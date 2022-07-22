package it.servizidigitali.camunda.integration.client;

/**
 * @author pindi
 */
public class HttpBasicAuthorizationCredentials implements CamundaApiAccessCredentials {

	private final String userName;

	private final String password;

	public HttpBasicAuthorizationCredentials(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
}
