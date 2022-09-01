package it.servizidigitali.presentatoreforms.frontend.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.Serializable;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;
import javax.portlet.filter.RenderFilter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;

/**
 *
 * @author pindi
 *
 */
@Component( //
		immediate = true, //
		property = { //
				"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
				"service.ranking:Integer=100" //
		}, //
		service = PortletFilter.class //
) //
public class SecurityAccessFilter implements RenderFilter {

	private static final Log log = LogFactoryUtil.getLog(SecurityAccessFilter.class.getName());

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Override
	public void doFilter(RenderRequest request, RenderResponse response, FilterChain chain) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		long groupId = layout.getGroupId();
		long layoutId = layout.getLayoutId();

		boolean isUserSignedIn = themeDisplay.isSignedIn();

		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnteByGroupIdLayoutId(groupId, layoutId);

		if (servizioEnte == null) {
			// TODO testare
			log.debug("Servizio non trovato :: groupId: " + groupId + ", layoutId: " + layoutId);
			throw new SecurityException("");
		}
		// TODO verifica servizio attivo
		if (!servizioEnte.getAttivo()) {
			log.debug("Servizio non attivo :: servizioId: " + servizioEnte.getServizioId() + ", organizationId: " + servizioEnte.getOrganizationId());
			// TODO testare
			throw new SecurityException("");
		}

		int livelloAutenticazione = servizioEnte.getLivelloAutenticazione();
		boolean autenticazione = servizioEnte.getAutenticazione();
		if (autenticazione && !isUserSignedIn) {
			log.debug("Il servizio richiede autenticazione ma l'utente non è loggato :: servizioId: " + servizioEnte.getServizioId() + ", organizationId: " + servizioEnte.getOrganizationId());
			// TODO testare
			throw new SecurityException("");
		}

		// TODO verifica livello SPID utente coerente con quello del servizio
		if (autenticazione && isUserSignedIn) {

			PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
			boolean omniadmin = permissionChecker.isOmniadmin();
			if (!omniadmin) {
				User loggedUser = themeDisplay.getUser();
				Serializable livelloSpid = loggedUser.getExpandoBridge().getAttribute("livelloSPID");
				if (livelloSpid != null) {
					int livelloSpidUser = (int) livelloSpid;
					if (livelloSpidUser < servizioEnte.getLivelloAutenticazione()) {
						log.debug("Livello SPID non sufficiente per accedere al servizio :: servizioId: " + servizioEnte.getServizioId() + ", organizationId: " + servizioEnte.getOrganizationId()
								+ ", livelloSpidUser: " + livelloSpidUser + ", livelloAutenticazione: " + servizioEnte.getLivelloAutenticazione());
						// TODO implementare meccanismo per permettere il login con livello spid
						// corretto (N.B.: DIPENDE DA IAM!)
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