package it.servizidigitali.backoffice.integration.service.anpr;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.linksmt.servizionline.anprws.client.ANPRWSClient;
import it.linksmt.servizionline.anprws.exception.ANPRClientException;
import it.servizidigitali.backoffice.integration.configuration.anpr.ANPRConfiguration;
import it.servizidigitali.backoffice.integration.converter.anpr.DatiAnagraficiANPRConverter;
import it.servizidigitali.backoffice.integration.converter.anpr.DatiAnagraficiGeneraliANPRConverter;
import it.servizidigitali.backoffice.integration.converter.anpr.DatiElettoraliANPRConverter;
import it.servizidigitali.backoffice.integration.converter.anpr.DatiVariazioniDomicilioANPRConverter;
import it.servizidigitali.backoffice.integration.exception.BackofficeIntegrationClientException;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagraficiGenerali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationService;
import it.servizidigitali.backoffice.integration.service.CacheService;
import it.sogei.anpr._3000consultazione.Risposta3002;

/**
 * @author pindi
 *
 */
@Component(name = "anagrafeANPRIntegrationService", immediate = true, service = AnagrafeIntegrationService.class, configurationPid = "it.servizidigitali.backoffice.integration.configuration.anpr.ANPRConfiguration")
public class AnagrafeANPRIntegrationServiceImpl implements AnagrafeIntegrationService {

	private static final String ID_TRANSAZIONE_DEFAULT = "999999999";

	private static final Log log = LogFactoryUtil.getLog(AnagrafeANPRIntegrationServiceImpl.class.getName());

	@Reference
	private CacheService cacheService;

	@Reference
	private DatiAnagraficiANPRConverter datiAnagraficiANPRConverter;

	@Reference
	private DatiAnagraficiGeneraliANPRConverter datiAnagraficiGeneraliANPRConverter;

	@Reference
	private DatiElettoraliANPRConverter datiElettoraliANPRConverter;

	@Reference
	private DatiVariazioniDomicilioANPRConverter datiVariazioniDomicilioANPRConverter;

	@Reference
	private ANPRService anprService;

