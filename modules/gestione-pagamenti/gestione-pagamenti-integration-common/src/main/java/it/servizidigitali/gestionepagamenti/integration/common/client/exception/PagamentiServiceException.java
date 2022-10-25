package it.servizidigitali.gestionepagamenti.integration.common.client.exception;

/**
 * @author pindi
 *
 */
public class PagamentiServiceException extends Exception {

	private static final long serialVersionUID = -4911753532268335395L;

	public PagamentiServiceException(String message) {
		super(message);
	}

	public PagamentiServiceException(Throwable cause) {
		super(cause);
	}

	public PagamentiServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
