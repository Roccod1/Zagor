package it.servizidigitali.scrivaniaoperatore.frontend.portlet.resource;

import java.io.File;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Portal;

import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;

@Component(immediate = true, service = MVCResourceCommand.class, property = {
		"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE,
		"mvc.command.name=/resource/uploadAllegato"
})
public class UploadAllegatoResourceCommand extends BaseMVCResourceCommand {

	@Reference
	private Portal portal;
	@Reference
	private DLAppService dlAppService;
	
	@Override
	protected void doServeResource(ResourceRequest request, ResourceResponse response)
			throws Exception {
		try {
			ServiceContext context = ServiceContextFactory.getInstance(request);
			
			UploadPortletRequest upr = portal.getUploadPortletRequest(request);
			File file = upr.getFile("allegato");
			String fileName = upr.getFileName("allegato");
			String contentType = upr.getContentType("allegato");
			
			//TODO rimpiazzare con service adeguato
			FileEntry fileEntry = dlAppService.addFileEntry(
					"", 
					context.getScopeGroupId(), 
					0, 
					fileName, 
					contentType, 
					fileName, 
					"", 
					"", 
					"", 
					file, 
					null, 
					null, 
					context);
			
			long fileId = fileEntry.getFileEntryId();
			
			response.getWriter().write("{ \"fileId\": " + fileId + " }");
		} catch (Exception e) {
			response.getWriter().write("{ \"error\": \"error\" }");
		}
	}

}
