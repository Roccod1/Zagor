package it.servizidigitali.gestionepagamenti.scheduler;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.StorageTypeAware;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration;
import it.servizidigitali.gestionepagamenti.common.enumeration.StatoPagamento;
import it.servizidigitali.gestionepagamenti.common.factory.PagamentiClientFactory;
import it.servizidigitali.gestionepagamenti.configuration.PagamentiSchedulerConfiguration;
import it.servizidigitali.gestionepagamenti.integration.common.client.PagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.TipoPagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.client.model.VerificaPagamentoMarcaDaBolloRisposta;
import it.servizidigitali.gestionepagamenti.integration.common.client.model.VerificaPagamentoRisposta;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.PagamentoLocalService;

/**
 * Scheduler per la verifica ed aggiornamento dello stato dei pagamenti sulla piattaforma esterna.
 *
 * @author pindi
 *
 */
@Component(immediate = true, //
		service = VerificaPagamentiScheduler.class, //
		configurationPid = { //
				"it.servizidigitali.gestionepagamenti.configuration.PagamentiSchedulerConfiguration", //
				"it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration" //
		}//
)
public class VerificaPagamentiScheduler extends BaseMessageListener {

	private static final Log _log = LogFactoryUtil.getLog(VerificaPagamentiScheduler.class);

	private volatile boolean _initialized;
	private TriggerFactory _triggerFactory;
	private SchedulerEngineHelper _schedulerEngineHelper;
	private SchedulerEntryImpl _schedulerEntryImpl = null;

	private volatile PagamentiSchedulerConfiguration pagamentiSchedulerConfiguration;
	private volatile ClientPagamentiEnteConfiguration accountClientPagamentiEnteConfiguration;
	private ConfigurationProvider configurationProvider;

	@Reference
	private PagamentoLocalService pagamentoLocalService;

	@Reference
	private PagamentiClientFactory pagamentiClientFactory;

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	@Override
	protected void doReceive(Message message) throws Exception {

		List<Pagamento> pagamentiInAttesa = pagamentoLocalService.getPagamentiByStato(StatoPagamento.IN_ATTESA.name());
		if (pagamentiInAttesa != null) {
			for (Pagamento pagamento : pagamentiInAttesa) {

				accountClientPagamentiEnteConfiguration = configurationProvider.getGroupConfiguration(ClientPagamentiEnteConfiguration.class, pagamento.getGroupId());
				PagamentiClient pagamentiClient = pagamentiClientFactory.getPagamentiClient(TipoPagamentiClient.valueOf(accountClientPagamentiEnteConfiguration.tipoPagamentiClient()));
				VerificaPagamentoRisposta verificaPagamento = pagamentiClient.verificaPagamento(pagamento.getIdSessione(), null, null, accountClientPagamentiEnteConfiguration.clientUsername(),
						accountClientPagamentiEnteConfiguration.clientPassword(), accountClientPagamentiEnteConfiguration.clientWsdlUrl());

				it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.StatoPagamento statoPagamento = verificaPagamento.getStatoPagamento();
				_log.info("verificaPagamento: " + pagamento.getPagamentoId() + ", stato: " + statoPagamento);

				switch (statoPagamento) {
				case ERRORE:
					pagamento.setErrore(verificaPagamento.getCodiceErrore() + " - " + verificaPagamento.getDescrizioneErrore());
					pagamento.setStato(StatoPagamento.ERRORE.name());
					break;
				case COMPLETATO:
					pagamento.setIud(verificaPagamento.getCodiceIuv());
					pagamento.setStato(StatoPagamento.COMPLETATO.name());
					pagamento.setCommissioni(verificaPagamento.getImportoCommissioni());
					// TODO implementare salvataggio stato pagamento bollo (salvataggio XML bollo
					// accanto a documento inviato)
					if (verificaPagamento instanceof VerificaPagamentoMarcaDaBolloRisposta) {
						// TODO salvataggio file marca da bollo
						// TODO implementare invio email?
					}
					break;

				default:
					break;
				}

				// Aggiornamento pagamento + richiesta corrispondente
				// pagamentoLocalService.updatePagamento(pagamento);

			}
		}
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {

		// extract the cron expression from the properties
		try {
			pagamentiSchedulerConfiguration = ConfigurableUtil.createConfigurable(PagamentiSchedulerConfiguration.class, properties);

			if (!pagamentiSchedulerConfiguration.verificaPagamentiSchedulerEnabled()) {
				_log.info("Diattivazione scheduler " + this.getClass().getSimpleName());
				deactivate();
				return;
			}

			accountClientPagamentiEnteConfiguration = ConfigurableUtil.createConfigurable(ClientPagamentiEnteConfiguration.class, properties);

			String cronExpression = pagamentiSchedulerConfiguration.verificaPagamentiSchedulerCronExpression();

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