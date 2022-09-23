package it.servizidigitali.presentatoreforms.frontend.service.impl;

import com.google.gson.Gson;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Image;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ImageLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.enums.RelazioneParentela;
import it.servizidigitali.backoffice.integration.enums.StatoCivile;
import it.servizidigitali.backoffice.integration.enums.TitoloStudio;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.ProvinciaLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.gestioneprocedure.model.TemplatePdf;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneprocedure.service.TemplatePdfLocalService;
import it.servizidigitali.presentatoreforms.frontend.exception.PDFServiceException;
import it.servizidigitali.presentatoreforms.frontend.service.PDFService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.output.VocabolariService;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;

/**
 * @author pindi
 *
 */
@Component(name = "jasperReportPDFService", immediate = true, service = PDFService.class)
public class JasperReportPDFService implements PDFService {

	private static final String JR_PARAMETER_DESTINAZIONE_USO = "destinazioneUso";

	private static final String JR_PARAMETER_LOGO_COMUNE = "logoComune";
	private static final String JR_PARAMETER_COMUNE = "comune";
	private static final String JR_PARAMETER_COMUNI = "comuni";
	private static final String JR_PARAMETER_COMUNI_ESTERI = "comuniEsteri";
	private static final String JR_PARAMETER_PROVINCE = "province";
	private static final String JR_PARAMETER_STATI = "stati";

	private static final String JR_PARAMETER_TITOLI_STUDIO = "titoliStudio";
	private static final String JR_PARAMETER_STATI_CIVILI = "statiCivili";
	private static final String JR_PARAMETER_RELAZIONI_PARENTELA = "relazioniParentela";

	private static final String JR_PARAMETER_TITOLI_STUDIO_ASCOT = "titoliStudioASCOT";
	private static final String JR_PARAMETER_TIPI_REGISTRAZIONE_ASCOT = "tipiRegistrazioneASCOT";
	private static final String JR_PARAMETER_TIPI_VEICOLO_ASCOT = "tipiVeicoloASCOT";
	private static final String JR_PARAMETER_STATI_CIVILI_ASCOT = "statiCiviliASCOT";
	private static final String JR_PARAMETER_RELAZIONI_PARENTELA_ASCOT = "relazioniParentelaASCOT";
	private static final String JR_PARAMETER_POSIZIONI_PROFESSIONALI_ASCOT = "posizioniProfessionaliASCOT";
	private static final String JR_PARAMETER_ENTI_RILASCIO_PATENTE_ASCOT = "entiRilascioPatenteASCOT";
	private static final String JR_PARAMETER_CONDIZIONI_NON_PROFESSIONALI_ASCOT = "condizioniNonProfessionaliASCOT";
	private static final String JR_PARAMETER_ALTRI_MOTIVI_ISCRIZIONE_ASCOT = "altriMotiviIscrizioneASCOT";

	private static final Log log = LogFactoryUtil.getLog(JasperReportPDFService.class.getName());

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private TemplatePdfLocalService templatePdfLocalService;

	@Reference
	private DLAppService dlAppService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ProvinciaLocalService provinciaLocalService;

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	@Reference
	private VocabolariService vocabolariService;

	@Reference
	private ImageLocalService imageLocalService;

