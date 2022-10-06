package it.servizidigitali.scrivaniacittadino.frontend.portlet.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.file.utility.factory.FileServiceFactory;
import it.servizidigitali.file.utility.model.File;
import it.servizidigitali.file.utility.service.FileService;
import it.servizidigitali.scrivaniacittadino.frontend.constants.ScrivaniaCittadinoPortletKeys;

/**
 * @author filierim
 */

@Component(immediate = true, 
		property = { 
				"javax.portlet.name=" + ScrivaniaCittadinoPortletKeys.SCRIVANIACITTADINO, 
				"mvc.command.name=" + ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_DOWNLOAD_FILE
		}, 
		service = MVCResourceCommand.class
)
public class DownloadAllegatoResourceCommand extends BaseMVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(DownloadAllegatoResourceCommand.class);

	@Reference
	private FileServiceFactory fileServiceFactory;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

		String fileId = ParamUtil.getString(resourceRequest, ScrivaniaCittadinoPortletKeys.PARAM_FILE_ID);
		
		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		FileService fileService = null;
		if(Validator.isNotNull(fileId)) {
			serviceContext = ServiceContextFactory.getInstance(resourceRequest);
			themeDisplay = serviceContext.getThemeDisplay();
			long groupId = themeDisplay.getSiteGroup().getGroupId();
			
			try {
				fileService = fileServiceFactory.getActiveFileService();

				if (fileService != null) {
					File requestFile = fileService.getRequestFile(fileId, themeDisplay.getScopeGroupId());

					if(requestFile != null) {
						PortletResponseUtil.sendFile(resourceRequest, resourceResponse, requestFile.getNome(), requestFile.getInputStream().readAllBytes(), requestFile.getMimeType());						
					}
				}
			} catch (Exception e) {
				_log.error("Impossibile ottenere il file [fileId: " + fileId + "] :: " + e.getMessage(), e);
			}
		}
	}
}