package it.servizidigitali.camunda.integration.client.impl;

import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.invoker.ApiClient;

/**
 * @author pindi
 *
 */
public class CamundaClientImpl {

	public void getProcessDefinition() {

		ApiClient client = new ApiClient();
		client.setBasePath("http://localhost:8080/engine-rest");

		ProcessDefinitionApi processDefinitionApi = new ProcessDefinitionApi(client);
	}

	public void insertOrUpdateProcessDefinitions(byte[] byteArray) {

	}

}
