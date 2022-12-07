package it.servizidigitali.accreditamentoenti.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
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
import it.servizidigitali.accreditamentoenti.model.ResponsabileEnte;
import it.servizidigitali.accreditamentoenti.service.EnteLocalService;
import it.servizidigitali.accreditamentoenti.service.ResponsabileEnteLocalService;

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

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private ResponsabileEnteLocalService responsabileEnteLocalService;

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
			validateNotNullField(actionRequest, denominazione, "denominazione");
			validateNotNullField(actionRequest, tipo, "tipo");
			validateNotNullField(actionRequest, codiceIPA, "codiceIPA");
			validateNotNullField(actionRequest, pec, "pec");

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

			ente = enteLocalService.updateEnte(ente);

			saveResponsabili(actionRequest, ente.getEnteId());

			SessionMessages.add(actionRequest, AccreditamentoEntiFrontendPortletKeys.SALVATAGGIO_SUCCESSO);
		} catch (Exception e) {
			_log.error("Impossibile salvare/aggiornare l'ente con ID: " + enteId, e);
			SessionErrors.add(actionRequest, AccreditamentoEntiFrontendPortletKeys.ERRORE_SALVATAGGIO);
		}
		actionResponse.sendRedirect(redirect);
	}

	private void validateNotNullField(ActionRequest actionRequest, String field, String fieldName) throws Exception {
		if (Validator.isNull(field)) {
			_log.error("Campo obbligatorio: " + fieldName);
			SessionErrors.add(actionRequest, AccreditamentoEntiFrontendPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			throw new Exception(AccreditamentoEntiFrontendPortletKeys.ERRORE_CAMPI_OBBLIGATORI);
		}
	}

	private Ente getEnte(ActionRequest actionRequest, Long enteId) throws Exception {
		if (Validator.isNotNull(enteId)) {
			try {
				return enteLocalService.getEnte(enteId);
			} catch (Exception ex) {
				_log.error(ex);
				SessionErrors.add(actionRequest,
						AccreditamentoEntiFrontendPortletKeys.ERRORE_IMPOSSIBILE_OTTENERE_ENTE);
				throw new Exception(AccreditamentoEntiFrontendPortletKeys.ERRORE_IMPOSSIBILE_OTTENERE_ENTE);
			}
		}
		// new
		return enteLocalService.createEnte(counterLocalService.increment());
	}

	private void saveResponsabili(ActionRequest actionRequest, long enteId) {
		String newIndexesS = ParamUtil.getString(actionRequest, AccreditamentoEntiFrontendPortletKeys.NEW_ROWS_INDEX);

		String[] newIndexes = newIndexesS.split(",");

		for (String index : newIndexes) {
			String cf = ParamUtil.getString(actionRequest,
					AccreditamentoEntiFrontendPortletKeys.CODICE_FISCALE + index);
			
			if (cf == null || cf.isBlank()) {
				continue;
			}

			try {
				User user = userLocalService.getUserByScreenName(CompanyThreadLocal.getCompanyId(), cf);
				
				//TODO check duplicati
				ResponsabileEnte responsabileEnte = responsabileEnteLocalService.createResponsabileEnte(counterLocalService.increment());
				responsabileEnte.setResponsabileUserId(user.getUserId());
				responsabileEnte.setEnteId(enteId);
				
				responsabileEnteLocalService.updateResponsabileEnte(responsabileEnte);
				
			} catch (PortalException ex) {
				// TODO manage error
				_log.error("User not found: " + cf);
			}
		}
	}
}