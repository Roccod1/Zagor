package it.servizidigitali.scrivaniaoperatore.frontend.dto;

public class UserDTO {
	private long userId;
	private String nome;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
