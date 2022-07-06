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
import it.servizidigitali.gestioneservizi.service.persistence.AreaTematicaFinder;
import it.servizidigitali.gestioneservizi.service.persistence.ServizioFinder;

/**
 * @author filierim
 *
 */

@Component(service = AreaTematicaFinder.class)
public class AreaTematicaFinderImpl extends AreaTematicaFinderBaseImpl implements AreaTematicaFinder{
	
	
}
