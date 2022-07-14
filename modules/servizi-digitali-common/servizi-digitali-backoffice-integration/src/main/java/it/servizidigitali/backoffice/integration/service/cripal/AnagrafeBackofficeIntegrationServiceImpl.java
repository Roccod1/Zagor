package it.servizidigitali.backoffice.integration.service.cripal;

import com.liferay.portal.kernel.service.OrganizationLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.osapulie.anagrafe.output.types.RichiestaDatiAnagraficiDocument.RichiestaDatiAnagrafici;
import it.osapulie.anagrafe.output.types.impl.RichiestaDatiAnagraficiDocumentImpl;
import it.servizidigitali.backoffice.integration.converter.cripal.CRIPALToDatiAnagraficiConverter;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagraficiGenerali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.AnagrafeBackofficeIntegrationService;
import it.servizidigitali.backoffice.integration.service.CacheService;

/**
 * @author pindi
 *
 */
@Component(name = "anagrafeCRIPALBackofficeIntegrationService", immediate = true, service = AnagrafeBackofficeIntegrationService.class)
public class AnagrafeBackofficeIntegrationServiceImpl implements AnagrafeBackofficeIntegrationService {

	private static final String RICHIESTA_DATI_ANAGRAFICI_CRIPAL = "richiestaDatiAnagrafici";
	private static final String RICHIESTA_DATI_ANAGRAFICI_GENERALI = "datiAnagraficiGenerali";
	private static final String RICHIESTA_DATI_ELETTORALI = "richiestaDatiElettorali";
	private static final String RICHIESTA_DATI_VARIAZIONI_DOMICILIARI = "richiestaVariazioniDomiciliari";

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private CRIPALToDatiAnagraficiConverter cripalToDatiAnagraficiConverter;

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
		RichiestaDatiAnagrafici richiesta = new RichiestaDatiAnagraficiDocumentImpl.RichiestaDatiAnagraficiImpl(RichiestaDatiAnagrafici.type);
		richiesta.setCodiceFiscale(codiceFiscale);
		if (integrationPreferences != null) {
			richiesta.setCodiceServizio(integrationPreferences.getCodiceServizio());
		}
		// Organization organization = organizationLocalService.getOrganization(1L);
		//
		//
		//
		// it.osapulie.anagrafe.web.ws.output.types.DatiAnagrafici datiAnagraficiCRIPAL =
		// esegui(RICHIESTA_DATI_ANAGRAFICI_CRIPAL, richiesta,
		// it.osapulie.anagrafe.web.ws.output.types.DatiAnagrafici.class,
		// comuneISA.getUriServizioGateway(), comuneISA.getCanaleIntegrazione());
		// DatiAnagrafici datiAnagrafici =
		// cripalToDatiAnagraficiConverter.convert(datiAnagraficiCRIPAL,
		// comuneISA.getCodiceIstat());
		return null;
	}

	@Override
	public DatiAnagraficiGenerali getDatiAnagraficiGenerali(String codiceFiscale, String codiceIpa, String idTransazione, IntegrationPreferences integrationPreferences) {
		// TODO completare
		return null;
	}

	@Override
	public DatiElettorali getDatiElettorali(String codiceFiscale, String codiceIpa, String idTransazione, IntegrationPreferences integrationPreferences) {
		// TODO completare
		return null;
	}

	@Override
	public DatiVariazioniDomicilio getDatiVariazioniDomicilio(String codiceFiscale, String codiceIpa, String idTransazione, IntegrationPreferences integrationPreferences) {
		// TODO completare
		return null;

	}

}
