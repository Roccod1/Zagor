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

	private String processInstanceId;
	private String taskId;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the numeroProtocollo
	 */
	public String getNumeroProtocollo() {
		return numeroProtocollo;
	}

	/**
	 * @param numeroProtocollo the numeroProtocollo to set
	 */
	public void setNumeroProtocollo(String numeroProtocollo) {
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
	 * @return the numeroProtocolloEsterno
	 */
	public String getNumeroProtocolloEsterno() {
		return numeroProtocolloEsterno;
	}

	/**
	 * @param numeroProtocolloEsterno the numeroProtocolloEsterno to set
	 */
	public void setNumeroProtocolloEsterno(String numeroProtocolloEsterno) {
		this.numeroProtocolloEsterno = numeroProtocolloEsterno;
	}

	/**
	 * @return the dataProtocolloEsterno
	 */
	public Date getDataProtocolloEsterno() {
		return dataProtocolloEsterno;
	}

	/**
	 * @param dataProtocolloEsterno the dataProtocolloEsterno to set
	 */
	public void setDataProtocolloEsterno(Date dataProtocolloEsterno) {
		this.dataProtocolloEsterno = dataProtocolloEsterno;
	}

	/**
	 * @return the dataUltimoAggiornamento
	 */
	public Date getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}

	/**
	 * @param dataUltimoAggiornamento the dataUltimoAggiornamento to set
	 */
	public void setDataUltimoAggiornamento(Date dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}

	/**
	 * @return the richiedente
	 */
	public String getRichiedente() {
		return richiedente;
	}

	/**
	 * @param richiedente the richiedente to set
	 */
	public void setRichiedente(String richiedente) {
		this.richiedente = richiedente;
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
	 * @return the cf
	 */
	public String getCf() {
		return cf;
	}

	/**
	 * @param cf the cf to set
	 */
	public void setCf(String cf) {
		this.cf = cf;
	}

	/**
	 * @return the accesso
	 */
	public boolean isAccesso() {
		return accesso;
	}

	/**
	 * @param accesso the accesso to set
	 */
	public void setAccesso(boolean accesso) {
		this.accesso = accesso;
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
	 * @return the oggetto
	 */
	public String getOggetto() {
		return oggetto;
	}

	/**
	 * @param oggetto the oggetto to set
	 */
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the pec
	 */
	public String getPec() {
		return pec;
	}

	/**
	 * @param pec the pec to set
	 */
	public void setPec(String pec) {
		this.pec = pec;
	}

	/**
	 * @return the parIVA
	 */
	public String getParIVA() {
		return parIVA;
	}

	/**
	 * @param parIVA the parIVA to set
	 */
	public void setParIVA(String parIVA) {
		this.parIVA = parIVA;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the indirizzoResidenza
	 */
	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}

	/**
	 * @param indirizzoResidenza the indirizzoResidenza to set
	 */
	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}

	/**
	 * @return the civicoResidenza
	 */
	public String getCivicoResidenza() {
		return civicoResidenza;
	}

	/**
	 * @param civicoResidenza the civicoResidenza to set
	 */
	public void setCivicoResidenza(String civicoResidenza) {
		this.civicoResidenza = civicoResidenza;
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
	 * @return the servizio
	 */
	public String getServizio() {
		return servizio;
	}

	/**
	 * @param servizio the servizio to set
	 */
	public void setServizio(String servizio) {
		this.servizio = servizio;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the processInstanceId
	 */
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	/**
	 * @param processInstanceId the processInstanceId to set
	 */
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

}
