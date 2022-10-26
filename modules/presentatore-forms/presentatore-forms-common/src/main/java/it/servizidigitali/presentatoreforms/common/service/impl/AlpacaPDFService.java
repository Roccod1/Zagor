package it.servizidigitali.presentatoreforms.common.service.impl;

import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutSetLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import freemarker.template.Configuration;
import freemarker.template.Template;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.ProvinciaLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.common.utility.enumeration.TipoTemplate;
import it.servizidigitali.common.utility.enumeration.TipoTemplateNativo;
import it.servizidigitali.file.utility.converter.pdf.PDFConverter;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.model.TemplatePdf;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneprocedure.service.TemplatePdfLocalService;
import it.servizidigitali.presentatoreforms.common.configuration.FreemarkerTemplateEnteConfiguration;
import it.servizidigitali.presentatoreforms.common.constants.PresentatoreFormsCommonPortletKeys;
import it.servizidigitali.presentatoreforms.common.exception.PDFServiceException;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.common.service.PDFService;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.DestinazioneUsoLocalService;

/**
 * @author pindi
 *
 */
@Component(name = "alpacaPDFService", immediate = true, service = PDFService.class, configurationPid = "it.servizidigitali.presentatoreforms.frontend.configuration.FreemarkerTemplateEnteConfiguration")
public class AlpacaPDFService implements PDFService {

	private static final String SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH = PresentatoreFormsCommonPortletKeys.SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH;

	private static final Log log = LogFactoryUtil.getLog(AlpacaPDFService.class.getName());

	private ConfigurationProvider configurationProvider;

	private volatile FreemarkerTemplateEnteConfiguration freemarkerTemplateEnteConfiguration;

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ProvinciaLocalService provinciaLocalService;

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	@Reference
	private LayoutSetLocalService layoutSetLocalService;

	// @Autowired
	// private JwtTokenUtil jwtTokenUtil;

	@Reference
	private DestinazioneUsoLocalService destinazioneUsoLocalService;

	@Reference
	private PDFConverter pdfConverter;

	@Reference
	private TemplatePdfLocalService templatePdfLocalService;

	@Reference
	private DLAppService dlAppService;

