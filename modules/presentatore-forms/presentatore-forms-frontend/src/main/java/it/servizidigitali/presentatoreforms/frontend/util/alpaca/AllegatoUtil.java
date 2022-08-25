package it.servizidigitali.presentatoreforms.frontend.util.alpaca;

import java.util.ArrayList;
import java.util.List;

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.presentatoreforms.frontend.util.model.DatiAllegato;
import it.servizidigitali.presentatoreforms.frontend.util.model.DatiFileAllegato;


/**
 * Allegato Util.
 * 
 * @author zonnog
 *
 */
public class AllegatoUtil {

	private static final String ALLEGATO_ID_TEMPORANEO_PREFIX = "allegato-";

	/**
	 * Unisce la definizione e i dati degli allegati.
	 * 
	 * @param definizioneAllegati La {@link List} di {@link DefinizioneAllegato}.
	 * @param datiFileAllegati La {@link List} di {@link DatiFileAllegato}.
	 * @return Restituisce la lista degli allegati con al suo interno la definizione e i suoi dati.
	 */
	public static List<DatiAllegato> mergeDefinizioneAndData(List<DefinizioneAllegato> definizioneAllegati, List<DatiFileAllegato> datiFileAllegati) {
		List<DatiAllegato> datiAllegati = new ArrayList<DatiAllegato>();
		for (DefinizioneAllegato definizioneAllegato : definizioneAllegati) {
			Long idDefinizioneAllegato = definizioneAllegato.getDefinizioneAllegatoId();
			DatiFileAllegato datiFileAllegatoFound = getDatiFileAllegatoByIdDefinizione(datiFileAllegati, idDefinizioneAllegato);
			DatiAllegato datiAllegato = new DatiAllegato();
			datiAllegato.setDatiFile(datiFileAllegatoFound);
			datiAllegato.setDefinizione(definizioneAllegato);
			datiAllegati.add(datiAllegato);
		}
		return datiAllegati;
	}

	/**
	 * Restituisce l'istanza {@link DatiFileAllegato} dal valore idDefinizioneAllegato passato.
	 * 
	 * @param datiAllegati La {@link List} di {@link DatiFileAllegato} su cui effettuare la ricerca.
	 * @param idDefinizioneAllegato L'id definizione allegato.
	 * @return Restituisce l'istanza {@link DatiFileAllegato}.
	 */
	public static DatiFileAllegato getDatiFileAllegatoByIdDefinizione(List<DatiFileAllegato> datiAllegati, Long idDefinizioneAllegato) {
		for (DatiFileAllegato datiFileAllegato : datiAllegati) {
			if (datiFileAllegato.getIdDefinizioneAllegato() == idDefinizioneAllegato.longValue()) {
				return datiFileAllegato;
			}
		}
		return null;
	}

}