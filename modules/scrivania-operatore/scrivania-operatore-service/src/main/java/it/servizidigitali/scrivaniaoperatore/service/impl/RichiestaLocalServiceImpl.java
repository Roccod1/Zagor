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

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchRichiestaException;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters;
import it.servizidigitali.scrivaniaoperatore.service.base.RichiestaLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.scrivaniaoperatore.model.Richiesta", service = AopService.class)
public class RichiestaLocalServiceImpl extends RichiestaLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(RichiestaLocalServiceImpl.class);

	@Override
	public List<Richiesta> search(RichiestaFilters filters, int start, int end) {
		return richiestaFinder.findByFilters(filters, start, end);
	}

	@Override
	public int count(RichiestaFilters filters) {
		return richiestaFinder.countByFilters(filters);
	}

	@Override
	public List<Richiesta> getRichiesteByStato(String stato) {
		return richiestaPersistence.findByStato(stato);
	}

	@Override
	public void updateStatoRichiesta(long richiestaId, String stato) throws NoSuchRichiestaException {
		Richiesta richiesta = richiestaPersistence.findByPrimaryKey(richiestaId);
		richiesta.setStato(stato);
		richiestaPersistence.update(richiesta);
	}

	@Override
	public void updateStatoRichiesta(long richiestaId, String stato, String noteToAppend) throws NoSuchRichiestaException {
		Richiesta richiesta = richiestaPersistence.findByPrimaryKey(richiestaId);
		richiesta.setStato(stato);

		if (noteToAppend != null) {
			String note = richiesta.getNote();
			if (Validator.isNull(note)) {
				richiesta.setNote(noteToAppend);
			}
			else {
				note += StringPool.NEW_LINE + noteToAppend;
				richiesta.setNote(note);
			}
		}

		richiestaPersistence.update(richiesta);
	}

	@Override
	public List<Richiesta> getRichiesteByCodiceFiscaleUtenteAndOrganizationGroupid(String codiceFiscale, long organizationGroupId, int cur, int delta, String orderByCol, String orderByType)
			throws Exception {
		List<Richiesta> listaRichieste = new ArrayList<Richiesta>();

		try {
			listaRichieste = richiestaFinder.findRichiestaByCfAndGroupId(codiceFiscale, organizationGroupId, cur, delta, orderByCol, orderByType);
		}
		catch (Exception e) {
			_log.error("getRichiesteByCodiceFiscaleUtenteAndOrganizationGroupid() :: " + e.getMessage(), e);
			throw new Exception(e);
		}

		return listaRichieste;
	}

	@Override
	public void updateProcessiInstanceIdRichiesta(long richiestaId, String processInstanceId) throws NoSuchRichiestaException {
		Richiesta richiesta = richiestaPersistence.findByPrimaryKey(richiestaId);
		richiesta.setProcessInstanceId(processInstanceId);
		richiestaPersistence.update(richiesta);
	}
	
	public List<Richiesta> getRichiesteByCodiceFiscaleStatoProceduraId(String codiceFiscale, String stato, long proceduraId){		
		List<Richiesta> listaRichieste = new ArrayList<Richiesta>();
		listaRichieste = richiestaFinder.findRichiestaByCodiceFiscaleStatoProceduraId(codiceFiscale, stato, proceduraId);
		return listaRichieste;	
	}
}