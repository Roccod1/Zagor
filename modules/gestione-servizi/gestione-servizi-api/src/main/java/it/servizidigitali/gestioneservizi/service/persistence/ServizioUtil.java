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

package it.servizidigitali.gestioneservizi.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneservizi.model.Servizio;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the servizio service. This utility wraps <code>it.servizidigitali.gestioneservizi.service.persistence.impl.ServizioPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioPersistence
 * @generated
 */
public class ServizioUtil {

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
	public static void clearCache(Servizio servizio) {
		getPersistence().clearCache(servizio);
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
	public static Map<Serializable, Servizio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Servizio> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Servizio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Servizio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Servizio update(Servizio servizio) {
		return getPersistence().update(servizio);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Servizio update(
		Servizio servizio, ServiceContext serviceContext) {

		return getPersistence().update(servizio, serviceContext);
	}

	/**
	 * Returns all the servizios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching servizios
	 */
	public static List<Servizio> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of matching servizios
	 */
	public static List<Servizio> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizios
	 */
	public static List<Servizio> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizios
	 */
	public static List<Servizio> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Servizio> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public static Servizio findByUuid_First(
			String uuid, OrderByComparator<Servizio> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public static Servizio fetchByUuid_First(
		String uuid, OrderByComparator<Servizio> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public static Servizio findByUuid_Last(
			String uuid, OrderByComparator<Servizio> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public static Servizio fetchByUuid_Last(
		String uuid, OrderByComparator<Servizio> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the servizios before and after the current servizio in the ordered set where uuid = &#63;.
	 *
	 * @param servizioId the primary key of the current servizio
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	public static Servizio[] findByUuid_PrevAndNext(
			long servizioId, String uuid,
			OrderByComparator<Servizio> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().findByUuid_PrevAndNext(
			servizioId, uuid, orderByComparator);
	}

	/**
	 * Removes all the servizios where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of servizios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching servizios
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the servizio where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchServizioException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public static Servizio findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the servizio where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public static Servizio fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the servizio where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public static Servizio fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the servizio where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the servizio that was removed
	 */
	public static Servizio removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of servizios where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching servizios
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching servizios
	 */
	public static List<Servizio> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of matching servizios
	 */
	public static List<Servizio> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizios
	 */
	public static List<Servizio> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizios
	 */
	public static List<Servizio> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Servizio> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public static Servizio findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Servizio> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public static Servizio fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Servizio> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public static Servizio findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Servizio> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public static Servizio fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Servizio> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the servizios before and after the current servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param servizioId the primary key of the current servizio
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	public static Servizio[] findByUuid_C_PrevAndNext(
			long servizioId, String uuid, long companyId,
			OrderByComparator<Servizio> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().findByUuid_C_PrevAndNext(
			servizioId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the servizios where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching servizios
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the servizio where codice = &#63; or throws a <code>NoSuchServizioException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public static Servizio findByCodice(String codice)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().findByCodice(codice);
	}

	/**
	 * Returns the servizio where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public static Servizio fetchByCodice(String codice) {
		return getPersistence().fetchByCodice(codice);
	}

	/**
	 * Returns the servizio where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public static Servizio fetchByCodice(
		String codice, boolean useFinderCache) {

		return getPersistence().fetchByCodice(codice, useFinderCache);
	}

	/**
	 * Removes the servizio where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the servizio that was removed
	 */
	public static Servizio removeByCodice(String codice)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().removeByCodice(codice);
	}

	/**
	 * Returns the number of servizios where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching servizios
	 */
	public static int countByCodice(String codice) {
		return getPersistence().countByCodice(codice);
	}

	/**
	 * Returns all the servizios where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching servizios
	 */
	public static List<Servizio> findByAttivo(boolean attivo) {
		return getPersistence().findByAttivo(attivo);
	}

	/**
	 * Returns a range of all the servizios where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of matching servizios
	 */
	public static List<Servizio> findByAttivo(
		boolean attivo, int start, int end) {

		return getPersistence().findByAttivo(attivo, start, end);
	}

	/**
	 * Returns an ordered range of all the servizios where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizios
	 */
	public static List<Servizio> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return getPersistence().findByAttivo(
			attivo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the servizios where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizios
	 */
	public static List<Servizio> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<Servizio> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAttivo(
			attivo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first servizio in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public static Servizio findByAttivo_First(
			boolean attivo, OrderByComparator<Servizio> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().findByAttivo_First(attivo, orderByComparator);
	}

	/**
	 * Returns the first servizio in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public static Servizio fetchByAttivo_First(
		boolean attivo, OrderByComparator<Servizio> orderByComparator) {

		return getPersistence().fetchByAttivo_First(attivo, orderByComparator);
	}

	/**
	 * Returns the last servizio in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public static Servizio findByAttivo_Last(
			boolean attivo, OrderByComparator<Servizio> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().findByAttivo_Last(attivo, orderByComparator);
	}

	/**
	 * Returns the last servizio in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public static Servizio fetchByAttivo_Last(
		boolean attivo, OrderByComparator<Servizio> orderByComparator) {

		return getPersistence().fetchByAttivo_Last(attivo, orderByComparator);
	}

	/**
	 * Returns the servizios before and after the current servizio in the ordered set where attivo = &#63;.
	 *
	 * @param servizioId the primary key of the current servizio
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	public static Servizio[] findByAttivo_PrevAndNext(
			long servizioId, boolean attivo,
			OrderByComparator<Servizio> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().findByAttivo_PrevAndNext(
			servizioId, attivo, orderByComparator);
	}

	/**
	 * Removes all the servizios where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	public static void removeByAttivo(boolean attivo) {
		getPersistence().removeByAttivo(attivo);
	}

	/**
	 * Returns the number of servizios where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching servizios
	 */
	public static int countByAttivo(boolean attivo) {
		return getPersistence().countByAttivo(attivo);
	}

	/**
	 * Caches the servizio in the entity cache if it is enabled.
	 *
	 * @param servizio the servizio
	 */
	public static void cacheResult(Servizio servizio) {
		getPersistence().cacheResult(servizio);
	}

	/**
	 * Caches the servizios in the entity cache if it is enabled.
	 *
	 * @param servizios the servizios
	 */
	public static void cacheResult(List<Servizio> servizios) {
		getPersistence().cacheResult(servizios);
	}

	/**
	 * Creates a new servizio with the primary key. Does not add the servizio to the database.
	 *
	 * @param servizioId the primary key for the new servizio
	 * @return the new servizio
	 */
	public static Servizio create(long servizioId) {
		return getPersistence().create(servizioId);
	}

	/**
	 * Removes the servizio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio that was removed
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	public static Servizio remove(long servizioId)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().remove(servizioId);
	}

	public static Servizio updateImpl(Servizio servizio) {
		return getPersistence().updateImpl(servizio);
	}

	/**
	 * Returns the servizio with the primary key or throws a <code>NoSuchServizioException</code> if it could not be found.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	public static Servizio findByPrimaryKey(long servizioId)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchServizioException {

		return getPersistence().findByPrimaryKey(servizioId);
	}

	/**
	 * Returns the servizio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio, or <code>null</code> if a servizio with the primary key could not be found
	 */
	public static Servizio fetchByPrimaryKey(long servizioId) {
		return getPersistence().fetchByPrimaryKey(servizioId);
	}

	/**
	 * Returns all the servizios.
	 *
	 * @return the servizios
	 */
	public static List<Servizio> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of servizios
	 */
	public static List<Servizio> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of servizios
	 */
	public static List<Servizio> findAll(
		int start, int end, OrderByComparator<Servizio> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of servizios
	 */
	public static List<Servizio> findAll(
		int start, int end, OrderByComparator<Servizio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the servizios from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of servizios.
	 *
	 * @return the number of servizios
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of tipologias associated with the servizio.
	 *
	 * @param pk the primary key of the servizio
	 * @return long[] of the primaryKeys of tipologias associated with the servizio
	 */
	public static long[] getTipologiaPrimaryKeys(long pk) {
		return getPersistence().getTipologiaPrimaryKeys(pk);
	}

	/**
	 * Returns all the servizio associated with the tipologia.
	 *
	 * @param pk the primary key of the tipologia
	 * @return the servizios associated with the tipologia
	 */
	public static List<Servizio> getTipologiaServizios(long pk) {
		return getPersistence().getTipologiaServizios(pk);
	}

	/**
	 * Returns all the servizio associated with the tipologia.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the tipologia
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of servizios associated with the tipologia
	 */
	public static List<Servizio> getTipologiaServizios(
		long pk, int start, int end) {

		return getPersistence().getTipologiaServizios(pk, start, end);
	}

	/**
	 * Returns all the servizio associated with the tipologia.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the tipologia
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of servizios associated with the tipologia
	 */
	public static List<Servizio> getTipologiaServizios(
		long pk, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return getPersistence().getTipologiaServizios(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of tipologias associated with the servizio.
	 *
	 * @param pk the primary key of the servizio
	 * @return the number of tipologias associated with the servizio
	 */
	public static int getTipologiasSize(long pk) {
		return getPersistence().getTipologiasSize(pk);
	}

	/**
	 * Returns <code>true</code> if the tipologia is associated with the servizio.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologiaPK the primary key of the tipologia
	 * @return <code>true</code> if the tipologia is associated with the servizio; <code>false</code> otherwise
	 */
	public static boolean containsTipologia(long pk, long tipologiaPK) {
		return getPersistence().containsTipologia(pk, tipologiaPK);
	}

	/**
	 * Returns <code>true</code> if the servizio has any tipologias associated with it.
	 *
	 * @param pk the primary key of the servizio to check for associations with tipologias
	 * @return <code>true</code> if the servizio has any tipologias associated with it; <code>false</code> otherwise
	 */
	public static boolean containsTipologias(long pk) {
		return getPersistence().containsTipologias(pk);
	}

	/**
	 * Adds an association between the servizio and the tipologia. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologiaPK the primary key of the tipologia
	 */
	public static void addTipologia(long pk, long tipologiaPK) {
		getPersistence().addTipologia(pk, tipologiaPK);
	}

	/**
	 * Adds an association between the servizio and the tipologia. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologia the tipologia
	 */
	public static void addTipologia(
		long pk, it.servizidigitali.gestioneservizi.model.Tipologia tipologia) {

		getPersistence().addTipologia(pk, tipologia);
	}

	/**
	 * Adds an association between the servizio and the tipologias. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologiaPKs the primary keys of the tipologias
	 */
	public static void addTipologias(long pk, long[] tipologiaPKs) {
		getPersistence().addTipologias(pk, tipologiaPKs);
	}

	/**
	 * Adds an association between the servizio and the tipologias. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologias the tipologias
	 */
	public static void addTipologias(
		long pk,
		List<it.servizidigitali.gestioneservizi.model.Tipologia> tipologias) {

		getPersistence().addTipologias(pk, tipologias);
	}

	/**
	 * Clears all associations between the servizio and its tipologias. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio to clear the associated tipologias from
	 */
	public static void clearTipologias(long pk) {
		getPersistence().clearTipologias(pk);
	}

	/**
	 * Removes the association between the servizio and the tipologia. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologiaPK the primary key of the tipologia
	 */
	public static void removeTipologia(long pk, long tipologiaPK) {
		getPersistence().removeTipologia(pk, tipologiaPK);
	}

	/**
	 * Removes the association between the servizio and the tipologia. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologia the tipologia
	 */
	public static void removeTipologia(
		long pk, it.servizidigitali.gestioneservizi.model.Tipologia tipologia) {

		getPersistence().removeTipologia(pk, tipologia);
	}

	/**
	 * Removes the association between the servizio and the tipologias. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologiaPKs the primary keys of the tipologias
	 */
	public static void removeTipologias(long pk, long[] tipologiaPKs) {
		getPersistence().removeTipologias(pk, tipologiaPKs);
	}

	/**
	 * Removes the association between the servizio and the tipologias. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologias the tipologias
	 */
	public static void removeTipologias(
		long pk,
		List<it.servizidigitali.gestioneservizi.model.Tipologia> tipologias) {

		getPersistence().removeTipologias(pk, tipologias);
	}

	/**
	 * Sets the tipologias associated with the servizio, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologiaPKs the primary keys of the tipologias to be associated with the servizio
	 */
	public static void setTipologias(long pk, long[] tipologiaPKs) {
		getPersistence().setTipologias(pk, tipologiaPKs);
	}

	/**
	 * Sets the tipologias associated with the servizio, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologias the tipologias to be associated with the servizio
	 */
	public static void setTipologias(
		long pk,
		List<it.servizidigitali.gestioneservizi.model.Tipologia> tipologias) {

		getPersistence().setTipologias(pk, tipologias);
	}

	public static ServizioPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ServizioPersistence _persistence;

}