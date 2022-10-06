package it.servizidigitali.common.utility.enumeration;

/**
 * @author pindi
 *
 */
public enum FriendlyUrl {

	SCHEDA_SERVIZIO("scheda-servizio");

	private String mapping;

	/**
	 *
	 */
	private FriendlyUrl(String mapping) {
		this.mapping = mapping;
	}

	/**
	 * @return the mapping
	 */
	public String getMapping() {
		return mapping;
	}

}
