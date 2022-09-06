package it.servizidigitali.gestioneprocedure.service.persistence.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFinder;


@Component(service = ProceduraFinder.class)
public class ProceduraFinderImpl extends ProceduraFinderBaseImpl implements ProceduraFinder{

	
	
	public List<Procedura> findByFilters(String denominazione, String attiva, Date dataInserimentoDa, Date dataInserimentoA, long siteGroupId, int cur, int delta, OrderByComparator<Procedura> ordine){
		List<Procedura> listaProcedure = new ArrayList<>();
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Procedura.class, classLoader);
		
		if(Validator.isNotNull(denominazione)) {
			dynamicQuery.add(RestrictionsFactoryUtil.like("nome", StringPool.PERCENT + denominazione + StringPool.PERCENT));
		}
		
		if(Validator.isNotNull(attiva) && !attiva.equalsIgnoreCase("-1")) {
			
			if(attiva.equalsIgnoreCase("1")) {
				dynamicQuery.add(RestrictionsFactoryUtil.eq("attiva", true));
			}else {
				dynamicQuery.add(RestrictionsFactoryUtil.eq("attiva", Boolean.parseBoolean(attiva)));
			}
			
		}
		
		if(Validator.isNotNull(siteGroupId)) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", siteGroupId));
		}
		
		
		if(Validator.isNotNull(dataInserimentoDa)) {
			dynamicQuery.add(RestrictionsFactoryUtil.ge("createDate", dataInserimentoDa));
		}
		
		if(Validator.isNotNull(dataInserimentoA)) {
			dynamicQuery.add(RestrictionsFactoryUtil.le("createDate", dataInserimentoA));
		}
		
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		
		int inizio = posizioni[0];
		int fine = posizioni[1];
		
		listaProcedure = proceduraPersistence.findWithDynamicQuery(dynamicQuery,inizio,fine,ordine);
		
		return listaProcedure;
	}
	
	
}
