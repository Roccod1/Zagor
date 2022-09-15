package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.AlpacaService;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=" + "/caricaCompilaIstanza"
		},
		service = MVCRenderCommand.class
	)
public class CaricaCompilaIstanzaRenderCommand implements MVCRenderCommand{
	
	private static final Log log = LogFactoryUtil.getLog(CaricaCompilaIstanzaRenderCommand.class.getName());
	
	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;
	
	@Reference
	private AlpacaService alpacaService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long richiestaId = ParamUtil.getLong(renderRequest, "richiestaId");
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		String isBozza = PortalUtil.getOriginalServletRequest(request).getParameter("isBozza");
		
		// TODO: Recuperare istanzaForm attraverso il finder
		
		IstanzaForm istanzaForm = null;
		FormData formData = null;
		AlpacaJsonStructure alpacaStructure = null;
		
		try {
			Procedura procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);	
			Form form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());
			
			UserPreferences userPreferences = new UserPreferences();
			userPreferences.setCodiceFiscaleRichiedente(themeDisplay.getUser().getScreenName());

			if (PortalUtil.getHttpServletRequest(renderRequest).getSession().getAttribute(PresentatoreFormsPortletKeys.USER_PREFERENCES_ATTRIBUTE_NAME) != null) {
				userPreferences = (UserPreferences) PortalUtil.getHttpServletRequest(renderRequest).getSession()
						.getAttribute(PresentatoreFormsPortletKeys.USER_PREFERENCES_ATTRIBUTE_NAME);
			}

			if(Boolean.valueOf(isBozza)) {
				formData = AlpacaUtil.loadFormData(form, istanzaForm.getJson(), true);
				alpacaStructure = formData.getAlpaca();
			}else {
				formData = AlpacaUtil.loadFormData(form, null, true);
				alpacaStructure = formData.getAlpaca();
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
					String step2TipoServizio = procedura.getStep2TipoServizio();
					TipoServizio tipoServizio = TipoServizio.valueOf(step2TipoServizio);
					if (tipoServizio != null && tipoServizio.equals(TipoServizio.VISURA) || tipoServizio.equals(TipoServizio.CERTIFICATO)) {
						log.error("renderizzaAlpacaForm :: impossibile caricare le informazioni dal backoffice per il Comune : " + themeDisplay.getScopeGroup().getName() + " :: "
								+ e.getMessage(), e);
						throw e;
					}
				}

			}
			renderRequest.setAttribute(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE, alpacaStructure);
			
			return PresentatoreFormsPortletKeys.JSP_COMPILA_FORM;
			
		}catch(Exception e) {
			SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_PROCEDURA);
			// TODO: Capire dove renderizzare
			log.error("Errore durante il caricamento della bozza all'utente!" + e.getMessage());
			return null;
		}
				
		
	}

}
