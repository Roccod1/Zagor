package it.servizidigitali.presentatoreforms.frontend.service.impl;

import com.google.gson.JsonSyntaxException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Image;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ImageLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutSetLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import freemarker.template.Configuration;
import freemarker.template.Template;
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
import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.file.utility.converter.pdf.PDFConverter;
import it.servizidigitali.file.utility.exception.FileConverterException;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.presentatoreforms.frontend.configuration.FreemarkerTemplateEnteConfiguration;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.exception.PDFServiceException;
import it.servizidigitali.presentatoreforms.frontend.service.PDFService;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

/**
 * @author pindi
 *
 */
@Component(name = "alpacaPDFService", immediate = true, service = PDFService.class, configurationPid = "it.servizidigitali.presentatoreforms.frontend.configuration.FreemarkerTemplateEnteConfiguration")
public class AlpacaPDFService implements PDFService {

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

	// @Autowired
	// private DestinazioneUsoService destinazioneUsoService;

	@Reference
	private PDFConverter pdfConverter;

	@Override
	public byte[] generaPDFCertificato(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, String fileName,
			Long idDestinazioneUso, String numeroBollo, PortletRequest portletRequest) throws PDFServiceException {

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
			
			Organization organization = organizationLocalService.getOrganization(organizationId);
			
			LayoutSet layout = layoutSetLocalService.getLayoutSet(themeDisplay.getSiteGroupId(), true);
			
			String numeroBolloDescrizione = "";
			
			data.put("comune",organization.getName());

			data.put("defaultThemeUrl", themeDisplay.getPathThemeRoot());
			data.put("url", portletRequest.getContextPath());
			data.put("portalUrl", themeDisplay.getPortalURL());
			data.put(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE,alpacaStructure);
			
			// Attributi impostati attraverso le destinazioni uso
			
			data.put("certificatoId", richiesta.getRichiestaId());
			data.put("descrizioneDestinazioneUso", "");
			data.put("pagamentoBollo","false");
			data.put("timbraCertificato", "false");
			data.put("showDescrizioneEsenzioneBollo", "false");

			if(Validator.isNotNull(numeroBollo)) {
				numeroBolloDescrizione = "Identificativo Bollo: " + numeroBollo;
			}
			
			long logoId = layout.getLogoId();
			data.put("logoId", logoId);
			
			data.put("numeroBollo", numeroBolloDescrizione);
			
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			try {
				Template template = new Template("templateName", new StringReader(freemarkerTemplateEnteConfiguration.certificatiAlpacaTemplate()), config);
				template.process(data, new OutputStreamWriter(os));
			}
			catch (Exception e) {
				log.error("generaPDFCertificato :: " + e.getMessage(), e);
			}

			htmlContent = os.toString(StandardCharsets.UTF_8);
			pdfContent = pdfConverter.generatePDF(htmlContent);
		}
		catch (JsonSyntaxException e) {
			log.error("generaPDFCertificato :: " + e.getMessage(), e);
		}
		catch (PortalException e) {
			log.error("generaPDFCertificato :: " + e.getMessage(), e);
		}
		catch (FileConverterException e) {
			log.error("generaPDFCertificato :: " + e.getMessage(), e);
		}

		return pdfContent;
	}

	@Override
	public byte[] generaPDFAlpacaForm(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, String fileName,
			String numeroBollo, boolean isDelega, String dettagliRichiesta, PortletRequest portletRequest) throws PDFServiceException {

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
			long logoId = layout.getLogoId();
			data.put("logoId", logoId);

			
			data.put("comune",organization.getName());

			data.put("defaultThemeUrl", themeDisplay.getPathThemeRoot());
			data.put("url", portletRequest.getContextPath());
			data.put("portalUrl", themeDisplay.getPortalURL());
			data.put("delega", isDelega);
			data.put("dataCorrente", sdf.format(new Date()));
			data.put("dettagliRichiesta", dettagliRichiesta);
			data.put(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE,alpacaStructure);
			
			
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			try {
				Template template = null;
				
				if(procedura.getStep2TipoServizio().equalsIgnoreCase(TipoServizio.AUTO_DICHIARAZIONE.name())) {
					template = new Template("templateName", new StringReader(freemarkerTemplateEnteConfiguration.autoDichiarazioniAlpacaTemplate()), config);
				}else {
					template = new Template("templateName", new StringReader(freemarkerTemplateEnteConfiguration.defaultAlpacaTemplate()), config);
				}
				
				
				template.process(data, new OutputStreamWriter(os));
			}
			catch (Exception e) {
				log.error("generaPDFAlpacaForm :: " + e.getMessage(), e);
			}

			htmlContent = os.toString(StandardCharsets.UTF_8);
			pdfContent = pdfConverter.generatePDF(htmlContent);			
		}
		catch (JsonSyntaxException e) {
			log.error("generaPDFAlpacaForm :: " + e.getMessage(), e);
		}
		catch (PortalException e) {
			log.error("generaPDFAlpacaForm :: " + e.getMessage(), e);
		}
		catch (FileConverterException e) {
			log.error("generaPDFAlpacaForm :: " + e.getMessage(), e);
		}

		return pdfContent;
	}
	
}
