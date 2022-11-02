package it.servizidigitali.presentatoreforms.frontend.portlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.commmon.ComponenteNucleoFamiliare;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.DatiAnagraficiPortletService;
import it.servizidigitali.common.utility.MessageUtility;
import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.common.model.FormData;
import it.servizidigitali.presentatoreforms.common.service.AlpacaService;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

/**
 * @author pindi
 */
@Component(immediate = true, //
		property = { //
				"com.liferay.portlet.display-category=category.servizidigitali", //
				"com.liferay.portlet.header-portlet-css=/css/main.css", //
				"com.liferay.portlet.header-portlet-css=/libs/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css", //
				"com.liferay.portlet.header-portlet-css=/libs/alpaca-custom/alpaca.css", //
				"com.liferay.portlet.header-portlet-css=/libs/jquery.handsontable/jquery.handsontable.full.css", //
				"com.liferay.portlet.footer-portlet-javascript=/libs/handlebars/handlebars.min.js", //
				"com.liferay.portlet.footer-portlet-javascript=/libs/moment/moment-with-locales.min.js", //
				"com.liferay.portlet.footer-portlet-javascript=/libs/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js", //
				"com.liferay.portlet.footer-portlet-javascript=/libs/jquery-ui-dist/jquery-ui.min.js", //
				"com.liferay.portlet.footer-portlet-javascript=/libs/jquery-blockui/jquery.blockUI.js", //
				"com.liferay.portlet.footer-portlet-javascript=/libs/jquery.handsontable/jquery.handsontable.full.js", //
				"com.liferay.portlet.footer-portlet-javascript=/libs/alpaca-custom/alpaca.min.js", //
				"com.liferay.portlet.footer-portlet-javascript=/dist/custom-fields.min.js", //
				"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=PresentatoreForms", //
				"com.liferay.portlet.single-page-application=false", "javax.portlet.init-param.template-path=/", //
				"javax.portlet.init-param.view-template=/view.jsp", //
				"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
				"javax.portlet.resource-bundle=content.Language", //
				"javax.portlet.security-role-ref=power-user,user" }, //
		service = Portlet.class //
)
public class PresentatoreFormsPortlet extends MVCPortlet {

	public static final Log log = LogFactoryUtil.getLog(PresentatoreFormsPortlet.class);

	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Reference
	private AlpacaService alpacaService;

