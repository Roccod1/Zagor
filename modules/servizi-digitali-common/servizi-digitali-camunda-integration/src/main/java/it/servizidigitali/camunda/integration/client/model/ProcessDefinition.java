package it.servizidigitali.camunda.integration.client.model;

/**
 * @author pindi
 *
 */
public class ProcessDefinition {

	private String id;
	private String key;
	private String category;
	private String description;
	private String name;
	private Integer version;
	private String resource;
	private String deploymentId;
	private String diagram;
	private Boolean suspended;
	private String tenantId;
	private String versionTag;
	private Integer historyTimeToLive;
	private Boolean startableInTasklist;

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
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
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
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the resource
	 */
	public String getResource() {
		return resource;
	}

	/**
	 * @param resource the resource to set
	 */
	public void setResource(String resource) {
		this.resource = resource;
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
	 * @return the diagram
	 */
	public String getDiagram() {
		return diagram;
	}

	/**
	 * @param diagram the diagram to set
	 */
	public void setDiagram(String diagram) {
		this.diagram = diagram;
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

	/**
	 * @return the versionTag
	 */
	public String getVersionTag() {
		return versionTag;
	}

	/**
	 * @param versionTag the versionTag to set
	 */
	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}

	/**
	 * @return the historyTimeToLive
	 */
	public Integer getHistoryTimeToLive() {
		return historyTimeToLive;
	}

	/**
	 * @param historyTimeToLive the historyTimeToLive to set
	 */
	public void setHistoryTimeToLive(Integer historyTimeToLive) {
		this.historyTimeToLive = historyTimeToLive;
	}

	/**
	 * @return the startableInTasklist
	 */
	public Boolean getStartableInTasklist() {
		return startableInTasklist;
	}

	/**
	 * @param startableInTasklist the startableInTasklist to set
	 */
	public void setStartableInTasklist(Boolean startableInTasklist) {
		this.startableInTasklist = startableInTasklist;
	}

}
