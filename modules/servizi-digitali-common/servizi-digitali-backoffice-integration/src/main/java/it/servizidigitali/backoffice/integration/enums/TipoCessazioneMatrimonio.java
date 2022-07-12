package it.servizidigitali.backoffice.integration.enums;

/**
 * https://www.anpr.interno.it/portale/documents/20182/50186/tabella_31.xlsx/d08064d9-f755-4f48-9c59-0e7788f3f8d8
 * 
 * @author pindi
 *
 */
public enum TipoCessazioneMatrimonio {
	
	CESSAZIONE_EFFETTI_CIVILI(1, "Cessazione effetti civili"),
	ANNULLAMENTO(2, "Annullamento"),
	SCIOGLIMENTO(3, "Scioglimento"),
	NULLITA(4, "Nullità"),
	SEPARAZIONE(5, "Separazione"),
	CESSAZIONE_EFFETTI_CIVILI_DL_12_09_2014(6, "Cessazione effetti civili - D.L. 12 settembre 2014"),
	SCIOGLIMENTO_DL_12_09_2014(7, "Scioglimento D.L. 12 settembre 2014, n. 132"),
	SEPARAZIONE_DL_12_09_2014(8, "Separazione - D.L. 12 settembre 2014, n. 132"),
	DELIBAZIONE_ESTERO(9, "Delibazione (estero)"),
	NOTAIO_ESTERO(10, "Notaio (estero)"),
	ALTRO_TIPO(22, "Altro tipo di cessazione/scioglimento");

	private final int codice;
	private final String descrizione;

	private TipoCessazioneMatrimonio(int codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}
	
	public static TipoCessazioneMatrimonio getByCodice(int codice){
	    for(TipoCessazioneMatrimonio v : values()){
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