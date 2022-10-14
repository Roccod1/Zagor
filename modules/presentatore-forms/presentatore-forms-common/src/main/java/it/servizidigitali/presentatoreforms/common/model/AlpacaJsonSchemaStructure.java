package it.servizidigitali.presentatoreforms.common.model;

import com.google.gson.JsonObject;

public class AlpacaJsonSchemaStructure {

	private String type;
	private JsonObject properties;
	private JsonObject dependencies;

	public AlpacaJsonSchemaStructure() {
		super();
	}

	public AlpacaJsonSchemaStructure(String type, JsonObject properties, JsonObject dependencies) {
		super();
		this.type = type;
		this.properties = properties;
		this.dependencies = dependencies;
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
	 * @return the properties
	 */
	public JsonObject getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(JsonObject properties) {
		this.properties = properties;
	}

	/**
	 * @return the dependencies
	 */
	public JsonObject getDependencies() {
		return dependencies;
	}

	/**
	 * @param dependencies the dependencies to set
	 */
	public void setDependencies(JsonObject dependencies) {
		this.dependencies = dependencies;
	}

}
