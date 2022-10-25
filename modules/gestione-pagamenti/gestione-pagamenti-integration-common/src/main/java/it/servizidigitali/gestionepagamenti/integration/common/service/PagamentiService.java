package it.servizidigitali.gestionepagamenti.integration.common.service;

import java.io.InputStream;

import it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.TipoPagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.client.exception.PagamentiServiceException;
import it.servizidigitali.gestionepagamenti.integration.common.model.MarcaDaBollo;

/**
 * @author pindi
 *
 */
public interface PagamentiService {

	/**
	 *
	 * @param inputStream
	 * @return
	 * @throws PagamentiServiceException
	 */
	MarcaDaBollo unmarshal(InputStream inputStream) throws PagamentiServiceException;

	/**
	 *
	 * @return
	 */
	TipoPagamentiClient getTipoPagamentiClient();

}
