package it.servizidigitali.profiloutente.preferenze.frontend.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.profiloutente.model.UtenteOrganizzazione;
import it.servizidigitali.profiloutente.portal.configuration.ProfiloUtenteConfiguration;
import it.servizidigitali.profiloutente.preferenze.frontend.constants.ProfiloUtentePreferenzePortletKeys;
import it.servizidigitali.profiloutente.service.CanaleComunicazioneLocalService;
import it.servizidigitali.profiloutente.service.UtenteOrganizzazioneLocalService;

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
	service = Portlet.class,
	configurationPid = "it.servizidigitali.profiloutente.portal.configuration.ProfiloUtenteConfiguration"
)
public class ProfiloUtentePreferenzePortlet extends MVCPortlet {
	
	private static final Log _log = LogFactoryUtil.getLog(ProfiloUtentePreferenzePortlet.class);
	
	@Reference
	private CanaleComunicazioneLocalService canaleComunicazioneLocalService;
	
	@Reference
	private UtenteOrganizzazioneLocalService utenteOrganizzazioneLocalService;
	
	@Reference
	private OrganizationLocalService organizationLocalService;
	
	private volatile ProfiloUtenteConfiguration profiloUtenteConfiguration;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		profiloUtenteConfiguration = ConfigurableUtil.createConfigurable(ProfiloUtenteConfiguration.class, props);
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		List<Organization> listaOrganizzazioni = null;
		UtenteOrganizzazione utenteOrganizzazionePreferita = null;
		boolean privacyAccettata = false;
		
		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		User utenteCorrente = null;
				
		try {
			serviceContext = ServiceContextFactory.getInstance(renderRequest);
			themeDisplay = serviceContext.getThemeDisplay();
			utenteCorrente = themeDisplay.getUser();
			listaOrganizzazioni = organizationLocalService.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			List<UtenteOrganizzazione> listaUtenteOrganizzazione = utenteOrganizzazioneLocalService.getByUtentePreferito(utenteCorrente.getUserId(), true);
			
			if(Validator.isNotNull(listaUtenteOrganizzazione) && !listaUtenteOrganizzazione.isEmpty()) {
				utenteOrganizzazionePreferita = listaUtenteOrganizzazione.get(0);
			}
			
			try{
				privacyAccettata = (boolean) utenteCorrente.getExpandoBridge().getAttribute(ProfiloUtentePreferenzePortletKeys.UTENTE_EXPANDO_ACCETTA_PRIVACY);
			}catch(NullPointerException npe) {
				_log.warn("Impossibile recuperare privacyUtente");
			}
		} catch (Exception e) {
			SessionErrors.add(renderRequest, ProfiloUtentePreferenzePortletKeys.ERRORE_GENERICO);
			_log.error("Impossibile recuperare le informazion pe l'utente corrente ::" + e.getMessage(), e);
		}
		
		if(Validator.isNull(listaOrganizzazioni)) {
			listaOrganizzazioni = new ArrayList<Organization>();
		}
		
		renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.UTENTE_ACCETTA_PRIVACY, privacyAccettata);
		renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.LISTA_ORGANIZZAZIONI, listaOrganizzazioni);
		renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.UTENTE_ORGANIZZAZIONE_PREFERITA, utenteOrganizzazionePreferita);
		super.render(renderRequest, renderResponse);
	}
}