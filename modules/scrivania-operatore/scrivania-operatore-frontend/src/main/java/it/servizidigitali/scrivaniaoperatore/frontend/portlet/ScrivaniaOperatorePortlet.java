package it.servizidigitali.scrivaniaoperatore.frontend.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.camunda.integration.client.exception.CamundaClientException;
import it.servizidigitali.camunda.integration.client.model.Task;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.RichiestaDTO;
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
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private MapUtil mapUtil;

	@Reference
	private CamundaClient camundaClient;

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

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

		filters.setProcedureIds(getProcedureIds(ctx));

		int count = richiestaLocalService.count(filters);
		List<RichiestaDTO> elems = richiestaLocalService.search(filters, start, end).stream().map(x -> mapUtil.mapRichiesta(ctx.getCompanyId(), x)).collect(Collectors.toList());

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

		super.render(request, response);
	}

	/**
	 * @param ctx
	 * @return
	 */
	private Set<Long> getProcedureIds(ServiceContext ctx) {

		try {
			// TODO questi sono i servizi che è possibile utilizzare nella ricerca
			List<ServizioEnte> serviziEnte = servizioEnteLocalService.getServiziEnteByOrganizationIdSubOrganizationIdsAttivo(ctx.getScopeGroup().getOrganizationId(), getSubOrganizationIds(ctx), true,
					ctx.getScopeGroupId(), ctx.getCompanyId());

			List<Long> serviziEnteIds = serviziEnte.stream().map(ServizioEnte::getServizioId).collect(Collectors.toList());

			List<Procedura> procedure = proceduraLocalService.getProcedureByServiziIdsGroupIdAttiva(serviziEnteIds, ctx.getScopeGroupId(), true);

			return procedure.stream().map(Procedura::getProceduraId).collect(Collectors.toSet());
		}
		catch (PortalException e) {
			log.error("getProcedureIds :: " + e.getMessage(), e);
		}

		return null;
	}

	private Set<String> getProcessInstanceIds(ServiceContext ctx) {
		try {
			List<Long> organizationIds = getSubOrganizationIds(ctx);

			List<String> organizationIdsStrings = organizationIds.stream().map(Object::toString).collect(Collectors.toList());

			List<Task> searchTasks = camundaClient.searchTasks(String.valueOf(ctx.getScopeGroup().getOrganizationId()), organizationIdsStrings, null, false);

			Set<String> processInstanceIds = searchTasks.stream().map(Task::getProcessInstanceId).collect(Collectors.toSet());
			return processInstanceIds;
		}
		catch (PortalException e1) {
			log.error("render :: " + e1.getMessage(), e1);
		}
		catch (CamundaClientException e1) {
			log.error("render :: " + e1.getMessage(), e1);
		}
		return null;
	}

	/**
	 * @param ctx
	 * @return
	 * @throws PortalException
	 */
	private List<Long> getSubOrganizationIds(ServiceContext ctx) throws PortalException {
		Organization currentOrganization = organizationLocalService.getOrganization(ctx.getScopeGroup().getOrganizationId());
		List<Long> organizationIds = currentOrganization.getSuborganizations().stream().map(Organization::getOrganizationId).collect(Collectors.toList());
		return organizationIds;
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