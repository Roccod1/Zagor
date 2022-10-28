package it.servizidigitali.chatbot.scheduler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.chatbot.model.RichiestaCertificato;
import it.servizidigitali.chatbot.scheduler.configuration.InvioCertificatiSchedulerConfiguration;
import it.servizidigitali.chatbot.service.RichiestaCertificatoLocalService;
import it.servizidigitali.common.utility.LayoutUtility;
import it.servizidigitali.common.utility.enumeration.StatoRichiestaCertificato;
import it.servizidigitali.communication.configuration.TemplateComunicazioniEnteConfiguration;
import it.servizidigitali.communication.enumeration.Canale;
import it.servizidigitali.communication.exception.CommunicationException;
import it.servizidigitali.communication.model.Allegato;
import it.servizidigitali.communication.model.Comunicazione;
import it.servizidigitali.communication.model.EsitoComunicazione;
import it.servizidigitali.communication.model.Utente;
import it.servizidigitali.communication.sender.CommunicationSender;
import it.servizidigitali.file.utility.factory.FileServiceFactory;
import it.servizidigitali.file.utility.model.File;
import it.servizidigitali.file.utility.service.FileService;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.common.model.FormData;
import it.servizidigitali.presentatoreforms.common.service.AllegatoRichiestaService;
import it.servizidigitali.presentatoreforms.common.service.AlpacaService;
import it.servizidigitali.presentatoreforms.common.service.CertificatoService;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.IstanzaFormLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

/**
 * @author pindi
 *
 */
@Component(immediate = true, //
		service = InvioCertificatiScheduler.class, //
		configurationPid = { //
				"it.servizidigitali.chatbot.scheduler.configuration.InvioCertificatiSchedulerConfiguration", //
				"it.servizidigitali.communication.configuration.TemplateComunicazioniEnteConfiguration"//
		}//
)
public class InvioCertificatiScheduler extends BaseMessageListener {

	private static final Log log = LogFactoryUtil.getLog(InvioCertificatiScheduler.class);

	private static final String USER_FULL_NAME_POSIZIONALE = "user_full_name";
	private static final String NOME_SERVIZIO_POSIZIONALE = "nome_servizio";
	private static final String ERRORE_POSIZIONALE = "errore";

	private List<String> stati = Arrays.asList(new String[] { StatoRichiestaCertificato.NUOVA.name(), StatoRichiestaCertificato.GENERATA.name() });

	private volatile boolean _initialized;
	private TriggerFactory _triggerFactory;
	private SchedulerEngineHelper _schedulerEngineHelper;
	private SchedulerEntryImpl _schedulerEntryImpl = null;

	private volatile InvioCertificatiSchedulerConfiguration invioCertificatiSchedulerConfiguration;
	private volatile TemplateComunicazioniEnteConfiguration templateComunicazioniEnteConfiguration;

	private ConfigurationProvider configurationProvider;

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	@Reference
	private RichiestaCertificatoLocalService richiestaCertificatoLocalService;

	@Reference
	private AlpacaService alpacaService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private ProceduraFormLocalService proceduraFormLocalService;

	@Reference
	private FormLocalService formLocalService;

	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private IstanzaFormLocalService istanzaFormLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private AllegatoRichiestaService allegatoRichiestaService;

	@Reference
	private LayoutUtility layoutUtility;

	@Reference
	private CertificatoService certificatoService;

	@Reference
	private CommunicationSender communicationSender;

	@Reference
	private FileServiceFactory fileServiceFactory;

	@Reference
	private AllegatoRichiestaLocalService allegatoRichiestaLocalService;

