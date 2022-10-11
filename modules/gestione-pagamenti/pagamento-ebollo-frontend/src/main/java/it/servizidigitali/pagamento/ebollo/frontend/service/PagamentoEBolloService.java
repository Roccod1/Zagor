package it.servizidigitali.pagamento.ebollo.frontend.service;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionepagamenti.common.client.PagamentiClient;
import it.servizidigitali.gestionepagamenti.common.client.exeption.PagamentiClientException;
import it.servizidigitali.gestionepagamenti.common.client.model.MarcaDaBollo;
import it.servizidigitali.gestionepagamenti.common.client.model.PagamentoDovutoRisposta;
import it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration;

/**
 * @author pindi
 *
 */
@Component(immediate = true, service = PagamentoEBolloService.class, configurationPid = "it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration")
public class PagamentoEBolloService {

	private static final Log log = LogFactoryUtil.getLog(PagamentoEBolloService.class.getName());

	private volatile ClientPagamentiEnteConfiguration accountClientPagamentiEnteConfiguration;

	private ConfigurationProvider configurationProvider;

	@Reference
	private PagamentiClient pagamentiClient;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		accountClientPagamentiEnteConfiguration = ConfigurableUtil.createConfigurable(ClientPagamentiEnteConfiguration.class, props);
	}

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	public String pagaBollo(long companyId, long groupId) throws ConfigurationException, PagamentiClientException {

		// TODO loggare parametri ingresso
		log.debug("pagaBollo: ");

		accountClientPagamentiEnteConfiguration = configurationProvider.getGroupConfiguration(ClientPagamentiEnteConfiguration.class, groupId);

		String username = accountClientPagamentiEnteConfiguration.clientUsername();
		String password = accountClientPagamentiEnteConfiguration.clientPassword();
		String wsdlUrl = accountClientPagamentiEnteConfiguration.clientWsdlUrl();

		MarcaDaBollo marcaDaBollo = new MarcaDaBollo();
		// TODO valorizzare campi marcaDaBollo
		String rispostaPagamentoUrl = null;
		// TODO generare path portlet esito pagamento
		PagamentoDovutoRisposta pagamentoDovutoRisposta = pagamentiClient.pagaDovuto(marcaDaBollo, username, password, wsdlUrl, rispostaPagamentoUrl);

		return pagamentoDovutoRisposta.getRedirectUrl();

	}

}