	private volatile ANPRConfiguration anprConfiguration;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		anprConfiguration = ConfigurableUtil.createConfigurable(ANPRConfiguration.class, props);
	}

	@Override
	public DatiAnagrafici getDatiAnagrafici(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		String idTransazione = integrationPreferences != null ? integrationPreferences.getIdTransazione() : null;
		if (idTransazione == null) {
			idTransazione = ID_TRANSAZIONE_DEFAULT;
		}
		DatiAnagrafici datiAnagrafici = null;
		boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
		if (usaCache) {
			if (datiAnagrafici == null) {
				datiAnagrafici = cacheService.getFromCache(codiceFiscale, DatiAnagrafici.class);
				try {
					Risposta3002 risposta3002 = esegui(codiceFiscale, idTransazione);
					datiAnagrafici = datiAnagraficiANPRConverter.convert(risposta3002);
					cacheService.putInCache(codiceFiscale, datiAnagrafici);
				}
				catch (ANPRClientException e) {
					log.error("getDatiAnagrafici :: " + e.getMessage(), e);
				}
			}
		}
		else {
			try {
				Risposta3002 risposta3002 = esegui(codiceFiscale, idTransazione);
				datiAnagrafici = datiAnagraficiANPRConverter.convert(risposta3002);
			}
			catch (ANPRClientException e) {
				log.error("getDatiAnagrafici :: " + e.getMessage(), e);
			}
		}

		return datiAnagrafici;
	}

	@Override
	public DatiAnagraficiGenerali getDatiAnagraficiGenerali(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		String idTransazione = integrationPreferences != null ? integrationPreferences.getIdTransazione() : null;
		if (idTransazione == null) {
			idTransazione = ID_TRANSAZIONE_DEFAULT;
		}
		DatiAnagraficiGenerali datiAnagraficiGenerali = null;
		boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
		if (usaCache) {
			datiAnagraficiGenerali = cacheService.getFromCache(codiceFiscale, DatiAnagraficiGenerali.class);
			if (datiAnagraficiGenerali == null) {
				try {
					Risposta3002 risposta3002 = esegui(codiceFiscale, idTransazione);
					datiAnagraficiGenerali = datiAnagraficiGeneraliANPRConverter.convert(risposta3002, codiceFiscale);
					cacheService.putInCache(codiceFiscale, datiAnagraficiGenerali);
				}
				catch (ANPRClientException e) {
					log.error("getDatiAnagraficiGenerali :: " + e.getMessage(), e);
				}
			}
		}
		else {
			try {
				Risposta3002 risposta3002 = esegui(codiceFiscale, idTransazione);
				datiAnagraficiGenerali = datiAnagraficiGeneraliANPRConverter.convert(risposta3002, codiceFiscale);
			}
			catch (ANPRClientException e) {
				log.error("getDatiAnagraficiGenerali :: " + e.getMessage(), e);
			}
		}

		return datiAnagraficiGenerali;
	}

	@Override
	public DatiElettorali getDatiElettorali(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		String idTransazione = integrationPreferences != null ? integrationPreferences.getIdTransazione() : null;
		if (idTransazione == null) {
			idTransazione = ID_TRANSAZIONE_DEFAULT;
		}
		DatiElettorali datiElettorali = null;

		boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
		if (usaCache) {
			datiElettorali = cacheService.getFromCache(codiceFiscale, DatiElettorali.class);
			if (datiElettorali == null) {
				try {
					Risposta3002 risposta3002 = esegui(codiceFiscale, idTransazione);
					datiElettorali = datiElettoraliANPRConverter.convert(risposta3002, codiceFiscale);
					cacheService.putInCache(codiceFiscale, datiElettorali);
				}
				catch (ANPRClientException e) {
					log.error("getDatiElettorali :: " + e.getMessage(), e);
				}
			}
		}
		else {
			try {
				Risposta3002 risposta3002 = esegui(codiceFiscale, idTransazione);
				datiElettorali = datiElettoraliANPRConverter.convert(risposta3002, codiceFiscale);
			}
			catch (ANPRClientException e) {
				log.error("getDatiElettorali :: " + e.getMessage(), e);
			}
		}
		return datiElettorali;
	}

	@Override
	public DatiVariazioniDomicilio getDatiVariazioniDomicilio(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		String idTransazione = integrationPreferences != null ? integrationPreferences.getIdTransazione() : null;
		if (idTransazione == null) {
			idTransazione = ID_TRANSAZIONE_DEFAULT;
		}

		DatiVariazioniDomicilio datiVariazioniDomicilio = null;
		boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
		if (usaCache) {
			datiVariazioniDomicilio = cacheService.getFromCache(codiceFiscale, DatiVariazioniDomicilio.class);
			if (datiVariazioniDomicilio == null) {
				try {
					Risposta3002 risposta3002 = esegui(codiceFiscale, idTransazione);
					datiVariazioniDomicilio = datiVariazioniDomicilioANPRConverter.convert(risposta3002, codiceFiscale);
					cacheService.putInCache(codiceFiscale, datiVariazioniDomicilio);
				}
				catch (ANPRClientException e) {
					log.error("getDatiVariazioniDomicilio :: " + e.getMessage(), e);
				}
			}
		}
		else {
			try {
				Risposta3002 risposta3002 = esegui(codiceFiscale, idTransazione);
				datiVariazioniDomicilio = datiVariazioniDomicilioANPRConverter.convert(risposta3002, codiceFiscale);
			}
			catch (ANPRClientException e) {
				log.error("getDatiVariazioniDomicilio :: " + e.getMessage(), e);
			}
		}
		return datiVariazioniDomicilio;

	}

	private Risposta3002 esegui(String codiceFiscale, String idTransazione) throws ANPRClientException {

		Risposta3002 risposta = null;
		// Tentativi caricamento dati
		try {
			int counter = 1;
			ANPRWSClient anprwsClient = anprService.getANPRWSClient();

			while (counter <= anprConfiguration.numeroTentativiInvio()) {
				try {
					risposta = anprwsClient.sendRequest(codiceFiscale, idTransazione);
					if (risposta == null) {
						throw new ANPRClientException("Risposta is null or empty");
					}
					counter++;
				}
				catch (Exception e) {
					log.error("esegui :: tentativo num. " + counter + " per caricamento dati da ANPR fallito : " + e.getMessage(), e);
					counter++;
				}
			}
		}
		catch (Exception e) {
			log.error("esegui :: " + e.getMessage(), e);
			throw new BackofficeIntegrationClientException(e);
		}
		return risposta;
	}

}
