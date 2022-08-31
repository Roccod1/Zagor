package it.servizidigitali.gestioneprocedure.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.frontend.constants.GestioneProcedurePortletKeys;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;

@Component(immediate = true, 
property = { 
		"javax.portlet.name=" + GestioneProcedurePortletKeys.GESTIONEPROCEDURE, 
		"mvc.command.name=" + GestioneProcedurePortletKeys.SALVA_CREA_ACTION_COMMAND 
}, 
service = { MVCActionCommand.class } 
)
public class SalvaCreaActionCommand extends BaseMVCActionCommand {
	
	public static final Log _log = LogFactoryUtil.getLog(SalvaCreaActionCommand.class);
	
	@Reference
	private CounterLocalService counterLocalService;
	
	@Reference
	private ProceduraLocalService proceduraLocalService;
	
	@Reference
	private ServizioLocalService servizioLocalService;
	
	@Reference
	private FormLocalService formLocalService;
	
	@Reference
	private ProceduraFormLocalService proceduraFormLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long idProcedura = ParamUtil.getLong(actionRequest, GestioneProcedurePortletKeys.ID_PROCEDURA);
		String nome = ParamUtil.getString(actionRequest, GestioneProcedurePortletKeys.NOME);
		String pec = ParamUtil.getString(actionRequest, GestioneProcedurePortletKeys.PEC);
		boolean attivaProcedura = ParamUtil.getBoolean(actionRequest, GestioneProcedurePortletKeys.ATTIVA_PROCEDURA);
		
		long idServizio = ParamUtil.getLong(actionRequest, GestioneProcedurePortletKeys.SERVIZIO);
		long idProcesso = ParamUtil.getLong(actionRequest, GestioneProcedurePortletKeys.PROCESSO_BPMN);
		long idFormPrincipale = ParamUtil.getLong(actionRequest, GestioneProcedurePortletKeys.IDENTIFICATIVO_FORM_PRINCIPALE);
		
		String[] idFormIntegrativi = ParamUtil.getStringValues(actionRequest, GestioneProcedurePortletKeys.IDENTIFICATIVI_FORM_INTEGRATIVI);
		boolean step1Attivo = ParamUtil.getBoolean(actionRequest, GestioneProcedurePortletKeys.CONFIGURAZIONE_STEP1_ATTIVO);
		
		String filtroComponentiNucleoFamiliare = ParamUtil.getString(actionRequest, GestioneProcedurePortletKeys.FILTRO_COMPONENTI_NUCLEO_FAMILIARE);
		String tipologiaServizio = ParamUtil.getString(actionRequest, GestioneProcedurePortletKeys.TIPOLOGIA_SERVIZIO);
		
		String[] tipiIntegrazioniBackoffice = ParamUtil.getStringValues(actionRequest, GestioneProcedurePortletKeys.TIPI_INTEGRAZIONI_BACKOFFICE);
		String tipoCaricamentoNucleoFamiliare = ParamUtil.getString(actionRequest, GestioneProcedurePortletKeys.CARICAMENTO_DA);
		boolean abilitaCacheIntegrazioneBackoffice = ParamUtil.getBoolean(actionRequest, GestioneProcedurePortletKeys.ABILITA_CACHE_INTEGRAZIONI_BACKOFFICE);
		
		String tipoGenerazioneTemplate = ParamUtil.getString(actionRequest, GestioneProcedurePortletKeys.TIPI_GENERAZIONE_TEMPLATE);
		boolean abilitaPagamento = ParamUtil.getBoolean(actionRequest, GestioneProcedurePortletKeys.ABILITA_PAGAMENTO);
		
		Procedura procedura = null;
		ProceduraForm proceduraForm = null;
		
		if(idProcedura>0) {
			procedura = proceduraLocalService.getProcedura(idProcedura);
		}else {
			procedura = proceduraLocalService.createProcedura(counterLocalService.increment());
		}
		
		
		if(Validator.isNull(nome)) {
			SessionErrors.add(actionRequest, GestioneProcedurePortletKeys.SESSION_ERROR_CAMPI_OBBLIGATORI);
			_log.error("GestioneProcedura :: salvaCrea :: Compilare tutti i campi obbligatori!");
			actionResponse.getRenderParameters().setValue("jspPage", GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA);
			return;
		}
		
		if(Validator.isNull(pec)) {
			SessionErrors.add(actionRequest, GestioneProcedurePortletKeys.SESSION_ERROR_CAMPI_OBBLIGATORI);
			_log.error("GestioneProcedura :: salvaCrea :: Compilare tutti i campi obbligatori!");
			actionResponse.getRenderParameters().setValue("jspPage", GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA);
			return;
		}
		
		if(Validator.isNull(idServizio)) {
			SessionErrors.add(actionRequest, GestioneProcedurePortletKeys.SESSION_ERROR_CAMPI_OBBLIGATORI);
			_log.error("GestioneProcedura :: salvaCrea :: Compilare tutti i campi obbligatori!");
			actionResponse.getRenderParameters().setValue("jspPage", GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA);
			return;
		}
		
		if(Validator.isNotNull(idProcesso)) {
			procedura.setProcessoId(idProcesso);
		}
		
		if(Validator.isNull(idFormPrincipale)) {
			SessionErrors.add(actionRequest, GestioneProcedurePortletKeys.SESSION_ERROR_CAMPI_OBBLIGATORI);
			_log.error("GestioneProcedura :: salvaCrea :: Compilare tutti i campi obbligatori!");
			actionResponse.getRenderParameters().setValue("jspPage", GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA);
			return;
		}
		
		procedura.setNome(nome);
		procedura.setPecDestinazione(pec);
		procedura.setAttiva(attivaProcedura);
		procedura.setServizioId(idServizio);
		
		ProceduraFormPK proceduraFormPk = new ProceduraFormPK();
		proceduraFormPk.setProceduraId(procedura.getProceduraId());
		proceduraFormPk.setFormId(idFormPrincipale);
		
		proceduraForm = proceduraFormLocalService.createProceduraForm(proceduraFormPk);
				
		proceduraFormLocalService.salvaListaFormIntegrativi(idFormIntegrativi, procedura.getProceduraId());
		
		procedura.setUserId(themeDisplay.getUserId());
		procedura.setGroupId(themeDisplay.getSiteGroupId());
		procedura.setUserName(themeDisplay.getUser().getFullName());
		
		
		SessionMessages.add(actionRequest, GestioneProcedurePortletKeys.SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE);
		proceduraLocalService.updateProcedura(procedura);
		proceduraFormLocalService.updateProceduraForm(proceduraForm);

	}

}
