package it.servizidigitali.portal.event;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.service.CacheService;
import it.servizidigitali.portal.constant.ServiziDigitaliPortalConstants;

/**
 *
 * @author pindi
 *
 */
@Component(immediate = true, //
		property = { "key=servlet.session.destroy.events" }, //
		service = LifecycleAction.class//
)
public class SessionDestroyPostAction implements LifecycleAction {

	private static final Log log = LogFactoryUtil.getLog(SessionDestroyPostAction.class.getName());

	@Reference
	private CacheService cacheService;

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		Object currentUserScreenName = lifecycleEvent.getSession().getAttribute(ServiziDigitaliPortalConstants.CURRENT_USER_SCREEN_NAME);

		if (currentUserScreenName != null) {
			log.debug("currentUserScreenName: " + currentUserScreenName);
			cacheService.deleteFromCache((String) currentUserScreenName);
		}
	}
}