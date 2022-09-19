package it.servizidigitali.scrivaniaoperatore.frontend.dto;

public class AllegatoDTO {
	private String descrizione;
	private String nomeFile;
	private String dimensione;
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getNomeFile() {
		return nomeFile;
	}
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}
	public String getDimensione() {
		return dimensione;
	}
	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}
	
}
