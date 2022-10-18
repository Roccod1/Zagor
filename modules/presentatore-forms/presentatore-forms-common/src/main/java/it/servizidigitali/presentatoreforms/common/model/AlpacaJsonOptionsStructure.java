package it.servizidigitali.presentatoreforms.common.model;

import com.google.gson.JsonObject;

public class AlpacaJsonOptionsStructure {

	private String type;
	private JsonObject fields;

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
	 * @return the fields
	 */
	public JsonObject getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(JsonObject fields) {
		this.fields = fields;
	}

}
