package it.servizidigitali.gestionepagamenti.frontend.command.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import it.servizidigitali.gestionepagamenti.frontend.constants.GestionePagamentiFrontendPortletKeys;
import it.servizidigitali.gestionepagamenti.frontend.service.GestionePagamentiService;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.PagamentoLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + GestionePagamentiFrontendPortletKeys.GESTIONEPAGAMENTIFRONTEND,
		"mvc.command.name=" + GestionePagamentiFrontendPortletKeys.CERCA_PAGAMENTI_ACTION_COMMAND }, service = {
				MVCActionCommand.class })
public class CercaPagamentiMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	private GestionePagamentiService gestionePagamentiService;
	
	@Reference
	private PagamentoLocalService pagamentoLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd");

		Date dataInserimentoDa = ParamUtil.getDate(actionRequest,
				GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_DA_CERCA, dateFormat, null);
		Date dataInserimentoA = ParamUtil.getDate(actionRequest,
				GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_A_CERCA, dateFormat, null);
		Date dataOperazioneDa = ParamUtil.getDate(actionRequest,
				GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_DA_CERCA, dateFormat, null);
		Date dataOperazioneA = ParamUtil.getDate(actionRequest,
				GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_A_CERCA, dateFormat, null);

		long siteGroupId = 0;
		
		long organizzazioneId = ParamUtil.getLong(actionRequest,
				GestionePagamentiFrontendPortletKeys.SELECT_ORGANIZZAZIONE_CERCA);
		
		Organization organization = organizzazioneId != 0 ? gestionePagamentiService.getOrganization(organizzazioneId) : null;
		
		if (Validator.isNotNull(organization)) {
			siteGroupId = organization.getGroupId();
		}
		
		String categoria = ParamUtil.getString(actionRequest,
				GestionePagamentiFrontendPortletKeys.SELECT_CATEGORIA_CERCA, null);
		String stato = ParamUtil.getString(actionRequest, GestionePagamentiFrontendPortletKeys.SELECT_STATO_CERCA,
				null);
		String gateway = ParamUtil.getString(actionRequest, GestionePagamentiFrontendPortletKeys.SELECT_GATEWAY_CERCA,
				null);
		String canale = ParamUtil.getString(actionRequest, GestionePagamentiFrontendPortletKeys.SELECT_CANALE_CERCA,
				null);
		String codiceFiscale = ParamUtil.getString(actionRequest, GestionePagamentiFrontendPortletKeys.CODICE_FISCALE_CERCA, null);
		String identificativoPagamento = ParamUtil.getString(actionRequest,
				GestionePagamentiFrontendPortletKeys.IDENTIFICATIVO_PAGAMENTO_CERCA, null);
		String codiceIuv = ParamUtil.getString(actionRequest, GestionePagamentiFrontendPortletKeys.CODICE_IUV_CERCA,
				null);
		long idPagamento = ParamUtil.getLong(actionRequest, GestionePagamentiFrontendPortletKeys.ID_PAGAMENTO_CERCA);
		
		int cur = GestionePagamentiFrontendPortletKeys.DEFAULT_CUR;
		int delta = GestionePagamentiFrontendPortletKeys.DEFAULT_DELTA;
		
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);

		int inizio = posizioni[0];
		int fine = posizioni[1];
		
		long totalCountPagamenti = pagamentoLocalService.countByFilters(dataInserimentoDa, dataInserimentoA, dataOperazioneDa, dataOperazioneA, siteGroupId, categoria, stato, gateway, canale, codiceFiscale, identificativoPagamento, codiceIuv, idPagamento);

		List<Pagamento> listaPagamenti = Collections.emptyList();
		
		if(totalCountPagamenti != 0) {
			listaPagamenti = pagamentoLocalService.search(dataInserimentoDa, dataInserimentoA,
					dataOperazioneDa, dataOperazioneA, siteGroupId, categoria, stato, gateway, canale, codiceFiscale,
					identificativoPagamento, codiceIuv, idPagamento, inizio, fine, null, null);
			listaPagamenti.forEach(pagamento -> gestionePagamentiService.initDataForView(pagamento));
		}

		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.TOTAL_COUNT_PAGAMENTI, totalCountPagamenti);
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.LISTA_PAGAMENTI, listaPagamenti);
		actionRequest.setAttribute(SearchContainer.DEFAULT_CUR_PARAM, cur);
		actionRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, delta);
		
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_DA_CERCA, dataInserimentoDa == null ? null : dateFormat.format(dataInserimentoDa));
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_A_CERCA, dataInserimentoA == null ? null : dateFormat.format(dataInserimentoA));
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_DA_CERCA, dataOperazioneDa == null ? null : dateFormat.format(dataOperazioneDa));
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_A_CERCA, dataOperazioneA == null ? null : dateFormat.format(dataOperazioneA));
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_ORGANIZZAZIONE_CERCA, organizzazioneId);
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_CATEGORIA_CERCA, categoria);
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_STATO_CERCA, stato);
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_GATEWAY_CERCA, gateway);
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_CANALE_CERCA, canale);
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.CODICE_FISCALE_CERCA, codiceFiscale);
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.IDENTIFICATIVO_PAGAMENTO_CERCA, identificativoPagamento);
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.CODICE_IUV_CERCA, codiceIuv);
		actionRequest.setAttribute(GestionePagamentiFrontendPortletKeys.ID_PAGAMENTO_CERCA, idPagamento != 0 ? idPagamento : null);

		actionResponse.getRenderParameters().setValue("mvcPath", "/view.jsp");
	}

}