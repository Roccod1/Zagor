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

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.profiloutente.model.UtenteOrganizzazione;
import it.servizidigitali.profiloutente.service.base.UtenteOrganizzazioneLocalServiceBaseImpl;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazionePK;

/**
 * @author filierim
 */
@Component(
	property = "model.class.name=it.servizidigitali.profiloutente.model.UtenteOrganizzazione",
	service = AopService.class
)
public class UtenteOrganizzazioneLocalServiceImpl extends UtenteOrganizzazioneLocalServiceBaseImpl {
	
	private static final Log _log = LogFactoryUtil.getLog(UtenteOrganizzazioneLocalServiceImpl.class);
	
	public List<UtenteOrganizzazione> getOrganizzazioniUtenteConfigurate(Long utenteId) throws Exception{
		return utenteOrganizzazionePersistence.findByUtenteId(utenteId);
	}
	
	public UtenteOrganizzazione findByUtenteOrganizzazionePreferito(UtenteOrganizzazionePK utenteOrganizzazionePK, boolean preferito) throws Exception{
		return utenteOrganizzazionePersistence.findByO_U_P(utenteOrganizzazionePK.getOrganizationId(), utenteOrganizzazionePK.getUtenteId(), preferito);
	}
}