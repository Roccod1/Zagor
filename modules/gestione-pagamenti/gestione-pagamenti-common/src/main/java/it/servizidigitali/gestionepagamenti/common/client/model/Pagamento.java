package it.servizidigitali.gestionepagamenti.common.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @author pindi
 *
 */
public class Pagamento {

	private String idPagamento;
	private String idCredito;
	private String stato;
	private String causale;

	private String idFiscaleCliente;
	private String denominazioneCliente;
	private String emailQuietanza;

	private String idServizio;
	private String descrizioneServizio;

	private BigDecimal importoServizio;
	private BigDecimal importoGateway;
	private BigDecimal importoTotale;

	private Map<String, Object> infoAggiuntive;
	private Map<String, Object> infoAggiuntiveGateway;
	private Map<String, Object> infoAggiuntiveUtenteGateway;

	private Date dataInserimento;
	private Date dataOperazione;
	private Date dataScadenza;

	private String codiceIban;
	private String denominazioneConto;
	private String denominazioneGateway;

	private String idFiscaleOrganizzazione;
	private String codiceIdentificativoOrganizzazione;
	private String denominazioneOrganizzazione;

	private String codiceCategoriaServizio;
	private String denominazioneCategoriaServizio;

	private boolean downloadAvviso;
	private boolean scadenzaObbligatoria;
	private String pathAvviso;

	private String codiceIUV;

	/**
	 * @return the idPagamento
	 */
	public String getIdPagamento() {
		return idPagamento;
	}

	/**
	 * @param idPagamento the idPagamento to set
	 */
	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
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
	 * @return the idServizio
	 */
	public String getIdServizio() {
		return idServizio;
	}

	/**
	 * @param idServizio the idServizio to set
	 */
	public void setIdServizio(String idServizio) {
		this.idServizio = idServizio;
	}

	/**
	 * @return the descrizioneServizio
	 */
	public String getDescrizioneServizio() {
		return descrizioneServizio;
	}

	/**
	 * @param descrizioneServizio the descrizioneServizio to set
	 */
	public void setDescrizioneServizio(String descrizioneServizio) {
		this.descrizioneServizio = descrizioneServizio;
	}

	/**
	 * @return the importoServizio
	 */
	public BigDecimal getImportoServizio() {
		return importoServizio;
	}

	/**
	 * @param importoServizio the importoServizio to set
	 */
	public void setImportoServizio(BigDecimal importoServizio) {
		this.importoServizio = importoServizio;
	}

	/**
	 * @return the importoGateway
	 */
	public BigDecimal getImportoGateway() {
		return importoGateway;
	}

	/**
	 * @param importoGateway the importoGateway to set
	 */
	public void setImportoGateway(BigDecimal importoGateway) {
		this.importoGateway = importoGateway;
	}

	/**
	 * @return the importoTotale
	 */
	public BigDecimal getImportoTotale() {
		return importoTotale;
	}

	/**
	 * @param importoTotale the importoTotale to set
	 */
	public void setImportoTotale(BigDecimal importoTotale) {
		this.importoTotale = importoTotale;
	}

	/**
	 * @return the infoAggiuntive
	 */
	public Map<String, Object> getInfoAggiuntive() {
		return infoAggiuntive;
	}

	/**
	 * @param infoAggiuntive the infoAggiuntive to set
	 */
	public void setInfoAggiuntive(Map<String, Object> infoAggiuntive) {
		this.infoAggiuntive = infoAggiuntive;
	}

	/**
	 * @return the infoAggiuntiveGateway
	 */
	public Map<String, Object> getInfoAggiuntiveGateway() {
		return infoAggiuntiveGateway;
	}

	/**
	 * @param infoAggiuntiveGateway the infoAggiuntiveGateway to set
	 */
	public void setInfoAggiuntiveGateway(Map<String, Object> infoAggiuntiveGateway) {
		this.infoAggiuntiveGateway = infoAggiuntiveGateway;
	}

	/**
	 * @return the infoAggiuntiveUtenteGateway
	 */
	public Map<String, Object> getInfoAggiuntiveUtenteGateway() {
		return infoAggiuntiveUtenteGateway;
	}

