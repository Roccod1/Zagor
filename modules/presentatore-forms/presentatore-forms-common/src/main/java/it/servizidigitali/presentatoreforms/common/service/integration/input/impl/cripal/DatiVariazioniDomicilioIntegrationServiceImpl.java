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
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.common.service.integration.IntegrationServiceFactory;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.BackofficeIntegrationService;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.JsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiVariazioneDomicilioJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;

/**
 * @author pindi
 *
 */
@Component(name = "datiVariazioniDomicilioIntegrationServiceImpl", immediate = true, service = BackofficeIntegrationService.class)
public class DatiVariazioniDomicilioIntegrationServiceImpl implements BackofficeIntegrationService {

	private static final Log log = LogFactoryUtil.getLog(DatiVariazioniDomicilioIntegrationServiceImpl.class.getName());

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

		DatiVariazioniDomicilio datiVariazioniDomicilio = getDatiVariazioniDomicilio(codiceFiscale, organizationId, integrationPreferences);
		if (datiVariazioniDomicilio != null) {
			List<DatiVariazioneDomicilioJsonEnrich> jsonEnrichs = integrationServiceFactory.getDatiVariazioneDomicilioJsonEnrichs();
			if (jsonEnrichs != null) {
				for (JsonEnrich jsonEnrich : jsonEnrichs) {
					EnrichmentModel<?> enrichmentModel = new EnrichmentModel<>(alpacaJsonOptionsStructure, jsonObject, datiVariazioniDomicilio, organizationId, servizioId, userPreferences);
					jsonEnrich.enrich(enrichmentModel);
				}
			}
		}
	}

	private DatiVariazioniDomicilio getDatiVariazioniDomicilio(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		DatiVariazioniDomicilio datiVariazioniDomicilio = null;
		try {
			datiVariazioniDomicilio = anagrafeBackofficeIntegrationService.getDatiVariazioniDomicilio(codiceFiscale, organizationId, integrationPreferences);
		}
		catch (Exception e) {
			log.error("getDatiElettorali :: " + e.getMessage(), e);
			throw new BackofficeServiceException("getDatiVariazioniDomicilio :: " + e.getMessage(), e);
		}

		if (datiVariazioniDomicilio == null || datiVariazioniDomicilio.getVariazioniDomicilio() == null || datiVariazioniDomicilio.getVariazioniDomicilio().isEmpty()) {
			throw new BackofficeServiceException("getDatiVariazioniDomicilio :: lista variazioni domicilio vuota");
		}

		return datiVariazioniDomicilio;
	}

	@Override
	public TipoIntegrazione getIntegrationType() {
		return TipoIntegrazione.CRIPAL;
	}

	@Override
	public TipoIntegrazioneBackoffice getBackofficeIntegrationType() {
		return TipoIntegrazioneBackoffice.VISURA_VARIAZIONI_DOMICILIARI;
	}

}
