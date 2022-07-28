package it.servizidigitali.presentatoreforms.frontend.util.model;


public class AlpacaJsonSchemaStructure {
	private String type;
	
	private Object properties;
	
	private Object dependencies;
	

	public AlpacaJsonSchemaStructure() {
		super();
	}
	
	

	public AlpacaJsonSchemaStructure(String type, Object properties, Object dependencies) {
		super();
		this.type = type;
		this.properties = properties;
		this.dependencies = dependencies;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getProperties() {
		return properties;
	}

	public void setProperties(Object properties) {
		this.properties = properties;
	}

	public Object getDependencies() {
		return dependencies;
	}

	public void setDependencies(Object dependencies) {
		this.dependencies = dependencies;
	}
}
