package it.servizidigitali.presentatoreforms.common.model;

import java.util.Date;

import it.servizidigitali.backoffice.integration.enums.RelazioneParentela;
import it.servizidigitali.backoffice.integration.enums.TipoIntegrazione;

/**
 * @author pindi
 *
 */
public class ComponenteNucleoFamiliareModel {

	private String codiceFiscale;
	private String codiceFiscaleManuale;
	private String denominazione;
	private Date dataNascita;

	private RelazioneParentela relazioneParentela;

	private TipoIntegrazione tipoIntegrazione;

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
	 * @return the denominazione
	 */
	public String getDenominazione() {
		return denominazione;
	}

	/**
	 * @param denominazione the denominazione to set
	 */
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	/**
	 * @return the codiceFiscaleManuale
	 */
	public String getCodiceFiscaleManuale() {
		return codiceFiscaleManuale;
	}

	/**
	 * @param codiceFiscaleManuale the codiceFiscaleManuale to set
	 */
	public void setCodiceFiscaleManuale(String codiceFiscaleManuale) {
		this.codiceFiscaleManuale = codiceFiscaleManuale;
	}

	/**
	 * @return the tipoIntegrazione
	 */
	public TipoIntegrazione getTipoIntegrazione() {
		return tipoIntegrazione;
	}

	/**
	 * @param tipoIntegrazione the tipoIntegrazione to set
	 */
	public void setTipoIntegrazione(TipoIntegrazione tipoIntegrazione) {
		this.tipoIntegrazione = tipoIntegrazione;
	}
}
