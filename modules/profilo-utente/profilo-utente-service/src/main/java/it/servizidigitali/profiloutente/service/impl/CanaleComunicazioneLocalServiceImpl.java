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

import java.util.List;

import it.servizidigitali.profiloutente.model.CanaleComunicazione;
import it.servizidigitali.profiloutente.service.base.CanaleComunicazioneLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author filierim
 */
@Component(
	property = "model.class.name=it.servizidigitali.profiloutente.model.CanaleComunicazione",
	service = AopService.class
)
public class CanaleComunicazioneLocalServiceImpl extends CanaleComunicazioneLocalServiceBaseImpl {
	
	public List<CanaleComunicazione> getCanaleComunicazionesAttivi(boolean attivo) throws Exception {
		return canaleComunicazionePersistence.findByAttivo(attivo);
	}
}