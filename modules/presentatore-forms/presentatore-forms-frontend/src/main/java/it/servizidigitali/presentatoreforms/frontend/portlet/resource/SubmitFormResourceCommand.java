package it.servizidigitali.presentatoreforms.frontend.portlet.resource;

import com.liferay.portal.kernel.json.JSONDeserializer;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;


@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=/submitForm" 
		}, 
service = { MVCResourceCommand.class }
)
public class SubmitFormResourceCommand  extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);

		
		String dataForm = ParamUtil.getString(resourceRequest, "dataForm");
		boolean caricaBozza = ParamUtil.getBoolean(resourceRequest, "caricaBozza");
		
		String status = null;
		
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		JSONDeserializer<AlpacaJsonStructure> des = JSONFactoryUtil.createJSONDeserializer();
		
		AlpacaJsonStructure alpacaStructure = des.deserialize(dataForm,AlpacaJsonStructure.class);
		
		

		
		
		json.put("status", status);
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		resourceResponse.getWriter().print(json.toString());
		
		
	}

}
