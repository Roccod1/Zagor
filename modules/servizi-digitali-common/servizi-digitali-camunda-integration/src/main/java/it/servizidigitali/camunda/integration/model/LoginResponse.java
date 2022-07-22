package it.servizidigitali.camunda.integration.model;

import java.util.List;

/**
 * Sample JSON:
 * 
 * <pre>
 * {
 *    "userId": "OSAPULIEADMIN001",
 *    "authorizedApps": [
 *       "admin",
 *       "tasklist",
 *       "welcome",
 *       "cockpit"
 *    ]
 * }
 * </pre>
 *
 * @author pindi
 */
public class LoginResponse {

	private String userId;

	private List<String> authorizedApps;

	private String sessionId;

	public List<String> getAuthorizedApps() {
		return authorizedApps;
	}

	public void setAuthorizedApps(List<String> authorizedApps) {
		this.authorizedApps = authorizedApps;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginResponse [userId=" + userId + ", authorizedApps=" + authorizedApps + "]";
	}
}
