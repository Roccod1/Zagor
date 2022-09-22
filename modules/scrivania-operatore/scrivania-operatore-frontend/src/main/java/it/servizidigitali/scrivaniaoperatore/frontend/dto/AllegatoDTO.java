package it.servizidigitali.scrivaniaoperatore.frontend.dto;

public class AllegatoDTO {
	private String descrizione;
	private String nomeFile;
	private String dimensione;
	private String url;
	private boolean visibileAlCittadino;
	private String nomeOperatore;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isVisibileAlCittadino() {
		return visibileAlCittadino;
	}
	public void setVisibileAlCittadino(boolean visibileAlCittadino) {
		this.visibileAlCittadino = visibileAlCittadino;
	}
	public String getNomeOperatore() {
		return nomeOperatore;
	}
	public void setNomeOperatore(String nomeOperatore) {
		this.nomeOperatore = nomeOperatore;
	}
	
}
