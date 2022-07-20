package it.servizidigitali.backoffice.integration.exception;

/**
 * @author pindi
 *
 */
public class BackofficeIntegrationClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BackofficeIntegrationClientException() {
		super();
	}

	public BackofficeIntegrationClientException(String message) {
		super(message);
	}

	public BackofficeIntegrationClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public BackofficeIntegrationClientException(Throwable cause) {
		super(cause);
	}
}
