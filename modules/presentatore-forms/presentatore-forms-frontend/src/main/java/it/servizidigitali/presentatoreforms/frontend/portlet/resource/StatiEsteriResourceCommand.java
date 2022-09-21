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

import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaDatasource;

@Component(immediate = true, property = { //
		"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
		"mvc.command.name=" + PresentatoreFormsPortletKeys.STATI_ESTERI_RESOURCE_COMMAND //
}, service = { MVCResourceCommand.class })
public class StatiEsteriResourceCommand extends BaseMVCResourceCommand  {
	
	public static final Log log = LogFactoryUtil.getLog(StatiEsteriResourceCommand.class);
	
	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
	
		try {
			List<StatoEstero> allStati = statoEsteroLocalService.getStatoEsteros(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<AlpacaDatasource> lst = new ArrayList<AlpacaDatasource>();
			
			for(StatoEstero statoEstero : allStati) {
				AlpacaDatasource alpacaDatasource = new AlpacaDatasource();
				alpacaDatasource.setText(statoEstero.getDenominazione());
				alpacaDatasource.setValue(String.valueOf(statoEstero.getCodiceStato()));
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
