package it.servizidigitali.scrivaniaoperatore.frontend.dto;

public class AllegatoDTO {

	private Long id;
	private String titolo;
	private String descrizione;
	private String nomeFile;
	private String dimensione;
	private boolean visibileAlCittadino;
	private String nomeOperatore;

	private byte[] contenuto;
	private String idDocumentale;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the nomeFile
	 */
	public String getNomeFile() {
		return nomeFile;
	}

	/**
	 * @param nomeFile the nomeFile to set
	 */
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	/**
	 * @return the dimensione
	 */
	public String getDimensione() {
		return dimensione;
	}

	/**
	 * @param dimensione the dimensione to set
	 */
	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}

	/**
	 * @return the visibileAlCittadino
	 */
	public boolean isVisibileAlCittadino() {
		return visibileAlCittadino;
	}

	/**
	 * @param visibileAlCittadino the visibileAlCittadino to set
	 */
	public void setVisibileAlCittadino(boolean visibileAlCittadino) {
		this.visibileAlCittadino = visibileAlCittadino;
	}

	/**
	 * @return the nomeOperatore
	 */
	public String getNomeOperatore() {
		return nomeOperatore;
	}

	/**
	 * @param nomeOperatore the nomeOperatore to set
	 */
	public void setNomeOperatore(String nomeOperatore) {
		this.nomeOperatore = nomeOperatore;
	}

	/**
	 * @return the contenuto
	 */
	public byte[] getContenuto() {
		return contenuto;
	}

	/**
	 * @param contenuto the contenuto to set
	 */
	public void setContenuto(byte[] contenuto) {
		this.contenuto = contenuto;
	}

	/**
	 * @return the idDocumentale
	 */
	public String getIdDocumentale() {
		return idDocumentale;
	}

	/**
	 * @param idDocumentale the idDocumentale to set
	 */
	public void setIdDocumentale(String idDocumentale) {
		this.idDocumentale = idDocumentale;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

}
