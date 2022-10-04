package it.servizidigitali.presentatoreforms.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.ArrayList;
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
import it.servizidigitali.presentatoreforms.frontend.service.AlpacaService;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.frontend.service.integration.output.model.DichiarazioneRisposta;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AllegatoUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.DatiAllegato;
import it.servizidigitali.presentatoreforms.frontend.util.model.DatiFileAllegato;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;


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
	
	@Reference
	AlpacaService alpacaService;
	
	@Reference
	private RichiestaLocalService richiestaLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {			
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		User user = themeDisplay.getUser();
		Procedura procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
		
		Servizio servizio = servizioLocalService.getServizio(procedura.getServizioId());
				
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		UserPreferences userPreferences = new UserPreferences();
		userPreferences.setCodiceFiscaleRichiedente(user.getScreenName());
		
		List<String> listaErrori = new ArrayList<String>();

		if (PortalUtil.getHttpServletRequest(actionRequest).getSession().getAttribute(PresentatoreFormsPortletKeys.USER_PREFERENCES_ATTRIBUTE_NAME) != null) {
			userPreferences = (UserPreferences) PortalUtil.getHttpServletRequest(actionRequest).getSession()
					.getAttribute(PresentatoreFormsPortletKeys.USER_PREFERENCES_ATTRIBUTE_NAME);
		}
		
		if(Validator.isNotNull(procedura) && procedura.getProceduraId() >0){
			
			Richiesta richiesta = presentatoreFormFrontendService.getRichiestaBozza(user.getScreenName(), procedura.getProceduraId());
			
			Form form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());
			
			if(Validator.isNotNull(form)){
				
				List<DefinizioneAllegato> listaDefinizioneAllegato = definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(form.getFormId());
				
				
					
					File fileFirmato = uploadPortletRequest.getFile("uploadFileFirmato");
					
					if(Validator.isNotNull(fileFirmato)) {
						allegatoRichiestaService.salvaAllegatoFirmato(fileFirmato, servizio.getCodice(), richiesta.getRichiestaId(), user.getFullName(), user.getUserId(), themeDisplay.getSiteGroupId());
					}else {
						_log.error("SalvaInviaRichiestaActionCommand :: Errore durante il salvataggio dell'allegato firmato!");
						List<DefinizioneAllegato> definizioneAllegati = definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(form.getFormId());
						List<DatiAllegato> allegati = AllegatoUtil.mergeDefinizioneAndData(definizioneAllegati, new ArrayList<DatiFileAllegato>());
						listaErrori.add("Errore durante il salvataggio dell'allegato principale!");
						String errori = String.join(",", listaErrori);

						actionRequest.setAttribute("bozzaStatus", richiesta.getStato());
						actionRequest.setAttribute("titoloPortletServizio",form.getNome());
						actionRequest.setAttribute("!invioIstanza",true);
						actionRequest.setAttribute("firmaDocumentoAbilitata",true);
						actionRequest.setAttribute("salvaUrl","/");
						actionRequest.setAttribute("scegliAllegatiDescription","42656");
						actionRequest.setAttribute("downloadIstanzaUrl","/");
						actionRequest.setAttribute("uploadFileMaxSize",3145728);
						actionRequest.setAttribute("uploadFileMaxSizeLabel",Long.toString(3145728 / 1000000) + " MB");
						actionRequest.setAttribute("nomeFileFirmato","file_firm");
						
						// TODO
						actionRequest.setAttribute("pdfFirmato", null);
						//
						
						actionRequest.setAttribute("downloadFilePrincipaleUrl","/");
						actionRequest.setAttribute("allegati", allegati);
						actionRequest.setAttribute("downloadFileUrl","/");
						actionRequest.setAttribute("downloadModelloUrl","/");
						actionRequest.setAttribute("downloadDocumentoPersonaleUrl", "/");
						actionRequest.setAttribute("homeScrivaniaUrl","/");
						actionRequest.setAttribute("firmaDocumentoAbilitata", true);
						actionRequest.setAttribute("invioIstanza",true);
						actionRequest.setAttribute("evaluationServiceEnable",false);
						actionRequest.setAttribute("pathScrivaniaVirtuale","/");
						actionRequest.setAttribute("isDebugEnabled",true);
						actionRequest.setAttribute("listaErrori", errori);
						actionResponse.getRenderParameters().setValue("mvcPath", PresentatoreFormsPortletKeys.JSP_SCEGLI_ALLEGATI);
						return;
					}
					
					if(Validator.isNotNull(listaDefinizioneAllegato) && !listaDefinizioneAllegato.isEmpty()) {
						for(DefinizioneAllegato definizioneAllegato : listaDefinizioneAllegato) {
							File allegato = uploadPortletRequest.getFile("allegato-" + definizioneAllegato.getDefinizioneAllegatoId());
							
							if(Validator.isNotNull(allegato)) {
								allegatoRichiestaService.salvaAllegatiRichiesta(allegato, servizio.getCodice(), richiesta.getRichiestaId(), user.getFullName(), user.getUserId(), themeDisplay.getSiteGroupId());
							}else {
								_log.error("SalvaInviaRichiestaActionCommand :: Errore durante il salvataggio dell'allegato con id definizione : " + definizioneAllegato.getDefinizioneAllegatoId());
								List<DefinizioneAllegato> definizioneAllegati = definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(form.getFormId());
								List<DatiAllegato> allegati = AllegatoUtil.mergeDefinizioneAndData(definizioneAllegati, new ArrayList<DatiFileAllegato>());
								listaErrori.add("Errore durante il salvataggio dell'allegato : " + definizioneAllegato.getDenominazione());
								String errori = String.join(",", listaErrori);
								actionRequest.setAttribute("listaErrori", errori);
								actionRequest.setAttribute("allegati", allegati);
								actionResponse.getRenderParameters().setValue("jspPage", PresentatoreFormsPortletKeys.JSP_SCEGLI_ALLEGATI);
								return;
							}
						}
					}

					if(Validator.isNotNull(richiesta)) {
						richiestaLocalService.updateStatoRichiesta(richiesta.getRichiestaId(), StatoRichiesta.NUOVA.name());
					}else {
						_log.error("SalvaInviaRichiestaActionCommand :: Errore durante il salvataggio della richiesta con ID : " + richiesta.getRichiestaId());
						listaErrori.add("Errore durante il salvataggio della richiesta con ID : " + richiesta.getRichiestaId());
						String errori = String.join(",", listaErrori);
						actionRequest.setAttribute("listaErrori", errori);
						actionResponse.getRenderParameters().setValue("jspPage", PresentatoreFormsPortletKeys.JSP_SCEGLI_ALLEGATI);
						return;
					}

					DichiarazioneRisposta risposta = alpacaService.sendData(richiesta, procedura, userPreferences);
					
					actionRequest.setAttribute("titoloPortletServizio", form.getNome());
					actionRequest.setAttribute("dichiarazioneRisposta", risposta);
					actionRequest.setAttribute("invioIstanza", true);
					actionResponse.getRenderParameters().setValue("mvcPath", PresentatoreFormsPortletKeys.JSP_ESITO_INVIO);
					
				
				
			}
		}	
		
		
		
	}
	
}
