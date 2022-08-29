package it.servizidigitali.portal.modellistener;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.Organization;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.camunda.integration.configuration.CamundaConfiguration;

/**
 * Model Listener per gestire gli eventi relativi al model {@link Organization}.
 *
 * @author pindi
 */
@Component(//
		immediate = true, //
		service = ModelListener.class, //
		configurationPid = "it.servizidigitali.camunda.integration.configuration.CamundaConfiguration" //
)
public class OrganizationModelListener extends BaseModelListener<Organization> {

	private volatile CamundaConfiguration camundaConfiguration;

	private boolean camundaIntegrationEnabled;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		camundaConfiguration = ConfigurableUtil.createConfigurable(CamundaConfiguration.class, props);
		camundaIntegrationEnabled = camundaConfiguration.integrationEnabled();
	}

	@Reference
	private CamundaClient camundaClient;

	@Override
	public void onAfterCreate(Organization model) throws ModelListenerException {

		if (!camundaIntegrationEnabled) {
			return;
		}

		insertOrUpdateCamundaTenant(model);
		insertOrUpdateCamundaGroup(model);
	}

	@Override
	public void onAfterUpdate(Organization originalModel, Organization model) throws ModelListenerException {

		if (!camundaIntegrationEnabled) {
			return;
		}

		insertOrUpdateCamundaTenant(model);
		insertOrUpdateCamundaGroup(model);
	}

	@Override
	public void onAfterRemove(Organization model) throws ModelListenerException {

		if (!camundaIntegrationEnabled) {
			return;
		}

		// eliminazione tenant su Camunda BPMN Engine
		long parentOrganizationId = model.getParentOrganizationId();
		long organizationId = model.getOrganizationId();
		if (parentOrganizationId == 0) {
			// E' un organizzazione padre = è un Ente
			camundaClient.removeTenant(String.valueOf(organizationId));
		}
		else {
			// E' un organizzazione figlia = è una ripartizione dell'Ente
			camundaClient.removeGroup(String.valueOf(organizationId));
		}
	}

	/**
	 * @param model
	 */
	private void insertOrUpdateCamundaTenant(Organization model) {
		// creazione/aggiornamento tenant su Camunda BPMN Engine
		long parentOrganizationId = model.getParentOrganizationId();
		if (parentOrganizationId == 0) {
			// E' un organizzazione padre = è un Ente
			long organizationId = model.getOrganizationId();
			String organizationName = model.getName();
			camundaClient.insertOrUpdateTenant(String.valueOf(organizationId), organizationName);
		}
	}

	/**
	 * @param model
	 */
	private void insertOrUpdateCamundaGroup(Organization model) {

		long parentOrganizationId = model.getParentOrganizationId();
		if (parentOrganizationId != 0) {
			// E' un organizzazione figlia = è una ripartizione dell'Ente
			long organizationId = model.getOrganizationId();
			String organizationName = model.getName();
			camundaClient.inserOrUpdateGroup(String.valueOf(organizationId), organizationName, null);
		}

	}

	private static final Log _log = LogFactoryUtil.getLog(OrganizationModelListener.class);

}