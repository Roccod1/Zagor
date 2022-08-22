package it.servizidigitali.communication.model;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @author pindi
 *
 */
public class Allegato implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String descrizione;
	private InputStream contenuto;
	private String tipoContenuto;
	private long dimensioni;

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
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the contenuto
	 */
	public InputStream getContenuto() {
		return contenuto;
	}

	/**
	 * @param contenuto the contenuto to set
	 */
	public void setContenuto(InputStream contenuto) {
		this.contenuto = contenuto;
	}

	/**
	 * @return the tipoContenuto
	 */
	public String getTipoContenuto() {
		return tipoContenuto;
	}

	/**
	 * @param tipoContenuto the tipoContenuto to set
	 */
	public void setTipoContenuto(String tipoContenuto) {
		this.tipoContenuto = tipoContenuto;
	}

	/**
	 * @return the dimensioni
	 */
	public long getDimensioni() {
		return dimensioni;
	}

	/**
	 * @param dimensioni the dimensioni to set
	 */
	public void setDimensioni(long dimensioni) {
		this.dimensioni = dimensioni;
	}

}
