package it.servizidigitali.camunda.integration.client.impl;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.camunda.community.rest.client.api.DeploymentApi;
import org.camunda.community.rest.client.dto.ProcessDefinitionDto;
import org.camunda.community.rest.client.dto.TaskDto;
import org.camunda.community.rest.client.dto.VariableInstanceDto;
import org.camunda.community.rest.client.invoker.ApiClient;
import org.camunda.community.rest.client.invoker.ApiException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.camunda.integration.client.exception.CamundaClientException;
import it.servizidigitali.camunda.integration.configuration.CamundaConfiguration;

/**
 * @author pindi
 *
 */
@Component(name = "camundaClientImpl", immediate = true, service = CamundaClient.class, configurationPid = "it.servizidigitali.camunda.integration.configuration.CamundaConfiguration")
public class CamundaClientImpl implements CamundaClient {

	private static final Log log = LogFactoryUtil.getLog(CamundaClientImpl.class.getName());

	private volatile CamundaConfiguration camundaConfiguration;

	private String apiBasePath;
	private String username;
	private String password;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		camundaConfiguration = ConfigurableUtil.createConfigurable(CamundaConfiguration.class, props);
		apiBasePath = camundaConfiguration.apiBasePath();
		username = camundaConfiguration.apiUsername();
		password = camundaConfiguration.apiPassword();
	}

	@Override
	public List<ProcessDefinitionDto> getProcessDefinitions() throws CamundaClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VariableInstanceDto> getVariablesByTaskId(String taskId) throws CamundaClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskDto> getTasksByBusinessKey(long businessKey, boolean includeCandidateGroups) throws CamundaClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existProcessByBusinessKey(long businessKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertOrUpdateProcessDefinitions(byte[] byteArray) throws CamundaClientException {
		try {
			ApiClient client = new ApiClient();
			client.setBasePath(apiBasePath);
			client.setUsername(username);
			client.setPassword(password);
			new DeploymentApi(client).createDeployment(null, null, true, true, "AutoDeployment", null, new File(""));
		}
		catch (ApiException e) {
			log.error("insertOrUpdateProcessDefinitions :: " + e.getMessage(), e);
			throw new CamundaClientException("insertOrUpdateProcessDefinitions :: " + e.getMessage(), e);
		}

	}

	@Override
	public long countTasksByCandidateGroupsAndCodiceServizio(String[] candidateGroups, String codiceServizio, boolean unassigned) throws CamundaClientException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countTasksByCandidateGroupsAndCodiceServizio(String[] candidateGroups, String codiceServizio, boolean unassigned, List<VariableInstanceDto> variables) throws CamundaClientException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TaskDto> getTasksByCandidateGroupsAndCodiceServizio(String[] candidateGroups, String codiceServizio, boolean unassigned) throws CamundaClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskDto> getTasksByCandidateGroupsAndCodiceServizio(String[] candidateGroups, String codiceServizio, boolean unassigned, List<VariableInstanceDto> variables, Integer firstResult,
			Integer maxResults, String sortName, String sortOrder, String sortType) throws CamundaClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskDto> getTasksByAssigneeAndCodiceServizio(String assignee, String codiceServizio) throws CamundaClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskDto> getTasksByAssigneeAndCodiceServizio(String assignee, String codiceServizio, List<VariableInstanceDto> variables, Integer firstResult, Integer maxResults, String sortName,
			String sortOrder, String sortType) throws CamundaClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countTasksByAssigneeAndCodiceServizio(String assignee, String codiceServizio) throws CamundaClientException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countTasksByAssigneeAndCodiceServizio(String assignee, String codiceServizio, List<VariableInstanceDto> variables) throws CamundaClientException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProcessDefinitionDto getProcessInstance(String id) throws CamundaClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean claim(String userId, String taskId) throws CamundaClientException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unclaim(String taskId) throws CamundaClientException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void completeTask(String taskId, List<Entry<String, String>> varialbles) throws CamundaClientException {
		// TODO Auto-generated method stub

	}

	@Override
	public ProcessDefinitionDto[] getProcessInstanceByBusinessKey(long businessKey) throws CamundaClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProcessInstanceVariableByBusinessKey(String processId, String variableName, String variableValue, String variableType) throws CamundaClientException {
		// TODO Auto-generated method stub

	}

	@Override
	public long countTasksByCodiceIpaComuneAndCodiceServizio(String codiceIpa, String codiceServizio, boolean unassigned) throws CamundaClientException {
		// TODO Auto-generated method stub
		return 0;
	}

}
