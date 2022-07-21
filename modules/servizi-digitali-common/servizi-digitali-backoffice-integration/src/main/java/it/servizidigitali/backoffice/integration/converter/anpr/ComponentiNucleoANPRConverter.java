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
import it.servizidigitali.backoffice.integration.model.commmon.ComponenteNucleoFamiliare;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.sogei.anpr._3000consultazione.Risposta3002;
import it.sogei.anpr._3000consultazione.Risposta3002OK;
import it.sogei.anpr.tipodato.TipoCittadinanza;
import it.sogei.anpr.tipodato.TipoCivicoInterno;
import it.sogei.anpr.tipodato.TipoComune;
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
@Component(name = "componentiNucleoANPRConverter", immediate = true, service = ComponentiNucleoANPRConverter.class)
public class ComponentiNucleoANPRConverter {

	private static final Log log = LogFactoryUtil.getLog(ComponentiNucleoANPRConverter.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	/**
	 *
	 * @param risposta3002
	 * @return
	 */
	public List<ComponenteNucleoFamiliare> convert(Risposta3002 risposta3002) {

		List<ComponenteNucleoFamiliare> componentiNucleoFamiliare = null;

		Risposta3002OK risposta3002ok = risposta3002.getRisposta3002OK();
		if (risposta3002.getRispostaKO() == null && risposta3002ok != null) {
			TipoListaSoggetti listaSoggetti = risposta3002ok.getListaSoggetti();
			if (listaSoggetti != null) {
				List<TipoDatiRispostaEstrazioneSoggetti> datiSoggetto = listaSoggetti.getDatiSoggetto();
				if (datiSoggetto != null) {
					componentiNucleoFamiliare = new ArrayList<>();
					for (TipoDatiRispostaEstrazioneSoggetti tipoDatiRispostaEstrazioneSoggetti : datiSoggetto) {
						ComponenteNucleoFamiliare componenteNucleoFamiliare = new ComponenteNucleoFamiliare();
						TipoGeneralita generalita = tipoDatiRispostaEstrazioneSoggetti.getGeneralita();
						componenteNucleoFamiliare.setCodiceFiscale(generalita.getCodiceFiscale().getCodFiscale());
						componenteNucleoFamiliare.setCognome(generalita.getCognome());
						componenteNucleoFamiliare.setNome(generalita.getNome());
						componenteNucleoFamiliare.setSesso(generalita.getSesso());
						componenteNucleoFamiliare.setDataNascita(generalita.getDataNascita().toGregorianCalendar().getTime());
						componenteNucleoFamiliare.setIdentificativoNucleo(tipoDatiRispostaEstrazioneSoggetti.getFamigliaConvivenza().getIdFamigliaConvivenzaComune().getIdFamigliaConvivenza());

						// Stato civile
						try {
							componenteNucleoFamiliare.setStatoCivile(StatoCivile.getByCodice(Integer.parseInt(tipoDatiRispostaEstrazioneSoggetti.getStatoCivile().getStatoCivile())).getDescrizione());
						}
						catch (IllegalArgumentException e) {
							log.warn("getComponentiNucleoFamiliare :: " + e.getMessage());
							componenteNucleoFamiliare.setStatoCivile(tipoDatiRispostaEstrazioneSoggetti.getStatoCivile().getStatoCivile());
						}
						List<TipoCittadinanza> cittadinanza = tipoDatiRispostaEstrazioneSoggetti.getCittadinanza();
						if (cittadinanza != null) {
							for (TipoCittadinanza tipoCittadinanza : cittadinanza) {
								String codiceStato = tipoCittadinanza.getCodiceStato();
								if (codiceStato.equals("100")) {
									componenteNucleoFamiliare.setCittadinanzaItaliana(true);
									break;
								}
							}
						}
						// Stato nascita
						if (generalita.getLuogoNascita().getLocalita() != null) {
							StatoEstero statoEsteroByDenominazione = statoEsteroLocalService.getStatoEsteroByDenominazione(generalita.getLuogoNascita().getLocalita().getDescrizioneStato());
							if (statoEsteroByDenominazione != null) {
								componenteNucleoFamiliare.setCodiceStatoEsteroNascita(String.valueOf(statoEsteroByDenominazione.getCodiceStato()));
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
							componenteNucleoFamiliare.setIndirizzoResidenza(indirizzo.getToponimo().getSpecie() + " " + indirizzo.getToponimo().getDenominazioneToponimo());
							componenteNucleoFamiliare.setCapResidenza(indirizzo.getCap());
							TipoNumeroCivico numeroCivico = indirizzo.getNumeroCivico();
							if (numeroCivico != null) {
								String numeroCivicoString = numeroCivico.getNumero();
								if (numeroCivico.getEsponente1() != null && !numeroCivico.getEsponente1().equals("")) {
									numeroCivicoString += ", " + numeroCivico.getEsponente1();
								}
								componenteNucleoFamiliare.setCivicoResidenza(numeroCivicoString);
								TipoCivicoInterno civicoInterno = numeroCivico.getCivicoInterno();
								if (civicoInterno != null) {
									componenteNucleoFamiliare.setPianoResidenza(civicoInterno.getPiano());
									componenteNucleoFamiliare.setScalaResidenza(civicoInterno.getScala());
									componenteNucleoFamiliare.setInternoResidenza(civicoInterno.getInterno1());
								}
							}

							TipoComune comune = indirizzo.getComune();
							componenteNucleoFamiliare.setCodiceIstatComuneResidenza(comune.getCodiceIstat());
							// Telefono
							componenteNucleoFamiliare.setTelefono(null);
						}

						// Relazione di parentela
						String codiceLegameParentela = tipoDatiRispostaEstrazioneSoggetti.getLegameSoggetto().getCodiceLegame();
						try {
							componenteNucleoFamiliare.setRelazioneParentela(RelazioneParentela.getByCodice(Integer.parseInt(codiceLegameParentela)).getDescrizione());
						}
						catch (IllegalArgumentException e) {
							log.warn("getComponentiNucleoFamiliare :: " + e.getMessage());
							componenteNucleoFamiliare.setRelazioneParentela(codiceLegameParentela);
						}

						componentiNucleoFamiliare.add(componenteNucleoFamiliare);
					}
				}
			}
		}

		return componentiNucleoFamiliare;
	}
}
