package it.servizidigitali.gestionecomunicazioni.frontend.portlet.render;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionecomunicazioni.frontend.constants.GestioneComunicazioniFrontendPortletKeys;
import it.servizidigitali.gestionecomunicazioni.frontend.dto.OrganizationDTO;
import it.servizidigitali.gestionecomunicazioni.frontend.dto.TipologiaDTO;
import it.servizidigitali.gestionecomunicazioni.service.TipologiaComunicazioneLocalService;

@Component(immediate = true, service = MVCRenderCommand.class, //
		property = { //
				"javax.portlet.name=" + GestioneComunicazioniFrontendPortletKeys.GESTIONECOMUNICAZIONI, //
				"mvc.command.name=/render/nuova"//
		}//
)
public class NuovaComunicazioneRenderCommand implements MVCRenderCommand {

	@Reference
	private TipologiaComunicazioneLocalService tipologiaComunicazioneLocalService;
	@Reference
	private OrganizationLocalService organizationLocalService;

	@Override
	public String render(RenderRequest request, RenderResponse response) throws PortletException {
		ServiceContext ctx;
		try {
			ctx = ServiceContextFactory.getInstance(request);
		}
		catch (PortalException e) {
			throw new PortletException(e);
		}

		long organizationId;
		try {
			organizationId = ctx.getScopeGroup().getOrganizationId();
		}
		catch (PortalException e) {
			throw new PortletException(e);
		}

		List<TipologiaDTO> tipologie = tipologiaComunicazioneLocalService.getTipologiaComunicaziones(QueryUtil.ALL_POS, QueryUtil.ALL_POS).stream().map(TipologiaDTO::new).collect(Collectors.toList());

		List<OrganizationDTO> organizzazioni;
		if (organizationId == 0) {
			organizzazioni = organizationLocalService.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS).stream().map(OrganizationDTO::new).collect(Collectors.toList());
		}
		else {
			organizzazioni = Collections.singletonList(organizationLocalService.fetchOrganization(organizationId)).stream().map(OrganizationDTO::new).collect(Collectors.toList());
			request.setAttribute("organizzazioneSito", true);
		}

		request.setAttribute("organizzazioni", organizzazioni);
		request.setAttribute("tipologie", tipologie);

		return "/nuova_comunicazione.jsp";
	}

}
