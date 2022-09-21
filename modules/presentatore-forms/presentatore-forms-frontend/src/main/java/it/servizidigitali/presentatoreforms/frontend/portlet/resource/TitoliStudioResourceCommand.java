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

import it.servizidigitali.backoffice.integration.enums.TitoloStudio;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaDatasource;

@Component(immediate = true, property = { //
		"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
		"mvc.command.name=" + PresentatoreFormsPortletKeys.TITOLI_STUDIO_RESOURCE_COMMAND //
}, service = { MVCResourceCommand.class })
public class TitoliStudioResourceCommand extends BaseMVCResourceCommand  {
	
	public static final Log log = LogFactoryUtil.getLog(TitoliStudioResourceCommand.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		TitoloStudio[] titoliStudio = TitoloStudio.values();
		List<AlpacaDatasource> lst = new ArrayList<AlpacaDatasource>();
		
		for(TitoloStudio titoloStudio : titoliStudio) {
			AlpacaDatasource alpacaDatasource = new AlpacaDatasource();
			alpacaDatasource.setText(titoloStudio.getDescrizione());
			alpacaDatasource.setValue(titoloStudio.getCodice());
			lst.add(alpacaDatasource);
		}
		
		Gson gson = new Gson();
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		String jsonstring = gson.toJson(lst);
		resourceResponse.getWriter().write(jsonstring);
		
	}

}
