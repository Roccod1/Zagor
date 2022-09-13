package it.servizidigitali.gestioneprocedure.frontend.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.enums.TipoIntegrazioneBackoffice;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.frontend.constants.GestioneProcedurePortletKeys;
import it.servizidigitali.gestioneprocedure.frontend.enumeration.FiltroComponentiNucleoFamiliare;
import it.servizidigitali.gestioneprocedure.frontend.enumeration.TipoGenerazionePDF;
import it.servizidigitali.gestioneprocedure.frontend.enumeration.TipoServizio;
import it.servizidigitali.gestioneprocedure.frontend.service.GestioneProcedureMiddlewareService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.service.ProcessoLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + GestioneProcedurePortletKeys.GESTIONEPROCEDURE,
			"mvc.command.name=" + GestioneProcedurePortletKeys.DETTAGLIO_NUOVO_RENDER_COMMAND
		},
		service = MVCRenderCommand.class
	)
public class DettaglioNuovoRenderCommand implements MVCRenderCommand{
	
	private static final Log _log = LogFactoryUtil.getLog(DettaglioNuovoRenderCommand.class);

	
	@Reference
	private GestioneProcedureMiddlewareService gestioneProcedureMiddlewareService;
	
	@Reference
	private ProcessoLocalService processoLocalService;
	
	@Reference
	private FormLocalService formLocalService;
	
	@Reference
	private ProceduraLocalService proceduraLocalService;
	
	@Reference
	private ProceduraFormLocalService proceduraFormLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long idProcedura = ParamUtil.getLong(renderRequest, GestioneProcedurePortletKeys.ID_PROCEDURA);
		
		List<Servizio> listaServizi = new ArrayList<Servizio>();
		List<Processo> listaProcessi = new ArrayList<Processo>();
		List<Form> listaFormPrincipali = new ArrayList<Form>();
		List<Form> listaFormIntegrativi = new ArrayList<Form>();
		
		
		Procedura procedura = null;
		String listaFormIntegrativiProcedura = null;
		long idFormPrincipale = 0;
		
		try {
			listaServizi = gestioneProcedureMiddlewareService.getServiziByOrganizationAttivo(themeDisplay.getSiteGroup().getOrganizationId());
		} catch (Exception e) {
			_log.error("Impossibile recuperare la lista dei servizi!" + e.getMessage());
			SessionErrors.add(renderRequest, GestioneProcedurePortletKeys.SESSION_ERROR_IMPOSSIBILE_RECUPERARE_SERVIZI);
			return GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA;
		}
		
		try {
			listaProcessi = processoLocalService.getListaProcessiByOrganizationAttivo(themeDisplay.getSiteGroupId(), true);
		}catch(Exception e) {
			_log.error("Impossibile recuperare la lista dei processi attivi!" + e.getMessage());
			SessionErrors.add(renderRequest, GestioneProcedurePortletKeys.SESSION_ERROR_IMPOSSIBILE_RECUPERARE_PROCESSI);
			return GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA;
		}
		
		try {
			listaFormPrincipali = formLocalService.getListaFormByOrganizationPrincipale(themeDisplay.getSiteGroupId(), true);			
		}catch(Exception e) {
			_log.error("Impossibile recuperare la lista dei form principali!" + e.getMessage());
			SessionErrors.add(renderRequest, GestioneProcedurePortletKeys.SESSION_ERROR_IMPOSSIBILE_RECUPERARE_FORM_PRINCIPALI);
			return GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA;
		}

		try {
			listaFormIntegrativi = formLocalService.getListaFormByOrganizationPrincipale(themeDisplay.getSiteGroupId(), false);
		}catch(Exception e) {
			_log.error("Impossibile recuperare la lista dei form integrativi!" + e.getMessage());
			SessionErrors.add(renderRequest, GestioneProcedurePortletKeys.SESSION_ERROR_IMPOSSIBILE_RECUPERARE_FORM_INTEGRATIVI);
			return GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA;
		}

		if(idProcedura>0) {
			try {
				procedura = proceduraLocalService.getProcedura(idProcedura);
				listaFormIntegrativiProcedura = proceduraFormLocalService.getFormIntegrativiProcedura(idProcedura);
				idFormPrincipale = proceduraFormLocalService.getFormPrincipaleProcedura(idProcedura);
				String tipiIntegrazioneBackoffice = null;
				
				if(idFormPrincipale>0) {
					renderRequest.setAttribute(GestioneProcedurePortletKeys.ID_FORM_PRINCIPALE, idFormPrincipale);
				}
				
				if(Validator.isNotNull(procedura.getStep2TipiIntegrazioneBackoffice())) {
					tipiIntegrazioneBackoffice = proceduraLocalService.getStringSelectMultipla(procedura.getStep2TipiIntegrazioneBackoffice());
					renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_TIPO_INTEGRAZIONE_BACKOFFICE_PROCEDURA, tipiIntegrazioneBackoffice);
				}else {
					renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_TIPO_INTEGRAZIONE_BACKOFFICE_PROCEDURA, GestioneProcedurePortletKeys.LISTA_VUOTA);
				}
				
				if(Validator.isNotNull(listaFormIntegrativiProcedura)) {
					renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_FORM_INTEGRATIVI_PROCEDURA, listaFormIntegrativiProcedura);
				}else {
					renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_FORM_INTEGRATIVI_PROCEDURA, GestioneProcedurePortletKeys.LISTA_VUOTA);
				}
				
				renderRequest.setAttribute(GestioneProcedurePortletKeys.PROCEDURA, procedura);
			} catch (Exception e) {
				_log.error("Impossibile recuperare la procedura con ID : " + idProcedura + e.getMessage());
				SessionErrors.add(renderRequest, GestioneProcedurePortletKeys.SESSION_ERROR_IMPOSSIBILE_RECUPERARE_PROCEDURA);
				return GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA;
			}
		}else {
			renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_FORM_INTEGRATIVI_PROCEDURA, GestioneProcedurePortletKeys.LISTA_VUOTA);
			renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_TIPO_INTEGRAZIONE_BACKOFFICE_PROCEDURA, GestioneProcedurePortletKeys.LISTA_VUOTA);
		}
		
		
		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_TIPO_COMPONENTI_FAMILIARI, FiltroComponentiNucleoFamiliare.values());
		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_TIPO_SERVIZIO, TipoServizio.values());
		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_TIPO_GENERAZIONE_PDF, TipoGenerazionePDF.values());
		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_TIPO_INTEGRAZIONE_BACKOFFICE,TipoIntegrazioneBackoffice.values());
		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_SERVIZI,listaServizi);
		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_PROCESSI,listaProcessi);
		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_FORM_PRINCIPALI, listaFormPrincipali);
		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_FORM_INTEGRATIVI, listaFormIntegrativi);
		
		return GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA;
	}

}