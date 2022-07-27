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

import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.base.ServizioLocalServiceBaseImpl;

/**
 * @author filierim
 *
 */
@Component(
	property = "model.class.name=it.servizidigitali.gestioneservizi.model.Servizio",
	service = AopService.class
)
public class ServizioLocalServiceImpl extends ServizioLocalServiceBaseImpl{

	private static final Log _log = LogFactoryUtil.getLog(ServizioLocalServiceImpl.class);
	
	public Servizio getServizioById(Long servizioId) throws Exception{
		_log.debug("getServizioById() :: INIZIO");

		Servizio servizio = null;
		List<Tipologia> listaTipologie = null;
		

		_log.debug("getServizioById() :: ID: "+servizioId);
		servizio = servizioPersistence.findByPrimaryKey(servizioId);
		listaTipologie = tipologiaPersistence.getServizioTipologias(servizio.getServizioId());
		_log.debug("listaTipologie size: "+listaTipologie.size());
		if(Validator.isNotNull(listaTipologie) && !listaTipologie.isEmpty()) {
			servizio.setListaTipologie(listaTipologie);				
		}
		
		_log.debug("getServizioById() :: FINE");
		return servizio;
	}
	
	public Servizio aggiornaServizio(Servizio servizioDaAggiornare) throws Exception{
		
		if(Validator.isNull(servizioDaAggiornare)) {
			_log.error("servizioDaAggiornare e' null");
			return null;
		}
		
		if(Validator.isNull(servizioDaAggiornare.getServizioId()) || servizioDaAggiornare.getServizioId() == 0L) {
			long id = counterLocalService.increment();
			servizioDaAggiornare.setServizioId(id);
		}
		
		Servizio servizioAggiornato = servizioPersistence.update(servizioDaAggiornare);
		
		_log.debug("Ottengo la lista delle tipologie con servidioId: " + servizioDaAggiornare.getServizioId());
		List<Tipologia> listaTipologieDaRimuovere = tipologiaPersistence.getServizioTipologias(servizioAggiornato.getServizioId());
		if(Validator.isNotNull(listaTipologieDaRimuovere) && !listaTipologieDaRimuovere.isEmpty()) {
			_log.debug("listaTiplogieDaRimuovere non è null :> Rimuovo le vecchie tipologie associate al servizio");
			servizioPersistence.removeTipologias(servizioAggiornato.getServizioId(), listaTipologieDaRimuovere);
		}
		if(Validator.isNotNull(servizioDaAggiornare.getListaTipologie()) && !servizioDaAggiornare.getListaTipologie().isEmpty()) {
			_log.debug("Imposto nove tipologie");
			servizioPersistence.addTipologias(servizioDaAggiornare.getServizioId(), servizioDaAggiornare.getListaTipologie());
		}

		return servizioAggiornato;
	}
	
	/**
	 * @param nome
	 * @param codice
	 * @param soloServiziAttivi
	 * @param cur: pagina attuale
	 * @param delta: numero elementi per pagina
	 * @param nomeOrdinamento
	 * @param direzioneOrdinamento
	 * @return
	 */
	public List<Servizio> searchServizio(String nome, String codice, Boolean soloServiziAttivi, int cur, int delta, String nomeOrdinamento, String direzioneOrdinamento) throws Exception{

		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		int inizio = posizioni[0];
		int fine = posizioni[1];
		
		if(Validator.isNull(nomeOrdinamento)) {
			_log.debug("Nessun ordinamento impostato. Uso di default servizioId");
			nomeOrdinamento = "servizioId";
		}
		
		if(inizio <= 0 || fine <= 0) {
			_log.debug("Posizione iniziale o finale sono minori o uguali a zero. Imposto inizio e fine al valore ALL_POS");
			inizio = QueryUtil.ALL_POS;
			fine = QueryUtil.ALL_POS;
		}
		
	
		boolean direzione = "desc".equals(direzioneOrdinamento.toLowerCase()) ? false : true;
		
		OrderByComparator<Servizio> ordine = OrderByComparatorFactoryUtil.create("Servizio", nomeOrdinamento, direzione);
		
		List<Servizio> listaServizi = servizioFinder.findServizioByFilter(nome, codice, soloServiziAttivi, inizio, fine, ordine);
	
		return listaServizi;
	}
	
	public int countSearchServizio(String nome, String codice, Boolean soloServiziAttivi) {
		return servizioFinder.countServizioByFilter(nome, codice, soloServiziAttivi);
	}
	
	public List<Servizio> listaServiziAttivi(Boolean attivo, Integer start, Integer end) throws Exception{
		return servizioPersistence.findByAttivo(attivo, start, end);
	}
	
}