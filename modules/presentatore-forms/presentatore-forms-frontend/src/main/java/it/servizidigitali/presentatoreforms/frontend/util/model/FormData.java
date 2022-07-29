package it.servizidigitali.presentatoreforms.frontend.util.model;

import java.util.ArrayList;
import java.util.List;

public class FormData {
	
	private AlpacaJsonStructure alpaca;
	private List<Placeholder> placeholders = new ArrayList<Placeholder>();
	
	public AlpacaJsonStructure getAlpaca() {
		return alpaca;
	}
	public void setAlpaca(AlpacaJsonStructure alpaca) {
		this.alpaca = alpaca;
	}
	public List<Placeholder> getPlaceholders() {
		return placeholders;
	}
	public void setPlaceholders(List<Placeholder> placeholders) {
		this.placeholders = placeholders;
	}
	
	
}
