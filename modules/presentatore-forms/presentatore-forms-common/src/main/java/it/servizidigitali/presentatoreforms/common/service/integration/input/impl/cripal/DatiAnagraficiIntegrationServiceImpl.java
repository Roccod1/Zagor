package it.servizidigitali.presentatoreforms.common.service.integration.input.impl.cripal;

import com.google.gson.JsonObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.enums.TipoIntegrazione;
import it.servizidigitali.backoffice.integration.enums.TipoIntegrazioneBackoffice;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.common.service.integration.IntegrationServiceFactory;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.BackofficeIntegrationService;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.JsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;

/**
 * @author pindi
 *
 */
@Component(name = "datiAnagraficiIntegrationServiceImpl", immediate = true, service = BackofficeIntegrationService.class)
public class DatiAnagraficiIntegrationServiceImpl implements BackofficeIntegrationService {

	private static final Log log = LogFactoryUtil.getLog(DatiAnagraficiIntegrationServiceImpl.class.getName());

	@Reference(target = "(component.name=anagrafeBackofficeIntegrationService)")
	private AnagrafeIntegrationService anagrafeBackofficeIntegrationService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private IntegrationServiceFactory integrationServiceFactory;

	@Override
	public void enrich(AlpacaJsonOptionsStructure alpacaJsonOptionsStructure, JsonObject jsonObject, UserPreferences userPreferences, long organizationId, long servizioId,
			IntegrationPreferences integrationPreferences) {

		String codiceFiscale = userPreferences.getCodiceFiscaleRichiedente();

		DatiAnagrafici datiAnagrafici = getDatiAnagrafici(codiceFiscale, organizationId, integrationPreferences);
		if (datiAnagrafici != null) {
			List<DatiAnagraficiJsonEnrich> jsonEnrichs = integrationServiceFactory.getDatiAnagraficiJsonEnrichs();
			if (jsonEnrichs != null) {
				for (JsonEnrich jsonEnrich : jsonEnrichs) {
					EnrichmentModel<?> enrichmentModel = new EnrichmentModel<>(alpacaJsonOptionsStructure, jsonObject, datiAnagrafici, organizationId, servizioId, userPreferences);
					jsonEnrich.enrich(enrichmentModel);
				}
			}
		}
	}

	private DatiAnagrafici getDatiAnagrafici(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		DatiAnagrafici datiAnagrafici = null;
		try {
			datiAnagrafici = anagrafeBackofficeIntegrationService.getDatiAnagrafici(codiceFiscale, organizationId, integrationPreferences);
		}
		catch (Exception e) {
			log.error("getDatiAnagrafici :: " + e.getMessage(), e);
			throw new BackofficeServiceException("getDatiAnagrafici :: " + e.getMessage(), e);
		}

		if (datiAnagrafici == null || datiAnagrafici.getComponentiNucleoFamiliare() == null || datiAnagrafici.getComponentiNucleoFamiliare().isEmpty()) {
			throw new BackofficeServiceException("getDatiAnagrafici :: lista componenti nucleo familiare vuota");
		}

		return datiAnagrafici;
	}

	@Override
	public TipoIntegrazione getIntegrationType() {
		return TipoIntegrazione.CRIPAL;
	}

	@Override
	public TipoIntegrazioneBackoffice getBackofficeIntegrationType() {
		return TipoIntegrazioneBackoffice.VISURA_ANAGRAFICA;
	}

}
