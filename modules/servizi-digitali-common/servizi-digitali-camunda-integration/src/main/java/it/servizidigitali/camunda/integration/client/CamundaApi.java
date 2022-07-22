package it.servizidigitali.camunda.integration.client;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map.Entry;

import it.servizidigitali.camunda.integration.exception.CamundaApiException;
import it.servizidigitali.camunda.integration.model.ProcessDefinition;
import it.servizidigitali.camunda.integration.model.ProcessInstance;
import it.servizidigitali.camunda.integration.model.Task;
import it.servizidigitali.camunda.integration.model.Variable;
import it.servizidigitali.camunda.integration.model.Variables;

/**
 * @author pindi
 */
public interface CamundaApi extends AutoCloseable {

	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	List<ProcessDefinition> getProcessDefinitions();

	List<Variable> getVariablesByTaskId(String taskId) throws CamundaApiException;

	List<Task> getTasksByBusinessKey(long businessKey, boolean includeCandidateGroups) throws CamundaApiException;

	boolean existProcessByBusinessKey(long businessKey);

	// void updateVariablessByBusinessKey( long id, Map <String, Object> variables);

	void insertOrUpdateProcessDefinitions(byte[] byteArray) throws Exception;

	/*
	 * //metodo per contare i processi in coda ad un gruppo + quelli in carico ad un utente long
	 * countProcessInstancesByCandidateGroups(String candidateGroups) throws CamundaApiException;
	 *
	 * long countProcessInstancesByCandidateGroupsAndCodiceServizio(String candidateGroups, String
	 * codiceServizio) throws CamundaApiException;
	 *
	 * //metodo per recuperare la lista dei processi di un determinato servizio in coda ad un gruppo
	 * List<ProcessInstance> getProcessInstancesByCandidateGroupsAndCodiceServizio(String
	 * candidateGroups, String codiceServizio) throws CamundaApiException;
	 */
	// metodo per contare i task in coda ad un gruppo
	long countTasksByCandidateGroupsAndCodiceServizio(String candidateGroups[], String codiceServizio, boolean unassigned) throws CamundaApiException;

	long countTasksByCandidateGroupsAndCodiceServizio(String candidateGroups[], String codiceServizio, boolean unassigned, List<Variables> variables) throws CamundaApiException;

	// metodo per riprendere la lista dei task in coda ad un gruppo
	List<Task> getTasksByCandidateGroupsAndCodiceServizio(String candidateGroups[], String codiceServizio, boolean unassigned) throws CamundaApiException;

	List<Task> getTasksByCandidateGroupsAndCodiceServizio(String candidateGroups[], String codiceServizio, boolean unassigned, List<Variables> variables, Integer firstResult, Integer maxResults,
			String sortName, String sortOrder, String sortType) throws CamundaApiException;

	// metodo per riprendere la lista dei task in carico ad un determinato utente
	List<Task> getTasksByAssigneeAndCodiceServizio(String assignee, String codiceServizio) throws CamundaApiException;

	List<Task> getTasksByAssigneeAndCodiceServizio(String assignee, String codiceServizio, List<Variables> variables, Integer firstResult, Integer maxResults, String sortName, String sortOrder,
			String sortType) throws CamundaApiException;

	// metodo per riprendere la lista dei task in carico ad un determinato utente
	long countTasksByAssigneeAndCodiceServizio(String assignee, String codiceServizio) throws CamundaApiException;

	long countTasksByAssigneeAndCodiceServizio(String assignee, String codiceServizio, List<Variables> variables) throws CamundaApiException;

	// metodo per riprendere una specifica processInstance
	ProcessInstance getProcessInstance(String id) throws CamundaApiException;

	boolean claim(String userId, String taskId) throws CamundaApiException;

	boolean unclaim(String taskId) throws CamundaApiException;

	@Override
	void close() throws CamundaApiException;

	void completeTask(String taskId, List<Entry<String, String>> varialbles) throws CamundaApiException;

	/**
	 * @param businessKey
	 * @return
	 * @throws CamundaApiException
	 */
	ProcessInstance[] getProcessInstanceByBusinessKey(long businessKey) throws CamundaApiException;

	/**
	 *
	 * @param processId
	 * @param variableName
	 * @param variableValue
	 * @param variableType
	 * @throws CamundaApiException
	 */
	void updateProcessInstanceVariableByBusinessKey(String processId, String variableName, String variableValue, String variableType) throws CamundaApiException;

	/**
	 * @param codiceIpa
	 * @param codiceServizio
	 * @param unassigned
	 * @return
	 * @throws CamundaApiException
	 */
	long countTasksByCodiceIpaComuneAndCodiceServizio(String codiceIpa, String codiceServizio, boolean unassigned) throws CamundaApiException;
}
