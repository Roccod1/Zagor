package it.servizidigitali.scrivaniaoperatore.scheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.StorageTypeAware;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.camunda.integration.client.constant.CustomProcessVariables;
import it.servizidigitali.camunda.integration.configuration.CamundaConfiguration;
import it.servizidigitali.common.utility.enumeration.OrganizationCustomAttributes;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.service.ProcessoLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.scheduler.configuration.AvvioIstanzaProcessoSchedulerConfiguration;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

/**
 * @author pindi
 *
 */
@Component(immediate = true, //
		service = AvvioIstanzaProcessoScheduler.class, //
		configurationPid = { "it.servizidigitali.scrivaniaoperatore.scheduler.configuration.AvvioIstanzaProcessoSchedulerConfiguration",
				"it.servizidigitali.camunda.integration.configuration.CamundaConfiguration" }//
)
public class AvvioIstanzaProcessoScheduler extends BaseMessageListener {

	private static final Log _log = LogFactoryUtil.getLog(AvvioIstanzaProcessoScheduler.class);

	private volatile boolean _initialized;
	private TriggerFactory _triggerFactory;
	private SchedulerEngineHelper _schedulerEngineHelper;
	private SchedulerEntryImpl _schedulerEntryImpl = null;

	private volatile AvvioIstanzaProcessoSchedulerConfiguration avvioIstanzaProcessoSchedulerConfiguration;
	private volatile CamundaConfiguration camundaConfiguration;

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private ProcessoLocalService processoLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private CamundaClient camundaClient;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private AllegatoRichiestaLocalService allegatoRichiestaLocalService;

