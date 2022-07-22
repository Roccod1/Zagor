package it.servizidigitali.camunda.integration.client.impl;

import static java.util.Arrays.asList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import it.linksmt.servizionline.camunda.api.CountResponse;
import it.linksmt.servizionline.util.CustomProcessVariables;
import it.servizidigitali.camunda.integration.client.CamundaApi;
import it.servizidigitali.camunda.integration.client.CamundaApiAccessCredentials;
import it.servizidigitali.camunda.integration.client.HttpBasicAuthorizationCredentials;
import it.servizidigitali.camunda.integration.client.HttpCookieAuthorizationCredentials;
import it.servizidigitali.camunda.integration.exception.CamundaApiException;
import it.servizidigitali.camunda.integration.model.ClaimRequest;
import it.servizidigitali.camunda.integration.model.IdentityLink;
import it.servizidigitali.camunda.integration.model.LoginResponse;
import it.servizidigitali.camunda.integration.model.ProcessDefinition;
import it.servizidigitali.camunda.integration.model.ProcessInstance;
import it.servizidigitali.camunda.integration.model.ProcessInstanceRequest;
import it.servizidigitali.camunda.integration.model.TaskRequest;
import it.servizidigitali.camunda.integration.model.VariableUpdateRequest;
import it.servizidigitali.camunda.integration.model.Variables;

/**
 * Implementation of the {@link CamundaApi} contract.
 *
 * @author pindi
 */
public class CamundaRestClientImpl implements CamundaApi {

	public static final String DEFAULT_TENANT = "default";

	private String apiBaseUrl;

	private final String tenant = DEFAULT_TENANT;

	private CamundaApiAccessCredentials authCredentials;

	@Override
	public void insertOrUpdateProcessDefinitions(byte[] byteArray) throws Exception {
		MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
		bodyMap.add("deployment-name", "SpringAutoDeployment");
		bodyMap.add("enable-duplicate-filtering", "false");
		bodyMap.add("deploy-changed-only", "false");
		// il nome del file non e' importante, serve solo perche' Camunda puo' teoricamente prendere
		// in input piu' file
		bodyMap.add("processo-bpmn.bpmn", getUserFileResource(byteArray));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

		String url = deployProcessModelUrl();

		RestTemplate restTemplate = getRestTemplate();
		restTemplate.postForEntity(url, requestEntity, String.class);

	}

