package it.servizidigitali.scrivaniacittadino.frontend.portlet.resource;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionecomunicazioni.model.Comunicazione;
import it.servizidigitali.scrivaniacittadino.frontend.constants.ScrivaniaCittadinoPortletKeys;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

/**
 * @author filierim
 */

@Component(immediate = true, 
		property = { 
				"javax.portlet.name=" + ScrivaniaCittadinoPortletKeys.SCRIVANIACITTADINO, 
				"mvc.command.name=" + ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_GET_RICHIESTE
		}, 
		service = MVCResourceCommand.class
)
public class GetRichiesteCittadinoResourceCommand extends BaseMVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(GetRichiesteCittadinoResourceCommand.class);

	@Reference
	private RichiestaLocalService richiestaLocalService;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

	       Map<String, Object> responseMap = new HashMap<String, Object>();
		   ServiceContext serviceContext = null;
		   ThemeDisplay themeDisplay = null;
		   boolean hasNext = false;
		
		   int cur = ParamUtil.getInteger(resourceRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
////	       int delta = ParamUtil.getInteger(resourceRequest, SearchContainer.DEFAULT_DELTA_PARAM);
		   String sortName = ParamUtil.getString(resourceRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		   String sortType = ParamUtil.getString(resourceRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
	
		   List<Richiesta> listaRichieste = new ArrayList<Richiesta>();
		   
		   try {        	   
				serviceContext = ServiceContextFactory.getInstance(resourceRequest);
				themeDisplay = serviceContext.getThemeDisplay();
				User loggedUser = themeDisplay.getUser();
				
				listaRichieste = richiestaLocalService.getRichiesteByCodiceFiscaleUtenteAndOrganizationGroupid(loggedUser.getScreenName(), themeDisplay.getSiteGroup().getOrganizationId(), cur, ScrivaniaCittadinoPortletKeys.DEFAULT_DELTA, sortName, sortType);

				List<Richiesta> paginaSuccessiva = richiestaLocalService.getRichiesteByCodiceFiscaleUtenteAndOrganizationGroupid(loggedUser.getScreenName(), themeDisplay.getSiteGroup().getOrganizationId(), cur + 1, ScrivaniaCittadinoPortletKeys.DEFAULT_DELTA, sortName, sortType);

				if(Validator.isNotNull(paginaSuccessiva) && !paginaSuccessiva.isEmpty()) {
					hasNext = true;
				}
		   }catch(Exception e) {
			   _log.error("doServeResource() :: "+e.getMessage(), e);
			   throw new Exception(e);
		   }
		   
		   responseMap.put("listaRichieste", listaRichieste);
		   responseMap.put("hasNext", hasNext);
		   responseMap.put("cur", cur);
		   String jsonObject = JSONFactoryUtil.looseSerializeDeep(responseMap);
		   resourceResponse.getWriter().write(jsonObject);
	}
}