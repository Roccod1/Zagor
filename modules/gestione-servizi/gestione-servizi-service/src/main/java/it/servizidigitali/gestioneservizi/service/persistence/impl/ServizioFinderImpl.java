package it.servizidigitali.gestioneservizi.service.persistence.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.persistence.ServizioFinder;

/**
 * @author filierim
 *
 */

@Component(service = ServizioFinder.class)
public class ServizioFinderImpl extends ServizioFinderBaseImpl implements ServizioFinder{
	
	public List<Servizio> findServizioByFilter(String nome, String codice, Boolean soloServiziAttivi, int inizio, int fine, OrderByComparator<Servizio> ordine){
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Servizio.class, classLoader);

		if(Validator.isNotNull(nome)) {
			query.add(RestrictionsFactoryUtil.like("nome", StringPool.PERCENT + nome + StringPool.PERCENT));			
		}
		
		if(Validator.isNotNull(codice)){
			query.add(RestrictionsFactoryUtil.like("codice", StringPool.PERCENT + codice + StringPool.PERCENT));
		}
		
		if(soloServiziAttivi) {
			query.add(RestrictionsFactoryUtil.eq("attivo", true));
		}
		
		List<Servizio> listaServiziFiltered = servizioPersistence.findWithDynamicQuery(query, inizio, fine, ordine);
		
		return listaServiziFiltered;
	}
}
