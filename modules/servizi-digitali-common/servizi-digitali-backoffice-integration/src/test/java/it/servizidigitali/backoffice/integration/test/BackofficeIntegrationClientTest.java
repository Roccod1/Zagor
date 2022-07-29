package it.servizidigitali.backoffice.integration.test;

import org.junit.Before;
import org.junit.Test;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.client.BackofficeIntegrationClient;
import it.servizidigitali.backoffice.integration.client.impl.BackofficeIntegrationClientImpl;

/**
 *
 * @author pindi
 *
 */
public class BackofficeIntegrationClientTest {

	@Reference
	private BackofficeIntegrationClient backofficeIntegrationClient;

	@Before
	public void setUp() {
	}

	@Test
	public void testCLient() {
		backofficeIntegrationClient = new BackofficeIntegrationClientImpl();
		String sendXml = backofficeIntegrationClient.sendXml("aaaa", "aaaa", "http://egov2-collaudo:8280/services/BariWSService ", null);
		System.out.println("AAAAAAAAAAAAA: " + sendXml);
	}

}
