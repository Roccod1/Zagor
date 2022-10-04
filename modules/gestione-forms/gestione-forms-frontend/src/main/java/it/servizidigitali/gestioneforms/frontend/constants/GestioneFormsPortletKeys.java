package it.servizidigitali.gestioneforms.frontend.constants;

/**
 * @author pindi
 */
public class GestioneFormsPortletKeys {

	public static final String GESTIONEFORMS = "it_servizidigitali_gestioneforms_frontend_GestioneFormsPortlet";

	// BUILDER
	public static final String LISTA_FORM = "listaForm";

	public static final String FORM = "form";

	public static final String CODICE = "codice";
	public static final String NOME = "nome";
	public static final String PRINCIPALE = "principale";
	public static final String MULTIENTE = "multiente";
	public static final String ID_FORM = "idform";

	public static final String AZIONI = "azioni";
	public static final String FORMATI_ALLEGATI = "formatiAllegati";
	public static final String MODELLO_FORM = "modelloForm";

	public static final String LISTA_TIPO_DOCUMENTO = "listaTipoDocumento";
	public static final String LISTA_ALLEGATI_DA_ELIMINARE = "listaAllegatiDaEliminare";
	public static final String DIMENSIONE_LISTA_ALLEGATI = "dimensioneListaDefinizioneAllegato";

	public static final String FILE = "file";

	public static final String SITE_GROUP_ID = "siteGroupId";
	public static final String ORGANIZATION_ID_SITE_PRINCIPALE = "organizationIdSitePrincipale";

	public static final String DEFINIZIONE_ALLEGATO_ID = "definizioneAllegatoId";
	public static final String DEFINIZIONE_ALLEGATO_DENOMINAZIONE = "denominazione";
	public static final String DEFINIZIONE_ALLEGATO_FILE_AMMESSI = "tipiFileAmmessi";
	public static final String DEFINIZIONE_ALLEGATO_CODICI_TIPOLOGIA = "codiciTipologiaDocumento";
	public static final String DEFINIZIONE_ALLEGATO_ID_TEMPORANEO = "idAllegatoTemporaneo";
	public static final String DEFINIZIONE_ALLEGATO_FILENAME = "filenameModello";
	public static final String DEFINIZIONE_ALLEGATO_OBBLIGATORIO = "obbligatorio";

	public static final String SESSION_MESSAGE_ERRORE_NON_AUTORIZZATO = "errore-non-autorizzato";

	// FORM RICERCA
	public static final String NOME_RICERCA = "nomeRicerca";
	public static final String DATA_INSERIMENTO_DA = "dataInserimentoDa";
	public static final String DATA_INSERIMENTO_A = "dataInserimentoA";
	public static final String DATA_CREAZIONE = "data-creazione";

	// DEFINIZIONE COMMAND
	public static final String RICERCA_ACTION_COMMAND = "/ricerca";
	public static final String SALVA_AGGIUNGI_ACTION_COMMAND = "/salvaModifica";
	public static final String DETTAGLIO_NUOVO_RENDER_COMMAND = "/dettaglioNuovo";
	public static final String UPLOAD_ALLEGATO_RESOURCE_COMMAND = "/uploadFile";

	// JSP
	public static final String JSP_FORM_RICERCA = "/formRicerca.jsp";
	public static final String JSP_LISTA_FORM = "/listaForm.jsp";
	public static final String JSP_AGGIUNGI_MODIFICA_FORM = "/aggiungiModificaForm.jsp";
	public static final String JSP_VIEW = "/view.jsp";

	// SESSION MESSAGES
	public static final String SESSION_MESSAGE_ERRORE_SALVATAGGIO = "errore-salvataggio";
	public static final String SESSION_MESSAGE_ERRORE_SALVATAGGIO_ALLEGATI = "errore-salvataggio-allegati";
	public static final String SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE = "eseguito-correttamente";

	// SEARCH CONTAINER
	public static final int DEFAULT_CUR = 1;
	public static final int DEFAULT_DELTA = 10;

	// STATI TIPO DOCUMENTO
	public static final String STATO_ATTIVO = "ATTIVO";

	// LISTA CARTELLE DOCUMENT REPOSITORY
	public static final String CARTELLA_CONFIGURAZIONE_PIATTAFORMA = "Configurazione Piattaforma";
	public static final String CARTELLA_FORM = "Form";
	public static final String CARTELLA_TEMPLATE = "Template";

	// JSON
	public static final String STATUS = "status";
	public static final String STATUS_OK = "ok";
	public static final String STATUS_ERROR = "error";
}