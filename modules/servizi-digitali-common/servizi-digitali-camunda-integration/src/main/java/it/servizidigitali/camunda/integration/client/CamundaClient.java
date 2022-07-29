package it.servizidigitali.camunda.integration.client;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map.Entry;

import org.camunda.community.rest.client.dto.ProcessDefinitionDto;
import org.camunda.community.rest.client.dto.ProcessInstanceDto;
import org.camunda.community.rest.client.dto.TaskDto;
import org.camunda.community.rest.client.dto.VariableInstanceDto;

import it.servizidigitali.camunda.integration.client.exception.CamundaClientException;

/**
 * @author pindi
 */
public interface CamundaClient {

	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	List<ProcessDefinitionDto> getProcessDefinitions(String tenantId) throws CamundaClientException;

	List<VariableInstanceDto> getVariablesByTaskId(String tenantId, String taskId) throws CamundaClientException;

	List<TaskDto> getTasksByBusinessKey(String tenantId, long businessKey, boolean includeCandidateGroups) throws CamundaClientException;

	boolean existProcessByBusinessKey(String tenantId, long businessKey);

	void insertOrUpdateProcessDefinitions(String tenantId, byte[] byteArray) throws CamundaClientException;

	long countTasksByCandidateGroupsAndCodiceServizio(String tenantId, String candidateGroups[], String codiceServizio, boolean unassigned) throws CamundaClientException;

	long countTasksByCandidateGroupsAndCodiceServizio(String tenantId, String candidateGroups[], String codiceServizio, boolean unassigned, List<VariableInstanceDto> variables) throws CamundaClientException;

	List<TaskDto> getTasksByCandidateGroupsAndCodiceServizio(String tenantId, String candidateGroups[], String codiceServizio, boolean unassigned) throws CamundaClientException;

	List<TaskDto> getTasksByCandidateGroupsAndCodiceServizio(String tenantId, String candidateGroups[], String codiceServizio, boolean unassigned, List<VariableInstanceDto> variables, Integer firstResult,
			Integer maxResults, String sortName, String sortOrder, String sortType) throws CamundaClientException;

	List<TaskDto> getTasksByAssigneeAndCodiceServizio(String tenantId, String assignee, String codiceServizio) throws CamundaClientException;

	List<TaskDto> getTasksByAssigneeAndCodiceServizio(String tenantId, String assignee, String codiceServizio, List<VariableInstanceDto> variables, Integer firstResult, Integer maxResults, String sortName,
			String sortOrder, String sortType) throws CamundaClientException;

	long countTasksByAssigneeAndCodiceServizio(String tenantId, String assignee, String codiceServizio) throws CamundaClientException;

	long countTasksByAssigneeAndCodiceServizio(String tenantId, String assignee, String codiceServizio, List<VariableInstanceDto> variables) throws CamundaClientException;

	ProcessInstanceDto getProcessInstance(String id) throws CamundaClientException;

	boolean claim(String userId, String taskId) throws CamundaClientException;

	boolean unclaim(String taskId) throws CamundaClientException;

	void completeTask(String taskId, List<Entry<String, String>> varialbles) throws CamundaClientException;

	/**
	 * @param businessKey
	 * @return
	 * @throws CamundaClientException
	 */
	ProcessInstanceDto[] getProcessInstanceByBusinessKey(String tenantId, long businessKey) throws CamundaClientException;

	/**
	 *
	 * @param processId
	 * @param variableName
	 * @param variableValue
	 * @param variableType
	 * @throws CamundaClientException
	 */
	void updateProcessInstanceVariableByBusinessKey(String processId, String variableName, String variableValue, String variableType) throws CamundaClientException;

	/**
	 * @param codiceIpa
	 * @param codiceServizio
	 * @param unassigned
	 * @return
	 * @throws CamundaClientException
	 */
	long countTasksByCodiceIpaComuneAndCodiceServizio(String tenantId, String codiceIpa, String codiceServizio, boolean unassigned) throws CamundaClientException;
}
