package it.servizidigitali.scrivaniaoperatore.scheduler;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.StorageTypeAware;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.camunda.integration.client.constant.CustomProcessVariables;
import it.servizidigitali.camunda.integration.client.model.ProcessInstance;
import it.servizidigitali.camunda.integration.configuration.CamundaConfiguration;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneprocessi.service.ProcessoLocalService;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.scheduler.configuration.AvvioIstanzaProcessoSchedulerConfiguration;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

/**
 * @author pindi
 *
 */
@Component(immediate = true, //
		service = RichiestaIntegrazioniScheduler.class, //
		configurationPid = { "it.servizidigitali.scrivaniaoperatore.scheduler.configuration.AvvioIstanzaProcessoSchedulerConfiguration",
				"it.servizidigitali.camunda.integration.configuration.CamundaConfiguration" }//
)
public class RichiestaIntegrazioniScheduler extends BaseMessageListener {

	private static final Log _log = LogFactoryUtil.getLog(RichiestaIntegrazioniScheduler.class);

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
	private ServizioEnteLocalService servizioEnteLocalService;

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

		// Caricamento lista richiesta in stato INTEGRAZIONI_INSERITE
		List<Richiesta> richieste = richiestaLocalService.getRichiesteByStato(StatoRichiesta.INTEGRAZIONI_INSERITE.name());
		if (richieste != null && !richieste.isEmpty()) {
			for (Richiesta richiesta : richieste) {
				_log.info("Completamento integrazioni. Id Richiesta:: " + richiesta.getRichiestaId());
				try {
					long groupId = richiesta.getGroupId();
					long organizationId = groupLocalService.getGroup(groupId).getOrganizationId();

					String tenantId = String.valueOf(organizationId);
					List<ProcessInstance> processInstanceByBusinessKey = camundaClient.getProcessInstanceByBusinessKey(tenantId, String.valueOf(richiesta.getRichiestaId()));
					if (processInstanceByBusinessKey.size() != 1) {
						_log.error("Impossibile individuare univocamente l'istanza di processo.");
						continue;
					}

					camundaClient.correlateMessage(tenantId, CustomProcessVariables.INTEGRAZIONI_COMPLETATE_MESSAGE, String.valueOf(richiesta.getRichiestaId()));
					// Aggiornamento stato richiesta -> in lavorazione
					richiestaLocalService.updateStatoRichiesta(richiesta.getRichiestaId(), StatoRichiesta.IN_LAVORAZIONE.name());
				}
				catch (Exception e) {
					_log.error("Impossibile riprendere il processo. Id Richiesta: " + richiesta.getRichiestaId() + ", errore: " + e.getMessage(), e);
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