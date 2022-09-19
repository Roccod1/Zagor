package it.servizidigitali.gestionepagamenti.common.client.model;

/**
 * @author pindi
 *
 */
public class PagamentoDovutoRisposta {

	private String redirectUrl;
	private String idSessione;

	/**
	 * @return the redirectUrl
	 */
	public String getRedirectUrl() {
		return redirectUrl;
	}

	/**
	 * @param redirectUrl the redirectUrl to set
	 */
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	/**
	 * @return the idSessione
	 */
	public String getIdSessione() {
		return idSessione;
	}

	/**
	 * @param idSessione the idSessione to set
	 */
	public void setIdSessione(String idSessione) {
		this.idSessione = idSessione;
	}

}
