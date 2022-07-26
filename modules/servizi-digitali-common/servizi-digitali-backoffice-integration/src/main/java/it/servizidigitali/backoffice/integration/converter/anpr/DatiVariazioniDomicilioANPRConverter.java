package it.servizidigitali.backoffice.integration.converter.anpr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio.VariazioneDomicilio;
import it.sogei.anpr._3000consultazione.Risposta3002;
import it.sogei.anpr._3000consultazione.Risposta3002OK;
import it.sogei.anpr.tipodato.TipoCivicoInterno;
import it.sogei.anpr.tipodato.TipoDatiRispostaEstrazioneSoggetti;
import it.sogei.anpr.tipodato.TipoGeneralita;
import it.sogei.anpr.tipodato.TipoIndirizzo;
import it.sogei.anpr.tipodato.TipoIndirizzoEstero;
import it.sogei.anpr.tipodato.TipoLocalitaEstera;
import it.sogei.anpr.tipodato.TipoNumeroCivico;
import it.sogei.anpr.tipodato.TipoResidenza;
import it.sogei.anpr.vocabolario3000consultazione.TipoListaSoggetti;

/**
 * @author pindi
 *
 */
@Component(name = "datiVariazioniDomicilioANPRConverter", immediate = true, service = DatiVariazioniDomicilioANPRConverter.class)
public class DatiVariazioniDomicilioANPRConverter {

	/**
	 *
	 * @param risposta3002
	 * @param codiceFiscaleComponente
	 * @return
	 */
	public DatiVariazioniDomicilio convert(Risposta3002 risposta3002, String codiceFiscaleComponente) {

		DatiVariazioniDomicilio datiVariazioniDomicilio = null;

		Risposta3002OK risposta3002ok = risposta3002.getRisposta3002OK();
		if (risposta3002.getRispostaKO() == null && risposta3002ok != null) {
			TipoListaSoggetti listaSoggetti = risposta3002ok.getListaSoggetti();
			if (listaSoggetti != null) {
				List<TipoDatiRispostaEstrazioneSoggetti> datiSoggetto = listaSoggetti.getDatiSoggetto();
				if (datiSoggetto != null) {
					datiVariazioniDomicilio = new DatiVariazioniDomicilio();
					for (TipoDatiRispostaEstrazioneSoggetti tipoDatiRispostaEstrazioneSoggetti : datiSoggetto) {
						TipoGeneralita generalita = tipoDatiRispostaEstrazioneSoggetti.getGeneralita();
						String codFiscale = generalita.getCodiceFiscale().getCodFiscale();
						if (codFiscale.equals(codiceFiscaleComponente)) {
							List<TipoResidenza> residenza = tipoDatiRispostaEstrazioneSoggetti.getResidenza();
							if (residenza != null) {
								Collections.sort(residenza, new Comparator<TipoResidenza>() {

									@Override
									public int compare(TipoResidenza o1, TipoResidenza o2) {
										return o1.getDataDecorrenzaResidenza().toGregorianCalendar().compareTo(o2.getDataDecorrenzaResidenza().toGregorianCalendar());
									}
								});

								List<VariazioneDomicilio> variazioniDomicilio = new ArrayList<>();
								for (TipoResidenza tipoResidenza : residenza) {
									VariazioneDomicilio variazioneDomicilio = new VariazioneDomicilio();
									TipoIndirizzo indirizzo = tipoResidenza.getIndirizzo();
									TipoLocalitaEstera localitaEstera = tipoResidenza.getLocalitaEstera();
									if (indirizzo != null) {
										TipoNumeroCivico numeroCivico = indirizzo.getNumeroCivico();
										if (numeroCivico != null) {

											variazioneDomicilio.setCodiceCivico(numeroCivico.getCodiceCivico());
											variazioneDomicilio.setEsponente(numeroCivico.getEsponente1());
											String numeroCivicoString = numeroCivico.getNumero();
											if (numeroCivico.getEsponente1() != null && !numeroCivico.getEsponente1().equals("")) {
												numeroCivicoString += ", " + numeroCivico.getEsponente1();
											}

											variazioneDomicilio.setNumeroCivico(numeroCivicoString);

											TipoCivicoInterno civicoInterno = numeroCivico.getCivicoInterno();
											if (civicoInterno != null) {
												variazioneDomicilio.setInterno(civicoInterno.getInterno1());
												variazioneDomicilio.setPiano(civicoInterno.getPiano());
												variazioneDomicilio.setScala(civicoInterno.getScala());
											}
										}
										variazioneDomicilio.setToponimoIndirizzo(indirizzo.getToponimo().getSpecie());
										variazioneDomicilio.setIndirizzo(indirizzo.getToponimo().getDenominazioneToponimo());
										variazioneDomicilio.setCodiceIstatComune(indirizzo.getComune().getCodiceIstat());
										variazioneDomicilio.setCap(indirizzo.getCap());
									}
									else if (localitaEstera != null) {
										TipoIndirizzoEstero indirizzoEstero = localitaEstera.getIndirizzoEstero();
										if (indirizzoEstero != null) {
											variazioneDomicilio.setIndirizzo(indirizzoEstero.getLocalita().getDescrizioneLocalita());
											variazioneDomicilio.setNumeroCivico(indirizzoEstero.getToponimo().getNumeroCivico());
											variazioneDomicilio.setToponimoIndirizzo(indirizzoEstero.getToponimo().getDenominazione());
											variazioneDomicilio.setCodiceIstatComune(indirizzoEstero.getLocalita().getCodiceStato());
											variazioneDomicilio.setCap(indirizzoEstero.getCap());
										}
									}
									variazioneDomicilio.setDataInizioDomicilio(
											tipoResidenza.getDataDecorrenzaResidenza() != null ? tipoResidenza.getDataDecorrenzaResidenza().toGregorianCalendar().getTime() : null);
									variazioneDomicilio.setDataIscrizioneComune(
											tipoResidenza.getDataDecorrenzaResidenza() != null ? tipoResidenza.getDataDecorrenzaResidenza().toGregorianCalendar().getTime() : null);
									variazioneDomicilio.setIndirizzo(null);

									variazioniDomicilio.add(variazioneDomicilio);
								}
								datiVariazioniDomicilio.setVariazioniDomicilio(variazioniDomicilio);
							}
							break;
						}
					}
				}
			}
		}

		return datiVariazioniDomicilio;
	}
}
