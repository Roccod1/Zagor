package it.servizidigitali.gestionepagamenti.common.client;

import it.servizidigitali.gestionepagamenti.common.client.exeption.PagamentiClientException;
import it.servizidigitali.gestionepagamenti.common.client.model.PagamentoDovutoRisposta;
import it.servizidigitali.gestionepagamenti.common.client.model.VerificaPagamentoRisposta;
import it.servizidigitali.gestionepagamenti.common.client.model.Dovuto;
import it.servizidigitali.gestionepagamenti.common.enumeration.TipoPagamentiClient;

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

	VerificaPagamentoRisposta verificaPagamento(String idSession, String identificativoPag, String username, String password, String wsdlUrl, String basePath) throws PagamentiClientException;
	
	/**
	 *
	 * @return
	 */
	TipoPagamentiClient getTipoPagamentiClient();

}