	/**
	 * @param infoAggiuntiveUtenteGateway the infoAggiuntiveUtenteGateway to set
	 */
	public void setInfoAggiuntiveUtenteGateway(Map<String, Object> infoAggiuntiveUtenteGateway) {
		this.infoAggiuntiveUtenteGateway = infoAggiuntiveUtenteGateway;
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
	 * @return the dataOperazione
	 */
	public Date getDataOperazione() {
		return dataOperazione;
	}

	/**
	 * @param dataOperazione the dataOperazione to set
	 */
	public void setDataOperazione(Date dataOperazione) {
		this.dataOperazione = dataOperazione;
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
	 * @return the codiceIban
	 */
	public String getCodiceIban() {
		return codiceIban;
	}

	/**
	 * @param codiceIban the codiceIban to set
	 */
	public void setCodiceIban(String codiceIban) {
		this.codiceIban = codiceIban;
	}

	/**
	 * @return the denominazioneConto
	 */
	public String getDenominazioneConto() {
		return denominazioneConto;
	}

	/**
	 * @param denominazioneConto the denominazioneConto to set
	 */
	public void setDenominazioneConto(String denominazioneConto) {
		this.denominazioneConto = denominazioneConto;
	}

	/**
	 * @return the denominazioneGateway
	 */
	public String getDenominazioneGateway() {
		return denominazioneGateway;
	}

	/**
	 * @param denominazioneGateway the denominazioneGateway to set
	 */
	public void setDenominazioneGateway(String denominazioneGateway) {
		this.denominazioneGateway = denominazioneGateway;
	}

	/**
	 * @return the idFiscaleOrganizzazione
	 */
	public String getIdFiscaleOrganizzazione() {
		return idFiscaleOrganizzazione;
	}

	/**
	 * @param idFiscaleOrganizzazione the idFiscaleOrganizzazione to set
	 */
	public void setIdFiscaleOrganizzazione(String idFiscaleOrganizzazione) {
		this.idFiscaleOrganizzazione = idFiscaleOrganizzazione;
	}

	/**
	 * @return the codiceIdentificativoOrganizzazione
	 */
	public String getCodiceIdentificativoOrganizzazione() {
		return codiceIdentificativoOrganizzazione;
	}

	/**
	 * @param codiceIdentificativoOrganizzazione the codiceIdentificativoOrganizzazione to set
	 */
	public void setCodiceIdentificativoOrganizzazione(String codiceIdentificativoOrganizzazione) {
		this.codiceIdentificativoOrganizzazione = codiceIdentificativoOrganizzazione;
	}

	/**
	 * @return the denominazioneOrganizzazione
	 */
	public String getDenominazioneOrganizzazione() {
		return denominazioneOrganizzazione;
	}

	/**
	 * @param denominazioneOrganizzazione the denominazioneOrganizzazione to set
	 */
	public void setDenominazioneOrganizzazione(String denominazioneOrganizzazione) {
		this.denominazioneOrganizzazione = denominazioneOrganizzazione;
	}

	/**
	 * @return the codiceCategoriaServizio
	 */
	public String getCodiceCategoriaServizio() {
		return codiceCategoriaServizio;
	}

	/**
	 * @param codiceCategoriaServizio the codiceCategoriaServizio to set
	 */
	public void setCodiceCategoriaServizio(String codiceCategoriaServizio) {
		this.codiceCategoriaServizio = codiceCategoriaServizio;
	}

	/**
	 * @return the denominazioneCategoriaServizio
	 */
	public String getDenominazioneCategoriaServizio() {
		return denominazioneCategoriaServizio;
	}

	/**
	 * @param denominazioneCategoriaServizio the denominazioneCategoriaServizio to set
	 */
	public void setDenominazioneCategoriaServizio(String denominazioneCategoriaServizio) {
		this.denominazioneCategoriaServizio = denominazioneCategoriaServizio;
	}

	/**
	 * @return the downloadAvviso
	 */
	public boolean isDownloadAvviso() {
		return downloadAvviso;
	}

	/**
	 * @param downloadAvviso the downloadAvviso to set
	 */
	public void setDownloadAvviso(boolean downloadAvviso) {
		this.downloadAvviso = downloadAvviso;
	}

	/**
	 * @return the scadenzaObbligatoria
	 */
	public boolean isScadenzaObbligatoria() {
		return scadenzaObbligatoria;
	}

	/**
	 * @param scadenzaObbligatoria the scadenzaObbligatoria to set
	 */
	public void setScadenzaObbligatoria(boolean scadenzaObbligatoria) {
		this.scadenzaObbligatoria = scadenzaObbligatoria;
	}

	/**
	 * @return the pathAvviso
	 */
	public String getPathAvviso() {
		return pathAvviso;
	}

	/**
	 * @param pathAvviso the pathAvviso to set
	 */
	public void setPathAvviso(String pathAvviso) {
		this.pathAvviso = pathAvviso;
	}

	/**
	 * @return the codiceIUV
	 */
	public String getCodiceIUV() {
		return codiceIUV;
	}

	/**
	 * @param codiceIUV the codiceIUV to set
	 */
	public void setCodiceIUV(String codiceIUV) {
		this.codiceIUV = codiceIUV;
	}

}
