package it.servizidigitali.communication.model.ce;

public class EmailAccount extends Account {

	private static final long serialVersionUID = 1L;

	private String auth;
	private Boolean starttls;
	private Boolean starttlsRequired;
	private String sslProtocols;

	/**
	 * @return the auth
	 */
	public String getAuth() {
		return auth;
	}

	/**
	 * @param auth the auth to set
	 */
	public void setAuth(String auth) {
		this.auth = auth;
	}

	/**
	 * @return the starttls
	 */
	public Boolean getStarttls() {
		return starttls;
	}

	/**
	 * @param starttls the starttls to set
	 */
	public void setStarttls(Boolean starttls) {
		this.starttls = starttls;
	}

	/**
	 * @return the starttlsRequired
	 */
	public Boolean getStarttlsRequired() {
		return starttlsRequired;
	}

	/**
	 * @param starttlsRequired the starttlsRequired to set
	 */
	public void setStarttlsRequired(Boolean starttlsRequired) {
		this.starttlsRequired = starttlsRequired;
	}

	/**
	 * @return the sslProtocols
	 */
	public String getSslProtocols() {
		return sslProtocols;
	}

	/**
	 * @param sslProtocols the sslProtocols to set
	 */
	public void setSslProtocols(String sslProtocols) {
		this.sslProtocols = sslProtocols;
	}
}
