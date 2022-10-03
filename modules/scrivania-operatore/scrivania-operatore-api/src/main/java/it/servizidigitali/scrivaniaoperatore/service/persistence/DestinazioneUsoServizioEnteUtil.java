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

import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the destinazione uso servizio ente service. This utility wraps <code>it.servizidigitali.scrivaniaoperatore.service.persistence.impl.DestinazioneUsoServizioEntePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DestinazioneUsoServizioEntePersistence
 * @generated
 */
public class DestinazioneUsoServizioEnteUtil {

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
	public static void clearCache(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		getPersistence().clearCache(destinazioneUsoServizioEnte);
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
	public static Map<Serializable, DestinazioneUsoServizioEnte>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DestinazioneUsoServizioEnte> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DestinazioneUsoServizioEnte> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DestinazioneUsoServizioEnte> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DestinazioneUsoServizioEnte update(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		return getPersistence().update(destinazioneUsoServizioEnte);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DestinazioneUsoServizioEnte update(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte,
		ServiceContext serviceContext) {

		return getPersistence().update(
			destinazioneUsoServizioEnte, serviceContext);
	}

	/**
	 * Returns all the destinazione uso servizio entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the destinazione uso servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte findByUuid_First(
			String uuid,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte fetchByUuid_First(
		String uuid,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte findByUuid_Last(
			String uuid,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte fetchByUuid_Last(
		String uuid,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the destinazione uso servizio entes before and after the current destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the current destinazione uso servizio ente
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public static DestinazioneUsoServizioEnte[] findByUuid_PrevAndNext(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK,
			String uuid,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByUuid_PrevAndNext(
			destinazioneUsoServizioEntePK, uuid, orderByComparator);
	}

	/**
	 * Removes all the destinazione uso servizio entes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of destinazione uso servizio entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching destinazione uso servizio entes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the destinazione uso servizio ente where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDestinazioneUsoServizioEnteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte findByUUID_G(
			String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the destinazione uso servizio ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the destinazione uso servizio ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the destinazione uso servizio ente where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the destinazione uso servizio ente that was removed
	 */
	public static DestinazioneUsoServizioEnte removeByUUID_G(
			String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of destinazione uso servizio entes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the destinazione uso servizio entes before and after the current destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the current destinazione uso servizio ente
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public static DestinazioneUsoServizioEnte[] findByUuid_C_PrevAndNext(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK,
			String uuid, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByUuid_C_PrevAndNext(
			destinazioneUsoServizioEntePK, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the destinazione uso servizio ente where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63; or throws a <code>NoSuchDestinazioneUsoServizioEnteException</code> if it could not be found.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @return the matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte
			findByDestinazioneUsoIdServizioIdOrganizationId(
				long destinazioneUsoId, long servizioId, long organizationId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByDestinazioneUsoIdServizioIdOrganizationId(
			destinazioneUsoId, servizioId, organizationId);
	}

	/**
	 * Returns the destinazione uso servizio ente where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte
		fetchByDestinazioneUsoIdServizioIdOrganizationId(
			long destinazioneUsoId, long servizioId, long organizationId) {

		return getPersistence().
			fetchByDestinazioneUsoIdServizioIdOrganizationId(
				destinazioneUsoId, servizioId, organizationId);
	}

	/**
	 * Returns the destinazione uso servizio ente where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte
		fetchByDestinazioneUsoIdServizioIdOrganizationId(
			long destinazioneUsoId, long servizioId, long organizationId,
			boolean useFinderCache) {

		return getPersistence().
			fetchByDestinazioneUsoIdServizioIdOrganizationId(
				destinazioneUsoId, servizioId, organizationId, useFinderCache);
	}

	/**
	 * Removes the destinazione uso servizio ente where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @return the destinazione uso servizio ente that was removed
	 */
	public static DestinazioneUsoServizioEnte
			removeByDestinazioneUsoIdServizioIdOrganizationId(
				long destinazioneUsoId, long servizioId, long organizationId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().
			removeByDestinazioneUsoIdServizioIdOrganizationId(
				destinazioneUsoId, servizioId, organizationId);
	}

	/**
	 * Returns the number of destinazione uso servizio entes where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63;.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	public static int countByDestinazioneUsoIdServizioIdOrganizationId(
		long destinazioneUsoId, long servizioId, long organizationId) {

		return getPersistence().
			countByDestinazioneUsoIdServizioIdOrganizationId(
				destinazioneUsoId, servizioId, organizationId);
	}

	/**
	 * Returns all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte>
		findByOrganizationIdGroupIdCompanyId(
			long organizationId, long groupId, long companyId) {

		return getPersistence().findByOrganizationIdGroupIdCompanyId(
			organizationId, groupId, companyId);
	}

	/**
	 * Returns a range of all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte>
		findByOrganizationIdGroupIdCompanyId(
			long organizationId, long groupId, long companyId, int start,
			int end) {

		return getPersistence().findByOrganizationIdGroupIdCompanyId(
			organizationId, groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte>
		findByOrganizationIdGroupIdCompanyId(
			long organizationId, long groupId, long companyId, int start,
			int end,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().findByOrganizationIdGroupIdCompanyId(
			organizationId, groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte>
		findByOrganizationIdGroupIdCompanyId(
			long organizationId, long groupId, long companyId, int start,
			int end,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByOrganizationIdGroupIdCompanyId(
			organizationId, groupId, companyId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte
			findByOrganizationIdGroupIdCompanyId_First(
				long organizationId, long groupId, long companyId,
				OrderByComparator<DestinazioneUsoServizioEnte>
					orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByOrganizationIdGroupIdCompanyId_First(
			organizationId, groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte
		fetchByOrganizationIdGroupIdCompanyId_First(
			long organizationId, long groupId, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().fetchByOrganizationIdGroupIdCompanyId_First(
			organizationId, groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte
			findByOrganizationIdGroupIdCompanyId_Last(
				long organizationId, long groupId, long companyId,
				OrderByComparator<DestinazioneUsoServizioEnte>
					orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByOrganizationIdGroupIdCompanyId_Last(
			organizationId, groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte
		fetchByOrganizationIdGroupIdCompanyId_Last(
			long organizationId, long groupId, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().fetchByOrganizationIdGroupIdCompanyId_Last(
			organizationId, groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the destinazione uso servizio entes before and after the current destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the current destinazione uso servizio ente
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public static DestinazioneUsoServizioEnte[]
			findByOrganizationIdGroupIdCompanyId_PrevAndNext(
				it.servizidigitali.scrivaniaoperatore.service.persistence.
					DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK,
				long organizationId, long groupId, long companyId,
				OrderByComparator<DestinazioneUsoServizioEnte>
					orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().
			findByOrganizationIdGroupIdCompanyId_PrevAndNext(
				destinazioneUsoServizioEntePK, organizationId, groupId,
				companyId, orderByComparator);
	}

	/**
	 * Removes all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByOrganizationIdGroupIdCompanyId(
		long organizationId, long groupId, long companyId) {

		getPersistence().removeByOrganizationIdGroupIdCompanyId(
			organizationId, groupId, companyId);
	}

	/**
	 * Returns the number of destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	public static int countByOrganizationIdGroupIdCompanyId(
		long organizationId, long groupId, long companyId) {

		return getPersistence().countByOrganizationIdGroupIdCompanyId(
			organizationId, groupId, companyId);
	}

	/**
	 * Returns all the destinazione uso servizio entes where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findByO_S_G_C(
		long organizationId, long servizioId, long groupId, long companyId) {

		return getPersistence().findByO_S_G_C(
			organizationId, servizioId, groupId, companyId);
	}

	/**
	 * Returns a range of all the destinazione uso servizio entes where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findByO_S_G_C(
		long organizationId, long servizioId, long groupId, long companyId,
		int start, int end) {

		return getPersistence().findByO_S_G_C(
			organizationId, servizioId, groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findByO_S_G_C(
		long organizationId, long servizioId, long groupId, long companyId,
		int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().findByO_S_G_C(
			organizationId, servizioId, groupId, companyId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findByO_S_G_C(
		long organizationId, long servizioId, long groupId, long companyId,
		int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByO_S_G_C(
			organizationId, servizioId, groupId, companyId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte findByO_S_G_C_First(
			long organizationId, long servizioId, long groupId, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByO_S_G_C_First(
			organizationId, servizioId, groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte fetchByO_S_G_C_First(
		long organizationId, long servizioId, long groupId, long companyId,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().fetchByO_S_G_C_First(
			organizationId, servizioId, groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte findByO_S_G_C_Last(
			long organizationId, long servizioId, long groupId, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByO_S_G_C_Last(
			organizationId, servizioId, groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte fetchByO_S_G_C_Last(
		long organizationId, long servizioId, long groupId, long companyId,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().fetchByO_S_G_C_Last(
			organizationId, servizioId, groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the destinazione uso servizio entes before and after the current destinazione uso servizio ente in the ordered set where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the current destinazione uso servizio ente
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public static DestinazioneUsoServizioEnte[] findByO_S_G_C_PrevAndNext(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK,
			long organizationId, long servizioId, long groupId, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByO_S_G_C_PrevAndNext(
			destinazioneUsoServizioEntePK, organizationId, servizioId, groupId,
			companyId, orderByComparator);
	}

	/**
	 * Removes all the destinazione uso servizio entes where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByO_S_G_C(
		long organizationId, long servizioId, long groupId, long companyId) {

		getPersistence().removeByO_S_G_C(
			organizationId, servizioId, groupId, companyId);
	}

	/**
	 * Returns the number of destinazione uso servizio entes where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	public static int countByO_S_G_C(
		long organizationId, long servizioId, long groupId, long companyId) {

		return getPersistence().countByO_S_G_C(
			organizationId, servizioId, groupId, companyId);
	}

	/**
	 * Caches the destinazione uso servizio ente in the entity cache if it is enabled.
	 *
	 * @param destinazioneUsoServizioEnte the destinazione uso servizio ente
	 */
	public static void cacheResult(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		getPersistence().cacheResult(destinazioneUsoServizioEnte);
	}

	/**
	 * Caches the destinazione uso servizio entes in the entity cache if it is enabled.
	 *
	 * @param destinazioneUsoServizioEntes the destinazione uso servizio entes
	 */
	public static void cacheResult(
		List<DestinazioneUsoServizioEnte> destinazioneUsoServizioEntes) {

		getPersistence().cacheResult(destinazioneUsoServizioEntes);
	}

	/**
	 * Creates a new destinazione uso servizio ente with the primary key. Does not add the destinazione uso servizio ente to the database.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key for the new destinazione uso servizio ente
	 * @return the new destinazione uso servizio ente
	 */
	public static DestinazioneUsoServizioEnte create(
		it.servizidigitali.scrivaniaoperatore.service.persistence.
			DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK) {

		return getPersistence().create(destinazioneUsoServizioEntePK);
	}

	/**
	 * Removes the destinazione uso servizio ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente that was removed
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public static DestinazioneUsoServizioEnte remove(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().remove(destinazioneUsoServizioEntePK);
	}

	public static DestinazioneUsoServizioEnte updateImpl(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		return getPersistence().updateImpl(destinazioneUsoServizioEnte);
	}

	/**
	 * Returns the destinazione uso servizio ente with the primary key or throws a <code>NoSuchDestinazioneUsoServizioEnteException</code> if it could not be found.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public static DestinazioneUsoServizioEnte findByPrimaryKey(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchDestinazioneUsoServizioEnteException {

		return getPersistence().findByPrimaryKey(destinazioneUsoServizioEntePK);
	}

	/**
	 * Returns the destinazione uso servizio ente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente, or <code>null</code> if a destinazione uso servizio ente with the primary key could not be found
	 */
	public static DestinazioneUsoServizioEnte fetchByPrimaryKey(
		it.servizidigitali.scrivaniaoperatore.service.persistence.
			DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK) {

		return getPersistence().fetchByPrimaryKey(
			destinazioneUsoServizioEntePK);
	}

	/**
	 * Returns all the destinazione uso servizio entes.
	 *
	 * @return the destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the destinazione uso servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findAll(
		int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte> findAll(
		int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the destinazione uso servizio entes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of destinazione uso servizio entes.
	 *
	 * @return the number of destinazione uso servizio entes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static DestinazioneUsoServizioEntePersistence getPersistence() {
		return _persistence;
	}

	private static volatile DestinazioneUsoServizioEntePersistence _persistence;

}