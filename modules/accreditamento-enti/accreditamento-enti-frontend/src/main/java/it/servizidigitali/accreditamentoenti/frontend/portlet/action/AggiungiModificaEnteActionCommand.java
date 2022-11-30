package it.servizidigitali.accreditamentoenti.frontend.portlet.action;

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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.accreditamentoenti.frontend.constants.AccreditamentoEntiFrontendPortletKeys;
import it.servizidigitali.accreditamentoenti.model.Ente;
import it.servizidigitali.accreditamentoenti.service.EnteLocalService;

/**
 * @author mancinig
 */

@Component(//
		immediate = true, //
		property = { //
				"javax.portlet.name=" + AccreditamentoEntiFrontendPortletKeys.ACCREDITAMENTOENTIFRONTEND, //
				"mvc.command.name=" + AccreditamentoEntiFrontendPortletKeys.SALVA_ACTION_COMMAND_NAME//
		}, //
		service = MVCActionCommand.class)
public class AggiungiModificaEnteActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaEnteActionCommand.class);

	@Reference
	private EnteLocalService enteLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		Long enteId = ParamUtil.getLong(actionRequest, AccreditamentoEntiFrontendPortletKeys.ENTE_ID);
		String denominazione = ParamUtil.getString(actionRequest, AccreditamentoEntiFrontendPortletKeys.DENOMINAZIONE);
		String tipo = ParamUtil.getString(actionRequest, AccreditamentoEntiFrontendPortletKeys.TIPO);
		String codiceIPA = ParamUtil.getString(actionRequest, AccreditamentoEntiFrontendPortletKeys.CODICE_IPA);
		String strutturaRiferimento = ParamUtil.getString(actionRequest,
				AccreditamentoEntiFrontendPortletKeys.STRUTTURA_DI_RIFERIMENTO);
		String pec = ParamUtil.getString(actionRequest, AccreditamentoEntiFrontendPortletKeys.PEC);
		String sitoWeb = ParamUtil.getString(actionRequest, AccreditamentoEntiFrontendPortletKeys.SITO_WEB);

		String redirect = ParamUtil.getString(actionRequest,
				AccreditamentoEntiFrontendPortletKeys.INDIRIZZO_PRECEDENTE);

		try {
			if (Validator.isNull(denominazione)) {
				_log.error("Il campo denominazione è obbligatorio");
				SessionErrors.add(actionRequest, AccreditamentoEntiFrontendPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
				throw new Exception(AccreditamentoEntiFrontendPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			}

			if (Validator.isNull(tipo)) {
				_log.error("Il campo tipo è obbligatorio");
				SessionErrors.add(actionRequest, AccreditamentoEntiFrontendPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
				throw new Exception(AccreditamentoEntiFrontendPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			}

			if (Validator.isNull(codiceIPA)) {
				_log.error("Il campo codice IPA è obbligatorio");
				SessionErrors.add(actionRequest, AccreditamentoEntiFrontendPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
				throw new Exception(AccreditamentoEntiFrontendPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			}

			if (Validator.isNull(pec)) {
				_log.error("Il campo codice PEC è obbligatorio");
				SessionErrors.add(actionRequest, AccreditamentoEntiFrontendPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
				throw new Exception(AccreditamentoEntiFrontendPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			}

			Ente ente = getEnte(actionRequest, enteId);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
			ente.setGroupId(themeDisplay.getCompanyGroupId());
			ente.setUserId(themeDisplay.getUserId());
			ente.setUserName(themeDisplay.getUser().getFullName());

			ente.setDenominazione(denominazione);
			ente.setTipo(tipo);
			ente.setCodiceIPA(codiceIPA);
			ente.setStrutturaRiferimento(strutturaRiferimento);
			ente.setPec(pec);
			ente.setSitoWeb(sitoWeb);

			enteLocalService.updateEnte(ente);
			SessionMessages.add(actionRequest, AccreditamentoEntiFrontendPortletKeys.SALVATAGGIO_SUCCESSO);
		} catch (Exception e) {
			_log.error("Impossibile salvare/aggiornare l'ente con ID: " + enteId, e);
			SessionErrors.add(actionRequest, AccreditamentoEntiFrontendPortletKeys.ERRORE_SALVATAGGIO);
		}
		actionResponse.sendRedirect(redirect);
	}

	private Ente getEnte(ActionRequest actionRequest, Long enteId) throws Exception {
		Ente ente;
		if (Validator.isNotNull(enteId)) {
			try {
				ente = enteLocalService.getEnte(enteId);
			} catch (Exception ex) {
				_log.error(ex);
				SessionErrors.add(actionRequest,
						AccreditamentoEntiFrontendPortletKeys.ERRORE_IMPOSSIBILE_OTTENERE_ENTE);
				throw new Exception(AccreditamentoEntiFrontendPortletKeys.ERRORE_IMPOSSIBILE_OTTENERE_ENTE);
			}
		} else {
			ente = enteLocalService.createEnte(0);
		}
		return ente;
	}
}