package it.servizidigitali.scrivaniacittadino.frontend.portlet.resource;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
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

import it.servizidigitali.scrivaniacittadino.frontend.constants.ScrivaniaCittadinoPortletKeys;
import it.servizidigitali.scrivaniacittadino.frontend.service.ScrivaniaCittadinoMiddlewareService;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters;
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
	
	@Reference
	private ScrivaniaCittadinoMiddlewareService scirvaniaCittadinoMiddlewareService;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

	       Map<String, Object> responseMap = new HashMap<String, Object>();
		   ServiceContext serviceContext = null;
		   ThemeDisplay themeDisplay = null;
		   boolean hasNext = false;
		
		   int cur = ParamUtil.getInteger(resourceRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
//	       int delta = ParamUtil.getInteger(resourceRequest, SearchContainer.DEFAULT_DELTA_PARAM);
		   String sortName = ParamUtil.getString(resourceRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		   String sortType = ParamUtil.getString(resourceRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
		   String filterOggettoNoteRichieste = ParamUtil.getString(resourceRequest, ScrivaniaCittadinoPortletKeys.FILTER_OGGETTO_RICHIESTE);
		   String filterStatoRichieste = ParamUtil.getString(resourceRequest, ScrivaniaCittadinoPortletKeys.FILTER_STATO_RICHIESTE);
		   
		   List<Richiesta> listaRichieste = new ArrayList<Richiesta>();
		   List<Richiesta> listaRichiesteModificabile = null;
		   try {        	   
				serviceContext = ServiceContextFactory.getInstance(resourceRequest);
				themeDisplay = serviceContext.getThemeDisplay();
				User loggedUser = themeDisplay.getUser();
				
				RichiestaFilters richiestaFilter = new RichiestaFilters();
				richiestaFilter.setCodiceFiscale(loggedUser.getScreenName());
				richiestaFilter.setCompanyId(themeDisplay.getSiteGroup().getCompanyId());
				richiestaFilter.setGroupId(themeDisplay.getSiteGroup().getGroupId());
				
				if(Validator.isNotNull(filterOggettoNoteRichieste)) {
					richiestaFilter.setOggettoNote(filterOggettoNoteRichieste);					
				}
				
				if(Validator.isNotNull(filterStatoRichieste)) {
					richiestaFilter.setTipo(filterStatoRichieste);					
				}
				
				if(Validator.isNotNull(sortName)) {
					richiestaFilter.setOrderByCol(sortName);					
				}
				
				if(Validator.isNotNull(sortType)) {
					richiestaFilter.setOrderByType(sortType);					
				}
				
				int startEnd[] = calcolaStartEnd(cur, ScrivaniaCittadinoPortletKeys.DEFAULT_DELTA);
				listaRichieste =  richiestaLocalService.search(richiestaFilter, startEnd[0], startEnd[1]);
				
				startEnd = calcolaStartEnd(cur + 1, ScrivaniaCittadinoPortletKeys.DEFAULT_DELTA);
				List<Richiesta> paginaSuccessiva = richiestaLocalService.getRichiesteByCodiceFiscaleUtenteAndOrganizationGroupid(loggedUser.getScreenName(), themeDisplay.getSiteGroup().getOrganizationId(), cur + 1, ScrivaniaCittadinoPortletKeys.DEFAULT_DELTA, sortName, sortType);

				List<Richiesta> pagamenti = scirvaniaCittadinoMiddlewareService.getPagamentiUtente(
						loggedUser.getScreenName(), 
						"", "", 
						themeDisplay.getSiteGroup().getCompanyId(), 
						themeDisplay.getSiteGroup().getOrganizationId(), 
						themeDisplay.getSiteGroup().getGroupId(), 
						true, 0, 0, "", "");
						
				listaRichiesteModificabile = new ArrayList<Richiesta>(listaRichieste);
				
				for(Richiesta pagamento:pagamenti) {
					if(listaRichiesteModificabile.contains(pagamento)) {
						listaRichiesteModificabile.remove(pagamento);
					}
				}
				
				if(Validator.isNotNull(paginaSuccessiva) && !paginaSuccessiva.isEmpty()) {
					hasNext = true;
				}
		   }catch(Exception e) {
			   _log.error("doServeResource() :: "+e.getMessage(), e);
			   throw new Exception(e);
		   }
		   
		   responseMap.put("listaRichieste", listaRichiesteModificabile != null && !listaRichiesteModificabile.isEmpty() ? listaRichiesteModificabile : listaRichieste);
		   responseMap.put("hasNext", hasNext);
		   responseMap.put("cur", cur);
		   String jsonObject = JSONFactoryUtil.looseSerializeDeep(responseMap);
		   resourceResponse.getWriter().write(jsonObject);
	}
	
	private int[] calcolaStartEnd(int cur, int delta) {
		int startEnd[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		if (startEnd[0] <= 0 || startEnd[1] <= 0) {
			startEnd[0] = QueryUtil.ALL_POS;
			startEnd[1] = QueryUtil.ALL_POS;
		}
		return startEnd;
	}
}