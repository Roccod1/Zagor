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

import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte;
import it.servizidigitali.scrivaniaoperatore.service.base.DestinazioneUsoServizioEnteLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte", service = AopService.class)
public class DestinazioneUsoServizioEnteLocalServiceImpl extends DestinazioneUsoServizioEnteLocalServiceBaseImpl {
	
	@Override
	public List<DestinazioneUsoServizioEnte> getDestinazioniUsoServizioEnteByServizioIdOrganizationId(long servizioId, long organizationId, long groupId, long companyId) {
		List<DestinazioneUsoServizioEnte> destinazioniUsoServizioEnte = destinazioneUsoServizioEntePersistence.findByS_O_G_C(servizioId, organizationId, groupId, companyId);
		return destinazioniUsoServizioEnte;
	}
	
}