package it.servizidigitali.presentatoreforms.frontend.service.integration.output.model;

/**
 * @author pindi
 *
 */
public class InfoAggiuntiva {

	private String descrizione;
	private String valore;

	public InfoAggiuntiva(String descrizione, String valore) {
		this.descrizione = descrizione;
		this.valore = valore;
	}

	/**
	 * Contiene la descrizione o la label da mostrare all'utente
	 * 
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * Contiene il valore da mostrare all'utente
	 * 
	 * @return the valore
	 */
	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

}
