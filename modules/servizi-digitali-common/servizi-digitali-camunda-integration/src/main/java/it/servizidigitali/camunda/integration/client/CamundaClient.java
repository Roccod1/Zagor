package it.servizidigitali.camunda.integration.client;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import it.servizidigitali.camunda.integration.client.exception.CamundaClientException;
import it.servizidigitali.camunda.integration.client.model.ProcessDefinition;
import it.servizidigitali.camunda.integration.client.model.ProcessInstance;
import it.servizidigitali.camunda.integration.client.model.Task;
import it.servizidigitali.camunda.integration.client.model.VariableInstance;

/**
 * @author pindi
 */
public interface CamundaClient {

	/**
	 *
	 * @param tenantId
	 * @return
	 * @throws CamundaClientException
	 */
	List<ProcessDefinition> getProcessDefinitions(String tenantId) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param taskId
	 * @return
	 * @throws CamundaClientException
	 */
	List<VariableInstance> getVariablesByTaskId(String tenantId, String taskId) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param businessKey
	 * @param includeCandidateGroups
	 * @return
	 * @throws CamundaClientException
	 */
	List<Task> getTasksByBusinessKey(String tenantId, long businessKey, boolean includeCandidateGroups) throws CamundaClientException;

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
	long countTasks(String tenantId, String candidateGroups[], String codiceServizio, boolean unassigned) throws CamundaClientException;

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
	long countTasks(String tenantId, String candidateGroups[], String codiceServizio, boolean unassigned, List<VariableInstance> variables) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param candidateGroups
	 * @param codiceServizio
	 * @param unassigned
	 * @return
	 * @throws CamundaClientException
	 */
	List<Task> searchTasks(String tenantId, String candidateGroups[], String codiceServizio, boolean unassigned) throws CamundaClientException;

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
	List<Task> searchTasks(String tenantId, String candidateGroups[], String codiceServizio, boolean unassigned, List<VariableInstance> variables, Integer firstResult, Integer maxResults,
			String sortName, String sortOrder, String sortType) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param assignee
	 * @param codiceServizio
	 * @return
	 * @throws CamundaClientException
	 */
	List<Task> searchTasks(String tenantId, String assignee, String codiceServizio) throws CamundaClientException;

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
	List<Task> searchTasks(String tenantId, String assignee, String codiceServizio, List<VariableInstance> variables, Integer firstResult, Integer maxResults, String sortName, String sortOrder,
			String sortType) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param assignee
	 * @param codiceServizio
	 * @return
	 * @throws CamundaClientException
	 */
	long countTasks(String tenantId, String assignee, String codiceServizio) throws CamundaClientException;

	/**
	 *
	 * @param tenantId
	 * @param assignee
	 * @param codiceServizio
	 * @param variables
	 * @return
	 * @throws CamundaClientException
	 */
	long countTasks(String tenantId, String assignee, String codiceServizio, List<VariableInstance> variables) throws CamundaClientException;

	/**
	 *
	 * @param id
	 * @return
	 * @throws CamundaClientException
	 */
	ProcessInstance getProcessInstance(String id) throws CamundaClientException;

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
	List<ProcessInstance> getProcessInstanceByBusinessKey(String tenantId, long businessKey) throws CamundaClientException;

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
	long countTasks(String tenantId, String codiceIpa, String codiceServizio, boolean unassigned) throws CamundaClientException;

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
	void deleteTenant(String tenantId);

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
	void deleteGroup(String groupId);

	/**
	 *
	 * @param userId
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 */
	void inserOrUpdateUser(String userId, String firstName, String lastName, String email, String password);

	/**
	 *
	 * @param userId
	 */
	void deleteUser(String userId);

	/**
	 * @param groupId
	 * @param userId
	 */
	void addUserToGroup(String groupId, String userId);

	/**
	 * @param groupId
	 * @param userId
	 */
	void removeUserFromGroup(String groupId, String userId);

	/**
	 *
	 * @param tenantId
	 * @param groupId
	 */
	void addGroupToTenant(String tenantId, String groupId);

	/**
	 *
	 * @param tenantId
	 * @param groupId
	 */
	void removeGroupFromTenant(String tenantId, String groupId);

	/**
	 *
	 * @param tenantId
	 * @param userId
	 */
	void addUserToTenant(String tenantId, String userId);

	/**
	 *
	 * @param tenantId
	 * @param userId
	 */
	void removeUserFromTenant(String tenantId, String userId);

	/**
	 *
	 * @param tenantId
	 * @param processDefinitionKey
	 * @param businessKey
	 * @param variables
	 * @return processId
	 */
	String startProcessInstance(String tenantId, String processDefinitionKey, String businessKey, Map<String, Object> variables);

	/**
	 * @param groupId
	 * @return
	 */
	boolean existsGroup(String groupId);

}
