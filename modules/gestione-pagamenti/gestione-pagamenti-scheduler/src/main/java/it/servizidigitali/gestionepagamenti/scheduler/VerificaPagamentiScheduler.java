package it.servizidigitali.gestionepagamenti.scheduler;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
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
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ContentTypes;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.file.utility.factory.FileServiceFactory;
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
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

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

	private static final String RICEVUTA_TELEMATICA_PAGAMENTO_FILE_PREFIX = "ricevuta-telematica-pagamento-";
	private static final String MARCA_DA_BOLLO_PAGAMENTO_FILE_PREFIX = "marca-da-bollo-pagamento-";
	private static final String DESCRIZIONE_ALLEGATO_RICEVUTA_TELEMATICA_XML = "Ricevuta telematica XML pagamento ID: %s";
	private static final String DESCRIZIONE_ALLEGATO_MARCA_DA_BOLLO = "Marca da Bollo - ID pagamento: %s";

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
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private FileServiceFactory fileServiceFactory;

	@Reference
	private AllegatoRichiestaLocalService allegatoRichiestaLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	@Override
	protected void doReceive(Message message) throws Exception {

		List<Pagamento> pagamentiInAttesa = pagamentoLocalService.getPagamentiByStato(StatoPagamento.IN_ATTESA.name());
		if (pagamentiInAttesa != null) {
			for (Pagamento pagamento : pagamentiInAttesa) {

				long pagamentoId = pagamento.getPagamentoId();
				String statoIniziale = pagamento.getStato();
				try {
					accountClientPagamentiEnteConfiguration = configurationProvider.getGroupConfiguration(ClientPagamentiEnteConfiguration.class, pagamento.getGroupId());
					PagamentiClient pagamentiClient = pagamentiClientFactory.getPagamentiClient(TipoPagamentiClient.valueOf(accountClientPagamentiEnteConfiguration.tipoPagamentiClient()));
					VerificaPagamentoRisposta verificaPagamento = pagamentiClient.verificaPagamento(pagamento.getIdSessione(), null, null, accountClientPagamentiEnteConfiguration.clientUsername(),
							accountClientPagamentiEnteConfiguration.clientPassword(), accountClientPagamentiEnteConfiguration.clientWsdlUrl());

					it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.StatoPagamento statoPagamento = verificaPagamento.getStatoPagamento();

					_log.info("verificaPagamento :: ID: " + pagamentoId + ", stato: " + statoPagamento);

					String statoRichiesta = StatoRichiesta.CHIUSA_POSITIVAMENTE.name();

					long richiestaId = pagamento.getRichiestaId();
					Richiesta richiesta = richiestaLocalService.getRichiesta(richiestaId);
					Servizio servizio = servizioLocalService.getServizio(richiesta.getServizioId());

					switch (statoPagamento) {
					case ERRORE:
						pagamento.setErrore(verificaPagamento.getCodiceErrore() + " - " + verificaPagamento.getDescrizioneErrore());
						pagamento.setStato(StatoPagamento.ERRORE.name());
						statoRichiesta = StatoRichiesta.CHIUSA_NEGATIVAMENTE.name();
						break;
					case ANNULLATO:
						pagamento.setStato(StatoPagamento.ANNULLATO.name());
						statoRichiesta = StatoRichiesta.ANNULLATA.name();
						break;
					case COMPLETATO:
						pagamento.setIud(verificaPagamento.getCodiceIuv());
						pagamento.setStato(StatoPagamento.COMPLETATO.name());
						pagamento.setCommissioni(verificaPagamento.getImportoCommissioni());
						pagamento.setRiferimentoEsternoId(verificaPagamento.getIdRichiesta());

						// Salvataggio RT XML
						byte[] ricevutaTelematicaXmlBytes = verificaPagamento.getRicevutaTelematicaXml();
						if (ricevutaTelematicaXmlBytes != null && ricevutaTelematicaXmlBytes.length > 0) {
							String fileNameRicevutaPagamentoXML = RICEVUTA_TELEMATICA_PAGAMENTO_FILE_PREFIX + pagamentoId + ".xml";
							String descrizioneAllegatoRicevutaTelematicaXML = String.format(DESCRIZIONE_ALLEGATO_RICEVUTA_TELEMATICA_XML, pagamentoId);

							_log.debug("salvataggio file XML RT: " + fileNameRicevutaPagamentoXML);

							salvaAllegato(pagamento, richiesta, servizio, fileNameRicevutaPagamentoXML, descrizioneAllegatoRicevutaTelematicaXML, new ByteArrayInputStream(ricevutaTelematicaXmlBytes),
									ContentTypes.TEXT_XML);

							_log.debug("salvataggio file XML RT: " + fileNameRicevutaPagamentoXML + " effettuato.");
						}

						if (verificaPagamento instanceof VerificaPagamentoMarcaDaBolloRisposta) {
							byte[] marcaDaBolloBytes = ((VerificaPagamentoMarcaDaBolloRisposta) verificaPagamento).getMarcaDaBolloBytes();

							if (marcaDaBolloBytes != null && marcaDaBolloBytes.length > 0) {
								// XML
								String descrizioneAllegatoMarcaDaBollo = String.format(DESCRIZIONE_ALLEGATO_MARCA_DA_BOLLO, pagamentoId);
								String fileNameMarcaDaBollo = MARCA_DA_BOLLO_PAGAMENTO_FILE_PREFIX + pagamentoId + ".xml";

								_log.debug("salvataggio file XML Marca da bollo: " + fileNameMarcaDaBollo);

								salvaAllegato(pagamento, richiesta, servizio, fileNameMarcaDaBollo, descrizioneAllegatoMarcaDaBollo, new ByteArrayInputStream(marcaDaBolloBytes),
										ContentTypes.TEXT_XML);

								_log.debug("salvataggio file XML Marca da bollo: " + fileNameMarcaDaBollo + " completato.");
							}
						}
						break;

					default:
						break;
					}

					richiesta.setStato(statoRichiesta);
					richiestaLocalService.updateRichiesta(richiesta);
					Pagamento pagamentoAggiornato = pagamentoLocalService.updatePagamento(pagamento);

					_log.info("verificaPagamento :: pagamento con ID: " + pagamentoId + " aggiornato dallo stato " + statoIniziale + " allo stato " + pagamentoAggiornato.getStato());
				}
				catch (Exception e) {
					_log.error("doReceive :: errore durante la verifica del pagamento : " + pagamentoId + " :: " + e.getMessage(), e);
				}
			}
		}
	}

	/**
	 *
	 * @param pagamento
	 * @param richiesta
	 * @param servizio
	 * @param nomeAllegato
	 * @param descrizioneAllegato
	 * @param inputStream
	 * @param contentType
	 * @throws Exception
	 */
	private void salvaAllegato(Pagamento pagamento, Richiesta richiesta, Servizio servizio, String nomeAllegato, String descrizioneAllegato, InputStream inputStream, String contentType)
			throws Exception {
		User user = userLocalService.getUser(pagamento.getUserId());
		PrincipalThreadLocal.setName(user.getUserId());
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);

		long richiestaId = richiesta.getRichiestaId();
		String idDocumentaleRicevutaTelematica = fileServiceFactory.getActiveFileService().saveRequestFile(nomeAllegato, nomeAllegato, descrizioneAllegato, servizio.getCodice(), richiestaId,
				inputStream, contentType, pagamento.getUserId(), pagamento.getGroupId());

		AllegatoRichiesta allegatoRichiestaRicevutaTelematica = allegatoRichiestaLocalService.createAllegatoRichiesta(counterLocalService.increment());
		allegatoRichiestaRicevutaTelematica.setCompanyId(pagamento.getCompanyId());
		allegatoRichiestaRicevutaTelematica.setDefinizioneAllegatoId(null);
		allegatoRichiestaRicevutaTelematica.setDescrizione(descrizioneAllegato);
		allegatoRichiestaRicevutaTelematica.setGroupId(pagamento.getGroupId());
		allegatoRichiestaRicevutaTelematica.setIdDocumentale(idDocumentaleRicevutaTelematica);
		allegatoRichiestaRicevutaTelematica.setInterno(false);
		allegatoRichiestaRicevutaTelematica.setNome(nomeAllegato);
		allegatoRichiestaRicevutaTelematica.setPrincipale(false);
		allegatoRichiestaRicevutaTelematica.setRichiestaId(richiestaId);
		allegatoRichiestaRicevutaTelematica.setTitolo(nomeAllegato);
		allegatoRichiestaRicevutaTelematica.setUserId(pagamento.getUserId());
		allegatoRichiestaRicevutaTelematica.setUserName(pagamento.getUserName());
		allegatoRichiestaRicevutaTelematica.setVisibile(true);

		allegatoRichiestaLocalService.updateAllegatoRichiesta(allegatoRichiestaRicevutaTelematica);
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