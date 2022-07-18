package it.servizidigitali.backoffice.integration.converter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali.PosizioneElettorale;
import it.servizidigitali.backoffice.integration.util.DateUtils;
import noNamespace.PosizioniElettorali;

/**
 * @author pindi
 *
 */
@Component(immediate = true, service = DatiElettoraliConverter.class)
public class DatiElettoraliConverter {

	private static final Log log = LogFactoryUtil.getLog(DatiElettoraliConverter.class.getName());

	private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 *
	 * @param datiElettoraliBackOffice
	 * @return
	 */
	public DatiElettorali convert(noNamespace.DatiElettoraliDocument.DatiElettorali datiElettoraliBackOffice) {

		DatiElettorali datiElettorali = null;

		if (datiElettoraliBackOffice != null) {
			datiElettorali = new DatiElettorali();
			PosizioniElettorali[] posizioniElettoraliCripal = datiElettoraliBackOffice.getPosizioniElettoraliArray();
			if (posizioniElettoraliCripal != null) {
				List<PosizioneElettorale> posizioniElettorali = new ArrayList<>();
				for (PosizioniElettorali posizioneElettoraleCripal : posizioniElettoraliCripal) {
					PosizioneElettorale posizioneElettorale = new PosizioneElettorale();
					posizioneElettorale.setAnnoIscrizione(posizioneElettoraleCripal.getAnnoIscrizioneElett() != 0 ? String.valueOf(posizioneElettoraleCripal.getAnnoIscrizioneElett()) : null);
					posizioneElettorale.setDataRilascioTesseraElettorale(DateUtils.getUniversalDateFromCalendar(posizioneElettoraleCripal.getDataRilascioTesseraElett()));
					posizioneElettorale.setDataVerbaleIscrizione(DateUtils.getUniversalDateFromCalendar(posizioneElettoraleCripal.getDataVerbaleIscrizione()));
					try {
						posizioneElettorale.setDataVerbaleIscrizioneAlboScrutatori(
								posizioneElettoraleCripal.getDataVerbIscrAlboScrut() != null ? dateFormat.parse(posizioneElettoraleCripal.getDataVerbIscrAlboScrut()) : null);
					}
					catch (ParseException e) {
						log.error("convert :: " + e.getMessage());
					}
					posizioneElettorale.setDescrizioneLista(posizioneElettoraleCripal.getDescrizioneLista());
					posizioneElettorale.setDescrizioneVia(posizioneElettoraleCripal.getDescrizioneVia());
					posizioneElettorale.setEsponente(posizioneElettoraleCripal.getEsponente());
					posizioneElettorale.setInterno(posizioneElettoraleCripal.getInterno());
					posizioneElettorale.setIscrizioneAlboPresidente(posizioneElettoraleCripal.getIscrizioneAlboPresidente());
					posizioneElettorale.setIscrizioneAlboScrutatori(posizioneElettoraleCripal.getIscrizioneAlboScrutatori());
					posizioneElettorale.setNumeroCivico(posizioneElettoraleCripal.getNumeroCivico());
					posizioneElettorale.setNumeroFascicolo(posizioneElettoraleCripal.getNumeroFascicolo());
					posizioneElettorale.setNumeroListaGenerale(posizioneElettoraleCripal.getNumeroListaGenerale());
					posizioneElettorale.setNumeroListaSezionale(posizioneElettoraleCripal.getNumeroListaSezionale());
					posizioneElettorale.setNumeroSezione(posizioneElettoraleCripal.getNumeroSezione());
					posizioneElettorale.setNumeroTesseraElettorale(posizioneElettoraleCripal.getNumeroTesseraElettorale());
					posizioneElettorale.setNumeroVerbaleIscrizione(posizioneElettoraleCripal.getNumVerbaleIscrizione());
					posizioneElettorale.setNumeroVerbaleIscrizioneAlboScrutatori(posizioneElettoraleCripal.getNumVerbIscrAlboScrut());
					posizioneElettorale.setPiano(posizioneElettoraleCripal.getPiano());
					posizioneElettorale.setScala(posizioneElettoraleCripal.getScala());
					posizioneElettorale.setTipoElettore(posizioneElettoraleCripal.getTipoElettore());
					posizioneElettorale.setToponimoIndirizzo(posizioneElettoraleCripal.getToponimoIndirizzo());

					posizioniElettorali.add(posizioneElettorale);
				}

				datiElettorali.setPosizioniElettorali(posizioniElettorali);
			}
		}

		return datiElettorali;
	}
}
