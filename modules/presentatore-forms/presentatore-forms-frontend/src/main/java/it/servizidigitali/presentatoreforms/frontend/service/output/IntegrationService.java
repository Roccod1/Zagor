package it.servizidigitali.presentatoreforms.frontend.service.output;

import it.servizidigitali.backoffice.integration.enums.TipoIntegrazione;
import it.servizidigitali.presentatoreforms.frontend.service.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.frontend.service.output.model.DichiarazioneRisposta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

/**
 * @author pindi
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
	 * Ritorna il codice servizio corrispondente al tipo di integrazione.
	 *
	 * @return
	 */
	String getServiceCode();

	/**
	 *
	 * @param datiRichiestaServizio
	 * @param userPreferences
	 * @return
	 */
	DichiarazioneRisposta send(Richiesta richiesta, UserPreferences userPreferences);

}
