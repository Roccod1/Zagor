package it.servizidigitali.backoffice.integration.model.anagrafe;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DatiVariazioniDomicilio implements Serializable {

	private static final long serialVersionUID = -6083826937821444575L;

	private List<DatiVariazioniDomicilio.VariazioneDomicilio> variazioniDomicilio;

	public static class VariazioneDomicilio implements Serializable {

		private final static long serialVersionUID = 1L;
		private Date dataInizioDomicilio;
		private String codiceIstatComune;
		private Date dataIscrizioneComune;
		private String cap;
		private String toponimoIndirizzo;
		private String indirizzo;
		private String codiceCivico;
		private String numeroCivico;
		private String esponente;
		private String piano;
		private String scala;
		private String interno;

		/**
		 * @return the dataInizioDomicilio
		 */
		public Date getDataInizioDomicilio() {
			return dataInizioDomicilio;
		}

		/**
		 * @param dataInizioDomicilio the dataInizioDomicilio to set
		 */
		public void setDataInizioDomicilio(Date dataInizioDomicilio) {
			this.dataInizioDomicilio = dataInizioDomicilio;
		}

		/**
		 * @return the codiceIstatComune
		 */
		public String getCodiceIstatComune() {
			return codiceIstatComune;
		}

		/**
		 * @param codiceIstatComune the codiceIstatComune to set
		 */
		public void setCodiceIstatComune(String codiceIstatComune) {
			this.codiceIstatComune = codiceIstatComune;
		}

		/**
		 * @return the dataIscrizioneComune
		 */
		public Date getDataIscrizioneComune() {
			return dataIscrizioneComune;
		}

		/**
		 * @param dataIscrizioneComune the dataIscrizioneComune to set
		 */
		public void setDataIscrizioneComune(Date dataIscrizioneComune) {
			this.dataIscrizioneComune = dataIscrizioneComune;
		}

		/**
		 * @return the toponimoIndirizzo
		 */
		public String getToponimoIndirizzo() {
			return toponimoIndirizzo;
		}

		/**
		 * @param toponimoIndirizzo the toponimoIndirizzo to set
		 */
		public void setToponimoIndirizzo(String toponimoIndirizzo) {
			this.toponimoIndirizzo = toponimoIndirizzo;
		}

		/**
		 * @return the indirizzo
		 */
		public String getIndirizzo() {
			return indirizzo;
		}

		/**
		 * @param indirizzo the indirizzo to set
		 */
		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}

		/**
		 * @return the numeroCivico
		 */
		public String getNumeroCivico() {
			return numeroCivico;
		}

		/**
		 * @param numeroCivico the numeroCivico to set
		 */
		public void setNumeroCivico(String numeroCivico) {
			this.numeroCivico = numeroCivico;
		}

		/**
		 * @return the esponente
		 */
		public String getEsponente() {
			return esponente;
		}

		/**
		 * @param esponente the esponente to set
		 */
		public void setEsponente(String esponente) {
			this.esponente = esponente;
		}

		/**
		 * @return the piano
		 */
		public String getPiano() {
			return piano;
		}

		/**
		 * @param piano the piano to set
		 */
		public void setPiano(String piano) {
			this.piano = piano;
		}

		/**
		 * @return the scala
		 */
		public String getScala() {
			return scala;
		}

		/**
		 * @param scala the scala to set
		 */
		public void setScala(String scala) {
			this.scala = scala;
		}

		/**
		 * @return the interno
		 */
		public String getInterno() {
			return interno;
		}

		/**
		 * @param interno the interno to set
		 */
		public void setInterno(String interno) {
			this.interno = interno;
		}

		/**
		 * @return the codiceCivico
		 */
		public String getCodiceCivico() {
			return codiceCivico;
		}

		/**
		 * @param codiceCivico the codiceCivico to set
		 */
		public void setCodiceCivico(String codiceCivico) {
			this.codiceCivico = codiceCivico;
		}

		/**
		 * @return the cap
		 */
		public String getCap() {
			return cap;
		}

		/**
		 * @param cap the cap to set
		 */
		public void setCap(String cap) {
			this.cap = cap;
		}
	}

	/**
	 * @return the variazioniDomicilio
	 */
	public List<DatiVariazioniDomicilio.VariazioneDomicilio> getVariazioniDomicilio() {
		return variazioniDomicilio;
	}

	/**
	 * @param variazioniDomicilio the variazioniDomicilio to set
	 */
	public void setVariazioniDomicilio(List<DatiVariazioniDomicilio.VariazioneDomicilio> variazioniDomicilio) {
		this.variazioniDomicilio = variazioniDomicilio;
	}

}
