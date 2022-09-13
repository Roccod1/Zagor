package it.servizidigitali.camunda.integration.client.model;

/**
 * @author pindi
 *
 */
public class ProcessInstance {

	private String id;
	private String definitionId;
	private String businessKey;
	private String caseInstanceId;
	private Boolean ended;
	private Boolean suspended;
	private String tenantId;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the definitionId
	 */
	public String getDefinitionId() {
		return definitionId;
	}

	/**
	 * @param definitionId the definitionId to set
	 */
	public void setDefinitionId(String definitionId) {
		this.definitionId = definitionId;
	}

	/**
	 * @return the businessKey
	 */
	public String getBusinessKey() {
		return businessKey;
	}

	/**
	 * @param businessKey the businessKey to set
	 */
	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	/**
	 * @return the caseInstanceId
	 */
	public String getCaseInstanceId() {
		return caseInstanceId;
	}

	/**
	 * @param caseInstanceId the caseInstanceId to set
	 */
	public void setCaseInstanceId(String caseInstanceId) {
		this.caseInstanceId = caseInstanceId;
	}

	/**
	 * @return the ended
	 */
	public Boolean getEnded() {
		return ended;
	}

	/**
	 * @param ended the ended to set
	 */
	public void setEnded(Boolean ended) {
		this.ended = ended;
	}

	/**
	 * @return the suspended
	 */
	public Boolean getSuspended() {
		return suspended;
	}

	/**
	 * @param suspended the suspended to set
	 */
	public void setSuspended(Boolean suspended) {
		this.suspended = suspended;
	}

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
