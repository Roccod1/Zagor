package it.servizidigitali.gestioneforms.frontend.portlet.resource;

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

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;

@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + GestioneFormsPortletKeys.GESTIONEFORMS,
			"mvc.command.name=/uploadFile" 
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
				long idTemporaneoAllegato = definizioneAllegatoLocalService.uploadAllegatoTemporaneo(file);
				
				if(Validator.isNotNull(idTemporaneoAllegato)) {
					json.put(GestioneFormsPortletKeys.DEFINIZIONE_ALLEGATO_ID_TEMPORANEO, idTemporaneoAllegato);
					json.put(GestioneFormsPortletKeys.STATUS, GestioneFormsPortletKeys.STATUS_OK);
				}
			}
		}catch(Exception e) {
			_log.error("GestioneForms :: uploadAllegatoResourceCommand :: " + e.getMessage());
			json.put(GestioneFormsPortletKeys.STATUS, GestioneFormsPortletKeys.STATUS_ERROR);
		}
		
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		resourceResponse.getWriter().print(json.toString());
		
		
		
	}

}
