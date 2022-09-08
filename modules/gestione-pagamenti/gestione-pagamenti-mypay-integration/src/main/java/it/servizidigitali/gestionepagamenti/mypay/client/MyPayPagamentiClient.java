package it.servizidigitali.gestionepagamenti.mypay.client;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestionepagamenti.common.client.PagamentiClient;
import it.servizidigitali.gestionepagamenti.common.client.exeption.PagamentiClientException;
import it.servizidigitali.gestionepagamenti.common.client.model.InviaPagamentoRichiesta;
import it.servizidigitali.gestionepagamenti.common.client.model.InvioPagamentoRisposta;

/**
 * @author pindi
 *
 */
@Component(name = "", service = PagamentiClient.class, immediate = true)
public class MyPayPagamentiClient implements PagamentiClient {

	@Override
	public InvioPagamentoRisposta inviaPagamento(InviaPagamentoRichiesta inviaPagamentoRichiesta) throws PagamentiClientException {
		// TODO Auto-generated method stub
		return null;
	}

}
