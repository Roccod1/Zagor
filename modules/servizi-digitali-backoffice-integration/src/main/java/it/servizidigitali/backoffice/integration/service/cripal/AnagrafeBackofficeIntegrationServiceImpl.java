package it.servizidigitali.backoffice.integration.service.cripal;

import java.util.Calendar;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.AnagrafeBackofficeIntegrationService;
import it.servizidigitali.backoffice.integration.service.CacheService;
import it.servizidigitali.backoffice.integration.xsd.cripal.anagrafe.output.DatiIndirizzo;
import it.servizidigitali.backoffice.integration.xsd.cripal.anagrafe.output.DatiUtente;
import it.servizidigitali.backoffice.integration.xsd.cripal.anagrafe.output.RichiestaDatiAnagrafici;
import it.servizidigitali.backoffice.integration.xsd.cripal.anagrafe.output.RichiestaDatiElettorali;
import it.servizidigitali.backoffice.integration.xsd.cripal.anagrafe.output.RichiestaVariazioniDomiciliari;

/**
 * @author pindi
 *
 */
@Component(name = "anagrafeCRIPALBackofficeIntegrationService", immediate = true, service = AnagrafeBackofficeIntegrationServiceImpl.class)
public class AnagrafeBackofficeIntegrationServiceImpl implements AnagrafeBackofficeIntegrationService {

	private static final String RICHIESTA_DATI_ANAGRAFICI_CRIPAL = "richiestaDatiAnagrafici";
	private static final String RICHIESTA_DATI_ANAGRAFICI_GENERALI = "datiAnagraficiGenerali";
	private static final String RICHIESTA_DATI_ELETTORALI = "richiestaDatiElettorali";
	private static final String RICHIESTA_DATI_VARIAZIONI_DOMICILIARI = "richiestaVariazioniDomiciliari";

	@Reference
	private CRIPALToDatiAnagraficiConverter cripalToDatiAnagraficiConverter;

	@Reference
	private CRIPALToDatiAnagraficiGeneraliConverter cripalToDatiAnagraficiGeneraliConverter;

	@Reference
	private CRIPALToDatiElettoraliConverter cripalToDatiElettoraliConverter;

	@Reference
	private CRIPALToDatiVariazioniDomicilioConverter cripalToDatiVariazioniDomicilioConverter;

	@Reference
	private CacheService cacheService;

	@Override
	public DatiAnagrafici getDatiAnagrafici(String codiceFiscale, String codiceIpa, String idTransazione, IntegrationPreferences integrationPreferences) {

		DatiAnagrafici datiAnagrafici = null;
		boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
		if (usaCache) {
			datiAnagrafici = cacheService.getFromCache(codiceFiscale, DatiAnagrafici.class);
			if (datiAnagrafici == null) {
				datiAnagrafici = getDatiAnagrafici(codiceFiscale, codiceIpa, integrationPreferences);
				cacheService.putInCache(codiceFiscale, datiAnagrafici);
			}
		}
		else {
			datiAnagrafici = getDatiAnagrafici(codiceFiscale, codiceIpa, integrationPreferences);
		}

		return datiAnagrafici;
	}

	/**
	 * @param codiceFiscale
	 * @param codiceIpa
	 * @param integrationPreferences
	 * @return
	 */
	private DatiAnagrafici getDatiAnagrafici(String codiceFiscale, String codiceIpa, IntegrationPreferences integrationPreferences) {
		RichiestaDatiAnagrafici richiesta = new RichiestaDatiAnagrafici();
		richiesta.setCodiceFiscale(codiceFiscale);
		if (integrationPreferences != null) {
			richiesta.setCodiceServizio(integrationPreferences.getCodiceServizio());
		}
		ComuneISA comuneISA = comuneISAService.getComuneByCodiceIPA(codiceIpa);
		it.osapulie.anagrafe.web.ws.output.types.DatiAnagrafici datiAnagraficiCRIPAL = esegui(RICHIESTA_DATI_ANAGRAFICI_CRIPAL, richiesta,
				it.osapulie.anagrafe.web.ws.output.types.DatiAnagrafici.class, comuneISA.getUriServizioGateway(), comuneISA.getCanaleIntegrazione());
		DatiAnagrafici datiAnagrafici = cripalToDatiAnagraficiConverter.convert(datiAnagraficiCRIPAL, comuneISA.getCodiceIstat());
		return datiAnagrafici;
	}

	@Override
	public DatiAnagraficiGenerali getDatiAnagraficiGenerali(String codiceFiscale, String codiceIpa, String idTransazione, IntegrationPreferences integrationPreferences) {

		DatiAnagraficiGenerali datiAnagraficiGenerali = null;
		boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
		if (usaCache) {
			datiAnagraficiGenerali = cacheService.getFromCache(codiceFiscale, DatiAnagraficiGenerali.class);
			if (datiAnagraficiGenerali == null) {
				datiAnagraficiGenerali = getDatiAnagraficiGenerali(codiceFiscale, codiceIpa);
				cacheService.putInCache(codiceFiscale, datiAnagraficiGenerali);
			}
		}
		else {
			datiAnagraficiGenerali = getDatiAnagraficiGenerali(codiceFiscale, codiceIpa);
		}

		return datiAnagraficiGenerali;
	}

