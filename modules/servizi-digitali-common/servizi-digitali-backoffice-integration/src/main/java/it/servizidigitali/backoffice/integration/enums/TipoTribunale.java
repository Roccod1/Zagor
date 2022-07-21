package it.servizidigitali.backoffice.integration.enums;

/**
 * https://www.anpr.interno.it/portale/documents/20182/50186/tabella+32_tipo__tribunale.xlsx/e91add16-9fc0-409d-8d60-cb95be997ab7
 * 
 * @author pindi
 *
 */
public enum TipoTribunale {
	
	TRIBUNALE_CIVILE(1, "Tribunale civile Italiano"),
	SACRA_ROTA(2, "Sacra Rota"),
	TRIBUNALE_ESTERO(3, "Tribunale Estero"),
	AVVOCATO_NOTAIO_UFICIO_ST_CIVILE(4, "Avvocato/Notaio/Uff.St.Civile"),
	NON_CONOSCIUTO(5, "Non conosciuto");
	
	private final int codice;
	private final String descrizione;

	private TipoTribunale(int codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}
	
	public static TipoTribunale getByCodice(int codice){
	    for(TipoTribunale v : values()){
	        if( v.getCodice() == codice){
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