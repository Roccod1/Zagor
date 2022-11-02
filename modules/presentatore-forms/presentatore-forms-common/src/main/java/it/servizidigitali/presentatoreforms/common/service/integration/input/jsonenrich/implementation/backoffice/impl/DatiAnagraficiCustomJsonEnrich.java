package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

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
import it.servizidigitali.common.service.StatoEsteroLocalServiceUtil;
import it.servizidigitali.common.utility.enumeration.OrganizationCustomAttributes;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;
import it.servizidigitali.presentatoreforms.common.util.EnrichmentUtilService;

/**
 * @author pindi
 *
 */
@Component(name = "datiAnagraficiCustomJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class DatiAnagraficiCustomJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(DatiAnagraficiCustomJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	public final String type = "datiAngraficiCustom";
	
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
				throw new BackofficeServiceException("Errore durante il caricamento dell'organizzazione " + enrichmentModel.getOrganizationId(), e);
			}

			Comune comuneByCodice = comuneLocalService
					.getComuneByCodiceISTAT(organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_ISTAT.getNomeAttributo()).toString());

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

				AlpacaJsonOptionsStructure alpacaJsonOptionsStructure = enrichmentModel.getAlpacaJsonOptionsStructure();

				// Custom field
				String fieldNameDataContainer = AlpacaUtil.getFieldNameDataContainer(alpacaJsonOptionsStructure, type);
				if (fieldNameDataContainer != null) {
					JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(fieldNameDataContainer);
					if (fieldDataContainer != null) {

						fieldDataContainer.addProperty("identificativo", componente.getIdentificativo());
						fieldDataContainer.addProperty("identificativoFamiglia", ((DatiAnagrafici) datiAnagrafici).getIdentificativoNucleoFamiliare());

						// Codice Fiscale
						String codiceFiscale = componente.getCodiceFiscale();
						fieldDataContainer.addProperty("codiceFiscale", codiceFiscale);

						// Nome
						String nome = componente.getNome();
						fieldDataContainer.addProperty("nome", nome);
						// Cognome
						String cognome = componente.getCognome();
						fieldDataContainer.addProperty("cognome", cognome);

						// Data nascita //
						fieldDataContainer.addProperty("dataNascita", EnrichmentUtilService.getDataNascitaComponente(componente));

						// Comune Nascita //
						String nomeComuneNascita = "";

						String codiceIstatComuneNascita = componente.getCodiceIstatComuneNascita();
						if (codiceIstatComuneNascita != null) {
							Comune comune = comuneLocalService.getComuneByCodiceISTAT(codiceIstatComuneNascita);
							if (comune != null) {
								nomeComuneNascita = comune.getDenominazione();
								Provincia provincia = comune.getProvincia();
								if (provincia != null) {
									nomeComuneNascita = nomeComuneNascita + " (" + provincia.getSigla() + ")";
								}
							}
						}

						// Se il componente è nato in uno stato estero
						if (componente.getCodiceStatoEsteroNascita() != null || componente.getDescrizioneStatoEsteroNascita() != null) {
							StatoEstero statoEsteroByCodiceOrDenominazione = 
									componente.getCodiceStatoEsteroNascita() != null ?
									statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita()):
										statoEsteroLocalService.getStatoEsteroByDenominazione(componente.getDescrizioneStatoEsteroNascita());
									
									//Se non riesco a recuperare lo stato estero dalle info, mantengo la descrizione che mi arriva dal BO
									if (statoEsteroByCodiceOrDenominazione == null || Validator.isBlank(statoEsteroByCodiceOrDenominazione.getDenominazione())) {
										statoEsteroByCodiceOrDenominazione = StatoEsteroLocalServiceUtil.createStatoEstero(0);
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
								fieldDataContainer.addProperty("codiceStatoEsteroNascitaHidden", componente.getCodiceStatoEsteroNascita() != null ? Integer.toString(componente.getCodiceStatoEsteroNascita()) : "");
							}

						}
						fieldDataContainer.addProperty("comuneNascita", nomeComuneNascita);

						// Indirizzo//
						String indirizzo = ((DatiAnagrafici) datiAnagrafici).getDescrizioneVia();

						if (indirizzo != null) {

							if (((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() != null) {
								indirizzo = ((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() + " " + indirizzo;
							}

							// FIXME modo alternativo di recuperare informazioni residenza//
							/*
							 * String luogoResidenza = "residente a "; DatiAnagraficiGenerali
							 * richDatiAna = new DatiAnagraficiGenerali();
							 * richDatiAna.setCodiceFiscale(dichiarante.getCodiceFiscale());
							 * DatiUtente altriDatiUtente = enrichmentUtilService
							 * .richiediDatiAnagraficiAltriServizi(richDatiAna,
							 * enrichmentModel.getUserPreferences()); String comuneResidenza =
							 * altriDatiUtente.getComuneResidenza(); String provinciaResidenza =
							 * altriDatiUtente.getProvinciaResidenza();
							 */

							// Comune residenza
							if (comuneByCodice != null) {
								String denominazioneComuneRes = comuneByCodice.getDenominazione();
								Comune comuneRes = comuneLocalService
										.getComuneByCodiceISTAT(organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_ISTAT.getNomeAttributo()).toString());

								// Provincia del comune di residenza
								String siglaProvinciaRes = comuneRes.getProvincia().getSigla();
								if (siglaProvinciaRes != null) {
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
									numeroCivico = ", n. " + numeroCivico;
								}
								else {
									numeroCivico = "";
								}
								// esponente
								String esponente = ((DatiAnagrafici) datiAnagrafici).getEsponente();
								if (esponente != null) {
									esponente = ", " + esponente;
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
								fieldDataContainer.addProperty("indirizzoResidenza", indirizzo + numeroCivico + esponente + scala + piano + interno + " " + denominazioneComuneRes + siglaProvinciaRes);
							}
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
