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

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.common.exception.NoSuchProvinciaException;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.service.base.ProvinciaLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.common.model.Provincia", service = AopService.class)
public class ProvinciaLocalServiceImpl extends ProvinciaLocalServiceBaseImpl {

	public Provincia getProvinciaBySigla(String sigla) {
		try {
			return provinciaPersistence.findBySigla(sigla);
		}
		catch (NoSuchProvinciaException e) {
		}
		return null;
	}
}