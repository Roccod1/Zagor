package it.servizidigitali.gestioneenti.frontend.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.frontend.constants.GestioneEntiPortletKeys;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
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

//	2022-07-25T11:02
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	
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
		
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		int inizio = posizioni[0];
		int fine = posizioni[1];
		if (Validator.isNull(orderByCol)) {
			_log.debug("Nessun ordinamento impostato. Uso di default organizationId");
			orderByCol = "organizationId";
		}

		boolean direzione = "desc".equals(orderByType.toLowerCase()) ? false : true;
		OrderByComparator<Organization> ordine = OrderByComparatorFactoryUtil.create("Organization", orderByCol, direzione);
		
		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(renderRequest);
			ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
			
			//recupero il siteGroupOrganizationId dal siteGroup
			Long siteGroupOrganizationId = themeDisplay.getSiteGroup().getOrganizationId();
			_log.debug("siteGroupOrganizationId: "+ siteGroupOrganizationId);

			
			/*
			 * verifico se il site ha un organizationId. se maggiore di 0 mostro solo i servizi per quell'ente 
			 * altrimenti la lista di enti presenti
			 * */
			if (Validator.isNull(listaOrganizations)) {
				if(Validator.isNotNull(siteGroupOrganizationId) && siteGroupOrganizationId > 0) {
					/*
					 * l'organizationId e' magiore di 0 => si tratta di un sito specifico, recupero l'organization e disabilito la ricerca
					 * */
					Organization organization = organizationLocalService.getOrganization(siteGroupOrganizationId);
					listaOrganizations = new ArrayList<Organization>();
					listaOrganizations.add(organization);
					renderRequest.setAttribute(GestioneEntiPortletKeys.DISABILITA_RICERCA, true);
				}else {
					listaOrganizations = servizioEnteLocalService.search(nome, codiceIpa, inizio, fine, ordine);
				}
				if(Validator.isNull(listaOrganizations)) {
					_log.warn("Lista organizzazioni e' vuota o null");
					listaOrganizations = new ArrayList<Organization>();							
				}
			}	
			
			renderRequest.setAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONI, listaOrganizations);
		} catch (Exception e) {
			_log.error("Errore render portlet", e);
		}
				
		//nascondo messaggi success e error default
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		super.render(renderRequest, renderResponse);
	}
}