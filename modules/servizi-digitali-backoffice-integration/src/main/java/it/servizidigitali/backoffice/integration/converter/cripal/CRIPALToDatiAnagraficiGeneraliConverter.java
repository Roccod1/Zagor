/************************************************************************************
 * Copyright (c) 2011, 2019 Link Management & Technology S.p.A. via R. Scotellaro, 55 73100 - Lecce
 * - http://www.linksmt.it - All rights reserved.
 *
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *************************************************************************************/
package it.osapulie.web.portlet.backoffice.converter.cripal;

import org.springframework.stereotype.Component;

import it.osapulie.anagrafe.web.ws.output.types.DatiUtente;
import it.osapulie.web.portlet.backoffice.converter.util.DateUtils;
import it.osapulie.web.portlet.backoffice.model.anagrafe.DatiAnagraficiGenerali;

/**
 * @author Gianluca Pindinelli
 *
 */
@Component
public class CRIPALToDatiAnagraficiGeneraliConverter {

	/**
	 *
	 * @param risposta3002
	 * @return
	 */
	public DatiAnagraficiGenerali convert(DatiUtente datiUtenteCRIPAL) {

		DatiAnagraficiGenerali datiAnagraficiGenerali = null;

		if (datiUtenteCRIPAL != null) {
			datiAnagraficiGenerali = new DatiAnagraficiGenerali();

			datiAnagraficiGenerali.setCap(datiUtenteCRIPAL.getCap());
			datiAnagraficiGenerali.setCodiceIstatResidenza(datiUtenteCRIPAL.getCodiceIstatResidenza());
			datiAnagraficiGenerali.setIndirizzo(datiUtenteCRIPAL.getIndirizzo());
			datiAnagraficiGenerali.setComuneResidenza(datiUtenteCRIPAL.getComuneResidenza());
			datiAnagraficiGenerali.setCognome(datiUtenteCRIPAL.getCognome());
			datiAnagraficiGenerali.setNome(datiUtenteCRIPAL.getNome());
			datiAnagraficiGenerali.setComuneNascita(datiUtenteCRIPAL.getComuneNascita());
			datiAnagraficiGenerali.setProvinciaNascita(datiUtenteCRIPAL.getProvinciaNascita());
			datiAnagraficiGenerali.setDataNascita(DateUtils.getUniversalDateFromCalendar(datiUtenteCRIPAL.getDataNascita()));
		}

		return datiAnagraficiGenerali;
	}
}
