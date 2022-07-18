package it.servizidigitali.backoffice.integration.service.impl.cripal;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import org.apache.xmlbeans.XmlException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.client.BackofficeIntegrationClient;
import it.servizidigitali.backoffice.integration.converter.cripal.DatiAnagraficiConverter;
import it.servizidigitali.backoffice.integration.converter.cripal.DatiAnagraficiGeneraliConverter;
import it.servizidigitali.backoffice.integration.converter.cripal.DatiElettoraliConverter;
import it.servizidigitali.backoffice.integration.converter.cripal.DatiVariazioniDomicilioConverter;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagraficiGenerali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationService;
import it.servizidigitali.backoffice.integration.service.CacheService;
import noNamespace.DatiAnagraficiGeneraliDocument;
import noNamespace.DatiElettoraliDocument;
import noNamespace.DatiUtenteDocument;
import noNamespace.RichiestaDatiAnagraficiDocument;
import noNamespace.RichiestaDatiAnagraficiDocument.RichiestaDatiAnagrafici;
import noNamespace.RichiestaDatiElettoraliDocument;
import noNamespace.RichiestaVariazioniDomiciliariDocument;
import noNamespace.VariazioniDomiciliariDocument;
import noNamespace.VisuraAnagraficaDocument;

/**
 * @author pindi
 *
 */
@Component(name = "anagrafeBackofficeIntegrationService", immediate = true, service = AnagrafeIntegrationService.class)
public class AnagrafeBackofficeIntegrationServiceImpl implements AnagrafeIntegrationService {

	private static final String RICHIESTA_DATI_ANAGRAFICI_CRIPAL = "richiestaDatiAnagrafici";
	private static final String RICHIESTA_DATI_ANAGRAFICI_GENERALI = "datiAnagraficiGenerali";
	private static final String RICHIESTA_DATI_ELETTORALI = "richiestaDatiElettorali";
	private static final String RICHIESTA_DATI_VARIAZIONI_DOMICILIARI = "richiestaVariazioniDomiciliari";

	private static final Log log = LogFactoryUtil.getLog(AnagrafeBackofficeIntegrationServiceImpl.class.getName());

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private DatiAnagraficiConverter datiAnagraficiConverter;

	@Reference
	private DatiAnagraficiGeneraliConverter datiAnagraficiGeneraliConverter;

	@Reference
	private DatiElettoraliConverter datiElettoraliConverter;

	@Reference
	private DatiVariazioniDomicilioConverter datiVariazioniDomicilioConverter;

	@Reference
	private CacheService cacheService;

	@Reference
	private BackofficeIntegrationClient backofficeIntegrationClient;

