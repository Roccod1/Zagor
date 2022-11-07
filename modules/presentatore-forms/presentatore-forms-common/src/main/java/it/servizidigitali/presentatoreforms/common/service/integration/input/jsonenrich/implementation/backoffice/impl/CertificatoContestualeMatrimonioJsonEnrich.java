package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.enums.StatoCivile;
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
@Component(name = "certificatoContestualeMatrimonioJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class CertificatoContestualeMatrimonioJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(CertificatoContestualeMatrimonioJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public final String datiAnagraficiKey = "datiAnagraficiCCM";
	public final String certificatoContestualeMatrimonioKey = "certificatoContestualeMatrimonio";

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

				JsonObject datiAnagraficiContainer = alpacaJsonData.getAsJsonObject(datiAnagraficiKey);
				if (datiAnagraficiContainer != null) {

					// Controllo scaricamento certificato
					if (componente.getStatoCivile() != null && componente.getStatoCivile().equals(StatoCivile.CONIUGATO_CONIUGATA)) {
						throw new BackofficeServiceException(BackofficeServiceExceptionLanguageCode.SOGGETTO_CONIUGATO);
					}
					// Nome e Cognome
					String nome = componente.getNome();
					String cognome = componente.getCognome();
					String nomeCognome = nome + ' ' + cognome;
					datiAnagraficiContainer.addProperty("nomeCognome", nomeCognome);

					// Codice Fiscale
					String codiceFiscale = "Cod. Fisc " + componente.getCodiceFiscale();
					datiAnagraficiContainer.addProperty("codiceFiscale", codiceFiscale);

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
					datiAnagraficiContainer.addProperty("dataComuneNascita", rigaNascita);

					// Atto
					String infoNascita = "atto N. " + componente.getNumeroAttoNascita();
					String serie = "--";
					String parte = "--";

					if (!Validator.isBlank(componente.getParteAttoNascita())) {
						parte = componente.getParteAttoNascita();
					}
					if (!Validator.isBlank(componente.getSerieAttoNascita())) {
						serie = componente.getSerieAttoNascita();
					}

					infoNascita = infoNascita + " p. " + parte + " s. " + serie;
					datiAnagraficiContainer.addProperty("atto", infoNascita);

					alpacaJsonData.add(datiAnagraficiKey, datiAnagraficiContainer);
				}

				JsonObject certificatoContestualeMatrimonioContainer = alpacaJsonData.getAsJsonObject(certificatoContestualeMatrimonioKey);
				// Custom field
				if (certificatoContestualeMatrimonioContainer != null) {
					// Cittadinanza
					String statoEsteroNascita = null;
					Integer codiceStatoEsteroNascita = componente.getCodiceStatoEsteroNascita();
					if (codiceStatoEsteroNascita == null || codiceStatoEsteroNascita == 100) {
						statoEsteroNascita = "";
						String cittadinanza = "E' CITTADINO ITALIANO";
						certificatoContestualeMatrimonioContainer.addProperty("cittadinanza", cittadinanza);
					}
					else {
						statoEsteroNascita = statoEsteroLocalService.getStatoEsteroByCodiceStato(codiceStatoEsteroNascita).getDenominazione();
						String cittadinanza = "E' CITTADINO" + statoEsteroNascita.toUpperCase();
						certificatoContestualeMatrimonioContainer.addProperty("cittadinanza", cittadinanza);
					}

					// StatoCivile
					String statoCivile = "Stato Civile ";
					if (componente.getStatoCivile() != null) {
						statoCivile = statoCivile + componente.getStatoCivile().getDescrizione();
					}
					certificatoContestualeMatrimonioContainer.addProperty("statoCivile", statoCivile.toUpperCase());

					String indirizzo = ((DatiAnagrafici) datiAnagrafici).getDescrizioneVia();

					if (indirizzo != null) {

						if (((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() != null) {
							indirizzo = ((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() + " " + indirizzo;
						}

						indirizzo = "in " + indirizzo;

						// Comune residenza
						if (comuneByCodice != null) {
							// numero civico
							String numeroCivico = ((DatiAnagrafici) datiAnagrafici).getNumeroCivico();
							if (numeroCivico != null) {
								numeroCivico = ", n. " + numeroCivico;
							}
							else {
								numeroCivico = "";
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
							certificatoContestualeMatrimonioContainer.addProperty("indirizzoResidenza", indirizzo + numeroCivico + scala + piano + interno);
						}
					}

					// Cap
					String cap = ((DatiAnagrafici) datiAnagrafici).getCap();

					String comuneResidenza = comuneByCodice.getDenominazione();
					String provinciaResidenza = comuneByCodice.getProvincia().getSigla();
					String capResidenza = cap + " " + comuneResidenza + " " + "(" + provinciaResidenza + ")";
					certificatoContestualeMatrimonioContainer.addProperty("capResidenza", capResidenza);

					// cittaEmissione + Data odierna
					String citta = organization.getName().toUpperCase();
					Date today = new Date();
					String dftoday = df.format(today);
					String cittaEmissione = citta + ", " + dftoday;
					certificatoContestualeMatrimonioContainer.addProperty("cittaEmissione", cittaEmissione);

					alpacaJsonData.add(certificatoContestualeMatrimonioKey, certificatoContestualeMatrimonioContainer);
				}

				// Salvataggio
				enrichmentModel.setAlpacaJsonData(alpacaJsonData);
			}
		}
	}
}
