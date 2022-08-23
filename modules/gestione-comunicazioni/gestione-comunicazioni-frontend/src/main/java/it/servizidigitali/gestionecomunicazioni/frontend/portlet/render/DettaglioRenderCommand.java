package it.servizidigitali.gestionecomunicazioni.frontend.portlet.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.ResourceBundle;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionecomunicazioni.frontend.constants.GestioneComunicazioniFrontendPortletKeys;
import it.servizidigitali.gestionecomunicazioni.frontend.dto.ComunicazioneDTO;
import it.servizidigitali.gestionecomunicazioni.model.Comunicazione;
import it.servizidigitali.gestionecomunicazioni.service.ComunicazioneLocalService;

@Component(immediate = true, service = MVCRenderCommand.class, property = {
		"javax.portlet.name=" + GestioneComunicazioniFrontendPortletKeys.GESTIONECOMUNICAZIONI,
		"mvc.command.name=/render/dettaglio"
})
public class DettaglioRenderCommand implements MVCRenderCommand {

	@Reference
	private ComunicazioneLocalService comunicazioneLocalService;
	
	@Override
	public String render(RenderRequest request, RenderResponse response) throws PortletException {
		long id = ParamUtil.getLong(request, "id");
		
		ComunicazioneDTO comunicazione;
		try {
			ServiceContext ctx = ServiceContextFactory.getInstance(request);
			
			Comunicazione model = comunicazioneLocalService.getComunicazione(id);
			comunicazione = new ComunicazioneDTO(model, ctx.getUserId());
		} catch (PortalException e) {
			throw new RuntimeException(e);
		}
		
		request.setAttribute("stato", LanguageUtil.get(PortalUtil.getHttpServletRequest(request), comunicazione.getStato()));
		request.setAttribute("comunicazione", comunicazione);		
		return "/dettaglio.jsp";
	}

}
