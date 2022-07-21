package it.servizidigitali.common.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.service.persistence.ComuneFinder;

/**
 * @author pindi
 *
 */
@Component(service = ComuneFinder.class)
public class ComuneFinderImpl extends ComuneFinderBaseImpl implements ComuneFinder {

	@Override
	public Comune findComuneByCodiceISTAT(String codiceISTAT) {

		ClassLoader classLoader = getClass().getClassLoader();
		Criterion crit = null;
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Comune.class, classLoader);

		if (codiceISTAT != null) {
			crit = RestrictionsFactoryUtil.eq("codiceIstatAN", codiceISTAT);
			crit = RestrictionsFactoryUtil.or(crit, RestrictionsFactoryUtil.eq("codiceIstat1", codiceISTAT));
			crit = RestrictionsFactoryUtil.or(crit, RestrictionsFactoryUtil.eq("codiceIstat103", codiceISTAT));
			crit = RestrictionsFactoryUtil.or(crit, RestrictionsFactoryUtil.eq("codicestat107", codiceISTAT));
		}

		query.add(crit);
		List<Comune> comuni = comunePersistence.findWithDynamicQuery(query);

		return comuni.get(0);
	}
}