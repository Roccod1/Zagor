package it.servizidigitali.communication.sender.impl;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.servizidigitali.communication.configuration.CommunicationConfiguration;
import it.servizidigitali.communication.exception.CommunicationException;
import it.servizidigitali.communication.model.Allegato;
import it.servizidigitali.communication.model.Comunicazione;
import it.servizidigitali.communication.model.DatiComune;
import it.servizidigitali.communication.model.Utente;
import it.servizidigitali.communication.model.ce.Attachment;
import it.servizidigitali.communication.model.ce.Contact;
import it.servizidigitali.communication.model.ce.EmailAccount;
import it.servizidigitali.communication.model.ce.Message;

/**
 *
 * @author pindi
 *
 */
@Component(immediate = true, property = {}, service = EmailSender.class, configurationPid = "it.servizidigitali.communication.configuration.CommunicationConfiguration")
public class EmailSender extends CommunicationEngineChannelSender {

	private static final String CHANNEL = "email";

	private volatile CommunicationConfiguration communicationConfiguration;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		communicationConfiguration = ConfigurableUtil.createConfigurable(CommunicationConfiguration.class, props);
		url = communicationConfiguration.communicationEngineBasePath();
	}

	@Override
	public Message getMessage(Comunicazione comunicazione) {

		try {
			Message message = new Message();
			message.setChannel(CHANNEL);
			message.setHtml(true);
			message.setSubject(comunicazione.getOggetto());
			message.setText(comunicazione.getTesto());
			String from = null;
			DatiComune datiComune = comunicazione.getDatiComune();
			if (datiComune != null) {
				message.setExternalId(datiComune.getTenantId());
				from = datiComune.getMailFrom();
			}
			message.setImportant(false);
			message.setOneShot(comunicazione.isInvioMultiplo());

			List<Allegato> allegati = comunicazione.getAllegati();
			if (allegati != null) {
				List<Attachment> attachmentsToSend = new ArrayList<Attachment>();
				for (Allegato allegato : allegati) {

					Attachment attachment = new Attachment();
					String base64 = DatatypeConverter.printBase64Binary(allegato.getContenuto().readAllBytes());
					attachment.setName(allegato.getNome());
					attachment.setContentType(allegato.getTipoContenuto());
					attachment.setContent(base64);
					attachmentsToSend.add(attachment);

				}
				message.setAttachments(attachmentsToSend);
			}

			if (Validator.isNotNull(from)) {
				Contact contact = new Contact();
				contact.setEmail(from);
				contact.setName(from);
				contact.setType(CHANNEL);
				message.setFrom(contact);
			}

			List<Object> contactsTo = new ArrayList<Object>();

			List<Utente> utenti = comunicazione.getUtenti();
			for (Utente utente : utenti) {
				Contact contact = new Contact();
				contact.setEmail(utente.getMail());
				contact.setName(utente.getMail());
				contact.setType(CHANNEL);
				contactsTo.add(contact);
			}

			message.setTo(contactsTo);
			message.setAccount(getEmailAccount(datiComune));
			return message;
		}
		catch (Exception e) {
			throw new CommunicationException(e);
		}
	}

	private EmailAccount getEmailAccount(DatiComune datiComune) {
		EmailAccount emailAccount = null;
		if (datiComune != null) {
			emailAccount = new EmailAccount();
			emailAccount.setHost(datiComune.getMailHost());
			emailAccount.setPort(datiComune.getMailPort());
			emailAccount.setProtocol(datiComune.getMailProtocol());
			emailAccount.setType(CHANNEL);
			emailAccount.setUsername(datiComune.getMailUsername());
			emailAccount.setPassword(datiComune.getMailPassword());
			emailAccount.setSocketFactoryPort(datiComune.getMailSmtpSocketFactoryPort());
			emailAccount.setAuth(datiComune.getMailSmtpAuth() != null ? String.valueOf(datiComune.getMailSmtpAuth()) : "");
			emailAccount.setStarttls(datiComune.getMailSmtpStarttlsEnable());
			emailAccount.setDebug(datiComune.getMailSmtpDebug());
			emailAccount.setStarttlsRequired(datiComune.getMailSmtpStarttlsRequired());
			emailAccount.setSocketFactoryFallback(datiComune.getMailSmtpSocketFactoryFallback());
			emailAccount.setFrom(datiComune.getMailFrom());
			emailAccount.setSslProtocols(datiComune.getMailSmtpSslProtocols());
		}
		return emailAccount;
	}
}
