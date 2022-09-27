package it.servizidigitali.presentatoreforms.frontend.portlet.resource;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.PDFService;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

@Component(immediate = true, property = { //
		"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
		"mvc.command.name=" + PresentatoreFormsPortletKeys.DOWNLOAD_ISTANZA_PDF_RESOURCE_COMMAND //
}, service = { MVCResourceCommand.class })
public class DownloadIstanzaPDFResourceCommand extends BaseMVCResourceCommand {

	public static final Log log = LogFactoryUtil.getLog(DownloadIstanzaPDFResourceCommand.class);

	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;

	@Reference
	private PDFService pdfService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		IstanzaForm istanzaForm = null;
		Richiesta richiesta = null;

		byte[] pdf = null;

		String screenName = themeDisplay.getUser().getScreenName();

		Gson gson = new Gson();

		try {
			Procedura procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);

			if (procedura == null) {
				SessionErrors.add(resourceRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_PROCEDURA);
				return;
			}
			richiesta = presentatoreFormFrontendService.getRichiestaBozza(screenName, procedura.getProceduraId());

			Form form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());
			istanzaForm = presentatoreFormFrontendService.getIstanzaFormRichiesta(richiesta.getRichiestaId(), form.getFormId());

			FormData formData = AlpacaUtil.loadFormData(form, istanzaForm.getJson(), true, themeDisplay.getPortalURL());
			AlpacaJsonStructure alpacaStructure = formData.getAlpaca();

			alpacaStructure.setSchema(AlpacaUtil.addAttachmentsToSchema(gson.toJson(alpacaStructure.getSchema()), form.getListaDefinizioneAllegato()));
			alpacaStructure.setOptions(AlpacaUtil.loadOptions(gson.toJson(alpacaStructure.getOptions()), form.getListaDefinizioneAllegato(), true, themeDisplay.getPortalURL()));
			alpacaStructure.setData(JsonParser.parseString(gson.toJson(alpacaStructure.getData())).getAsJsonObject());

			String fileName = "richiesta-" + String.valueOf(richiesta.getRichiestaId()) + ".pdf";
			String step2TipoServizio = procedura.getStep2TipoServizio();
			TipoServizio tipoServizio = TipoServizio.valueOf(step2TipoServizio);
			String codiceFiscaleComponente = null;
			String dettagliRichiesta = "";
			// if (delega != null) {
			// DateFormat dtfmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			// String dataCorrente = dtfmt.format(new Date());
			// dettagliRichiesta = "n. " + datiRichiestaServizio.getId() + " del " + dataCorrente;
			// }

			switch (tipoServizio) {
			case CERTIFICATO:
				Long idDestinazioneUso = null;
				String numeroBollo = null;
				pdf = pdfService.generaPDFCertificato(screenName, codiceFiscaleComponente, alpacaStructure, richiesta, idDestinazioneUso, numeroBollo, resourceRequest);
				break;
			default:
				pdf = pdfService.generaPDFAlpacaForm(screenName, codiceFiscaleComponente, alpacaStructure, richiesta, false, dettagliRichiesta, resourceRequest);
				break;
			}

			// TODO: Capire se isDelega viene utilizzato
			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, fileName, pdf, ContentTypes.APPLICATION_PDF);

		}
		catch (Exception e) {
			log.error("downloadIstanzaPDFResourceCommand :: " + e.getMessage(), e);
			SessionErrors.add(resourceRequest, PresentatoreFormsPortletKeys.ERRORE_GENERICO);
			return;
		}
	}
}
