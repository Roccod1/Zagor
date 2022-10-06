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

import it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the commento richiesta service. This utility wraps <code>it.servizidigitali.scrivaniaoperatore.service.persistence.impl.CommentoRichiestaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentoRichiestaPersistence
 * @generated
 */
public class CommentoRichiestaUtil {

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
	public static void clearCache(CommentoRichiesta commentoRichiesta) {
		getPersistence().clearCache(commentoRichiesta);
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
	public static Map<Serializable, CommentoRichiesta> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CommentoRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CommentoRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CommentoRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CommentoRichiesta update(
		CommentoRichiesta commentoRichiesta) {

		return getPersistence().update(commentoRichiesta);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CommentoRichiesta update(
		CommentoRichiesta commentoRichiesta, ServiceContext serviceContext) {

		return getPersistence().update(commentoRichiesta, serviceContext);
	}

	/**
	 * Returns all the commento richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the commento richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta findByUuid_First(
			String uuid, OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchByUuid_First(
		String uuid, OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta findByUuid_Last(
			String uuid, OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchByUuid_Last(
		String uuid, OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public static CommentoRichiesta[] findByUuid_PrevAndNext(
			long commentoRichiestaId, String uuid,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByUuid_PrevAndNext(
			commentoRichiestaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the commento richiestas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of commento richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching commento richiestas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the commento richiesta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCommentoRichiestaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the commento richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the commento richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the commento richiesta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the commento richiesta that was removed
	 */
	public static CommentoRichiesta removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of commento richiestas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching commento richiestas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public static CommentoRichiesta[] findByUuid_C_PrevAndNext(
			long commentoRichiestaId, String uuid, long companyId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			commentoRichiestaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the commento richiestas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching commento richiestas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the commento richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByRichiestaId(long richiestaId) {
		return getPersistence().findByRichiestaId(richiestaId);
	}

	/**
	 * Returns a range of all the commento richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end) {

		return getPersistence().findByRichiestaId(richiestaId, start, end);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().findByRichiestaId(
			richiestaId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRichiestaId(
			richiestaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta findByRichiestaId_First(
			long richiestaId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByRichiestaId_First(
			richiestaId, orderByComparator);
	}

	/**
	 * Returns the first commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchByRichiestaId_First(
		long richiestaId,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaId_First(
			richiestaId, orderByComparator);
	}

	/**
	 * Returns the last commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta findByRichiestaId_Last(
			long richiestaId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByRichiestaId_Last(
			richiestaId, orderByComparator);
	}

	/**
	 * Returns the last commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchByRichiestaId_Last(
		long richiestaId,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaId_Last(
			richiestaId, orderByComparator);
	}

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public static CommentoRichiesta[] findByRichiestaId_PrevAndNext(
			long commentoRichiestaId, long richiestaId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByRichiestaId_PrevAndNext(
			commentoRichiestaId, richiestaId, orderByComparator);
	}

	/**
	 * Removes all the commento richiestas where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 */
	public static void removeByRichiestaId(long richiestaId) {
		getPersistence().removeByRichiestaId(richiestaId);
	}

	/**
	 * Returns the number of commento richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching commento richiestas
	 */
	public static int countByRichiestaId(long richiestaId) {
		return getPersistence().countByRichiestaId(richiestaId);
	}

	/**
	 * Returns all the commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @return the matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile) {

		return getPersistence().findByRichiestaIdVisibile(
			richiestaId, visibile);
	}

	/**
	 * Returns a range of all the commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end) {

		return getPersistence().findByRichiestaIdVisibile(
			richiestaId, visibile, start, end);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().findByRichiestaIdVisibile(
			richiestaId, visibile, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRichiestaIdVisibile(
			richiestaId, visibile, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta findByRichiestaIdVisibile_First(
			long richiestaId, boolean visibile,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByRichiestaIdVisibile_First(
			richiestaId, visibile, orderByComparator);
	}

	/**
	 * Returns the first commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchByRichiestaIdVisibile_First(
		long richiestaId, boolean visibile,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaIdVisibile_First(
			richiestaId, visibile, orderByComparator);
	}

	/**
	 * Returns the last commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta findByRichiestaIdVisibile_Last(
			long richiestaId, boolean visibile,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByRichiestaIdVisibile_Last(
			richiestaId, visibile, orderByComparator);
	}

	/**
	 * Returns the last commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchByRichiestaIdVisibile_Last(
		long richiestaId, boolean visibile,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaIdVisibile_Last(
			richiestaId, visibile, orderByComparator);
	}

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public static CommentoRichiesta[] findByRichiestaIdVisibile_PrevAndNext(
			long commentoRichiestaId, long richiestaId, boolean visibile,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByRichiestaIdVisibile_PrevAndNext(
			commentoRichiestaId, richiestaId, visibile, orderByComparator);
	}

	/**
	 * Removes all the commento richiestas where richiestaId = &#63; and visibile = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 */
	public static void removeByRichiestaIdVisibile(
		long richiestaId, boolean visibile) {

		getPersistence().removeByRichiestaIdVisibile(richiestaId, visibile);
	}

	/**
	 * Returns the number of commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @return the number of matching commento richiestas
	 */
	public static int countByRichiestaIdVisibile(
		long richiestaId, boolean visibile) {

		return getPersistence().countByRichiestaIdVisibile(
			richiestaId, visibile);
	}

	/**
	 * Returns all the commento richiestas where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByTaskId(String taskId) {
		return getPersistence().findByTaskId(taskId);
	}

	/**
	 * Returns a range of all the commento richiestas where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByTaskId(
		String taskId, int start, int end) {

		return getPersistence().findByTaskId(taskId, start, end);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByTaskId(
		String taskId, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	public static List<CommentoRichiesta> findByTaskId(
		String taskId, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta findByTaskId_First(
			String taskId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the first commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchByTaskId_First(
		String taskId, OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().fetchByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the last commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta findByTaskId_Last(
			String taskId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the last commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchByTaskId_Last(
		String taskId, OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().fetchByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public static CommentoRichiesta[] findByTaskId_PrevAndNext(
			long commentoRichiestaId, String taskId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByTaskId_PrevAndNext(
			commentoRichiestaId, taskId, orderByComparator);
	}

	/**
	 * Removes all the commento richiestas where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public static void removeByTaskId(String taskId) {
		getPersistence().removeByTaskId(taskId);
	}

	/**
	 * Returns the number of commento richiestas where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching commento richiestas
	 */
	public static int countByTaskId(String taskId) {
		return getPersistence().countByTaskId(taskId);
	}

	/**
	 * Caches the commento richiesta in the entity cache if it is enabled.
	 *
	 * @param commentoRichiesta the commento richiesta
	 */
	public static void cacheResult(CommentoRichiesta commentoRichiesta) {
		getPersistence().cacheResult(commentoRichiesta);
	}

	/**
	 * Caches the commento richiestas in the entity cache if it is enabled.
	 *
	 * @param commentoRichiestas the commento richiestas
	 */
	public static void cacheResult(List<CommentoRichiesta> commentoRichiestas) {
		getPersistence().cacheResult(commentoRichiestas);
	}

	/**
	 * Creates a new commento richiesta with the primary key. Does not add the commento richiesta to the database.
	 *
	 * @param commentoRichiestaId the primary key for the new commento richiesta
	 * @return the new commento richiesta
	 */
	public static CommentoRichiesta create(long commentoRichiestaId) {
		return getPersistence().create(commentoRichiestaId);
	}

	/**
	 * Removes the commento richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta that was removed
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public static CommentoRichiesta remove(long commentoRichiestaId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().remove(commentoRichiestaId);
	}

	public static CommentoRichiesta updateImpl(
		CommentoRichiesta commentoRichiesta) {

		return getPersistence().updateImpl(commentoRichiesta);
	}

	/**
	 * Returns the commento richiesta with the primary key or throws a <code>NoSuchCommentoRichiestaException</code> if it could not be found.
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public static CommentoRichiesta findByPrimaryKey(long commentoRichiestaId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchCommentoRichiestaException {

		return getPersistence().findByPrimaryKey(commentoRichiestaId);
	}

	/**
	 * Returns the commento richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta, or <code>null</code> if a commento richiesta with the primary key could not be found
	 */
	public static CommentoRichiesta fetchByPrimaryKey(
		long commentoRichiestaId) {

		return getPersistence().fetchByPrimaryKey(commentoRichiestaId);
	}

	/**
	 * Returns all the commento richiestas.
	 *
	 * @return the commento richiestas
	 */
	public static List<CommentoRichiesta> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the commento richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of commento richiestas
	 */
	public static List<CommentoRichiesta> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the commento richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commento richiestas
	 */
	public static List<CommentoRichiesta> findAll(
		int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commento richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commento richiestas
	 */
	public static List<CommentoRichiesta> findAll(
		int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the commento richiestas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of commento richiestas.
	 *
	 * @return the number of commento richiestas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CommentoRichiestaPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CommentoRichiestaPersistence _persistence;

}