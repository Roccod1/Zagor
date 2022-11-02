package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonObject;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.util.EnrichmentUtilService;

/**
 * @author pindi
 *
 */
@Component(name = "datiAnagraficiVisuraPosizioneElettoraleJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)

public class DatiAnagraficiVisuraPosizioneElettoraleJsonEnrich implements DatiAnagraficiJsonEnrich {

	public String fieldNameDataContainerKey = "anagraficavisuraposizioneelettorale";

	/*
	 * (non-Javadoc)
	 *
	 * @see it.linksmt.servizionline.portlet.formpresenter.service.jsonenrich.JsonEnrich# enrich(it.
	 * linksmt.servizionline.portlet.formpresenter.service.jsonenrich.model. EnrichmentModel)
	 */
	@Override
	public <T> void enrich(EnrichmentModel<T> enrichmentModel) {

		T datiAnagrafici = enrichmentModel.getSourceObject();
		if (datiAnagrafici instanceof DatiAnagrafici) {

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

				// Custom field
				// String fieldNameDataContainer =
				// AlpacaUtil.getFieldNameDataContainer(alpacaJsonOptionsStructure, type);
				String fieldNameDataContainer = fieldNameDataContainerKey;

				if (fieldNameDataContainer != null) {
					JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(fieldNameDataContainer);

					if (fieldDataContainer != null) {
						// Codice Fiscale
						String codiceFiscale = componente.getCodiceFiscale();
						fieldDataContainer.addProperty("codicefiscale", codiceFiscale);
						// Nome
						String nome = componente.getNome();
						fieldDataContainer.addProperty("nome", nome);
						// Cognome
						String cognome = componente.getCognome();
						fieldDataContainer.addProperty("cognome", cognome);
						// Data nascita //
						fieldDataContainer.addProperty("datanascita", EnrichmentUtilService.getDataNascitaComponente(componente));

						// Salvo
						alpacaJsonData.add(fieldNameDataContainerKey, fieldDataContainer);

						enrichmentModel.setAlpacaJsonData(alpacaJsonData);
					}
				}
			}
		}
	}
}
