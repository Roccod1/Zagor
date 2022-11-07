package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.util.EnrichmentUtilService;

/**
 * @author pindi
 *
 */
@Component(name = "datiNucleoFamiliareJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class DatiNucleoFamiliareJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(DatiNucleoFamiliareJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	public String fieldNameDataContainerKey = "nucleoFamiliare";
	
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
					JsonArray fieldDataArray = alpacaJsonData.getAsJsonArray(fieldNameDataContainer);
					if (fieldDataArray != null) {

						// Membri famiglia //

						int i = 0;

						if (componentiNucleo.size() > 1) {
							List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleoTemp = componentiNucleo;

							// componentiNucleoTemp.remove(dichiarante);

							for (DatiAnagrafici.ComponenteNucleoFamiliare membroFamiglia : componentiNucleoTemp) {

								if (membroFamiglia != componente) {

									String componenteFamiglia = "";

									((JsonObject) fieldDataArray.get(i)).addProperty("identificativo", componente.getIdentificativo());
									((JsonObject) fieldDataArray.get(i)).addProperty("identificativoFamiglia", ((DatiAnagrafici) datiAnagrafici).getIdentificativoNucleoFamiliare());

									// Nome e cognome //

									fieldDataArray.add(new JsonObject());
									componenteFamiglia = membroFamiglia.getCognome() + " " + membroFamiglia.getNome();
									((JsonObject) fieldDataArray.get(i)).addProperty("cognomeNome", componenteFamiglia);

									// Cod fisc. //

									((JsonObject) fieldDataArray.get(i)).addProperty("codiceFiscale", membroFamiglia.getCodiceFiscale());
									/*
									 * //ASSOCIA ALLA CHECKBOX IL COD FISC ((JsonObject)
									 * fieldDataArray.get(i)).addProperty("checkFamiliare",
									 * membroFamiglia.getCodiceFiscale());
									 */

									// Data e luogo nascita //
									((JsonObject) fieldDataArray.get(i)).addProperty("dataNascita", EnrichmentUtilService.getDataNascitaComponente(componente));

									String nomeComuneNascita = "";
									String nomeProvinciaNascita = "";
									String rigaNascita = "";
									String codiceIstat = membroFamiglia.getCodiceIstatComuneNascita();
									if (codiceIstat != null) {
										Comune comune = comuneLocalService.getComuneByCodiceISTAT(codiceIstat);
										if (comune != null) {
											nomeComuneNascita = comune.getDenominazione();
											rigaNascita = rigaNascita + nomeComuneNascita;
											Provincia provincia = comune.getProvincia();
											if (provincia != null) {
												nomeProvinciaNascita = provincia.getSigla();
												rigaNascita = rigaNascita + " (" + nomeProvinciaNascita + ")";
											}
										}
										else {
											try {
												ComuneEstero comuneEstero = comuneEsteroLocalService.getComuneEsteroByCodice(Integer.parseInt(codiceIstat));
												rigaNascita = rigaNascita + comuneEstero.getDenominazione();
											}
											catch (Exception e) {
												rigaNascita = "";
											}
										}
									}
									else {

										if (membroFamiglia.getDescrizioneComuneEsteroNascita() != null) {
											nomeComuneNascita = membroFamiglia.getDescrizioneComuneEsteroNascita();
											rigaNascita = rigaNascita + nomeComuneNascita;
											if (membroFamiglia.getCodiceStatoEsteroNascita() != null) {
												StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(membroFamiglia.getCodiceStatoEsteroNascita());
												nomeComuneNascita = nomeComuneNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
												rigaNascita = rigaNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
											}
										}
										else if (membroFamiglia.getCodiceStatoEsteroNascita() != null) {
											StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(membroFamiglia.getCodiceStatoEsteroNascita());
											nomeComuneNascita = nomeComuneNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
											rigaNascita = rigaNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
										}
									}
									((JsonObject) fieldDataArray.get(i)).addProperty("comuneNascita", rigaNascita);
									i++;
								}
							}
							// Salvo
							alpacaJsonData.add(fieldNameDataContainer, fieldDataArray);
							enrichmentModel.setAlpacaJsonData(alpacaJsonData);
						}

					}
				}
			}
		}
	}
}
