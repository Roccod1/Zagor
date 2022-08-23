package it.servizidigitali.communication.sender.impl;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.communication.configuration.AccountEnteConfiguration;
import it.servizidigitali.communication.configuration.CommunicationConfiguration;
import it.servizidigitali.communication.exception.CommunicationException;
import it.servizidigitali.communication.model.Allegato;
import it.servizidigitali.communication.model.Comunicazione;
import it.servizidigitali.communication.model.Utente;
import it.servizidigitali.communication.model.ce.Attachment;
import it.servizidigitali.communication.model.ce.Contact;
import it.servizidigitali.communication.model.ce.Message;
import it.servizidigitali.communication.model.ce.PecAccount;

/**
 *
 * @author pindi
 *
 */
@Component(immediate = true, property = {}, service = EmailPecSender.class, configurationPid = { "it.servizidigitali.communication.configuration.CommunicationConfiguration",
		"it.servizidigitali.communication.configuration.AccountEnteConfiguration" })
public class EmailPecSender extends CommunicationEngineChannelSender {

	private static final String CHANNEL = "pec";

	private volatile CommunicationConfiguration communicationConfiguration;
	private volatile AccountEnteConfiguration accountEnteConfiguration;

	private ConfigurationProvider configurationProvider;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		communicationConfiguration = ConfigurableUtil.createConfigurable(CommunicationConfiguration.class, props);
		accountEnteConfiguration = ConfigurableUtil.createConfigurable(AccountEnteConfiguration.class, props);
		url = communicationConfiguration.communicationEngineBasePath();
		sendEnabled = communicationConfiguration.communicationEngineSendEnabled();
	}

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	@Override
	public Message getMessage(Comunicazione comunicazione) throws CommunicationException {

		try {

			long groupId = comunicazione.getGroupId();
			if (groupId != 0) {
				accountEnteConfiguration = configurationProvider.getGroupConfiguration(AccountEnteConfiguration.class, groupId);
			}

			Message message = new Message();
			message.setChannel(CHANNEL);
			message.setHtml(true);
			message.setSubject(comunicazione.getOggetto());
			message.setText(comunicazione.getTesto());
			String tenantId = accountEnteConfiguration.tenantId();
			if (Validator.isNotNull(tenantId)) {
				message.setExternalId(tenantId);
			}

			String from = null;
			boolean accountEnabled = accountEnteConfiguration.accountPecEnabled();
			if (accountEnabled) {
				from = accountEnteConfiguration.pecFrom();
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
				contact.setEmail(utente.getPec());
				contact.setName(utente.getPec());
				contact.setType(CHANNEL);
				contactsTo.add(contact);
			}

			message.setTo(contactsTo);
			message.setAccount(getPecAccount());
			return message;
		}
		catch (Exception e) {
			throw new CommunicationException(e);
		}
	}

	private PecAccount getPecAccount() {
		PecAccount pecAccount = null;
		if (accountEnteConfiguration.accountPecEnabled()) {
			pecAccount = new PecAccount();
			pecAccount.setHost(accountEnteConfiguration.pecHost());
			pecAccount.setPort(accountEnteConfiguration.pecPort());
			pecAccount.setProtocol(accountEnteConfiguration.pecProtocol());
			pecAccount.setType(CHANNEL);
			pecAccount.setUsername(accountEnteConfiguration.pecUsername());
			pecAccount.setPassword(accountEnteConfiguration.pecPassword());
			pecAccount.setSocketFactoryPort(accountEnteConfiguration.pecSmtpSocketFactoryPort());
			pecAccount.setAuth(String.valueOf(accountEnteConfiguration.pecSmtpAuth()));
			pecAccount.setStarttls(accountEnteConfiguration.pecSmtpStarttlsEnable());
			pecAccount.setDebug(accountEnteConfiguration.pecSmtpDebug());
			pecAccount.setStarttlsRequired(accountEnteConfiguration.pecSmtpStarttlsRequired());
			pecAccount.setSocketFactoryFallback(accountEnteConfiguration.pecSmtpSocketFactoryFallback());
			pecAccount.setFrom(accountEnteConfiguration.pecFrom());
			pecAccount.setSslProtocols(accountEnteConfiguration.pecSmtpSslProtocols());
		}
		return pecAccount;
	}
}