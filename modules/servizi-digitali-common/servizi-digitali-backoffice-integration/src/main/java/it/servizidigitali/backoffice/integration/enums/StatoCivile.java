package it.servizidigitali.backoffice.integration.enums;
/**
 * https://www.anpr.interno.it/portale/documents/20182/26001/tabella_1_stato_civile.xlsx/cef8e627-6416-4a6d-96bb-6eea502288da
 * 
 * @author pindi
 *
 */
public enum StatoCivile {
	CELIBE_NUBILE(1, "Celibe/Nubile"), 
	CONIUGATO_CONIUGATA(2, "Coniugato/a"), 
	VEDOVO_VEDOVA(3, "Vedovo/a"), 
	DIVORZIATO_DIVORZIATA(4, "Divorziato/a"),
	UNITO_CIVILMENTE(6, "Unito civilmente"),
	STATO_LIBERO_DECESSO(7, "Stato libero a seguito di decesso della parte unita civilmente"),
	STATO_LIBERO_SCIOGLIMENTO(8, "Stato libero a seguito di scioglimento dell'unione"),
	IGNOTO(9, "Ignoto");
	
	private final int codice;
	private final String descrizione;

	private StatoCivile(int codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}
	
	public static StatoCivile getByCodice(int codice){
	    for(StatoCivile v : values()){
	        if( v.getCodice() == codice){
	            return v;
	        }
	    }
	    return null;
	}

	public static StatoCivile getByDescrizione(String descrizione){
		for(StatoCivile v : values()){
			if( v.getDescrizione().equals(descrizione)){
				return v;
			}
		}
		return null;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public int getCodice() {
		return codice;
	}

}