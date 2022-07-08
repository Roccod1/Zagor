package it.servizidigitali.gestioneenti.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
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

@Component(immediate = true, //
		property = { "javax.portlet.name=" + GestioneEntiPortletKeys.GESTIONEENTI, "mvc.command.name=/salva" }, //
		service = MVCActionCommand.class//
) //
public class AggiungiModificaEnteServizioActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaEnteServizioActionCommand.class);

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		Long servizioId = ParamUtil.getLong(actionRequest, "servizioId");
		Long organizationId = ParamUtil.getLong(actionRequest, "organizationId");
		String uri = ParamUtil.getString(actionRequest, "uri");
		String uriGuest = ParamUtil.getString(actionRequest, "uriGuest");
		String uriScheda = ParamUtil.getString(actionRequest, "uriScheda");
		Boolean autenticazione = ParamUtil.getBoolean(actionRequest, "autenticazione");
		Boolean attivo = ParamUtil.getBoolean(actionRequest, "attivo");
		Date dataInizioAttivazione = ParamUtil.getDate(actionRequest, "dataInizioAttivazione", GestioneEntiPortlet.simpleDateFormat, null);
		Date dataFineAttivazione = ParamUtil.getDate(actionRequest, "dataFineAttivazione", GestioneEntiPortlet.simpleDateFormat, null);
		Boolean cittadino = ParamUtil.getBoolean(actionRequest, "cittadino");
		Boolean azienda = ParamUtil.getBoolean(actionRequest, "azienda");
		Boolean delega = ParamUtil.getBoolean(actionRequest, "delega");
		Boolean allegatoDelega = ParamUtil.getBoolean(actionRequest, "allegatoDelega");
		Boolean privacyDelega = ParamUtil.getBoolean(actionRequest, "privacyDelega");
		Boolean prenotabile = ParamUtil.getBoolean(actionRequest, "prenotabile");
		Boolean chatBot = ParamUtil.getBoolean(actionRequest, "chatBot");

		ServizioEntePK servizioEntePK = new ServizioEntePK();
		servizioEntePK.setServizioId(servizioId);
		servizioEntePK.setOrganizationId(organizationId);

		ServizioEnte servizioEnte = null;
		if (servizioId > 0) {
			servizioEnte = servizioEnteLocalService.getServizioEnte(servizioEntePK);
		}
		else {
			servizioEnte = servizioEnteLocalService.createServizioEnte(servizioEntePK);
		}

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

		try {
			servizioEnteLocalService.updateServizioEnte(servizioEnte);
			SessionMessages.add(actionRequest, GestioneEntiPortletKeys.SALVATAGGIO_SUCCESSO);
			MutableRenderParameters params = actionResponse.getRenderParameters();
			params.setValue("mvcPath", "/view.jsp");
		}
		catch (Exception e) {
			_log.error("Impossibile salvare/aggiornare il servizio con ID: " + servizioId, e);
			throw e;
		}
	}
}