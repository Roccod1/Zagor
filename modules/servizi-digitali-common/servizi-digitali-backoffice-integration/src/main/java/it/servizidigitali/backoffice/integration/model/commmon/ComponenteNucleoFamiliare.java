package it.servizidigitali.backoffice.integration.model.commmon;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pindi
 *
 */
public class ComponenteNucleoFamiliare implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codiceFiscale;
	private String cognome;
	private String nome;
	private String identificativoNucleo;
	private Date dataNascita;
	private String dataNascitaString;
	private String sesso;
	private String statoCivile;
	private String relazioneParentela;
	private boolean cittadinanzaItaliana;
	private String codiceIstatComuneNascita;
	private String nomeComuneNascita;
	private String codiceStatoEsteroNascita;
	private String nomeStatoEsteroNascita;
	private String nomeComuneNascitaFrontEnd;
	private String codiceIstatComuneResidenza;
	private String nomeComuneResidenza;
	private String indirizzoResidenza;
	private String indirizzoResidenzaCompletoFrontEnd;
	private String civicoResidenza;
	private String capResidenza;
	private String pianoResidenza;
	private String scalaResidenza;
	private String internoResidenza;
	private String codiceViaResidenza;
	private String telefono;
	private Date dataMorte;

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
	 * @return the identificativoNucleo
	 */
	public String getIdentificativoNucleo() {
		return identificativoNucleo;
	}

	/**
	 * @param identificativoNucleo the identificativoNucleo to set
	 */
	public void setIdentificativoNucleo(String identificativoNucleo) {
		this.identificativoNucleo = identificativoNucleo;
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
	 * @return the dataNascitaString
	 */
	public String getDataNascitaString() {
		return dataNascitaString;
	}

	/**
	 * @param dataNascitaString the dataNascitaString to set
	 */
	public void setDataNascitaString(String dataNascitaString) {
		this.dataNascitaString = dataNascitaString;
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
	public String getStatoCivile() {
		return statoCivile;
	}

	/**
	 * @param statoCivile the statoCivile to set
	 */
	public void setStatoCivile(String statoCivile) {
		this.statoCivile = statoCivile;
	}

	/**
	 * @return the relazioneParentela
	 */
	public String getRelazioneParentela() {
		return relazioneParentela;
	}

	/**
	 * @param relazioneParentela the relazioneParentela to set
	 */
	public void setRelazioneParentela(String relazioneParentela) {
		this.relazioneParentela = relazioneParentela;
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
	 * @return the nomeComuneNascita
	 */
	public String getNomeComuneNascita() {
		return nomeComuneNascita;
	}

	/**
	 * @param nomeComuneNascita the nomeComuneNascita to set
	 */
	public void setNomeComuneNascita(String nomeComuneNascita) {
		this.nomeComuneNascita = nomeComuneNascita;
	}

	/**
	 * @return the codiceStatoEsteroNascita
	 */
	public String getCodiceStatoEsteroNascita() {
		return codiceStatoEsteroNascita;
	}

	/**
	 * @param codiceStatoEsteroNascita the codiceStatoEsteroNascita to set
	 */
	public void setCodiceStatoEsteroNascita(String codiceStatoEsteroNascita) {
		this.codiceStatoEsteroNascita = codiceStatoEsteroNascita;
	}

	/**
	 * @return the nomeStatoEsteroNascita
	 */
	public String getNomeStatoEsteroNascita() {
		return nomeStatoEsteroNascita;
	}

	/**
	 * @param nomeStatoEsteroNascita the nomeStatoEsteroNascita to set
	 */
	public void setNomeStatoEsteroNascita(String nomeStatoEsteroNascita) {
		this.nomeStatoEsteroNascita = nomeStatoEsteroNascita;
	}

	/**
	 * @return the nomeComuneNascitaFrontEnd
	 */
	public String getNomeComuneNascitaFrontEnd() {
		return nomeComuneNascitaFrontEnd;
	}

	/**
	 * @param nomeComuneNascitaFrontEnd the nomeComuneNascitaFrontEnd to set
	 */
	public void setNomeComuneNascitaFrontEnd(String nomeComuneNascitaFrontEnd) {
		this.nomeComuneNascitaFrontEnd = nomeComuneNascitaFrontEnd;
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
	 * @return the nomeComuneResidenza
	 */
	public String getNomeComuneResidenza() {
		return nomeComuneResidenza;
	}

	/**
	 * @param nomeComuneResidenza the nomeComuneResidenza to set
	 */
	public void setNomeComuneResidenza(String nomeComuneResidenza) {
		this.nomeComuneResidenza = nomeComuneResidenza;
	}

	/**
	 * @return the indirizzoResidenza
	 */
	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}

	/**
	 * @param indirizzoResidenza the indirizzoResidenza to set
	 */
	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}

	/**
	 * @return the indirizzoResidenzaCompletoFrontEnd
	 */
	public String getIndirizzoResidenzaCompletoFrontEnd() {
		return indirizzoResidenzaCompletoFrontEnd;
	}

	/**
	 * @param indirizzoResidenzaCompletoFrontEnd the indirizzoResidenzaCompletoFrontEnd to set
	 */
	public void setIndirizzoResidenzaCompletoFrontEnd(String indirizzoResidenzaCompletoFrontEnd) {
		this.indirizzoResidenzaCompletoFrontEnd = indirizzoResidenzaCompletoFrontEnd;
	}

	/**
	 * @return the civicoResidenza
	 */
	public String getCivicoResidenza() {
		return civicoResidenza;
	}

	/**
	 * @param civicoResidenza the civicoResidenza to set
	 */
	public void setCivicoResidenza(String civicoResidenza) {
		this.civicoResidenza = civicoResidenza;
	}

	/**
	 * @return the capResidenza
	 */
	public String getCapResidenza() {
		return capResidenza;
	}

	/**
	 * @param capResidenza the capResidenza to set
	 */
	public void setCapResidenza(String capResidenza) {
		this.capResidenza = capResidenza;
	}

	/**
	 * @return the pianoResidenza
	 */
	public String getPianoResidenza() {
		return pianoResidenza;
	}

	/**
	 * @param pianoResidenza the pianoResidenza to set
	 */
	public void setPianoResidenza(String pianoResidenza) {
		this.pianoResidenza = pianoResidenza;
	}

	/**
	 * @return the scalaResidenza
	 */
	public String getScalaResidenza() {
		return scalaResidenza;
	}

	/**
	 * @param scalaResidenza the scalaResidenza to set
	 */
	public void setScalaResidenza(String scalaResidenza) {
		this.scalaResidenza = scalaResidenza;
	}

	/**
	 * @return the internoResidenza
	 */
	public String getInternoResidenza() {
		return internoResidenza;
	}

	/**
	 * @param internoResidenza the internoResidenza to set
	 */
	public void setInternoResidenza(String internoResidenza) {
		this.internoResidenza = internoResidenza;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return the codiceViaResidenza
	 */
	public String getCodiceViaResidenza() {
		return codiceViaResidenza;
	}

	/**
	 * @param codiceViaResidenza the codiceViaResidenza to set
	 */
	public void setCodiceViaResidenza(String codiceViaResidenza) {
		this.codiceViaResidenza = codiceViaResidenza;
	}

}
