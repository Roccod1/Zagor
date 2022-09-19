package it.servizidigitali.chatbot.frontend.constants;

public enum CustomAttribute {
	AGENT("agent"), 
	URL_AUDIOREPO("url_audiorepo"),
	PROXY_URL("proxy_url"),
	RECIPIENT_FULLNAME("recipient_fullname"),
	BUTTON_LABEL("button_label"),
	WELCOME_IMAGE("welcome_image"),
	WELCOME_SUMMARY("welcome_summary"),
	START_HIDDEN_MESSAGE("start_hidden_message"),
	PAYLOAD("payload"),
	USERTOKEN("usertoken");

	private final String value;

	/**
	 *
	 */
	private CustomAttribute(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
