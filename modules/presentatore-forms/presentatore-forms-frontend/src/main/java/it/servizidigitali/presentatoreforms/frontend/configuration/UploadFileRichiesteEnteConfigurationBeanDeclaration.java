package it.servizidigitali.presentatoreforms.frontend.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 *
 * @author pindi
 *
 */
@Component
public class UploadFileRichiesteEnteConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return UploadFileRichiesteEnteConfiguration.class;
	}

}