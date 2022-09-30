package it.servizidigitali.presentatoreforms.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.AllegatoRichiestaService;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;


@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=" + PresentatoreFormsPortletKeys.SALVA_INVIA_RICHIESTA_ACTION_COMMAND
		}, 
service = { MVCActionCommand.class }
)
public class SalvaInviaRichiestaActionCommand extends BaseMVCActionCommand{
	public static final Log _log = LogFactoryUtil.getLog(SalvaInviaRichiestaActionCommand.class);
	
	@Reference
    private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;
	
	@Reference
	PresentatoreFormFrontendService presentatoreFormFrontendService;
	
	@Reference
	AllegatoRichiestaService allegatoRichiestaService;
	
	@Reference
	ServizioLocalService servizioLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {			
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		User user = themeDisplay.getUser();
		Procedura procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
		
		Servizio servizio = servizioLocalService.getServizio(procedura.getServizioId());
		
		String dataForm = ParamUtil.getString(actionRequest, "dataForm");
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		if(Validator.isNotNull(dataForm) && procedura.getProceduraId() >0){
			
			presentatoreFormFrontendService.createOrUpdateRichiesta(user, procedura.getProceduraId(), dataForm, StatoRichiesta.NUOVA.name());
			
			Form form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());
			
			if(Validator.isNotNull(form)){
				
				List<DefinizioneAllegato> listaDefinizioneAllegato = definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(form.getFormId());
				
				if(Validator.isNotNull(listaDefinizioneAllegato) && !listaDefinizioneAllegato.isEmpty()){
					
					for(DefinizioneAllegato definizioneAllegato : listaDefinizioneAllegato) {
						File allegato = uploadPortletRequest.getFile("allegato-" + definizioneAllegato.getDefinizioneAllegatoId());
						
						if(Validator.isNotNull(allegato)) {
							allegatoRichiestaService.salvaAllegatiRichiesta(allegato, servizio.getCodice(), user.getUserId(), themeDisplay.getSiteGroupId());
						}
					}
					
				}
				
			}
		}		
	}
	
}
