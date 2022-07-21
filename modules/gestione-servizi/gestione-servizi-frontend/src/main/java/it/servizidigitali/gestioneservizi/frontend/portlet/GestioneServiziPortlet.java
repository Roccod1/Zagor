package it.servizidigitali.gestioneservizi.frontend.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;

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

import it.servizidigitali.gestioneservizi.frontend.constants.GestioneServiziPortletKeys;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;

/**
 * @author pindi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servizidigitali",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GestioneServizi",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GestioneServiziPortletKeys.GESTIONESERVIZI,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)


public class GestioneServiziPortlet extends MVCPortlet {
	
	private static final Log _log = LogFactoryUtil.getLog(GestioneServiziPortlet.class);
	
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	@Reference
	private ServizioLocalService servizioLocalService;
	
	@Reference
	private TipologiaLocalService tipologiaLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, GestioneServiziPortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, GestioneServiziPortletKeys.DEFAULT_DELTA);
		String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
		
		String nome = ParamUtil.getString(renderRequest, GestioneServiziPortletKeys.NOME_RICERCA);
		String codice = ParamUtil.getString(renderRequest, GestioneServiziPortletKeys.CODICE_RICERCA);
		Boolean soloServiziAttivi = ParamUtil.getBoolean(renderRequest, GestioneServiziPortletKeys.SOLO_SERVIZI_ATTIVI_RICERCA);
		
		List<Servizio> listaServizi = new ArrayList<Servizio>();	
		try {
			listaServizi = servizioLocalService.searchServizio(
					nome, 
					codice, 
					soloServiziAttivi, 
					cur, delta, 
					orderByCol, 
					orderByType);			
		}catch(Exception e) {
			_log.error("Impossibile ottenere la lista dei servizi", e);
		}

		renderRequest.setAttribute(GestioneServiziPortletKeys.LISTA_SERVIZI, listaServizi);
		
		//imposto nuovamente i parametri ricevuti in ingresso per l'integrazione tra formRicerca e searchContainer
		renderRequest.setAttribute(GestioneServiziPortletKeys.NOME_RICERCA, nome);
		renderRequest.setAttribute(GestioneServiziPortletKeys.CODICE_RICERCA, codice);
		renderRequest.setAttribute(GestioneServiziPortletKeys.SOLO_SERVIZI_ATTIVI_RICERCA, soloServiziAttivi);

		//rimuovo i messaggi di success default
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);



		super.render(renderRequest, renderResponse);
	}
}