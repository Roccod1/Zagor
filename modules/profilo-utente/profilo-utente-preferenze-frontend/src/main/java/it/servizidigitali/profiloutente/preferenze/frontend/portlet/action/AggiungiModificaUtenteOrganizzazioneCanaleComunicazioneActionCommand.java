package it.servizidigitali.profiloutente.preferenze.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.profiloutente.model.UtenteOrganizzazione;
import it.servizidigitali.profiloutente.preferenze.frontend.constants.ProfiloUtentePreferenzePortletKeys;
import it.servizidigitali.profiloutente.service.UtenteOrganizzazioneCanaleComunicazioneLocalService;
import it.servizidigitali.profiloutente.service.UtenteOrganizzazioneLocalService;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazionePK;

/**
 * @author filierim
 * */

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ProfiloUtentePreferenzePortletKeys.PROFILOUTENTEPREFERENZE,
		"mvc.command.name=" + ProfiloUtentePreferenzePortletKeys.ACTION_SALVA
	},
	service = MVCActionCommand.class
)
public class AggiungiModificaUtenteOrganizzazioneCanaleComunicazioneActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaUtenteOrganizzazioneCanaleComunicazioneActionCommand.class);
	
	@Reference
	private UtenteOrganizzazioneLocalService utenteOrganizzazioneLocalService;
	
	@Reference
	private UtenteOrganizzazioneCanaleComunicazioneLocalService utenteOrganizzazioneCanaleComunicazioneLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//		parametri entity
		long organizationId = ParamUtil.getLong(actionRequest, ProfiloUtentePreferenzePortletKeys.ORGANIZATION_ID);
		long listaIdCanaliComunicazione[] = ParamUtil.getLongValues(actionRequest, ProfiloUtentePreferenzePortletKeys.CANALE_COMUNICAZIONE);
		boolean preferito = ParamUtil.getBoolean(actionRequest, ProfiloUtentePreferenzePortletKeys.PREFERITO);
		
//		parametri utility
		long companyId = 0;
		long userId = 0;
		long groupId = 0;
		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		UtenteOrganizzazione utenteOrganizzazione = null;
		User utenteCorrente = null;
		UtenteOrganizzazionePK utenteOrganizzazionePK = null;
		MutableRenderParameters mutableRenderParameters = actionResponse.getRenderParameters();
		String jspDestinazioneRedirect = ProfiloUtentePreferenzePortletKeys.JSP_HOME;
		
		try {
			
			serviceContext = ServiceContextFactory.getInstance(actionRequest);
			themeDisplay = serviceContext.getThemeDisplay();
			utenteCorrente = themeDisplay.getUser();
			groupId = themeDisplay.getSiteGroupId();
			
			if(Validator.isNull(utenteCorrente)) {
				_log.error("Impossibile ottere l'utente loggato dal ThemeDisplay");
				throw new Exception();
			}

			userId = utenteCorrente.getUserId();
			
			if(organizationId > 0 && userId > 0) {
				utenteOrganizzazionePK = new UtenteOrganizzazionePK(userId, organizationId);
				utenteOrganizzazione = utenteOrganizzazioneLocalService.fetchUtenteOrganizzazione(utenteOrganizzazionePK);	
			}
			
			if(Validator.isNull(utenteOrganizzazione)) {
				utenteOrganizzazione = utenteOrganizzazioneLocalService.createUtenteOrganizzazione(utenteOrganizzazionePK);
			}
			
			/*
			 * se preferito == TRUE recupero l'oggetto precedentemente impostato come predefinito e lo imposto su false
			 * */
			if(preferito == Boolean.TRUE) {
				UtenteOrganizzazione attualePreferito = null;
				try {
					attualePreferito = utenteOrganizzazioneLocalService.findByUtentePreferito(userId, true).get(0);				
				}catch(Exception l) {
					_log.warn("Nessuna organizzazione preferita attualmente impostata {userId: " + userId + ", organizationId: " + organizationId + "}");
				}
				
				if(Validator.isNotNull(attualePreferito)) {
					attualePreferito.setPreferito(false);
					utenteOrganizzazioneLocalService.updateUtenteOrganizzazione(attualePreferito);
				}
			}
			utenteOrganizzazione.setPreferito(preferito);
			
//			imposto campi utility
			utenteOrganizzazione.setCompanyId(companyId);
			utenteOrganizzazione.setUserId(userId);
			utenteOrganizzazione.setGroupId(groupId);
			
			utenteOrganizzazioneLocalService.updateUtenteOrganizzazione(utenteOrganizzazione);				
			utenteOrganizzazioneCanaleComunicazioneLocalService.updateMassivoUtenteOrganizzazioneCanaleComunicazione(userId, groupId, companyId, organizationId, listaIdCanaliComunicazione);
			
		}catch(Exception e) {
			_log.error("Impossibile procedere al salvataggio", e);
			SessionErrors.add(actionRequest, ProfiloUtentePreferenzePortletKeys.ERRORE_SALVATAGGIO);
			jspDestinazioneRedirect = ProfiloUtentePreferenzePortletKeys.JSP_PREFERENZE_DETTAGLIO;
		}
		
//		imposto redirect dopo salvataggio 
		mutableRenderParameters.setValue("mvcPath", jspDestinazioneRedirect);
		mutableRenderParameters.setValue(ProfiloUtentePreferenzePortletKeys.ORGANIZATION_ID, jspDestinazioneRedirect);
	}
}