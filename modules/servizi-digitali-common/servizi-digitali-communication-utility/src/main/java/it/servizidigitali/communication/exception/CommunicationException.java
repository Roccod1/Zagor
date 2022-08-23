package it.servizidigitali.communication.exception;

/**
 * @author Gianluca Pindinelli
 *
 */
public class CommunicationException extends Exception {

	private static final long serialVersionUID = 1L;

	public CommunicationException() {
		super();
	}

	public CommunicationException(String message) {
		super(message);
	}

	public CommunicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommunicationException(Throwable cause) {
		super(cause);
	}
}
