package it.servizidigitali.presentatoreforms.frontend.util.model;

public class AlpacaDatasource {
	private String text;
	private String value;
	
	public AlpacaDatasource() {};
	
	public AlpacaDatasource(String text, String value) {
		this.text = text;
		this.value = value;
	}

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
}
