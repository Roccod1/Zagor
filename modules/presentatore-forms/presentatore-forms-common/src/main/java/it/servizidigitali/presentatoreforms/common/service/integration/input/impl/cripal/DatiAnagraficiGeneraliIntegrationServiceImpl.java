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
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagraficiGenerali;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.common.service.integration.IntegrationServiceFactory;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.BackofficeIntegrationService;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.JsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiGeneraliJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;

/**
 * @author pindi
 *
 */
@Component(name = "datiAnagraficiGeneraliIntegrationServiceImpl", immediate = true, service = BackofficeIntegrationService.class)
public class DatiAnagraficiGeneraliIntegrationServiceImpl implements BackofficeIntegrationService {

	private static final Log log = LogFactoryUtil.getLog(DatiAnagraficiGeneraliIntegrationServiceImpl.class.getName());

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

		DatiAnagraficiGenerali datiAnagraficiGenerali = getDatiAnagraficiGenerali(codiceFiscale, organizationId, integrationPreferences);
		if (datiAnagraficiGenerali != null) {
			List<DatiAnagraficiGeneraliJsonEnrich> jsonEnrichs = integrationServiceFactory.getDatiAnagraficiGeneraliJsonEnrichs();
			if (jsonEnrichs != null) {
				for (JsonEnrich jsonEnrich : jsonEnrichs) {
					EnrichmentModel<?> enrichmentModel = new EnrichmentModel<>(alpacaJsonOptionsStructure, jsonObject, datiAnagraficiGenerali, organizationId, servizioId, userPreferences);
					jsonEnrich.enrich(enrichmentModel);
				}
			}
		}
	}

	private DatiAnagraficiGenerali getDatiAnagraficiGenerali(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		DatiAnagraficiGenerali datiAnagraficiGenerali = null;
		try {
			datiAnagraficiGenerali = anagrafeBackofficeIntegrationService.getDatiAnagraficiGenerali(codiceFiscale, organizationId, integrationPreferences);
		}
		catch (Exception e) {
			log.error("getDatiAnagraficiGenerali :: " + e.getMessage(), e);
			throw new BackofficeServiceException("getDatiAnagraficiGenerali :: " + e.getMessage(), e);
		}

		if (datiAnagraficiGenerali == null) {
			throw new BackofficeServiceException("getDatiAnagraficiGenerali :: dati utente null");
		}

		return datiAnagraficiGenerali;
	}

	@Override
	public TipoIntegrazione getIntegrationType() {
		return TipoIntegrazione.CRIPAL;
	}

	@Override
	public TipoIntegrazioneBackoffice getBackofficeIntegrationType() {
		return TipoIntegrazioneBackoffice.VISURA_DATI_ANAGRAFICI_GENERALI;
	}

}
