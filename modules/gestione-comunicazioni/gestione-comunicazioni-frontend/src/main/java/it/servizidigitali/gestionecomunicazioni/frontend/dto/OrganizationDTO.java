package it.servizidigitali.gestionecomunicazioni.frontend.dto;

import com.liferay.portal.kernel.model.Organization;

public class OrganizationDTO {
	private long id;
	private String nome;
	
	public OrganizationDTO(Organization organization) {
		id = organization.getOrganizationId();
		nome = organization.getName();
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
