package it.servizidigitali.scrivaniaoperatore.frontend.portlet.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.RichiestaDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.util.MapUtil;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(immediate = true, service = MVCRenderCommand.class, property = {
		"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE,
		"mvc.command.name=/render/dettaglio"
})
public class DettaglioRenderCommand implements MVCRenderCommand {

	@Reference
	private RichiestaLocalService richiestaLocalService;
	@Reference
	private MapUtil mapUtil;
	
	@Override
	public String render(RenderRequest request, RenderResponse response) throws PortletException {
		long id = ParamUtil.getLong(request, "id");
		
		ServiceContext ctx;
		try {
			ctx = ServiceContextFactory.getInstance(request);
		} catch (PortalException e) {
			throw new RuntimeException(e);
		}
		
		RichiestaDTO richiesta = mapUtil.mapRichiesta(
				ctx.getCompanyId(), 
				richiestaLocalService.fetchRichiesta(id));
		
		request.setAttribute("richiesta", richiesta);
		
		return "/dettaglio.jsp";
	}
}
