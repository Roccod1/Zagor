package it.servizidigitali.communication.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Gianluca Pindinelli
 *
 */
public class Utente implements Serializable {

	private static final long serialVersionUID = -496801821538965723L;
	private String cognome;
	private String nome;
	private String codiceFiscale;
	private String mail;
	private String mailPec;
	private boolean autenticazioneForte;
	private Integer livelloAutenticazione;
	private Date dataAutenticazioneForte;
	private String canaleAutenticazione;
	private String infoAggiuntive;
	private Map<String, List<CanaleComunicazione>> canaliComunicazioniByComuneMap;
	private List<Gruppo> gruppi;
	private boolean attivo;

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
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the mailPec
	 */
	public String getMailPec() {
		return mailPec;
	}

	/**
	 * @param mailPec the mailPec to set
	 */
	public void setMailPec(String mailPec) {
		this.mailPec = mailPec;
	}

	/**
	 * @return the autenticazioneForte
	 */
	public boolean isAutenticazioneForte() {
		return autenticazioneForte;
	}

	/**
	 * @param autenticazioneForte the autenticazioneForte to set
	 */
	public void setAutenticazioneForte(boolean autenticazioneForte) {
		this.autenticazioneForte = autenticazioneForte;
	}

	/**
	 * @return the livelloAutenticazione
	 */
	public Integer getLivelloAutenticazione() {
		return livelloAutenticazione;
	}

	/**
	 * @param livelloAutenticazione the livelloAutenticazione to set
	 */
	public void setLivelloAutenticazione(Integer livelloAutenticazione) {
		this.livelloAutenticazione = livelloAutenticazione;
	}

	/**
	 * @return the dataAutenticazioneForte
	 */
	public Date getDataAutenticazioneForte() {
		return dataAutenticazioneForte;
	}

	/**
	 * @param dataAutenticazioneForte the dataAutenticazioneForte to set
	 */
	public void setDataAutenticazioneForte(Date dataAutenticazioneForte) {
		this.dataAutenticazioneForte = dataAutenticazioneForte;
	}

	/**
	 * @return the canaleAutenticazione
	 */
	public String getCanaleAutenticazione() {
		return canaleAutenticazione;
	}

	/**
	 * @param canaleAutenticazione the canaleAutenticazione to set
	 */
	public void setCanaleAutenticazione(String canaleAutenticazione) {
		this.canaleAutenticazione = canaleAutenticazione;
	}

	/**
	 * @return the infoAggiuntive
	 */
	public String getInfoAggiuntive() {
		return infoAggiuntive;
	}

	/**
	 * @param infoAggiuntive the infoAggiuntive to set
	 */
	public void setInfoAggiuntive(String infoAggiuntive) {
		this.infoAggiuntive = infoAggiuntive;
	}

	/**
	 * @return the canaliComunicazioniByComuneMap
	 */
	public Map<String, List<CanaleComunicazione>> getCanaliComunicazioniByComuneMap() {
		return canaliComunicazioniByComuneMap;
	}

	/**
	 * @param canaliComunicazioniByComuneMap the canaliComunicazioniByComuneMap to set
	 */
	public void setCanaliComunicazioniByComuneMap(Map<String, List<CanaleComunicazione>> canaliComunicazioniByComuneMap) {
		this.canaliComunicazioniByComuneMap = canaliComunicazioniByComuneMap;
	}

	/**
	 * @return the attivo
	 */
	public boolean isAttivo() {
		return attivo;
	}

	/**
	 * @param attivo the attivo to set
	 */
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	/**
	 * @return the gruppi
	 */
	public List<Gruppo> getGruppi() {
		return gruppi;
	}

	/**
	 * @param gruppi the gruppi to set
	 */
	public void setGruppi(List<Gruppo> gruppi) {
		this.gruppi = gruppi;
	}

}
