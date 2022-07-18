package it.servizidigitali.gestioneforms.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;

/**
 * @author COSTABILEE
 *
 */
@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + GestioneFormsPortletKeys.GESTIONEFORMS,
			"mvc.command.name=" + GestioneFormsPortletKeys.SALVA_AGGIUNGI_ACTION_COMMAND
		}, 
service = { MVCActionCommand.class }
)
public class SalvaModificaActionCommand extends BaseMVCActionCommand{
	public static final Log _log = LogFactoryUtil.getLog(SalvaModificaActionCommand.class);
	
	@Reference
	private FormLocalService formLocalService;
	
	@Reference
    private CounterLocalService counterLocalService;
	
	@Reference
    private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {			
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
		long idForm = ParamUtil.getLong(actionRequest, GestioneFormsPortletKeys.ID_FORM);
		String codice = ParamUtil.getString(actionRequest, GestioneFormsPortletKeys.CODICE);
		String nome = ParamUtil.getString(actionRequest, GestioneFormsPortletKeys.NOME);
		boolean principale = ParamUtil.getBoolean(actionRequest, GestioneFormsPortletKeys.PRINCIPALE);
		String modelloForm = ParamUtil.getString(actionRequest, "modelloForm");
		
		long indiceListaDefinizioneAllegati = ParamUtil.getLong(actionRequest, "dimensioneListaDefinizioneAllegato");
			
		Form form = null;
		
		if(Validator.isNull(nome)) {
			SessionErrors.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
			return;
		}
		
		if(Validator.isNull(codice)) {
			SessionErrors.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
			return;
		}
		
		if(Validator.isNotNull(idForm) && idForm>0) {
			form = formLocalService.getForm(idForm);
			SessionMessages.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE);
		}else {
			form = formLocalService.createForm(counterLocalService.increment());	
			SessionMessages.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE);
		}
		
		form.setCodice(codice);
		form.setNome(nome);
		form.setJson(modelloForm);
		form.setPrincipale(principale);
		form.setUserId(serviceContext.getThemeDisplay().getUserId());
		form.setGroupId(serviceContext.getThemeDisplay().getScopeGroupId());
		form.setUserName(serviceContext.getThemeDisplay().getUser().getScreenName());
		
		formLocalService.updateForm(form);
		
		// Recupero elenco allegati specificato nella creazione del form 
		
		for(int i=0;i<indiceListaDefinizioneAllegati;i++) {
			long definizioneAllegatoId = ParamUtil.getLong(actionRequest, "listaDefinizioneAllegato[" + i + "].definizioneAllegatoId");
			String denominazione = ParamUtil.getString(actionRequest, "listaDefinizioneAllegato[" + i + "].denominazione");
			String[] tipiFileAmmessi = ParamUtil.getParameterValues(actionRequest, "listaDefinizioneAllegato[" + i + "].tipiFileAmmessi");
			String[] codiciTipologiaDocumento = ParamUtil.getParameterValues(actionRequest, "listaDefinizioneAllegato[" + i + "].codiciTipologiaDocumento");
			boolean obbligatorio = ParamUtil.getBoolean(actionRequest, "listaDefinizioneAllegato[" + i + "].obbligatorio");
			
			DefinizioneAllegato allegato = definizioneAllegatoLocalService.createDefinizioneAllegato(0);
			
			if(definizioneAllegatoId > 0) {
				allegato = definizioneAllegatoLocalService.getDefinizioneAllegato(definizioneAllegatoId);
			}else {
				allegato.setDefinizioneAllegatoId(counterLocalService.increment());
			}
			
			if(Validator.isNotNull(denominazione)) {
				allegato.setDenominazione(denominazione);
			}else {
				SessionErrors.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
				return;
			}
			
			if(Validator.isNotNull(tipiFileAmmessi)) {
				allegato.setTipiFileAmmessi(String.join(",", tipiFileAmmessi));
			}else {
				SessionErrors.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
				return;
			}
			
			if(Validator.isNotNull(codiciTipologiaDocumento)) {
				allegato.setCodiciTipologiaDocumento(String.join(",", codiciTipologiaDocumento));
			}
			
			allegato.setObbligatorio(obbligatorio);
			allegato.setFormId(form.getFormId());
			definizioneAllegatoLocalService.updateDefinizioneAllegato(allegato);
		}
		
		// Controllo su eventuali rimozioni degli allegati
		
		String[] allegatiDaEliminare = ParamUtil.getParameterValues(actionRequest, "listaAllegatiDaEliminare");
		
		for(String allegatoId : allegatiDaEliminare) {
			definizioneAllegatoLocalService.deleteDefinizioneAllegato(Long.valueOf(allegatoId));
		}
	}
}
