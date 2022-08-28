package it.servizidigitali.gestionecomunicazioni.scheduler;

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
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.communication.enumeration.Canale;
import it.servizidigitali.communication.exception.CommunicationException;
import it.servizidigitali.communication.model.Comunicazione;
import it.servizidigitali.communication.model.EsitoComunicazione;
import it.servizidigitali.communication.model.Utente;
import it.servizidigitali.communication.sender.CommunicationSender;
import it.servizidigitali.gestionecomunicazioni.configuration.InvioComunicazioniSchedulerConfiguration;
import it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione;
import it.servizidigitali.gestionecomunicazioni.service.ComunicazioneLocalService;
import it.servizidigitali.profiloutente.service.UtenteOrganizzazioneCanaleComunicazioneLocalService;

/**
 * @author pindi
 *
 */
@Component(immediate = true, //
		service = InvioComunicazioniScheduler.class, //
		configurationPid = "it.servizidigitali.gestionecomunicazioni.configuration.InvioComunicazioniSchedulerConfiguration"//
)
public class InvioComunicazioniScheduler extends BaseMessageListener {

	private static final Log _log = LogFactoryUtil.getLog(InvioComunicazioniScheduler.class);

	private volatile boolean _initialized;
	private TriggerFactory _triggerFactory;
	private SchedulerEngineHelper _schedulerEngineHelper;
	private SchedulerEntryImpl _schedulerEntryImpl = null;

	private volatile InvioComunicazioniSchedulerConfiguration invioComunicazioniSchedulerConfiguration;

	@Reference
	private ComunicazioneLocalService comunicazioneLocalService;
	@Reference
	private CommunicationSender communicationSender;
	@Reference
	private UtenteOrganizzazioneCanaleComunicazioneLocalService utenteOrganizzazioneCanaleComunicazioneLocalService;
	@Reference
	private OrganizationLocalService organizationLocalService;
	@Reference
	private UserLocalService userLocalService;
	
	@Override
	protected void doReceive(Message message) throws Exception {

		_log.debug("Scheduled task executed...");
		List<it.servizidigitali.gestionecomunicazioni.model.Comunicazione> comunicazioni = comunicazioneLocalService.getNonInviate();

		for (it.servizidigitali.gestionecomunicazioni.model.Comunicazione comunicazione : comunicazioni) {
			Stream<User> streamUtenti;
			long userId = comunicazione.getDestinatarioUserId();
			
			if (userId == 0) {
				streamUtenti = userLocalService.getOrganizationUsers(comunicazione.getDestinatarioOrganizationId()).stream();
			} else {
				streamUtenti = Stream.of(userLocalService.fetchUser(userId));
			}
			
			List<User> utenti = streamUtenti.filter(x -> x.isActive()).collect(Collectors.toList());
			Organization organization = organizationLocalService.fetchOrganization(comunicazione.getDestinatarioOrganizationId());
			TipologiaComunicazione tipologia = comunicazione.getTipologia();
			
			for (User user : utenti) {
				sendComunicazione(comunicazione, user, organization, tipologia);
			}
			
			comunicazione.setDataInvio(new Date());
			comunicazioneLocalService.updateComunicazione(comunicazione);
		}
	}

	private void sendComunicazione(it.servizidigitali.gestionecomunicazioni.model.Comunicazione comunicazione, User user, Organization organization, TipologiaComunicazione tipologia) throws Exception, CommunicationException {
		List<Canale> canali = utenteOrganizzazioneCanaleComunicazioneLocalService
				.getListaCanaleComunicazioneByUtenteOrganization(user.getUserId(), comunicazione.getDestinatarioOrganizationId())
				.stream()
				.map(x -> x.getCanale())
				.map(x -> Canale.getSupportedChannel(x.getCodice()))
				.collect(Collectors.toList());
		
		for (Canale canale : canali) {
			Utente utente = new Utente();
			utente.setEmail(user.getEmailAddress());
			
			String oggetto = String.format("[%s] - %s - %s", 
					organization.getName(), 
					tipologia.getNome(),
					comunicazione.getTitolo());
			Comunicazione com = new Comunicazione(oggetto, comunicazione.getDescrizione(), Collections.singletonList(utente), null, true, null, comunicazione.getCompanyId(), comunicazione.getGroupId());
			EsitoComunicazione esito = communicationSender.sendNow(com, canale);
			
			//TODO gestire messageId
			String messageId = esito.getMessageId();
		}
	}

	public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {

		// extract the cron expression from the properties
		try {
			invioComunicazioniSchedulerConfiguration = ConfigurableUtil.createConfigurable(InvioComunicazioniSchedulerConfiguration.class, properties);

			if (!invioComunicazioniSchedulerConfiguration.invioComunicazioniSchedulerEnabled()) {
				_log.info("Diattivazione scheduler " + this.getClass().getSimpleName());
				deactivate();
				return;
			}

			String cronExpression = invioComunicazioniSchedulerConfiguration.invioComunicazioniSchedulerCronExpression();

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