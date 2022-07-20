package it.servizidigitali.backoffice.integration.converter.anpr;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali.PosizioneElettorale;
import it.sogei.anpr._3000consultazione.Risposta3002;
import it.sogei.anpr._3000consultazione.Risposta3002OK;
import it.sogei.anpr.tipodato.TipoComune;
import it.sogei.anpr.tipodato.TipoDatiRispostaEstrazioneSoggetti;
import it.sogei.anpr.tipodato.TipoGeneralita;
import it.sogei.anpr.tipodato.TipoListaElettorale;
import it.sogei.anpr.vocabolario3000consultazione.TipoListaSoggetti;

/**
 * @author pindi
 *
 */
@Component(name = "datiElettoraliANPRConverter", immediate = true, service = DatiElettoraliANPRConverter.class)
public class DatiElettoraliANPRConverter {

	/**
	 *
	 * @param risposta3002
	 * @param codiceFiscaleComponente
	 * @return
	 */
	public DatiElettorali convert(Risposta3002 risposta3002, String codiceFiscaleComponente) {

		DatiElettorali datiElettorali = null;

		Risposta3002OK risposta3002ok = risposta3002.getRisposta3002OK();
		if (risposta3002.getRispostaKO() == null && risposta3002ok != null) {
			TipoListaSoggetti listaSoggetti = risposta3002ok.getListaSoggetti();
			if (listaSoggetti != null) {
				List<TipoDatiRispostaEstrazioneSoggetti> datiSoggetto = listaSoggetti.getDatiSoggetto();
				if (datiSoggetto != null) {
					datiElettorali = new DatiElettorali();
					for (TipoDatiRispostaEstrazioneSoggetti tipoDatiRispostaEstrazioneSoggetti : datiSoggetto) {
						TipoGeneralita generalita = tipoDatiRispostaEstrazioneSoggetti.getGeneralita();
						String codFiscale = generalita.getCodiceFiscale().getCodFiscale();
						if (codFiscale.equals(codiceFiscaleComponente)) {

							List<PosizioneElettorale> posizioneElettorale = new ArrayList<DatiElettorali.PosizioneElettorale>();
							TipoListaElettorale listaElettorale = tipoDatiRispostaEstrazioneSoggetti.getListaElettorale();
							if (listaElettorale != null) {
								TipoComune comune = listaElettorale.getComune();
								break;
							}
						}
					}
				}
			}
		}

		return datiElettorali;
	}
}
