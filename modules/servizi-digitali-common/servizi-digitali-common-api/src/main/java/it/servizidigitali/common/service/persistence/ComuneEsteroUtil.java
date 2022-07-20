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

import it.servizidigitali.common.model.ComuneEstero;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the comune estero service. This utility wraps <code>it.servizidigitali.common.service.persistence.impl.ComuneEsteroPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComuneEsteroPersistence
 * @generated
 */
public class ComuneEsteroUtil {

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
	public static void clearCache(ComuneEstero comuneEstero) {
		getPersistence().clearCache(comuneEstero);
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
	public static Map<Serializable, ComuneEstero> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ComuneEstero> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ComuneEstero> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ComuneEstero> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ComuneEstero> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ComuneEstero update(ComuneEstero comuneEstero) {
		return getPersistence().update(comuneEstero);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ComuneEstero update(
		ComuneEstero comuneEstero, ServiceContext serviceContext) {

		return getPersistence().update(comuneEstero, serviceContext);
	}

	/**
	 * Returns the comune estero where codice = &#63; or throws a <code>NoSuchComuneEsteroException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching comune estero
	 * @throws NoSuchComuneEsteroException if a matching comune estero could not be found
	 */
	public static ComuneEstero findByCodice(int codice)
		throws it.servizidigitali.common.exception.NoSuchComuneEsteroException {

		return getPersistence().findByCodice(codice);
	}

	/**
	 * Returns the comune estero where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching comune estero, or <code>null</code> if a matching comune estero could not be found
	 */
	public static ComuneEstero fetchByCodice(int codice) {
		return getPersistence().fetchByCodice(codice);
	}

	/**
	 * Returns the comune estero where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune estero, or <code>null</code> if a matching comune estero could not be found
	 */
	public static ComuneEstero fetchByCodice(
		int codice, boolean useFinderCache) {

		return getPersistence().fetchByCodice(codice, useFinderCache);
	}

	/**
	 * Removes the comune estero where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the comune estero that was removed
	 */
	public static ComuneEstero removeByCodice(int codice)
		throws it.servizidigitali.common.exception.NoSuchComuneEsteroException {

		return getPersistence().removeByCodice(codice);
	}

	/**
	 * Returns the number of comune esteros where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching comune esteros
	 */
	public static int countByCodice(int codice) {
		return getPersistence().countByCodice(codice);
	}

	/**
	 * Returns all the comune esteros where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @return the matching comune esteros
	 */
	public static List<ComuneEstero> findByDenominazioneLike(
		String denominazione) {

		return getPersistence().findByDenominazioneLike(denominazione);
	}

	/**
	 * Returns a range of all the comune esteros where denominazione LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param denominazione the denominazione
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @return the range of matching comune esteros
	 */
	public static List<ComuneEstero> findByDenominazioneLike(
		String denominazione, int start, int end) {

		return getPersistence().findByDenominazioneLike(
			denominazione, start, end);
	}

	/**
	 * Returns an ordered range of all the comune esteros where denominazione LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param denominazione the denominazione
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comune esteros
	 */
	public static List<ComuneEstero> findByDenominazioneLike(
		String denominazione, int start, int end,
		OrderByComparator<ComuneEstero> orderByComparator) {

		return getPersistence().findByDenominazioneLike(
			denominazione, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comune esteros where denominazione LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param denominazione the denominazione
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comune esteros
	 */
	public static List<ComuneEstero> findByDenominazioneLike(
		String denominazione, int start, int end,
		OrderByComparator<ComuneEstero> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDenominazioneLike(
			denominazione, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune estero
	 * @throws NoSuchComuneEsteroException if a matching comune estero could not be found
	 */
	public static ComuneEstero findByDenominazioneLike_First(
			String denominazione,
			OrderByComparator<ComuneEstero> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchComuneEsteroException {

		return getPersistence().findByDenominazioneLike_First(
			denominazione, orderByComparator);
	}

	/**
	 * Returns the first comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune estero, or <code>null</code> if a matching comune estero could not be found
	 */
	public static ComuneEstero fetchByDenominazioneLike_First(
		String denominazione,
		OrderByComparator<ComuneEstero> orderByComparator) {

		return getPersistence().fetchByDenominazioneLike_First(
			denominazione, orderByComparator);
	}

	/**
	 * Returns the last comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune estero
	 * @throws NoSuchComuneEsteroException if a matching comune estero could not be found
	 */
	public static ComuneEstero findByDenominazioneLike_Last(
			String denominazione,
			OrderByComparator<ComuneEstero> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchComuneEsteroException {

		return getPersistence().findByDenominazioneLike_Last(
			denominazione, orderByComparator);
	}

	/**
	 * Returns the last comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune estero, or <code>null</code> if a matching comune estero could not be found
	 */
	public static ComuneEstero fetchByDenominazioneLike_Last(
		String denominazione,
		OrderByComparator<ComuneEstero> orderByComparator) {

		return getPersistence().fetchByDenominazioneLike_Last(
			denominazione, orderByComparator);
	}

	/**
	 * Returns the comune esteros before and after the current comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param comuneEsteroId the primary key of the current comune estero
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comune estero
	 * @throws NoSuchComuneEsteroException if a comune estero with the primary key could not be found
	 */
	public static ComuneEstero[] findByDenominazioneLike_PrevAndNext(
			long comuneEsteroId, String denominazione,
			OrderByComparator<ComuneEstero> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchComuneEsteroException {

		return getPersistence().findByDenominazioneLike_PrevAndNext(
			comuneEsteroId, denominazione, orderByComparator);
	}

	/**
	 * Removes all the comune esteros where denominazione LIKE &#63; from the database.
	 *
	 * @param denominazione the denominazione
	 */
	public static void removeByDenominazioneLike(String denominazione) {
		getPersistence().removeByDenominazioneLike(denominazione);
	}

	/**
	 * Returns the number of comune esteros where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @return the number of matching comune esteros
	 */
	public static int countByDenominazioneLike(String denominazione) {
		return getPersistence().countByDenominazioneLike(denominazione);
	}

	/**
	 * Caches the comune estero in the entity cache if it is enabled.
	 *
	 * @param comuneEstero the comune estero
	 */
	public static void cacheResult(ComuneEstero comuneEstero) {
		getPersistence().cacheResult(comuneEstero);
	}

	/**
	 * Caches the comune esteros in the entity cache if it is enabled.
	 *
	 * @param comuneEsteros the comune esteros
	 */
	public static void cacheResult(List<ComuneEstero> comuneEsteros) {
		getPersistence().cacheResult(comuneEsteros);
	}

	/**
	 * Creates a new comune estero with the primary key. Does not add the comune estero to the database.
	 *
	 * @param comuneEsteroId the primary key for the new comune estero
	 * @return the new comune estero
	 */
	public static ComuneEstero create(long comuneEsteroId) {
		return getPersistence().create(comuneEsteroId);
	}

	/**
	 * Removes the comune estero with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero that was removed
	 * @throws NoSuchComuneEsteroException if a comune estero with the primary key could not be found
	 */
	public static ComuneEstero remove(long comuneEsteroId)
		throws it.servizidigitali.common.exception.NoSuchComuneEsteroException {

		return getPersistence().remove(comuneEsteroId);
	}

	public static ComuneEstero updateImpl(ComuneEstero comuneEstero) {
		return getPersistence().updateImpl(comuneEstero);
	}

	/**
	 * Returns the comune estero with the primary key or throws a <code>NoSuchComuneEsteroException</code> if it could not be found.
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero
	 * @throws NoSuchComuneEsteroException if a comune estero with the primary key could not be found
	 */
	public static ComuneEstero findByPrimaryKey(long comuneEsteroId)
		throws it.servizidigitali.common.exception.NoSuchComuneEsteroException {

		return getPersistence().findByPrimaryKey(comuneEsteroId);
	}

	/**
	 * Returns the comune estero with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero, or <code>null</code> if a comune estero with the primary key could not be found
	 */
	public static ComuneEstero fetchByPrimaryKey(long comuneEsteroId) {
		return getPersistence().fetchByPrimaryKey(comuneEsteroId);
	}

	/**
	 * Returns all the comune esteros.
	 *
	 * @return the comune esteros
	 */
	public static List<ComuneEstero> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the comune esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @return the range of comune esteros
	 */
	public static List<ComuneEstero> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the comune esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comune esteros
	 */
	public static List<ComuneEstero> findAll(
		int start, int end, OrderByComparator<ComuneEstero> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comune esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comune esteros
	 */
	public static List<ComuneEstero> findAll(
		int start, int end, OrderByComparator<ComuneEstero> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the comune esteros from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of comune esteros.
	 *
	 * @return the number of comune esteros
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ComuneEsteroPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ComuneEsteroPersistence _persistence;

}