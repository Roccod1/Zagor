package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
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

@Component(//
		immediate = true, //
		property = { //
				"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
				"mvc.command.name=" + PresentatoreFormsPortletKeys.HOME_RENDER_COMMAND //
		}, //
		service = MVCRenderCommand.class//
)
public class HomeRenderCommand implements MVCRenderCommand {

	public static final Log log = LogFactoryUtil.getLog(HomeRenderCommand.class);

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
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Procedura procedura = null;
		AlpacaJsonStructure alpacaStructure = null;

		List<String> lstDestinazioniUso = getListaDestinazioniUso();

		try {
			procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
			alpacaStructure = getAlpacaJsonStructure(procedura);

			String step2TipoServizio = procedura.getStep2TipoServizio();

			TipoServizio tipoServizio = TipoServizio.valueOf(step2TipoServizio);

			if (Validator.isNotNull(alpacaStructure)) {
				renderRequest.setAttribute("alpacaStructure", alpacaStructure);
			}

			String codiceFiscaleComponente = ParamUtil.getString(renderRequest, PresentatoreFormsPortletKeys.SELECT_COMPONENTI_NUCLEO_FAMILIARE);
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

			renderRequest.setAttribute(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE, alpacaStructure);

			if (tipoServizio.equals(TipoServizio.CERTIFICATO)) {
				return PresentatoreFormsPortletKeys.JSP_SCEGLI_DESTINAZIONE_USO;
			}
			else {
				return PresentatoreFormsPortletKeys.JSP_COMPILA_FORM;
			}
		}
		catch (Exception e) {
			log.error(e);
			// TODO gestire errori in pagina
		}

		renderRequest.setAttribute("destinazioniUso", lstDestinazioniUso);

		return PresentatoreFormsPortletKeys.JSP_HOME;

	}

	private AlpacaJsonStructure getAlpacaJsonStructure(Procedura procedura) {

		Form form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());

		FormData formData = AlpacaUtil.loadFormData(form, null, true);
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