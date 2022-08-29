package it.servizidigitali.camunda.integration.client;

import java.io.File;
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

	/**
	 *
	 * @param tenantId
	 * @return
	 * @throws CamundaClientException
	 */
	List<ProcessDefinitionDto> getProcessDefinitions(String tenantId) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param taskId
	 * @return
	 * @throws CamundaClientException
	 */
	List<VariableInstanceDto> getVariablesByTaskId(String tenantId, String taskId) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param businessKey
	 * @param includeCandidateGroups
	 * @return
	 * @throws CamundaClientException
	 */
	List<TaskDto> getTasksByBusinessKey(String tenantId, long businessKey, boolean includeCandidateGroups) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param businessKey
	 * @return
	 */
	boolean existProcessByBusinessKey(String tenantId, long businessKey);

	/**
	 *
	 * @param tenantId
	 * @param processDefinitionName
	 * @param byteArray
	 * @return
	 * @throws CamundaClientException
	 */
	String insertOrUpdateProcessDefinitions(String tenantId, String processDefinitionName, byte[] byteArray) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param candidateGroups
	 * @param codiceServizio
	 * @param unassigned
	 * @return
	 * @throws CamundaClientException
	 */
	long countTasksByCandidateGroupsAndCodiceServizio(String tenantId, String candidateGroups[], String codiceServizio, boolean unassigned) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param candidateGroups
	 * @param codiceServizio
	 * @param unassigned
	 * @param variables
	 * @return
	 * @throws CamundaClientException
	 */
	long countTasksByCandidateGroupsAndCodiceServizio(String tenantId, String candidateGroups[], String codiceServizio, boolean unassigned, List<VariableInstanceDto> variables)
			throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param candidateGroups
	 * @param codiceServizio
	 * @param unassigned
	 * @return
	 * @throws CamundaClientException
	 */
	List<TaskDto> getTasksByCandidateGroupsAndCodiceServizio(String tenantId, String candidateGroups[], String codiceServizio, boolean unassigned) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param candidateGroups
	 * @param codiceServizio
	 * @param unassigned
	 * @param variables
	 * @param firstResult
	 * @param maxResults
	 * @param sortName
	 * @param sortOrder
	 * @param sortType
	 * @return
	 * @throws CamundaClientException
	 */
	List<TaskDto> getTasksByCandidateGroupsAndCodiceServizio(String tenantId, String candidateGroups[], String codiceServizio, boolean unassigned, List<VariableInstanceDto> variables,
			Integer firstResult, Integer maxResults, String sortName, String sortOrder, String sortType) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param assignee
	 * @param codiceServizio
	 * @return
	 * @throws CamundaClientException
	 */
	List<TaskDto> getTasksByAssigneeAndCodiceServizio(String tenantId, String assignee, String codiceServizio) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param assignee
	 * @param codiceServizio
	 * @param variables
	 * @param firstResult
	 * @param maxResults
	 * @param sortName
	 * @param sortOrder
	 * @param sortType
	 * @return
	 * @throws CamundaClientException
	 */
	List<TaskDto> getTasksByAssigneeAndCodiceServizio(String tenantId, String assignee, String codiceServizio, List<VariableInstanceDto> variables, Integer firstResult, Integer maxResults,
			String sortName, String sortOrder, String sortType) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param assignee
	 * @param codiceServizio
	 * @return
	 * @throws CamundaClientException
	 */
	long countTasksByAssigneeAndCodiceServizio(String tenantId, String assignee, String codiceServizio) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param assignee
	 * @param codiceServizio
	 * @param variables
	 * @return
	 * @throws CamundaClientException
	 */
	long countTasksByAssigneeAndCodiceServizio(String tenantId, String assignee, String codiceServizio, List<VariableInstanceDto> variables) throws CamundaClientException;

	/**
	 *
	 * @param id
	 * @return
	 * @throws CamundaClientException
	 */
	ProcessInstanceDto getProcessInstance(String id) throws CamundaClientException;

	/**
	 *
	 * @param userId
	 * @param taskId
	 * @return
	 * @throws CamundaClientException
	 */
	boolean claim(String userId, String taskId) throws CamundaClientException;

	/**
	 *
	 * @param taskId
	 * @return
	 * @throws CamundaClientException
	 */
	boolean unclaim(String taskId) throws CamundaClientException;

	/**
	 *
	 * @param taskId
	 * @param varialbles
	 * @throws CamundaClientException
	 */
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

	/**
	 *
	 * @param id
	 * @return
	 * @throws CamundaClientException
	 */
	File getDeploymentFile(String id) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param tenantName
	 */
	void insertOrUpdateTenant(String tenantId, String tenantName);

	/**
	 *
	 * @param tenantId
	 */
	void removeTenant(String tenantId);

	/**
	 *
	 * @param groupId
	 * @param groupName
	 * @param groupType
	 */
	void inserOrUpdateGroup(String groupId, String groupName, String groupType);

	/**
	 *
	 * @param groupId
	 */
	void removeGroup(String groupId);

}
