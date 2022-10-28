package it.servizidigitali.presentatoreforms.common.service;

import it.servizidigitali.presentatoreforms.common.exception.PDFServiceException;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
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
	 * @param idDestinazioneUso
	 * @param numeroBollo
	 * @return
	 * @throws PDFServiceException
	 */
	byte[] generaPDFCertificato(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, Long idDestinazioneUso, String numeroBollo)
			throws PDFServiceException;

	/**
	 *
	 * @param codiceFiscaleRichiedente
	 * @param codiceFiscaleComponente
	 * @param alpacaStructure
	 * @param richiesta
	 * @param isDelega
	 * @param dettagliRichiesta
	 * @return
	 * @throws PDFServiceException
	 */
	byte[] generaPDFAlpacaForm(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, boolean isDelega, String dettagliRichiesta)
			throws PDFServiceException;

}
