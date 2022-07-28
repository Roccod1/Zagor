package it.servizidigitali.gestionecomunicazioni.frontend.dto;

import com.liferay.portal.kernel.model.Organization;

import java.util.Date;

import it.servizidigitali.gestionecomunicazioni.model.Comunicazione;

public class ComunicazioneDTO {
	private Date dataInvio;
	private String titolo;
	private String descrizione;
	private String tipologia;
	private String stato;
	private String ente;
	
	public ComunicazioneDTO(Comunicazione comunicazione) {
		dataInvio = comunicazione.getDataInvio();
		titolo = comunicazione.getTitolo();
		descrizione = comunicazione.getDescrizione();
		tipologia = comunicazione.getTipologia().getNome();
		
		if (comunicazione.getLettura() != null) {
			stato = "Letto";
		} else {
			stato = "Non Letto";
		}
		
		Organization organizzazione = comunicazione.getDestinatarioOrganizzazione();
		ente = organizzazione.getName();
	}
	
	public Date getDataInvio() {
		return dataInvio;
	}
	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getEnte() {
		return ente;
	}
	public void setEnte(String ente) {
		this.ente = ente;
	}
	
}
