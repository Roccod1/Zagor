package it.servizidigitali.gestioneforms.frontend.portlet.resource;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;

/**
 * @author COSTABILEE
 *
 */
@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + GestioneFormsPortletKeys.GESTIONEFORMS,
			"mvc.command.name=/uploadFile"
		}, 
service = { MVCResourceCommand.class }
)
public class UploadAllegatoResourceCommand implements MVCResourceCommand{
	
	public static final Log _log = LogFactoryUtil.getLog(UploadAllegatoResourceCommand.class);
	
	@Reference
	private DLAppLocalService DLappLocalService;

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay= (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		String fileName = uploadRequest.getFileName("file");
		
		File file = uploadRequest.getFile("file");
		byte[] fileByteArray = null;
		
//		String status = "";
//		JsonObject json = new JsonObject();
		
		try {
			serviceContext = ServiceContextFactory.getInstance(resourceRequest);
			fileByteArray = FileUtil.getBytes(file);
			Folder folder = DLappLocalService.addFolder(themeDisplay.getUserId(), themeDisplay.getCompanyGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "", "", serviceContext);
		} catch (Exception e) {
			_log.error(":: uploadAllegatoResourceCommand :: Errore durante l'elaborazione del file!" + e.getMessage());
		}
		

		return false;
	}

}
