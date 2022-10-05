package it.servizidigitali.scrivaniaoperatore.scheduler.model;

import java.util.Date;

public class FileAllegato {

	private long idDefinizioneAllegato;

	private Long id;
	private String idDocumentale;
	private String idTemporaneo;
	private String fileName;
	private Date dataInserimento;

	/**
	 * @return the idDefinizioneAllegato
	 */
	public long getIdDefinizioneAllegato() {
		return idDefinizioneAllegato;
	}

	/**
	 * @param idDefinizioneAllegato the idDefinizioneAllegato to set
	 */
	public void setIdDefinizioneAllegato(long idDefinizioneAllegato) {
		this.idDefinizioneAllegato = idDefinizioneAllegato;
	}

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
	 * @return the idTemporaneo
	 */
	public String getIdTemporaneo() {
		return idTemporaneo;
	}

	/**
	 * @param idTemporaneo the idTemporaneo to set
	 */
	public void setIdTemporaneo(String idTemporaneo) {
		this.idTemporaneo = idTemporaneo;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the dataInserimento
	 */
	public Date getDataInserimento() {
		return dataInserimento;
	}

	/**
	 * @param dataInserimento the dataInserimento to set
	 */
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
}
