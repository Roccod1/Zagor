package it.servizidigitali.camunda.integration.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

/**
 * @author pindi
 *
 */
@JsonInclude(Include.NON_NULL)
public class TaskRequest {

	private Variables[] processVariables;
	private Boolean unassigned;

	private String processInstanceBusinessKeyIn;

	private String priority;
	private String[] candidateGroups;

	private String assignee;

	private List<Sort> sorting;

	public Boolean isUnassigned() {
		return unassigned;
	}

	public void setUnassigned(Boolean unassigned) {
		this.unassigned = unassigned;
	}

	public Variables[] getProcessVariables() {
		return processVariables;
	}

	public void setProcessVariables(Variables[] processVariables) {
		this.processVariables = processVariables;
	}

	public String getProcessInstanceBusinessKeyIn() {
		return processInstanceBusinessKeyIn;
	}

	public void setProcessInstanceBusinessKeyIn(String processInstanceBusinessKeyIn) {
		this.processInstanceBusinessKeyIn = processInstanceBusinessKeyIn;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	@Override
	public String toString() {
		return "ClassPojo [processVariables = " + processVariables + ", processInstanceBusinessKeyIn = " + processInstanceBusinessKeyIn + ", priority = " + priority + "]";
	}

	/**
	 * @return the candidateGroup
	 */
	public String[] getCandidateGroups() {
		return candidateGroups;
	}

	/**
	 * @param candidateGroup the candidateGroup to set
	 */
	public void setCandidateGroups(String[] candidateGroup) {
		this.candidateGroups = candidateGroup;
	}

	/**
	 * @return the sorting
	 */
	public List<Sort> getSorting() {
		return sorting;
	}

	/**
	 * @param sorting the sorting to set
	 */
	public void setSorting(List<Sort> sorting) {
		this.sorting = sorting;
	}

}
