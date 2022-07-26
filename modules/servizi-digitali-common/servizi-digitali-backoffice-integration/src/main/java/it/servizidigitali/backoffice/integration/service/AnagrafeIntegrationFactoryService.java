package it.servizidigitali.backoffice.integration.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import java.io.Serializable;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author pindi
 *
 */
@Component(name = "anagrafeIntegrationFactoryService", immediate = true, service = AnagrafeIntegrationFactoryService.class)
public class AnagrafeIntegrationFactoryService {

	private static final Log log = LogFactoryUtil.getLog(AnagrafeIntegrationFactoryService.class.getName());

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference(target = "(component.name=anagrafeBackofficeIntegrationService)")
	private AnagrafeIntegrationService anagrafeBackofficeIntegrationService;

	@Reference(target = "(component.name=anagrafeANPRIntegrationService)")
	private AnagrafeIntegrationService anagrafeANPRIntegrationService;

	public AnagrafeIntegrationService getAnagrafeIntegrationService(long organizationId) {

		try {
			Organization organization = organizationLocalService.getOrganization(organizationId);

			Serializable anpr = organization.getExpandoBridge().getAttribute("anpr");
			if (anpr != null && Boolean.parseBoolean(anpr.toString())) {
				return anagrafeANPRIntegrationService;
			}
			else {
				return anagrafeBackofficeIntegrationService;
			}
		}
		catch (Exception e) {
			log.error("getAnagrafeIntegrationService :: " + e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

}
