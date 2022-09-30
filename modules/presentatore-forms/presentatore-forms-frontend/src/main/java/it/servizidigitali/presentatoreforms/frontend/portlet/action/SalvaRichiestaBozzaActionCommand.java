package it.servizidigitali.presentatoreforms.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;

/**
 * @author zonnog
 *
 */
@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=" + PresentatoreFormsPortletKeys.SALVA_INVIA_RICHIESTA_ACTION_COMMAND
		}, 
service = { MVCActionCommand.class }
)
public class SalvaRichiestaBozzaActionCommand extends BaseMVCActionCommand{
	public static final Log _log = LogFactoryUtil.getLog(SalvaRichiestaBozzaActionCommand.class);
	
	@Reference
	private FormLocalService formLocalService;
	
	@Reference
    private CounterLocalService counterLocalService;
	
	@Reference
    private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;
	
	@Reference
	private GroupLocalService groupLocalService;
	
	@Reference
	PresentatoreFormFrontendService presentatoreFormFrontendService;
		
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {			
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		User user = themeDisplay.getUser();
		long proceduraId = ParamUtil.getLong(actionRequest, "proceduraId");
		String dataForm = ParamUtil.getString(actionRequest, "dataForm");
		
		if(Validator.isNotNull(dataForm) && proceduraId >0){
			presentatoreFormFrontendService.createOrUpdateRichiesta(user, proceduraId, dataForm, StatoRichiesta.BOZZA.name());
		}		
	}	
	
}
