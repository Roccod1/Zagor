package it.servizidigitali.profiloutente.preferenze.frontend.constants;

/**
 * @author filierim
 */
public class ProfiloUtentePreferenzePortletKeys {

	public static final String PROFILOUTENTEPREFERENZE = "it_servizidigitali_profiloutente_preferenze_ProfiloUtentePreferenzePortlet";

//	sezione home
	public static final String SEZIONE_PREFERENZE = "preferenze";
	public static final String SEZIONE_PRIVACY= "privacy";
	public static final String LISTA_ORGANIZZAZIONI = "listaOrganizzazioni";
	
//	dettaglio preferenze
	public static final String ORGANIZZAZIONE = "organizzazione";
	public static final String UTENTE_ORGANIZZAZIONE = "utenteOrganizzazione";
	public static final String UTENTE_ORGANIZZAZIONE_PREFERITA = "utenteOrganizzazionePreferita";
	public static final String UTENTE_ACCETTA_PRIVACY = "utenteAccettaPrivacy";
	public static final String UTENTE_ORGANIZZAZIONE_ID = "utenteOrganizzazioneId";
	public static final String ORGANIZATION_ID = "organizationId";
	public static final String EMAIL = "email";
	public static final String PEC = "pec";
	public static final String APP = "app";
	public static final String PREFERITO = "preferito";
	public static final String CANALE_COMUNICAZIONE = "canaleComunicazione";
	public static final String LISTA_CANALI_COMUNICAZIONE = "listaCanaliComunicazione";
	public static final String LISTA_UTENTE_ORGANIZZAZIONE_CANALE_COMUNICAZIONE = "listaUtenteOrganizzazioneCanaleComunicazione";
	public static final String UTENTE_EXPANDO_ACCETTA_PRIVACY = "accettaPrivacy";
	public static final String PRIVACY_ARTICLE_ID = "privacyArticleId";
	public static final String PRIVACY_ARTICLE_GROUP_ID = "privacyArticleGroupId";

//	nomi jsp
	public static final String JSP_PREFERENZE = "/preferenze.jsp";
	public static final String JSP_PRIVACY = "/privacy.jsp"; 
	public static final String JSP_HOME = "/view.jsp";
	public static final String JSP_PREFERENZE_DETTAGLIO = "/preferenzeDettaglio.jsp";
	
//	nomi command
	public static final String RENDER_INSERISCI_MODIFICA = "/inserisciModifica";
	public static final String RENDER_SEZIONE = "/sezione";
	public static final String ACTION_SALVA = "/salva";
	public static final String ACTION_SALVA_PRIVACY = "/salvaPrivacy";
	
//	utility
	public static final String INDIRIZZO_REDIRECT = "indirizzoRedirect";
	
//	validazioni
	public static final String ERRORE_SALVATAGGIO = "errore-salvataggio";
	public static final String ERRORE_GENERICO = "errore-generico";
	public static final String SUCCESSO_SALVATAGGIO = "salvataggio-avvenuto-con-successo";
	public static final String ERRORE_GET_DETTAGLIO = "impossibile-ottenere-dettaglio-organizzazione";
	
}