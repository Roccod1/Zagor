package it.servizidigitali.gestioneenti.frontend.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.frontend.constants.GestioneEntiPortletKeys;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;

/**
 * @author pindi
 */
@Component(//
		immediate = true, //
		property = { //
				"com.liferay.portlet.display-category=category.servizidigitali", //
				"com.liferay.portlet.header-portlet-css=/css/main.css", //
				"com.liferay.portlet.instanceable=true", //
				"javax.portlet.display-name=GestioneEnti", //
				"javax.portlet.init-param.template-path=/", //
				"javax.portlet.init-param.view-template=/view.jsp", //
				"javax.portlet.name=" + GestioneEntiPortletKeys.GESTIONEENTI, //
				"javax.portlet.resource-bundle=content.Language", //
				"javax.portlet.security-role-ref=power-user,user"//
		}, //
		service = Portlet.class//
) //
public class GestioneEntiPortlet extends MVCPortlet {

	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		List<Organization> organizations = organizationLocalService.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONI, organizations);

		List<ServizioEnte> serviziEnte = servizioEnteLocalService.getServizioEntes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute(GestioneEntiPortletKeys.SERVIZI_ENTE, serviziEnte);

		super.render(renderRequest, renderResponse);
	}
}