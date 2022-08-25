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

package it.servizidigitali.gestionecomunicazioni.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the lettura comunicazione service. This utility wraps <code>it.servizidigitali.gestionecomunicazioni.service.persistence.impl.LetturaComunicazionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LetturaComunicazionePersistence
 * @generated
 */
public class LetturaComunicazioneUtil {

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
	public static void clearCache(LetturaComunicazione letturaComunicazione) {
		getPersistence().clearCache(letturaComunicazione);
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
	public static Map<Serializable, LetturaComunicazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LetturaComunicazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LetturaComunicazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LetturaComunicazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LetturaComunicazione> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LetturaComunicazione update(
		LetturaComunicazione letturaComunicazione) {

		return getPersistence().update(letturaComunicazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LetturaComunicazione update(
		LetturaComunicazione letturaComunicazione,
		ServiceContext serviceContext) {

		return getPersistence().update(letturaComunicazione, serviceContext);
	}

	/**
	 * Caches the lettura comunicazione in the entity cache if it is enabled.
	 *
	 * @param letturaComunicazione the lettura comunicazione
	 */
	public static void cacheResult(LetturaComunicazione letturaComunicazione) {
		getPersistence().cacheResult(letturaComunicazione);
	}

	/**
	 * Caches the lettura comunicaziones in the entity cache if it is enabled.
	 *
	 * @param letturaComunicaziones the lettura comunicaziones
	 */
	public static void cacheResult(
		List<LetturaComunicazione> letturaComunicaziones) {

		getPersistence().cacheResult(letturaComunicaziones);
	}

	/**
	 * Creates a new lettura comunicazione with the primary key. Does not add the lettura comunicazione to the database.
	 *
	 * @param letturaComunicazionePK the primary key for the new lettura comunicazione
	 * @return the new lettura comunicazione
	 */
	public static LetturaComunicazione create(
		it.servizidigitali.gestionecomunicazioni.service.persistence.
			LetturaComunicazionePK letturaComunicazionePK) {

		return getPersistence().create(letturaComunicazionePK);
	}

	/**
	 * Removes the lettura comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione that was removed
	 * @throws NoSuchLetturaComunicazioneException if a lettura comunicazione with the primary key could not be found
	 */
	public static LetturaComunicazione remove(
			it.servizidigitali.gestionecomunicazioni.service.persistence.
				LetturaComunicazionePK letturaComunicazionePK)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchLetturaComunicazioneException {

		return getPersistence().remove(letturaComunicazionePK);
	}

	public static LetturaComunicazione updateImpl(
		LetturaComunicazione letturaComunicazione) {

		return getPersistence().updateImpl(letturaComunicazione);
	}

	/**
	 * Returns the lettura comunicazione with the primary key or throws a <code>NoSuchLetturaComunicazioneException</code> if it could not be found.
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione
	 * @throws NoSuchLetturaComunicazioneException if a lettura comunicazione with the primary key could not be found
	 */
	public static LetturaComunicazione findByPrimaryKey(
			it.servizidigitali.gestionecomunicazioni.service.persistence.
				LetturaComunicazionePK letturaComunicazionePK)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchLetturaComunicazioneException {

		return getPersistence().findByPrimaryKey(letturaComunicazionePK);
	}

	/**
	 * Returns the lettura comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione, or <code>null</code> if a lettura comunicazione with the primary key could not be found
	 */
	public static LetturaComunicazione fetchByPrimaryKey(
		it.servizidigitali.gestionecomunicazioni.service.persistence.
			LetturaComunicazionePK letturaComunicazionePK) {

		return getPersistence().fetchByPrimaryKey(letturaComunicazionePK);
	}

	/**
	 * Returns all the lettura comunicaziones.
	 *
	 * @return the lettura comunicaziones
	 */
	public static List<LetturaComunicazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the lettura comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LetturaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lettura comunicaziones
	 * @param end the upper bound of the range of lettura comunicaziones (not inclusive)
	 * @return the range of lettura comunicaziones
	 */
	public static List<LetturaComunicazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the lettura comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LetturaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lettura comunicaziones
	 * @param end the upper bound of the range of lettura comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lettura comunicaziones
	 */
	public static List<LetturaComunicazione> findAll(
		int start, int end,
		OrderByComparator<LetturaComunicazione> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lettura comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LetturaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lettura comunicaziones
	 * @param end the upper bound of the range of lettura comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lettura comunicaziones
	 */
	public static List<LetturaComunicazione> findAll(
		int start, int end,
		OrderByComparator<LetturaComunicazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the lettura comunicaziones from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lettura comunicaziones.
	 *
	 * @return the number of lettura comunicaziones
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static LetturaComunicazionePersistence getPersistence() {
		return _persistence;
	}

	private static volatile LetturaComunicazionePersistence _persistence;

}