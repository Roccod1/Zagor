package it.servizidigitali.profiloutente.preferenze.frontend.portlet.render;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.profiloutente.model.CanaleComunicazione;
import it.servizidigitali.profiloutente.model.UtenteOrganizzazione;
import it.servizidigitali.profiloutente.model.UtenteOrganizzazioneCanaleComunicazione;
import it.servizidigitali.profiloutente.preferenze.frontend.constants.ProfiloUtentePreferenzePortletKeys;
import it.servizidigitali.profiloutente.service.CanaleComunicazioneLocalService;
import it.servizidigitali.profiloutente.service.UtenteOrganizzazioneCanaleComunicazioneLocalService;
import it.servizidigitali.profiloutente.service.UtenteOrganizzazioneLocalService;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazionePK;

/**
 * @author filierim
 */

@Component(
	immediate = true,
	property = { 
		"javax.portlet.name=" + ProfiloUtentePreferenzePortletKeys.PROFILOUTENTEPREFERENZE, 
		"mvc.command.name=" + ProfiloUtentePreferenzePortletKeys.RENDER_INSERISCI_MODIFICA
	},
	service = MVCRenderCommand.class
) 
public class AggiungiModificaServiziEnteRenderCommand implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaServiziEnteRenderCommand.class);

	@Reference
	private CanaleComunicazioneLocalService canaleComunicazioneLocalService;
	
	@Reference
	private OrganizationLocalService organizationLocalService;
	
	@Reference
	private UtenteOrganizzazioneLocalService utenteOrganizzazioneLocalService;
	
	@Reference
	private UtenteOrganizzazioneCanaleComunicazioneLocalService utenteOrganizzazioneCanaleComunicazioneLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		
		List<CanaleComunicazione> listaCanaliComunicazione = null;
		List<Organization> listaOrganizzazioni = null;
		List<UtenteOrganizzazioneCanaleComunicazione> listaUtenteOrganizzazioneCanaleComunicazione = null;
		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		Organization organization = null;
		UtenteOrganizzazione utenteOrganizzazione = null;
		
		long organizationId = ParamUtil.getLong(renderRequest, ProfiloUtentePreferenzePortletKeys.ORGANIZATION_ID);
		try {
			serviceContext = ServiceContextFactory.getInstance(renderRequest);
			themeDisplay = serviceContext.getThemeDisplay();
			
			User utenteCorrente = themeDisplay.getUser();
			
			listaCanaliComunicazione = canaleComunicazioneLocalService.getCanaleComunicazionesAttivi(true);
			listaUtenteOrganizzazioneCanaleComunicazione = utenteOrganizzazioneCanaleComunicazioneLocalService.getListaCanaleComunicazioneByUtenteOrganization(utenteCorrente.getUserId(), organizationId);
			
			listaOrganizzazioni = organizationLocalService.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			if(organizationId == 0) {
				listaOrganizzazioni = getListaOrganizzazioniFiltrata(listaOrganizzazioni, utenteCorrente.getUserId());				
			}
			organization = organizationLocalService.getOrganization(organizationId);
			
			UtenteOrganizzazionePK utenteOrganizzazionePK = new UtenteOrganizzazionePK(utenteCorrente.getUserId(), organizationId);
			utenteOrganizzazione = utenteOrganizzazioneLocalService.fetchUtenteOrganizzazione(utenteOrganizzazionePK);
		
			if(Validator.isNull(utenteOrganizzazione)) {
				_log.warn("Nessun UtenteOrganizzazione con PK {utenteId="+utenteCorrente.getUserId()+", organizationId="+organizationId+"}");
			}
		}catch(Exception e) {
			_log.error("Errore nel render della pagina :: " + e.getMessage(), e);
			SessionErrors.add(renderRequest, ProfiloUtentePreferenzePortletKeys.ERRORE_GET_DETTAGLIO);
			return ProfiloUtentePreferenzePortletKeys.JSP_HOME;
		}

		renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.UTENTE_ORGANIZZAZIONE, utenteOrganizzazione);
		renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.ORGANIZZAZIONE, organization);
		renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.LISTA_CANALI_COMUNICAZIONE, listaCanaliComunicazione);
		renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.LISTA_ORGANIZZAZIONI, listaOrganizzazioni);
		renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.LISTA_UTENTE_ORGANIZZAZIONE_CANALE_COMUNICAZIONE, listaUtenteOrganizzazioneCanaleComunicazione);
		return ProfiloUtentePreferenzePortletKeys.JSP_PREFERENZE_DETTAGLIO;
	}

	private List<Organization> getListaOrganizzazioniFiltrata(List<Organization> listaOrganizzazioniOrginale, Long utenteId) throws Exception{
		
		if(Validator.isNull(listaOrganizzazioniOrginale)) {
			return listaOrganizzazioniOrginale;
		}
		
		List<Organization> listaOrganizzazioniFiltrata = ListUtil.copy(listaOrganizzazioniOrginale);
		List<UtenteOrganizzazione> listaOrganizzazioniConfigurate = utenteOrganizzazioneLocalService.getOrganizzazioniUtenteConfigurate(utenteId);
		
		for(Organization daRimuovere : listaOrganizzazioniOrginale) {
			for(UtenteOrganizzazione orgConfigurata : listaOrganizzazioniConfigurate) {
				if(daRimuovere.getOrganizationId() == orgConfigurata.getOrganizationId()) {
					listaOrganizzazioniFiltrata.remove(daRimuovere);
				}
			}
		}
		
		return listaOrganizzazioniFiltrata;
	}
	
}