	@Override
	public DatiAnagrafici getDatiAnagrafici(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		DatiAnagrafici datiAnagrafici = null;
		try {
			boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
			if (usaCache) {
				datiAnagrafici = cacheService.getFromCache(codiceFiscale, DatiAnagrafici.class);
				if (datiAnagrafici == null) {
					datiAnagrafici = getDatiAnagraficiPrivate(codiceFiscale, organizationId, integrationPreferences);
					cacheService.putInCache(codiceFiscale, datiAnagrafici);
				}
			}
			else {
				datiAnagrafici = getDatiAnagraficiPrivate(codiceFiscale, organizationId, integrationPreferences);
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
	private DatiAnagrafici getDatiAnagraficiPrivate(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) throws XmlException, PortalException {

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

		DatiAnagrafici datiAnagrafici = datiAnagraficiConverter.convert(datiAnagraficiCRIPAL.getVisuraAnagrafica(), codiceIstat);
		return datiAnagrafici;
	}

	@Override
	public DatiAnagraficiGenerali getDatiAnagraficiGenerali(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		DatiAnagraficiGenerali datiAnagraficiGenerali = null;
		try {
			boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
			if (usaCache) {
				datiAnagraficiGenerali = cacheService.getFromCache(codiceFiscale, DatiAnagraficiGenerali.class);
				if (datiAnagraficiGenerali == null) {
					datiAnagraficiGenerali = getDatiAnagraficiGeneraliPrivate(codiceFiscale, organizationId, integrationPreferences);
					cacheService.putInCache(codiceFiscale, datiAnagraficiGenerali);
				}
			}
			else {
				datiAnagraficiGenerali = getDatiAnagraficiGeneraliPrivate(codiceFiscale, organizationId, integrationPreferences);
			}
		}
		catch (PortalException e) {
			log.error("getDatiAnagraficiGenerali :: " + e.getMessage(), e);
		}
		catch (XmlException e) {
			log.error("getDatiAnagraficiGenerali :: " + e.getMessage(), e);
		}
		return datiAnagraficiGenerali;
	}

	/**
	 * @param codiceFiscale
	 * @param organizationId
	 * @param integrationPreferences
	 * @return
	 */
	private DatiAnagraficiGenerali getDatiAnagraficiGeneraliPrivate(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) throws XmlException, PortalException {

		DatiAnagraficiGeneraliDocument richiestaDocument = DatiAnagraficiGeneraliDocument.Factory.newInstance();
		noNamespace.DatiAnagraficiGeneraliDocument.DatiAnagraficiGenerali richiesta = noNamespace.DatiAnagraficiGeneraliDocument.DatiAnagraficiGenerali.Factory.newInstance();
		richiesta.setCodiceFiscale(codiceFiscale);

		richiestaDocument.setDatiAnagraficiGenerali(richiesta);
		Organization organization = organizationLocalService.getOrganization(organizationId);
		String payloadXml = richiestaDocument.toString();
		String wsUrl = organization.getExpandoBridge().getAttribute("uriBackoffice").toString();

		String xmlResponse = backofficeIntegrationClient.sendXml(payloadXml, RICHIESTA_DATI_ANAGRAFICI_GENERALI, wsUrl, 30000);
		noNamespace.DatiUtenteDocument datiUtenteDocument = DatiUtenteDocument.Factory.parse(xmlResponse);

		DatiAnagraficiGenerali datiAnagraficiGenerali = datiAnagraficiGeneraliConverter.convert(datiUtenteDocument.getDatiUtente());
		return datiAnagraficiGenerali;
	}

	@Override
	public DatiElettorali getDatiElettorali(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		DatiElettorali datiElettorali = null;
		try {
			boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
			if (usaCache) {
				datiElettorali = cacheService.getFromCache(codiceFiscale, DatiElettorali.class);
				if (datiElettorali == null) {
					datiElettorali = getDatiElettoraliPrivate(codiceFiscale, organizationId, integrationPreferences);
					cacheService.putInCache(codiceFiscale, datiElettorali);
				}
			}
			else {
				datiElettorali = getDatiElettoraliPrivate(codiceFiscale, organizationId, integrationPreferences);
			}
		}
		catch (PortalException e) {
			log.error("getDatiElettorali :: " + e.getMessage(), e);
		}
		catch (XmlException e) {
			log.error("getDatiElettorali :: " + e.getMessage(), e);
		}
		return datiElettorali;
	}

	/**
	 * @param codiceFiscale
	 * @param organizationId
	 * @param integrationPreferences
	 * @return
	 */
	private DatiElettorali getDatiElettoraliPrivate(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) throws XmlException, PortalException {

		RichiestaDatiElettoraliDocument richiestaDocument = RichiestaDatiElettoraliDocument.Factory.newInstance();
		noNamespace.RichiestaDatiElettoraliDocument.RichiestaDatiElettorali richiesta = noNamespace.RichiestaDatiElettoraliDocument.RichiestaDatiElettorali.Factory.newInstance();
		richiesta.setCodiceFiscale(codiceFiscale);

		richiestaDocument.setRichiestaDatiElettorali(richiesta);
		Organization organization = organizationLocalService.getOrganization(organizationId);
		String payloadXml = richiestaDocument.toString();
		String wsUrl = organization.getExpandoBridge().getAttribute("uriBackoffice").toString();

		String xmlResponse = backofficeIntegrationClient.sendXml(payloadXml, RICHIESTA_DATI_ELETTORALI, wsUrl, 30000);
		noNamespace.DatiElettoraliDocument datiElettoraliDocument = DatiElettoraliDocument.Factory.parse(xmlResponse);

		DatiElettorali datiElettorali = datiElettoraliConverter.convert(datiElettoraliDocument.getDatiElettorali());
		return datiElettorali;
	}

	@Override
	public DatiVariazioniDomicilio getDatiVariazioniDomicilio(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		DatiVariazioniDomicilio datiVariazioniDomicilio = null;
		try {
			boolean usaCache = integrationPreferences == null || integrationPreferences.isUsaCache();
			if (usaCache) {
				datiVariazioniDomicilio = cacheService.getFromCache(codiceFiscale, DatiVariazioniDomicilio.class);
				if (datiVariazioniDomicilio == null) {
					datiVariazioniDomicilio = getDatiVariazioniDomicilioPrivate(codiceFiscale, organizationId, integrationPreferences);
					cacheService.putInCache(codiceFiscale, datiVariazioniDomicilio);
				}
			}
			else {
				datiVariazioniDomicilio = getDatiVariazioniDomicilioPrivate(codiceFiscale, organizationId, integrationPreferences);
			}
		}
		catch (PortalException e) {
			log.error("getDatiVariazioniDomicilio :: " + e.getMessage(), e);
		}
		catch (XmlException e) {
			log.error("getDatiVariazioniDomicilio :: " + e.getMessage(), e);
		}
		return datiVariazioniDomicilio;

	}

	/**
	 * @param codiceFiscale
	 * @param organizationId
	 * @param integrationPreferences
	 * @return
	 */
	private DatiVariazioniDomicilio getDatiVariazioniDomicilioPrivate(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) throws XmlException, PortalException {

		RichiestaVariazioniDomiciliariDocument richiestaDocument = RichiestaVariazioniDomiciliariDocument.Factory.newInstance();
		noNamespace.RichiestaVariazioniDomiciliariDocument.RichiestaVariazioniDomiciliari richiesta = noNamespace.RichiestaVariazioniDomiciliariDocument.RichiestaVariazioniDomiciliari.Factory
				.newInstance();
		richiesta.setCodiceFiscale(codiceFiscale);

		richiestaDocument.setRichiestaVariazioniDomiciliari(richiesta);
		Organization organization = organizationLocalService.getOrganization(organizationId);
		String payloadXml = richiestaDocument.toString();
		String wsUrl = organization.getExpandoBridge().getAttribute("uriBackoffice").toString();

		String xmlResponse = backofficeIntegrationClient.sendXml(payloadXml, RICHIESTA_DATI_VARIAZIONI_DOMICILIARI, wsUrl, 30000);
		noNamespace.VariazioniDomiciliariDocument variazioniDomiciliariDocument = VariazioniDomiciliariDocument.Factory.parse(xmlResponse);

		DatiVariazioniDomicilio datiVariazioniDomicilio = datiVariazioniDomicilioConverter.convert(variazioniDomiciliariDocument.getVariazioniDomiciliari());
		return datiVariazioniDomicilio;
	}

}
