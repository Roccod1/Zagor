package it.servizidigitali.presentatoreforms.frontend.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.enums.TipoIntegrazione;
import it.servizidigitali.backoffice.integration.enums.TipoIntegrazioneBackoffice;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.IntegrationServiceFactory;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.BackofficeIntegrationService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.IntegrationService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.frontend.service.integration.output.model.DichiarazioneRisposta;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

/**
 * The Alpaca service.
 *
 * @author pindi
 *
 */
@Component(name = "alpacaService", immediate = true, service = AlpacaService.class)
public class AlpacaService {

	private static final Log log = LogFactoryUtil.getLog(AlpacaService.class.getName());

	@Reference
	private IntegrationServiceFactory integrationServiceFactory;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	/**
	 * Carica i dati relativi al form di Alpaca.
	 *
	 * @param data
	 * @param schema
	 * @param options
	 * @param form
	 * @param codiceFiscaleComponente
	 * @param request
	 * @throws PortalException
	 */
	public void loadData(final JsonObject data, final String schema, final String options, Procedura procedura, UserPreferences userPreferences) throws PortalException {

		Gson gson = new Gson();
		AlpacaJsonOptionsStructure optionStr = gson.fromJson(options, AlpacaJsonOptionsStructure.class);

		// Enrichment
		enrichAlpacaForm(optionStr, data, userPreferences, procedura);

	}

	/**
	 *
	 * @param richiesta
	 * @param procedura
	 * @param userPreferences
	 * @return
	 * @throws PortalException
	 */
	public DichiarazioneRisposta sendData(Richiesta richiesta, Procedura procedura, UserPreferences userPreferences) throws PortalException {

		DichiarazioneRisposta risposta = null;

		long groupId = procedura.getGroupId();
		Servizio servizio = servizioLocalService.getServizio(procedura.getServizioId());

		long organizationId = groupLocalService.getGroup(groupId).getOrganizationId();

		Organization organization = organizationLocalService.getOrganization(organizationId);
		if (organization != null && organization.isRoot()) {
			Serializable tipoIntegrazioneSerializable = organization.getExpandoBridge().getAttribute("tipoIntegrazione");

			TipoIntegrazione tipoIntegrazione = TipoIntegrazione.valueOf(tipoIntegrazioneSerializable.toString());

			Map<TipoIntegrazione, Map<String, it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService>> outputBackofficeIntegrationServicesMap = integrationServiceFactory
					.getOutputBackofficeIntegrationServicesMap();

			Map<String, it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService> integrationServicesMap = outputBackofficeIntegrationServicesMap
					.get(tipoIntegrazione);
			if (integrationServicesMap != null && !integrationServicesMap.isEmpty()) {
				it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService integrationService = integrationServicesMap.get(servizio.getCodice());
				if (integrationService != null) {
					risposta = integrationService.send(richiesta, userPreferences);
				}
			}
		}
		return risposta;
	}

