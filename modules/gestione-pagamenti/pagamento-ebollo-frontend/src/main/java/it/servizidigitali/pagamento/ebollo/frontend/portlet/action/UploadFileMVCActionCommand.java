package it.servizidigitali.pagamento.ebollo.frontend.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.pagamento.ebollo.frontend.constants.PagamentoEbolloFrontendPortletKeys;
import it.servizidigitali.pagamento.ebollo.frontend.service.PagamentoEBolloService;

@Component(immediate = true, property = { "javax.portlet.name=" + PagamentoEbolloFrontendPortletKeys.PAGAMENTOEBOLLOFRONTEND,
		"mvc.command.name=" + PagamentoEbolloFrontendPortletKeys.UPLOAD_FILE_ACTION_COMMAND }, service = { MVCActionCommand.class })
public class UploadFileMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	private PagamentoEBolloService pagamentoEBolloService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String redirectPagamentoBolloUrl = pagamentoEBolloService.pagaBollo(actionRequest);
		actionRequest.setAttribute("redirectPagamentoBolloUrl", redirectPagamentoBolloUrl);
		actionResponse.getRenderParameters().setValue("mvcPath", "/redirect.jsp");
	}
}