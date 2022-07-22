package it.servizidigitali.camunda.integration.client;

import it.servizidigitali.camunda.integration.model.LoginResponse;

/**
 * @author pindi
 */
public class HttpCookieAuthorizationCredentials implements CamundaApiAccessCredentials {

	private final String jsessionId;
	private final LoginResponse loginResponse;

	public HttpCookieAuthorizationCredentials(String jsessionId, LoginResponse loginResponse) {
		super();
		this.jsessionId = jsessionId;
		this.loginResponse = loginResponse;
	}

	public String getJsessionId() {
		return jsessionId;
	}

	public LoginResponse getLoginResponse() {
		return loginResponse;
	}

	public boolean hasSession() {
		return getJsessionId() != null && !getJsessionId().isBlank();
	}
}
