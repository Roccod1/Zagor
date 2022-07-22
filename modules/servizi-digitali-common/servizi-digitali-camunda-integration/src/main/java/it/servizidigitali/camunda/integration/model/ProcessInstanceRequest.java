package it.servizidigitali.camunda.integration.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Gianluca Pindinelli
 *
 */
@JsonInclude(Include.NON_NULL)
public class ProcessInstanceRequest {

	private String processDefinitionId;

	private String processInstanceBusinessKey;

	private Variables[] variables;

	private Sorting[] sorting;

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	public String getProcessInstanceBusinessKey() {
		return processInstanceBusinessKey;
	}

	public void setProcessInstanceBusinessKey(String processInstanceBusinessKey) {
		this.processInstanceBusinessKey = processInstanceBusinessKey;
	}

	public Variables[] getVariables() {
		return variables;
	}

	public void setVariables(Variables[] variables) {
		this.variables = variables;
	}

	public Sorting[] getSorting() {
		return sorting;
	}

	public void setSorting(Sorting[] sorting) {
		this.sorting = sorting;
	}

	@Override
	public String toString() {
		return "ClassPojo [processDefinitionId = " + processDefinitionId + "processInstanceBusinessKey = " + processInstanceBusinessKey + ", variables = " + variables + ", sorting = " + sorting + "]";
	}
}
