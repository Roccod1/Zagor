package it.servizidigitali.presentatoreforms.frontend.portlet.action;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.AlpacaService;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;
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

		try {
			procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
			alpacaStructure = getAlpacaJsonStructure(procedura,themeDisplay);

			String step2TipoServizio = procedura.getStep2TipoServizio();

			TipoServizio tipoServizio = TipoServizio.valueOf(step2TipoServizio);

			if (Validator.isNotNull(alpacaStructure)) {
				actionRequest.setAttribute("alpacaStructure", alpacaStructure);
			}

			String codiceFiscaleComponente = ParamUtil.getString(actionRequest, PresentatoreFormsPortletKeys.SELECT_COMPONENTI_NUCLEO_FAMILIARE);
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
				log.error("render :: " + e.getMessage(), e);
				alpacaStructure.setData(data);

				if (e.getConditionCode() != 0) {
					throw e;
				}

				if (tipoServizio != null && tipoServizio.equals(TipoServizio.VISURA) || tipoServizio.equals(TipoServizio.CERTIFICATO)) {
					log.error("renderizzaAlpacaForm :: impossibile caricare le informazioni dal backoffice per il Comune : " + themeDisplay.getScopeGroup().getName() + " :: " + e.getMessage(), e);
					throw e;
				}
			}

			// Sostituzione valore di data
			String dataString = gson.toJson(alpacaStructure.getData());
			JsonObject jsonData = gson.fromJson(dataString, JsonObject.class);
			alpacaStructure.setData(gson.toJsonTree(jsonData).getAsJsonObject());

			actionRequest.setAttribute(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE, alpacaStructure);

			if (tipoServizio.equals(TipoServizio.CERTIFICATO)) {
				List<String> lstDestinazioniUso = getListaDestinazioniUso();
				actionRequest.setAttribute("destinazioniUso", lstDestinazioniUso);
				// TODO
			}
		}
		catch (Exception e) {
			log.error(e);
			actionResponse.getRenderParameters().setValue("mvcPath", PresentatoreFormsPortletKeys.JSP_SCEGLI_COMPONENTI_NUCLEO);
		}

		actionResponse.getRenderParameters().setValue("mvcPath", PresentatoreFormsPortletKeys.JSP_COMPILA_FORM);

	}

	private AlpacaJsonStructure getAlpacaJsonStructure(Procedura procedura, ThemeDisplay themeDisplay) {

		Form form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());

		FormData formData = AlpacaUtil.loadFormData(form, null, true, themeDisplay.getPortalURL());
		AlpacaJsonStructure alpacaStructure = formData.getAlpaca();

		return alpacaStructure;

	}

	private List<String> getListaDestinazioniUso() {
		List<String> lstDestinazioniUso = new ArrayList<String>();
		lstDestinazioniUso.add("Bollo");
		lstDestinazioniUso.add("Esenzione");

		return lstDestinazioniUso;
	}

}
