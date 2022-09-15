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

package it.servizidigitali.gestioneprocedure.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneprocedure.model.Procedura;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the procedura service. This utility wraps <code>it.servizidigitali.gestioneprocedure.service.persistence.impl.ProceduraPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProceduraPersistence
 * @generated
 */
public class ProceduraUtil {

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
	public static void clearCache(Procedura procedura) {
		getPersistence().clearCache(procedura);
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
	public static Map<Serializable, Procedura> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Procedura> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Procedura> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Procedura> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Procedura update(Procedura procedura) {
		return getPersistence().update(procedura);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Procedura update(
		Procedura procedura, ServiceContext serviceContext) {

		return getPersistence().update(procedura, serviceContext);
	}

	/**
	 * Returns all the proceduras where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching proceduras
	 */
	public static List<Procedura> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the proceduras where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	public static List<Procedura> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the proceduras where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduras where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByUuid_First(
			String uuid, OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first procedura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByUuid_First(
		String uuid, OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByUuid_Last(
			String uuid, OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByUuid_Last(
		String uuid, OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where uuid = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public static Procedura[] findByUuid_PrevAndNext(
			long proceduraId, String uuid,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByUuid_PrevAndNext(
			proceduraId, uuid, orderByComparator);
	}

	/**
	 * Removes all the proceduras where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of proceduras where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching proceduras
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the procedura where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProceduraException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procedura where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procedura where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the procedura where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedura that was removed
	 */
	public static Procedura removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of proceduras where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching proceduras
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching proceduras
	 */
	public static List<Procedura> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	public static List<Procedura> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public static Procedura[] findByUuid_C_PrevAndNext(
			long proceduraId, String uuid, long companyId,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByUuid_C_PrevAndNext(
			proceduraId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the proceduras where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching proceduras
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the proceduras where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @return the matching proceduras
	 */
	public static List<Procedura> findByAttiva(boolean attiva) {
		return getPersistence().findByAttiva(attiva);
	}

	/**
	 * Returns a range of all the proceduras where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	public static List<Procedura> findByAttiva(
		boolean attiva, int start, int end) {

		return getPersistence().findByAttiva(attiva, start, end);
	}

	/**
	 * Returns an ordered range of all the proceduras where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByAttiva(
		boolean attiva, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().findByAttiva(
			attiva, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduras where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByAttiva(
		boolean attiva, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAttiva(
			attiva, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedura in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByAttiva_First(
			boolean attiva, OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByAttiva_First(attiva, orderByComparator);
	}

	/**
	 * Returns the first procedura in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByAttiva_First(
		boolean attiva, OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByAttiva_First(attiva, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByAttiva_Last(
			boolean attiva, OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByAttiva_Last(attiva, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByAttiva_Last(
		boolean attiva, OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByAttiva_Last(attiva, orderByComparator);
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where attiva = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public static Procedura[] findByAttiva_PrevAndNext(
			long proceduraId, boolean attiva,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByAttiva_PrevAndNext(
			proceduraId, attiva, orderByComparator);
	}

	/**
	 * Removes all the proceduras where attiva = &#63; from the database.
	 *
	 * @param attiva the attiva
	 */
	public static void removeByAttiva(boolean attiva) {
		getPersistence().removeByAttiva(attiva);
	}

	/**
	 * Returns the number of proceduras where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @return the number of matching proceduras
	 */
	public static int countByAttiva(boolean attiva) {
		return getPersistence().countByAttiva(attiva);
	}

	/**
	 * Returns all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @return the matching proceduras
	 */
	public static List<Procedura> findByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId) {

		return getPersistence().findByGroupIdServizioIdProcessoId(
			groupId, servizioId, processoId);
	}

	/**
	 * Returns a range of all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	public static List<Procedura> findByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId, int start, int end) {

		return getPersistence().findByGroupIdServizioIdProcessoId(
			groupId, servizioId, processoId, start, end);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().findByGroupIdServizioIdProcessoId(
			groupId, servizioId, processoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdServizioIdProcessoId(
			groupId, servizioId, processoId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByGroupIdServizioIdProcessoId_First(
			long groupId, long servizioId, long processoId,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByGroupIdServizioIdProcessoId_First(
			groupId, servizioId, processoId, orderByComparator);
	}

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByGroupIdServizioIdProcessoId_First(
		long groupId, long servizioId, long processoId,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByGroupIdServizioIdProcessoId_First(
			groupId, servizioId, processoId, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByGroupIdServizioIdProcessoId_Last(
			long groupId, long servizioId, long processoId,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByGroupIdServizioIdProcessoId_Last(
			groupId, servizioId, processoId, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByGroupIdServizioIdProcessoId_Last(
		long groupId, long servizioId, long processoId,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByGroupIdServizioIdProcessoId_Last(
			groupId, servizioId, processoId, orderByComparator);
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public static Procedura[] findByGroupIdServizioIdProcessoId_PrevAndNext(
			long proceduraId, long groupId, long servizioId, long processoId,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByGroupIdServizioIdProcessoId_PrevAndNext(
			proceduraId, groupId, servizioId, processoId, orderByComparator);
	}

	/**
	 * Removes all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 */
	public static void removeByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId) {

		getPersistence().removeByGroupIdServizioIdProcessoId(
			groupId, servizioId, processoId);
	}

	/**
	 * Returns the number of proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @return the number of matching proceduras
	 */
	public static int countByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId) {

		return getPersistence().countByGroupIdServizioIdProcessoId(
			groupId, servizioId, processoId);
	}

	/**
	 * Returns all the proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @return the matching proceduras
	 */
	public static List<Procedura> findByGroupIdServizioId(
		long groupId, long servizioId) {

		return getPersistence().findByGroupIdServizioId(groupId, servizioId);
	}

	/**
	 * Returns a range of all the proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	public static List<Procedura> findByGroupIdServizioId(
		long groupId, long servizioId, int start, int end) {

		return getPersistence().findByGroupIdServizioId(
			groupId, servizioId, start, end);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByGroupIdServizioId(
		long groupId, long servizioId, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().findByGroupIdServizioId(
			groupId, servizioId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByGroupIdServizioId(
		long groupId, long servizioId, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdServizioId(
			groupId, servizioId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByGroupIdServizioId_First(
			long groupId, long servizioId,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByGroupIdServizioId_First(
			groupId, servizioId, orderByComparator);
	}

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByGroupIdServizioId_First(
		long groupId, long servizioId,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByGroupIdServizioId_First(
			groupId, servizioId, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByGroupIdServizioId_Last(
			long groupId, long servizioId,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByGroupIdServizioId_Last(
			groupId, servizioId, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByGroupIdServizioId_Last(
		long groupId, long servizioId,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByGroupIdServizioId_Last(
			groupId, servizioId, orderByComparator);
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public static Procedura[] findByGroupIdServizioId_PrevAndNext(
			long proceduraId, long groupId, long servizioId,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByGroupIdServizioId_PrevAndNext(
			proceduraId, groupId, servizioId, orderByComparator);
	}

	/**
	 * Removes all the proceduras where groupId = &#63; and servizioId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 */
	public static void removeByGroupIdServizioId(
		long groupId, long servizioId) {

		getPersistence().removeByGroupIdServizioId(groupId, servizioId);
	}

	/**
	 * Returns the number of proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @return the number of matching proceduras
	 */
	public static int countByGroupIdServizioId(long groupId, long servizioId) {
		return getPersistence().countByGroupIdServizioId(groupId, servizioId);
	}

	/**
	 * Returns all the proceduras where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @return the matching proceduras
	 */
	public static List<Procedura> findByGroupIdServizioIdAttiva(
		long groupId, long servizioId, boolean attiva) {

		return getPersistence().findByGroupIdServizioIdAttiva(
			groupId, servizioId, attiva);
	}

	/**
	 * Returns a range of all the proceduras where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	public static List<Procedura> findByGroupIdServizioIdAttiva(
		long groupId, long servizioId, boolean attiva, int start, int end) {

		return getPersistence().findByGroupIdServizioIdAttiva(
			groupId, servizioId, attiva, start, end);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByGroupIdServizioIdAttiva(
		long groupId, long servizioId, boolean attiva, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().findByGroupIdServizioIdAttiva(
			groupId, servizioId, attiva, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByGroupIdServizioIdAttiva(
		long groupId, long servizioId, boolean attiva, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdServizioIdAttiva(
			groupId, servizioId, attiva, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByGroupIdServizioIdAttiva_First(
			long groupId, long servizioId, boolean attiva,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByGroupIdServizioIdAttiva_First(
			groupId, servizioId, attiva, orderByComparator);
	}

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByGroupIdServizioIdAttiva_First(
		long groupId, long servizioId, boolean attiva,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByGroupIdServizioIdAttiva_First(
			groupId, servizioId, attiva, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByGroupIdServizioIdAttiva_Last(
			long groupId, long servizioId, boolean attiva,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByGroupIdServizioIdAttiva_Last(
			groupId, servizioId, attiva, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByGroupIdServizioIdAttiva_Last(
		long groupId, long servizioId, boolean attiva,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByGroupIdServizioIdAttiva_Last(
			groupId, servizioId, attiva, orderByComparator);
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public static Procedura[] findByGroupIdServizioIdAttiva_PrevAndNext(
			long proceduraId, long groupId, long servizioId, boolean attiva,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByGroupIdServizioIdAttiva_PrevAndNext(
			proceduraId, groupId, servizioId, attiva, orderByComparator);
	}

	/**
	 * Removes all the proceduras where groupId = &#63; and servizioId = &#63; and attiva = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 */
	public static void removeByGroupIdServizioIdAttiva(
		long groupId, long servizioId, boolean attiva) {

		getPersistence().removeByGroupIdServizioIdAttiva(
			groupId, servizioId, attiva);
	}

	/**
	 * Returns the number of proceduras where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @return the number of matching proceduras
	 */
	public static int countByGroupIdServizioIdAttiva(
		long groupId, long servizioId, boolean attiva) {

		return getPersistence().countByGroupIdServizioIdAttiva(
			groupId, servizioId, attiva);
	}

	/**
	 * Returns all the proceduras where groupId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param attiva the attiva
	 * @return the matching proceduras
	 */
	public static List<Procedura> findByGroupIdAttiva(
		long groupId, boolean attiva) {

		return getPersistence().findByGroupIdAttiva(groupId, attiva);
	}

	/**
	 * Returns a range of all the proceduras where groupId = &#63; and attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	public static List<Procedura> findByGroupIdAttiva(
		long groupId, boolean attiva, int start, int end) {

		return getPersistence().findByGroupIdAttiva(
			groupId, attiva, start, end);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByGroupIdAttiva(
		long groupId, boolean attiva, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().findByGroupIdAttiva(
			groupId, attiva, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	public static List<Procedura> findByGroupIdAttiva(
		long groupId, boolean attiva, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdAttiva(
			groupId, attiva, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByGroupIdAttiva_First(
			long groupId, boolean attiva,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByGroupIdAttiva_First(
			groupId, attiva, orderByComparator);
	}

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByGroupIdAttiva_First(
		long groupId, boolean attiva,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByGroupIdAttiva_First(
			groupId, attiva, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public static Procedura findByGroupIdAttiva_Last(
			long groupId, boolean attiva,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByGroupIdAttiva_Last(
			groupId, attiva, orderByComparator);
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchByGroupIdAttiva_Last(
		long groupId, boolean attiva,
		OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().fetchByGroupIdAttiva_Last(
			groupId, attiva, orderByComparator);
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where groupId = &#63; and attiva = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param groupId the group ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public static Procedura[] findByGroupIdAttiva_PrevAndNext(
			long proceduraId, long groupId, boolean attiva,
			OrderByComparator<Procedura> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByGroupIdAttiva_PrevAndNext(
			proceduraId, groupId, attiva, orderByComparator);
	}

	/**
	 * Removes all the proceduras where groupId = &#63; and attiva = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param attiva the attiva
	 */
	public static void removeByGroupIdAttiva(long groupId, boolean attiva) {
		getPersistence().removeByGroupIdAttiva(groupId, attiva);
	}

	/**
	 * Returns the number of proceduras where groupId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param attiva the attiva
	 * @return the number of matching proceduras
	 */
	public static int countByGroupIdAttiva(long groupId, boolean attiva) {
		return getPersistence().countByGroupIdAttiva(groupId, attiva);
	}

	/**
	 * Caches the procedura in the entity cache if it is enabled.
	 *
	 * @param procedura the procedura
	 */
	public static void cacheResult(Procedura procedura) {
		getPersistence().cacheResult(procedura);
	}

	/**
	 * Caches the proceduras in the entity cache if it is enabled.
	 *
	 * @param proceduras the proceduras
	 */
	public static void cacheResult(List<Procedura> proceduras) {
		getPersistence().cacheResult(proceduras);
	}

	/**
	 * Creates a new procedura with the primary key. Does not add the procedura to the database.
	 *
	 * @param proceduraId the primary key for the new procedura
	 * @return the new procedura
	 */
	public static Procedura create(long proceduraId) {
		return getPersistence().create(proceduraId);
	}

	/**
	 * Removes the procedura with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proceduraId the primary key of the procedura
	 * @return the procedura that was removed
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public static Procedura remove(long proceduraId)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().remove(proceduraId);
	}

	public static Procedura updateImpl(Procedura procedura) {
		return getPersistence().updateImpl(procedura);
	}

	/**
	 * Returns the procedura with the primary key or throws a <code>NoSuchProceduraException</code> if it could not be found.
	 *
	 * @param proceduraId the primary key of the procedura
	 * @return the procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public static Procedura findByPrimaryKey(long proceduraId)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraException {

		return getPersistence().findByPrimaryKey(proceduraId);
	}

	/**
	 * Returns the procedura with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proceduraId the primary key of the procedura
	 * @return the procedura, or <code>null</code> if a procedura with the primary key could not be found
	 */
	public static Procedura fetchByPrimaryKey(long proceduraId) {
		return getPersistence().fetchByPrimaryKey(proceduraId);
	}

	/**
	 * Returns all the proceduras.
	 *
	 * @return the proceduras
	 */
	public static List<Procedura> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the proceduras.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of proceduras
	 */
	public static List<Procedura> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the proceduras.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proceduras
	 */
	public static List<Procedura> findAll(
		int start, int end, OrderByComparator<Procedura> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduras.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of proceduras
	 */
	public static List<Procedura> findAll(
		int start, int end, OrderByComparator<Procedura> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the proceduras from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of proceduras.
	 *
	 * @return the number of proceduras
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProceduraPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProceduraPersistence _persistence;

}