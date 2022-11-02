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
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici.ComponenteNucleoFamiliare;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.model.StatoEstero;
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
@Component(name = "certificatoCostituzioneUnioneJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class CertificatoCostituzioneUnioneJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(CertificatoCostituzioneUnioneJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public final String certificatoUnioneKey = "certificatoUnione";
	public final String autorizzazioneKey = "autorizzazione";

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
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equals(enrichmentModel.getUserPreferences().getCodiceFiscaleComponente())).collect(Collectors.toList());
			}
			else {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equals(enrichmentModel.getUserPreferences().getCodiceFiscaleRichiedente())).collect(Collectors.toList());
			}
			if (componentiList.size() == 1) {
				DatiAnagrafici.ComponenteNucleoFamiliare componente = componentiList.get(0);

				JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();

				JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(certificatoUnioneKey);
				if (fieldDataContainer != null) {

					// Controllo se il certificato pu√≤ essere scaricato
					if (
							Validator.isBlank(componente.getAnnoAttoUnioneCivile()) ||
							Validator.isBlank(componente.getComuneResidenzaAttoUnioneCivile()) ||
							Validator.isBlank(componente.getComuneResidenzaUnitoAttoUnioneCivile())
					
					) {
						throw new BackofficeServiceException(BackofficeServiceExceptionLanguageCode.ATTO_NON_PRESENTE);
					}

					// Premessa
					String premessaAtto = "<b>L'UFFICIALE DELLO STATO CIVILE</b><br>in conformit‡† alle risultanze degli Atti di Unione civile di questo Comune,<br>";

					if (componente.getAnnoAttoUnioneCivile() != null) {
						premessaAtto = premessaAtto + "dell'anno " + componente.getAnnoAttoUnioneCivile();
					}
					if (componente.getParteAttoUnioneCivile() != null) {
						premessaAtto = premessaAtto + ", parte " + componente.getParteAttoUnioneCivile();
					}
					if (componente.getNumeroAttoUnioneCivile() != null) {
						premessaAtto = premessaAtto + ", numero " + componente.getNumeroAttoUnioneCivile();
					}
					if (componente.getUfficioAttoUnioneCivile() != null) {
						premessaAtto = premessaAtto + ", " + componente.getUfficioAttoUnioneCivile();
					}
					fieldDataContainer.addProperty("premessa", "<p>" + premessaAtto + "</p><p class='text-center'><b>CERTIFICA CHE :</b></p>");
					
					// Cognome e nome
					
					// il dato specifico per l'atto vince sul dato generico del componente
					if (!Validator.isBlank(componente.getNomeAttoUnioneCivile()) && !Validator.isBlank(componente.getCognomeAttoUnioneCivile())) {
						fieldDataContainer.addProperty("cognomeNome", "<p><b>" + componente.getCognomeAttoUnioneCivile() + " " + componente.getNomeAttoUnioneCivile() + "</b></p>");
					}
					
					// Data e luogo nascita //
					String rigaNascita = EnrichmentUtilService.getBornLabelByGenderDichiarante(componente) + "il ";
					
					// il dato specifico per l'atto vince sul dato generico del componente
					if (componente.getDataNascitaAttoUnioneCivile() != null) {
						rigaNascita = rigaNascita + df.format(componente.getDataNascitaAttoUnioneCivile()) + " a ";
					}
					
					// il dato specifico per l'atto vince sul dato generico del componente
					if (!Validator.isBlank(componente.getComuneNascitaAttoUnioneCivile())) {
						rigaNascita += componente.getComuneNascitaAttoUnioneCivile();
					}
					fieldDataContainer.addProperty("dataLuogoNascita", rigaNascita);
					
					// atto nascita
					String rigaAttoNascita = "";
					
					if (!Validator.isBlank(componente.getAttoNascitaAttoUnioneCivile())) {
						rigaAttoNascita += "atto N. " + componente.getAttoNascitaAttoUnioneCivile();
					}
					
					if (!Validator.isBlank(componente.getAttoNascitaTrascrittoAttoUnioneCivile())) {
						if (!Validator.isBlank(rigaAttoNascita)) {
							rigaAttoNascita += " --- ";
						}
						rigaAttoNascita += "atto tr. N. " + componente.getAttoNascitaTrascrittoAttoUnioneCivile();
						rigaAttoNascita += componente.getComuneAttoNascitaTrascrittoAttoUnioneCivile() != null ? 
								" a " + componente.getComuneAttoNascitaTrascrittoAttoUnioneCivile().toUpperCase() : "";
					}
					fieldDataContainer.addProperty("attoNascita", rigaAttoNascita);

					
					// residenza
					String rigaResidenza = "";
					
					// il dato specifico per l'atto vince sul dato generico del componente
					if (!Validator.isBlank(componente.getComuneResidenzaAttoUnioneCivile())) {
						rigaResidenza = componente.getComuneResidenzaAttoUnioneCivile();
					}
					
					if (!Validator.isBlank(rigaResidenza)) {
						fieldDataContainer.addProperty("luogoResidenza", "residente a " + rigaResidenza.toUpperCase());
					}

					// cognome nome unito civilmente
					String cognomeNomeUnito = "";
					
					// il dato specifico per l'atto vince sul dato generico del componente
					if (!Validator.isBlank(componente.getDenominazioneUnitoAttoUnioneCivile())) {
						cognomeNomeUnito = componente.getDenominazioneUnitoAttoUnioneCivile();
					} else {
					cognomeNomeUnito = !Validator.isBlank(componente.getCognomeUnitoAttoUnioneCivile()) ?
									componente.getCognomeUnitoAttoUnioneCivile() : "";
					cognomeNomeUnito += !Validator.isBlank(componente.getNomeUnitoAttoUnioneCivile()) ?
							" " + componente.getNomeUnitoAttoUnioneCivile() : "";
					}
					fieldDataContainer.addProperty("cognomeNomeUnito", "<b>" + cognomeNomeUnito + "</b>");
					
					
					// data e luogo nascita unito civilmente
					
					String dataLuogoNascitaUnito =  "";
					
					if (componente.getDataNascitaUnitoAttoUnioneCivile() != null) {
						dataLuogoNascitaUnito +=  "il " + df.format(componente.getDataNascitaUnitoAttoUnioneCivile());
					}
					
					if (componente.getComuneNascitaUnitoAttoUnioneCivile() != null) {
						dataLuogoNascitaUnito += " a " + componente.getComuneNascitaUnitoAttoUnioneCivile().toUpperCase();
					}
					
					if (!Validator.isBlank(dataLuogoNascitaUnito)) {
						//FIXME manca dato sesso unito civilmente
						dataLuogoNascitaUnito = EnrichmentUtilService.getBornLabelByGenderDichiarante(new ComponenteNucleoFamiliare()) + dataLuogoNascitaUnito;
						fieldDataContainer.addProperty("dataLuogoNascitaUnito", dataLuogoNascitaUnito);
					}
					
					// atto nascita unito civilmente
					String rigaAttoNascitaUnito = "";
					
					if (!Validator.isBlank(componente.getAttoNascitaUnitoAttoUnioneCivile())) {
						rigaAttoNascitaUnito += "atto N. " + componente.getAttoNascitaUnitoAttoUnioneCivile();
					}
					
					if (!Validator.isBlank(componente.getAttoNascitaTrascrittoUnitoAttoUnioneCivile())) {
						if (!Validator.isBlank(rigaAttoNascitaUnito)) {
							rigaAttoNascitaUnito += " --- ";
						}
						rigaAttoNascitaUnito += "atto tr. N. " + componente.getAttoNascitaTrascrittoUnitoAttoUnioneCivile();
						rigaAttoNascitaUnito += componente.getComuneAttoNascitaTrascrittoUnitoAttoUnioneCivile() != null ? 
								" a " + componente.getComuneAttoNascitaTrascrittoUnitoAttoUnioneCivile().toUpperCase() : "";
					}
					fieldDataContainer.addProperty("attoNascitaUnito", rigaAttoNascitaUnito);

					
					// luogo residenza unito civilmente
					if (componente.getComuneResidenzaUnitoAttoUnioneCivile() != null) {
						fieldDataContainer.addProperty("luogoResidenzaUnito", "residente a " + componente.getComuneResidenzaUnitoAttoUnioneCivile());
					}
					
					//data e luogo unione
					String dataLuogoUnione = "";
					if (componente.getDataAttoUnioneCivile() != null) {
						dataLuogoUnione += "il giorno " + df.format(componente.getDataAttoUnioneCivile());
					}
					String luogoUnione = "";
					if (componente.getCodiceIstatComuneAttoUnioneCivile() != null) {
						luogoUnione = getTestoLuogoByInfo(componente.getCodiceIstatComuneAttoUnioneCivile(), null, null);
					}
					if (Validator.isBlank(luogoUnione) && !Validator.isBlank(componente.getDenominazioneComuneAttoUnioneCivile())) {
						luogoUnione = componente.getDenominazioneComuneAttoUnioneCivile();
						
					}
					dataLuogoUnione += !Validator.isBlank(luogoUnione) ? " a " + luogoUnione.toUpperCase() : "";
					
					if (!Validator.isBlank(dataLuogoUnione)) {
						fieldDataContainer.addProperty("dataLuogoUnione", dataLuogoUnione);
					}
					
					//regime patrimoniale
					if (!Validator.isBlank(componente.getRegimePatrimonialeAttoUnioneCivile())) {
						fieldDataContainer.addProperty("regimePatrimonialeUnione", "scegliendo il regime patrimoniale della " + componente.getRegimePatrimonialeAttoUnioneCivile());
					}
					
					// cognome nome testimone 1
					String cognomeNomeTest1 = !Validator.isBlank(componente.getCognomeTestimone1AttoUnioneCivile()) ?
							componente.getCognomeTestimone1AttoUnioneCivile() : "";
					cognomeNomeTest1 += !Validator.isBlank(componente.getNomeTestimone1AttoUnioneCivile()) ?
							" " + componente.getNomeTestimone1AttoUnioneCivile() : "";
					cognomeNomeTest1 = "<b>" + cognomeNomeTest1 + "</b>";
					fieldDataContainer.addProperty("cognomeNomeTest1", cognomeNomeTest1);
					
					// data e luogo nascita testimone 1
					String dataLuogoNascitaTest1 =  "";
					
					if (componente.getDataNascitaTestimone1AttoUnioneCivile() != null) {
						dataLuogoNascitaTest1 +=  "il " + df.format(componente.getDataNascitaTestimone1AttoUnioneCivile());
					}

					String luogoNascitaTest1 = "";
					if (componente.getComuneNascitaTestimone1AttoUnioneCivile() != null) {
						luogoNascitaTest1 += " a " + componente.getComuneNascitaTestimone1AttoUnioneCivile().toUpperCase();
						if (componente.getProvinciaNascitaTestimone1AttoUnioneCivile() != null) {
							luogoNascitaTest1 += " " + componente.getProvinciaNascitaTestimone1AttoUnioneCivile().toUpperCase();
						}
					}
					
					if (!Validator.isBlank(componente.getStatoEsteroNascitaTestimone1AttoUnioneCivile())) {
						luogoNascitaTest1 += 
							Validator.isBlank(luogoNascitaTest1) ?
							" in " + componente.getStatoEsteroNascitaTestimone1AttoUnioneCivile().toUpperCase() :
							" ("+ componente.getStatoEsteroNascitaTestimone1AttoUnioneCivile().toUpperCase() + ")";
					}
					
					dataLuogoNascitaTest1 += luogoNascitaTest1;
					if (!Validator.isBlank(dataLuogoNascitaTest1)) {
						//FIXME manca dato sesso testimone 1
						dataLuogoNascitaTest1 = EnrichmentUtilService.getBornLabelByGenderDichiarante(new ComponenteNucleoFamiliare()) + dataLuogoNascitaTest1;
						fieldDataContainer.addProperty("dataLuogoNascitaTest1", dataLuogoNascitaTest1);
					}

					// cittadinanza testimone 1
					if (!Validator.isBlank(componente.getCittadinanzaTestimone1AttoUnioneCivile())) {
						fieldDataContainer.addProperty("cittadinanzaTest1", "di cittadinanza " + componente.getCittadinanzaTestimone1AttoUnioneCivile());
					}
					
					//luogo residenza testimone 1
					String luogoResidenzaTest1 = "";
					if (componente.getComuneResidenzaTestimone1AttoUnioneCivile() != null) {
						luogoResidenzaTest1 += " a " + componente.getComuneResidenzaTestimone1AttoUnioneCivile().toUpperCase();
						if (componente.getProvinciaResidenzaTestimone1AttoUnioneCivile() != null) {
							luogoResidenzaTest1 += " " + componente.getProvinciaResidenzaTestimone1AttoUnioneCivile().toUpperCase();
						}
					}
					
					if (
							!Validator.isBlank(componente.getStatoEsteroResidenzaTestimone1AttoUnioneCivile()) &&
							Validator.isBlank(componente.getProvinciaResidenzaTestimone1AttoUnioneCivile())
						) {
						luogoResidenzaTest1 += 
							Validator.isBlank(luogoResidenzaTest1) ?
							" in " + componente.getStatoEsteroResidenzaTestimone1AttoUnioneCivile().toUpperCase() :
							" ("+ componente.getStatoEsteroResidenzaTestimone1AttoUnioneCivile().toUpperCase() + ")";
					}
					
					if (!Validator.isBlank(luogoResidenzaTest1)) {
						fieldDataContainer.addProperty("luogoResidenzaTest1", "residente " + luogoResidenzaTest1);
					}
					
					
					// TESTIMONE 2
					
					// cognome nome testimone 2
					String cognomeNomeTest2 = !Validator.isBlank(componente.getCognomeTestimone2AttoUnioneCivile()) ?
							componente.getCognomeTestimone2AttoUnioneCivile() : "";
					cognomeNomeTest2 += !Validator.isBlank(componente.getNomeTestimone2AttoUnioneCivile()) ?
							" " + componente.getNomeTestimone2AttoUnioneCivile() : "";
					cognomeNomeTest2 = "<b>" + cognomeNomeTest2 + "</b>";
					fieldDataContainer.addProperty("cognomeNomeTest2", cognomeNomeTest2);
					
					// data e luogo nascita testimone 2
					String dataLuogoNascitaTest2 =  "";
					
					if (componente.getDataNascitaTestimone2AttoUnioneCivile() != null) {
						dataLuogoNascitaTest2 +=  "il " + df.format(componente.getDataNascitaTestimone2AttoUnioneCivile());
					}

					String luogoNascitaTest2 = "";
					if (componente.getComuneNascitaTestimone2AttoUnioneCivile() != null) {
						luogoNascitaTest2 += " a " + componente.getComuneNascitaTestimone2AttoUnioneCivile().toUpperCase();
						if (componente.getProvinciaNascitaTestimone2AttoUnioneCivile() != null) {
							luogoNascitaTest2 += " " + componente.getProvinciaNascitaTestimone2AttoUnioneCivile().toUpperCase();
						}
					}
					
					if (!Validator.isBlank(componente.getStatoEsteroNascitaTestimone2AttoUnioneCivile())) {
						luogoNascitaTest2 += 
							Validator.isBlank(luogoNascitaTest2) ?
							" in " + componente.getStatoEsteroNascitaTestimone2AttoUnioneCivile().toUpperCase() :
							" (" + componente.getStatoEsteroNascitaTestimone2AttoUnioneCivile().toUpperCase() + ")";
					}
					
					dataLuogoNascitaTest2 += luogoNascitaTest2;
					if (!Validator.isBlank(dataLuogoNascitaTest2)) {
						//FIXME manca dato sesso testimone 2
						dataLuogoNascitaTest2 = EnrichmentUtilService.getBornLabelByGenderDichiarante(new ComponenteNucleoFamiliare()) + dataLuogoNascitaTest2;
						fieldDataContainer.addProperty("dataLuogoNascitaTest2", dataLuogoNascitaTest2);
					}

					// cittadinanza testimone 2
					if (!Validator.isBlank(componente.getCittadinanzaTestimone2AttoUnioneCivile())) {
						fieldDataContainer.addProperty("cittadinanzaTest2", "di cittadinanza " + componente.getCittadinanzaTestimone2AttoUnioneCivile());
					}
					
					//luogo residenza testimone 2
					String luogoResidenzaTest2 = "";
					if (componente.getComuneResidenzaTestimone2AttoUnioneCivile() != null) {
						luogoResidenzaTest2 += " a " + componente.getComuneResidenzaTestimone2AttoUnioneCivile().toUpperCase();
						if (componente.getProvinciaResidenzaTestimone2AttoUnioneCivile() != null) {
							luogoResidenzaTest2 += " " + componente.getProvinciaResidenzaTestimone2AttoUnioneCivile().toUpperCase();
						}
					}
					
					if (
							!Validator.isBlank(componente.getStatoEsteroResidenzaTestimone2AttoUnioneCivile()) &&
							Validator.isBlank(componente.getProvinciaResidenzaTestimone2AttoUnioneCivile())
						) {						luogoResidenzaTest2 += 
							Validator.isBlank(luogoResidenzaTest2) ?
							" in " + componente.getStatoEsteroResidenzaTestimone2AttoUnioneCivile().toUpperCase() :
							" ("+ componente.getStatoEsteroResidenzaTestimone2AttoUnioneCivile().toUpperCase() + ")";
					}
					
					if (!Validator.isBlank(luogoResidenzaTest2)) {
						fieldDataContainer.addProperty("luogoResidenzaTest2", "residente " + luogoResidenzaTest2);
					}
		
					// cittaEmissione + Data odierna
					String citta = organization.getName().toUpperCase();
					Date today = new Date();
					String dftoday = df.format(today);
					String cittaEmissione = citta + ", " + dftoday;
					fieldDataContainer.addProperty("cittaEmissione", "<p><br> "+ cittaEmissione + "</p>");
		
					alpacaJsonData.add(certificatoUnioneKey, fieldDataContainer);
					enrichmentModel.setAlpacaJsonData(alpacaJsonData);
				}
			
			}
		}
	}
	
	/**
	 * @param codiceIstat
	 * @param codiceStatoString nullable
	 * @param descrizioneStato nullable
	 * @return il testo, il piu completo possibile, descrittivo del luogo, con comune, provincia oppure comune estero e/o stato. Stringa "" se no info.
	 */
	private String getTestoLuogoByInfo(String codiceIstat, String codiceStatoString, String descrizioneStato) {
		String testo = "";
		Integer codiceStato = null;
		try {
			codiceStato = Integer.parseInt(codiceStatoString);
		}
		catch (Exception e) {
			codiceStato = null;
		}
		String nomeComune = "";
		String siglaProvincia = "";
		if (codiceIstat != null) {
			Comune comune = comuneLocalService.getComuneByCodiceISTAT(codiceIstat);
			if (comune != null) {
				nomeComune = comune.getDenominazione();
				testo = testo + nomeComune;
				Provincia provincia = comune.getProvincia();
				if (provincia != null) {
					siglaProvincia = provincia.getSigla();
					testo = testo + " (" + siglaProvincia + ")";
				}
			}
			else {
				try {
					ComuneEstero comuneEstero = comuneEsteroLocalService.getComuneEsteroByCodice(Integer.parseInt(codiceIstat));
					testo = testo + comuneEstero.getDenominazione();
				}
				catch (Exception e) {
					testo = "";
				}
			}
		}
		else {

			if (descrizioneStato != null) {
				nomeComune = descrizioneStato;
				testo = testo + nomeComune;
				if (codiceStato != null) {
					StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(codiceStato);
					testo = testo + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
				}
			}
			else if (codiceStato != null) {
				StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(codiceStato);
				testo = testo + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
			}
		}
		return testo;
	}
	
}
