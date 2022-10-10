package it.servizidigitali.scrivaniacittadino.frontend.constants;

/**
 * @author pindi
 */
public class ScrivaniaCittadinoPortletKeys
{
    public static final String SCRIVANIACITTADINO = "it_servizidigitali_scrivaniacittadino_frontend_ScrivaniaCittadinoPortlet";
    
    public static final String SEZIONE_SCRIVANIA = "sezioneScrivania";
    public static final String SEZIONE_ATTIVITA = "sezioneAttivita";
    public static final String SEZIONE_MESSAGGI = "sezioneMessaggi";
    public static final String SEZIONE_SERVIZI = "sezioneServizi";
    public static final String TAB_ATTIVA = "tabAttiva";
    
    public static final String LISTA_RICHIESTE = "listaRichieste";
    public static final String LISTA_PRENOTAZIONI = "listaPrenotazioni";
    public static final String LISTA_COMUNICAZIONI = "listaComunicazioni";
    public static final String LISTA_PAGAMENTI = "listaPagamenti";
    public static final String LISTA_TIPOLOGIA_COMUNICAZIONE = "listaTipologiaComunicazione";
    public static final String LISTA_TIPOLOGIA_RICHIESTA = "listaTipologiaRichiesta";
    public static final String LISTA_STATO = "listaStato";

    
    public static final String RESOURCE_COMMAND_GET_RICHIESTE = "/getRichiesteUtente";
    public static final String RESOURCE_COMMAND_GET_COMUNICAZIONI = "/getComunicazioniUtente";
    public static final String RESOURCE_COMMAND_GET_PAGAMENTI = "/getPagamentiUtente";
    public static final String RESOURCE_COMMAND_GET_PRENOTAZIONI = "/getPrenotazioniUtente";    
    public static final String RESOURCE_COMMAND_DOWNLOAD_FILE = "/downloadFile";


    public static final String RENDER_COMMAND_DETTAGLIO_RICHIESTA="/dettaglioRichiesta";
    
    public static final String FILTER_STATO_RICHIESTE = "filterStatoRichiesta";
    public static final String FILTER_OGGETTO_RICHIESTE = "filterOggettoRichiesta";
    public static final String FILTER_STATO_PAGAMENTO = "filterStatoPagamento";
    public static final String FILTER_OGGETTO_PAGAMENTO = "filterOggettoPagamento";
    public static final String FILTER_OGGETTO_COMUNICAZIONE = "filterOggettoComunicazione";
    public static final String FILTER_TIPO_COMUNICAZIONE = "filterTipoComunicazione";
    
    public static final String PARAM_ID = "id";
    public static final String PARAM_FILE_ID = "fileId";
    public static final String RICHIESTA = "richiesta";
    public static final String ALLEGATI_RICHIESTA = "allegatiRichiesta";
    public static final String ALLEGATI_PROVVEDIMENTI_FINALI = "allegatiProvvedimentiFinali";

    public static final String COMMENTI_RICHIESTA = "commentiRichiesta";
    public static final String COMMENTI_RICHIESTA_COUNT = "commentiRichiestaCount";
    public static final String ATTIVITA_RICHIESTA = "attivitaRichiesta";
    public static final String ATTIVITA_RICHIESTA_COUNT = "attivitaRichiestaCount";
    public static final String PDF_RICHIESTA = "pdfRichiesta";
    
    public static final String SEARCH_CONTAINER_NAME = "searchContainerName";
    public static final String SEARCH_CONTAINER_ATTIVITA = "attivita";
    public static final String SEARCH_CONTAINER_COMMENTI = "commenti";


    public static final String JSP_HOME = "/view.jsp";
    public static final String JSP_DETTAGLIO_RICHIESTA = "/dettaglio_richiesta.jsp";

    public static final String ERROR_IMPOSSIBILE_OTTENERE_DETTAGLIO = "error-impossiible-ottenere-dettaglio";
    
	public static final int DEFAULT_DELTA = 10;
	public static final String CUR_ATTIVITA = "curAttivita";
	public static final String CUR_COMMENTI = "curCommenti";
}