package it.servizidigitali.presentatoreforms.common.service;

import com.liferay.portal.kernel.exception.PortalException;

import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;

/**
 * @author pindi
 *
 */
public interface CertificatoService {

	/**
	 *
	 * @param codiceFiscaleRichiedente
	 * @param codiceFiscaleComponente
	 * @param richiestaId
	 * @param destinazioneUsoId
	 * @param numeroBollo
	 * @return
	 * @throws PortalException
	 */
	byte[] generaPDFCertificato(String codiceFiscaleRichiedente, String codiceFiscaleComponente, long richiestaId, long destinazioneUsoId, String numeroBollo) throws PortalException;

	/**
	 *
	 * @param codiceFiscaleRichiedente
	 * @param codiceFiscaleComponente
	 * @param alpacaStructure
	 * @param richiestaId
	 * @param destinazioneUsoId
	 * @param numeroBollo
	 * @return
	 * @throws PortalException
	 */
	byte[] generaPDFCertificato(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, long richiestaId, long destinazioneUsoId, String numeroBollo)
			throws PortalException;

}
