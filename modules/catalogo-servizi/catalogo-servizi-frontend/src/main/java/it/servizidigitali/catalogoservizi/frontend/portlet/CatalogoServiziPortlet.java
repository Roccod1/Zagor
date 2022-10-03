package it.servizidigitali.catalogoservizi.frontend.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.catalogoservizi.frontend.constants.CatalogoServiziPortletKeys;
import it.servizidigitali.catalogoservizi.frontend.service.CatalogoServiziMiddlewareService;
import it.servizidigitali.gestioneservizi.model.Servizio;

/**
 * @author pindi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servizidigitali",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=CatalogoServizi",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CatalogoServiziPortletKeys.CATALOGOSERVIZI,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CatalogoServiziPortlet extends MVCPortlet {
	
	private static final Log _log = LogFactoryUtil.getLog(CatalogoServiziPortlet.class);
	
	@Reference
	private CatalogoServiziMiddlewareService catalogoServiziMiddlewareService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, 1);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 10);
		String queryNome = ParamUtil.getString(renderRequest, "queryNome");
		
		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		List<Servizio> listaServizi = new ArrayList<Servizio>();
		long organizationId = 0L;
		long companyId = 0L;
		long tipologiaId = 0L;
		long areaTematicaId = 0L;
		long groupId = 0L;
		
		try {
			serviceContext = ServiceContextFactory.getInstance(renderRequest);
			themeDisplay = serviceContext.getThemeDisplay();
			organizationId = themeDisplay.getSiteGroup().getClassPK();
			groupId = themeDisplay.getCompanyGroupId();
//			companyId = themeDisplay.getCompanyId();
			listaServizi = catalogoServiziMiddlewareService.getServizioByParams(queryNome, areaTematicaId, true, tipologiaId, companyId, groupId, organizationId, 0, 0, null, null);
			if(Validator.isNull(listaServizi) || listaServizi.isEmpty()) {
				renderRequest.setAttribute(CatalogoServiziPortletKeys.NOME_ENTE, themeDisplay.getSiteGroup().getName());		
			}
		} catch (Exception e) {
			_log.error("Impossibile ottenere la lista di servizi :: " + e.getMessage(), e);
		}
		
		renderRequest.setAttribute(CatalogoServiziPortletKeys.LISTA_SERVIZI, listaServizi);		
		super.render(renderRequest, renderResponse);
	}
	
}