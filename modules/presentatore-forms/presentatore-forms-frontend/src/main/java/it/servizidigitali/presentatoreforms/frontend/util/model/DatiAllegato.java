package it.servizidigitali.presentatoreforms.frontend.util.model;

import java.util.List;

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;

/**
 * Un bean che collega una definizione allegato con un file allegato ed eventuale lista dei
 * documenti personali dell'utente (provenienti dal profilo utente).
 *
 * @author Davide Pastore
 * @author Gianluca Pindinelli
 *
 */
public class DatiAllegato {

	private DefinizioneAllegato definizione;
	private DatiFileAllegato datiFile;
	private List<DatiDocumentoPersonale> documentiPersonali;

	public DefinizioneAllegato getDefinizione() {
		return definizione;
	}

	public void setDefinizione(DefinizioneAllegato definizione) {
		this.definizione = definizione;
	}

	public DatiFileAllegato getDatiFile() {
		return datiFile;
	}

	public void setDatiFile(DatiFileAllegato datiFile) {
		this.datiFile = datiFile;
	}

	/**
	 * @return the documentiPersonali
	 */
	public List<DatiDocumentoPersonale> getDocumentiPersonali() {
		return documentiPersonali;
	}

	/**
	 * @param documentiPersonali the documentiPersonali to set
	 */
	public void setDocumentiPersonali(List<DatiDocumentoPersonale> documentiPersonali) {
		this.documentiPersonali = documentiPersonali;
	}

}
