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

import it.servizidigitali.common.model.Comune;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the comune service. This utility wraps <code>it.servizidigitali.common.service.persistence.impl.ComunePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComunePersistence
 * @generated
 */
public class ComuneUtil {

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
	public static void clearCache(Comune comune) {
		getPersistence().clearCache(comune);
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
	public static Map<Serializable, Comune> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Comune> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Comune> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Comune> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Comune> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Comune update(Comune comune) {
		return getPersistence().update(comune);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Comune update(Comune comune, ServiceContext serviceContext) {
		return getPersistence().update(comune, serviceContext);
	}

	/**
	 * Returns the comune where codiceIstatAN = &#63; or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @return the matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public static Comune findByCodiceIstatAN(String codiceIstatAN)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().findByCodiceIstatAN(codiceIstatAN);
	}

	/**
	 * Returns the comune where codiceIstatAN = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public static Comune fetchByCodiceIstatAN(String codiceIstatAN) {
		return getPersistence().fetchByCodiceIstatAN(codiceIstatAN);
	}

	/**
	 * Returns the comune where codiceIstatAN = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public static Comune fetchByCodiceIstatAN(
		String codiceIstatAN, boolean useFinderCache) {

		return getPersistence().fetchByCodiceIstatAN(
			codiceIstatAN, useFinderCache);
	}

	/**
	 * Removes the comune where codiceIstatAN = &#63; from the database.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @return the comune that was removed
	 */
	public static Comune removeByCodiceIstatAN(String codiceIstatAN)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().removeByCodiceIstatAN(codiceIstatAN);
	}

	/**
	 * Returns the number of comunes where codiceIstatAN = &#63;.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @return the number of matching comunes
	 */
	public static int countByCodiceIstatAN(String codiceIstatAN) {
		return getPersistence().countByCodiceIstatAN(codiceIstatAN);
	}

	/**
	 * Returns the comune where codiceCatastale = &#63; or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param codiceCatastale the codice catastale
	 * @return the matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public static Comune findByCodiceCatastale(String codiceCatastale)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().findByCodiceCatastale(codiceCatastale);
	}

	/**
	 * Returns the comune where codiceCatastale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceCatastale the codice catastale
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public static Comune fetchByCodiceCatastale(String codiceCatastale) {
		return getPersistence().fetchByCodiceCatastale(codiceCatastale);
	}

	/**
	 * Returns the comune where codiceCatastale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceCatastale the codice catastale
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public static Comune fetchByCodiceCatastale(
		String codiceCatastale, boolean useFinderCache) {

		return getPersistence().fetchByCodiceCatastale(
			codiceCatastale, useFinderCache);
	}

	/**
	 * Removes the comune where codiceCatastale = &#63; from the database.
	 *
	 * @param codiceCatastale the codice catastale
	 * @return the comune that was removed
	 */
	public static Comune removeByCodiceCatastale(String codiceCatastale)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().removeByCodiceCatastale(codiceCatastale);
	}

	/**
	 * Returns the number of comunes where codiceCatastale = &#63;.
	 *
	 * @param codiceCatastale the codice catastale
	 * @return the number of matching comunes
	 */
	public static int countByCodiceCatastale(String codiceCatastale) {
		return getPersistence().countByCodiceCatastale(codiceCatastale);
	}

