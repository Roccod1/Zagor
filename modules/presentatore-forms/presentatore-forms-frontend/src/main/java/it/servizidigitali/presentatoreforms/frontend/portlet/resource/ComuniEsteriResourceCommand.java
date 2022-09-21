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

import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaDatasource;

@Component(immediate = true, property = { //
		"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
		"mvc.command.name=" + PresentatoreFormsPortletKeys.COMUNI_ESTERI_RESOURCE_COMMAND //
}, service = { MVCResourceCommand.class })
public class ComuniEsteriResourceCommand extends BaseMVCResourceCommand {
	
	public static final Log log = LogFactoryUtil.getLog(ComuniEsteriResourceCommand.class);
	
	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		try {
			List<ComuneEstero> allComuniEsteri = comuneEsteroLocalService.getComuneEsteros(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<AlpacaDatasource> lst = new ArrayList<AlpacaDatasource>();
			
			for(ComuneEstero comuneEstero : allComuniEsteri) {
				AlpacaDatasource alpacaDatasource = new AlpacaDatasource();
				alpacaDatasource.setText(comuneEstero.getDenominazione());
				alpacaDatasource.setValue(String.valueOf(comuneEstero.getCodice()));
				lst.add(alpacaDatasource);
			}
			
			Gson gson = new Gson();
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			String jsonstring = gson.toJson(lst);
			resourceResponse.getWriter().write(jsonstring);
		}catch(Exception e) {
			log.error("statiEsteriResourceCommand :: errore durante il recupero degli stati esteri! " + e.getMessage(),e);
		}
		
	}

}
