package it.servizidigitali.camunda.integration.model;

import it.servizidigitali.camunda.integration.enumeration.Operator;

public class Variables {

	private String name;
	private Object value;
	private String operator;

	public Variables() {
	}

	public Variables(String name, Object value, String operator) {
		this.name = name;
		if (operator.equals(Operator.LIKE.getValue()) || operator.equals(Operator.NOTLIKE.getValue())) {
			this.value = "%" + value + "%";
		}
		else {
			this.value = value;
		}
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "ClassPojo [name = " + name + ", value = " + value + ", operator = " + operator + "]";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

}