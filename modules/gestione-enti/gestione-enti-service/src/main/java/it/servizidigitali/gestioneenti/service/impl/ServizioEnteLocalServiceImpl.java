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

package it.servizidigitali.gestioneenti.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.base.ServizioEnteLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.gestioneenti.model.ServizioEnte", service = AopService.class)
public class ServizioEnteLocalServiceImpl extends ServizioEnteLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(ServizioEnteLocalServiceImpl.class);

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Override
	public List<ServizioEnte> getServizioEntes(int start, int end) {
		List<ServizioEnte> servizioEntes = super.getServizioEntes(start, end);

		if (servizioEntes != null) {
			for (ServizioEnte servizioEnte : servizioEntes) {
				fillServizioEnte(servizioEnte);
			}
		}

		return servizioEntes;
	}

	public List<ServizioEnte> getServiziEnte(long organizationId) {
		return servizioEntePersistence.findByOrganizationId(organizationId);
	}

	private void fillServizioEnte(ServizioEnte servizioEnte) {

		long organizationId = servizioEnte.getOrganizationId();
		if (organizationId != 0l) {
			try {
				Organization organization = organizationLocalService.getOrganization(organizationId);
				servizioEnte.setOrganization(organization);
				servizioEnte.setCodiceIPA(organization.getExpandoBridge().getAttribute("codiceIPA").toString());
				servizioEnte.setNome(organization.getName());
				servizioEnte.setDescrizione(organization.getComments());
			}
			catch (PortalException e) {
				_log.error(e);
			}
		}

	}
}