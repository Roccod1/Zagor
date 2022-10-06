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

package it.servizidigitali.scrivaniaoperatore.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the destinazione uso service. This utility wraps <code>it.servizidigitali.scrivaniaoperatore.service.persistence.impl.DestinazioneUsoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DestinazioneUsoPersistence
 * @generated
 */
public class DestinazioneUsoUtil {

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
	public static void clearCache(DestinazioneUso destinazioneUso) {
		getPersistence().clearCache(destinazioneUso);
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
	public static Map<Serializable, DestinazioneUso> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DestinazioneUso> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DestinazioneUso> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DestinazioneUso> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DestinazioneUso update(DestinazioneUso destinazioneUso) {
		return getPersistence().update(destinazioneUso);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DestinazioneUso update(
		DestinazioneUso destinazioneUso, ServiceContext serviceContext) {

		return getPersistence().update(destinazioneUso, serviceContext);
	}

	/**
	 * Returns all the destinazione usos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching destinazione usos
	 */
	public static List<DestinazioneUso> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the destinazione usos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of matching destinazione usos
	 */
	public static List<DestinazioneUso> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione usos
	 */
	public static List<DestinazioneUso> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione usos
	 */
	public static List<DestinazioneUso> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso findByUuid_First(
			String uuid, OrderByComparator<DestinazioneUso> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso fetchByUuid_First(
		String uuid, OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso findByUuid_Last(
			String uuid, OrderByComparator<DestinazioneUso> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso fetchByUuid_Last(
		String uuid, OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the destinazione usos before and after the current destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param destinazioneUsoId the primary key of the current destinazione uso
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	public static DestinazioneUso[] findByUuid_PrevAndNext(
			long destinazioneUsoId, String uuid,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByUuid_PrevAndNext(
			destinazioneUsoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the destinazione usos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of destinazione usos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching destinazione usos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the destinazione uso where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDestinazioneUsoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the destinazione uso where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the destinazione uso where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the destinazione uso where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the destinazione uso that was removed
	 */
	public static DestinazioneUso removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of destinazione usos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching destinazione usos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching destinazione usos
	 */
	public static List<DestinazioneUso> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of matching destinazione usos
	 */
	public static List<DestinazioneUso> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione usos
	 */
	public static List<DestinazioneUso> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione usos
	 */
	public static List<DestinazioneUso> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the destinazione usos before and after the current destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param destinazioneUsoId the primary key of the current destinazione uso
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	public static DestinazioneUso[] findByUuid_C_PrevAndNext(
			long destinazioneUsoId, String uuid, long companyId,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			destinazioneUsoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the destinazione usos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching destinazione usos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the destinazione usos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching destinazione usos
	 */
	public static List<DestinazioneUso> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the destinazione usos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of matching destinazione usos
	 */
	public static List<DestinazioneUso> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione usos
	 */
	public static List<DestinazioneUso> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione usos
	 */
	public static List<DestinazioneUso> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso findByGroupId_First(
			long groupId, OrderByComparator<DestinazioneUso> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso fetchByGroupId_First(
		long groupId, OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso findByGroupId_Last(
			long groupId, OrderByComparator<DestinazioneUso> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso fetchByGroupId_Last(
		long groupId, OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the destinazione usos before and after the current destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param destinazioneUsoId the primary key of the current destinazione uso
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	public static DestinazioneUso[] findByGroupId_PrevAndNext(
			long destinazioneUsoId, long groupId,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByGroupId_PrevAndNext(
			destinazioneUsoId, groupId, orderByComparator);
	}

	/**
	 * Removes all the destinazione usos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of destinazione usos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching destinazione usos
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the destinazione usos where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @return the matching destinazione usos
	 */
	public static List<DestinazioneUso> findByPagamentoBollo(
		boolean pagamentoBollo) {

		return getPersistence().findByPagamentoBollo(pagamentoBollo);
	}

	/**
	 * Returns a range of all the destinazione usos where pagamentoBollo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of matching destinazione usos
	 */
	public static List<DestinazioneUso> findByPagamentoBollo(
		boolean pagamentoBollo, int start, int end) {

		return getPersistence().findByPagamentoBollo(
			pagamentoBollo, start, end);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where pagamentoBollo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione usos
	 */
	public static List<DestinazioneUso> findByPagamentoBollo(
		boolean pagamentoBollo, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().findByPagamentoBollo(
			pagamentoBollo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where pagamentoBollo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione usos
	 */
	public static List<DestinazioneUso> findByPagamentoBollo(
		boolean pagamentoBollo, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPagamentoBollo(
			pagamentoBollo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso findByPagamentoBollo_First(
			boolean pagamentoBollo,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByPagamentoBollo_First(
			pagamentoBollo, orderByComparator);
	}

	/**
	 * Returns the first destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso fetchByPagamentoBollo_First(
		boolean pagamentoBollo,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().fetchByPagamentoBollo_First(
			pagamentoBollo, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso findByPagamentoBollo_Last(
			boolean pagamentoBollo,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByPagamentoBollo_Last(
			pagamentoBollo, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso fetchByPagamentoBollo_Last(
		boolean pagamentoBollo,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().fetchByPagamentoBollo_Last(
			pagamentoBollo, orderByComparator);
	}

	/**
	 * Returns the destinazione usos before and after the current destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param destinazioneUsoId the primary key of the current destinazione uso
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	public static DestinazioneUso[] findByPagamentoBollo_PrevAndNext(
			long destinazioneUsoId, boolean pagamentoBollo,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByPagamentoBollo_PrevAndNext(
			destinazioneUsoId, pagamentoBollo, orderByComparator);
	}

	/**
	 * Removes all the destinazione usos where pagamentoBollo = &#63; from the database.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 */
	public static void removeByPagamentoBollo(boolean pagamentoBollo) {
		getPersistence().removeByPagamentoBollo(pagamentoBollo);
	}

	/**
	 * Returns the number of destinazione usos where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @return the number of matching destinazione usos
	 */
	public static int countByPagamentoBollo(boolean pagamentoBollo) {
		return getPersistence().countByPagamentoBollo(pagamentoBollo);
	}

	/**
	 * Caches the destinazione uso in the entity cache if it is enabled.
	 *
	 * @param destinazioneUso the destinazione uso
	 */
	public static void cacheResult(DestinazioneUso destinazioneUso) {
		getPersistence().cacheResult(destinazioneUso);
	}

	/**
	 * Caches the destinazione usos in the entity cache if it is enabled.
	 *
	 * @param destinazioneUsos the destinazione usos
	 */
	public static void cacheResult(List<DestinazioneUso> destinazioneUsos) {
		getPersistence().cacheResult(destinazioneUsos);
	}

	/**
	 * Creates a new destinazione uso with the primary key. Does not add the destinazione uso to the database.
	 *
	 * @param destinazioneUsoId the primary key for the new destinazione uso
	 * @return the new destinazione uso
	 */
	public static DestinazioneUso create(long destinazioneUsoId) {
		return getPersistence().create(destinazioneUsoId);
	}

	/**
	 * Removes the destinazione uso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso that was removed
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	public static DestinazioneUso remove(long destinazioneUsoId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().remove(destinazioneUsoId);
	}

	public static DestinazioneUso updateImpl(DestinazioneUso destinazioneUso) {
		return getPersistence().updateImpl(destinazioneUso);
	}

	/**
	 * Returns the destinazione uso with the primary key or throws a <code>NoSuchDestinazioneUsoException</code> if it could not be found.
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	public static DestinazioneUso findByPrimaryKey(long destinazioneUsoId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoException {

		return getPersistence().findByPrimaryKey(destinazioneUsoId);
	}

	/**
	 * Returns the destinazione uso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso, or <code>null</code> if a destinazione uso with the primary key could not be found
	 */
	public static DestinazioneUso fetchByPrimaryKey(long destinazioneUsoId) {
		return getPersistence().fetchByPrimaryKey(destinazioneUsoId);
	}

	/**
	 * Returns all the destinazione usos.
	 *
	 * @return the destinazione usos
	 */
	public static List<DestinazioneUso> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the destinazione usos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of destinazione usos
	 */
	public static List<DestinazioneUso> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the destinazione usos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of destinazione usos
	 */
	public static List<DestinazioneUso> findAll(
		int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the destinazione usos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of destinazione usos
	 */
	public static List<DestinazioneUso> findAll(
		int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the destinazione usos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of destinazione usos.
	 *
	 * @return the number of destinazione usos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DestinazioneUsoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DestinazioneUsoPersistence _persistence;

}