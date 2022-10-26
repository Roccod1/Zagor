package it.servizidigitali.pagamento.ebollo.frontend.portlet.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.pagamento.ebollo.frontend.constants.PagamentoEbolloFrontendPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + PagamentoEbolloFrontendPortletKeys.PAGAMENTOEBOLLOFRONTEND,
		"mvc.command.name=" + PagamentoEbolloFrontendPortletKeys.ESITO_PAGAMENTO_RENDER_COMMAND }, service = {
				MVCRenderCommand.class })
public class EsitoPagamentoMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		HttpServletRequest httpServletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		boolean pagamentoAnnullato = ParamUtil.getBoolean(httpServletRequest, "annullato") || ParamUtil.getBoolean(httpServletRequest, "ANNULLATO");
		String esitoPagamento = ParamUtil.getString(httpServletRequest, "esito", "OK");
		
		renderRequest.setAttribute(PagamentoEbolloFrontendPortletKeys.PAGAMENTO_ANNULLATO_CALLBACK_ATTRIBUTE, pagamentoAnnullato);
		renderRequest.setAttribute(PagamentoEbolloFrontendPortletKeys.ESITO_PAGAMENTO_CALLBACK_ATTRIBUTE, esitoPagamento);
		
		return PagamentoEbolloFrontendPortletKeys.ESITO_PAGAMENTO_RENDER_VIEW;
	}

}
