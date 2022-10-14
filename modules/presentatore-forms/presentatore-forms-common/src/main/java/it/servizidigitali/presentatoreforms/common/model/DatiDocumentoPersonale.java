/************************************************************************************
 * Copyright (c) 2011, 2019 Link Management & Technology S.p.A. via R. Scotellaro, 55 73100 - Lecce
 * - http://www.linksmt.it - All rights reserved.
 *
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *************************************************************************************/
package it.servizidigitali.presentatoreforms.common.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Gianluca Pindinelli
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatiDocumentoPersonale implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idRepository;
	private String titolo;
	private String descrizione;
	private String versione;
	private Date dataCreazione;
	private Date dataModifica;
	private String metadati;
	private String codice;
	private String codiceFiscaleProprietario;
	private byte[] bytes;
	private String numero;
	private Date dataScadenza;
	private String nomeFile;

	private boolean inScadenza;
	private boolean scaduto;

	/**
	 * @return the idRepository
	 */
	public String getIdRepository() {
		return idRepository;
	}

	/**
	 * @param idRepository the idRepository to set
	 */
	public void setIdRepository(String idRepository) {
		this.idRepository = idRepository;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the versione
	 */
	public String getVersione() {
		return versione;
	}

	/**
	 * @param versione the versione to set
	 */
	public void setVersione(String versione) {
		this.versione = versione;
	}

	/**
	 * @return the dataCreazione
	 */
	public Date getDataCreazione() {
		return dataCreazione;
	}

	/**
	 * @param dataCreazione the dataCreazione to set
	 */
	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	/**
	 * @return the dataModifica
	 */
	public Date getDataModifica() {
		return dataModifica;
	}

	/**
	 * @param dataModifica the dataModifica to set
	 */
	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	/**
	 * @return the metadati
	 */
	public String getMetadati() {
		return metadati;
	}

	/**
	 * @param metadati the metadati to set
	 */
	public void setMetadati(String metadati) {
		this.metadati = metadati;
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the codiceFiscaleProprietario
	 */
	public String getCodiceFiscaleProprietario() {
		return codiceFiscaleProprietario;
	}

	/**
	 * @param codiceFiscaleProprietario the codiceFiscaleProprietario to set
	 */
	public void setCodiceFiscaleProprietario(String codiceFiscaleProprietario) {
		this.codiceFiscaleProprietario = codiceFiscaleProprietario;
	}

	/**
	 * @return the bytes
	 */
	public byte[] getBytes() {
		return bytes;
	}

	/**
	 * @param bytes the bytes to set
	 */
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the dataScadenza
	 */
	public Date getDataScadenza() {
		return dataScadenza;
	}

	/**
	 * @param dataScadenza the dataScadenza to set
	 */
	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	/**
	 * @return the nomeFile
	 */
	public String getNomeFile() {
		return nomeFile;
	}

	/**
	 * @param nomeFile the nomeFile to set
	 */
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	/**
	 * @return the inScadenza
	 */
	public boolean isInScadenza() {
		return inScadenza;
	}

	/**
	 * @param inScadenza the inScadenza to set
	 */
	public void setInScadenza(boolean inScadenza) {
		this.inScadenza = inScadenza;
	}

	/**
	 * @return the scaduto
	 */
	public boolean isScaduto() {
		return scaduto;
	}

	/**
	 * @param scaduto the scaduto to set
	 */
	public void setScaduto(boolean scaduto) {
		this.scaduto = scaduto;
	}
}
