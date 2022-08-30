package it.servizidigitali.scrivaniaoperatore.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters;
import it.servizidigitali.scrivaniaoperatore.service.persistence.RichiestaFinder;

@Component
public class RichiestaFinderImpl extends RichiestaFinderBaseImpl implements RichiestaFinder {

	public List<Richiesta> findByFilters(RichiestaFilters filters, int start, int end) {
		DynamicQuery dq = createQuery();
		return richiestaPersistence.findWithDynamicQuery(dq, start, end);
	}

	public int countByFilters(RichiestaFilters filters) {
		DynamicQuery dq = createQuery();
		return (int) richiestaPersistence.countWithDynamicQuery(dq);
	}

	private DynamicQuery createQuery() {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Richiesta.class, getClass().getClassLoader());
		return dq;
	}

}
