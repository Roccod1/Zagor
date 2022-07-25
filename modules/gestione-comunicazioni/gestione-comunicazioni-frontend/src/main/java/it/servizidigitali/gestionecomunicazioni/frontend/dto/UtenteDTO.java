package it.servizidigitali.gestionecomunicazioni.frontend.dto;

import com.liferay.portal.kernel.model.User;

public class UtenteDTO {
	private long id;
	private String nome;
	private String cf;
	
	public UtenteDTO(User user) {
		id = user.getUserId();
		nome = user.getFullName();
		cf = user.getScreenName().toUpperCase();
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

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}
	
}
