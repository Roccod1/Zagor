package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneforms.service.TipoDocumentoLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AllegatoUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.DatiAllegato;
import it.servizidigitali.presentatoreforms.frontend.util.model.DatiDocumentoPersonale;
import it.servizidigitali.presentatoreforms.frontend.util.model.DatiFileAllegato;


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
		
		Long idFormMock = 52402L;
		Form form = null;
		try {
		form = formLocalService.getForm(idFormMock);
		} catch (Exception e) {
			_log.error("errore nel recupero del form: " + idFormMock + " :: ERORR MESSAGE: " + e.getMessage());
		}
		
		List<DefinizioneAllegato> definizioneAllegati = definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(idFormMock);
		
		List<DatiAllegato> allegati = AllegatoUtil.mergeDefinizioneAndData(definizioneAllegati, new ArrayList<DatiFileAllegato>());
		
		//FIXME Valori mock
		for (DatiAllegato allegato : allegati) {
			List<DatiDocumentoPersonale> datiDocPersonaleList = new ArrayList<DatiDocumentoPersonale>();
			if ("ci".equals(allegato.getDefinizione().getCodiciTipologiaDocumento())) {

				DatiDocumentoPersonale docPers = new DatiDocumentoPersonale();
				docPers.setBytes("testo_carta_identita".getBytes());
				docPers.setCodice("ci");
				docPers.setCodiceFiscaleProprietario("prvprv00a00a000a");
				docPers.setDataCreazione(new Date());
				docPers.setDataModifica(new Date());
				docPers.setDataScadenza(new Date(0L));
				docPers.setDescrizione("questa è una carta di identità");
				docPers.setInScadenza(false);
				docPers.setIdRepository("/opt/liferay-ce-portal-7.4.3.30-ga30/data/carta_identita.pdf");
				docPers.setMetadati("metadati");
				docPers.setNomeFile("carta_identita.pdf");
				docPers.setNumero("99999");
				docPers.setScaduto(true);
				docPers.setTitolo("carta di identità");
				docPers.setVersione("1");
				datiDocPersonaleList.add(docPers);
				
			}
			if ("cf".equals(allegato.getDefinizione().getCodiciTipologiaDocumento())) {

				DatiDocumentoPersonale docPers = new DatiDocumentoPersonale();
				docPers.setBytes("testo_cod_fisc".getBytes());
				docPers.setCodice("cf");
				docPers.setCodiceFiscaleProprietario("prvprv00a00a000a");
				docPers.setDataCreazione(new Date());
				docPers.setDataModifica(new Date());
				docPers.setDataScadenza(new Date(new Date().getTime() + 86400000));
				docPers.setDescrizione("questo è un cod fisc");
				docPers.setInScadenza(true);
				docPers.setIdRepository("/opt/liferay-ce-portal-7.4.3.30-ga30/data/cod_fisc.pdf");
				docPers.setMetadati("metadati");
				docPers.setNomeFile("cod_fisc.pdf");
				docPers.setNumero("99999");
				docPers.setScaduto(false);
				docPers.setTitolo("codice fiscale");
				docPers.setVersione("1");
				datiDocPersonaleList.add(docPers);
				
			}
			allegato.setDocumentiPersonali(datiDocPersonaleList);
		}
		
		renderRequest.setAttribute("idServizio",1);
		renderRequest.setAttribute("idRichiesta",1);
		renderRequest.setAttribute("richiestaStatus", true);
		renderRequest.setAttribute("bozzaStatus", true);
		renderRequest.setAttribute("titoloPortletServizio",form.getNome());
		renderRequest.setAttribute("!invioIstanza",true);
		renderRequest.setAttribute("firmaDocumentoAbilitata",true);
		renderRequest.setAttribute("salvaUrl","/");
		renderRequest.setAttribute("scegliAllegatiDescription","42656");
		renderRequest.setAttribute("downloadIstanzaUrl","/");
		renderRequest.setAttribute("uploadFileMaxSize",3145728);
		renderRequest.setAttribute("uploadFileMaxSizeLabel",Long.toString(3145728 / 1000000) + " MB");
		renderRequest.setAttribute("nomeFileFirmato","file_firm");
		
		// TODO
		renderRequest.setAttribute("pdfFirmato", null);
		//
		
		renderRequest.setAttribute("downloadFilePrincipaleUrl","/");
		renderRequest.setAttribute("allegati", allegati);
		renderRequest.setAttribute("downloadFileUrl","/");
		renderRequest.setAttribute("downloadModelloUrl","/");
		renderRequest.setAttribute("downloadDocumentoPersonaleUrl", "/");
		renderRequest.setAttribute("homeScrivaniaUrl","/");
		renderRequest.setAttribute("firmaDocumentoAbilitata", true);
		renderRequest.setAttribute("invioIstanza",true);
		renderRequest.setAttribute("evaluationServiceEnable",false);
		renderRequest.setAttribute("pathScrivaniaVirtuale","/");
		renderRequest.setAttribute("isDebugEnabled",true);
		
		return PresentatoreFormsPortletKeys.JSP_SCEGLI_ALLEGATI;
	}

}
