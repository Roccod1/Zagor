package it.servizidigitali.communication.service.impl;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.communication.configuration.TemplateComunicazioniEnteConfiguration;
import it.servizidigitali.communication.enumeration.Canale;
import it.servizidigitali.communication.exception.CommunicationException;
import it.servizidigitali.communication.model.Comunicazione;
import it.servizidigitali.communication.model.Utente;
import it.servizidigitali.communication.sender.CommunicationSender;
import it.servizidigitali.communication.service.CommunicationService;

/**
 * @author pindi
 *
 */
@Component(immediate = true, name = "communicationService", service = CommunicationService.class, configurationPid = "it.servizidigitali.communication.configuration.TemplateComunicazioniEnteConfiguration")
public class CommunicationServiceImpl implements CommunicationService {

	/**
	 *
	 */
	private static final String USER_FULL_NAME_POSIZIONALE = "user_full_name";
	private static final String NUOVO_STATO_RICHIESTA_POSIZIONALE = "nuovo_stato_richiesta";
	private static final String VECCHIO_STATO_RICHIESTA_POSIZIONALE = "vecchio_stato_richiesta";
	private static final String RICHIESTA_ID_POSIZIONALE = "richiesta_id";
	private static final String OGGETTO_RICHIESTA_POSIZIONALE = "oggetto_richiesta";
	private static final String NOME_ENTE_POSIZIONALE = "nome_ente";

	private static final Log log = LogFactoryUtil.getLog(CommunicationServiceImpl.class.getName());

	private volatile TemplateComunicazioniEnteConfiguration templateComunicazioniEnteConfiguration;

	private ConfigurationProvider configurationProvider;

	@Reference
	private CommunicationSender communicationSender;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		templateComunicazioniEnteConfiguration = ConfigurableUtil.createConfigurable(TemplateComunicazioniEnteConfiguration.class, props);
	}

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	@Override
	public void sendCambioStatoRichiestaCommunication(String nomeEnte, long richiestaId, String oggettoRichiesta, String vecchioStato, String nuovoStato, User user, long companyId, long groupId)
			throws CommunicationException {

		try {
			if (groupId != 0) {
				templateComunicazioniEnteConfiguration = configurationProvider.getGroupConfiguration(TemplateComunicazioniEnteConfiguration.class, groupId);
			}

			String cambioStatoRichiestaEmailSubjectTemplate = templateComunicazioniEnteConfiguration.cambioStatoRichiestaEmailSubjectTemplate();
			String cambioStatoRichiestaEmailBodyTemplate = templateComunicazioniEnteConfiguration.cambioStatoRichiestaEmailBodyTemplate();

			Map<String, String> valuesMap = new HashMap<String, String>();
			valuesMap.put(NOME_ENTE_POSIZIONALE, nomeEnte);
			valuesMap.put(RICHIESTA_ID_POSIZIONALE, String.valueOf(richiestaId));

			StringSubstitutor cambioStatoRichiestaEmailSubjectTemplateStringSubstitutor = new StringSubstitutor(valuesMap);
			String cambioStatoRichiestaEmailSubjectTemplateResolved = cambioStatoRichiestaEmailSubjectTemplateStringSubstitutor.replace(cambioStatoRichiestaEmailSubjectTemplate);

			valuesMap = new HashMap<String, String>();
			valuesMap.put(USER_FULL_NAME_POSIZIONALE, user.getFullName());
			valuesMap.put(OGGETTO_RICHIESTA_POSIZIONALE, oggettoRichiesta);
			valuesMap.put(VECCHIO_STATO_RICHIESTA_POSIZIONALE, vecchioStato);
			valuesMap.put(NUOVO_STATO_RICHIESTA_POSIZIONALE, nuovoStato);

			StringSubstitutor cambioStatoRichiestaEmailBodyTemplateStringSubstitutor = new StringSubstitutor(valuesMap);
			String cambioStatoRichiestaEmailBodyTemplateResolved = cambioStatoRichiestaEmailBodyTemplateStringSubstitutor.replace(cambioStatoRichiestaEmailBodyTemplate);

			Utente utente = new Utente();
			utente.setEmail(user.getEmailAddress());
			List<Utente> utenti = Arrays.asList(utente);

			Comunicazione comunicazione = new Comunicazione(cambioStatoRichiestaEmailSubjectTemplateResolved, cambioStatoRichiestaEmailBodyTemplateResolved, utenti, null, false, null, companyId,
					groupId);
			communicationSender.sendNow(comunicazione, Canale.EMAIL);

		}
		catch (ConfigurationException e) {
			log.error("sendCambioStatoRichiestaCommunication :: " + e.getMessage(), e);
		}

	}

}
