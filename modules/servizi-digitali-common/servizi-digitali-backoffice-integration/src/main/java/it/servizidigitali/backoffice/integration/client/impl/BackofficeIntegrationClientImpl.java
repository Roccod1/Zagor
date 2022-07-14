package it.servizidigitali.backoffice.integration.client.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.axis.client.Service;
import org.osgi.service.component.annotations.Component;

import it.linksmt.servizionline.ws.PayloadXmlRequest;
import it.linksmt.servizionline.ws.ServiziOnlinePortSoap11Stub;
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
	public String sendXml(String payloadXml, String nomeServizio, String wsUrl, int... readTimeout) throws BackofficeIntegrationClientException {
		try {
			URL url = new URL(wsUrl);
			QName qname = new QName("http://ws.servizionline.linksmt.it", "PayloadXml");
			Service service = new Service(url, qname);
			ServiziOnlinePortSoap11Stub serviziOnlinePortSoap11Stub = new ServiziOnlinePortSoap11Stub(service);

			PayloadXmlRequest payloadXmlRequest = new PayloadXmlRequest(nomeServizio, payloadXml);
			serviziOnlinePortSoap11Stub.payloadXml(payloadXmlRequest);
		}
		catch (Exception e) {
			log.error("sendXml :: " + e.getMessage(), e);
			throw new BackofficeIntegrationClientException(e.getMessage(), e);
		}
		return null;
	}

}