	@Reference
	private DatiAnagraficiPortletService datiAnagraficiPortletService;

	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		log.debug("render presentatore forms.");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			Procedura procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);

			if (procedura == null) {
				SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_PROCEDURA);
				return;
			}

			String screenName = themeDisplay.getUser().getScreenName();

			Richiesta richiesta = presentatoreFormFrontendService.getRichiestaBozza(screenName, procedura.getProceduraId());

			String step2TipoServizio = procedura.getStep2TipoServizio();
			TipoServizio tipoServizio = TipoServizio.valueOf(step2TipoServizio);

			boolean stepComponentiFamiliari = procedura.getStep1Attivo();
			String filtroComponentiFamiliari = procedura.getStep1TipoComponentiNucleoFamiliare();

			String mvcRenderCommandName = ParamUtil.getString(renderRequest, "mvcRenderCommandName");
			String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
			if (Validator.isNull(mvcRenderCommandName) && Validator.isNull(mvcPath)) {
				if (Validator.isNotNull(richiesta) && richiesta.getStato().equalsIgnoreCase(StatoRichiesta.BOZZA.name())) {
					renderRequest.setAttribute(PresentatoreFormsPortletKeys.RICHIESTA_ID, richiesta.getRichiestaId());
					include(PresentatoreFormsPortletKeys.JSP_HOME, renderRequest, renderResponse);
				}
				else {
					try {

						if (stepComponentiFamiliari) {
							Long organizationId = themeDisplay.getSiteGroup().getOrganizationId();
							String codiceFiscale = screenName;

							IntegrationPreferences integrationPreferences = new IntegrationPreferences();
							integrationPreferences.setUsaCache(procedura.isAbilitaCacheIntegrazioneBackoffice());

							List<ComponenteNucleoFamiliare> componentiNucleoFamiliare = datiAnagraficiPortletService.getComponentiNucleoFamiliare(codiceFiscale, organizationId,
									integrationPreferences);

							if (tipoServizio != null && (tipoServizio.equals(TipoServizio.VISURA) || tipoServizio.equals(TipoServizio.CERTIFICATO))
									&& (componentiNucleoFamiliare == null || componentiNucleoFamiliare.isEmpty())) {
								MessageUtility messageUtility = new MessageUtility(PresentatoreFormsPortletKeys.BUNDLE_SYMBOLIC_NAME, themeDisplay.getLocale());
								String errorMessage = messageUtility.getMessage(PresentatoreFormsPortletKeys.DATI_ANAGRAFICI_BACKOFFICE_NON_DISPONIBILI);
								throw new RuntimeException(errorMessage);
							}

							renderRequest.setAttribute(PresentatoreFormsPortletKeys.COMPONENTI_NUCLEO_FAMILIARE, componentiNucleoFamiliare);
							renderRequest.setAttribute(PresentatoreFormsPortletKeys.CODICE_FISCALE_MANUALE, codiceFiscale);
							renderRequest.setAttribute(PresentatoreFormsPortletKeys.FILTRO_COMPONENTI_FAMILIARI, filtroComponentiFamiliari);

							include(PresentatoreFormsPortletKeys.JSP_SCEGLI_COMPONENTI_NUCLEO, renderRequest, renderResponse);

						}
						else {

							Form form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());

							FormData formData = AlpacaUtil.loadFormData(form, null, true, themeDisplay.getPortalURL());
							AlpacaJsonStructure alpacaStructure = formData.getAlpaca();

							UserPreferences userPreferences = new UserPreferences();
							userPreferences.setCodiceFiscaleRichiedente(screenName);

							if (PortalUtil.getHttpServletRequest(renderRequest).getSession().getAttribute(PresentatoreFormsPortletKeys.USER_PREFERENCES_ATTRIBUTE_NAME) != null) {
								userPreferences = (UserPreferences) PortalUtil.getHttpServletRequest(renderRequest).getSession()
										.getAttribute(PresentatoreFormsPortletKeys.USER_PREFERENCES_ATTRIBUTE_NAME);
							}

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
								throw new RuntimeException(errorMessage);
							}

							// Sostituzione valore di data
							String dataString = gson.toJson(alpacaStructure.getData());
							JsonObject jsonData = gson.fromJson(dataString, JsonObject.class);
							alpacaStructure.setData(gson.toJsonTree(jsonData).getAsJsonObject());

							renderRequest.setAttribute(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE, alpacaStructure);
							renderRequest.setAttribute(PresentatoreFormsPortletKeys.API_ALPACA_PATH,
									themeDisplay.getPortalURL() + PresentatoreFormsPortletKeys.SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH);
							renderRequest.setAttribute(PresentatoreFormsPortletKeys.TIPO_SERVIZIO_STEP2, procedura.getStep2TipoServizio());

							// Aggiunta destinazioni d'uso in pagina se certificato
							if (tipoServizio.equals(TipoServizio.CERTIFICATO)) {
								List<DestinazioneUso> destinazioniUso = presentatoreFormFrontendService.getDestinazioniUso(themeDisplay);
								renderRequest.setAttribute(PresentatoreFormsPortletKeys.DESTINAZIONI_USO, destinazioniUso);
								renderRequest.setAttribute(PresentatoreFormsPortletKeys.TITOLO_PORTLET_SERVIZIO, form.getNome());
								include(PresentatoreFormsPortletKeys.JSP_SCEGLI_DESTINAZIONE_USO, renderRequest, renderResponse);
							}
							else {
								include(PresentatoreFormsPortletKeys.JSP_COMPILA_FORM, renderRequest, renderResponse);
							}
						}
					}
					catch (Exception e) {
						log.error(e.getMessage(), e);
						SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.GENERIC_ERROR_MESSAGE_KEY, e.getMessage());
						include(PresentatoreFormsPortletKeys.JSP_ERROR, renderRequest, renderResponse);
						return;
					}
				}
			}
		}
		catch (PortalException e) {
			log.error("render :: " + e.getMessage(), e);
		}

		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

		super.render(renderRequest, renderResponse);

	}
}