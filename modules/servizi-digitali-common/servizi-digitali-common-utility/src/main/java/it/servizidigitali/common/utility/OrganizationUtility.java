package it.servizidigitali.common.utility;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;

@Component(name = "organizationUtility", service = OrganizationUtility.class)
public class OrganizationUtility {
	
	public Organization getByName(String name) {
		
		DynamicQuery dq = _organizationLocalService.dynamicQuery();
		dq.add(RestrictionsFactoryUtil.ilike("name", name));
		
		List<Organization> result = _organizationLocalService.dynamicQuery(dq);
		return result.isEmpty() ? null : result.get(0);
		
	}
	
	@Reference
	private OrganizationLocalService _organizationLocalService;

}
