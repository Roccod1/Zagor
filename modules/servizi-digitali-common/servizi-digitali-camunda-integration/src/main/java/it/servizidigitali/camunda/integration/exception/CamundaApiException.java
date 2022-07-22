package it.servizidigitali.camunda.integration.exception;

/**
 * @author pindi
 *
 */
public class CamundaApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CamundaApiException() {
		super();
	}

	public CamundaApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public CamundaApiException(String message) {
		super(message);
	}

}
