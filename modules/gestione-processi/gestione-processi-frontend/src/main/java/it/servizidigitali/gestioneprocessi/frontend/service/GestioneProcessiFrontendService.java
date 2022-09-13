package it.servizidigitali.gestioneprocessi.frontend.service;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.camunda.integration.client.model.DeploymentResource;
import it.servizidigitali.camunda.integration.client.model.ProcessDefinition;
import it.servizidigitali.gestioneprocessi.exception.NoSuchProcessoException;
import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.service.ProcessoLocalService;

/**
 * @author pindi
 *
 */
@Component(name = "gestioneProcessiFrontendService", service = GestioneProcessiFrontendService.class, immediate = true)
public class GestioneProcessiFrontendService {

	private static final Log log = LogFactoryUtil.getLog(GestioneProcessiFrontendService.class.getName());

	@Reference
	private ProcessoLocalService processoLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private CamundaClient camundaClient;

	/**
	 *
	 * @param themeDisplay
	 */
	public void aggiornaProcessiPortale(ThemeDisplay themeDisplay) {

		List<DeploymentResource> defaultDeploymentResources = camundaClient.getDefaultDeploymentResources();
		if (defaultDeploymentResources != null) {
			for (DeploymentResource deploymentResource : defaultDeploymentResources) {
				ProcessDefinition processDefinition = deploymentResource.getProcessDefinition();
				Processo processoByDeploymentIdResourceId = null;
				try {
					processoByDeploymentIdResourceId = processoLocalService.getProcessoByCodice(processDefinition.getKey());
				}
				catch (NoSuchProcessoException e) {
				}

				if (processoByDeploymentIdResourceId == null) {
					log.debug("Creazione processo di default nel sistema: DeploymentID: " + deploymentResource.getDeploymentId() + ", ResourceId: " + deploymentResource.getId());

					Processo processo = processoLocalService.createProcesso(counterLocalService.increment());
					processo.setCodice(processDefinition.getKey());
					processo.setNome(processDefinition.getName());
					processo.setAttivo(true);
					processo.setUserId(themeDisplay.getUserId());
					processo.setGroupId(themeDisplay.getSiteGroupId());
					processo.setUserName(themeDisplay.getUser().getFullName());
					processo.setDeploymentId(deploymentResource.getDeploymentId());
					processo.setResourceId(deploymentResource.getId());
					processo.setModificabile(false);
					processoLocalService.updateProcesso(processo);
				}
				else {
					String deploymentId = processoByDeploymentIdResourceId.getDeploymentId();
					String resourceId = processoByDeploymentIdResourceId.getResourceId();
					if (!deploymentId.equals(deploymentResource.getDeploymentId()) && !resourceId.equals(deploymentResource.getId())) {
						// Aggiornamento riferimenti a processo
						processoByDeploymentIdResourceId.setDeploymentId(deploymentResource.getDeploymentId());
						processoByDeploymentIdResourceId.setResourceId(deploymentResource.getId());
						processoByDeploymentIdResourceId.setModificabile(false);
						processoLocalService.updateProcesso(processoByDeploymentIdResourceId);
					}
				}
			}
		}
	}
}
