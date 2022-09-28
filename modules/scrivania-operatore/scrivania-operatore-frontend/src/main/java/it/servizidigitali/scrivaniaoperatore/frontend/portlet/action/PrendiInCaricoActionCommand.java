package it.servizidigitali.scrivaniaoperatore.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.frontend.service.ScrivaniaOperatoreFrontendService;

@Component(immediate = true, service = MVCActionCommand.class, property = { "javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE, "mvc.command.name=/action/prendiInCarico" })
public class PrendiInCaricoActionCommand extends BaseMVCActionCommand {

	@Reference
	private ScrivaniaOperatoreFrontendService scrivaniaOperatoreFrontendService;

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		_log.debug("::doProcessAction");

		try {
			String taskId = ParamUtil.getString(request, "taskId");
	
			_log.debug("Task Id: " + taskId);
	
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	
			scrivaniaOperatoreFrontendService.prendiTaskInCarico(themeDisplay.getUser().getScreenName(), taskId);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(request, "errore-generico");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(PrendiInCaricoActionCommand.class);
}
