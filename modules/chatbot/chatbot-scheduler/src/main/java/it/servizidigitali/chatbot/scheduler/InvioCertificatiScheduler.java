package it.servizidigitali.chatbot.scheduler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
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

import it.servizidigitali.chatbot.model.RichiestaCertificato;
import it.servizidigitali.chatbot.scheduler.configuration.InvioCertificatiSchedulerConfiguration;
import it.servizidigitali.chatbot.service.RichiestaCertificatoLocalService;
import it.servizidigitali.common.utility.LayoutUtility;
import it.servizidigitali.common.utility.enumeration.StatoRichiestaCertificato;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.common.model.FormData;
import it.servizidigitali.presentatoreforms.common.service.AlpacaService;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;

/**
 * @author pindi
 *
 */
@Component(immediate = true, //
		service = InvioCertificatiScheduler.class, //
		configurationPid = { "it.servizidigitali.chatbot.scheduler.configuration.InvioCertificatiSchedulerConfiguration" }//
)
public class InvioCertificatiScheduler extends BaseMessageListener {

	private static final Log _log = LogFactoryUtil.getLog(InvioCertificatiScheduler.class);

	private volatile boolean _initialized;
	private TriggerFactory _triggerFactory;
	private SchedulerEngineHelper _schedulerEngineHelper;
	private SchedulerEntryImpl _schedulerEntryImpl = null;

	private volatile InvioCertificatiSchedulerConfiguration invioCertificatiSchedulerConfiguration;

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
	private LayoutUtility layoutUtility;

	@Override
	protected void doReceive(Message message) throws Exception {
		List<RichiestaCertificato> richiesteCertificato = richiestaCertificatoLocalService.getRichiesteCertificatoByStato(StatoRichiestaCertificato.NUOVA.name());
		if (richiesteCertificato == null || richiesteCertificato.isEmpty()) {
			return;
		}

		_log.info("InviaCertificatiScheduler :: inviaCertificati : Avvio invio certificati");

		for (RichiestaCertificato richiestaCertificato : richiesteCertificato) {

			Procedura procedura = proceduraLocalService.getProceduraByServizioIdGroupIdAttiva(richiestaCertificato.getServizioId(), richiestaCertificato.getGroupId(), true);

			User user = userLocalService.getUser(richiestaCertificato.getUserId());

			UserPreferences userPreferences = new UserPreferences();
			userPreferences.setCodiceFiscaleRichiedente(user.getScreenName());
			userPreferences.setCodiceFiscaleComponente(richiestaCertificato.getCodiceFiscale());

			Form form = getFormPrincipaleProcedura(procedura.getProceduraId());

			Organization organization = organizationLocalService.getOrganization(richiestaCertificato.getOrganizationId());
			String portalUrl = layoutUtility.getSitePath(organization.getGroupId(), organization.getCompanyId());

			Gson gson = new Gson();

			FormData formData = AlpacaUtil.loadFormData(form, null, true, portalUrl);
			AlpacaJsonStructure alpacaStructure = formData.getAlpaca();
			AlpacaJsonOptionsStructure alpacaJsonOptionsStructure = gson.fromJson(gson.toJson(alpacaStructure.getOptions()), AlpacaJsonOptionsStructure.class);

			JsonObject data = gson.fromJson(gson.toJson(alpacaStructure.getData()), JsonObject.class);

			alpacaService.enrichAlpacaForm(alpacaJsonOptionsStructure, data, userPreferences, procedura);
			alpacaStructure.setData(data);

			// TODO continuare

		}

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
			_log.warn("getFormPrincipaleProcedura :: " + e.getMessage());
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
				_log.info("Diattivazione scheduler " + this.getClass().getSimpleName());
				deactivate();
				return;
			}

			String cronExpression = invioCertificatiSchedulerConfiguration.invioCertificatiSchedulerCronExpression();

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