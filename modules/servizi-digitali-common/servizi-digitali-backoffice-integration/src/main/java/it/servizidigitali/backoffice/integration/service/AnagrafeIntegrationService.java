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
public interface AnagrafeIntegrationService {

	/**
	 *
	 * @param codiceFiscale
	 * @param organizationId
	 * @param integrationPreferences
	 * @return
	 */
	DatiAnagrafici getDatiAnagrafici(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences);

	/**
	 *
	 * @param codiceFiscale
	 * @param organizationId
	 * @param integrationPreferences
	 * @return
	 */
	DatiAnagraficiGenerali getDatiAnagraficiGenerali(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences);

	/**
	 *
	 * @param codiceFiscale
	 * @param organizationId
	 * @param integrationPreferences
	 * @return
	 */
	DatiElettorali getDatiElettorali(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences);

	/**
	 *
	 * @param codiceFiscale
	 * @param organizationId
	 * @param integrationPreferences
	 * @return
	 */
	DatiVariazioniDomicilio getDatiVariazioniDomicilio(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences);

}
