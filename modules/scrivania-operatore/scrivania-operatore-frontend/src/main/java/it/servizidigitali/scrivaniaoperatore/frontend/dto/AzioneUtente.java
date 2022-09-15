package it.servizidigitali.scrivaniaoperatore.frontend.dto;

public class AzioneUtente {

	private String codiceAzioneUtente = null;
	private String descrizione = null;
	
	//private String tipoParere = null;
	//private String origineParere = null;
	
	private String variableSet = null;
	private String variableValue = null;
	private String descrizioneAlternativa = null;
	
	public String getCodiceAzioneUtente() {
		return codiceAzioneUtente;
	}
	public void setCodiceAzioneUtente(String codiceAzioneUtente) {
		this.codiceAzioneUtente = codiceAzioneUtente;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getVariableSet() {
		return variableSet;
	}
	public void setVariableSet(String variableSet) {
		this.variableSet = variableSet;
	}
	public String getVariableValue() {
		return variableValue;
	}
	public void setVariableValue(String variableValue) {
		this.variableValue = variableValue;
	}
	public String getDescrizioneAlternativa() {
		return descrizioneAlternativa;
	}
	public void setDescrizioneAlternativa(String descrizioneAlternativa) {
		this.descrizioneAlternativa = descrizioneAlternativa;
	}	
}
