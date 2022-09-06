package it.servizidigitali.scrivaniaoperatore.service.persistence.impl;

import com.liferay.petra.sql.dsl.spi.query.OrderBy;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.persistence.RichiestaFinder;

/**
 * @author filierim
 *
 */

@Component(service = RichiestaFinderImpl.class)
public class RichiestaFinderImpl extends RichiestaFinderBaseImpl implements RichiestaFinder {
	
	/**
	 * @param cf codiceFiscale utente
	 * @param groupId groupId organizzazione
	 * @return
	 */
	public List<Richiesta> findRichiestaByCfAndGroupId(String cf, long groupId, int cur, int delta, String orderByCol, String orderByType){		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Richiesta.class, getClassLoader());
		
		if(Validator.isNotNull(cf)) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("codiceFiscale", cf));
		}
		
		if(groupId > 0) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		}
		
		if(Validator.isNull(orderByCol)) {
			orderByCol = "modifiedDate";
		}
		
		boolean direzione = "desc".equals(orderByType) ? false : true;
		
		OrderByComparator<Richiesta> comparator = OrderByComparatorFactoryUtil.create(Richiesta.class.getSimpleName(), orderByCol, direzione);
		
		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		int[] startEnd = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		
		if((startEnd[0] >= 1) && (startEnd[1] >= 1)) {
			start = startEnd[0];
			end = startEnd[1];
		}
		
		return richiestaPersistence.findWithDynamicQuery(dynamicQuery, start, end, comparator);
	}
}
