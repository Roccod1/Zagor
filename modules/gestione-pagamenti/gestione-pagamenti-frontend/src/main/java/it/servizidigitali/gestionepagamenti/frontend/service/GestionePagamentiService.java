package it.servizidigitali.gestionepagamenti.frontend.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(name = "getOrganizzazioniService", immediate = true, service = GestionePagamentiService.class)
public class GestionePagamentiService {
	
	public static final Log LOG = LogFactoryUtil.getLog(GestionePagamentiService.class);

	@Reference
	private OrganizationLocalService organizationLocalService;
	
	public List<Organization> getAllParentsOrganizations() {
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Organization.class, this.getClass().getClassLoader());
		dynamicQuery.add(RestrictionsFactoryUtil.eq("parentOrganizationId", 0L));
		
		return organizationLocalService.dynamicQuery(dynamicQuery);
	}
	
	public Organization getOrganization(long organizationId) {
		
		Organization organization = null;
		
		try {
			organization = organizationLocalService.getOrganization(organizationId);
		} catch (PortalException e) {
			LOG.error(e.getMessage(), e);
		}
		
		return organization;
	}
}