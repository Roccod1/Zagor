package it.servizidigitali.scrivaniaoperatore.service.persistence.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters;
import it.servizidigitali.scrivaniaoperatore.service.persistence.RichiestaFinder;

@Component
public class RichiestaFinderImpl extends RichiestaFinderBaseImpl implements RichiestaFinder {

	@Reference
	private UserLocalService userLocalService;
	
	public List<Richiesta> findByFilters(RichiestaFilters filters, int start, int end) {
		DynamicQuery dq = createQuery(filters);
		return richiestaPersistence.findWithDynamicQuery(dq, start, end);
	}

	public int countByFilters(RichiestaFilters filters) {
		DynamicQuery dq = createQuery(filters);
		return (int) richiestaPersistence.countWithDynamicQuery(dq);
	}

	private DynamicQuery createQuery(RichiestaFilters filters) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Richiesta.class, getClass().getClassLoader());
		
		if (filters.getNomeCognome() != null) {
			String pattern = StringPool.PERCENT + filters.getNomeCognome() + StringPool.PERCENT;
			
			DynamicQuery userDq = DynamicQueryFactoryUtil.forClass(User.class, getClass().getClassLoader());
			userDq.add(RestrictionsFactoryUtil.or(
					RestrictionsFactoryUtil.ilike("firstName", pattern),
					RestrictionsFactoryUtil.ilike("lastName", pattern)));
			
			userDq.setProjection(ProjectionFactoryUtil.property("screenName"));
			
			List<String> cfs = userLocalService.<String>dynamicQuery(userDq);
			
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
		
		return dq;
	}

}
