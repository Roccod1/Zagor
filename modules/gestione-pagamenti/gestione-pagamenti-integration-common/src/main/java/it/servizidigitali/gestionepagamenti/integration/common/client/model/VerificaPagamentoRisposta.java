package it.servizidigitali.gestionepagamenti.integration.common.client.model;

import java.io.InputStream;
import java.math.BigDecimal;

import it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.StatoPagamento;

/**
 *
 * @author pindi
 *
 */
public class VerificaPagamentoRisposta {

	private String codiceIuv;
	private StatoPagamento statoPagamento;
	private String idRichiesta;
	private BigDecimal importoCommissioni;
	private String codiceErrore;
	private String descrizioneErrore;
	private InputStream ricevutaPagamento;

	/**
	 * @return the codiceIuv
	 */
	public String getCodiceIuv() {
		return codiceIuv;
	}

	/**
	 * @param codiceIuv the codiceIuv to set
	 */
	public void setCodiceIuv(String codiceIuv) {
		this.codiceIuv = codiceIuv;
	}

	/**
	 * @return the statoPagamento
	 */
	public StatoPagamento getStatoPagamento() {
		return statoPagamento;
	}

	/**
	 * @param statoPagamento the statoPagamento to set
	 */
	public void setStatoPagamento(StatoPagamento statoPagamento) {
		this.statoPagamento = statoPagamento;
	}

	/**
	 * @return the idRichiesta
	 */
	public String getIdRichiesta() {
		return idRichiesta;
	}

	/**
	 * @param idRichiesta the idRichiesta to set
	 */
	public void setIdRichiesta(String idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	/**
	 * @return the importoCommissioni
	 */
	public BigDecimal getImportoCommissioni() {
		return importoCommissioni;
	}

	/**
	 * @param importoCommissioni the importoCommissioni to set
	 */
	public void setImportoCommissioni(BigDecimal importoCommissioni) {
		this.importoCommissioni = importoCommissioni;
	}

	/**
	 * @return the codiceErrore
	 */
	public String getCodiceErrore() {
		return codiceErrore;
	}

	/**
	 * @param codiceErrore the codiceErrore to set
	 */
	public void setCodiceErrore(String codiceErrore) {
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
	 * @return the ricevutaPagamento
	 */
	public InputStream getRicevutaPagamento() {
		return ricevutaPagamento;
	}

	/**
	 * @param ricevutaPagamento the ricevutaPagamento to set
	 */
	public void setRicevutaPagamento(InputStream ricevutaPagamento) {
		this.ricevutaPagamento = ricevutaPagamento;
	}

}
