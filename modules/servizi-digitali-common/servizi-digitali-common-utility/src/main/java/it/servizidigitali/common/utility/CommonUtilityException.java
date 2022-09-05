package it.servizidigitali.common.utility;

/**
 * @author pindi
 *
 */
public class CommonUtilityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CommonUtilityException() {
		super();
	}

	public CommonUtilityException(String message) {
		super(message);
	}

	public CommonUtilityException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommonUtilityException(Throwable cause) {
		super(cause);
	}

}
