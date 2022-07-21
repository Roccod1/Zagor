package it.servizidigitali.backoffice.integration.model.anagrafe;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import it.servizidigitali.backoffice.integration.enums.RelazioneParentela;
import it.servizidigitali.backoffice.integration.enums.StatoCivile;
import it.servizidigitali.backoffice.integration.enums.TipoCessazioneMatrimonio;
import it.servizidigitali.backoffice.integration.enums.TipoTribunale;

public class DatiAnagrafici implements Serializable {

	private static final long serialVersionUID = 3646962141841888392L;

	private String identificativoNucleoFamiliare;
	private String codiceIstatComune;
	private String codiceVia;
	private String codiceCivico;
	private String toponimoIndirizzo;
	private String descrizioneVia;
	private String cap;
	private String numeroCivico;
	private String esponente;
	private String piano;
	private String interno;
	private String scala;
	private String telefono;
	private List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleoFamiliare;

	public static class ComponenteNucleoFamiliare implements Serializable {

		private final static long serialVersionUID = 1L;
		private String codiceFiscale;
		private String identificativo;
		private String cognome;
		private String nome;
		private Date dataNascita;
		private boolean dataNascitaSenzaGiorno;
		private boolean dataNascitaSenzaGiornoMese;
		private String sesso;
		private StatoCivile statoCivile;
		private RelazioneParentela relazioneParentela;
		private String codiceFiscaleConiuge;
		private String cognomeNomeConiuge;
		private boolean cittadinanzaItaliana;
		private String codiceIstatComuneNascita;
		private String descrizioneComuneEsteroNascita;
		private Integer codiceStatoEsteroNascita;
		private String descrizioneStatoEsteroNascita;

		private String codiceStatoComuneResidenza;
		private String codiceIstatComuneResidenza;
		private String codiceVia;
		private String codiceCivico;
		private String toponimoIndirizzo;
		private String descrizioneVia;
		private String cap;
		private String numeroCivico;
		private String esponente;
		private String piano;
		private String interno;
		private String scala;

		private boolean attoNascitaTrascitto;

		private String cognomeNomeAttoNascita;
		private String numeroAttoNascita;
		private String parteAttoNascita;
		private String serieAttoNascita;
		private String annoAttoNascita;
		private String ufficioAttoNascita;
		private String volumeAttoNascita;
		private String codiceIstatComuneAttoNascita; // è il comune dell'atto o del dichiarante?
														// TODO
		private String denominazioneComuneAttoNascita;
		private String annoStringaAttoNascita;
		private String meseStringaAttoNascita;
		private String giornoStringaAttoNascita;

		private String luogoMatrimonio;
		private Date dataMatrimonio;
		private boolean attoMatrimonioTrascitto;
		private String numeroAttoMatrimonio;
		private String parteAttoMatrimonio;
		private String serieAttoMatrimonio;
		private String annoAttoMatrimonio;
		private String ufficioAttoMatrimonio;
		private String volumeAttoMartrimonio;
		private String codiceIstatComuneAttoMatrimonio;

		private String denominazioneComuneAttoMatrimonio;
		private String annoStringaAttoMatrimonio;
		private String meseStringaAttoMatrimonio;
		private String giornoStringaAttoMatrimonio;
		private String cognomeNomeAttoMatrimonio; // ok
		private Date dataNascitaAttoMatrimonio; // ok
		private String comuneNascitaAttoMatrimonio; // ok
		private String cognomeNomeConiugeAttoMatrimonio;
		private Date dataNascitaConiugeAttoMatrimonio;
		private String comuneNascitaConiugeAttoMatrimonio;

		private String numeroAttoUnioneCivile;
		private String parteAttoUnioneCivile;
		private String serieAttoUnioneCivile;
		private String annoAttoUnioneCivile;
		private String ufficioAttoUnioneCivile;
		private String codiceIstatComuneAttoUnioneCivile;
		private String denominazioneComuneAttoUnioneCivile;
		private Date dataAttoUnioneCivile;
		private String volumeAttoUnioneCivile;
		private String regimePatrimonialeAttoUnioneCivile;
		private String cognomeAttoUnioneCivile; // ok
		private String nomeAttoUnioneCivile; // ok
		private Date dataNascitaAttoUnioneCivile; // ok
		private String etaAttoUnioneCivile;
		private String comuneNascitaAttoUnioneCivile; // ok
		private String comuneResidenzaAttoUnioneCivile; // ok
		private String attoNascitaAttoUnioneCivile;
		private String attoNascitaTrascrittoAttoUnioneCivile;
		private String comuneAttoNascitaTrascrittoAttoUnioneCivile;
		private String cognomeUnitoAttoUnioneCivile; // ok
		private String nomeUnitoAttoUnioneCivile; // ok
		private String denominazioneUnitoAttoUnioneCivile; // ok
		private Date dataNascitaUnitoAttoUnioneCivile;
		private String etaUnitoAttoUnioneCivile;
		private String comuneNascitaUnitoAttoUnioneCivile;
		private String comuneResidenzaUnitoAttoUnioneCivile;
		private String attoNascitaUnitoAttoUnioneCivile;
		private String comuneAttoNascitaUnitoAttoUnioneCivile;
		private String attoNascitaTrascrittoUnitoAttoUnioneCivile;
		private String comuneAttoNascitaTrascrittoUnitoAttoUnioneCivile;
		private String cognomeTestimone1AttoUnioneCivile;
		private String nomeTestimone1AttoUnioneCivile;
		private Date dataNascitaTestimone1AttoUnioneCivile;
		private String comuneNascitaTestimone1AttoUnioneCivile;
		private String provinciaNascitaTestimone1AttoUnioneCivile;
		private String statoEsteroNascitaTestimone1AttoUnioneCivile;
		private String comuneResidenzaTestimone1AttoUnioneCivile;
		private String provinciaResidenzaTestimone1AttoUnioneCivile;
		private String statoEsteroResidenzaTestimone1AttoUnioneCivile;
		private String cittadinanzaTestimone1AttoUnioneCivile;
		private String cognomeTestimone2AttoUnioneCivile;
		private String nomeTestimone2AttoUnioneCivile;
		private Date dataNascitaTestimone2AttoUnioneCivile;
		private String comuneNascitaTestimone2AttoUnioneCivile;
		private String provinciaNascitaTestimone2AttoUnioneCivile;
		private String statoEsteroNascitaTestimone2AttoUnioneCivile;
		private String comuneResidenzaTestimone2AttoUnioneCivile;
		private String provinciaResidenzaTestimone2AttoUnioneCivile;
		private String statoEsteroResidenzaTestimone2AttoUnioneCivile;
		private String cittadinanzaTestimone2AttoUnioneCivile;

		private TipoCessazioneMatrimonio tipoCessazioneMatrimonio;
		private Date dataDecorrenzaAnnullamentoMatrimonio;
		private Date dataSentenzaAnnullamentoMatrimonio;
		private String numeroSentenzaAnnullamentoMatrimonio;
		private String autoritaSentenzaAnnullamentoMatrimonio;
		private TipoTribunale tipoTribunale;

		private boolean attoAnnullamentoMatrimonioTrascitto;
		private String codiceIstatComuneAttoAnnullamentoMatrimonio;
		private String annoAttoAnnullamentoMatrimonio;
		private Date dataAttoAnnullamentoMatrimonio;
		private String numeroAttoAnnullamentoMatrimonio;
		private String parteAttoAnnullamentoMatrimonio;
		private String serieAttoAnnullamentoMatrimonio;
		private String volumeAttoAnnullamentoMatrimonio;
		private String ufficioAttoAnnullamentoMatrimonio;

		private boolean attoVedovanzaTrascitto;
		private Date dataAttoVedovanza;
		private String numeroAttoVedovanza;
		private String parteAttoVedovanza;
		private String serieAttoVedovanza;
		private String volumeAttoVedovanza;
		private String ufficioAttoVedovanza;
		private String codiceIstatComuneAttoVedovanza;

		private Date dataMorte;
		private boolean attoMorteTrascitto;
		private String cognomeNomeAttoMorte;
		private Date dataNascitaAttoMorte;
		private String numeroAttoMorte;
		private String parteAttoMorte;
		private String serieAttoMorte;
		private String ufficioAttoMorte;
		private String volumeAttoMorte;
		private String annoAttoMorte;
		private String codiceIstatComuneAttoMorte; // è il comune dell'atto o del dichiarante? TODO
		private String comuneNascitaAttoMorte;
		private String denominazioneComuneAttoMorte;
		private String annoStringaAttoMorte;
		private String meseStringaAttoMorte;
		private String giornoStringaAttoMorte;

		private String professione;
		private String titoloStudio;

		private List<DatiAnagrafici.ComponenteNucleoFamiliare.Pensione> pensioni;

		private String numeroCartaIdentita;
		private Date dataRilascioCartaIdentita;
		private Date dataScadenzaCartaIdentita;
		private String codiceIstatComuneRilascioCartaIdentita;

		private String telefono;
		private String cellulare;
		private String domicilioDigitale;

		public static class Pensione implements Serializable {

			private final static long serialVersionUID = 1L;
			private String numeroPensione;
			private String codicePensione;

			/**
			 * @return the numeroPensione
			 */
			public String getNumeroPensione() {
				return numeroPensione;
			}

			/**
			 * @param numeroPensione the numeroPensione to set
			 */
			public void setNumeroPensione(String numeroPensione) {
				this.numeroPensione = numeroPensione;
			}

			/**
			 * @return the codicePensione
			 */
			public String getCodicePensione() {
				return codicePensione;
			}

			/**
			 * @param codicePensione the codicePensione to set
			 */
			public void setCodicePensione(String codicePensione) {
				this.codicePensione = codicePensione;
			}

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
		 * @return the identificativo
		 */
		public String getIdentificativo() {
			return identificativo;
		}

		/**
		 * @param identificativo the identificativo to set
		 */
		public void setIdentificativo(String identificativo) {
			this.identificativo = identificativo;
		}

		/**
		 * @return the cognome
		 */
		public String getCognome() {
			return cognome;
		}

		/**
		 * @param cognome the cognome to set
		 */
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		/**
		 * @return the nome
		 */
		public String getNome() {
			return nome;
		}

		/**
		 * @param nome the nome to set
		 */
		public void setNome(String nome) {
			this.nome = nome;
		}

		/**
		 * @return the dataNascita
		 */
		public Date getDataNascita() {
			return dataNascita;
		}

		/**
		 * @param dataNascita the dataNascita to set
		 */
		public void setDataNascita(Date dataNascita) {
			this.dataNascita = dataNascita;
		}

