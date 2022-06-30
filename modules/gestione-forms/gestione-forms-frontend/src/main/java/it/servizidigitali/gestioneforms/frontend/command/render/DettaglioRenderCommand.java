package it.servizidigitali.gestioneforms.frontend.command.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + GestioneFormsPortletKeys.GESTIONEFORMS,
			"mvc.command.name=/dettaglio"
		},
		service = MVCRenderCommand.class
	)
public class DettaglioRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		return "/dettaglio.jsp";
	}

}
