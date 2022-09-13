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
import com.liferay.portal.kernel.util.PortalUtil;
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
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
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
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;
	
	@Reference
	private AlpacaService alpacaService;
	

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long richiestaId = 0;
		long proceduraId = 0;
		
		Richiesta richiesta = null;
		Procedura procedura = null;
		Servizio servizio = null;
		AlpacaJsonStructure alpacaStructure = null;
		
		List<String> lstDestinazioniUso = getListaDestinazioniUso();
		
//		se tipologia servizio = certificato -> step2 altrimenti compila form
		
		String tipologiaServizio = "DEMO";
		UserPreferences userPreferences = new UserPreferences();
		
		try {
			alpacaStructure = getAlpacaJsonStructure(0,procedura,false);
			
			if(Validator.isNotNull(alpacaStructure)) {
				renderRequest.setAttribute("alpacaStructure", alpacaStructure);
			}

			if(tipologiaServizio.equalsIgnoreCase("CERTIFICATO")) {
				return PresentatoreFormsPortletKeys.JSP_SCEGLI_DESTINAZIONE_USO;
			}else {
				return PresentatoreFormsPortletKeys.JSP_COMPILA_FORM;
			}
			
//			procedura = proceduraLocalService.getProcedura(proceduraId);
//			servizio = servizioLocalService.getServizioById(procedura.getServizioId());

		}catch(Exception e) {
			_log.error("");
		}
		
		
		
		renderRequest.setAttribute("statoRichiesta", richiesta.getStato());
		renderRequest.setAttribute("configurazioneTipoServizioStep2", "DEMO");
		renderRequest.setAttribute("destinazioniUso", lstDestinazioniUso);
		
		return PresentatoreFormsPortletKeys.JSP_HOME;

	}
	
	private AlpacaJsonStructure getAlpacaJsonStructure(long idRichiesta, Procedura procedura, Boolean caricaBozza) {
		Gson gson = new Gson();
		String jsonDataBozza = null;
		IstanzaForm istanzaForm = null;
		Form form = null;
		
		try {
			form = formLocalService.getForm(52402);
			form.setListaDefinizioneAllegato(definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(52402));
		} catch (PortalException e) {
			_log.error("Errore durante il recupero del form con id 85607" + e.getMessage());
		}
		
//		if(Validator.isNotNull(procedura)) {
//			form = gestioneProcedureMiddlewareService.getFormPrincipaleProcedura(procedura.getProceduraId());
//			
//		}
		
		FormData formData = AlpacaUtil.loadFormData(form, null, true);
		AlpacaJsonStructure alpacaStructure = formData.getAlpaca();
		

		JsonObject data = gson.fromJson(gson.toJson(alpacaStructure.getData()), JsonObject.class);
		
		return alpacaStructure;

	}
	
	private List<String> getListaDestinazioniUso(){
		List<String> lstDestinazioniUso = new ArrayList<String>();
		lstDestinazioniUso.add("Bollo");
		lstDestinazioniUso.add("Esenzione");
		
		return lstDestinazioniUso;
	}

}