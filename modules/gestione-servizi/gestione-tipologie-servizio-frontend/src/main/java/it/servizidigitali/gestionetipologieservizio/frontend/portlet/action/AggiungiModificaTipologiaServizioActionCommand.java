package it.servizidigitali.gestionetipologieservizio.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;
import it.servizidigitali.gestionetipologieservizio.frontend.constants.GestioneTipologieServizioPortletKeys;

/**
 * @author filierim
 * */

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GestioneTipologieServizioPortletKeys.GESTIONETIPOLOGIESERVIZIO,
		"mvc.command.name=" + GestioneTipologieServizioPortletKeys.SALVA_ACTION_COMMAND_NAME
	},
	service = MVCActionCommand.class
)
public class AggiungiModificaTipologiaServizioActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaTipologiaServizioActionCommand.class);
	
	@Reference
	private TipologiaLocalService tipologiaLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		List<String> listaErrori = new ArrayList<String>();
		Long tipologiaId = ParamUtil.getLong(actionRequest, GestioneTipologieServizioPortletKeys.TIPOLOGIA_ID);
		String nome = ParamUtil.getString(actionRequest, GestioneTipologieServizioPortletKeys.NOME);
		String descrizione = ParamUtil.getString(actionRequest, GestioneTipologieServizioPortletKeys.DESCRIZIONE);
		Boolean visibile = ParamUtil.getBoolean(actionRequest, GestioneTipologieServizioPortletKeys.VISIBILE);
		Boolean invioEmailCittadino = ParamUtil.getBoolean(actionRequest, GestioneTipologieServizioPortletKeys.INVIO_EMAIL_CITTADINO);
		String chatbotInlineIntent = ParamUtil.getString(actionRequest, GestioneTipologieServizioPortletKeys.CHATBOT_INLINE_INTENT);
		String indirizzoPrecedente = ParamUtil.getString(actionRequest, GestioneTipologieServizioPortletKeys.INDIRIZZO_PRECEDENTE);
		
		if(Validator.isNull(nome)) {
			SessionErrors.add(actionRequest, GestioneTipologieServizioPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			listaErrori.add("nome e' obbligatorio");
		}
		
			
		Tipologia tipologia = tipologiaLocalService.createTipologia(0L);
		
		if(Validator.isNotNull(tipologiaId)) {
			try {
				tipologia = tipologiaLocalService.getTipologia(tipologiaId);				
			}catch(Exception e) {
				_log.error("Impossibile ottenere tipologia con ID: " + tipologiaId);
				SessionErrors.add(actionRequest, GestioneTipologieServizioPortletKeys.ERRORE_IMPOSSIBILE_OTTENERE_TIPOLOGIA);
				SessionErrors.add(actionRequest, GestioneTipologieServizioPortletKeys.ERRORE_SALVATAGGIO);
			}
		}
		
		if(!listaErrori.isEmpty()) {
			for(String errore : listaErrori) {
				_log.error(errore);
			}
			actionResponse.sendRedirect(indirizzoPrecedente);
		}
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		tipologia.setGroupId(themeDisplay.getCompanyGroupId());
		tipologia.setUserId(themeDisplay.getUserId());
		tipologia.setUserName(themeDisplay.getUser().getFullName());
		
		tipologia.setNome(nome);		
		tipologia.setDescrizione(descrizione);						
		tipologia.setVisibile(visibile);
		tipologia.setInvioEmailCittadino(invioEmailCittadino);
		tipologia.setChatbotInlineIntent(chatbotInlineIntent);
		
		try {
			tipologiaLocalService.salvaTipologia(tipologia);
			SessionMessages.add(actionRequest, GestioneTipologieServizioPortletKeys.SALVATAGGIO_SUCCESSO);			
		}catch(Exception e) {
			_log.error("Impossibile salvare/aggiornare la tipologia con ID: " + tipologiaId, e);
			SessionErrors.add(actionRequest, GestioneTipologieServizioPortletKeys.ERRORE_SALVATAGGIO);			
		}
		actionResponse.sendRedirect(indirizzoPrecedente);
	}
}