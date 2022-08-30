package it.servizidigitali.presentatoreforms.frontend.service.input;

import it.servizidigitali.backoffice.integration.enums.TipoIntegrazioneBackoffice;

/**
 * @author Gianluca Pindinelli
 *
 */
public interface BackofficeIntegrationService extends IntegrationService {

	/**
	 * Ritorna la particolare tipologia di interazione da backoffice comunale.
	 *
	 * @return
	 */
	TipoIntegrazioneBackoffice getBackofficeIntegrationType();

}
