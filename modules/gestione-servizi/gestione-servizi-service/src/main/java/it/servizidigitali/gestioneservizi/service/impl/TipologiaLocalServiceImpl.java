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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

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
	
	public Tipologia getTipologiaById(Long idTipologia) {
		Tipologia tipologia = null;
		try {
			tipologia = tipologiaPersistence.findByPrimaryKey(idTipologia);
		}catch(Exception e) {
			_log.error("Non esiste la tipologia con ID: "+idTipologia);
		}
		return tipologia;
	}
}