package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Validator;

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
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.AlpacaService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.exception.NoSuchIstanzaFormException;
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
	
	@Reference
	private ProceduraLocalService proceduraLocalService;
	
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
		Long idRichiesta = null;
		Richiesta richiesta = null;
		Procedura procedura = null;
		Servizio servizio = null;
		AlpacaJsonStructure alpacaStructure = null;
		
		List<String> lstDestinazioniUso = getListaDestinazioniUso();
		
		if(Validator.isNotNull(idRichiesta)) {
			try {
				richiesta = richiestaLocalService.getRichiesta(idRichiesta);
			} catch (Exception e) {
				_log.error("Impossibile recuperare la richiesta con ID: " + idRichiesta + "a causa di: " + e.getMessage());
				// capire a quale jsp deve puntare in caso di errore
				SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_RICHIESTA);
			}
		
			try {
				procedura = proceduraLocalService.getProcedura(richiesta.getProceduraId());
			} catch (Exception e) {
				_log.error("Impossibile recuperare la procedura con ID: " + idRichiesta + "a causa di: " + e.getMessage());
				// capire a quale jsp deve puntare in caso di errore
				SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_PROCEDURA);
			}
		
			try {
				servizio = servizioLocalService.getServizioById(procedura.getServizioId());
			} catch (Exception e) {
				_log.error("Impossibile recuperare il servizio con ID: " + idRichiesta + "a causa di: " + e.getMessage());
				// capire a quale jsp deve puntare in caso di errore
				SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_SERVIZIO);
			}
		}else {
			_log.error("Non è stato possibile recuperare l'id della richiesta!");
			SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_RICHIESTA);
			// capire a quale jsp deve puntare in caso di errore
		}
		
		if(richiesta.getStato().equalsIgnoreCase(StatoRichiesta.BOZZA.name())) {
			renderRequest.setAttribute("bozzaPresente", true);
			/*
			 * Return della jsp dove permette di scegliere
			 * se caricare la bozza oppure compilare nuova
			 * istanza
			 */
			
			;
		}else {
			
			/*
			 * TODO: Affinare la condizione nell'if una volta fatto il merge
			 * del branch con gestione procedure
			 */
//			if(Validator.isNotNull(procedura.getConfigurazioniPresentatoreForm())) {
				try {
					alpacaStructure = getAlpacaJsonStructure(richiesta.getRichiestaId(),procedura,false);
				}catch(Exception e) {
					_log.error("Errore durante la visualizzazione del form!" + e.getMessage());
					// capire a quale jsp deve puntare in caso di errore
				}
//			}
		}
		
		renderRequest.setAttribute("statoRichiesta", richiesta.getStato());
		renderRequest.setAttribute("configurazioneTipoServizioStep2", "CERTIFICATO");
		renderRequest.setAttribute("destinazioniUso", lstDestinazioniUso);

		return PresentatoreFormsPortletKeys.JSP_SCEGLI_DESTINAZIONE_USO;
	}
	
	private AlpacaJsonStructure getAlpacaJsonStructure(long idRichiesta, Procedura procedura, Boolean caricaBozza) {
		Gson gson = new Gson();
		String jsonDataBozza = null;
		IstanzaForm istanzaForm = null;
		Form form = null;
		
		if(Validator.isNotNull(procedura)) {
			form = getFormPrincipale(procedura.getProceduraId());
		}
		
		if(Validator.isNotNull(caricaBozza) && caricaBozza && idRichiesta>0) {
			
			try {
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
		
		FormData formData = AlpacaUtil.loadFormData(form, jsonDataBozza, caricaBozza);
		AlpacaJsonStructure alpacaStructure = formData.getAlpaca();
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
	
	private Form getFormPrincipale(long idProcedura) {
		Form form = null;
		if(idProcedura>0) {
			/*
			 * TODO: Una volta fatto il merge con il branch di gestione
			 * procedure, utilizzare proceduraFormLocalService per ottenere l'id
			 * del form principale attraverso la procedura e recuperarne l'oggetto
			 */
		}
		
		return form;
	}
	
	private List<String> getListaDestinazioniUso(){
		List<String> lstDestinazioniUso = new ArrayList<String>();
		lstDestinazioniUso.add("Bollo");
		lstDestinazioniUso.add("Esenzione");
		
		return lstDestinazioniUso;
	}

}
