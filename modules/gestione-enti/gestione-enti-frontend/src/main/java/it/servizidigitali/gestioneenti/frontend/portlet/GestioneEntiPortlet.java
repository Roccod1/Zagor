package it.servizidigitali.gestioneenti.frontend.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
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

/**
 * @author pindi
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

		if(Validator.isNull(listaOrganizations)) {
			try {
				listaOrganizations = servizioEnteLocalService.findOrganizationsByParams(nome, codiceIpa, cur, delta, orderByCol, orderByType);
			} catch (Exception e) {
				_log.error("Errore nella ricerca delle organizzazioni", e);
				listaOrganizations = new ArrayList<Organization>();
			}
		}
	
		renderRequest.setAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONI, listaOrganizations);


		//nascondo messaggi success e error default
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		super.render(renderRequest, renderResponse);
	}
}