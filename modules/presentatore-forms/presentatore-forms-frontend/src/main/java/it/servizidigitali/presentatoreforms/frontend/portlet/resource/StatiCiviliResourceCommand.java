package it.servizidigitali.presentatoreforms.frontend.portlet.resource;

import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.backoffice.integration.enums.StatoCivile;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaDatasource;

@Component(immediate = true, property = { //
		"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
		"mvc.command.name=" + PresentatoreFormsPortletKeys.STATI_CIVILI_RESOURCE_COMMAND //
}, service = { MVCResourceCommand.class })
public class StatiCiviliResourceCommand extends BaseMVCResourceCommand{
	
	public static final Log log = LogFactoryUtil.getLog(StatiCiviliResourceCommand.class);


	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		StatoCivile[] statiCivili = StatoCivile.values();
		
		List<AlpacaDatasource> lst = new ArrayList<AlpacaDatasource>();
		
		for(StatoCivile statoCivile : statiCivili) {
			AlpacaDatasource alpacaDatasource = new AlpacaDatasource();
			alpacaDatasource.setText(statoCivile.getDescrizione());
			alpacaDatasource.setValue(String.valueOf(statoCivile.getCodice()));
			lst.add(alpacaDatasource);
		}
		
		Gson gson = new Gson();
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		String jsonstring = gson.toJson(lst);
		resourceResponse.getWriter().write(jsonstring);
		
	}

}
