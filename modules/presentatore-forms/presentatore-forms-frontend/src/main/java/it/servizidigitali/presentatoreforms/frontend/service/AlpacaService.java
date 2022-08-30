package it.servizidigitali.presentatoreforms.frontend.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.enums.TipoIntegrazione;
import it.servizidigitali.backoffice.integration.enums.TipoIntegrazioneBackoffice;
import it.servizidigitali.backoffice.integration.service.DatiAnagraficiPortletService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.BackofficeIntegrationService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.IntegrationService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.NucleoFamiliareIntegrationService;

/**
 * The Alpaca service.
 *
 * @author pindi
 *
 */
@Component(name = "alpacaService", immediate = true, service = AlpacaService.class)
public class AlpacaService {

	private static final Log log = LogFactoryUtil.getLog(AlpacaService.class.getName());

	@Reference
	private OrganizationLocalService organizationLocalService;

	private List<IntegrationService> inputIntegrationServices;

	@Reference
	private List<BackofficeIntegrationService> inputBackofficeIntegrationServices;

	private List<NucleoFamiliareIntegrationService> inputNucleoFamiliareIntegrationServices;

	private DatiAnagraficiPortletService datiAnagraficiPortletService;

	/**
	 * Mappa servizi di integrazione di input raggruppati per chiave "TipoIntegrazioneBackoffice" e
	 * per "tipo integrazione" (sottomappa).
	 */
	private Map<TipoIntegrazione, Map<TipoIntegrazioneBackoffice, List<BackofficeIntegrationService>>> inputBackofficeIntegrationServicesMap;

	/**
	 * Mappa servizi di integrazione di input raggruppati per chiave "TipoIntegrazione".
	 */
	private Map<TipoIntegrazione, List<IntegrationService>> inputIntegrationServicesMap;

	private List<it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService> outputIntegrationServices;
	/**
	 * Mappa servizi di integrazione di output raggruppati per chiave "TipoIntegrazione" e per
	 * codice servizio (sotto mappa).
	 */
	private Map<TipoIntegrazione, Map<String, it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService>> outputBackofficeIntegrationServicesMap;

	/**
	 * Inizializzazione variabili di classe.
	 */
	private void init() {

		inputBackofficeIntegrationServicesMap = new LinkedHashMap<TipoIntegrazione, Map<TipoIntegrazioneBackoffice, List<BackofficeIntegrationService>>>();
		if (inputBackofficeIntegrationServices != null) {
			for (BackofficeIntegrationService integrationService : inputBackofficeIntegrationServices) {
				Map<TipoIntegrazioneBackoffice, List<BackofficeIntegrationService>> innerMap = inputBackofficeIntegrationServicesMap.get(integrationService.getIntegrationType());
				if (innerMap == null) {
					innerMap = new LinkedHashMap<TipoIntegrazioneBackoffice, List<BackofficeIntegrationService>>();
					inputBackofficeIntegrationServicesMap.put(integrationService.getIntegrationType(), innerMap);
				}
				List<BackofficeIntegrationService> list = innerMap.get(integrationService.getBackofficeIntegrationType());
				if (list == null) {
					list = new ArrayList<BackofficeIntegrationService>();
					innerMap.put(integrationService.getBackofficeIntegrationType(), list);
				}
				list.add(integrationService);
			}
		}

		inputIntegrationServicesMap = new LinkedHashMap<TipoIntegrazione, List<IntegrationService>>();
		if (inputIntegrationServices != null) {
			for (IntegrationService integrationService : inputIntegrationServices) {
				List<IntegrationService> list = inputIntegrationServicesMap.get(integrationService.getIntegrationType());
				if (list == null) {
					list = new ArrayList<IntegrationService>();
					inputIntegrationServicesMap.put(integrationService.getIntegrationType(), list);
				}
				list.add(integrationService);
			}
		}

		outputBackofficeIntegrationServicesMap = new LinkedHashMap<TipoIntegrazione, Map<String, it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService>>();
		if (outputIntegrationServices != null) {
			for (it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService integrationService : outputIntegrationServices) {
				Map<String, it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService> innerMap = outputBackofficeIntegrationServicesMap
						.get(integrationService.getIntegrationType());
				if (innerMap == null) {
					innerMap = new LinkedHashMap<String, it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService>();
					outputBackofficeIntegrationServicesMap.put(integrationService.getIntegrationType(), innerMap);
				}
				innerMap.put(integrationService.getServiceCode(), integrationService);
			}
		}
	}

