package it.servizidigitali.gestioneservizi.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneservizi.frontend.constants.GestioneServiziPortletKeys;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;

/**
 * @author filierim
 * */

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GestioneServiziPortletKeys.GESTIONESERVIZI,
		"mvc.command.name=/salva"
	},
	service = MVCActionCommand.class
)
public class AggiungiModificaServizioActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaServizioActionCommand.class);
	
	@Reference
	private ServizioLocalService servizioLocalService;
	
	@Reference
	private TipologiaLocalService tipologiaLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		Long servizioId = ParamUtil.getLong(actionRequest, "servizioId");
		String nome = ParamUtil.getString(actionRequest, "nome");
		String codice = ParamUtil.getString(actionRequest, "codice");
		String descrizione = ParamUtil.getString(actionRequest, "descrizione");
		Long areaTematicaId = ParamUtil.getLong(actionRequest, "areaTematicaId");
		String descrizioneEstesa = ParamUtil.getString(actionRequest, "descrizioneEstesa");
		String uri = ParamUtil.getString(actionRequest, "uri");
		String uriGuest = ParamUtil.getString(actionRequest, "uriGuest");
		String uriScheda = ParamUtil.getString(actionRequest, "uriScheda");
		Boolean autenticazione = ParamUtil.getBoolean(actionRequest, "autenticazione");
		Boolean attivo = ParamUtil.getBoolean(actionRequest, "attivo");
		Date dataInizioAttivazione = ParamUtil.getDate(actionRequest, "dataInizioAttivazione",DateUtil.getISOFormat());
		Boolean cittadino = ParamUtil.getBoolean(actionRequest, "cittadino");
		Boolean azienda = ParamUtil.getBoolean(actionRequest, "azienda");
		Date dataFineAttivazione = ParamUtil.getDate(actionRequest, "dataFineAttivazione",DateUtil.getISOFormat());
		Boolean delega = ParamUtil.getBoolean(actionRequest, "delega");
		Boolean allegatoDelega = ParamUtil.getBoolean(actionRequest, "allegatoDelega");
		Boolean privacyDelega = ParamUtil.getBoolean(actionRequest, "privacyDelega");
		Boolean prenotabile = ParamUtil.getBoolean(actionRequest, "prenotabile");
		Boolean chatBot = ParamUtil.getBoolean(actionRequest, "chatBot");
		Boolean gestionebackOffice = ParamUtil.getBoolean(actionRequest, "gestioneBackffice");
		long[] listaTipologieSelezionate = ParamUtil.getLongValues(actionRequest, "listaTipologieSelezionate");
		
		String indirizzoPrecedente = ParamUtil.getString(actionRequest, GestioneServiziPortletKeys.INDIRIZZO_PRECEDENTE);
		
		if(Validator.isNull(nome)) {
			SessionMessages.add(actionRequest, GestioneServiziPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			_log.error("nome e' obbligatorio");
		}
		
		if(Validator.isNull(codice)) {
			SessionMessages.add(actionRequest, GestioneServiziPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			_log.error("codice e' obbligatorio");
		}
		
		if(Validator.isNull(descrizione)) {
			SessionMessages.add(actionRequest, GestioneServiziPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			_log.error("descrizione e' obbligatorio");
		}
		
		if(Validator.isNull(areaTematicaId)) {
			SessionMessages.add(actionRequest, GestioneServiziPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			_log.error("areaTematicaId e' obbligatorio");
		}
		
		Servizio servizio = servizioLocalService.createServizio(0);
		
		if(servizioId > 0) {
			servizio = servizioLocalService.getServizio(servizioId);
		}else {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			ThemeDisplay tema = serviceContext.getThemeDisplay();
			
			servizio = servizioLocalService.createServizio(0L);
//			servizio.setGroupId(tema.getCompanyGroupId());
//			servizio.setUserId(tema.getUserId());
		}
		
		servizio.setNome(nome);
		servizio.setServizioId(servizioId);
		servizio.setNome(nome);						
		servizio.setCodice(codice);						
		servizio.setDescrizione(descrizione);						
		servizio.setAreaTematicaId(areaTematicaId);						
		servizio.setDescrizioneEstesa(descrizioneEstesa);						
		servizio.setUri(uri);						
		servizio.setUriGuest(uriGuest);						
		servizio.setUriScheda(uriScheda);						
		servizio.setAutenticazione(autenticazione);						
		servizio.setAttivo(attivo);						
		servizio.setDataInizioAttivazione(dataInizioAttivazione);						
		servizio.setCittadino(cittadino);						
		servizio.setAzienda(azienda);						
		servizio.setDataFineAttivazione(dataFineAttivazione);						
		servizio.setDelega(delega);						
		servizio.setAllegatoDelega(allegatoDelega);						
		servizio.setPrivacyDelega(privacyDelega);
		servizio.setPrenotabile(prenotabile);						
		servizio.setChatbot(chatBot);						
		servizio.setGestioneBackoffice(gestionebackOffice);						
		
		if(listaTipologieSelezionate.length > 0) {
			List<Tipologia> listaTipologie = new ArrayList<Tipologia>();
			for(long id:listaTipologieSelezionate) {
				Tipologia tipologia = tipologiaLocalService.createTipologia(id);
				listaTipologie.add(tipologia);
			}
			servizio.setListaTipologie(listaTipologie);
		}
		
		try {
			servizioLocalService.aggiornaServizio(servizio);
			SessionMessages.add(actionRequest, GestioneServiziPortletKeys.SALVATAGGIO_SUCCESSO);			
			actionResponse.sendRedirect(indirizzoPrecedente);
		}catch(Exception e) {
			_log.error("Impossibile salvare/aggiornare il servizio con ID: " + servizioId, e);
		}
	}
}