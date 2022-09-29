package it.servizidigitali.gestioneprocedure.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoGenerazionePDF;
import it.servizidigitali.gestioneprocedure.frontend.constants.GestioneProcedurePortletKeys;
import it.servizidigitali.gestioneprocedure.frontend.service.GestioneProcedureMiddlewareService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.model.TemplatePdf;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneprocedure.service.TemplatePdfLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + GestioneProcedurePortletKeys.GESTIONEPROCEDURE,
		"mvc.command.name=" + GestioneProcedurePortletKeys.SALVA_CREA_ACTION_COMMAND }, service = { MVCActionCommand.class })
public class SalvaCreaActionCommand extends BaseMVCActionCommand {

	public static final Log _log = LogFactoryUtil.getLog(SalvaCreaActionCommand.class);

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private TemplatePdfLocalService templatePdfLocalService;

	@Reference
	private GestioneProcedureMiddlewareService gestioneProcedureMiddlewareService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		String userFullName = themeDisplay.getUser().getFullName();
		long userId = themeDisplay.getUserId();
		long siteGroupId = themeDisplay.getSiteGroupId();
		long companyGroupId = themeDisplay.getCompanyGroupId();

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String rowIndexes = ParamUtil.getString(actionRequest, "countJasperReport");

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
		boolean abilitaCacheIntegrazioneBackoffice = ParamUtil.getBoolean(actionRequest, GestioneProcedurePortletKeys.ABILITA_CACHE_INTEGRAZIONI_BACKOFFICE);

		String tipoGenerazioneTemplate = ParamUtil.getString(actionRequest, GestioneProcedurePortletKeys.TIPI_GENERAZIONE_TEMPLATE);

		Procedura procedura = null;

		if (idProcedura > 0) {
			procedura = proceduraLocalService.getProcedura(idProcedura);
		}
		else {
			procedura = proceduraLocalService.createProcedura(counterLocalService.increment());
		}

		if (Validator.isNull(nome)) {
			SessionErrors.add(actionRequest, GestioneProcedurePortletKeys.SESSION_ERROR_CAMPI_OBBLIGATORI);
			_log.error("GestioneProcedura :: salvaCrea :: Compilare tutti i campi obbligatori!");
			actionResponse.getRenderParameters().setValue("jspPage", GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA);
			return;
		}

		if (Validator.isNull(pec)) {
			SessionErrors.add(actionRequest, GestioneProcedurePortletKeys.SESSION_ERROR_CAMPI_OBBLIGATORI);
			_log.error("GestioneProcedura :: salvaCrea :: Compilare tutti i campi obbligatori!");
			actionResponse.getRenderParameters().setValue("jspPage", GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA);
			return;
		}

		if (Validator.isNull(idServizio)) {
			SessionErrors.add(actionRequest, GestioneProcedurePortletKeys.SESSION_ERROR_CAMPI_OBBLIGATORI);
			_log.error("GestioneProcedura :: salvaCrea :: Compilare tutti i campi obbligatori!");
			actionResponse.getRenderParameters().setValue("jspPage", GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA);
			return;
		}

		if (Validator.isNull(idFormPrincipale)) {
			SessionErrors.add(actionRequest, GestioneProcedurePortletKeys.SESSION_ERROR_CAMPI_OBBLIGATORI);
			_log.error("GestioneProcedura :: salvaCrea :: Compilare tutti i campi obbligatori!");
			actionResponse.getRenderParameters().setValue("jspPage", GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA);
			return;
		}

		procedura.setNome(nome);
		procedura.setPecDestinazione(pec);
		procedura.setAttiva(attivaProcedura);
		procedura.setServizioId(idServizio);
		procedura.setProcessoId(idProcesso);

		procedura.setStep1Attivo(step1Attivo);
		procedura.setStep1TipoComponentiNucleoFamiliare(filtroComponentiNucleoFamiliare);

		procedura.setStep2TipoServizio(tipologiaServizio);
		procedura.setStep2TipiIntegrazioneBackoffice(String.join(",", tipiIntegrazioniBackoffice));
		procedura.setAbilitaCacheIntegrazioneBackoffice(abilitaCacheIntegrazioneBackoffice);
		procedura.setTipoGenerazionePDF(tipoGenerazioneTemplate);

		procedura.setUserId(serviceContext.getThemeDisplay().getUserId());
		procedura.setGroupId(serviceContext.getThemeDisplay().getSiteGroupId());
		procedura.setUserName(serviceContext.getThemeDisplay().getUser().getFullName());

		SessionMessages.add(actionRequest, GestioneProcedurePortletKeys.SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE);
		proceduraLocalService.updateProcedura(procedura);

		gestioneProcedureMiddlewareService.salvaProceduraFormPrincipale(idFormPrincipale, procedura.getProceduraId());
		gestioneProcedureMiddlewareService.salvaListaFormIntegrativi(idFormIntegrativi, procedura.getProceduraId());

		if (Validator.isNotNull(tipoGenerazioneTemplate)) {
			if (tipoGenerazioneTemplate.equalsIgnoreCase(TipoGenerazionePDF.JASPER_REPORT.name())) {
				List<Long> listaReportDaMantenere = new ArrayList<Long>();
				TemplatePdf templateCaricato = null;
				TemplatePdf templatePrincipaleProcedura = null;
				if (Validator.isNotNull(rowIndexes)) {
					long reportIdNuovoPrincipale = 0;

					if (idProcedura > 0) {
						templatePrincipaleProcedura = gestioneProcedureMiddlewareService.recuperaTemplatePdfPrincipale(idProcedura);
					}

					for (int i = 0; i < Long.valueOf(rowIndexes); i++) {
						boolean principale = ParamUtil.getBoolean(actionRequest, "allegatoPrincipale" + i);
						long reportId = ParamUtil.getLong(actionRequest, "idAllegatoJasper" + i);
						File file = uploadPortletRequest.getFile("jasperReportFile" + i);
						String nomeFile = uploadPortletRequest.getFileName("jasperReportFile" + i);

						if (reportId > 0) {
							listaReportDaMantenere.add(reportId);
						}

						if (Validator.isNotNull(templatePrincipaleProcedura)) {
							if (principale && templatePrincipaleProcedura.getTemplatePdfId() != reportId) {
								reportIdNuovoPrincipale = reportId;
							}
						}

						if (Validator.isNotNull(file)) {
							templateCaricato = gestioneProcedureMiddlewareService.caricaTemplatePdf(file, nomeFile, principale, procedura.getProceduraId(), reportId, i, userFullName, userId,
									siteGroupId, companyGroupId);

							if (Validator.isNotNull(templateCaricato)) {
								listaReportDaMantenere.add(templateCaricato.getTemplatePdfId());
							}
						}

					}

					if (reportIdNuovoPrincipale > 0) {
						gestioneProcedureMiddlewareService.aggiornaPrincipaleTemplatePdf(templatePrincipaleProcedura, reportIdNuovoPrincipale);
					}

					gestioneProcedureMiddlewareService.deleteTemplatePdf(listaReportDaMantenere, procedura.getProceduraId());
				}
			}
			else if (tipoGenerazioneTemplate.equalsIgnoreCase(TipoGenerazionePDF.NATIVA.name())) {
				// Eliminazione Jasper report, se presenti
				gestioneProcedureMiddlewareService.deleteTemplatePdfProcedura(idProcedura);
			}
		}
	}

}
