package it.servizidigitali.backoffice.integration.service.anpr;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.linksmt.servizionline.anprws.client.ANPRWSClient;
import it.linksmt.servizionline.anprws.exception.ANPRClientException;
import it.linksmt.servizionline.anprws.model.ANPRConfigurationModel;
import it.servizidigitali.backoffice.integration.configuration.anpr.ANPRConfiguration;

/**
 * @author pindi
 *
 */
@Component(name = "ANPRService", immediate = true, service = ANPRService.class, configurationPid = "it.servizidigitali.backoffice.integration.configuration.anpr.ANPRConfiguration")
public class ANPRService {

	private volatile ANPRConfiguration anprConfiguration;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		anprConfiguration = ConfigurableUtil.createConfigurable(ANPRConfiguration.class, props);
	}

	public ANPRWSClient getANPRWSClient() throws ANPRClientException {
		ANPRWSClient anprwsClient = new ANPRWSClient(loadConfiguration());
		return anprwsClient;
	}

	private ANPRConfigurationModel loadConfiguration() {

		ANPRConfigurationModel anprConfigurationModel = new ANPRConfigurationModel();

		anprConfigurationModel.setAliasKeystore(anprConfiguration.aliasKeystore());
		anprConfigurationModel.setIdApplicazione(anprConfiguration.idApplicazione());
		anprConfigurationModel.setIdOperatore(anprConfiguration.idOperatore());
		anprConfigurationModel.setIdPostazione(anprConfiguration.idPostazione());
		anprConfigurationModel.setIdSede(anprConfiguration.idSede());
		anprConfigurationModel.setKeyStorePath(anprConfiguration.pathKeystore());
		anprConfigurationModel.setPasswordKeystore(anprConfiguration.passwordKeystore());
		anprConfigurationModel.setTipoInvio(anprConfiguration.tipoInvio());
		anprConfigurationModel.setWsUrl(anprConfiguration.wsUrl());

		return anprConfigurationModel;
	}
}
