package it.servizidigitali.profiloutente.preferenze.frontend.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
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

import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.profiloutente.model.CanaleComunicazione;
import it.servizidigitali.profiloutente.preferenze.frontend.constants.ProfiloUtentePreferenzePortletKeys;
import it.servizidigitali.profiloutente.service.CanaleComunicazioneLocalService;

/**
 * @author filierim
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servizidigitali",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ProfiloUtentePreferenze",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProfiloUtentePreferenzePortletKeys.PROFILOUTENTEPREFERENZE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProfiloUtentePreferenzePortlet extends MVCPortlet {
	
	private static final Log _log = LogFactoryUtil.getLog(ProfiloUtentePreferenzePortlet.class);
	
	@Reference
	private CanaleComunicazioneLocalService canaleComunicazioneLocalService;
	
	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.LISTA_ENTI, new ArrayList<Organization>());
		
		try {
			List<Organization> listaEnti = servizioEnte
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.render(renderRequest, renderResponse);
	}
}