package it.servizidigitali.gestionepagamenti.common.client;

import it.servizidigitali.gestionepagamenti.common.client.exeption.PagamentiClientException;
import it.servizidigitali.gestionepagamenti.common.client.model.InvioPagamentoRisposta;
import it.servizidigitali.gestionepagamenti.common.client.model.Pagamento;
import it.servizidigitali.gestionepagamenti.common.enumeration.TipoPagamentiClient;

/**
 * @author pindi
 *
 */
public interface PagamentiClient {

	/**
	 *
	 * @param pagamento
	 * @param username
	 * @param password
	 * @param wsdlUrl
	 * @param rispostaPagamentoUrl
	 * @return
	 * @throws PagamentiClientException
	 */
	InvioPagamentoRisposta inviaPagamento(Pagamento pagamento, String username, String password, String wsdlUrl, String rispostaPagamentoUrl) throws PagamentiClientException;

	/**
	 *
	 * @return
	 */
	TipoPagamentiClient getTipoPagamentiClient();

}
