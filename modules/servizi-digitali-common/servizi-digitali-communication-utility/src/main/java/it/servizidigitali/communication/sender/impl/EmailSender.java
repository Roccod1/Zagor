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
import it.servizidigitali.communication.model.DatiEnte;
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
		sendEnabled = communicationConfiguration.communicationEngineSendEnabled();
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
			DatiEnte datiEnte = comunicazione.getDatiComune();
			if (datiEnte != null) {
				message.setExternalId(datiEnte.getTenantId());
				from = datiEnte.getMailFrom();
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
			message.setAccount(getEmailAccount(datiEnte));
			return message;
		}
		catch (Exception e) {
			throw new CommunicationException(e);
		}
	}

	private EmailAccount getEmailAccount(DatiEnte datiEnte) {
		EmailAccount emailAccount = null;
		if (datiEnte != null) {
			emailAccount = new EmailAccount();
			emailAccount.setHost(datiEnte.getMailHost());
			emailAccount.setPort(datiEnte.getMailPort());
			emailAccount.setProtocol(datiEnte.getMailProtocol());
			emailAccount.setType(CHANNEL);
			emailAccount.setUsername(datiEnte.getMailUsername());
			emailAccount.setPassword(datiEnte.getMailPassword());
			emailAccount.setSocketFactoryPort(datiEnte.getMailSmtpSocketFactoryPort());
			emailAccount.setAuth(datiEnte.getMailSmtpAuth() != null ? String.valueOf(datiEnte.getMailSmtpAuth()) : "");
			emailAccount.setStarttls(datiEnte.getMailSmtpStarttlsEnable());
			emailAccount.setDebug(datiEnte.getMailSmtpDebug());
			emailAccount.setStarttlsRequired(datiEnte.getMailSmtpStarttlsRequired());
			emailAccount.setSocketFactoryFallback(datiEnte.getMailSmtpSocketFactoryFallback());
			emailAccount.setFrom(datiEnte.getMailFrom());
			emailAccount.setSslProtocols(datiEnte.getMailSmtpSslProtocols());
		}
		return emailAccount;
	}
}
