package it.servizidigitali.gestioneprocedure.frontend.portlet.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneprocedure.frontend.constants.GestioneProcedurePortletKeys;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + GestioneProcedurePortletKeys.GESTIONEPROCEDURE,
			"mvc.command.name=" + GestioneProcedurePortletKeys.DETTAGLIO_NUOVO_RENDER_COMMAND
		},
		service = MVCRenderCommand.class
	)
public class DettaglioNuovoRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA;
	}

}
