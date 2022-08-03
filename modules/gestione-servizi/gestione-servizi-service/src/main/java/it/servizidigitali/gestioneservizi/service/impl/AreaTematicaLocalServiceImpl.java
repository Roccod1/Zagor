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

package it.servizidigitali.gestioneservizi.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneservizi.model.AreaTematica;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.base.AreaTematicaLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.servizidigitali.gestioneservizi.model.AreaTematica",
	service = AopService.class
)
public class AreaTematicaLocalServiceImpl extends AreaTematicaLocalServiceBaseImpl {

	private static final Log  _log = LogFactoryUtil.getLog(AreaTematicaLocalServiceImpl.class);
	
	public AreaTematica salvaAreaTematica(AreaTematica areaTematica) throws Exception {
		
		if(Validator.isNull(areaTematica)) {
			_log.error("tipologiaDaAggiornare e' null");
			return null;
		}
		
		if(Validator.isNull(areaTematica.getAreaTematicaId()) || areaTematica.getAreaTematicaId() == 0L) {
			_log.debug("L'id e' null oppure impostato a 0 :> inserisco una nuova entity");
			long areaTematicaId = counterLocalService.increment();
			areaTematica.setAreaTematicaId(areaTematicaId);
		}
		
		areaTematica = areaTematicaPersistence.update(areaTematica);
		
		return areaTematica;
	}
	
	public List<AreaTematica> getListaAreeTematicheOrdinata(int cur, int delta, String nomeOrdinamento, String direzioneOrdinamento) throws Exception{
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		int inizio = posizioni[0];
		int fine = posizioni[1];
		
		if(Validator.isNull(nomeOrdinamento)) {
			nomeOrdinamento = "ordine";
		}
		
		if(inizio <= 0 || fine <= 0) {
			inizio = QueryUtil.ALL_POS;
			fine = QueryUtil.ALL_POS;
		}
		
		boolean direzione = "desc".equals(direzioneOrdinamento.toLowerCase()) ? false : true;
		OrderByComparator<AreaTematica> ordine = OrderByComparatorFactoryUtil.create("Tipologia", nomeOrdinamento, direzione);
		
		List<AreaTematica> listaAreeTematiche = areaTematicaFinder.getListaAreeTematicheOrdinata(inizio, fine, ordine);
		return listaAreeTematiche;
	}
	
}