package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.commmon.ComponenteNucleoFamiliare;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.DatiAnagraficiPortletService;
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
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

@Component(//
		immediate = true, //
		property = { //

				"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=PresentatoreForms", //
				"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp", //
				"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
				"mvc.command.name=" + "/caricaCompilaIstanza"//
		}, //
		service = MVCRenderCommand.class//
) //
public class CaricaCompilaIstanzaRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(CaricaCompilaIstanzaRenderCommand.class.getName());

	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;

	@Reference
	private AlpacaService alpacaService;

	@Reference
	private DatiAnagraficiPortletService datiAnagraficiPortletService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		String isBozza = PortalUtil.getOriginalServletRequest(request).getParameter("isBozza");

		FormData formData = null;
		AlpacaJsonStructure alpacaStructure = null;
		String jsonDataBozza = null;
		String screenName = themeDisplay.getUser().getScreenName();

		Gson gson = new Gson();
		try {
			User currentUser = themeDisplay.getUser();

			Procedura procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
			Form form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());
			Richiesta richiestaBozza = presentatoreFormFrontendService.getRichiestaBozza(currentUser.getScreenName(), procedura.getProceduraId());
			IstanzaForm istanzaFormRichiesta = presentatoreFormFrontendService.getIstanzaFormRichiesta(richiestaBozza.getRichiestaId(), form.getFormId());

			boolean stepComponentiFamiliari = procedura.getStep1Attivo();
			String filtroComponentiFamiliari = procedura.getStep1TipoComponentiNucleoFamiliare();

			String step2TipoServizio = procedura.getStep2TipoServizio();
			TipoServizio tipoServizio = TipoServizio.valueOf(step2TipoServizio);

			if (Boolean.valueOf(isBozza) && istanzaFormRichiesta != null) {
				
				if(!tipoServizio.equals(TipoServizio.CERTIFICATO)) {
					jsonDataBozza = gson.toJson(gson.fromJson(istanzaFormRichiesta.getJson(), FormData.class));
				}
				
				formData = AlpacaUtil.loadFormData(form, jsonDataBozza, true, themeDisplay.getPortalURL());
				alpacaStructure = formData.getAlpaca();
				
				if(tipoServizio.equals(tipoServizio.CERTIFICATO)) {
					List<DestinazioneUso> destinazioniUso = presentatoreFormFrontendService.getDestinazioniUso(themeDisplay);
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE, alpacaStructure);
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.API_ALPACA_PATH, themeDisplay.getPortalURL() + PresentatoreFormsPortletKeys.SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH);
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.TIPO_SERVIZIO_STEP2, procedura.getStep2TipoServizio());
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.DESTINAZIONI_USO, destinazioniUso);
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.TITOLO_PORTLET_SERVIZIO, form.getNome());
					return PresentatoreFormsPortletKeys.JSP_SCEGLI_DESTINAZIONE_USO;
				}
			}
			else {

				try {

					presentatoreFormFrontendService.deleteRichiesteBozzaUtente(screenName, procedura.getProceduraId(), form.getFormId());

					if (stepComponentiFamiliari) {
						Long organizationId = themeDisplay.getSiteGroup().getOrganizationId();
						String codiceFiscale = screenName;

						IntegrationPreferences integrationPreferences = new IntegrationPreferences();
						integrationPreferences.setUsaCache(procedura.isAbilitaCacheIntegrazioneBackoffice());

						List<ComponenteNucleoFamiliare> componentiNucleoFamiliare = datiAnagraficiPortletService.getComponentiNucleoFamiliare(codiceFiscale, organizationId, integrationPreferences);
						renderRequest.setAttribute(PresentatoreFormsPortletKeys.COMPONENTI_NUCLEO_FAMILIARE, componentiNucleoFamiliare);
						renderRequest.setAttribute(PresentatoreFormsPortletKeys.CODICE_FISCALE_MANUALE, codiceFiscale);
						renderRequest.setAttribute(PresentatoreFormsPortletKeys.FILTRO_COMPONENTI_FAMILIARI, filtroComponentiFamiliari);

						return PresentatoreFormsPortletKeys.JSP_SCEGLI_COMPONENTI_NUCLEO;

					}
					else {
						formData = AlpacaUtil.loadFormData(form, null, true, themeDisplay.getPortalURL());
						alpacaStructure = formData.getAlpaca();

						UserPreferences userPreferences = new UserPreferences();
						userPreferences.setCodiceFiscaleRichiedente(screenName);

						if (PortalUtil.getHttpServletRequest(renderRequest).getSession().getAttribute(PresentatoreFormsPortletKeys.USER_PREFERENCES_ATTRIBUTE_NAME) != null) {
							userPreferences = (UserPreferences) PortalUtil.getHttpServletRequest(renderRequest).getSession().getAttribute(PresentatoreFormsPortletKeys.USER_PREFERENCES_ATTRIBUTE_NAME);
						}

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
								log.error("renderizzaAlpacaForm :: impossibile caricare le informazioni dal backoffice per il Comune : " + themeDisplay.getScopeGroup().getName() + " :: "
										+ e.getMessage(), e);
								throw e;
							}
						}

						String dataString = gson.toJson(alpacaStructure.getData());
						JsonObject jsonData = gson.fromJson(dataString, JsonObject.class);
						alpacaStructure.setData(gson.toJsonTree(jsonData).getAsJsonObject());
						renderRequest.setAttribute(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE, alpacaStructure);

						// Aggiunta destinazioni d'uso in pagina se certificato
						if (tipoServizio.equals(TipoServizio.CERTIFICATO)) {
							List<DestinazioneUso> destinazioniUso = presentatoreFormFrontendService.getDestinazioniUso(themeDisplay);
							renderRequest.setAttribute(PresentatoreFormsPortletKeys.DESTINAZIONI_USO, destinazioniUso);
						}
					}
				}
				catch (Exception e) {
					log.error(e.getMessage(), e);
				}

			}

			// Sostituzione valore di data
			String data = gson.toJson(alpacaStructure.getData());
			JsonObject jsonData = gson.fromJson(data, JsonObject.class);
			alpacaStructure.setData(gson.toJsonTree(jsonData).getAsJsonObject());

			AlpacaUtil.convertiComponentiAlpacaStructure(alpacaStructure);
			// Carica la view se presente
			AlpacaUtil.loadView(alpacaStructure);

			renderRequest.setAttribute(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE, alpacaStructure);
			renderRequest.setAttribute(PresentatoreFormsPortletKeys.API_ALPACA_PATH, themeDisplay.getPortalURL() + PresentatoreFormsPortletKeys.SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH);
			renderRequest.setAttribute(PresentatoreFormsPortletKeys.TIPO_SERVIZIO_STEP2, procedura.getStep2TipoServizio());
			return PresentatoreFormsPortletKeys.JSP_COMPILA_FORM;

		}
		catch (Exception e) {
			SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_PROCEDURA);
			log.error("Errore durante il caricamento della bozza all'utente! " + e.getMessage(), e);
			return PresentatoreFormsPortletKeys.JSP_HOME;
		}

	}

}
