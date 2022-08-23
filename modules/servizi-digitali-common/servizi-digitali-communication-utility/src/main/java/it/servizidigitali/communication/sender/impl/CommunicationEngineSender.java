package it.servizidigitali.communication.sender.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.communication.enumeration.Canale;
import it.servizidigitali.communication.exception.CommunicationException;
import it.servizidigitali.communication.model.Comunicazione;
import it.servizidigitali.communication.model.EsitoComunicazione;
import it.servizidigitali.communication.model.ce.Message;
import it.servizidigitali.communication.model.ce.Result;
import it.servizidigitali.communication.sender.CommunicationSender;

/**
 * @author pindi
 *
 */
@Component(immediate = true, property = {}, service = CommunicationSender.class)
public class CommunicationEngineSender implements CommunicationSender {

	private static final Log log = LogFactoryUtil.getLog(CommunicationEngineSender.class.getName());

	@Reference
	private CommunicationEngineSenderFactory communicationEngineSenderFactory;

	@Override
	public EsitoComunicazione send(Comunicazione comunicazione, Canale canale) throws CommunicationException {

		try {
			CommunicationEngineChannelSender communicationEngineChannelSender = communicationEngineSenderFactory.getChannelSender(canale);

			Message message = communicationEngineChannelSender.getMessage(comunicazione);
			Result result = communicationEngineChannelSender.sendMessage(message);

			EsitoComunicazione esitoComunicazione = new EsitoComunicazione();
			esitoComunicazione.setChannel(result.getChannel());
			esitoComunicazione.setCode(result.getCode());
			esitoComunicazione.setError(result.getError());
			esitoComunicazione.setMessage(result.getMessage());
			esitoComunicazione.setMessageId(result.getMessageId());
			esitoComunicazione.setPath(result.getPath());
			esitoComunicazione.setStatus(result.getStatus());
			esitoComunicazione.setTime(result.getTime());

			return esitoComunicazione;
		}
		catch (CommunicationException e) {
			log.error("send :: " + e.getMessage(), e);
			throw e;
		}
		catch (Exception e) {
			log.error("send :: " + e.getMessage(), e);
			throw new CommunicationException(e);
		}
	}

	@Override
	public EsitoComunicazione sendNow(Comunicazione comunicazione, Canale canale) throws CommunicationException {

		try {
			CommunicationEngineChannelSender communicationEngineChannelSender = communicationEngineSenderFactory.getChannelSender(canale);

			Message message = communicationEngineChannelSender.getMessage(comunicazione);
			Result result = communicationEngineChannelSender.sendNowMessage(message);

			EsitoComunicazione esitoComunicazione = new EsitoComunicazione();
			esitoComunicazione.setChannel(result.getChannel());
			esitoComunicazione.setCode(result.getCode());
			esitoComunicazione.setError(result.getError());
			esitoComunicazione.setMessage(result.getMessage());
			esitoComunicazione.setMessageId(result.getMessageId());
			esitoComunicazione.setPath(result.getPath());
			esitoComunicazione.setStatus(result.getStatus());
			esitoComunicazione.setTime(result.getTime());

			return esitoComunicazione;
		}
		catch (CommunicationException e) {
			log.error("sendNow :: " + e.getMessage(), e);
			throw e;
		}
		catch (Exception e) {
			log.error("sendNow :: " + e.getMessage(), e);
			throw new CommunicationException(e);
		}
	}
}
