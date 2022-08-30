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

package it.servizidigitali.gestioneprocedure.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.base.ProceduraLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.servizidigitali.gestioneprocedure.model.Procedura",
	service = AopService.class
)
public class ProceduraLocalServiceImpl extends ProceduraLocalServiceBaseImpl {
	public static final Log _log = LogFactoryUtil.getLog(ProceduraLocalServiceImpl.class);
	
	public List<Procedura> search(String nome, Boolean attiva, Date dataInserimentoDa, Date dataInserimentoA, int delta, int cur, String orderByCol, String orderByType){
		boolean direzione = false;
		
		if(orderByType.equalsIgnoreCase("asc")) {
			direzione = true;
		}
		
		if(Validator.isNull(orderByCol)) {
			orderByCol = "proceduraId";
		}
		
		OrderByComparator<Procedura> comparator = OrderByComparatorFactoryUtil.create("Procedura", orderByCol, direzione);
		List<Procedura> listaProcedure = proceduraFinder.findByFilters(nome, attiva,dataInserimentoDa, dataInserimentoA, cur, delta, comparator);
		
		return listaProcedure;
	}
}