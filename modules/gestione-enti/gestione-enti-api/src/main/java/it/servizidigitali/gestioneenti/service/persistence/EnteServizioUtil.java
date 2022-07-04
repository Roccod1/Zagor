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

package it.servizidigitali.gestioneenti.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneenti.model.EnteServizio;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ente servizio service. This utility wraps <code>it.servizidigitali.gestioneenti.service.persistence.impl.EnteServizioPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnteServizioPersistence
 * @generated
 */
public class EnteServizioUtil {

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
	public static void clearCache(EnteServizio enteServizio) {
		getPersistence().clearCache(enteServizio);
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
	public static Map<Serializable, EnteServizio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EnteServizio> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EnteServizio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EnteServizio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EnteServizio> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EnteServizio update(EnteServizio enteServizio) {
		return getPersistence().update(enteServizio);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EnteServizio update(
		EnteServizio enteServizio, ServiceContext serviceContext) {

		return getPersistence().update(enteServizio, serviceContext);
	}

	/**
	 * Returns all the ente servizios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ente servizios
	 */
	public static List<EnteServizio> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the ente servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @return the range of matching ente servizios
	 */
	public static List<EnteServizio> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the ente servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ente servizios
	 */
	public static List<EnteServizio> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EnteServizio> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ente servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ente servizios
	 */
	public static List<EnteServizio> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EnteServizio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ente servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public static EnteServizio findByUuid_First(
			String uuid, OrderByComparator<EnteServizio> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ente servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public static EnteServizio fetchByUuid_First(
		String uuid, OrderByComparator<EnteServizio> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ente servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public static EnteServizio findByUuid_Last(
			String uuid, OrderByComparator<EnteServizio> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ente servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public static EnteServizio fetchByUuid_Last(
		String uuid, OrderByComparator<EnteServizio> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ente servizios before and after the current ente servizio in the ordered set where uuid = &#63;.
	 *
	 * @param enteServizioPK the primary key of the current ente servizio
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ente servizio
	 * @throws NoSuchEnteServizioException if a ente servizio with the primary key could not be found
	 */
	public static EnteServizio[] findByUuid_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK,
			String uuid, OrderByComparator<EnteServizio> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().findByUuid_PrevAndNext(
			enteServizioPK, uuid, orderByComparator);
	}

	/**
	 * Removes all the ente servizios where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ente servizios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ente servizios
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ente servizio where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEnteServizioException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public static EnteServizio findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ente servizio where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public static EnteServizio fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ente servizio where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public static EnteServizio fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the ente servizio where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ente servizio that was removed
	 */
	public static EnteServizio removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of ente servizios where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ente servizios
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the ente servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ente servizios
	 */
	public static List<EnteServizio> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the ente servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @return the range of matching ente servizios
	 */
	public static List<EnteServizio> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ente servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ente servizios
	 */
	public static List<EnteServizio> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EnteServizio> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ente servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ente servizios
	 */
	public static List<EnteServizio> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EnteServizio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ente servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public static EnteServizio findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EnteServizio> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first ente servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public static EnteServizio fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EnteServizio> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ente servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public static EnteServizio findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EnteServizio> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ente servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public static EnteServizio fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EnteServizio> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the ente servizios before and after the current ente servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param enteServizioPK the primary key of the current ente servizio
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ente servizio
	 * @throws NoSuchEnteServizioException if a ente servizio with the primary key could not be found
	 */
	public static EnteServizio[] findByUuid_C_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK,
			String uuid, long companyId,
			OrderByComparator<EnteServizio> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().findByUuid_C_PrevAndNext(
			enteServizioPK, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the ente servizios where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of ente servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ente servizios
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the ente servizio where organizationId = &#63; or throws a <code>NoSuchEnteServizioException</code> if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @return the matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public static EnteServizio findByOrganizationId(long organizationId)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	 * Returns the ente servizio where organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @return the matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public static EnteServizio fetchByOrganizationId(long organizationId) {
		return getPersistence().fetchByOrganizationId(organizationId);
	}

	/**
	 * Returns the ente servizio where organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public static EnteServizio fetchByOrganizationId(
		long organizationId, boolean useFinderCache) {

		return getPersistence().fetchByOrganizationId(
			organizationId, useFinderCache);
	}

	/**
	 * Removes the ente servizio where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @return the ente servizio that was removed
	 */
	public static EnteServizio removeByOrganizationId(long organizationId)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of ente servizios where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching ente servizios
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Returns all the ente servizios where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the matching ente servizios
	 */
	public static List<EnteServizio> findByServizioId(long servizioId) {
		return getPersistence().findByServizioId(servizioId);
	}

	/**
	 * Returns a range of all the ente servizios where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @return the range of matching ente servizios
	 */
	public static List<EnteServizio> findByServizioId(
		long servizioId, int start, int end) {

		return getPersistence().findByServizioId(servizioId, start, end);
	}

	/**
	 * Returns an ordered range of all the ente servizios where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ente servizios
	 */
	public static List<EnteServizio> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<EnteServizio> orderByComparator) {

		return getPersistence().findByServizioId(
			servizioId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ente servizios where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ente servizios
	 */
	public static List<EnteServizio> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<EnteServizio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByServizioId(
			servizioId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ente servizio in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public static EnteServizio findByServizioId_First(
			long servizioId, OrderByComparator<EnteServizio> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().findByServizioId_First(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the first ente servizio in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public static EnteServizio fetchByServizioId_First(
		long servizioId, OrderByComparator<EnteServizio> orderByComparator) {

		return getPersistence().fetchByServizioId_First(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the last ente servizio in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public static EnteServizio findByServizioId_Last(
			long servizioId, OrderByComparator<EnteServizio> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().findByServizioId_Last(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the last ente servizio in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public static EnteServizio fetchByServizioId_Last(
		long servizioId, OrderByComparator<EnteServizio> orderByComparator) {

		return getPersistence().fetchByServizioId_Last(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the ente servizios before and after the current ente servizio in the ordered set where servizioId = &#63;.
	 *
	 * @param enteServizioPK the primary key of the current ente servizio
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ente servizio
	 * @throws NoSuchEnteServizioException if a ente servizio with the primary key could not be found
	 */
	public static EnteServizio[] findByServizioId_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK,
			long servizioId, OrderByComparator<EnteServizio> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().findByServizioId_PrevAndNext(
			enteServizioPK, servizioId, orderByComparator);
	}

	/**
	 * Removes all the ente servizios where servizioId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 */
	public static void removeByServizioId(long servizioId) {
		getPersistence().removeByServizioId(servizioId);
	}

	/**
	 * Returns the number of ente servizios where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the number of matching ente servizios
	 */
	public static int countByServizioId(long servizioId) {
		return getPersistence().countByServizioId(servizioId);
	}

	/**
	 * Caches the ente servizio in the entity cache if it is enabled.
	 *
	 * @param enteServizio the ente servizio
	 */
	public static void cacheResult(EnteServizio enteServizio) {
		getPersistence().cacheResult(enteServizio);
	}

	/**
	 * Caches the ente servizios in the entity cache if it is enabled.
	 *
	 * @param enteServizios the ente servizios
	 */
	public static void cacheResult(List<EnteServizio> enteServizios) {
		getPersistence().cacheResult(enteServizios);
	}

	/**
	 * Creates a new ente servizio with the primary key. Does not add the ente servizio to the database.
	 *
	 * @param enteServizioPK the primary key for the new ente servizio
	 * @return the new ente servizio
	 */
	public static EnteServizio create(
		it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
			enteServizioPK) {

		return getPersistence().create(enteServizioPK);
	}

	/**
	 * Removes the ente servizio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enteServizioPK the primary key of the ente servizio
	 * @return the ente servizio that was removed
	 * @throws NoSuchEnteServizioException if a ente servizio with the primary key could not be found
	 */
	public static EnteServizio remove(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().remove(enteServizioPK);
	}

	public static EnteServizio updateImpl(EnteServizio enteServizio) {
		return getPersistence().updateImpl(enteServizio);
	}

	/**
	 * Returns the ente servizio with the primary key or throws a <code>NoSuchEnteServizioException</code> if it could not be found.
	 *
	 * @param enteServizioPK the primary key of the ente servizio
	 * @return the ente servizio
	 * @throws NoSuchEnteServizioException if a ente servizio with the primary key could not be found
	 */
	public static EnteServizio findByPrimaryKey(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchEnteServizioException {

		return getPersistence().findByPrimaryKey(enteServizioPK);
	}

	/**
	 * Returns the ente servizio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enteServizioPK the primary key of the ente servizio
	 * @return the ente servizio, or <code>null</code> if a ente servizio with the primary key could not be found
	 */
	public static EnteServizio fetchByPrimaryKey(
		it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
			enteServizioPK) {

		return getPersistence().fetchByPrimaryKey(enteServizioPK);
	}

	/**
	 * Returns all the ente servizios.
	 *
	 * @return the ente servizios
	 */
	public static List<EnteServizio> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ente servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @return the range of ente servizios
	 */
	public static List<EnteServizio> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ente servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ente servizios
	 */
	public static List<EnteServizio> findAll(
		int start, int end, OrderByComparator<EnteServizio> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ente servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ente servizios
	 */
	public static List<EnteServizio> findAll(
		int start, int end, OrderByComparator<EnteServizio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ente servizios from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ente servizios.
	 *
	 * @return the number of ente servizios
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static EnteServizioPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EnteServizioPersistence _persistence;

}