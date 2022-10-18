package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneforms.service.TipoDocumentoLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.presentatoreforms.frontend.configuration.UploadFileRichiesteEnteConfiguration;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AllegatoUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.DatiAllegato;
import it.servizidigitali.presentatoreforms.frontend.util.model.DatiFileAllegato;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;


/**
 * @author COSTABILEE
 *
 */
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=" + PresentatoreFormsPortletKeys.SCEGLI_ALLEGATI_RENDER_COMMAND
		},
		service = MVCRenderCommand.class
	)
public class ScegliAllegatiRenderCommand implements MVCRenderCommand{
	
	private ConfigurationProvider configurationProvider;
	
	private volatile UploadFileRichiesteEnteConfiguration uploadFileRichiesteEnteConfiguration;

	public static final Log _log = LogFactoryUtil.getLog(ScegliAllegatiRenderCommand.class);
	
	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}
		
	@Reference
	private FormLocalService formLocalService;
	
	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;
	
	@Reference
	private TipoDocumentoLocalService tipoDocumentoLocalService;
	
	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		_log.info("render scegliAllegati");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	
		User user = themeDisplay.getUser();
		Gson gson = new Gson();
		
		Form form = null;
		Procedura procedura = null;
		Richiesta richiesta = null;
		IstanzaForm istanzaForm = null;
		ServizioEnte servizioEnte = null;
		
		boolean firmaDocumentoAbilitata = false;
		
		try {
			uploadFileRichiesteEnteConfiguration = configurationProvider.getGroupConfiguration(UploadFileRichiesteEnteConfiguration.class, themeDisplay.getScopeGroupId());
			procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
			form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());
			richiesta = presentatoreFormFrontendService.getRichiestaBozza(user.getScreenName(), procedura.getProceduraId());
			istanzaForm = presentatoreFormFrontendService.getIstanzaFormRichiesta(richiesta.getRichiestaId(), form.getFormId());
			servizioEnte = presentatoreFormFrontendService.getServizioEnteByPage(themeDisplay);
			
			if(Validator.isNotNull(servizioEnte)) {
				firmaDocumentoAbilitata = servizioEnte.getRichiestaFirma();
			}
			
		} catch (Exception e) {
			_log.error("errore nel recupero del form: " + form.getFormId() + " :: ERORR MESSAGE: " + e.getMessage());
		}
		
		List<DefinizioneAllegato> definizioneAllegati = definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(form.getFormId());
		
		List<DatiAllegato> allegati = AllegatoUtil.mergeDefinizioneAndData(definizioneAllegati, new ArrayList<DatiFileAllegato>());
		
		String jsonAlpaca = istanzaForm.getJson();

		if(Validator.isNotNull(jsonAlpaca)) {
			JsonObject jsonAlpacaObject = gson.fromJson(jsonAlpaca, JsonObject.class);
			JsonElement istanzaDaFirmareObject = jsonAlpacaObject.getAsJsonObject("alpaca").getAsJsonObject("data").get("isIstanzaDaFirmare");
			if (istanzaDaFirmareObject != null && firmaDocumentoAbilitata) {
				firmaDocumentoAbilitata = istanzaDaFirmareObject.getAsBoolean();
			}
		}
		
		String step2TipoServizio = procedura.getStep2TipoServizio();
		TipoServizio tipoServizio = TipoServizio.valueOf(step2TipoServizio);
		
		switch (tipoServizio) {
		case DICHIARAZIONE:
			renderRequest.setAttribute(PresentatoreFormsPortletKeys.INVIO_ISTANZA,true);
			break;
		case CONCORSO:
			renderRequest.setAttribute(PresentatoreFormsPortletKeys.INVIO_ISTANZA,true);
			break;
		case PAGAMENTO:
			break;
		case CERTIFICATO:
			renderRequest.setAttribute(PresentatoreFormsPortletKeys.INVIO_ISTANZA,false);
			break;
		case VISURA:
			break;
		case AUTO_DICHIARAZIONE:
			renderRequest.setAttribute(PresentatoreFormsPortletKeys.INVIO_ISTANZA,false);
			break;
		default:
			break;
		}
		
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.TITOLO_PORTLET_SERVIZIO,form.getNome());
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.FIRMA_DOCUMENTO_ABILITATA,firmaDocumentoAbilitata);	
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.UPLOAD_FILE_MAX_SIZE,uploadFileRichiesteEnteConfiguration.maxUploadRichiesteFileSize());
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.UPLOAD_FILE_MAX_SIZE_LABEL,Long.toString(uploadFileRichiesteEnteConfiguration.maxUploadRichiesteFileSize() / 1000000) + " MB");
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.LISTA_ALLEGATI, allegati);
		
		// TODO: Capire in base a cosa e quando
		
//		renderRequest.setAttribute("evaluationServiceEnable",false);
		
		return PresentatoreFormsPortletKeys.JSP_SCEGLI_ALLEGATI;
	}

}
