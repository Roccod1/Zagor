package it.servizidigitali.gestioneprocessi.frontend.portlet.render;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.gestioneprocessi.frontend.constants.GestioneProcessiPortletKeys;
import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.service.ProcessoLocalService;

/**
 * @author COSTABILEE
 *
 */

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + GestioneProcessiPortletKeys.GESTIONEPROCESSI,
			"mvc.command.name=" + GestioneProcessiPortletKeys.DETTAGLIO_NUOVO_RENDER_COMMAND
		},
		service = MVCRenderCommand.class
	)
public class DettaglioNuovoRenderCommand implements MVCRenderCommand{
	
	public static final Log _log = LogFactoryUtil.getLog(DettaglioNuovoRenderCommand.class);
	
	@Reference
	private ProcessoLocalService processoLocalService;
	
	@Reference
	private CamundaClient camundaClient;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long organizationIdSitePrincipale = themeDisplay.getSiteGroup().getOrganizationId();

		long idProcesso = ParamUtil.getLong(renderRequest, GestioneProcessiPortletKeys.ID_PROCESSO);
		Processo processo = null;
		String modelloXml = "";
		
		if(idProcesso>0) {
			try {
				processo = processoLocalService.getProcesso(idProcesso);
				
				if(processo.getGroupId() != themeDisplay.getSiteGroupId() && organizationIdSitePrincipale!=0) {
					SessionErrors.add(renderRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_NON_AUTORIZZATO);
					return GestioneProcessiPortletKeys.JSP_HOME;
				}
				
				File deployment = camundaClient.getDeploymentFile(processo.getDeploymentId());

				try {
					modelloXml = FileUtil.read(deployment);
				} catch (IOException e) {
					_log.error("Errore durante il recupero del file del deployment" + e.getMessage());
				}
				
			} catch (PortalException e) {
				_log.error("Impossibile recuperare il processo!" + e.getMessage());
			}
			
			renderRequest.setAttribute(GestioneProcessiPortletKeys.ATTRIBUTO_PROCESSO, processo);
			
			if(Validator.isNotNull(modelloXml)) {
				renderRequest.setAttribute(GestioneProcessiPortletKeys.MODELLOXML, modelloXml);
			}
			
		}
		
		renderRequest.setAttribute(GestioneProcessiPortletKeys.ORGANIZATION_ID, themeDisplay.getScopeGroup().getOrganizationId());

		
		return GestioneProcessiPortletKeys.JSP_AGGIUNGI_MODIFICA_PROCESSO;
	}
	
}
