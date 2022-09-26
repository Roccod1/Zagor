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

import it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the attivita richiesta service. This utility wraps <code>it.servizidigitali.scrivaniaoperatore.service.persistence.impl.AttivitaRichiestaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttivitaRichiestaPersistence
 * @generated
 */
public class AttivitaRichiestaUtil {

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
	public static void clearCache(AttivitaRichiesta attivitaRichiesta) {
		getPersistence().clearCache(attivitaRichiesta);
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
	public static Map<Serializable, AttivitaRichiesta> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AttivitaRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AttivitaRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AttivitaRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AttivitaRichiesta update(
		AttivitaRichiesta attivitaRichiesta) {

		return getPersistence().update(attivitaRichiesta);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AttivitaRichiesta update(
		AttivitaRichiesta attivitaRichiesta, ServiceContext serviceContext) {

		return getPersistence().update(attivitaRichiesta, serviceContext);
	}

	/**
	 * Returns all the attivita richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching attivita richiestas
	 */
	public static List<AttivitaRichiesta> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the attivita richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of matching attivita richiestas
	 */
	public static List<AttivitaRichiesta> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attivita richiestas
	 */
	public static List<AttivitaRichiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attivita richiestas
	 */
	public static List<AttivitaRichiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta findByUuid_First(
			String uuid, OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta fetchByUuid_First(
		String uuid, OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta findByUuid_Last(
			String uuid, OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta fetchByUuid_Last(
		String uuid, OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the attivita richiestas before and after the current attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param attivitaRichiestaId the primary key of the current attivita richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	public static AttivitaRichiesta[] findByUuid_PrevAndNext(
			long attivitaRichiestaId, String uuid,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().findByUuid_PrevAndNext(
			attivitaRichiestaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the attivita richiestas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of attivita richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching attivita richiestas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the attivita richiesta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAttivitaRichiestaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the attivita richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the attivita richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the attivita richiesta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the attivita richiesta that was removed
	 */
	public static AttivitaRichiesta removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of attivita richiestas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching attivita richiestas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching attivita richiestas
	 */
	public static List<AttivitaRichiesta> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of matching attivita richiestas
	 */
	public static List<AttivitaRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attivita richiestas
	 */
	public static List<AttivitaRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attivita richiestas
	 */
	public static List<AttivitaRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the attivita richiestas before and after the current attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param attivitaRichiestaId the primary key of the current attivita richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	public static AttivitaRichiesta[] findByUuid_C_PrevAndNext(
			long attivitaRichiestaId, String uuid, long companyId,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			attivitaRichiestaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the attivita richiestas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching attivita richiestas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the attivita richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching attivita richiestas
	 */
	public static List<AttivitaRichiesta> findByRichiestaId(long richiestaId) {
		return getPersistence().findByRichiestaId(richiestaId);
	}

	/**
	 * Returns a range of all the attivita richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of matching attivita richiestas
	 */
	public static List<AttivitaRichiesta> findByRichiestaId(
		long richiestaId, int start, int end) {

		return getPersistence().findByRichiestaId(richiestaId, start, end);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attivita richiestas
	 */
	public static List<AttivitaRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return getPersistence().findByRichiestaId(
			richiestaId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attivita richiestas
	 */
	public static List<AttivitaRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRichiestaId(
			richiestaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta findByRichiestaId_First(
			long richiestaId,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().findByRichiestaId_First(
			richiestaId, orderByComparator);
	}

	/**
	 * Returns the first attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta fetchByRichiestaId_First(
		long richiestaId,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaId_First(
			richiestaId, orderByComparator);
	}

	/**
	 * Returns the last attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta findByRichiestaId_Last(
			long richiestaId,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().findByRichiestaId_Last(
			richiestaId, orderByComparator);
	}

	/**
	 * Returns the last attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public static AttivitaRichiesta fetchByRichiestaId_Last(
		long richiestaId,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaId_Last(
			richiestaId, orderByComparator);
	}

	/**
	 * Returns the attivita richiestas before and after the current attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param attivitaRichiestaId the primary key of the current attivita richiesta
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	public static AttivitaRichiesta[] findByRichiestaId_PrevAndNext(
			long attivitaRichiestaId, long richiestaId,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().findByRichiestaId_PrevAndNext(
			attivitaRichiestaId, richiestaId, orderByComparator);
	}

	/**
	 * Removes all the attivita richiestas where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 */
	public static void removeByRichiestaId(long richiestaId) {
		getPersistence().removeByRichiestaId(richiestaId);
	}

	/**
	 * Returns the number of attivita richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching attivita richiestas
	 */
	public static int countByRichiestaId(long richiestaId) {
		return getPersistence().countByRichiestaId(richiestaId);
	}

	/**
	 * Caches the attivita richiesta in the entity cache if it is enabled.
	 *
	 * @param attivitaRichiesta the attivita richiesta
	 */
	public static void cacheResult(AttivitaRichiesta attivitaRichiesta) {
		getPersistence().cacheResult(attivitaRichiesta);
	}

	/**
	 * Caches the attivita richiestas in the entity cache if it is enabled.
	 *
	 * @param attivitaRichiestas the attivita richiestas
	 */
	public static void cacheResult(List<AttivitaRichiesta> attivitaRichiestas) {
		getPersistence().cacheResult(attivitaRichiestas);
	}

	/**
	 * Creates a new attivita richiesta with the primary key. Does not add the attivita richiesta to the database.
	 *
	 * @param attivitaRichiestaId the primary key for the new attivita richiesta
	 * @return the new attivita richiesta
	 */
	public static AttivitaRichiesta create(long attivitaRichiestaId) {
		return getPersistence().create(attivitaRichiestaId);
	}

	/**
	 * Removes the attivita richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attivitaRichiestaId the primary key of the attivita richiesta
	 * @return the attivita richiesta that was removed
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	public static AttivitaRichiesta remove(long attivitaRichiestaId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().remove(attivitaRichiestaId);
	}

	public static AttivitaRichiesta updateImpl(
		AttivitaRichiesta attivitaRichiesta) {

		return getPersistence().updateImpl(attivitaRichiesta);
	}

	/**
	 * Returns the attivita richiesta with the primary key or throws a <code>NoSuchAttivitaRichiestaException</code> if it could not be found.
	 *
	 * @param attivitaRichiestaId the primary key of the attivita richiesta
	 * @return the attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	public static AttivitaRichiesta findByPrimaryKey(long attivitaRichiestaId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAttivitaRichiestaException {

		return getPersistence().findByPrimaryKey(attivitaRichiestaId);
	}

	/**
	 * Returns the attivita richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attivitaRichiestaId the primary key of the attivita richiesta
	 * @return the attivita richiesta, or <code>null</code> if a attivita richiesta with the primary key could not be found
	 */
	public static AttivitaRichiesta fetchByPrimaryKey(
		long attivitaRichiestaId) {

		return getPersistence().fetchByPrimaryKey(attivitaRichiestaId);
	}

	/**
	 * Returns all the attivita richiestas.
	 *
	 * @return the attivita richiestas
	 */
	public static List<AttivitaRichiesta> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the attivita richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of attivita richiestas
	 */
	public static List<AttivitaRichiesta> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attivita richiestas
	 */
	public static List<AttivitaRichiesta> findAll(
		int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of attivita richiestas
	 */
	public static List<AttivitaRichiesta> findAll(
		int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the attivita richiestas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of attivita richiestas.
	 *
	 * @return the number of attivita richiestas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AttivitaRichiestaPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AttivitaRichiestaPersistence _persistence;

}