package it.servizidigitali.scrivaniaoperatore.frontend.dto;

import java.util.Date;

public class AttivitaDTO {
	private Date data;
	private String stato;
	private String note;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
