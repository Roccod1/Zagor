package it.servizidigitali.scrivaniaoperatore.frontend.dto;

import java.util.Date;

public class CommentoDTO {
	private Date data;
	private String operatore;
	private String testo;
	private boolean visibileAlCittadino;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getOperatore() {
		return operatore;
	}
	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public boolean isVisibileAlCittadino() {
		return visibileAlCittadino;
	}
	public void setVisibileAlCittadino(boolean visibileAlCittadino) {
		this.visibileAlCittadino = visibileAlCittadino;
	}
	
}
