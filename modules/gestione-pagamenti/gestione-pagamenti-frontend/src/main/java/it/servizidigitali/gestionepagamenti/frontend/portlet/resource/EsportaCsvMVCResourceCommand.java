package it.servizidigitali.gestionepagamenti.frontend.portlet.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.StringWriter;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionepagamenti.frontend.constants.GestionePagamentiFrontendPortletKeys;
import it.servizidigitali.gestionepagamenti.frontend.service.GestionePagamentiService;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.PagamentoLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + GestionePagamentiFrontendPortletKeys.GESTIONEPAGAMENTIFRONTEND,
		"mvc.command.name=" + GestionePagamentiFrontendPortletKeys.ESPORTA_CSV_RESOURCE_COMMAND }, service = {
				MVCResourceCommand.class })
public class EsportaCsvMVCResourceCommand extends BaseMVCResourceCommand {

	public static final Log LOG = LogFactoryUtil.getLog(EsportaCsvMVCResourceCommand.class);

	@Reference
	private GestionePagamentiService gestionePagamentiService;

	@Reference
	private PagamentoLocalService pagamentoLocalService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long siteOrganizationId = themeDisplay.getSiteGroup().getOrganizationId();
		
		boolean mainSite = siteOrganizationId == 0;
		
		long siteGroupId = mainSite ? 0 : themeDisplay.getSiteGroupId();

		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd");

		Date dataInserimentoDa = ParamUtil.getDate(resourceRequest,
				GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_DA_CERCA, dateFormat, null);
		Date dataInserimentoA = ParamUtil.getDate(resourceRequest,
				GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_A_CERCA, dateFormat, null);
		Date dataOperazioneDa = ParamUtil.getDate(resourceRequest,
				GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_DA_CERCA, dateFormat, null);
		Date dataOperazioneA = ParamUtil.getDate(resourceRequest,
				GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_A_CERCA, dateFormat, null);

		long organizzazioneId = ParamUtil.getLong(resourceRequest,
				GestionePagamentiFrontendPortletKeys.SELECT_ORGANIZZAZIONE_CERCA);

		Organization organization = organizzazioneId != 0 ? gestionePagamentiService.getOrganization(organizzazioneId)
				: null;

		if (Validator.isNotNull(organization)) {
			siteGroupId = organization.getGroupId();
		}

		long servizioId = ParamUtil.getLong(resourceRequest,
				GestionePagamentiFrontendPortletKeys.SELECT_CATEGORIA_CERCA);
		String stato = ParamUtil.getString(resourceRequest, GestionePagamentiFrontendPortletKeys.SELECT_STATO_CERCA,
				null);
		String gateway = ParamUtil.getString(resourceRequest, GestionePagamentiFrontendPortletKeys.SELECT_GATEWAY_CERCA,
				null);
		String canale = ParamUtil.getString(resourceRequest, GestionePagamentiFrontendPortletKeys.SELECT_CANALE_CERCA,
				null);
		String codiceFiscale = ParamUtil.getString(resourceRequest,
				GestionePagamentiFrontendPortletKeys.CODICE_FISCALE_CERCA, null);
		String codiceIuv = ParamUtil.getString(resourceRequest, GestionePagamentiFrontendPortletKeys.CODICE_IUV_CERCA,
				null);
		long idPagamento = ParamUtil.getLong(resourceRequest, GestionePagamentiFrontendPortletKeys.ID_PAGAMENTO_CERCA);

		List<Pagamento> listaPagamenti = pagamentoLocalService.search(dataInserimentoDa, dataInserimentoA, dataOperazioneDa,
				dataOperazioneA, siteGroupId, servizioId, stato, gateway, canale, codiceFiscale, codiceIuv,
				idPagamento, -1, -1, null, null);
		listaPagamenti.forEach(pagamento -> gestionePagamentiService.initDataForView(pagamento));

		if (!listaPagamenti.isEmpty()) {
			
			CSVFormat csvFormat = CSVFormat.Builder.create(CSVFormat.DEFAULT).setHeader(gestionePagamentiService.getCsvHeader(mainSite)).build();

			StringWriter stringWriter = new StringWriter();
			try (CSVPrinter printer = new CSVPrinter(stringWriter, csvFormat)) {
				printer.printRecords(gestionePagamentiService.getValuesForCsv(listaPagamenti, mainSite));
			}
			
			String stringCsv = stringWriter.toString();
			
			String filename = String.format("Export_pagamenti_%s.csv", LocalDateTime.now().toString());
				
			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, filename, stringCsv.getBytes(), ContentTypes.APPLICATION_OCTET_STREAM);
		}
	}

}
