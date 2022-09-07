package it.servizidigitali.scrivaniaoperatore.frontend.dto;

import java.util.Date;

public class RichiestaDTO {
	private long id;
	private String numeroProtocollo;
	private Date dataProtocollo;
	private String numeroProtocolloEsterno;
	private Date dataProtocolloEsterno;
	private Date dataUltimoAggiornamento;
	private String richiedente;
	private String stato;
	private String cf;
	private boolean accesso;
	private Date dataInserimento;
	private String oggetto;
	private String note;
	private String pec;
	private String parIVA;
	private String email;
	private String indirizzoResidenza;
	private String civicoResidenza;
	private String comuneResidenza;
	private String servizio;
	private String telefono;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumeroProtocollo() {
		return numeroProtocollo;
	}
	public void setNumeroProtocollo(String numeroProtocollo) {
		this.numeroProtocollo = numeroProtocollo;
	}
	public Date getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}
	public void setDataUltimoAggiornamento(Date dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}
	public String getRichiedente() {
		return richiedente;
	}
	public void setRichiedente(String richiedente) {
		this.richiedente = richiedente;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public boolean isAccesso() {
		return accesso;
	}
	public void setAccesso(boolean accesso) {
		this.accesso = accesso;
	}
	public Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDataProtocollo() {
		return dataProtocollo;
	}
	public void setDataProtocollo(Date dataProtocollo) {
		this.dataProtocollo = dataProtocollo;
	}
	public String getNumeroProtocolloEsterno() {
		return numeroProtocolloEsterno;
	}
	public void setNumeroProtocolloEsterno(String numeroProtocolloEsterno) {
		this.numeroProtocolloEsterno = numeroProtocolloEsterno;
	}
	public Date getDataProtocolloEsterno() {
		return dataProtocolloEsterno;
	}
	public void setDataProtocolloEsterno(Date dataProtocolloEsterno) {
		this.dataProtocolloEsterno = dataProtocolloEsterno;
	}
	public String getPec() {
		return pec;
	}
	public void setPec(String pec) {
		this.pec = pec;
	}
	public String getParIVA() {
		return parIVA;
	}
	public void setParIVA(String parIVA) {
		this.parIVA = parIVA;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}
	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}
	public String getCivicoResidenza() {
		return civicoResidenza;
	}
	public void setCivicoResidenza(String civicoResidenza) {
		this.civicoResidenza = civicoResidenza;
	}
	public String getComuneResidenza() {
		return comuneResidenza;
	}
	public void setComuneResidenza(String comuneResidenza) {
		this.comuneResidenza = comuneResidenza;
	}
	public String getServizio() {
		return servizio;
	}
	public void setServizio(String servizio) {
		this.servizio = servizio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
