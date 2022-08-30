/************************************************************************************
 * Copyright (c) 2011, 2019 Link Management & Technology S.p.A. via R. Scotellaro, 55 73100 - Lecce
 * - http://www.linksmt.it - All rights reserved.
 *
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *************************************************************************************/
package it.servizidigitali.presentatoreforms.frontend.service.input;

import java.util.List;

import it.servizidigitali.backoffice.integration.enums.TipoIntegrazione;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.presentatoreforms.frontend.model.ComponenteNucleoFamiliareModel;
import it.servizidigitali.presentatoreforms.frontend.service.input.jsonenrich.model.UserPreferences;

/**
 * @author Gianluca Pindinelli
 *
 */
public interface NucleoFamiliareIntegrationService {

	/**
	 * Ritorna la tipologia di integrazione.
	 *
	 * @return
	 */
	TipoIntegrazione getIntegrationType();

	/**
	 *
	 * @param userPreferences
	 * @param integrationPreferences
	 * @return
	 */
	List<ComponenteNucleoFamiliareModel> getComponentiNucleoFamiliare(UserPreferences userPreferences, IntegrationPreferences integrationPreferences);

}
