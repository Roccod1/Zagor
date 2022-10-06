package it.servizidigitali.gestioneforms.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
import it.servizidigitali.gestioneforms.frontend.service.GestioneFormsMiddlewareService;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;

/**
 * @author COSTABILEE
 *
 */
@Component( //
		immediate = true, //
		property = { //
				"javax.portlet.name=" + GestioneFormsPortletKeys.GESTIONEFORMS, //
				"mvc.command.name=" + GestioneFormsPortletKeys.SALVA_AGGIUNGI_ACTION_COMMAND }, //
		service = { MVCActionCommand.class } //
)
public class SalvaModificaActionCommand extends BaseMVCActionCommand {

	public static final Log _log = LogFactoryUtil.getLog(SalvaModificaActionCommand.class);

	@Reference
	private FormLocalService formLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private GestioneFormsMiddlewareService gestioneFormsMiddlewareService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		long idForm = ParamUtil.getLong(actionRequest, GestioneFormsPortletKeys.ID_FORM);
		String codice = ParamUtil.getString(actionRequest, GestioneFormsPortletKeys.CODICE);
		String nome = ParamUtil.getString(actionRequest, GestioneFormsPortletKeys.NOME);
		boolean principale = ParamUtil.getBoolean(actionRequest, GestioneFormsPortletKeys.PRINCIPALE);
		String modelloForm = ParamUtil.getString(actionRequest, GestioneFormsPortletKeys.MODELLO_FORM);

		long indiceListaDefinizioneAllegati = ParamUtil.getLong(actionRequest, GestioneFormsPortletKeys.DIMENSIONE_LISTA_ALLEGATI);

		Form form = null;

		if (Validator.isNull(nome)) {
			SessionErrors.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
			actionRequest.setAttribute(GestioneFormsPortletKeys.MODELLO_FORM, modelloForm);
			actionResponse.getRenderParameters().setValue("jspPage", "/aggiungiModificaForm.jsp");
			return;
		}

		if (Validator.isNull(codice)) {
			SessionErrors.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
			actionRequest.setAttribute(GestioneFormsPortletKeys.MODELLO_FORM, modelloForm);
			actionResponse.getRenderParameters().setValue("jspPage", "/aggiungiModificaForm.jsp");
			return;
		}

		if (Validator.isNotNull(idForm) && idForm > 0) {
			form = formLocalService.getForm(idForm);
		}
		else {
			form = formLocalService.createForm(counterLocalService.increment());
		}

		form.setCodice(codice);
		form.setNome(nome);
		form.setJson(modelloForm);
		form.setPrincipale(principale);
		form.setUserId(themeDisplay.getUserId());
		form.setGroupId(themeDisplay.getSiteGroupId());
		form.setUserName(themeDisplay.getUser().getFullName());
		long organizationId = themeDisplay.getScopeGroup().getOrganizationId();
		if (organizationId != 0) {
			form.setOrganizationId(organizationId);
		}

		Form newForm = formLocalService.updateForm(form);

		// Recupero elenco allegati specificati nella creazione del form
		try {
			for (int i = 0; i < indiceListaDefinizioneAllegati; i++) {
				long definizioneAllegatoId = ParamUtil.getLong(actionRequest, GestioneFormsPortletKeys.DEFINIZIONE_ALLEGATO_ID + i);
				String denominazione = ParamUtil.getString(actionRequest, GestioneFormsPortletKeys.DEFINIZIONE_ALLEGATO_DENOMINAZIONE + i);
				String[] tipiFileAmmessi = ParamUtil.getParameterValues(actionRequest, GestioneFormsPortletKeys.DEFINIZIONE_ALLEGATO_FILE_AMMESSI + i);
				String[] codiciTipologiaDocumento = ParamUtil.getParameterValues(actionRequest, GestioneFormsPortletKeys.DEFINIZIONE_ALLEGATO_CODICI_TIPOLOGIA + i);
				String fileNameModello = ParamUtil.getString(actionRequest, GestioneFormsPortletKeys.DEFINIZIONE_ALLEGATO_FILENAME + i);
				boolean obbligatorio = ParamUtil.getBoolean(actionRequest, GestioneFormsPortletKeys.DEFINIZIONE_ALLEGATO_OBBLIGATORIO + i);
				File fileCaricato = uploadPortletRequest.getFile("fileInput" + i);

				if (Validator.isNull(denominazione)) {
					SessionErrors.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
					actionRequest.setAttribute(GestioneFormsPortletKeys.MODELLO_FORM, modelloForm);
					actionResponse.getRenderParameters().setValue("jspPage", "/aggiungiModificaForm.jsp");
					return;
				}

				if (Validator.isNull(tipiFileAmmessi)) {
					SessionErrors.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
					actionRequest.setAttribute(GestioneFormsPortletKeys.MODELLO_FORM, modelloForm);
					actionResponse.getRenderParameters().setValue("jspPage", "/aggiungiModificaForm.jsp");
					return;
				}

				if (Validator.isNotNull(fileCaricato)) {
					gestioneFormsMiddlewareService.salvaAllegatoTemplate(definizioneAllegatoId, denominazione, tipiFileAmmessi, codiciTipologiaDocumento, fileNameModello, obbligatorio, fileCaricato,
							form.getFormId(), themeDisplay.getUserId(), themeDisplay.getSiteGroupId());
				}
			}
		}
		catch (Exception e) {
			_log.error("doProcessAction :: " + e.getMessage(), e);
			// rollback in caso di generazione nuovo form
			if (Validator.isNull(idForm)) {
				formLocalService.deleteForm(newForm);
			}
			SessionErrors.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO_ALLEGATI);
			actionRequest.setAttribute(GestioneFormsPortletKeys.MODELLO_FORM, modelloForm);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", GestioneFormsPortletKeys.DETTAGLIO_NUOVO_RENDER_COMMAND);
			return;
		}

		// Controllo su eventuali rimozioni degli allegati
		String[] allegatiDaEliminare = ParamUtil.getParameterValues(actionRequest, GestioneFormsPortletKeys.LISTA_ALLEGATI_DA_ELIMINARE);
		gestioneFormsMiddlewareService.eliminaAllegati(allegatiDaEliminare);

		SessionMessages.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE);
	}

}
