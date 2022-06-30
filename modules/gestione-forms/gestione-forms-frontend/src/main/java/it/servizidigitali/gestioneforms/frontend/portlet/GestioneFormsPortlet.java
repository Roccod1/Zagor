package it.servizidigitali.gestioneforms.frontend.portlet;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalServiceUtil;
import it.servizidigitali.gestioneforms.service.persistence.FormUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author pindi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GestioneForms",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GestioneFormsPortletKeys.GESTIONEFORMS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GestioneFormsPortlet extends MVCPortlet {
	@Reference
	private FormLocalService formLocalService;
	
	public void render (RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		
		renderRequest.setAttribute("listaForm", formLocalService.getForms(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
		super.render(renderRequest, renderResponse);
	}
}