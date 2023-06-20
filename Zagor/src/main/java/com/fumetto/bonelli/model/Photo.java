package com.fumetto.bonelli.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column; 

@Entity
@Table(name = "fumetti")
public class Photo {
	
	@Id
	private int id;
	private String url;
	private String titolo;
	private int numero;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Photo() {}
	
	public Photo(int id, String url, String titolo, int numero) {
		this.id=id;
		this.url=url;
		this.titolo=titolo;
		this.numero=numero;
	}
}
