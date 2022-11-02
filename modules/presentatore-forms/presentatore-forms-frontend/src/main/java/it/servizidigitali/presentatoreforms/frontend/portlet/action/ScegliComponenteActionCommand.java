package it.servizidigitali.presentatoreforms.frontend.portlet.action;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.MessageUtility;
import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.common.model.FormData;
import it.servizidigitali.presentatoreforms.common.service.AlpacaService;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;
import it.servizidigitali.scrivaniaoperatore.service.IstanzaFormLocalService;

/**
 * @author pindi
 *
 */
@Component(//
		immediate = true, //
		property = { //
				"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
				"mvc.command.name=" + PresentatoreFormsPortletKeys.SCEGLI_COMPONENTE_ACTION_COMMAND//
		}, //
		service = { MVCActionCommand.class }//
)
public class ScegliComponenteActionCommand extends BaseMVCActionCommand {

	public static final Log log = LogFactoryUtil.getLog(ScegliComponenteActionCommand.class);

	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private ProceduraFormLocalService proceduraFormLocalService;

	@Reference
	private IstanzaFormLocalService istanzaFormLocalService;

	@Reference
	private AlpacaService alpacaService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Procedura procedura = null;
		AlpacaJsonStructure alpacaStructure = null;
		Form form = null;

		try {
			procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
			form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());

			FormData formData = AlpacaUtil.loadFormData(form, null, true, themeDisplay.getPortalURL());
			alpacaStructure = formData.getAlpaca();

			String step2TipoServizio = procedura.getStep2TipoServizio();

			TipoServizio tipoServizio = TipoServizio.valueOf(step2TipoServizio);

			if (Validator.isNotNull(alpacaStructure)) {
				actionRequest.setAttribute(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE, alpacaStructure);
			}

			String codiceFiscaleComponente = ParamUtil.getString(actionRequest, PresentatoreFormsPortletKeys.SELECT_COMPONENTI_NUCLEO_FAMILIARE);

			if (Validator.isNull(codiceFiscaleComponente)) {
				SessionErrors.add(actionRequest, PresentatoreFormsPortletKeys.SELEZIONARE_COMPONENTE_NUCLEO);
				log.error("Selezionare un componente del nucleo familiare!");
				actionResponse.getRenderParameters().setValue("mvcRenderCommand", "/");
				return;
			}

			UserPreferences userPreferences = new UserPreferences();
			userPreferences.setCodiceFiscaleRichiedente(themeDisplay.getUser().getScreenName());
			userPreferences.setCodiceFiscaleComponente(codiceFiscaleComponente);

			Gson gson = new Gson();
			JsonObject data = gson.fromJson(gson.toJson(alpacaStructure.getData()), JsonObject.class);
			try {
				alpacaService.loadData(data, gson.toJson(alpacaStructure.getSchema()), gson.toJson(alpacaStructure.getOptions()), procedura, userPreferences);
				alpacaStructure.setData(data);
			}
			catch (BackofficeServiceException e) {
				alpacaStructure.setData(data);

				String errorMessage = null;
				MessageUtility messageUtility = new MessageUtility(PresentatoreFormsPortletKeys.BUNDLE_SYMBOLIC_NAME, themeDisplay.getLocale());
				if (e.getBackofficeServiceExceptionLanguageCode() != null) {
					errorMessage = messageUtility.getMessage(e.getBackofficeServiceExceptionLanguageCode().getLiferayLanguageKey());
				}

				if (tipoServizio != null && tipoServizio.equals(TipoServizio.VISURA) || tipoServizio.equals(TipoServizio.CERTIFICATO)) {
					errorMessage = messageUtility.getMessage(PresentatoreFormsPortletKeys.DATI_ANAGRAFICI_BACKOFFICE_NON_DISPONIBILI);
				}
				throw new RuntimeException(errorMessage, e);
			}

			// Sostituzione valore di data
			String dataString = gson.toJson(alpacaStructure.getData());
			JsonObject jsonData = gson.fromJson(dataString, JsonObject.class);
			alpacaStructure.setData(gson.toJsonTree(jsonData).getAsJsonObject());

			actionRequest.setAttribute(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE, alpacaStructure);
			actionRequest.setAttribute(PresentatoreFormsPortletKeys.API_ALPACA_PATH, themeDisplay.getPortalURL() + PresentatoreFormsPortletKeys.SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH);
			actionRequest.setAttribute(PresentatoreFormsPortletKeys.TIPO_SERVIZIO_STEP2, procedura.getStep2TipoServizio());

			// Aggiunta destinazioni d'uso in pagina se certificato
			if (tipoServizio.equals(TipoServizio.CERTIFICATO)) {
				List<DestinazioneUso> destinazioniUso = presentatoreFormFrontendService.getDestinazioniUso(themeDisplay);
				actionRequest.setAttribute(PresentatoreFormsPortletKeys.DESTINAZIONI_USO, destinazioniUso);
				actionRequest.setAttribute(PresentatoreFormsPortletKeys.TITOLO_PORTLET_SERVIZIO, form.getNome());
				actionRequest.setAttribute(PresentatoreFormsPortletKeys.SELECT_COMPONENTI_NUCLEO_FAMILIARE, codiceFiscaleComponente);
				actionResponse.getRenderParameters().setValue("mvcPath", PresentatoreFormsPortletKeys.JSP_SCEGLI_DESTINAZIONE_USO);
			}
			else {
				actionResponse.getRenderParameters().setValue("mvcPath", PresentatoreFormsPortletKeys.JSP_COMPILA_FORM);
			}
		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, PresentatoreFormsPortletKeys.GENERIC_ERROR_MESSAGE_KEY, e.getMessage());
			actionResponse.getRenderParameters().setValue("mvcRenderCommand", "/");
		}
	}
}