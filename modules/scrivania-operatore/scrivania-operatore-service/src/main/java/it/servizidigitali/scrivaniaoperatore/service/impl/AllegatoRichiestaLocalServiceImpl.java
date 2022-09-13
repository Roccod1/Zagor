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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchAllegatoRichiestaException;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.service.base.AllegatoRichiestaLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta", service = AopService.class)
public class AllegatoRichiestaLocalServiceImpl extends AllegatoRichiestaLocalServiceBaseImpl {

	@Override
	public AllegatoRichiesta getAllegatoRichiesta(long richiestaId, boolean principale, long groupId) {
		try {
			return allegatoRichiestaPersistence.findByR_P_G(richiestaId, principale, groupId);
		}
		catch (NoSuchAllegatoRichiestaException e) {
		}
		return null;
	}

	@Override
	public List<AllegatoRichiesta> getAllegatiRichiesta(long richiestaId, long groupId) {
		return allegatoRichiestaPersistence.findByR_G(richiestaId, groupId);

	}
}