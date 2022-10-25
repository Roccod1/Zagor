package it.servizidigitali.verifica.ebollo.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.verifica.ebollo.frontend.constants.VerificaEbolloFrontendPortletKeys;
import it.servizidigitali.verifica.ebollo.frontend.service.VerificaEBolloService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + VerificaEbolloFrontendPortletKeys.VERIFICAEBOLLOPORTLET,
		"mvc.command.name=" + VerificaEbolloFrontendPortletKeys.UPLOAD_FILES_ACTION_COMMAND }, service = {
				MVCActionCommand.class })
public class UploadFilesMVCActionCommand extends BaseMVCActionCommand{
	
	private static final Log LOG = LogFactoryUtil.getLog(UploadFilesMVCActionCommand.class.getName());
	
	@Reference
	private VerificaEBolloService verificaEBolloService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		File documento = uploadPortletRequest.getFile(VerificaEbolloFrontendPortletKeys.UPLOAD_DOCUMENTO_ATTRIBUTE);
		
		File xmlBollo = uploadPortletRequest.getFile(VerificaEbolloFrontendPortletKeys.UPLOAD_XML_BOLLO_ATTRIBUTE);
		
		actionRequest.setAttribute(VerificaEbolloFrontendPortletKeys.IS_SIGNATURE_VALID, verificaEBolloService.checkSignature(xmlBollo));
		
		actionRequest.setAttribute(VerificaEbolloFrontendPortletKeys.IS_FILE_HASH_MATCH, verificaEBolloService.checkFileHashMatch(themeDisplay.getSiteGroupId(), documento, xmlBollo));
		
		actionRequest.setAttribute(VerificaEbolloFrontendPortletKeys.CHECK_DONE_ATTRIBUTE, true);
		
		actionResponse.getRenderParameters().setValue("mvcPath", "/view.jsp");
	}

}