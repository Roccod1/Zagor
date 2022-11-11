package it.servizidigitali.pagamento.ebollo.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.pagamento.ebollo.frontend.constants.PagamentoEbolloFrontendPortletKeys;
import it.servizidigitali.pagamento.ebollo.frontend.service.PagamentoEBolloService;

@Component(immediate = true, //
		property = { //
				"javax.portlet.name=" + PagamentoEbolloFrontendPortletKeys.PAGAMENTOEBOLLOFRONTEND, //
				"mvc.command.name=" + PagamentoEbolloFrontendPortletKeys.UPLOAD_FILE_ACTION_COMMAND //
		}, //
		service = { MVCActionCommand.class }//
) //

public class UploadFileMVCActionCommand extends BaseMVCActionCommand {

	private static final Log LOG = LogFactoryUtil.getLog(UploadFileMVCActionCommand.class.getName());

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private PagamentoEBolloService pagamentoEBolloService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long siteGroupId = themeDisplay.getSiteGroupId();
		long companyId = themeDisplay.getCompanyId();

		long organizationId = themeDisplay.getSiteGroup().getOrganizationId();

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		File file = uploadPortletRequest.getFile(PagamentoEbolloFrontendPortletKeys.FILE_TO_UPLOAD_ATTRIBUTE);

		String fileName = uploadPortletRequest.getFileName(PagamentoEbolloFrontendPortletKeys.FILE_TO_UPLOAD_ATTRIBUTE);

		User user = themeDisplay.getUser();

		long userId = user.getUserId();

		LiferayPortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPpid(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		portletURL.getRenderParameters().setValue("mvcRenderCommandName", PagamentoEbolloFrontendPortletKeys.ESITO_PAGAMENTO_RENDER_COMMAND);

		Servizio servizio = pagamentoEBolloService.getCurrentServizio(themeDisplay);

		try {
			byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
			String redirectPagamentoBolloUrl = pagamentoEBolloService.pagaBollo(bytes, fileName, servizio.getServizioId(), organizationId, userId, siteGroupId, companyId, portletURL.toString());

			actionRequest.setAttribute(PagamentoEbolloFrontendPortletKeys.REDIRECT_PAGAMENTO_BOLLO_URL, redirectPagamentoBolloUrl);

			actionResponse.getRenderParameters().setValue("mvcPath", "/redirect.jsp");

		}
		catch (Exception e) {
			String errorMessage = e.getMessage();
			LOG.error(errorMessage, e);

			actionRequest.setAttribute(PagamentoEbolloFrontendPortletKeys.ERROR_OCCURRED_ON_PAGA_BOLLO, true);
			actionRequest.setAttribute(PagamentoEbolloFrontendPortletKeys.ERROR_MESSAGE_ON_PAGA_BOLLO, errorMessage);
			actionResponse.getRenderParameters().setValue("mvcPath", "/view.jsp");

			return;
		}
		finally {
			if (file != null && !file.exists()) {
				file.delete();
			}
		}
	}
}