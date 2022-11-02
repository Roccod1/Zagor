package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.utility.enumeration.OrganizationCustomAttributes;
import it.servizidigitali.presentatoreforms.common.service.integration.enumeration.BackofficeServiceExceptionLanguageCode;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.util.EnrichmentUtilService;

/**
 * @author ZONNOG
 *
 */
@Component(name = "datiCertificatoMorteJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class DatiCertificatoMorteJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(DatiCertificatoMorteJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public String fieldNameDataContainerKey = "certificatoMorte";
	public static final String CODICE_SERVIZIO_RICHIESTA_CERTIFICATO_MORTE = "AC07";

	@Override
	public <T> void enrich(EnrichmentModel<T> enrichmentModel) {
		T datiAnagrafici = enrichmentModel.getSourceObject();
		if (datiAnagrafici instanceof DatiAnagrafici) {

			Organization organization;
			try {
				organization = organizationLocalService.getOrganization(enrichmentModel.getOrganizationId());
			}
			catch (PortalException e) {
				log.error("enrich :: " + e.getMessage(), e);
				throw new BackofficeServiceException("Errore durante il caricamento dell'organizzazione " + enrichmentModel.getOrganizationId(), e);
			}
			Comune comuneByCodice = comuneLocalService
					.getComuneByCodiceISTAT(organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_ISTAT.getNomeAttributo()).toString());

			// Nucleo familiare
			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleo = ((DatiAnagrafici) datiAnagrafici).getComponentiNucleoFamiliare();

			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiList = null;
			if (enrichmentModel.getUserPreferences().getCodiceFiscaleComponente() != null) {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equalsIgnoreCase(enrichmentModel.getUserPreferences().getCodiceFiscaleComponente())).collect(Collectors.toList());
			}
			else {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equalsIgnoreCase(enrichmentModel.getUserPreferences().getCodiceFiscaleRichiedente())).collect(Collectors.toList());
			}
			if (componentiList.size() == 1) {
				DatiAnagrafici.ComponenteNucleoFamiliare componente = componentiList.get(0);
				JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();

				String fieldNameDataContainer = fieldNameDataContainerKey;
				if (fieldNameDataContainer != null) {
					JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(fieldNameDataContainer);
					if (fieldDataContainer != null) {

						// Controllo se il certificato può essere scaricato
						if (componente.getAnnoAttoMorte() == null) {
							throw new BackofficeServiceException(BackofficeServiceExceptionLanguageCode.ATTO_NON_PRESENTE);
						}

						/*
						Map<String, Boolean> conditions = configurazioneService.getCondizioniGenerazioneCertificati(componente, CODICE_SERVIZIO_RICHIESTA_CERTIFICATO_MORTE,
								enrichmentModel.getUserPreferences().getIdComuneIsa());
						
						if (conditions != null && !conditions.get(DATA_NASCITA_CONDITION)) {
							log.info("enrich :: dataNascitaCondition : impossibile generare il certificato per : " + componente.getCodiceFiscale());

							throw new BackofficeServiceException(CondizioniScaricamentoEnum.DATA_MINIMA_CERT_MORTE.getKey());
						}
						

						String conditionValue = configurazioneService.getCondizioneGenerazioneCertficiati(DATA_NASCITA_CONDITION, CODICE_SERVIZIO_RICHIESTA_CERTIFICATO_MORTE,
								enrichmentModel.getUserPreferences().getIdComuneIsa());
						if (conditionValue != null) {

							log.info("condition value : " + conditionValue);

						}
						*/
						
						// Inizio enrich

						// Premessa
						String premessaAtto = "L'UFFICIALE DELLO STATO CIVILE<br>VISTO IL REGISTRO DEGLI ATTI DI MORTE DELL'ANNO ";
						String annoAttoMorte = componente.getAnnoAttoMorte();

						if (annoAttoMorte != null) {
							premessaAtto = premessaAtto + annoAttoMorte;
						}
						fieldDataContainer.addProperty("premessa", "<p>" + premessaAtto + "</p><p class='text-center'><b>CERTIFICA CHE</b></p>");

						
						// Cognome e nome
						fieldDataContainer.addProperty("nomeCognome", "<p><b>" + componente.getCognomeNomeAttoMorte().toUpperCase() + "</b></p>");

						// Data e luogo nascita 
						String rigaNascita = EnrichmentUtilService.getBornLabelByGenderDichiarante(componente) + "il ";
						if (componente.getDataNascitaAttoMorte() != null) {
							rigaNascita = rigaNascita + df.format(componente.getDataNascitaAttoMorte()) + " a ";
						}

						String nomeComuneNascita = "";
						String siglaProvinciaNascita = "";

						String comuneNascita = componente.getComuneNascitaAttoMorte();
						if (comuneNascita != null) {
							rigaNascita = rigaNascita + comuneNascita;
						}
						fieldDataContainer.addProperty("rigaNascita", rigaNascita.toUpperCase());

						// luogo morte
						String rigaLuogoMorte = null;
						
						String comuneMorte = componente.getDenominazioneComuneAttoMorte();
						if (comuneMorte != null) {
							rigaLuogoMorte = comuneMorte;
						}
						
						/*
						if (codiceIstatMorte != null) {
							Comune comuneMorte = comuneService.getComuneByCodiceISTAT(codiceIstatMorte);
							if (comuneMorte != null) {
								rigaLuogoMorte = comuneMorte.getDenominazione();
								
								Provincia provinciaMorte = comuneMorte.getProvincia();
								if (provinciaMorte != null) {
									rigaLuogoMorte += " (" + provinciaMorte.getSigla() + ")";
								}
							} else {
								try {
									ComuneEstero comuneEsteroMorte = comuneEsteroService.getComuneEsteroByCodice(Integer.parseInt(codiceIstatMorte));
									rigaLuogoMorte = comuneEsteroMorte.getDenominazione();
								}
								catch (Exception e) {
									rigaLuogoMorte = null;
								}
							}
						}
						*/
						rigaLuogoMorte = rigaLuogoMorte != null ? " IN " + rigaLuogoMorte : "";
						fieldDataContainer.addProperty("rigaLuogoMorte", "E' " + EnrichmentUtilService.getDeathLabelByGenderDichiarante(componente).toUpperCase() + rigaLuogoMorte.toUpperCase());

						// data di morte in lettere//
						String giornoMorte = "";
						String meseMorte = "";
						String annoMorte = "";
						String rigaGiornoMeseMorte = "";
						String rigaAnnoMorte = "";
						
						giornoMorte = componente.getGiornoStringaAttoMorte() != null ? componente.getGiornoStringaAttoMorte() : "";
								
						meseMorte = componente.getMeseStringaAttoMorte() != null ? componente.getMeseStringaAttoMorte() : "";
						
						annoMorte = componente.getAnnoStringaAttoMorte() != null ? componente.getAnnoStringaAttoMorte() : "";
						
						rigaGiornoMeseMorte += !Validator.isBlank(giornoMorte) ? "il giorno " + giornoMorte : "";
						rigaGiornoMeseMorte += !Validator.isBlank(rigaGiornoMeseMorte) ? " del mese di " : "nel mese di ";
						rigaGiornoMeseMorte = !Validator.isBlank(meseMorte) ? rigaGiornoMeseMorte + meseMorte : "";
															
						rigaAnnoMorte += !Validator.isBlank(rigaGiornoMeseMorte) ? "dell'anno " : "nell'anno ";
						rigaAnnoMorte = !Validator.isBlank(annoMorte) ? rigaAnnoMorte + annoMorte : "";
						
						fieldDataContainer.addProperty("rigaGiornoMeseMorte","<p>" + rigaGiornoMeseMorte.toUpperCase() + "</p>");
						fieldDataContainer.addProperty("rigaAnnoMorte","<p>" + rigaAnnoMorte.toUpperCase() + "</p>");

						// atto morte //
						String attoMorte = componente.getNumeroAttoMorte();
						String infoMorte = "come risulta dall'atto n. ";

						if (attoMorte == null) {
							fieldDataContainer.addProperty("attoMorte", "<p>" + infoMorte.toUpperCase() + "</p>");
						}
						else {
							infoMorte += attoMorte;
							if (!Validator.isBlank(componente.getParteAttoMorte())) {
								infoMorte += " parte " + componente.getParteAttoMorte();
							}
							if (!Validator.isBlank(componente.getSerieAttoMorte())) {
								infoMorte += " serie " + componente.getSerieAttoMorte();
							}
							if (!Validator.isBlank(componente.getUfficioAttoMorte())) {
								infoMorte += "<br> " + componente.getUfficioAttoMorte();
							}
							
							infoMorte = infoMorte.toUpperCase();

							fieldDataContainer.addProperty("attoMorte", "<p>" + infoMorte + "</p>");
						}
						// luogo e data del certificato //
						String comuneFirma = organization.getName().toUpperCase();
						Date dataEmissione = new Date();
						String infoVarie = "<p><br> " + comuneFirma + ", " + df.format(dataEmissione) + "</p>";
						fieldDataContainer.addProperty("infoVarie", infoVarie.toUpperCase());

						// Salvo
						alpacaJsonData.add(fieldNameDataContainer, fieldDataContainer);
						enrichmentModel.setAlpacaJsonData(alpacaJsonData);
					}
				}
			}
		}
	}
}
