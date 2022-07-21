package it.servizidigitali.backoffice.integration.model.anagrafe;

import java.io.Serializable;
import java.util.Date;

public class DatiAnagraficiGenerali implements Serializable {

	private static final long serialVersionUID = 2374477208461436852L;

	private String nome;
	private String cognome;
	private Date dataNascita;
	private boolean dataNascitaSenzaGiorno;
	private boolean dataNascitaSenzaGiornoMese;
	private String comuneNascita;
	private String provinciaNascita;
	private String indirizzo;
	private String cap;
	private String comuneResidenza;
	private String provinciaResidenza;
	private String codiceIstatResidenza;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the dataNascita
	 */
	public Date getDataNascita() {
		return dataNascita;
	}

	/**
	 * @param dataNascita the dataNascita to set
	 */
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	/**
	 * @return the comuneNascita
	 */
	public String getComuneNascita() {
		return comuneNascita;
	}

	/**
	 * @param comuneNascita the comuneNascita to set
	 */
	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}

	/**
	 * @return the provinciaNascita
	 */
	public String getProvinciaNascita() {
		return provinciaNascita;
	}

	/**
	 * @param provinciaNascita the provinciaNascita to set
	 */
	public void setProvinciaNascita(String provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}

	/**
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * @return the cap
	 */
	public String getCap() {
		return cap;
	}

	/**
	 * @param cap the cap to set
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}

	/**
	 * @return the comuneResidenza
	 */
	public String getComuneResidenza() {
		return comuneResidenza;
	}

	/**
	 * @param comuneResidenza the comuneResidenza to set
	 */
	public void setComuneResidenza(String comuneResidenza) {
		this.comuneResidenza = comuneResidenza;
	}

	/**
	 * @return the provinciaResidenza
	 */
	public String getProvinciaResidenza() {
		return provinciaResidenza;
	}

	/**
	 * @param provinciaResidenza the provinciaResidenza to set
	 */
	public void setProvinciaResidenza(String provinciaResidenza) {
		this.provinciaResidenza = provinciaResidenza;
	}

	/**
	 * @return the codiceIstatResidenza
	 */
	public String getCodiceIstatResidenza() {
		return codiceIstatResidenza;
	}

	/**
	 * @param codiceIstatResidenza the codiceIstatResidenza to set
	 */
	public void setCodiceIstatResidenza(String codiceIstatResidenza) {
		this.codiceIstatResidenza = codiceIstatResidenza;
	}

	/**
	 * @return the dataNascitaSenzaGiorno
	 */
	public boolean isDataNascitaSenzaGiorno() {
		return dataNascitaSenzaGiorno;
	}

	/**
	 * @param dataNascitaSenzaGiorno the dataNascitaSenzaGiorno to set
	 */
	public void setDataNascitaSenzaGiorno(boolean dataNascitaSenzaGiorno) {
		this.dataNascitaSenzaGiorno = dataNascitaSenzaGiorno;
	}

	/**
	 * @return the dataNascitaSenzaGiornoMese
	 */
	public boolean isDataNascitaSenzaGiornoMese() {
		return dataNascitaSenzaGiornoMese;
	}

	/**
	 * @param dataNascitaSenzaGiornoMese the dataNascitaSenzaGiornoMese to set
	 */
	public void setDataNascitaSenzaGiornoMese(boolean dataNascitaSenzaGiornoMese) {
		this.dataNascitaSenzaGiornoMese = dataNascitaSenzaGiornoMese;
	}

}
