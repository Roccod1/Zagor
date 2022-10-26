package it.servizidigitali.gestionepagamenti.integration.common.client.exception;

/**
 * @author pindi
 *
 */
public class PagamentiClientException extends Exception {

	private static final long serialVersionUID = -4911753532268335395L;

	private String faultCode;
	private String faultString;

	public PagamentiClientException(String message) {
		super(message);
	}

	public PagamentiClientException(Throwable cause) {
		super(cause);
	}

	public PagamentiClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public PagamentiClientException(String faultCode, String faultString) {
		super("Il server ha risposto con codice errore '" + faultCode + "', messaggio errore '" + faultString + "'");
		this.faultCode = faultCode;
		this.faultString = faultString;
	}

	/**
	 * @return the faultCode
	 */
	public String getFaultCode() {
		return faultCode;
	}

	/**
	 * @return the faultString
	 */
	public String getFaultString() {
		return faultString;
	}

}
