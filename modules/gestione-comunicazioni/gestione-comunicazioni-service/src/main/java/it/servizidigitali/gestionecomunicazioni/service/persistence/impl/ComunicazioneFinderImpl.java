package it.servizidigitali.gestionecomunicazioni.service.persistence.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestionecomunicazioni.model.Comunicazione;
import it.servizidigitali.gestionecomunicazioni.service.persistence.ComunicazioneFinder;

@Component(immediate = true, service = ComunicazioneFinder.class)
public class ComunicazioneFinderImpl extends ComunicazioneFinderBaseImpl implements ComunicazioneFinder {

	public List<Comunicazione> findByFilters(Long organizzazione, String username, Long tipologia, int start, int end) {
		DynamicQuery dynamicQuery = createDynQuery(organizzazione, username, tipologia);
		
		return comunicazionePersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}
	
	public int countByFilters(Long organizzazione, String username, Long tipologia) {
		
		DynamicQuery dynamicQuery = createDynQuery(organizzazione, username, tipologia);
		
		
		return (int) comunicazionePersistence.countWithDynamicQuery(dynamicQuery);
	}

	private DynamicQuery createDynQuery(Long organizzazione, String username, Long tipologia) {
		ClassLoader classLoader = getClass().getClassLoader();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Comunicazione.class, classLoader);
		
		if (organizzazione != null) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("organizationId", organizzazione));
		}
		
		if (tipologia != null) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("tipologiaComunicazioneId", tipologia));
		}
		
		if (username != null) {
			String pattern = StringPool.PERCENT + username + StringPool.PERCENT;
			
			dynamicQuery.add(RestrictionsFactoryUtil.ilike("userName", pattern));
		}
		
		return dynamicQuery;
	}
}
