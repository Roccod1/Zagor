package it.servizidigitali.gestionecomunicazioni.frontend.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;

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
import it.servizidigitali.gestionecomunicazioni.frontend.dto.OrganizationDTO;
import it.servizidigitali.gestionecomunicazioni.frontend.dto.TipologiaDTO;
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
	private TipologiaComunicazioneLocalService tipologiaComunicazioneLocalService;
	@Reference
	private OrganizationLocalService organizationLocalService;
	@Reference
	private UserLocalService userLocalService;
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
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
		
		request.setAttribute("organizzazioni", organizzazioni);
		request.setAttribute("tipologie", tipologie);

		super.render(request, response);
	}
}