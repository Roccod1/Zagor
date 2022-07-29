package it.servizidigitali.file.utility.exception;

/**
 * @author pindi
 *
 */
public class FileConverterException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FileConverterException() {
		super();
	}

	public FileConverterException(String message) {
		super(message);
	}

	public FileConverterException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileConverterException(Throwable cause) {
		super(cause);
	}
}
