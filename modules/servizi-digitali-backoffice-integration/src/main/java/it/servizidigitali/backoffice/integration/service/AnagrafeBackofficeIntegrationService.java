package it.servizidigitali.backoffice.integration.service;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagraficiGenerali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;

/**
 * @author pindi
 *
 */
public interface AnagrafeBackofficeIntegrationService {

	/**
	 *
	 * @param codiceFiscale
	 * @param codiceIpa
	 * @param idTransazione
	 * @param integrationPreferences
	 * @return
	 */
	DatiAnagrafici getDatiAnagrafici(String codiceFiscale, String codiceIpa, String idTransazione, IntegrationPreferences integrationPreferences);

	/**
	 *
	 * @param codiceFiscale
	 * @param codiceIpa
	 * @param idTransazione
	 * @return
	 */
	DatiAnagraficiGenerali getDatiAnagraficiGenerali(String codiceFiscale, String codiceIpa, String idTransazione, IntegrationPreferences integrationPreferences);

	/**
	 *
	 * @param codiceFiscale
	 * @param codiceIpa
	 * @param idTransazione
	 * @return
	 */
	DatiElettorali getDatiElettorali(String codiceFiscale, String codiceIpa, String idTransazione, IntegrationPreferences integrationPreferences);

	/**
	 *
	 * @param codiceFiscale
	 * @param codiceIpa
	 * @param idTransazione
	 * @return
	 */
	DatiVariazioniDomicilio getDatiVariazioniDomicilio(String codiceFiscale, String codiceIpa, String idTransazione, IntegrationPreferences integrationPreferences);

}
