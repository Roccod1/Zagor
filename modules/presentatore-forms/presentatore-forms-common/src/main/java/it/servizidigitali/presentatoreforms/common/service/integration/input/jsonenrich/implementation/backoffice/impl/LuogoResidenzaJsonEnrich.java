package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonObject;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagraficiGenerali;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;

@Component(name = "luogoResidenzaJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class LuogoResidenzaJsonEnrich implements DatiAnagraficiJsonEnrich {


	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;


	public final String luogoResidenzaKey = "luogoResidenzaObject";

	@Override
	public <T> void enrich(EnrichmentModel<T> enrichmentModel) {
		T sourceObject = enrichmentModel.getSourceObject();
		if (sourceObject instanceof DatiAnagraficiGenerali) {
			DatiAnagraficiGenerali datiUtente = (DatiAnagraficiGenerali) sourceObject;
			// Nucleo familiare
			JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();

			JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(luogoResidenzaKey);
			if (fieldDataContainer != null && datiUtente != null) {

				String luogoResidenza = datiUtente.getComuneResidenza();

				if (datiUtente.getProvinciaResidenza() != null) {
					luogoResidenza += " (" + datiUtente.getProvinciaResidenza() + ")";
				}

				fieldDataContainer.addProperty("luogoResidenza", luogoResidenza);
				enrichmentModel.setAlpacaJsonData(alpacaJsonData);
			}
		}
	}
}