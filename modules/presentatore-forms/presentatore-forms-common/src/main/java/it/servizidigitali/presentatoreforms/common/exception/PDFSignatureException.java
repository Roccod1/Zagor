package it.servizidigitali.presentatoreforms.common.exception;

/**
 * @author pindi
 *
 */
public class PDFSignatureException extends Exception {

	private static final long serialVersionUID = 1L;

	public PDFSignatureException() {
		super();
	}

	public PDFSignatureException(String message) {
		super(message);
	}

	public PDFSignatureException(String message, Throwable cause) {
		super(message, cause);
	}

	public PDFSignatureException(Throwable cause) {
		super(cause);
	}
}
