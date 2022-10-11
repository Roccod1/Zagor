package it.servizidigitali.scrivaniacittadino.frontend.dto;

import java.util.List;

import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

public class RichiestaAccordionDto {
	private Richiesta richiesta;
	private List<AllegatoRichiesta> allegatiRichiesta;
	public Richiesta getRichiesta() {
		return richiesta;
	}
	public void setRichiesta(Richiesta richiesta) {
		this.richiesta = richiesta;
	}
	public List<AllegatoRichiesta> getAllegatiRichiesta() {
		return allegatiRichiesta;
	}
	public void setAllegatiRichiesta(List<AllegatoRichiesta> allegatiRichiesta) {
		this.allegatiRichiesta = allegatiRichiesta;
	}
}
