package it.servizidigitali.common.utility.enumeration;

/**
 * @author pindi
 *
 */
public enum OrganizationCustomAttributes {

	ANPR("anpr"), CANALE_INTEGRAZIONE("canaleIntegrazione"), CODICE_IPA("codiceIPA"), CODICE_ISTAT("codiceISTAT"), EMAIL("email"), PEC("pec"), TIPO_INTEGRAZIONE("tipoIntegrazione"), URI_BACKOFFICE(
			"uriBackoffice");

	private String nomeAttributo;

	/**
	 *
	 */
	private OrganizationCustomAttributes(String nomeAttributo) {
		this.nomeAttributo = nomeAttributo;
	}

	/**
	 * @return the nomeAttributo
	 */
	public String getNomeAttributo() {
		return nomeAttributo;
	}
}
