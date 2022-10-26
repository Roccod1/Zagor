package it.servizidigitali.gestionepagamenti.integration.common.client;

import it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.TipoPagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.client.exception.PagamentiClientException;
import it.servizidigitali.gestionepagamenti.integration.common.client.model.Dovuto;
import it.servizidigitali.gestionepagamenti.integration.common.client.model.PagamentoDovutoRisposta;
import it.servizidigitali.gestionepagamenti.integration.common.client.model.VerificaPagamentoRisposta;

/**
 * @author pindi
 *
 */
public interface PagamentiClient {

	/**
	 *
	 * @param dovuto
	 * @param username
	 * @param password
	 * @param wsdlUrl
	 * @param rispostaPagamentoUrl
	 * @return
	 * @throws PagamentiClientException
	 */
	PagamentoDovutoRisposta pagaDovuto(Dovuto dovuto, String username, String password, String wsdlUrl, String rispostaPagamentoUrl) throws PagamentiClientException;

	/**
	 *
	 * @param idSessione
	 * @param iuv
	 * @param iud
	 * @param username
	 * @param password
	 * @param wsdlUrl
	 * @return
	 * @throws PagamentiClientException
	 */
	VerificaPagamentoRisposta verificaPagamento(String idSessione, String iuv, String iud, String username, String password, String wsdlUrl) throws PagamentiClientException;

	/**
	 *
	 * @return
	 */
	TipoPagamentiClient getTipoPagamentiClient();

}
