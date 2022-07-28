package it.servizidigitali.gestionecomunicazioni.frontend.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.OrganizationLocalService;
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
		
		int[] limit = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		int start = limit[0];
		int end = limit[1];
		
		List<ComunicazioneDTO> comunicazioni = comunicazioneLocalService
				.getComunicaziones(start, end)
				.stream()
				.map(ComunicazioneDTO::new)
				.collect(Collectors.toList());
		
		int comunicazioniCount = comunicazioneLocalService.getComunicazionesCount();
		
		request.setAttribute("comunicazioni", comunicazioni);
		request.setAttribute("comunicazioniCount", comunicazioniCount);
		request.setAttribute("tipologie", tipologie);
		request.setAttribute("organizzazioni", organizzazioni);
		request.setAttribute("queryOrganizzazione", queryOrganizzazione);
		request.setAttribute("queryUsername", queryUsername);
		request.setAttribute("queryTipologia", queryTipologia);
		
		super.render(request, response);
	}
}