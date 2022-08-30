package it.servizidigitali.presentatoreforms.frontend.service.input.jsonenrich.model;

/**
 * @author pindi
 *
 */
public class UserPreferences {

	private String codiceFiscaleRichiedente;
	private String codiceFiscaleComponente;

	/**
	 * @return the codiceFiscaleRichiedente
	 */
	public String getCodiceFiscaleRichiedente() {
		return codiceFiscaleRichiedente;
	}

	/**
	 * @param codiceFiscaleRichiedente the codiceFiscaleRichiedente to set
	 */
	public void setCodiceFiscaleRichiedente(String codiceFiscaleRichiedente) {
		this.codiceFiscaleRichiedente = codiceFiscaleRichiedente;
	}

	/**
	 * @return the codiceFiscaleComponente
	 */
	public String getCodiceFiscaleComponente() {
		return codiceFiscaleComponente;
	}

	/**
	 * @param codiceFiscaleComponente the codiceFiscaleComponente to set
	 */
	public void setCodiceFiscaleComponente(String codiceFiscaleComponente) {
		this.codiceFiscaleComponente = codiceFiscaleComponente;
	}

}
