package it.servizidigitali.backoffice.integration.client.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.apache.axis.client.Stub;
import org.osgi.service.component.annotations.Component;

import it.linksmt.servizionline.ws.PayloadXmlRequest;
import it.linksmt.servizionline.ws.PayloadXmlResponse;
import it.linksmt.servizionline.ws.ServiziOnlinePort;
import it.linksmt.servizionline.ws.ServiziOnlinePortServiceLocator;
import it.servizidigitali.backoffice.integration.client.BackofficeIntegrationClient;
import it.servizidigitali.backoffice.integration.exception.BackofficeIntegrationClientException;

/**
 *
 * @author pindi
 *
 */
@Component(immediate = true, service = BackofficeIntegrationClient.class)
public class BackofficeIntegrationClientImpl implements BackofficeIntegrationClient {

	private static final Log log = LogFactoryUtil.getLog(BackofficeIntegrationClientImpl.class.getName());

	@Override
	public String sendXml(String payloadXml, String nomeServizio, String wsUrl, Integer readTimeout) throws BackofficeIntegrationClientException {
		try {

			ServiziOnlinePortServiceLocator locator = new ServiziOnlinePortServiceLocator();
			locator.setServiziOnlinePortSoap11EndpointAddress(wsUrl);
			PayloadXmlRequest payloadXmlRequest = new PayloadXmlRequest(nomeServizio, payloadXml);
			ServiziOnlinePort serviziOnlinePortSoap11 = locator.getServiziOnlinePortSoap11();

			if (readTimeout != null) {
				org.apache.axis.client.Stub stub = (Stub) serviziOnlinePortSoap11;
				stub.setTimeout(readTimeout);
			}

			PayloadXmlResponse payloadXmlResponse = serviziOnlinePortSoap11.payloadXml(payloadXmlRequest);

			return payloadXmlResponse.getXml();
		}
		catch (Exception e) {
			log.error("sendXml :: " + e.getMessage(), e);
			throw new BackofficeIntegrationClientException(e.getMessage(), e);
		}
	}

}
