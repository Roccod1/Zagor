package it.servizidigitali.presentatoreforms.frontend.portlet;

import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

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
	
}