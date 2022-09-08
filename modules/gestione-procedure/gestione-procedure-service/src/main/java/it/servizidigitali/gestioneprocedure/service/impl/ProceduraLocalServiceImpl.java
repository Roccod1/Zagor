/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package it.servizidigitali.gestioneprocedure.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.base.ProceduraLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.gestioneprocedure.model.Procedura", service = AopService.class)
public class ProceduraLocalServiceImpl extends ProceduraLocalServiceBaseImpl {

	public static final Log _log = LogFactoryUtil.getLog(ProceduraLocalServiceImpl.class);

	@Override
	public List<Procedura> search(String nome, String attiva, Date dataInserimentoDa, Date dataInserimentoA, long groupId, int delta, int cur, String orderByCol, String orderByType) {
		boolean direzione = false;

		if (orderByType.equalsIgnoreCase("asc")) {
			direzione = true;
		}

		if (Validator.isNull(orderByCol)) {
			orderByCol = "proceduraId";
		}

		OrderByComparator<Procedura> comparator = OrderByComparatorFactoryUtil.create("Procedura", orderByCol, direzione);
		List<Procedura> listaProcedure = proceduraFinder.findByFilters(nome, attiva, dataInserimentoDa, dataInserimentoA, groupId, cur, delta, comparator);

		return listaProcedure;
	}

	@Override
	public String getStringSelectMultipla(String string) throws JSONException {
		string = "[" + string + "]";
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(string);
		String jsonArrayString = JSONFactoryUtil.createJSONSerializer().serialize(jsonArray);

		return jsonArrayString;
	}

	@Override
	public List<Procedura> getProcedureByServiziIdsGroupIdAttiva(List<Long> serviziIds, long groupId, Boolean attiva) {
		return proceduraFinder.findByServiziIdsGroupIdAttiva(serviziIds, groupId, attiva);
	}

}