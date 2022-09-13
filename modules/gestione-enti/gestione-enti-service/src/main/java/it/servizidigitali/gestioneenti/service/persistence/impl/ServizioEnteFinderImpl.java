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

	@Override
	public ServizioEnte findServizioEnteByGroupIdLayoutId(long groupId, long layoutId) {

		ClassLoader classLoader = getClass().getClassLoader();

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ServizioEnte.class, classLoader);
		Criterion criterion = null;

		criterion = RestrictionsFactoryUtil.eq("groupId", groupId);

		Criterion orCriterion = RestrictionsFactoryUtil.eq("privateLayoutId", layoutId);
		orCriterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.eq("publicLayoutId", layoutId));

		criterion = RestrictionsFactoryUtil.and(criterion, orCriterion);

		query.add(criterion);

		List<ServizioEnte> servizioEntes = servizioEntePersistence.findWithDynamicQuery(query);
		if (servizioEntes != null && !servizioEntes.isEmpty()) {
			return servizioEntes.get(0);
		}

		return null;
	}

}
