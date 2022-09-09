package it.servizidigitali.scrivaniaoperatore.service.persistence.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters;
import it.servizidigitali.scrivaniaoperatore.service.persistence.RichiestaFinder;

/**
 * @author filierim
 * @author rizzitellim
 *
 */

@Component(service = RichiestaFinder.class)
public class RichiestaFinderImpl extends RichiestaFinderBaseImpl implements RichiestaFinder {

	@Reference
	private UserLocalService userLocalService;

	@Override
	public List<Richiesta> findByFilters(RichiestaFilters filters, int start, int end) {
		DynamicQuery dq = createQuery(filters);
		OrderByComparator<Richiesta> orderByComparator = null;
		if(Validator.isNotNull(filters.getOrderByCol())) {
			orderByComparator = OrderByComparatorFactoryUtil.create(Richiesta.class.getSimpleName(), filters.getOrderByCol());
			if(Validator.isNotNull(filters.getOrderByType())) {
				boolean orderByType = "desc".equals(filters.getOrderByType()) ? false : true;
				orderByComparator = OrderByComparatorFactoryUtil.create(Richiesta.class.getSimpleName(), filters.getOrderByCol(), orderByType);
			}
		}
		return richiestaPersistence.findWithDynamicQuery(dq, start, end, orderByComparator);
	}

	@Override
	public int countByFilters(RichiestaFilters filters) {
		DynamicQuery dq = createQuery(filters);
		return (int) richiestaPersistence.countWithDynamicQuery(dq);
	}

	private DynamicQuery createQuery(RichiestaFilters filters) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Richiesta.class, getClass().getClassLoader());
		dq.add(RestrictionsFactoryUtil.eq("groupId", filters.getGroupId()));
		dq.add(RestrictionsFactoryUtil.eq("companyId", filters.getCompanyId()));
		if (filters.getNomeCognome() != null) {
			String pattern = StringPool.PERCENT + filters.getNomeCognome() + StringPool.PERCENT;

			DynamicQuery userDq = DynamicQueryFactoryUtil.forClass(User.class, getClass().getClassLoader());
			userDq.add(RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.ilike("firstName", pattern), RestrictionsFactoryUtil.ilike("lastName", pattern)));

			userDq.setProjection(ProjectionFactoryUtil.property("screenName"));

			List<String> cfs = userLocalService.<String> dynamicQuery(userDq);

			dq.add(RestrictionsFactoryUtil.in("codiceFiscale", cfs));
		}

		if (filters.getCodiceFiscale() != null) {
			String pattern = StringPool.PERCENT + filters.getCodiceFiscale() + StringPool.PERCENT;

			dq.add(RestrictionsFactoryUtil.ilike("codiceFiscale", pattern));
		}

		if (filters.getIdRichiesta() != null) {
			String pattern = StringPool.PERCENT + filters.getIdRichiesta() + StringPool.PERCENT;

			dq.add(RestrictionsFactoryUtil.sqlRestriction("richiestaId like ?", pattern, Type.STRING));
		}

		if (filters.getNumeroProtocollo() != null) {
			String pattern = StringPool.PERCENT + filters.getNumeroProtocollo() + StringPool.PERCENT;

			dq.add(RestrictionsFactoryUtil.ilike("numeroProtocollo", pattern));
		}

		if (filters.getDataDa() != null) {
			dq.add(RestrictionsFactoryUtil.gt("createDate", filters.getDataDa()));
		}

		if (filters.getDataA() != null) {
			dq.add(RestrictionsFactoryUtil.lt("createDate", filters.getDataA()));
		}

		if (filters.getAutenticazione() != null) {
			dq.add(RestrictionsFactoryUtil.eq("invioGuest", filters.getAutenticazione() ? false : true));
		}

		if (filters.getTipo() != null) {
			dq.add(RestrictionsFactoryUtil.eq("stato", filters.getTipo()));
		}

		if (filters.getProcessInstanceIds() != null) {
			dq.add(RestrictionsFactoryUtil.in("processInstanceId", filters.getProcessInstanceIds()));
		}

		if (filters.getProcedureIds() != null) {
			dq.add(RestrictionsFactoryUtil.in("proceduraId", filters.getProcedureIds()));
		}

		return dq;
	}

	/**
	 * @param cf codiceFiscale utente
	 * @param groupId groupId organizzazione
	 * @return
	 */
	@Override
	public List<Richiesta> findRichiestaByCfAndGroupId(String cf, long groupId, int cur, int delta, String orderByCol, String orderByType) {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Richiesta.class, getClassLoader());

		if (Validator.isNotNull(cf)) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("codiceFiscale", cf));
		}

		if (groupId > 0) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		}

		if (Validator.isNull(orderByCol)) {
			orderByCol = "modifiedDate";
		}

		boolean direzione = "desc".equals(orderByType) ? false : true;

		OrderByComparator<Richiesta> comparator = OrderByComparatorFactoryUtil.create(Richiesta.class.getSimpleName(), orderByCol, direzione);

		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		int[] startEnd = SearchPaginationUtil.calculateStartAndEnd(cur, delta);

		if ((startEnd[0] >= 1) && (startEnd[1] >= 1)) {
			start = startEnd[0];
			end = startEnd[1];
		}

		return richiestaPersistence.findWithDynamicQuery(dynamicQuery, start, end, comparator);
	}

}
