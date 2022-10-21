package it.servizidigitali.gestionepagamenti.integration.common.client.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author pindi
 *
 */
public class Dovuto {

	private String iud;
	private String idCredito;
	private String stato;
	private String causale;

	private String idFiscaleCliente;
	private String denominazioneCliente;
	private String emailQuietanza;

	private BigDecimal importo;

	private Date dataScadenza;

	private String codiceDovuto;
	private String codiceOrganizzazione;

	/**
	 * @return the iud
	 */
	public String getIud() {
		return iud;
	}

	/**
	 * @param iud the iud to set
	 */
	public void setIud(String iud) {
		this.iud = iud;
	}

	/**
	 * @return the idCredito
	 */
	public String getIdCredito() {
		return idCredito;
	}

	/**
	 * @param idCredito the idCredito to set
	 */
	public void setIdCredito(String idCredito) {
		this.idCredito = idCredito;
	}

	/**
	 * @return the stato
	 */
	public String getStato() {
		return stato;
	}

	/**
	 * @param stato the stato to set
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/**
	 * @return the causale
	 */
	public String getCausale() {
		return causale;
	}

	/**
	 * @param causale the causale to set
	 */
	public void setCausale(String causale) {
		this.causale = causale;
	}

	/**
	 * @return the idFiscaleCliente
	 */
	public String getIdFiscaleCliente() {
		return idFiscaleCliente;
	}

	/**
	 * @param idFiscaleCliente the idFiscaleCliente to set
	 */
	public void setIdFiscaleCliente(String idFiscaleCliente) {
		this.idFiscaleCliente = idFiscaleCliente;
	}

	/**
	 * @return the denominazioneCliente
	 */
	public String getDenominazioneCliente() {
		return denominazioneCliente;
	}

	/**
	 * @param denominazioneCliente the denominazioneCliente to set
	 */
	public void setDenominazioneCliente(String denominazioneCliente) {
		this.denominazioneCliente = denominazioneCliente;
	}

	/**
	 * @return the emailQuietanza
	 */
	public String getEmailQuietanza() {
		return emailQuietanza;
	}

	/**
	 * @param emailQuietanza the emailQuietanza to set
	 */
	public void setEmailQuietanza(String emailQuietanza) {
		this.emailQuietanza = emailQuietanza;
	}

	/**
	 * @return the importo
	 */
	public BigDecimal getImporto() {
		return importo;
	}

	/**
	 * @param importo the importo to set
	 */
	public void setImporto(BigDecimal importo) {
		this.importo = importo;
	}

	/**
	 * @return the dataScadenza
	 */
	public Date getDataScadenza() {
		return dataScadenza;
	}

	/**
	 * @param dataScadenza the dataScadenza to set
	 */
	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	/**
	 * @return the codiceDovuto
	 */
	public String getCodiceDovuto() {
		return codiceDovuto;
	}

	/**
	 * @param codiceDovuto the codiceDovuto to set
	 */
	public void setCodiceDovuto(String codiceDovuto) {
		this.codiceDovuto = codiceDovuto;
	}

	/**
	 * @return the codiceOrganizzazione
	 */
	public String getCodiceOrganizzazione() {
		return codiceOrganizzazione;
	}

	/**
	 * @param codiceOrganizzazione the codiceOrganizzazione to set
	 */
	public void setCodiceOrganizzazione(String codiceOrganizzazione) {
		this.codiceOrganizzazione = codiceOrganizzazione;
	}

}
