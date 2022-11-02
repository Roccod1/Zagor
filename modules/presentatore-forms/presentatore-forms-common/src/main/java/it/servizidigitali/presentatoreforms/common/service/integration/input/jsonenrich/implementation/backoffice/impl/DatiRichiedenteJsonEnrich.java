package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

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

import it.servizidigitali.backoffice.integration.enums.StatoCivile;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;
import it.servizidigitali.presentatoreforms.common.util.EnrichmentUtilService;

/**
 * @author pindi
 *
 */
@Component(name = "datiRichiedenteJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class DatiRichiedenteJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(DatiRichiedenteJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	public final String typeAnagrafeRichiedente = "anagraferichiedente";
	public final String typeAnagrafeRichiedenteStessoComune = "anagraferichiedentestessocomune";
	public final String typeAnagrafeRichiedenteAltroMotivo = "anagraferichiedentealtromotivo";
	
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
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equals(enrichmentModel.getUserPreferences().getCodiceFiscaleComponente())).collect(Collectors.toList());
			}
			else {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equals(enrichmentModel.getUserPreferences().getCodiceFiscaleRichiedente())).collect(Collectors.toList());
			}
			if (componentiList.size() == 1) {

				DatiAnagrafici.ComponenteNucleoFamiliare componente = componentiList.get(0);

				JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();

				AlpacaJsonOptionsStructure alpacaJsonOptionsStructure = enrichmentModel.getAlpacaJsonOptionsStructure();

				// Custom field
				String fieldNameDataContainer = AlpacaUtil.getFieldNameDataContainer(alpacaJsonOptionsStructure, typeAnagrafeRichiedente);
				if (fieldNameDataContainer != null) {
					JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(fieldNameDataContainer);
					if (fieldDataContainer != null) {
						// Nome
						String nome = componente.getNome();
						fieldDataContainer.addProperty("nome", nome);
						// Cognome
						String cognome = componente.getCognome();
						fieldDataContainer.addProperty("cognome", cognome);
						// cittadinanza
						boolean cittadinanza = componente.isCittadinanzaItaliana();
						if (cittadinanza) {
							fieldDataContainer.addProperty("new1501144026093", "Italia");
						}

						fieldDataContainer.addProperty("identificativo", componente.getIdentificativo());
						fieldDataContainer.addProperty("identificativoFamiglia", ((DatiAnagrafici) datiAnagrafici).getIdentificativoNucleoFamiliare());

						// Codice Fiscale
						String codiceFiscale = componente.getCodiceFiscale();
						fieldDataContainer.addProperty("codicefiscale", codiceFiscale);
						// Sesso
						String sesso = "F";
						if (componente.getSesso().equalsIgnoreCase("M")) {
							sesso = "M";
						}
						fieldDataContainer.addProperty("sesso", sesso);

						// Data nascita //
						fieldDataContainer.addProperty("dataNascita", EnrichmentUtilService.getDataNascitaComponente(componente));

						StatoCivile statoCivile = componente.getStatoCivile();
						if (statoCivile != null) {
							fieldDataContainer.addProperty("statoCivile", statoCivile.getCodice());
						}

						// Provenienzanascita
						JsonObject jsonProvenienzaNascita = new JsonObject();

						// Se provenienza nascita Italia
						Integer codiceStatoEsteroNascita = componente.getCodiceStatoEsteroNascita();
						if (codiceStatoEsteroNascita == null || codiceStatoEsteroNascita == 100) {
							jsonProvenienzaNascita.addProperty("nazione", "Italia");
						}
						else {
							try {
								StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
								jsonProvenienzaNascita.addProperty("nazione", statoEsteroByCodiceStato.getDenominazione());
							}
							catch (Exception er) {
								log.error(er);
							}
						}

						// Comune nascita
						String codiceIstat = componente.getCodiceIstatComuneNascita();
						Comune comune = comuneLocalService.getComuneByCodiceISTAT(codiceIstat);
						if (comune != null) {
							jsonProvenienzaNascita.addProperty("comune", comune.getDenominazione());
							// Provincia nascita
							Provincia provincia = comune.getProvincia();
							jsonProvenienzaNascita.addProperty("provincia", provincia != null ? provincia.getSigla() : "");
						}
						fieldDataContainer.add("new1497618134104", jsonProvenienzaNascita);
						// Salvo
						alpacaJsonData.add(typeAnagrafeRichiedente, fieldDataContainer);
						alpacaJsonData.add(typeAnagrafeRichiedenteStessoComune, fieldDataContainer);
						alpacaJsonData.add(typeAnagrafeRichiedenteAltroMotivo, fieldDataContainer);
						alpacaJsonData.add(fieldNameDataContainer, fieldDataContainer);
						enrichmentModel.setAlpacaJsonData(alpacaJsonData);
					}
				}
			}
		}
	}
}
