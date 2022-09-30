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

import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.base.TipologiaLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.servizidigitali.gestioneservizi.model.Tipologia",
	service = AopService.class
)
public class TipologiaLocalServiceImpl extends TipologiaLocalServiceBaseImpl {
	
	private static final Log _log = LogFactoryUtil.getLog(TipologiaLocalServiceImpl.class);
	
	public Tipologia salvaTipologia(Tipologia tipologia) throws Exception{
		
		if(Validator.isNull(tipologia)) {
			_log.error("tipologiaDaAggiornare e' null");
			return null;
		}
		
		if(Validator.isNull(tipologia.getTipologiaId()) || tipologia.getTipologiaId() == 0L) {
			long id = counterLocalService.increment();
			tipologia.setTipologiaId(id);
		}
		
		tipologia = tipologiaPersistence.update(tipologia);
		
		return tipologia;
	}
	
	public List<Tipologia> getListaTipologiaOrdinata(int inizio, int fine, OrderByComparator<Tipologia> ordine) throws Exception{
		
		List<Tipologia> listaTipologia = tipologiaFinder.findListaTipologiaOrdinata(inizio, fine, ordine);
		return listaTipologia;
	}
	
	public long count() throws Exception{
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Tipologia.class, classLoader);
		
		long totale = tipologiaPersistence.countWithDynamicQuery(query);
		
		return totale;
	}
	
	
}