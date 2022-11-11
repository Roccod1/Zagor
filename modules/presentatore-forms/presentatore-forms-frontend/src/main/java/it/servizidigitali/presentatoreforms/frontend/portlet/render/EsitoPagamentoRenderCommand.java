package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;

@Component(//
		immediate = true, //
		property = { //
				"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
				"mvc.command.name=" + PresentatoreFormsPortletKeys.ESITO_PAGAMENTO_RENDER_COMMAND//
		}, //
		service = MVCRenderCommand.class//
) //
public class EsitoPagamentoRenderCommand implements MVCRenderCommand {

	public static final Log log = LogFactoryUtil.getLog(EsitoPagamentoRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		HttpServletRequest originalServletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String esitoParameterValue = originalServletRequest.getParameter("esito");
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.ESITO_PAGAMENTO, esitoParameterValue);

		return PresentatoreFormsPortletKeys.JSP_ESITO_PAGAMENTO;
	}

}
