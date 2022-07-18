package it.servizidigitali.gestioneforms.frontend.portlet.render;

import com.liferay.portal.kernel.exception.PortalException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;


/**
 * @author COSTABILEE
 *
 */
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + GestioneFormsPortletKeys.GESTIONEFORMS,
			"mvc.command.name=" + GestioneFormsPortletKeys.DETTAGLIO_NUOVO_RENDER_COMMAND
		},
		service = MVCRenderCommand.class
	)
public class DettaglioNuovoRenderCommand implements MVCRenderCommand{
	
	public static final Log _log = LogFactoryUtil.getLog(DettaglioNuovoRenderCommand.class);
	
	@Reference
	private FormLocalService formLocalService;
	
	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;
	
	private Map<String, String> attachmentFileTypesMap;
	private String attachmentFileTypes = "PDF,P7M,JPG,PNG,DOC,DOCX,XLS,ZIP";

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		// Inizializzazione valori dei formati accettati per gli allegati
		
		attachmentFileTypesMap = new HashMap<>();
		if (attachmentFileTypes != null) {
			String[] attachmentFileTypesSplit = attachmentFileTypes.split(",");
			if (attachmentFileTypesSplit != null) {
				for (String string : attachmentFileTypesSplit) {
					attachmentFileTypesMap.put(string.toLowerCase(), string.toUpperCase());
				}
			}
		}			
		
		Long idForm = ParamUtil.getLong(renderRequest, GestioneFormsPortletKeys.ID_FORM);
		Form form = null;
		
		if(idForm>0) {
			try {
				form = formLocalService.getForm(idForm);
				form.setListaDefinizioneAllegato(definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(idForm));
			} catch (PortalException e) {
				_log.error("Impossibile recuperare il form!" + e.getMessage());
			}
			
			renderRequest.setAttribute(GestioneFormsPortletKeys.FORM, form);
		}
		
		renderRequest.setAttribute(GestioneFormsPortletKeys.FORMATI_ALLEGATI, attachmentFileTypesMap);
		return GestioneFormsPortletKeys.JSP_AGGIUNGI_MODIFICA_FORM;
	}

}
