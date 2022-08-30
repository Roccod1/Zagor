package it.servizidigitali.presentatoreforms.frontend.service.input.jsonenrich.implementation.backoffice.impl;

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
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.presentatoreforms.frontend.service.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.frontend.service.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.EnrichmentUtilService;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonOptionsStructure;

/**
 * @author pindi
 *
 */
@Component(name = "datiDichiaranteJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class DatiDichiaranteJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(DatiDichiaranteJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	public final String type = "anagrafeutente";

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
				throw new RuntimeException(e);
			}
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
				String fieldNameDataContainer = AlpacaUtil.getFieldNameDataContainer(alpacaJsonOptionsStructure, type);
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
							fieldDataContainer.addProperty("cittadinanza", "Italia");
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
						fieldDataContainer.addProperty("datanascita", EnrichmentUtilService.getDataNascitaComponente(componente));

						// Provenienzanascita
						JsonObject jsonProvenienzaNascita = new JsonObject();

						Integer codiceStatoEsteroNascita = componente.getCodiceStatoEsteroNascita();
						if (codiceStatoEsteroNascita == null || codiceStatoEsteroNascita == 100) {
							jsonProvenienzaNascita.addProperty("nazione", "Italia");
						}
						else {
							StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
							jsonProvenienzaNascita.addProperty("nazione", statoEsteroByCodiceStato.getDenominazione());
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
						fieldDataContainer.add("provenienzanascita", jsonProvenienzaNascita);

						String indirizzo = ((DatiAnagrafici) datiAnagrafici).getDescrizioneVia();
						if (indirizzo != null) {

							if (((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() != null) {
								indirizzo = ((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() + " " + indirizzo;
							}

							// Comune residenza
							if (organization != null) {
								String descrizione = organization.getName();
								fieldDataContainer.addProperty("residenza", descrizione);
							}

							// Localita
							// String localita = indirizzo.getLocalita();
							// jsonContent.addProperty("localita", localita != null ? localita :
							// "");

							// Via residenza
							fieldDataContainer.addProperty("via", indirizzo);

							// numero civico
							String numeroCivico = ((DatiAnagrafici) datiAnagrafici).getNumeroCivico();
							fieldDataContainer.addProperty("ncivico", numeroCivico);

							// scala
							String scala = ((DatiAnagrafici) datiAnagrafici).getScala();
							fieldDataContainer.addProperty("scala", scala);

							// piano
							String piano = ((DatiAnagrafici) datiAnagrafici).getPiano();
							fieldDataContainer.addProperty("piano", piano);

							// interno
							String interno = ((DatiAnagrafici) datiAnagrafici).getInterno();
							fieldDataContainer.addProperty("interno", interno);
						}
						// Salvo
						alpacaJsonData.add(fieldNameDataContainer, fieldDataContainer);
						enrichmentModel.setAlpacaJsonData(alpacaJsonData);
					}
				}
			}
		}
	}
}
