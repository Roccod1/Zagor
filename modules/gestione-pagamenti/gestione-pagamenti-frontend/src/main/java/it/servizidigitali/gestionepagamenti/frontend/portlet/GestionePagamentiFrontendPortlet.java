package it.servizidigitali.gestionepagamenti.frontend.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionepagamenti.frontend.constants.GestionePagamentiFrontendPortletKeys;
import it.servizidigitali.gestionepagamenti.frontend.service.GestionePagamentiService;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.PagamentoLocalService;

/**
 * @author pindi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servizidigitali",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GestionePagamentiFrontend",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GestionePagamentiFrontendPortletKeys.GESTIONEPAGAMENTIFRONTEND,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GestionePagamentiFrontendPortlet extends MVCPortlet {
	
	@Reference
	private GestionePagamentiService gestionePagamentiService;
	
	@Reference
	private PagamentoLocalService pagamentoLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long siteOrganizationId = themeDisplay.getSiteGroup().getOrganizationId(); 
		
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SITE_ORGANIZATION_ID, siteOrganizationId);
		
		long siteGroupId = 0;
		
		if (siteOrganizationId == 0) { //MAIN SITE
			
			List<Organization> listaOrganizzazioni = gestionePagamentiService.getAllParentsOrganizations();
			
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.LISTA_ORGANIZZAZIONI, listaOrganizzazioni);
			
		} else { //SPECIFIC SITE
			siteGroupId = themeDisplay.getSiteGroupId();
		}
		
		List<Pagamento> listaPagamenti = (List<Pagamento>) renderRequest.getAttribute(GestionePagamentiFrontendPortletKeys.LISTA_PAGAMENTI);
		
		if (Validator.isNull(listaPagamenti)) {
			
			DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd");

			Date dataInserimentoDa = ParamUtil.getDate(renderRequest,
					GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_DA_CERCA, dateFormat, null);
			Date dataInserimentoA = ParamUtil.getDate(renderRequest,
					GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_A_CERCA, dateFormat, null);
			Date dataOperazioneDa = ParamUtil.getDate(renderRequest,
					GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_DA_CERCA, dateFormat, null);
			Date dataOperazioneA = ParamUtil.getDate(renderRequest,
					GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_A_CERCA, dateFormat, null);

			long organizzazioneId = ParamUtil.getLong(renderRequest,
					GestionePagamentiFrontendPortletKeys.SELECT_ORGANIZZAZIONE_CERCA);
			
			Organization organization = organizzazioneId != 0 ? gestionePagamentiService.getOrganization(organizzazioneId) : null;
			
			if (Validator.isNotNull(organization)) {
				siteGroupId = organization.getGroupId();
			}
			
			String categoria = ParamUtil.getString(renderRequest,
					GestionePagamentiFrontendPortletKeys.SELECT_CATEGORIA_CERCA, null);
			String stato = ParamUtil.getString(renderRequest, GestionePagamentiFrontendPortletKeys.SELECT_STATO_CERCA,
					null);
			String gateway = ParamUtil.getString(renderRequest, GestionePagamentiFrontendPortletKeys.SELECT_GATEWAY_CERCA,
					null);
			String canale = ParamUtil.getString(renderRequest, GestionePagamentiFrontendPortletKeys.SELECT_CANALE_CERCA,
					null);
			String codiceFiscale = ParamUtil.getString(renderRequest, GestionePagamentiFrontendPortletKeys.CODICE_FISCALE_CERCA, null);
			String identificativoPagamento = ParamUtil.getString(renderRequest,
					GestionePagamentiFrontendPortletKeys.IDENTIFICATIVO_PAGAMENTO_CERCA, null);
			String codiceIuv = ParamUtil.getString(renderRequest, GestionePagamentiFrontendPortletKeys.CODICE_IUV_CERCA,
					null);
			long idPagamento = ParamUtil.getLong(renderRequest, GestionePagamentiFrontendPortletKeys.ID_PAGAMENTO_CERCA);
			
			int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, GestionePagamentiFrontendPortletKeys.DEFAULT_CUR);
			int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, GestionePagamentiFrontendPortletKeys.DEFAULT_DELTA);
			
			int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);

			int inizio = posizioni[0];
			int fine = posizioni[1];
			
			String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
			String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
			
			long totalCountPagamenti = pagamentoLocalService.countByFilters(dataInserimentoDa, dataInserimentoA, dataOperazioneDa, dataOperazioneA, siteGroupId, categoria, stato, gateway, canale, codiceFiscale, identificativoPagamento, codiceIuv, idPagamento);

			listaPagamenti = Collections.emptyList();
			
			if(totalCountPagamenti != 0) {
				listaPagamenti = pagamentoLocalService.search(dataInserimentoDa, dataInserimentoA, dataOperazioneDa, dataOperazioneA, siteGroupId, categoria, stato, gateway, canale, codiceFiscale, identificativoPagamento, codiceIuv, idPagamento, inizio, fine, orderByCol, orderByType);
				listaPagamenti.forEach(pagamento -> gestionePagamentiService.initAdditionalData(pagamento));
			}

			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.TOTAL_COUNT_PAGAMENTI, totalCountPagamenti);
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.LISTA_PAGAMENTI, listaPagamenti);
			
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_DA_CERCA, dataInserimentoDa == null ? null : dateFormat.format(dataInserimentoDa));
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_A_CERCA, dataInserimentoA == null ? null : dateFormat.format(dataInserimentoA));
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_DA_CERCA, dataOperazioneDa == null ? null : dateFormat.format(dataOperazioneDa));
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_A_CERCA, dataOperazioneA == null ? null : dateFormat.format(dataOperazioneA));
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_ORGANIZZAZIONE_CERCA, organizzazioneId);
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_CATEGORIA_CERCA, categoria);
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_STATO_CERCA, stato);
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_GATEWAY_CERCA, gateway);
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_CANALE_CERCA, canale);
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.CODICE_FISCALE_CERCA, codiceFiscale);
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.IDENTIFICATIVO_PAGAMENTO_CERCA, identificativoPagamento);
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.CODICE_IUV_CERCA, codiceIuv);
			renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.ID_PAGAMENTO_CERCA, idPagamento != 0 ? idPagamento : null);
			
			renderRequest.setAttribute(SearchContainer.DEFAULT_CUR_PARAM, cur);
			renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, delta);
			renderRequest.setAttribute(SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, orderByCol);
			renderRequest.setAttribute(SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, orderByType);
		}
		
		super.render(renderRequest, renderResponse);
	}
	
	
}