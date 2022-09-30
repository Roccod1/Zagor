/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.servizidigitali.gestioneservizi.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneservizi.model.AreaTematica;
import it.servizidigitali.gestioneservizi.service.base.AreaTematicaLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.servizidigitali.gestioneservizi.model.AreaTematica",
	service = AopService.class
)
public class AreaTematicaLocalServiceImpl extends AreaTematicaLocalServiceBaseImpl {

	private static final Log  _log = LogFactoryUtil.getLog(AreaTematicaLocalServiceImpl.class);
	
	public AreaTematica salvaAreaTematica(AreaTematica areaTematica) throws Exception {
		
		if(Validator.isNull(areaTematica)) {
			_log.error("tipologiaDaAggiornare e' null");
			return null;
		}
		
		if(Validator.isNull(areaTematica.getAreaTematicaId()) || areaTematica.getAreaTematicaId() == 0L) {
			_log.debug("L'id e' null oppure impostato a 0 :> inserisco una nuova entity");
			long areaTematicaId = counterLocalService.increment();
			areaTematica.setAreaTematicaId(areaTematicaId);
		}
		
		areaTematica = areaTematicaPersistence.update(areaTematica);
		
		return areaTematica;
	}
	
	public List<AreaTematica> getListaAreeTematicheOrdinata(int inizio, int fine, OrderByComparator<AreaTematica> ordine) throws Exception{
		
		List<AreaTematica> listaAreeTematiche = areaTematicaFinder.findListaAreeTematicheOrdinata(inizio, fine, ordine);
		return listaAreeTematiche;
	}
	
	public long count() throws Exception{
		ClassLoader classLoader = getClass().getClassLoader();
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(AreaTematica.class, classLoader);

		long totale = areaTematicaPersistence.countWithDynamicQuery(query);
		return totale;
	}
	
}