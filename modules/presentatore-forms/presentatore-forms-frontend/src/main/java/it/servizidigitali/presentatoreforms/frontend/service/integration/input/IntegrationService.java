package it.servizidigitali.presentatoreforms.frontend.service.integration.input;

import com.google.gson.JsonObject;

import it.servizidigitali.backoffice.integration.enums.TipoIntegrazione;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonOptionsStructure;

/**
 * @author Gianluca Pindinelli
 *
 */
public interface IntegrationService {

	/**
	 * Ritorna la tipologia di integrazione.
	 *
	 * @return
	 */
	TipoIntegrazione getIntegrationType();

	/**
	 * Arricchisce il {@link JsonObject} passato in input sulla base della struttura Alpaca.
	 *
	 * @param alpacaJsonOptionsStructure
	 * @param alpacaJsonData
	 * @param userPreferences
	 * @param organizationId
	 * @param servizioId
	 * @param integrationPreferences
	 */
	void enrich(AlpacaJsonOptionsStructure alpacaJsonOptionsStructure, JsonObject jsonObject, UserPreferences userPreferences, long organizationId, long servizioId,
			IntegrationPreferences integrationPreferences);

}
