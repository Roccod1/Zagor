package it.servizidigitali.camunda.integration.client.impl;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.camunda.community.rest.client.api.DeploymentApi;
import org.camunda.community.rest.client.api.GroupApi;
import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.api.ProcessInstanceApi;
import org.camunda.community.rest.client.api.TaskApi;
import org.camunda.community.rest.client.api.TenantApi;
import org.camunda.community.rest.client.api.UserApi;
import org.camunda.community.rest.client.api.VariableInstanceApi;
import org.camunda.community.rest.client.dto.CompleteTaskDto;
import org.camunda.community.rest.client.dto.CountResultDto;
import org.camunda.community.rest.client.dto.DeploymentDto;
import org.camunda.community.rest.client.dto.DeploymentResourceDto;
import org.camunda.community.rest.client.dto.DeploymentWithDefinitionsDto;
import org.camunda.community.rest.client.dto.GroupDto;
import org.camunda.community.rest.client.dto.PatchVariablesDto;
import org.camunda.community.rest.client.dto.ProcessDefinitionDto;
import org.camunda.community.rest.client.dto.ProcessInstanceDto;
import org.camunda.community.rest.client.dto.ProcessInstanceQueryDto;
import org.camunda.community.rest.client.dto.ProcessInstanceWithVariablesDto;
import org.camunda.community.rest.client.dto.SortTaskQueryParametersDto;
import org.camunda.community.rest.client.dto.StartProcessInstanceDto;
import org.camunda.community.rest.client.dto.TaskDto;
import org.camunda.community.rest.client.dto.TaskQueryDto;
import org.camunda.community.rest.client.dto.TaskQueryDtoSorting;
import org.camunda.community.rest.client.dto.TenantDto;
import org.camunda.community.rest.client.dto.UserDto;
import org.camunda.community.rest.client.dto.UserIdDto;
import org.camunda.community.rest.client.dto.UserProfileDto;
import org.camunda.community.rest.client.dto.VariableInstanceDto;
import org.camunda.community.rest.client.dto.VariableInstanceQueryDto;
import org.camunda.community.rest.client.dto.VariableQueryParameterDto;
import org.camunda.community.rest.client.dto.VariableValueDto;
import org.camunda.community.rest.client.invoker.ApiClient;
import org.camunda.community.rest.client.invoker.ApiException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.camunda.integration.client.constant.CustomProcessVariables;
import it.servizidigitali.camunda.integration.client.exception.CamundaClientException;
import it.servizidigitali.camunda.integration.client.model.DeploymentResource;
import it.servizidigitali.camunda.integration.client.model.ProcessDefinition;
import it.servizidigitali.camunda.integration.client.model.ProcessInstance;
import it.servizidigitali.camunda.integration.client.model.Task;
import it.servizidigitali.camunda.integration.client.model.VariableInstance;
import it.servizidigitali.camunda.integration.configuration.CamundaConfiguration;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * @author pindi
 * @author pascal
 *
 */
@Component(name = "camundaClientImpl", immediate = true, service = CamundaClient.class, configurationPid = "it.servizidigitali.camunda.integration.configuration.CamundaConfiguration")
public class CamundaClientImpl implements CamundaClient {

	private static final String DEFAULT_CAMUNDA_DEPLOYMENT_NAME = "default";

	private static final Log log = LogFactoryUtil.getLog(CamundaClientImpl.class.getName());

	private volatile CamundaConfiguration camundaConfiguration;

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

