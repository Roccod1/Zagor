package it.servizidigitali.presentatoreforms.frontend.portlet.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.OutputStream;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.PDFService;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.IstanzaFormLocalService;

@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=" + PresentatoreFormsPortletKeys.DOWNLOAD_ISTANZA_PDF_RESOURCE_COMMAND
		}, 
service = { MVCResourceCommand.class }
)
public class DownloadIstanzaPDFResourceCommand extends BaseMVCResourceCommand{
	
	public static final Log log = LogFactoryUtil.getLog(DownloadIstanzaPDFResourceCommand.class);

	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;
	
	@Reference
	private PDFService pdfService;


	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		IstanzaForm istanzaForm = null;
		Richiesta richiesta = null;
		
		OutputStream os = null;
		byte[] pdf = null;
		
		String screenName = themeDisplay.getUser().getScreenName();

		
		
		
		try {
			Procedura procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
			
			if (procedura == null) {
				SessionErrors.add(resourceRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_PROCEDURA);
				return;
			}
			richiesta = presentatoreFormFrontendService.getRichiestaBozza(screenName, procedura.getProceduraId());

			Form form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());
			istanzaForm = presentatoreFormFrontendService.getIstanzaFormRichiesta(richiesta.getRichiestaId(), form.getFormId());
			
			FormData formData = AlpacaUtil.loadFormData(form, istanzaForm.getJson(), true);
			AlpacaJsonStructure alpacaStructure = formData.getAlpaca();
			
			String fileName = "allegato-" + String.valueOf(richiesta.getRichiestaId());


			switch (procedura.getStep2TipoServizio()) {
			case "CERTIFICATO":
				pdf = pdfService.generaPDFCertificato(screenName, null, alpacaStructure, richiesta, fileName, null, null, resourceRequest);
				break;
			default:
				pdf = pdfService.generaPDFAlpacaForm(screenName, null, alpacaStructure, 
						null, fileName, null, null, false, null, resourceRequest);
				break;
			}
			
			// TODO: Capire se isDelega viene utilizzato
			
			resourceResponse.setContentType(ContentTypes.APPLICATION_OCTET_STREAM);
			os = resourceResponse.getPortletOutputStream();
			os.write(pdf);
			
		}catch(Exception e) {
			log.error("downloadIstanzaPDFResourceCommand :: " + e.getMessage());
		}
		finally {
			os.close();
		}
		
	}

}
