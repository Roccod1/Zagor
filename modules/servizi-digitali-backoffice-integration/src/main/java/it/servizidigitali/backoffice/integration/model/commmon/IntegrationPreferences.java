package it.servizidigitali.backoffice.integration.model.commmon;

/**
 * @author pindi
 *
 */
public class IntegrationPreferences {

	private boolean usaCache = true;
	private String codiceServizio;

	/**
	 * @return the usaCache
	 */
	public boolean isUsaCache() {
		return usaCache;
	}

	/**
	 * @param usaCache the usaCache to set
	 */
	public void setUsaCache(boolean usaCache) {
		this.usaCache = usaCache;
	}

	/**
	 * @return the codiceServizio
	 */
	public String getCodiceServizio() {
		return codiceServizio;
	}

	/**
	 * @param codiceServizio the codiceServizio to set
	 */
	public void setCodiceServizio(String codiceServizio) {
		this.codiceServizio = codiceServizio;
	}

}
