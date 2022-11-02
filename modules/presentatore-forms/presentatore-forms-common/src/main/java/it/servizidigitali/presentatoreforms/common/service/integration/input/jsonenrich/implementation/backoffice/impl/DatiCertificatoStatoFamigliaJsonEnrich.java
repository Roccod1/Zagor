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
@Component(name = "datiCertificatoStatoFamigliaJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class DatiCertificatoStatoFamigliaJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(DatiCertificatoStatoFamigliaJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;
	
	private final DateFormat dfdash = new SimpleDateFormat("dd-MM-yyyy");

	public String fieldNameDataContainerKey = "certificatoStatoFamiglia";
	private int i = 0;

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

						// Condizioni scaricamento certificato
						if (componente.getDataMorte() != null) {
							throw new BackofficeServiceException(BackofficeServiceExceptionLanguageCode.SOGGETTO_DECEDUTO_CERTIFICATO_NON_DISPONIBILE);
						}

						// indirizzo //
						String indirizzo = ((DatiAnagrafici) datiAnagrafici).getDescrizioneVia();
						if (indirizzo != null) {

							if (((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() != null) {
								indirizzo = ((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() + " " + indirizzo;
							}

							indirizzo = indirizzo + " ";

							// numero civico //
							String numeroCivico = ((DatiAnagrafici) datiAnagrafici).getNumeroCivico();
							if (numeroCivico != null) {
								numeroCivico = " n. " + numeroCivico;
							}
							else {
								numeroCivico = "";
							}

							// esponente del civico //
							String esponente = ((DatiAnagrafici) datiAnagrafici).getEsponente();
							if (esponente != null) {
								esponente = " " + esponente;
							}
							else {
								esponente = "";
							}

							// scala //
							String scala = ((DatiAnagrafici) datiAnagrafici).getScala();
							if (scala != null) {
								scala = " scala " + scala;
							}
							else {
								scala = "";
							}

							// piano //
							String piano = ((DatiAnagrafici) datiAnagrafici).getPiano();
							if (piano != null) {
								piano = " piano " + piano;
							}
							else {
								piano = "";
							}

							// interno //
							String interno = ((DatiAnagrafici) datiAnagrafici).getInterno();
							if (interno != null) {
								interno = " interno " + interno;
							}
							else {
								interno = "";
							}

							fieldDataContainer.addProperty("rigaIndirizzo", indirizzo + numeroCivico + esponente + scala + piano + interno);
						}

						// Membri famiglia //
						String riassuntoFamiglia = "";
						i = 0;
						for (DatiAnagrafici.ComponenteNucleoFamiliare membroFamiglia : componentiNucleo) {
							String riassuntoMembro = "";

							if (membroFamiglia.getDataMorte() == null) {
								i++;
								// Nome e cognome

								riassuntoMembro = membroFamiglia.getNome() + " " + membroFamiglia.getCognome() + "<br>";

								// Data e luogo nascita //

								String rigaNascita = EnrichmentUtilService.getBornLabelByGenderDichiarante(membroFamiglia) + "il ";
								rigaNascita = rigaNascita + EnrichmentUtilService.getDataNascitaComponente(membroFamiglia) + " a ";

								// TODO va controllata la cittadinanza e mostrato il comune italiano
								// o estero a
								// seconda dei casi o si dà per scontata cittadinanza italiana?
								String nomeComuneNascita = "";
								String siglaProvinciaNascita = "";

								String codiceIstat = membroFamiglia.getCodiceIstatComuneNascita();
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
											if(comuneEstero != null) {
												rigaNascita = rigaNascita + comuneEstero.getDenominazione();	
											} else if( !Validator.isBlank(membroFamiglia.getDescrizioneComuneEsteroNascita())) {
												rigaNascita = rigaNascita + " " + membroFamiglia.getDescrizioneComuneEsteroNascita();
												if( !Validator.isBlank(membroFamiglia.getDescrizioneStatoEsteroNascita())) {
													rigaNascita += "(" + membroFamiglia.getDescrizioneStatoEsteroNascita() + ")" ;
												}
											}
											
										}
										catch (Exception e) {
											rigaNascita = "";
										}
									}
								}
								else {

									if (membroFamiglia.getDescrizioneComuneEsteroNascita() != null) {
										nomeComuneNascita = membroFamiglia.getDescrizioneComuneEsteroNascita();
										rigaNascita = rigaNascita + nomeComuneNascita;
										if (componente.getCodiceStatoEsteroNascita() != null) {
											StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
											if(statoEsteroByCodiceStato != null) {
												nomeComuneNascita = nomeComuneNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
												rigaNascita = rigaNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";	
											}
											
										}
									}
									else if (componente.getCodiceStatoEsteroNascita() != null) {
										StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
										rigaNascita = rigaNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
									}
								}
								riassuntoMembro = riassuntoMembro + rigaNascita + "<br>";

								// atto nascita //
								String attoNascita = membroFamiglia.getNumeroAttoNascita();

								if (attoNascita == null) {
									riassuntoMembro = riassuntoMembro + "atto n. " + "<br>";
								}
								else {
									riassuntoMembro = riassuntoMembro + "atto n. " + attoNascita + "<br>";
								}

								// relazione parentela //
								RelazioneParentela relazioneParentela = membroFamiglia.getRelazioneParentela();

								if (relazioneParentela != null && !relazioneParentela.equals(RelazioneParentela.INTESTATARIO_SCHEDA)) {
									riassuntoMembro = riassuntoMembro + relazioneParentela.getDescrizione().toUpperCase() + "<br>";
								}
								
								if ( i > 1) {
									riassuntoFamiglia += "<br>";
								}
								riassuntoFamiglia += riassuntoMembro;
							}

							if (i % 5 == 0) {
								System.out.println("page break = " + i);
								riassuntoFamiglia = riassuntoFamiglia + "</p><div style=\"page-break-after: always\"></div><p>";
							}

						}
						fieldDataContainer.addProperty("membriFamiglia", riassuntoFamiglia);

						// luogo e data del certificato //
						String comuneFirma = organization.getName().toUpperCase();
						Date dataEmissione = new Date();
						String infoVarie = "<h4>" + comuneFirma + ", " + dfdash.format(dataEmissione) + "</h4>";
						fieldDataContainer.addProperty("infoVarie", infoVarie);

						// Salvo
						alpacaJsonData.add(fieldNameDataContainer, fieldDataContainer);
						enrichmentModel.setAlpacaJsonData(alpacaJsonData);
					}
				}
			}
		}
	}
}