	@Override
	protected void doReceive(Message message) throws Exception {

		List<RichiestaCertificato> richiesteCertificato = richiestaCertificatoLocalService.getRichiesteCertificatoByStati(stati);
		if (richiesteCertificato == null || richiesteCertificato.isEmpty()) {
			return;
		}

		log.debug("doReceive :: invio certificati : Avvio invio certificati");

		for (RichiestaCertificato richiestaCertificato : richiesteCertificato) {

			User user = userLocalService.getUser(richiestaCertificato.getUserId());
			Procedura procedura = proceduraLocalService.getProceduraByServizioIdGroupIdAttiva(richiestaCertificato.getServizioId(), richiestaCertificato.getGroupId(), true);
			Servizio servizio = servizioLocalService.getServizio(procedura.getServizioId());
			long companyId = procedura.getCompanyId();
			long groupId = procedura.getGroupId();
			Richiesta richiesta = null;
			try {
				PrincipalThreadLocal.setName(user.getUserId());
				PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
				PermissionThreadLocal.setPermissionChecker(permissionChecker);

				StatoRichiestaCertificato statoRichiestaCertificato = StatoRichiestaCertificato.valueOf(richiestaCertificato.getStato());
				switch (statoRichiestaCertificato) {
				case NUOVA:

					log.debug("doReceive :: generazione ed invio certificato con ID: " + richiestaCertificato.getRichiestaCertificatoId() + ", stato: " + richiestaCertificato.getStato());

					templateComunicazioniEnteConfiguration = configurationProvider.getGroupConfiguration(TemplateComunicazioniEnteConfiguration.class, richiestaCertificato.getGroupId());

					UserPreferences userPreferences = new UserPreferences();
					userPreferences.setCodiceFiscaleRichiedente(user.getScreenName());
					userPreferences.setCodiceFiscaleComponente(richiestaCertificato.getCodiceFiscale());

					Form form = getFormPrincipaleProcedura(procedura.getProceduraId());

					Group group = groupLocalService.getGroup(groupId);

					Organization organization = organizationLocalService.getOrganization(group.getOrganizationId());
					String portalUrl = layoutUtility.getSitePath(organization.getGroupId(), organization.getCompanyId());

					Gson gson = new Gson();

					FormData formData = AlpacaUtil.loadFormData(form, null, true, portalUrl);
					AlpacaJsonStructure alpacaStructure = formData.getAlpaca();
					AlpacaJsonOptionsStructure alpacaJsonOptionsStructure = gson.fromJson(gson.toJson(alpacaStructure.getOptions()), AlpacaJsonOptionsStructure.class);

					JsonObject data = gson.fromJson(gson.toJson(alpacaStructure.getData()), JsonObject.class);

					alpacaService.enrichAlpacaForm(alpacaJsonOptionsStructure, data, userPreferences, procedura);
					alpacaStructure.setData(data);
					formData.setAlpaca(alpacaStructure);

					// Creazione richiesta
					richiesta = richiestaLocalService.createRichiesta(counterLocalService.increment());
					richiesta.setCodiceFiscale(user.getScreenName());
					richiesta.setUserId(user.getUserId());
					richiesta.setUserName(user.getFullName());
					richiesta.setEmail(user.getEmailAddress());
					richiesta.setOggetto(servizio.getNome());
					richiesta.setProceduraId(procedura.getProceduraId());
					richiesta.setStato(StatoRichiesta.BOZZA.name());
					richiesta.setServizioId(servizio.getServizioId());
					richiesta.setGroupId(groupId);
					richiesta.setCompanyId(companyId);
					richiesta = richiestaLocalService.updateRichiesta(richiesta);

					String jsonToSave = gson.toJson(formData);

					IstanzaForm istanzaForm = istanzaFormLocalService.createIstanzaForm(counterLocalService.increment());
					istanzaForm.setCompanyId(companyId);
					istanzaForm.setGroupId(groupId);
					istanzaForm.setCompanyId(companyId);
					istanzaForm.setUserId(user.getUserId());
					istanzaForm.setUserName(user.getFullName());
					istanzaForm.setRichiestaId(richiesta.getRichiestaId());
					istanzaForm.setFormId(form.getFormId());
					istanzaForm.setJson(jsonToSave);
					istanzaFormLocalService.updateIstanzaForm(istanzaForm);
					byte[] pdfCertificato = certificatoService.generaPDFCertificato(user.getScreenName(), richiestaCertificato.getCodiceFiscale(), alpacaStructure, richiesta.getRichiestaId(),
							richiestaCertificato.getDestinazioneUsoId(), null);

					String idDocumentale = allegatoRichiestaService.salvaCertificato(pdfCertificato, servizio, richiesta.getRichiestaId(), user.getFullName(), user.getUserId(), groupId, companyId);

					richiestaCertificato.setRichiestaId(richiesta.getRichiestaId());
					richiestaCertificato.setStato(StatoRichiestaCertificato.GENERATA.name());
					richiestaCertificatoLocalService.updateRichiestaCertificato(richiestaCertificato);

					// invio comunicazione
					sendEmail(richiestaCertificato, user, servizio, companyId, groupId, idDocumentale);

					richiestaCertificato.setStato(StatoRichiestaCertificato.INVIATA.name());
					richiestaCertificato = richiestaCertificatoLocalService.updateRichiestaCertificato(richiestaCertificato);

					richiesta.setStato(StatoRichiesta.CHIUSA_POSITIVAMENTE.name());
					richiestaLocalService.updateRichiesta(richiesta);

					log.debug("doReceive :: generazione ed invio certificato con ID: " + richiestaCertificato.getRichiestaCertificatoId() + " completato, stato: " + richiestaCertificato.getStato());
					break;

				case GENERATA:

					log.debug("doReceive :: invio certificato con ID: " + richiestaCertificato.getRichiestaCertificatoId());
					// invio comunicazione
					List<AllegatoRichiesta> allegatiRichiestaByRichiestaIdPrincipale = allegatoRichiestaLocalService.getAllegatiRichiestaByRichiestaIdPrincipale(richiestaCertificato.getRichiestaId(),
							true);
					sendEmail(richiestaCertificato, user, servizio, companyId, groupId, allegatiRichiestaByRichiestaIdPrincipale.get(0).getIdDocumentale());
					richiestaCertificato.setStato(StatoRichiestaCertificato.INVIATA.name());
					richiestaCertificato = richiestaCertificatoLocalService.updateRichiestaCertificato(richiestaCertificato);

					log.debug("doReceive :: invio certificato con ID: " + richiestaCertificato.getRichiestaCertificatoId() + " completato, stato: " + richiestaCertificato.getStato());
					break;
				default:
					break;
				}

				// TODO applicazione bollo non ancora presente
			}
			catch (Exception e) {
				log.error(
						"doReceive :: inviaCertificati  :: si è verificato un errore durante la generazione ed invio della richiesta certificato : " + richiestaCertificato.getRichiestaCertificatoId(),
						e);
				String errorMessage = e.getMessage();
				if (e instanceof BackofficeServiceException) {
					BackofficeServiceException backofficeServiceException = (BackofficeServiceException) e;
					errorMessage = LanguageUtil.get(Locale.ITALY, backofficeServiceException.getBackofficeServiceExceptionLanguageCode().getLiferayLanguageKey());

					log.debug("doReceive :: errore invio certificato con ID: " + richiestaCertificato.getRichiestaCertificatoId() + " :: messaggio di errore : " + errorMessage);

					try {
						String oggetto = templateComunicazioniEnteConfiguration.invioRichiestaCertificatoEmailSubjectTemplate();
						String descrizione = templateComunicazioniEnteConfiguration.invioRichiestaCertificatoKoEmailBodyTemplate();

						Map<String, String> valuesMap = new HashMap<String, String>();
						valuesMap.put(USER_FULL_NAME_POSIZIONALE, user.getFullName());
						valuesMap.put(NOME_SERVIZIO_POSIZIONALE, servizio.getNome());
						valuesMap.put(ERRORE_POSIZIONALE, errorMessage);

						StringSubstitutor oggettoStringSubstitutor = new StringSubstitutor(valuesMap);
						oggetto = oggettoStringSubstitutor.replace(oggetto);

						StringSubstitutor descrizioneStringSubstitutor = new StringSubstitutor(valuesMap);
						descrizione = descrizioneStringSubstitutor.replace(descrizione);

						Canale canale = Canale.EMAIL;
						Utente utente = new Utente();
						utente.setEmail(user.getEmailAddress());

						log.debug("doReceive :: invio comunicazione errore per richiesta certificato con ID: " + richiestaCertificato.getRichiestaCertificatoId());

						Comunicazione comunicazione = new Comunicazione(oggetto, descrizione, Collections.singletonList(utente), null, true, null, companyId, groupId);
						log.debug("Invio comunicazione ERRORE richiesta certificato " + richiestaCertificato.getRichiestaCertificatoId() + " tramite canale '" + canale.getName() + "' a '"
								+ user.getScreenName() + "'");
						EsitoComunicazione esito = communicationSender.sendNow(comunicazione, canale);
						log.debug("Invio comunicazione ERRORE richiesta certificato " + richiestaCertificato.getRichiestaCertificatoId() + " tramite canale '" + canale.getName() + "' a '"
								+ user.getScreenName() + "' inviata. MessageID: " + esito.getMessageId());

						if (esito.getError() != null) {
							throw new RuntimeException(esito.getError());
						}

						richiestaCertificato.setStato(StatoRichiestaCertificato.ERRORE.name());
						richiestaCertificato.setErrore(errorMessage);
						richiestaCertificato = richiestaCertificatoLocalService.updateRichiestaCertificato(richiestaCertificato);

						if (richiesta != null) {
							richiesta.setStato(StatoRichiesta.CHIUSA_NEGATIVAMENTE.name());
							richiestaLocalService.updateRichiesta(richiesta);
						}

						log.debug("doReceive :: invio comunicazione errore per richiesta certificato con ID: " + richiestaCertificato.getRichiestaCertificatoId() + " completato, stato: "
								+ richiestaCertificato.getStato());
					}
					catch (Exception e1) {
						log.error("doReceive :: invio certificato :" + e1.getMessage(), e1);
					}
				}
			}
		}
	}

