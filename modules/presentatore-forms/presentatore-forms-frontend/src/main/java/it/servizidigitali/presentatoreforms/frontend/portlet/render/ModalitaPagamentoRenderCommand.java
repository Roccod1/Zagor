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

import it.servizidigitali.common.utility.enumeration.TipoGenerazionePDF;
import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.PDFService;
import it.servizidigitali.presentatoreforms.frontend.service.PDFServiceFactory;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=" + PresentatoreFormsPortletKeys.SCEGLI_MODALITA_PAGAMENTO_RENDER_COMMAND
		},
		service = MVCRenderCommand.class
	)
public class ModalitaPagamentoRenderCommand implements MVCRenderCommand{
	
	public static final Log _log = LogFactoryUtil.getLog(ModalitaPagamentoRenderCommand.class);
	
	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;
	
	@Reference
	private ServizioLocalService servizioLocalService;
	
	@Reference
	private PDFServiceFactory pdfServiceFactory;
	
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
		
		String encoded = null;
		
		long destinazioneUsoId = ParamUtil.getLong(renderRequest, "destinazioneUsoId");
		
		Gson gson = new Gson();
		
		try {
			
			procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
			
			if(Validator.isNull(procedura)) {
				SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_PROCEDURA);
				return PresentatoreFormsPortletKeys.JSP_VIEW;
			}
			
			form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());
			richiesta = presentatoreFormFrontendService.getRichiestaBozza(user.getScreenName(), procedura.getProceduraId());
			servizio = servizioLocalService.getServizio(procedura.getServizioId());
			istanzaForm = presentatoreFormFrontendService.getIstanzaFormRichiesta(richiesta.getRichiestaId(), form.getFormId());
			
			PDFService pdfService = pdfServiceFactory.getPDFService(TipoGenerazionePDF.valueOf(procedura.getTipoGenerazionePDF()));
			
			// Controllo se la destinazione uso è associata al servizio
			
			DestinazioneUso destinazioneUso = presentatoreFormFrontendService.checkDestinazioneUso(destinazioneUsoId, servizio.getServizioId(), organizationId, groupId, companyId);
			
			if(Validator.isNotNull(destinazioneUso)) {
				if(destinazioneUso.isPagamentoBollo()) {
					daPagare = true;
				}
			}

			if(richiesta.getStato().equalsIgnoreCase(StatoRichiesta.BOZZA.name())) {
				
				// TODO: Controllare se firmaDocumentoAbilitata
				
				TipoServizio tipoServizio = TipoServizio.valueOf(procedura.getStep2TipoServizio());
				
				if(Validator.isNotNull(tipoServizio)) {
										
					// CERTIFICATO
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.INVIO_ISTANZA, false);
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.DA_PAGARE, daPagare);
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.DESTINAZIONE_USO_ID, destinazioneUsoId);
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.ANTEPRIMA_CERTIFICATI, certificatiPdfPreviewEnabled); 
					
					if(certificatiPdfPreviewEnabled) {
						
						String jsonDataBozza = istanzaForm.getJson();
						
						FormData formData = AlpacaUtil.loadFormData(form, jsonDataBozza, true, themeDisplay.getPortalURL());
						AlpacaJsonStructure alpacaStructure = formData.getAlpaca();
						
						alpacaStructure.setSchema(AlpacaUtil.addAttachmentsToSchema(gson.toJson(alpacaStructure.getSchema()), form.getListaDefinizioneAllegato()));
						alpacaStructure.setOptions(AlpacaUtil.loadOptions(gson.toJson(alpacaStructure.getOptions()), form.getListaDefinizioneAllegato(), true, themeDisplay.getPortalURL()));
						alpacaStructure.setData(JsonParser.parseString(gson.toJson(alpacaStructure.getData())).getAsJsonObject());
						
						byte[] pdfFile = pdfService.generaPDFCertificato(user.getScreenName(), user.getScreenName(), alpacaStructure, richiesta, destinazioneUsoId, null, renderRequest);
						
						if(Validator.isNotNull(pdfFile)) {
							encoded = new String(Base64.getEncoder().encode(pdfFile));
							renderRequest.setAttribute(PresentatoreFormsPortletKeys.BASE_64_PDF_CERTIFICATO, encoded);
						}

					}
				}
			}
			
		}catch(Exception e) {
			_log.error(e.getMessage(),e);
		}
		
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.TITOLO_PORTLET_SERVIZIO, form.getNome());
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.DA_PAGARE, true);
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.DOWNLOAD_CERTIFICATO, true);
		
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.CERTIFICATI_PREVIEW_ABILITATA, certificatiPdfPreviewEnabled);
		
		return PresentatoreFormsPortletKeys.JSP_SCEGLI_MODALITA_PAGAMENTO;
	}

}