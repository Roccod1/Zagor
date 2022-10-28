package it.servizidigitali.chatbot.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.chatbot.model.RichiestaCertificato;
import it.servizidigitali.chatbot.service.persistence.RichiestaCertificatoFinder;

/**
 *
 */

@Component(service = RichiestaCertificatoFinder.class)
public class RichiestaCertificatoFinderImpl extends RichiestaCertificatoFinderBaseImpl implements RichiestaCertificatoFinder {

	@Override
	public List<RichiestaCertificato> findByStati(List<String> stati) {

		ClassLoader classLoader = getClass().getClassLoader();

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(RichiestaCertificato.class, classLoader);
		query.add(RestrictionsFactoryUtil.in("stato", stati));

		List<RichiestaCertificato> listaServiziFiltered = richiestaCertificatoPersistence.findWithDynamicQuery(query);

		return listaServiziFiltered;
	}

}
