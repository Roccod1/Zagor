package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Base64;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.common.model.FormData;
import it.servizidigitali.presentatoreforms.common.service.CertificatoService;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

@Component(//
		immediate = true, //
		property = { //
				"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
				"mvc.command.name=" + PresentatoreFormsPortletKeys.SCEGLI_MODALITA_PAGAMENTO_RENDER_COMMAND //
		}, //
		service = MVCRenderCommand.class//
)
public class ModalitaPagamentoRenderCommand implements MVCRenderCommand {

	public static final Log _log = LogFactoryUtil.getLog(ModalitaPagamentoRenderCommand.class);

	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private CertificatoService certificatoService;

	boolean certificatiPdfPreviewEnabled = true; // Valore viene preso da configurazione d'ambiente

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		long organizationId = themeDisplay.getScopeGroup().getOrganizationId();
		long groupId = themeDisplay.getSiteGroupId();
		long companyId = themeDisplay.getCompanyId();

		Richiesta richiesta = null;
		Procedura procedura = null;
		Servizio servizio = null;
		Form form = null;
		IstanzaForm istanzaForm = null;
		boolean daPagare = false;
		boolean invioIstanza = true;

		String encoded = null;

		String destinazioneUsoId = ParamUtil.getString(renderRequest, "destinazioneUsoId");

		Gson gson = new Gson();

		try {

			procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);

			if (Validator.isNull(procedura)) {
				SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_PROCEDURA);
				return PresentatoreFormsPortletKeys.JSP_VIEW;
			}

			form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());
			richiesta = presentatoreFormFrontendService.getRichiestaBozza(user.getScreenName(), procedura.getProceduraId());
			servizio = servizioLocalService.getServizio(procedura.getServizioId());
			istanzaForm = presentatoreFormFrontendService.getIstanzaFormRichiesta(richiesta.getRichiestaId(), form.getFormId());

			// Controllo se la destinazione uso è associata al servizio
			DestinazioneUso destinazioneUso = presentatoreFormFrontendService.checkDestinazioneUso(Long.valueOf(destinazioneUsoId), servizio.getServizioId(), organizationId, groupId, companyId);

			if (Validator.isNotNull(destinazioneUso)) {
				if (destinazioneUso.isPagamentoBollo()) {
					daPagare = true;
				}
			}

			if (richiesta.getStato().equalsIgnoreCase(StatoRichiesta.BOZZA.name())) {

				// TODO: Controllare se firmaDocumentoAbilitata

				TipoServizio tipoServizio = TipoServizio.valueOf(procedura.getStep2TipoServizio());

				if (Validator.isNotNull(tipoServizio)) {

					// CERTIFICATO

					if (certificatiPdfPreviewEnabled) {

						String jsonDataBozza = istanzaForm.getJson();
						String codiceFiscaleComponente = ParamUtil.getString(renderRequest, "codiceFiscaleComponente");

						FormData formData = AlpacaUtil.loadFormData(form, jsonDataBozza, true, themeDisplay.getPortalURL());
						AlpacaJsonStructure alpacaStructure = formData.getAlpaca();
						JsonParser jsonParser = new JsonParser();
						alpacaStructure.setSchema(AlpacaUtil.addAttachmentsToSchema(gson.toJson(alpacaStructure.getSchema()), form.getListaDefinizioneAllegato()));
						alpacaStructure.setOptions(AlpacaUtil.loadOptions(gson.toJson(alpacaStructure.getOptions()), form.getListaDefinizioneAllegato(), true, themeDisplay.getPortalURL()));
						alpacaStructure.setData(jsonParser.parse(gson.toJson(alpacaStructure.getData())).getAsJsonObject());

						byte[] pdfFile = certificatoService.generaPDFCertificato(user.getScreenName(), user.getScreenName(), richiesta.getRichiestaId(), destinazioneUso.getDestinazioneUsoId(), null);

						if (Validator.isNotNull(pdfFile)) {
							encoded = new String(Base64.getEncoder().encode(pdfFile));

							renderRequest.setAttribute(PresentatoreFormsPortletKeys.BASE_64_PDF_CERTIFICATO, encoded);
							renderRequest.setAttribute(PresentatoreFormsPortletKeys.DOWNLOAD_CERTIFICATO, true);
							renderRequest.setAttribute(PresentatoreFormsPortletKeys.SELECT_COMPONENTI_NUCLEO_FAMILIARE, codiceFiscaleComponente);

						}

					}
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.TITOLO_PORTLET_SERVIZIO, servizio.getNome());
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.INVIO_ISTANZA, invioIstanza);
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.DA_PAGARE, daPagare);
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.DESTINAZIONE_USO_ID, destinazioneUsoId);
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.ANTEPRIMA_CERTIFICATI, certificatiPdfPreviewEnabled);
				}
			}

		}
		catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return PresentatoreFormsPortletKeys.JSP_SCEGLI_MODALITA_PAGAMENTO;

	}

}