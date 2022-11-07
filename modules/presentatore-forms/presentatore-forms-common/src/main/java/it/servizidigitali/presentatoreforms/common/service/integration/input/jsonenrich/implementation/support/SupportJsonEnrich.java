package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.support;

import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.JsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;

/**
 * @author Gianluca Pindinelli
 *
 */
public interface SupportJsonEnrich extends JsonEnrich {

	/**
	 * Crea l'{@link EnrichmentModel} che sarà utilizzato dalla particolare implementazione.
	 *
	 * @param userPreferences
	 * @return
	 */
	EnrichmentModel<?> generateEnrichmentModel(UserPreferences userPreferences);

}
