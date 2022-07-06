package it.servizidigitali.gestioneservizi.frontend.portlet.render;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneservizi.frontend.constants.GestioneServiziPortletKeys;
import it.servizidigitali.gestioneservizi.model.AreaTematica;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.AreaTematicaLocalService;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;

/**
 * @author filierim
 * */

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GestioneServiziPortletKeys.GESTIONESERVIZI,
		"mvc.command.name=/aggiungiModifica"
	},
	service = MVCRenderCommand.class
)
public class AggiungiModificaServizioRenderCommand implements MVCRenderCommand{

	@Reference
	private ServizioLocalService servizioLocalService;
	
	@Reference
	private TipologiaLocalService tipologiaLocalService;
	
	@Reference
	private AreaTematicaLocalService areaTematicaLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		Long servizioId = ParamUtil.getLong(renderRequest, "servizioId", 0L);
		String indirizzoPrecedente = ParamUtil.getString(renderRequest, GestioneServiziPortletKeys.INDIRIZZO_PRECEDENTE);
		
		Servizio servizio = null;
		List<Tipologia> listaTipologie = null;
		if(servizioId > 0) {
			try {
				servizio = servizioLocalService.getServizioById(servizioId);		
				listaTipologie = servizio.getListaTipologie();
			}catch(Exception e) {
				
			}
		}
		
		List<AreaTematica> listaAreaTematica = areaTematicaLocalService.getAreaTematicas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		listaTipologie = tipologiaLocalService.getTipologias(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		renderRequest.setAttribute(GestioneServiziPortletKeys.LISTA_AREA_TEMATICA, listaAreaTematica);
		renderRequest.setAttribute(GestioneServiziPortletKeys.SERVIZIO, servizio);
		renderRequest.setAttribute(GestioneServiziPortletKeys.LISTA_TIPOLOGIE_SELEZIONATE, Validator.isNotNull(servizio) ? servizio.getListaTipologie() : new ArrayList<Tipologia>());
		renderRequest.setAttribute(GestioneServiziPortletKeys.LISTA_TIPOLOGIE, listaTipologie);
		renderRequest.setAttribute(GestioneServiziPortletKeys.INDIRIZZO_PRECEDENTE, indirizzoPrecedente);
		
		return GestioneServiziPortletKeys.JSP_INSERIMENTO_MODIFICA_SERVIZIO;
	}

}
