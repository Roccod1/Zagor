package it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.model;

import com.google.gson.JsonObject;

import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonOptionsStructure;

/**
 * @author pindi
 * @param <T>
 *
 */
public class EnrichmentModel<T> {

	private AlpacaJsonOptionsStructure alpacaJsonOptionsStructure;
	private JsonObject alpacaJsonData;
	private T sourceObject;
	private UserPreferences userPreferences;
	private Long organizationId;
	private Long servizioId;

	/**
	 *
	 */
	public EnrichmentModel(T sourceObject) {
		this.sourceObject = sourceObject;
	}

	/**
	 *
	 */
	public EnrichmentModel(AlpacaJsonOptionsStructure alpacaJsonOptionsStructure, JsonObject alpacaJsonData, T sourceObject, Long organizationId, Long servizioId, UserPreferences userPreferences) {
		this.alpacaJsonOptionsStructure = alpacaJsonOptionsStructure;
		this.alpacaJsonData = alpacaJsonData;
		this.sourceObject = sourceObject;
		this.organizationId = organizationId;
		this.servizioId = servizioId;
		this.userPreferences = userPreferences;
	}

	/**
	 * @return the alpacaJsonOptionsStructure
	 */
	public AlpacaJsonOptionsStructure getAlpacaJsonOptionsStructure() {
		return alpacaJsonOptionsStructure;
	}

	/**
	 * @param alpacaJsonOptionsStructure the alpacaJsonOptionsStructure to set
	 */
	public void setAlpacaJsonOptionsStructure(AlpacaJsonOptionsStructure alpacaJsonOptionsStructure) {
		this.alpacaJsonOptionsStructure = alpacaJsonOptionsStructure;
	}

	/**
	 * @return the alpacaJsonData
	 */
	public JsonObject getAlpacaJsonData() {
		return alpacaJsonData;
	}

	/**
	 * @param alpacaJsonData the alpacaJsonData to set
	 */
	public void setAlpacaJsonData(JsonObject alpacaJsonData) {
		this.alpacaJsonData = alpacaJsonData;
	}

	/**
	 * @return the sourceObject
	 */
	public T getSourceObject() {
		return sourceObject;
	}

	/**
	 * @param sourceObject the sourceObject to set
	 */
	public void setSourceObject(T sourceObject) {
		this.sourceObject = sourceObject;
	}

	/**
	 * @return the organizationId
	 */
	public Long getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @return the servizioId
	 */
	public Long getServizioId() {
		return servizioId;
	}

	/**
	 * @param servizioId the servizioId to set
	 */
	public void setServizioId(Long servizioId) {
		this.servizioId = servizioId;
	}

	/**
	 * @return the userPreferences
	 */
	public UserPreferences getUserPreferences() {
		return userPreferences;
	}

	/**
	 * @param userPreferences the userPreferences to set
	 */
	public void setUserPreferences(UserPreferences userPreferences) {
		this.userPreferences = userPreferences;
	}

}
