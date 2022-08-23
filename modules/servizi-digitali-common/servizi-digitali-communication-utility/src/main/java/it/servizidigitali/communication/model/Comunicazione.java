package it.servizidigitali.communication.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author pindi
 *
 */
public class Comunicazione implements Serializable {

	private static final long serialVersionUID = 7766060831972457158L;

	private String oggetto;
	private String testo;
	private List<Allegato> allegati;
	private List<Utente> utenti;
	private String disclaimer;
	private boolean invioMultiplo = true;

	private long companyId;
	private long groupId;

	public Comunicazione(String oggetto, String testo, List<Utente> utenti, List<Allegato> allegati, boolean invioMultiplo, String disclaimer) {
		this.oggetto = oggetto;
		this.testo = testo;
		this.allegati = allegati;
		this.utenti = utenti;
		this.disclaimer = disclaimer;
		this.invioMultiplo = invioMultiplo;
	}

	public Comunicazione(String oggetto, String testo, List<Utente> utenti, List<Allegato> allegati, boolean invioMultiplo, String disclaimer, long companyId, long groupId) {
		this.oggetto = oggetto;
		this.testo = testo;
		this.allegati = allegati;
		this.utenti = utenti;
		this.disclaimer = disclaimer;
		this.invioMultiplo = invioMultiplo;
		this.companyId = companyId;
		this.groupId = groupId;
	}

	/**
	 * @return the oggetto
	 */
	public String getOggetto() {
		return oggetto;
	}

	/**
	 * @param oggetto the oggetto to set
	 */
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	/**
	 * @return the testo
	 */
	public String getTesto() {
		return testo;
	}

	/**
	 * @param testo the testo to set
	 */
	public void setTesto(String testo) {
		this.testo = testo;
	}

	/**
	 * @return the allegati
	 */
	public List<Allegato> getAllegati() {
		return allegati;
	}

	/**
	 * @param allegati the allegati to set
	 */
	public void setAllegati(List<Allegato> allegati) {
		this.allegati = allegati;
	}

	/**
	 * @return the utenti
	 */
	public List<Utente> getUtenti() {
		return utenti;
	}

	/**
	 * @param utenti the utenti to set
	 */
	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	/**
	 * @return the disclaimer
	 */
	public String getDisclaimer() {
		return disclaimer;
	}

	/**
	 * @param disclaimer the disclaimer to set
	 */
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	/**
	 * @return the invioMultiplo
	 */
	public boolean isInvioMultiplo() {
		return invioMultiplo;
	}

	/**
	 * @param invioMultiplo the invioMultiplo to set
	 */
	public void setInvioMultiplo(boolean invioMultiplo) {
		this.invioMultiplo = invioMultiplo;
	}

	/**
	 * @return the companyId
	 */
	public long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the groupId
	 */
	public long getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

}