package it.servizidigitali.backoffice.integration.converter.cripal;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagraficiGenerali;
import it.servizidigitali.backoffice.integration.util.DateUtils;
import noNamespace.DatiUtenteDocument.DatiUtente;

/**
 * @author pindi
 *
 */
@Component(immediate = true, service = DatiAnagraficiGeneraliConverter.class)
public class DatiAnagraficiGeneraliConverter {

	/**
	 *
	 * @param datiUtente
	 * @return
	 */
	public DatiAnagraficiGenerali convert(DatiUtente datiUtente) {

		DatiAnagraficiGenerali datiAnagraficiGenerali = null;

		if (datiUtente != null) {
			datiAnagraficiGenerali = new DatiAnagraficiGenerali();

			datiAnagraficiGenerali.setCap(datiUtente.getCap());
			datiAnagraficiGenerali.setCodiceIstatResidenza(datiUtente.getCodiceIstatResidenza());
			datiAnagraficiGenerali.setIndirizzo(datiUtente.getIndirizzo());
			datiAnagraficiGenerali.setComuneResidenza(datiUtente.getComuneResidenza());
			datiAnagraficiGenerali.setCognome(datiUtente.getCognome());
			datiAnagraficiGenerali.setNome(datiUtente.getNome());
			datiAnagraficiGenerali.setComuneNascita(datiUtente.getComuneNascita());
			datiAnagraficiGenerali.setProvinciaNascita(datiUtente.getProvinciaNascita());
			datiAnagraficiGenerali.setDataNascita(DateUtils.getUniversalDateFromCalendar(datiUtente.getDataNascita()));
		}

		return datiAnagraficiGenerali;
	}
}
