package it.servizidigitali.backoffice.integration.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.enums.RelazioneParentela;
import it.servizidigitali.backoffice.integration.enums.StatoCivile;
import it.servizidigitali.backoffice.integration.enums.TipoIntegrazione;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.model.commmon.ComponenteNucleoFamiliare;
import it.servizidigitali.backoffice.integration.model.commmon.IntegrationPreferences;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationService;
import it.servizidigitali.backoffice.integration.service.DatiAnagraficiPortletService;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.common.utility.enumeration.OrganizationCustomAttributes;

/**
 * Implementazione di {@link DatiAnagraficiPortletService} che si occupa di caricare i componenti
 * nucleo familiare da backoffice, se disponibili, oppure da sistema (se presenti).
 *
 * @author pindi
 *
 */
@Component(name = "datiAnagraficiPortletService", immediate = true, service = DatiAnagraficiPortletService.class)
public class DatiAnagraficiPortletServiceImpl implements DatiAnagraficiPortletService {

	private static final Log log = LogFactoryUtil.getLog(DatiAnagraficiPortletServiceImpl.class.getName());

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private AnagrafeIntegrationService anagrafeIntegrationService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	@Override
	public List<ComponenteNucleoFamiliare> getComponentiNucleoFamiliare(String codiceFiscale, long organizationId, IntegrationPreferences integrationPreferences) {

		List<ComponenteNucleoFamiliare> componentiNucleoFamiliare = null;
		try {
			Organization organization = organizationLocalService.getOrganization(organizationId);
			String wsUrl = organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.URI_BACKOFFICE.getNomeAttributo()).toString();
			componentiNucleoFamiliare = null;

			if (Validator.isNotNull(wsUrl)) {
				componentiNucleoFamiliare = getComponentiNucleoFamiliareBackoffice(codiceFiscale, organization, integrationPreferences);
			}
			else {
				componentiNucleoFamiliare = getComponentiNucleoFamiliareDB(codiceFiscale);
			}
		}
		catch (PortalException e) {
			log.error("getComponentiNucleoFamiliare :: " + e.getMessage(), e);
		}
		return componentiNucleoFamiliare;
	}

	private List<ComponenteNucleoFamiliare> getComponentiNucleoFamiliareBackoffice(String codiceFiscale, Organization organization, IntegrationPreferences integrationPreferences) {

		List<ComponenteNucleoFamiliare> componentiNucleoFamiliare = null;
		if (organization != null) {

			String anpr = organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.ANPR.getNomeAttributo()).toString();
			String tipoIntegrazioneExpando = organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.TIPO_INTEGRAZIONE.getNomeAttributo()).toString();

			TipoIntegrazione tipoIntegrazione = TipoIntegrazione.valueOf(tipoIntegrazioneExpando);
			if (Boolean.parseBoolean(anpr)) {
				tipoIntegrazione = TipoIntegrazione.ANPR;
			}
			switch (tipoIntegrazione) {
			case CRIPAL:
				DatiAnagrafici datiAnagraficiFromBackoffice = anagrafeIntegrationService.getDatiAnagrafici(codiceFiscale, organization.getOrganizationId(), integrationPreferences);
				if (datiAnagraficiFromBackoffice != null) {
					componentiNucleoFamiliare = getComponentiNucleoFamiliare(organization, datiAnagraficiFromBackoffice);
				}
				break;
			case ANPR:
				// DatiAnagrafici datiAnagraficiFromANPR =
				// anagrafeANPRBackofficeIntegrationService.getDatiAnagrafici(codiceFiscale,
				// organization.getOrganizationId(), integrationPreferences);
				// if (datiAnagraficiFromANPR != null) {
				// componentiNucleoFamiliare = getComponentiNucleoFamiliare(organization,
				// datiAnagraficiFromANPR);
				// }
				break;
			default:
				break;
			}
		}
		return componentiNucleoFamiliare;
	}

	private List<ComponenteNucleoFamiliare> getComponentiNucleoFamiliare(Organization organization, DatiAnagrafici datiAnagrafici) {

		List<ComponenteNucleoFamiliare> componentiNucleoFamiliare = null;

		List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleoFamiliareBackoffice = datiAnagrafici.getComponentiNucleoFamiliare();
		if (componentiNucleoFamiliareBackoffice != null) {
			componentiNucleoFamiliare = new ArrayList<>();
			for (it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici.ComponenteNucleoFamiliare componenteNucleoFamiliareBackoffice : componentiNucleoFamiliareBackoffice) {

				// Caricamento tutti componenti
				ComponenteNucleoFamiliare componenteNucleoFamiliare = new ComponenteNucleoFamiliare();
				componenteNucleoFamiliare.setCodiceFiscale(componenteNucleoFamiliareBackoffice.getCodiceFiscale());
				componenteNucleoFamiliare.setCognome(componenteNucleoFamiliareBackoffice.getCognome());
				componenteNucleoFamiliare.setNome(componenteNucleoFamiliareBackoffice.getNome());
				componenteNucleoFamiliare.setSesso(componenteNucleoFamiliareBackoffice.getSesso());
				componenteNucleoFamiliare.setDataNascita(componenteNucleoFamiliareBackoffice.getDataNascita());
				componenteNucleoFamiliare.setIdentificativoNucleo(componenteNucleoFamiliareBackoffice.getIdentificativo());
				StatoCivile statoCivile = componenteNucleoFamiliareBackoffice.getStatoCivile();
				if (statoCivile != null) {
					try {
						componenteNucleoFamiliare.setStatoCivile(statoCivile.getDescrizione());
					}
					catch (IllegalArgumentException e) {
						log.warn("getComponentiNucleoFamiliare :: " + e.getMessage());
					}
				}
				componenteNucleoFamiliare.setCittadinanzaItaliana(componenteNucleoFamiliareBackoffice.isCittadinanzaItaliana());
				Integer codiceStatoEsteroNascita = componenteNucleoFamiliareBackoffice.getCodiceStatoEsteroNascita();
				if (codiceStatoEsteroNascita != null) {
					StatoEstero statoEstero = statoEsteroLocalService.getStatoEsteroByCodiceStato(codiceStatoEsteroNascita);
					if (statoEstero != null) {
						componenteNucleoFamiliare.setCodiceStatoEsteroNascita(String.valueOf(statoEstero.getCodiceStato()));
						componenteNucleoFamiliare.setNomeStatoEsteroNascita(statoEstero.getDenominazione());
					}
				}
				else {
					String descrizioneStatoEsteroNascita = componenteNucleoFamiliareBackoffice.getDescrizioneStatoEsteroNascita();
					if (descrizioneStatoEsteroNascita != null && !descrizioneStatoEsteroNascita.isEmpty()) {
						StatoEstero statoEstero = statoEsteroLocalService.getStatoEsteroByDenominazione(descrizioneStatoEsteroNascita);
						if (statoEstero != null) {
							componenteNucleoFamiliare.setCodiceStatoEsteroNascita(String.valueOf(statoEstero.getCodiceStato()));
							componenteNucleoFamiliare.setNomeStatoEsteroNascita(statoEstero.getDenominazione());
						}
						else {
							componenteNucleoFamiliare.setNomeStatoEsteroNascita(descrizioneStatoEsteroNascita);
						}

					}
				}

				// Comune Nascita
				String codiceIstatComuneNascita = componenteNucleoFamiliareBackoffice.getCodiceIstatComuneNascita();

				// Caricamento Provincia Nascita da codice ISTAT
				if (codiceIstatComuneNascita != null) {
					componenteNucleoFamiliare.setCodiceIstatComuneNascita(codiceIstatComuneNascita);

					if (componenteNucleoFamiliare.getCodiceStatoEsteroNascita() == null) {
						Comune comuneNascita = comuneLocalService.getComuneByCodiceISTAT(codiceIstatComuneNascita);
						if (comuneNascita != null) {
							componenteNucleoFamiliare.setCodiceIstatComuneNascita(comuneNascita.getCodiceIstatAN());
						}
					}
					else {
						try {
							ComuneEstero comuneEsteroByCodice = comuneEsteroLocalService.getComuneEsteroByCodice(Integer.parseInt(codiceIstatComuneNascita));
							componenteNucleoFamiliare.setNomeComuneNascita(comuneEsteroByCodice.getDenominazione());
							componenteNucleoFamiliare.setCodiceIstatComuneNascita(codiceIstatComuneNascita);
						}
						catch (Exception e) {
							log.warn("getComponentiNucleoFamiliare :: " + e.getMessage());
						}
						if (componenteNucleoFamiliare.getNomeComuneNascita() == null) {
							componenteNucleoFamiliare.setNomeComuneNascita(componenteNucleoFamiliareBackoffice.getDescrizioneComuneEsteroNascita());
						}
					}
				}

				// Comune Residenza
				if (organization != null) {
					String codiceISTAT = organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_ISTAT.getNomeAttributo()).toString();
					componenteNucleoFamiliare.setCodiceIstatComuneResidenza(codiceISTAT);
				}

				// Residenza
				String indirizzoResidenza = datiAnagrafici.getDescrizioneVia();
				if (datiAnagrafici.getToponimoIndirizzo() != null) {
					indirizzoResidenza = datiAnagrafici.getToponimoIndirizzo() + " " + datiAnagrafici.getDescrizioneVia();
				}
				componenteNucleoFamiliare.setIndirizzoResidenza(indirizzoResidenza);
				componenteNucleoFamiliare.setCivicoResidenza(datiAnagrafici.getNumeroCivico());
				componenteNucleoFamiliare.setCapResidenza(datiAnagrafici.getCap());
				componenteNucleoFamiliare.setPianoResidenza(datiAnagrafici.getPiano());
				componenteNucleoFamiliare.setScalaResidenza(datiAnagrafici.getScala());
				componenteNucleoFamiliare.setInternoResidenza(datiAnagrafici.getInterno());
				componenteNucleoFamiliare.setCodiceViaResidenza(datiAnagrafici.getCodiceVia());
				// Telefono
				componenteNucleoFamiliare.setTelefono(null);
				// Relazione di parentela
				RelazioneParentela relazioneParentela = componenteNucleoFamiliareBackoffice.getRelazioneParentela();
				if (relazioneParentela != null) {
					try {
						componenteNucleoFamiliare.setRelazioneParentela(relazioneParentela.getDescrizione());
					}
					catch (IllegalArgumentException e) {
						log.warn("getComponentiNucleoFamiliare :: " + e.getMessage());
					}
				}
				componenteNucleoFamiliare.setDataMorte(componenteNucleoFamiliareBackoffice.getDataMorte());
				componentiNucleoFamiliare.add(componenteNucleoFamiliare);
			}
		}
		return componentiNucleoFamiliare;
	}

	/**
	 * @param codiceFiscale
	 * @return
	 */
	private List<ComponenteNucleoFamiliare> getComponentiNucleoFamiliareDB(String codiceFiscale) {
		// TODO Auto-generated method stub
		return null;
	}
}
