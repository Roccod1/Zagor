package it.servizidigitali.pagamento.ebollo.frontend.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

/**
 * @author pindi
 *
 */
@Component(immediate = true, service = PagamentoEBolloService.class)
public class PagamentoEBolloService {

	private static final Log log = LogFactoryUtil.getLog(PagamentoEBolloService.class.getName());

}
