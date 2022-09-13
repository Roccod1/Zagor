package it.servizidigitali.chatbot.frontend.model;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class ChatbotConfigurationModel implements Serializable {

	private static final long serialVersionUID = 6045605233544685612L;
	private boolean active;
	private String projectId;
	private String agentId;
	private String userId;
	private String welcomeTitle;
	private String welcomeMsg;
	private String widgetTitle;
	private String logoPath;
	private String launchJsPath;
	private String senderUrlImage;
	private String calloutTitle;
	private String calloutMsg;

	private LinkedHashMap<String, Object> customAttributes;
	private String customAttributesString;

	private boolean showPopup;
	private Integer popupIdleTimeout;

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the welcomeTitle
	 */
	public String getWelcomeTitle() {
		return welcomeTitle;
	}

	/**
	 * @param welcomeTitle the welcomeTitle to set
	 */
	public void setWelcomeTitle(String welcomeTitle) {
		this.welcomeTitle = welcomeTitle;
	}

	/**
	 * @return the welcomeMsg
	 */
	public String getWelcomeMsg() {
		return welcomeMsg;
	}

	/**
	 * @param welcomeMsg the welcomeMsg to set
	 */
	public void setWelcomeMsg(String welcomeMsg) {
		this.welcomeMsg = welcomeMsg;
	}

	/**
	 * @return the widgetTitle
	 */
	public String getWidgetTitle() {
		return widgetTitle;
	}

	/**
	 * @param widgetTitle the widgetTitle to set
	 */
	public void setWidgetTitle(String widgetTitle) {
		this.widgetTitle = widgetTitle;
	}

	/**
	 * @return the customAttributesString
	 */
	public String getCustomAttributesString() {
		return customAttributesString;
	}

	/**
	 * @param customAttributesString the customAttributesString to set
	 */
	public void setCustomAttributesString(String customAttributesString) {
		this.customAttributesString = customAttributesString;
	}

	/**
	 * @return the customAttributes
	 */
	public LinkedHashMap<String, Object> getCustomAttributes() {
		return customAttributes;
	}

	/**
	 * @param customAttributes the customAttributes to set
	 */
	public void setCustomAttributes(LinkedHashMap<String, Object> customAttributes) {
		this.customAttributes = customAttributes;
	}

	/**
	 * @return the logoPath
	 */
	public String getLogoPath() {
		return logoPath;
	}

	/**
	 * @param logoPath the logoPath to set
	 */
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	/**
	 * @return the launchJsPath
	 */
	public String getLaunchJsPath() {
		return launchJsPath;
	}

	/**
	 * @param launchJsPath the launchJsPath to set
	 */
	public void setLaunchJsPath(String launchJsPath) {
		this.launchJsPath = launchJsPath;
	}

	/**
	 * @return the senderUrlImage
	 */
	public String getSenderUrlImage() {
		return senderUrlImage;
	}

	/**
	 * @param senderUrlImage the senderUrlImage to set
	 */
	public void setSenderUrlImage(String senderUrlImage) {
		this.senderUrlImage = senderUrlImage;
	}

	/**
	 * @return the calloutTitle
	 */
	public String getCalloutTitle() {
		return calloutTitle;
	}

	/**
	 * @param calloutTitle the calloutTitle to set
	 */
	public void setCalloutTitle(String calloutTitle) {
		this.calloutTitle = calloutTitle;
	}

	/**
	 * @return the calloutMsg
	 */
	public String getCalloutMsg() {
		return calloutMsg;
	}

	/**
	 * @param calloutMsg the calloutMsg to set
	 */
	public void setCalloutMsg(String calloutMsg) {
		this.calloutMsg = calloutMsg;
	}

	/**
	 * @return the showPopup
	 */
	public boolean isShowPopup() {
		return showPopup;
	}

	/**
	 * @param showPopup the showPopup to set
	 */
	public void setShowPopup(boolean showPopup) {
		this.showPopup = showPopup;
	}

	/**
	 * @return the popupIdleTimeout
	 */
	public Integer getPopupIdleTimeout() {
		return popupIdleTimeout;
	}

	/**
	 * @param popupIdleTimeout the popupIdleTimeout to set
	 */
	public void setPopupIdleTimeout(Integer popupIdleTimeout) {
		this.popupIdleTimeout = popupIdleTimeout;
	}

	/**
	 * @return the agentId
	 */
	public String getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	@Override
	public String toString() {
		return "ChatbotConfigurationModel [active=" + active + ", projectId=" + projectId + ", agentId=" + agentId
				+ ", userId=" + userId + ", welcomeTitle=" + welcomeTitle + ", welcomeMsg=" + welcomeMsg
				+ ", widgetTitle=" + widgetTitle + ", logoPath=" + logoPath + ", launchJsPath=" + launchJsPath
				+ ", senderUrlImage=" + senderUrlImage + ", calloutTitle=" + calloutTitle + ", calloutMsg=" + calloutMsg
				+ ", customAttributes=" + customAttributes + ", customAttributesString=" + customAttributesString
				+ ", showPopup=" + showPopup + ", popupIdleTimeout=" + popupIdleTimeout + "]";
	}
	
}
