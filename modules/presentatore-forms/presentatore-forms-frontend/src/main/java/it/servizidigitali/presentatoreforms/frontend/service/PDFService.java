package it.servizidigitali.presentatoreforms.frontend.service;


import javax.portlet.PortletRequest;

import it.servizidigitali.presentatoreforms.frontend.exception.PDFServiceException;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

/**
 * @author pindi
 *
 */
public interface PDFService {

	/**
	 *
	 * @param codiceFiscaleRichiedente
	 * @param codiceFiscaleComponente
	 * @param alpacaStructure
	 * @param richiesta
	 * @param fileName
	 * @param idDestinazioneUso
	 * @param numeroBollo
	 * @param themeDisplay
	 * @return
	 * @throws PDFServiceException
	 */
	byte[] generaPDFCertificato(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, String fileName, Long idDestinazioneUso,
			String numeroBollo, PortletRequest portletRequest) throws PDFServiceException;

	/**
	 *
	 * @param codiceFiscaleRichiedente
	 * @param codiceFiscaleComponente
	 * @param alpacaStructure
	 * @param richiesta
	 * @param fileName
	 * @param idDestinazioneUso
	 * @param numeroBollo
	 * @param isDelega
	 * @param dettagliRichiesta
	 * @param themeDisplay
	 * @return
	 * @throws PDFServiceException
	 */
	byte[] generaPDFAlpacaForm(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, String fileName,
			String numeroBollo, boolean isDelega, String dettagliRichiesta, PortletRequest portletRequest) throws PDFServiceException;

}
