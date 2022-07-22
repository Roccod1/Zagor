package it.servizidigitali.camunda.integration.model;

public class Sorting {

	private String sortOrder;

	private String sortBy;

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	@Override
	public String toString() {
		return "ClassPojo [sortOrder = " + sortOrder + ", sortBy = " + sortBy + "]";
	}
}