	@Override
	public byte[] generaPDFCertificato(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, Long idDestinazioneUso,
			String numeroBollo, PortletRequest portletRequest) throws PDFServiceException {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		byte[] pdfContent = null;
		try {

			freemarkerTemplateEnteConfiguration = configurationProvider.getGroupConfiguration(FreemarkerTemplateEnteConfiguration.class, themeDisplay.getScopeGroupId());

			Map<String, Object> data = new HashMap<String, Object>();
			Configuration config = new Configuration(Configuration.VERSION_2_3_29);

			String htmlContent = null;

			long proceduraId = richiesta.getProceduraId();
			Procedura procedura = proceduraLocalService.getProcedura(proceduraId);
			long groupId = procedura.getGroupId();

			long organizationId = groupLocalService.getGroup(groupId).getOrganizationId();

			DestinazioneUso destinazioneUso = destinazioneUsoLocalService.getDestinazioneUso(idDestinazioneUso);

			Organization organization = organizationLocalService.getOrganization(organizationId);

			LayoutSet layout = layoutSetLocalService.getLayoutSet(themeDisplay.getSiteGroupId(), true);

			List<TemplatePdf> listaTemplate = templatePdfLocalService.getTemplatePdfByProceduraIdAndTipoTemplate(procedura.getProceduraId(), TipoTemplate.FREEMARKER.name());

			TemplatePdf templatePdf = null;

			Template template = null;

			String numeroBolloDescrizione = "";

			data.put("comune", organization.getName());

			data.put("defaultThemeUrl", themeDisplay.getPathThemeRoot());
			data.put("url", portletRequest.getContextPath());
			data.put("portalUrl", themeDisplay.getPortalURL());
			data.put(PresentatoreFormsCommonPortletKeys.ALPACA_STRUCTURE, alpacaStructure);

			// Attributi impostati attraverso le destinazioni uso

			data.put("certificatoId", richiesta.getRichiestaId());
			data.put("pagamentoBollo", "false");
			data.put("timbraCertificato", "false");
			data.put("showDescrizioneEsenzioneBollo", "true");

			if (Validator.isNotNull(destinazioneUso)) {
				data.put("descrizioneDestinazioneUso", destinazioneUso.getDescrizione());
			}

			if (Validator.isNotNull(numeroBollo)) {
				numeroBolloDescrizione = "Identificativo Bollo: " + numeroBollo;
			}

			long logoId = layout.getLogoId();
			data.put("logoId", logoId);

			data.put("numeroBollo", numeroBolloDescrizione);

			addParametriAggiuntivi(data, themeDisplay);

			ByteArrayOutputStream os = new ByteArrayOutputStream();

			if (Validator.isNotNull(listaTemplate) && !listaTemplate.isEmpty()) {

				int i = 0;
				boolean templateCertificato = false;

				while (i < listaTemplate.size() && templateCertificato == false) {

					if (listaTemplate.get(i).getTipoTemplateNativo().equalsIgnoreCase(TipoTemplateNativo.CERTIFICATO.name())) {
						templateCertificato = true;
						templatePdf = listaTemplate.get(i);
					}

					i++;
				}

				if (Validator.isNotNull(templatePdf)) {
					long fileEntryId = templatePdf.getFileEntryId();
					FileEntry feTemplate = dlAppService.getFileEntry(fileEntryId);

					if (Validator.isNotNull(feTemplate)) {
						InputStream isTemplate = feTemplate.getContentStream();
						String templateCustom = new String(isTemplate.readAllBytes(), StandardCharsets.UTF_8);
						template = new Template("templateName", new StringReader(templateCustom), config);
					}

				}
				else {
					template = new Template("templateName", new StringReader(freemarkerTemplateEnteConfiguration.certificatiAlpacaTemplate()), config);
				}

			}
			else {
				template = new Template("templateName", new StringReader(freemarkerTemplateEnteConfiguration.certificatiAlpacaTemplate()), config);
			}

			template.process(data, new OutputStreamWriter(os));

			htmlContent = os.toString(StandardCharsets.UTF_8);
			pdfContent = pdfConverter.generatePDF(htmlContent);
		}
		catch (Exception e) {
			log.error("generaPDFCertificato :: " + e.getMessage(), e);
			throw new PDFServiceException("Errore durante il processo di generazione del PDF :: " + e.getMessage(), e);
		}

		return pdfContent;
	}