	public static Resource getUserFileResource(byte[] byteArray) throws IOException {
		Path tempFile = Files.createTempFile("processo-bpmn", ".bpmn");
		// byte[] b = byteArray.getBytes(Charset.forName("UTF-8"));

		Files.write(tempFile, byteArray);
		File file = tempFile.toFile();
		return new FileSystemResource(file);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.linksmt.servizionline.camunda.restclient.CamundaApi#getProcessDefinitions( )
	 */
	@Override
	public List<ProcessDefinition> getProcessDefinitions() {
		String url = processDefinitionUrl();

		// TODO Add support for query parameters
		ResponseEntity<ProcessDefinition[]> responseEntity = getRestTemplate().getForEntity(url, ProcessDefinition[].class);
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();

		return asList(responseEntity.getBody());
	}

	void setApiBaseUrl(String apiUrl) {
		this.apiBaseUrl = apiUrl;
	}

	void setAuthCredentials(CamundaApiAccessCredentials authCredentials) {
		this.authCredentials = authCredentials;
	}

	void useHttpCookieAuthorizationScheme(String camundaUser, String camundaPassword) {
		HttpCookieAuthorizationCredentials credentials = login(camundaUser, camundaPassword);
		setAuthCredentials(credentials);

		RestTemplate restTemplate = getRestTemplate();

		if (authCredentials instanceof HttpBasicAuthorizationCredentials) {
			restTemplate.getInterceptors().add(new HttpBasicAuthorizationInterceptor((HttpBasicAuthorizationCredentials) authCredentials));
		}
		else if (authCredentials instanceof HttpCookieAuthorizationCredentials) {
			restTemplate.getInterceptors().add(new HttpCookieAuthorizationInterceptor((HttpCookieAuthorizationCredentials) authCredentials));
		}
	}

	protected String url(String apiEndpoint) {
		String httpUrl = String.format("%s/%s", apiBaseUrl, apiEndpoint);
		return httpUrl;
	}

	protected String processDefinitionUrl() {
		String httpUrl = String.format("%s/engine/engine/%s/process-definition", apiBaseUrl, getTenant());
		return httpUrl;
	}

	protected String deployProcessModelUrl() {
		String httpUrl = String.format("%s/engine/engine/%s/deployment/create", apiBaseUrl, getTenant());
		return httpUrl;
	}

	protected String cockpitLoginUrl() {
		String httpUrl = String.format("%s/admin/auth/user/%s/login/cockpit", apiBaseUrl, getTenant());
		return httpUrl;
	}

	protected String processInstanceUrl() {
		String httpUrl = String.format("%s/engine/engine/%s/process-instance", apiBaseUrl, getTenant());
		return httpUrl;
	}

	protected String taskUrl() {
		String httpUrl = String.format("%s/engine/engine/%s/task", apiBaseUrl, getTenant());
		return httpUrl;
	}

	protected String taskVariablesUrl(String id) {
		String httpUrl = String.format("%s/engine/engine/%s/task/%s/variables", apiBaseUrl, getTenant(), id);
		return httpUrl;
	}

	protected String groupUrl() {
		String httpUrl = String.format("%s/engine/engine/%s/group", apiBaseUrl, getTenant());
		return httpUrl;
	}

	protected boolean isDefaultTenant() {
		return DEFAULT_TENANT.equals(getTenant());
	}

	public String getTenant() {
		return tenant;
	}

	private RestTemplate getRestTemplate() {

		return REST_TEMPLATES_HOLDER.get();

		/*
		 * RestTemplate restTemplate = REST_TEMPLATES_HOLDER.get(); List interceptors =
		 * restTemplate.getInterceptors(); if (interceptors == null) { interceptors = new
		 * ArrayList<>(); } for (Object object : interceptors) { if (object instanceof
		 * LoggingRequestInterceptor) { return restTemplate; } }
		 *
		 * interceptors.add(new LoggingRequestInterceptor());
		 * restTemplate.setInterceptors(interceptors);
		 *
		 * return restTemplate;
		 */
	}

	/* package */ HttpCookieAuthorizationCredentials login(String camundaUser, String camundaPassword) {
		StringBuilder sb = new StringBuilder();
		sb.append(cockpitLoginUrl());
		String url = sb.toString();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("username", camundaUser);
		map.add("password", camundaPassword);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<LoginResponse> responseEntity = getRestTemplate().postForEntity(url, request, LoginResponse.class);

		HttpHeaders responseHeaders = responseEntity.getHeaders();
		String sessionId = responseHeaders.getFirst("Set-Cookie");

		HttpCookieAuthorizationCredentials credentials = new HttpCookieAuthorizationCredentials(sessionId, responseEntity.getBody());

		return credentials;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws CamundaApiException {
		REST_TEMPLATES_HOLDER.set(null);
	}

	@Override
	public boolean existProcessByBusinessKey(long businessKey) throws CamundaApiException {

		ProcessInstanceRequest processInstanceRequest = new ProcessInstanceRequest();
		processInstanceRequest.setProcessInstanceBusinessKey(String.valueOf(businessKey));

		String url = processInstanceUrl() + "/count";
		ResponseEntity<CountResponse> responseEntity = getRestTemplate().postForEntity(url, processInstanceRequest, CountResponse.class);

		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();

		return responseEntity.getBody().getCount() > 0;
	}

	@Override
	public ProcessInstance[] getProcessInstanceByBusinessKey(long businessKey) throws CamundaApiException {

		ProcessInstanceRequest processInstanceRequest = new ProcessInstanceRequest();
		processInstanceRequest.setProcessInstanceBusinessKey(String.valueOf(businessKey));

		String url = processInstanceUrl() + "?businessKey=" + businessKey;

		ResponseEntity<ProcessInstance[]> responseEntity = getRestTemplate().getForEntity(url, ProcessInstance[].class);

		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();

		return responseEntity.getBody();
	}

	@Override
	public void updateProcessInstanceVariableByBusinessKey(String processId, String variableName, String variableValue, String variableType) throws CamundaApiException {

		VariableUpdateRequest variableUpdateRequest = new VariableUpdateRequest();
		variableUpdateRequest.setValue(variableValue);
		variableUpdateRequest.setType(variableType);

		String url = processInstanceUrl() + "/" + processId + "/variables/" + variableName;

		getRestTemplate().put(url, variableUpdateRequest);
	}

	@Override
	public ProcessInstance getProcessInstance(String id) throws CamundaApiException {

		String url = processInstanceUrl() + "/" + id;

		ResponseEntity<ProcessInstance> responseEntity = getRestTemplate().getForEntity(url, ProcessInstance.class);
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		return responseEntity.getBody();
	}

	@Override
	public long countTasksByCodiceIpaComuneAndCodiceServizio(String codiceIpa, String codiceServizio, boolean unassigned) throws CamundaApiException {

		TaskRequest taskRequest = new TaskRequest();
		if (unassigned) {
			taskRequest.setUnassigned(Boolean.TRUE);
		}

		Variables variable1 = new Variables();
		if (!StringUtil.isNull(codiceServizio)) {
			variable1.setName(CustomProcessVariables.CODICE_SERVIZIO);
			variable1.setOperator(Operator.EQ.getValue());
			variable1.setValue(codiceServizio);
		}

		Variables variable2 = new Variables();
		if (!StringUtil.isNull(codiceIpa)) {

			variable2.setName(CustomProcessVariables.CODICE_IPA_COMUNE);
			variable2.setOperator(Operator.EQ.getValue());
			variable2.setValue(codiceIpa);
		}

		Variables[] processVariables = { variable1, variable2 };
		taskRequest.setProcessVariables(processVariables);

		String url = taskUrl() + "/count";

		ResponseEntity<CountResponse> responseEntity = getRestTemplate().postForEntity(url, taskRequest, CountResponse.class);
		return responseEntity.getBody().getCount();
	}

	@Override
	public long countTasksByCandidateGroupsAndCodiceServizio(String[] candidateGroups, String codiceServizio, boolean unassigned) throws CamundaApiException {

		TaskRequest taskRequest = new TaskRequest();
		taskRequest.setCandidateGroups(candidateGroups);
		if (unassigned) {
			taskRequest.setUnassigned(Boolean.TRUE);
		}

		if (!StringUtil.isNull(codiceServizio)) {
			Variables variable1 = new Variables();
			variable1.setName(CustomProcessVariables.CODICE_SERVIZIO);
			variable1.setOperator(Operator.EQ.getValue());
			variable1.setValue(codiceServizio);

			Variables[] processVariables = { variable1 };
			taskRequest.setProcessVariables(processVariables);
		}

		String url = taskUrl() + "/count";

		ResponseEntity<CountResponse> responseEntity = getRestTemplate().postForEntity(url, taskRequest, CountResponse.class);
		return responseEntity.getBody().getCount();
	}

	@Override
	public List<Task> getTasksByCandidateGroupsAndCodiceServizio(String[] candidateGroups, String codiceServizio, boolean unassigned) throws CamundaApiException {

		TaskRequest taskRequest = new TaskRequest();
		taskRequest.setCandidateGroups(candidateGroups);
		if (unassigned) {
			taskRequest.setUnassigned(Boolean.TRUE);
		}

		if (!StringUtil.isNull(codiceServizio)) {
			Variables variable1 = new Variables();
			variable1.setName(CustomProcessVariables.CODICE_SERVIZIO);
			variable1.setOperator(Operator.EQ.getValue());
			variable1.setValue(codiceServizio);

			Variables[] processVariables = { variable1 };
			taskRequest.setProcessVariables(processVariables);
		}

		String url = taskUrl();

		ResponseEntity<Task[]> responseEntity = getRestTemplate().postForEntity(url, taskRequest, Task[].class);
		return asList(responseEntity.getBody());
	}

	@Override
	public List<Task> getTasksByAssigneeAndCodiceServizio(String assignee, String codiceServizio) throws CamundaApiException {

		TaskRequest taskRequest = new TaskRequest();
		if (!StringUtil.isNull(assignee)) {
			taskRequest.setAssignee(assignee.toUpperCase());
		}

		if (!StringUtil.isNull(codiceServizio)) {
			Variables variable1 = new Variables();
			variable1.setName(CustomProcessVariables.CODICE_SERVIZIO);
			variable1.setOperator(Operator.EQ.getValue());
			variable1.setValue(codiceServizio);

			Variables[] processVariables = { variable1 };
			taskRequest.setProcessVariables(processVariables);
		}

		String url = taskUrl();

		ResponseEntity<Task[]> responseEntity = getRestTemplate().postForEntity(url, taskRequest, Task[].class);
		return asList(responseEntity.getBody());
	}

	@Override
	public long countTasksByAssigneeAndCodiceServizio(String assignee, String codiceServizio) throws CamundaApiException {

		TaskRequest taskRequest = new TaskRequest();
		if (!StringUtil.isNull(assignee)) {
			taskRequest.setAssignee(assignee.toUpperCase());
		}

		if (!StringUtil.isNull(codiceServizio)) {
			Variables variable1 = new Variables();
			variable1.setName(CustomProcessVariables.CODICE_SERVIZIO);
			variable1.setOperator(Operator.EQ.getValue());
			variable1.setValue(codiceServizio);

			Variables[] processVariables = { variable1 };
			taskRequest.setProcessVariables(processVariables);
		}

		String url = taskUrl() + "/count";

		ResponseEntity<CountResponse> responseEntity = getRestTemplate().postForEntity(url, taskRequest, CountResponse.class);
		return responseEntity.getBody().getCount();
	}

	@Override
	public void completeTask(String taskId, List<Entry<String, String>> varialbles) {
		String url = taskUrl() + "/" + taskId + "/complete";

		LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> varPost = new LinkedHashMap<>();
		if (varialbles != null) {
			LinkedHashMap<String, LinkedHashMap<String, String>> varValue = new LinkedHashMap<>();
			for (Entry<String, String> entry : varialbles) {
				LinkedHashMap<String, String> valValue = new LinkedHashMap<>();
				valValue.put("value", entry.getValue() != null ? StringUtil.trimStr(entry.getValue()) : null);
				valValue.put("type", "string");

				varValue.put(StringUtil.trimStr(entry.getKey()), valValue);
			}

			varPost.put("variables", varValue);
		}

		ResponseEntity<Void> response = getRestTemplate().postForEntity(url, varPost, Void.class);
		if (response.getStatusCode().value() != 204) {
			throw new CamundaApiException("Errore di chiusura del task. HTTP Status: " + response.getStatusCode().value());
		}

		response.getBody();
	}

	@Override
	public boolean claim(String userId, String taskId) {
		String url = taskUrl() + "/" + taskId + "/claim";

		ClaimRequest request = new ClaimRequest();
		request.setUserId(userId);
		RestTemplate restTemplate = getRestTemplate();
		boolean out = false;
		try {
			ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
			out = response.getStatusCode().toString().equals("204");
		}
		catch (Exception e) {

		}

		return out;
	}

	@Override
	public boolean unclaim(String taskId) {
		String url = taskUrl() + "/" + taskId + "/unclaim";

		RestTemplate restTemplate = getRestTemplate();
		boolean out = false;
		try {
			ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);
			out = response.getStatusCode().toString().equals("204");
		}
		catch (Exception e) {

		}

		return out;
	}

	@Override
	public List<Variable> getVariablesByTaskId(String taskId) {
		String url = taskUrl() + "/" + taskId + "/variables";

		LinkedHashMap responseEntity = getRestTemplate().getForObject(url, LinkedHashMap.class);

		List<Variable> retVal = new ArrayList<Variable>();
		if (responseEntity == null && responseEntity.isEmpty()) {
			return retVal;
		}

		Iterator keysIt = responseEntity.keySet().iterator();
		while (keysIt.hasNext()) {
			Object key = keysIt.next();

			Variable var = new Variable();
			var.setName(String.valueOf(key));

			LinkedHashMap camVariableVar = (LinkedHashMap) responseEntity.get(key);
			var.setValue(camVariableVar.get("value"));

			retVal.add(var);
		}

		return retVal;
	}

	@Override
	public List<Task> getTasksByBusinessKey(long businessKey, boolean includeCandidateGroups) throws CamundaApiException {
		String url = taskUrl() + "?processInstanceBusinessKey=" + String.valueOf(businessKey);

		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<Task[]> responseEntity = restTemplate.getForEntity(url, Task[].class);

		if (responseEntity.getStatusCode().value() != 200) {
			throw new CamundaApiException("Errore di lettura dei dati del task. HTTP Status: " + responseEntity.getStatusCode().value());
		}

		// Valorizzo i candidtate groups
		List<Task> retVal = asList(responseEntity.getBody());
		for (Task task : retVal) {
			String tUrl = taskUrl() + "/" + task.getId() + "/identity-links";
			ResponseEntity<IdentityLink[]> respIdentity = restTemplate.getForEntity(tUrl, IdentityLink[].class);

			if (responseEntity.getStatusCode().value() != 200) {
				throw new CamundaApiException("Errore di lettura dei dati del task. HTTP Status: " + responseEntity.getStatusCode().value());
			}

			List<IdentityLink> listId = asList(respIdentity.getBody());
			List<String> listGroups = new ArrayList<String>();

			Iterator<IdentityLink> keysIt = listId.iterator();
			while (keysIt.hasNext()) {
				IdentityLink key = keysIt.next();
				if (key.getType().equalsIgnoreCase("candidate") && !StringUtil.isNull(key.getGroupId())) {
					listGroups.add(StringUtil.trimStr(key.getGroupId()));
				}
			}
			if (!listGroups.isEmpty()) {
				task.setCandidateGroups(listGroups.toArray(new String[listGroups.size()]));
			}
		}

		return retVal;
	}

	@Override
	public List<Task> getTasksByCandidateGroupsAndCodiceServizio(String[] candidateGroups, String codiceServizio, boolean unassigned, List<Variables> variables, Integer firstResult,
			Integer maxResults, String sortName, String sortOrder, String sortType) throws CamundaApiException {

		TaskRequest taskRequest = new TaskRequest();
		taskRequest.setCandidateGroups(candidateGroups);
		if (unassigned) {
			taskRequest.setUnassigned(Boolean.TRUE);
		}
		if (variables == null) {
			variables = new ArrayList<>();
		}

		if (!StringUtil.isNull(codiceServizio)) {
			Variables variable1 = new Variables();
			variable1.setName(CustomProcessVariables.CODICE_SERVIZIO);
			variable1.setOperator(Operator.EQ.getValue());
			variable1.setValue(codiceServizio);
			variables.add(variable1);
		}

		Variables[] processVariables = new Variables[variables.size()];
		variables.toArray(processVariables);

		taskRequest.setProcessVariables(processVariables);

		if (sortName != null && sortOrder != null && sortType != null) {
			Sort sort = new Sort();
			sort.setSortBy("processVariable");
			sort.setSortOrder(sortOrder);

			Parameters parameter = sort.new Parameters();
			parameter.setVariable(sortName);
			parameter.setType(sortType);

			sort.setParameters(parameter);

			taskRequest.setSorting(Arrays.asList(sort));
		}

		String url = taskUrl();
		if (firstResult != null && maxResults != null) {
			url += "?firstResult=" + firstResult + "&maxResults=" + maxResults;
		}

		ResponseEntity<Task[]> responseEntity = getRestTemplate().postForEntity(url, taskRequest, Task[].class);
		List<Task> asList = asList(responseEntity.getBody());
		return asList;
	}

	@Override
	public List<Task> getTasksByAssigneeAndCodiceServizio(String assignee, String codiceServizio, List<Variables> variables, Integer firstResult, Integer maxResults, String sortName, String sortOrder,
			String sortType) throws CamundaApiException {
		TaskRequest taskRequest = new TaskRequest();
		if (!StringUtil.isNull(assignee)) {
			taskRequest.setAssignee(assignee.toUpperCase());
		}

		if (variables == null) {
			variables = new ArrayList<>();
		}

		if (!StringUtil.isNull(codiceServizio)) {
			Variables variable1 = new Variables();
			variable1.setName(CustomProcessVariables.CODICE_SERVIZIO);
			variable1.setOperator(Operator.EQ.getValue());
			variable1.setValue(codiceServizio);

			variables.add(variable1);
		}

		Variables[] processVariables = new Variables[variables.size()];
		variables.toArray(processVariables);
		taskRequest.setProcessVariables(processVariables);

		if (sortName != null && sortOrder != null && sortType != null) {
			Sort sort = new Sort();
			sort.setSortBy("processVariable");
			sort.setSortOrder(sortOrder);

			Parameters parameter = sort.new Parameters();
			parameter.setVariable(sortName);
			parameter.setType(sortType);

			sort.setParameters(parameter);

			taskRequest.setSorting(Arrays.asList(sort));
		}

		String url = taskUrl();
		if (firstResult != null && maxResults != null) {
			url += "?firstResult=" + firstResult + "&maxResults=" + maxResults;
		}

		ResponseEntity<Task[]> responseEntity = getRestTemplate().postForEntity(url, taskRequest, Task[].class);
		return asList(responseEntity.getBody());
	}

	@Override
	public long countTasksByCandidateGroupsAndCodiceServizio(String[] candidateGroups, String codiceServizio, boolean unassigned, List<Variables> variables) throws CamundaApiException {

		TaskRequest taskRequest = new TaskRequest();
		taskRequest.setCandidateGroups(candidateGroups);
		if (unassigned) {
			taskRequest.setUnassigned(Boolean.TRUE);
		}

		if (variables == null) {
			variables = new ArrayList<>();
		}

		if (!StringUtil.isNull(codiceServizio)) {
			Variables variable1 = new Variables();
			variable1.setName(CustomProcessVariables.CODICE_SERVIZIO);
			variable1.setOperator(Operator.EQ.getValue());
			variable1.setValue(codiceServizio);

			variables.add(variable1);
		}

		Variables[] processVariables = new Variables[variables.size()];
		variables.toArray(processVariables);
		taskRequest.setProcessVariables(processVariables);

		String url = taskUrl() + "/count";

		ResponseEntity<CountResponse> responseEntity = getRestTemplate().postForEntity(url, taskRequest, CountResponse.class);
		return responseEntity.getBody().getCount();
	}

	@Override
	public long countTasksByAssigneeAndCodiceServizio(String assignee, String codiceServizio, List<Variables> variables) throws CamundaApiException {
		TaskRequest taskRequest = new TaskRequest();
		if (!StringUtil.isNull(assignee)) {
			taskRequest.setAssignee(assignee.toUpperCase());
		}

		if (variables == null) {
			variables = new ArrayList<>();
		}

		if (!StringUtil.isNull(codiceServizio)) {
			Variables variable1 = new Variables();
			variable1.setName(CustomProcessVariables.CODICE_SERVIZIO);
			variable1.setOperator(Operator.EQ.getValue());
			variable1.setValue(codiceServizio);

			variables.add(variable1);
		}

		Variables[] processVariables = new Variables[variables.size()];
		variables.toArray(processVariables);
		taskRequest.setProcessVariables(processVariables);

		String url = taskUrl() + "/count";

		ResponseEntity<CountResponse> responseEntity = getRestTemplate().postForEntity(url, taskRequest, CountResponse.class);
		return responseEntity.getBody().getCount();
	}
}