		/**
		 * @return the dataNascitaSenzaGiorno
		 */
		public boolean isDataNascitaSenzaGiorno() {
			return dataNascitaSenzaGiorno;
		}

		/**
		 * @param dataNascitaSenzaGiorno the dataNascitaSenzaGiorno to set
		 */
		public void setDataNascitaSenzaGiorno(boolean dataNascitaSenzaGiorno) {
			this.dataNascitaSenzaGiorno = dataNascitaSenzaGiorno;
		}

		/**
		 * @return the dataNascitaSenzaGiornoMese
		 */
		public boolean isDataNascitaSenzaGiornoMese() {
			return dataNascitaSenzaGiornoMese;
		}

		/**
		 * @param dataNascitaSenzaGiornoMese the dataNascitaSenzaGiornoMese to set
		 */
		public void setDataNascitaSenzaGiornoMese(boolean dataNascitaSenzaGiornoMese) {
			this.dataNascitaSenzaGiornoMese = dataNascitaSenzaGiornoMese;
		}

		/**
		 * @return the sesso
		 */
		public String getSesso() {
			return sesso;
		}

		/**
		 * @param sesso the sesso to set
		 */
		public void setSesso(String sesso) {
			this.sesso = sesso;
		}

		/**
		 * @return the statoCivile
		 */
		public StatoCivile getStatoCivile() {
			return statoCivile;
		}

		/**
		 * @param statoCivile the statoCivile to set
		 */
		public void setStatoCivile(StatoCivile statoCivile) {
			this.statoCivile = statoCivile;
		}

		/**
		 * @return the relazioneParentela
		 */
		public RelazioneParentela getRelazioneParentela() {
			return relazioneParentela;
		}

		/**
		 * @param relazioneParentela the relazioneParentela to set
		 */
		public void setRelazioneParentela(RelazioneParentela relazioneParentela) {
			this.relazioneParentela = relazioneParentela;
		}

		/**
		 * @return the codiceFiscaleConiuge
		 */
		public String getCodiceFiscaleConiuge() {
			return codiceFiscaleConiuge;
		}

		/**
		 * @param codiceFiscaleConiuge the codiceFiscaleConiuge to set
		 */
		public void setCodiceFiscaleConiuge(String codiceFiscaleConiuge) {
			this.codiceFiscaleConiuge = codiceFiscaleConiuge;
		}

		/**
		 * @return the cognomeNomeConiuge
		 */
		public String getCognomeNomeConiuge() {
			return cognomeNomeConiuge;
		}

		/**
		 * @param cognomeNomeConiuge the cognomeNomeConiuge to set
		 */
		public void setCognomeNomeConiuge(String cognomeNomeConiuge) {
			this.cognomeNomeConiuge = cognomeNomeConiuge;
		}

		/**
		 * @return the cittadinanzaItaliana
		 */
		public boolean isCittadinanzaItaliana() {
			return cittadinanzaItaliana;
		}

		/**
		 * @param cittadinanzaItaliana the cittadinanzaItaliana to set
		 */
		public void setCittadinanzaItaliana(boolean cittadinanzaItaliana) {
			this.cittadinanzaItaliana = cittadinanzaItaliana;
		}

		/**
		 * @return the codiceIstatComuneNascita
		 */
		public String getCodiceIstatComuneNascita() {
			return codiceIstatComuneNascita;
		}

		/**
		 * @param codiceIstatComuneNascita the codiceIstatComuneNascita to set
		 */
		public void setCodiceIstatComuneNascita(String codiceIstatComuneNascita) {
			this.codiceIstatComuneNascita = codiceIstatComuneNascita;
		}

		/**
		 * @return the descrizioneComuneEsteroNascita
		 */
		public String getDescrizioneComuneEsteroNascita() {
			return descrizioneComuneEsteroNascita;
		}

		/**
		 * @param descrizioneComuneEsteroNascita the descrizioneComuneEsteroNascita to set
		 */
		public void setDescrizioneComuneEsteroNascita(String descrizioneComuneEsteroNascita) {
			this.descrizioneComuneEsteroNascita = descrizioneComuneEsteroNascita;
		}

		/**
		 * @return the codiceStatoEsteroNascita
		 */
		public Integer getCodiceStatoEsteroNascita() {
			return codiceStatoEsteroNascita;
		}

		/**
		 * @param codiceStatoEsteroNascita the codiceStatoEsteroNascita to set
		 */
		public void setCodiceStatoEsteroNascita(Integer codiceStatoEsteroNascita) {
			this.codiceStatoEsteroNascita = codiceStatoEsteroNascita;
		}

		/**
		 * @return the descrizioneStatoEsteroNascita
		 */
		public String getDescrizioneStatoEsteroNascita() {
			return descrizioneStatoEsteroNascita;
		}

		/**
		 * @param descrizioneStatoEsteroNascita the descrizioneStatoEsteroNascita to set
		 */
		public void setDescrizioneStatoEsteroNascita(String descrizioneStatoEsteroNascita) {
			this.descrizioneStatoEsteroNascita = descrizioneStatoEsteroNascita;
		}

		/**
		 * @return the codiceStatoComuneResidenza
		 */
		public String getCodiceStatoComuneResidenza() {
			return codiceStatoComuneResidenza;
		}

		/**
		 * @param codiceStatoComuneResidenza the codiceStatoComuneResidenza to set
		 */
		public void setCodiceStatoComuneResidenza(String codiceStatoComuneResidenza) {
			this.codiceStatoComuneResidenza = codiceStatoComuneResidenza;
		}

		/**
		 * @return the codiceIstatComuneResidenza
		 */
		public String getCodiceIstatComuneResidenza() {
			return codiceIstatComuneResidenza;
		}

		/**
		 * @param codiceIstatComuneResidenza the codiceIstatComuneResidenza to set
		 */
		public void setCodiceIstatComuneResidenza(String codiceIstatComuneResidenza) {
			this.codiceIstatComuneResidenza = codiceIstatComuneResidenza;
		}

		/**
		 * @return the codiceVia
		 */
		public String getCodiceVia() {
			return codiceVia;
		}

