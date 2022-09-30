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

package it.servizidigitali.gestioneservizi.service.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneservizi.exception.NoSuchServizioException;
import it.servizidigitali.gestioneservizi.model.AreaTematica;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.base.ServizioLocalServiceBaseImpl;

/**
 * @author filierim
 *
 */
@Component(property = "model.class.name=it.servizidigitali.gestioneservizi.model.Servizio", service = AopService.class)
public class ServizioLocalServiceImpl extends ServizioLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(ServizioLocalServiceImpl.class);

	@Override
	public Servizio getServizioById(Long servizioId) throws Exception {
		_log.debug("getServizioById() :: INIZIO");

		_log.debug("getServizioById() :: ID: " + servizioId);
		Servizio servizio = servizioPersistence.findByPrimaryKey(servizioId);
		List<Tipologia> listaTipologie = tipologiaPersistence.getServizioTipologias(servizio.getServizioId());

		if (Validator.isNotNull(servizio.getAreaTematicaId())) {
			AreaTematica areaTematica = areaTematicaPersistence.fetchByPrimaryKey(servizio.getAreaTematicaId());
			if (Validator.isNotNull(areaTematica)) {
				servizio.setAreaTematica(areaTematica);
			}
			else {
				_log.warn("Area tematica inesistente con ID: " + servizio.getAreaTematicaId());
			}
		}
		_log.debug("listaTipologie size: " + listaTipologie.size());
		if (Validator.isNotNull(listaTipologie) && !listaTipologie.isEmpty()) {
			servizio.setListaTipologie(listaTipologie);
		}

		_log.debug("getServizioById() :: FINE");
		return servizio;
	}

	@Override
	public Servizio aggiornaServizio(Servizio servizioDaAggiornare) throws Exception {

		if (Validator.isNull(servizioDaAggiornare)) {
			_log.error("servizioDaAggiornare e' null");
			return null;
		}

		if (Validator.isNull(servizioDaAggiornare.getServizioId()) || servizioDaAggiornare.getServizioId() == 0L) {
			long id = counterLocalService.increment();
			servizioDaAggiornare.setServizioId(id);
		}

		Servizio servizioAggiornato = servizioPersistence.update(servizioDaAggiornare);

		_log.debug("Ottengo la lista delle tipologie con servidioId: " + servizioDaAggiornare.getServizioId());
		List<Tipologia> listaTipologieDaRimuovere = tipologiaPersistence.getServizioTipologias(servizioAggiornato.getServizioId());
		if (Validator.isNotNull(listaTipologieDaRimuovere) && !listaTipologieDaRimuovere.isEmpty()) {
			_log.debug("listaTiplogieDaRimuovere non è null :> Rimuovo le vecchie tipologie associate al servizio");
			servizioPersistence.removeTipologias(servizioAggiornato.getServizioId(), listaTipologieDaRimuovere);
		}
		if (Validator.isNotNull(servizioDaAggiornare.getListaTipologie()) && !servizioDaAggiornare.getListaTipologie().isEmpty()) {
			_log.debug("Imposto nove tipologie");
			servizioPersistence.addTipologias(servizioDaAggiornare.getServizioId(), servizioDaAggiornare.getListaTipologie());
		}

		return servizioAggiornato;
	}

	/**
	 *
	 * @param nome
	 * @param codice
	 * @param soloServiziAttivi
	 * @param inizio
	 * @param fine
	 * @param orderByCol
	 * @param orderByType
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Servizio> search(String nome, String codice, Boolean soloServiziAttivi, int inizio, int fine, String orderByCol, String orderByType) throws Exception {

		boolean direzione = "desc".equals(orderByType.toLowerCase()) ? false : true;

		OrderByComparator<Servizio> ordine = OrderByComparatorFactoryUtil.create("Servizio", orderByCol, direzione);

		List<Servizio> listaServizi = servizioFinder.findByNomeCodiceAttivo(nome, codice, soloServiziAttivi, inizio, fine, ordine);
		return listaServizi;
	}

	@Override
	public int count(String nome, String codice, Boolean soloServiziAttivi) {
		ClassLoader classLoader = getClass().getClassLoader();

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Servizio.class, classLoader);

		if (Validator.isNotNull(nome)) {
			query.add(RestrictionsFactoryUtil.like("nome", StringPool.PERCENT + nome + StringPool.PERCENT));
		}

		if (Validator.isNotNull(codice)) {
			query.add(RestrictionsFactoryUtil.like("codice", StringPool.PERCENT + codice + StringPool.PERCENT));
		}

		if (soloServiziAttivi) {
			query.add(RestrictionsFactoryUtil.eq("attivo", true));
		}

		return (int) servizioPersistence.countWithDynamicQuery(query);
	}

	@Override
	public List<Servizio> listaServiziAttivi(Boolean attivo, Integer start, Integer end) throws Exception {
		return servizioPersistence.findByAttivo(attivo, start, end);
	}

	@Override
	public List<Servizio> getServiziUtilizzabili(List<Object> listaServiziEnte, String nome, long areaTematicaId, long tipologiaId, int cur, int delta, String orderByCol, String orderByType) {

		// preparo i parametri per ordinamento e paginazione
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		int inizio = posizioni[0];
		int fine = posizioni[1];
		boolean direzione = true;

		if (Validator.isNull(orderByCol)) {
			_log.debug("Nessun ordinamento impostato. Uso di default servizioId");
			orderByCol = "servizioId";
		}

		if (inizio <= 0 || fine <= 0) {
			_log.debug("Posizione iniziale o finale sono minori o uguali a zero. Imposto inizio e fine al valore ALL_POS");
			inizio = QueryUtil.ALL_POS;
			fine = QueryUtil.ALL_POS;
		}

		if (!Validator.isBlank(orderByType)) {
			if ("desc".equals(orderByType.toLowerCase())) {
				direzione = false;
			}
		}

		OrderByComparator<Servizio> ordine = OrderByComparatorFactoryUtil.create("Servizio", orderByCol, direzione);

		ClassLoader classLoader = getClassLoader();
		DynamicQuery servizioDynamicQuery = DynamicQueryFactoryUtil.forClass(Servizio.class, classLoader);

		// imposto "join" di servizio su servizioEnte in modo che servizioEnte.servizioId =
		// servizio.servizioId
		servizioDynamicQuery.add(PropertyFactoryUtil.forName("servizioId").in(listaServiziEnte));

		if (!Validator.isBlank(nome)) {
			servizioDynamicQuery.add(RestrictionsFactoryUtil.like("nome", StringPool.PERCENT + nome + StringPool.PERCENT));
		}

		if (areaTematicaId > 0) {
			servizioDynamicQuery.add(RestrictionsFactoryUtil.eq("areaTematicaId", areaTematicaId));
		}

		if (tipologiaId > 0) {
			servizioDynamicQuery.add(RestrictionsFactoryUtil.eq("tipologiaId", tipologiaId));
		}
		List<Servizio> listaServizi = servizioPersistence.findWithDynamicQuery(servizioDynamicQuery, inizio, fine, ordine);

		setAreaTematicaListaServizi(listaServizi);

		// richiedo lista servizi paginata e ordinata
		return servizioPersistence.findWithDynamicQuery(servizioDynamicQuery, inizio, fine, ordine);
	}

	private void setAreaTematicaListaServizi(List<Servizio> listaServizi) {
		for (Servizio servizio : listaServizi) {
			setAreaTematica(servizio);
		}
	}

	private void setAreaTematica(Servizio servizio) {
		if (servizio.getAreaTematicaId() > 0) {
			AreaTematica areaTematica = areaTematicaPersistence.fetchByPrimaryKey(servizio.getAreaTematicaId());
			if (Validator.isNotNull(areaTematica)) {
				servizio.setAreaTematica(areaTematica);
			}
		}
	}

	@Override
	public Servizio getServizioByCodice(String codice) {
		Servizio servizio = null;
		try {
			servizio = servizioPersistence.findByCodice(codice);
		}
		catch (NoSuchServizioException e) {
		}
		return servizio;
	}
}