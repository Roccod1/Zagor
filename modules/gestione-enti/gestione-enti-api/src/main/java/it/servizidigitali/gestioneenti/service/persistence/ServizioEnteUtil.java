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

import it.servizidigitali.gestioneenti.model.ServizioEnte;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the servizio ente service. This utility wraps <code>it.servizidigitali.gestioneenti.service.persistence.impl.ServizioEntePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioEntePersistence
 * @generated
 */
public class ServizioEnteUtil {

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
	public static void clearCache(ServizioEnte servizioEnte) {
		getPersistence().clearCache(servizioEnte);
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
	public static Map<Serializable, ServizioEnte> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ServizioEnte> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServizioEnte> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServizioEnte> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ServizioEnte update(ServizioEnte servizioEnte) {
		return getPersistence().update(servizioEnte);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ServizioEnte update(
		ServizioEnte servizioEnte, ServiceContext serviceContext) {

		return getPersistence().update(servizioEnte, serviceContext);
	}

	/**
	 * Returns all the servizio entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching servizio entes
	 */
	public static List<ServizioEnte> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of matching servizio entes
	 */
	public static List<ServizioEnte> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio entes
	 */
	public static List<ServizioEnte> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizio entes
	 */
	public static List<ServizioEnte> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public static ServizioEnte findByUuid_First(
			String uuid, OrderByComparator<ServizioEnte> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public static ServizioEnte fetchByUuid_First(
		String uuid, OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public static ServizioEnte findByUuid_Last(
			String uuid, OrderByComparator<ServizioEnte> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public static ServizioEnte fetchByUuid_Last(
		String uuid, OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the servizio entes before and after the current servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param servizioEntePK the primary key of the current servizio ente
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	public static ServizioEnte[] findByUuid_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK,
			String uuid, OrderByComparator<ServizioEnte> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByUuid_PrevAndNext(
			servizioEntePK, uuid, orderByComparator);
	}

	/**
	 * Removes all the servizio entes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of servizio entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching servizio entes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the servizio ente where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchServizioEnteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public static ServizioEnte findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the servizio ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public static ServizioEnte fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the servizio ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public static ServizioEnte fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the servizio ente where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the servizio ente that was removed
	 */
	public static ServizioEnte removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of servizio entes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching servizio entes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching servizio entes
	 */
	public static List<ServizioEnte> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of matching servizio entes
	 */
	public static List<ServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio entes
	 */
	public static List<ServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizio entes
	 */
	public static List<ServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public static ServizioEnte findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public static ServizioEnte fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public static ServizioEnte findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public static ServizioEnte fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the servizio entes before and after the current servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param servizioEntePK the primary key of the current servizio ente
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	public static ServizioEnte[] findByUuid_C_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK,
			String uuid, long companyId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByUuid_C_PrevAndNext(
			servizioEntePK, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the servizio entes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching servizio entes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the servizio entes where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching servizio entes
	 */
	public static List<ServizioEnte> findByOrganizationId(long organizationId) {
		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	 * Returns a range of all the servizio entes where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of matching servizio entes
	 */
	public static List<ServizioEnte> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the servizio entes where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio entes
	 */
	public static List<ServizioEnte> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the servizio entes where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizio entes
	 */
	public static List<ServizioEnte> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public static ServizioEnte findByOrganizationId_First(
			long organizationId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public static ServizioEnte fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public static ServizioEnte findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public static ServizioEnte fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the servizio entes before and after the current servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param servizioEntePK the primary key of the current servizio ente
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	public static ServizioEnte[] findByOrganizationId_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK,
			long organizationId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			servizioEntePK, organizationId, orderByComparator);
	}

	/**
	 * Removes all the servizio entes where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of servizio entes where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching servizio entes
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Returns all the servizio entes where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the matching servizio entes
	 */
	public static List<ServizioEnte> findByServizioId(long servizioId) {
		return getPersistence().findByServizioId(servizioId);
	}

	/**
	 * Returns a range of all the servizio entes where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of matching servizio entes
	 */
	public static List<ServizioEnte> findByServizioId(
		long servizioId, int start, int end) {

		return getPersistence().findByServizioId(servizioId, start, end);
	}

	/**
	 * Returns an ordered range of all the servizio entes where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio entes
	 */
	public static List<ServizioEnte> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().findByServizioId(
			servizioId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the servizio entes where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizio entes
	 */
	public static List<ServizioEnte> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByServizioId(
			servizioId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public static ServizioEnte findByServizioId_First(
			long servizioId, OrderByComparator<ServizioEnte> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByServizioId_First(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the first servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public static ServizioEnte fetchByServizioId_First(
		long servizioId, OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().fetchByServizioId_First(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the last servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public static ServizioEnte findByServizioId_Last(
			long servizioId, OrderByComparator<ServizioEnte> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByServizioId_Last(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the last servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public static ServizioEnte fetchByServizioId_Last(
		long servizioId, OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().fetchByServizioId_Last(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the servizio entes before and after the current servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioEntePK the primary key of the current servizio ente
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	public static ServizioEnte[] findByServizioId_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK,
			long servizioId, OrderByComparator<ServizioEnte> orderByComparator)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByServizioId_PrevAndNext(
			servizioEntePK, servizioId, orderByComparator);
	}

	/**
	 * Removes all the servizio entes where servizioId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 */
	public static void removeByServizioId(long servizioId) {
		getPersistence().removeByServizioId(servizioId);
	}

	/**
	 * Returns the number of servizio entes where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the number of matching servizio entes
	 */
	public static int countByServizioId(long servizioId) {
		return getPersistence().countByServizioId(servizioId);
	}

	/**
	 * Caches the servizio ente in the entity cache if it is enabled.
	 *
	 * @param servizioEnte the servizio ente
	 */
	public static void cacheResult(ServizioEnte servizioEnte) {
		getPersistence().cacheResult(servizioEnte);
	}

	/**
	 * Caches the servizio entes in the entity cache if it is enabled.
	 *
	 * @param servizioEntes the servizio entes
	 */
	public static void cacheResult(List<ServizioEnte> servizioEntes) {
		getPersistence().cacheResult(servizioEntes);
	}

	/**
	 * Creates a new servizio ente with the primary key. Does not add the servizio ente to the database.
	 *
	 * @param servizioEntePK the primary key for the new servizio ente
	 * @return the new servizio ente
	 */
	public static ServizioEnte create(
		it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
			servizioEntePK) {

		return getPersistence().create(servizioEntePK);
	}

	/**
	 * Removes the servizio ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente that was removed
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	public static ServizioEnte remove(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().remove(servizioEntePK);
	}

	public static ServizioEnte updateImpl(ServizioEnte servizioEnte) {
		return getPersistence().updateImpl(servizioEnte);
	}

	/**
	 * Returns the servizio ente with the primary key or throws a <code>NoSuchServizioEnteException</code> if it could not be found.
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	public static ServizioEnte findByPrimaryKey(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK)
		throws it.servizidigitali.gestioneenti.exception.
			NoSuchServizioEnteException {

		return getPersistence().findByPrimaryKey(servizioEntePK);
	}

	/**
	 * Returns the servizio ente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente, or <code>null</code> if a servizio ente with the primary key could not be found
	 */
	public static ServizioEnte fetchByPrimaryKey(
		it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
			servizioEntePK) {

		return getPersistence().fetchByPrimaryKey(servizioEntePK);
	}

	/**
	 * Returns all the servizio entes.
	 *
	 * @return the servizio entes
	 */
	public static List<ServizioEnte> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of servizio entes
	 */
	public static List<ServizioEnte> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of servizio entes
	 */
	public static List<ServizioEnte> findAll(
		int start, int end, OrderByComparator<ServizioEnte> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of servizio entes
	 */
	public static List<ServizioEnte> findAll(
		int start, int end, OrderByComparator<ServizioEnte> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the servizio entes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of servizio entes.
	 *
	 * @return the number of servizio entes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static ServizioEntePersistence getPersistence() {
		return _persistence;
	}

	private static volatile ServizioEntePersistence _persistence;

}