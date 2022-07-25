package it.servizidigitali.gestioneenti.frontend.portlet.render;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.frontend.constants.GestioneEntiPortletKeys;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;

/**
 * @author filierim
 */

@Component(immediate = true, 
	property = { 
		"javax.portlet.name=" + GestioneEntiPortletKeys.GESTIONEENTI, 
		"mvc.command.name=" + GestioneEntiPortletKeys.LISTA_SERVIZI_ENTE_RENDER_COMMAND 
	}, 
	service = MVCRenderCommand.class
) 
public class ListaServiziEnteRenderCommand implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(ListaServiziEnteRenderCommand.class);

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;
	
	@Reference
	private ServizioLocalService servizioLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		Long organizationId = ParamUtil.getLong(renderRequest, GestioneEntiPortletKeys.ORGANIZZAZIONE_ID);
		Long servizioId = ParamUtil.getLong(renderRequest, GestioneEntiPortletKeys.SERVIZIO_ID);
		Boolean deleteToggle = ParamUtil.getBoolean(renderRequest, GestioneEntiPortletKeys.DELETE_TOGGLE, false);
		SessionErrors.clear(renderRequest);
		
		/*
		 * gestisco l'eliminazione di un servizio dallo specifico ente
		 * */
		if(deleteToggle) {
			try {
				eliminaServizioEnte(organizationId, servizioId, renderRequest);
				SessionMessages.add(renderRequest, GestioneEntiPortletKeys.ELIMINAZIONE_SUCCESSO);
			}catch(Exception e) {
				_log.error("impossibile eliminare il servizio associato all'organizzazione");
				SessionErrors.add(renderRequest, GestioneEntiPortletKeys.ERRORE_ELIMINAZIONE_SERVIZIO);
			}
		}
		
		if(Validator.isNotNull(organizationId)) {
			try {
				List<ServizioEnte> serviziEnte = servizioEnteLocalService.getServiziEnte(organizationId);
				renderRequest.setAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONE_SERVIZI, serviziEnte);
				
				List<Servizio> listaServizi = servizioLocalService.getServizios(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_SERVIZI, listaServizi);							

				Organization organization = organizationLocalService.getOrganization(organizationId);
				renderRequest.setAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONE, organization);
				
				return GestioneEntiPortletKeys.JSP_LISTA_SERVIZI_ENTE;
			}catch(Exception e) {
				_log.error("Impossibile recuperare lista servizi e/o organizzazioni", e);
			}			
		}else {
			_log.error("organizationId e' null");
		}
		SessionErrors.add(renderRequest, GestioneEntiPortletKeys.ERRORE_IMPOSSIBILE_CARICARE_I_DATI);
		return GestioneEntiPortletKeys.JSP_HOME;
	}

	
	private void eliminaServizioEnte(Long organizationId, Long servizioId, RenderRequest renderRequest) throws Exception{
		boolean ok = true;
		
		/*
		 * verifico ci siano organizationId e servizioId per costruire la pk
		 * */
		
		if(Validator.isNull(organizationId)) {
			_log.error("eliminaServizio ::> organizationId e' null");
			ok = false;
		}
	
		if(Validator.isNull(servizioId)) {
			_log.error("eliminaServizio ::> servizioId e' null");
			ok = false;
		}
		
		/*
		 * in assenza di errori procedo a creare la pk e ad eliminare il servizio
		 * */
		if(ok) {
			ServizioEntePK servizioEntePK = new ServizioEntePK(servizioId, organizationId);
			servizioEnteLocalService.deleteServizioEnte(servizioEntePK);
		}
	}
}