package it.servizidigitali.profiloutente.preferenze.frontend.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.profiloutente.preferenze.frontend.constants.ProfiloUtentePreferenzePortletKeys;

/**
 * @author filierim
 */

@Component(
	immediate = true,
	property = { 
		"javax.portlet.name=" + ProfiloUtentePreferenzePortletKeys.PROFILOUTENTEPREFERENZE, 
		"mvc.command.name=" + ProfiloUtentePreferenzePortletKeys.RENDER_INSERISCI_MODIFICA
	},
	service = MVCRenderCommand.class
) 
public class AggiungiModificaServiziEnteRenderCommand implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaServiziEnteRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		return ProfiloUtentePreferenzePortletKeys.JSP_PREFERENZE_DETTAGLIO;
	}

}