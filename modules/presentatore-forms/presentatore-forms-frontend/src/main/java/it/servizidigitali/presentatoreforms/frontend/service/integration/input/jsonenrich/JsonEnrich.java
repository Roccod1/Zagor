package it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich;

import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.model.EnrichmentModel;

/**
 * @author pindi
 *
 */
public interface JsonEnrich {

	/**
	 * Metodo per arricchire il json Alpaca sulla base del pattern Chain of Responsability.
	 *
	 * @param <T>
	 * @param enrichmentModel
	 */
	<T> void enrich(EnrichmentModel<T> enrichmentModel);

}
