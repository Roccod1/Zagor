package it.servizidigitali.gestionetipologieservizio.frontend.constants;

/**
 * @author pindi
 */
public class GestioneTipologieServizioPortletKeys {

//	costanti portlet
	public static final String GESTIONETIPOLOGIESERVIZIO = "it_servizidigitali_gestionetipologieservizio_frontend_GestioneTipologieServizioPortlet";

//	attributi utility
	public static final String LISTA_TIPOLOGIE = "listaTipologie";
	public static final String INDIRIZZO_PRECEDENTE = "indirizzoPrecedente";
	
//	messaggi sessione
	public static final String ERRORE_CAMPI_OBBLIGATORI = "validazione-campi-obbligatori-fallita";
	public static final String ERRORE_SALVATAGGIO = "salvataggio-errore";
	public static final String ERRORE_IMPOSSIBILE_OTTENERE_TIPOLOGIA = "errore-impossibile-ottenere-tipologia";
	public static final String SALVATAGGIO_SUCCESSO = "salvataggio-successo";
	
	//parametri default search container
	public static final int DEFAULT_CUR = 1;
	public static final int DEFAULT_DELTA = 10;

	//	attributi tipologia
	public static final String TIPOLOGIA = "tipologia";	
	public static final String TIPOLOGIA_ID = "tipologiaId";	
	public static final String NOME = "nome";
	public static final String DESCRIZIONE = "descrizione";
	public static final String VISIBILE = "visibile";
	public static final String INVIO_EMAIL_CITTADINO = "invioEmailCittadino";
	public static final String CHATBOT_INLINE_INTENT = "chatbotInlineIntent";

//	path jsp
	public static final String JSP_INSERIMENTO_MODIFICA_TIPOLOGIA = "/inserisciModificaTipologiaServizio.jsp";
	public static final String JSP_HOME = "/view.jsp";
	
//	path command
	public static final String AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME = "/aggiungiModifica";
	public static final String SALVA_ACTION_COMMAND_NAME = "/salva";
}	
