package it.servizidigitali.presentatoreforms.frontend.portlet.resource;

import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaDatasource;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;

@Component(immediate = true, property = { //
		"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
		"mvc.command.name=" + PresentatoreFormsPortletKeys.COMUNE_RESOURCE_COMMAND //
}, service = { MVCResourceCommand.class })
public class ComuneResourceCommand extends BaseMVCResourceCommand {
	
	public static final Log log = LogFactoryUtil.getLog(ComuneResourceCommand.class);
	
	@Reference
	private ComuneLocalService comuneLocalService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		try {
			List<Comune> allComuni = comuneLocalService.getComunes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<AlpacaDatasource> lst = new ArrayList<AlpacaDatasource>();
			
			for(Comune comune : allComuni) {
				AlpacaDatasource alpacaDatasource = new AlpacaDatasource();
				alpacaDatasource.setText(comune.getDenominazione());
				alpacaDatasource.setValue(comune.getCodiceIstatAN());
				lst.add(alpacaDatasource);
			}
			
			Gson gson = new Gson();
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			String jsonstring = gson.toJson(lst);
			resourceResponse.getWriter().write(jsonstring);
		}catch(Exception e) {
			log.error("comuneResourceCommand :: errore durante il recupero dei comuni! " + e.getMessage(),e);
		}
		
	}

}
