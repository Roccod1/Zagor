package it.servizidigitali.profiloutente.mieidati.frontend.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationFactoryService;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationService;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.profiloutente.mieidati.frontend.constants.ProfiloUtenteMieiDatiPortletKeys;

/**
 * @author filierim
 */

@Component(immediate = true, 
	property = { 
		"javax.portlet.name=" + ProfiloUtenteMieiDatiPortletKeys.PROFILOUTENTEMIEIDATI, 
		"mvc.command.name=" + ProfiloUtenteMieiDatiPortletKeys.DETTAGLIO_COMPONENTE_NUCLEO_FAMILIARE_RENDER_COMMAND_NAME 
	}, 
	service = MVCRenderCommand.class
) 
public class DettaglioComponenteNucleoFamiliare implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(DettaglioComponenteNucleoFamiliare.class);

	@Reference
	private AnagrafeIntegrationFactoryService anagrafeIntegrationFactoryService;
	
	@Reference
	private ComuneLocalService comuneLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

	
		String codiceFiscaleComponenteFamiliare = ParamUtil.getString(renderRequest, ProfiloUtenteMieiDatiPortletKeys.CODICE_FISCALE);
		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;		
		DatiAnagrafici datiAnagrafici = null;
		Comune comuneNascita = null;
		Comune comuneResidenza = null;
		DatiAnagrafici.ComponenteNucleoFamiliare componenteNucleoFamiliare = null;
		try {
			
			if(Validator.isBlank(codiceFiscaleComponenteFamiliare)) {
				throw new Exception("CodiceFicale e' null");
			}
			
			serviceContext = ServiceContextFactory.getInstance(renderRequest);
			themeDisplay = serviceContext.getThemeDisplay();

            User user = themeDisplay.getUser();
            // recupero il siteGroupOrganizationId dal siteGroup
            Long siteGroupOrganizationId = themeDisplay.getSiteGroup().getOrganizationId();
            AnagrafeIntegrationService anagrafeIntegrationService = anagrafeIntegrationFactoryService.getAnagrafeIntegrationService(siteGroupOrganizationId);
            
            datiAnagrafici = anagrafeIntegrationService.getDatiAnagrafici(user.getScreenName(), siteGroupOrganizationId, null);
            
            
            for(DatiAnagrafici.ComponenteNucleoFamiliare componente : datiAnagrafici.getComponentiNucleoFamiliare()) {
            	if(componente.getCodiceFiscale().equalsIgnoreCase(codiceFiscaleComponenteFamiliare)) {
            		componenteNucleoFamiliare = componente;
            	}
            }
            
            if(Validator.isNotNull(componenteNucleoFamiliare)) {
            	if(!Validator.isBlank( componenteNucleoFamiliare.getCodiceIstatComuneNascita())) {
            		comuneNascita = comuneLocalService.getComuneByCodiceISTAT(componenteNucleoFamiliare.getCodiceIstatComuneNascita()); 
            	}else {
            		_log.warn("Impossibile ottenere comune di nascita con codiceIstat :"+componenteNucleoFamiliare.getCodiceIstatComuneNascita());
            	}
            		
            	if(!Validator.isBlank( componenteNucleoFamiliare.getCodiceIstatComuneResidenza())) {
            		comuneResidenza = comuneLocalService.getComuneByCodiceISTAT(componenteNucleoFamiliare.getCodiceIstatComuneResidenza());            		
            	}else {
            		_log.warn("Impossibile ottenere comune di residenza con codiceIstat :"+componenteNucleoFamiliare.getCodiceIstatComuneResidenza());
            	}
            }else {
            	_log.warn("Impossibile ottenere comune/proviuncia di nascita/residenza ::> componenteNucleoFamiliare e' null");
            }
            
            renderRequest.setAttribute(ProfiloUtenteMieiDatiPortletKeys.DETTAGLIO_COMPONENTE_NUCLEO_FAMILIARE_COMUNE_NASCITA, comuneNascita);
            renderRequest.setAttribute(ProfiloUtenteMieiDatiPortletKeys.DETTAGLIO_COMPONENTE_NUCLEO_FAMILIARE_COMUNE_RESIDENZA, comuneResidenza);
        	renderRequest.setAttribute(ProfiloUtenteMieiDatiPortletKeys.COMPONENTE_NUCLEO_FAMILIARE, componenteNucleoFamiliare);
            return ProfiloUtenteMieiDatiPortletKeys.JSP_DATI_ANAGRAFICI_COMPONENTE_NUCLEO_FAMILIARE;
		}catch(Exception e) {
			_log.error("Errore durante il caricamento del dettaglio componente familiare CF > " + codiceFiscaleComponenteFamiliare + " :: " + e.getMessage(), e);
			renderRequest.setAttribute(ProfiloUtenteMieiDatiPortletKeys.TAB_ATTIVA, ProfiloUtenteMieiDatiPortletKeys.SEZIONE_NUCLEO_FAMILIARE);
			SessionErrors.add(renderRequest, ProfiloUtenteMieiDatiPortletKeys.ERRORE_GENERICO, e );
		}
		return ProfiloUtenteMieiDatiPortletKeys.JSP_HOME;
	}
}