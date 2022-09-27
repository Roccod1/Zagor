package it.servizidigitali.common.utility.enumeration;

/**
 * @author pindi
 *
 */
public enum OrganizationRole {

	REFERENTE("referente"), RESPONSABILE("responsabile"), ALTRO_RESPONSABILE("altro-responsabile");

	private String chiave;

	/**
	 *
	 */
	private OrganizationRole(String chiave) {
		this.chiave = chiave;
	}

	/**
	 * @return the chiave
	 */
	public String getChiave() {
		return chiave;
	}

}
