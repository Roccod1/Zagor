package it.servizidigitali.camunda.integration.client.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.camunda.community.rest.client.api.DeploymentApi;
import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.api.ProcessInstanceApi;
import org.camunda.community.rest.client.api.TaskApi;
import org.camunda.community.rest.client.api.VariableInstanceApi;
import org.camunda.community.rest.client.dto.CompleteTaskDto;
import org.camunda.community.rest.client.dto.CountResultDto;
import org.camunda.community.rest.client.dto.DeploymentWithDefinitionsDto;
import org.camunda.community.rest.client.dto.PatchVariablesDto;
import org.camunda.community.rest.client.dto.ProcessDefinitionDto;
import org.camunda.community.rest.client.dto.ProcessInstanceDto;
import org.camunda.community.rest.client.dto.ProcessInstanceQueryDto;
import org.camunda.community.rest.client.dto.SortTaskQueryParametersDto;
import org.camunda.community.rest.client.dto.TaskDto;
import org.camunda.community.rest.client.dto.TaskQueryDto;
import org.camunda.community.rest.client.dto.TaskQueryDtoSorting;
import org.camunda.community.rest.client.dto.UserIdDto;
import org.camunda.community.rest.client.dto.VariableInstanceDto;
import org.camunda.community.rest.client.dto.VariableInstanceQueryDto;
import org.camunda.community.rest.client.dto.VariableQueryParameterDto;
import org.camunda.community.rest.client.dto.VariableValueDto;
import org.camunda.community.rest.client.invoker.ApiClient;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.camunda.integration.client.constant.CustomProcessVariables;
import it.servizidigitali.camunda.integration.client.exception.CamundaClientException;
import it.servizidigitali.camunda.integration.configuration.CamundaConfiguration;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

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
	
	private ApiClient getApiClient() {
		OkHttpClient httpClient = new OkHttpClient.Builder().authenticator(new Authenticator() {
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
	public List<ProcessDefinitionDto> getProcessDefinitions(String tenantId) throws CamundaClientException {
		
		ProcessDefinitionApi api = new ProcessDefinitionApi(getApiClient());

		try {

			return api.getProcessDefinitions(null, null, null, null, null, null, null, null, null, null, 
					null, null, null, null, null, null, null, null, 
					null, null, null, null, null, tenantId, null, 
					null, null, null, null, null, null, null, null, 
					null, null, null);

		}catch (Exception e) {
			log.error("getProcessDefinitions", e);
			throw new CamundaClientException("insertOrUpdateProcessDefinitions :: " + e.getMessage(), e);
		}
	}

	@Override
	public List<VariableInstanceDto> getVariablesByTaskId(String tenantId, String taskId) throws CamundaClientException {
		VariableInstanceApi api = new VariableInstanceApi(getApiClient());

		try {

			VariableInstanceQueryDto q = new VariableInstanceQueryDto();
			q.setTaskIdIn(Arrays.asList(new String[] {taskId}));

			if(Validator.isNotNull(tenantId)) {
				q.setTenantIdIn(Arrays.asList(tenantId));
			}
			
			return api.queryVariableInstances(null, null, null, q);

			// return api.getVariableInstances(null, null, null, null, null, null, taskId, null, null, null, null, null, null, null, null, null, null, null, null);

		}catch (Exception e) {
			log.error("getVariablesByTaskId", e);
			throw new CamundaClientException("getVariablesByTaskId :: " + e.getMessage(), e);
		}
	}

	@Override
	public List<TaskDto> getTasksByBusinessKey(String tenantId, long businessKey, boolean includeCandidateGroups) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = new TaskQueryDto();
			q.setProcessInstanceBusinessKey(String.valueOf(businessKey));
			q.setWithCandidateGroups(includeCandidateGroups);
			
			if(Validator.isNotNull(tenantId)) {
				q.setTenantIdIn(Arrays.asList(tenantId));
			}

			return api.queryTasks(null, null, q);

			//			return api.getTasks(null, null, null, null, String.valueOf(businessKey), null, null, null, null, null, null, null, null, null, null, null, null, null, 
			//					null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
			//					null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
			//					null, null, null, null, null, 
			//					null, null, null, null, null, null, null, 
			//					null, null, null, null, null, null, null, 
			//					null, null, null, null, null, includeCandidateGroups, null, null, null, 
			//					null, null, null, null, null, null, null, null, null, null, null, null);
		}catch (Exception e) {
			log.error("getTasksByBusinessKey", e);
			throw new CamundaClientException("getTasksByBusinessKey :: " + e.getMessage(), e);
		}
	}

	@Override
	public boolean existProcessByBusinessKey(String tenantId, long businessKey) {
		ProcessInstanceApi api = new ProcessInstanceApi(getApiClient());

		try {
			ProcessInstanceQueryDto q = new ProcessInstanceQueryDto();
			q.setBusinessKey(String.valueOf(businessKey));
			
			if(Validator.isNotNull(tenantId)) {
				q.setTenantIdIn(Arrays.asList(tenantId));
			}
			
			CountResultDto count = api.queryProcessInstancesCount(q);

			return count.getCount().compareTo(0L) > 0;

		}catch (Exception e) {
			log.error("existProcessByBusinessKey", e);
			throw new CamundaClientException("existProcessByBusinessKey :: " + e.getMessage(), e);
		}
	}

	@Override
	public void insertOrUpdateProcessDefinitions(String tenantId, byte[] byteArray) throws CamundaClientException {
		File tempFile = null;
		try {

			ApiClient client = getApiClient();

			String prefix = "process_" + new Date().getTime();
			// String prefix = "AutoDeployment";
			String suffix = ".bpmn";

			tempFile = File.createTempFile(prefix, suffix, null);
			FileOutputStream fos = new FileOutputStream(tempFile);
			fos.write(byteArray);

			DeploymentWithDefinitionsDto output = new DeploymentApi(client).createDeployment(tenantId, null, true, true, "AutoDeployment", null, tempFile);
			System.out.println("Created " + output.getId());

			fos.close();

		}catch (Exception e) {
			log.error("insertOrUpdateProcessDefinitions", e);;
			throw new CamundaClientException("insertOrUpdateProcessDefinitions :: " +e.getMessage() , e );
		} finally {
			if(null != tempFile) {
				tempFile.delete();
			}
		}
	}

	@Override
	public long countTasksByCandidateGroupsAndCodiceServizio(String tenantId, String[] candidateGroups, String codiceServizio, boolean unassigned) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, candidateGroups, codiceServizio, unassigned, null, null, null, null, null);

			CountResultDto count = api.queryTasksCount(q);
			return count.getCount();

		}catch (Exception e) {
			log.error("countTasksByCandidateGroupsAndCodiceServizio", e);
			throw new CamundaClientException("countTasksByCandidateGroupsAndCodiceServizio :: " + e.getMessage(), e);
		}
	}

	@Override
	public long countTasksByCandidateGroupsAndCodiceServizio(String tenantId, String[] candidateGroups, String codiceServizio, boolean unassigned, List<VariableInstanceDto> variables) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, candidateGroups, codiceServizio, unassigned, variables, null, null, null, null);

			CountResultDto count = api.queryTasksCount(q);

			return count.getCount();

		}catch (Exception e) {
			log.error("countTasksByCandidateGroupsAndCodiceServizio", e);
			throw new CamundaClientException("countTasksByCandidateGroupsAndCodiceServizio :: " + e.getMessage(), e);
		}
	}

	@Override
	public List<TaskDto> getTasksByCandidateGroupsAndCodiceServizio(String tenantId, String[] candidateGroups, String codiceServizio, boolean unassigned) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, candidateGroups, codiceServizio, unassigned, null, null, null, null, null);

			return api.queryTasks(null, null, q);

		}catch (Exception e) {
			log.error("getTasksByCandidateGroupsAndCodiceServizio", e);
			throw new CamundaClientException("getTasksByCandidateGroupsAndCodiceServizio :: " + e.getMessage(), e);
		}
	}

	@Override
	public List<TaskDto> getTasksByCandidateGroupsAndCodiceServizio(String tenantId, String[] candidateGroups, String codiceServizio, boolean unassigned, List<VariableInstanceDto> variables, Integer firstResult,
			Integer maxResults, String sortName, String sortOrder, String sortType) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, candidateGroups, codiceServizio, unassigned, null,  sortName, sortOrder, sortType, null);

			return api.queryTasks(firstResult, maxResults, q);

		}catch (Exception e) {
			log.error("getTasksByCandidateGroupsAndCodiceServizio", e);
			throw new CamundaClientException("getTasksByCandidateGroupsAndCodiceServizio :: " + e.getMessage(), e);
		}
	}

	@Override
	public List<TaskDto> getTasksByAssigneeAndCodiceServizio(String tenantId, String assignee, String codiceServizio) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, null, codiceServizio, null, null,  null, null, null, assignee);

			return api.queryTasks(null, null, q);

		}catch (Exception e) {
			log.error("getTasksByAssigneeAndCodiceServizio", e);
			throw new CamundaClientException("getTasksByAssigneeAndCodiceServizio :: " + e.getMessage(), e);
		}
	}

	@Override
	public List<TaskDto> getTasksByAssigneeAndCodiceServizio(String tenantId, String assignee, String codiceServizio, List<VariableInstanceDto> variables, Integer firstResult, Integer maxResults, String sortName,
			String sortOrder, String sortType) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, null, codiceServizio, null, variables, sortName, sortOrder, sortType, assignee);

			return api.queryTasks(firstResult, maxResults, q);

		}catch (Exception e) {
			log.error("getTasksByAssigneeAndCodiceServizio", e);
			throw new CamundaClientException("getTasksByAssigneeAndCodiceServizio :: " + e.getMessage(), e);
		}
	}

	@Override
	public long countTasksByAssigneeAndCodiceServizio(String tenantId, String assignee, String codiceServizio) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, null, codiceServizio, null, null, null, null, null, assignee);

			CountResultDto count = api.queryTasksCount(q);
			return count.getCount();

		}catch (Exception e) {
			log.error("countTasksByAssigneeAndCodiceServizio", e);
			throw new CamundaClientException("countTasksByAssigneeAndCodiceServizio :: " + e.getMessage(), e);
		}
	}

	@Override
	public long countTasksByAssigneeAndCodiceServizio(String tenantId, String assignee, String codiceServizio, List<VariableInstanceDto> variables) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			TaskQueryDto q = getTaskQueryDto(tenantId, null, codiceServizio, null, variables, null, null, null, assignee);

			CountResultDto count = api.queryTasksCount(q);
			return count.getCount();

		}catch (Exception e) {
			log.error("countTasksByAssigneeAndCodiceServizio", e);
			throw new CamundaClientException("countTasksByAssigneeAndCodiceServizio :: " + e.getMessage(), e);
		}
	}

	@Override
	public ProcessInstanceDto getProcessInstance(String id) throws CamundaClientException {
		ProcessInstanceApi api = new ProcessInstanceApi(getApiClient());

		try {

			return api.getProcessInstance(id);

		}catch (Exception e) {
			log.error("getProcessInstance", e);
			throw new CamundaClientException("getProcessInstance :: " + e.getMessage(), e);
		}
	}

	@Override
	public boolean claim(String userId, String taskId) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {
			UserIdDto u = new UserIdDto();
			u.setUserId(userId);
			api.claim(taskId, u);
			return true;

		}catch (Exception e) {
			log.error("claim", e);
			throw new CamundaClientException("claim :: " + e.getMessage(), e);
		}
	}

	@Override
	public boolean unclaim(String taskId) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {
			api.unclaim(taskId);
			return true;

		}catch (Exception e) {
			log.error("unclaim", e);
			throw new CamundaClientException("unclaim :: " + e.getMessage(), e);
		}
	}

	@Override
	public void completeTask(String taskId, List<Entry<String, String>> varialbles) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {
			CompleteTaskDto d = new CompleteTaskDto();

			if(null != varialbles) {
				for(Entry<String, String> entry : varialbles) {

					VariableValueDto value = new VariableValueDto();
					value.setValue(entry.getValue());
					value.setType("string");

					d.putVariablesItem( /*trim*/ entry.getKey(), value);
				}
			}

			api.complete(taskId, d);

		}catch (Exception e) {
			log.error("completeTask", e);
			throw new CamundaClientException("completeTask :: " + e.getMessage(), e);
		}

	}

	@Override
	public ProcessInstanceDto[] getProcessInstanceByBusinessKey(String tenantId, long businessKey) throws CamundaClientException {
		ProcessInstanceApi api = new ProcessInstanceApi(getApiClient());

		try {

			ProcessInstanceQueryDto q = new ProcessInstanceQueryDto();
			q.setBusinessKey(String.valueOf(businessKey));
			
			if(Validator.isNotNull(tenantId)) {
				q.setTenantIdIn(Arrays.asList(tenantId));
			}
			
			List<ProcessInstanceDto> res = api.queryProcessInstances(null, null, q);

			return res.toArray(new ProcessInstanceDto[0]);

		}catch (Exception e) {
			log.error("getProcessInstanceByBusinessKey", e);
			throw new CamundaClientException("getProcessInstanceByBusinessKey :: " + e.getMessage(), e);
		}
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

		}catch (Exception e) {
			log.error("updateProcessInstanceVariableByBusinessKey", e);
			throw new CamundaClientException("updateProcessInstanceVariableByBusinessKey :: " + e.getMessage(), e);
		}

	}

	@Override
	public long countTasksByCodiceIpaComuneAndCodiceServizio(String tenantId, String codiceIpa, String codiceServizio, boolean unassigned) throws CamundaClientException {
		TaskApi api = new TaskApi(getApiClient());

		try {

			List<VariableInstanceDto> variables = new ArrayList<>();
			VariableInstanceDto d = new VariableInstanceDto();
			d.setName(CustomProcessVariables.CODICE_IPA_COMUNE);
			d.setValue(codiceIpa);
			variables.add(d);

			TaskQueryDto q = getTaskQueryDto(tenantId, null, codiceServizio, unassigned, variables, null, null, null, null);

			CountResultDto count = api.queryTasksCount(q);
			return count.getCount();

		}catch (Exception e) {
			log.error("countTasksByCodiceIpaComuneAndCodiceServizio", e);
			throw new CamundaClientException("countTasksByCodiceIpaComuneAndCodiceServizio :: " + e.getMessage(), e);
		}
	}
	
	private TaskQueryDto getTaskQueryDto(String tenantId, String[] candidateGroups, String codiceServizio, Boolean unassigned, List<VariableInstanceDto> variables, String sortName, String sortOrder, String sortType, String assignee) {
		TaskQueryDto q = new TaskQueryDto();

		if(Validator.isNotNull(unassigned) && unassigned) {
			q.setUnassigned(Boolean.TRUE);
		}

		if(Validator.isNotNull(tenantId)) {
			q.setTenantIdIn(Arrays.asList(tenantId));
		}
		
		if(null != candidateGroups && candidateGroups.length > 0) {
			q.setCandidateGroups(Arrays.asList(candidateGroups));
		}

		List<VariableQueryParameterDto> vqs = new ArrayList<>();

		if(Validator.isNotNull(variables)) {
			for(VariableInstanceDto v : variables) {
				VariableQueryParameterDto vq = new VariableQueryParameterDto();
				vq.setName(v.getName());
				vq.setValue(v.getValue());
				vq.setOperator(VariableQueryParameterDto.OperatorEnum.EQ);

				vqs.add(vq);
			}
		}

		if(Validator.isNotNull(codiceServizio)) {
			VariableQueryParameterDto vq = new VariableQueryParameterDto();
			vq.setName(CustomProcessVariables.CODICE_SERVIZIO);
			vq.setValue(codiceServizio);
			vq.setOperator(VariableQueryParameterDto.OperatorEnum.EQ);
			vqs.add(vq);
		}

		if(!vqs.isEmpty()) {
			q.setProcessVariables(vqs);
		}


		if(Validator.isNotNull(sortName) && Validator.isNotNull(sortOrder) && Validator.isNotNull(sortType)) {
			
			TaskQueryDtoSorting sort = new TaskQueryDtoSorting();
			sort.setSortBy(TaskQueryDtoSorting.SortByEnum.PROCESSVARIABLE);
			sort.setSortOrder(TaskQueryDtoSorting.SortOrderEnum.fromValue(sortOrder));

			SortTaskQueryParametersDto p = new SortTaskQueryParametersDto();
			p.setVariable(sortName);
			p.setType(sortType);

			sort.setParameters(p);

			q.setSorting(Arrays.asList(sort));
		}

		if(Validator.isNotNull(assignee)) {
			q.setAssignee(assignee);
		}

		return q;
	}
	
}