package it.servizidigitali.gestionecomunicazioni.frontend.portlet.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionecomunicazioni.frontend.constants.GestioneComunicazioniFrontendPortletKeys;
import it.servizidigitali.gestionecomunicazioni.frontend.dto.UtenteDTO;
import it.servizidigitali.gestionecomunicazioni.frontend.service.UtenteService;

@Component(immediate = true, service = MVCResourceCommand.class, property = {
		"javax.portlet.name=" + GestioneComunicazioniFrontendPortletKeys.GESTIONECOMUNICAZIONI,
		"mvc.command.name=/resource/ricercaUtenti"
})
public class RicercaUtentiResourceCommand extends BaseMVCResourceCommand {
	
	@Reference
	private UtenteService utenteService;
	
	@Override
	protected void doServeResource(ResourceRequest request, ResourceResponse response) throws Exception {
		long organizzazione = ParamUtil.getLong(request, "organizzazione");
		String query = ParamUtil.getString(request, "query");
		int limit = ParamUtil.getInteger(request, "limit");
		
		try {
			ServiceContext ctx = ServiceContextFactory.getInstance(request);
			
			List<UtenteDTO> utenti = utenteService.ricerca(ctx, organizzazione, query, limit);
			
			ObjectMapper om = new ObjectMapper();
			
			String payload = om.writeValueAsString(utenti);
			response.getPortletOutputStream().write(payload.getBytes());
		} catch (Exception e) {
			String payload = "{ \"error\": \"generico\" }";
			response.getPortletOutputStream().write(payload.getBytes());
		}
	}

}
