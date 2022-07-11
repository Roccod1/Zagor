/************************************************************************************
 * Copyright (c) 2011, 2019 Link Management & Technology S.p.A. via R. Scotellaro, 55 73100 - Lecce
 * - http://www.linksmt.it - All rights reserved.
 *
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *************************************************************************************/
package it.osapulie.web.portlet.backoffice.converter.cripal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import it.osapulie.web.portlet.backoffice.converter.util.DateUtils;
import it.osapulie.web.portlet.backoffice.model.anagrafe.DatiElettorali;
import it.osapulie.web.portlet.backoffice.model.anagrafe.DatiElettorali.PosizioneElettorale;

/**
 * @author Gianluca Pindinelli
 *
 */
@Component
public class CRIPALToDatiElettoraliConverter {

	private final Logger log = LoggerFactory.getLogger(CRIPALToDatiElettoraliConverter.class.getName());

	private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 *
	 * @param datiElettoraliCripal
	 * @return
	 */
	public DatiElettorali convert(it.osapulie.anagrafe.web.ws.output.types.DatiElettorali datiElettoraliCripal) {

		DatiElettorali datiElettorali = null;

		if (datiElettoraliCripal != null) {
			datiElettorali = new DatiElettorali();
			List<it.osapulie.anagrafe.web.ws.output.types.PosizioniElettorali> posizioniElettoraliCripal = datiElettoraliCripal.getPosizioniElettorali();
			if (posizioniElettoraliCripal != null) {
				List<PosizioneElettorale> posizioniElettorali = new ArrayList<>();
				for (it.osapulie.anagrafe.web.ws.output.types.PosizioniElettorali posizioneElettoraleCripal : posizioniElettoraliCripal) {
					PosizioneElettorale posizioneElettorale = new PosizioneElettorale();
					posizioneElettorale.setAnnoIscrizione(posizioneElettoraleCripal.getAnnoIscrizioneElett() != null ? posizioneElettoraleCripal.getAnnoIscrizioneElett().toString() : null);
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
