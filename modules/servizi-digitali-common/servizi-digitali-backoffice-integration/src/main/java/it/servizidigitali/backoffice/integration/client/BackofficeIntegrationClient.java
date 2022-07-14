package it.servizidigitali.backoffice.integration.client;

import it.servizidigitali.backoffice.integration.exception.BackofficeIntegrationClientException;

/**
 * 
 * @author pindi
 *
 */
public interface BackofficeIntegrationClient {

	/**
	 * 
	 * @param payloadXml
	 * @param nomeServizio
	 * @param wsUrl
	 * @param readTimeout
	 * @return
	 * @throws BackofficeIntegrationClientException
	 */
	String sendXml(String payloadXml, String nomeServizio, String wsUrl, int... readTimeout) throws BackofficeIntegrationClientException;

}
