package it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.Validator;

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
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.EnrichmentUtilService;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonOptionsStructure;

/**
 * @author pindi
 *
 */
@Component(name = "datiAnagraficiCustomTwoColJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class DatiAnagraficiCustomTwoColJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(DatiAnagraficiCustomTwoColJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	public final String type = "datiAngraficiCustomTwoCol";

	@Override
	public <T> void enrich(EnrichmentModel<T> enrichmentModel) {

		T datiAnagrafici = enrichmentModel.getSourceObject();
		if (datiAnagrafici instanceof DatiAnagrafici) {

			// Nucleo familiare
			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleo = ((DatiAnagrafici) datiAnagrafici).getComponentiNucleoFamiliare();

			Organization organization;
			try {
				organization = organizationLocalService.getOrganization(enrichmentModel.getOrganizationId());
			}
			catch (PortalException e) {
				log.error("enrich :: " + e.getMessage(), e);
				throw new RuntimeException(e);
			}
			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiList = null;
			String codiceFiscaleComponente = enrichmentModel.getUserPreferences().getCodiceFiscaleComponente();
			if (Validator.isNotNull(codiceFiscaleComponente)) {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equalsIgnoreCase(codiceFiscaleComponente)).collect(Collectors.toList());
			}
			else {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equalsIgnoreCase(enrichmentModel.getUserPreferences().getCodiceFiscaleRichiedente()))
						.collect(Collectors.toList());
			}
			if (componentiList.size() == 1) {
				DatiAnagrafici.ComponenteNucleoFamiliare componente = componentiList.get(0);
				JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();

				AlpacaJsonOptionsStructure alpacaJsonOptionsStructure = enrichmentModel.getAlpacaJsonOptionsStructure();

				// Custom field
				List<String> fieldNamesDataContainer = AlpacaUtil.getAllFieldNameDataContainer(alpacaJsonOptionsStructure, type);
				if (fieldNamesDataContainer != null) {
					for (String fieldNameDataContainer : fieldNamesDataContainer) {
						JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(fieldNameDataContainer);
						if (fieldDataContainer != null) {
							// Nome
							String nome = componente.getNome();
							fieldDataContainer.addProperty("nome", nome);
							// Cognome
							String cognome = componente.getCognome();
							fieldDataContainer.addProperty("cognome", cognome);
							// cittadinanza
							boolean cittadinanza = componente.isCittadinanzaItaliana();
							if (cittadinanza) {
								fieldDataContainer.addProperty("cittadinanza", "Italia");
							}

							fieldDataContainer.addProperty("identificativo", componente.getIdentificativo());
							fieldDataContainer.addProperty("identificativoFamiglia", ((DatiAnagrafici) datiAnagrafici).getIdentificativoNucleoFamiliare());

							// Codice Fiscale
							String codiceFiscale = componente.getCodiceFiscale();
							fieldDataContainer.addProperty("codicefiscale", codiceFiscale);
							// Sesso
							String sesso = "F";
							if (componente.getSesso().equalsIgnoreCase("M")) {
								sesso = "M";
							}
							fieldDataContainer.addProperty("sesso", sesso);

							// Data nascita //
							fieldDataContainer.addProperty("datanascita", EnrichmentUtilService.getDataNascitaComponente(componente));

							// Comune Nascita //
							String nomeComuneNascita = "";
							String codiceIstatComuneNascita = componente.getCodiceIstatComuneNascita();
							if (Validator.isNotNull(codiceIstatComuneNascita)) {
								Comune comune = comuneLocalService.getComuneByCodiceISTAT(codiceIstatComuneNascita);
								if (comune != null) {
									fieldDataContainer.addProperty("codiceIstatComuneNascitaHidden", codiceIstatComuneNascita);
									nomeComuneNascita = comune.getDenominazione();
									Provincia provincia = comune.getProvincia();
									if (provincia != null) {
										fieldDataContainer.addProperty("siglaProvinciaNascitaHidden", provincia.getSigla());
										nomeComuneNascita = nomeComuneNascita + " (" + provincia.getSigla() + ")";
									}
								}
							}

							// Se il componente è nato in uno stato estero
							if (componente.getCodiceStatoEsteroNascita() != null || componente.getDescrizioneStatoEsteroNascita() != null) {
								StatoEstero statoEsteroByCodiceOrDenominazione = componente.getCodiceStatoEsteroNascita() != null
										? statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita())
										: statoEsteroLocalService.getStatoEsteroByDenominazione(componente.getDescrizioneStatoEsteroNascita());

								// Se non riesco a recuperare lo stato estero dalle info, mantengo
								// la
								// descrizione che mi arriva dal BO
								if (statoEsteroByCodiceOrDenominazione == null || Validator.isNotNull(statoEsteroByCodiceOrDenominazione.getDenominazione())) {
									statoEsteroByCodiceOrDenominazione.setDenominazione(componente.getDescrizioneStatoEsteroNascita());
								}

								ComuneEstero comuneEstero = null;
								if (codiceIstatComuneNascita != null) {
									comuneEstero = comuneEsteroLocalService.getComuneEsteroByCodice(Integer.parseInt(codiceIstatComuneNascita));
								}
								else if (componente.getDescrizioneComuneEsteroNascita() != null) {
									comuneEstero = comuneEsteroLocalService.getComuneEsteroByDenominazione(componente.getDescrizioneComuneEsteroNascita());
								}

								if (comuneEstero != null) {
									nomeComuneNascita = comuneEstero.getDenominazione();
									fieldDataContainer.addProperty("codiceComuneEsteroNascitaHidden", String.valueOf(comuneEstero.getCodice()));
								}
								else {
									nomeComuneNascita = componente.getDescrizioneComuneEsteroNascita();
									if (statoEsteroByCodiceOrDenominazione != null) {
										nomeComuneNascita += " (" + statoEsteroByCodiceOrDenominazione.getDenominazione() + ")";
									}
								}

								if (statoEsteroByCodiceOrDenominazione != null) {
									fieldDataContainer.addProperty("codiceStatoEsteroNascitaHidden",
											componente.getCodiceStatoEsteroNascita() != null ? Integer.toString(componente.getCodiceStatoEsteroNascita()) : "");
								}

							}

							fieldDataContainer.addProperty("luogoNascita", nomeComuneNascita);

							String indirizzo = ((DatiAnagrafici) datiAnagrafici).getDescrizioneVia();
							if (Validator.isNotNull(indirizzo)) {

								if (((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() != null) {
									indirizzo = ((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() + " " + indirizzo;
								}

								// Comune residenza
								String denominazioneComuneRes = organization.getName();
								if (denominazioneComuneRes != null) {
									fieldDataContainer.addProperty("comuneResHidden", denominazioneComuneRes);
								}
								Comune comuneRes = comuneLocalService
										.getComuneByCodiceISTAT(organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_ISTAT.getNomeAttributo()).toString());

								// Provincia del comune di residenza
								String siglaProvinciaRes = comuneRes.getProvincia().getSigla();
								if (siglaProvinciaRes != null) {
									fieldDataContainer.addProperty("provinciaResHidden", siglaProvinciaRes);
									siglaProvinciaRes = " (" + siglaProvinciaRes + ")";
								}
								else {
									siglaProvinciaRes = "";
								}
								fieldDataContainer.addProperty("residenza", denominazioneComuneRes + siglaProvinciaRes);

								// Localita

								// numero civico
								String numeroCivico = ((DatiAnagrafici) datiAnagrafici).getNumeroCivico();
								if (numeroCivico != null) {
									fieldDataContainer.addProperty("civicoHidden", numeroCivico);
									numeroCivico = ", n. " + numeroCivico;
								}
								else {
									numeroCivico = "";
								}
								// CAP (per solo campo hidden)
								String CAPResidenza = componente.getCap();
								if (CAPResidenza != null) {
									fieldDataContainer.addProperty("capHidden", CAPResidenza);
								}

								// esponente
								String esponente = ((DatiAnagrafici) datiAnagrafici).getEsponente();
								if (esponente != null) {
									fieldDataContainer.addProperty("esponenteHidden", esponente);
									esponente = ", " + esponente;
								}
								else {
									esponente = "";
								}
								// scala
								String scala = ((DatiAnagrafici) datiAnagrafici).getScala();
								if (scala != null) {
									fieldDataContainer.addProperty("scalaHidden", scala);
									scala = ", Scala: " + scala;
								}
								else {
									scala = "";
								}
								// piano
								String piano = ((DatiAnagrafici) datiAnagrafici).getPiano();
								if (piano != null) {
									fieldDataContainer.addProperty("pianoHidden", piano);
									piano = ", Piano: " + piano;
								}
								else {
									piano = "";
								}
								// interno
								String interno = ((DatiAnagrafici) datiAnagrafici).getInterno();
								if (interno != null) {
									fieldDataContainer.addProperty("internoHidden", interno);
									interno = ", Int. " + interno;
								}
								else {
									interno = "";
								}
								fieldDataContainer.addProperty("indirizzoResidenza", indirizzo + numeroCivico + esponente + scala + piano + interno + " " + denominazioneComuneRes + siglaProvinciaRes);
							}
							alpacaJsonData.add(fieldNameDataContainer, fieldDataContainer);
						}
						// Salvo
						enrichmentModel.setAlpacaJsonData(alpacaJsonData);
					}
				}
			}
		}
	}
}
