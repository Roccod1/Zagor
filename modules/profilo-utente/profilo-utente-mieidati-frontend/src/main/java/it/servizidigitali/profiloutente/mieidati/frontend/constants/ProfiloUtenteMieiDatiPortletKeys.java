package it.servizidigitali.profiloutente.mieidati.frontend.constants;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.service.persistence.ExpandoColumnUtil;

/**
 * @author pindi
 */
public class ProfiloUtenteMieiDatiPortletKeys {

	public static final String PROFILOUTENTEMIEIDATI = "it_servizidigitali_profiloutente_mieidati_ProfiloUtenteMieiDatiPortlet";

//	sezioni
	public static final String SEZIONE_DATI_ANAGRAFICI = "sezioneDatiAnagrafici";
	public static final String SEZIONE_CONTATTI = "sezioneContatti";
	public static final String SEZIONE_NUCLEO_FAMILIARE = "sezioneNucleoFamiliare";
	
//	jsp
	public static final String JSP_DATI_ANAGRAFICI = "/datiAnagrafici.jsp";
	public static final String JSP_CONTATTI = "/contatti.jsp";
	public static final String JSP_NUCLEO_FAMILIARE = "/nucleoFamiliare.jsp";
	public static final String JSP_DATI_ANAGRAFICI_COMPONENTE_NUCLEO_FAMILIARE = "/datiAnagraficiComponenteNucleoFamiliare.jsp";
	public static final String JSP_HOME = "/view.jsp";
	
//	action command
	public static final String SALVA_EMAIL_ACTION_COMMAND_NAME = "/salvaEmail";
	
//	render command
	public static final String DETTAGLIO_COMPONENTE_NUCLEO_FAMILIARE_RENDER_COMMAND_NAME = "/dettaglioComponenteNucleoFamiliare";

//	parameter
	public static final String UTENTE = "utente";
	public static final String EMAIL_SECONDARIA = "emailSecondaria";
	public static final String COMPONENTI_NUCLEO_FAMILIARE = "listaComponentiNucleoFamiliare";
	public static final String CODICE_FISCALE = "codiceFiscale";
	public static final String COMPONENTE_NUCLEO_FAMILIARE = "componenteNucleoFamiliare";
	public static final String DETTAGLIO_COMPONENTE_NUCLEO_FAMILIARE_COMUNE_NASCITA = "comuneNascita";
	public static final String DETTAGLIO_COMPONENTE_NUCLEO_FAMILIARE_COMUNE_RESIDENZA = "comuneResidenza";
	public static final String TAB_ATTIVA = "tabAttiva";
	public static final String ORGANIZATION = "organization";
	public static final String ANPR = "anpr";
	public static final String NOME_FONTE = "nomeFonte";
	
//	campi expando utente
	public static final String EXPANDO_USER_PEC = "pec";
	public static final String EXPANDO_USER_EMAIL_AGGIUNTIVA = "emailAggiuntiva";
	public static final String EXPANDO_ORGANIZATION_ANPR = "anpr";
	
//	errori
	public static final String ERRORE_BACKOFFICE = "erroreBackoffice";
	public static final String ERRORE_GENERICO = "erroreGenerico";
}