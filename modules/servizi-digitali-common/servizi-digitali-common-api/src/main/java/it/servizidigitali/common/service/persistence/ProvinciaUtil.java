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

import it.servizidigitali.common.model.Provincia;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the provincia service. This utility wraps <code>it.servizidigitali.common.service.persistence.impl.ProvinciaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProvinciaPersistence
 * @generated
 */
public class ProvinciaUtil {

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
	public static void clearCache(Provincia provincia) {
		getPersistence().clearCache(provincia);
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
	public static Map<Serializable, Provincia> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Provincia> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Provincia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Provincia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Provincia> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Provincia update(Provincia provincia) {
		return getPersistence().update(provincia);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Provincia update(
		Provincia provincia, ServiceContext serviceContext) {

		return getPersistence().update(provincia, serviceContext);
	}

	/**
	 * Returns the provincia where codiceNUTS1 = &#63; or throws a <code>NoSuchProvinciaException</code> if it could not be found.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @return the matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	public static Provincia findByCodiceNUTS1(String codiceNUTS1)
		throws it.servizidigitali.common.exception.NoSuchProvinciaException {

		return getPersistence().findByCodiceNUTS1(codiceNUTS1);
	}

	/**
	 * Returns the provincia where codiceNUTS1 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @return the matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public static Provincia fetchByCodiceNUTS1(String codiceNUTS1) {
		return getPersistence().fetchByCodiceNUTS1(codiceNUTS1);
	}

	/**
	 * Returns the provincia where codiceNUTS1 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public static Provincia fetchByCodiceNUTS1(
		String codiceNUTS1, boolean useFinderCache) {

		return getPersistence().fetchByCodiceNUTS1(codiceNUTS1, useFinderCache);
	}

	/**
	 * Removes the provincia where codiceNUTS1 = &#63; from the database.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @return the provincia that was removed
	 */
	public static Provincia removeByCodiceNUTS1(String codiceNUTS1)
		throws it.servizidigitali.common.exception.NoSuchProvinciaException {

		return getPersistence().removeByCodiceNUTS1(codiceNUTS1);
	}

	/**
	 * Returns the number of provincias where codiceNUTS1 = &#63;.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @return the number of matching provincias
	 */
	public static int countByCodiceNUTS1(String codiceNUTS1) {
		return getPersistence().countByCodiceNUTS1(codiceNUTS1);
	}

	/**
	 * Returns all the provincias where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @return the matching provincias
	 */
	public static List<Provincia> findByCodiceRegione(long codiceRegione) {
		return getPersistence().findByCodiceRegione(codiceRegione);
	}

	/**
	 * Returns a range of all the provincias where codiceRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceRegione the codice regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @return the range of matching provincias
	 */
	public static List<Provincia> findByCodiceRegione(
		long codiceRegione, int start, int end) {

		return getPersistence().findByCodiceRegione(codiceRegione, start, end);
	}

	/**
	 * Returns an ordered range of all the provincias where codiceRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceRegione the codice regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provincias
	 */
	public static List<Provincia> findByCodiceRegione(
		long codiceRegione, int start, int end,
		OrderByComparator<Provincia> orderByComparator) {

		return getPersistence().findByCodiceRegione(
			codiceRegione, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the provincias where codiceRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceRegione the codice regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching provincias
	 */
	public static List<Provincia> findByCodiceRegione(
		long codiceRegione, int start, int end,
		OrderByComparator<Provincia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCodiceRegione(
			codiceRegione, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	public static Provincia findByCodiceRegione_First(
			long codiceRegione, OrderByComparator<Provincia> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchProvinciaException {

		return getPersistence().findByCodiceRegione_First(
			codiceRegione, orderByComparator);
	}

	/**
	 * Returns the first provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public static Provincia fetchByCodiceRegione_First(
		long codiceRegione, OrderByComparator<Provincia> orderByComparator) {

		return getPersistence().fetchByCodiceRegione_First(
			codiceRegione, orderByComparator);
	}

	/**
	 * Returns the last provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	public static Provincia findByCodiceRegione_Last(
			long codiceRegione, OrderByComparator<Provincia> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchProvinciaException {

		return getPersistence().findByCodiceRegione_Last(
			codiceRegione, orderByComparator);
	}

	/**
	 * Returns the last provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public static Provincia fetchByCodiceRegione_Last(
		long codiceRegione, OrderByComparator<Provincia> orderByComparator) {

		return getPersistence().fetchByCodiceRegione_Last(
			codiceRegione, orderByComparator);
	}

	/**
	 * Returns the provincias before and after the current provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param provinciaId the primary key of the current provincia
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next provincia
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	public static Provincia[] findByCodiceRegione_PrevAndNext(
			long provinciaId, long codiceRegione,
			OrderByComparator<Provincia> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchProvinciaException {

		return getPersistence().findByCodiceRegione_PrevAndNext(
			provinciaId, codiceRegione, orderByComparator);
	}

	/**
	 * Removes all the provincias where codiceRegione = &#63; from the database.
	 *
	 * @param codiceRegione the codice regione
	 */
	public static void removeByCodiceRegione(long codiceRegione) {
		getPersistence().removeByCodiceRegione(codiceRegione);
	}

	/**
	 * Returns the number of provincias where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @return the number of matching provincias
	 */
	public static int countByCodiceRegione(long codiceRegione) {
		return getPersistence().countByCodiceRegione(codiceRegione);
	}

	/**
	 * Returns all the provincias where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @return the matching provincias
	 */
	public static List<Provincia> findByDenominazioneRegione(
		String denominazioneRegione) {

		return getPersistence().findByDenominazioneRegione(
			denominazioneRegione);
	}

	/**
	 * Returns a range of all the provincias where denominazioneRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @return the range of matching provincias
	 */
	public static List<Provincia> findByDenominazioneRegione(
		String denominazioneRegione, int start, int end) {

		return getPersistence().findByDenominazioneRegione(
			denominazioneRegione, start, end);
	}

	/**
	 * Returns an ordered range of all the provincias where denominazioneRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provincias
	 */
	public static List<Provincia> findByDenominazioneRegione(
		String denominazioneRegione, int start, int end,
		OrderByComparator<Provincia> orderByComparator) {

		return getPersistence().findByDenominazioneRegione(
			denominazioneRegione, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the provincias where denominazioneRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching provincias
	 */
	public static List<Provincia> findByDenominazioneRegione(
		String denominazioneRegione, int start, int end,
		OrderByComparator<Provincia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDenominazioneRegione(
			denominazioneRegione, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	public static Provincia findByDenominazioneRegione_First(
			String denominazioneRegione,
			OrderByComparator<Provincia> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchProvinciaException {

		return getPersistence().findByDenominazioneRegione_First(
			denominazioneRegione, orderByComparator);
	}

	/**
	 * Returns the first provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public static Provincia fetchByDenominazioneRegione_First(
		String denominazioneRegione,
		OrderByComparator<Provincia> orderByComparator) {

		return getPersistence().fetchByDenominazioneRegione_First(
			denominazioneRegione, orderByComparator);
	}

	/**
	 * Returns the last provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	public static Provincia findByDenominazioneRegione_Last(
			String denominazioneRegione,
			OrderByComparator<Provincia> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchProvinciaException {

		return getPersistence().findByDenominazioneRegione_Last(
			denominazioneRegione, orderByComparator);
	}

	/**
	 * Returns the last provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public static Provincia fetchByDenominazioneRegione_Last(
		String denominazioneRegione,
		OrderByComparator<Provincia> orderByComparator) {

		return getPersistence().fetchByDenominazioneRegione_Last(
			denominazioneRegione, orderByComparator);
	}

	/**
	 * Returns the provincias before and after the current provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param provinciaId the primary key of the current provincia
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next provincia
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	public static Provincia[] findByDenominazioneRegione_PrevAndNext(
			long provinciaId, String denominazioneRegione,
			OrderByComparator<Provincia> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchProvinciaException {

		return getPersistence().findByDenominazioneRegione_PrevAndNext(
			provinciaId, denominazioneRegione, orderByComparator);
	}

	/**
	 * Removes all the provincias where denominazioneRegione = &#63; from the database.
	 *
	 * @param denominazioneRegione the denominazione regione
	 */
	public static void removeByDenominazioneRegione(
		String denominazioneRegione) {

		getPersistence().removeByDenominazioneRegione(denominazioneRegione);
	}

	/**
	 * Returns the number of provincias where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @return the number of matching provincias
	 */
	public static int countByDenominazioneRegione(String denominazioneRegione) {
		return getPersistence().countByDenominazioneRegione(
			denominazioneRegione);
	}

	/**
	 * Returns the provincia where sigla = &#63; or throws a <code>NoSuchProvinciaException</code> if it could not be found.
	 *
	 * @param sigla the sigla
	 * @return the matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	public static Provincia findBySigla(String sigla)
		throws it.servizidigitali.common.exception.NoSuchProvinciaException {

		return getPersistence().findBySigla(sigla);
	}

	/**
	 * Returns the provincia where sigla = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sigla the sigla
	 * @return the matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public static Provincia fetchBySigla(String sigla) {
		return getPersistence().fetchBySigla(sigla);
	}

	/**
	 * Returns the provincia where sigla = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sigla the sigla
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public static Provincia fetchBySigla(String sigla, boolean useFinderCache) {
		return getPersistence().fetchBySigla(sigla, useFinderCache);
	}

	/**
	 * Removes the provincia where sigla = &#63; from the database.
	 *
	 * @param sigla the sigla
	 * @return the provincia that was removed
	 */
	public static Provincia removeBySigla(String sigla)
		throws it.servizidigitali.common.exception.NoSuchProvinciaException {

		return getPersistence().removeBySigla(sigla);
	}

	/**
	 * Returns the number of provincias where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @return the number of matching provincias
	 */
	public static int countBySigla(String sigla) {
		return getPersistence().countBySigla(sigla);
	}

	/**
	 * Caches the provincia in the entity cache if it is enabled.
	 *
	 * @param provincia the provincia
	 */
	public static void cacheResult(Provincia provincia) {
		getPersistence().cacheResult(provincia);
	}

	/**
	 * Caches the provincias in the entity cache if it is enabled.
	 *
	 * @param provincias the provincias
	 */
	public static void cacheResult(List<Provincia> provincias) {
		getPersistence().cacheResult(provincias);
	}

	/**
	 * Creates a new provincia with the primary key. Does not add the provincia to the database.
	 *
	 * @param provinciaId the primary key for the new provincia
	 * @return the new provincia
	 */
	public static Provincia create(long provinciaId) {
		return getPersistence().create(provinciaId);
	}

	/**
	 * Removes the provincia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param provinciaId the primary key of the provincia
	 * @return the provincia that was removed
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	public static Provincia remove(long provinciaId)
		throws it.servizidigitali.common.exception.NoSuchProvinciaException {

		return getPersistence().remove(provinciaId);
	}

	public static Provincia updateImpl(Provincia provincia) {
		return getPersistence().updateImpl(provincia);
	}

	/**
	 * Returns the provincia with the primary key or throws a <code>NoSuchProvinciaException</code> if it could not be found.
	 *
	 * @param provinciaId the primary key of the provincia
	 * @return the provincia
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	public static Provincia findByPrimaryKey(long provinciaId)
		throws it.servizidigitali.common.exception.NoSuchProvinciaException {

		return getPersistence().findByPrimaryKey(provinciaId);
	}

	/**
	 * Returns the provincia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param provinciaId the primary key of the provincia
	 * @return the provincia, or <code>null</code> if a provincia with the primary key could not be found
	 */
	public static Provincia fetchByPrimaryKey(long provinciaId) {
		return getPersistence().fetchByPrimaryKey(provinciaId);
	}

	/**
	 * Returns all the provincias.
	 *
	 * @return the provincias
	 */
	public static List<Provincia> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the provincias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @return the range of provincias
	 */
	public static List<Provincia> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the provincias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of provincias
	 */
	public static List<Provincia> findAll(
		int start, int end, OrderByComparator<Provincia> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the provincias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of provincias
	 */
	public static List<Provincia> findAll(
		int start, int end, OrderByComparator<Provincia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the provincias from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of provincias.
	 *
	 * @return the number of provincias
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProvinciaPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProvinciaPersistence _persistence;

}