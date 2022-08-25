package it.servizidigitali.communication.sender.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.communication.enumeration.Canale;

/**
 *
 * @author Gianluca Pindinelli
 *
 */
@Component(immediate = true, property = {}, service = CommunicationEngineSenderFactory.class)
public class CommunicationEngineSenderFactory {

	@Reference
	private EmailSender emailSender;

	@Reference
	private EmailPecSender emailPecSender;

	public CommunicationEngineChannelSender getChannelSender(Canale canale) {

		if (canale != null) {

			switch (canale) {

			case EMAIL:
				return emailSender;

			case PEC:
				return emailPecSender;

			case PUSH:
				// Not yet implemented
				return null;

			case CKAN:
				throw new UnsupportedOperationException("Not yet implemented");

			case FACEBOOK:
				throw new UnsupportedOperationException("Not yet implemented");

			case TWITTER:
				throw new UnsupportedOperationException("Not yet implemented");

			default:
				return null;
			}
		}
		return null;
	}
}
