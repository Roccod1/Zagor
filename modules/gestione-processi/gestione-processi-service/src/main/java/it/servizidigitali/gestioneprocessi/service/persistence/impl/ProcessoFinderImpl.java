package it.servizidigitali.gestioneprocessi.service.persistence.impl;

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

import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.service.persistence.ProcessoFinder;

@Component(service = ProcessoFinder.class)
public class ProcessoFinderImpl extends ProcessoFinderBaseImpl implements ProcessoFinder{
	public List<Processo> findByFilters(String denominazione, Date dataInserimentoDa, Date dataInserimentoA, int inizio, int fine, OrderByComparator<Processo> ordine){
		List<Processo> listaProcessi = new ArrayList<>();
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Processo.class, classLoader);
		
		if(Validator.isNotNull(denominazione)) {
			dynamicQuery.add(RestrictionsFactoryUtil.like("nome", StringPool.PERCENT + denominazione + StringPool.PERCENT));
		}
		
		if(Validator.isNotNull(dataInserimentoDa)) {
			dynamicQuery.add(RestrictionsFactoryUtil.ge("createDate", dataInserimentoDa));
		}
		
		if(Validator.isNotNull(dataInserimentoA)) {
			dynamicQuery.add(RestrictionsFactoryUtil.le("createDate", dataInserimentoA));
		}
		
		listaProcessi = processoPersistence.findWithDynamicQuery(dynamicQuery,inizio,fine,ordine);
		
		return listaProcessi;
	}
}
