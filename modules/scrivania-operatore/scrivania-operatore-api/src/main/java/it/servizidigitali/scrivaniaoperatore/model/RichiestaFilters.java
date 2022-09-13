package it.servizidigitali.scrivaniaoperatore.model;

import java.util.Date;

public class RichiestaFilters {
	private String nomeCognome;
	private String codiceFiscale;
	private String idRichiesta;
	private String numeroProtocollo;
	private Date dataDa;
	private Date dataA;
	private Boolean autenticazione;
	private String tipo;

	public String getNomeCognome() {
		return nomeCognome;
	}
	public void setNomeCognome(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getIdRichiesta() {
		return idRichiesta;
	}
	public void setIdRichiesta(String idRichiesta) {
		this.idRichiesta = idRichiesta;
	}
	public String getNumeroProtocollo() {
		return numeroProtocollo;
	}
	public void setNumeroProtocollo(String numeroProtocollo) {
		this.numeroProtocollo = numeroProtocollo;
	}
	public Date getDataDa() {
		return dataDa;
	}
	public void setDataDa(Date dataDa) {
		this.dataDa = dataDa;
	}
	public Date getDataA() {
		return dataA;
	}
	public void setDataA(Date dataA) {
		this.dataA = dataA;
	}
	public Boolean getAutenticazione() {
		return autenticazione;
	}
	public void setAutenticazione(Boolean autenticazione) {
		this.autenticazione = autenticazione;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
