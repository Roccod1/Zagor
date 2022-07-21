package it.servizidigitali.backoffice.integration.enums;

/**
 * https://www.anpr.interno.it/portale/documents/20182/50186/tabella_5_relazioni_parentela.xlsx
 * 
 * @author pindi
 *
 */
public enum RelazioneParentela {
	
	INTESTATARIO_SCHEDA(1, "Intestatario Scheda"),
	MARITO_MOGLIE(2, "Marito/Moglie"), 
	FIGLIO_FIGLIA(3, "Figlio/Figlia"), 
	NIPOTE_DISCENDENTE(4, "Nipote (discendente)"), 
	PRONIPOTE_DISCENDENTE(5, "Pronipote (discendente)"), 
	PADRE_MADRE(6, "Padre/Madre"), 
	NONNO_NONNA(7, "Nonno/Nonna"),
	BISNONNO_BISNONNA(8, "Bisnonno/Bisnonna"),
	FRATELLO_SORELLA(9, "Fratello/Sorella"),
	NIPOTE_COLLATERALE(10, "Nipote (collaterale)"), 
	ZIO_ZIA_COLLATERALE(11, "Zio/Zia (collaterale)"),
	CUGINO_CUGINA(12, "Cugino/Cugina"),
	ALTRO_PARENTE(13, "Altro Parente"),
	FIGLIASTRO_FIGLIASTRA(14, "Figliastro/Figliastra"),
	PATRIGNO_MATRIGNA(15, "Patrigno/Matrigna"),
	GENERO_NUORA(16, "Genero/Nuora"),
	SUOCERO_SUOCERA(17, "Suocero/Suocera"),
	COGNATO_COGNATA(18, "Cognato/Cognata"),
	FRATELLASTRO_SORELLASTRA(19, "Fratellastro/Sorellastra"),
	NIPOTE_AFFINE(20, "Nipote (affine)"),
	ZIO_ZIA_AFFINE(21, "Zio/Zia (affine)"),
	ALTRO_AFFINE(22, "Altro (affine)"),
	CONVIVENTE(23, "Convivente (con vincoli di adozione o affettivi)"),
	RESPONSABILE_CONVIVENZA_NON_AFFETTIVA(24, "Responsabile della convivenza non affettiva"),
	CONVIVENTE_CONVIVENZA_NON_AFFETTIVA(25, "Convivente in convivenza non affettiva"),
	TUTORE(26, "Tutore"),
	UNITO_CIVILMENTE(28, "Unito civilmente"),
	NON_DEFINITO_COMUNICAZTO(99, "Non definito/comunicato");

	private final int codice;
	private final String descrizione;

	private RelazioneParentela(int codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}
	
	public static RelazioneParentela getByCodice(int codice){
	    for(RelazioneParentela v : values()){
	        if( v.getCodice() == codice){
	            return v;
	        }
	    }
	    return null;
	}

	public static RelazioneParentela getByDescrizione(String descrizione){
		for(RelazioneParentela v : values()){
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