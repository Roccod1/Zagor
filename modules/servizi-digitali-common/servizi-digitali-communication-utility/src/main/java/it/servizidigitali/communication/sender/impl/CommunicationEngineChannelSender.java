package it.servizidigitali.communication.sender.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;

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

	public Result sendMessage(Message message) {

		log.debug(":::: sendMessage :: start");

		Result result = new Result();

		if (message != null) {

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

				ObjectMapper om = new ObjectMapper();
				om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

				try {
					result = om.readValue(errorResponse, Result.class);
				}
				catch (Exception ex) {
					log.error(":::: sendMessage :: error ", ex);
				}
			}
		}
		else {
			result.setCode(-1);
			result.setError("Channel " + message.getChannel() + " not yet implemented");
			result.setMessageId("");
			result.setStatus(-1);
		}

		log.debug(":::: sendMessage :: end :: " + result);
		return result;
	}

	public Result sendNowMessage(Message message) {

		log.debug(":::: sendNowMessage :: start");

		Result result = new Result();

		if (message != null) {

			try {
				WebClient client = WebClient.create(url);
				client.path("/sendNow");
				client.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE);

				result = client.post(message, Result.class);

			}
			catch (Exception e) {

				log.error(":::: sendNowMessage :: error ", e);

				String errorResponse = e.getMessage();

				ObjectMapper om = new ObjectMapper();
				om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

				try {
					result = om.readValue(errorResponse, Result.class);
				}
				catch (Exception ex) {
					log.error(":::: sendNowMessage :: error ", ex);
				}
			}
		}
		else {
			result.setCode(-1);
			result.setError("Channel " + message.getChannel() + " not yet implemented");
			result.setMessageId("");
			result.setStatus(-1);
		}

		log.debug(":::: sendMessage :: end :: " + result);
		return result;
	}

	/**
	 * @param comunicazione
	 * @return
	 */
	protected abstract Message getMessage(Comunicazione comunicazione);
}
