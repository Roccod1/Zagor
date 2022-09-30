package it.servizidigitali.gestioneservizi.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.persistence.TipologiaFinder;

/**
 * @author filierim
 *
 */

@Component(service = TipologiaFinder.class)
public class TipologiaFinderImpl extends TipologiaFinderBaseImpl implements TipologiaFinder {
	
	public List<Tipologia> findListaTipologiaOrdinata(int inizio, int fine, OrderByComparator<Tipologia> ordine){
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Tipologia.class, classLoader);

		List<Tipologia> listaTipologiaOrdinata= tipologiaPersistence.findWithDynamicQuery(query, inizio, fine, ordine);
		
		return listaTipologiaOrdinata;
	}
	
}