	/**
	 * @param richiestaCertificato
	 * @param user
	 * @param servizio
	 * @param companyId
	 * @param groupId
	 * @param idDocumentale
	 * @throws CommunicationException
	 */
	private void sendEmail(RichiestaCertificato richiestaCertificato, User user, Servizio servizio, long companyId, long groupId, String idDocumentale) throws CommunicationException {

		Canale canale = Canale.EMAIL;

		log.debug("Invio comunicazione richiesta certificato " + richiestaCertificato.getRichiestaCertificatoId() + " tramite canale '" + canale.getName() + "' a '" + user.getScreenName() + "'");

		Utente utente = new Utente();
		utente.setEmail(user.getEmailAddress());

		String oggetto = templateComunicazioniEnteConfiguration.invioRichiestaCertificatoEmailSubjectTemplate();
		String descrizione = templateComunicazioniEnteConfiguration.invioRichiestaCertificatoOkEmailBodyTemplate();

		Map<String, String> valuesMap = new HashMap<String, String>();
		valuesMap.put(USER_FULL_NAME_POSIZIONALE, user.getFullName());
		valuesMap.put(NOME_SERVIZIO_POSIZIONALE, servizio.getNome());

		StringSubstitutor oggettoStringSubstitutor = new StringSubstitutor(valuesMap);
		oggetto = oggettoStringSubstitutor.replace(oggetto);

		StringSubstitutor descrizioneStringSubstitutor = new StringSubstitutor(valuesMap);
		descrizione = descrizioneStringSubstitutor.replace(descrizione);

		FileService activeFileService = fileServiceFactory.getActiveFileService();
		File requestFile = activeFileService.getRequestFile(idDocumentale, groupId);

		List<Allegato> allegati = new ArrayList<Allegato>();
		Allegato allegato = new Allegato();
		allegato.setNome(requestFile.getNome());
		allegato.setDescrizione(requestFile.getDescrizione());
		allegato.setContenuto(requestFile.getInputStream());
		allegato.setTipoContenuto(requestFile.getMimeType());
		allegati.add(allegato);

		Comunicazione comunicazione = new Comunicazione(oggetto, descrizione, Collections.singletonList(utente), allegati, true, null, companyId, groupId);
		EsitoComunicazione esito = communicationSender.sendNow(comunicazione, canale);
		log.debug("Invio comunicazione richiesta certificato " + richiestaCertificato.getRichiestaCertificatoId() + " tramite canale '" + canale.getName() + "' a '" + user.getScreenName()
				+ "' inviata. MessageID: " + esito.getMessageId());
	}