	/**
	 * Returns the comune where codiceComune = &#63; or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param codiceComune the codice comune
	 * @return the matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public static Comune findByCodiceComune(int codiceComune)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().findByCodiceComune(codiceComune);
	}

	/**
	 * Returns the comune where codiceComune = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceComune the codice comune
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public static Comune fetchByCodiceComune(int codiceComune) {
		return getPersistence().fetchByCodiceComune(codiceComune);
	}

	/**
	 * Returns the comune where codiceComune = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceComune the codice comune
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public static Comune fetchByCodiceComune(
		int codiceComune, boolean useFinderCache) {

		return getPersistence().fetchByCodiceComune(
			codiceComune, useFinderCache);
	}

	/**
	 * Removes the comune where codiceComune = &#63; from the database.
	 *
	 * @param codiceComune the codice comune
	 * @return the comune that was removed
	 */
	public static Comune removeByCodiceComune(int codiceComune)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().removeByCodiceComune(codiceComune);
	}

	/**
	 * Returns the number of comunes where codiceComune = &#63;.
	 *
	 * @param codiceComune the codice comune
	 * @return the number of matching comunes
	 */
	public static int countByCodiceComune(int codiceComune) {
		return getPersistence().countByCodiceComune(codiceComune);
	}

	/**
	 * Returns all the comunes where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @return the matching comunes
	 */
	public static List<Comune> findByidRegione(long idProvincia) {
		return getPersistence().findByidRegione(idProvincia);
	}

	/**
	 * Returns a range of all the comunes where idProvincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idProvincia the id provincia
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @return the range of matching comunes
	 */
	public static List<Comune> findByidRegione(
		long idProvincia, int start, int end) {

		return getPersistence().findByidRegione(idProvincia, start, end);
	}

	/**
	 * Returns an ordered range of all the comunes where idProvincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idProvincia the id provincia
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunes
	 */
	public static List<Comune> findByidRegione(
		long idProvincia, int start, int end,
		OrderByComparator<Comune> orderByComparator) {

		return getPersistence().findByidRegione(
			idProvincia, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comunes where idProvincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idProvincia the id provincia
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunes
	 */
	public static List<Comune> findByidRegione(
		long idProvincia, int start, int end,
		OrderByComparator<Comune> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByidRegione(
			idProvincia, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public static Comune findByidRegione_First(
			long idProvincia, OrderByComparator<Comune> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().findByidRegione_First(
			idProvincia, orderByComparator);
	}

	/**
	 * Returns the first comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public static Comune fetchByidRegione_First(
		long idProvincia, OrderByComparator<Comune> orderByComparator) {

		return getPersistence().fetchByidRegione_First(
			idProvincia, orderByComparator);
	}

	/**
	 * Returns the last comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public static Comune findByidRegione_Last(
			long idProvincia, OrderByComparator<Comune> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().findByidRegione_Last(
			idProvincia, orderByComparator);
	}

	/**
	 * Returns the last comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public static Comune fetchByidRegione_Last(
		long idProvincia, OrderByComparator<Comune> orderByComparator) {

		return getPersistence().fetchByidRegione_Last(
			idProvincia, orderByComparator);
	}

	/**
	 * Returns the comunes before and after the current comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param comuneId the primary key of the current comune
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comune
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	public static Comune[] findByidRegione_PrevAndNext(
			long comuneId, long idProvincia,
			OrderByComparator<Comune> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().findByidRegione_PrevAndNext(
			comuneId, idProvincia, orderByComparator);
	}

	/**
	 * Removes all the comunes where idProvincia = &#63; from the database.
	 *
	 * @param idProvincia the id provincia
	 */
	public static void removeByidRegione(long idProvincia) {
		getPersistence().removeByidRegione(idProvincia);
	}

	/**
	 * Returns the number of comunes where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @return the number of matching comunes
	 */
	public static int countByidRegione(long idProvincia) {
		return getPersistence().countByidRegione(idProvincia);
	}

	/**
	 * Returns all the comunes where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @return the matching comunes
	 */
	public static List<Comune> findByIdProvincia(long idRegione) {
		return getPersistence().findByIdProvincia(idRegione);
	}

	/**
	 * Returns a range of all the comunes where idRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegione the id regione
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @return the range of matching comunes
	 */
	public static List<Comune> findByIdProvincia(
		long idRegione, int start, int end) {

		return getPersistence().findByIdProvincia(idRegione, start, end);
	}

	/**
	 * Returns an ordered range of all the comunes where idRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegione the id regione
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunes
	 */
	public static List<Comune> findByIdProvincia(
		long idRegione, int start, int end,
		OrderByComparator<Comune> orderByComparator) {

		return getPersistence().findByIdProvincia(
			idRegione, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comunes where idRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegione the id regione
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunes
	 */
	public static List<Comune> findByIdProvincia(
		long idRegione, int start, int end,
		OrderByComparator<Comune> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByIdProvincia(
			idRegione, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comune in the ordered set where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public static Comune findByIdProvincia_First(
			long idRegione, OrderByComparator<Comune> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().findByIdProvincia_First(
			idRegione, orderByComparator);
	}

	/**
	 * Returns the first comune in the ordered set where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public static Comune fetchByIdProvincia_First(
		long idRegione, OrderByComparator<Comune> orderByComparator) {

		return getPersistence().fetchByIdProvincia_First(
			idRegione, orderByComparator);
	}

	/**
	 * Returns the last comune in the ordered set where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public static Comune findByIdProvincia_Last(
			long idRegione, OrderByComparator<Comune> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().findByIdProvincia_Last(
			idRegione, orderByComparator);
	}

	/**
	 * Returns the last comune in the ordered set where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public static Comune fetchByIdProvincia_Last(
		long idRegione, OrderByComparator<Comune> orderByComparator) {

		return getPersistence().fetchByIdProvincia_Last(
			idRegione, orderByComparator);
	}

	/**
	 * Returns the comunes before and after the current comune in the ordered set where idRegione = &#63;.
	 *
	 * @param comuneId the primary key of the current comune
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comune
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	public static Comune[] findByIdProvincia_PrevAndNext(
			long comuneId, long idRegione,
			OrderByComparator<Comune> orderByComparator)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().findByIdProvincia_PrevAndNext(
			comuneId, idRegione, orderByComparator);
	}

	/**
	 * Removes all the comunes where idRegione = &#63; from the database.
	 *
	 * @param idRegione the id regione
	 */
	public static void removeByIdProvincia(long idRegione) {
		getPersistence().removeByIdProvincia(idRegione);
	}

	/**
	 * Returns the number of comunes where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @return the number of matching comunes
	 */
	public static int countByIdProvincia(long idRegione) {
		return getPersistence().countByIdProvincia(idRegione);
	}

	/**
	 * Caches the comune in the entity cache if it is enabled.
	 *
	 * @param comune the comune
	 */
	public static void cacheResult(Comune comune) {
		getPersistence().cacheResult(comune);
	}

	/**
	 * Caches the comunes in the entity cache if it is enabled.
	 *
	 * @param comunes the comunes
	 */
	public static void cacheResult(List<Comune> comunes) {
		getPersistence().cacheResult(comunes);
	}

	/**
	 * Creates a new comune with the primary key. Does not add the comune to the database.
	 *
	 * @param comuneId the primary key for the new comune
	 * @return the new comune
	 */
	public static Comune create(long comuneId) {
		return getPersistence().create(comuneId);
	}

	/**
	 * Removes the comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param comuneId the primary key of the comune
	 * @return the comune that was removed
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	public static Comune remove(long comuneId)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().remove(comuneId);
	}

	public static Comune updateImpl(Comune comune) {
		return getPersistence().updateImpl(comune);
	}

	/**
	 * Returns the comune with the primary key or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param comuneId the primary key of the comune
	 * @return the comune
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	public static Comune findByPrimaryKey(long comuneId)
		throws it.servizidigitali.common.exception.NoSuchComuneException {

		return getPersistence().findByPrimaryKey(comuneId);
	}

	/**
	 * Returns the comune with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param comuneId the primary key of the comune
	 * @return the comune, or <code>null</code> if a comune with the primary key could not be found
	 */
	public static Comune fetchByPrimaryKey(long comuneId) {
		return getPersistence().fetchByPrimaryKey(comuneId);
	}

	/**
	 * Returns all the comunes.
	 *
	 * @return the comunes
	 */
	public static List<Comune> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @return the range of comunes
	 */
	public static List<Comune> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comunes
	 */
	public static List<Comune> findAll(
		int start, int end, OrderByComparator<Comune> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comunes
	 */
	public static List<Comune> findAll(
		int start, int end, OrderByComparator<Comune> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the comunes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of comunes.
	 *
	 * @return the number of comunes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ComunePersistence getPersistence() {
		return _persistence;
	}

	private static volatile ComunePersistence _persistence;

}