package it.servizidigitali.gestioneenti.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEnteFinder;

/**
 * @author filierim
 *
 */

@Component(service = ServizioEnteFinder.class)
public class ServizioEnteFinderImpl extends ServizioEnteFinderBaseImpl implements ServizioEnteFinder {

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
	
	@Override
	public ServizioEnte findServizioEnteByOrganizationIdLayoutId(long organizationId, long layoutId) {

		ClassLoader classLoader = getClass().getClassLoader();

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ServizioEnte.class, classLoader);
		Criterion criterion = null;

		criterion = RestrictionsFactoryUtil.eq("organizationId", organizationId);

		Criterion orCriterion = RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("privateLayoutId", layoutId), RestrictionsFactoryUtil.eq("publicLayoutId", layoutId));

		criterion = RestrictionsFactoryUtil.and(criterion, orCriterion);

		query.add(criterion);

		List<ServizioEnte> servizioEntes = servizioEntePersistence.findWithDynamicQuery(query);
		if (servizioEntes != null && !servizioEntes.isEmpty()) {
			return servizioEntes.get(0);
		}

		return null;
	}

}
