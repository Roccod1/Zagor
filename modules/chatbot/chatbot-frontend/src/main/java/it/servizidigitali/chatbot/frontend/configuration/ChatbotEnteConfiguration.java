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
	

}
