package it.servizidigitali.scrivaniaoperatore.frontend.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.camunda.integration.client.model.Task;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.RichiestaDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.ServizioDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.service.ScrivaniaOperatoreFrontendService;
import it.servizidigitali.scrivaniaoperatore.frontend.util.MapUtil;
import it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

/**
 * @author pindi
 */
@Component(//
		immediate = true, //
		property = { //
				"com.liferay.portlet.display-category=category.servizidigitali", //
				"com.liferay.portlet.header-portlet-css=/css/main.css", //
				"com.liferay.portlet.instanceable=true", //
				"javax.portlet.display-name=Scrivania Operatore", //
				"javax.portlet.init-param.template-path=/", //
				"javax.portlet.init-param.view-template=/view.jsp", //
				"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE, //
				"javax.portlet.resource-bundle=content.Language", //
				"javax.portlet.security-role-ref=power-user,user"//
		}, //
		service = Portlet.class//
) //
public class ScrivaniaOperatorePortlet extends MVCPortlet {

	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

	private static final Log log = LogFactoryUtil.getLog(ScrivaniaOperatorePortlet.class.getName());

	@Reference
	private RichiestaLocalService richiestaLocalService;
	@Reference
	private ScrivaniaOperatoreFrontendService scrivaniaOperatoreFrontendService;
	@Reference
	private MapUtil mapUtil;

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		boolean isMain = ParamUtil.getBoolean(request, "isMain", true);

		if (isMain) {
			try {
				renderMain(request);
			} catch (Exception e) {
				log.error(e);
				SessionErrors.add(request, "errore-generico");
			}
		}

		super.render(request, response);
	}

	private void renderMain(RenderRequest request) {
		String queryTab = ParamUtil.getString(request, "queryTab", ScrivaniaOperatorePortletKeys.TAB_ARRIVO);
		int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM, 1);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM, 10);
		String queryNome = ParamUtil.getString(request, "queryNome");
		String queryCf = ParamUtil.getString(request, "queryCf");
		String queryRichiestaId = ParamUtil.getString(request, "queryRichiestaId");
		String queryNumProt = ParamUtil.getString(request, "queryNumProt");
		String queryDataRichDa = ParamUtil.getString(request, "queryDataRichDa");
		String queryDataRichA = ParamUtil.getString(request, "queryDataRichA");
		int queryAut = ParamUtil.getInteger(request, "queryAut");
		String queryStato = ParamUtil.getString(request, "queryStato");
		long queryServizio = ParamUtil.getLong(request, "queryServizio", 0);

		ServiceContext ctx;
		try {
			ctx = ServiceContextFactory.getInstance(request);
		}
		catch (PortalException e) {
			throw new RuntimeException(e);
		}

		int[] limits = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		int start = limits[0];
		int end = limits[1];

		RichiestaFilters filters = new RichiestaFilters();
		filters.setGroupId(ctx.getScopeGroupId());
		filters.setCompanyId(ctx.getCompanyId());
		filters.setNomeCognome(queryNome.isBlank() ? null : queryNome.trim());
		filters.setCodiceFiscale(queryCf.isBlank() ? null : queryCf.trim());
		filters.setIdRichiesta(queryRichiestaId.isBlank() ? null : queryRichiestaId.trim());
		filters.setNumeroProtocollo(queryNumProt.isBlank() ? null : queryNumProt.trim());
		try {
			filters.setDataDa(queryDataRichDa.isBlank() ? null : FORMATTER.parse(queryDataRichDa));
			filters.setDataA(queryDataRichA.isBlank() ? null : FORMATTER.parse(queryDataRichA));
		}
		catch (ParseException e) {
			throw new RuntimeException(e);
		}
		filters.setAutenticazione(mapAutenticazione(queryAut));
		filters.setTipo(queryStato.isBlank() ? null : queryStato);

		Map<String, Task> tasksMap;

		switch (queryTab) {
		case ScrivaniaOperatorePortletKeys.TAB_ARRIVO: {
			tasksMap = scrivaniaOperatoreFrontendService.getOrganizationTasks(ctx);
			Set<String> processInstanceIds = scrivaniaOperatoreFrontendService.getProcessInstanceIds(tasksMap);
			filters.setProcessInstanceIds(processInstanceIds);
			break;
		}
		case ScrivaniaOperatorePortletKeys.TAB_CARICO: {
			tasksMap = scrivaniaOperatoreFrontendService.getUserTasks(ctx);
			Set<String> processInstanceIds = scrivaniaOperatoreFrontendService.getProcessInstanceIds(tasksMap);
			filters.setProcessInstanceIds(processInstanceIds);
			break;
		}
		case ScrivaniaOperatorePortletKeys.TAB_ITINERE_CHIUSI: {
			tasksMap = null;
			filters.setProcedureIds(scrivaniaOperatoreFrontendService.getProcedureIds(ctx));
			break;
		}
		default:
			throw new RuntimeException("queryTab");
		}

		if (queryServizio != 0) {
			filters.setProcedureIds(scrivaniaOperatoreFrontendService.getProcedureIds(Arrays.asList(queryServizio), ctx));
		}

		int count = richiestaLocalService.count(filters);
		List<RichiestaDTO> elems = richiestaLocalService.search(filters, start, end).stream().map(x -> mapUtil.mapRichiesta(ctx.getCompanyId(), x)).collect(Collectors.toList());
		if (tasksMap != null) {
			for (RichiestaDTO richiestaDTO : elems) {
				if (richiestaDTO.getProcessInstanceId() != null && tasksMap.containsKey(richiestaDTO.getProcessInstanceId())) {
					Task task = tasksMap.get(richiestaDTO.getProcessInstanceId());
					richiestaDTO.setTaskId(task.getId());
				}
			}
		}

		List<ServizioDTO> servizi = scrivaniaOperatoreFrontendService.getServiziEnte(ctx).stream().map(x -> mapUtil.mapServizio(x)).collect(Collectors.toList());

		request.setAttribute("servizi", servizi);
		request.setAttribute("totale", count);
		request.setAttribute("lista", elems);
		request.setAttribute("stati", StatoRichiesta.values());
		request.setAttribute("queryTab", queryTab);
		request.setAttribute("queryNome", queryNome);
		request.setAttribute("queryCf", queryCf);
		request.setAttribute("queryRichiestaId", queryRichiestaId);
		request.setAttribute("queryNumProt", queryNumProt);
		request.setAttribute("queryDataRichDa", queryDataRichDa);
		request.setAttribute("queryDataRichA", queryDataRichA);
		request.setAttribute("queryAut", queryAut);
		request.setAttribute("queryStato", queryStato);
		request.setAttribute("queryServizio", queryServizio);
	}

	private Boolean mapAutenticazione(int queryAut) {
		switch (queryAut) {
		case ScrivaniaOperatorePortletKeys.AUT_TUTTI:
			return null;
		case ScrivaniaOperatorePortletKeys.AUT_AUTH:
			return true;
		case ScrivaniaOperatorePortletKeys.AUT_GUEST:
			return false;
		default:
			throw new RuntimeException("queryAut");
		}
	}

}