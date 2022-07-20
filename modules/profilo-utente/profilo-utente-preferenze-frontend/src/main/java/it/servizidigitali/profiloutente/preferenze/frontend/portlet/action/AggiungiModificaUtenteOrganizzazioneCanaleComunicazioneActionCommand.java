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
import it.servizidigitali.profiloutente.model.UtenteOrganizzazioneCanaleComunicazione;
import it.servizidigitali.profiloutente.preferenze.frontend.constants.ProfiloUtentePreferenzePortletKeys;
import it.servizidigitali.profiloutente.service.UtenteOrganizzazioneCanaleComunicazioneLocalService;
import it.servizidigitali.profiloutente.service.UtenteOrganizzazioneLocalService;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazioneCanaleComunicazionePK;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazionePK;

/**
 * @author filierim
 * */

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ProfiloUtentePreferenzePortletKeys.PROFILOUTENTEPREFERENZE,
		"mvc.command.name=/salva"
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
//		parametri utility
		List<String> listaErrori = new ArrayList<String>();
		String indirizzoPrecedente = ParamUtil.getString(actionRequest, ProfiloUtentePreferenzePortletKeys.INDIRIZZO_REDIRECT);

//		parametri entity
		long organizationId = ParamUtil.getLong(actionRequest, ProfiloUtentePreferenzePortletKeys.ORGANIZATION_ID);
		long listaIdCanaliComunicazione[] = ParamUtil.getLongValues(actionRequest, ProfiloUtentePreferenzePortletKeys.CANALE_COMUNICAZIONE);
		boolean preferito = ParamUtil.getBoolean(actionRequest, ProfiloUtentePreferenzePortletKeys.DEFAULT);
		
		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		UtenteOrganizzazione utenteOrganizzazione = null;
		UtenteOrganizzazionePK utenteOrganizzazionePK = null;
		User utenteCorrente = null;
		MutableRenderParameters mutableRenderParameters = actionResponse.getRenderParameters();
		String jspDestinazioneRedirect = ProfiloUtentePreferenzePortletKeys.JSP_PREFERENZE;
		try {
			
			serviceContext = ServiceContextFactory.getInstance(actionRequest);
			themeDisplay = serviceContext.getThemeDisplay();

			utenteCorrente = themeDisplay.getUser();
			if(Validator.isNull(utenteCorrente)) {
				_log.error("Impossibile ottere l'utente loggato dal ThemeDisplay");
				SessionErrors.add(actionRequest, ProfiloUtentePreferenzePortletKeys.ERRORE_PARAMETRI_MANCANTI);
				jspDestinazioneRedirect = ProfiloUtentePreferenzePortletKeys.JSP_PREFERENZE_DETTAGLIO;
				throw new Exception();
			}
			if(organizationId > 0 && utenteCorrente.getUserId() > 0) {
				utenteOrganizzazionePK = new UtenteOrganizzazionePK(utenteCorrente.getUserId(), organizationId);
				utenteOrganizzazione = utenteOrganizzazioneLocalService.fetchUtenteOrganizzazione(utenteOrganizzazionePK);	
			}
			
			if(Validator.isNull(utenteOrganizzazione)) {
				utenteOrganizzazione = utenteOrganizzazioneLocalService.createUtenteOrganizzazione(utenteOrganizzazionePK);
			}
			
			UtenteOrganizzazione attualePreferito = utenteOrganizzazioneLocalService.findByUtenteOrganizzazionePreferito(utenteOrganizzazionePK, true);
			
			if(Validator.isNotNull(attualePreferito)) {
				attualePreferito.setPreferito(false);
				utenteOrganizzazioneLocalService.updateUtenteOrganizzazione(attualePreferito);
			}
			
			utenteOrganizzazione.setPreferito(preferito);
			utenteOrganizzazioneLocalService.updateUtenteOrganizzazione(utenteOrganizzazione);
			utenteOrganizzazioneCanaleComunicazioneLocalService.updateMassivoUtenteOrganizzazioneCanaleComunicazione(utenteOrganizzazionePK.getUtenteId(), utenteOrganizzazionePK.getOrganizationId(), listaIdCanaliComunicazione);
			
		}catch(Exception e) {
			_log.error("Impossibile procedere al salvataggio", e);
			SessionErrors.add(actionRequest, ProfiloUtentePreferenzePortletKeys.ERRORE_GENERICO);
			jspDestinazioneRedirect = ProfiloUtentePreferenzePortletKeys.JSP_PREFERENZE_DETTAGLIO;
		}
		mutableRenderParameters.setValue("mvcPath", jspDestinazioneRedirect);
		mutableRenderParameters.setValue(ProfiloUtentePreferenzePortletKeys.ORGANIZATION_ID, jspDestinazioneRedirect);
	}
}