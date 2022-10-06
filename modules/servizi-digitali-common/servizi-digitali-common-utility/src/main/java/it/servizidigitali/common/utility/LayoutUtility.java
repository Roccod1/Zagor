package it.servizidigitali.common.utility;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.VirtualHost;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.LayoutSetLocalService;
import com.liferay.portal.kernel.service.VirtualHostLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author pindi
 *
 */
@Component(immediate = true, name = "LayoutUtility", service = LayoutUtility.class)
public class LayoutUtility {

	private static final Log log = LogFactoryUtil.getLog(LayoutUtility.class.getName());

	@Reference
	private LayoutLocalService layoutLocalService;

	@Reference
	private LayoutSetLocalService layoutSetLocalService;

	@Reference
	private VirtualHostLocalService virtualHostLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	/**
	 *
	 * @param layoutId
	 * @param groupId
	 * @param companyId
	 * @return
	 */
	public String getPathByLayoutId(long layoutId, long groupId, long companyId) {

		try {
			Group group = groupLocalService.getGroup(groupId);
			boolean isSite = group.isSite();
			if (isSite) {
				LayoutSet layoutSet = layoutSetLocalService.getLayoutSet(groupId, false);
				List<VirtualHost> virtualHosts = virtualHostLocalService.getVirtualHosts(companyId, layoutSet.getLayoutSetId());
				if (virtualHosts != null) {
					VirtualHost virtualHost = virtualHosts.stream().filter(vh -> vh.getDefaultVirtualHost()).findAny().orElse(null);

					String friendlyURL = layoutLocalService.getLayout(groupId, false, layoutId).getFriendlyURL();

					String pagePath = "https://" + virtualHost.getHostname() + friendlyURL;
					return pagePath;
				}
			}
		}
		catch (PortalException e) {
			log.error("getPathByLayoutId :: " + e.getMessage(), e);
		}
		return null;
	}

	/**
	 *
	 * @param siteId
	 * @param companyId
	 * @return
	 */
	public String getSitePath(long siteId, long companyId) {

		try {
			Group group = groupLocalService.getGroup(siteId);
			boolean isSite = group.isSite();
			if (isSite) {
				LayoutSet layoutSet = layoutSetLocalService.getLayoutSet(siteId, false);
				List<VirtualHost> virtualHosts = virtualHostLocalService.getVirtualHosts(companyId, layoutSet.getLayoutSetId());
				if (virtualHosts != null) {
					VirtualHost virtualHost = virtualHosts.stream().filter(vh -> vh.getDefaultVirtualHost()).findAny().orElse(null);
					return "https://" + virtualHost.getHostname();
				}
			}
		}
		catch (PortalException e) {
			log.error("getHostName :: " + e.getMessage(), e);
		}
		return null;
	}
}
