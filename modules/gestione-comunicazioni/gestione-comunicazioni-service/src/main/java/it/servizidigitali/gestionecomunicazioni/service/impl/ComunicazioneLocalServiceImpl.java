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

package it.servizidigitali.gestionecomunicazioni.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.User;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestionecomunicazioni.model.Comunicazione;
import it.servizidigitali.gestionecomunicazioni.service.base.ComunicazioneLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.servizidigitali.gestionecomunicazioni.model.Comunicazione",
	service = AopService.class
)
public class ComunicazioneLocalServiceImpl
	extends ComunicazioneLocalServiceBaseImpl {
		
	public Comunicazione addComunicazione(
			long groupId,
			long companyId, 
			long userId, 
			String titolo, 
			String descrizione,
			Date dataInizio,
			Date dataFine, 
			long tipologiaId,
			long destinatarioUserId) {
		User user = userLocalService.fetchUser(userId);
		User userDestinatario = userLocalService.fetchUser(destinatarioUserId);
		
		long id = counterLocalService.increment(Comunicazione.class.getName());
		Comunicazione model = comunicazionePersistence.create(id);
		model.setGroupId(groupId);
		model.setCompanyId(companyId);
		model.setUserId(userId);
		model.setUserName(user.getScreenName());
		model.setTitolo(titolo);
		model.setDescrizione(descrizione);
		model.setDataInizio(dataInizio);
		model.setDataFine(dataFine);
		model.setTipologiaComunicazioneId(tipologiaId);
		model.setDestinatarioUserId(null);
		//model.setDestinatarioOrganizationId();;
		return comunicazionePersistence.update(model);
	}
}