package it.servizidigitali.presentatoreforms.frontend.portlet.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.presentatoreforms.common.model.DatiFileAllegato;
import it.servizidigitali.presentatoreforms.common.service.AllegatoRichiestaService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;

@Component(immediate = true, property = { //
		"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
		"mvc.command.name=" + PresentatoreFormsPortletKeys.DOWNLOAD_MODELLO_RESOURCE_COMMAND //
}, service = { MVCResourceCommand.class })

public class DownloadModelloResourceCommand extends BaseMVCResourceCommand{
	
	@Reference
	private AllegatoRichiestaService allegatoRichiestaService;
	
	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;
	
	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;

	private static final Log log = LogFactoryUtil.getLog(DownloadModelloResourceCommand.class.getName());
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		long definizioneAllegatoId = ParamUtil.getLong(resourceRequest, "id");
		DatiFileAllegato modelloAllegato = null;
		
		try {

			if(definizioneAllegatoId>0) {
				modelloAllegato = allegatoRichiestaService.getModelloAllegato(definizioneAllegatoId);
				
				if(Validator.isNotNull(modelloAllegato)) {
					PortletResponseUtil.sendFile(resourceRequest, resourceResponse, modelloAllegato.getFileName(), modelloAllegato.getContenuto(), ContentTypes.APPLICATION_PDF);
				}else {
					log.error("Impossibile effettuare il sendFile del modelloAllegato!");
				}
			}else {
				log.error("ID Allegato 0 o NULL");
			}
			
			
		}catch(Exception e) {
			log.error("Errore durante il download del modello dell'allegato con id : " + definizioneAllegatoId);
		}
		
	}

}
