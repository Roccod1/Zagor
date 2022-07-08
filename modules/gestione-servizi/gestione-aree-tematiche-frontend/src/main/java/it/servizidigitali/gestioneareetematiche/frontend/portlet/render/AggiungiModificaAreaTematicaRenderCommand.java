package it.servizidigitali.gestioneareetematiche.frontend.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
		"mvc.command.name=" + GestioneAreeTematichePortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME
	},
	service = MVCRenderCommand.class
)
public class AggiungiModificaAreaTematicaRenderCommand implements MVCRenderCommand{
	
	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaAreaTematicaRenderCommand.class);
	
	@Reference
	private AreaTematicaLocalService areaTematicaLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		Long areaTematicaId = ParamUtil.getLong(renderRequest, GestioneAreeTematichePortletKeys.AREA_TEMATICA_ID);
		String indirizzoPrecedente = ParamUtil.getString(renderRequest, GestioneAreeTematichePortletKeys.INDIRIZZO_PRECEDENTE);
		
		AreaTematica areaTematica = null;
		
		if(Validator.isNotNull(areaTematicaId)) {
			try {
				areaTematica = areaTematicaLocalService.getAreaTematica(areaTematicaId);
			}catch(Exception e) {
				_log.error("Impossibile ottenere la areaTematica con ID: " + areaTematicaId);
				SessionErrors.add(renderRequest, GestioneAreeTematichePortletKeys.ERRORE_IMPOSSIBILE_OTTENERE_AREA_TEMATICA);
				return GestioneAreeTematichePortletKeys.JSP_HOME;
			}
		}
		
		renderRequest.setAttribute(GestioneAreeTematichePortletKeys.AREA_TEMATICA, areaTematica);
		renderRequest.setAttribute(GestioneAreeTematichePortletKeys.INDIRIZZO_PRECEDENTE, indirizzoPrecedente);
		
		return GestioneAreeTematichePortletKeys.JSP_INSERIMENTO_MODIFICA_AREA_TEMATICA;
	}

}
