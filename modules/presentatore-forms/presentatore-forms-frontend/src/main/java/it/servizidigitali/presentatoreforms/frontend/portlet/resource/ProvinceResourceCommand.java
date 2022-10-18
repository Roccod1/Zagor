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

import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.service.ProvinciaLocalService;
import it.servizidigitali.presentatoreforms.common.model.ProvinceDatasource;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;

@Component(immediate = true, property = { //
		"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
		"mvc.command.name=" + PresentatoreFormsPortletKeys.PROVINCE_RESOURCE_COMMAND //
}, service = { MVCResourceCommand.class })
public class ProvinceResourceCommand extends BaseMVCResourceCommand {
	
	public static final Log log = LogFactoryUtil.getLog(ProvinceResourceCommand.class);
	
	@Reference
	private ProvinciaLocalService provinciaLocalService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		try {
			List<Provincia> allProvince = provinciaLocalService.getProvincias(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<ProvinceDatasource> lst = new ArrayList<ProvinceDatasource>();
			
			for(Provincia provincia : allProvince) {
				ProvinceDatasource alpacaDatasource = new ProvinceDatasource();
				alpacaDatasource.setText(provincia.getDenominazioneProvincia());
				alpacaDatasource.setValue(provincia.getSigla());
				alpacaDatasource.setIdProvincia(provincia.getProvinciaId());
				lst.add(alpacaDatasource);
			}
			
			Gson gson = new Gson();
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			String jsonstring = gson.toJson(lst);
			resourceResponse.getWriter().write(jsonstring);
		}catch(Exception e) {
			log.error("provinceResourceCommand :: errore durante il recupero delle province! " + e.getMessage(),e);
		}
		
	}

}
