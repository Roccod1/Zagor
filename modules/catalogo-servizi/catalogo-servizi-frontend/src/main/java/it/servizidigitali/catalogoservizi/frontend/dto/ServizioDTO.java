package it.servizidigitali.catalogoservizi.frontend.dto;

import it.servizidigitali.gestioneservizi.model.Servizio;

public class ServizioDTO {
	private String tipologia;
	private String nome;
	private String descrizione;
	
	public ServizioDTO(Servizio servizio) {
		nome = servizio.getNome();
		descrizione = servizio.getDescrizione();
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
