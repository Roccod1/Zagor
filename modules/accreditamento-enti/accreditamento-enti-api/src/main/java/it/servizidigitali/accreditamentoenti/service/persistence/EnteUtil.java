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

package it.servizidigitali.accreditamentoenti.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.accreditamentoenti.model.Ente;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ente service. This utility wraps <code>it.servizidigitali.accreditamentoenti.service.persistence.impl.EntePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntePersistence
 * @generated
 */
public class EnteUtil {

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
	public static void clearCache(Ente ente) {
		getPersistence().clearCache(ente);
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
	public static Map<Serializable, Ente> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Ente> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ente> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ente> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Ente> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Ente update(Ente ente) {
		return getPersistence().update(ente);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Ente update(Ente ente, ServiceContext serviceContext) {
		return getPersistence().update(ente, serviceContext);
	}

	/**
	 * Returns all the entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching entes
	 */
	public static List<Ente> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @return the range of matching entes
	 */
	public static List<Ente> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching entes
	 */
	public static List<Ente> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Ente> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching entes
	 */
	public static List<Ente> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Ente> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente
	 * @throws NoSuchEnteException if a matching ente could not be found
	 */
	public static Ente findByUuid_First(
			String uuid, OrderByComparator<Ente> orderByComparator)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchEnteException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente, or <code>null</code> if a matching ente could not be found
	 */
	public static Ente fetchByUuid_First(
		String uuid, OrderByComparator<Ente> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente
	 * @throws NoSuchEnteException if a matching ente could not be found
	 */
	public static Ente findByUuid_Last(
			String uuid, OrderByComparator<Ente> orderByComparator)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchEnteException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente, or <code>null</code> if a matching ente could not be found
	 */
	public static Ente fetchByUuid_Last(
		String uuid, OrderByComparator<Ente> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the entes before and after the current ente in the ordered set where uuid = &#63;.
	 *
	 * @param enteId the primary key of the current ente
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ente
	 * @throws NoSuchEnteException if a ente with the primary key could not be found
	 */
	public static Ente[] findByUuid_PrevAndNext(
			long enteId, String uuid, OrderByComparator<Ente> orderByComparator)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchEnteException {

		return getPersistence().findByUuid_PrevAndNext(
			enteId, uuid, orderByComparator);
	}

	/**
	 * Removes all the entes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching entes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ente where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEnteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ente
	 * @throws NoSuchEnteException if a matching ente could not be found
	 */
	public static Ente findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchEnteException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ente, or <code>null</code> if a matching ente could not be found
	 */
	public static Ente fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ente, or <code>null</code> if a matching ente could not be found
	 */
	public static Ente fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the ente where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ente that was removed
	 */
	public static Ente removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchEnteException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of entes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching entes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching entes
	 */
	public static List<Ente> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @return the range of matching entes
	 */
	public static List<Ente> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching entes
	 */
	public static List<Ente> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Ente> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching entes
	 */
	public static List<Ente> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Ente> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente
	 * @throws NoSuchEnteException if a matching ente could not be found
	 */
	public static Ente findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Ente> orderByComparator)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchEnteException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente, or <code>null</code> if a matching ente could not be found
	 */
	public static Ente fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Ente> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente
	 * @throws NoSuchEnteException if a matching ente could not be found
	 */
	public static Ente findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Ente> orderByComparator)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchEnteException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente, or <code>null</code> if a matching ente could not be found
	 */
	public static Ente fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Ente> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the entes before and after the current ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param enteId the primary key of the current ente
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ente
	 * @throws NoSuchEnteException if a ente with the primary key could not be found
	 */
	public static Ente[] findByUuid_C_PrevAndNext(
			long enteId, String uuid, long companyId,
			OrderByComparator<Ente> orderByComparator)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchEnteException {

		return getPersistence().findByUuid_C_PrevAndNext(
			enteId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the entes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching entes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the ente in the entity cache if it is enabled.
	 *
	 * @param ente the ente
	 */
	public static void cacheResult(Ente ente) {
		getPersistence().cacheResult(ente);
	}

	/**
	 * Caches the entes in the entity cache if it is enabled.
	 *
	 * @param entes the entes
	 */
	public static void cacheResult(List<Ente> entes) {
		getPersistence().cacheResult(entes);
	}

	/**
	 * Creates a new ente with the primary key. Does not add the ente to the database.
	 *
	 * @param enteId the primary key for the new ente
	 * @return the new ente
	 */
	public static Ente create(long enteId) {
		return getPersistence().create(enteId);
	}

	/**
	 * Removes the ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enteId the primary key of the ente
	 * @return the ente that was removed
	 * @throws NoSuchEnteException if a ente with the primary key could not be found
	 */
	public static Ente remove(long enteId)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchEnteException {

		return getPersistence().remove(enteId);
	}

	public static Ente updateImpl(Ente ente) {
		return getPersistence().updateImpl(ente);
	}

	/**
	 * Returns the ente with the primary key or throws a <code>NoSuchEnteException</code> if it could not be found.
	 *
	 * @param enteId the primary key of the ente
	 * @return the ente
	 * @throws NoSuchEnteException if a ente with the primary key could not be found
	 */
	public static Ente findByPrimaryKey(long enteId)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchEnteException {

		return getPersistence().findByPrimaryKey(enteId);
	}

	/**
	 * Returns the ente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enteId the primary key of the ente
	 * @return the ente, or <code>null</code> if a ente with the primary key could not be found
	 */
	public static Ente fetchByPrimaryKey(long enteId) {
		return getPersistence().fetchByPrimaryKey(enteId);
	}

	/**
	 * Returns all the entes.
	 *
	 * @return the entes
	 */
	public static List<Ente> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @return the range of entes
	 */
	public static List<Ente> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of entes
	 */
	public static List<Ente> findAll(
		int start, int end, OrderByComparator<Ente> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of entes
	 */
	public static List<Ente> findAll(
		int start, int end, OrderByComparator<Ente> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the entes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of entes.
	 *
	 * @return the number of entes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EntePersistence getPersistence() {
		return _persistence;
	}

	private static volatile EntePersistence _persistence;

}