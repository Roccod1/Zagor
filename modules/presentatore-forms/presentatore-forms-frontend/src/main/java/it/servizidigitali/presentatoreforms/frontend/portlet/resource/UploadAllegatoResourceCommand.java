package it.servizidigitali.presentatoreforms.frontend.portlet.resource;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;

@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=" + PresentatoreFormsPortletKeys.UPLOAD_ALLEGATO_RESOURCE_COMMAND
		}, 
service = { MVCResourceCommand.class }
)
public class UploadAllegatoResourceCommand extends BaseMVCResourceCommand{
	
	public static final Log _log = LogFactoryUtil.getLog(UploadAllegatoResourceCommand.class);
	
	@Reference
    private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		File file = uploadPortletRequest.getFile("attachmentFile");
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		try {
			if(Validator.isNotNull(file)) {
				long idTemporaneoAllegato = 0;
				
				if(Validator.isNotNull(idTemporaneoAllegato)) {
					json.put(PresentatoreFormsPortletKeys.DEFINIZIONE_ALLEGATO_ID_TEMPORANEO, idTemporaneoAllegato);
					json.put(PresentatoreFormsPortletKeys.STATUS, PresentatoreFormsPortletKeys.STATUS_OK);
				}
			}
		}catch(Exception e) {
			_log.error("GestioneForms :: uploadAllegatoResourceCommand :: " + e.getMessage());
			json.put(PresentatoreFormsPortletKeys.STATUS, PresentatoreFormsPortletKeys.STATUS_ERROR);
		}
		
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		resourceResponse.getWriter().print(json.toString());
		
		
	}

}
