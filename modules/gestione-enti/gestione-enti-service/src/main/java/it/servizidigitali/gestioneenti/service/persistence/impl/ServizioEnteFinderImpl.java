package it.servizidigitali.gestioneenti.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEnteFinder;

/**
 * @author pindi
 *
 */
@Component(service = ServizioEnteFinder.class)
public class ServizioEnteFinderImpl extends ServizioEnteFinderBaseImpl implements ServizioEnteFinder {

	@Override
	public List<ServizioEnte> findServizioEnteByFilters(long organizationId, List<Long> subOrganizationIds, Boolean attivo, long groupId, long companyId) {

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ServizioEnte.class, getClass().getClassLoader());
		dynamicQuery.add(RestrictionsFactoryUtil.eq("primaryKey.organizationId", organizationId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));

		if (attivo != null) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("attivo", attivo));
		}

		if (subOrganizationIds != null) {
			dynamicQuery.add(RestrictionsFactoryUtil.in("subOrganizationId", subOrganizationIds));
		}

		return servizioEntePersistence.findWithDynamicQuery(dynamicQuery);
	}
}
