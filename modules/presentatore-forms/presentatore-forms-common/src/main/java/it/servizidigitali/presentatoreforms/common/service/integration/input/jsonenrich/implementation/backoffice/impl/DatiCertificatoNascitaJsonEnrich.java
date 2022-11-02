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
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
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
@Component(name = "datiCertificatoNascitaJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class DatiCertificatoNascitaJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(DatiCertificatoNascitaJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public static final String CODICE_SERVIZIO_RICHIESTA_CERTIFICATO_NASCITA = "AC08";

	public String fieldNameDataContainerKey = "certificatoNascita";

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
						if (componente.getAnnoAttoNascita() == null) {
							throw new BackofficeServiceException(BackofficeServiceExceptionLanguageCode.ATTO_NON_PRESENTE);
						}

						// Inizio enrich

						// Premessa
						String premessaAtto = "L'UFFICIALE DELLO STATO CIVILE<br>VISTO IL REGISTRO DEGLI ATTI DI NASCITA DELL'ANNO ";
						String annoAttoNascita = componente.getAnnoAttoNascita();

						if (annoAttoNascita != null) {
							premessaAtto = premessaAtto + annoAttoNascita;
						}
						fieldDataContainer.addProperty("premessa", "<p>" + premessaAtto + "</p><p class='text-center'><b>CERTIFICA CHE</b></p>");

						// Cognome e nome 
						fieldDataContainer.addProperty("nomeCognome", "<p><b>" + componente.getCognomeNomeAttoNascita().toUpperCase() + "</b></p>");

						// luogo nascita 
						String rigaNascita = "E' " + EnrichmentUtilService.getBornLabelByGenderDichiarante(componente) + " IN ";

						if (componente.getDenominazioneComuneAttoNascita() != null) {
							rigaNascita += componente.getDenominazioneComuneAttoNascita();
						}
						
						fieldDataContainer.addProperty("rigaNascita", "<p>" + rigaNascita.toUpperCase() + "</p>");

						// data di nascita in lettere//
						String giornoNascita = "";
						String meseNascita = "";
						String annoNascita = "";
						String rigaGiornoMeseNascita = "";
						String rigaAnnoNascita = "";
						
						if (!componente.isDataNascitaSenzaGiorno()) {
							giornoNascita = componente.getGiornoStringaAttoNascita() != null ? componente.getGiornoStringaAttoNascita() : "";
								
						}
						if (!componente.isDataNascitaSenzaGiornoMese()) {
							meseNascita = componente.getMeseStringaAttoNascita() != null ? componente.getMeseStringaAttoNascita() : "";
						}
						annoNascita = componente.getAnnoStringaAttoNascita() != null ? componente.getAnnoStringaAttoNascita() : "";
						
						rigaGiornoMeseNascita += !Validator.isBlank(giornoNascita) ? "il giorno " + giornoNascita : "";
						rigaGiornoMeseNascita += !Validator.isBlank(rigaGiornoMeseNascita) ? " del mese di " : "nel mese di ";
						rigaGiornoMeseNascita = !Validator.isBlank(meseNascita) ? rigaGiornoMeseNascita + meseNascita : "";
															
						rigaAnnoNascita += !Validator.isBlank(rigaGiornoMeseNascita) ? "dell'anno " : "nell'anno ";
						rigaAnnoNascita = !Validator.isBlank(annoNascita) ? rigaAnnoNascita + annoNascita : "";
						
						fieldDataContainer.addProperty("rigaGiornoMeseNascita","<p>" + rigaGiornoMeseNascita.toUpperCase() + "</p>");
						fieldDataContainer.addProperty("rigaAnnoNascita","<p>" + rigaAnnoNascita.toUpperCase() + "</p>");

						// atto nascita //
						String attoNascita = componente.getNumeroAttoNascita();
						String infoNascita = "come risulta dall'atto n. ";

						if (attoNascita == null) {
							fieldDataContainer.addProperty("rigaAtto", "<p>" + infoNascita.toUpperCase() + "</p>");
						}
						else {
							infoNascita += attoNascita;
							if (!Validator.isBlank(componente.getParteAttoNascita())) {
								infoNascita += " parte " + componente.getParteAttoNascita();
							}
							if (!Validator.isBlank(componente.getSerieAttoNascita())) {
								infoNascita += " serie " + componente.getSerieAttoNascita();
							}
							if (!Validator.isBlank(componente.getVolumeAttoNascita())) {
								infoNascita += "<br>volume " + componente.getVolumeAttoNascita();
							}
							
							infoNascita = infoNascita.toUpperCase();
							
							if (!Validator.isBlank(componente.getUfficioAttoNascita())) {
								infoNascita +=
										!Validator.isBlank(componente.getVolumeAttoNascita()) ?
												"&emsp;&emsp;&emsp;" + componente.getUfficioAttoNascita().toUpperCase() :
												"<br> " + componente.getUfficioAttoNascita().toUpperCase();
							}
							fieldDataContainer.addProperty("rigaAtto", "<p>" + infoNascita + "</p>");
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
