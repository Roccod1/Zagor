package it.servizidigitali.presentatoreforms.common.enumeration;

public enum AlpacaKey {
	DATA_SOURCE("dataSource"),
	DEFAULT("default"),
	FIELDS("fields"),
	ITEMS("items"),
	LABEL("label"),
	PLACEHOLDER("placeholder"),
	PROPERTIES("properties"),
	READONLY("readonly"),
	RIGHT_LABEL("rightLabel"),
	TYPE("type"),
	ORDER("order"),
	FIELD_CLASS("fieldClass"),
	WIZARD("wizard"),
	BINDINGS("bindings"),
	STEPS("steps"),
	LAYOUT("layout"),
	TEMPLATE("template");
	
	private String name;
	
	private AlpacaKey(String name){
		this.setName(name);
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
}
