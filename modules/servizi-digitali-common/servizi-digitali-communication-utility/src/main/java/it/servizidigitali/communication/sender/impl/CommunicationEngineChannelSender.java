package it.servizidigitali.communication.sender.impl;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;

import it.servizidigitali.communication.exception.CommunicationException;
import it.servizidigitali.communication.model.Comunicazione;
import it.servizidigitali.communication.model.ce.Message;
import it.servizidigitali.communication.model.ce.Result;

/**
 *
 * @author pindi
 *
 */
public abstract class CommunicationEngineChannelSender {

	private static final Log log = LogFactoryUtil.getLog(CommunicationEngineChannelSender.class.getName());

	protected String url;
	protected boolean sendEnabled;

	public Result sendMessage(Message message) throws CommunicationException {

		if (!sendEnabled) {
			throw new CommunicationException("Invio tramite Communication Engine disabilitato.");
		}

		log.debug(":::: sendMessage :: start");

		Result result = new Result();

		try {
			List<Object> providers = new ArrayList<Object>();
			JacksonJaxbJsonProvider jacksonJsonProvider = new JacksonJaxbJsonProvider();
			providers.add(jacksonJsonProvider);

			WebClient client = WebClient.create(url, providers);
			client.path("/send");
			client.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE);

			result = client.post(message, Result.class);

		}
		catch (Exception e) {

			log.error(":::: sendMessage :: error ", e);

			String errorResponse = e.getMessage();
			throw new CommunicationException(errorResponse, e);
		}

		log.debug(":::: sendMessage :: end :: " + result);
		return result;
	}

	public Result sendNowMessage(Message message) throws CommunicationException {

		if (!sendEnabled) {
			throw new CommunicationException("Invio tramite Communication Engine disabilitato.");
		}

		log.debug(":::: sendNowMessage :: start");

		Result result = new Result();

		try {
			List<Object> providers = new ArrayList<Object>();
			JacksonJaxbJsonProvider jacksonJsonProvider = new JacksonJaxbJsonProvider();
			providers.add(jacksonJsonProvider);
			WebClient client = WebClient.create(url, providers);
			client.path("/sendNow");
			client.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE);

			result = client.post(message, Result.class);

		}
		catch (Exception e) {

			log.error(":::: sendNowMessage :: error ", e);

			String errorResponse = e.getMessage();
			throw new CommunicationException(errorResponse, e);
		}

		log.debug(":::: sendNowMessage :: end :: " + result);
		return result;
	}

	/**
	 * @param comunicazione
	 * @return
	 */
	protected abstract Message getMessage(Comunicazione comunicazione) throws CommunicationException;
}