	public void enrichAlpacaForm(AlpacaJsonOptionsStructure alpacaJsonOptionsStructure, JsonObject jsonObject, UserPreferences userPreferences, Procedura procedura) throws PortalException {

		long servizioId = procedura.getServizioId();
		long groupId = procedura.getGroupId();

		long organizationId = groupLocalService.getGroup(groupId).getOrganizationId();

		IntegrationPreferences integrationPreferences = getIntegrationPreferences(procedura);

		Map<TipoIntegrazione, List<IntegrationService>> inputIntegrationServicesMap = integrationServiceFactory.getInputIntegrationServicesMap();

		// Aggiunta enrichment servizi di supporto
		List<IntegrationService> supportIntegrationServices = inputIntegrationServicesMap.get(TipoIntegrazione.SUPPORTO);
		if (supportIntegrationServices != null) {
			for (IntegrationService integrationService : supportIntegrationServices) {
				integrationService.enrich(alpacaJsonOptionsStructure, jsonObject, userPreferences, organizationId, servizioId, integrationPreferences);
			}
		}

		Organization organization = organizationLocalService.getOrganization(organizationId);

		// Enrichment sulla base del tipo di integrazione previsto dal Comune e sul tipo
		// di TipoIntegrazioneBackoffice
		if (organization != null && organization.isRoot()) {
			Serializable anprSerializable = organization.getExpandoBridge().getAttribute("anpr");
			Serializable tipoIntegrazioneSerializable = organization.getExpandoBridge().getAttribute("tipoIntegrazione");

			TipoIntegrazione tipoIntegrazione = TipoIntegrazione.valueOf(tipoIntegrazioneSerializable.toString());

			// Verifica integrazione ANPR (che deve vincere sui servizi di Backoffice Anagrafici)
			boolean usaANPR = Boolean.parseBoolean(anprSerializable.toString());
			if (usaANPR) {
				List<TipoIntegrazioneBackoffice> tipiIntegrazioneBackoffice = getTipiIntegrazioneBackofficeList(procedura.getStep2TipiIntegrazioneBackoffice());
				if (tipiIntegrazioneBackoffice != null) {
					for (TipoIntegrazioneBackoffice tipoIntegrazioneBackoffice : tipiIntegrazioneBackoffice) {
						if (tipoIntegrazioneBackoffice.equals(TipoIntegrazioneBackoffice.VISURA_ANAGRAFICA)
								|| tipoIntegrazioneBackoffice.equals(TipoIntegrazioneBackoffice.VISURA_DATI_ANAGRAFICI_GENERALI)
								|| tipoIntegrazioneBackoffice.equals(TipoIntegrazioneBackoffice.VISURA_ELETTORALE)
								|| tipoIntegrazioneBackoffice.equals(TipoIntegrazioneBackoffice.VISURA_VARIAZIONI_DOMICILIARI)) {
							tipoIntegrazione = TipoIntegrazione.ANPR;
							break;
						}
					}
				}
			}

			Map<TipoIntegrazione, Map<TipoIntegrazioneBackoffice, List<BackofficeIntegrationService>>> inputBackofficeIntegrationServicesMap = integrationServiceFactory
					.getInputBackofficeIntegrationServicesMap();

			Map<TipoIntegrazioneBackoffice, List<BackofficeIntegrationService>> integrationServiceMap = inputBackofficeIntegrationServicesMap.get(tipoIntegrazione);
			List<TipoIntegrazioneBackoffice> tipiIntegrazioneBackoffice = getTipiIntegrazioneBackofficeList(procedura.getStep2TipiIntegrazioneBackoffice());
			if (integrationServiceMap != null && !integrationServiceMap.isEmpty() && tipiIntegrazioneBackoffice != null) {
				for (TipoIntegrazioneBackoffice tipoIntegrazioneBackoffice : tipiIntegrazioneBackoffice) {
					List<BackofficeIntegrationService> backofficeIntegrationServices = integrationServiceMap.get(tipoIntegrazioneBackoffice);
					if (backofficeIntegrationServices != null) {
						for (BackofficeIntegrationService backofficeIntegrationService : backofficeIntegrationServices) {
							backofficeIntegrationService.enrich(alpacaJsonOptionsStructure, jsonObject, userPreferences, organizationId, servizioId, integrationPreferences);
						}
					}
				}
			}
		}
	}

	/**
	 * @param step2TipiIntegrazioneBackoffice
	 * @return
	 */
	private List<TipoIntegrazioneBackoffice> getTipiIntegrazioneBackofficeList(String step2TipiIntegrazioneBackoffice) {
		String[] step2TipiIntegrazioneBackofficeSplit = step2TipiIntegrazioneBackoffice.split(",");
		if (step2TipiIntegrazioneBackofficeSplit != null) {
			List<TipoIntegrazioneBackoffice> tipoIntegrazioneBackoffices = new ArrayList<TipoIntegrazioneBackoffice>();
			for (String tipoIntegrazioneBackoffice : step2TipiIntegrazioneBackofficeSplit) {
				try {
					tipoIntegrazioneBackoffices.add(TipoIntegrazioneBackoffice.valueOf(tipoIntegrazioneBackoffice));
				}
				catch (Exception e) {
					log.warn("getTipiIntegrazioneBackofficeList :: " + e.getMessage());
				}
			}
			return tipoIntegrazioneBackoffices;

		}
		return null;
	}

	/**
	 *
	 * @param procedura
	 * @return
	 * @throws PortalException
	 */
	private IntegrationPreferences getIntegrationPreferences(Procedura procedura) throws PortalException {

		IntegrationPreferences integrationPreferences = null;
		if (procedura != null) {
			integrationPreferences = new IntegrationPreferences();
			String codiceServizio = servizioLocalService.getServizio(procedura.getServizioId()).getCodice();
			integrationPreferences.setUsaCache(procedura.isAbilitaCacheIntegrazioneBackoffice());
			integrationPreferences.setCodiceServizio(codiceServizio);
		}

		return integrationPreferences;
	}
}
