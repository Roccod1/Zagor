package it.servizidigitali.gestionepagamenti.common.enumeration;

/**
 * @author pindi
 *
 */
public enum StatoPagamento {
	NUOVO("NUOVO"), IN_ATTESA("IN ATTESA"), CONFERMATO("CONFERMATO"), COMPLETATO("COMPLETATO"), ERRORE("ERRORE"), NON_CONFERMATO("NON CONFERMATO");
	
	private String descrizione;
	
	private StatoPagamento(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}
}
