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

import it.servizidigitali.profiloutente.portal.configuration.ProfiloUtenteConfiguration;

/**
 * Filtro per il redirect a pagina check privacy.
 *
 * @author pindi
 *
 */
@Component(immediate = true, //
		property = { "servlet-context-name=", //
				"servlet-filter-name=Check Privacy Filter", //
				"dispatcher=FORWARD", //
				"dispatcher=REQUEST", //
				"url-pattern=/web/*", //
				"url-pattern=/group/*" //
		}, //
		service = Filter.class, //
		configurationPid = "it.servizidigitali.profiloutente.portal.configuration.ProfiloUtenteConfiguration")
public class CheckPrivacyFilter extends BaseFilter {

	private volatile ProfiloUtenteConfiguration profiloUtenteConfiguration;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		profiloUtenteConfiguration = ConfigurableUtil.createConfigurable(ProfiloUtenteConfiguration.class, props);
	}

	@Override
	public boolean isFilterEnabled() {
		return profiloUtenteConfiguration.ckeckPrivacyRedirectEnabled();
	}

	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws Exception {

		String redirectCkeckPrivacyPath = profiloUtenteConfiguration.ckeckPrivacyRedirectPath();
		User user = PortalUtil.getUser(request);
		if (!PortalUtil.getCurrentURL(request).equals(redirectCkeckPrivacyPath) && user != null && user.isActive() && !isAdministrator(user)) {

			Serializable accettaPrivacy = user.getExpandoBridge().getAttribute("accettaPrivacy");
			boolean accettaPrivacyBoolean = accettaPrivacy != null && Boolean.parseBoolean(accettaPrivacy.toString());

			if (!accettaPrivacyBoolean) {
				response.sendRedirect(redirectCkeckPrivacyPath);
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

	private static final Log _log = LogFactoryUtil.getLog(CheckPrivacyFilter.class);
}