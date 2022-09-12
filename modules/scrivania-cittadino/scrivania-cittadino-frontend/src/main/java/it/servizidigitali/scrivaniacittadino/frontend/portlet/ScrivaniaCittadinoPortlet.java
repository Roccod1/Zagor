package it.servizidigitali.scrivaniacittadino.frontend.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione;
import it.servizidigitali.gestionecomunicazioni.service.ComunicazioneLocalService;
import it.servizidigitali.gestionecomunicazioni.service.TipologiaComunicazioneLocalService;
import it.servizidigitali.scrivaniacittadino.frontend.constants.ScrivaniaCittadinoPortletKeys;

/**
 * @author pindi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servizidigitali",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
//		"com.liferay.portlet.header-portlet-js=/js/main.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ScrivaniaCittadino",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ScrivaniaCittadinoPortletKeys.SCRIVANIACITTADINO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ScrivaniaCittadinoPortlet extends MVCPortlet {
	
	private static final Log _log = LogFactoryUtil.getLog(ScrivaniaCittadinoPortlet.class);
	
	@Reference
	private ComunicazioneLocalService comunicazioneLocalService;
	
	@Reference
	private TipologiaComunicazioneLocalService tipologiaComunicazioneLocalService;
	
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
       ServiceContext serviceContext = null;
       ThemeDisplay themeDisplay = null;
       List<TipologiaComunicazione> listaTipologiaComunicazione = new ArrayList<TipologiaComunicazione>();
       try {
            serviceContext = ServiceContextFactory.getInstance(renderRequest);
            themeDisplay = serviceContext.getThemeDisplay();
            User loggedUser = themeDisplay.getUser();

            listaTipologiaComunicazione = tipologiaComunicazioneLocalService.getTipologiaComunicaziones(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            
		}catch (Exception e) {
		    _log.error("render() :: " + e.getMessage(), e);
		}
       
   		renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.LISTA_TIPOLOGIA_COMUNICAZIONE, listaTipologiaComunicazione);
       	
   		super.render(renderRequest, renderResponse);
	}
	

}