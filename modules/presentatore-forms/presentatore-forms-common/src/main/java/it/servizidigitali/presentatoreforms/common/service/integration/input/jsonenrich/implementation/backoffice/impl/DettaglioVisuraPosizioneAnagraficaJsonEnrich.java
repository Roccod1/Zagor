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

import it.servizidigitali.backoffice.integration.enums.RelazioneParentela;
import it.servizidigitali.backoffice.integration.enums.StatoCivile;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici.ComponenteNucleoFamiliare.Pensione;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.common.utility.enumeration.OrganizationCustomAttributes;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.util.EnrichmentUtilService;

/**
 * @author pindi
 *
 */
@Component(name = "dettaglioVisuraPosizioneAnagraficaJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class DettaglioVisuraPosizioneAnagraficaJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(DettaglioVisuraPosizioneAnagraficaJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public String fieldNameDataContainerKey = "visuraPosizioneAnagrafica";
	
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
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equals(enrichmentModel.getUserPreferences().getCodiceFiscaleComponente())).collect(Collectors.toList());
			}
			else {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equals(enrichmentModel.getUserPreferences().getCodiceFiscaleRichiedente())).collect(Collectors.toList());
			}
			if (componentiList.size() == 1) {
				DatiAnagrafici.ComponenteNucleoFamiliare componente = componentiList.get(0);
				JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();

				String fieldNameDataContainer = fieldNameDataContainerKey;
				if (fieldNameDataContainer != null) {
					JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(fieldNameDataContainer);
					if (fieldDataContainer != null) {

						// Recupero di provincia e/o comune di nascita che servono in più campi //
						String nomeComuneNascita = "";
						String siglaProvinciaNascita = "";

						String codiceIstat = componente.getCodiceIstatComuneNascita();
						if (codiceIstat != null) {
							Comune comune = comuneLocalService.getComuneByCodiceISTAT(codiceIstat);
							if (comune != null) {
								nomeComuneNascita = comune.getDenominazione();
								Provincia provincia = comune.getProvincia();
								if (provincia != null) {
									siglaProvinciaNascita = provincia.getSigla();
									fieldDataContainer.addProperty("provinciaNascita", siglaProvinciaNascita);
								}
							}
							else {
								try {
									ComuneEstero comuneEstero = comuneEsteroLocalService.getComuneEsteroByCodice(Integer.parseInt(codiceIstat));
									nomeComuneNascita = comuneEstero.getDenominazione();
								}
								catch (Exception e) {
									nomeComuneNascita = "";
								}
							}
						}
						else {
							if (componente.getDescrizioneComuneEsteroNascita() != null) {
								nomeComuneNascita = componente.getDescrizioneComuneEsteroNascita();
								if (componente.getCodiceStatoEsteroNascita() != null) {
									StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
									nomeComuneNascita = nomeComuneNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
								}
							}
							else if (componente.getCodiceStatoEsteroNascita() != null) {
								StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
								nomeComuneNascita = nomeComuneNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
							}
						}
						fieldDataContainer.addProperty("comuneNascita", nomeComuneNascita);

						// Nome
						String nome = componente.getNome();
						if (nome == null) {
							fieldDataContainer.addProperty("nome", " ");
						}
						else {
							fieldDataContainer.addProperty("nome", nome);
						}
						// Cognome
						String cognome = componente.getCognome();
						if (cognome == null) {
							fieldDataContainer.addProperty("cognome", " ");
						}
						else {
							fieldDataContainer.addProperty("cognome", cognome);
						}

						// cittadinanza
						boolean cittadinanza = componente.isCittadinanzaItaliana();
						if (cittadinanza) {
							fieldDataContainer.addProperty("cittadinanzaItaliana", "Sì");
						}
						else {
							fieldDataContainer.addProperty("cittadinanzaItaliana", "No");
						}

						fieldDataContainer.addProperty("identificativo", componente.getIdentificativo());
						fieldDataContainer.addProperty("identificativoFamiglia", ((DatiAnagrafici) datiAnagrafici).getIdentificativoNucleoFamiliare());

						// Codice Fiscale
						String codiceFiscale = componente.getCodiceFiscale();
						fieldDataContainer.addProperty("codiceFiscale", codiceFiscale);

						// Sesso
						String sesso = " ";
						if (componente.getSesso() != null) {
							sesso = "F";
							if (componente.getSesso().equalsIgnoreCase("M")) {
								sesso = "M";
							}
						}
						fieldDataContainer.addProperty("sesso", sesso);

						// Data nascita //
						fieldDataContainer.addProperty("dataNascita", EnrichmentUtilService.getDataNascitaComponente(componente));

						// Stato civile //

						StatoCivile statoCivile = componente.getStatoCivile();
						if (statoCivile == null) {
							fieldDataContainer.addProperty("statoCivile", " ");
						}
						else {
							fieldDataContainer.addProperty("statoCivile", statoCivile.getDescrizione());
						}

						// Coniuge //
						String coniuge = componente.getCognomeNomeConiuge();
						if (coniuge == null) {
							fieldDataContainer.addProperty("coniuge", " ");
						}
						else {
							fieldDataContainer.addProperty("coniuge", coniuge);
						}

						// relazione parentela //
						RelazioneParentela relazioneParentela = componente.getRelazioneParentela();
						if (relazioneParentela == null) {
							fieldDataContainer.addProperty("relazioneParentela", " ");
						}
						else {
							fieldDataContainer.addProperty("relazioneParentela", relazioneParentela.getDescrizione());
						}

						// professione //
						String professione = componente.getProfessione();
						if (professione == null) {
							fieldDataContainer.addProperty("professione", " ");
						}
						else {
							fieldDataContainer.addProperty("professione", professione);
						}

						// titolo studio //
						String titoloStudio = componente.getTitoloStudio();
						if (titoloStudio == null) {
							fieldDataContainer.addProperty("titoloStudio", " ");
						}
						else {
							fieldDataContainer.addProperty("titoloStudio", titoloStudio);
						}

						// n carta identita //
						String nCartaIdentita = componente.getNumeroCartaIdentita();
						if (nCartaIdentita == null) {
							fieldDataContainer.addProperty("nCartaIdentita", " ");
						}
						else {
							fieldDataContainer.addProperty("nCartaIdentita", nCartaIdentita);
						}

						// data carta identita //
						Date dataCartaIdentita = componente.getDataRilascioCartaIdentita();
						if (dataCartaIdentita == null) {
							fieldDataContainer.addProperty("dataCartaIdentita", " ");
						}
						else {
							fieldDataContainer.addProperty("dataCartaIdentita", df.format(dataCartaIdentita));
						}

						// validita carta identita //
						Date dataScadenzaCartaIdentita = componente.getDataScadenzaCartaIdentita();
						if (dataScadenzaCartaIdentita != null) {
							boolean validitaCartaIdentita = dataScadenzaCartaIdentita.before(new Date());
							if (validitaCartaIdentita) {
								fieldDataContainer.addProperty("validitaCartaIdentita", "Sì");
							}
							else {
								fieldDataContainer.addProperty("validitaCartaIdentita", "No");
							}
						}

						// atto nascita //
						if (!componente.isAttoNascitaTrascitto()) {

							String attoNascita = componente.getNumeroAttoNascita();
							String infoNascita = "";

							if (attoNascita == null) {
								fieldDataContainer.addProperty("attoNascita", " ");
							}
							else {
								if (!Validator.isBlank(componente.getParteAttoNascita())) {
									infoNascita = ", p. " + componente.getParteAttoNascita();
								}
								if (!Validator.isBlank(componente.getSerieAttoNascita())) {
									infoNascita = infoNascita + ", s. " + componente.getSerieAttoNascita();
								}
								if (componente.getAnnoAttoNascita() != null) {
									infoNascita = infoNascita + ", anno: " + componente.getAnnoAttoNascita();
								}
								if (!Validator.isBlank(componente.getUfficioAttoNascita())) {
									infoNascita = infoNascita + ", ufficio: " + componente.getUfficioAttoNascita();
								}

								if (!Validator.isBlank(nomeComuneNascita)) {
									infoNascita = infoNascita + ", comune: " + nomeComuneNascita;
								}
								if (!Validator.isBlank(siglaProvinciaNascita)) {
									infoNascita = infoNascita + ", prov: " + siglaProvinciaNascita;
								}

								fieldDataContainer.addProperty("attoNascita", "n. " + attoNascita + infoNascita);

							}
						}
						// atto nascita trascritto//
						else {
							String attoNascitaTrascritto = componente.getNumeroAttoNascita();
							String infoNascitaTrascritto = "";

							if (attoNascitaTrascritto == null) {
								fieldDataContainer.addProperty("attoNascitaTrascritto", " ");
							}
							else {
								if (!Validator.isBlank(componente.getParteAttoNascita())) {

									infoNascitaTrascritto = ", p. " + componente.getParteAttoNascita();
								}
								if (!Validator.isBlank(componente.getSerieAttoNascita())) {
									infoNascitaTrascritto = infoNascitaTrascritto + ", s. " + componente.getSerieAttoNascita();
								}
								if (componente.getAnnoAttoNascita() != null) {
									infoNascitaTrascritto = infoNascitaTrascritto + ", anno: " + componente.getAnnoAttoNascita();
								}
								if (!Validator.isBlank(componente.getUfficioAttoNascita())) {
									infoNascitaTrascritto = infoNascitaTrascritto + ", ufficio: " + componente.getUfficioAttoNascita();
								}

								String codiceIstatNascitaTrascritto = componente.getCodiceIstatComuneAttoNascita();
								if (!Validator.isBlank(codiceIstatNascitaTrascritto)) {
									Comune comuneNascitaTrascritto = comuneLocalService.getComuneByCodiceISTAT(codiceIstatNascitaTrascritto);
									if (comuneNascitaTrascritto != null) {
										infoNascitaTrascritto = infoNascitaTrascritto + ", comune: " + comuneNascitaTrascritto.getDenominazione();
									}
									Provincia provinciaNascitaTrascritto = comuneNascitaTrascritto.getProvincia();
									if (provinciaNascitaTrascritto != null) {
										infoNascitaTrascritto = infoNascitaTrascritto + ", prov.: " + provinciaNascitaTrascritto.getDenominazioneProvincia();
									}
								}
								fieldDataContainer.addProperty("attoNascitaTrascritto", "n. " + attoNascitaTrascritto + infoNascitaTrascritto);
							}
						}

						// atto matrimonio //
						if (!componente.isAttoMatrimonioTrascitto()) {
							String attoMatrimonio = componente.getNumeroAttoMatrimonio();
							String infoMatrimonio = "";

							if (attoMatrimonio == null) {
								fieldDataContainer.addProperty("attoMatrimonio", " ");
							}
							else {
								if (!Validator.isBlank(componente.getParteAttoMatrimonio())) {
									infoMatrimonio = ", p. " + componente.getParteAttoMatrimonio();
								}
								if (!Validator.isBlank(componente.getSerieAttoMatrimonio())) {
									infoMatrimonio = infoMatrimonio + ", s. " + componente.getSerieAttoMatrimonio();
								}
								if (componente.getAnnoAttoMatrimonio() != null) {
									infoMatrimonio = infoMatrimonio + ", anno: " + componente.getAnnoAttoMatrimonio();
								}
								if (!Validator.isBlank(componente.getUfficioAttoMatrimonio())) {
									infoMatrimonio = infoMatrimonio + ", ufficio: " + componente.getUfficioAttoMatrimonio();
								}
								if (!Validator.isBlank(componente.getLuogoMatrimonio())) {
									infoMatrimonio = infoMatrimonio + ", " + componente.getLuogoMatrimonio();
								}
								if (componente.getDataMatrimonio() != null) {
									Date dataMatrimonio = componente.getDataMatrimonio();
									infoMatrimonio = infoMatrimonio + ", Data matrimonio: " + df.format(dataMatrimonio);
								}

								String codiceIstatMatrimonio = componente.getCodiceIstatComuneAttoMatrimonio();
								if (!Validator.isBlank(codiceIstatMatrimonio)) {
									Comune comuneMatrimonio = comuneLocalService.getComuneByCodiceISTAT(codiceIstatMatrimonio);
									if (comuneMatrimonio != null) {
										infoMatrimonio = infoMatrimonio + ", comune: " + comuneMatrimonio.getDenominazione();
									}
									Provincia provinciaMatrimonio = comuneMatrimonio.getProvincia();
									if (provinciaMatrimonio != null) {
										infoMatrimonio = infoMatrimonio + ", prov.: " + provinciaMatrimonio.getDenominazioneProvincia();
									}
								}
								fieldDataContainer.addProperty("attoMatrimonio", "n. " + attoMatrimonio + infoMatrimonio);

							}
						}
						// Atto Matrimonio Trascritto //
						else {
							String attoMatrimonioTrascritto = componente.getNumeroAttoMatrimonio();
							String infoMatrimonioTrascritto = "";

							if (attoMatrimonioTrascritto == null) {
								fieldDataContainer.addProperty("attoMatrimonioTrascritto", " ");
							}
							else {
								if (!Validator.isBlank(componente.getParteAttoMatrimonio())) {
									infoMatrimonioTrascritto = ", p. " + componente.getParteAttoMatrimonio();
								}
								if (!Validator.isBlank(componente.getSerieAttoMatrimonio())) {
									infoMatrimonioTrascritto = infoMatrimonioTrascritto + ", s. " + componente.getSerieAttoMatrimonio();
								}
								if (componente.getAnnoAttoMatrimonio() != null) {
									infoMatrimonioTrascritto = infoMatrimonioTrascritto + ", anno: " + componente.getAnnoAttoMatrimonio();
								}

								if (!Validator.isBlank(componente.getUfficioAttoMatrimonio())) {
									infoMatrimonioTrascritto = infoMatrimonioTrascritto + ", ufficio: " + componente.getUfficioAttoMatrimonio();
								}

								String codiceIstatMatrimonioTrascritto = componente.getCodiceIstatComuneAttoMatrimonio();
								if (!Validator.isBlank(codiceIstatMatrimonioTrascritto)) {
									Comune comuneMatrimonioTrascritto = comuneLocalService.getComuneByCodiceISTAT(codiceIstatMatrimonioTrascritto);
									if (comuneMatrimonioTrascritto != null) {
										infoMatrimonioTrascritto = infoMatrimonioTrascritto + ", comune: " + comuneMatrimonioTrascritto.getDenominazione();
									}
									Provincia provinciaMatrimonioTrascritto = comuneMatrimonioTrascritto.getProvincia();
									if (provinciaMatrimonioTrascritto != null) {
										infoMatrimonioTrascritto = infoMatrimonioTrascritto + ", prov.: " + provinciaMatrimonioTrascritto.getDenominazioneProvincia();
									}
								}
								fieldDataContainer.addProperty("attoMatrimonioTrascritto", "n. " + attoMatrimonioTrascritto + infoMatrimonioTrascritto);
							}
						}

						// atto vedovanza //
						if (!componente.isAttoVedovanzaTrascitto()) {

							String attoVedovanza = componente.getNumeroAttoVedovanza();
							String infoVedovanza = "";

							if (attoVedovanza == null) {
								fieldDataContainer.addProperty("attoVedovanza", " ");
							}
							else {
								if (componente.getDataAttoVedovanza() != null) {
									Date dataVedovanza = componente.getDataAttoVedovanza();
									infoVedovanza = infoVedovanza + ", data: " + df.format(dataVedovanza);
								}
								if (!Validator.isBlank(componente.getParteAttoVedovanza())) {
									infoVedovanza = ", p. " + componente.getParteAttoVedovanza();
								}
								if (!Validator.isBlank(componente.getSerieAttoVedovanza())) {
									infoVedovanza = infoVedovanza + ", s. " + componente.getSerieAttoVedovanza();
								}
								if (!Validator.isBlank(componente.getVolumeAttoVedovanza())) {
									infoVedovanza = infoVedovanza + ", vol. " + componente.getVolumeAttoVedovanza();
								}
								if (!Validator.isBlank(componente.getUfficioAttoVedovanza())) {
									infoVedovanza = infoVedovanza + ", ufficio: " + componente.getUfficioAttoVedovanza();
								}

								String codiceIstatVedovanza = componente.getCodiceIstatComuneAttoVedovanza();
								if (!Validator.isBlank(codiceIstatVedovanza)) {
									Comune comuneVedovanza = comuneLocalService.getComuneByCodiceISTAT(codiceIstatVedovanza);
									if (comuneVedovanza != null) {
										infoVedovanza = infoVedovanza + ", comune: " + comuneVedovanza.getDenominazione();
									}
									Provincia provinciaVedovanza = comuneVedovanza.getProvincia();
									if (provinciaVedovanza != null) {
										infoVedovanza = infoVedovanza + ", prov.: " + provinciaVedovanza.getDenominazioneProvincia();
									}
								}

								fieldDataContainer.addProperty("attoVedovanza", "n. " + attoVedovanza + infoVedovanza);
							}
						}
						else {
							// TODO atto vedovanza trascritto
						}

						// atto divorzio //
						if (!componente.isAttoAnnullamentoMatrimonioTrascitto()) {

							String attoDivorzio = componente.getNumeroAttoAnnullamentoMatrimonio();
							String infoDivorzio = "";

							if (attoDivorzio == null) {
								fieldDataContainer.addProperty("attoDivorzio", " ");
							}
							else {
								if (componente.getDataAttoAnnullamentoMatrimonio() != null) {
									Date dataDivorzio = componente.getDataAttoAnnullamentoMatrimonio();
									infoDivorzio = infoDivorzio + ", data: " + df.format(dataDivorzio);
								}
								if (componente.getTipoCessazioneMatrimonio() != null) {
									infoDivorzio = ", tipo: " + componente.getTipoCessazioneMatrimonio().getDescrizione();
								}
								if (!Validator.isBlank(componente.getNumeroSentenzaAnnullamentoMatrimonio())) {
									infoDivorzio = ", n. sentenza: " + componente.getNumeroSentenzaAnnullamentoMatrimonio();
								}
								if (componente.getDataSentenzaAnnullamentoMatrimonio() != null) {
									Date dataSentenza = componente.getDataSentenzaAnnullamentoMatrimonio();
									infoDivorzio = infoDivorzio + ", data sentenza: " + df.format(dataSentenza);
								}
								if (componente.getDataDecorrenzaAnnullamentoMatrimonio() != null) {
									Date dataDecorrenza = componente.getDataDecorrenzaAnnullamentoMatrimonio();
									infoDivorzio = infoDivorzio + ", data decorrenza: " + df.format(dataDecorrenza);
								}
								if (!Validator.isBlank(componente.getParteAttoAnnullamentoMatrimonio())) {
									infoDivorzio = ", p. " + componente.getParteAttoAnnullamentoMatrimonio();
								}
								if (!Validator.isBlank(componente.getSerieAttoAnnullamentoMatrimonio())) {
									infoDivorzio = infoDivorzio + ", s. " + componente.getSerieAttoAnnullamentoMatrimonio();
								}
								if (!Validator.isBlank(componente.getVolumeAttoAnnullamentoMatrimonio())) {
									infoDivorzio = infoDivorzio + ", vol. " + componente.getVolumeAttoAnnullamentoMatrimonio();
								}
								if (!Validator.isBlank(componente.getUfficioAttoAnnullamentoMatrimonio())) {
									infoDivorzio = infoDivorzio + ", ufficio: " + componente.getUfficioAttoAnnullamentoMatrimonio();
								}

								String codiceIstatDivorzio = componente.getCodiceIstatComuneAttoAnnullamentoMatrimonio();
								if (!Validator.isBlank(codiceIstatDivorzio)) {
									Comune comuneTribunaleDivorzio = comuneLocalService.getComuneByCodiceISTAT(codiceIstatDivorzio);
									if (comuneTribunaleDivorzio != null) {
										infoDivorzio = infoDivorzio + ", comune: " + comuneTribunaleDivorzio.getDenominazione();
									}
									Provincia provinciaTribunaleDivorzio = comuneTribunaleDivorzio.getProvincia();
									if (provinciaTribunaleDivorzio != null) {
										infoDivorzio = infoDivorzio + ", prov.: " + provinciaTribunaleDivorzio.getDenominazioneProvincia();
									}
								}

								fieldDataContainer.addProperty("attoDivorzio", "n. " + attoDivorzio + infoDivorzio);

							}
						}
						// atto divorzio trascritto//
						else {
							String infoDivorzioTrascritto = "";
							String attoDivorzioTrascritto = componente.getNumeroAttoAnnullamentoMatrimonio();

							if (attoDivorzioTrascritto == null) {
								fieldDataContainer.addProperty("attoDivorzioTrascritto", " ");
							}
							else {
								if (componente.getDataAttoAnnullamentoMatrimonio() != null) {
									Date dataDivorzioTrascritto = componente.getDataAttoAnnullamentoMatrimonio();
									infoDivorzioTrascritto = infoDivorzioTrascritto + ", data: " + df.format(dataDivorzioTrascritto);
								}
								if (!Validator.isBlank(componente.getParteAttoAnnullamentoMatrimonio())) {
									infoDivorzioTrascritto = ", p. " + componente.getParteAttoAnnullamentoMatrimonio();
								}
								if (!Validator.isBlank(componente.getSerieAttoAnnullamentoMatrimonio())) {
									infoDivorzioTrascritto = infoDivorzioTrascritto + ", s. " + componente.getSerieAttoAnnullamentoMatrimonio();
								}
								if (!Validator.isBlank(componente.getVolumeAttoAnnullamentoMatrimonio())) {
									infoDivorzioTrascritto = infoDivorzioTrascritto + ", vol. " + componente.getVolumeAttoAnnullamentoMatrimonio();
								}
								if (!Validator.isBlank(componente.getUfficioAttoAnnullamentoMatrimonio())) {
									infoDivorzioTrascritto = infoDivorzioTrascritto + ", ufficio: " + componente.getUfficioAttoAnnullamentoMatrimonio();
								}
								String codiceIstatDivorzioTrascritto = componente.getCodiceIstatComuneAttoAnnullamentoMatrimonio();
								if (!Validator.isBlank(codiceIstatDivorzioTrascritto)) {
									Comune comuneTribunaleDivorzioTrascritto = comuneLocalService.getComuneByCodiceISTAT(codiceIstatDivorzioTrascritto);
									if (comuneTribunaleDivorzioTrascritto != null) {
										infoDivorzioTrascritto = infoDivorzioTrascritto + ", comune: " + comuneTribunaleDivorzioTrascritto.getDenominazione();
									}
									Provincia provinciaTribunaleDivorzioTrascritto = comuneTribunaleDivorzioTrascritto.getProvincia();
									if (provinciaTribunaleDivorzioTrascritto != null) {
										infoDivorzioTrascritto = infoDivorzioTrascritto + ", prov.: " + provinciaTribunaleDivorzioTrascritto.getDenominazioneProvincia();
									}
								}
								fieldDataContainer.addProperty("attoDivorzioTrascritto", "n. " + attoDivorzioTrascritto + infoDivorzioTrascritto);
							}

						}

						if (!componente.isAttoMorteTrascitto()) {
							// atto morte //
							String attoMorte = componente.getNumeroAttoMorte();
							String infoMorte = "";

							if (attoMorte == null) {
								fieldDataContainer.addProperty("attoMorte", " ");
							}
							else {
								if (componente.getDataMorte() != null) {
									Date dataMorte = componente.getDataMorte();
									infoMorte = infoMorte + ", data morte:" + df.format(dataMorte);
								}
								if (!Validator.isBlank(componente.getParteAttoMorte())) {
									infoMorte = ", p. " + componente.getParteAttoMorte();
								}
								if (!Validator.isBlank(componente.getSerieAttoMorte())) {
									infoMorte = infoMorte + ", s. " + componente.getSerieAttoMorte();
								}
								if (componente.getAnnoAttoMorte() != null) {
									infoMorte = infoMorte + ", anno: " + componente.getAnnoAttoMorte();
								}
								if (!Validator.isBlank(componente.getUfficioAttoMorte())) {
									infoMorte = infoMorte + ", ufficio: " + componente.getUfficioAttoMorte();
								}

								String codiceIstatMorte = componente.getCodiceIstatComuneAttoMorte();
								if (!Validator.isBlank(codiceIstatMorte)) {
									Comune comuneMorte = comuneLocalService.getComuneByCodiceISTAT(codiceIstatMorte);
									if (comuneMorte != null) {
										infoMorte = infoMorte + ", comune: " + comuneMorte.getDenominazione();
									}
									Provincia provinciaMorte = comuneMorte.getProvincia();
									if (provinciaMorte != null) {
										infoMorte = infoMorte + ", prov.: " + provinciaMorte.getDenominazioneProvincia();
									}
								}
								fieldDataContainer.addProperty("attoMorte", "n. " + attoMorte + infoMorte);
							}
						}
						else {
							// TODO atto morte coniuge trascritto (non era presente su egov1) -->
							// rendere atto morte trascritto?
							String attoMorteConiugeTrascritto = componente.getNumeroAttoMorte();
							String infoMorteConiugeTrascritto = "";

							if (attoMorteConiugeTrascritto == null) {
								fieldDataContainer.addProperty("attoMorteConiugeTrascritto", " ");
							}
							else {
								if (!Validator.isBlank(componente.getParteAttoMorte())) {
									infoMorteConiugeTrascritto = ", p. " + componente.getParteAttoMorte();
								}
								if (!Validator.isBlank(componente.getSerieAttoMorte())) {
									infoMorteConiugeTrascritto = infoMorteConiugeTrascritto + ", s. " + componente.getSerieAttoMorte();
								}
								if (!Validator.isBlank(componente.getUfficioAttoMorte())) {
									infoMorteConiugeTrascritto += ", ufficio: " + componente.getUfficioAttoMorte();
								}
								if (componente.getAnnoAttoMorte() != null) {
									infoMorteConiugeTrascritto = infoMorteConiugeTrascritto + ", anno: " + componente.getAnnoAttoMorte();
								}

								String codiceIstatMorteConiugeTrascritto = componente.getCodiceIstatComuneAttoMorte();
								if (!Validator.isBlank(codiceIstatMorteConiugeTrascritto)) {
									Comune comuneMorteConiugeTrascritto = comuneLocalService.getComuneByCodiceISTAT(codiceIstatMorteConiugeTrascritto);
									if (comuneMorteConiugeTrascritto != null) {
										infoMorteConiugeTrascritto = infoMorteConiugeTrascritto + ", comune: " + comuneMorteConiugeTrascritto.getDenominazione();
									}
									Provincia provinciaMorteConiugeTrascritto = comuneMorteConiugeTrascritto.getProvincia();
									if (provinciaMorteConiugeTrascritto != null) {
										infoMorteConiugeTrascritto = infoMorteConiugeTrascritto + ", prov.: " + provinciaMorteConiugeTrascritto.getDenominazioneProvincia();
									}
								}
								fieldDataContainer.addProperty("attoMorteConiugeTrascritto", "n. " + attoMorteConiugeTrascritto + infoMorteConiugeTrascritto);
							}
						}

						// pensioni //
						String stringaPensioni = "";
						if (componente.getPensioni() != null) {
							List<Pensione> pensioni = componente.getPensioni();
							int indicePensione = 1;
							for (Pensione pensione : pensioni) {
								stringaPensioni = stringaPensioni + indicePensione + ") Numero pensione: " + pensione.getNumeroPensione() + " Codice pensione: " + pensione.getCodicePensione()
										+ "<br>";
								indicePensione++;
							}
						}
						fieldDataContainer.addProperty("pensioni", stringaPensioni);

						// indirizzo //
						String indirizzo = ((DatiAnagrafici) datiAnagrafici).getDescrizioneVia();
						String nomeComuneResidenza = "";
						if (indirizzo != null) {
							indirizzo = indirizzo + ",";

							if (componente.getCodiceIstatComuneResidenza() != null) {
								Comune comuneByCodiceISTAT = comuneLocalService.getComuneByCodiceISTAT(componente.getCodiceIstatComuneResidenza());
								if (comuneByCodiceISTAT != null) {
									nomeComuneResidenza = " " + comuneByCodiceISTAT.getDenominazione();
								}
							}
							else if (comuneByCodice != null) {
								nomeComuneResidenza = " " + comuneByCodice.getDenominazione();
							}

							// numero civico //
							String numeroCivico = ((DatiAnagrafici) datiAnagrafici).getNumeroCivico();
							if (numeroCivico != null) {
								numeroCivico = " n. " + numeroCivico + ",";
							}
							else {
								numeroCivico = "";
							}

							// esponente del civico //
							String esponente = ((DatiAnagrafici) datiAnagrafici).getEsponente();
							if (esponente != null) {
								esponente = " " + esponente + ",";
							}
							else {
								esponente = "";
							}

							// scala //
							String scala = ((DatiAnagrafici) datiAnagrafici).getScala();
							if (scala != null) {
								scala = " Scala: " + scala + ",";
							}
							else {
								scala = "";
							}

							// piano //
							String piano = ((DatiAnagrafici) datiAnagrafici).getPiano();
							if (piano != null) {
								piano = " Piano: " + piano + ",";
							}
							else {
								piano = "";
							}

							// interno //
							String interno = ((DatiAnagrafici) datiAnagrafici).getInterno();
							if (interno != null) {
								interno = " Int. " + interno + ",";
							}
							else {
								interno = "";
							}

							fieldDataContainer.addProperty("indirizzoResidenza", indirizzo + numeroCivico + esponente + scala + piano + interno + nomeComuneResidenza);
						}
						// Salvo
						alpacaJsonData.add(fieldNameDataContainer, fieldDataContainer);
						enrichmentModel.setAlpacaJsonData(alpacaJsonData);
					}
				}
			}
		}
	}
}
