package it.servizidigitali.gestioneservizi.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneservizi.model.AreaTematica;
import it.servizidigitali.gestioneservizi.service.persistence.AreaTematicaFinder;

/**
 * @author filierim
 *
 */

@Component(service = AreaTematicaFinder.class)
public class AreaTematicaFinderImpl extends AreaTematicaFinderBaseImpl implements AreaTematicaFinder{
	
	public List<AreaTematica> findListaAreeTematicheOrdinata(int inizio, int fine, OrderByComparator<AreaTematica> ordine){
			
		ClassLoader classLoader = getClass().getClassLoader();
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(AreaTematica.class, classLoader);

		List<AreaTematica> listaAreeTematicheOrdinata = areaTematicaPersistence.findWithDynamicQuery(query, inizio, fine, ordine);

		return listaAreeTematicheOrdinata;
	}
}
