package it.servizidigitali.presentatoreforms.frontend.service.integration.output.model;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * @author pindi
 *
 */
public class DichiarazioneRisposta {

	private String idPratica;
	private Date dataInserimento;
	private Long numeroProtocollo;
	private Date dataProtocollo;
	private Integer codiceErrore;
	private String descrizioneErrore;
	private LinkedHashMap<String, InfoAggiuntiva> infoAggiuntive;

	/**
	 * @return the idPratica
	 */
	public String getIdPratica() {
		return idPratica;
	}

	/**
	 * @param idPratica the idPratica to set
	 */
	public void setIdPratica(String idPratica) {
		this.idPratica = idPratica;
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

	/**
	 * @return the numeroProtocollo
	 */
	public Long getNumeroProtocollo() {
		return numeroProtocollo;
	}

	/**
	 * @param numeroProtocollo the numeroProtocollo to set
	 */
	public void setNumeroProtocollo(Long numeroProtocollo) {
		this.numeroProtocollo = numeroProtocollo;
	}

	/**
	 * @return the dataProtocollo
	 */
	public Date getDataProtocollo() {
		return dataProtocollo;
	}

	/**
	 * @param dataProtocollo the dataProtocollo to set
	 */
	public void setDataProtocollo(Date dataProtocollo) {
		this.dataProtocollo = dataProtocollo;
	}

	/**
	 * @return the codiceErrore
	 */
	public Integer getCodiceErrore() {
		return codiceErrore;
	}

	/**
	 * @param codiceErrore the codiceErrore to set
	 */
	public void setCodiceErrore(Integer codiceErrore) {
		this.codiceErrore = codiceErrore;
	}

	/**
	 * @return the descrizioneErrore
	 */
	public String getDescrizioneErrore() {
		return descrizioneErrore;
	}

	/**
	 * @param descrizioneErrore the descrizioneErrore to set
	 */
	public void setDescrizioneErrore(String descrizioneErrore) {
		this.descrizioneErrore = descrizioneErrore;
	}

	/**
	 * @return the infoAggiuntive
	 */
	public LinkedHashMap<String, InfoAggiuntiva> getInfoAggiuntive() {
		return infoAggiuntive;
	}

	/**
	 * @param infoAggiuntive the infoAggiuntive to set
	 */
	public void setInfoAggiuntive(LinkedHashMap<String, InfoAggiuntiva> infoAggiuntiva) {
		this.infoAggiuntive = infoAggiuntiva;
	}

}
