package it.servizidigitali.gestioneservizi.frontend.portlet.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneservizi.frontend.constants.GestioneServiziPortletKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GestioneServiziPortletKeys.GESTIONESERVIZI,
		"mvc.command.name=/aggiungiModifica"
	},
	service = MVCRenderCommand.class
)
public class AggiungiModificaServizioMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return GestioneServiziPortletKeys.PAGINA_INSERIMENTO_MODIFICA_SERVIZIO;
	}

}
