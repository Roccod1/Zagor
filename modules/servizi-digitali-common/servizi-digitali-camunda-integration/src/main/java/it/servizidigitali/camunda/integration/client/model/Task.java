package it.servizidigitali.camunda.integration.client.model;

import java.util.Date;
import java.util.List;

/**
 * @author pindi
 *
 */
public class Task {

	private String id;
	private String name;
	private String assignee;
	private String owner;
	private Date created;
	private Date due;
	private Date followUp;
	private String description;
	private String executionId;
	private String parentTaskId;
	private Integer priority;
	private String processDefinitionId;
	private String processInstanceId;
	private String caseExecutionId;
	private String caseDefinitionId;
	private String caseInstanceId;
	private String taskDefinitionKey;
	private Boolean suspended;
	private String formKey;
	private String tenantId;
	private List<String> candidateGroups;

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
	 * @return the assignee
	 */
	public String getAssignee() {
		return assignee;
	}

	/**
	 * @param assignee the assignee to set
	 */
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the due
	 */
	public Date getDue() {
		return due;
	}

	/**
	 * @param due the due to set
	 */
	public void setDue(Date due) {
		this.due = due;
	}

	/**
	 * @return the followUp
	 */
	public Date getFollowUp() {
		return followUp;
	}

	/**
	 * @param followUp the followUp to set
	 */
	public void setFollowUp(Date followUp) {
		this.followUp = followUp;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the parentTaskId
	 */
	public String getParentTaskId() {
		return parentTaskId;
	}

	/**
	 * @param parentTaskId the parentTaskId to set
	 */
	public void setParentTaskId(String parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	/**
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
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
	 * @return the caseDefinitionId
	 */
	public String getCaseDefinitionId() {
		return caseDefinitionId;
	}

	/**
	 * @param caseDefinitionId the caseDefinitionId to set
	 */
	public void setCaseDefinitionId(String caseDefinitionId) {
		this.caseDefinitionId = caseDefinitionId;
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
	 * @return the taskDefinitionKey
	 */
	public String getTaskDefinitionKey() {
		return taskDefinitionKey;
	}

	/**
	 * @param taskDefinitionKey the taskDefinitionKey to set
	 */
	public void setTaskDefinitionKey(String taskDefinitionKey) {
		this.taskDefinitionKey = taskDefinitionKey;
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
	 * @return the formKey
	 */
	public String getFormKey() {
		return formKey;
	}

	/**
	 * @param formKey the formKey to set
	 */
	public void setFormKey(String formKey) {
		this.formKey = formKey;
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
	 * @return the candidateGroups
	 */
	public List<String> getCandidateGroups() {
		return candidateGroups;
	}

	/**
	 * @param candidateGroups the candidateGroups to set
	 */
	public void setCandidateGroups(List<String> candidateGroups) {
		this.candidateGroups = candidateGroups;
	}
}
