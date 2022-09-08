package it.servizidigitali.camunda.integration.client.model;

import java.util.Map;

/**
 * @author pindi
 *
 */
public class VariableInstance {

	private String id;
	private String name;
	private String processDefinitionId;
	private String processInstanceId;
	private String executionId;
	private String caseInstanceId;
	private String caseExecutionId;
	private String taskId;
	private String batchId;
	private String activityInstanceId;
	private String tenantId;
	private String errorMessage;
	private Object value;
	private String type;
	private Map<String, Object> valueInfo;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the processDefinitionId
	 */
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	/**
	 * @param processDefinitionId the processDefinitionId to set
	 */
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	/**
	 * @return the processInstanceId
	 */
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	/**
	 * @param processInstanceId the processInstanceId to set
	 */
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	/**
	 * @return the executionId
	 */
	public String getExecutionId() {
		return executionId;
	}

	/**
	 * @param executionId the executionId to set
	 */
	public void setExecutionId(String executionId) {
		this.executionId = executionId;
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
	 * @return the caseExecutionId
	 */
	public String getCaseExecutionId() {
		return caseExecutionId;
	}

	/**
	 * @param caseExecutionId the caseExecutionId to set
	 */
	public void setCaseExecutionId(String caseExecutionId) {
		this.caseExecutionId = caseExecutionId;
	}

	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the batchId
	 */
	public String getBatchId() {
		return batchId;
	}

	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	/**
	 * @return the activityInstanceId
	 */
	public String getActivityInstanceId() {
		return activityInstanceId;
	}

	/**
	 * @param activityInstanceId the activityInstanceId to set
	 */
	public void setActivityInstanceId(String activityInstanceId) {
		this.activityInstanceId = activityInstanceId;
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

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the valueInfo
	 */
	public Map<String, Object> getValueInfo() {
		return valueInfo;
	}

	/**
	 * @param valueInfo the valueInfo to set
	 */
	public void setValueInfo(Map<String, Object> valueInfo) {
		this.valueInfo = valueInfo;
	}
}
