package it.servizidigitali.presentatoreforms.common.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 *
 * @author pindi
 *
 */
@Component
public class FreemarkerTemplateEnteConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return FreemarkerTemplateEnteConfiguration.class;
	}

}