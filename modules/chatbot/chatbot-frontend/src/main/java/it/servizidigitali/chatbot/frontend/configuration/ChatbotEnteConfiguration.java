package it.servizidigitali.chatbot.frontend.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "third-party" , scope = ExtendedObjectClassDefinition.Scope.GROUP)
@Meta.OCD(
		id = "it.servizidigitali.chatbot.frontend.configuration.ChatbotEnteConfiguration",
		name = "Configurazione Chatbot"
		)
public interface ChatbotEnteConfiguration {

	@Meta.AD(
			deflt = "",
			required = false
			)
	public String dialogflowAgentId();
	
	
	@Meta.AD(
			deflt = "Chatbot",
			required = false
			)
	public String widgetTitle();
	
	@Meta.AD(
			deflt = "",
			required = false
			)
	public String projectId();
	
	@Meta.AD(
			deflt = "",
			required = false
			)
	public String userId();
	
	
	@Meta.AD(
			deflt = "chatbot-btn-label",
			required = false
			)
	public String chatbotButtonLabelKey();
	
	@Meta.AD(
			deflt = "chatbot-recipient-name",
			required = false
			)
	public String chatbotRecipientNameKey();
	
	@Meta.AD(
			deflt = "chatbot-welcome-summary",
			required = false
			)
	public String chatbotWelcomeSummaryKey();
	
	@Meta.AD(
			deflt = "chatbot-callout-title",
			required = false
			)
	public String chatbotCalloutTitleKey();
	
	@Meta.AD(
			deflt = "chatbot-callout-message",
			required = false
			)
	public String chatbotCalloutMessageKey();
	
	@Meta.AD(
			deflt = "chatbot-welcome-title",
			required = false
			)
	public String chatbotWelcomeTitleKey();
	
	@Meta.AD(
			deflt = "http://localhost",
			required = false
			)
	public String nodeJsBasePath();
	
	@Meta.AD(
			deflt = "",
			required = false
			)
	public String chatbotLogoUrl();
	
	@Meta.AD(
			deflt = "",
			required = false
			)
	public String senderImageUrl();
	
	@Meta.AD(
			deflt = "30000",
			required = false
			)
	public Integer popupIdleTimeout();
	
	@Meta.AD(
			deflt = "true",
			required = false
			)
	public boolean showPopup();
	
	

}
