package it.servizidigitali.gestioneforms.enumeration;

public enum CartelleAllegatiEnum {
	CONFIGURAZIONE_PIATTAFORMA("Configurazione Piattaforma"),
	FORM("Form"),
	TEMPLATE("Template");
	
	private String name;
	
	private CartelleAllegatiEnum(String name){
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