	private Form getFormPrincipaleProcedura(long proceduraId) {
		try {
			List<ProceduraForm> listaProceduraFormProcedura = proceduraFormLocalService.getListaProceduraFormProcedura(proceduraId);

			if (listaProceduraFormProcedura != null) {
				for (ProceduraForm proceduraForm : listaProceduraFormProcedura) {
					Form form = formLocalService.getForm(proceduraForm.getFormId());
					if (form.isPrincipale()) {
						form.setListaDefinizioneAllegato(definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(form.getFormId()));
						return form;
					}
				}
			}
		}
		catch (PortalException e) {
			log.warn("getFormPrincipaleProcedura :: " + e.getMessage());
		}
		return null;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {

		// extract the cron expression from the properties
		try {
			invioCertificatiSchedulerConfiguration = ConfigurableUtil.createConfigurable(InvioCertificatiSchedulerConfiguration.class, properties);

			if (!invioCertificatiSchedulerConfiguration.invioCertificatiSchedulerEnabled()) {
				log.info("Diattivazione scheduler " + this.getClass().getSimpleName());
				deactivate();
				return;
			}

			templateComunicazioniEnteConfiguration = ConfigurableUtil.createConfigurable(TemplateComunicazioniEnteConfiguration.class, properties);

			String cronExpression = invioCertificatiSchedulerConfiguration.invioCertificatiSchedulerCronExpression();

			log.info("Attivazione scheduler " + this.getClass().getSimpleName() + " - cronExpression: " + cronExpression);

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
			log.error(e);
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
				if (log.isWarnEnabled()) {
					log.warn("Unable to unschedule trigger", se);
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