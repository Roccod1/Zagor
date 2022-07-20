package it.servizidigitali.gestionecomunicazioni.frontend.dto;

import com.liferay.portal.kernel.model.User;

public class UtenteDTO {
	private long id;
	private String nome;
	
	public UtenteDTO(User user) {
		id = user.getUserId();
		nome = user.getFullName();
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
