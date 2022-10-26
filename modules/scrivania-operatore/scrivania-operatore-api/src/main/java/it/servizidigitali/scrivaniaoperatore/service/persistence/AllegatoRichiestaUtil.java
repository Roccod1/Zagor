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

import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the allegato richiesta service. This utility wraps <code>it.servizidigitali.scrivaniaoperatore.service.persistence.impl.AllegatoRichiestaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AllegatoRichiestaPersistence
 * @generated
 */
public class AllegatoRichiestaUtil {

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
	public static void clearCache(AllegatoRichiesta allegatoRichiesta) {
		getPersistence().clearCache(allegatoRichiesta);
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
	public static Map<Serializable, AllegatoRichiesta> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AllegatoRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AllegatoRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AllegatoRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AllegatoRichiesta update(
		AllegatoRichiesta allegatoRichiesta) {

		return getPersistence().update(allegatoRichiesta);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AllegatoRichiesta update(
		AllegatoRichiesta allegatoRichiesta, ServiceContext serviceContext) {

		return getPersistence().update(allegatoRichiesta, serviceContext);
	}

	/**
	 * Returns all the allegato richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the allegato richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByUuid_First(
			String uuid, OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByUuid_First(
		String uuid, OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByUuid_Last(
			String uuid, OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByUuid_Last(
		String uuid, OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public static AllegatoRichiesta[] findByUuid_PrevAndNext(
			long allegatoRichiestaId, String uuid,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByUuid_PrevAndNext(
			allegatoRichiestaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the allegato richiestas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of allegato richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allegato richiestas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the allegato richiesta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the allegato richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the allegato richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the allegato richiesta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allegato richiesta that was removed
	 */
	public static AllegatoRichiesta removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of allegato richiestas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allegato richiestas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public static AllegatoRichiesta[] findByUuid_C_PrevAndNext(
			long allegatoRichiestaId, String uuid, long companyId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			allegatoRichiestaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the allegato richiestas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allegato richiestas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the allegato richiesta where idDocumentale = &#63; or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param idDocumentale the id documentale
	 * @return the matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByIdDocumentale(String idDocumentale)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByIdDocumentale(idDocumentale);
	}

	/**
	 * Returns the allegato richiesta where idDocumentale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idDocumentale the id documentale
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByIdDocumentale(String idDocumentale) {
		return getPersistence().fetchByIdDocumentale(idDocumentale);
	}

	/**
	 * Returns the allegato richiesta where idDocumentale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idDocumentale the id documentale
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByIdDocumentale(
		String idDocumentale, boolean useFinderCache) {

		return getPersistence().fetchByIdDocumentale(
			idDocumentale, useFinderCache);
	}

	/**
	 * Removes the allegato richiesta where idDocumentale = &#63; from the database.
	 *
	 * @param idDocumentale the id documentale
	 * @return the allegato richiesta that was removed
	 */
	public static AllegatoRichiesta removeByIdDocumentale(String idDocumentale)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().removeByIdDocumentale(idDocumentale);
	}

	/**
	 * Returns the number of allegato richiestas where idDocumentale = &#63;.
	 *
	 * @param idDocumentale the id documentale
	 * @return the number of matching allegato richiestas
	 */
	public static int countByIdDocumentale(String idDocumentale) {
		return getPersistence().countByIdDocumentale(idDocumentale);
	}

	/**
	 * Returns the allegato richiesta where url = &#63; or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param url the url
	 * @return the matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByUrl(String url)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByUrl(url);
	}

	/**
	 * Returns the allegato richiesta where url = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param url the url
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByUrl(String url) {
		return getPersistence().fetchByUrl(url);
	}

	/**
	 * Returns the allegato richiesta where url = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param url the url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByUrl(
		String url, boolean useFinderCache) {

		return getPersistence().fetchByUrl(url, useFinderCache);
	}

	/**
	 * Removes the allegato richiesta where url = &#63; from the database.
	 *
	 * @param url the url
	 * @return the allegato richiesta that was removed
	 */
	public static AllegatoRichiesta removeByUrl(String url)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().removeByUrl(url);
	}

