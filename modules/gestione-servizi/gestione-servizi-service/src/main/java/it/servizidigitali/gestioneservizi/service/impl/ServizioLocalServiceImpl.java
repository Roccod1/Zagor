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

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.base.ServizioLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.servizidigitali.gestioneservizi.model.Servizio",
	service = AopService.class
)
public class ServizioLocalServiceImpl extends ServizioLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(ServizioLocalServiceImpl.class);
	
	public Servizio getServizioById(Long servizioId) {
		_log.info("getServizioById() :: INIZIO");

		Servizio servizio = null;
		List<Tipologia> listaTipologie = null;
		
		try{
			_log.info("getServizioById() :: ID: "+servizioId);
			servizio = servizioPersistence.findByPrimaryKey(servizioId);
			listaTipologie = tipologiaPersistence.getServizioTipologias(servizio.getServizioId());
			_log.info("listaTipologie size: "+listaTipologie.size());
			servizio.setListaTipologie(listaTipologie);
		}catch(Exception e) {
			_log.error("Impossibile ottenere il servizio con ID "+servizioId, e);
		}
		
		_log.info("getServizioById() :: FINE");
		return servizio;
	}
	
	public Servizio aggiornaServizio(Servizio servizioDaAggiornare) {
		
		if(Validator.isNull(servizioDaAggiornare)) {
			_log.error("servizioDaAggiornare e' null");
			return null;
		}
		
		if(Validator.isNull(servizioDaAggiornare.getServizioId()) || servizioDaAggiornare.getServizioId() == 0L) {
			long id = counterLocalService.increment();
			servizioDaAggiornare.setServizioId(id);
		}
		
		Servizio servizioAggiornato = servizioPersistence.update(servizioDaAggiornare);
		if(Validator.isNotNull(servizioDaAggiornare.getListaTipologie()) && !servizioDaAggiornare.getListaTipologie().isEmpty()) {
			List<Tipologia> listaTipologieDaRimuovere = tipologiaPersistence.getServizioTipologias(servizioAggiornato.getServizioId());
			if(Validator.isNotNull(listaTipologieDaRimuovere) && !listaTipologieDaRimuovere.isEmpty()) {
				servizioPersistence.removeTipologias(servizioAggiornato.getServizioId(), listaTipologieDaRimuovere);
			}
			servizioPersistence.addTipologias(servizioAggiornato.getServizioId(), servizioDaAggiornare.getListaTipologie());
		}
		
		return servizioAggiornato;
	}
	
}