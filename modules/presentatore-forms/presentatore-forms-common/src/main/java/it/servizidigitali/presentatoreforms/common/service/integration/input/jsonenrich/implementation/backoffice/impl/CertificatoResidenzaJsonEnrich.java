package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.common.utility.enumeration.OrganizationCustomAttributes;
import it.servizidigitali.presentatoreforms.common.service.integration.enumeration.BackofficeServiceExceptionLanguageCode;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.util.EnrichmentUtilService;

/**
 * @author ZONNOG
 *
 */
@Component(name = "certificatoResidenzaJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class CertificatoResidenzaJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(CertificatoResidenzaJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;


	private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public final String certificatoResidenzaKey = "certificatoResidenza";
	public final String autorizzazioneKey = "autorizzazione";

	@Override
	public <T> void enrich(EnrichmentModel<T> enrichmentModel) {
		T datiAnagrafici = enrichmentModel.getSourceObject();
		if (datiAnagrafici instanceof DatiAnagrafici) {

			Organization organization;
			try {
				organization = organizationLocalService.getOrganization(enrichmentModel.getOrganizationId());
			}
			catch (PortalException e) {
				log.error("enrich :: " + e.getMessage(), e);
				throw new BackofficeServiceException("Errore durante il caricamento dell'organizzazione " + enrichmentModel.getOrganizationId(), e);
			}
			Comune comuneByCodice = comuneLocalService
					.getComuneByCodiceISTAT(organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_ISTAT.getNomeAttributo()).toString());

			
			// Nucleo familiare
			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleo = ((DatiAnagrafici) datiAnagrafici).getComponentiNucleoFamiliare();

			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiList = null;
			if (enrichmentModel.getUserPreferences().getCodiceFiscaleComponente() != null) {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equalsIgnoreCase(enrichmentModel.getUserPreferences().getCodiceFiscaleComponente())).collect(Collectors.toList());
			}
			else {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equalsIgnoreCase(enrichmentModel.getUserPreferences().getCodiceFiscaleRichiedente())).collect(Collectors.toList());
			}
			if (componentiList.size() == 1) {
				DatiAnagrafici.ComponenteNucleoFamiliare componente = componentiList.get(0);

				JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();

				String certificatoResidenzaNameContainer = certificatoResidenzaKey;
				if (certificatoResidenzaNameContainer != null) {

					JsonObject certificatoResidenzaContainer = alpacaJsonData.getAsJsonObject(certificatoResidenzaNameContainer);
					if (certificatoResidenzaContainer != null) {

						// Condizioni scaricamento certificato
						if (componente.getDataMorte() != null) {
							throw new BackofficeServiceException(BackofficeServiceExceptionLanguageCode.SOGGETTO_DECEDUTO_CERTIFICATO_NON_DISPONIBILE);
						}

						// Nome e Cognome
						String nome = componente.getNome();
						String cognome = componente.getCognome();
						String nomeCognome = nome + ' ' + cognome;
						certificatoResidenzaContainer.addProperty("nomeCognome", nomeCognome);

						// Codice Fiscale
						String codiceFiscale = "Cod. Fisc " + componente.getCodiceFiscale();
						certificatoResidenzaContainer.addProperty("codiceFiscale", codiceFiscale);

						// Data e luogo nascita //
						String rigaNascita = EnrichmentUtilService.getBornLabelByGenderDichiarante(componente) + "il ";
						rigaNascita = rigaNascita + EnrichmentUtilService.getDataNascitaComponente(componente) + " a ";

						// TODO va controllata la cittadinanza e mostrato il comune italiano o
						// estero a
						// seconda dei casi o si dà per scontata cittadinanza italiana?
						String nomeComuneNascita = "";
						String siglaProvinciaNascita = "";

						String codiceIstat = componente.getCodiceIstatComuneNascita();
						if (codiceIstat != null) {
							Comune comune = comuneLocalService.getComuneByCodiceISTAT(codiceIstat);
							if (comune != null) {
								nomeComuneNascita = comune.getDenominazione();
								rigaNascita = rigaNascita + nomeComuneNascita;
								Provincia provincia = comune.getProvincia();
								if (provincia != null) {
									siglaProvinciaNascita = provincia.getSigla();
									rigaNascita = rigaNascita + " (" + siglaProvinciaNascita + ")";
								}
							}
							else {
								try {
									ComuneEstero comuneEstero = comuneEsteroLocalService.getComuneEsteroByCodice(Integer.parseInt(codiceIstat));
									rigaNascita = rigaNascita + comuneEstero.getDenominazione();
								}
								catch (Exception e) {
									rigaNascita = "";
								}
							}
						}
						else {

							if (componente.getDescrizioneComuneEsteroNascita() != null) {
								nomeComuneNascita = componente.getDescrizioneComuneEsteroNascita();
								rigaNascita = rigaNascita + nomeComuneNascita;
								if (componente.getCodiceStatoEsteroNascita() != null) {
									StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
									nomeComuneNascita = nomeComuneNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
									rigaNascita = rigaNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
								}
							}
							else if (componente.getCodiceStatoEsteroNascita() != null) {
								StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
								rigaNascita = rigaNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
							}
						}
						certificatoResidenzaContainer.addProperty("dataComuneNascita", rigaNascita);

						String indirizzo = ((DatiAnagrafici) datiAnagrafici).getDescrizioneVia();

						if (indirizzo != null) {

							// Comune residenza
							if (comuneByCodice != null) {

								if (((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() != null) {
									indirizzo = ((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() + " " + indirizzo;
								}

								// numero civico
								String numeroCivico = ((DatiAnagrafici) datiAnagrafici).getNumeroCivico();
								if (numeroCivico != null) {
									numeroCivico = ", n. " + numeroCivico;
								}
								else {
									numeroCivico = "";
								}
								// esponente
								String esponente = ((DatiAnagrafici) datiAnagrafici).getEsponente();
								if (esponente != null) {
									esponente = " " + esponente;
								}
								else {
									esponente = "";
								}
								// scala
								String scala = ((DatiAnagrafici) datiAnagrafici).getScala();
								if (scala != null) {
									scala = ", Scala: " + scala;
								}
								else {
									scala = "";
								}
								// piano
								String piano = ((DatiAnagrafici) datiAnagrafici).getPiano();
								if (piano != null) {
									piano = ", Piano: " + piano;
								}
								else {
									piano = "";
								}
								// interno
								String interno = ((DatiAnagrafici) datiAnagrafici).getInterno();
								if (interno != null) {
									interno = ", Int. " + interno;
								}
								else {
									interno = "";
								}
								certificatoResidenzaContainer.addProperty("indirizzoResidenza", indirizzo + numeroCivico + esponente + scala + piano + interno);
							}
						}
						// cittaEmissione + Data odierna

						String citta = organization.getName().toUpperCase();
						Date today = new Date();
						String dftoday = df.format(today);
						String cittaEmissione = "<h4><br> " + citta + ", " + dftoday + "</h4>";
						certificatoResidenzaContainer.addProperty("cittaEmissione", cittaEmissione);

						// Salvataggio
						alpacaJsonData.add(certificatoResidenzaKey, certificatoResidenzaContainer);
						enrichmentModel.setAlpacaJsonData(alpacaJsonData);
					}

				}
			}
		}
	}
}
