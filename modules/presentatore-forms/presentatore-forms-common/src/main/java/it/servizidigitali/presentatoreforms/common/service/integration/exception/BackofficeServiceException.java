package it.servizidigitali.presentatoreforms.common.service.integration.exception;

import it.servizidigitali.presentatoreforms.common.service.integration.enumeration.BackofficeServiceExceptionLanguageCode;

/**
 * Eccezione di runtime per le chiamate ai servizi di backoffice comunali.
 *
 * @author pindi
 *
 */
public class BackofficeServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private BackofficeServiceExceptionLanguageCode backofficeServiceExceptionLanguageCode;

	public BackofficeServiceException(String message, Throwable e) {
		super(message, e);
	}

	/**
	 * @param message
	 */
	public BackofficeServiceException(String message) {
		super(message);
	}

	public BackofficeServiceException(BackofficeServiceExceptionLanguageCode backofficeServiceExceptionLanguageCode) {
		super();
		this.backofficeServiceExceptionLanguageCode = backofficeServiceExceptionLanguageCode;
	}

	/**
	 * @return the backofficeServiceExceptionLanguageCode
	 */
	public BackofficeServiceExceptionLanguageCode getBackofficeServiceExceptionLanguageCode() {
		return backofficeServiceExceptionLanguageCode;
	}

}
