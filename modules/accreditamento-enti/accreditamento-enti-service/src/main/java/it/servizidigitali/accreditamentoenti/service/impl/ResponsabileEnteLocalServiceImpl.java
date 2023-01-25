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

package it.servizidigitali.accreditamentoenti.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.accreditamentoenti.exception.NoSuchResponsabileEnteException;
import it.servizidigitali.accreditamentoenti.model.ResponsabileEnte;
import it.servizidigitali.accreditamentoenti.service.base.ResponsabileEnteLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.accreditamentoenti.model.ResponsabileEnte", service = AopService.class)
public class ResponsabileEnteLocalServiceImpl extends ResponsabileEnteLocalServiceBaseImpl {

	@Override
	public List<ResponsabileEnte> getResponsabileEnteByEnteId(long enteId) {
		return responsabileEntePersistence.findByEnteId(enteId);
	}

	@Override
	public ResponsabileEnte getResponsabileEnteByResponsabileUserIdAndEnteId(long responsabileUserId, long enteId)
			throws NoSuchResponsabileEnteException {
		return responsabileEntePersistence.findByResponsabileUserIdAndEnteId(responsabileUserId, enteId);
	}
}