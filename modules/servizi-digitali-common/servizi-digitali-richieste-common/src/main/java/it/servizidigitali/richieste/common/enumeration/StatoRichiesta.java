package it.servizidigitali.richieste.common.enumeration;

/**
 * Enumeration per la definizione dei possibili stati assegnabili ad una Richiesta.
 * 
 * @author pindi
 *
 */
public enum StatoRichiesta {

	RICHIESTA_BOZZA("BOZZA", "Bozza"),
	RICHIESTA_NUOVA("NUOVA", "Nuova"),
	RICHIESTA_INVIATA("INVIATA", "Inviata"),
	RICHIESTA_PROTOCOLLATA("PROTOCOLLATA", "Protocollata"),
	RICHIESTA_CONSEGNATA("CONSEGNATA", "Consegnata"),
	RICHIESTA_LAVORAZIONE("IN_LAVORAZIONE", "In Lavorazione"),
	ATTESA_INTEGRAZIONI("ATTESA_INTEGRAZIONI", "Attesa Integrazioni"),
	INTEGRAZIONI_INSERITE("INTEGRAZIONI_INSERITE", "Integrazioni Inserite"),
	RICHIESTA_ANNULLATA("ANNULLATA", "Annullata"),
	RICHIESTA_CHIUSA_POSITIVAMENTE("CHIUSA_POSITIVAMENTE", "Chiusa con esito positivo"),
	RICHIESTA_CHIUSA_NEGATIVAMENTE("CHIUSA_NEGATIVAMENTE", "Chiusa con esito negativo"),
	RIFIUTATA("RIFIUTATA", "Rifiutata"), /*Rigettata. utilizzata da operatore suss per richiedere il reinoltro della richiesta di iscrizione*/
	STATO_NON_DISPONIBILE("STATO_NON_DISPONIBILE", "Stato non disponibile"),
	DA_AUTORIZZARE("DA_AUTORIZZARE", "In attesa di autorizzazione"),
	AUTORIZZATA("AUTORIZZATA", "Autorizzata"),
	AUTORIZZATA_MANUALMENTE("AUTORIZZATA_MANUALMENTE", "Autorizzata da operatore"),
	ATTESA_PAGAMENTO("ATTESA_PAGAMENTO", "Attesa di pagamento"),
	ELIMINATA("ELIMINATA", "Eliminata"); /*verificare*/

	private String key;
	private String value;

	private StatoRichiesta(final String key, final String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	public static String getValueFormKey(final String key){

		for(StatoRichiesta val : values()){
			if(val.getKey().equalsIgnoreCase(key)){
				return val.getValue();
			}
		}

		return null;
	}
	
	public static StatoRichiesta getFromKey(String key){
		for (StatoRichiesta e : StatoRichiesta.values()) {
			if(e.getKey().equals(key)){
				return e;
			}
		}
		return null;
	}

}