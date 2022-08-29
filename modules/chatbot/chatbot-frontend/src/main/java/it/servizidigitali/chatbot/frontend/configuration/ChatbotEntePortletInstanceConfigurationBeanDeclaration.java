package it.servizidigitali.chatbot.frontend.configuration;


import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;


@Component
public class ChatbotEntePortletInstanceConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return ChatbotEnteConfiguration.class;
	}
	
}
