package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonObject;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;
import it.servizidigitali.presentatoreforms.common.util.EnrichmentUtilService;

/**
 * @author pindi
 *
 */
@Component(name = "anagrafeTariNonDomesticaJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class AnagrafeTariNonDomesticaJsonEnrich implements DatiAnagraficiJsonEnrich {

	public final String type = "anagrafeTariNonDomestica";
	public final String typeNoStradario = "anagrafeTariNonDomesticaNoStradario";
	

	@Override
	public <T> void enrich(EnrichmentModel<T> enrichmentModel) {
		T datiAnagrafici = enrichmentModel.getSourceObject();
		if (datiAnagrafici instanceof DatiAnagrafici) {

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

				AlpacaJsonOptionsStructure alpacaJsonOptionsStructure = enrichmentModel.getAlpacaJsonOptionsStructure();

				// Custom field
				String fieldNameDataContainer = AlpacaUtil.getFieldNameDataContainer(alpacaJsonOptionsStructure, type);
				if(fieldNameDataContainer == null) {
					fieldNameDataContainer = AlpacaUtil.getFieldNameDataContainer(alpacaJsonOptionsStructure, typeNoStradario);
				}
				if (fieldNameDataContainer != null) {
					JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(fieldNameDataContainer);
					if (fieldDataContainer != null) {

						fieldDataContainer.addProperty("identificativo", componente.getIdentificativo());
						fieldDataContainer.addProperty("identificativoFamiglia", ((DatiAnagrafici) datiAnagrafici).getIdentificativoNucleoFamiliare());

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

						// Sesso
						String sesso = componente.getSesso();
						fieldDataContainer.addProperty("sesso", sesso);

						// Comune Nascita //
						// String nomeComuneNascita = "";
						//
						// String codiceIstat = componente.getCodiceIstatComuneNascita();
						// if (codiceIstat != null) {
						// Comune comune = comuneService.getComuneByCodiceISTAT(codiceIstat);
						// if (comune != null) {
						// nomeComuneNascita = comune.getDenominazione();
						// Provincia provincia = comune.getProvincia();
						// if (provincia != null) {
						// nomeComuneNascita = nomeComuneNascita + " (" +
						// provincia.getDenominazioneProvincia() + ")";
						// }
						// }
						// else {
						// try {
						// ComuneEstero comuneEstero =
						// comuneEsteroService.getComuneEsteroByCodice(Integer.parseInt(codiceIstat));
						// nomeComuneNascita = comuneEstero.getDenominazione();
						// }
						// catch (NumberFormatException e) {
						// nomeComuneNascita = "";
						// }
						// }
						// }
						// else {
						//
						// if (componente.getDescrizioneComuneEsteroNascita() != null) {
						// nomeComuneNascita = componente.getDescrizioneComuneEsteroNascita();
						// if (componente.getCodiceStatoEsteroNascita() != null) {
						// StatoEstero statoEsteroByCodiceStato =
						// statoEsteroService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
						// nomeComuneNascita = nomeComuneNascita + " (" +
						// statoEsteroByCodiceStato.getDenominazione() + ")";
						// }
						// }
						// else if (componente.getCodiceStatoEsteroNascita() != null) {
						// StatoEstero statoEsteroByCodiceStato =
						// statoEsteroService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
						// nomeComuneNascita = nomeComuneNascita + " (" +
						// statoEsteroByCodiceStato.getDenominazione() + ")";
						// }
						// }
						// fieldDataContainer.addProperty("provenienzaNascita", nomeComuneNascita);

						// Salvo
						alpacaJsonData.add(fieldNameDataContainer, fieldDataContainer);
						enrichmentModel.setAlpacaJsonData(alpacaJsonData);
					}
				}
			}
		}
	}
}
