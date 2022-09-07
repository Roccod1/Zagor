package it.servizidigitali.gestionecomunicazioni.model;

import java.util.Date;

public class ComunicazioneFilters {
	private Long organizzazione;
	private Long tipologia;
	private String username;
	private Boolean stato;
	private Date dataInvioDa;
	private Date dataInvioA;
	private long userId;
	private String orderByCol;
	private String orderByType;
	
	public Long getOrganizzazione() {
		return organizzazione;
	}
	public void setOrganizzazione(Long organizzazione) {
		this.organizzazione = organizzazione;
	}
	public Long getTipologia() {
		return tipologia;
	}
	public void setTipologia(Long tipologia) {
		this.tipologia = tipologia;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getStato() {
		return stato;
	}
	public void setStato(Boolean stato) {
		this.stato = stato;
	}
	public Date getDataInvioDa() {
		return dataInvioDa;
	}
	public void setDataInvioDa(Date dataInvioDa) {
		this.dataInvioDa = dataInvioDa;
	}
	public Date getDataInvioA() {
		return dataInvioA;
	}
	public void setDataInvioA(Date dataInvioA) {
		this.dataInvioA = dataInvioA;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getOrderByCol() {
		return orderByCol;
	}
	public void setOrderByCol(String orderByCol) {
		this.orderByCol = orderByCol;
	}
	public String getOrderByType() {
		return orderByType;
	}
	public void setOrderByType(String orderByType) {
		this.orderByType = orderByType;
	}
}
