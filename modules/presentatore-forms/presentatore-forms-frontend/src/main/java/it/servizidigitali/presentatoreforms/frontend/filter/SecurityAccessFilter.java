package it.servizidigitali.presentatoreforms.frontend.filter;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.Serializable;

import javax.portlet.PortletException;
import javax.portlet.PortletSecurityException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;
import javax.portlet.filter.RenderFilter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.UserCustomAttributes;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.frontend.configuration.PresentatoreFormsEnteConfiguration;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;

/**
 *
 * @author pindi
 *
 */
@Component( //
		immediate = false, //
		property = { //
				"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
				"service.ranking:Integer=100" //
		}, //
		service = PortletFilter.class //
) //
public class SecurityAccessFilter implements RenderFilter {

	private static final Log log = LogFactoryUtil.getLog(SecurityAccessFilter.class.getName());

	private ConfigurationProvider configurationProvider;

	private volatile PresentatoreFormsEnteConfiguration uploadFileRichiesteEnteConfiguration;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	@Override
	public void doFilter(RenderRequest request, RenderResponse response, FilterChain chain) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();

		boolean filterEnabled = false;
		try {
			uploadFileRichiesteEnteConfiguration = configurationProvider.getGroupConfiguration(PresentatoreFormsEnteConfiguration.class, groupId);
			filterEnabled = uploadFileRichiesteEnteConfiguration.securityFilterEnabled();
		}
		catch (ConfigurationException e1) {
			log.error("doFilter :: " + e1.getMessage(), e1);
		}

		if (!filterEnabled) {
			chain.doFilter(request, response);
			return;
		}

		Layout layout = themeDisplay.getLayout();

		long layoutId = layout.getLayoutId();

		boolean isUserSignedIn = themeDisplay.isSignedIn();

		long organizationId;
		try {
			Group group = groupLocalService.getGroup(groupId);
			organizationId = group.getOrganizationId();
		}
		catch (PortalException e) {
			log.error("doFilter :: " + e.getMessage(), e);
			throw new PortletSecurityException("Organizzazione non trovata per groupId: " + groupId);
		}

		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnteByOrganizationIdLayoutId(organizationId, layoutId);

		if (servizioEnte == null) {
			// TODO testare
			log.debug("Servizio non trovato :: groupId: " + groupId + ", layoutId: " + layoutId);
			throw new PortletSecurityException("Servizio non trovato :: groupId: " + groupId + ", layoutId: " + layoutId);
		}
		// verifica servizio attivo
		long servizioId = servizioEnte.getServizioId();
		if (!servizioEnte.getAttivo()) {
			log.debug("Servizio non attivo :: servizioId: " + servizioId + ", organizationId: " + servizioEnte.getOrganizationId());
			// TODO testare
			throw new PortletSecurityException("Servizio non attivo :: servizioId: " + servizioId + ", organizationId: " + servizioEnte.getOrganizationId());
		}

		Servizio servizio;
		try {
			servizio = servizioLocalService.getServizio(servizioId);
		}
		catch (PortalException e) {
			log.error("doFilter :: " + e.getMessage(), e);
			throw new PortletSecurityException("Servizio non trovato :: servizioId: " + servizioId);
		}

		if (!servizio.isAttivo()) {
			throw new PortletSecurityException("Servizio non attivo :: servizioId: " + servizioId);
		}

		boolean autenticazione = servizioEnte.getAutenticazione();
		if (autenticazione && !isUserSignedIn) {
			log.debug("Il servizio richiede autenticazione ma l'utente non è loggato :: servizioId: " + servizioId + ", organizationId: " + servizioEnte.getOrganizationId());
			// TODO testare
			throw new PortletSecurityException("Il servizio richiede autenticazione ma l'utente non è loggato :: servizioId: " + servizioId + ", organizationId: " + servizioEnte.getOrganizationId());
		}

		// TODO verifica livello SPID utente coerente con quello del servizio
		if (autenticazione && isUserSignedIn) {

			int livelloAutenticazione = servizioEnte.getLivelloAutenticazione();
			PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
			boolean omniadmin = permissionChecker.isOmniadmin();
			if (!omniadmin) {
				User loggedUser = themeDisplay.getUser();
				Serializable livelloSpid = loggedUser.getExpandoBridge().getAttribute(UserCustomAttributes.LIVELLO_SPID.getNomeAttributo());
				if (livelloSpid != null) {
					short livelloSpidUser = (short) livelloSpid;
					if (livelloSpidUser != 0 && livelloSpidUser < livelloAutenticazione) {
						log.debug("Livello SPID non sufficiente per accedere al servizio :: servizioId: " + servizioId + ", organizationId: " + servizioEnte.getOrganizationId() + ", livelloSpidUser: "
								+ livelloSpidUser + ", livelloAutenticazione: " + servizioEnte.getLivelloAutenticazione());
						// TODO implementare meccanismo per permettere il login con livello spid
						// corretto (N.B.: DIPENDE DA IAM che non ritorna lo spid level negli
						// attributi SAML!)
					}
				}
			}
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws PortletException {

	}

	@Override
	public void destroy() {

	}
}