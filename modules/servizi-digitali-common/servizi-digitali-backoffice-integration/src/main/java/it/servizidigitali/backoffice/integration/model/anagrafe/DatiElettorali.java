package it.servizidigitali.backoffice.integration.model.anagrafe;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DatiElettorali implements Serializable {

	private static final long serialVersionUID = 3980533646455516589L;

	private List<DatiElettorali.PosizioneElettorale> posizioniElettorali;

	public static class PosizioneElettorale implements Serializable {

		private final static long serialVersionUID = 1L;
		private String toponimoIndirizzo;
		private String descrizioneVia;
		private String numeroCivico;
		private String esponente;
		private String piano;
		private String scala;
		private String interno;
		private Date dataVerbaleIscrizione;
		private String numeroVerbaleIscrizione;
		private String annoIscrizione;
		private String numeroFascicolo;
		private String numeroListaGenerale;
		private String numeroListaSezionale;
		private String descrizioneLista;
		private String tipoElettore;
		private Integer numeroSezione;
		private String numeroTesseraElettorale;
		private Date dataRilascioTesseraElettorale;
		private Boolean iscrizioneAlboPresidente;
		private Boolean iscrizioneAlboScrutatori;
		private Integer numeroVerbaleIscrizioneAlboScrutatori;
		private Date dataVerbaleIscrizioneAlboScrutatori;

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
		 * @return the descrizioneVia
		 */
		public String getDescrizioneVia() {
			return descrizioneVia;
		}

		/**
		 * @param descrizioneVia the descrizioneVia to set
		 */
		public void setDescrizioneVia(String descrizioneVia) {
			this.descrizioneVia = descrizioneVia;
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
		 * @return the dataVerbaleIscrizione
		 */
		public Date getDataVerbaleIscrizione() {
			return dataVerbaleIscrizione;
		}

		/**
		 * @param dataVerbaleIscrizione the dataVerbaleIscrizione to set
		 */
		public void setDataVerbaleIscrizione(Date dataVerbaleIscrizione) {
			this.dataVerbaleIscrizione = dataVerbaleIscrizione;
		}

		/**
		 * @return the numeroVerbaleIscrizione
		 */
		public String getNumeroVerbaleIscrizione() {
			return numeroVerbaleIscrizione;
		}

		/**
		 * @param numeroVerbaleIscrizione the numeroVerbaleIscrizione to set
		 */
		public void setNumeroVerbaleIscrizione(String numeroVerbaleIscrizione) {
			this.numeroVerbaleIscrizione = numeroVerbaleIscrizione;
		}

		/**
		 * @return the numeroFascicolo
		 */
		public String getNumeroFascicolo() {
			return numeroFascicolo;
		}

		/**
		 * @param numeroFascicolo the numeroFascicolo to set
		 */
		public void setNumeroFascicolo(String numeroFascicolo) {
			this.numeroFascicolo = numeroFascicolo;
		}

		/**
		 * @return the numeroListaSezionale
		 */
		public String getNumeroListaSezionale() {
			return numeroListaSezionale;
		}

		/**
		 * @param numeroListaSezionale the numeroListaSezionale to set
		 */
		public void setNumeroListaSezionale(String numeroListaSezionale) {
			this.numeroListaSezionale = numeroListaSezionale;
		}

		/**
		 * @return the descrizioneLista
		 */
		public String getDescrizioneLista() {
			return descrizioneLista;
		}

		/**
		 * @param descrizioneLista the descrizioneLista to set
		 */
		public void setDescrizioneLista(String descrizioneLista) {
			this.descrizioneLista = descrizioneLista;
		}

		/**
		 * @return the tipoElettore
		 */
		public String getTipoElettore() {
			return tipoElettore;
		}

		/**
		 * @param tipoElettore the tipoElettore to set
		 */
		public void setTipoElettore(String tipoElettore) {
			this.tipoElettore = tipoElettore;
		}

		/**
		 * @return the numeroSezione
		 */
		public Integer getNumeroSezione() {
			return numeroSezione;
		}

		/**
		 * @param numeroSezione the numeroSezione to set
		 */
		public void setNumeroSezione(Integer numeroSezione) {
			this.numeroSezione = numeroSezione;
		}

		/**
		 * @return the numeroTesseraElettorale
		 */
		public String getNumeroTesseraElettorale() {
			return numeroTesseraElettorale;
		}

		/**
		 * @param numeroTesseraElettorale the numeroTesseraElettorale to set
		 */
		public void setNumeroTesseraElettorale(String numeroTesseraElettorale) {
			this.numeroTesseraElettorale = numeroTesseraElettorale;
		}

		/**
		 * @return the dataRilascioTesseraElettorale
		 */
		public Date getDataRilascioTesseraElettorale() {
			return dataRilascioTesseraElettorale;
		}

		/**
		 * @param dataRilascioTesseraElettorale the dataRilascioTesseraElettorale to set
		 */
		public void setDataRilascioTesseraElettorale(Date dataRilascioTesseraElettorale) {
			this.dataRilascioTesseraElettorale = dataRilascioTesseraElettorale;
		}

		/**
		 * @return the iscrizioneAlboPresidente
		 */
		public Boolean getIscrizioneAlboPresidente() {
			return iscrizioneAlboPresidente;
		}

		/**
		 * @param iscrizioneAlboPresidente the iscrizioneAlboPresidente to set
		 */
		public void setIscrizioneAlboPresidente(Boolean iscrizioneAlboPresidente) {
			this.iscrizioneAlboPresidente = iscrizioneAlboPresidente;
		}

		/**
		 * @return the iscrizioneAlboScrutatori
		 */
		public Boolean getIscrizioneAlboScrutatori() {
			return iscrizioneAlboScrutatori;
		}

		/**
		 * @param iscrizioneAlboScrutatori the iscrizioneAlboScrutatori to set
		 */
		public void setIscrizioneAlboScrutatori(Boolean iscrizioneAlboScrutatori) {
			this.iscrizioneAlboScrutatori = iscrizioneAlboScrutatori;
		}

		/**
		 * @return the numeroVerbaleIscrizioneAlboScrutatori
		 */
		public Integer getNumeroVerbaleIscrizioneAlboScrutatori() {
			return numeroVerbaleIscrizioneAlboScrutatori;
		}

		/**
		 * @param numeroVerbaleIscrizioneAlboScrutatori the numeroVerbaleIscrizioneAlboScrutatori to
		 *        set
		 */
		public void setNumeroVerbaleIscrizioneAlboScrutatori(Integer numeroVerbaleIscrizioneAlboScrutatori) {
			this.numeroVerbaleIscrizioneAlboScrutatori = numeroVerbaleIscrizioneAlboScrutatori;
		}

		/**
		 * @return the annoIscrizione
		 */
		public String getAnnoIscrizione() {
			return annoIscrizione;
		}

		/**
		 * @param annoIscrizione the annoIscrizione to set
		 */
		public void setAnnoIscrizione(String annoIscrizione) {
			this.annoIscrizione = annoIscrizione;
		}

		/**
		 * @return the dataVerbaleIscrizioneAlboScrutatori
		 */
		public Date getDataVerbaleIscrizioneAlboScrutatori() {
			return dataVerbaleIscrizioneAlboScrutatori;
		}

		/**
		 * @param dataVerbaleIscrizioneAlboScrutatori the dataVerbaleIscrizioneAlboScrutatori to set
		 */
		public void setDataVerbaleIscrizioneAlboScrutatori(Date dataVerbaleIscrizioneAlboScrutatori) {
			this.dataVerbaleIscrizioneAlboScrutatori = dataVerbaleIscrizioneAlboScrutatori;
		}

		/**
		 * @return the numeroListaGenerale
		 */
		public String getNumeroListaGenerale() {
			return numeroListaGenerale;
		}

		/**
		 * @param numeroListaGenerale the numeroListaGenerale to set
		 */
		public void setNumeroListaGenerale(String numeroListaGenerale) {
			this.numeroListaGenerale = numeroListaGenerale;
		}
	}

	/**
	 * @return the posizioniElettorali
	 */
	public List<DatiElettorali.PosizioneElettorale> getPosizioniElettorali() {
		return posizioniElettorali;
	}

	/**
	 * @param posizioniElettorali the posizioniElettorali to set
	 */
	public void setPosizioniElettorali(List<DatiElettorali.PosizioneElettorale> posizioniElettorali) {
		this.posizioniElettorali = posizioniElettorali;
	}

}
