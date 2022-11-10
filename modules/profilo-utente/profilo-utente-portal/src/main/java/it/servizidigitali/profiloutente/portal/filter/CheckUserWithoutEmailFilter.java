package it.servizidigitali.profiloutente.portal.filter;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.servizidigitali.common.utility.enumeration.UserCustomAttributes;
import it.servizidigitali.profiloutente.portal.configuration.ProfiloUtenteConfiguration;

/**
 * Filtro per il redirect a pagina aggiornamento email (nel caso di email fake settata per l'utente
 * loggato).
 *
 * @author pindi
 *
 */
@Component(immediate = true, //
		property = { "servlet-context-name=", //
				"servlet-filter-name=Check User Without Email Filter", //
				"dispatcher=FORWARD", //
				"dispatcher=REQUEST", //
				"url-pattern=/web/*", //
				"url-pattern=/group/*", //
				"after-filter=Check Privacy Filter" //
		}, //
		service = Filter.class, //
		configurationPid = "it.servizidigitali.profiloutente.portal.configuration.ProfiloUtenteConfiguration")
public class CheckUserWithoutEmailFilter extends BaseFilter {

	private volatile ProfiloUtenteConfiguration profiloUtenteConfiguration;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		profiloUtenteConfiguration = ConfigurableUtil.createConfigurable(ProfiloUtenteConfiguration.class, props);
	}

	@Override
	public boolean isFilterEnabled() {
		return profiloUtenteConfiguration.ckeckUserWithoutEmailEnabled();
	}

	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws Exception {

		String redirectPath = profiloUtenteConfiguration.ckeckUserWithoutEmailRedirectPath();
		User user = PortalUtil.getUser(request);
		String currentURL = PortalUtil.getCurrentURL(request);
		String redirectPathWithoutParameters = redirectPath;
		if (redirectPath.contains("?")) {
			redirectPathWithoutParameters = redirectPath.substring(0, redirectPath.lastIndexOf("?"));
		}

		if (!currentURL.contains(redirectPathWithoutParameters) && user != null && user.isActive() && !isAdministrator(user)) {

			Serializable loginSenzaEmail = user.getExpandoBridge().getAttribute(UserCustomAttributes.LOGIN_SENZA_EMAIL.getNomeAttributo());
			boolean loginSenzaEmailBoolean = loginSenzaEmail != null && Boolean.parseBoolean(loginSenzaEmail.toString());

			if (loginSenzaEmailBoolean) {
				response.sendRedirect(redirectPath);
				return;
			}
		}

		super.processFilter(request, response, filterChain);
	}

	private boolean isAdministrator(User user) {
		List<Role> roles = user.getRoles();
		if (roles != null) {
			for (Role role : roles) {
				if (role.getName().equals(RoleConstants.ADMINISTRATOR)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	private static final Log _log = LogFactoryUtil.getLog(CheckUserWithoutEmailFilter.class);
}