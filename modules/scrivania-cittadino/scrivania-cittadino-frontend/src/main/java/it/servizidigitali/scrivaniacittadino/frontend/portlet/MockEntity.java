package it.servizidigitali.scrivaniacittadino.frontend.portlet;

import java.util.Date;

public class MockEntity {
	private String nome;
	private Date data;
	private String stato;
	private String protocollo;
	private String descrizione;
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
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
	public String getProtocollo() {
		return protocollo;
	}
	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}
	
	
}
