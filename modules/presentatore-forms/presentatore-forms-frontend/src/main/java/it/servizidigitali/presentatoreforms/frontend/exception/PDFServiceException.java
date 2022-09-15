package it.servizidigitali.presentatoreforms.frontend.exception;

/**
 * @author pindi
 *
 */
public class PDFServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public PDFServiceException() {
		super();
	}

	public PDFServiceException(String message) {
		super(message);
	}

	public PDFServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PDFServiceException(Throwable cause) {
		super(cause);
	}
}