	/**
	 * Returns the number of allegato richiestas where url = &#63;.
	 *
	 * @param url the url
	 * @return the number of matching allegato richiestas
	 */
	public static int countByUrl(String url) {
		return getPersistence().countByUrl(url);
	}

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and principale = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @return the matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdPrincipale(
		long richiestaId, boolean principale) {

		return getPersistence().findByRichiestaIdPrincipale(
			richiestaId, principale);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and principale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdPrincipale(
		long richiestaId, boolean principale, int start, int end) {

		return getPersistence().findByRichiestaIdPrincipale(
			richiestaId, principale, start, end);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and principale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdPrincipale(
		long richiestaId, boolean principale, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().findByRichiestaIdPrincipale(
			richiestaId, principale, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and principale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdPrincipale(
		long richiestaId, boolean principale, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRichiestaIdPrincipale(
			richiestaId, principale, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and principale = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByRichiestaIdPrincipale_First(
			long richiestaId, boolean principale,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaIdPrincipale_First(
			richiestaId, principale, orderByComparator);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and principale = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByRichiestaIdPrincipale_First(
		long richiestaId, boolean principale,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaIdPrincipale_First(
			richiestaId, principale, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and principale = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByRichiestaIdPrincipale_Last(
			long richiestaId, boolean principale,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaIdPrincipale_Last(
			richiestaId, principale, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and principale = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByRichiestaIdPrincipale_Last(
		long richiestaId, boolean principale,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaIdPrincipale_Last(
			richiestaId, principale, orderByComparator);
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and principale = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public static AllegatoRichiesta[] findByRichiestaIdPrincipale_PrevAndNext(
			long allegatoRichiestaId, long richiestaId, boolean principale,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaIdPrincipale_PrevAndNext(
			allegatoRichiestaId, richiestaId, principale, orderByComparator);
	}

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; and principale = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 */
	public static void removeByRichiestaIdPrincipale(
		long richiestaId, boolean principale) {

		getPersistence().removeByRichiestaIdPrincipale(richiestaId, principale);
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and principale = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @return the number of matching allegato richiestas
	 */
	public static int countByRichiestaIdPrincipale(
		long richiestaId, boolean principale) {

		return getPersistence().countByRichiestaIdPrincipale(
			richiestaId, principale);
	}

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaId(long richiestaId) {
		return getPersistence().findByRichiestaId(richiestaId);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end) {

		return getPersistence().findByRichiestaId(richiestaId, start, end);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().findByRichiestaId(
			richiestaId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRichiestaId(
			richiestaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByRichiestaId_First(
			long richiestaId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaId_First(
			richiestaId, orderByComparator);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByRichiestaId_First(
		long richiestaId,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaId_First(
			richiestaId, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByRichiestaId_Last(
			long richiestaId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaId_Last(
			richiestaId, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByRichiestaId_Last(
		long richiestaId,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaId_Last(
			richiestaId, orderByComparator);
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public static AllegatoRichiesta[] findByRichiestaId_PrevAndNext(
			long allegatoRichiestaId, long richiestaId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaId_PrevAndNext(
			allegatoRichiestaId, richiestaId, orderByComparator);
	}

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 */
	public static void removeByRichiestaId(long richiestaId) {
		getPersistence().removeByRichiestaId(richiestaId);
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching allegato richiestas
	 */
	public static int countByRichiestaId(long richiestaId) {
		return getPersistence().countByRichiestaId(richiestaId);
	}

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @return the matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdInterno(
		long richiestaId, boolean interno) {

		return getPersistence().findByRichiestaIdInterno(richiestaId, interno);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and interno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdInterno(
		long richiestaId, boolean interno, int start, int end) {

		return getPersistence().findByRichiestaIdInterno(
			richiestaId, interno, start, end);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and interno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdInterno(
		long richiestaId, boolean interno, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().findByRichiestaIdInterno(
			richiestaId, interno, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and interno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdInterno(
		long richiestaId, boolean interno, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRichiestaIdInterno(
			richiestaId, interno, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByRichiestaIdInterno_First(
			long richiestaId, boolean interno,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaIdInterno_First(
			richiestaId, interno, orderByComparator);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByRichiestaIdInterno_First(
		long richiestaId, boolean interno,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaIdInterno_First(
			richiestaId, interno, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByRichiestaIdInterno_Last(
			long richiestaId, boolean interno,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaIdInterno_Last(
			richiestaId, interno, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByRichiestaIdInterno_Last(
		long richiestaId, boolean interno,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaIdInterno_Last(
			richiestaId, interno, orderByComparator);
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public static AllegatoRichiesta[] findByRichiestaIdInterno_PrevAndNext(
			long allegatoRichiestaId, long richiestaId, boolean interno,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaIdInterno_PrevAndNext(
			allegatoRichiestaId, richiestaId, interno, orderByComparator);
	}

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; and interno = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 */
	public static void removeByRichiestaIdInterno(
		long richiestaId, boolean interno) {

		getPersistence().removeByRichiestaIdInterno(richiestaId, interno);
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @return the number of matching allegato richiestas
	 */
	public static int countByRichiestaIdInterno(
		long richiestaId, boolean interno) {

		return getPersistence().countByRichiestaIdInterno(richiestaId, interno);
	}

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @return the matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile) {

		return getPersistence().findByRichiestaIdVisibile(
			richiestaId, visibile);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end) {

		return getPersistence().findByRichiestaIdVisibile(
			richiestaId, visibile, start, end);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().findByRichiestaIdVisibile(
			richiestaId, visibile, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRichiestaIdVisibile(
			richiestaId, visibile, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByRichiestaIdVisibile_First(
			long richiestaId, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaIdVisibile_First(
			richiestaId, visibile, orderByComparator);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByRichiestaIdVisibile_First(
		long richiestaId, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaIdVisibile_First(
			richiestaId, visibile, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByRichiestaIdVisibile_Last(
			long richiestaId, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaIdVisibile_Last(
			richiestaId, visibile, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByRichiestaIdVisibile_Last(
		long richiestaId, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaIdVisibile_Last(
			richiestaId, visibile, orderByComparator);
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public static AllegatoRichiesta[] findByRichiestaIdVisibile_PrevAndNext(
			long allegatoRichiestaId, long richiestaId, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaIdVisibile_PrevAndNext(
			allegatoRichiestaId, richiestaId, visibile, orderByComparator);
	}

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; and visibile = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 */
	public static void removeByRichiestaIdVisibile(
		long richiestaId, boolean visibile) {

		getPersistence().removeByRichiestaIdVisibile(richiestaId, visibile);
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @return the number of matching allegato richiestas
	 */
	public static int countByRichiestaIdVisibile(
		long richiestaId, boolean visibile) {

		return getPersistence().countByRichiestaIdVisibile(
			richiestaId, visibile);
	}

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @return the matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdInternoVisibile(
		long richiestaId, boolean interno, boolean visibile) {

		return getPersistence().findByRichiestaIdInternoVisibile(
			richiestaId, interno, visibile);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdInternoVisibile(
		long richiestaId, boolean interno, boolean visibile, int start,
		int end) {

		return getPersistence().findByRichiestaIdInternoVisibile(
			richiestaId, interno, visibile, start, end);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdInternoVisibile(
		long richiestaId, boolean interno, boolean visibile, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().findByRichiestaIdInternoVisibile(
			richiestaId, interno, visibile, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public static List<AllegatoRichiesta> findByRichiestaIdInternoVisibile(
		long richiestaId, boolean interno, boolean visibile, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRichiestaIdInternoVisibile(
			richiestaId, interno, visibile, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByRichiestaIdInternoVisibile_First(
			long richiestaId, boolean interno, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaIdInternoVisibile_First(
			richiestaId, interno, visibile, orderByComparator);
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByRichiestaIdInternoVisibile_First(
		long richiestaId, boolean interno, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaIdInternoVisibile_First(
			richiestaId, interno, visibile, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta findByRichiestaIdInternoVisibile_Last(
			long richiestaId, boolean interno, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaIdInternoVisibile_Last(
			richiestaId, interno, visibile, orderByComparator);
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchByRichiestaIdInternoVisibile_Last(
		long richiestaId, boolean interno, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().fetchByRichiestaIdInternoVisibile_Last(
			richiestaId, interno, visibile, orderByComparator);
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public static AllegatoRichiesta[]
			findByRichiestaIdInternoVisibile_PrevAndNext(
				long allegatoRichiestaId, long richiestaId, boolean interno,
				boolean visibile,
				OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByRichiestaIdInternoVisibile_PrevAndNext(
			allegatoRichiestaId, richiestaId, interno, visibile,
			orderByComparator);
	}

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; and interno = &#63; and visibile = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 */
	public static void removeByRichiestaIdInternoVisibile(
		long richiestaId, boolean interno, boolean visibile) {

		getPersistence().removeByRichiestaIdInternoVisibile(
			richiestaId, interno, visibile);
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @return the number of matching allegato richiestas
	 */
	public static int countByRichiestaIdInternoVisibile(
		long richiestaId, boolean interno, boolean visibile) {

		return getPersistence().countByRichiestaIdInternoVisibile(
			richiestaId, interno, visibile);
	}

	/**
	 * Caches the allegato richiesta in the entity cache if it is enabled.
	 *
	 * @param allegatoRichiesta the allegato richiesta
	 */
	public static void cacheResult(AllegatoRichiesta allegatoRichiesta) {
		getPersistence().cacheResult(allegatoRichiesta);
	}

	/**
	 * Caches the allegato richiestas in the entity cache if it is enabled.
	 *
	 * @param allegatoRichiestas the allegato richiestas
	 */
	public static void cacheResult(List<AllegatoRichiesta> allegatoRichiestas) {
		getPersistence().cacheResult(allegatoRichiestas);
	}

	/**
	 * Creates a new allegato richiesta with the primary key. Does not add the allegato richiesta to the database.
	 *
	 * @param allegatoRichiestaId the primary key for the new allegato richiesta
	 * @return the new allegato richiesta
	 */
	public static AllegatoRichiesta create(long allegatoRichiestaId) {
		return getPersistence().create(allegatoRichiestaId);
	}

	/**
	 * Removes the allegato richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allegatoRichiestaId the primary key of the allegato richiesta
	 * @return the allegato richiesta that was removed
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public static AllegatoRichiesta remove(long allegatoRichiestaId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().remove(allegatoRichiestaId);
	}

	public static AllegatoRichiesta updateImpl(
		AllegatoRichiesta allegatoRichiesta) {

		return getPersistence().updateImpl(allegatoRichiesta);
	}

	/**
	 * Returns the allegato richiesta with the primary key or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param allegatoRichiestaId the primary key of the allegato richiesta
	 * @return the allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public static AllegatoRichiesta findByPrimaryKey(long allegatoRichiestaId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchAllegatoRichiestaException {

		return getPersistence().findByPrimaryKey(allegatoRichiestaId);
	}

	/**
	 * Returns the allegato richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allegatoRichiestaId the primary key of the allegato richiesta
	 * @return the allegato richiesta, or <code>null</code> if a allegato richiesta with the primary key could not be found
	 */
	public static AllegatoRichiesta fetchByPrimaryKey(
		long allegatoRichiestaId) {

		return getPersistence().fetchByPrimaryKey(allegatoRichiestaId);
	}

	/**
	 * Returns all the allegato richiestas.
	 *
	 * @return the allegato richiestas
	 */
	public static List<AllegatoRichiesta> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the allegato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of allegato richiestas
	 */
	public static List<AllegatoRichiesta> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allegato richiestas
	 */
	public static List<AllegatoRichiesta> findAll(
		int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of allegato richiestas
	 */
	public static List<AllegatoRichiesta> findAll(
		int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the allegato richiestas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of allegato richiestas.
	 *
	 * @return the number of allegato richiestas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AllegatoRichiestaPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AllegatoRichiestaPersistence _persistence;

}