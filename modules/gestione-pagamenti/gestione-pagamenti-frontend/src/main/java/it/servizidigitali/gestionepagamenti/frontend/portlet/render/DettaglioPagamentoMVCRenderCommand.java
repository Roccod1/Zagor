package it.servizidigitali.gestionepagamenti.frontend.portlet.render;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.DateFormat;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionepagamenti.frontend.constants.GestionePagamentiFrontendPortletKeys;
import it.servizidigitali.gestionepagamenti.frontend.service.GestionePagamentiService;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.PagamentoLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + GestionePagamentiFrontendPortletKeys.GESTIONEPAGAMENTIFRONTEND,
		"mvc.command.name=" + GestionePagamentiFrontendPortletKeys.DETTAGLIO_PAGAMENTO_RENDER_COMMAND }, service = {
				MVCRenderCommand.class })
public class DettaglioPagamentoMVCRenderCommand implements MVCRenderCommand {
	
	public static final Log LOG = LogFactoryUtil.getLog(DettaglioPagamentoMVCRenderCommand.class);
	
	@Reference
	private PagamentoLocalService pagamentoLocalService;
	
	@Reference
	private GestionePagamentiService gestionePagamentiService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
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
		
		long servizioId = ParamUtil.getLong(renderRequest,
				GestionePagamentiFrontendPortletKeys.SELECT_CATEGORIA_CERCA);
		String stato = ParamUtil.getString(renderRequest, GestionePagamentiFrontendPortletKeys.SELECT_STATO_CERCA,
				null);
		String gateway = ParamUtil.getString(renderRequest, GestionePagamentiFrontendPortletKeys.SELECT_GATEWAY_CERCA,
				null);
		String canale = ParamUtil.getString(renderRequest, GestionePagamentiFrontendPortletKeys.SELECT_CANALE_CERCA,
				null);
		String codiceFiscale = ParamUtil.getString(renderRequest, GestionePagamentiFrontendPortletKeys.CODICE_FISCALE_CERCA, null);
		String codiceIuv = ParamUtil.getString(renderRequest, GestionePagamentiFrontendPortletKeys.CODICE_IUV_CERCA,
				null);
		long idPagamento = ParamUtil.getLong(renderRequest, GestionePagamentiFrontendPortletKeys.ID_PAGAMENTO_CERCA);
		
		int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, GestionePagamentiFrontendPortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, GestionePagamentiFrontendPortletKeys.DEFAULT_DELTA);
		
		String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);

		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_DA_CERCA, dataInserimentoDa == null ? null : dateFormat.format(dataInserimentoDa));
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_A_CERCA, dataInserimentoA == null ? null : dateFormat.format(dataInserimentoA));
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_DA_CERCA, dataOperazioneDa == null ? null : dateFormat.format(dataOperazioneDa));
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_A_CERCA, dataOperazioneA == null ? null : dateFormat.format(dataOperazioneA));
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_ORGANIZZAZIONE_CERCA, organizzazioneId != 0 ? organizzazioneId : null);
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_CATEGORIA_CERCA, servizioId != 0 ? servizioId : null);
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_STATO_CERCA, stato);
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_GATEWAY_CERCA, gateway);
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.SELECT_CANALE_CERCA, canale);
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.CODICE_FISCALE_CERCA, codiceFiscale);
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.CODICE_IUV_CERCA, codiceIuv);
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.ID_PAGAMENTO_CERCA, idPagamento != 0 ? idPagamento : null);
		
		renderRequest.setAttribute(SearchContainer.DEFAULT_CUR_PARAM, cur);
		renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, delta);
		renderRequest.setAttribute(SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, orderByCol);
		renderRequest.setAttribute(SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, orderByType);
		
		long pagamentoId = ParamUtil.getLong(renderRequest, GestionePagamentiFrontendPortletKeys.PAGAMENTO_ID_DETTAGLIO);
		
		Pagamento pagamento = null;
		
		try {
			pagamento = pagamentoLocalService.getPagamento(pagamentoId);
			gestionePagamentiService.initDataForView(pagamento);
		} catch (PortalException e) {
			LOG.error(e.getMessage(), e);
		}
		
		renderRequest.setAttribute(GestionePagamentiFrontendPortletKeys.DETTAGLIO_PAGAMENTO, pagamento);
		
		return GestionePagamentiFrontendPortletKeys.DETTAGLIO_PAGAMENTO_VIEW;
	}

}
