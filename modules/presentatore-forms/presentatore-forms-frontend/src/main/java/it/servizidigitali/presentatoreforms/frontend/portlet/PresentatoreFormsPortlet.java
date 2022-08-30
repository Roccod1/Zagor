package it.servizidigitali.presentatoreforms.frontend.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.AlpacaService;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;

/**
 * @author pindi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servizidigitali",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/libs/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css",
		"com.liferay.portlet.header-portlet-css=/libs/alpaca-custom/alpaca.css",
		"com.liferay.portlet.header-portlet-css=/libs/jquery.handsontable/jquery.handsontable.full.css",
		"com.liferay.portlet.footer-portlet-javascript=/libs/handlebars/handlebars.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/libs/jquery-ui-dist/jquery-ui.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/libs/jquery-blockui/jquery.blockUI.js",
		"com.liferay.portlet.footer-portlet-javascript=/libs/jquery.handsontable/jquery.handsontable.full.js",
		"com.liferay.portlet.footer-portlet-javascript=/libs/moment/moment-with-locales.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/libs/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/libs/alpaca-custom/alpaca.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/dist/custom-fields.min.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PresentatoreForms",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PresentatoreFormsPortlet extends MVCPortlet {
	
	public static final Log _log = LogFactoryUtil.getLog(PresentatoreFormsPortlet.class);
	
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Reference
	private FormLocalService formLocalService;
	
	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;
	
	@Reference
	private AlpacaService alpacaService;
	
	public void render (RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		_log.info("render presentatore forms");
		try {
			alpacaService.test();
			Long idFormMock = 49940L;
			Form form = formLocalService.getForm(idFormMock);
			form.setListaDefinizioneAllegato(definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(idFormMock));

			FormData formData = AlpacaUtil.loadFormData(form, null, false);
			AlpacaJsonStructure alpacaStructure = formData.getAlpaca();
			renderRequest.setAttribute(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE, alpacaStructure);
			
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		super.render(renderRequest, renderResponse);
	}

	
}