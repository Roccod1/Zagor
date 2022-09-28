package it.servizidigitali.restservice.internal.jaxrs.exception;

public class UnauthorizedException extends Exception {

	private static final long serialVersionUID = 4247188094914388284L;

	public UnauthorizedException() {
		super();
	}

	public UnauthorizedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnauthorizedException(String message) {
		super(message);
	}

	public UnauthorizedException(Throwable cause) {
		super(cause);
	}
	
}
