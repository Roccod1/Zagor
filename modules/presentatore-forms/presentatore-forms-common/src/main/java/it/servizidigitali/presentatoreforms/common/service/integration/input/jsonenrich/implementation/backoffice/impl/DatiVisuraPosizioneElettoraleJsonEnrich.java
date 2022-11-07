package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali.PosizioneElettorale;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiElettoraliJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;

/**
 * @author pindi
 *
 */
@Component(name = "datiVisuraPosizioneElettoraleJsonEnrich", immediate = true, service = DatiElettoraliJsonEnrich.class)
public class DatiVisuraPosizioneElettoraleJsonEnrich implements DatiElettoraliJsonEnrich {

	private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public final String visuraPosizioneElettoraleKey = "visuraElettorale";
	public final String tesseraElettoraleKey = "tesseraElettorale";
	public final String iscrizioneAlbiKey = "iscrizioneAlbi";

	/*
	 * (non-Javadoc)
	 *
	 * @see it.linksmt.servizionline.portlet.formpresenter.service.jsonenrich. JsonEnrich#
	 * enrich(it. linksmt.servizionline.portlet.formpresenter.service.jsonenrich.model.
	 * EnrichmentModel)
	 */
	@Override
	public <T> void enrich(EnrichmentModel<T> enrichmentModel) {
		T datiElettorali = enrichmentModel.getSourceObject();

		if (datiElettorali instanceof DatiElettorali) {

			List<PosizioneElettorale> posizioniElettorali = ((DatiElettorali) datiElettorali).getPosizioniElettorali();

			if (posizioniElettorali != null) {
				JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();

				String visuraPosizioneElettoraleNameDataContainer = visuraPosizioneElettoraleKey;

				if (visuraPosizioneElettoraleNameDataContainer != null) {
					JsonArray visuraPosizioneElettoraleDataContainer = alpacaJsonData.getAsJsonArray(visuraPosizioneElettoraleNameDataContainer);
					if (visuraPosizioneElettoraleDataContainer != null) {

						// Posizioni Elettorali //

						int i = 0;

						for (PosizioneElettorale ps : posizioniElettorali) {
							visuraPosizioneElettoraleDataContainer.add(new JsonObject());

							// Data Iscrizione
							Date dataIscrizione = ps.getDataVerbaleIscrizione();
							((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("cognomeNome", df.format(dataIscrizione));

							// Stato IScrizione
							if (df.format(dataIscrizione) != null) {

								((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("statoIscrizione", "iscritto");
							}
							else {
								((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("statoIscrizione", "non iscritto");
							}

							// Anno Iscrizione
							String annoiscrizione = ps.getAnnoIscrizione();
							((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("annoIscrizione", annoiscrizione);

							// Verbale Iscrizione
							String verbaleiscrizione = ps.getNumeroVerbaleIscrizione();
							((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("verbaleIscrizione", verbaleiscrizione);

							// Numero Sezione
							Integer numerosezione = ps.getNumeroSezione();
							((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("numeroSezione", numerosezione);

							// Numero Lista Generale
							String numerolistagenerale = ps.getNumeroListaGenerale();
							((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("numeroListaGenerale", numerolistagenerale);

							// numerolistasezionale
							String numerolistasezionale = ps.getNumeroListaSezionale();
							((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("numeroListaSezionale", numerolistasezionale);

							// descrizioneLista
							String descrizioneLista = ps.getDescrizioneLista();
							((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("descrizioneLista", descrizioneLista);

							// tipoElettore
							String tipoElettore = ps.getTipoElettore();
							((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("tipoElettore", tipoElettore);

							// numeroFascicolo
							String numeroFascicolo = ps.getNumeroFascicolo();
							((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("numeroFascicolo", numeroFascicolo);

							// numeroTesseraElettorale
							String numeroTesseraElettorale = ps.getNumeroTesseraElettorale();
							((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("numeroTesseraElettorale", numeroTesseraElettorale);

							// dataRilascioTesseraElett
							Date dataRilascioTesseraElett = ps.getDataRilascioTesseraElettorale();
							((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("dataRilascioTesseraElett", df.format(dataRilascioTesseraElett));

							// iscrizioneAlboScrutatori
							boolean iscrizioneAlboScrutatori = ps.getIscrizioneAlboScrutatori();
							if (iscrizioneAlboScrutatori == true) {
								((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("iscrizioneAlboScrutatori", "si");
							}
							else {
								((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("iscrizioneAlboScrutatori", "no");
							}
							// iscrizioneAlboPresidente
							boolean iscrizioneAlboPresidente = ps.getIscrizioneAlboScrutatori();
							if (iscrizioneAlboPresidente == true) {
								((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("iscrizioneAlboPresidente", "si");
							}
							else {
								((JsonObject) visuraPosizioneElettoraleDataContainer.get(i)).addProperty("iscrizioneAlboPresidente", "no");
							}
							i++;
						}
						// Salvataggio
						alpacaJsonData.add(visuraPosizioneElettoraleKey, visuraPosizioneElettoraleDataContainer);
						enrichmentModel.setAlpacaJsonData(alpacaJsonData);

					}
				}
			}
		}

	}
}
