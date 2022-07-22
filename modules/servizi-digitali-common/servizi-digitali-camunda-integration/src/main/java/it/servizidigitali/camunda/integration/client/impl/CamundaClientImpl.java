package it.servizidigitali.camunda.integration.client.impl;

import java.util.List;
import java.util.Map.Entry;

import org.camunda.community.rest.client.dto.ProcessDefinitionDto;
import org.camunda.community.rest.client.dto.TaskDto;
import org.camunda.community.rest.client.dto.VariableInstanceDto;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.camunda.integration.client.exception.CamundaClientException;

/**
 * @author pindi
 *
 */
public class CamundaClientImpl implements CamundaClient {

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
		// TODO Auto-generated method stub

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
