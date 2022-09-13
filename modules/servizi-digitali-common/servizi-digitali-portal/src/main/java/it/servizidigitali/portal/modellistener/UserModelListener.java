package it.servizidigitali.portal.modellistener;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.security.ldap.authenticator.configuration.LDAPAuthConfiguration;
import com.liferay.portal.security.ldap.configuration.ConfigurationProvider;
import com.liferay.portal.security.ldap.configuration.LDAPServerConfiguration;

import java.util.List;
import java.util.Map;

import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.camunda.integration.configuration.CamundaConfiguration;
import it.servizidigitali.portal.util.LDAPManager;

/**
 * Model Listener per gestire gli eventi relativi al model {@link User}.
 *
 * @author pindi
 */
@Component(//
		immediate = true, //
		service = ModelListener.class, //
		configurationPid = "it.servizidigitali.camunda.integration.configuration.CamundaConfiguration" //
) //
public class UserModelListener extends BaseModelListener<User> {

	private ConfigurationProvider<LDAPServerConfiguration> ldapServerConfigurationProvider;

	private ConfigurationProvider<LDAPAuthConfiguration> ldapAuthConfigurationProvider;

	private volatile CamundaConfiguration camundaConfiguration;
	private boolean camundaIntegrationEnabled;

	@Reference
	private CamundaClient camundaClient;

	@Reference(target = "(factoryPid=com.liferay.portal.security.ldap.configuration.LDAPServerConfiguration)", unbind = "-")
	protected void setLDAPServerConfigurationProvider(ConfigurationProvider<LDAPServerConfiguration> ldapServerConfigurationProvider) {
		this.ldapServerConfigurationProvider = ldapServerConfigurationProvider;
	}

	@Reference(target = "(factoryPid=com.liferay.portal.security.ldap.authenticator.configuration.LDAPAuthConfiguration)", unbind = "-")
	protected void setLDAPAuthConfiguration(ConfigurationProvider<LDAPAuthConfiguration> ldapAuthConfigurationProvider) {
		this.ldapAuthConfigurationProvider = ldapAuthConfigurationProvider;
	}

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		camundaConfiguration = ConfigurableUtil.createConfigurable(CamundaConfiguration.class, props);
		camundaIntegrationEnabled = camundaConfiguration.integrationEnabled();
	}

	@Override
	public void onAfterRemove(User model) throws ModelListenerException {

		// Eliminazione da LDAP
		try {
			long companyId = model.getCompanyId();
			boolean ldapEnabled = ldapAuthConfigurationProvider.getConfiguration(companyId).enabled();
			if (ldapEnabled) {
				List<LDAPServerConfiguration> configurations = ldapServerConfigurationProvider.getConfigurations(companyId);
				if (configurations != null) {
					for (LDAPServerConfiguration configuration : configurations) {
						String hostname = configuration.baseProviderURL();
						String usernameLdap = configuration.securityPrincipal();
						String password = configuration.securityCredential();
						String users_ou = configuration.usersDN();
						String groups_ou = configuration.groupsDN();
						try {
							LDAPManager ldapManager = new LDAPManager(hostname, 0, usernameLdap, password, users_ou, groups_ou, null, true);
							ldapManager.deleteUser(model.getScreenName());
						}
						catch (NameNotFoundException e) {
							_log.warn("delete on LDAP failed :: " + e.getMessage());
						}
						catch (NamingException e) {
							_log.error("delete on LDAP failed :: " + e.getMessage(), e);
						}
					}
				}
			}
		}
		catch (Exception e) {
			_log.error(e);
		}

		// Eliminazione da Camunda BPMN server
		if (camundaIntegrationEnabled) {
			try {
				camundaClient.deleteUser(model.getScreenName());
			}
			catch (Exception e) {
				_log.error("delete on Camunda BPMN engine failed :: " + e.getMessage(), e);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(UserModelListener.class);

}