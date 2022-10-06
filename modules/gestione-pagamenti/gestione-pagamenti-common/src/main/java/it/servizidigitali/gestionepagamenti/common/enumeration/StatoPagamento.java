package it.servizidigitali.gestionepagamenti.common.enumeration;

import java.util.stream.Stream;

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
	
	public static String getDescrizioneByName(String name) {
		
		String descrizione = "-";
		
		if (Stream.of(StatoPagamento.values()).filter(en -> en.toString().equals(name)).findAny().isPresent()) {
			descrizione = StatoPagamento.valueOf(name).getDescrizione();
		}
		
		return descrizione;
	}
}
