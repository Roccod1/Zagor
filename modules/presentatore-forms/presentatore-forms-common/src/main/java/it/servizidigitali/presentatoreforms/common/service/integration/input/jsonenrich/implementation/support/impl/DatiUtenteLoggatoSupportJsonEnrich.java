package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.support.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.utility.UtenteUtility;
import it.servizidigitali.common.utility.model.IndirizzoResidenza;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.support.SupportJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;

/**
 * @author Gianluca Pindinelli
 *
 */
@Component(name = "datiUtenteLoggatoSupportJsonEnrich", immediate = true, service = SupportJsonEnrich.class)
public class DatiUtenteLoggatoSupportJsonEnrich implements SupportJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(DatiUtenteLoggatoSupportJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private UtenteUtility utenteUtility;
	
	public final String[] types = { "datiAngraficiCustomTwoCol", "datiLoggatoCustomTwoCol", "anagrafeRichiedenteResidenza", "anagrafeRichiedenteIscrizioneAltroMotivo",
			"anagrafeRichiedenteCambioResidenzaStessoComune" };



	@Override
	public <T> void enrich(EnrichmentModel<T> enrichmentModel) {

		T sourceObject = enrichmentModel.getSourceObject();

		if (sourceObject instanceof User) {
			User profiloUtenteCittadino = (User) sourceObject;

			// Oggetto json
			JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();
			
			AlpacaJsonOptionsStructure alpacaJsonOptionsStructure = enrichmentModel.getAlpacaJsonOptionsStructure();

			// Custom field
			List<String> fieldNamesDataContainer = AlpacaUtil.getAllFieldNameDataContainer(alpacaJsonOptionsStructure, types);
			UserPreferences userPreferences = enrichmentModel.getUserPreferences();
			String isDelegato = "false"; // FIXME Boolean.toString(userPreferences.getIdDelega() != null);
			
			String codiceFiscaleServizio = userPreferences.getCodiceFiscaleRichiedente();
			if (fieldNamesDataContainer != null && codiceFiscaleServizio.equals(profiloUtenteCittadino.getScreenName())) {
				for (String fieldNameDataContainer : fieldNamesDataContainer) {
					JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(fieldNameDataContainer);
					if (fieldDataContainer != null) {

						User liferayUser = null;
						try {
							liferayUser = UserLocalServiceUtil.getUserByScreenName(CompanyThreadLocal.getCompanyId(), profiloUtenteCittadino.getScreenName());
						}
						catch (PortalException e1) {
							log.error("enrich :: " + e1.getMessage(), e1);
						}
						catch (SystemException e1) {
							log.error("enrich :: " + e1.getMessage(), e1);
						}

						// Delegato
						fieldDataContainer.addProperty("isDelegato", isDelegato);
						// Nome
						String nome = profiloUtenteCittadino.getFirstName();
						fieldDataContainer.addProperty("nome", nome);
						// Cognome
						String cognome = profiloUtenteCittadino.getLastName();
						fieldDataContainer.addProperty("cognome", cognome);
						// Codice Fiscale
						String codiceFiscale = profiloUtenteCittadino.getScreenName();
						fieldDataContainer.addProperty("codiceFiscale", codiceFiscale);
						fieldDataContainer.addProperty("codicefiscale", codiceFiscale);

						if (liferayUser != null) {
							// Sesso
							String sesso = null;
							try {
								if (liferayUser.getFemale()) {
									sesso = "F";
								}
								if (liferayUser.getMale()) {
									sesso = "M";
								}
							}
							catch (PortalException e) {
								log.error("enrich :: " + e.getMessage(), e);
							}
							catch (SystemException e) {
								log.error("enrich :: " + e.getMessage(), e);
							}
							if (sesso != null) {
								fieldDataContainer.addProperty("sesso", sesso);
							}

							// Data nascita
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
							try {
								Date dataNascita = liferayUser.getBirthday();
								fieldDataContainer.addProperty("dataNascita", simpleDateFormat.format(dataNascita));
								fieldDataContainer.addProperty("datanascita", simpleDateFormat.format(dataNascita));
							}
							catch (PortalException e) {
								log.error("enrich :: " + e.getMessage(), e);
							}
							catch (SystemException e) {
								log.error("enrich :: " + e.getMessage(), e);
							}
						}

						// Comune nascita
						String nomeComuneNascita = "";
						String infoAggiuntive = null; 
						// FIXME sarà implementato un utenteUtility.get... che prenda le info aggiuntive da spid
						if (infoAggiuntive != null && !infoAggiuntive.trim().isEmpty()) {
							Gson gson = new Gson();
							Map<String, String> infoAggiuntiveMap = new HashMap<>();
							infoAggiuntiveMap = gson.fromJson(infoAggiuntive, infoAggiuntiveMap.getClass());
							if (infoAggiuntiveMap != null && infoAggiuntiveMap.containsKey("placeOfBirth")) {
								nomeComuneNascita = infoAggiuntiveMap.get("placeOfBirth");
							}
							else if (infoAggiuntiveMap != null && infoAggiuntiveMap.containsKey("\"placeOfBirth\"")) {
								nomeComuneNascita = infoAggiuntiveMap.get("\"placeOfBirth\"");
							}
						}

						// Se non trovo il luogo di nascita in info aggiuntive, lo cerco nella tabella componenti nucleo familiare
						// e se c'è mi ricavo il nome in modo da passarlo in modo analogo al resto del codice.

						
						if (!Validator.isNull(nomeComuneNascita)) {
							Comune comuneNascita = comuneLocalService.getComuneByDenominazione(nomeComuneNascita);
							if (comuneNascita == null) {
								// Da SPID potrebbe ritornare il codice catastale...
								comuneNascita = comuneLocalService.getComuneByCodiceCatastale(nomeComuneNascita);
							}
							if (comuneNascita != null) {
								fieldDataContainer.addProperty("codiceIstatComuneNascitaHidden", comuneNascita.getCodiceIstatAN());
								nomeComuneNascita = comuneNascita.getDenominazione();
								Provincia provincia = comuneNascita.getProvincia();
								if (provincia != null) {
									fieldDataContainer.addProperty("siglaProvinciaNascitaHidden", provincia.getSigla());
									nomeComuneNascita = nomeComuneNascita + " (" + provincia.getSigla() + ")";
								}
							}
						}

						fieldDataContainer.addProperty("luogoNascita", nomeComuneNascita);

						IndirizzoResidenza indirizzo = utenteUtility.getIndirizzoRedidenza(liferayUser.getCompanyId(), liferayUser.getScreenName());
						if (indirizzo != null) {
							// Comune residenza
							String comuneResidenza = indirizzo.getLuogo();
							String residenza = null;
							if (comuneResidenza != null) {
								String descrizione = comuneResidenza;
								residenza = descrizione;
								fieldDataContainer.addProperty("residenza", descrizione);
								fieldDataContainer.addProperty("comuneResHidden", descrizione);
								fieldDataContainer.addProperty("provinciaResHidden", indirizzo.getProvincia() != null ? indirizzo.getProvincia() : "");
							}

							// Via residenza
							String via = indirizzo.getIndirizzo();
							via = via == null ? "" : via;
							fieldDataContainer.addProperty("via", via);
							fieldDataContainer.addProperty("viaHidden", via);
							;
							// numero civico
							String civico = indirizzo.getCivico();
							fieldDataContainer.addProperty("ncivico", civico);
							fieldDataContainer.addProperty("civicoHidden", civico);
							if (civico != null) {
								civico = ", n. " + civico;
							}
							else {
								civico = "";
							}
							
						
							// TODO se si vogliono specificare ulteriori info di residenza (CAP, esponente, scala, etc.)
							// potrebbero essere messe a db nelle info_aggiuntive di tb_profilo_utente_cittadino di osapulie
							// e estratte/parsate qui da: profiloUtenteCittadino.getInfoAggiuntive()

							fieldDataContainer.addProperty("indirizzoResidenza", residenza != null ? via + civico + " (" + residenza + ")" : via + civico);
						
						}
						 
						alpacaJsonData.add(fieldNameDataContainer, fieldDataContainer);
					}
				}
				// Salvo
				enrichmentModel.setAlpacaJsonData(alpacaJsonData);
			}
		}
	}

	@Override
	public EnrichmentModel<?> generateEnrichmentModel(UserPreferences userPreferences) {
		User liferayUser = null;
		try {
			liferayUser = UserLocalServiceUtil.getUserByScreenName(CompanyThreadLocal.getCompanyId(), userPreferences.getCodiceFiscaleRichiedente());
		}
		catch (PortalException e1) {
			log.error("enrich :: " + e1.getMessage(), e1);
		}
		catch (SystemException e1) {
			log.error("enrich :: " + e1.getMessage(), e1);
		}
		EnrichmentModel<User> enrichmentModel = new EnrichmentModel<User>(liferayUser);
		return enrichmentModel;
	}

}
