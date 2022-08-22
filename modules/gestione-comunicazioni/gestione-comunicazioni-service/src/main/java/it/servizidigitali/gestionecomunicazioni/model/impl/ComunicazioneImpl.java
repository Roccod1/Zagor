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

package it.servizidigitali.gestionecomunicazioni.model.impl;

import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;

import it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione;
import it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione;
import it.servizidigitali.gestionecomunicazioni.service.LetturaComunicazioneLocalServiceUtil;
import it.servizidigitali.gestionecomunicazioni.service.TipologiaComunicazioneLocalServiceUtil;
import it.servizidigitali.gestionecomunicazioni.service.persistence.LetturaComunicazionePK;

/**
 * @author Brian Wing Shun Chan
 */
public class ComunicazioneImpl extends ComunicazioneBaseImpl {
	
	public TipologiaComunicazione getTipologia() {
		return TipologiaComunicazioneLocalServiceUtil.fetchTipologiaComunicazione(getTipologiaComunicazioneId());
	}
	
	public LetturaComunicazione getLettura(long userId) {
		LetturaComunicazionePK id = new LetturaComunicazionePK(getComunicazioneId(), userId);
		return LetturaComunicazioneLocalServiceUtil.fetchLetturaComunicazione(id);
	}
	
	public Organization getDestinatarioOrganizzazione() {
		return OrganizationLocalServiceUtil.fetchOrganization(getDestinatarioOrganizationId());
	}
}