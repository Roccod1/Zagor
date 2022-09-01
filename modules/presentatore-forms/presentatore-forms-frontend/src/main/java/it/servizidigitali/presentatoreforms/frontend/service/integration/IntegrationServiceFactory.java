package it.servizidigitali.presentatoreforms.frontend.service.integration;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import it.servizidigitali.backoffice.integration.enums.TipoIntegrazione;
import it.servizidigitali.backoffice.integration.enums.TipoIntegrazioneBackoffice;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.BackofficeIntegrationService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.IntegrationService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.NucleoFamiliareIntegrationService;
import it.servizidigitali.presentatoreforms.frontend.service.integration.input.jsonenrich.JsonEnrich;

/**
 * @author pindi
 *
 */
@Component(name = "integrationServiceFactory", immediate = true, service = IntegrationServiceFactory.class)
public class IntegrationServiceFactory {

	private static final Log log = LogFactoryUtil.getLog(IntegrationServiceFactory.class.getName());

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	private volatile List<IntegrationService> inputIntegrationServices;

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	private volatile List<BackofficeIntegrationService> inputBackofficeIntegrationServices;

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	private volatile List<it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService> outputIntegrationServices;

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	private volatile List<NucleoFamiliareIntegrationService> inputNucleoFamiliareIntegrationServices;

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	private volatile List<JsonEnrich> jsonEnrichs;

	/**
	 * Mappa servizi di integrazione di input raggruppati per chiave "TipoIntegrazione".
	 */
	private Map<TipoIntegrazione, List<IntegrationService>> inputIntegrationServicesMap;
	private Map<TipoIntegrazione, Map<TipoIntegrazioneBackoffice, List<BackofficeIntegrationService>>> inputBackofficeIntegrationServicesMap;
	private Map<TipoIntegrazione, Map<String, it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService>> outputBackofficeIntegrationServicesMap;

	/**
	 * Mappa servizi di integrazione di output raggruppati per chiave "TipoIntegrazione" e per
	 * codice servizio (sotto mappa).
	 */

	private boolean initialized;

	private void init() {

		if (initialized) {
			return;
		}

		log.debug("Initializing integration services map...");

		inputBackofficeIntegrationServicesMap = new LinkedHashMap<TipoIntegrazione, Map<TipoIntegrazioneBackoffice, List<BackofficeIntegrationService>>>();
		if (inputBackofficeIntegrationServices != null) {
			for (BackofficeIntegrationService integrationService : inputBackofficeIntegrationServices) {
				Map<TipoIntegrazioneBackoffice, List<BackofficeIntegrationService>> innerMap = inputBackofficeIntegrationServicesMap.get(integrationService.getIntegrationType());
				if (innerMap == null) {
					innerMap = new LinkedHashMap<TipoIntegrazioneBackoffice, List<BackofficeIntegrationService>>();
					inputBackofficeIntegrationServicesMap.put(integrationService.getIntegrationType(), innerMap);
				}
				List<BackofficeIntegrationService> list = innerMap.get(integrationService.getBackofficeIntegrationType());
				if (list == null) {
					list = new ArrayList<BackofficeIntegrationService>();
					innerMap.put(integrationService.getBackofficeIntegrationType(), list);
				}
				list.add(integrationService);
			}
		}

		inputIntegrationServicesMap = new LinkedHashMap<TipoIntegrazione, List<IntegrationService>>();
		if (inputIntegrationServices != null) {
			for (IntegrationService integrationService : inputIntegrationServices) {
				List<IntegrationService> list = inputIntegrationServicesMap.get(integrationService.getIntegrationType());
				if (list == null) {
					list = new ArrayList<IntegrationService>();
					inputIntegrationServicesMap.put(integrationService.getIntegrationType(), list);
				}
				list.add(integrationService);
			}
		}

		outputBackofficeIntegrationServicesMap = new LinkedHashMap<TipoIntegrazione, Map<String, it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService>>();
		if (outputIntegrationServices != null) {
			for (it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService integrationService : outputIntegrationServices) {
				Map<String, it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService> innerMap = outputBackofficeIntegrationServicesMap
						.get(integrationService.getIntegrationType());
				if (innerMap == null) {
					innerMap = new LinkedHashMap<String, it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService>();
					outputBackofficeIntegrationServicesMap.put(integrationService.getIntegrationType(), innerMap);
				}
				innerMap.put(integrationService.getServiceCode(), integrationService);
			}
		}

		initialized = true;

		log.debug("Integration services map initialized");
	}

	@Modified
	private void update() {
		initialized = false;
	}

	/**
	 * @return the inputBackofficeIntegrationServicesMap
	 */
	public Map<TipoIntegrazione, Map<TipoIntegrazioneBackoffice, List<BackofficeIntegrationService>>> getInputBackofficeIntegrationServicesMap() {
		init();
		return inputBackofficeIntegrationServicesMap;
	}

	/**
	 * @return the inputIntegrationServicesMap
	 */
	public Map<TipoIntegrazione, List<IntegrationService>> getInputIntegrationServicesMap() {
		init();
		return inputIntegrationServicesMap;
	}

	/**
	 * @return the outputBackofficeIntegrationServicesMap
	 */
	public Map<TipoIntegrazione, Map<String, it.servizidigitali.presentatoreforms.frontend.service.integration.output.IntegrationService>> getOutputBackofficeIntegrationServicesMap() {
		init();
		return outputBackofficeIntegrationServicesMap;
	}

	/**
	 * @return the jsonEnrichs
	 */
	public List<JsonEnrich> getJsonEnrichs() {
		return jsonEnrichs;
	}

}
