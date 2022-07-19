package it.servizidigitali.backoffice.integration.service.anpr;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagraficiGenerali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationService;
import it.servizidigitali.backoffice.integration.service.CacheService;

/**
 * @author pindi
 *
 */
@Component(name = "anagrafeANPRIntegrationService", immediate = true, service = AnagrafeIntegrationService.class)
public class AnagrafeANPRIntegrationServiceImpl implements AnagrafeIntegrationService {

	private static final String ID_TRANSAZIONE_DEFAULT = "999999999";

	private static final Log log = LogFactoryUtil.getLog(AnagrafeANPRIntegrationServiceImpl.class.getName());

	@Reference
	private CacheService cacheService;

	@Override
	public DatiAnagrafici getDatiAnagrafici(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatiAnagraficiGenerali getDatiAnagraficiGenerali(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatiElettorali getDatiElettorali(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatiVariazioniDomicilio getDatiVariazioniDomicilio(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {
		// TODO Auto-generated method stub
		return null;
	}

}
