package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
			"mvc.command.name=" + PresentatoreFormsPortletKeys.SCEGLI_MODALITA_PAGAMENTO_RENDER_COMMAND
		},
		service = MVCRenderCommand.class
	)
public class ModalitaPagamentoRenderCommand implements MVCRenderCommand{
	
	public static final Log _log = LogFactoryUtil.getLog(ModalitaPagamentoRenderCommand.class);
	
	@Reference
	private RichiestaLocalService richiestaLocalService;
	
	@Reference
	private ProceduraLocalService proceduraLocalService;
	
	@Reference
	private ServizioLocalService servizioLocalService;
	
	boolean certificatiPdfPreviewEnabled = true; // Valore viene preso da configurazione d'ambiente


	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long idRichiesta = ParamUtil.getLong(renderRequest, "idRichiesta");
		Richiesta richiesta = null;
		Procedura procedura = null;
		Servizio servizio = null;
		boolean daPagare = false;
		
		String tmpDir = System.getProperty("java.io.tmpdir");
		String percorsoFile = tmpDir + File.separator + "test.pdf";
		File file = new File(percorsoFile);
		byte[] fileArray = null;
		
		try {
			fileArray = FileUtil.getBytes(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String encoded = new String(Base64.getEncoder().encode(fileArray));
				
//		if(Validator.isNotNull(idRichiesta)) {
//			try {
//				richiesta = richiestaLocalService.getRichiesta(idRichiesta);
//			} catch (Exception e) {
//				_log.error("Impossibile recuperare la richiesta con ID: " + idRichiesta + "a causa di: " + e.getMessage());
//				// capire a quale jsp deve puntare in caso di errore
//				SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_RICHIESTA);
//			}
//			
//			try {
//				procedura = proceduraLocalService.getProcedura(richiesta.getProceduraId());
//			} catch (Exception e) {
//				_log.error("Impossibile recuperare la procedura con ID: " + idRichiesta + "a causa di: " + e.getMessage());
//				// capire a quale jsp deve puntare in caso di errore
//				SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_PROCEDURA);
//			}
//			
//			try {
//				servizio = servizioLocalService.getServizioById(procedura.getServizioId());
//			} catch (Exception e) {
//				_log.error("Impossibile recuperare il servizio con ID: " + idRichiesta + "a causa di: " + e.getMessage());
//				// capire a quale jsp deve puntare in caso di errore
//				SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_SERVIZIO);
//			}
//		}else {
//			_log.error("Non è stato possibile recuperare l'id della richiesta!");
//			SessionErrors.add(renderRequest, PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_RICHIESTA);
//			// capire a quale jsp deve puntare in caso di errore
//		}
		
		// TODO: Delega
		
		// TODO: Da Pagare
		
		
//		if(richiesta.getStato().equalsIgnoreCase(StatoRichiesta.BOZZA.name())) {
			
			// TODO: Controllare se firmaDocumentoAbilitata
			
			// TipoServizio tipoServizio = procedura.getTipoServizio();
			
//			if(Validator.isNotNull(tipoServizio)) {
//				renderRequest.setAttribute("configurazione_tipo_servizio_step2_2", tipoServizio);
				
				// TODO: Capire se utilizzare uno switch case per tutti i tipi di servizi o no 
				
				// CERTIFICATO
				
//				renderRequest.setAttribute(PresentatoreFormsPortletKeys.ANTEPRIMA_CERTIFICATI, certificatiPdfPreviewEnabled); 
				
//				if(certificatiPdfPreviewEnabled) {
					/*
					 * TODO: Realizzare un metodo in ProceduraLocalServiceImpl che dato l'idProcedura
					 * mi restituisca il json pulito del form principale
					 */
					
					/*
					 * TODO: Realizzare un metodo in IstanzaFormLocalSerivceImpl che dato l'idRichiesta
					 * mi restituisca il json del form con i dati (utilizzare il finder già definito)
					 */
//				}
//			}
//		}
		
//		renderRequest.setAttribute(PresentatoreFormsPortletKeys.TITOLO_PORTLET_SERVIZIO, servizio.getNome());
//		renderRequest.setAttribute(PresentatoreFormsPortletKeys.DA_PAGARE, daPagare);
//		renderRequest.setAttribute("downloadCertificato", true);
//		renderRequest.setAttribute(PresentatoreFormsPortletKeys.RICHIESTA_STATUS, richiesta.getStato());
//		renderRequest.setAttribute(PresentatoreFormsPortletKeys.BOZZA_STATUS, StatoRichiesta.BOZZA.name());
		
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.TITOLO_PORTLET_SERVIZIO, "Test Servizio");
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.DA_PAGARE, true);
		renderRequest.setAttribute("downloadCertificato", true);
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.RICHIESTA_STATUS, "bozza");
		renderRequest.setAttribute(PresentatoreFormsPortletKeys.BOZZA_STATUS, "bozza");
		renderRequest.setAttribute("certificatiPdfPreviewEnabled", certificatiPdfPreviewEnabled);
		renderRequest.setAttribute("base64PDFCertificato", encoded);
		return PresentatoreFormsPortletKeys.JSP_SCEGLI_MODALITA_PAGAMENTO;
	}

}
