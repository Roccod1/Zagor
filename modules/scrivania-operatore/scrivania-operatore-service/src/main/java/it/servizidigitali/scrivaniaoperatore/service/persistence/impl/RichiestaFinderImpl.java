package it.servizidigitali.scrivaniaoperatore.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters;
import it.servizidigitali.scrivaniaoperatore.service.persistence.RichiestaFinder;

@Component
public class RichiestaFinderImpl extends RichiestaFinderBaseImpl implements RichiestaFinder {

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
			
		}
		
		if (filters.getCodiceFiscale() != null) {
			
		}
		
		if (filters.getIdRichiesta() != null) {
			
		}
		
		if (filters.getNumeroProtocollo() != null) {
			
		}
		
		if (filters.getDataDa() != null) {
			
		}
		
		if (filters.getDataA() != null) {
			
		}
		
		if (filters.getAutenticazione() != null) {
			
		}
		
		if (filters.getTipo() != null) {
			dq.add(RestrictionsFactoryUtil.eq("stato", filters.getTipo()));
		}
		
		return dq;
	}

}
