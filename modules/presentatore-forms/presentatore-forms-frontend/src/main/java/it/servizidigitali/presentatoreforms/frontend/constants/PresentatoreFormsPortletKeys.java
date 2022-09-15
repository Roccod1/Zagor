package it.servizidigitali.presentatoreforms.frontend.constants;

/**
 * @author pindi
 */
public class PresentatoreFormsPortletKeys {

	public static final String PRESENTATOREFORMS =
		"it_servizidigitali_presentatoreforms_frontend_PresentatoreFormsPortlet";
	
	public static final String ALPACA_STRUCTURE = "alpacaStructure";

	// DEFINIZIONE COMMAND
	public static final String SCEGLI_ALLEGATI_RENDER_COMMAND = "/scegliAllegati";
	public static final String SUBMIT_FORM_RESOURCE_COMMAND = "/submitForm";
	public static final String UPLOAD_ALLEGATO_RESOURCE_COMMAND = "/uploadFile";
	public static final String SALVA_DATI_FORM_ACTION_COMMAND = "/salvaDatiForm";
	public static final String HOME_RENDER_COMMAND = "/home";
	public static final String SCEGLI_MODALITA_PAGAMENTO_RENDER_COMMAND = "/scegliModalitaPagamento";
	public static final String SALVA_INVIA_ACTION_COMMAND = "/salvaInvia";
	
	
	//JSP
	public static final String JSP_SCEGLI_ALLEGATI = "/scegliAllegati.jsp";
	public static final String SELECT_COMPONENTI_NUCLEO_FAMILIARE ="selectComponentiNucleoFamiliare";
	public static final String JSP_SCEGLI_DESTINAZIONE_USO = "/scegliDestinazioneUso.jsp";
	public static final String JSP_SCEGLI_MODALITA_PAGAMENTO = "/scegliModalitaPagamento.jsp";
	public static final String JSP_COMPILA_FORM = "/compilaForm.jsp";
	public static final String JSP_HOME = "/home.jsp";
	
	// MESSAGGI DI ERRORE
	public static final String IMPOSSIBILE_RECUPERARE_RICHIESTA = "impossibile-recuperare-richiesta";
	public static final String IMPOSSIBILE_RECUPERARE_SERVIZIO = "impossibile-recuperare-servizio";
	public static final String IMPOSSIBILE_RECUPERARE_PROCEDURA = "impossibile-recuperare-procedura";

	// ATTRIBUTI
	public static final String TITOLO_PORTLET_SERVIZIO = "titoloPortletServizio";
	public static final String DA_PAGARE = "daPagare";
	public static final String ANTEPRIMA_CERTIFICATI = "certificatiPdfPreviewEnabled";
	public static final String BOZZA_STATUS = "bozzaStatus";
	public static final String RICHIESTA_STATUS = "richiestaStatus";
	
	
	// JSON
	public static final String STATUS = "status";
	public static final String STATUS_OK = "ok";
	public static final String STATUS_ERROR = "error";
	
	public static final String DEFINIZIONE_ALLEGATO_ID_TEMPORANEO = "idAllegatoTemporaneo";
	public static final String USER_PREFERENCES_ATTRIBUTE_NAME = "userPreferences";

}