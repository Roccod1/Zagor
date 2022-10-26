package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.enums.RelazioneParentela;
import it.servizidigitali.backoffice.integration.enums.StatoCivile;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalServiceUtil;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;
import it.servizidigitali.presentatoreforms.common.util.EnrichmentUtilService;

/**
 * @author ZONNOG
 *
 */
@Component(name = "anagrafeRichiedenteResidenzaJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class AnagrafeRichiedenteResidenzaJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(AnagrafeRichiedenteResidenzaJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	private static final String type = "anagrafeRichiedenteResidenza";
	private static final String datiFamiliareType = "datiFamiliare";
	private static final String CHECK_FAM_TRASF = "checkFamTrasf";

	@Override
	public <T> void enrich(EnrichmentModel<T> enrichmentModel) {
		T datiAnagrafici = enrichmentModel.getSourceObject();
		if (datiAnagrafici instanceof DatiAnagrafici) {

			// Nucleo familiare
			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleo = ((DatiAnagrafici) datiAnagrafici).getComponentiNucleoFamiliare();

			Organization organization;
			try {
				organization = organizationLocalService.getOrganization(enrichmentModel.getOrganizationId());
			}
			catch (PortalException e) {
				log.error("enrich :: " + e.getMessage(), e);
				throw new BackofficeServiceException("Errore durante il caricamento dell'organizzazione " + enrichmentModel.getOrganizationId(), e);
			}
			
			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiList = null;
			if (enrichmentModel.getUserPreferences().getCodiceFiscaleComponente() != null) {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equals(enrichmentModel.getUserPreferences().getCodiceFiscaleComponente())).collect(Collectors.toList());
			}
			else {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equals(enrichmentModel.getUserPreferences().getCodiceFiscaleRichiedente())).collect(Collectors.toList());
			}

			List<DatiAnagrafici.ComponenteNucleoFamiliare> altriComponentiList = null;

			JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();
			AlpacaJsonOptionsStructure alpacaJsonOptionsStructure = enrichmentModel.getAlpacaJsonOptionsStructure();

			// Dichiarante
			if (componentiList.size() == 1) {
				DatiAnagrafici.ComponenteNucleoFamiliare dichiarante = componentiList.get(0);
				altriComponentiList = componentiNucleo.stream().filter(p -> !p.getCodiceFiscale().equals(dichiarante.getCodiceFiscale())).collect(Collectors.toList());

				// Custom field
				String fieldNameDataContainer = AlpacaUtil.getFieldNameDataContainer(alpacaJsonOptionsStructure, type);
				if (fieldNameDataContainer != null) {
					JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(fieldNameDataContainer);
					if (fieldDataContainer != null) {

						fieldDataContainer.addProperty("identificativo", dichiarante.getIdentificativo());
						fieldDataContainer.addProperty("identificativoFamiglia", ((DatiAnagrafici) datiAnagrafici).getIdentificativoNucleoFamiliare());

						// Codice Fiscale
						String codiceFiscale = dichiarante.getCodiceFiscale();
						fieldDataContainer.addProperty("codicefiscale", codiceFiscale);

						// Nome
						String nome = dichiarante.getNome();
						fieldDataContainer.addProperty("nome", nome);
						// Cognome
						String cognome = dichiarante.getCognome();
						fieldDataContainer.addProperty("cognome", cognome);

						// Data nascita //
						fieldDataContainer.addProperty("datanascita", EnrichmentUtilService.getDataNascitaComponente(dichiarante));

						// Sesso
						String sesso = dichiarante.getSesso();
						fieldDataContainer.addProperty("sesso", sesso);

						StatoCivile statoCivile = dichiarante.getStatoCivile();
						if (statoCivile != null) {
							fieldDataContainer.addProperty("statoCivile", statoCivile.getCodice());
						}

						
						// Comune Nascita //
						String nomeComuneNascita = "";
						String codiceIstatComuneNascita = dichiarante.getCodiceIstatComuneNascita();
						if (codiceIstatComuneNascita != null) {
							Comune comune = comuneLocalService.getComuneByCodiceISTAT(codiceIstatComuneNascita);
							if (comune != null) {
								fieldDataContainer.addProperty("codiceIstatComuneNascitaHidden", codiceIstatComuneNascita);
								nomeComuneNascita = comune.getDenominazione();
								Provincia provincia = comune.getProvincia();
								if (provincia != null) {
									fieldDataContainer.addProperty("siglaProvinciaNascitaHidden", provincia.getSigla());
									nomeComuneNascita = nomeComuneNascita + " (" + provincia.getSigla() + ")";
								}
							}
						}

						// Se il componente è nato in uno stato estero
						if (dichiarante.getCodiceStatoEsteroNascita() != null || dichiarante.getDescrizioneStatoEsteroNascita() != null) {
							StatoEstero statoEsteroByCodiceOrDenominazione = 
									dichiarante.getCodiceStatoEsteroNascita() != null ?
									statoEsteroLocalService.getStatoEsteroByCodiceStato(dichiarante.getCodiceStatoEsteroNascita()):
									statoEsteroLocalService.getStatoEsteroByDenominazione(dichiarante.getDescrizioneStatoEsteroNascita());
									
									//Se non riesco a recuperare lo stato estero dalle info, mantengo la descrizione che mi arriva dal BO
									if (statoEsteroByCodiceOrDenominazione == null || Validator.isBlank(statoEsteroByCodiceOrDenominazione.getDenominazione())) {
										statoEsteroByCodiceOrDenominazione =  StatoEsteroLocalServiceUtil.createStatoEstero(0);
										statoEsteroByCodiceOrDenominazione.setDenominazione(dichiarante.getDescrizioneStatoEsteroNascita());
									}

									
							ComuneEstero comuneEstero = null;
							if (codiceIstatComuneNascita != null) {
								comuneEstero = comuneEsteroLocalService.getComuneEsteroByCodice(Integer.parseInt(codiceIstatComuneNascita));
							}
							else if (dichiarante.getDescrizioneComuneEsteroNascita() != null) {
								comuneEstero = comuneEsteroLocalService.getComuneEsteroByDenominazione(dichiarante.getDescrizioneComuneEsteroNascita());
							}

							if (comuneEstero != null) {
								nomeComuneNascita = comuneEstero.getDenominazione();
								fieldDataContainer.addProperty("codiceComuneEsteroNascitaHidden", String.valueOf(comuneEstero.getCodice()));
							}
							else {
								nomeComuneNascita = dichiarante.getDescrizioneComuneEsteroNascita();
								if (statoEsteroByCodiceOrDenominazione != null) {
									nomeComuneNascita += " (" + statoEsteroByCodiceOrDenominazione.getDenominazione() + ")";
								}
							}

							if (statoEsteroByCodiceOrDenominazione != null) {
								fieldDataContainer.addProperty("codiceStatoEsteroNascitaHidden", dichiarante.getCodiceStatoEsteroNascita() != null ? Integer.toString(dichiarante.getCodiceStatoEsteroNascita()) : "");
							}

						}

						fieldDataContainer.addProperty("luogoNascita", nomeComuneNascita);

						// Aggiungo
						alpacaJsonData.add(fieldNameDataContainer, fieldDataContainer);
					}
				}
			}

			// Altri componenti
			if (altriComponentiList != null) {
				String fieldNameDataContainer = AlpacaUtil.getFieldNameDataContainer(alpacaJsonOptionsStructure, datiFamiliareType);
				if (fieldNameDataContainer != null) {
					JsonArray fieldDataContainerArray = alpacaJsonData.getAsJsonArray(fieldNameDataContainer);
					if (fieldDataContainerArray == null) {
						fieldDataContainerArray = new JsonArray();
						int i = 0;
						for (DatiAnagrafici.ComponenteNucleoFamiliare componente : altriComponentiList) {
							JsonObject fieldDataContainer = new JsonObject();

							fieldDataContainer.addProperty("identificativo", componente.getIdentificativo());
							fieldDataContainer.addProperty("identificativoFamiglia", ((DatiAnagrafici) datiAnagrafici).getIdentificativoNucleoFamiliare());
							RelazioneParentela relazioneParentela = componente.getRelazioneParentela();
							if (relazioneParentela != null) {
								fieldDataContainer.addProperty("relazioneParentela", relazioneParentela.getCodice());
							}

							// Codice Fiscale
							String codiceFiscale = componente.getCodiceFiscale();
							fieldDataContainer.addProperty("codiceFiscale", codiceFiscale);

							// Nome
							String nome = componente.getNome();
							fieldDataContainer.addProperty("nome", nome);
							// Cognome
							String cognome = componente.getCognome();
							fieldDataContainer.addProperty("cognome", cognome);

							// Data nascita //
							fieldDataContainer.addProperty("datanascita", EnrichmentUtilService.getDataNascitaComponente(componente));

							// Sesso
							String sesso = componente.getSesso();
							fieldDataContainer.addProperty("sesso", sesso);

							StatoCivile statoCivile = componente.getStatoCivile();
							if (statoCivile != null) {
								fieldDataContainer.addProperty("statoCivile", statoCivile.getCodice());
							}

							
							
							// provenienzaNascita //
							String codiceIstat = componente.getCodiceIstatComuneNascita();
							JsonObject provenienzaNascitaJsonObject = new JsonObject();
							if (codiceIstat != null) {
								Comune comune = comuneLocalService.getComuneByCodiceISTAT(codiceIstat);
								if (comune != null) {
									Provincia provincia = comune.getProvincia();
									JsonObject provinciaComuneJsonObject = new JsonObject();
									provinciaComuneJsonObject.addProperty("comune", comune.getCodiceIstatAN());
									if (provincia != null) {
										provinciaComuneJsonObject.addProperty("provincia", provincia.getSigla());
									}
									provenienzaNascitaJsonObject.add("provinciaComune", provinciaComuneJsonObject);

									JsonObject nazioniJsonObject = new JsonObject();
									nazioniJsonObject.addProperty("stati", "100");
									provenienzaNascitaJsonObject.add("nazioni", nazioniJsonObject);

								}
							}

							if (componente.getDescrizioneComuneEsteroNascita() != null && !componente.getDescrizioneComuneEsteroNascita().isEmpty()) {
								ComuneEstero comuneEstero = comuneEsteroLocalService.getComuneEsteroByDenominazione(componente.getDescrizioneComuneEsteroNascita());
								if (comuneEstero != null) {
									provenienzaNascitaJsonObject.addProperty("comuneEstero", String.valueOf(comuneEstero.getCodice()));
									alpacaJsonData.addProperty(datiFamiliareType + "_" + i + "_provenienzaNascita_comuneEsteroText", comuneEstero.getDenominazione());
									alpacaJsonData.addProperty(datiFamiliareType + "_" + i + "_provenienzaNascita_comuneEsteroValue", String.valueOf(comuneEstero.getCodice()));
								}
							}
							if (componente.getCodiceStatoEsteroNascita() != null) {
								StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
								if (statoEsteroByCodiceStato != null) {
									JsonObject nazioniJsonObject = new JsonObject();
									nazioniJsonObject.addProperty("stati", String.valueOf(statoEsteroByCodiceStato.getCodiceStato()));
									provenienzaNascitaJsonObject.add("nazioni", nazioniJsonObject);
								}
							}
							fieldDataContainer.add("provenienzaNascita", provenienzaNascitaJsonObject);
							
							fieldDataContainerArray.add(fieldDataContainer);
							i++;
						}
						
						
						// Aggiungo
						alpacaJsonData.add(fieldNameDataContainer, fieldDataContainerArray);
						alpacaJsonData.addProperty(CHECK_FAM_TRASF, true);
					}
				}
			}
			enrichmentModel.setAlpacaJsonData(alpacaJsonData);
		}
	}
}
