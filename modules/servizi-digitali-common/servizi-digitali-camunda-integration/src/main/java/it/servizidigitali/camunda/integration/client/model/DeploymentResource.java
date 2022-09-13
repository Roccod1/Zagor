package it.servizidigitali.camunda.integration.client.model;

/**
 * @author pindi
 *
 */
public class DeploymentResource {

	private String id;
	private String name;
	private String deploymentId;
	private ProcessDefinition processDefinition;

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
	 * @return the deploymentId
	 */
	public String getDeploymentId() {
		return deploymentId;
	}

	/**
	 * @param deploymentId the deploymentId to set
	 */
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	/**
	 * @return the processDefinition
	 */
	public ProcessDefinition getProcessDefinition() {
		return processDefinition;
	}

	/**
	 * @param processDefinition the processDefinition to set
	 */
	public void setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}
}
