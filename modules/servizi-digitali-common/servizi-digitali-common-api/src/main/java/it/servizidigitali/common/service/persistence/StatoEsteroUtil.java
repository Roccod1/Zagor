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

package it.servizidigitali.common.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.common.model.StatoEstero;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the stato estero service. This utility wraps <code>it.servizidigitali.common.service.persistence.impl.StatoEsteroPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoEsteroPersistence
 * @generated
 */
public class StatoEsteroUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(StatoEstero statoEstero) {
		getPersistence().clearCache(statoEstero);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, StatoEstero> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StatoEstero> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatoEstero> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatoEstero> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StatoEstero> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StatoEstero update(StatoEstero statoEstero) {
		return getPersistence().update(statoEstero);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StatoEstero update(
		StatoEstero statoEstero, ServiceContext serviceContext) {

		return getPersistence().update(statoEstero, serviceContext);
	}

	/**
	 * Returns the stato estero where codiceStato = &#63; or throws a <code>NoSuchStatoEsteroException</code> if it could not be found.
	 *
	 * @param codiceStato the codice stato
	 * @return the matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	public static StatoEstero findByCodiceStato(int codiceStato)
		throws it.servizidigitali.common.exception.NoSuchStatoEsteroException {

		return getPersistence().findByCodiceStato(codiceStato);
	}

	/**
	 * Returns the stato estero where codiceStato = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceStato the codice stato
	 * @return the matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public static StatoEstero fetchByCodiceStato(int codiceStato) {
		return getPersistence().fetchByCodiceStato(codiceStato);
	}

	/**
	 * Returns the stato estero where codiceStato = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceStato the codice stato
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public static StatoEstero fetchByCodiceStato(
		int codiceStato, boolean useFinderCache) {

		return getPersistence().fetchByCodiceStato(codiceStato, useFinderCache);
	}

	/**
	 * Removes the stato estero where codiceStato = &#63; from the database.
	 *
	 * @param codiceStato the codice stato
	 * @return the stato estero that was removed
	 */
	public static StatoEstero removeByCodiceStato(int codiceStato)
		throws it.servizidigitali.common.exception.NoSuchStatoEsteroException {

		return getPersistence().removeByCodiceStato(codiceStato);
	}

	/**
	 * Returns the number of stato esteros where codiceStato = &#63;.
	 *
	 * @param codiceStato the codice stato
	 * @return the number of matching stato esteros
	 */
	public static int countByCodiceStato(int codiceStato) {
		return getPersistence().countByCodiceStato(codiceStato);
	}

	/**
	 * Returns the stato estero where denominazione = &#63; or throws a <code>NoSuchStatoEsteroException</code> if it could not be found.
	 *
	 * @param denominazione the denominazione
	 * @return the matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	public static StatoEstero findByDenominazione(String denominazione)
		throws it.servizidigitali.common.exception.NoSuchStatoEsteroException {

		return getPersistence().findByDenominazione(denominazione);
	}

	/**
	 * Returns the stato estero where denominazione = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param denominazione the denominazione
	 * @return the matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public static StatoEstero fetchByDenominazione(String denominazione) {
		return getPersistence().fetchByDenominazione(denominazione);
	}

	/**
	 * Returns the stato estero where denominazione = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param denominazione the denominazione
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public static StatoEstero fetchByDenominazione(
		String denominazione, boolean useFinderCache) {

		return getPersistence().fetchByDenominazione(
			denominazione, useFinderCache);
	}

	/**
	 * Removes the stato estero where denominazione = &#63; from the database.
	 *
	 * @param denominazione the denominazione
	 * @return the stato estero that was removed
	 */
	public static StatoEstero removeByDenominazione(String denominazione)
		throws it.servizidigitali.common.exception.NoSuchStatoEsteroException {

		return getPersistence().removeByDenominazione(denominazione);
	}

	/**
	 * Returns the number of stato esteros where denominazione = &#63;.
	 *
	 * @param denominazione the denominazione
	 * @return the number of matching stato esteros
	 */
	public static int countByDenominazione(String denominazione) {
		return getPersistence().countByDenominazione(denominazione);
	}

	/**
	 * Returns all the stato esteros where continente = &#63;.
	 *
	 * @param continente the continente
	 * @return the matching stato esteros
	 */
	public static List<StatoEstero> findByContinente(int continente) {
		return getPersistence().findByContinente(continente);
	}

	/**
	 * Returns a range of all the stato esteros where continente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param continente the continente
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @return the range of matching stato esteros
	 */
	public static List<StatoEstero> findByContinente(
		int continente, int start, int end) {

		return getPersistence().findByContinente(continente, start, end);
	}

	/**
	 * Returns an ordered range of all the stato esteros where continente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param continente the continente
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato esteros
	 */
	public static List<StatoEstero> findByContinente(
		int continente, int start, int end,
		OrderByComparator<StatoEstero> orderByComparator) {

		return getPersistence().findByContinente(
			continente, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stato esteros where continente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param continente the continente
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stato esteros
	 */
	public static List<StatoEstero> findByContinente(
		int continente, int start, int end,
		OrderByComparator<StatoEstero> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByContinente(
			continente, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stato estero in the ordered set where continente = &#63;.
	 *
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	public static StatoEstero findByContinente_First(
			int continente, OrderByComparator<StatoEstero> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchStatoEsteroException {

		return getPersistence().findByContinente_First(
			continente, orderByComparator);
	}

	/**
	 * Returns the first stato estero in the ordered set where continente = &#63;.
	 *
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public static StatoEstero fetchByContinente_First(
		int continente, OrderByComparator<StatoEstero> orderByComparator) {

		return getPersistence().fetchByContinente_First(
			continente, orderByComparator);
	}

	/**
	 * Returns the last stato estero in the ordered set where continente = &#63;.
	 *
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	public static StatoEstero findByContinente_Last(
			int continente, OrderByComparator<StatoEstero> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchStatoEsteroException {

		return getPersistence().findByContinente_Last(
			continente, orderByComparator);
	}

	/**
	 * Returns the last stato estero in the ordered set where continente = &#63;.
	 *
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public static StatoEstero fetchByContinente_Last(
		int continente, OrderByComparator<StatoEstero> orderByComparator) {

		return getPersistence().fetchByContinente_Last(
			continente, orderByComparator);
	}

	/**
	 * Returns the stato esteros before and after the current stato estero in the ordered set where continente = &#63;.
	 *
	 * @param statoEsteroId the primary key of the current stato estero
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato estero
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	public static StatoEstero[] findByContinente_PrevAndNext(
			long statoEsteroId, int continente,
			OrderByComparator<StatoEstero> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchStatoEsteroException {

		return getPersistence().findByContinente_PrevAndNext(
			statoEsteroId, continente, orderByComparator);
	}

	/**
	 * Removes all the stato esteros where continente = &#63; from the database.
	 *
	 * @param continente the continente
	 */
	public static void removeByContinente(int continente) {
		getPersistence().removeByContinente(continente);
	}

	/**
	 * Returns the number of stato esteros where continente = &#63;.
	 *
	 * @param continente the continente
	 * @return the number of matching stato esteros
	 */
	public static int countByContinente(int continente) {
		return getPersistence().countByContinente(continente);
	}

	/**
	 * Returns all the stato esteros where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @return the matching stato esteros
	 */
	public static List<StatoEstero> findByCodiceArea(int codiceArea) {
		return getPersistence().findByCodiceArea(codiceArea);
	}

	/**
	 * Returns a range of all the stato esteros where codiceArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param codiceArea the codice area
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @return the range of matching stato esteros
	 */
	public static List<StatoEstero> findByCodiceArea(
		int codiceArea, int start, int end) {

		return getPersistence().findByCodiceArea(codiceArea, start, end);
	}

	/**
	 * Returns an ordered range of all the stato esteros where codiceArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param codiceArea the codice area
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato esteros
	 */
	public static List<StatoEstero> findByCodiceArea(
		int codiceArea, int start, int end,
		OrderByComparator<StatoEstero> orderByComparator) {

		return getPersistence().findByCodiceArea(
			codiceArea, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stato esteros where codiceArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param codiceArea the codice area
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stato esteros
	 */
	public static List<StatoEstero> findByCodiceArea(
		int codiceArea, int start, int end,
		OrderByComparator<StatoEstero> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCodiceArea(
			codiceArea, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	public static StatoEstero findByCodiceArea_First(
			int codiceArea, OrderByComparator<StatoEstero> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchStatoEsteroException {

		return getPersistence().findByCodiceArea_First(
			codiceArea, orderByComparator);
	}

	/**
	 * Returns the first stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public static StatoEstero fetchByCodiceArea_First(
		int codiceArea, OrderByComparator<StatoEstero> orderByComparator) {

		return getPersistence().fetchByCodiceArea_First(
			codiceArea, orderByComparator);
	}

	/**
	 * Returns the last stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	public static StatoEstero findByCodiceArea_Last(
			int codiceArea, OrderByComparator<StatoEstero> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchStatoEsteroException {

		return getPersistence().findByCodiceArea_Last(
			codiceArea, orderByComparator);
	}

	/**
	 * Returns the last stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public static StatoEstero fetchByCodiceArea_Last(
		int codiceArea, OrderByComparator<StatoEstero> orderByComparator) {

		return getPersistence().fetchByCodiceArea_Last(
			codiceArea, orderByComparator);
	}

	/**
	 * Returns the stato esteros before and after the current stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param statoEsteroId the primary key of the current stato estero
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato estero
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	public static StatoEstero[] findByCodiceArea_PrevAndNext(
			long statoEsteroId, int codiceArea,
			OrderByComparator<StatoEstero> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchStatoEsteroException {

		return getPersistence().findByCodiceArea_PrevAndNext(
			statoEsteroId, codiceArea, orderByComparator);
	}

	/**
	 * Removes all the stato esteros where codiceArea = &#63; from the database.
	 *
	 * @param codiceArea the codice area
	 */
	public static void removeByCodiceArea(int codiceArea) {
		getPersistence().removeByCodiceArea(codiceArea);
	}

	/**
	 * Returns the number of stato esteros where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @return the number of matching stato esteros
	 */
	public static int countByCodiceArea(int codiceArea) {
		return getPersistence().countByCodiceArea(codiceArea);
	}

	/**
	 * Caches the stato estero in the entity cache if it is enabled.
	 *
	 * @param statoEstero the stato estero
	 */
	public static void cacheResult(StatoEstero statoEstero) {
		getPersistence().cacheResult(statoEstero);
	}

	/**
	 * Caches the stato esteros in the entity cache if it is enabled.
	 *
	 * @param statoEsteros the stato esteros
	 */
	public static void cacheResult(List<StatoEstero> statoEsteros) {
		getPersistence().cacheResult(statoEsteros);
	}

	/**
	 * Creates a new stato estero with the primary key. Does not add the stato estero to the database.
	 *
	 * @param statoEsteroId the primary key for the new stato estero
	 * @return the new stato estero
	 */
	public static StatoEstero create(long statoEsteroId) {
		return getPersistence().create(statoEsteroId);
	}

	/**
	 * Removes the stato estero with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statoEsteroId the primary key of the stato estero
	 * @return the stato estero that was removed
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	public static StatoEstero remove(long statoEsteroId)
		throws it.servizidigitali.common.exception.NoSuchStatoEsteroException {

		return getPersistence().remove(statoEsteroId);
	}

	public static StatoEstero updateImpl(StatoEstero statoEstero) {
		return getPersistence().updateImpl(statoEstero);
	}

	/**
	 * Returns the stato estero with the primary key or throws a <code>NoSuchStatoEsteroException</code> if it could not be found.
	 *
	 * @param statoEsteroId the primary key of the stato estero
	 * @return the stato estero
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	public static StatoEstero findByPrimaryKey(long statoEsteroId)
		throws it.servizidigitali.common.exception.NoSuchStatoEsteroException {

		return getPersistence().findByPrimaryKey(statoEsteroId);
	}

	/**
	 * Returns the stato estero with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statoEsteroId the primary key of the stato estero
	 * @return the stato estero, or <code>null</code> if a stato estero with the primary key could not be found
	 */
	public static StatoEstero fetchByPrimaryKey(long statoEsteroId) {
		return getPersistence().fetchByPrimaryKey(statoEsteroId);
	}

	/**
	 * Returns all the stato esteros.
	 *
	 * @return the stato esteros
	 */
	public static List<StatoEstero> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the stato esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @return the range of stato esteros
	 */
	public static List<StatoEstero> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the stato esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stato esteros
	 */
	public static List<StatoEstero> findAll(
		int start, int end, OrderByComparator<StatoEstero> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stato esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of stato esteros
	 */
	public static List<StatoEstero> findAll(
		int start, int end, OrderByComparator<StatoEstero> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the stato esteros from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of stato esteros.
	 *
	 * @return the number of stato esteros
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StatoEsteroPersistence getPersistence() {
		return _persistence;
	}

	private static volatile StatoEsteroPersistence _persistence;

}