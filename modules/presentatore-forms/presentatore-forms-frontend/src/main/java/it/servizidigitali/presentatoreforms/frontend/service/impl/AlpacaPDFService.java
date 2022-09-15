package it.servizidigitali.presentatoreforms.frontend.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import it.servizidigitali.file.utility.converter.pdf.PDFConverter;
import it.servizidigitali.file.utility.exception.FileConverterException;
import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.presentatoreforms.frontend.exception.PDFServiceException;
import it.servizidigitali.presentatoreforms.frontend.service.PDFService;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

/**
 * @author pindi
 *
 */
@Component(name = "alpacaPDFService", immediate = true, service = PDFService.class)
public class AlpacaPDFService implements PDFService {

	private static final Log log = LogFactoryUtil.getLog(AlpacaPDFService.class.getName());

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	// @Autowired
	// private JwtTokenUtil jwtTokenUtil;

	// @Autowired
	// private DestinazioneUsoService destinazioneUsoService;

	@Reference
	private PDFConverter pdfConverter;

	@Override
	public byte[] generaPDFCertificato(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, String fileName,
			Long idDestinazioneUso, String numeroBollo, ThemeDisplay themeDisplay) throws PDFServiceException {

		byte[] pdfContent = null;
		try {

			Gson gson = new Gson();
			
			String templateLocation = "/META-INF/resources/freemarker/template.ftl";
			Map<String,Object> data= new HashMap<String,Object>();
			ByteArrayOutputStream os =new ByteArrayOutputStream();
			
			Configuration config = new Configuration(Configuration.VERSION_2_3_29);
			config.setTemplateLoader(new ClassTemplateLoader(getClass(), "/"));
			Template template = null;
			String htmlContent = null;
			

			long proceduraId = richiesta.getProceduraId();
			Procedura procedura = proceduraLocalService.getProcedura(proceduraId);
			long groupId = procedura.getGroupId();

			long organizationId = groupLocalService.getGroup(groupId).getOrganizationId();

			Organization organization = organizationLocalService.getOrganization(organizationId);

			List<DefinizioneAllegato> definizioneAllegati = null;
			alpacaStructure.setSchema(AlpacaUtil.addAttachmentsToSchema(gson.toJson(alpacaStructure.getSchema()), definizioneAllegati));
			alpacaStructure.setOptions(AlpacaUtil.loadOptions(gson.toJson(alpacaStructure.getOptions()), definizioneAllegati, true));
			alpacaStructure.setData(new JsonParser().parse(gson.toJson(alpacaStructure.getData())).getAsJsonObject());

			try {
				template = config.getTemplate(templateLocation);
				template.process(data, new OutputStreamWriter(os));
			} catch (Exception e) {
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
			Long idDestinazioneUso, String numeroBollo, boolean isDelega, String dettagliRichiesta, ThemeDisplay themeDisplay) throws PDFServiceException {

		byte[] pdfContent = null;
		try {
			Gson gson = new Gson();

			long proceduraId = richiesta.getProceduraId();
			Procedura procedura = proceduraLocalService.getProcedura(proceduraId);
			long groupId = procedura.getGroupId();

			long organizationId = groupLocalService.getGroup(groupId).getOrganizationId();

			Organization organization = organizationLocalService.getOrganization(organizationId);

			List<DefinizioneAllegato> definizioneAllegati = null;
			alpacaStructure.setSchema(AlpacaUtil.addAttachmentsToSchema(gson.toJson(alpacaStructure.getSchema()), definizioneAllegati));
			alpacaStructure.setOptions(AlpacaUtil.loadOptions(gson.toJson(alpacaStructure.getOptions()), definizioneAllegati, true));
			alpacaStructure.setData(new JsonParser().parse(gson.toJson(alpacaStructure.getData())).getAsJsonObject());

			// TODO generare HTML con template freemarker (da configurazioni sito?)
			String htmlContent = null;
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
