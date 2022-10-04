package it.servizidigitali.presentatoreforms.frontend.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;

@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=" + PresentatoreFormsPortletKeys.INDIETRO_ACTION_COMMAND
		}, 
service = { MVCActionCommand.class }
)
public class IndietroActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		actionResponse.getRenderParameters().setValue("mvcPath", PresentatoreFormsPortletKeys.JSP_VIEW);
		
	}

}
