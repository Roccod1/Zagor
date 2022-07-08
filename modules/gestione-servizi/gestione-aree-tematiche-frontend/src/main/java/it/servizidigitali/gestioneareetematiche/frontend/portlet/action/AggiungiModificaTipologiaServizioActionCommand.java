package it.servizidigitali.gestioneareetematiche.frontend.portlet.action;

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

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneareetematiche.frontend.constants.GestioneAreeTematichePortletKeys;
import it.servizidigitali.gestioneservizi.model.AreaTematica;
import it.servizidigitali.gestioneservizi.service.AreaTematicaLocalService;

/**
 * @author filierim
 * */

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GestioneAreeTematichePortletKeys.GESTIONEAREETEMATICHE,
		"mvc.command.name=/salva"
	},
	service = MVCActionCommand.class
)
public class AggiungiModificaTipologiaServizioActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaTipologiaServizioActionCommand.class);
	
	@Reference
	private AreaTematicaLocalService areaTematicaLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		List<String> listaErrori = new ArrayList<String>();
		Long areaTematicaId = ParamUtil.getLong(actionRequest, GestioneAreeTematichePortletKeys.AREA_TEMATICA_ID);
		String nome = ParamUtil.getString(actionRequest, GestioneAreeTematichePortletKeys.NOME);
		String descrizione = ParamUtil.getString(actionRequest, GestioneAreeTematichePortletKeys.DESCRIZIONE);
		Boolean visibile = ParamUtil.getBoolean(actionRequest, GestioneAreeTematichePortletKeys.VISIBILE);
		String indirizzoPrecedente = ParamUtil.getString(actionRequest, GestioneAreeTematichePortletKeys.INDIRIZZO_PRECEDENTE);
		Integer ordine = ParamUtil.getInteger(actionRequest, GestioneAreeTematichePortletKeys.ORDINE);
		
		if(Validator.isNull(nome)) {
			SessionErrors.add(actionRequest, GestioneAreeTematichePortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			listaErrori.add("nome e' obbligatorio");
		}
		
		if(Validator.isNull(ordine) || ordine == 0) {
			SessionErrors.add(actionRequest, GestioneAreeTematichePortletKeys.ERRORE_CAMPI_OBBLIGATORI);
			listaErrori.add("ordine e' obbligatorio");
		}
		
			
		AreaTematica areaTematica = areaTematicaLocalService.createAreaTematica(0L);
		
		if(Validator.isNotNull(areaTematicaId)) {
			try {
				areaTematica = areaTematicaLocalService.getAreaTematica(areaTematicaId);				
			}catch(Exception e) {
				_log.error("Impossibile ottenere tipologia con ID: " + areaTematicaId);
				SessionErrors.add(actionRequest, GestioneAreeTematichePortletKeys.ERRORE_IMPOSSIBILE_OTTENERE_AREA_TEMATICA);
				SessionErrors.add(actionRequest, GestioneAreeTematichePortletKeys.ERRORE_SALVATAGGIO);
			}
		}
		
		if(!listaErrori.isEmpty()) {
			for(String errore : listaErrori) {
				_log.error(errore);
			}
			actionResponse.sendRedirect(indirizzoPrecedente);
		}
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		ThemeDisplay tema = serviceContext.getThemeDisplay();
		areaTematica.setGroupId(tema.getCompanyGroupId());
		areaTematica.setUserId(tema.getUserId());
		
		areaTematica.setNome(nome);		
		areaTematica.setDescrizione(descrizione);						
		areaTematica.setVisibile(visibile);
		areaTematica.setOrdine(ordine);
		
		try {
			areaTematicaLocalService.salvaAreaTematica(areaTematica);
			SessionMessages.add(actionRequest, GestioneAreeTematichePortletKeys.SALVATAGGIO_SUCCESSO);			
		}catch(Exception e) {
			_log.error("Impossibile salvare/aggiornare la tipologia con ID: " + areaTematicaId, e);
			SessionErrors.add(actionRequest, GestioneAreeTematichePortletKeys.ERRORE_SALVATAGGIO);			
		}
		actionResponse.sendRedirect(indirizzoPrecedente);
	}
}