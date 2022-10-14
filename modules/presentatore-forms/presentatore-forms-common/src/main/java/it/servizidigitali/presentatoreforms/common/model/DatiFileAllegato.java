package it.servizidigitali.presentatoreforms.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import it.servizidigitali.presentatoreforms.common.util.ByteUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatiFileAllegato {

	long idDefinizioneAllegato;

	private Long id;
	private String idDocumentale;
	private String idTemporaneo;
	private String fileName;
	private Date dataInserimento;

	/* CAMPI DI SUPPORTO USATI IN FASE DI VISUALIZZAZIONE */
	private String descrizione;
	private long dimensione;
	private boolean personale;
	/* END */

	private boolean principale;
	private byte[] contenuto;

	/**
	 * @return the idDocumentale
	 */
	public String getIdDocumentale() {
		return idDocumentale;
	}

	/**
	 * @param idDocumentale the idDocumentale to set
	 */
	public void setIdDocumentale(final String idDocumentale) {
		this.idDocumentale = idDocumentale;
	}

	/**
	 * @return the idTemporaneo
	 */
	public String getIdTemporaneo() {
		return idTemporaneo;
	}

	/**
	 * @param idTemporaneo the idTemporaneo to set
	 */
	public void setIdTemporaneo(final String idTemporaneo) {
		this.idTemporaneo = idTemporaneo;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 */
	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the idDefinizioneAllegato
	 */
	public long getIdDefinizioneAllegato() {
		return idDefinizioneAllegato;
	}

	/**
	 * @param idDefinizioneAllegato
	 */
	public void setIdDefinizioneAllegato(final long idDefinizioneAllegato) {
		this.idDefinizioneAllegato = idDefinizioneAllegato;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione
	 */
	public void setDescrizione(final String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the dimensione
	 */
	public long getDimensione() {
		return dimensione;
	}

	/**
	 * @param dimensione
	 */
	public void setDimensione(final long dimensione) {
		this.dimensione = dimensione;
	}

	/**
	 * Restituisce la dimensione come una stringa human readable.
	 *
	 * @return Restituisce la dimensione come una stringa human readable.
	 */
	@JsonProperty("dimensioneAsString")
	public String generateDimensioneAsString() {
		return ByteUtil.humanReadableByteCount(dimensione, true);
	}

	/**
	 * @return the personale
	 */
	public boolean isPersonale() {
		return personale;
	}

	/**
	 * @param personale the personale to set
	 */
	public void setPersonale(boolean personale) {
		this.personale = personale;
	}

	/**
	 * @return the principale
	 */
	public boolean isPrincipale() {
		return principale;
	}

	/**
	 * @param principale the principale to set
	 */
	public void setPrincipale(boolean principale) {
		this.principale = principale;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
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

}
