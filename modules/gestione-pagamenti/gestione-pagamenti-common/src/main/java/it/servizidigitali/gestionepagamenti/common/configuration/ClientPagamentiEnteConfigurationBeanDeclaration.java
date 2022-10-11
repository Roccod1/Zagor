package it.servizidigitali.gestionepagamenti.common.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 *
 * @author pindi
 *
 */
@Component
public class ClientPagamentiEnteConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return ClientPagamentiEnteConfiguration.class;
	}

}