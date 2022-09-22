package it.servizidigitali.gestionepagamenti.common.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import it.servizidigitali.gestionepagamenti.common.client.PagamentiClient;
import it.servizidigitali.gestionepagamenti.common.enumeration.TipoPagamentiClient;

/**
 * @author pindi
 *
 */
@Component(name = "pagamentiClientFactory", service = PagamentiClientFactory.class, immediate = true)
public class PagamentiClientFactory {

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	private volatile List<PagamentiClient> pagamentiClients;

	private Map<TipoPagamentiClient, PagamentiClient> pagamentiClientMap;

	boolean initialized;

	private void init() {
		if (!initialized && pagamentiClients != null) {
			pagamentiClientMap = new HashMap<>();
			for (PagamentiClient pagamentiClient : pagamentiClients) {
				pagamentiClientMap.put(pagamentiClient.getTipoPagamentiClient(), pagamentiClient);
			}
		}
		initialized = true;
	}

	/**
	 * @return the pagamentiClientMap
	 */
	private Map<TipoPagamentiClient, PagamentiClient> getPagamentiClientMap() {
		init();
		return pagamentiClientMap;
	}

	/**
	 *
	 * @param tipoPagamentiClient
	 * @return
	 */
	public PagamentiClient getPagamentiClient(TipoPagamentiClient tipoPagamentiClient) {
		return pagamentiClientMap.get(tipoPagamentiClient);
	}

}
