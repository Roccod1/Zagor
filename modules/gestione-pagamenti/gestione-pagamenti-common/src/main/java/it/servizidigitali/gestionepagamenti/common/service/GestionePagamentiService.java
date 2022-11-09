package it.servizidigitali.gestionepagamenti.common.service;

import it.servizidigitali.gestionepagamenti.common.exception.GestionePagamentiServiceException;

/**
 * @author pindi
 *
 */
public interface GestionePagamentiService {

	/**
	 *
	 * @param file
	 * @param fileName
	 * @param richiestaId
	 * @param proceduraId
	 * @param servizioId
	 * @param organizationId
	 * @param userId
	 * @param groupId
	 * @param companyId
	 * @param callbackUrl
	 * @return path per il redirect al sistema di pagamento bollo
	 * @throws GestionePagamentiServiceException
	 */
	String pagaBollo(byte[] file, String fileName, long richiestaId, long proceduraId, long servizioId, long organizationId, long userId, long groupId, long companyId, String callbackUrl)
			throws GestionePagamentiServiceException;
}
