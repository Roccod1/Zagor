package it.servizidigitali.presentatoreforms.common.service.integration.exception;

/**
 * Eccezione di runtime per le chiamate ai servizi di backoffice comunali.
 *
 * @author pindi
 *
 */
public class BackofficeServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int conditionCode = 0;

	public BackofficeServiceException(String message, Throwable e) {
		super(message, e);
	}

	/**
	 * @param message
	 */
	public BackofficeServiceException(String message) {
		super(message);
	}

	public BackofficeServiceException(int conditionCode) {
		super();
		this.conditionCode = conditionCode;
	}

	public int getConditionCode() {
		return this.conditionCode;
	}
}
