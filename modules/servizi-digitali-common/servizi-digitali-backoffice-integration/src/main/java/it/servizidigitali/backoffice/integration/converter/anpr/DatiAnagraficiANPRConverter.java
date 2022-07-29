package it.servizidigitali.backoffice.integration.converter.anpr;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.enums.RelazioneParentela;
import it.servizidigitali.backoffice.integration.enums.StatoCivile;
import it.servizidigitali.backoffice.integration.enums.TipoCessazioneMatrimonio;
import it.servizidigitali.backoffice.integration.enums.TipoTribunale;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.sogei.anpr._3000consultazione.Risposta3002;
import it.sogei.anpr._3000consultazione.Risposta3002OK;
import it.sogei.anpr.tipodato.TipoAltriDati;
import it.sogei.anpr.tipodato.TipoAnnullamentoMatrimonio;
import it.sogei.anpr.tipodato.TipoAtto;
import it.sogei.anpr.tipodato.TipoCartaIdentita;
import it.sogei.anpr.tipodato.TipoCittadinanza;
import it.sogei.anpr.tipodato.TipoCivicoInterno;
import it.sogei.anpr.tipodato.TipoComune;
import it.sogei.anpr.tipodato.TipoDatiEvento;
import it.sogei.anpr.tipodato.TipoDatiRispostaEstrazioneSoggetti;
import it.sogei.anpr.tipodato.TipoDomicilioDigitale;
import it.sogei.anpr.tipodato.TipoGeneralita;
import it.sogei.anpr.tipodato.TipoIndirizzo;
import it.sogei.anpr.tipodato.TipoIndirizzoEstero;
import it.sogei.anpr.tipodato.TipoLocalitaEstera;
import it.sogei.anpr.tipodato.TipoLuogoEvento;
import it.sogei.anpr.tipodato.TipoMatrimonio;
import it.sogei.anpr.tipodato.TipoNumeroCivico;
import it.sogei.anpr.tipodato.TipoResidenza;
import it.sogei.anpr.tipodato.TipoSentenza;
import it.sogei.anpr.tipodato.TipoVedovanza;
import it.sogei.anpr.vocabolario3000consultazione.TipoListaSoggetti;

/**
 * @author pindi
 *
 */
@Component(name = "datiAnagraficiANPRConverter", immediate = true, service = DatiAnagraficiANPRConverter.class)
public class DatiAnagraficiANPRConverter {

