package it.servizidigitali.gestioneprocedure.frontend.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
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
import it.servizidigitali.gestioneprocedure.frontend.constants.GestioneProcedurePortletKeys;
import it.servizidigitali.gestioneprocedure.frontend.service.GestioneProcedureMiddlewareService;
import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.service.ProcessoLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + GestioneProcedurePortletKeys.GESTIONEPROCEDURE,
			"mvc.command.name=" + GestioneProcedurePortletKeys.DETTAGLIO_NUOVO_RENDER_COMMAND
		},
		service = MVCRenderCommand.class
	)
public class DettaglioNuovoRenderCommand implements MVCRenderCommand{
	
	private static final Log _log = LogFactoryUtil.getLog(DettaglioNuovoRenderCommand.class);

	
	@Reference
	private GestioneProcedureMiddlewareService gestioneProcedureMiddlewareService;
	
	@Reference
	private ProcessoLocalService processoLocalService;
	
	@Reference
	private FormLocalService formLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Servizio> listaServizi = new ArrayList<Servizio>();
		List<Processo> listaProcessi = new ArrayList<Processo>();
		List<Form> listaFormPrincipali = new ArrayList<Form>();
		List<Form> listaFormIntegrativi = new ArrayList<Form>();
		
		try {
			listaServizi = gestioneProcedureMiddlewareService.getServiziByOrganizationAttivo(themeDisplay.getSiteGroup().getOrganizationId());
			listaProcessi = processoLocalService.getListaProcessiByOrganizationAttivo(themeDisplay.getSiteGroupId(), true);
			listaFormPrincipali = formLocalService.getListaFormByOrganizationPrincipale(themeDisplay.getSiteGroupId(), true);
			listaFormIntegrativi = formLocalService.getListaFormByOrganizationPrincipale(themeDisplay.getSiteGroupId(), false);
		} catch (Exception e) {
			_log.error("Impossibile recuperare la lista dei servizi!" + e.getMessage());
		}
		
		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_SERVIZI,listaServizi);
		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_PROCESSI,listaProcessi);
		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_FORM_PRINCIPALI, listaFormPrincipali);
		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_FORM_INTEGRATIVI, listaFormIntegrativi);
		
		return GestioneProcedurePortletKeys.JSP_AGGIUNGI_MODIFICA_PROCEDURA;
	}

}
