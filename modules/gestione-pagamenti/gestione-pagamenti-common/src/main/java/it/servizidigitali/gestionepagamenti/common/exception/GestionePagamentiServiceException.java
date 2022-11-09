package it.servizidigitali.gestionepagamenti.common.exception;

/**
 * @author pindi
 *
 */
public class GestionePagamentiServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public GestionePagamentiServiceException() {
		super();
	}

	public GestionePagamentiServiceException(String message) {
		super(message);
	}

	public GestionePagamentiServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public GestionePagamentiServiceException(Throwable cause) {
		super(cause);
	}

}
