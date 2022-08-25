package it.servizidigitali.gestionecomunicazioni.frontend.dto;

import it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione;

public class TipologiaDTO {
	private long id;
	private String nome;
	
	public TipologiaDTO() {
	}

	public TipologiaDTO(TipologiaComunicazione tc) {
		id = tc.getTipologiaComunicazioneId();
		nome = tc.getNome();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
