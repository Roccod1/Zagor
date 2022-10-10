package it.servizidigitali.presentatoreforms.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;


@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=" + PresentatoreFormsPortletKeys.SALVA_RICHIESTA_BOZZA_ACTION_COMMAND
		}, 
service = { MVCActionCommand.class }
)
public class SalvaRichiestaBozzaActionCommand extends BaseMVCActionCommand{
	public static final Log _log = LogFactoryUtil.getLog(SalvaRichiestaBozzaActionCommand.class);
	
	@Reference
	PresentatoreFormFrontendService presentatoreFormFrontendService;
	
	@Reference
	ServizioLocalService servizioLocalService;
		
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {			
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		User user = themeDisplay.getUser();
		String dataForm = ParamUtil.getString(actionRequest, "dataForm");
		Procedura procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
		
		Servizio servizio = servizioLocalService.getServizio(procedura.getServizioId());

				
		if(Validator.isNotNull(dataForm) && procedura.getProceduraId() >0){
			
			TipoServizio tipoServizio = TipoServizio.valueOf(procedura.getStep2TipoServizio());
			
			if(tipoServizio.equals(TipoServizio.CERTIFICATO)) {
				long destinazioneUsoId = ParamUtil.getLong(actionRequest, "destinazioneUsoId");
				
				if(destinazioneUsoId>0) {
					presentatoreFormFrontendService.createOrUpdateRichiesta(user, servizio, procedura.getProceduraId(), dataForm, StatoRichiesta.BOZZA.name(), themeDisplay.getSiteGroupId());			
				}
			}else {
				presentatoreFormFrontendService.createOrUpdateRichiesta(user, servizio, procedura.getProceduraId(), dataForm, StatoRichiesta.BOZZA.name(), themeDisplay.getSiteGroupId());			
			}

		}		
	}	
	
}
