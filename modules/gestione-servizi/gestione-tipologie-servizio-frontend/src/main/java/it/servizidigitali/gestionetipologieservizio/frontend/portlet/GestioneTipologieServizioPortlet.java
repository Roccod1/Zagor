package it.servizidigitali.gestionetipologieservizio.frontend.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;
import it.servizidigitali.gestionetipologieservizio.frontend.constants.GestioneTipologieServizioPortletKeys;

/**
 * @author pindi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servizidigitali",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GestioneTipologieServizio",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GestioneTipologieServizioPortletKeys.GESTIONETIPOLOGIESERVIZIO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GestioneTipologieServizioPortlet extends MVCPortlet {
	
	private static final Log _log = LogFactoryUtil.getLog(GestioneTipologieServizioPortlet.class);
	
	@Reference
	private TipologiaLocalService tipologiaLocalService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, GestioneTipologieServizioPortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, GestioneTipologieServizioPortletKeys.DEFAULT_DELTA);
		String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
		
		List<Tipologia> listaTipologie = new ArrayList<Tipologia>();
		
		try{
			listaTipologie = tipologiaLocalService.getListaTipologiaOrdinata(cur, delta, orderByCol, orderByType);
		}catch(Exception e) {
			_log.error("Impossibile ottenere la lista delle tipologie", e);
		}
		
		renderRequest.setAttribute(GestioneTipologieServizioPortletKeys.LISTA_TIPOLOGIE, listaTipologie);
		
		//rimuovo messaggi success e error default
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		super.render(renderRequest, renderResponse);
	}
}