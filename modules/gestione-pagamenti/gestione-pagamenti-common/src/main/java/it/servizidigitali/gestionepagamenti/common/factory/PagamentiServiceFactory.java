package it.servizidigitali.gestionepagamenti.common.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.TipoPagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.service.PagamentiService;

/**
 * @author pindi
 *
 */
@Component(name = "pagamentiServiceFactory", service = PagamentiServiceFactory.class, immediate = true)
public class PagamentiServiceFactory {

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	private volatile List<PagamentiService> pagamentiService;

	private Map<TipoPagamentiClient, PagamentiService> pagamentiServiceMap;

	boolean initialized;

	private void init() {
		if (!initialized && pagamentiService != null) {
			pagamentiServiceMap = new HashMap<>();
			for (PagamentiService pagamentiService : pagamentiService) {
				pagamentiServiceMap.put(pagamentiService.getTipoPagamentiClient(), pagamentiService);
			}
		}
		initialized = true;
	}

	/**
	 *
	 * @param tipoPagamentiClient
	 * @return
	 */
	public PagamentiService getPagamentiService(TipoPagamentiClient tipoPagamentiClient) {
		init();
		if (pagamentiServiceMap != null && !pagamentiServiceMap.isEmpty()) {
			return pagamentiServiceMap.get(tipoPagamentiClient);
		}
		return null;
	}
}
