package it.servizidigitali.profiloutente.preferenze.frontend.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(name = "profiloUtentePreferenzeMiddlewareService", immediate = true, service = ProfiloUtentePreferenzeMiddlewareService.class)
public class ProfiloUtentePreferenzeMiddlewareService {

	@Reference
	private OrganizationLocalService organizationLocalService;

	public List<Organization> getOrganizations(int inizio, int fine, OrderByComparator<Organization> ordine) {
		List<Organization> listaOrganizzazioni = new ArrayList<Organization>();

		ClassLoader classLoader = getClass().getClassLoader();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Organization.class, classLoader);

		listaOrganizzazioni = organizationLocalService.dynamicQuery(dynamicQuery, inizio, fine, ordine);

		return listaOrganizzazioni;
	}

	public Organization getOrganization(long organizationId) throws PortalException {
		Organization organization = null;

		if (organizationId > 0) {
			organization = organizationLocalService.getOrganization(organizationId);
		}

		return organization;
	}
}
