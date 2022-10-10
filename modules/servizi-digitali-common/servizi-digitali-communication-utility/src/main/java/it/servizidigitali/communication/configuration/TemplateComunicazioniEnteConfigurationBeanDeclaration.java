package it.servizidigitali.communication.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 *
 * @author pindi
 *
 */
@Component
public class TemplateComunicazioniEnteConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return TemplateComunicazioniEnteConfiguration.class;
	}

}