package it.servizidigitali.communication.service;

import com.liferay.portal.kernel.model.User;

import it.servizidigitali.communication.exception.CommunicationException;

/**
 * @author pindi
 *
 */
public interface CommunicationService {

	/**
	 *
	 * @param nomeEnte
	 * @param richiestaId
	 * @param oggettoRichiesta
	 * @param vecchioStato
	 * @param nuovoStato
	 * @param user
	 * @param companyId
	 * @param groupId
	 * @throws CommunicationException
	 */
	void sendCambioStatoRichiestaCommunication(String nomeEnte, long richiestaId, String oggettoRichiesta, String vecchioStato, String nuovoStato, User user, long companyId, long groupId)
			throws CommunicationException;

}
