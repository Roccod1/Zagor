package it.servizidigitali.portal.event;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.portal.constant.ServiziDigitaliPortalConstants;

/**
 *
 * @author pindi
 *
 */
@Component(immediate = true, //
		property = { "key=login.events.post" }, //
		service = LifecycleAction.class//
)
public class LoginPostAction implements LifecycleAction {

	public static final Log log = LogFactoryUtil.getLog(LoginPostAction.class);

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		try {
			User user = PortalUtil.getUser(lifecycleEvent.getRequest());
			if (user != null) {
				lifecycleEvent.getRequest().getSession().setAttribute(ServiziDigitaliPortalConstants.CURRENT_USER_SCREEN_NAME, user.getScreenName());
			}
		}
		catch (PortalException e) {
			log.error("processLifecycleEvent :: " + e.getMessage(), e);
		}
	}
}