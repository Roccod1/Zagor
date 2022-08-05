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
import com.liferay.portal.kernel.util.ParamUtil;

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

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long idProcesso = ParamUtil.getLong(renderRequest, GestioneProcessiPortletKeys.ID_PROCESSO);
		Processo processo = null;
		String modelloXml = "";
		if(idProcesso>0) {
			try {
				processo = processoLocalService.getProcesso(idProcesso);
				
				try {
					modelloXml = processoLocalService.recuperaProcessoXml(processo.getFileEntryId());
				} catch (Exception e) {
					_log.error("Errore durante il recupero dell'xml dal sistema!");
					SessionErrors.add(renderRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_RECUPERO_PROCESSO_REPOSITORY);
				}
				
			} catch (PortalException e) {
				_log.error("Impossibile recuperare il processo!" + e.getMessage());
			}
			
			renderRequest.setAttribute(GestioneProcessiPortletKeys.ATTRIBUTO_PROCESSO, processo);
			renderRequest.setAttribute(GestioneProcessiPortletKeys.MODELLOXML, modelloXml);
		}
		
		return GestioneProcessiPortletKeys.JSP_AGGIUNGI_MODIFICA_PROCESSO;
	}
	
}