	public void test() {
		log.info(inputBackofficeIntegrationServices);
	}

	// /**
	// * Carica i dati relativi al form di Alpaca.
	// *
	// * @param data
	// * @param schema
	// * @param options
	// * @param request
	// * @param form
	// * @param codiceFiscaleComponente
	// */
	// public void loadData(final JsonObject data, final String schema, final String options, final
	// PortletRequest request, Form form, String codiceFiscaleComponente) {
	//
	// ServiziOnlineUser userInfo = serviziOnlineSessionUtil.getLoggedUser(request);
	//
	// String codiceServizio =
	// form.getDatiConfigurazioneProcedura().getCodiceIdentificativoServizio();
	//
	// Gson gson = new Gson();
	// AlpacaJsonOptionsStructure optionStr = gson.fromJson(options,
	// AlpacaJsonOptionsStructure.class);
	//
	// Set<Entry<String, JsonElement>> optionsFields = optionStr.getFields().entrySet();
	// // Carica i dati in base al valore di options
	// // TODO Non gestisce i campi annidati
	// for (Entry<String, JsonElement> entry : optionsFields) {
	//
	// String key = entry.getKey();
	// JsonElement value = entry.getValue();
	//
	// if (value != null && value.getAsJsonObject() != null) {
	//
	// JsonObject object = value.getAsJsonObject();
	//
	// if (object.get(AlpacaKey.TYPE.getName()) == null) {
	// continue;
	// }
	//
	// String type = object.get(AlpacaKey.TYPE.getName()).getAsString();
	//
	// if (type.equalsIgnoreCase(AlpacaOptionType.CONTATTI.getName())) {
	// data.addProperty(key, AlpacaUtil.buildContattiUrl(userInfo.getEnteID(), codiceServizio));
	// }
	// else if (type.equalsIgnoreCase(AlpacaOptionType.URL_DOCUMENTO.getName())) {
	// // Lettura del campo placeholder utilizzato come file name
	// JsonElement placeholderObject = object.get(AlpacaKey.PLACEHOLDER.getName());
	// String placeholder = "";
	//
	// if (placeholderObject != null) {
	// placeholder = placeholderObject.getAsString();
	// String portletUrl = buildPortletUrl(request, userInfo, codiceServizio, placeholder);
	//
	// // Utilizza la portlet URL generata
	// data.addProperty(key, portletUrl.toString());
	// }
	// else {
	// log.warn("Il valore del campo di tipo urldocumentofield con chiave " + key + " viene ignorato
	// perchè il placeholder è vuoto.");
	// }
	// }
	// }
	// }
	//
	// UserPreferences userPreferences = helper.getUserPreferences(request);
	// UserPreferences userPreferencesClone = (UserPreferences)
	// SerializationUtils.clone(userPreferences);
	// // Componente nucleo familare
	// if (codiceFiscaleComponente != null && !codiceFiscaleComponente.isEmpty()) {
	// userPreferencesClone.setCodiceFiscaleComponente(codiceFiscaleComponente);
	// }
	//
	// log.debug("CF ::>" + userPreferencesClone.getCodiceFiscaleServizio());
	//
	// // Enrichment
	// enrichAlpacaForm(optionStr, data, userPreferencesClone,
	// form.getDatiConfigurazioneProcedura());
	//
	// }
	//
	// /**
	// *
	// * @param datiRichiestaServizio
	// * @param userPreferences
	// * @return
	// */
	// public DichiarazioneRisposta sendData(DatiRichiestaServizio datiRichiestaServizio,
	// UserPreferences userPreferences) {
	//
	// DichiarazioneRisposta risposta = null;
	//
	// ComuneISA comuneByPk = comuneISAService.getComuneByPk(userPreferences.getIdComuneIsa());
	// if (comuneByPk != null && comuneByPk.getTipoIntegrazione() != null && datiRichiestaServizio
	// != null) {
	// TipoIntegrazione tipoIntegrazione = comuneByPk.getTipoIntegrazione();
	//
	// Map<String,
	// it.linksmt.servizionline.portlet.formpresenter.service.integration.output.IntegrationService>
	// integrationServicesMap = outputBackofficeIntegrationServicesMap
	// .get(tipoIntegrazione);
	// if (integrationServicesMap != null && !integrationServicesMap.isEmpty()) {
	// it.linksmt.servizionline.portlet.formpresenter.service.integration.output.IntegrationService
	// integrationService = integrationServicesMap
	// .get(datiRichiestaServizio.getCodiceIdentificativoServizio());
	// if (integrationService != null) {
	// risposta = integrationService.send(datiRichiestaServizio, userPreferences);
	// }
	// }
	// }
	// return risposta;
	// }
	//
	// /**
	// * Costruisce l'URL per la portlet.
	// *
	// * @param request La request.
	// * @param userInfo Lo user info.
	// * @param codiceServizio Il codice del servizio.
	// * @param placeholder Il placeholder.
	// * @return Restituisce l'URL per la portlet.
	// */
	// private String buildPortletUrl(PortletRequest request, ServiziOnlineUser userInfo, String
	// codiceServizio, String placeholder) {
	// Map<String, String> parameters = new HashMap<String, String>();
	// parameters.put("comune", userInfo.getEnteID());
	// parameters.put("servizio", codiceServizio);
	// parameters.put("documento", placeholder);
	// return LiferayUtil.buildPortletUrl(request, parameters, "downloadDocumento");
	// }
	//
	// /**
	// * Arricchisce il form Alpaca passato in input sulla base dei servizi di integrazione
	// esistenti.
	// *
	// * @param alpacaJsonOptionsStructure
	// * @param jsonObject
	// * @param userPreferences
	// * @param datiConfigurazioneProcedura
	// */
	// public void enrichAlpacaForm(AlpacaJsonOptionsStructure alpacaJsonOptionsStructure,
	// JsonObject jsonObject, UserPreferences userPreferences,
	// DatiConfigurazioneProcedura datiConfigurazioneProcedura) {
	//
	// ConfigurazioniFormPresenter configurazioniFormPresenter =
	// datiConfigurazioneProcedura.getConfigurazioniFormPresenter();
	//
	// String codiceServizio = datiConfigurazioneProcedura.getCodiceIdentificativoServizio();
	//
	// IntegrationPreferences integrationPreferences =
	// getIntegrationPreferences(datiConfigurazioneProcedura);
	//
	// // Aggiunta enrichment servizi di supporto
	// List<IntegrationService> supportIntegrationServices =
	// inputIntegrationServicesMap.get(TipoIntegrazione.SUPPORTO);
	// if (supportIntegrationServices != null) {
	// for (IntegrationService integrationService : supportIntegrationServices) {
	// integrationService.enrich(alpacaJsonOptionsStructure, jsonObject, userPreferences,
	// codiceServizio, integrationPreferences);
	// }
	// }
	//
	// // Enrichment sulla base del tipo di integrazione previsto dal Comune e sul tipo
	// // di TipoIntegrazioneBackoffice
	// ComuneISA comuneByPk = comuneISAService.getComuneByPk(userPreferences.getIdComuneIsa());
	// if (comuneByPk != null && comuneByPk.getTipoIntegrazione() != null &&
	// configurazioniFormPresenter != null && configurazioniFormPresenter.getConfigurazioneStep2()
	// != null) {
	//
	// TipoIntegrazione tipoIntegrazione = comuneByPk.getTipoIntegrazione();
	// ConfigurazioneStep2 configurazioneStep2 =
	// configurazioniFormPresenter.getConfigurazioneStep2();
	//
	// // Verifica integrazione ANPR (che deve vincere sui servizi di Backoffice Anagrafici)
	// boolean usaANPR = comuneByPk.isUsaANPR() && comuneByPk.getConfigurazioneANPR() != null &&
	// !comuneByPk.getConfigurazioneANPR().isEmpty();
	// if (usaANPR) {
	// List<TipoIntegrazioneBackoffice> tipiIntegrazioneBackoffice =
	// configurazioneStep2.getTipiIntegrazioneBackoffice();
	// if (tipiIntegrazioneBackoffice != null) {
	// for (TipoIntegrazioneBackoffice tipoIntegrazioneBackoffice : tipiIntegrazioneBackoffice) {
	// if (tipoIntegrazioneBackoffice.equals(TipoIntegrazioneBackoffice.VISURA_ANAGRAFICA)
	// ||
	// tipoIntegrazioneBackoffice.equals(TipoIntegrazioneBackoffice.VISURA_DATI_ANAGRAFICI_GENERALI)
	// || tipoIntegrazioneBackoffice.equals(TipoIntegrazioneBackoffice.VISURA_ELETTORALE)
	// ||
	// tipoIntegrazioneBackoffice.equals(TipoIntegrazioneBackoffice.VISURA_VARIAZIONI_DOMICILIARI))
	// {
	// tipoIntegrazione = TipoIntegrazione.ANPR;
	// break;
	// }
	// }
	// }
	// }
	//
	// Map<TipoIntegrazioneBackoffice, List<BackofficeIntegrationService>> integrationServiceMap =
	// inputBackofficeIntegrationServicesMap.get(tipoIntegrazione);
	// List<TipoIntegrazioneBackoffice> tipiIntegrazioneBackoffice =
	// configurazioneStep2.getTipiIntegrazioneBackoffice();
	// if (integrationServiceMap != null && !integrationServiceMap.isEmpty() &&
	// tipiIntegrazioneBackoffice != null) {
	// for (TipoIntegrazioneBackoffice tipoIntegrazioneBackoffice : tipiIntegrazioneBackoffice) {
	// List<BackofficeIntegrationService> backofficeIntegrationServices =
	// integrationServiceMap.get(tipoIntegrazioneBackoffice);
	// if (backofficeIntegrationServices != null) {
	// for (BackofficeIntegrationService backofficeIntegrationService :
	// backofficeIntegrationServices) {
	// backofficeIntegrationService.enrich(alpacaJsonOptionsStructure, jsonObject, userPreferences,
	// codiceServizio, integrationPreferences);
	// }
	// }
	// }
	// }
	// }
	//
	// // Sovrascrittura (se prevista) dei componenti nucleo familiare sulla base della
	// // configurazione form presenter
	// boolean componentiNucleoFamiliareFromProfiloEnable = false;
	//
	// if (configurazioniFormPresenter != null) {
	// TipoIntegrazioneNucleoFamiliare tipoIntegrazioneNucleoFamiliare =
	// configurazioniFormPresenter.getTipoIntegrazioneNucleoFamiliare();
	// componentiNucleoFamiliareFromProfiloEnable =
	// tipoIntegrazioneNucleoFamiliare.equals(TipoIntegrazioneNucleoFamiliare.PROFILO_UTENTE);
	// }
	//
	// if (componentiNucleoFamiliareFromProfiloEnable) {
	// nucleoFamiliareIntegrationServiceImpl.enrich(alpacaJsonOptionsStructure, jsonObject,
	// userPreferences, codiceServizio, integrationPreferences);
	// }
	// }
	//
	// /**
	// * Carica la lista dei componenti nucleo familiari sulla base dei servizi di integrazione
	// * esistenti.
	// *
	// * @param userPreferences
	// * @param datiConfigurazioneProcedura
	// * @return
	// */
	// public List<ComponenteNucleoFamiliareModel> getComponentiNucleoFamiliare(UserPreferences
	// userPreferences, DatiConfigurazioneProcedura datiConfigurazioneProcedura) {
	//
	// List<ComponenteNucleoFamiliareModel> componentiNucleoFamiliare = null;
	//
	// IntegrationPreferences integrationPreferences =
	// getIntegrationPreferences(datiConfigurazioneProcedura);
	//
	// ConfigurazioniFormPresenter configurazioniFormPresenter =
	// datiConfigurazioneProcedura.getConfigurazioniFormPresenter();
	// if (configurazioniFormPresenter != null) {
	//
	// TipoIntegrazioneNucleoFamiliare tipoIntegrazioneNucleoFamiliare =
	// configurazioniFormPresenter.getTipoIntegrazioneNucleoFamiliare();
	// switch (tipoIntegrazioneNucleoFamiliare) {
	// case AUTO:
	// try {
	// componentiNucleoFamiliare = getComponentiNucleoFamiliareFromBackoffice(userPreferences,
	// integrationPreferences);
	// }
	// catch (Exception e) {
	// log.warn("getComponentiNucleoFamiliare :: " + e.getMessage(), e);
	// }
	// if (componentiNucleoFamiliare == null) {
	// componentiNucleoFamiliare = getComponentiNucleoFamiliareFromProfiloUtente(userPreferences,
	// integrationPreferences);
	// }
	// break;
	// case BACKOFFICE:
	// componentiNucleoFamiliare = getComponentiNucleoFamiliareFromBackoffice(userPreferences,
	// integrationPreferences);
	// break;
	// case PROFILO_UTENTE:
	// componentiNucleoFamiliare = getComponentiNucleoFamiliareFromProfiloUtente(userPreferences,
	// integrationPreferences);
	// break;
	//
	// default:
	// break;
	// }
	// }
	//
	// return componentiNucleoFamiliare;
	// }
	//
	// /**
	// * @param codiceIdentificativoServizio
	// * @return
	// */
	// private IntegrationPreferences getIntegrationPreferences(DatiConfigurazioneProcedura
	// datiConfigurazioneProcedura) {
	//
	// IntegrationPreferences integrationPreferences = null;
	// if (datiConfigurazioneProcedura != null) {
	// integrationPreferences = new IntegrationPreferences();
	// ConfigurazioniFormPresenter configurazioniFormPresenter =
	// datiConfigurazioneProcedura.getConfigurazioniFormPresenter();
	// integrationPreferences.setCodiceServizio(datiConfigurazioneProcedura.getCodiceIdentificativoServizio());
	// if (configurazioniFormPresenter != null) {
	// integrationPreferences.setUsaCache(configurazioniFormPresenter.isAbilitaCacheIntegrazioneBackoffice());
	// }
	// }
	//
	// return integrationPreferences;
	// }
	//
	// /**
	// * @param userPreferences
	// * @return
	// */
	// private List<ComponenteNucleoFamiliareModel>
	// getComponentiNucleoFamiliareFromBackoffice(UserPreferences userPreferences,
	// IntegrationPreferences integrationPreferences) {
	//
	// List<ComponenteNucleoFamiliareModel> componentiNucleoFamiliare = null;
	// ComuneISA comuneByPk = comuneISAService.getComuneByPk(userPreferences.getIdComuneIsa());
	//
	// TipoIntegrazione tipoIntegrazione = comuneByPk.getTipoIntegrazione();
	//
	// // Verifica integrazione ANPR (che deve vincere sui servizi di Backoffice Anagrafici)
	// boolean usaANPR = comuneByPk.isUsaANPR() && comuneByPk.getConfigurazioneANPR() != null &&
	// !comuneByPk.getConfigurazioneANPR().isEmpty();
	// if (usaANPR) {
	// tipoIntegrazione = TipoIntegrazione.ANPR;
	// }
	//
	// for (NucleoFamiliareIntegrationService nucleoFamiliareIntegrationService :
	// inputNucleoFamiliareIntegrationServices) {
	// TipoIntegrazione integrationType = nucleoFamiliareIntegrationService.getIntegrationType();
	// if (integrationType.equals(tipoIntegrazione)) {
	// componentiNucleoFamiliare =
	// nucleoFamiliareIntegrationService.getComponentiNucleoFamiliare(userPreferences,
	// integrationPreferences);
	// }
	// }
	// return componentiNucleoFamiliare;
	// }
	//
	// /**
	// * @param userPreferences
	// * @return
	// */
	// private List<ComponenteNucleoFamiliareModel>
	// getComponentiNucleoFamiliareFromProfiloUtente(UserPreferences userPreferences,
	// IntegrationPreferences integrationPreferences) {
	// return nucleoFamiliareIntegrationServiceImpl.getComponentiNucleoFamiliare(userPreferences,
	// integrationPreferences);
	// }
	//
	// // NB: questo metodo contatta un rest che risponde il range per l'anno scolastico attuale di
	// // iscrizione del servizio!
	// public ResultCheckRangeEtaControlDto checkifServiceHaveARangeOfEta(String codiceIpa, String
	// codiceServizio) {
	// log.debug("AlpacaService :: checkifServiceHaveARangeOfEta");
	//
	// final String GET_CONFIGURAZIONE =
	// "/getConfRangeEtaByServizioAndCodiceIpa?codiceIpa={codiceIpa}&codiceServizio={codiceServizio}";
	// final String URL_REST_GET_CONF_RANGE_ETA = AlpacaApiRestPath.PRIVATE_BO_SERVER_ADDRESS +
	// AlpacaApiRestPath.CONFIGURAZIONE_SERVIZI_SCOLASTICI_API_PATH + GET_CONFIGURAZIONE;
	//
	// ResultCheckRangeEtaControlDto result = new ResultCheckRangeEtaControlDto();
	// Map<String, String> pars = new HashMap<String, String>();
	// pars.put("codiceIpa", codiceIpa);
	// pars.put("codiceServizio", codiceServizio);
	// RestTemplate restTemplate = new RestTemplate();
	// result = restTemplate.getForObject(URL_REST_GET_CONF_RANGE_ETA,
	// ResultCheckRangeEtaControlDto.class, pars);
	//
	// return result;
	// }
	//
	// // NB: questo metodo contatta un rest che risponde true/false per l'anno scolastico attuale
	// di
	// // iscrizione del servizio!
	// public Boolean checkOutOfRangeDateIscrizione(String codiceIpa, String codiceServizio, boolean
	// isOpSuss) {
	// log.debug("AlpacaService :: checkOutOfRangeDateIscrizione");
	//
	// final String URL_REST_GET_CONF_RANGE_DATE_ISCR = AlpacaApiRestPath.PRIVATE_BO_SERVER_ADDRESS
	// + AlpacaApiRestPath.CONFIGURAZIONE_SERVIZI_SCOLASTICI_API_PATH
	// +
	// "/checkOutOfRangeDateIscrizioneCurrentYear?codiceIpa={codiceIpa}&codiceServizio={codiceServizio}&isOpSuss={isOpSuss}";
	//
	// String checkOutOfRangeString;
	// Map<String, String> pars = new HashMap<String, String>();
	// pars.put("codiceIpa", codiceIpa);
	// pars.put("codiceServizio", codiceServizio);
	// pars.put("isOpSuss", Boolean.toString(isOpSuss));
	//
	// RestTemplate restTemplate = new RestTemplate();
	// checkOutOfRangeString = restTemplate.getForObject(URL_REST_GET_CONF_RANGE_DATE_ISCR,
	// String.class, pars);
	//
	// Boolean checkOutOfRange = Boolean.valueOf(checkOutOfRangeString);
	//
	// return checkOutOfRange;
	// }
	//
	// public Boolean checkEsistenzaRichiestaStessoAnnoScolastico(String codiceIpa, String
	// codiceServizio, String cfRichiedente, String cfMinore) {
	// log.debug("AlpacaService :: checkEsistenzaRichiestaStessoAnnoScolastico");
	//
	// final String URL_REST_CHECK_ESISTENZA_RICHIESTE = AlpacaApiRestPath.PRIVATE_BO_SERVER_ADDRESS
	// + SPORTELLO_SCOLASTICO_PORTLET_SERVIZISCOLASTICI_PATH
	// + "/checkIfRichiestaIscrizioneIsPresentAndNotRifiutataForCurrentYear" +
	// "?codiceIpa={codiceIpa}" + "&codiceServizio={codiceServizio}" +
	// "&cfRichiedente={cfRichiedente}"
	// + "&cfMinore={cfMinore}";
	//
	// String checkEsistenzaString;
	//
	// Map<String, String> pars = new HashMap<String, String>();
	// pars.put("codiceIpa", codiceIpa);
	// pars.put("codiceServizio", codiceServizio);
	// pars.put("cfRichiedente", cfRichiedente);
	// pars.put("cfMinore", cfMinore);
	// RestTemplate restTemplate = new RestTemplate();
	// checkEsistenzaString = restTemplate.getForObject(URL_REST_CHECK_ESISTENZA_RICHIESTE,
	// String.class, pars);
	//
	// Boolean checkEsistenza = Boolean.valueOf(checkEsistenzaString);
	//
	// return checkEsistenza;
	// }
	//
	// public Boolean checkEsistenzaRichiestaMinoreStessoAnnoScolastico(String codiceIpa, String
	// codiceServizio, String cfRichiedente) {
	// log.debug("AlpacaService :: checkEsistenzaRichiestaMinoreStessoAnnoScolastico");
	//
	// final String URL_REST_CHECK_ESISTENZA_RICHIESTE_MINORE =
	// AlpacaApiRestPath.PRIVATE_BO_SERVER_ADDRESS +
	// SPORTELLO_SCOLASTICO_PORTLET_SERVIZISCOLASTICI_PATH
	// + "/checkRichiestaIscrizioneMinorePresentAndStatoBloccanteForCurrentYear" +
	// "?codiceIpa={codiceIpa}" + "&codiceServizio={codiceServizio}";
	//
	// String checkEsistenzaString;
	//
	// List<ComponenteNucleoFamiliare> componentiList =
	// datiAnagraficiPortletService.getComponentiNucleoFamiliare(cfRichiedente, codiceIpa, null);
	//
	// String componenti = null;
	// if (componentiList != null) {
	// Gson gson = new Gson();
	// componenti = gson.toJson(componentiList);
	// }
	// else {
	// throw new RuntimeException("AlpacaService ::
	// checkEsistenzaRichiestaMinoreStessoAnnoScolastico :: Nessun componente familiare associato.
	// ");
	// }
	//
	// Map<String, String> pars = new HashMap<String, String>();
	// pars.put("codiceIpa", codiceIpa);
	// pars.put("codiceServizio", codiceServizio);
	//
	// HttpHeaders headers = new HttpHeaders();
	// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	// headers.setContentType(MediaType.APPLICATION_JSON);
	// headers.set("componenti", componenti);
	//
	// RestTemplate restTemplate = new RestTemplate();
	// checkEsistenzaString = restTemplate.getForObject(URL_REST_CHECK_ESISTENZA_RICHIESTE_MINORE,
	// String.class, pars);
	//
	// Boolean checkEsistenza = Boolean.valueOf(checkEsistenzaString);
	//
	// return checkEsistenza;
	// }
	//
	// public Boolean checkEsistenzaRichiestaRichiedenteStessoAnnoScolastico(String codiceIpa,
	// String codiceServizio, String cfRichiedente) {
	// log.debug("AlpacaService :: checkEsistenzaRichiestaRichiedenteStessoAnnoScolastico");
	//
	// final String URL_REST_CHECK_ESISTENZA_RICHIESTE_RICHIEDENTE =
	// AlpacaApiRestPath.PRIVATE_BO_SERVER_ADDRESS +
	// SPORTELLO_SCOLASTICO_PORTLET_SERVIZISCOLASTICI_PATH
	// + "/checkRichiestaIscrizioneRichiedentePresentAndStatoBloccanteForCurrentYear" +
	// "?codiceIpa={codiceIpa}" + "&codiceServizio={codiceServizio}" +
	// "&cfRichiedente={cfRichiedente}";
	//
	// String checkEsistenzaString;
	//
	// Map<String, String> pars = new HashMap<String, String>();
	// pars.put("codiceIpa", codiceIpa);
	// pars.put("codiceServizio", codiceServizio);
	// pars.put("cfRichiedente", cfRichiedente);
	//
	// RestTemplate restTemplate = new RestTemplate();
	// checkEsistenzaString =
	// restTemplate.getForObject(URL_REST_CHECK_ESISTENZA_RICHIESTE_RICHIEDENTE, String.class,
	// pars);
	//
	// Boolean checkEsistenza = Boolean.valueOf(checkEsistenzaString);
	//
	// return checkEsistenza;
	// }
	//
	// public List<GenericTextAndValueDto> getMinoriIscrivibiliServizio(String cfRichiedente, String
	// codiceIpa, String codiceServizio) {
	// log.debug("AlpacaService :: getMinoriIscrivibiliServizio");
	//
	// final String PRIVATE_BO_SERVER_ADDRESS =
	// EnvConfig.getProperty(CommonProperties.PRIVATE_BO_SERVER_ADDRESS);
	// final String SPORTELLO_SCOLASTICO_API_PATH = "/sportello-scolastico-portlet" +
	// RestMappings.SERVIZI_SCOLASTICI;
	//
	// List<GenericTextAndValueDto> result = new ArrayList<GenericTextAndValueDto>();
	//
	// List<ComponenteNucleoFamiliare> componentiList =
	// datiAnagraficiPortletService.getComponentiNucleoFamiliare2(cfRichiedente, codiceIpa, null);
	// HttpHeaders headers = new HttpHeaders();
	// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	// headers.setContentType(MediaType.APPLICATION_JSON);
	//
	// String componenti = null;
	// if (componentiList != null) {
	// Gson gson = new Gson();
	// componenti = gson.toJson(componentiList);
	// headers.set("componenti", componenti);
	//
	// }
	//
	// String url = PRIVATE_BO_SERVER_ADDRESS + SPORTELLO_SCOLASTICO_API_PATH +
	// "/getMinoriIscrivibiliServizio";
	// url = url + "?codiceIpa=" + codiceIpa + "&codiceServizio=" + codiceServizio +
	// "&cfRichiedente=" + cfRichiedente;
	//
	// HttpEntity<String> entity = new HttpEntity<String>(headers);
	//
	// RestTemplate restTemplate = new RestTemplate();
	//
	// ResponseEntity<GenericTextAndValueDto[]> response = restTemplate.exchange(url,
	// HttpMethod.GET, entity, GenericTextAndValueDto[].class);
	//
	// if (response.getStatusCode() != HttpStatus.OK) {
	// throw new RuntimeException("Errore durante il caricamento delle ComponenteNucleoFamiliare ::
	// codice di errore : " + response.getStatusCode());
	// }
	// result = Arrays.asList(response.getBody());
	//
	// return result;
	//
	// }
	//
	// public String getCheckResultSistemaInfanzia(String cfRichiedente, String codiceIpa) {
	// log.debug("AlpacaService :: getCheckResultSistemaInfanzia");
	//
	// final String PRIVATE_BO_SERVER_ADDRESS =
	// EnvConfig.getProperty(CommonProperties.PRIVATE_BO_SERVER_ADDRESS);
	// String url = PRIVATE_BO_SERVER_ADDRESS + SPORTELLO_SCOLASTICO_PORTLET_SERVIZISCOLASTICI_PATH
	// + "/getCheckResultSistemaInfanzia?codiceIpa={codiceIpa}&codiceFiscale={codiceFiscale}";
	//
	// Map<String, String> pars = new HashMap<String, String>();
	// pars.put("codiceIpa", codiceIpa);
	// pars.put("codiceFiscale", cfRichiedente);
	//
	// RestTemplate restTemplate = new RestTemplate();
	// ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, pars);
	//
	// if (response.getStatusCode() != HttpStatus.OK) {
	// throw new RuntimeException(
	// "Errore durante il controllo del sistema esterno iscrizione scuola infanzia :: codice di
	// errore : " + response.getStatusCode() + " :: messaggio errore: " + response.getBody());
	// }
	//
	// return response.getBody();
	//
	// }
}
