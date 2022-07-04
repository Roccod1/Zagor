package it.servizidigitali.gestioneforms.frontend.portlet;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalService;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
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
		
		List<Form> listaForm = (List<Form>) renderRequest.getAttribute(GestioneFormsPortletKeys.LISTA_FORM);
		
		if(listaForm==null) {
			listaForm = formLocalService.getForms(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			renderRequest.setAttribute(GestioneFormsPortletKeys.LISTA_FORM, listaForm);
		}
		
		super.render(renderRequest, renderResponse);
		
		
		// Rimozione messaggi default
		
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	    LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
	    SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
}