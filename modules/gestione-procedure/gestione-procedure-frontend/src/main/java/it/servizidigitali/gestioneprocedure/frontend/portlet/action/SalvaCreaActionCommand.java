package it.servizidigitali.gestioneprocedure.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneprocedure.frontend.constants.GestioneProcedurePortletKeys;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;

@Component(immediate = true, 
property = { 
		"javax.portlet.name=" + GestioneProcedurePortletKeys.GESTIONEPROCEDURE, 
		"mvc.command.name=" + GestioneProcedurePortletKeys.SALVA_CREA_ACTION_COMMAND 
}, 
service = { MVCActionCommand.class } 
)
public class SalvaCreaActionCommand extends BaseMVCActionCommand {
	
	@Reference
	private CounterLocalService counterLocalService;
	
	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		
	}

}
