package it.servizidigitali.file.utility.exception;

/**
 * @author pindi
 *
 */
public class SignatureVerificationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SignatureVerificationException() {
		super();
	}

	public SignatureVerificationException(String message) {
		super(message);
	}

	public SignatureVerificationException(String message, Throwable cause) {
		super(message, cause);
	}

	public SignatureVerificationException(Throwable cause) {
		super(cause);
	}
}
