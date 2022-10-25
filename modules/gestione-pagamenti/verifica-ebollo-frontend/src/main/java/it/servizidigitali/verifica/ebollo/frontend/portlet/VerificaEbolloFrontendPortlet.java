package it.servizidigitali.verifica.ebollo.frontend.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.verifica.ebollo.frontend.constants.VerificaEbolloFrontendPortletKeys;

/**
 * @author pindi
 */
@Component(immediate = true, //
		property = { //
				"com.liferay.portlet.display-category=category.servizidigitali", //
				"com.liferay.portlet.header-portlet-css=/css/main.css", //
				"com.liferay.portlet.instanceable=true", //
				"javax.portlet.display-name=VerificaEbolloPortelt", //
				"javax.portlet.init-param.template-path=/", //
				"javax.portlet.init-param.view-template=/view.jsp", //
				"javax.portlet.name=" + VerificaEbolloFrontendPortletKeys.VERIFICAEBOLLOPORTLET, //
				"javax.portlet.resource-bundle=content.Language", //
				"javax.portlet.security-role-ref=power-user,user"//
		}, //
		service = Portlet.class//
) //
public class VerificaEbolloFrontendPortlet extends MVCPortlet {
}