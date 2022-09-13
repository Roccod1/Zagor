package it.servizidigitali.scrivaniaoperatore.frontend.enumeration;

public enum CamundaCodiciOperazioniUtente {
	RICHIESTA_INTEGRAZIONE("RICHIESTA_INTEGRAZIONE"),
	ASSEGNA_RESPONSABILE("ASSEGNA_RESPONSABILE"),
	ASSEGNA_ALTRO_RESPONSABILE("ASSEGNA_ALTRO_RESPONSABILE"),
	RILASCIA_TASK("RILASCIA_TASK"),
	RIMANDA_REFERENTE("RIMANDA_REFERENTE"),
	ESITO_PROCEDIMENTO_NEGATIVO("ESITO_PROCEDIMENTO_NEGATIVO"),
	ESITO_PROCEDIMENTO_POSITIVO("ESITO_PROCEDIMENTO_POSITIVO");
	
	private String value;
	
	private CamundaCodiciOperazioniUtente(String value){
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
