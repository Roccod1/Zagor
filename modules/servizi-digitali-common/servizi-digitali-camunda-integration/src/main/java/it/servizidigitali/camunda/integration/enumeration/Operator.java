package it.servizidigitali.camunda.integration.enumeration;

/**
 * @author pindi
 *
 */
public enum Operator {

	EQ("eq"), NEQ("neq"), GT("gt"), GTEQ("gteq"), LT("lt"), LTEQ("lteq"), LIKE("like"), NOTLIKE("notLike");

	private String value;

	private Operator(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return getValue();
	}

}
