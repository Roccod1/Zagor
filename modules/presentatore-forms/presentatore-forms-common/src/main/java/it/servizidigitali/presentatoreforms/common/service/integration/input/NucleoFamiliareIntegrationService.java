package it.servizidigitali.presentatoreforms.common.service.integration.input;

import java.util.List;

import it.servizidigitali.backoffice.integration.enums.TipoIntegrazione;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.presentatoreforms.common.model.ComponenteNucleoFamiliareModel;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;

/**
 * @author Gianluca Pindinelli
 *
 */
public interface NucleoFamiliareIntegrationService {

	/**
	 * Ritorna la tipologia di integrazione.
	 *
	 * @return
	 */
	TipoIntegrazione getIntegrationType();

	/**
	 *
	 * @param userPreferences
	 * @param integrationPreferences
	 * @return
	 */
	List<ComponenteNucleoFamiliareModel> getComponentiNucleoFamiliare(UserPreferences userPreferences, IntegrationPreferences integrationPreferences);

}
