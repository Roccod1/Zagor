package it.servizidigitali.gestioneenti.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.frontend.constants.GestioneEntiPortletKeys;
import it.servizidigitali.gestioneenti.frontend.portlet.GestioneEntiPortlet;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;

/**
 * @author pindi
 */

@Component(immediate = true,
		property = { 
			"javax.portlet.name=" + GestioneEntiPortletKeys.GESTIONEENTI, 
			"mvc.command.name=" + GestioneEntiPortletKeys.SALVA_ACTION_COMMAND_NAME 
		}, 
		service = MVCActionCommand.class
)
public class AggiungiModificaEnteServizioActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaEnteServizioActionCommand.class);

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		Long servizioId = ParamUtil.getLong(actionRequest, GestioneEntiPortletKeys.SERVIZIO_ID);
		Long organizationId = ParamUtil.getLong(actionRequest, GestioneEntiPortletKeys.ORGANIZZAZIONE_ID);
		String uri = ParamUtil.getString(actionRequest, GestioneEntiPortletKeys.SERVIZIO_URI);
		String uriGuest = ParamUtil.getString(actionRequest, GestioneEntiPortletKeys.SERVIZIO_URI_GUEST);
		String uriScheda = ParamUtil.getString(actionRequest, GestioneEntiPortletKeys.SERVIZIO_SCHEDA);
		Boolean autenticazione = ParamUtil.getBoolean(actionRequest, GestioneEntiPortletKeys.SERVIZIO_AUTENTICAZIONE);
		Boolean attivo = ParamUtil.getBoolean(actionRequest, GestioneEntiPortletKeys.SERVIZIO_ATTIVO);
		Date dataInizioAttivazione = ParamUtil.getDate(actionRequest, GestioneEntiPortletKeys.SERVIZIO_DATA_INIZIO_ATTIVAZIONE, GestioneEntiPortlet.simpleDateFormat, null);
		Date dataFineAttivazione = ParamUtil.getDate(actionRequest, GestioneEntiPortletKeys.SERVIZIO_DATA_FINE_ATTIVAZIONE, GestioneEntiPortlet.simpleDateFormat, null);
		Boolean cittadino = ParamUtil.getBoolean(actionRequest, GestioneEntiPortletKeys.SERVIZIO_CITTADINO);
		Boolean azienda = ParamUtil.getBoolean(actionRequest, GestioneEntiPortletKeys.SERVIZIO_AZIENDA);
		Boolean delega = ParamUtil.getBoolean(actionRequest, GestioneEntiPortletKeys.SERVIZIO_DELEGA);
		Boolean allegatoDelega = ParamUtil.getBoolean(actionRequest, GestioneEntiPortletKeys.SERVIZIO_ALLEGATO_DELEGA);
		Boolean privacyDelega = ParamUtil.getBoolean(actionRequest, GestioneEntiPortletKeys.SERVIZIO_PRIVACY_DELEGA);
		Boolean prenotabile = ParamUtil.getBoolean(actionRequest, GestioneEntiPortletKeys.SERVIZIO_PRENOTABILE);
		Boolean chatBot = ParamUtil.getBoolean(actionRequest, GestioneEntiPortletKeys.SERVIZIO_CHATBOT);
		Boolean iseeInps = ParamUtil.getBoolean(actionRequest, GestioneEntiPortletKeys.SERVIZIO_ISEE_INPS);
		Boolean timbroCertificato = ParamUtil.getBoolean(actionRequest, GestioneEntiPortletKeys.SERVIZIO_TIMBRO_CERTIFICATO);

		String redirect = ParamUtil.getString(actionRequest, GestioneEntiPortletKeys.INDIRIZZO_REDIRECT);
		
		
		ServizioEntePK servizioEntePK = new ServizioEntePK();
		servizioEntePK.setServizioId(servizioId);
		servizioEntePK.setOrganizationId(organizationId);

		ServizioEnte servizioEnte = null;
		if (servizioId > 0 && organizationId > 0) {
			try {
				servizioEnte = servizioEnteLocalService.getServizioEnte(servizioEntePK);				
			}catch(Exception e) {
				_log.debug("ServizioEnte con serviziId "+ servizioId + " e organizationId " + organizationId + " inesistente. Creo nuova entity");
				servizioEnte = servizioEnteLocalService.createServizioEnte(servizioEntePK);
			}
		}else {
			_log.error("servizioId  e organizationId sono campi obbligatori");
			SessionErrors.add(actionRequest, GestioneEntiPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			actionResponse.sendRedirect(redirect);
		}
		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
			servizioEnte.setGroupId(themeDisplay.getCompanyGroupId());
			servizioEnte.setUserId(themeDisplay.getUserId());
	
			servizioEnte.setUri(uri);
			servizioEnte.setUriGuest(uriGuest);
			servizioEnte.setUriScheda(uriScheda);
			servizioEnte.setAutenticazione(autenticazione);
			servizioEnte.setAttivo(attivo);
			servizioEnte.setDataInizioAttivazione(dataInizioAttivazione);
			servizioEnte.setCittadino(cittadino);
			servizioEnte.setAzienda(azienda);
			servizioEnte.setDataFineAttivazione(dataFineAttivazione);
			servizioEnte.setDelega(delega);
			servizioEnte.setAllegatoDelega(allegatoDelega);
			servizioEnte.setPrivacyDelega(privacyDelega);
			servizioEnte.setPrenotabile(prenotabile);
			servizioEnte.setChatbot(chatBot);
			servizioEnte.setIseeInps(iseeInps);
			servizioEnte.setTimbroCertificato(timbroCertificato);

		
			servizioEnteLocalService.updateServizioEnte(servizioEnte);
			SessionMessages.add(actionRequest, GestioneEntiPortletKeys.SALVATAGGIO_SUCCESSO);
//			MutableRenderParameters params = actionResponse.getRenderParameters();
//			params.setValue("mvcPath", GestioneEntiPortletKeys.JSP_INSERIMENTO_MODIFICA);
//			params.setValue(GestioneEntiPortletKeys.ORGANIZZAZIONE_ID, organizationId.toString());
			actionResponse.sendRedirect(redirect);
		}
		catch (Exception e) {
			_log.error("Impossibile salvare/aggiornare il servizio con ID: " + servizioId, e);
			SessionErrors.add(actionRequest, GestioneEntiPortletKeys.ERRORE_SALVATAGGIO);
		}
	}
}