package it.servizidigitali.gestionecomunicazioni.frontend.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionecomunicazioni.frontend.constants.GestioneComunicazioniFrontendPortletKeys;
import it.servizidigitali.gestionecomunicazioni.frontend.dto.ComunicazioneDTO;
import it.servizidigitali.gestionecomunicazioni.frontend.dto.OrganizationDTO;
import it.servizidigitali.gestionecomunicazioni.frontend.dto.TipologiaDTO;
import it.servizidigitali.gestionecomunicazioni.service.ComunicazioneLocalService;
import it.servizidigitali.gestionecomunicazioni.service.TipologiaComunicazioneLocalService;

/**
 * @author pindi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servizidigitali",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GestioneComunicazioniFrontend",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GestioneComunicazioniFrontendPortletKeys.GESTIONECOMUNICAZIONI,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GestioneComunicazioniPortlet extends MVCPortlet {
	
	@Reference
	private ComunicazioneLocalService comunicazioneLocalService;
	@Reference
	private TipologiaComunicazioneLocalService tipologiaComunicazioneLocalService;
	@Reference
	private OrganizationLocalService organizationLocalService;
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM, 1);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM, 10);
		long queryOrganizzazione = ParamUtil.getLong(request, "queryOrganizzazione");
		String queryUsername = ParamUtil.getString(request, "queryUsername");
		long queryTipologia = ParamUtil.getLong(request, "queryTipologia");
		
		ServiceContext ctx;
		try {
			ctx = ServiceContextFactory.getInstance(request);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
		
		long organizationId;
		try {
			organizationId = ctx.getScopeGroup().getOrganizationId();
		} catch (PortalException e) {
			throw new PortletException(e);
		}
		
		List<TipologiaDTO> tipologie = tipologiaComunicazioneLocalService
				.getTipologiaComunicaziones(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
				.stream()
				.map(TipologiaDTO::new)
				.collect(Collectors.toList());
		List<OrganizationDTO> organizzazioni = organizationLocalService
				.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
				.stream()
				.map(OrganizationDTO::new)
				.collect(Collectors.toList());
		
		Long organizzazione = queryOrganizzazione == 0 ? null : queryOrganizzazione;
		String username = queryUsername.isBlank() ? null : queryUsername.trim();
		Long tipologia = queryTipologia == 0 ? null : queryTipologia;
		
		List<ComunicazioneDTO> comunicazioni = comunicazioneLocalService
				.findByFilters(organizzazione, username, tipologia, cur, delta)
				.stream()
				.map(x -> new ComunicazioneDTO(x, ctx.getUserId()))
				.collect(Collectors.toList());
		
		int comunicazioniCount = comunicazioneLocalService.countByFilters(organizzazione, username, tipologia);
		
		request.setAttribute("comunicazioni", comunicazioni);
		request.setAttribute("comunicazioniCount", comunicazioniCount);
		request.setAttribute("tipologie", tipologie);
		request.setAttribute("organizzazioni", organizzazioni);
		request.setAttribute("queryOrganizzazione", queryOrganizzazione);
		request.setAttribute("queryUsername", queryUsername);
		request.setAttribute("queryTipologia", queryTipologia);
		request.setAttribute("inOrganization", organizationId != 0);
		
		super.render(request, response);
	}
}