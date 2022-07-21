package it.servizidigitali.backoffice.integration.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.linksmt.servizionline.anprws.client.ANPRWSClient;
import it.linksmt.servizionline.anprws.exception.ANPRClientException;
import it.linksmt.servizionline.anprws.model.ANPRConfigurationModel;
import it.sogei.anpr._3000consultazione.Risposta3002;

/**
 * @author pindi
 *
 */
public class ANPRTestClient {

	private ANPRWSClient anprwsClient;

	@BeforeClass
	public static void setTrustStore() throws Exception {
		System.setProperty("javax.net.ssl.trustStore", "keystore/cacerts");
		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
	}

	@Before
	public void init() throws Exception {

		ANPRConfigurationModel anprConfigurationModel = new ANPRConfigurationModel();
		anprConfigurationModel.setAliasKeystore("888191-CO-0000");
		anprConfigurationModel.setIdApplicazione("12345");
		anprConfigurationModel.setIdOperatore("USERSFREETEST191");
		anprConfigurationModel.setIdPostazione("888191-CO-0000");
		anprConfigurationModel.setIdSede("888191");
		anprConfigurationModel.setKeyStorePath("keystore/888191-CO-0000.p12");
		anprConfigurationModel.setPasswordKeystore("4DA682FF");
		anprConfigurationModel.setWsUrl("https://wsfree.anpr.interno.it");
		anprwsClient = new ANPRWSClient(anprConfigurationModel);
	}

	@Test
	public void test() throws ANPRClientException {
		Risposta3002 sendRequest = anprwsClient.sendRequest("RSSNTN81A05B519S", "123456789");
		assertNotNull(sendRequest);
	}

}
