/************************************************************************************
 * Copyright (c) 2011, 2019 Link Management & Technology S.p.A. via R. Scotellaro, 55 73100 - Lecce
 * - http://www.linksmt.it - All rights reserved.
 *
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *************************************************************************************/
package it.servizidigitali.backoffice.integration.converter.cripal;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio.VariazioneDomicilio;
import it.servizidigitali.backoffice.integration.util.DateUtils;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.service.ComuneLocalService;
import noNamespace.DatiIndirizzo;
import noNamespace.DatiIndirizzo.VariazioniDomicilio;

/**
 * @author Gianluca Pindinelli
 *
 */
@Component(immediate = true, service = DatiVariazioniDomicilioConverter.class)
public class DatiVariazioniDomicilioConverter {

	@Reference
	private ComuneLocalService comuneLocalService;

	/**
	 *
	 * @param datiIndirizzoBackOffice
	 * @return
	 */
	public DatiVariazioniDomicilio convert(DatiIndirizzo datiIndirizzoBackOffice) {

		DatiVariazioniDomicilio datiVariazioniDomicilio = null;

		if (datiIndirizzoBackOffice != null) {
			datiVariazioniDomicilio = new DatiVariazioniDomicilio();

			VariazioniDomicilio[] variazioniDomicilioCripal = datiIndirizzoBackOffice.getVariazioniDomicilioArray();
			if (variazioniDomicilioCripal != null) {
				List<VariazioneDomicilio> variazioniDomicilio = new ArrayList<>();
				for (VariazioniDomicilio variazioneDomicilioCripal : variazioniDomicilioCripal) {
					VariazioneDomicilio variazioneDomicilio = new VariazioneDomicilio();
					Comune comuneByName = comuneLocalService.getComuneByDenominazione(variazioneDomicilioCripal.getDescComune());
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
