package it.servizidigitali.gestioneenti.frontend.constants;

/**
 * @author pindi
 */
public class GestioneEntiPortletKeys {

	public static final String GESTIONEENTI = "it_servizidigitali_gestioneenti_frontend_GestioneEntiPortlet";

//	property entity
	public static final String ORGANIZZAZIONI = "organizzazioni";
	public static final String ORGANIZZAZIONE = "organizzazione";
	public static final String ORGANIZZAZIONE_SERVIZI = "listaServiziEnte";
	
//	proeprty ricerca
	public static final String ORGANIZZAZIONE_NOME_RICERCA = "nomeOrganizzazioneRicerca";
	public static final String ORGANIZZAZIONE_CODICE_IPA_RICERCA = "codiceIpaOrganizzazioneRicerca";

//	entity organizzazione
	public static final String ORGANIZZAZIONE_ID = "organizationId";
	public static final String ORGANIZZAZIONE_NOME = "name";
	public static final String ORGANIZZAZIONE_LISTA_SERVIZI_ASSOCIATI= "listaServiziAssociati";
	public static final String LISTA_SERVIZI = "listaServizi";

//	entity servizioOrganizzazione
	public static final String SERVIZIO_ENTE = "servizioEnte";
	public static final String SERVIZIO_ENTE_ID = "servizioEnteId";


//	entity Servizio
	public static final String SERVIZIO_ID = "servizioId";
	public static final String SERVIZIO_URI = "uri";
	public static final String SERVIZIO_URI_GUEST = "uriGuest";
	public static final String SERVIZIO_URI_ESTERNA = "uriEsterna";
	public static final String SERVIZIO_CATALOGO_SERVIZI_ARTICLE_ID = "catalogoServizioArticleId";
	public static final String SERVIZIO_AUTENTICAZIONE = "autenticazione";
	public static final String SERVIZIO_LIVELLO_AUTENTICAZIONE = "livelloAutenticazione";
	public static final String SERVIZIO_DATA_INIZIO_ATTIVAZIONE = "dataInizioAttivazione";
	public static final String SERVIZIO_DATA_FINE_ATTIVAZIONE = "dataFineAttivazione";
	public static final String SERVIZIO_CITTADINO = "cittadino";
	public static final String SERVIZIO_DELEGA = "delega";
	public static final String SERVIZIO_CHATBOT = "chatbot";
	public static final String SERVIZIO_PRENOTABILE = "prenotabile";
	public static final String SERVIZIO_PRIVACY_DELEGA = "privacyDelega";
	public static final String SERVIZIO_ALLEGATO_DELEGA = "allegatoDelega";
	public static final String SERVIZIO_TIMBRO_CERTIFICATO = "timbroCertificato";
	public static final String SERVIZIO_ISEE_INPS = "iseeInps";
	public static final String SERVIZIO_ATTIVO = "attivo";
	public static final String SERVIZIO_AZIENDA = "azienda";

//	path jsp
	public static final String JSP_INSERIMENTO_MODIFICA = "/inserisciModificaEnteServizio.jsp";
	public static final String JSP_RISULTATI_RICERCA = "/risultatiRicerca.jsp";
	public static final String JSP_HOME = "/view.jsp";
	public static final String JSP_FORM_RICERCA = "/formRicerca.jsp";
	public static final String JSP_LISTA_SERVIZI_ENTE = "/listaServiziEnte.jsp";
	
//	path command
	public static final String AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME = "/inserisciModifica";
	public static final String SALVA_ACTION_COMMAND_NAME = "/salva";
	public static final String CERCA_ACTION_COMMAND_NAME = "/cerca";
	public static final String LISTA_SERVIZI_ENTE_RENDER_COMMAND = "/listaServiziEnte";

	//	utility
	public static final String SALVATAGGIO_SUCCESSO = "salvataggio-successo";
	public static final String ELIMINAZIONE_SUCCESSO = "eliminazione-successo";
	public static final String ERRORE_CAMPI_OBBLIGATORI = "validazione-campi-obbligatori-fallita";
	public static final String ERRORE_SALVATAGGIO = "salvataggio-errore";
	public static final String ERRORE_IMPOSSIBILE_CARICARE_I_DATI = "errore-impossibile-caricare-i-dati";
	public static final String ERRORE_ELIMINAZIONE_SERVIZIO = "errore-eliminazione-servizio-associato";
	public static final String ERRORE_PERIODO_DATE_ATTIVAZIONE= "errore-periodo-date";
	public static final String ERRORE_VALIDAZIONE_URI = "errore-validazione-uri";
//	public static final String ERRORE_VALIDAZIONE_URI_GUEST = "errore-validazione-uri-guest";
	public static final String ERRORE_VALIDAZIONE_URI_ESTERNA = "errore-validazione-uri-esterna";
	public static final String INDIRIZZO_REDIRECT = "indirizzoRedirect";
	public static final String DELETE_TOGGLE = "toDelete";
	public static final String PULSANTE_PAGINA_PRINCIPALE_TOGGLE = "pulsantePaginaPrincipale";
	public static final String DISABILITA_RICERCA = "disabilitaRicerca";
	
	public static final int DEFAULT_CUR = 1;
	public static final int DEFAULT_DELTA = 10;

	public static final String STRUCTURE_NAME_CATALOGO_SERVIZI = "Catalogo Servizi";
	public static final String LISTA_ARTICLE_CATALOGO_SERVIZI = "listaArticleCatalogoServizi";
	
	public static final String LISTA_URI_PRIVATE = "listaUriPrivata";
	public static final String LISTA_URI_PUBBLICHE = "listaUriPubblica";
	
	public static final String SERVIZI_FRIENDLY_URL = "/servizi";
}