	@Override
	protected void doReceive(Message message) throws Exception {

		if (!camundaConfiguration.integrationEnabled()) {
			return;
		}

		_log.debug("Scheduled task executed...");

		// Caricamento lista richiesta in stato NUOVO
		List<Richiesta> richieste = richiestaLocalService.getRichiesteByStato(StatoRichiesta.NUOVA.name());
		if (richieste != null && !richieste.isEmpty()) {
			ObjectMapper objectMapper = new ObjectMapper();
			for (Richiesta richiesta : richieste) {

				// verifica processo già avviato
				long groupId = richiesta.getGroupId();
				long organizationId = groupLocalService.getGroup(groupId).getOrganizationId();

				String tenantId = String.valueOf(organizationId);
				long businessKey = richiesta.getRichiestaId();
				boolean existProcessByBusinessKey = camundaClient.existProcessByBusinessKey(tenantId, businessKey);

				if (existProcessByBusinessKey) {
					_log.debug("Esiste già una istanza di processo attiva per organizationId " + organizationId + " e businessKey " + businessKey);
					continue;
				}

				long proceduraId = richiesta.getProceduraId();

				Procedura procedura = proceduraLocalService.getProcedura(proceduraId);
				User userRichiesta = userLocalService.getUserByScreenName(richiesta.getCompanyId(), richiesta.getCodiceFiscale().toLowerCase());

				PrincipalThreadLocal.setName(userRichiesta.getUserId());
				PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(userRichiesta);
				PermissionThreadLocal.setPermissionChecker(permissionChecker);

				Organization organization = organizationLocalService.getOrganization(organizationId);
				Serializable codiceIPACustomAttribute = organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_IPA.getNomeAttributo());

				String codiceIPA = null;
				if (codiceIPACustomAttribute != null) {
					codiceIPA = (String) codiceIPACustomAttribute;
				}

				long processoId = procedura.getProcessoId();
				if (procedura != null && procedura.isAttiva() && processoId != 0) {

					// Avvio istanza processo

					Processo processo = processoLocalService.getProcesso(processoId);

					if (processo != null && processo.isAttivo()) {

						Servizio servizio = servizioLocalService.getServizioById(procedura.getServizioId());

						String candidateGroups = "";
						List<Organization> suborganizations = organization.getSuborganizations();
						if (suborganizations != null) {
							for (Organization subOrganization : suborganizations) {
								boolean existsGroup = camundaClient.existsGroup(String.valueOf(subOrganization.getOrganizationId()));
								if (!existsGroup) {
									throw new Exception("Impossibile assegnare il Gruppo Destinatario.");
								}

								if (candidateGroups.length() > 0) {
									candidateGroups += ",";
								}

								candidateGroups += subOrganization.getOrganizationId();
							}
						}

						// Allegati
						String allegatiJson = "";
						List<AllegatoRichiesta> allegatiRichiesta = allegatoRichiestaLocalService.getAllegatiRichiesta(richiesta.getRichiestaId(), groupId);
						if (allegatiRichiesta != null) {
							allegatiJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allegatiRichiesta);
						}

						// PDF principale
						String pdfFirmatoJson = "";
						AllegatoRichiesta allegatoPrincipaleRichiesta = allegatoRichiestaLocalService.getAllegatoRichiesta(richiesta.getRichiestaId(), true, groupId);
						if (allegatoPrincipaleRichiesta != null) {
							pdfFirmatoJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allegatoPrincipaleRichiesta);
						}

						Map<String, Object> variables = new HashMap<String, Object>();
						variables.put(CustomProcessVariables.ID_RICHIESTA_SERVIZIO, richiesta.getRichiestaId());
						variables.put(CustomProcessVariables.ID_GRUPPO_REFERENTI, candidateGroups);

						variables.put(CustomProcessVariables.DENOMINAZIONE_RICHIEDENTE, userRichiesta.getFullName());
						variables.put(CustomProcessVariables.COD_FISCALE_RICHIEDENTE, richiesta.getCodiceFiscale().toUpperCase());
						variables.put(CustomProcessVariables.EMAIL_RICHIEDENTE, richiesta.getEmail());
						variables.put(CustomProcessVariables.PARTITA_IVA_RICHIEDENTE, richiesta.getPartitaIva());

						variables.put(CustomProcessVariables.OGGETTO, richiesta.getOggetto());

						variables.put(CustomProcessVariables.FILE_ALLEGATI, allegatiJson);
						variables.put(CustomProcessVariables.NOME_FILE_FIRMATO, "allegato-pdf-firmato");
						variables.put(CustomProcessVariables.PDF_FIRMATO, pdfFirmatoJson);

						variables.put(CustomProcessVariables.CODICE_IPA_COMUNE, codiceIPA);
						variables.put(CustomProcessVariables.DENOMINAZIONE_COMUNE, organization.getName());

						variables.put(CustomProcessVariables.CODICE_SERVIZIO, servizio.getCodice());
						variables.put(CustomProcessVariables.DENOMINAZIONE_SERVIZIO, servizio.getNome());

						variables.put(CustomProcessVariables.CODICE_AREA_TEMATICA, servizio.getAreaTematica().getCodice());
						variables.put(CustomProcessVariables.DENOMINAZIONE_AREA_TEMATICA, servizio.getAreaTematica().getNome());

						variables.put(CustomProcessVariables.DATA_CREAZIONE_RICHIESTA, richiesta.getCreateDate());
						variables.put(CustomProcessVariables.STATO_RICHIESTA, richiesta.getStato());

						String processInstanceId = camundaClient.startProcessInstance(tenantId, processo.getCodice(), String.valueOf(businessKey), variables);
						richiestaLocalService.updateProcessiInstanceIdRichiesta(richiesta.getRichiestaId(), processInstanceId);
					}
				}
				else {
					// Cambio stato in INVIATA
					richiestaLocalService.updateStatoRichiesta(richiesta.getRichiestaId(), StatoRichiesta.INVIATA.name());
				}
			}
		}
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {

		// extract the cron expression from the properties
		try {
			avvioIstanzaProcessoSchedulerConfiguration = ConfigurableUtil.createConfigurable(AvvioIstanzaProcessoSchedulerConfiguration.class, properties);
			camundaConfiguration = ConfigurableUtil.createConfigurable(CamundaConfiguration.class, properties);

			if (!avvioIstanzaProcessoSchedulerConfiguration.avvioIstanzaProcessoSchedulerEnabled()) {
				_log.info("Diattivazione scheduler " + this.getClass().getSimpleName());
				deactivate();
				return;
			}

			String cronExpression = avvioIstanzaProcessoSchedulerConfiguration.avvioIstanzaProcessoSchedulerCronExpression();

			_log.info("Attivazione scheduler " + this.getClass().getSimpleName() + " - cronExpression: " + cronExpression);

			// create a new trigger definition for the job.
			String listenerClass = getClass().getName();
			Trigger jobTrigger = _triggerFactory.createTrigger(listenerClass, listenerClass, new Date(), null, cronExpression);

			// wrap the current scheduler entry in our new wrapper.
			// use the persisted storaget type and set the wrapper back to the class field.
			_schedulerEntryImpl = new SchedulerEntryImpl(getClass().getName(), jobTrigger);

			// if we were initialized (i.e. if this is called due to CA modification)
			if (_initialized) {
				// first deactivate the current job before we schedule.
				deactivate();
			}

			// register the scheduled task
			_schedulerEngineHelper.register(this, _schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);

			// set the initialized flag.
			_initialized = true;
		}
		catch (Exception e) {
			_log.error(e);
			deactivate();
		}
	}

	@Deactivate
	protected void deactivate() {
		// if we previously were initialized
		if (_initialized) {
			// unschedule the job so it is cleaned up
			try {
				_schedulerEngineHelper.unschedule(_schedulerEntryImpl, getStorageType());
			}
			catch (SchedulerException se) {
				if (_log.isWarnEnabled()) {
					_log.warn("Unable to unschedule trigger", se);
				}
			}

			// unregister this listener
			_schedulerEngineHelper.unregister(this);
		}

		// clear the initialized flag
		_initialized = false;
	}

	/**
	 * getStorageType: Utility method to get the storage type from the scheduler entry wrapper.
	 *
	 * @return StorageType The storage type to use.
	 */
	protected StorageType getStorageType() {
		if (_schedulerEntryImpl instanceof StorageTypeAware) {
			return ((StorageTypeAware) _schedulerEntryImpl).getStorageType();
		}

		return StorageType.MEMORY_CLUSTERED;
	}

	/**
	 * setModuleServiceLifecycle: So this requires some explanation...
	 *
	 * OSGi will start a component once all of it's dependencies are satisfied. However, there are
	 * times where you want to hold off until the portal is completely ready to go.
	 *
	 * This reference declaration is waiting for the ModuleServiceLifecycle's PORTAL_INITIALIZED
	 * component which will not be available until, surprise surprise, the portal has finished
	 * initializing.
	 *
	 * With this reference, this component activation waits until portal initialization has
	 * completed.
	 *
	 * @param moduleServiceLifecycle
	 */
	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference(unbind = "-")
	protected void setTriggerFactory(TriggerFactory triggerFactory) {
		_triggerFactory = triggerFactory;
	}

	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(SchedulerEngineHelper schedulerEngineHelper) {
		_schedulerEngineHelper = schedulerEngineHelper;
	}

}