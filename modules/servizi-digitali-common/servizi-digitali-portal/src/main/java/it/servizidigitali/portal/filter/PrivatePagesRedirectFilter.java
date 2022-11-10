package it.servizidigitali.portal.filter;

import com.liferay.portal.kernel.exception.NoSuchLayoutException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.permission.LayoutPermissionUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.servlet.filters.BasePortalFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Filtro per il redirect a pagina check privacy.
 *
 * @author pindi
 *
 */
@Component(immediate = true, //
		property = { "servlet-context-name=", //
				"servlet-filter-name=Private pages redirect Filter", //
				"dispatcher=FORWARD", //
				"dispatcher=REQUEST", //
				"url-pattern=/web/*", //
				"url-pattern=/group/*", //
				"url-regex-ignore-pattern=^/html/.+\\.(css|gif|html|ico|jpg|js|png)(\\?.*)?$"//
		}, //
		service = Filter.class//
)
public class PrivatePagesRedirectFilter extends BasePortalFilter {

	private ServletContext _servletContext;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private LayoutLocalService layoutLocalService;

	@Override
	public void init(FilterConfig filterConfig) {
		super.init(filterConfig);
		_servletContext = filterConfig.getServletContext();
	}

	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws Exception {

		User user = PortalUtil.getUser(request);
		if (user != null) {
			super.processFilter(request, response, filterChain);
			return;
		}

		String currentURL = PortalUtil.getCurrentURL(request);
		long companyId = PortalUtil.getCompanyId(request);

		LayoutSet layoutSet = (LayoutSet) request.getAttribute(WebKeys.VIRTUAL_HOST_LAYOUT_SET);
		String virtualHostname = layoutSet.getVirtualHostname();
		long groupId = layoutSet.getGroupId();

		try {
			Layout layout = layoutLocalService.getLayoutByFriendlyURL(groupId, false, currentURL.substring(currentURL.lastIndexOf("/")));

			User defaultUser = userLocalService.getDefaultUser(companyId);
			boolean pageHasGuestViewPermission = LayoutPermissionUtil.contains(PermissionCheckerFactoryUtil.create(defaultUser), layout, ActionKeys.VIEW);
			if (!pageHasGuestViewPermission && !response.isCommitted()) {
				RequestDispatcher requestDispatcher = _servletContext.getRequestDispatcher("/c/portal/login?redirect=https://" + virtualHostname + currentURL);
				requestDispatcher.forward(request, response);
				return;
			}
		}
		catch (NoSuchLayoutException e) {
		}

		super.processFilter(request, response, filterChain);
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	private static final Log _log = LogFactoryUtil.getLog(PrivatePagesRedirectFilter.class);
}