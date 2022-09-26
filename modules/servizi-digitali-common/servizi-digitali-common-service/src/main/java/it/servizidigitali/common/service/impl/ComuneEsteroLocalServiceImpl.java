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

package it.servizidigitali.common.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.common.exception.NoSuchComuneEsteroException;
import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.service.base.ComuneEsteroLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.common.model.ComuneEstero", service = AopService.class)
public class ComuneEsteroLocalServiceImpl extends ComuneEsteroLocalServiceBaseImpl {

	@Override
	public ComuneEstero getComuneEsteroByCodice(int codice) {
		ComuneEstero comuneEstero = null;
		try {
			comuneEstero = comuneEsteroPersistence.findByCodice(codice);
		}
		catch (NoSuchComuneEsteroException e) {
		}

		return comuneEstero;
	}

	@Override
	public ComuneEstero getComuneEsteroByDenominazione(String denominazione) {
		List<ComuneEstero> comuniEsteri = comuneEsteroPersistence.findByDenominazioneLike(denominazione);
		if (comuniEsteri != null && !comuniEsteri.isEmpty()) {
			return comuniEsteri.get(0);
		}
		return null;
	}

	public List<ComuneEstero> getComuniEsteriByDenominazione(String denominazione) {
		List<ComuneEstero> comuniEsteri = comuneEsteroPersistence.findByDenominazioneLike(denominazione);
		return comuniEsteri;
	}

}