	private String apiBasePath;
	private String username;
	private String password;
	private boolean integrationEnabled;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		camundaConfiguration = ConfigurableUtil.createConfigurable(CamundaConfiguration.class, props);
		apiBasePath = camundaConfiguration.apiBasePath();
		username = camundaConfiguration.apiUsername();
		password = camundaConfiguration.apiPassword();
		integrationEnabled = camundaConfiguration.integrationEnabled();
	}

	private ApiClient getApiClient() {

		if (!integrationEnabled) {
			throw new CamundaClientException("Integrazione con Camunda BPMN Engine disabilitata.");
		}

		OkHttpClient httpClient = new OkHttpClient.Builder().authenticator(new Authenticator() {

			@Override
			public Request authenticate(Route route, Response response) throws IOException {
				String credential = Credentials.basic(username, password);
				return response.request().newBuilder().header("Authorization", credential).build();
			}
		}).build();

		ApiClient client = new ApiClient(httpClient);
		client.setBasePath(apiBasePath);

		return client;
	}

	@Override
	public List<ProcessDefinition> getProcessDefinitions(String tenantId) throws CamundaClientException {

		ProcessDefinitionApi api = new ProcessDefinitionApi(getApiClient());
		try {

			List<ProcessDefinitionDto> processDefinitions = api.getProcessDefinitions(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
					null, null, null, null, tenantId, null, null, null, null, null, null, null, null, null, null, null, null);
			return getProcessDefinitions(processDefinitions);
		}
		catch (ApiException e) {
			log.error("getProcessDefinitions: " + e.getResponseBody(), e);
			throw new CamundaClientException("getProcessDefinitions :: " + e.getResponseBody(), e);
		}
	}

	/**
	 * @param processDefinitionsDto
	 * @return
	 */
	private List<ProcessDefinition> getProcessDefinitions(List<ProcessDefinitionDto> processDefinitionsDto) {
		if (processDefinitionsDto == null) {
			return null;
		}
		List<ProcessDefinition> processDefinitions = new ArrayList<ProcessDefinition>();
		for (ProcessDefinitionDto processDefinitionDto : processDefinitionsDto) {
			ProcessDefinition processDefinition = new ProcessDefinition();
			BeanPropertiesUtil.copyProperties(processDefinitionDto, processDefinition);
			processDefinitions.add(processDefinition);
		}
		return processDefinitions;
	}

	@Override
	public List<VariableInstance> getVariablesByExecutionId(String tenantId, String executionId) throws CamundaClientException {
		VariableInstanceApi api = new VariableInstanceApi(getApiClient());
		try {
			VariableInstanceQueryDto q = new VariableInstanceQueryDto();
			q.setExecutionIdIn(Arrays.asList(new String[] { executionId }));

			if (Validator.isNotNull(tenantId)) {
				q.setTenantIdIn(Arrays.asList(tenantId));
			}

			List<VariableInstanceDto> queryVariableInstances = api.queryVariableInstances(null, null, null, q);
			return getVariableInstances(queryVariableInstances);

		}
		catch (ApiException e) {
			log.error("getVariablesByTaskId: " + e.getResponseBody(), e);
			throw new CamundaClientException("getVariablesByTaskId :: " + e.getResponseBody(), e);
		}
	}

	/**
	 * @param queryVariableInstancesDto
	 * @return
	 */
	private List<VariableInstance> getVariableInstances(List<VariableInstanceDto> queryVariableInstancesDto) {
		if (queryVariableInstancesDto == null) {
			return null;
		}
		List<VariableInstance> variableInstances = new ArrayList<VariableInstance>();
		for (VariableInstanceDto variableInstanceDto : queryVariableInstancesDto) {
			VariableInstance variableInstance = new VariableInstance();
			BeanPropertiesUtil.copyProperties(variableInstanceDto, variableInstance);
			variableInstances.add(variableInstance);

		}
		return variableInstances;
	}

	@Override
	public List<Task> getTasksByBusinessKey(String tenantId, String businessKey, boolean includeCandidateGroups) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = new TaskQueryDto();
			q.setProcessInstanceBusinessKey(businessKey);
			q.setWithCandidateGroups(includeCandidateGroups);

			if (Validator.isNotNull(tenantId)) {
				q.setTenantIdIn(Arrays.asList(tenantId));
			}

			List<TaskDto> queryTasks = api.queryTasks(null, null, q);
			return getTasks(queryTasks);
		}
		catch (ApiException e) {
			log.error("getTasksByBusinessKey: " + e.getResponseBody(), e);
			throw new CamundaClientException("getTasksByBusinessKey :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public boolean existProcessByBusinessKey(String tenantId, String businessKey) {
		ProcessInstanceApi api = new ProcessInstanceApi(getApiClient());

		try {
			ProcessInstanceQueryDto q = new ProcessInstanceQueryDto();
			q.setBusinessKey(businessKey);

			if (Validator.isNotNull(tenantId)) {
				q.setTenantIdIn(Arrays.asList(tenantId));
			}

			CountResultDto count = api.queryProcessInstancesCount(q);

			return count.getCount().compareTo(0L) > 0;

		}
		catch (ApiException e) {
			log.error("existProcessByBusinessKey: " + e.getResponseBody(), e);
			throw new CamundaClientException("existProcessByBusinessKey :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public String startProcessInstance(String tenantId, String processDefinitionKey, String businessKey, Map<String, Object> variables) {
		ProcessDefinitionApi api = new ProcessDefinitionApi(getApiClient());

		try {
			StartProcessInstanceDto startProcessInstanceDto = new StartProcessInstanceDto();
			startProcessInstanceDto.setBusinessKey(businessKey);

			if (variables != null) {
				Map<String, VariableValueDto> variablesMap = new HashMap<String, VariableValueDto>();
				for (Entry<String, Object> entry : variables.entrySet()) {
					String key = entry.getKey();
					Object value = entry.getValue();

					VariableValueDto variableValueDto = new VariableValueDto();
					if (value instanceof Date) {
						value = simpleDateFormat.format(value);
						variableValueDto.setType("date");
					}
					else {
						variableValueDto.setType(value.getClass().getSimpleName().toLowerCase());
					}
					variableValueDto.setValue(value);

					variablesMap.put(key, variableValueDto);
				}

				// Add tenant ID
				if (tenantId != null) {
					VariableValueDto tenantIdVariableValueDto = new VariableValueDto();
					tenantIdVariableValueDto.setValue(tenantId);
					variablesMap.put("tenantId", tenantIdVariableValueDto);
				}

				startProcessInstanceDto.setVariables(variablesMap);
			}

			ProcessInstanceWithVariablesDto processInstanceWithVariablesDto = api.startProcessInstanceByKey(processDefinitionKey, startProcessInstanceDto);
			return processInstanceWithVariablesDto.getId();
		}
		catch (ApiException e) {
			log.error("startProcessInstance: " + e.getResponseBody(), e);
			throw new CamundaClientException("startProcessInstance :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public String insertOrUpdateProcessDefinitions(String tenantId, String fileName, byte[] byteArray) throws CamundaClientException {

		File file = null;
		File tempFolder = null;
		String deploymentId = "";
		DeploymentWithDefinitionsDto output = null;

		try {

			ApiClient client = getApiClient();

			String time = "_" + new Date().getTime();

			String suffix = ".bpmn";

			Path tempDirWithPrefix = Files.createTempDirectory(null);

			tempFolder = tempDirWithPrefix.toFile();

			Path path = Paths.get(tempDirWithPrefix.toString(), fileName + time + suffix);

			Path filePath = Files.write(path, byteArray);

			file = filePath.toFile();

			DeploymentApi deploymentApi = new DeploymentApi(client);
			output = deploymentApi.createDeployment(tenantId, null, false, false, "AutoDeployment", null, file);

			deploymentId = output.getId();

			log.debug("Created " + output.getId());

		}
		catch (ApiException e) {
			log.error("insertOrUpdateProcessDefinitions: " + e.getResponseBody(), e);
			throw new CamundaClientException("insertOrUpdateProcessDefinitions :: " + e.getResponseBody(), e);
		}
		catch (Exception e) {
			log.error("insertOrUpdateProcessDefinitions: " + e.getMessage(), e);
			throw new CamundaClientException("insertOrUpdateProcessDefinitions :: " + e.getMessage(), e);
		}
		finally {
			if (null != file) {
				file.delete();
			}
			if (null != tempFolder) {
				tempFolder.delete();
			}
		}

		return deploymentId;
	}

	@Override
	public long countTasks(String tenantId, List<String> candidateGroups, String codiceServizio, boolean unassigned) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, candidateGroups, codiceServizio, unassigned, null, null, null, null, null);

			CountResultDto count = api.queryTasksCount(q);
			return count.getCount();

		}
		catch (ApiException e) {
			log.error("countTasksByCandidateGroupsAndCodiceServizio: " + e.getResponseBody(), e);
			throw new CamundaClientException("countTasksByCandidateGroupsAndCodiceServizio :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public long countTasks(String tenantId, List<String> candidateGroups, String codiceServizio, boolean unassigned, List<VariableInstance> variables) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, candidateGroups, codiceServizio, unassigned, variables, null, null, null, null);

			CountResultDto count = api.queryTasksCount(q);

			return count.getCount();

		}
		catch (ApiException e) {
			log.error("countTasksByCandidateGroupsAndCodiceServizio: " + e.getResponseBody(), e);
			throw new CamundaClientException("countTasksByCandidateGroupsAndCodiceServizio :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public List<Task> searchTasks(String tenantId, List<String> candidateGroups, String codiceServizio, boolean unassigned) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, candidateGroups, codiceServizio, unassigned, null, null, null, null, null);

			List<TaskDto> queryTasks = api.queryTasks(null, null, q);
			return getTasks(queryTasks);

		}
		catch (ApiException e) {
			log.error("getTasksByCandidateGroupsAndCodiceServizio: " + e.getResponseBody(), e);
			throw new CamundaClientException("getTasksByCandidateGroupsAndCodiceServizio :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public List<Task> searchTasks(String tenantId, List<String> candidateGroups, String codiceServizio, boolean unassigned, List<VariableInstance> variables, Integer firstResult, Integer maxResults,
			String sortName, String sortOrder, String sortType) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, candidateGroups, codiceServizio, unassigned, null, sortName, sortOrder, sortType, null);

			List<TaskDto> queryTasks = api.queryTasks(firstResult, maxResults, q);
			return getTasks(queryTasks);

		}
		catch (ApiException e) {
			log.error("getTasksByCandidateGroupsAndCodiceServizio: " + e.getResponseBody(), e);
			throw new CamundaClientException("getTasksByCandidateGroupsAndCodiceServizio :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public List<Task> searchTasks(String tenantId, String assignee, String codiceServizio) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, null, codiceServizio, null, null, null, null, null, assignee);

			List<TaskDto> queryTasks = api.queryTasks(null, null, q);
			return getTasks(queryTasks);
		}
		catch (ApiException e) {
			log.error("getTasksByAssigneeAndCodiceServizio: " + e.getResponseBody(), e);
			throw new CamundaClientException("getTasksByAssigneeAndCodiceServizio :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public List<Task> searchTasks(String tenantId, String assignee, String codiceServizio, List<VariableInstance> variables, Integer firstResult, Integer maxResults, String sortName, String sortOrder,
			String sortType) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, null, codiceServizio, null, variables, sortName, sortOrder, sortType, assignee);

			List<TaskDto> queryTasks = api.queryTasks(firstResult, maxResults, q);
			return getTasks(queryTasks);

		}
		catch (ApiException e) {
			log.error("getTasksByAssigneeAndCodiceServizio: " + e.getResponseBody(), e);
			throw new CamundaClientException("getTasksByAssigneeAndCodiceServizio :: " + e.getResponseBody(), e);
		}
	}

	/**
	 * @param queryTasks
	 * @return
	 */
	private List<Task> getTasks(List<TaskDto> queryTasks) {

		if (queryTasks == null) {
			return null;
		}
		List<Task> tasks = new ArrayList<Task>();
		for (TaskDto taskDto : queryTasks) {
			Task task = new Task();
			BeanPropertiesUtil.copyProperties(taskDto, task);
			tasks.add(task);
		}
		return tasks;
	}

	@Override
	public long countTasks(String tenantId, String assignee, String codiceServizio) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, null, codiceServizio, null, null, null, null, null, assignee);

			CountResultDto count = api.queryTasksCount(q);
			return count.getCount();

		}
		catch (ApiException e) {
			log.error("countTasksByAssigneeAndCodiceServizio: " + e.getResponseBody(), e);
			throw new CamundaClientException("countTasksByAssigneeAndCodiceServizio :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public long countTasks(String tenantId, String assignee, String codiceServizio, List<VariableInstance> variables) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, null, codiceServizio, null, variables, null, null, null, assignee);

			CountResultDto count = api.queryTasksCount(q);
			return count.getCount();

		}
		catch (ApiException e) {
			log.error("countTasksByAssigneeAndCodiceServizio: " + e.getResponseBody(), e);
			throw new CamundaClientException("countTasksByAssigneeAndCodiceServizio :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public ProcessInstance getProcessInstance(String id) throws CamundaClientException {
		ProcessInstanceApi api = new ProcessInstanceApi(getApiClient());

		try {

			ProcessInstanceDto processInstanceDto = api.getProcessInstance(id);

			return getProcessInstance(processInstanceDto);

		}
		catch (ApiException e) {
			log.error("getProcessInstance: " + e.getResponseBody(), e);
			throw new CamundaClientException("getProcessInstance :: " + e.getResponseBody(), e);
		}
	}

	/**
	 * @param processInstanceDto
	 * @return
	 */
	private ProcessInstance getProcessInstance(ProcessInstanceDto processInstanceDto) {
		if (processInstanceDto != null) {
			ProcessInstance processInstance = new ProcessInstance();
			BeanPropertiesUtil.copyProperties(processInstanceDto, processInstance);
			return processInstance;
		}
		return null;
	}

	@Override
	public boolean claim(String userId, String taskId) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {
			UserIdDto u = new UserIdDto();
			u.setUserId(userId);
			api.claim(taskId, u);
			return true;

		}
		catch (ApiException e) {
			log.error("claim: " + e.getResponseBody(), e);
			throw new CamundaClientException("claim :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public boolean unclaim(String taskId) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {
			api.unclaim(taskId);
			return true;

		}
		catch (ApiException e) {
			log.error("unclaim: " + e.getResponseBody(), e);
			throw new CamundaClientException("unclaim :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public void completeTask(String taskId, List<Entry<String, String>> variables) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {
			CompleteTaskDto d = new CompleteTaskDto();

			if (null != variables) {
				for (Entry<String, String> entry : variables) {

					VariableValueDto value = new VariableValueDto();
					value.setValue(entry.getValue());
					value.setType("string");

					d.putVariablesItem(entry.getKey(), value);
				}
			}

			api.complete(taskId, d);

		}
		catch (ApiException e) {
			log.error("completeTask: " + e.getResponseBody(), e);
			throw new CamundaClientException("completeTask :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public List<ProcessInstance> getProcessInstanceByBusinessKey(String tenantId, String businessKey) throws CamundaClientException {
		ProcessInstanceApi api = new ProcessInstanceApi(getApiClient());

		try {

			ProcessInstanceQueryDto processInstanceQueryDto = new ProcessInstanceQueryDto();
			processInstanceQueryDto.setBusinessKey(businessKey);

			if (Validator.isNotNull(tenantId)) {
				processInstanceQueryDto.setTenantIdIn(Arrays.asList(tenantId));
			}

			List<ProcessInstanceDto> res = api.queryProcessInstances(null, null, processInstanceQueryDto);

			return getProcessInstances(res);

		}
		catch (ApiException e) {
			log.error("getProcessInstanceByBusinessKey: " + e.getResponseBody(), e);
			throw new CamundaClientException("getProcessInstanceByBusinessKey :: " + e.getResponseBody(), e);
		}
	}

	/**
	 * @param processInstancesDto
	 * @return
	 */
	private List<ProcessInstance> getProcessInstances(List<ProcessInstanceDto> processInstancesDto) {
		if (processInstancesDto == null) {
			return null;
		}

		List<ProcessInstance> processInstances = new ArrayList<ProcessInstance>();
		for (ProcessInstanceDto processInstanceDto : processInstancesDto) {
			ProcessInstance processInstance = new ProcessInstance();
			BeanPropertiesUtil.copyProperties(processInstanceDto, processInstance);
			processInstances.add(processInstance);
		}
		return processInstances;
	}

	@Override
	public void updateProcessInstanceVariableByBusinessKey(String processId, String variableName, String variableValue, String variableType) throws CamundaClientException {
		ProcessInstanceApi api = new ProcessInstanceApi(getApiClient());

		try {

			PatchVariablesDto d = new PatchVariablesDto();

			VariableValueDto dv = new VariableValueDto();
			dv.setType(variableType);
			dv.setValue(variableValue);
			d.putModificationsItem(variableName, dv);

			api.modifyProcessInstanceVariables(processId, d);

		}
		catch (ApiException e) {
			log.error("updateProcessInstanceVariableByBusinessKey: " + e.getResponseBody(), e);
			throw new CamundaClientException("updateProcessInstanceVariableByBusinessKey :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public long countTasks(String tenantId, String codiceIpa, String codiceServizio, boolean unassigned) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			List<VariableInstance> variables = new ArrayList<>();
			VariableInstance d = new VariableInstance();
			d.setName(CustomProcessVariables.CODICE_IPA_COMUNE);
			d.setValue(codiceIpa);
			variables.add(d);

			TaskQueryDto q = getTaskQueryDto(tenantId, null, codiceServizio, unassigned, variables, null, null, null, null);

			CountResultDto count = api.queryTasksCount(q);
			return count.getCount();

		}
		catch (ApiException e) {
			log.error("countTasksByCodiceIpaComuneAndCodiceServizio: " + e.getResponseBody(), e);
			throw new CamundaClientException("countTasksByCodiceIpaComuneAndCodiceServizio :: " + e.getResponseBody(), e);
		}
	}

	private TaskQueryDto getTaskQueryDto(String tenantId, List<String> candidateGroups, String codiceServizio, Boolean unassigned, List<VariableInstance> variables, String sortName, String sortOrder,
			String sortType, String assignee) {
		TaskQueryDto q = new TaskQueryDto();

		if (Validator.isNotNull(unassigned) && unassigned) {
			q.setUnassigned(Boolean.TRUE);
		}

		if (Validator.isNotNull(tenantId)) {
			q.setTenantIdIn(Arrays.asList(tenantId));
		}

		if (null != candidateGroups && !candidateGroups.isEmpty()) {
			q.setCandidateGroups(candidateGroups);
		}

		List<VariableQueryParameterDto> vqs = new ArrayList<>();

		if (Validator.isNotNull(variables)) {
			for (VariableInstance v : variables) {
				VariableQueryParameterDto vq = new VariableQueryParameterDto();
				vq.setName(v.getName());
				vq.setValue(v.getValue());
				vq.setOperator(VariableQueryParameterDto.OperatorEnum.EQ);

				vqs.add(vq);
			}
		}

		if (Validator.isNotNull(codiceServizio)) {
			VariableQueryParameterDto vq = new VariableQueryParameterDto();
			vq.setName(CustomProcessVariables.CODICE_SERVIZIO);
			vq.setValue(codiceServizio);
			vq.setOperator(VariableQueryParameterDto.OperatorEnum.EQ);
			vqs.add(vq);
		}

		if (!vqs.isEmpty()) {
			q.setProcessVariables(vqs);
		}

		if (Validator.isNotNull(sortName) && Validator.isNotNull(sortOrder) && Validator.isNotNull(sortType)) {

			TaskQueryDtoSorting sort = new TaskQueryDtoSorting();
			sort.setSortBy(TaskQueryDtoSorting.SortByEnum.PROCESSVARIABLE);
			sort.setSortOrder(TaskQueryDtoSorting.SortOrderEnum.fromValue(sortOrder));

			SortTaskQueryParametersDto p = new SortTaskQueryParametersDto();
			p.setVariable(sortName);
			p.setType(sortType);

			sort.setParameters(p);

			q.setSorting(Arrays.asList(sort));
		}

		if (Validator.isNotNull(assignee)) {
			q.setAssignee(assignee);
		}

		return q;
	}

	@Override
	public File getDeploymentFile(String id, String resourceId) throws CamundaClientException {

		File output = null;

		try {
			ApiClient client = getApiClient();
			DeploymentApi deploymentApi = new DeploymentApi(client);
			if (resourceId != null) {
				output = deploymentApi.getDeploymentResourceData(id, resourceId);
			}
			else {
				List<DeploymentResourceDto> listResource = deploymentApi.getDeploymentResources(id);
				output = deploymentApi.getDeploymentResourceData(id, listResource.get(0).getId());
			}
		}
		catch (ApiException e) {
			log.error("getDeploymentFile: " + e.getResponseBody(), e);
			throw new CamundaClientException("getDeploymentFile :: " + e.getResponseBody(), e);
		}

		return output;
	}

	@Override
	public void insertOrUpdateTenant(String tenantId, String tenantName) {

		try {
			ApiClient client = getApiClient();

			TenantDto tenantDto = new TenantDto();
			tenantDto.setId(tenantId);
			tenantDto.setName(tenantName);

			TenantApi tenantApi = new TenantApi(client);

			TenantDto tenant = null;
			try {
				tenant = tenantApi.getTenant(tenantId);
			}
			catch (Exception e) {
				log.warn("insertOrUpdateTenant :: " + e.getMessage());
			}
			if (tenant == null) {
				tenantApi.createTenant(tenantDto);
			}
			else {
				tenantApi.updateTenant(tenantId, tenantDto);
			}
		}
		catch (ApiException e) {
			log.error("insertOrUpdateTenand: " + e.getResponseBody(), e);
			throw new CamundaClientException("insertOrUpdateTenand :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public void deleteTenant(String tenantId) {
		try {
			ApiClient client = getApiClient();
			TenantApi tenantApi = new TenantApi(client);
			tenantApi.deleteTenant(tenantId);
		}
		catch (ApiException e) {
			log.error("deleteTenant: " + e.getResponseBody(), e);
			throw new CamundaClientException("deleteTenant :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public void inserOrUpdateGroup(String groupId, String groupName, String groupType) {

		try {
			ApiClient client = getApiClient();
			GroupApi groupApi = new GroupApi(client);

			GroupDto group = null;
			try {
				group = groupApi.getGroup(groupId);
			}
			catch (Exception e) {
				log.warn("inserOrUpdateGroup :: " + e.getMessage());
			}
			if (group == null) {
				GroupDto groupDto = new GroupDto();
				groupDto.setId(groupId);
				groupDto.setName(groupName);
				groupDto.setType(groupType);
				groupApi.createGroup(groupDto);
			}
			else {
				GroupDto groupDto = new GroupDto();
				groupDto.setId(groupId);
				groupDto.setName(groupName);
				groupDto.setType(groupType);
				groupApi.updateGroup(groupId, groupDto);

			}
		}
		catch (ApiException e) {
			log.error("inserOrUpdateGroup: " + e.getResponseBody(), e);
			throw new CamundaClientException("inserOrUpdateGroup :: " + e.getResponseBody(), e);
		}

	}

	@Override
	public void deleteGroup(String groupId) {

		try {
			ApiClient client = getApiClient();
			GroupApi groupApi = new GroupApi(client);
			groupApi.deleteGroup(groupId);
		}
		catch (ApiException e) {
			log.error("startProcessInstance: " + e.getResponseBody(), e);
			throw new CamundaClientException("startProcessInstance :: " + e.getResponseBody(), e);
		}

	}

	@Override
	public void inserOrUpdateUser(String userId, String firstName, String lastName, String email, String password) {

		try {
			ApiClient client = getApiClient();
			UserApi userApi = new UserApi(client);

			UserProfileDto userProfileDto = null;
			try {
				userProfileDto = userApi.getUserProfile(userId);
			}
			catch (Exception e) {
				log.warn("inserOrUpdateUser :: " + e.getMessage());
			}
			if (userProfileDto == null) {
				UserProfileDto userProfileDto2 = new UserProfileDto();
				userProfileDto2.setId(userId);
				userProfileDto2.setFirstName(firstName);
				userProfileDto2.setLastName(lastName);
				userProfileDto2.setEmail(email);
				UserDto userDto = new UserDto();
				userDto.setProfile(userProfileDto2);
				userApi.createUser(userDto);
			}
			else {
				userProfileDto.setId(userId);
				userProfileDto.setFirstName(firstName);
				userProfileDto.setLastName(lastName);
				userProfileDto.setEmail(email);
				userApi.updateProfile(userId, userProfileDto);
			}
		}
		catch (ApiException e) {
			log.error("inserOrUpdateUser: " + e.getResponseBody(), e);
			throw new CamundaClientException("inserOrUpdateUser :: " + e.getResponseBody(), e);
		}

	}

	@Override
	public void deleteUser(String userId) {
		try {
			ApiClient client = getApiClient();
			UserApi userApi = new UserApi(client);
			userApi.deleteUser(userId);
		}
		catch (ApiException e) {
			log.error("deleteUser: " + e.getResponseBody(), e);
			throw new CamundaClientException("deleteUser :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public void addUserToGroup(String groupId, String userId) {
		try {
			ApiClient client = getApiClient();
			GroupApi groupApi = new GroupApi(client);
			groupApi.createGroupMember(groupId, userId);
		}
		catch (ApiException e) {
			log.error("addUserToGroup: " + e.getResponseBody(), e);
			throw new CamundaClientException("addUserToGroup :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public void removeUserFromGroup(String groupId, String userId) {
		try {
			ApiClient client = getApiClient();
			GroupApi groupApi = new GroupApi(client);
			groupApi.deleteGroupMember(groupId, userId);
		}
		catch (ApiException e) {
			log.error("removeUserFromGroup: " + e.getResponseBody(), e);
			throw new CamundaClientException("removeUserFromGroup :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public void addGroupToTenant(String tenantId, String groupId) {
		try {
			ApiClient client = getApiClient();
			TenantApi tenantApi = new TenantApi(client);
			tenantApi.createGroupMembership(tenantId, groupId);
		}
		catch (ApiException e) {
			log.error("addGroupToTenant :: " + e.getMessage(), e);
			throw new CamundaClientException("addGroupToTenant :: " + e.getMessage(), e);
		}
	}

	@Override
	public void removeGroupFromTenant(String tenantId, String groupId) {
		try {
			ApiClient client = getApiClient();
			TenantApi tenantApi = new TenantApi(client);
			tenantApi.deleteGroupMembership(tenantId, groupId);
		}
		catch (ApiException e) {
			log.error("startProcessInstance: " + e.getResponseBody(), e);
			throw new CamundaClientException("startProcessInstance :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public void addUserToTenant(String tenantId, String userId) {
		try {
			ApiClient client = getApiClient();
			TenantApi tenantApi = new TenantApi(client);
			tenantApi.createUserMembership(tenantId, userId);
		}
		catch (ApiException e) {
			log.error("addUserToTenant: " + e.getResponseBody(), e);
			throw new CamundaClientException("addUserToTenant :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public void removeUserFromTenant(String tenantId, String userId) {
		try {
			ApiClient client = getApiClient();
			TenantApi tenantApi = new TenantApi(client);
			tenantApi.deleteUserMembership(tenantId, userId);
		}
		catch (ApiException e) {
			log.error("removeUserFromTenant: " + e.getResponseBody(), e);
			throw new CamundaClientException("removeUserFromTenant :: " + e.getResponseBody(), e);
		}
	}

	@Override
	public boolean existsGroup(String groupId) {

		ApiClient client = getApiClient();
		GroupApi groupApi = new GroupApi(client);

		GroupDto group = null;
		try {
			group = groupApi.getGroup(groupId);
		}
		catch (Exception e) {
			log.warn("existsGroup :: " + e.getMessage());
		}
		return group != null;
	}

	@Override
	public List<DeploymentResource> getDefaultDeploymentResources() throws CamundaClientException {

		try {
			ApiClient client = getApiClient();
			DeploymentApi deploymentApi = new DeploymentApi(client);
			List<DeploymentDto> deployments = deploymentApi.getDeployments(null, DEFAULT_CAMUNDA_DEPLOYMENT_NAME, null, null, null, null, null, null, null, null, null, null, null, null);
			if (deployments != null && !deployments.isEmpty()) {
				DeploymentDto deploymentDto = deployments.get(0);
				List<DeploymentResourceDto> deploymentResources = deploymentApi.getDeploymentResources(deploymentDto.getId());
				List<DeploymentResource> resources = new ArrayList<DeploymentResource>();
				if (deploymentResources != null) {
					ProcessDefinitionApi processDefinitionApi = new ProcessDefinitionApi(getApiClient());

					for (DeploymentResourceDto deploymentResourceDto : deploymentResources) {
						DeploymentResource deploymentResource = new DeploymentResource();
						BeanPropertiesUtil.copyProperties(deploymentResourceDto, deploymentResource);

						// Process Definition
						List<ProcessDefinitionDto> processDefinitions = processDefinitionApi.getProcessDefinitions(null, null, null, null, deploymentResource.getDeploymentId(), null, null, null, null,
								null, null, null, null, null, deploymentResource.getName(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null);
						if (processDefinitions != null && !processDefinitions.isEmpty()) {
							deploymentResource.setProcessDefinition(getProcessDefinitions(processDefinitions).get(0));
						}
						resources.add(deploymentResource);
					}
				}
				return resources;
			}
		}
		catch (ApiException e) {
			log.error("getDefaultDeploymentResources: " + e.getResponseBody(), e);
			throw new CamundaClientException("getDefaultDeploymentResources :: " + e.getResponseBody(), e);
		}
		return null;
	}

	@Override
	public List<DeploymentResource> getDeploymentResources(String deploymentId) throws CamundaClientException {

		try {
			ApiClient client = getApiClient();
			DeploymentApi deploymentApi = new DeploymentApi(client);
			DeploymentDto deploymentDto = deploymentApi.getDeployment(deploymentId);
			List<DeploymentResourceDto> deploymentResources = deploymentApi.getDeploymentResources(deploymentDto.getId());
			List<DeploymentResource> resources = new ArrayList<DeploymentResource>();
			if (deploymentResources != null) {
				ProcessDefinitionApi processDefinitionApi = new ProcessDefinitionApi(getApiClient());

				for (DeploymentResourceDto deploymentResourceDto : deploymentResources) {
					DeploymentResource deploymentResource = new DeploymentResource();
					BeanPropertiesUtil.copyProperties(deploymentResourceDto, deploymentResource);

					// Process Definition
					List<ProcessDefinitionDto> processDefinitions = processDefinitionApi.getProcessDefinitions(null, null, null, null, deploymentResource.getDeploymentId(), null, null, null, null,
							null, null, null, null, null, deploymentResource.getName(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null);
					if (processDefinitions != null && !processDefinitions.isEmpty()) {
						deploymentResource.setProcessDefinition(getProcessDefinitions(processDefinitions).get(0));
					}
					resources.add(deploymentResource);
				}
			}
			return resources;
		}
		catch (ApiException e) {
			log.error("getDeploymentResources: " + e.getResponseBody(), e);
			throw new CamundaClientException("getDeploymentResources :: " + e.getResponseBody(), e);
		}
	}
}
