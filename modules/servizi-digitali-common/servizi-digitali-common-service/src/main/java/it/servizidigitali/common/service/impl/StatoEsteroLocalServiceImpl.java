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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.common.exception.NoSuchStatoEsteroException;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.base.StatoEsteroLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.common.model.StatoEstero", service = AopService.class)
public class StatoEsteroLocalServiceImpl extends StatoEsteroLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(StatoEsteroLocalServiceImpl.class.getName());

	@Override
	public StatoEstero getStatoEsteroByDenominazione(String denominazione) {

		StatoEstero statoEstero = null;
		try {
			statoEstero = statoEsteroPersistence.findByDenominazione(denominazione);
		}
		catch (NoSuchStatoEsteroException e) {
			_log.warn(e.getMessage());
		}
		return statoEstero;
	}

	public StatoEstero getStatoEsteroByCodiceStato(int codiceStato) {
		StatoEstero findByCodiceStato = null;
		try {
			findByCodiceStato = statoEsteroPersistence.findByCodiceStato(codiceStato);
		}
		catch (NoSuchStatoEsteroException e) {
		}
		return findByCodiceStato;
	}
}