	@Override
	public byte[] generaPDFCertificato(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, Long idDestinazioneUso,
			String numeroBollo, PortletRequest portletRequest) throws PDFServiceException {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Image image = imageLocalService.getCompanyLogo(themeDisplay.getCompany().getLogoId());

		try {

			long proceduraId = richiesta.getProceduraId();

			List<TemplatePdf> templatesPdf = templatePdfLocalService.getTemplatePdfByProceduraId(proceduraId);

			TemplatePdf templatePdfPrincipale = getTemplatePdfPrincipale(templatesPdf);

			List<TemplatePdf> templatesPdfFigli = getTemplatesPdfFigli(templatesPdf);

			if (templatePdfPrincipale == null) {
				throw new PDFServiceException("Report JRXML principale non presente.");
			}

			Map<String, Object> param = new HashMap<String, Object>();

			FormData formData = (FormData) alpacaStructure.getData();
			Object data = formData.getAlpaca().getData();

			Gson gson = new Gson();
			InputStream stream = new ByteArrayInputStream(gson.toJson(data).getBytes("UTF-8"));

			JRDataSource jsonDataSource = new JsonDataSource(stream);

			long fileEntryId = templatePdfPrincipale.getFileEntryId();
			FileEntry documentoPrincipalefileEntry = dlAppService.getFileEntry(fileEntryId);

			InputStream reportPrincipaleInputStream = new ByteArrayInputStream(documentoPrincipalefileEntry.getContentStream().readAllBytes());
			JasperReport reportPrincipaleJasperReport = JasperCompileManager.compileReport(reportPrincipaleInputStream);

			// Sottoreport, se presenti
			if (templatesPdfFigli != null) {
				for (TemplatePdf templatePdfFiglio : templatesPdfFigli) {
					FileEntry documentoFiglioEntry = dlAppService.getFileEntry(templatePdfFiglio.getFileEntryId());
					InputStream subReportInputStream = new ByteArrayInputStream(documentoFiglioEntry.getContentStream().readAllBytes());
					JasperReport subJasperReport = JasperCompileManager.compileReport(subReportInputStream);
					param.put(templatePdfFiglio.getNomeFile(), subJasperReport);
				}
			}

			addParametriAggiuntivi(param);

			if (Validator.isNotNull(image)) {
				ByteArrayInputStream logoComune = new ByteArrayInputStream(image.getTextObj());
				param.put(JR_PARAMETER_LOGO_COMUNE, logoComune);
			}

			// TODO destinazione uso

			JasperPrint jasperPrint = JasperFillManager.fillReport(reportPrincipaleJasperReport, param, jsonDataSource);

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			return out.toByteArray();
		}
		catch (Exception e) {
			log.error("generaPDFCertificato :: " + e.getMessage(), e);
			throw new PDFServiceException("Errore durante il processo di generazione del PDF :: " + e.getMessage(), e);
		}
	}

	@Override
	public byte[] generaPDFAlpacaForm(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, boolean isDelega,
			String dettagliRichiesta, PortletRequest portletRequest) throws PDFServiceException {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Image image = imageLocalService.getCompanyLogo(themeDisplay.getCompany().getLogoId());

		try {
			long proceduraId = richiesta.getProceduraId();

			List<TemplatePdf> templatesPdf = templatePdfLocalService.getTemplatePdfByProceduraId(proceduraId);

			TemplatePdf templatePdfPrincipale = getTemplatePdfPrincipale(templatesPdf);

			List<TemplatePdf> templatesPdfFigli = getTemplatesPdfFigli(templatesPdf);

			if (templatePdfPrincipale == null) {
				throw new PDFServiceException("Report JRXML principale non presente.");
			}

			Map<String, Object> param = new HashMap<String, Object>();

			FormData formData = (FormData) alpacaStructure.getData();
			Object data = formData.getAlpaca().getData();

			Gson gson = new Gson();
			InputStream stream = new ByteArrayInputStream(gson.toJson(data).getBytes("UTF-8"));

			JRDataSource jsonDataSource = new JsonDataSource(stream);

			long fileEntryId = templatePdfPrincipale.getFileEntryId();
			FileEntry documentoPrincipalefileEntry = dlAppService.getFileEntry(fileEntryId);

			InputStream reportPrincipaleInputStream = new ByteArrayInputStream(documentoPrincipalefileEntry.getContentStream().readAllBytes());
			JasperReport reportPrincipaleJasperReport = JasperCompileManager.compileReport(reportPrincipaleInputStream);

			// Sottoreport, se presenti
			if (templatesPdfFigli != null) {
				for (TemplatePdf templatePdfFiglio : templatesPdfFigli) {
					FileEntry documentoFiglioEntry = dlAppService.getFileEntry(templatePdfFiglio.getFileEntryId());
					InputStream subReportInputStream = new ByteArrayInputStream(documentoFiglioEntry.getContentStream().readAllBytes());
					JasperReport subJasperReport = JasperCompileManager.compileReport(subReportInputStream);
					param.put(templatePdfFiglio.getNomeFile(), subJasperReport);
				}
			}

			addParametriAggiuntivi(param);

			if (Validator.isNotNull(image)) {
				ByteArrayInputStream logoComune = new ByteArrayInputStream(image.getTextObj());
				param.put(JR_PARAMETER_LOGO_COMUNE, logoComune);
			}

			JasperPrint jasperPrint = JasperFillManager.fillReport(reportPrincipaleJasperReport, param, jsonDataSource);

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			return out.toByteArray();
		}
		catch (Exception e) {
			log.error("generaPDFAlpacaForm :: " + e.getMessage(), e);
			throw new PDFServiceException("Errore durante il processo di generazione del PDF :: " + e.getMessage(), e);
		}
	}

