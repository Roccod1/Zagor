package it.servizidigitali.scrivaniaoperatore.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.frontend.service.ScrivaniaOperatoreFrontendService;

@Component(immediate = true, service = MVCActionCommand.class, property = {
		"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE,
		 "mvc.command.name=/action/rilascia"
})
public class RilasciaActionCommand extends BaseMVCActionCommand {

	@Reference
	private ScrivaniaOperatoreFrontendService scrivaniaOperatoreFrontendService;
	
	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		_log.debug("::doProcessAction");
		
		String taskId = ParamUtil.getString(request, "taskId");
		
		_log.debug("Task Id: " + taskId);
		
		ServiceContext context = ServiceContextFactory.getInstance(request);
		scrivaniaOperatoreFrontendService.rilasciaTask(String.valueOf(context.getUserId()), taskId);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(RilasciaActionCommand.class);
}
