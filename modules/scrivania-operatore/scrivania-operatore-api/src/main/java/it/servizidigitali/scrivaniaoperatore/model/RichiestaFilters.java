package it.servizidigitali.scrivaniaoperatore.model;

import java.util.Date;
import java.util.List;

public class RichiestaFilters {

	private String nomeCognome;
	private String codiceFiscale;
	private String idRichiesta;
	private String numeroProtocollo;
	private Date dataDa;
	private Date dataA;
	private Boolean autenticazione;
	private String tipo;
	private List<String> processInstanceIds;

	/**
	 * @return the nomeCognome
	 */
	public String getNomeCognome() {
		return nomeCognome;
	}

	/**
	 * @param nomeCognome the nomeCognome to set
	 */
	public void setNomeCognome(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}

	/**
	 * @return the codiceFiscale
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * @param codiceFiscale the codiceFiscale to set
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * @return the idRichiesta
	 */
	public String getIdRichiesta() {
		return idRichiesta;
	}

	/**
	 * @param idRichiesta the idRichiesta to set
	 */
	public void setIdRichiesta(String idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	/**
	 * @return the numeroProtocollo
	 */
	public String getNumeroProtocollo() {
		return numeroProtocollo;
	}

	/**
	 * @param numeroProtocollo the numeroProtocollo to set
	 */
	public void setNumeroProtocollo(String numeroProtocollo) {
		this.numeroProtocollo = numeroProtocollo;
	}

	/**
	 * @return the dataDa
	 */
	public Date getDataDa() {
		return dataDa;
	}

	/**
	 * @param dataDa the dataDa to set
	 */
	public void setDataDa(Date dataDa) {
		this.dataDa = dataDa;
	}

	/**
	 * @return the dataA
	 */
	public Date getDataA() {
		return dataA;
	}

	/**
	 * @param dataA the dataA to set
	 */
	public void setDataA(Date dataA) {
		this.dataA = dataA;
	}

	/**
	 * @return the autenticazione
	 */
	public Boolean getAutenticazione() {
		return autenticazione;
	}

	/**
	 * @param autenticazione the autenticazione to set
	 */
	public void setAutenticazione(Boolean autenticazione) {
		this.autenticazione = autenticazione;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the processInstanceIds
	 */
	public List<String> getProcessInstanceIds() {
		return processInstanceIds;
	}

	/**
	 * @param processInstanceIds the processInstanceIds to set
	 */
	public void setProcessInstanceIds(List<String> processInstanceIds) {
		this.processInstanceIds = processInstanceIds;
	}

}
