package it.servizidigitali.gestioneprocessi.service.enumeration;

public enum NomiCartelleEnum {
	CONFIGURAZIONI("Configurazioni"),
	BPMN("BPMN"),
	FILES("files");
	
	private String name;
	
	private NomiCartelleEnum(String name){
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
