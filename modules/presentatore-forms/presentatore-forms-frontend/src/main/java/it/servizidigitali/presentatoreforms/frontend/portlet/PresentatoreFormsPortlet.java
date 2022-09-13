package it.servizidigitali.presentatoreforms.frontend.portlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.commmon.ComponenteNucleoFamiliare;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.DatiAnagraficiPortletService;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.AlpacaService;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;

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
				"com.liferay.portlet.footer-portlet-javascript=/libs/jquery-ui-dist/jquery-ui.min.js", //
				"com.liferay.portlet.footer-portlet-javascript=/libs/jquery-blockui/jquery.blockUI.js", //
				"com.liferay.portlet.footer-portlet-javascript=/libs/jquery.handsontable/jquery.handsontable.full.js", //
				"com.liferay.portlet.footer-portlet-javascript=/libs/moment/moment-with-locales.min.js", //
				"com.liferay.portlet.footer-portlet-javascript=/libs/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js", //
				"com.liferay.portlet.footer-portlet-javascript=/libs/alpaca-custom/alpaca.min.js", //
				"com.liferay.portlet.footer-portlet-javascript=/dist/custom-fields.min.js", //
				"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=PresentatoreForms", //
				"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp", //
				"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
				"javax.portlet.resource-bundle=content.Language", //
				"javax.portlet.security-role-ref=power-user,user" }, //
		service = Portlet.class //
)
public class PresentatoreFormsPortlet extends MVCPortlet {

	public static final Log log = LogFactoryUtil.getLog(PresentatoreFormsPortlet.class);

	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Reference
	private FormLocalService formLocalService;

	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;

	@Reference
	private AlpacaService alpacaService;

	@Reference
	private DatiAnagraficiPortletService datiAnagraficiPortletService;

	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		log.info("render presentatore forms");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			Procedura procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);

			boolean stepComponentiFamiliari = procedura.getStep1Attivo();
			String filtroComponentiFamiliari = procedura.getStep1TipoComponentiNucleoFamiliare();

			boolean bozza = false;

			if (bozza) {
				include("/home.jsp", renderRequest, renderResponse);
			}
			else {
				if (!PresentatoreFormsPortletKeys.SCEGLI_ALLEGATI_RENDER_COMMAND.equals(ParamUtil.getString(renderRequest, "mvcRenderCommandName"))
						&& !PresentatoreFormsPortletKeys.HOME_RENDER_COMMAND.equals(ParamUtil.getString(renderRequest, "mvcRenderCommandName"))) {

					try {

						if (stepComponentiFamiliari) {
							Long organizationId = themeDisplay.getSiteGroup().getOrganizationId();
							String codiceFiscale = themeDisplay.getUser().getScreenName();

							IntegrationPreferences integrationPreferences = new IntegrationPreferences();
							integrationPreferences.setUsaCache(procedura.isAbilitaCacheIntegrazioneBackoffice());

							List<ComponenteNucleoFamiliare> componentiNucleoFamiliare = datiAnagraficiPortletService.getComponentiNucleoFamiliare(codiceFiscale, organizationId,
									integrationPreferences);
							renderRequest.setAttribute("componentiNucleoFamiliare", componentiNucleoFamiliare);
							renderRequest.setAttribute("codiceFiscaleManuale", codiceFiscale);
							renderRequest.setAttribute("filtroComponentiFamiliari", filtroComponentiFamiliari);

							include("/scegliComponentiNucleoFamiliare.jsp", renderRequest, renderResponse);

						}
						else {
							try {

								Long idFormMock = 52402L;
								Form form = formLocalService.getForm(idFormMock);
								form.setListaDefinizioneAllegato(definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(idFormMock));

								FormData formData = AlpacaUtil.loadFormData(form, null, true);
								AlpacaJsonStructure alpacaStructure = formData.getAlpaca();

								UserPreferences userPreferences = new UserPreferences();

								if (PortalUtil.getHttpServletRequest(renderRequest).getSession().getAttribute(PresentatoreFormsPortletKeys.USER_PREFERENCES_ATTRIBUTE_NAME) != null) {
									userPreferences = (UserPreferences) PortalUtil.getHttpServletRequest(renderRequest).getSession()
											.getAttribute(PresentatoreFormsPortletKeys.USER_PREFERENCES_ATTRIBUTE_NAME);
								}

								Gson gson = new Gson();
								JsonObject data = gson.fromJson(gson.toJson(alpacaStructure.getData()), JsonObject.class);

								alpacaService.loadData(data, gson.toJson(alpacaStructure.getSchema()), gson.toJson(alpacaStructure.getOptions()), procedura, userPreferences);
								renderRequest.setAttribute(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE, alpacaStructure);
								include("/compilaForm.jsp", renderRequest, renderResponse);

							}
							catch (Exception e) {
								log.error(e.getMessage());
							}

						}

					}
					catch (Exception e) {
						log.error(e.getMessage());
					}

				}
			}
		}
		catch (PortalException e) {
			log.error("render :: " + e.getMessage(), e);
		}

		super.render(renderRequest, renderResponse);

	}
}