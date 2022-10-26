package it.servizidigitali.presentatoreforms.common.enumeration;

/**
 * @author ZONNOG
 *
 */
public enum CondizioniScaricamentoEnum {
	
	DATA_MINIMA_CERT_MORTE(1, Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.condizione.data.non.verificata.cert.morte" ),
	DATA_MINIMA_CERT_NASCITA(2, Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(), "error.condizione.data.non.verificata.cert.nascita"),
	SOGGETTO_NON_DECEDUTO(3, Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.condizione.morte.non.verificata" ),
	COMUNE_NON_CORRETTO(4, Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.condizione.comune.nascita.non.verificata"),
	SOGGETTO_NON_CONIUGATO(5, Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(), "error.condizione.coniugato.non.verificata"),
	SOGGETTO_CONIUGATO(6, Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(), "error.condizione.non.coniugato.non.verificata"),
	SOGGETTO_NON_LIBERO(7,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.condizione.libero.non.verificata"),
	POSIZIONI_ELETTORALI_VUOTE(8,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.condizione.posizioni.elettorali.vuote"),
	SOGGETTO_NON_VEDOVO(9,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.condizione.vedovanza.non.verificata"),
	SOGGETTO_NON_IN_VITA(10,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.condizione.in.vita.non.verificata"),
	SOGGETTO_DECEDUTO_CERTIFICATO_NON_DISPONIBILE(11,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.condizione.deceduto.messaggio.generico"),
	RICHIESTA_DUPLICATA(12,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.richiesta.duplicata"),
	NESSUN_MINORE_RANGE_ETA(13,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.no.minore.range.eta"),
	CONFIGURAZIONE_MANCANTE(14,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.no.configurazione"),
	NESSUN_MINORE_ISCRIVIBILE(15,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.no.minore.iscrivibile"),
	RICHIESTA_UNICA_DUPLICATA(16,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.richiesta.unica.duplicata"),
	RICHIESTA_FUORI_PERIODO(17,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.richiesta.fuori.periodo"),
	ANNO_ERRATO_SIST_ESTERNO(18,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.anno.sistema.esterno"),
	RICHIESTA_DUPLICATA_SIST_ESTERNO(19,Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(),"error.richiesta.duplicata.esterna"),
	ATTO_NON_PRESENTE(20, Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(), "error.atto.non.presente"),
	SOGGETTO_NON_UNITO(21, Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue(), "error.condizione.unito.non.verificata");
	
	private int key;
	private String value;
	private String messageName;
	
	private CondizioniScaricamentoEnum(int key, String value, String messageName){
		this.key = key;
		this.value = value;
		this.messageName = messageName;
	}
	
	public int getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getMessageName() {
		return messageName;
	}
	
	public static String getValueByKey(int key){
		for (CondizioniScaricamentoEnum e : CondizioniScaricamentoEnum.values()) {
			if(e.getKey() == key){
				return e.getValue();
			}
		}
		return Views.FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW.getValue();
	}

	public static String getMessageNameByKey(int key){
		for (CondizioniScaricamentoEnum e : CondizioniScaricamentoEnum.values()) {
			if(e.getKey() == key){
				return e.getMessageName();
			}
		}
		return "exception.generalError.title";
	}
	
}
