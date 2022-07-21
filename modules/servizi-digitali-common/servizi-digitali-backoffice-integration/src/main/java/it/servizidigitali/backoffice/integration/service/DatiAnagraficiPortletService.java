package it.servizidigitali.backoffice.integration.service;

import java.util.List;

import it.servizidigitali.backoffice.integration.model.commmon.ComponenteNucleoFamiliare;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;

/**
 * @author pindi
 *
 */
public interface DatiAnagraficiPortletService {

	/**
	 * Ritorna i componenti nucleo familiare sulla base del Comune ISA (in base al tipo di
	 * integrazione configurato) e dell'utente passati in input. Se il Comune passato in input non
	 * ha nessuna tipologia di integrazione allora ritorna i componenti salvati nel sistema (se
	 * presenti).
	 *
	 * @param codiceFiscale
	 * @param organizationId
	 * @return
	 */
	List<ComponenteNucleoFamiliare> getComponentiNucleoFamiliare(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences);

}
