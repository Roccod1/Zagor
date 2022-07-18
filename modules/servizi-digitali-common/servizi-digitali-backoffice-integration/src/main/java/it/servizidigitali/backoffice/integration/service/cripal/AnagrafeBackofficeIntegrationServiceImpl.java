package it.servizidigitali.backoffice.integration.service.cripal;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import org.apache.xmlbeans.XmlException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.client.BackofficeIntegrationClient;
import it.servizidigitali.backoffice.integration.converter.cripal.CRIPALToDatiAnagraficiConverter;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagraficiGenerali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.AnagrafeBackofficeIntegrationService;
import it.servizidigitali.backoffice.integration.service.CacheService;
import noNamespace.RichiestaDatiAnagraficiDocument;
import noNamespace.RichiestaDatiAnagraficiDocument.RichiestaDatiAnagrafici;
import noNamespace.VisuraAnagraficaDocument;

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

	private static final Log log = LogFactoryUtil.getLog(AnagrafeBackofficeIntegrationServiceImpl.class.getName());

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private CRIPALToDatiAnagraficiConverter cripalToDatiAnagraficiConverter;

	@Reference
	private CacheService cacheService;

	@Reference
	private BackofficeIntegrationClient backofficeIntegrationClient;

	@Override
	public DatiAnagrafici getDatiAnagrafici(String codiceFiscale, long organizationId, String idTransazione, IntegrationPreferences integrationPreferences) {

		DatiAnagrafici datiAnagrafici = null;
		try {
			boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
			if (usaCache) {
				datiAnagrafici = cacheService.getFromCache(codiceFiscale, DatiAnagrafici.class);
				if (datiAnagrafici == null) {
					datiAnagrafici = getDatiAnagrafici(codiceFiscale, organizationId, integrationPreferences);
					cacheService.putInCache(codiceFiscale, datiAnagrafici);
				}
			}
			else {
				datiAnagrafici = getDatiAnagrafici(codiceFiscale, organizationId, integrationPreferences);
			}
		}
		catch (PortalException e) {
			log.error("getDatiAnagrafici :: " + e.getMessage(), e);
		}
		catch (XmlException e) {
			log.error("getDatiAnagrafici :: " + e.getMessage(), e);
		}

		return datiAnagrafici;
	}

	/**
	 * @param codiceFiscale
	 * @param codiceIpa
	 * @param integrationPreferences
	 * @return
	 * @throws XmlException
	 * @throws PortalException
	 */
	private DatiAnagrafici getDatiAnagrafici(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) throws XmlException, PortalException {
		RichiestaDatiAnagraficiDocument richiestaDocument = RichiestaDatiAnagraficiDocument.Factory.newInstance();
		RichiestaDatiAnagrafici richiesta = RichiestaDatiAnagrafici.Factory.newInstance();
		richiesta.setCodiceFiscale(codiceFiscale);
		if (integrationPreferences != null) {
			richiesta.setCodiceServizio(integrationPreferences.getCodiceServizio());
		}

		richiestaDocument.setRichiestaDatiAnagrafici(richiesta);
		Organization organization = organizationLocalService.getOrganization(organizationId);
		String payloadXml = richiestaDocument.toString();
		String wsUrl = organization.getExpandoBridge().getAttribute("uriBackoffice").toString();
		String codiceIstat = organization.getExpandoBridge().getAttribute("codiceISTAT").toString();

		String xmlResponse = backofficeIntegrationClient.sendXml(payloadXml, RICHIESTA_DATI_ANAGRAFICI_CRIPAL, wsUrl, 30000);
		noNamespace.VisuraAnagraficaDocument datiAnagraficiCRIPAL = VisuraAnagraficaDocument.Factory.parse(xmlResponse);

		DatiAnagrafici datiAnagrafici = cripalToDatiAnagraficiConverter.convert(datiAnagraficiCRIPAL.getVisuraAnagrafica(), codiceIstat);
		return datiAnagrafici;
	}

	@Override
	public DatiAnagraficiGenerali getDatiAnagraficiGenerali(String codiceFiscale, long organizationId, String idTransazione, IntegrationPreferences integrationPreferences) {
		// TODO completare
		return null;
	}

	@Override
	public DatiElettorali getDatiElettorali(String codiceFiscale, long organizationId, String idTransazione, IntegrationPreferences integrationPreferences) {
		// TODO completare
		return null;
	}

	@Override
	public DatiVariazioniDomicilio getDatiVariazioniDomicilio(String codiceFiscale, long organizationId, String idTransazione, IntegrationPreferences integrationPreferences) {
		// TODO completare
		return null;

	}

}
