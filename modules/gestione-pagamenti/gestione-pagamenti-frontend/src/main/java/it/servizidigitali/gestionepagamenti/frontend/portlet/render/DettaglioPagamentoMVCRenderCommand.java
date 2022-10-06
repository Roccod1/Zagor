package it.servizidigitali.gestionepagamenti.frontend.portlet.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionepagamenti.frontend.constants.GestionePagamentiFrontendPortletKeys;
import it.servizidigitali.gestionepagamenti.frontend.service.GestionePagamentiService;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.PagamentoLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + GestionePagamentiFrontendPortletKeys.GESTIONEPAGAMENTIFRONTEND,
		"mvc.command.name=" + GestionePagamentiFrontendPortletKeys.DETTAGLIO_PAGAMENTO_RENDER_COMMAND }, service = {
				MVCRenderCommand.class })
public class DettaglioPagamentoMVCRenderCommand implements MVCRenderCommand {
	
	public static final Log LOG = LogFactoryUtil.getLog(DettaglioPagamentoMVCRenderCommand.class);
	
	@Reference
	private PagamentoLocalService pagamentoLocalService;
	
	@Reference
	private GestionePagamentiService gestionePagamentiService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long pagamentoId = ParamUtil.getLong(renderRequest, GestionePagamentiFrontendPortletKeys.PAGAMENTO_ID_DETTAGLIO);
		
		Pagamento pagamento = null;
		
		try {
			pagamento = pagamentoLocalService.getPagamento(pagamentoId);
			gestionePagamentiService.initDataForView(pagamento);
		} catch (PortalException e) {
			LOG.error(e.getMessage(), e);
		}
		
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DETTAGLIO_PAGAMENTO, pagamento);
		
		return GestionePagamentiFrontendPortletKeys.DETTAGLIO_PAGAMENTO_VIEW;
	}

}
