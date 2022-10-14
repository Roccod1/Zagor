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
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.common.service.integration.IntegrationServiceFactory;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.BackofficeIntegrationService;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.JsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiElettoraliJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;

/**
 * @author pindi
 *
 */
@Component(name = "datiElettoraliIntegrationServiceImpl", immediate = true, service = BackofficeIntegrationService.class)
public class DatiElettoraliIntegrationServiceImpl implements BackofficeIntegrationService {

	private static final Log log = LogFactoryUtil.getLog(DatiElettoraliIntegrationServiceImpl.class.getName());

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

		DatiElettorali datiElettorali = getDatiElettorali(codiceFiscale, organizationId, integrationPreferences);
		if (datiElettorali != null) {
			List<DatiElettoraliJsonEnrich> jsonEnrichs = integrationServiceFactory.getDatiElettoraliJsonEnrichs();
			if (jsonEnrichs != null) {
				for (JsonEnrich jsonEnrich : jsonEnrichs) {
					EnrichmentModel<?> enrichmentModel = new EnrichmentModel<>(alpacaJsonOptionsStructure, jsonObject, datiElettorali, organizationId, servizioId, userPreferences);
					jsonEnrich.enrich(enrichmentModel);
				}
			}
		}
	}

	private DatiElettorali getDatiElettorali(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		DatiElettorali datiElettorali = null;
		try {
			datiElettorali = anagrafeBackofficeIntegrationService.getDatiElettorali(codiceFiscale, organizationId, integrationPreferences);
		}
		catch (Exception e) {
			log.error("getDatiElettorali :: " + e.getMessage(), e);
			throw new BackofficeServiceException("getDatiElettorali :: " + e.getMessage(), e);
		}

		if (datiElettorali == null || datiElettorali.getPosizioniElettorali() == null || datiElettorali.getPosizioniElettorali().isEmpty()) {
			throw new BackofficeServiceException("getDatiElettorali :: lista posizioni elettorali vuota");
		}

		return datiElettorali;
	}

	@Override
	public TipoIntegrazione getIntegrationType() {
		return TipoIntegrazione.CRIPAL;
	}

	@Override
	public TipoIntegrazioneBackoffice getBackofficeIntegrationType() {
		return TipoIntegrazioneBackoffice.VISURA_ELETTORALE;
	}

}
