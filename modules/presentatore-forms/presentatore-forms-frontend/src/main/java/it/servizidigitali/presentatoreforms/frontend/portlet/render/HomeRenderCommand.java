package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.AlpacaService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.IstanzaFormLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=" + PresentatoreFormsPortletKeys.HOME_RENDER_COMMAND
		},
		service = MVCRenderCommand.class
	)
public class HomeRenderCommand implements MVCRenderCommand{
	
	public static final Log _log = LogFactoryUtil.getLog(HomeRenderCommand.class);
	
	@Reference
	private RichiestaLocalService richiestaLocalService;
	
//	@Reference
//	private GestioneProcedureMiddlewareService gestioneProcedureMiddlewareService;
	
	@Reference
	private ServizioLocalService servizioLocalService;
	
	@Reference
	private FormLocalService formLocalService;
	
	@Reference
	private ProceduraFormLocalService proceduraFormLocalService;
	
	@Reference
	private IstanzaFormLocalService istanzaFormLocalService;
	
	@Reference
	private AlpacaService alpacaService;
	

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long richiestaId = 0;
		long servizioId = 0;
		
		Richiesta richiesta = null;
		Procedura procedura = null;
		Servizio servizio = null;
		AlpacaJsonStructure alpacaStructure = null;
		
		List<String> lstDestinazioniUso = getListaDestinazioniUso();
		
		if(Validator.isNotNull(richiestaId)) {
			try {
				richiesta = richiestaLocalService.getRichiesta(richiestaId);
			} catch (Exception e) {
				_log.error("Impossibile recuperare la richiesta con ID: " + richiestaId + "a causa di: " + e.getMessage());
				// capire a quale jsp deve puntare in caso di errore
				SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_RICHIESTA);
			}
		
			try {
//				procedura = gestioneProcedureMiddlewareService.getProcedura(themeDisplay.getSiteGroupId(), servizioId, true);
			} catch (Exception e) {
				_log.error("Impossibile recuperare la procedura con servizioId: " + servizioId + "a causa di: " + e.getMessage());
				// capire a quale jsp deve puntare in caso di errore
				SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_PROCEDURA);
			}
		
			try {
				servizio = servizioLocalService.getServizioById(procedura.getServizioId());
			} catch (Exception e) {
				_log.error("Impossibile recuperare il servizio con ID: " + procedura.getServizioId() + "a causa di: " + e.getMessage());
				// capire a quale jsp deve puntare in caso di errore
				SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_SERVIZIO);
			}
		}else {
			_log.error("Non è stato possibile recuperare l'id della richiesta!");
			SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_RICHIESTA);
			// capire a quale jsp deve puntare in caso di errore
		}
		
		
		renderRequest.setAttribute("statoRichiesta", richiesta.getStato());
		renderRequest.setAttribute("configurazioneTipoServizioStep2", procedura.getStep2TipoServizio());
		renderRequest.setAttribute("destinazioniUso", lstDestinazioniUso);
		
		try {
			if(richiesta.getStato().equalsIgnoreCase(StatoRichiesta.BOZZA.name())) {
				renderRequest.setAttribute("bozzaPresente", true);
				return "/home.jsp";
			}else {
				alpacaStructure = getAlpacaJsonStructure(richiesta.getRichiestaId(),procedura,false);
				renderRequest.setAttribute(PresentatoreFormsPortletKeys.ALPACA_STRUCTURE, alpacaStructure);
				
				return PresentatoreFormsPortletKeys.JSP_COMPILA_FORM;
				
			}
		}catch(Exception e) {
			_log.error("Errore durante la visualizzazione del form!" + e.getMessage());
		}
		
		return PresentatoreFormsPortletKeys.JSP_HOME;

	}
	
	private AlpacaJsonStructure getAlpacaJsonStructure(long idRichiesta, Procedura procedura, Boolean caricaBozza) {
		Gson gson = new Gson();
		String jsonDataBozza = null;
		IstanzaForm istanzaForm = null;
		Form form = null;
		
		try {
			form = formLocalService.getForm(75716);
		} catch (PortalException e) {
			_log.error("Errore durante il recupero del form con id 75716" + e.getMessage());
		}
		
//		if(Validator.isNotNull(procedura)) {
//			form = gestioneProcedureMiddlewareService.getFormPrincipaleProcedura(procedura.getProceduraId());
//			
//		}
		
		if(Validator.isNotNull(caricaBozza) && caricaBozza && idRichiesta>0) {
			
			try {
				// TODO: Sostituire con metodo che ritorna istanza per idRichiesta
				istanzaForm = istanzaFormLocalService.getIstanzaForm(idRichiesta);
			}
			catch (PortalException e) {
				_log.error("Impossibile recuperare l'istanza della richiesta con ID : " + idRichiesta + "per: " + e.getMessage());
			}
			
			jsonDataBozza = istanzaForm.getJson();
		}else {
			/*
			 * TODO: Eliminare bozze precedenti
			 */
		}
		
		FormData formData = null;
		AlpacaJsonStructure alpacaStructure = null;
		
		if(Validator.isNotNull(form)) {
			formData = AlpacaUtil.loadFormData(form, jsonDataBozza, caricaBozza);
			alpacaStructure = formData.getAlpaca();
		}

		UserPreferences userPreferences = new UserPreferences();
		userPreferences.setCodiceFiscaleComponente(null);
		userPreferences.setCodiceFiscaleRichiedente(null);
		
		if(Validator.isNotNull(caricaBozza) && !caricaBozza && (Validator.isNotNull(alpacaStructure.getData()) && alpacaStructure.getData() instanceof JsonObject)) {
			JsonObject data = gson.fromJson(gson.toJson(alpacaStructure.getData()), JsonObject.class);
			
			try {
				alpacaService.loadData(data, gson.toJson(alpacaStructure.getSchema()), gson.toJson(alpacaStructure.getOptions()), procedura, userPreferences);
				alpacaStructure.setData(data);
			}catch(Exception e) {
				_log.error("Impossibile recuperare le informazioni dai servizi di integrazione!" + e.getMessage());				
				return null;
			}
		}
		
		
		// Chiedere perché viene sostituito nuovamente il valore di data
		
		try {
			AlpacaUtil.loadView(alpacaStructure);
		} catch (JSONException e) {
			_log.error("Impossibile caricare la view del form!" + e.getMessage());
		}
		
		return alpacaStructure;

	}
	
	private List<String> getListaDestinazioniUso(){
		List<String> lstDestinazioniUso = new ArrayList<String>();
		lstDestinazioniUso.add("Bollo");
		lstDestinazioniUso.add("Esenzione");
		
		return lstDestinazioniUso;
	}

}