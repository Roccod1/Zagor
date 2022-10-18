package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoGenerazionePDF;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.common.model.FormData;
import it.servizidigitali.presentatoreforms.common.service.PDFService;
import it.servizidigitali.presentatoreforms.common.service.PDFServiceFactory;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.AllegatoRichiestaService;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(//
		immediate = true, //
		property = { //

				"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=PresentatoreForms", //
				"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp", //
				"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
				"mvc.command.name=" + PresentatoreFormsPortletKeys.GENERA_CERTIFICATO_RENDER_COMMAND//
		}, //
		service = MVCRenderCommand.class//
) //
public class GeneraCertificatoRenderCommand implements MVCRenderCommand {

	public static final Log log = LogFactoryUtil.getLog(GeneraCertificatoRenderCommand.class);

	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private PDFServiceFactory pdfServiceFactory;

	@Reference
	private AllegatoRichiestaService allegatoRichiestaService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		Procedura procedura = null;
		Form form = null;
		Richiesta richiesta = null;
		IstanzaForm istanzaForm = null;
		Servizio servizio = null;

		Gson gson = new Gson();

		byte[] pdfCertificato = null;

		long destinazioneUsoId = ParamUtil.getLong(renderRequest, "destinazioneUsoId");
		String codiceFiscaleComponente = ParamUtil.getString(renderRequest, "codiceFiscaleComponente");

		try {
			procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
			PDFService pdfService = pdfServiceFactory.getPDFService(TipoGenerazionePDF.valueOf(procedura.getTipoGenerazionePDF()));
			servizio = servizioLocalService.getServizio(procedura.getServizioId());
			form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());
			richiesta = presentatoreFormFrontendService.getRichiestaBozza(user.getScreenName(), procedura.getProceduraId());
			istanzaForm = presentatoreFormFrontendService.getIstanzaFormRichiesta(richiesta.getRichiestaId(), form.getFormId());

			FormData formData = AlpacaUtil.loadFormData(form, istanzaForm.getJson(), true, themeDisplay.getPortalURL());
			AlpacaJsonStructure alpacaStructure = formData.getAlpaca();
			JsonParser jsonParser = new JsonParser();
			alpacaStructure.setSchema(AlpacaUtil.addAttachmentsToSchema(gson.toJson(alpacaStructure.getSchema()), form.getListaDefinizioneAllegato()));
			alpacaStructure.setOptions(AlpacaUtil.loadOptions(gson.toJson(alpacaStructure.getOptions()), form.getListaDefinizioneAllegato(), true, themeDisplay.getPortalURL()));
			alpacaStructure.setData(jsonParser.parse(gson.toJson(alpacaStructure.getData())).getAsJsonObject());

			pdfCertificato = pdfService.generaPDFCertificato(user.getScreenName(), codiceFiscaleComponente, alpacaStructure, richiesta, destinazioneUsoId, null, renderRequest);

			if (Validator.isNotNull(pdfCertificato) && Validator.isNotNull(richiesta)) {
				richiestaLocalService.updateStatoRichiesta(richiesta.getRichiestaId(), StatoRichiesta.CHIUSA_POSITIVAMENTE.name());
				String idDocumentale = allegatoRichiestaService.salvaCertificato(pdfCertificato, servizio, richiesta.getRichiestaId(), user.getFullName(), user.getUserId(),
						themeDisplay.getSiteGroupId());
				renderRequest.setAttribute(PresentatoreFormsPortletKeys.RICHIESTA_ID, richiesta.getRichiestaId());
				renderRequest.setAttribute(PresentatoreFormsPortletKeys.SELECT_COMPONENTI_NUCLEO_FAMILIARE, codiceFiscaleComponente);
				renderRequest.setAttribute(PresentatoreFormsPortletKeys.ID_DOCUMENTALE, idDocumentale);
				return PresentatoreFormsPortletKeys.JSP_DOWNLOAD_CERTIFICATO;
			}

		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

}