	private static final Log log = LogFactoryUtil.getLog(DatiAnagraficiANPRConverter.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	/**
	 *
	 * @param risposta3002
	 * @return
	 */
	public DatiAnagrafici convert(Risposta3002 risposta3002) {

		DatiAnagrafici datiAnagrafici = null;

		Risposta3002OK risposta3002ok = risposta3002.getRisposta3002OK();
		if (risposta3002.getRispostaKO() == null && risposta3002ok != null) {
			TipoListaSoggetti listaSoggetti = risposta3002ok.getListaSoggetti();
			if (listaSoggetti != null) {
				List<TipoDatiRispostaEstrazioneSoggetti> datiSoggetto = listaSoggetti.getDatiSoggetto();
				if (datiSoggetto != null) {
					datiAnagrafici = new DatiAnagrafici();
					List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleoFamiliare = new ArrayList<>();
					for (TipoDatiRispostaEstrazioneSoggetti tipoDatiRispostaEstrazioneSoggetti : datiSoggetto) {

						datiAnagrafici.setIdentificativoNucleoFamiliare(tipoDatiRispostaEstrazioneSoggetti.getFamigliaConvivenza().getIdFamigliaConvivenzaComune().getIdFamigliaConvivenza());

						DatiAnagrafici.ComponenteNucleoFamiliare componenteNucleoFamiliare = new DatiAnagrafici.ComponenteNucleoFamiliare();
						TipoGeneralita generalita = tipoDatiRispostaEstrazioneSoggetti.getGeneralita();
						componenteNucleoFamiliare.setCodiceFiscale(generalita.getCodiceFiscale().getCodFiscale());
						TipoMatrimonio matrimonio = tipoDatiRispostaEstrazioneSoggetti.getMatrimonio();
						if (matrimonio != null) {
							TipoGeneralita coniuge = matrimonio.getConiuge();
							if (coniuge != null) {
								componenteNucleoFamiliare.setCodiceFiscaleConiuge(coniuge.getCodiceFiscale().getCodFiscale());
								componenteNucleoFamiliare.setCognomeNomeConiuge(coniuge.getCognome() + " " + coniuge.getNome());
							}
							TipoDatiEvento datiMatrimonio = matrimonio.getDatiMatrimonio();
							if (datiMatrimonio != null) {
								componenteNucleoFamiliare.setDataMatrimonio(datiMatrimonio.getDataEvento() != null ? datiMatrimonio.getDataEvento().toGregorianCalendar().getTime() : null);
								TipoLuogoEvento luogoEvento = datiMatrimonio.getLuogoEvento();
								if (luogoEvento != null) {
									TipoComune comuneMatrimonio = luogoEvento.getComune();
									if (comuneMatrimonio != null) {
										componenteNucleoFamiliare.setLuogoMatrimonio(comuneMatrimonio.getNomeComune());
									}
								}
							}

							// Atto Matrimonio
							TipoAtto attoEvento = matrimonio.getDatiMatrimonio().getAttoEvento();
							if (attoEvento != null) {
								componenteNucleoFamiliare.setAttoMatrimonioTrascitto(attoEvento.getTrascritto() != null && attoEvento.getTrascritto().equals("1"));
								componenteNucleoFamiliare.setNumeroAttoMatrimonio(attoEvento.getNumeroAtto());
								componenteNucleoFamiliare.setParteAttoMatrimonio(attoEvento.getParte());
								componenteNucleoFamiliare.setSerieAttoMatrimonio(attoEvento.getSerie());
								componenteNucleoFamiliare.setAnnoAttoMatrimonio(attoEvento.getAnno());
								componenteNucleoFamiliare.setCodiceIstatComuneAttoMatrimonio(attoEvento.getComuneRegistrazione() != null ? attoEvento.getComuneRegistrazione().getCodiceIstat() : null);
							}

						}
						componenteNucleoFamiliare.setIdentificativo(tipoDatiRispostaEstrazioneSoggetti.getGeneralita().getIdSchedaSoggettoANPR());
						componenteNucleoFamiliare.setCognome(generalita.getCognome());
						componenteNucleoFamiliare.setNome(generalita.getNome());
						componenteNucleoFamiliare.setSesso(generalita.getSesso());
						componenteNucleoFamiliare.setDataNascita(generalita.getDataNascita().toGregorianCalendar().getTime());
						if (generalita.getSenzaGiorno() != null && generalita.getSenzaGiorno().equals("1")) {
							componenteNucleoFamiliare.setDataNascitaSenzaGiorno(true);
						}
						if (generalita.getSenzaGiornoMese() != null && generalita.getSenzaGiornoMese().equals("1")) {
							componenteNucleoFamiliare.setDataNascitaSenzaGiornoMese(true);
						}

						// Relazione di parentela
						String codiceLegameParentela = tipoDatiRispostaEstrazioneSoggetti.getLegameSoggetto().getCodiceLegame();
						try {
							componenteNucleoFamiliare.setRelazioneParentela(RelazioneParentela.getByCodice(Integer.parseInt(codiceLegameParentela)));
						}
						catch (Exception e) {
							log.warn("getComponentiNucleoFamiliare :: " + e.getMessage());
						}

						// Stato civile
						try {
							componenteNucleoFamiliare.setStatoCivile(StatoCivile.getByCodice(Integer.parseInt(tipoDatiRispostaEstrazioneSoggetti.getStatoCivile().getStatoCivile())));
						}
						catch (Exception e) {
							log.warn("getComponentiNucleoFamiliare :: " + e.getMessage());
						}
						List<TipoCittadinanza> cittadinanza = tipoDatiRispostaEstrazioneSoggetti.getCittadinanza();
						if (cittadinanza != null && !cittadinanza.isEmpty()) {
							Collections.sort(cittadinanza, new Comparator<TipoCittadinanza>() {

								@Override
								public int compare(TipoCittadinanza o1, TipoCittadinanza o2) {
									return o1.getDataValidita().toGregorianCalendar().compareTo(o2.getDataValidita().toGregorianCalendar());
								}
							});

							TipoCittadinanza tipoCittadinanza = cittadinanza.get(cittadinanza.size() - 1);
							String codiceStato = tipoCittadinanza.getCodiceStato();
							if (codiceStato.equals("100")) {
								componenteNucleoFamiliare.setCittadinanzaItaliana(true);
							}
						}
						// Stato nascita
						if (generalita.getLuogoNascita().getLocalita() != null) {
							StatoEstero statoEsteroByCodice = statoEsteroLocalService.getStatoEsteroByCodiceStato(Integer.parseInt(generalita.getLuogoNascita().getLocalita().getCodiceStato()));
							componenteNucleoFamiliare.setDescrizioneStatoEsteroNascita(generalita.getLuogoNascita().getLocalita().getDescrizioneStato());
							if (statoEsteroByCodice != null) {
								componenteNucleoFamiliare.setCodiceStatoEsteroNascita(statoEsteroByCodice.getCodiceStato());
							}
						}
						if (generalita.getLuogoNascita().getComune() != null) {
							// Comune Nascita
							// Caricamento Provincia Nascita da codice ISTAT
							Comune comuneNascita = comuneLocalService.getComuneByCodiceISTAT(generalita.getLuogoNascita().getComune().getCodiceIstat());
							if (comuneNascita != null) {
								componenteNucleoFamiliare.setCodiceIstatComuneNascita(comuneNascita.getCodiceIstatAN());
							}
						}

						// Indirizzo e Comune Residenza
						List<TipoResidenza> residenza = tipoDatiRispostaEstrazioneSoggetti.getResidenza();
						if (residenza != null && !residenza.isEmpty()) {
							Collections.sort(residenza, new Comparator<TipoResidenza>() {

								@Override
								public int compare(TipoResidenza o1, TipoResidenza o2) {
									return o1.getDataDecorrenzaResidenza().toGregorianCalendar().compareTo(o2.getDataDecorrenzaResidenza().toGregorianCalendar());
								}
							});

							TipoResidenza latsTipoResidenza = residenza.get(residenza.size() - 1);
							TipoIndirizzo indirizzo = latsTipoResidenza.getIndirizzo();
							TipoLocalitaEstera localitaEstera = latsTipoResidenza.getLocalitaEstera();
							if (indirizzo != null) {
								componenteNucleoFamiliare.setToponimoIndirizzo(indirizzo.getToponimo().getSpecie());
								componenteNucleoFamiliare.setDescrizioneVia(indirizzo.getToponimo().getDenominazioneToponimo());
								componenteNucleoFamiliare.setCap(indirizzo.getCap());
								TipoNumeroCivico numeroCivico = indirizzo.getNumeroCivico();
								if (numeroCivico != null) {
									String numeroCivicoString = numeroCivico.getNumero();
									if (numeroCivico.getEsponente1() != null && !numeroCivico.getEsponente1().equals("")) {
										numeroCivicoString += ", " + numeroCivico.getEsponente1();
									}
									componenteNucleoFamiliare.setNumeroCivico(numeroCivicoString);
									componenteNucleoFamiliare.setCodiceCivico(numeroCivico.getCodiceCivico());
									TipoCivicoInterno civicoInterno = numeroCivico.getCivicoInterno();
									if (civicoInterno != null) {
										componenteNucleoFamiliare.setPiano(civicoInterno.getPiano());
										componenteNucleoFamiliare.setScala(civicoInterno.getScala());
										componenteNucleoFamiliare.setInterno(civicoInterno.getInterno1());
									}
								}

								TipoComune comune = indirizzo.getComune();
								componenteNucleoFamiliare.setCodiceIstatComuneResidenza(comune.getCodiceIstat());
							}
							else if (localitaEstera != null) {
								TipoIndirizzoEstero indirizzoEstero = localitaEstera.getIndirizzoEstero();
								if (indirizzoEstero != null) {
									componenteNucleoFamiliare.setToponimoIndirizzo(indirizzoEstero.getToponimo().getDenominazione());
									componenteNucleoFamiliare.setCap(indirizzoEstero.getCap());
									componenteNucleoFamiliare.setNumeroCivico(indirizzoEstero.getToponimo().getNumeroCivico());
									componenteNucleoFamiliare.setCodiceStatoComuneResidenza(indirizzoEstero.getLocalita().getCodiceStato());
								}
							}

							if (componenteNucleoFamiliare.getRelazioneParentela() != null && componenteNucleoFamiliare.getRelazioneParentela().equals(RelazioneParentela.INTESTATARIO_SCHEDA)) {
								datiAnagrafici.setToponimoIndirizzo(componenteNucleoFamiliare.getToponimoIndirizzo());
								datiAnagrafici.setCap(componenteNucleoFamiliare.getCap());
								datiAnagrafici.setNumeroCivico(componenteNucleoFamiliare.getNumeroCivico());
								datiAnagrafici.setPiano(componenteNucleoFamiliare.getPiano());
								datiAnagrafici.setScala(componenteNucleoFamiliare.getScala());
								datiAnagrafici.setInterno(componenteNucleoFamiliare.getInterno());
								datiAnagrafici.setCodiceIstatComune(componenteNucleoFamiliare.getCodiceIstatComuneResidenza());
								datiAnagrafici.setDescrizioneVia(componenteNucleoFamiliare.getDescrizioneVia());
							}
						}

						// Telefono
						componenteNucleoFamiliare.setTelefono(null);

						// Carta d'identità
						TipoCartaIdentita cartaIdentita = tipoDatiRispostaEstrazioneSoggetti.getCartaIdentita();
						if (cartaIdentita != null) {
							componenteNucleoFamiliare.setNumeroCartaIdentita(cartaIdentita.getNumero());
							componenteNucleoFamiliare.setDataScadenzaCartaIdentita(cartaIdentita.getDataScadenza() != null ? cartaIdentita.getDataScadenza().toGregorianCalendar().getTime() : null);
							componenteNucleoFamiliare.setDataRilascioCartaIdentita(cartaIdentita.getDataRilascio() != null ? cartaIdentita.getDataRilascio().toGregorianCalendar().getTime() : null);
							componenteNucleoFamiliare.setCodiceIstatComuneRilascioCartaIdentita(cartaIdentita.getComuneRilascio() != null ? cartaIdentita.getComuneRilascio().getCodiceIstat() : null);
						}

						// Domicilio digitale
						TipoDomicilioDigitale domicilioDigitale = tipoDatiRispostaEstrazioneSoggetti.getDomicilioDigitale();
						if (domicilioDigitale != null) {
							componenteNucleoFamiliare.setDomicilioDigitale(domicilioDigitale.getIndirizzoDigitale());
						}

						TipoAltriDati altriDati = tipoDatiRispostaEstrazioneSoggetti.getAltriDati();
						if (altriDati != null) {
							componenteNucleoFamiliare.setTitoloStudio(altriDati.getTitoloStudio());
							componenteNucleoFamiliare.setProfessione(altriDati.getPosizioneProfessionale());
						}

						// Atto nascita
						TipoAtto attoNascita = tipoDatiRispostaEstrazioneSoggetti.getAttoNascita();
						if (attoNascita != null) {
							componenteNucleoFamiliare.setAttoNascitaTrascitto(attoNascita.getTrascritto() != null && attoNascita.getTrascritto().equals("1"));
							componenteNucleoFamiliare.setNumeroAttoNascita(attoNascita.getNumeroAtto());
							componenteNucleoFamiliare.setParteAttoNascita(attoNascita.getParte());
							componenteNucleoFamiliare.setSerieAttoNascita(attoNascita.getSerie());
							componenteNucleoFamiliare.setAnnoAttoNascita(attoNascita.getAnno());
							componenteNucleoFamiliare.setCodiceIstatComuneNascita(attoNascita.getComuneRegistrazione() != null ? attoNascita.getComuneRegistrazione().getCodiceIstat() : null);
						}

						// Annullamento matrimonio
						TipoAnnullamentoMatrimonio annullamentoMatrimonio = tipoDatiRispostaEstrazioneSoggetti.getAnnullamentoMatrimonio();
						if (annullamentoMatrimonio != null) {
							String tipoCessazione = annullamentoMatrimonio.getTipoCessazione();
							if (tipoCessazione != null) {
								componenteNucleoFamiliare.setTipoCessazioneMatrimonio(TipoCessazioneMatrimonio.getByCodice(Integer.parseInt(tipoCessazione)));
							}

							TipoAtto attoAnnullamentoMatrimonio = annullamentoMatrimonio.getAttoAnnullamentoMatrimonio();
							if (attoAnnullamentoMatrimonio != null) {
								componenteNucleoFamiliare
										.setAttoAnnullamentoMatrimonioTrascitto(attoAnnullamentoMatrimonio.getTrascritto() != null && attoAnnullamentoMatrimonio.getTrascritto().equals("1"));
								componenteNucleoFamiliare.setNumeroAttoAnnullamentoMatrimonio(attoAnnullamentoMatrimonio.getNumeroAtto());
								componenteNucleoFamiliare.setParteAttoAnnullamentoMatrimonio(attoAnnullamentoMatrimonio.getParte());
								componenteNucleoFamiliare.setSerieAttoAnnullamentoMatrimonio(attoAnnullamentoMatrimonio.getSerie());
								componenteNucleoFamiliare.setAnnoAttoAnnullamentoMatrimonio(attoAnnullamentoMatrimonio.getAnno());
								componenteNucleoFamiliare.setCodiceIstatComuneAttoAnnullamentoMatrimonio(
										attoAnnullamentoMatrimonio.getComuneRegistrazione() != null ? attoAnnullamentoMatrimonio.getComuneRegistrazione().getCodiceIstat() : null);
								componenteNucleoFamiliare.setVolumeAttoAnnullamentoMatrimonio(attoAnnullamentoMatrimonio.getVolume());
								componenteNucleoFamiliare.setUfficioAttoAnnullamentoMatrimonio(attoAnnullamentoMatrimonio.getUfficioMunicipio());
								componenteNucleoFamiliare.setDataAttoAnnullamentoMatrimonio(
										attoAnnullamentoMatrimonio.getDataFormazioneAtto() != null ? attoAnnullamentoMatrimonio.getDataFormazioneAtto().toGregorianCalendar().getTime() : null);
							}

							TipoSentenza sentenzaAnnullamentoMatrimonio = annullamentoMatrimonio.getSentenza();
							if (sentenzaAnnullamentoMatrimonio != null) {
								componenteNucleoFamiliare.setNumeroSentenzaAnnullamentoMatrimonio(sentenzaAnnullamentoMatrimonio.getNumero());
								componenteNucleoFamiliare.setDataDecorrenzaAnnullamentoMatrimonio(
										sentenzaAnnullamentoMatrimonio.getDataValidita() != null ? sentenzaAnnullamentoMatrimonio.getDataValidita().toGregorianCalendar().getTime() : null);
								componenteNucleoFamiliare.setDataSentenzaAnnullamentoMatrimonio(
										sentenzaAnnullamentoMatrimonio.getData() != null ? sentenzaAnnullamentoMatrimonio.getData().toGregorianCalendar().getTime() : null);

								componenteNucleoFamiliare.setAutoritaSentenzaAnnullamentoMatrimonio(sentenzaAnnullamentoMatrimonio.getAutorita());
								String tipoTribunale = sentenzaAnnullamentoMatrimonio.getTipoTribunale();
								if (tipoTribunale != null) {
									componenteNucleoFamiliare.setTipoTribunale(TipoTribunale.getByCodice(Integer.parseInt(tipoTribunale)));
								}
							}
						}

						// Vedovanza
						TipoVedovanza vedovanza = tipoDatiRispostaEstrazioneSoggetti.getVedovanza();
						if (vedovanza != null) {
							TipoDatiEvento datiMorteconiuge = vedovanza.getDatiMorteconiuge();
							TipoAtto attoEvento = datiMorteconiuge.getAttoEvento();
							if (attoEvento != null) {
								componenteNucleoFamiliare.setAttoVedovanzaTrascitto(attoEvento.getTrascritto() != null && attoEvento.getTrascritto().equals("1"));
								componenteNucleoFamiliare.setDataAttoVedovanza(attoEvento.getDataFormazioneAtto() != null ? attoEvento.getDataFormazioneAtto().toGregorianCalendar().getTime() : null);
								componenteNucleoFamiliare.setNumeroAttoVedovanza(attoEvento.getNumeroAtto());
								componenteNucleoFamiliare.setParteAttoVedovanza(attoEvento.getParte());
								componenteNucleoFamiliare.setSerieAttoVedovanza(attoEvento.getSerie());
								componenteNucleoFamiliare.setVolumeAttoVedovanza(attoEvento.getVolume());
								componenteNucleoFamiliare.setUfficioAttoVedovanza(attoEvento.getUfficioMunicipio());
								componenteNucleoFamiliare.setCodiceIstatComuneAttoVedovanza(attoEvento.getComuneRegistrazione() != null ? attoEvento.getComuneRegistrazione().getCodiceIstat() : null);
							}
						}

						// Atto morte (sgrat!)
						TipoDatiEvento datiDecesso = tipoDatiRispostaEstrazioneSoggetti.getDatiDecesso();
						if (datiDecesso != null) {
							componenteNucleoFamiliare.setDataMorte(datiDecesso.getDataEvento() != null ? datiDecesso.getDataEvento().toGregorianCalendar().getTime() : null);
							TipoAtto attoEvento = datiDecesso.getAttoEvento();
							if (attoEvento != null) {
								componenteNucleoFamiliare.setAttoMorteTrascitto(attoEvento.getTrascritto() != null && attoEvento.getTrascritto().equals("1"));
								componenteNucleoFamiliare.setNumeroAttoMorte(attoEvento.getNumeroAtto());
								componenteNucleoFamiliare.setParteAttoMorte(attoEvento.getParte());
								componenteNucleoFamiliare.setSerieAttoMorte(attoEvento.getSerie());
								componenteNucleoFamiliare.setAnnoAttoMorte(attoEvento.getAnno());
								componenteNucleoFamiliare.setCodiceIstatComuneAttoMorte(attoEvento.getComuneRegistrazione() != null ? attoEvento.getComuneRegistrazione().getCodiceIstat() : null);
							}
						}

						componentiNucleoFamiliare.add(componenteNucleoFamiliare);
					}
					datiAnagrafici.setComponentiNucleoFamiliare(componentiNucleoFamiliare);
				}
			}
		}

		return datiAnagrafici;
	}
}
