package it.servizidigitali.presentatoreforms.common.model;

public class ProvinceDatasource {
	private String text;
	private String value;
	private long idProvincia;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public long getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(long idProvincia) {
		this.idProvincia = idProvincia;
	}
	public ProvinceDatasource(String text, String value, long idProvincia) {
		super();
		this.text = text;
		this.value = value;
		this.idProvincia = idProvincia;
	}
	
	public ProvinceDatasource() {
		super();
	} 
	
	
}
