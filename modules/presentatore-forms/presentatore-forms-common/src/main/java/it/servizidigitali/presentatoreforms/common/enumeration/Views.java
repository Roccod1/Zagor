package it.servizidigitali.presentatoreforms.common.enumeration;

/**
 * Enumeration contenente le costanti riguardanti le view disponibili per la portlet.
 *
 * @author Damiano Miri
 *
 */
public enum Views {

	FORM_PRESENTER_HOME_VIEW("home"),
	FORM_PRESENTER_NO_SERVIZIO_SELEZIONATO_VIEW("noServizio"),
	FORM_PRESENTER_NO_SERVIZIO_ERROR_VIEW("noServizioError"),
	FORM_PRESENTER_ERROR_VIEW("error"),
	FORM_PRESENTER_NUOVA_VIEW("nuovaIstanza"),
	FORM_PRESENTER_SCEGLI_COMPONENTE_NUCLEO_FAMILIARE("scegliComponenteNucleoFamiliare"),
	FORM_PRESENTER_NUOVA_SUSS_VIEW("nuovaIstanzaSuss"),
	FORM_PRESENTER_SCEGLI_ALLEGATI("scegliAllegati"),
	FORM_PRESENTER_SCEGLI_INFORMAZIONI_INTEGRATIVE("scegliInformazioniIntegrative"),
	FORM_PRESENTER_COMPILA_INFORMAZIONI_INTEGRATIVE("compilaInformazioniIntegrative"),
	FORM_PRESENTER_SCEGLI_ALLEGATI_INFORMAZIONI_INTEGRATIVE("scegliAllegatiInformazioniIntegrative"),
	FORM_PRESENTER_DETTAGLIO_INFORMAZIONI_INTEGRATIVE("dettaglioInformazioniIntegrative"),
	FORM_RICERCA_COMUNICAZIONE("formRicercaComunicazione"),
	FORM_RICERCA_POSIZIONE_DEBITORIA("formRicercaPosizioneDebitoria"),
	FORM_RICERCA_PAGAMENTI("formRicercaPagamenti"),
	FORM_PRESENTER_DATI_NON_DISPONIBILI_VIEW("datiNonDisponibili"),
	FORM_PRESENTER_DATI_NON_DISPONIBILI_PER_CERTIFICATI_VIEW("datiNonDisponibiliPerCertificati"),
	FORM_PRESENTER_ESITO_INVIO_VIEW("esitoInvio"),
	FORM_PRESENTER_CONDIZIONI_NON_VERIFICATE_VIEW("condizioniNonVerificate"),
	

	COMUNICAZIONE_DETTAGLIO("dettaglioComunicazione"),
	POSIZIONE_DEBITORIA_DETTAGLIO("dettaglioPosizioneDebitoria"),
	
	VIRTUAL_DESK("virtualdesk"),
	ENTE_NOT_SEL("enteNonSelezionato"),
	DETTAGLIO_RICHESTA("dettaglioRichiesta"),
    VIRTUAL_WIDGET("virtualwidget"),
	
	CALENDAR_VIEW("calendar"),
	
	SCELTA_MODALITA_PAGAMENTO("sceltaModalitaPagamento"),
	ESITO_PAGAMENTO("esitoPagamento")
	;

	private String value;

	/**
	 *
	 */
	private Views(final String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
