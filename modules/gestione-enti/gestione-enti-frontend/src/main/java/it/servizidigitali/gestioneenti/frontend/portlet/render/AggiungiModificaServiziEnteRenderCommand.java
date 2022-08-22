package it.servizidigitali.gestioneenti.frontend.portlet.render;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
 * @author pindi
 */

@Component(immediate = true, 
	property = { 
		"javax.portlet.name=" + GestioneEntiPortletKeys.GESTIONEENTI, 
		"mvc.command.name=" + GestioneEntiPortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME 
	}, 
	service = MVCRenderCommand.class
) 
public class AggiungiModificaServiziEnteRenderCommand implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaServiziEnteRenderCommand.class);

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;
	
	@Reference
	private ServizioLocalService servizioLocalService;
	
	@Reference
	private JournalArticleLocalService journalArticleLocalService;
	
	@Reference
	private DDMStructureLocalService dDMStructureLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		Long organizationId = ParamUtil.getLong(renderRequest, GestioneEntiPortletKeys.ORGANIZZAZIONE_ID);
		Long servizioId = ParamUtil.getLong(renderRequest, GestioneEntiPortletKeys.SERVIZIO_ID);
		List<Servizio> listaServizi = new ArrayList<Servizio>();

		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		List<JournalArticle> listaArticoliCatalogoServizi = new ArrayList<JournalArticle>();
		long groupId = 0;
		try {
			serviceContext = ServiceContextFactory.getInstance(renderRequest);
			themeDisplay = serviceContext.getThemeDisplay();
			groupId = themeDisplay.getSiteGroupId();
			String structureKey = "";
			if(groupId > 0) {
				
				List<DDMStructure> structures = DDMStructureLocalServiceUtil.getStructures(groupId);
				for (DDMStructure structure : structures) {
					if (GestioneEntiPortletKeys.STRUCTURE_NAME_CATALOGO_SERVIZI.equalsIgnoreCase(structure.getName(Locale.ROOT))) {
						structureKey = structure.getStructureKey();
					}
				}				
				
//				long classNameId = ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class);
//				long idStruttura = dDMStructureLocalService.getStructure(groupId, classNameId, GestioneEntiPortletKeys.STRUCTURE_NAME_CATALOGO_SERVIZI).getStructureId();
				
				if(!Validator.isNull(structureKey)) {
					listaArticoliCatalogoServizi = journalArticleLocalService.getArticlesByStructureId(groupId, structureKey , QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);					
				}
			}
		}catch(Exception e) {
			_log.error("Impossibile recuperare lista Articles ::> " + e.getMessage(), e);
		}
		
		try {
			listaServizi = servizioLocalService.listaServiziAttivi(true, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e1) {
			_log.error("Impossibile recuperare la lista dei servizi attivi");
		}
		
		
		
		try {
			if (Validator.isNotNull(organizationId)) {
				Organization organization = organizationLocalService.getOrganization(organizationId);
				renderRequest.setAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONE, organization);

				/*
				 * se servizioId non e' null si tratta di modifica servizio esistente quindi imposto la lista
				 * completa per poter visualizzare il nome del servizio associato a servizioEnte
				 * altrimenti filtro la lista rimuovendo i servizi gia' attivi per l'ente
				 * */
				if(Validator.isNotNull(servizioId)) {
					ServizioEntePK servizioEntePK = new ServizioEntePK(servizioId, organizationId);
					ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnte(servizioEntePK);
					renderRequest.setAttribute(GestioneEntiPortletKeys.SERVIZIO_ENTE, servizioEnte);
				}else {						
					listaServizi = listaServiziAttivabili(listaServizi, organizationId);
				}
			
				renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_SERVIZI, listaServizi);
			}
	
		}
		catch (Exception e) {
			_log.error("Errore durante il caricamento dell'ente_servizio : ", e);
			SessionErrors.add(renderRequest, GestioneEntiPortletKeys.ERRORE_IMPOSSIBILE_CARICARE_I_DATI);
			return GestioneEntiPortletKeys.JSP_LISTA_SERVIZI_ENTE;
		}

		
		renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_ARTICLE_CATALOGO_SERVIZI, listaArticoliCatalogoServizi);
		return GestioneEntiPortletKeys.JSP_INSERIMENTO_MODIFICA;
	}
	
	private List<Servizio> listaServiziAttivabili(List<Servizio> listaTuttiServizi, Long organizationId){
		if(listaTuttiServizi.isEmpty()) {
			return listaTuttiServizi;
		}
		
		List<Servizio> listaFinita = new ArrayList<Servizio>(listaTuttiServizi);
		List<ServizioEnte> listaServiziAttivi = servizioEnteLocalService.getServiziEnte(organizationId);
		
		//rimuovo dalla lista servizi quelli gia' attivi per lo specifico ente
		for(Servizio servizio : listaTuttiServizi) {
			for(ServizioEnte servizioAttivo : listaServiziAttivi) {
				if(servizioAttivo.getServizioId() == servizio.getServizioId()) {
					listaFinita.remove(servizio);
				}
			}
		}
		return listaFinita;
	}
}