	/**
	 * @param param
	 */
	private void addParametriAggiuntivi(Map<String, Object> param) {

		// Caricamento parametri aggiuntivi
		List<StatoEstero> allStati = statoEsteroLocalService.getStatoEsteros(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		Map<String, String> stati = allStati.stream().collect(Collectors.toMap(stato -> Integer.toString(stato.getCodiceStato()), StatoEstero::getDenominazione));
		param.put(JR_PARAMETER_STATI, stati);

		List<Provincia> allProvince = provinciaLocalService.getProvincias(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		Map<String, String> province = allProvince.stream().collect(Collectors.toMap(Provincia::getSigla, Provincia::getDenominazioneProvincia));
		param.put(JR_PARAMETER_PROVINCE, province);

		List<Comune> allComuni = comuneLocalService.getComunes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		Map<String, String> comuni = allComuni.stream().collect(Collectors.toMap(Comune::getCodiceIstatAN, Comune::getDenominazione));
		param.put(JR_PARAMETER_COMUNI, comuni);

		List<ComuneEstero> allComuniEsteri = comuneEsteroLocalService.getComuneEsteros(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		Map<String, String> comuniEsteri = allComuniEsteri.stream().collect(Collectors.toMap(comune -> Integer.toString(comune.getCodice()), ComuneEstero::getDenominazione));
		param.put(JR_PARAMETER_COMUNI_ESTERI, comuniEsteri);

		Map<String, String> titoliStudio = Arrays.stream(TitoloStudio.values()).collect(Collectors.toMap(TitoloStudio::getCodice, TitoloStudio::getDescrizione));
		param.put(JR_PARAMETER_TITOLI_STUDIO, titoliStudio);
		Map<String, String> statiCivili = Arrays.stream(StatoCivile.values()).collect(Collectors.toMap(titoloStudio -> Integer.toString(titoloStudio.getCodice()), StatoCivile::getDescrizione));
		param.put(JR_PARAMETER_STATI_CIVILI, statiCivili);
		Map<String, String> relazioniParentela = Arrays.stream(RelazioneParentela.values())
				.collect(Collectors.toMap(relazioneParentele -> Integer.toString(relazioneParentele.getCodice()), RelazioneParentela::getDescrizione));
		param.put(JR_PARAMETER_RELAZIONI_PARENTELA, relazioniParentela);

		param.put(JR_PARAMETER_ALTRI_MOTIVI_ISCRIZIONE_ASCOT, vocabolariService.getVocabolarioAltriMotiviIscrizione());
		param.put(JR_PARAMETER_CONDIZIONI_NON_PROFESSIONALI_ASCOT, vocabolariService.getVocabolarioCondizioniNonProfessionali());
		param.put(JR_PARAMETER_ENTI_RILASCIO_PATENTE_ASCOT, vocabolariService.getVocabolarioEntiRilascioPatente());
		param.put(JR_PARAMETER_POSIZIONI_PROFESSIONALI_ASCOT, vocabolariService.getVocabolarioPosizioniProfessionali());
		param.put(JR_PARAMETER_RELAZIONI_PARENTELA_ASCOT, vocabolariService.getVocabolarioRelazioniDiParentela());
		param.put(JR_PARAMETER_STATI_CIVILI_ASCOT, vocabolariService.getVocabolarioStatiCivili());
		param.put(JR_PARAMETER_TIPI_VEICOLO_ASCOT, vocabolariService.getVocabolarioTipiVeicolo());
		param.put(JR_PARAMETER_TIPI_REGISTRAZIONE_ASCOT, vocabolariService.getVocabolarioTipoRegistrazione());
		param.put(JR_PARAMETER_TITOLI_STUDIO_ASCOT, vocabolariService.getVocabolarioTitoliDiStudio());
	}

	/**
	 * @param templatesPdf
	 * @return
	 */
	private List<TemplatePdf> getTemplatesPdfFigli(List<TemplatePdf> templatesPdf) {

		if (templatesPdf != null) {
			List<TemplatePdf> templatesPdfFigli = new ArrayList<TemplatePdf>();
			for (TemplatePdf templatePdf : templatesPdf) {
				if (templatePdf.getTemplatePdfParentId() != 0) {
					templatesPdfFigli.add(templatePdf);
				}
			}
			return templatesPdfFigli;
		}
		return null;
	}

	/**
	 * @param templatesPdf
	 * @return
	 */
	private TemplatePdf getTemplatePdfPrincipale(List<TemplatePdf> templatesPdf) {
		if (templatesPdf != null) {
			for (TemplatePdf templatePdf : templatesPdf) {
				if (templatePdf.getTemplatePdfParentId() == 0) {
					return templatePdf;
				}
			}
		}
		return null;
	}
}
