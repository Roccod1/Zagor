package it.servizidigitali.presentatoreforms.frontend.util.alpaca.enumeration;

public enum AlpacaSchemaType {
	BOOLEAN("boolean"),
	OBJECT("object");
	
	private String name;
	
	private AlpacaSchemaType(String name){
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
