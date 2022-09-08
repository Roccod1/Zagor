package it.servizidigitali.gestionepagamenti.common.client;

import it.servizidigitali.gestionepagamenti.common.client.exeption.PagamentiClientException;
import it.servizidigitali.gestionepagamenti.common.client.model.InviaPagamentoRichiesta;
import it.servizidigitali.gestionepagamenti.common.client.model.InvioPagamentoRisposta;

/**
 * @author pindi
 *
 */
public interface PagamentiClient {

	/**
	 *
	 * @param inviaPagamentoRichiesta
	 * @return
	 * @throws PagamentiClientException
	 */
	InvioPagamentoRisposta inviaPagamento(InviaPagamentoRichiesta inviaPagamentoRichiesta) throws PagamentiClientException;

}
