package it.servizidigitali.scrivaniaoperatore.frontend.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.camunda.integration.client.exception.CamundaClientException;
import it.servizidigitali.camunda.integration.client.model.Task;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;

/**
 * @author pindi
 *
 */
@Component(name = "scrivaniaOperatoreFrontendService", service = ScrivaniaOperatoreFrontendService.class, immediate = true)
public class ScrivaniaOperatoreFrontendService {

	private static final Log log = LogFactoryUtil.getLog(ScrivaniaOperatoreFrontendService.class.getName());

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private CamundaClient camundaClient;

	/**
	 *
	 * @param serviceContext
	 * @return
	 */
	public List<ServizioEnte> getServiziEnte(ServiceContext serviceContext) {
		try {
			List<ServizioEnte> serviziEnte = servizioEnteLocalService.getServiziEnteByOrganizationIdSubOrganizationIdsAttivo(serviceContext.getScopeGroup().getOrganizationId(),
					getUserSubOrganizationIds(serviceContext), true, serviceContext.getScopeGroupId(), serviceContext.getCompanyId());

			return serviziEnte;
		}
		catch (PortalException e) {
			log.error("getServiziEnte :: " + e.getMessage(), e);
		}

		return null;
	}

	/**
	 * @param serviceContext
	 * @return
	 */
	public Set<Long> getProcedureIds(ServiceContext serviceContext) {

		List<ServizioEnte> serviziEnte = getServiziEnte(serviceContext);

		List<Long> serviziEnteIds = serviziEnte.stream().map(ServizioEnte::getServizioId).collect(Collectors.toList());

		List<Procedura> procedure = proceduraLocalService.getProcedureByServiziIdsGroupIdAttiva(serviziEnteIds, serviceContext.getScopeGroupId(), true);

		return procedure.stream().map(Procedura::getProceduraId).collect(Collectors.toSet());

	}

	/**
	 *
	 * @param serviceContext
	 * @return
	 */
	public Set<String> getProcessInstanceIds(ServiceContext serviceContext) {
		try {
			List<Long> organizationIds = getUserSubOrganizationIds(serviceContext);

			List<String> organizationIdsStrings = organizationIds.stream().map(Object::toString).collect(Collectors.toList());

			List<Task> searchTasks = camundaClient.searchTasks(String.valueOf(serviceContext.getScopeGroup().getOrganizationId()), organizationIdsStrings, null, false);

			Set<String> processInstanceIds = searchTasks.stream().map(Task::getProcessInstanceId).collect(Collectors.toSet());
			return processInstanceIds;
		}
		catch (PortalException e1) {
			log.error("getProcessInstanceIds :: " + e1.getMessage(), e1);
		}
		catch (CamundaClientException e1) {
			log.error("getProcessInstanceIds :: " + e1.getMessage(), e1);
		}
		return null;
	}

	/**
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	private List<Long> getUserSubOrganizationIds(ServiceContext serviceContext) throws PortalException {

		long userId = serviceContext.getUserId();
		User currentUser = userLocalService.getUser(userId);
		List<Long> organizationIds = currentUser.getOrganizations().stream().map(Organization::getOrganizationId).collect(Collectors.toList());
		return organizationIds;
	}

}
