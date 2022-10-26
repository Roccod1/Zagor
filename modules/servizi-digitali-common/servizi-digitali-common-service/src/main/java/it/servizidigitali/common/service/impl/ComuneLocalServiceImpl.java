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

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.common.exception.NoSuchComuneException;
import it.servizidigitali.common.exception.NoSuchProvinciaException;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.service.base.ComuneLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.common.model.Comune", service = AopService.class)
public class ComuneLocalServiceImpl extends ComuneLocalServiceBaseImpl {

	@Override
	public Comune getComuneByDenominazione(String denominazione) {
		Comune comune = null;
		try {
			comune = comunePersistence.findByDenominazione(denominazione);
			fillComune(comune);
		}
		catch (NoSuchComuneException e) {
		}
		return comune;
	}

	@Override
	public Comune getComuneByCodiceISTAT(String codiceIstat) {
		Comune comune = comuneFinder.findComuneByCodiceISTAT(codiceIstat);
		fillComune(comune);
		return comune;
	}

	@Override
	public List<Comune> getComuniByProvinciaId(long provinciaId) {
		return comunePersistence.findByIdProvincia(provinciaId);
	}
	
	@Override
	public List<Comune> getComuniByIdRegione(long idRegione) {
		return comunePersistence.findByidRegione(idRegione);
	}

	public List<Comune> getComuniByIdProvinciaSiglaProvinciaDenominazioneRegione(Long idProvincia, String siglaProvincia, String denominazioneRegione) {
		return comuneFinder.findByArguments(idProvincia, siglaProvincia, denominazioneRegione);
	}

	/**
	 * @param comune
	 * @throws NoSuchProvinciaException
	 */
	private void fillComune(Comune comune) {

		if (comune != null) {
			try {
				Provincia provincia = provinciaPersistence.findByPrimaryKey(comune.getIdProvincia());
				comune.setProvincia(provincia);
			}
			catch (NoSuchProvinciaException e) {
			}
		}
	}
}