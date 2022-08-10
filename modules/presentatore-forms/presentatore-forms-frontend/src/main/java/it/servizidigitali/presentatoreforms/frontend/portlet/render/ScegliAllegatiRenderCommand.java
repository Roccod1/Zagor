package it.servizidigitali.presentatoreforms.frontend.portlet.render;

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

import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneforms.service.TipoDocumentoLocalService;


/**
 * @author COSTABILEE
 *
 */
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=" + PresentatoreFormsPortletKeys.SCEGLI_ALLEGATI_RENDER_COMMAND
		},
		service = MVCRenderCommand.class
	)
public class ScegliAllegatiRenderCommand implements MVCRenderCommand{
	
	public static final Log _log = LogFactoryUtil.getLog(ScegliAllegatiRenderCommand.class);
	
	@Reference
	private FormLocalService formLocalService;
	
	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;
	
	@Reference
	private TipoDocumentoLocalService tipoDocumentoLocalService;
	
	private Map<String, String> attachmentFileTypesMap;
	private String attachmentFileTypes = "PDF,P7M,JPG,PNG,DOC,DOCX,XLS,ZIP";

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		_log.info("render scegliAllegati");
		/* Inizializzazione valori dei formati accettati per gli allegati
		
		attachmentFileTypesMap = new HashMap<>();
		if (attachmentFileTypes != null) {
			String[] attachmentFileTypesSplit = attachmentFileTypes.split(",");
			if (attachmentFileTypesSplit != null) {
				for (String string : attachmentFileTypesSplit) {
					attachmentFileTypesMap.put(string.toLowerCase(), string.toUpperCase());
				}
			}
		}			
		
		Long idForm = ParamUtil.getLong(renderRequest, "idFormMock");
		Form form = null;
		
		if(idForm>0) {
			try {
				form = formLocalService.getForm(idForm);
				form.setListaDefinizioneAllegato(definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(idForm));
			} catch (PortalException e) {
				_log.error("Impossibile recuperare il form!" + e.getMessage());
			}
			
			// renderRequest.setAttribute(PresentatoreFormsPortletKeys.FORM, form);
		}
		
		//renderRequest.setAttribute(PresentatoreFormsPortletKeys.FORMATI_ALLEGATI, attachmentFileTypesMap);
		//renderRequest.setAttribute(PresentatoreFormsPortletKeys.LISTA_TIPO_DOCUMENTO, tipoDocumentoLocalService.getListaTipoDocumentiByStato(PresentatoreFormsPortletKeys.STATO_ATTIVO));
		*/
		return PresentatoreFormsPortletKeys.JSP_SCEGLI_ALLEGATI;
	}

}
