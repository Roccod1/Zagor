package it.servizidigitali.gestioneenti.frontend.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.RenderRequestFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.portlet.MutablePortletParameters;
import javax.portlet.MutableRenderParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletParameters;
import javax.portlet.PortletRequest;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.frontend.constants.GestioneEntiPortletKeys;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;

/**
 * @author filierim
 */
@Component(
		immediate = true, 
		property = { 
				"com.liferay.portlet.display-category=category.servizidigitali", 
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=GestioneEnti",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=" + GestioneEntiPortletKeys.GESTIONEENTI,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		}, 
		service = Portlet.class
) 
public class GestioneEntiPortlet extends MVCPortlet {

	public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private static final Log _log = LogFactoryUtil.getLog(GestioneEntiPortlet.class);

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;
	
	@Reference
	private ServizioLocalService servizioLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		@SuppressWarnings("unchecked")
		List<Organization> listaOrganizations = (List<Organization>) renderRequest.getAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONI);
		
		int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, GestioneEntiPortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, GestioneEntiPortletKeys.DEFAULT_DELTA);
		String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
		String codiceIpa = ParamUtil.getString(renderRequest, GestioneEntiPortletKeys.ORGANIZZAZIONE_CODICE_IPA_RICERCA);
		String nome = ParamUtil.getString(renderRequest, GestioneEntiPortletKeys.ORGANIZZAZIONE_NOME_RICERCA);
		
		String jspDaRenderizzare = null;
		
		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(renderRequest);
			ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
			
			//recupero l'siteGroupOrganizationId dal siteGroup
			Long siteGroupOrganizationId = themeDisplay.getSiteGroup().getOrganizationId();
			_log.debug("siteGroupOrganizationId: "+ siteGroupOrganizationId);

			if(Validator.isNotNull(siteGroupOrganizationId) && siteGroupOrganizationId > 0) {
				jspDaRenderizzare = GestioneEntiPortletKeys.JSP_LISTA_SERVIZI_ENTE;

				List<ServizioEnte> serviziEnte = servizioEnteLocalService.getServiziEnte(siteGroupOrganizationId);
				renderRequest.setAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONE_SERVIZI, serviziEnte);
				
				List<Servizio> listaServizi = servizioLocalService.getServizios(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_SERVIZI, listaServizi);							

				Organization organization = organizationLocalService.getOrganization(siteGroupOrganizationId);
				renderRequest.setAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONE, organization);
				
				renderRequest.setAttribute(GestioneEntiPortletKeys.PULSANTE_PAGINA_PRINCIPALE_TOGGLE, false);
				
			}else {
				if (Validator.isNull(listaOrganizations)) {
					listaOrganizations = servizioEnteLocalService.findOrganizationsByParams(nome, codiceIpa, cur, delta, orderByCol, orderByType);
				
					if(Validator.isNull(listaOrganizations)) {
						_log.warn("Lista organizzazioni e' vuota o null");
						listaOrganizations = new ArrayList<Organization>();							
					}
				}
				renderRequest.setAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONI, listaOrganizations);
			}			
		} catch (Exception e) {
			_log.error("Errore render portlet", e);
		}
				
		//nascondo messaggi success e error default
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		if(Validator.isNotNull(jspDaRenderizzare)) {
			include(jspDaRenderizzare, renderRequest, renderResponse);			
		}else {
			super.render(renderRequest, renderResponse);
		}
	}
}