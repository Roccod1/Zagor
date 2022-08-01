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

package it.servizidigitali.profiloutente.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.profiloutente.model.CanaleComunicazione;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the canale comunicazione service. This utility wraps <code>it.servizidigitali.profiloutente.service.persistence.impl.CanaleComunicazionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanaleComunicazionePersistence
 * @generated
 */
public class CanaleComunicazioneUtil {

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
	public static void clearCache(CanaleComunicazione canaleComunicazione) {
		getPersistence().clearCache(canaleComunicazione);
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
	public static Map<Serializable, CanaleComunicazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CanaleComunicazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CanaleComunicazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CanaleComunicazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CanaleComunicazione> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CanaleComunicazione update(
		CanaleComunicazione canaleComunicazione) {

		return getPersistence().update(canaleComunicazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CanaleComunicazione update(
		CanaleComunicazione canaleComunicazione,
		ServiceContext serviceContext) {

		return getPersistence().update(canaleComunicazione, serviceContext);
	}

	/**
	 * Returns the canale comunicazione where codice = &#63; or throws a <code>NoSuchCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	public static CanaleComunicazione findByCodice(String codice)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchCanaleComunicazioneException {

		return getPersistence().findByCodice(codice);
	}

	/**
	 * Returns the canale comunicazione where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public static CanaleComunicazione fetchByCodice(String codice) {
		return getPersistence().fetchByCodice(codice);
	}

	/**
	 * Returns the canale comunicazione where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public static CanaleComunicazione fetchByCodice(
		String codice, boolean useFinderCache) {

		return getPersistence().fetchByCodice(codice, useFinderCache);
	}

	/**
	 * Removes the canale comunicazione where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the canale comunicazione that was removed
	 */
	public static CanaleComunicazione removeByCodice(String codice)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchCanaleComunicazioneException {

		return getPersistence().removeByCodice(codice);
	}

	/**
	 * Returns the number of canale comunicaziones where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching canale comunicaziones
	 */
	public static int countByCodice(String codice) {
		return getPersistence().countByCodice(codice);
	}

	/**
	 * Returns all the canale comunicaziones where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching canale comunicaziones
	 */
	public static List<CanaleComunicazione> findByAttivo(boolean attivo) {
		return getPersistence().findByAttivo(attivo);
	}

	/**
	 * Returns a range of all the canale comunicaziones where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @return the range of matching canale comunicaziones
	 */
	public static List<CanaleComunicazione> findByAttivo(
		boolean attivo, int start, int end) {

		return getPersistence().findByAttivo(attivo, start, end);
	}

	/**
	 * Returns an ordered range of all the canale comunicaziones where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching canale comunicaziones
	 */
	public static List<CanaleComunicazione> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<CanaleComunicazione> orderByComparator) {

		return getPersistence().findByAttivo(
			attivo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the canale comunicaziones where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching canale comunicaziones
	 */
	public static List<CanaleComunicazione> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<CanaleComunicazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAttivo(
			attivo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	public static CanaleComunicazione findByAttivo_First(
			boolean attivo,
			OrderByComparator<CanaleComunicazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchCanaleComunicazioneException {

		return getPersistence().findByAttivo_First(attivo, orderByComparator);
	}

	/**
	 * Returns the first canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public static CanaleComunicazione fetchByAttivo_First(
		boolean attivo,
		OrderByComparator<CanaleComunicazione> orderByComparator) {

		return getPersistence().fetchByAttivo_First(attivo, orderByComparator);
	}

	/**
	 * Returns the last canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	public static CanaleComunicazione findByAttivo_Last(
			boolean attivo,
			OrderByComparator<CanaleComunicazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchCanaleComunicazioneException {

		return getPersistence().findByAttivo_Last(attivo, orderByComparator);
	}

	/**
	 * Returns the last canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public static CanaleComunicazione fetchByAttivo_Last(
		boolean attivo,
		OrderByComparator<CanaleComunicazione> orderByComparator) {

		return getPersistence().fetchByAttivo_Last(attivo, orderByComparator);
	}

	/**
	 * Returns the canale comunicaziones before and after the current canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param canaleComunicazioneId the primary key of the current canale comunicazione
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	public static CanaleComunicazione[] findByAttivo_PrevAndNext(
			long canaleComunicazioneId, boolean attivo,
			OrderByComparator<CanaleComunicazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchCanaleComunicazioneException {

		return getPersistence().findByAttivo_PrevAndNext(
			canaleComunicazioneId, attivo, orderByComparator);
	}

	/**
	 * Removes all the canale comunicaziones where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	public static void removeByAttivo(boolean attivo) {
		getPersistence().removeByAttivo(attivo);
	}

	/**
	 * Returns the number of canale comunicaziones where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching canale comunicaziones
	 */
	public static int countByAttivo(boolean attivo) {
		return getPersistence().countByAttivo(attivo);
	}

	/**
	 * Caches the canale comunicazione in the entity cache if it is enabled.
	 *
	 * @param canaleComunicazione the canale comunicazione
	 */
	public static void cacheResult(CanaleComunicazione canaleComunicazione) {
		getPersistence().cacheResult(canaleComunicazione);
	}

	/**
	 * Caches the canale comunicaziones in the entity cache if it is enabled.
	 *
	 * @param canaleComunicaziones the canale comunicaziones
	 */
	public static void cacheResult(
		List<CanaleComunicazione> canaleComunicaziones) {

		getPersistence().cacheResult(canaleComunicaziones);
	}

	/**
	 * Creates a new canale comunicazione with the primary key. Does not add the canale comunicazione to the database.
	 *
	 * @param canaleComunicazioneId the primary key for the new canale comunicazione
	 * @return the new canale comunicazione
	 */
	public static CanaleComunicazione create(long canaleComunicazioneId) {
		return getPersistence().create(canaleComunicazioneId);
	}

	/**
	 * Removes the canale comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param canaleComunicazioneId the primary key of the canale comunicazione
	 * @return the canale comunicazione that was removed
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	public static CanaleComunicazione remove(long canaleComunicazioneId)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchCanaleComunicazioneException {

		return getPersistence().remove(canaleComunicazioneId);
	}

	public static CanaleComunicazione updateImpl(
		CanaleComunicazione canaleComunicazione) {

		return getPersistence().updateImpl(canaleComunicazione);
	}

	/**
	 * Returns the canale comunicazione with the primary key or throws a <code>NoSuchCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param canaleComunicazioneId the primary key of the canale comunicazione
	 * @return the canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	public static CanaleComunicazione findByPrimaryKey(
			long canaleComunicazioneId)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchCanaleComunicazioneException {

		return getPersistence().findByPrimaryKey(canaleComunicazioneId);
	}

	/**
	 * Returns the canale comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param canaleComunicazioneId the primary key of the canale comunicazione
	 * @return the canale comunicazione, or <code>null</code> if a canale comunicazione with the primary key could not be found
	 */
	public static CanaleComunicazione fetchByPrimaryKey(
		long canaleComunicazioneId) {

		return getPersistence().fetchByPrimaryKey(canaleComunicazioneId);
	}

	/**
	 * Returns all the canale comunicaziones.
	 *
	 * @return the canale comunicaziones
	 */
	public static List<CanaleComunicazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @return the range of canale comunicaziones
	 */
	public static List<CanaleComunicazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of canale comunicaziones
	 */
	public static List<CanaleComunicazione> findAll(
		int start, int end,
		OrderByComparator<CanaleComunicazione> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of canale comunicaziones
	 */
	public static List<CanaleComunicazione> findAll(
		int start, int end,
		OrderByComparator<CanaleComunicazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the canale comunicaziones from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of canale comunicaziones.
	 *
	 * @return the number of canale comunicaziones
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CanaleComunicazionePersistence getPersistence() {
		return _persistence;
	}

	private static volatile CanaleComunicazionePersistence _persistence;

}