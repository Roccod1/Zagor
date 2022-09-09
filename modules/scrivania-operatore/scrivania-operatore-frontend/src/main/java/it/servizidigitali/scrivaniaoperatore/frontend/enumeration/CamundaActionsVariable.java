package it.servizidigitali.scrivaniaoperatore.frontend.enumeration;

public enum CamundaActionsVariable {

	// Azioni Operatore
	VAR_IMPOSTAZIONE_VARIABILI("IMPOSTAZIONE_VARIABILI"),
	VAR_ASSEGNAZIONE_RESPONSABILE("ASSEGNAZIONE_RESPONSABILE"),
	VAR_RICHIESTA_INTEGRAZIONE("RICHIESTA_INTEGRAZIONE"),
	VAR_RILASCIA_TASK("RILASCIA_TASK"),
	VAL_SEPARATOR(":");
	
	private String value;
	
	private CamundaActionsVariable(String value){
		this.setValue(value);
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param name the value to set
	 */
	private void setValue(String value) {
		this.value = value;
	}
}