	/**
	 * @param codiceFiscale
	 * @param codiceIpa
	 * @return
	 */
	private DatiAnagraficiGenerali getDatiAnagraficiGenerali(String codiceFiscale, String codiceIpa) {
		it.osapulie.anagrafe.web.ws.output.types.DatiAnagraficiGenerali datiAnagraficiGeneraliRichiesta = new it.osapulie.anagrafe.web.ws.output.types.DatiAnagraficiGenerali();
		datiAnagraficiGeneraliRichiesta.setCodiceFiscale(codiceFiscale);

		ComuneISA comuneISA = comuneISAService.getComuneByCodiceIPA(codiceIpa);

		DatiUtente datiUtente = esegui(RICHIESTA_DATI_ANAGRAFICI_GENERALI, datiAnagraficiGeneraliRichiesta, it.osapulie.anagrafe.web.ws.output.types.DatiUtente.class,
				comuneISA.getUriServizioGateway(), comuneISA.getCanaleIntegrazione());
		DatiAnagraficiGenerali datiAnagraficiGenerali = cripalToDatiAnagraficiGeneraliConverter.convert(datiUtente);
		return datiAnagraficiGenerali;
	}

	@Override
	public DatiElettorali getDatiElettorali(String codiceFiscale, String codiceIpa, String idTransazione, IntegrationPreferences integrationPreferences) {

		DatiElettorali datiElettorali = null;
		boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
		if (usaCache) {
			datiElettorali = cacheService.getFromCache(codiceFiscale, DatiElettorali.class);
			if (datiElettorali == null) {
				datiElettorali = getDatiElettorali(codiceFiscale, codiceIpa);
				cacheService.putInCache(codiceFiscale, datiElettorali);
			}
		}
		else {
			datiElettorali = getDatiElettorali(codiceFiscale, codiceIpa);
		}
		return datiElettorali;
	}

	/**
	 * @param codiceFiscale
	 * @param codiceIpa
	 * @return
	 */
	private DatiElettorali getDatiElettorali(String codiceFiscale, String codiceIpa) {
		RichiestaDatiElettorali richiestaDatiElettorali = new RichiestaDatiElettorali();
		richiestaDatiElettorali.setCodiceFiscale(codiceFiscale);
		ComuneISA comuneISA = comuneISAService.getComuneByCodiceIPA(codiceIpa);
		it.osapulie.anagrafe.web.ws.output.types.DatiElettorali datiElettoraliCripal = esegui(RICHIESTA_DATI_ELETTORALI, richiestaDatiElettorali,
				it.osapulie.anagrafe.web.ws.output.types.DatiElettorali.class, comuneISA.getUriServizioGateway(), comuneISA.getCanaleIntegrazione());
		DatiElettorali datiElettorali = cripalToDatiElettoraliConverter.convert(datiElettoraliCripal);
		return datiElettorali;
	}

	@Override
	public DatiVariazioniDomicilio getDatiVariazioniDomicilio(String codiceFiscale, String codiceIpa, String idTransazione, IntegrationPreferences integrationPreferences) {

		DatiVariazioniDomicilio datiVariazioniDomicilio = null;
		boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
		if (usaCache) {
			datiVariazioniDomicilio = cacheService.getFromCache(codiceFiscale, DatiVariazioniDomicilio.class);
			if (datiVariazioniDomicilio == null) {
				datiVariazioniDomicilio = getDatiVariazioniDomiciliari(codiceFiscale, codiceIpa);
				cacheService.putInCache(codiceFiscale, datiVariazioniDomicilio);
			}
		}
		else {
			datiVariazioniDomicilio = getDatiVariazioniDomiciliari(codiceFiscale, codiceIpa);
		}
		return datiVariazioniDomicilio;

	}

	/**
	 * @param codiceFiscale
	 * @param codiceIpa
	 * @return
	 */
	private DatiVariazioniDomicilio getDatiVariazioniDomiciliari(String codiceFiscale, String codiceIpa) {
		RichiestaVariazioniDomiciliari richiestaVariazioniDomiciliari = new RichiestaVariazioniDomiciliari();
		richiestaVariazioniDomiciliari.setCodiceFiscale(codiceFiscale);
		Calendar now = Calendar.getInstance();
		richiestaVariazioniDomiciliari.setDataFine(now);
		Calendar start = Calendar.getInstance();
		start.set(1900, 1, 1);
		richiestaVariazioniDomiciliari.setDataPartenza(start);
		ComuneISA comuneISA = comuneISAService.getComuneByCodiceIPA(codiceIpa);
		DatiIndirizzo datiIndirizzo = esegui(RICHIESTA_DATI_VARIAZIONI_DOMICILIARI, richiestaVariazioniDomiciliari, DatiIndirizzo.class, comuneISA.getUriServizioGateway(),
				comuneISA.getCanaleIntegrazione());
		DatiVariazioniDomicilio datiVariazioniDomicilio = cripalToDatiVariazioniDomicilioConverter.convert(datiIndirizzo);
		return datiVariazioniDomicilio;
	}

}
