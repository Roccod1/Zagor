package it.servizidigitali.restservice.jwt.utility.exception;

public class JwtException extends Exception {

	private static final long serialVersionUID = -6250988879373767101L;

	private String code;
	private String description;
	
	public JwtException(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