		/**
		 * @param codiceVia the codiceVia to set
		 */
		public void setCodiceVia(String codiceVia) {
			this.codiceVia = codiceVia;
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
		 * @return the attoNascitaTrascitto
		 */
		public boolean isAttoNascitaTrascitto() {
			return attoNascitaTrascitto;
		}

		/**
		 * @param attoNascitaTrascitto the attoNascitaTrascitto to set
		 */
		public void setAttoNascitaTrascitto(boolean attoNascitaTrascitto) {
			this.attoNascitaTrascitto = attoNascitaTrascitto;
		}

		/**
		 * @return the numeroAttoNascita
		 */
		public String getNumeroAttoNascita() {
			return numeroAttoNascita;
		}

		/**
		 * @param numeroAttoNascita the numeroAttoNascita to set
		 */
		public void setNumeroAttoNascita(String numeroAttoNascita) {
			this.numeroAttoNascita = numeroAttoNascita;
		}

		/**
		 * @return the parteAttoNascita
		 */
		public String getParteAttoNascita() {
			return parteAttoNascita;
		}

		/**
		 * @param parteAttoNascita the parteAttoNascita to set
		 */
		public void setParteAttoNascita(String parteAttoNascita) {
			this.parteAttoNascita = parteAttoNascita;
		}

		/**
		 * @return the serieAttoNascita
		 */
		public String getSerieAttoNascita() {
			return serieAttoNascita;
		}

		/**
		 * @param serieAttoNascita the serieAttoNascita to set
		 */
		public void setSerieAttoNascita(String serieAttoNascita) {
			this.serieAttoNascita = serieAttoNascita;
		}

		/**
		 * @return the annoAttoNascita
		 */
		public String getAnnoAttoNascita() {
			return annoAttoNascita;
		}

		/**
		 * @param annoAttoNascita the annoAttoNascita to set
		 */
		public void setAnnoAttoNascita(String annoAttoNascita) {
			this.annoAttoNascita = annoAttoNascita;
		}

		/**
		 * @return the ufficioAttoNascita
		 */
		public String getUfficioAttoNascita() {
			return ufficioAttoNascita;
		}

		/**
		 * @param ufficioAttoNascita the ufficioAttoNascita to set
		 */
		public void setUfficioAttoNascita(String ufficioAttoNascita) {
			this.ufficioAttoNascita = ufficioAttoNascita;
		}

		/**
		 * @return the codiceIstatComuneAttoNascita
		 */
		public String getCodiceIstatComuneAttoNascita() {
			return codiceIstatComuneAttoNascita;
		}

		/**
		 * @param codiceIstatComuneAttoNascita the codiceIstatComuneAttoNascita to set
		 */
		public void setCodiceIstatComuneAttoNascita(String codiceIstatComuneAttoNascita) {
			this.codiceIstatComuneAttoNascita = codiceIstatComuneAttoNascita;
		}

		/**
		 * @return the luogoMatrimonio
		 */
		public String getLuogoMatrimonio() {
			return luogoMatrimonio;
		}

		/**
		 * @param luogoMatrimonio the luogoMatrimonio to set
		 */
		public void setLuogoMatrimonio(String luogoMatrimonio) {
			this.luogoMatrimonio = luogoMatrimonio;
		}

		/**
		 * @return the dataMatrimonio
		 */
		public Date getDataMatrimonio() {
			return dataMatrimonio;
		}

		/**
		 * @param dataMatrimonio the dataMatrimonio to set
		 */
		public void setDataMatrimonio(Date dataMatrimonio) {
			this.dataMatrimonio = dataMatrimonio;
		}

		/**
		 * @return the attoMatrimonioTrascitto
		 */
		public boolean isAttoMatrimonioTrascitto() {
			return attoMatrimonioTrascitto;
		}

		/**
		 * @param attoMatrimonioTrascitto the attoMatrimonioTrascitto to set
		 */
		public void setAttoMatrimonioTrascitto(boolean attoMatrimonioTrascitto) {
			this.attoMatrimonioTrascitto = attoMatrimonioTrascitto;
		}

		/**
		 * @return the numeroAttoMatrimonio
		 */
		public String getNumeroAttoMatrimonio() {
			return numeroAttoMatrimonio;
		}

		/**
		 * @param numeroAttoMatrimonio the numeroAttoMatrimonio to set
		 */
		public void setNumeroAttoMatrimonio(String numeroAttoMatrimonio) {
			this.numeroAttoMatrimonio = numeroAttoMatrimonio;
		}

		/**
		 * @return the parteAttoMatrimonio
		 */
		public String getParteAttoMatrimonio() {
			return parteAttoMatrimonio;
		}

		/**
		 * @param parteAttoMatrimonio the parteAttoMatrimonio to set
		 */
		public void setParteAttoMatrimonio(String parteAttoMatrimonio) {
			this.parteAttoMatrimonio = parteAttoMatrimonio;
		}

		/**
		 * @return the serieAttoMatrimonio
		 */
		public String getSerieAttoMatrimonio() {
			return serieAttoMatrimonio;
		}

		/**
		 * @param serieAttoMatrimonio the serieAttoMatrimonio to set
		 */
		public void setSerieAttoMatrimonio(String serieAttoMatrimonio) {
			this.serieAttoMatrimonio = serieAttoMatrimonio;
		}

		/**
		 * @return the annoAttoMatrimonio
		 */
		public String getAnnoAttoMatrimonio() {
			return annoAttoMatrimonio;
		}

		/**
		 * @param annoAttoMatrimonio the annoAttoMatrimonio to set
		 */
		public void setAnnoAttoMatrimonio(String annoAttoMatrimonio) {
			this.annoAttoMatrimonio = annoAttoMatrimonio;
		}

		/**
		 * @return the ufficioAttoMatrimonio
		 */
		public String getUfficioAttoMatrimonio() {
			return ufficioAttoMatrimonio;
		}

		/**
		 * @param ufficioAttoMatrimonio the ufficioAttoMatrimonio to set
		 */
		public void setUfficioAttoMatrimonio(String ufficioAttoMatrimonio) {
			this.ufficioAttoMatrimonio = ufficioAttoMatrimonio;
		}

		/**
		 * @return the codiceIstatComuneAttoMatrimonio
		 */
		public String getCodiceIstatComuneAttoMatrimonio() {
			return codiceIstatComuneAttoMatrimonio;
		}

		/**
		 * @param codiceIstatComuneAttoMatrimonio the codiceIstatComuneAttoMatrimonio to set
		 */
		public void setCodiceIstatComuneAttoMatrimonio(String codiceIstatComuneAttoMatrimonio) {
			this.codiceIstatComuneAttoMatrimonio = codiceIstatComuneAttoMatrimonio;
		}

		/**
		 * @return the tipoCessazioneMatrimonio
		 */
		public TipoCessazioneMatrimonio getTipoCessazioneMatrimonio() {
			return tipoCessazioneMatrimonio;
		}

		/**
		 * @param tipoCessazioneMatrimonio the tipoCessazioneMatrimonio to set
		 */
		public void setTipoCessazioneMatrimonio(TipoCessazioneMatrimonio tipoCessazioneMatrimonio) {
			this.tipoCessazioneMatrimonio = tipoCessazioneMatrimonio;
		}

		/**
		 * @return the dataDecorrenzaAnnullamentoMatrimonio
		 */
		public Date getDataDecorrenzaAnnullamentoMatrimonio() {
			return dataDecorrenzaAnnullamentoMatrimonio;
		}

		/**
		 * @param dataDecorrenzaAnnullamentoMatrimonio the dataDecorrenzaAnnullamentoMatrimonio to
		 *        set
		 */
		public void setDataDecorrenzaAnnullamentoMatrimonio(Date dataDecorrenzaAnnullamentoMatrimonio) {
			this.dataDecorrenzaAnnullamentoMatrimonio = dataDecorrenzaAnnullamentoMatrimonio;
		}

		/**
		 * @return the dataSentenzaAnnullamentoMatrimonio
		 */
		public Date getDataSentenzaAnnullamentoMatrimonio() {
			return dataSentenzaAnnullamentoMatrimonio;
		}

		/**
		 * @param dataSentenzaAnnullamentoMatrimonio the dataSentenzaAnnullamentoMatrimonio to set
		 */
		public void setDataSentenzaAnnullamentoMatrimonio(Date dataSentenzaAnnullamentoMatrimonio) {
			this.dataSentenzaAnnullamentoMatrimonio = dataSentenzaAnnullamentoMatrimonio;
		}

		/**
		 * @return the numeroSentenzaAnnullamentoMatrimonio
		 */
		public String getNumeroSentenzaAnnullamentoMatrimonio() {
			return numeroSentenzaAnnullamentoMatrimonio;
		}

		/**
		 * @param numeroSentenzaAnnullamentoMatrimonio the numeroSentenzaAnnullamentoMatrimonio to
		 *        set
		 */
		public void setNumeroSentenzaAnnullamentoMatrimonio(String numeroSentenzaAnnullamentoMatrimonio) {
			this.numeroSentenzaAnnullamentoMatrimonio = numeroSentenzaAnnullamentoMatrimonio;
		}

		/**
		 * @return the autoritaSentenzaAnnullamentoMatrimonio
		 */
		public String getAutoritaSentenzaAnnullamentoMatrimonio() {
			return autoritaSentenzaAnnullamentoMatrimonio;
		}

		/**
		 * @param autoritaSentenzaAnnullamentoMatrimonio the autoritaSentenzaAnnullamentoMatrimonio
		 *        to set
		 */
		public void setAutoritaSentenzaAnnullamentoMatrimonio(String autoritaSentenzaAnnullamentoMatrimonio) {
			this.autoritaSentenzaAnnullamentoMatrimonio = autoritaSentenzaAnnullamentoMatrimonio;
		}

		/**
		 * @return the tipoTribunale
		 */
		public TipoTribunale getTipoTribunale() {
			return tipoTribunale;
		}

		/**
		 * @param tipoTribunale the tipoTribunale to set
		 */
		public void setTipoTribunale(TipoTribunale tipoTribunale) {
			this.tipoTribunale = tipoTribunale;
		}

		/**
		 * @return the attoAnnullamentoMatrimonioTrascitto
		 */
		public boolean isAttoAnnullamentoMatrimonioTrascitto() {
			return attoAnnullamentoMatrimonioTrascitto;
		}

		/**
		 * @param attoAnnullamentoMatrimonioTrascitto the attoAnnullamentoMatrimonioTrascitto to set
		 */
		public void setAttoAnnullamentoMatrimonioTrascitto(boolean attoAnnullamentoMatrimonioTrascitto) {
			this.attoAnnullamentoMatrimonioTrascitto = attoAnnullamentoMatrimonioTrascitto;
		}

		/**
		 * @return the codiceIstatComuneAttoAnnullamentoMatrimonio
		 */
		public String getCodiceIstatComuneAttoAnnullamentoMatrimonio() {
			return codiceIstatComuneAttoAnnullamentoMatrimonio;
		}

		/**
		 * @param codiceIstatComuneAttoAnnullamentoMatrimonio the
		 *        codiceIstatComuneAttoAnnullamentoMatrimonio to set
		 */
		public void setCodiceIstatComuneAttoAnnullamentoMatrimonio(String codiceIstatComuneAttoAnnullamentoMatrimonio) {
			this.codiceIstatComuneAttoAnnullamentoMatrimonio = codiceIstatComuneAttoAnnullamentoMatrimonio;
		}

		/**
		 * @return the annoAttoAnnullamentoMatrimonio
		 */
		public String getAnnoAttoAnnullamentoMatrimonio() {
			return annoAttoAnnullamentoMatrimonio;
		}

		/**
		 * @param annoAttoAnnullamentoMatrimonio the annoAttoAnnullamentoMatrimonio to set
		 */
		public void setAnnoAttoAnnullamentoMatrimonio(String annoAttoAnnullamentoMatrimonio) {
			this.annoAttoAnnullamentoMatrimonio = annoAttoAnnullamentoMatrimonio;
		}

		/**
		 * @return the dataAttoAnnullamentoMatrimonio
		 */
		public Date getDataAttoAnnullamentoMatrimonio() {
			return dataAttoAnnullamentoMatrimonio;
		}

		/**
		 * @param dataAttoAnnullamentoMatrimonio the dataAttoAnnullamentoMatrimonio to set
		 */
		public void setDataAttoAnnullamentoMatrimonio(Date dataAttoAnnullamentoMatrimonio) {
			this.dataAttoAnnullamentoMatrimonio = dataAttoAnnullamentoMatrimonio;
		}

		/**
		 * @return the numeroAttoAnnullamentoMatrimonio
		 */
		public String getNumeroAttoAnnullamentoMatrimonio() {
			return numeroAttoAnnullamentoMatrimonio;
		}

		/**
		 * @param numeroAttoAnnullamentoMatrimonio the numeroAttoAnnullamentoMatrimonio to set
		 */
		public void setNumeroAttoAnnullamentoMatrimonio(String numeroAttoAnnullamentoMatrimonio) {
			this.numeroAttoAnnullamentoMatrimonio = numeroAttoAnnullamentoMatrimonio;
		}

		/**
		 * @return the parteAttoAnnullamentoMatrimonio
		 */
		public String getParteAttoAnnullamentoMatrimonio() {
			return parteAttoAnnullamentoMatrimonio;
		}

		/**
		 * @param parteAttoAnnullamentoMatrimonio the parteAttoAnnullamentoMatrimonio to set
		 */
		public void setParteAttoAnnullamentoMatrimonio(String parteAttoAnnullamentoMatrimonio) {
			this.parteAttoAnnullamentoMatrimonio = parteAttoAnnullamentoMatrimonio;
		}

		/**
		 * @return the serieAttoAnnullamentoMatrimonio
		 */
		public String getSerieAttoAnnullamentoMatrimonio() {
			return serieAttoAnnullamentoMatrimonio;
		}

		/**
		 * @param serieAttoAnnullamentoMatrimonio the serieAttoAnnullamentoMatrimonio to set
		 */
		public void setSerieAttoAnnullamentoMatrimonio(String serieAttoAnnullamentoMatrimonio) {
			this.serieAttoAnnullamentoMatrimonio = serieAttoAnnullamentoMatrimonio;
		}

		/**
		 * @return the volumeAttoAnnullamentoMatrimonio
		 */
		public String getVolumeAttoAnnullamentoMatrimonio() {
			return volumeAttoAnnullamentoMatrimonio;
		}

		/**
		 * @param volumeAttoAnnullamentoMatrimonio the volumeAttoAnnullamentoMatrimonio to set
		 */
		public void setVolumeAttoAnnullamentoMatrimonio(String volumeAttoAnnullamentoMatrimonio) {
			this.volumeAttoAnnullamentoMatrimonio = volumeAttoAnnullamentoMatrimonio;
		}

		/**
		 * @return the ufficioAttoAnnullamentoMatrimonio
		 */
		public String getUfficioAttoAnnullamentoMatrimonio() {
			return ufficioAttoAnnullamentoMatrimonio;
		}

		/**
		 * @param ufficioAttoAnnullamentoMatrimonio the ufficioAttoAnnullamentoMatrimonio to set
		 */
		public void setUfficioAttoAnnullamentoMatrimonio(String ufficioAttoAnnullamentoMatrimonio) {
			this.ufficioAttoAnnullamentoMatrimonio = ufficioAttoAnnullamentoMatrimonio;
		}

		/**
		 * @return the dataAttoVedovanza
		 */
		public Date getDataAttoVedovanza() {
			return dataAttoVedovanza;
		}

		/**
		 * @param dataAttoVedovanza the dataAttoVedovanza to set
		 */
		public void setDataAttoVedovanza(Date dataAttoVedovanza) {
			this.dataAttoVedovanza = dataAttoVedovanza;
		}

		/**
		 * @return the numeroAttoVedovanza
		 */
		public String getNumeroAttoVedovanza() {
			return numeroAttoVedovanza;
		}

		/**
		 * @param numeroAttoVedovanza the numeroAttoVedovanza to set
		 */
		public void setNumeroAttoVedovanza(String numeroAttoVedovanza) {
			this.numeroAttoVedovanza = numeroAttoVedovanza;
		}

		/**
		 * @return the parteAttoVedovanza
		 */
		public String getParteAttoVedovanza() {
			return parteAttoVedovanza;
		}

		/**
		 * @param parteAttoVedovanza the parteAttoVedovanza to set
		 */
		public void setParteAttoVedovanza(String parteAttoVedovanza) {
			this.parteAttoVedovanza = parteAttoVedovanza;
		}

		/**
		 * @return the serieAttoVedovanza
		 */
		public String getSerieAttoVedovanza() {
			return serieAttoVedovanza;
		}

		/**
		 * @param serieAttoVedovanza the serieAttoVedovanza to set
		 */
		public void setSerieAttoVedovanza(String serieAttoVedovanza) {
			this.serieAttoVedovanza = serieAttoVedovanza;
		}

		/**
		 * @return the volumeAttoVedovanza
		 */
		public String getVolumeAttoVedovanza() {
			return volumeAttoVedovanza;
		}

		/**
		 * @param volumeAttoVedovanza the volumeAttoVedovanza to set
		 */
		public void setVolumeAttoVedovanza(String volumeAttoVedovanza) {
			this.volumeAttoVedovanza = volumeAttoVedovanza;
		}

		/**
		 * @return the ufficioAttoVedovanza
		 */
		public String getUfficioAttoVedovanza() {
			return ufficioAttoVedovanza;
		}

		/**
		 * @param ufficioAttoVedovanza the ufficioAttoVedovanza to set
		 */
		public void setUfficioAttoVedovanza(String ufficioAttoVedovanza) {
			this.ufficioAttoVedovanza = ufficioAttoVedovanza;
		}

		/**
		 * @return the dataMorte
		 */
		public Date getDataMorte() {
			return dataMorte;
		}

		/**
		 * @param dataMorte the dataMorte to set
		 */
		public void setDataMorte(Date dataMorte) {
			this.dataMorte = dataMorte;
		}

		/**
		 * @return the attoMorteTrascitto
		 */
		public boolean isAttoMorteTrascitto() {
			return attoMorteTrascitto;
		}

		/**
		 * @param attoMorteTrascitto the attoMorteTrascitto to set
		 */
		public void setAttoMorteTrascitto(boolean attoMorteTrascitto) {
			this.attoMorteTrascitto = attoMorteTrascitto;
		}

		/**
		 * @return the numeroAttoMorte
		 */
		public String getNumeroAttoMorte() {
			return numeroAttoMorte;
		}

		/**
		 * @param numeroAttoMorte the numeroAttoMorte to set
		 */
		public void setNumeroAttoMorte(String numeroAttoMorte) {
			this.numeroAttoMorte = numeroAttoMorte;
		}

		/**
		 * @return the parteAttoMorte
		 */
		public String getParteAttoMorte() {
			return parteAttoMorte;
		}

		/**
		 * @param parteAttoMorte the parteAttoMorte to set
		 */
		public void setParteAttoMorte(String parteAttoMorte) {
			this.parteAttoMorte = parteAttoMorte;
		}

		/**
		 * @return the serieAttoMorte
		 */
		public String getSerieAttoMorte() {
			return serieAttoMorte;
		}

		/**
		 * @param serieAttoMorte the serieAttoMorte to set
		 */
		public void setSerieAttoMorte(String serieAttoMorte) {
			this.serieAttoMorte = serieAttoMorte;
		}

		/**
		 * @return the ufficioAttoMorte
		 */
		public String getUfficioAttoMorte() {
			return ufficioAttoMorte;
		}

		/**
		 * @param ufficioAttoMorte the ufficioAttoMorte to set
		 */
		public void setUfficioAttoMorte(String ufficioAttoMorte) {
			this.ufficioAttoMorte = ufficioAttoMorte;
		}

		/**
		 * @return the annoAttoMorte
		 */
		public String getAnnoAttoMorte() {
			return annoAttoMorte;
		}

		/**
		 * @param annoAttoMorte the annoAttoMorte to set
		 */
		public void setAnnoAttoMorte(String annoAttoMorte) {
			this.annoAttoMorte = annoAttoMorte;
		}

		/**
		 * @return the codiceIstatComuneAttoMorte
		 */
		public String getCodiceIstatComuneAttoMorte() {
			return codiceIstatComuneAttoMorte;
		}

		/**
		 * @param codiceIstatComuneAttoMorte the codiceIstatComuneAttoMorte to set
		 */
		public void setCodiceIstatComuneAttoMorte(String codiceIstatComuneAttoMorte) {
			this.codiceIstatComuneAttoMorte = codiceIstatComuneAttoMorte;
		}

		/**
		 * @return the professione
		 */
		public String getProfessione() {
			return professione;
		}

		/**
		 * @param professione the professione to set
		 */
		public void setProfessione(String professione) {
			this.professione = professione;
		}

		/**
		 * @return the titoloStudio
		 */
		public String getTitoloStudio() {
			return titoloStudio;
		}

		/**
		 * @param titoloStudio the titoloStudio to set
		 */
		public void setTitoloStudio(String titoloStudio) {
			this.titoloStudio = titoloStudio;
		}

		/**
		 * @return the pensioni
		 */
		public List<DatiAnagrafici.ComponenteNucleoFamiliare.Pensione> getPensioni() {
			return pensioni;
		}

		/**
		 * @param pensioni the pensioni to set
		 */
		public void setPensioni(List<DatiAnagrafici.ComponenteNucleoFamiliare.Pensione> pensioni) {
			this.pensioni = pensioni;
		}

		/**
		 * @return the numeroCartaIdentita
		 */
		public String getNumeroCartaIdentita() {
			return numeroCartaIdentita;
		}

		/**
		 * @param numeroCartaIdentita the numeroCartaIdentita to set
		 */
		public void setNumeroCartaIdentita(String numeroCartaIdentita) {
			this.numeroCartaIdentita = numeroCartaIdentita;
		}

		/**
		 * @return the dataRilascioCartaIdentita
		 */
		public Date getDataRilascioCartaIdentita() {
			return dataRilascioCartaIdentita;
		}

		/**
		 * @param dataRilascioCartaIdentita the dataRilascioCartaIdentita to set
		 */
		public void setDataRilascioCartaIdentita(Date dataRilascioCartaIdentita) {
			this.dataRilascioCartaIdentita = dataRilascioCartaIdentita;
		}

		/**
		 * @return the dataScadenzaCartaIdentita
		 */
		public Date getDataScadenzaCartaIdentita() {
			return dataScadenzaCartaIdentita;
		}

		/**
		 * @param dataScadenzaCartaIdentita the dataScadenzaCartaIdentita to set
		 */
		public void setDataScadenzaCartaIdentita(Date dataScadenzaCartaIdentita) {
			this.dataScadenzaCartaIdentita = dataScadenzaCartaIdentita;
		}

		/**
		 * @return the codiceIstatComuneRilascioCartaIdentita
		 */
		public String getCodiceIstatComuneRilascioCartaIdentita() {
			return codiceIstatComuneRilascioCartaIdentita;
		}

		/**
		 * @param codiceIstatComuneRilascioCartaIdentita the codiceIstatComuneRilascioCartaIdentita
		 *        to set
		 */
		public void setCodiceIstatComuneRilascioCartaIdentita(String codiceIstatComuneRilascioCartaIdentita) {
			this.codiceIstatComuneRilascioCartaIdentita = codiceIstatComuneRilascioCartaIdentita;
		}

		/**
		 * @return the telefono
		 */
		public String getTelefono() {
			return telefono;
		}

		/**
		 * @param telefono the telefono to set
		 */
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		/**
		 * @return the cellulare
		 */
		public String getCellulare() {
			return cellulare;
		}

		/**
		 * @param cellulare the cellulare to set
		 */
		public void setCellulare(String cellulare) {
			this.cellulare = cellulare;
		}

		/**
		 * @return the domicilioDigitale
		 */
		public String getDomicilioDigitale() {
			return domicilioDigitale;
		}

		/**
		 * @param domicilioDigitale the domicilioDigitale to set
		 */
		public void setDomicilioDigitale(String domicilioDigitale) {
			this.domicilioDigitale = domicilioDigitale;
		}

		/**
		 * @return the attoVedovanzaTrascitto
		 */
		public boolean isAttoVedovanzaTrascitto() {
			return attoVedovanzaTrascitto;
		}

		/**
		 * @param attoVedovanzaTrascitto the attoVedovanzaTrascitto to set
		 */
		public void setAttoVedovanzaTrascitto(boolean attoVedovanzaTrascitto) {
			this.attoVedovanzaTrascitto = attoVedovanzaTrascitto;
		}

		/**
		 * @return the codiceIstatComuneAttoVedovanza
		 */
		public String getCodiceIstatComuneAttoVedovanza() {
			return codiceIstatComuneAttoVedovanza;
		}

		/**
		 * @param codiceIstatComuneAttoVedovanza the codiceIstatComuneAttoVedovanza to set
		 */
		public void setCodiceIstatComuneAttoVedovanza(String codiceIstatComuneAttoVedovanza) {
			this.codiceIstatComuneAttoVedovanza = codiceIstatComuneAttoVedovanza;
		}

		/**
		 * @return the volumeAttoNascita
		 */
		public String getVolumeAttoNascita() {
			return volumeAttoNascita;
		}

		/**
		 * @param volumeAttoNascita the volumeAttoNascita to set
		 */
		public void setVolumeAttoNascita(String volumeAttoNascita) {
			this.volumeAttoNascita = volumeAttoNascita;
		}

		/**
		 * @return the denominazioneComuneAttoNascita
		 */
		public String getDenominazioneComuneAttoNascita() {
			return denominazioneComuneAttoNascita;
		}

		/**
		 * @param denominazioneComuneAttoNascita the denominazioneComuneAttoNascita to set
		 */
		public void setDenominazioneComuneAttoNascita(String denominazioneComuneAttoNascita) {
			this.denominazioneComuneAttoNascita = denominazioneComuneAttoNascita;
		}

		/**
		 * @return the annoStringaAttoNascita
		 */
		public String getAnnoStringaAttoNascita() {
			return annoStringaAttoNascita;
		}

		/**
		 * @param annoStringaAttoNascita the annoStringaAttoNascita to set
		 */
		public void setAnnoStringaAttoNascita(String annoStringaAttoNascita) {
			this.annoStringaAttoNascita = annoStringaAttoNascita;
		}

		/**
		 * @return the meseStringaAttoNascita
		 */
		public String getMeseStringaAttoNascita() {
			return meseStringaAttoNascita;
		}

		/**
		 * @param meseStringaAttoNascita the meseStringaAttoNascita to set
		 */
		public void setMeseStringaAttoNascita(String meseStringaAttoNascita) {
			this.meseStringaAttoNascita = meseStringaAttoNascita;
		}

		/**
		 * @return the giornoStringaAttoNascita
		 */
		public String getGiornoStringaAttoNascita() {
			return giornoStringaAttoNascita;
		}

		/**
		 * @param giornoStringaAttoNascita the giornoStringaAttoNascita to set
		 */
		public void setGiornoStringaAttoNascita(String giornoStringaAttoNascita) {
			this.giornoStringaAttoNascita = giornoStringaAttoNascita;
		}

		/**
		 * @return the volumeAttoMorte
		 */
		public String getVolumeAttoMorte() {
			return volumeAttoMorte;
		}

		/**
		 * @param volumeAttoMorte the volumeAttoMorte to set
		 */
		public void setVolumeAttoMorte(String volumeAttoMorte) {
			this.volumeAttoMorte = volumeAttoMorte;
		}

		/**
		 * @return the denominazioneComuneAttoMorte
		 */
		public String getDenominazioneComuneAttoMorte() {
			return denominazioneComuneAttoMorte;
		}

		/**
		 * @param denominazioneComuneAttoMorte the denominazioneComuneAttoMorte to set
		 */
		public void setDenominazioneComuneAttoMorte(String denominazioneComuneAttoMorte) {
			this.denominazioneComuneAttoMorte = denominazioneComuneAttoMorte;
		}

		/**
		 * @return the annoStringaAttoMorte
		 */
		public String getAnnoStringaAttoMorte() {
			return annoStringaAttoMorte;
		}

		/**
		 * @param annoStringaAttoMorte the annoStringaAttoMorte to set
		 */
		public void setAnnoStringaAttoMorte(String annoStringaAttoMorte) {
			this.annoStringaAttoMorte = annoStringaAttoMorte;
		}

		/**
		 * @return the meseStringaAttoMorte
		 */
		public String getMeseStringaAttoMorte() {
			return meseStringaAttoMorte;
		}

		/**
		 * @param meseStringaAttoMorte the meseStringaAttoMorte to set
		 */
		public void setMeseStringaAttoMorte(String meseStringaAttoMorte) {
			this.meseStringaAttoMorte = meseStringaAttoMorte;
		}

		/**
		 * @return the giornoStringaAttoMorte
		 */
		public String getGiornoStringaAttoMorte() {
			return giornoStringaAttoMorte;
		}

		/**
		 * @param giornoStringaAttoMorte the giornoStringaAttoMorte to set
		 */
		public void setGiornoStringaAttoMorte(String giornoStringaAttoMorte) {
			this.giornoStringaAttoMorte = giornoStringaAttoMorte;
		}

		/**
		 * @return the denominazioneComuneAttoMatrimonio
		 */
		public String getDenominazioneComuneAttoMatrimonio() {
			return denominazioneComuneAttoMatrimonio;
		}

		/**
		 * @param denominazioneComuneAttoMatrimonio the denominazioneComuneAttoMatrimonio to set
		 */
		public void setDenominazioneComuneAttoMatrimonio(String denominazioneComuneAttoMatrimonio) {
			this.denominazioneComuneAttoMatrimonio = denominazioneComuneAttoMatrimonio;
		}

		/**
		 * @return the annoStringaAttoMatrimonio
		 */
		public String getAnnoStringaAttoMatrimonio() {
			return annoStringaAttoMatrimonio;
		}

		/**
		 * @param annoStringaAttoMatrimonio the annoStringaAttoMatrimonio to set
		 */
		public void setAnnoStringaAttoMatrimonio(String annoStringaAttoMatrimonio) {
			this.annoStringaAttoMatrimonio = annoStringaAttoMatrimonio;
		}

		/**
		 * @return the meseStringaAttoMatrimonio
		 */
		public String getMeseStringaAttoMatrimonio() {
			return meseStringaAttoMatrimonio;
		}

		/**
		 * @param meseStringaAttoMatrimonio the meseStringaAttoMatrimonio to set
		 */
		public void setMeseStringaAttoMatrimonio(String meseStringaAttoMatrimonio) {
			this.meseStringaAttoMatrimonio = meseStringaAttoMatrimonio;
		}

		/**
		 * @return the giornoStringaAttoMatrimonio
		 */
		public String getGiornoStringaAttoMatrimonio() {
			return giornoStringaAttoMatrimonio;
		}

		/**
		 * @param giornoStringaAttoMatrimonio the giornoStringaAttoMatrimonio to set
		 */
		public void setGiornoStringaAttoMatrimonio(String giornoStringaAttoMatrimonio) {
			this.giornoStringaAttoMatrimonio = giornoStringaAttoMatrimonio;
		}

		/**
		 * @return the cognomeNomeAttoMatrimonio
		 */
		public String getCognomeNomeAttoMatrimonio() {
			return cognomeNomeAttoMatrimonio;
		}

		/**
		 * @param cognomeNomeAttoMatrimonio the cognomeNomeAttoMatrimonio to set
		 */
		public void setCognomeNomeAttoMatrimonio(String cognomeNomeAttoMatrimonio) {
			this.cognomeNomeAttoMatrimonio = cognomeNomeAttoMatrimonio;
		}

		/**
		 * @return the dataNascitaAttoMatrimonio
		 */
		public Date getDataNascitaAttoMatrimonio() {
			return dataNascitaAttoMatrimonio;
		}

		/**
		 * @param dataNascitaAttoMatrimonio the dataNascitaAttoMatrimonio to set
		 */
		public void setDataNascitaAttoMatrimonio(Date dataNascitaAttoMatrimonio) {
			this.dataNascitaAttoMatrimonio = dataNascitaAttoMatrimonio;
		}

		/**
		 * @return the comuneNascitaAttoMatrimonio
		 */
		public String getComuneNascitaAttoMatrimonio() {
			return comuneNascitaAttoMatrimonio;
		}

		/**
		 * @param comuneNascitaAttoMatrimonio the comuneNascitaAttoMatrimonio to set
		 */
		public void setComuneNascitaAttoMatrimonio(String comuneNascitaAttoMatrimonio) {
			this.comuneNascitaAttoMatrimonio = comuneNascitaAttoMatrimonio;
		}

		/**
		 * @return the cognomeNomeConiugeAttoMatrimonio
		 */
		public String getCognomeNomeConiugeAttoMatrimonio() {
			return cognomeNomeConiugeAttoMatrimonio;
		}

		/**
		 * @param cognomeNomeConiugeAttoMatrimonio the cognomeNomeConiugeAttoMatrimonio to set
		 */
		public void setCognomeNomeConiugeAttoMatrimonio(String cognomeNomeConiugeAttoMatrimonio) {
			this.cognomeNomeConiugeAttoMatrimonio = cognomeNomeConiugeAttoMatrimonio;
		}

		/**
		 * @return the dataNascitaConiugeAttoMatrimonio
		 */
		public Date getDataNascitaConiugeAttoMatrimonio() {
			return dataNascitaConiugeAttoMatrimonio;
		}

		/**
		 * @param dataNascitaConiugeAttoMatrimonio the dataNascitaConiugeAttoMatrimonio to set
		 */
		public void setDataNascitaConiugeAttoMatrimonio(Date dataNascitaConiugeAttoMatrimonio) {
			this.dataNascitaConiugeAttoMatrimonio = dataNascitaConiugeAttoMatrimonio;
		}

		/**
		 * @return the comuneNascitaConiugeAttoMatrimonio
		 */
		public String getComuneNascitaConiugeAttoMatrimonio() {
			return comuneNascitaConiugeAttoMatrimonio;
		}

		/**
		 * @param comuneNascitaConiugeAttoMatrimonio the comuneNascitaConiugeAttoMatrimonio to set
		 */
		public void setComuneNascitaConiugeAttoMatrimonio(String comuneNascitaConiugeAttoMatrimonio) {
			this.comuneNascitaConiugeAttoMatrimonio = comuneNascitaConiugeAttoMatrimonio;
		}

		/**
		 * @return the volumeAttoMartrimonio
		 */
		public String getVolumeAttoMartrimonio() {
			return volumeAttoMartrimonio;
		}

		/**
		 * @param volumeAttoMartrimonio the volumeAttoMartrimonio to set
		 */
		public void setVolumeAttoMartrimonio(String volumeAttoMartrimonio) {
			this.volumeAttoMartrimonio = volumeAttoMartrimonio;
		}

		/**
		 * @return the numeroAttoUnioneCivile
		 */
		public String getNumeroAttoUnioneCivile() {
			return numeroAttoUnioneCivile;
		}

		/**
		 * @param numeroAttoUnioneCivile the numeroAttoUnioneCivile to set
		 */
		public void setNumeroAttoUnioneCivile(String numeroAttoUnioneCivile) {
			this.numeroAttoUnioneCivile = numeroAttoUnioneCivile;
		}

		/**
		 * @return the parteAttoUnioneCivile
		 */
		public String getParteAttoUnioneCivile() {
			return parteAttoUnioneCivile;
		}

		/**
		 * @param parteAttoUnioneCivile the parteAttoUnioneCivile to set
		 */
		public void setParteAttoUnioneCivile(String parteAttoUnioneCivile) {
			this.parteAttoUnioneCivile = parteAttoUnioneCivile;
		}

		/**
		 * @return the serieAttoUnioneCivile
		 */
		public String getSerieAttoUnioneCivile() {
			return serieAttoUnioneCivile;
		}

		/**
		 * @param serieAttoUnioneCivile the serieAttoUnioneCivile to set
		 */
		public void setSerieAttoUnioneCivile(String serieAttoUnioneCivile) {
			this.serieAttoUnioneCivile = serieAttoUnioneCivile;
		}

		/**
		 * @return the annoAttoUnioneCivile
		 */
		public String getAnnoAttoUnioneCivile() {
			return annoAttoUnioneCivile;
		}

		/**
		 * @param annoAttoUnioneCivile the annoAttoUnioneCivile to set
		 */
		public void setAnnoAttoUnioneCivile(String annoAttoUnioneCivile) {
			this.annoAttoUnioneCivile = annoAttoUnioneCivile;
		}

		/**
		 * @return the ufficioAttoUnioneCivile
		 */
		public String getUfficioAttoUnioneCivile() {
			return ufficioAttoUnioneCivile;
		}

		/**
		 * @param ufficioAttoUnioneCivile the ufficioAttoUnioneCivile to set
		 */
		public void setUfficioAttoUnioneCivile(String ufficioAttoUnioneCivile) {
			this.ufficioAttoUnioneCivile = ufficioAttoUnioneCivile;
		}

		/**
		 * @return the codiceIstatComuneAttoUnioneCivile
		 */
		public String getCodiceIstatComuneAttoUnioneCivile() {
			return codiceIstatComuneAttoUnioneCivile;
		}

		/**
		 * @param codiceIstatComuneAttoUnioneCivile the codiceIstatComuneAttoUnioneCivile to set
		 */
		public void setCodiceIstatComuneAttoUnioneCivile(String codiceIstatComuneAttoUnioneCivile) {
			this.codiceIstatComuneAttoUnioneCivile = codiceIstatComuneAttoUnioneCivile;
		}

		/**
		 * @return the denominazioneComuneAttoUnioneCivile
		 */
		public String getDenominazioneComuneAttoUnioneCivile() {
			return denominazioneComuneAttoUnioneCivile;
		}

		/**
		 * @param denominazioneComuneAttoUnioneCivile the denominazioneComuneAttoUnioneCivile to set
		 */
		public void setDenominazioneComuneAttoUnioneCivile(String denominazioneComuneAttoUnioneCivile) {
			this.denominazioneComuneAttoUnioneCivile = denominazioneComuneAttoUnioneCivile;
		}

		/**
		 * @return the dataAttoUnioneCivile
		 */
		public Date getDataAttoUnioneCivile() {
			return dataAttoUnioneCivile;
		}

		/**
		 * @param dataAttoUnioneCivile the dataAttoUnioneCivile to set
		 */
		public void setDataAttoUnioneCivile(Date dataAttoUnioneCivile) {
			this.dataAttoUnioneCivile = dataAttoUnioneCivile;
		}

		/**
		 * @return the volumeAttoAttoUnioneCivile
		 */
		public String getVolumeAttoUnioneCivile() {
			return volumeAttoUnioneCivile;
		}

		/**
		 * @param volumeAttoAttoUnioneCivile the volumeAttoAttoUnioneCivile to set
		 */
		public void setVolumeAttoUnioneCivile(String volumeAttoUnioneCivile) {
			this.volumeAttoUnioneCivile = volumeAttoUnioneCivile;
		}

		/**
		 * @return the regimePatrimonialeAttoUnioneCivile
		 */
		public String getRegimePatrimonialeAttoUnioneCivile() {
			return regimePatrimonialeAttoUnioneCivile;
		}

		/**
		 * @param regimePatrimonialeAttoUnioneCivile the regimePatrimonialeAttoUnioneCivile to set
		 */
		public void setRegimePatrimonialeAttoUnioneCivile(String regimePatrimonialeAttoUnioneCivile) {
			this.regimePatrimonialeAttoUnioneCivile = regimePatrimonialeAttoUnioneCivile;
		}

		/**
		 * @return the cognomeAttoUnioneCivile
		 */
		public String getCognomeAttoUnioneCivile() {
			return cognomeAttoUnioneCivile;
		}

		/**
		 * @param cognomeAttoUnioneCivile the cognomeAttoUnioneCivile to set
		 */
		public void setCognomeAttoUnioneCivile(String cognomeAttoUnioneCivile) {
			this.cognomeAttoUnioneCivile = cognomeAttoUnioneCivile;
		}

		/**
		 * @return the nomeAttoUnioneCivile
		 */
		public String getNomeAttoUnioneCivile() {
			return nomeAttoUnioneCivile;
		}

		/**
		 * @param nomeAttoUnioneCivile the nomeAttoUnioneCivile to set
		 */
		public void setNomeAttoUnioneCivile(String nomeAttoUnioneCivile) {
			this.nomeAttoUnioneCivile = nomeAttoUnioneCivile;
		}

		/**
		 * @return the etaAttoUnioneCivile
		 */
		public String getEtaAttoUnioneCivile() {
			return etaAttoUnioneCivile;
		}

		/**
		 * @param etaAttoUnioneCivile the etaAttoUnioneCivile to set
		 */
		public void setEtaAttoUnioneCivile(String etaAttoUnioneCivile) {
			this.etaAttoUnioneCivile = etaAttoUnioneCivile;
		}

		/**
		 * @return the comuneNascitaAttoUnioneCivile
		 */
		public String getComuneNascitaAttoUnioneCivile() {
			return comuneNascitaAttoUnioneCivile;
		}

		/**
		 * @param comuneNascitaAttoUnioneCivile the comuneNascitaAttoUnioneCivile to set
		 */
		public void setComuneNascitaAttoUnioneCivile(String comuneNascitaAttoUnioneCivile) {
			this.comuneNascitaAttoUnioneCivile = comuneNascitaAttoUnioneCivile;
		}

		/**
		 * @return the comuneResidenzaAttoUnioneCivile
		 */
		public String getComuneResidenzaAttoUnioneCivile() {
			return comuneResidenzaAttoUnioneCivile;
		}

		/**
		 * @param comuneResidenzaAttoUnioneCivile the comuneResidenzaAttoUnioneCivile to set
		 */
		public void setComuneResidenzaAttoUnioneCivile(String comuneResidenzaAttoUnioneCivile) {
			this.comuneResidenzaAttoUnioneCivile = comuneResidenzaAttoUnioneCivile;
		}

		/**
		 * @return the attoNascitaAttoUnioneCivile
		 */
		public String getAttoNascitaAttoUnioneCivile() {
			return attoNascitaAttoUnioneCivile;
		}

		/**
		 * @param attoNascitaAttoUnioneCivile the attoNascitaAttoUnioneCivile to set
		 */
		public void setAttoNascitaAttoUnioneCivile(String attoNascitaAttoUnioneCivile) {
			this.attoNascitaAttoUnioneCivile = attoNascitaAttoUnioneCivile;
		}

		/**
		 * @return the attoNascitaTrascrittoAttoUnioneCivile
		 */
		public String getAttoNascitaTrascrittoAttoUnioneCivile() {
			return attoNascitaTrascrittoAttoUnioneCivile;
		}

		/**
		 * @param attoNascitaTrascrittoAttoUnioneCivile the attoNascitaTrascrittoAttoUnioneCivile to
		 *        set
		 */
		public void setAttoNascitaTrascrittoAttoUnioneCivile(String attoNascitaTrascrittoAttoUnioneCivile) {
			this.attoNascitaTrascrittoAttoUnioneCivile = attoNascitaTrascrittoAttoUnioneCivile;
		}

		/**
		 * @return the comuneAttoNascitaTrascrittoAttoUnioneCivile
		 */
		public String getComuneAttoNascitaTrascrittoAttoUnioneCivile() {
			return comuneAttoNascitaTrascrittoAttoUnioneCivile;
		}

		/**
		 * @param comuneAttoNascitaTrascrittoAttoUnioneCivile the
		 *        comuneAttoNascitaTrascrittoAttoUnioneCivile to set
		 */
		public void setComuneAttoNascitaTrascrittoAttoUnioneCivile(String comuneAttoNascitaTrascrittoAttoUnioneCivile) {
			this.comuneAttoNascitaTrascrittoAttoUnioneCivile = comuneAttoNascitaTrascrittoAttoUnioneCivile;
		}

		/**
		 * @return the cognomeUnitoAttoUnioneCivile
		 */
		public String getCognomeUnitoAttoUnioneCivile() {
			return cognomeUnitoAttoUnioneCivile;
		}

		/**
		 * @param cognomeUnitoAttoUnioneCivile the cognomeUnitoAttoUnioneCivile to set
		 */
		public void setCognomeUnitoAttoUnioneCivile(String cognomeUnitoAttoUnioneCivile) {
			this.cognomeUnitoAttoUnioneCivile = cognomeUnitoAttoUnioneCivile;
		}

		/**
		 * @return the nomeUnitoAttoUnioneCivile
		 */
		public String getNomeUnitoAttoUnioneCivile() {
			return nomeUnitoAttoUnioneCivile;
		}

		/**
		 * @param nomeUnitoAttoUnioneCivile the nomeUnitoAttoUnioneCivile to set
		 */
		public void setNomeUnitoAttoUnioneCivile(String nomeUnitoAttoUnioneCivile) {
			this.nomeUnitoAttoUnioneCivile = nomeUnitoAttoUnioneCivile;
		}

		/**
		 * @return the etaUnitoAttoUnioneCivile
		 */
		public String getEtaUnitoAttoUnioneCivile() {
			return etaUnitoAttoUnioneCivile;
		}

		/**
		 * @param etaUnitoAttoUnioneCivile the etaUnitoAttoUnioneCivile to set
		 */
		public void setEtaUnitoAttoUnioneCivile(String etaUnitoAttoUnioneCivile) {
			this.etaUnitoAttoUnioneCivile = etaUnitoAttoUnioneCivile;
		}

		/**
		 * @return the comuneNascitaUnitoAttoUnioneCivile
		 */
		public String getComuneNascitaUnitoAttoUnioneCivile() {
			return comuneNascitaUnitoAttoUnioneCivile;
		}

		/**
		 * @param comuneNascitaUnitoAttoUnioneCivile the comuneNascitaUnitoAttoUnioneCivile to set
		 */
		public void setComuneNascitaUnitoAttoUnioneCivile(String comuneNascitaUnitoAttoUnioneCivile) {
			this.comuneNascitaUnitoAttoUnioneCivile = comuneNascitaUnitoAttoUnioneCivile;
		}

		/**
		 * @return the comuneResidenzaUnitoAttoUnioneCivile
		 */
		public String getComuneResidenzaUnitoAttoUnioneCivile() {
			return comuneResidenzaUnitoAttoUnioneCivile;
		}

		/**
		 * @param comuneResidenzaUnitoAttoUnioneCivile the comuneResidenzaUnitoAttoUnioneCivile to
		 *        set
		 */
		public void setComuneResidenzaUnitoAttoUnioneCivile(String comuneResidenzaUnitoAttoUnioneCivile) {
			this.comuneResidenzaUnitoAttoUnioneCivile = comuneResidenzaUnitoAttoUnioneCivile;
		}

		/**
		 * @return the attoNascitaUnitoAttoUnioneCivile
		 */
		public String getAttoNascitaUnitoAttoUnioneCivile() {
			return attoNascitaUnitoAttoUnioneCivile;
		}

		/**
		 * @param attoNascitaUnitoAttoUnioneCivile the attoNascitaUnitoAttoUnioneCivile to set
		 */
		public void setAttoNascitaUnitoAttoUnioneCivile(String attoNascitaUnitoAttoUnioneCivile) {
			this.attoNascitaUnitoAttoUnioneCivile = attoNascitaUnitoAttoUnioneCivile;
		}

		/**
		 * @return the comuneAttoNascitaUnitoAttoUnioneCivile
		 */
		public String getComuneAttoNascitaUnitoAttoUnioneCivile() {
			return comuneAttoNascitaUnitoAttoUnioneCivile;
		}

		/**
		 * @param comuneAttoNascitaUnitoAttoUnioneCivile the comuneAttoNascitaUnitoAttoUnioneCivile
		 *        to set
		 */
		public void setComuneAttoNascitaUnitoAttoUnioneCivile(String comuneAttoNascitaUnitoAttoUnioneCivile) {
			this.comuneAttoNascitaUnitoAttoUnioneCivile = comuneAttoNascitaUnitoAttoUnioneCivile;
		}

		/**
		 * @return the attoNascitaTrascrittoUnitoAttoUnioneCivile
		 */
		public String getAttoNascitaTrascrittoUnitoAttoUnioneCivile() {
			return attoNascitaTrascrittoUnitoAttoUnioneCivile;
		}

		/**
		 * @param attoNascitaTrascrittoUnitoAttoUnioneCivile the
		 *        attoNascitaTrascrittoUnitoAttoUnioneCivile to set
		 */
		public void setAttoNascitaTrascrittoUnitoAttoUnioneCivile(String attoNascitaTrascrittoUnitoAttoUnioneCivile) {
			this.attoNascitaTrascrittoUnitoAttoUnioneCivile = attoNascitaTrascrittoUnitoAttoUnioneCivile;
		}

		/**
		 * @return the comuneAttoNascitaTrascrittoUnitoAttoUnioneCivile
		 */
		public String getComuneAttoNascitaTrascrittoUnitoAttoUnioneCivile() {
			return comuneAttoNascitaTrascrittoUnitoAttoUnioneCivile;
		}

		/**
		 * @param comuneAttoNascitaTrascrittoUnitoAttoUnioneCivile the
		 *        comuneAttoNascitaTrascrittoUnitoAttoUnioneCivile to set
		 */
		public void setComuneAttoNascitaTrascrittoUnitoAttoUnioneCivile(String comuneAttoNascitaTrascrittoUnitoAttoUnioneCivile) {
			this.comuneAttoNascitaTrascrittoUnitoAttoUnioneCivile = comuneAttoNascitaTrascrittoUnitoAttoUnioneCivile;
		}

		/**
		 * @return the cognomeTestimone1AttoUnioneCivile
		 */
		public String getCognomeTestimone1AttoUnioneCivile() {
			return cognomeTestimone1AttoUnioneCivile;
		}

		/**
		 * @param cognomeTestimone1AttoUnioneCivile the cognomeTestimone1AttoUnioneCivile to set
		 */
		public void setCognomeTestimone1AttoUnioneCivile(String cognomeTestimone1AttoUnioneCivile) {
			this.cognomeTestimone1AttoUnioneCivile = cognomeTestimone1AttoUnioneCivile;
		}

		/**
		 * @return the nomeTestimone1AttoUnioneCivile
		 */
		public String getNomeTestimone1AttoUnioneCivile() {
			return nomeTestimone1AttoUnioneCivile;
		}

		/**
		 * @param nomeTestimone1AttoUnioneCivile the nomeTestimone1AttoUnioneCivile to set
		 */
		public void setNomeTestimone1AttoUnioneCivile(String nomeTestimone1AttoUnioneCivile) {
			this.nomeTestimone1AttoUnioneCivile = nomeTestimone1AttoUnioneCivile;
		}

		/**
		 * @return the dataNascitaTestimone1AttoUnioneCivile
		 */
		public Date getDataNascitaTestimone1AttoUnioneCivile() {
			return dataNascitaTestimone1AttoUnioneCivile;
		}

		/**
		 * @param dataNascitaTestimone1AttoUnioneCivile the dataNascitaTestimone1AttoUnioneCivile to
		 *        set
		 */
		public void setDataNascitaTestimone1AttoUnioneCivile(Date dataNascitaTestimone1AttoUnioneCivile) {
			this.dataNascitaTestimone1AttoUnioneCivile = dataNascitaTestimone1AttoUnioneCivile;
		}

		/**
		 * @return the comuneNascitaTestimone1AttoUnioneCivile
		 */
		public String getComuneNascitaTestimone1AttoUnioneCivile() {
			return comuneNascitaTestimone1AttoUnioneCivile;
		}

		/**
		 * @param comuneNascitaTestimone1AttoUnioneCivile the
		 *        comuneNascitaTestimone1AttoUnioneCivile to set
		 */
		public void setComuneNascitaTestimone1AttoUnioneCivile(String comuneNascitaTestimone1AttoUnioneCivile) {
			this.comuneNascitaTestimone1AttoUnioneCivile = comuneNascitaTestimone1AttoUnioneCivile;
		}

		/**
		 * @return the provinciaNascitaTestimone1AttoUnioneCivile
		 */
		public String getProvinciaNascitaTestimone1AttoUnioneCivile() {
			return provinciaNascitaTestimone1AttoUnioneCivile;
		}

		/**
		 * @param provinciaNascitaTestimone1AttoUnioneCivile the
		 *        provinciaNascitaTestimone1AttoUnioneCivile to set
		 */
		public void setProvinciaNascitaTestimone1AttoUnioneCivile(String provinciaNascitaTestimone1AttoUnioneCivile) {
			this.provinciaNascitaTestimone1AttoUnioneCivile = provinciaNascitaTestimone1AttoUnioneCivile;
		}

		/**
		 * @return the provinciaResidenzaTestimone1AttoUnioneCivile
		 */
		public String getProvinciaResidenzaTestimone1AttoUnioneCivile() {
			return provinciaResidenzaTestimone1AttoUnioneCivile;
		}

		/**
		 * @param provinciaResidenzaTestimone1AttoUnioneCivile the
		 *        provinciaResidenzaTestimone1AttoUnioneCivile to set
		 */
		public void setProvinciaResidenzaTestimone1AttoUnioneCivile(String provinciaResidenzaTestimone1AttoUnioneCivile) {
			this.provinciaResidenzaTestimone1AttoUnioneCivile = provinciaResidenzaTestimone1AttoUnioneCivile;
		}

		/**
		 * @return the statoEsteroNascitaTestimone1AttoUnioneCivile
		 */
		public String getStatoEsteroNascitaTestimone1AttoUnioneCivile() {
			return statoEsteroNascitaTestimone1AttoUnioneCivile;
		}

		/**
		 * @param statoEsteroNascitaTestimone1AttoUnioneCivile the
		 *        statoEsteroNascitaTestimone1AttoUnioneCivile to set
		 */
		public void setStatoEsteroNascitaTestimone1AttoUnioneCivile(String statoEsteroNascitaTestimone1AttoUnioneCivile) {
			this.statoEsteroNascitaTestimone1AttoUnioneCivile = statoEsteroNascitaTestimone1AttoUnioneCivile;
		}

		/**
		 * @return the cittadinanzaTestimone1AttoUnioneCivile
		 */
		public String getCittadinanzaTestimone1AttoUnioneCivile() {
			return cittadinanzaTestimone1AttoUnioneCivile;
		}

		/**
		 * @param cittadinanzaTestimone1AttoUnioneCivile the cittadinanzaTestimone1AttoUnioneCivile
		 *        to set
		 */
		public void setCittadinanzaTestimone1AttoUnioneCivile(String cittadinanzaTestimone1AttoUnioneCivile) {
			this.cittadinanzaTestimone1AttoUnioneCivile = cittadinanzaTestimone1AttoUnioneCivile;
		}

		/**
		 * @return the cognomeTestimone2AttoUnioneCivile
		 */
		public String getCognomeTestimone2AttoUnioneCivile() {
			return cognomeTestimone2AttoUnioneCivile;
		}

		/**
		 * @param cognomeTestimone2AttoUnioneCivile the cognomeTestimone2AttoUnioneCivile to set
		 */
		public void setCognomeTestimone2AttoUnioneCivile(String cognomeTestimone2AttoUnioneCivile) {
			this.cognomeTestimone2AttoUnioneCivile = cognomeTestimone2AttoUnioneCivile;
		}

		/**
		 * @return the nomeTestimone2AttoUnioneCivile
		 */
		public String getNomeTestimone2AttoUnioneCivile() {
			return nomeTestimone2AttoUnioneCivile;
		}

		/**
		 * @param nomeTestimone2AttoUnioneCivile the nomeTestimone2AttoUnioneCivile to set
		 */
		public void setNomeTestimone2AttoUnioneCivile(String nomeTestimone2AttoUnioneCivile) {
			this.nomeTestimone2AttoUnioneCivile = nomeTestimone2AttoUnioneCivile;
		}

		/**
		 * @return the dataNascitaTestimone2AttoUnioneCivile
		 */
		public Date getDataNascitaTestimone2AttoUnioneCivile() {
			return dataNascitaTestimone2AttoUnioneCivile;
		}

		/**
		 * @param dataNascitaTestimone2AttoUnioneCivile the dataNascitaTestimone2AttoUnioneCivile to
		 *        set
		 */
		public void setDataNascitaTestimone2AttoUnioneCivile(Date dataNascitaTestimone2AttoUnioneCivile) {
			this.dataNascitaTestimone2AttoUnioneCivile = dataNascitaTestimone2AttoUnioneCivile;
		}

		/**
		 * @return the comuneNascitaTestimone2AttoUnioneCivile
		 */
		public String getComuneNascitaTestimone2AttoUnioneCivile() {
			return comuneNascitaTestimone2AttoUnioneCivile;
		}

		/**
		 * @param comuneNascitaTestimone2AttoUnioneCivile the
		 *        comuneNascitaTestimone2AttoUnioneCivile to set
		 */
		public void setComuneNascitaTestimone2AttoUnioneCivile(String comuneNascitaTestimone2AttoUnioneCivile) {
			this.comuneNascitaTestimone2AttoUnioneCivile = comuneNascitaTestimone2AttoUnioneCivile;
		}

		/**
		 * @return the provinciaNascitaTestimone2AttoUnioneCivile
		 */
		public String getProvinciaNascitaTestimone2AttoUnioneCivile() {
			return provinciaNascitaTestimone2AttoUnioneCivile;
		}

		/**
		 * @param provinciaNascitaTestimone2AttoUnioneCivile the
		 *        provinciaNascitaTestimone2AttoUnioneCivile to set
		 */
		public void setProvinciaNascitaTestimone2AttoUnioneCivile(String provinciaNascitaTestimone2AttoUnioneCivile) {
			this.provinciaNascitaTestimone2AttoUnioneCivile = provinciaNascitaTestimone2AttoUnioneCivile;
		}

		/**
		 * @return the provinciaResidenzaTestimone2AttoUnioneCivile
		 */
		public String getProvinciaResidenzaTestimone2AttoUnioneCivile() {
			return provinciaResidenzaTestimone2AttoUnioneCivile;
		}

		/**
		 * @param provinciaResidenzaTestimone2AttoUnioneCivile the
		 *        provinciaResidenzaTestimone2AttoUnioneCivile to set
		 */
		public void setProvinciaResidenzaTestimone2AttoUnioneCivile(String provinciaResidenzaTestimone2AttoUnioneCivile) {
			this.provinciaResidenzaTestimone2AttoUnioneCivile = provinciaResidenzaTestimone2AttoUnioneCivile;
		}

		/**
		 * @return the statoEsteroNascitaTestimone2AttoUnioneCivile
		 */
		public String getStatoEsteroNascitaTestimone2AttoUnioneCivile() {
			return statoEsteroNascitaTestimone2AttoUnioneCivile;
		}

		/**
		 * @param statoEsteroNascitaTestimone2AttoUnioneCivile the
		 *        statoEsteroNascitaTestimone2AttoUnioneCivile to set
		 */
		public void setStatoEsteroNascitaTestimone2AttoUnioneCivile(String statoEsteroNascitaTestimone2AttoUnioneCivile) {
			this.statoEsteroNascitaTestimone2AttoUnioneCivile = statoEsteroNascitaTestimone2AttoUnioneCivile;
		}

		/**
		 * @return the cittadinanzaTestimone2AttoUnioneCivile
		 */
		public String getCittadinanzaTestimone2AttoUnioneCivile() {
			return cittadinanzaTestimone2AttoUnioneCivile;
		}

		/**
		 * @param cittadinanzaTestimone2AttoUnioneCivile the cittadinanzaTestimone2AttoUnioneCivile
		 *        to set
		 */
		public void setCittadinanzaTestimone2AttoUnioneCivile(String cittadinanzaTestimone2AttoUnioneCivile) {
			this.cittadinanzaTestimone2AttoUnioneCivile = cittadinanzaTestimone2AttoUnioneCivile;
		}

		/**
		 * @return the denominazioneUnitoAttoUnioneCivile
		 */
		public String getDenominazioneUnitoAttoUnioneCivile() {
			return denominazioneUnitoAttoUnioneCivile;
		}

		/**
		 * @param denominazioneUnitoAttoUnioneCivile the denominazioneUnitoAttoUnioneCivile to set
		 */
		public void setDenominazioneUnitoAttoUnioneCivile(String denominazioneUnitoAttoUnioneCivile) {
			this.denominazioneUnitoAttoUnioneCivile = denominazioneUnitoAttoUnioneCivile;
		}

		/**
		 * @return the comuneResidenzaTestimone1AttoUnioneCivile
		 */
		public String getComuneResidenzaTestimone1AttoUnioneCivile() {
			return comuneResidenzaTestimone1AttoUnioneCivile;
		}

		/**
		 * @param comuneResidenzaTestimone1AttoUnioneCivile the
		 *        comuneResidenzaTestimone1AttoUnioneCivile to set
		 */
		public void setComuneResidenzaTestimone1AttoUnioneCivile(String comuneResidenzaTestimone1AttoUnioneCivile) {
			this.comuneResidenzaTestimone1AttoUnioneCivile = comuneResidenzaTestimone1AttoUnioneCivile;
		}

		/**
		 * @return the comuneResidenzaTestimone2AttoUnioneCivile
		 */
		public String getComuneResidenzaTestimone2AttoUnioneCivile() {
			return comuneResidenzaTestimone2AttoUnioneCivile;
		}

		/**
		 * @param comuneResidenzaTestimone2AttoUnioneCivile the
		 *        comuneResidenzaTestimone2AttoUnioneCivile to set
		 */
		public void setComuneResidenzaTestimone2AttoUnioneCivile(String comuneResidenzaTestimone2AttoUnioneCivile) {
			this.comuneResidenzaTestimone2AttoUnioneCivile = comuneResidenzaTestimone2AttoUnioneCivile;
		}

		/**
		 * @return the statoEsteroResidenzaTestimone1AttoUnioneCivile
		 */
		public String getStatoEsteroResidenzaTestimone1AttoUnioneCivile() {
			return statoEsteroResidenzaTestimone1AttoUnioneCivile;
		}

		/**
		 * @param statoEsteroResidenzaTestimone1AttoUnioneCivile the
		 *        statoEsteroResidenzaTestimone1AttoUnioneCivile to set
		 */
		public void setStatoEsteroResidenzaTestimone1AttoUnioneCivile(String statoEsteroResidenzaTestimone1AttoUnioneCivile) {
			this.statoEsteroResidenzaTestimone1AttoUnioneCivile = statoEsteroResidenzaTestimone1AttoUnioneCivile;
		}

		/**
		 * @return the statoEsteroResidenzaTestimone2AttoUnioneCivile
		 */
		public String getStatoEsteroResidenzaTestimone2AttoUnioneCivile() {
			return statoEsteroResidenzaTestimone2AttoUnioneCivile;
		}

		/**
		 * @param statoEsteroResidenzaTestimone2AttoUnioneCivile the
		 *        statoEsteroResidenzaTestimone2AttoUnioneCivile to set
		 */
		public void setStatoEsteroResidenzaTestimone2AttoUnioneCivile(String statoEsteroResidenzaTestimone2AttoUnioneCivile) {
			this.statoEsteroResidenzaTestimone2AttoUnioneCivile = statoEsteroResidenzaTestimone2AttoUnioneCivile;
		}

		/**
		 * @return the dataNascitaUnitoAttoUnioneCivile
		 */
		public Date getDataNascitaUnitoAttoUnioneCivile() {
			return dataNascitaUnitoAttoUnioneCivile;
		}

		/**
		 * @param dataNascitaUnitoAttoUnioneCivile the dataNascitaUnitoAttoUnioneCivile to set
		 */
		public void setDataNascitaUnitoAttoUnioneCivile(Date dataNascitaUnitoAttoUnioneCivile) {
			this.dataNascitaUnitoAttoUnioneCivile = dataNascitaUnitoAttoUnioneCivile;
		}

		/**
		 * @return the dataNascitaAttoUnioneCivile
		 */
		public Date getDataNascitaAttoUnioneCivile() {
			return dataNascitaAttoUnioneCivile;
		}

		/**
		 * @param dataNascitaAttoUnioneCivile the dataNascitaAttoUnioneCivile to set
		 */
		public void setDataNascitaAttoUnioneCivile(Date dataNascitaAttoUnioneCivile) {
			this.dataNascitaAttoUnioneCivile = dataNascitaAttoUnioneCivile;
		}

		/**
		 * @return the cognomeNomeAttoMorte
		 */
		public String getCognomeNomeAttoMorte() {
			return cognomeNomeAttoMorte;
		}

		/**
		 * @param cognomeNomeAttoMorte the cognomeNomeAttoMorte to set
		 */
		public void setCognomeNomeAttoMorte(String cognomeNomeAttoMorte) {
			this.cognomeNomeAttoMorte = cognomeNomeAttoMorte;
		}

		/**
		 * @return the cognomeNomeAttoNascita
		 */
		public String getCognomeNomeAttoNascita() {
			return cognomeNomeAttoNascita;
		}

		/**
		 * @param cognomeNomeAttoNascita the cognomeNomeAttoNascita to set
		 */
		public void setCognomeNomeAttoNascita(String cognomeNomeAttoNascita) {
			this.cognomeNomeAttoNascita = cognomeNomeAttoNascita;
		}

		/**
		 * @return the comuneNascitaAttoMorte
		 */
		public String getComuneNascitaAttoMorte() {
			return comuneNascitaAttoMorte;
		}

		/**
		 * @param comuneNascitaAttoMorte the comuneNascitaAttoMorte to set
		 */
		public void setComuneNascitaAttoMorte(String comuneNascitaAttoMorte) {
			this.comuneNascitaAttoMorte = comuneNascitaAttoMorte;
		}

		/**
		 * @return the dataNascitaAttoMorte
		 */
		public Date getDataNascitaAttoMorte() {
			return dataNascitaAttoMorte;
		}

		/**
		 * @param dataNascitaAttoMorte the dataNascitaAttoMorte to set
		 */
		public void setDataNascitaAttoMorte(Date dataNascitaAttoMorte) {
			this.dataNascitaAttoMorte = dataNascitaAttoMorte;
		}

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
	 * @return the componentiNucleoFamiliare
	 */
	public List<DatiAnagrafici.ComponenteNucleoFamiliare> getComponentiNucleoFamiliare() {
		return componentiNucleoFamiliare;
	}

	/**
	 * @param componentiNucleoFamiliare the componentiNucleoFamiliare to set
	 */
	public void setComponentiNucleoFamiliare(List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleoFamiliare) {
		this.componentiNucleoFamiliare = componentiNucleoFamiliare;
	}

	/**
	 * @return the identificativoNucleoFamiliare
	 */
	public String getIdentificativoNucleoFamiliare() {
		return identificativoNucleoFamiliare;
	}

	/**
	 * @param identificativoNucleoFamiliare the identificativoNucleoFamiliare to set
	 */
	public void setIdentificativoNucleoFamiliare(String identificativoNucleoFamiliare) {
		this.identificativoNucleoFamiliare = identificativoNucleoFamiliare;
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
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the codiceVia
	 */
	public String getCodiceVia() {
		return codiceVia;
	}

	/**
	 * @param codiceVia the codiceVia to set
	 */
	public void setCodiceVia(String codiceVia) {
		this.codiceVia = codiceVia;
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
}
