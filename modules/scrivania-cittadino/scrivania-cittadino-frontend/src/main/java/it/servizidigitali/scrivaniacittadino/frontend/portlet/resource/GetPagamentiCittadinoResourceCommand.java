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
import it.servizidigitali.scrivaniacittadino.frontend.service.ScrivaniaCittadinoMiddlewareService;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

/**
 * @author filierim
 */

@Component(immediate = true, property = { "javax.portlet.name=" + ScrivaniaCittadinoPortletKeys.SCRIVANIACITTADINO,
		"mvc.command.name="
				+ ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_GET_PAGAMENTI }, service = MVCResourceCommand.class)
public class GetPagamentiCittadinoResourceCommand extends BaseMVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(GetPagamentiCittadinoResourceCommand.class);

	@Reference
	private ScrivaniaCittadinoMiddlewareService scrivaniaCittadinoMiddlewareService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		List<Richiesta> listaPagamenti = new ArrayList<Richiesta>();

		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		boolean hasNext = false;

		int cur = ParamUtil.getInteger(resourceRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
//	       int delta = ParamUtil.getInteger(resourceRequest, SearchContainer.DEFAULT_DELTA_PARAM);
		String sortName = ParamUtil.getString(resourceRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String sortType = ParamUtil.getString(resourceRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
		String filterStatoPagamento = ParamUtil.getString(resourceRequest, ScrivaniaCittadinoPortletKeys.FILTER_STATO_PAGAMENTO);
		String filterOggettoNote = ParamUtil.getString(resourceRequest, ScrivaniaCittadinoPortletKeys.FILTER_OGGETTO_PAGAMENTO);
		try {
			serviceContext = ServiceContextFactory.getInstance(resourceRequest);
			themeDisplay = serviceContext.getThemeDisplay();
			User loggedUser = themeDisplay.getUser();

			listaPagamenti = scrivaniaCittadinoMiddlewareService.getPagamentiUtente(loggedUser.getScreenName(),
					filterOggettoNote, filterStatoPagamento, themeDisplay.getCompanyId(), themeDisplay.getSiteGroup().getOrganizationId(),
					themeDisplay.getSiteGroup().getGroupId(), true, cur, ScrivaniaCittadinoPortletKeys.DEFAULT_DELTA, sortName, sortType);

			List<Richiesta> paginaSuccessiva = scrivaniaCittadinoMiddlewareService.getPagamentiUtente(
					loggedUser.getScreenName(), filterOggettoNote, filterStatoPagamento, themeDisplay.getCompanyId(),
					themeDisplay.getSiteGroup().getOrganizationId(), themeDisplay.getSiteGroup().getGroupId(), true,
					cur + 1, ScrivaniaCittadinoPortletKeys.DEFAULT_DELTA, sortName, sortType);
			if (Validator.isNotNull(paginaSuccessiva) && !paginaSuccessiva.isEmpty()) {
				hasNext = true;
			}
		} catch (Exception e) {
			_log.error("doServeResource() :: " + e.getMessage(), e);
			throw new Exception(e);
		}

		responseMap.put("listaPagamenti", listaPagamenti);
		responseMap.put("hasNext", hasNext);
		responseMap.put("cur", cur);
		String jsonObject = JSONFactoryUtil.looseSerializeDeep(responseMap);
		resourceResponse.getWriter().write(jsonObject);
	}

}