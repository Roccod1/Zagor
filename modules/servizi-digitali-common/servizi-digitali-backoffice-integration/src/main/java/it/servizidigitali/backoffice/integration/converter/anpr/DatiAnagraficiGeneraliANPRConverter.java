package it.servizidigitali.backoffice.integration.converter.anpr;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagraficiGenerali;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.service.ComuneLocalService;
import it.sogei.anpr._3000consultazione.Risposta3002;
import it.sogei.anpr._3000consultazione.Risposta3002OK;
import it.sogei.anpr.tipodato.TipoAtto;
import it.sogei.anpr.tipodato.TipoDatiRispostaEstrazioneSoggetti;
import it.sogei.anpr.tipodato.TipoGeneralita;
import it.sogei.anpr.tipodato.TipoIndirizzo;
import it.sogei.anpr.tipodato.TipoNumeroCivico;
import it.sogei.anpr.tipodato.TipoResidenza;
import it.sogei.anpr.vocabolario3000consultazione.TipoListaSoggetti;

/**
 * @author pindi
 *
 */
@Component(name = "datiAnagraficiGeneraliANPRConverter", immediate = true, service = DatiAnagraficiGeneraliANPRConverter.class)
public class DatiAnagraficiGeneraliANPRConverter {

	@Reference
	private ComuneLocalService comuneLocalService;

	/**
	 *
	 * @param risposta3002
	 * @param codiceFiscaleComponente
	 * @return
	 */
	public DatiAnagraficiGenerali convert(Risposta3002 risposta3002, String codiceFiscaleComponente) {

		DatiAnagraficiGenerali datiAnagraficiGenerali = null;

		Risposta3002OK risposta3002ok = risposta3002.getRisposta3002OK();
		if (risposta3002.getRispostaKO() == null && risposta3002ok != null) {
			TipoListaSoggetti listaSoggetti = risposta3002ok.getListaSoggetti();
			if (listaSoggetti != null) {
				List<TipoDatiRispostaEstrazioneSoggetti> datiSoggetto = listaSoggetti.getDatiSoggetto();
				if (datiSoggetto != null) {
					datiAnagraficiGenerali = new DatiAnagraficiGenerali();
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

								TipoResidenza latsTipoResidenza = residenza.get(residenza.size() - 1);
								TipoIndirizzo indirizzo = latsTipoResidenza.getIndirizzo();
								datiAnagraficiGenerali.setCap(indirizzo.getCap());
								datiAnagraficiGenerali.setCodiceIstatResidenza(indirizzo.getComune().getCodiceIstat());
								TipoNumeroCivico numeroCivico = indirizzo.getNumeroCivico();
								String numeroCivicoString = numeroCivico.getNumero();
								if (numeroCivico.getEsponente1() != null && !numeroCivico.getEsponente1().equals("")) {
									numeroCivicoString += ", " + numeroCivico.getEsponente1();
								}
								datiAnagraficiGenerali.setIndirizzo(indirizzo.getToponimo().getSpecie() + " " + indirizzo.getToponimo().getDenominazioneToponimo() + "," + numeroCivicoString);
								datiAnagraficiGenerali.setComuneResidenza(indirizzo.getComune().getNomeComune());
								Comune comuneByCodiceISTAT = comuneLocalService.getComuneByCodiceISTAT(indirizzo.getComune().getCodiceIstat());
								if (comuneByCodiceISTAT != null) {
									Provincia provincia = comuneByCodiceISTAT.getProvincia();
									if (provincia != null) {
										datiAnagraficiGenerali.setProvinciaResidenza(provincia.getSigla());
									}
								}
							}
							datiAnagraficiGenerali.setCognome(generalita.getCognome());
							datiAnagraficiGenerali.setNome(generalita.getNome());
							TipoAtto attoNascita = tipoDatiRispostaEstrazioneSoggetti.getAttoNascita();
							if (attoNascita != null) {
								datiAnagraficiGenerali.setComuneNascita(attoNascita.getComuneRegistrazione().getCodiceIstat());
								Comune comuneByCodiceISTAT = comuneLocalService.getComuneByCodiceISTAT(attoNascita.getComuneRegistrazione().getCodiceIstat());
								Provincia provincia = comuneByCodiceISTAT.getProvincia();
								if (provincia != null) {
									datiAnagraficiGenerali.setProvinciaNascita(provincia.getSigla());
								}
							}
							XMLGregorianCalendar dataNascita = generalita.getDataNascita();
							if (dataNascita != null) {
								datiAnagraficiGenerali.setDataNascita(dataNascita.toGregorianCalendar().getTime());
								if (generalita.getSenzaGiorno() != null && generalita.getSenzaGiorno().equals("1")) {
									datiAnagraficiGenerali.setDataNascitaSenzaGiorno(true);
								}
								if (generalita.getSenzaGiornoMese() != null && generalita.getSenzaGiornoMese().equals("1")) {
									datiAnagraficiGenerali.setDataNascitaSenzaGiornoMese(true);
								}
							}
							break;
						}
					}
				}
			}
		}

		return datiAnagraficiGenerali;
	}
}
