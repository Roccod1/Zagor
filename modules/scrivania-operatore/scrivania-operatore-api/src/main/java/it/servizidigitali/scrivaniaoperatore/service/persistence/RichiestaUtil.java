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

import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the richiesta service. This utility wraps <code>it.servizidigitali.scrivaniaoperatore.service.persistence.impl.RichiestaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaPersistence
 * @generated
 */
public class RichiestaUtil {

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
	public static void clearCache(Richiesta richiesta) {
		getPersistence().clearCache(richiesta);
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
	public static Map<Serializable, Richiesta> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Richiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Richiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Richiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Richiesta update(Richiesta richiesta) {
		return getPersistence().update(richiesta);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Richiesta update(
		Richiesta richiesta, ServiceContext serviceContext) {

		return getPersistence().update(richiesta, serviceContext);
	}

	/**
	 * Returns all the richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching richiestas
	 */
	public static List<Richiesta> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public static List<Richiesta> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByUuid_First(
			String uuid, OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByUuid_First(
		String uuid, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByUuid_Last(
			String uuid, OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByUuid_Last(
		String uuid, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public static Richiesta[] findByUuid_PrevAndNext(
			long richiestaId, String uuid,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByUuid_PrevAndNext(
			richiestaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the richiestas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching richiestas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the richiesta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRichiestaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the richiesta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the richiesta that was removed
	 */
	public static Richiesta removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of richiestas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching richiestas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching richiestas
	 */
	public static List<Richiesta> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public static List<Richiesta> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public static Richiesta[] findByUuid_C_PrevAndNext(
			long richiestaId, String uuid, long companyId,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			richiestaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the richiestas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching richiestas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the richiestas where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the matching richiestas
	 */
	public static List<Richiesta> findByCodiceFiscale(String codiceFiscale) {
		return getPersistence().findByCodiceFiscale(codiceFiscale);
	}

	/**
	 * Returns a range of all the richiestas where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public static List<Richiesta> findByCodiceFiscale(
		String codiceFiscale, int start, int end) {

		return getPersistence().findByCodiceFiscale(codiceFiscale, start, end);
	}

	/**
	 * Returns an ordered range of all the richiestas where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByCodiceFiscale(
		String codiceFiscale, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().findByCodiceFiscale(
			codiceFiscale, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiestas where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByCodiceFiscale(
		String codiceFiscale, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCodiceFiscale(
			codiceFiscale, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByCodiceFiscale_First(
			String codiceFiscale,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByCodiceFiscale_First(
			codiceFiscale, orderByComparator);
	}

	/**
	 * Returns the first richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByCodiceFiscale_First(
		String codiceFiscale, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByCodiceFiscale_First(
			codiceFiscale, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByCodiceFiscale_Last(
			String codiceFiscale,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByCodiceFiscale_Last(
			codiceFiscale, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByCodiceFiscale_Last(
		String codiceFiscale, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByCodiceFiscale_Last(
			codiceFiscale, orderByComparator);
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public static Richiesta[] findByCodiceFiscale_PrevAndNext(
			long richiestaId, String codiceFiscale,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByCodiceFiscale_PrevAndNext(
			richiestaId, codiceFiscale, orderByComparator);
	}

	/**
	 * Removes all the richiestas where codiceFiscale = &#63; from the database.
	 *
	 * @param codiceFiscale the codice fiscale
	 */
	public static void removeByCodiceFiscale(String codiceFiscale) {
		getPersistence().removeByCodiceFiscale(codiceFiscale);
	}

	/**
	 * Returns the number of richiestas where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the number of matching richiestas
	 */
	public static int countByCodiceFiscale(String codiceFiscale) {
		return getPersistence().countByCodiceFiscale(codiceFiscale);
	}

	/**
	 * Returns all the richiestas where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @return the matching richiestas
	 */
	public static List<Richiesta> findByPartitaIva(String partitaIva) {
		return getPersistence().findByPartitaIva(partitaIva);
	}

	/**
	 * Returns a range of all the richiestas where partitaIva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param partitaIva the partita iva
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public static List<Richiesta> findByPartitaIva(
		String partitaIva, int start, int end) {

		return getPersistence().findByPartitaIva(partitaIva, start, end);
	}

	/**
	 * Returns an ordered range of all the richiestas where partitaIva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param partitaIva the partita iva
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByPartitaIva(
		String partitaIva, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().findByPartitaIva(
			partitaIva, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiestas where partitaIva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param partitaIva the partita iva
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByPartitaIva(
		String partitaIva, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPartitaIva(
			partitaIva, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByPartitaIva_First(
			String partitaIva, OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByPartitaIva_First(
			partitaIva, orderByComparator);
	}

	/**
	 * Returns the first richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByPartitaIva_First(
		String partitaIva, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByPartitaIva_First(
			partitaIva, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByPartitaIva_Last(
			String partitaIva, OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByPartitaIva_Last(
			partitaIva, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByPartitaIva_Last(
		String partitaIva, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByPartitaIva_Last(
			partitaIva, orderByComparator);
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public static Richiesta[] findByPartitaIva_PrevAndNext(
			long richiestaId, String partitaIva,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByPartitaIva_PrevAndNext(
			richiestaId, partitaIva, orderByComparator);
	}

	/**
	 * Removes all the richiestas where partitaIva = &#63; from the database.
	 *
	 * @param partitaIva the partita iva
	 */
	public static void removeByPartitaIva(String partitaIva) {
		getPersistence().removeByPartitaIva(partitaIva);
	}

	/**
	 * Returns the number of richiestas where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @return the number of matching richiestas
	 */
	public static int countByPartitaIva(String partitaIva) {
		return getPersistence().countByPartitaIva(partitaIva);
	}

	/**
	 * Returns all the richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @return the matching richiestas
	 */
	public static List<Richiesta> findByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato) {

		return getPersistence().findByCodiceFiscaleDelegato(
			codiceFiscaleDelegato);
	}

	/**
	 * Returns a range of all the richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public static List<Richiesta> findByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato, int start, int end) {

		return getPersistence().findByCodiceFiscaleDelegato(
			codiceFiscaleDelegato, start, end);
	}

	/**
	 * Returns an ordered range of all the richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().findByCodiceFiscaleDelegato(
			codiceFiscaleDelegato, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCodiceFiscaleDelegato(
			codiceFiscaleDelegato, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByCodiceFiscaleDelegato_First(
			String codiceFiscaleDelegato,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByCodiceFiscaleDelegato_First(
			codiceFiscaleDelegato, orderByComparator);
	}

	/**
	 * Returns the first richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByCodiceFiscaleDelegato_First(
		String codiceFiscaleDelegato,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByCodiceFiscaleDelegato_First(
			codiceFiscaleDelegato, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByCodiceFiscaleDelegato_Last(
			String codiceFiscaleDelegato,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByCodiceFiscaleDelegato_Last(
			codiceFiscaleDelegato, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByCodiceFiscaleDelegato_Last(
		String codiceFiscaleDelegato,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByCodiceFiscaleDelegato_Last(
			codiceFiscaleDelegato, orderByComparator);
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public static Richiesta[] findByCodiceFiscaleDelegato_PrevAndNext(
			long richiestaId, String codiceFiscaleDelegato,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByCodiceFiscaleDelegato_PrevAndNext(
			richiestaId, codiceFiscaleDelegato, orderByComparator);
	}

	/**
	 * Removes all the richiestas where codiceFiscaleDelegato = &#63; from the database.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 */
	public static void removeByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato) {

		getPersistence().removeByCodiceFiscaleDelegato(codiceFiscaleDelegato);
	}

	/**
	 * Returns the number of richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @return the number of matching richiestas
	 */
	public static int countByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato) {

		return getPersistence().countByCodiceFiscaleDelegato(
			codiceFiscaleDelegato);
	}

	/**
	 * Returns all the richiestas where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching richiestas
	 */
	public static List<Richiesta> findByStato(String stato) {
		return getPersistence().findByStato(stato);
	}

	/**
	 * Returns a range of all the richiestas where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public static List<Richiesta> findByStato(
		String stato, int start, int end) {

		return getPersistence().findByStato(stato, start, end);
	}

	/**
	 * Returns an ordered range of all the richiestas where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByStato(
		String stato, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().findByStato(
			stato, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiestas where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByStato(
		String stato, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStato(
			stato, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByStato_First(
			String stato, OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByStato_First(stato, orderByComparator);
	}

	/**
	 * Returns the first richiesta in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByStato_First(
		String stato, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByStato_First(stato, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByStato_Last(
			String stato, OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByStato_Last(stato, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByStato_Last(
		String stato, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByStato_Last(stato, orderByComparator);
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where stato = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public static Richiesta[] findByStato_PrevAndNext(
			long richiestaId, String stato,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByStato_PrevAndNext(
			richiestaId, stato, orderByComparator);
	}

	/**
	 * Removes all the richiestas where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	public static void removeByStato(String stato) {
		getPersistence().removeByStato(stato);
	}

	/**
	 * Returns the number of richiestas where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching richiestas
	 */
	public static int countByStato(String stato) {
		return getPersistence().countByStato(stato);
	}

	/**
	 * Returns all the richiestas where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @return the matching richiestas
	 */
	public static List<Richiesta> findByInvioGuest(boolean invioGuest) {
		return getPersistence().findByInvioGuest(invioGuest);
	}

	/**
	 * Returns a range of all the richiestas where invioGuest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param invioGuest the invio guest
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public static List<Richiesta> findByInvioGuest(
		boolean invioGuest, int start, int end) {

		return getPersistence().findByInvioGuest(invioGuest, start, end);
	}

	/**
	 * Returns an ordered range of all the richiestas where invioGuest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param invioGuest the invio guest
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByInvioGuest(
		boolean invioGuest, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().findByInvioGuest(
			invioGuest, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiestas where invioGuest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param invioGuest the invio guest
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByInvioGuest(
		boolean invioGuest, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByInvioGuest(
			invioGuest, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByInvioGuest_First(
			boolean invioGuest, OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByInvioGuest_First(
			invioGuest, orderByComparator);
	}

	/**
	 * Returns the first richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByInvioGuest_First(
		boolean invioGuest, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByInvioGuest_First(
			invioGuest, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByInvioGuest_Last(
			boolean invioGuest, OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByInvioGuest_Last(
			invioGuest, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByInvioGuest_Last(
		boolean invioGuest, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByInvioGuest_Last(
			invioGuest, orderByComparator);
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public static Richiesta[] findByInvioGuest_PrevAndNext(
			long richiestaId, boolean invioGuest,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByInvioGuest_PrevAndNext(
			richiestaId, invioGuest, orderByComparator);
	}

	/**
	 * Removes all the richiestas where invioGuest = &#63; from the database.
	 *
	 * @param invioGuest the invio guest
	 */
	public static void removeByInvioGuest(boolean invioGuest) {
		getPersistence().removeByInvioGuest(invioGuest);
	}

	/**
	 * Returns the number of richiestas where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @return the number of matching richiestas
	 */
	public static int countByInvioGuest(boolean invioGuest) {
		return getPersistence().countByInvioGuest(invioGuest);
	}

	/**
	 * Returns the richiesta where tokenVisualizzazione = &#63; or throws a <code>NoSuchRichiestaException</code> if it could not be found.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @return the matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByTokenVisualizzazione(
			String tokenVisualizzazione)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByTokenVisualizzazione(
			tokenVisualizzazione);
	}

	/**
	 * Returns the richiesta where tokenVisualizzazione = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByTokenVisualizzazione(
		String tokenVisualizzazione) {

		return getPersistence().fetchByTokenVisualizzazione(
			tokenVisualizzazione);
	}

	/**
	 * Returns the richiesta where tokenVisualizzazione = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByTokenVisualizzazione(
		String tokenVisualizzazione, boolean useFinderCache) {

		return getPersistence().fetchByTokenVisualizzazione(
			tokenVisualizzazione, useFinderCache);
	}

	/**
	 * Removes the richiesta where tokenVisualizzazione = &#63; from the database.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @return the richiesta that was removed
	 */
	public static Richiesta removeByTokenVisualizzazione(
			String tokenVisualizzazione)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().removeByTokenVisualizzazione(
			tokenVisualizzazione);
	}

	/**
	 * Returns the number of richiestas where tokenVisualizzazione = &#63;.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @return the number of matching richiestas
	 */
	public static int countByTokenVisualizzazione(String tokenVisualizzazione) {
		return getPersistence().countByTokenVisualizzazione(
			tokenVisualizzazione);
	}

	/**
	 * Returns all the richiestas where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the matching richiestas
	 */
	public static List<Richiesta> findByProceduraId(long proceduraId) {
		return getPersistence().findByProceduraId(proceduraId);
	}

	/**
	 * Returns a range of all the richiestas where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public static List<Richiesta> findByProceduraId(
		long proceduraId, int start, int end) {

		return getPersistence().findByProceduraId(proceduraId, start, end);
	}

	/**
	 * Returns an ordered range of all the richiestas where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByProceduraId(
		long proceduraId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().findByProceduraId(
			proceduraId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiestas where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByProceduraId(
		long proceduraId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProceduraId(
			proceduraId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByProceduraId_First(
			long proceduraId, OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByProceduraId_First(
			proceduraId, orderByComparator);
	}

	/**
	 * Returns the first richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByProceduraId_First(
		long proceduraId, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByProceduraId_First(
			proceduraId, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByProceduraId_Last(
			long proceduraId, OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByProceduraId_Last(
			proceduraId, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByProceduraId_Last(
		long proceduraId, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByProceduraId_Last(
			proceduraId, orderByComparator);
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public static Richiesta[] findByProceduraId_PrevAndNext(
			long richiestaId, long proceduraId,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByProceduraId_PrevAndNext(
			richiestaId, proceduraId, orderByComparator);
	}

	/**
	 * Removes all the richiestas where proceduraId = &#63; from the database.
	 *
	 * @param proceduraId the procedura ID
	 */
	public static void removeByProceduraId(long proceduraId) {
		getPersistence().removeByProceduraId(proceduraId);
	}

	/**
	 * Returns the number of richiestas where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the number of matching richiestas
	 */
	public static int countByProceduraId(long proceduraId) {
		return getPersistence().countByProceduraId(proceduraId);
	}

	/**
	 * Returns all the richiestas where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the matching richiestas
	 */
	public static List<Richiesta> findByServizioId(long servizioId) {
		return getPersistence().findByServizioId(servizioId);
	}

	/**
	 * Returns a range of all the richiestas where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public static List<Richiesta> findByServizioId(
		long servizioId, int start, int end) {

		return getPersistence().findByServizioId(servizioId, start, end);
	}

	/**
	 * Returns an ordered range of all the richiestas where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().findByServizioId(
			servizioId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiestas where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public static List<Richiesta> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByServizioId(
			servizioId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByServizioId_First(
			long servizioId, OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByServizioId_First(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the first richiesta in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByServizioId_First(
		long servizioId, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByServizioId_First(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByServizioId_Last(
			long servizioId, OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByServizioId_Last(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the last richiesta in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByServizioId_Last(
		long servizioId, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().fetchByServizioId_Last(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where servizioId = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public static Richiesta[] findByServizioId_PrevAndNext(
			long richiestaId, long servizioId,
			OrderByComparator<Richiesta> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByServizioId_PrevAndNext(
			richiestaId, servizioId, orderByComparator);
	}

	/**
	 * Removes all the richiestas where servizioId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 */
	public static void removeByServizioId(long servizioId) {
		getPersistence().removeByServizioId(servizioId);
	}

	/**
	 * Returns the number of richiestas where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the number of matching richiestas
	 */
	public static int countByServizioId(long servizioId) {
		return getPersistence().countByServizioId(servizioId);
	}

	/**
	 * Returns the richiesta where processInstanceId = &#63; or throws a <code>NoSuchRichiestaException</code> if it could not be found.
	 *
	 * @param processInstanceId the process instance ID
	 * @return the matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public static Richiesta findByProcessInstanceId(String processInstanceId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByProcessInstanceId(processInstanceId);
	}

	/**
	 * Returns the richiesta where processInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param processInstanceId the process instance ID
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByProcessInstanceId(String processInstanceId) {
		return getPersistence().fetchByProcessInstanceId(processInstanceId);
	}

	/**
	 * Returns the richiesta where processInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param processInstanceId the process instance ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchByProcessInstanceId(
		String processInstanceId, boolean useFinderCache) {

		return getPersistence().fetchByProcessInstanceId(
			processInstanceId, useFinderCache);
	}

	/**
	 * Removes the richiesta where processInstanceId = &#63; from the database.
	 *
	 * @param processInstanceId the process instance ID
	 * @return the richiesta that was removed
	 */
	public static Richiesta removeByProcessInstanceId(String processInstanceId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().removeByProcessInstanceId(processInstanceId);
	}

	/**
	 * Returns the number of richiestas where processInstanceId = &#63;.
	 *
	 * @param processInstanceId the process instance ID
	 * @return the number of matching richiestas
	 */
	public static int countByProcessInstanceId(String processInstanceId) {
		return getPersistence().countByProcessInstanceId(processInstanceId);
	}

	/**
	 * Caches the richiesta in the entity cache if it is enabled.
	 *
	 * @param richiesta the richiesta
	 */
	public static void cacheResult(Richiesta richiesta) {
		getPersistence().cacheResult(richiesta);
	}

	/**
	 * Caches the richiestas in the entity cache if it is enabled.
	 *
	 * @param richiestas the richiestas
	 */
	public static void cacheResult(List<Richiesta> richiestas) {
		getPersistence().cacheResult(richiestas);
	}

	/**
	 * Creates a new richiesta with the primary key. Does not add the richiesta to the database.
	 *
	 * @param richiestaId the primary key for the new richiesta
	 * @return the new richiesta
	 */
	public static Richiesta create(long richiestaId) {
		return getPersistence().create(richiestaId);
	}

	/**
	 * Removes the richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta that was removed
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public static Richiesta remove(long richiestaId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().remove(richiestaId);
	}

	public static Richiesta updateImpl(Richiesta richiesta) {
		return getPersistence().updateImpl(richiesta);
	}

	/**
	 * Returns the richiesta with the primary key or throws a <code>NoSuchRichiestaException</code> if it could not be found.
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public static Richiesta findByPrimaryKey(long richiestaId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		return getPersistence().findByPrimaryKey(richiestaId);
	}

	/**
	 * Returns the richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta, or <code>null</code> if a richiesta with the primary key could not be found
	 */
	public static Richiesta fetchByPrimaryKey(long richiestaId) {
		return getPersistence().fetchByPrimaryKey(richiestaId);
	}

	/**
	 * Returns all the richiestas.
	 *
	 * @return the richiestas
	 */
	public static List<Richiesta> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of richiestas
	 */
	public static List<Richiesta> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiestas
	 */
	public static List<Richiesta> findAll(
		int start, int end, OrderByComparator<Richiesta> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of richiestas
	 */
	public static List<Richiesta> findAll(
		int start, int end, OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the richiestas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of richiestas.
	 *
	 * @return the number of richiestas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RichiestaPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RichiestaPersistence _persistence;

}