	@Override
	public byte[] generaPDFAlpacaForm(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, boolean isDelega,
			String dettagliRichiesta, PortletRequest portletRequest) throws PDFServiceException {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		byte[] pdfContent = null;

		try {

			freemarkerTemplateEnteConfiguration = configurationProvider.getGroupConfiguration(FreemarkerTemplateEnteConfiguration.class, themeDisplay.getScopeGroupId());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			Map<String, Object> data = new HashMap<String, Object>();
			Configuration config = new Configuration(Configuration.VERSION_2_3_29);

			String htmlContent = null;

			long proceduraId = richiesta.getProceduraId();
			Procedura procedura = proceduraLocalService.getProcedura(proceduraId);
			long groupId = procedura.getGroupId();

			long organizationId = groupLocalService.getGroup(groupId).getOrganizationId();

			Organization organization = organizationLocalService.getOrganization(organizationId);

			LayoutSet layout = layoutSetLocalService.getLayoutSet(themeDisplay.getSiteGroupId(), true);

			List<TemplatePdf> listaTemplate = templatePdfLocalService.getTemplatePdfByProceduraIdAndTipoTemplate(procedura.getProceduraId(), TipoTemplate.FREEMARKER.name());

			TemplatePdf templatePdf = null;

			long logoId = layout.getLogoId();
			data.put("logoId", logoId);

			data.put("comune", organization.getName());

			data.put("defaultThemeUrl", themeDisplay.getPathThemeRoot());
			data.put("url", portletRequest.getContextPath());
			data.put("portalUrl", themeDisplay.getPortalURL());
			data.put("delega", Boolean.toString(isDelega));
			data.put("dataCorrente", sdf.format(new Date()));
			data.put("dettagliRichiesta", dettagliRichiesta);
			data.put(PresentatoreFormsCommonPortletKeys.ALPACA_STRUCTURE, alpacaStructure);

			addParametriAggiuntivi(data, themeDisplay);

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			Template template = null;

			if (Validator.isNotNull(listaTemplate) && !listaTemplate.isEmpty()) {

				int i = 0;
				boolean templateTrovato = false;

				while (i < listaTemplate.size() && templateTrovato == false) {
					
					if (procedura.getStep2TipoServizio().equalsIgnoreCase(TipoServizio.AUTO_DICHIARAZIONE.name())) {
						if (listaTemplate.get(i).getTipoTemplateNativo().equalsIgnoreCase(TipoTemplateNativo.AUTO_DICHIARAZIONE.name())) {
							templateTrovato = true;
							templatePdf = listaTemplate.get(i);
						}					
					}else {
						if (listaTemplate.get(i).getTipoTemplateNativo().equalsIgnoreCase(TipoTemplateNativo.DEFAULT.name())) {
							templateTrovato = true;
							templatePdf = listaTemplate.get(i);
						}					
					}
					
					i++;
				}

				if (Validator.isNotNull(templatePdf)) {
					long fileEntryId = templatePdf.getFileEntryId();
					FileEntry feTemplate = dlAppService.getFileEntry(fileEntryId);

					if (Validator.isNotNull(feTemplate)) {
						InputStream isTemplate = feTemplate.getContentStream();
						String templateCustom = new String(isTemplate.readAllBytes(), StandardCharsets.UTF_8);
						template = new Template("templateName", new StringReader(templateCustom), config);
					}

				}
				else {

					if (procedura.getStep2TipoServizio().equalsIgnoreCase(TipoServizio.AUTO_DICHIARAZIONE.name())) {
						template = new Template("templateName", new StringReader(freemarkerTemplateEnteConfiguration.autoDichiarazioniAlpacaTemplate()), config);
					}
					else {
						template = new Template("templateName", new StringReader(freemarkerTemplateEnteConfiguration.defaultAlpacaTemplate()), config);
					}

				}

			}
			else {

				if (procedura.getStep2TipoServizio().equalsIgnoreCase(TipoServizio.AUTO_DICHIARAZIONE.name())) {
					template = new Template("templateName", new StringReader(freemarkerTemplateEnteConfiguration.autoDichiarazioniAlpacaTemplate()), config);
				}
				else {
					template = new Template("templateName", new StringReader(freemarkerTemplateEnteConfiguration.defaultAlpacaTemplate()), config);
				}

			}

			template.process(data, new OutputStreamWriter(os));

			htmlContent = os.toString(StandardCharsets.UTF_8);
			pdfContent = pdfConverter.generatePDF(htmlContent);
		}
		catch (Exception e) {
			log.error("generaPDFAlpacaForm :: " + e.getMessage(), e);
			throw new PDFServiceException("Errore durante il processo di generazione del PDF :: " + e.getMessage(), e);
		}

		return pdfContent;
	}

	private void addParametriAggiuntivi(Map<String, Object> data, ThemeDisplay themeDisplay) {

		String portalURL = themeDisplay.getPortalURL();

		data.put("listaStatiEsteriUrlKey", portalURL + SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH + "/stati-esteri");
		data.put("listaProvinceUrlKey", portalURL + SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH + "/province");
		data.put("listaComuniUrlKey", portalURL + SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH + "/comuni");
		data.put("listaComuniEsteriSelUrlKey", portalURL + SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH + "/comuni-esteri");
		data.put("listaTitoliStudioUrlKey", portalURL + SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH + "/titoli-studio");
		data.put("listaStatiCiviliUrlKey", portalURL + SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH + "/stati-civili");
		data.put("listaRelazioniParentelaUrlKey", portalURL + SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH + "/relazioni-parentela");
	}

}
