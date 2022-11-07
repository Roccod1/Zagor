package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonObject;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio.VariazioneDomicilio;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiVariazioneDomicilioJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;

@Component(name = "indirizzoDomicilioJsonEnrich", immediate = true, service = DatiVariazioneDomicilioJsonEnrich.class)
public class IndirizzoDomicilioJsonEnrich implements DatiVariazioneDomicilioJsonEnrich {

	private final String indirizzoDomicilioKey = "indirizzoDomicilioObject";

	@Override
	public <T> void enrich(EnrichmentModel<T> enrichmentModel) {

		T sourceObject = enrichmentModel.getSourceObject();
		if (sourceObject instanceof DatiVariazioniDomicilio) {
			DatiVariazioniDomicilio datiVariazioniDomicilio = (DatiVariazioniDomicilio) sourceObject;

			JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();

			JsonObject indirizzoDomicilioContainer = alpacaJsonData.getAsJsonObject(indirizzoDomicilioKey);
			if (indirizzoDomicilioContainer != null) {

				// Variazione Domicilio

				String ultimoDomicilio = "";
				List<VariazioneDomicilio> listaDatiInridizzo = datiVariazioniDomicilio.getVariazioniDomicilio();
				if (listaDatiInridizzo.size() > 0) {

					VariazioneDomicilio vd = listaDatiInridizzo.get(listaDatiInridizzo.size() - 1);

					String via = "";
					String civico = "";
					String interno = "";
					String scala = "";
					String piano = "";

					if (vd.getIndirizzo() != null) {
						via = vd.getIndirizzo();

					}
					if (vd.getNumeroCivico() != null) {
						civico = ", " + vd.getNumeroCivico();

					}
					if (vd.getInterno() != null) {
						interno = " int. " + vd.getInterno();

					}
					if (vd.getScala() != null) {
						scala = " scala " + vd.getScala();

					}
					if (vd.getPiano() != null) {
						piano = " piano " + vd.getPiano();

					}

					ultimoDomicilio = via + civico + interno + scala + piano;

				}

				indirizzoDomicilioContainer.addProperty("indirizzoDomicilioPrecompilato", ultimoDomicilio);

				// Salvo
				alpacaJsonData.add(indirizzoDomicilioKey, indirizzoDomicilioContainer);
				enrichmentModel.setAlpacaJsonData(alpacaJsonData);
			}
		}
	}
}
