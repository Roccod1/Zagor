package it.servizidigitali.camunda.integration.client.exception;

/**
 * @author pindi
 *
 */
public class CamundaClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CamundaClientException() {
		super();
	}

	public CamundaClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public CamundaClientException(String message) {
		super(message);
	}

}
