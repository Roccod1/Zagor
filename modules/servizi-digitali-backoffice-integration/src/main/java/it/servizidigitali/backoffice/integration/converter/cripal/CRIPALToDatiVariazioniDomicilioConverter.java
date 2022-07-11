/************************************************************************************
 * Copyright (c) 2011, 2019 Link Management & Technology S.p.A. via R. Scotellaro, 55 73100 - Lecce
 * - http://www.linksmt.it - All rights reserved.
 *
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *************************************************************************************/
package it.osapulie.web.portlet.backoffice.converter.cripal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.osapulie.domain.Comune;
import it.osapulie.service.ComuneService;
import it.osapulie.web.portlet.backoffice.converter.util.DateUtils;
import it.osapulie.web.portlet.backoffice.model.anagrafe.DatiVariazioniDomicilio;
import it.osapulie.web.portlet.backoffice.model.anagrafe.DatiVariazioniDomicilio.VariazioneDomicilio;

/**
 * @author Gianluca Pindinelli
 *
 */
@Component
public class CRIPALToDatiVariazioniDomicilioConverter {

	@Autowired
	private ComuneService comuneService;

	/**
	 *
	 * @param datiElettoraliCripal
	 * @return
	 */
	public DatiVariazioniDomicilio convert(it.osapulie.anagrafe.web.ws.output.types.DatiIndirizzo datiIndirizzoCripal) {

		DatiVariazioniDomicilio datiVariazioniDomicilio = null;

		if (datiIndirizzoCripal != null) {
			datiVariazioniDomicilio = new DatiVariazioniDomicilio();

			List<it.osapulie.anagrafe.web.ws.output.types.DatiIndirizzo.VariazioniDomicilio> variazioniDomicilioCripal = datiIndirizzoCripal.getVariazioniDomicilio();
			if (variazioniDomicilioCripal != null) {
				List<VariazioneDomicilio> variazioniDomicilio = new ArrayList<>();
				for (it.osapulie.anagrafe.web.ws.output.types.DatiIndirizzo.VariazioniDomicilio variazioneDomicilioCripal : variazioniDomicilioCripal) {
					VariazioneDomicilio variazioneDomicilio = new VariazioneDomicilio();
					Comune comuneByName = comuneService.getComuneByName(variazioneDomicilioCripal.getDescComune());
					variazioneDomicilio.setCodiceIstatComune(comuneByName != null ? comuneByName.getCodiceIstatAN() : null);
					variazioneDomicilio.setDataInizioDomicilio(DateUtils.getUniversalDateFromCalendar(variazioneDomicilioCripal.getDataInizioInd()));
					variazioneDomicilio.setDataIscrizioneComune(DateUtils.getUniversalDateFromCalendar(variazioneDomicilioCripal.getDataIscrizioneCom()));
					variazioneDomicilio.setEsponente(variazioneDomicilioCripal.getEsponenteSto());
					variazioneDomicilio.setIndirizzo(variazioneDomicilioCripal.getDescrizioneViaSto());
					variazioneDomicilio.setInterno(variazioneDomicilioCripal.getInternoSto());
					variazioneDomicilio.setNumeroCivico(variazioneDomicilioCripal.getNumeroCivicoSto());
					variazioneDomicilio.setPiano(variazioneDomicilioCripal.getPianoSto());
					variazioneDomicilio.setScala(variazioneDomicilioCripal.getScalaSto());
					variazioneDomicilio.setToponimoIndirizzo(variazioneDomicilioCripal.getDescrizioneTopSto());
					variazioniDomicilio.add(variazioneDomicilio);
				}

				datiVariazioniDomicilio.setVariazioniDomicilio(variazioniDomicilio);

			}
		}

		return datiVariazioniDomicilio;
	}
}
