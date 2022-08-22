package it.servizidigitali.communication.sender;

import it.servizidigitali.communication.enumeration.Canale;
import it.servizidigitali.communication.exception.CommunicationException;
import it.servizidigitali.communication.model.Comunicazione;
import it.servizidigitali.communication.model.EsitoComunicazione;

/**
 * @author pindi
 *
 */
public interface CommunicationSender {

	/**
	 * Invio comunicazione
	 * 
	 * @param comunicazione
	 * @param canale
	 * @return
	 * @throws CommunicationException
	 */
	EsitoComunicazione send(Comunicazione comunicazione, Canale canale) throws CommunicationException;

	/**
	 *
	 * @param comunicazione
	 * @param canale
	 * @return
	 * @throws CommunicationException
	 */
	EsitoComunicazione sendNow(Comunicazione comunicazione, Canale canale) throws CommunicationException;

}
