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
		"com.liferay.portlet.footer-portlet-javascript=/dist/custom-fields.js",
		"com.liferay.portlet.header-portlet-css=/scripts/alpaca/alpaca.css",
		"com.liferay.portlet.footer-portlet-javascript=/scripts/alpaca/alpaca.min.js",
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