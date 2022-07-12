package it.servizidigitali.backoffice.integration.enums;

/**
 * https://www.anpr.interno.it/portale/documents/20182/50186/tabella_11.xlsx/9e49f262-ee2a-4d37-8b42-2149ca717977
 * 
 * @author pindi
 *
 */
public enum TitoloStudio {
	
	NON_APPLICABILE("0","Non applicabile"),
	NESSUN_TITOLO_LICENZA_ELEMENTARE("1","Nessun titolo/ licenza elementare"),
	LICENZA_MEDIA("2","Licenza media"),
	DIPLOMA_SCUOLA_SUPERIORE("3","Diploma scuola superiore"),
	LAUREA_TRIENNALE("4","Laurea triennale"),
	LAUREA("5","Laurea"),
	DOTTORATO_SPECIALIZZAZIONE_POST_LAUREA("6","Dottorato/specializz. Post-laurea"),
	LICENZA_MEDIA_AVVIAMENTO_PROFESSIONALE("9","Licenza media /avviamento professionale"),
	NESSUN_TITOLO("7","Nessun titolo"),
	LICENZA_ELEMENTARE("8" ,"Licenza elementare"),
	DIPLOMA_QUALIFICA_PROFESSIONALE_E_REGIONALI_2_3_ANNI("A" ,"Diploma di qualifica professionale e qualifiche regionali di 2-3 anni"),
	ATTESTATO_IFP_TRIENNALE_DIPLOMA_IFP_QUADRIENNALE_TECNICO("B" ,"Attestato IFP di qualifica professionale triennale (operatore) / Diploma professionale quadriennale IFP di tecnico"),
	DIPLOMA_MATURITA("C" ,"Diploma di maturità "),
	CERT_SPECIALIZZAZIONE_TECNICA_SUP_IFTS("D" ,"Certificato di specializzazione tecnica superiore (IFTS)"),
	DIPLOMA_TECNICO_SUP_ITS("E" ,"Diploma di tecnico superiore (ITS)"),
	LAUREA_PRIMO_LIV_DIPL_UNI_DIPL_ACC_PRIMO_LIV("F" ,"Laurea di primo livello (3 anni), Diploma universitario (2-3 anni), Diploma accademico di primo livello"),
	LAUREA_MAGISTR_DIPL_LAUREA_VO_DIPL_ACC_SECONDO_LIV_VO("G" ,"Laurea magistrale/specialistica o Diploma di laurea vecchio ordinamento (4-6 anni); Diploma accademico di secondo livello o Diploma accademico del vecchio ordinamento"),
	DOTTORATO("H" ,"Dottorato"),
	NON_CONOSCIUTO_NON_FORNITO("Z" ,"Non conosciuto / non fornito");

	private final String codice;
	private final String descrizione;

	private TitoloStudio(String codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}
	
	public static TitoloStudio getByCodice(String codice){
	    for(TitoloStudio v : values()){
	        if( v.getCodice().equals(codice)){
	            return v;
	        }
	    }
	    return null;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public String getCodice() {
		return codice;
	}

}