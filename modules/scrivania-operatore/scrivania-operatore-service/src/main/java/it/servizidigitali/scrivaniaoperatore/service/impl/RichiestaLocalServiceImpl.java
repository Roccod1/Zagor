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

package it.servizidigitali.scrivaniaoperatore.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters;
import it.servizidigitali.scrivaniaoperatore.service.base.RichiestaLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.scrivaniaoperatore.model.Richiesta", service = AopService.class)
public class RichiestaLocalServiceImpl extends RichiestaLocalServiceBaseImpl {

	@Override
	public List<Richiesta> search(RichiestaFilters filters, int start, int end) {
		return richiestaFinder.findByFilters(filters, start, end);
	}

	@Override
	public int count(RichiestaFilters filters) {
		return richiestaFinder.countByFilters(filters);
	}

	@Override
	public List<Richiesta> getRichiesteByStato(String stato) {
		return richiestaPersistence.findByStato(stato);
	}
}