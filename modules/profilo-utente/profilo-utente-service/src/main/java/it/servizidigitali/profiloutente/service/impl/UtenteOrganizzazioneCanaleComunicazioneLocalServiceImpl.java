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

package it.servizidigitali.profiloutente.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.profiloutente.model.UtenteOrganizzazioneCanaleComunicazione;
import it.servizidigitali.profiloutente.service.base.UtenteOrganizzazioneCanaleComunicazioneLocalServiceBaseImpl;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazioneCanaleComunicazionePK;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.servizidigitali.profiloutente.model.UtenteOrganizzazioneCanaleComunicazione",
	service = AopService.class
)
public class UtenteOrganizzazioneCanaleComunicazioneLocalServiceImpl extends UtenteOrganizzazioneCanaleComunicazioneLocalServiceBaseImpl {
	private static final Log _log = LogFactoryUtil.getLog(UtenteOrganizzazioneCanaleComunicazioneLocalServiceImpl.class);

	public List<UtenteOrganizzazioneCanaleComunicazione> updateMassivoUtenteOrganizzazioneCanaleComunicazione(long userId, long groupId, long companyId, long organizationId, long listaIdCanaliComunicazione[]) throws Exception{
		List<UtenteOrganizzazioneCanaleComunicazione> listaEntityAggiornate = new ArrayList<UtenteOrganizzazioneCanaleComunicazione>();
		utenteOrganizzazioneCanaleComunicazionePersistence.findByUtenteOrganization(userId, organizationId);
		for(long canaleComunicazioneId : listaIdCanaliComunicazione) {
			UtenteOrganizzazioneCanaleComunicazionePK utenteOrganizzazioneCanaleComunicazionePK = new UtenteOrganizzazioneCanaleComunicazionePK(userId, organizationId, canaleComunicazioneId);
			UtenteOrganizzazioneCanaleComunicazione utenteOrganizzazioneCanaleComunicazione = utenteOrganizzazioneCanaleComunicazioneLocalService.createUtenteOrganizzazioneCanaleComunicazione(utenteOrganizzazioneCanaleComunicazionePK);
			utenteOrganizzazioneCanaleComunicazione.setCanaleComunicazioneId(canaleComunicazioneId);
			utenteOrganizzazioneCanaleComunicazione.setUserId(userId);
			utenteOrganizzazioneCanaleComunicazione.setCompanyId(companyId);
			utenteOrganizzazioneCanaleComunicazione.setGroupId(groupId);
			UtenteOrganizzazioneCanaleComunicazione entityAggiornata = utenteOrganizzazioneCanaleComunicazionePersistence.update(utenteOrganizzazioneCanaleComunicazione);
			listaEntityAggiornate.add(entityAggiornata);
		}
		
		return listaEntityAggiornate;
	}
	
	public List<UtenteOrganizzazioneCanaleComunicazione> getListaCanaleComunicazioneByUtenteOrganization(long utenteId, long organizationId) throws Exception{
		return utenteOrganizzazioneCanaleComunicazionePersistence.findByUtenteOrganization(utenteId, organizationId);
	}
}