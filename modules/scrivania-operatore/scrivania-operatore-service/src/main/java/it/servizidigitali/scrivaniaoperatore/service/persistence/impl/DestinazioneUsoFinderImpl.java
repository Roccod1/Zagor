package it.servizidigitali.scrivaniaoperatore.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;
import it.servizidigitali.scrivaniaoperatore.service.persistence.DestinazioneUsoFinder;

@Component(service = DestinazioneUsoFinder.class)
public class DestinazioneUsoFinderImpl extends DestinazioneUsoFinderBaseImpl implements DestinazioneUsoFinder {

	@Override
	public List<DestinazioneUso> findByDestinazioneUsoIdsCompanyId(List<Long> destinazioniUsoIds, long companyId) {

		ClassLoader classLoader = getClass().getClassLoader();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DestinazioneUso.class, classLoader);
		dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));

		if (destinazioniUsoIds != null) {
			dynamicQuery.add(RestrictionsFactoryUtil.in("destinazioneUsoId", destinazioniUsoIds));
		}

		return destinazioneUsoPersistence.findWithDynamicQuery(dynamicQuery);

	}

}
