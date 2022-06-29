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

package it.servizidigitali.gestioneservizi.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneservizi.model.Tipologia;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the tipologia service. This utility wraps <code>it.servizidigitali.gestioneservizi.service.persistence.impl.TipologiaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaPersistence
 * @generated
 */
public class TipologiaUtil {

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
	public static void clearCache(Tipologia tipologia) {
		getPersistence().clearCache(tipologia);
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
	public static Map<Serializable, Tipologia> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Tipologia> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Tipologia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Tipologia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Tipologia> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Tipologia update(Tipologia tipologia) {
		return getPersistence().update(tipologia);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Tipologia update(
		Tipologia tipologia, ServiceContext serviceContext) {

		return getPersistence().update(tipologia, serviceContext);
	}

	/**
	 * Returns all the tipologias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tipologias
	 */
	public static List<Tipologia> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the tipologias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of matching tipologias
	 */
	public static List<Tipologia> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the tipologias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipologias
	 */
	public static List<Tipologia> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Tipologia> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipologias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipologias
	 */
	public static List<Tipologia> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Tipologia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public static Tipologia findByUuid_First(
			String uuid, OrderByComparator<Tipologia> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public static Tipologia fetchByUuid_First(
		String uuid, OrderByComparator<Tipologia> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public static Tipologia findByUuid_Last(
			String uuid, OrderByComparator<Tipologia> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public static Tipologia fetchByUuid_Last(
		String uuid, OrderByComparator<Tipologia> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the tipologias before and after the current tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param tipologiaId the primary key of the current tipologia
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	public static Tipologia[] findByUuid_PrevAndNext(
			long tipologiaId, String uuid,
			OrderByComparator<Tipologia> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().findByUuid_PrevAndNext(
			tipologiaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the tipologias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of tipologias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tipologias
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the tipologia where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTipologiaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public static Tipologia findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the tipologia where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public static Tipologia fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the tipologia where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public static Tipologia fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the tipologia where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tipologia that was removed
	 */
	public static Tipologia removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of tipologias where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tipologias
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tipologias
	 */
	public static List<Tipologia> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of matching tipologias
	 */
	public static List<Tipologia> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipologias
	 */
	public static List<Tipologia> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Tipologia> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipologias
	 */
	public static List<Tipologia> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Tipologia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public static Tipologia findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Tipologia> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public static Tipologia fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Tipologia> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public static Tipologia findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Tipologia> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public static Tipologia fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Tipologia> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the tipologias before and after the current tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param tipologiaId the primary key of the current tipologia
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	public static Tipologia[] findByUuid_C_PrevAndNext(
			long tipologiaId, String uuid, long companyId,
			OrderByComparator<Tipologia> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			tipologiaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the tipologias where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tipologias
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the tipologias where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @return the matching tipologias
	 */
	public static List<Tipologia> findByVisibile(boolean visibile) {
		return getPersistence().findByVisibile(visibile);
	}

	/**
	 * Returns a range of all the tipologias where visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param visibile the visibile
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of matching tipologias
	 */
	public static List<Tipologia> findByVisibile(
		boolean visibile, int start, int end) {

		return getPersistence().findByVisibile(visibile, start, end);
	}

	/**
	 * Returns an ordered range of all the tipologias where visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param visibile the visibile
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipologias
	 */
	public static List<Tipologia> findByVisibile(
		boolean visibile, int start, int end,
		OrderByComparator<Tipologia> orderByComparator) {

		return getPersistence().findByVisibile(
			visibile, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipologias where visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param visibile the visibile
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipologias
	 */
	public static List<Tipologia> findByVisibile(
		boolean visibile, int start, int end,
		OrderByComparator<Tipologia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVisibile(
			visibile, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public static Tipologia findByVisibile_First(
			boolean visibile, OrderByComparator<Tipologia> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().findByVisibile_First(
			visibile, orderByComparator);
	}

	/**
	 * Returns the first tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public static Tipologia fetchByVisibile_First(
		boolean visibile, OrderByComparator<Tipologia> orderByComparator) {

		return getPersistence().fetchByVisibile_First(
			visibile, orderByComparator);
	}

	/**
	 * Returns the last tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public static Tipologia findByVisibile_Last(
			boolean visibile, OrderByComparator<Tipologia> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().findByVisibile_Last(
			visibile, orderByComparator);
	}

	/**
	 * Returns the last tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public static Tipologia fetchByVisibile_Last(
		boolean visibile, OrderByComparator<Tipologia> orderByComparator) {

		return getPersistence().fetchByVisibile_Last(
			visibile, orderByComparator);
	}

	/**
	 * Returns the tipologias before and after the current tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param tipologiaId the primary key of the current tipologia
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	public static Tipologia[] findByVisibile_PrevAndNext(
			long tipologiaId, boolean visibile,
			OrderByComparator<Tipologia> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().findByVisibile_PrevAndNext(
			tipologiaId, visibile, orderByComparator);
	}

	/**
	 * Removes all the tipologias where visibile = &#63; from the database.
	 *
	 * @param visibile the visibile
	 */
	public static void removeByVisibile(boolean visibile) {
		getPersistence().removeByVisibile(visibile);
	}

	/**
	 * Returns the number of tipologias where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @return the number of matching tipologias
	 */
	public static int countByVisibile(boolean visibile) {
		return getPersistence().countByVisibile(visibile);
	}

	/**
	 * Caches the tipologia in the entity cache if it is enabled.
	 *
	 * @param tipologia the tipologia
	 */
	public static void cacheResult(Tipologia tipologia) {
		getPersistence().cacheResult(tipologia);
	}

	/**
	 * Caches the tipologias in the entity cache if it is enabled.
	 *
	 * @param tipologias the tipologias
	 */
	public static void cacheResult(List<Tipologia> tipologias) {
		getPersistence().cacheResult(tipologias);
	}

	/**
	 * Creates a new tipologia with the primary key. Does not add the tipologia to the database.
	 *
	 * @param tipologiaId the primary key for the new tipologia
	 * @return the new tipologia
	 */
	public static Tipologia create(long tipologiaId) {
		return getPersistence().create(tipologiaId);
	}

	/**
	 * Removes the tipologia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia that was removed
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	public static Tipologia remove(long tipologiaId)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().remove(tipologiaId);
	}

	public static Tipologia updateImpl(Tipologia tipologia) {
		return getPersistence().updateImpl(tipologia);
	}

	/**
	 * Returns the tipologia with the primary key or throws a <code>NoSuchTipologiaException</code> if it could not be found.
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	public static Tipologia findByPrimaryKey(long tipologiaId)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchTipologiaException {

		return getPersistence().findByPrimaryKey(tipologiaId);
	}

	/**
	 * Returns the tipologia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia, or <code>null</code> if a tipologia with the primary key could not be found
	 */
	public static Tipologia fetchByPrimaryKey(long tipologiaId) {
		return getPersistence().fetchByPrimaryKey(tipologiaId);
	}

	/**
	 * Returns all the tipologias.
	 *
	 * @return the tipologias
	 */
	public static List<Tipologia> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the tipologias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of tipologias
	 */
	public static List<Tipologia> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the tipologias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipologias
	 */
	public static List<Tipologia> findAll(
		int start, int end, OrderByComparator<Tipologia> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipologias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tipologias
	 */
	public static List<Tipologia> findAll(
		int start, int end, OrderByComparator<Tipologia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the tipologias from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of tipologias.
	 *
	 * @return the number of tipologias
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of servizios associated with the tipologia.
	 *
	 * @param pk the primary key of the tipologia
	 * @return long[] of the primaryKeys of servizios associated with the tipologia
	 */
	public static long[] getServizioPrimaryKeys(long pk) {
		return getPersistence().getServizioPrimaryKeys(pk);
	}

	/**
	 * Returns all the tipologia associated with the servizio.
	 *
	 * @param pk the primary key of the servizio
	 * @return the tipologias associated with the servizio
	 */
	public static List<Tipologia> getServizioTipologias(long pk) {
		return getPersistence().getServizioTipologias(pk);
	}

	/**
	 * Returns all the tipologia associated with the servizio.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the servizio
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of tipologias associated with the servizio
	 */
	public static List<Tipologia> getServizioTipologias(
		long pk, int start, int end) {

		return getPersistence().getServizioTipologias(pk, start, end);
	}

	/**
	 * Returns all the tipologia associated with the servizio.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the servizio
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipologias associated with the servizio
	 */
	public static List<Tipologia> getServizioTipologias(
		long pk, int start, int end,
		OrderByComparator<Tipologia> orderByComparator) {

		return getPersistence().getServizioTipologias(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of servizios associated with the tipologia.
	 *
	 * @param pk the primary key of the tipologia
	 * @return the number of servizios associated with the tipologia
	 */
	public static int getServiziosSize(long pk) {
		return getPersistence().getServiziosSize(pk);
	}

	/**
	 * Returns <code>true</code> if the servizio is associated with the tipologia.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPK the primary key of the servizio
	 * @return <code>true</code> if the servizio is associated with the tipologia; <code>false</code> otherwise
	 */
	public static boolean containsServizio(long pk, long servizioPK) {
		return getPersistence().containsServizio(pk, servizioPK);
	}

	/**
	 * Returns <code>true</code> if the tipologia has any servizios associated with it.
	 *
	 * @param pk the primary key of the tipologia to check for associations with servizios
	 * @return <code>true</code> if the tipologia has any servizios associated with it; <code>false</code> otherwise
	 */
	public static boolean containsServizios(long pk) {
		return getPersistence().containsServizios(pk);
	}

	/**
	 * Adds an association between the tipologia and the servizio. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPK the primary key of the servizio
	 */
	public static void addServizio(long pk, long servizioPK) {
		getPersistence().addServizio(pk, servizioPK);
	}

	/**
	 * Adds an association between the tipologia and the servizio. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizio the servizio
	 */
	public static void addServizio(
		long pk, it.servizidigitali.gestioneservizi.model.Servizio servizio) {

		getPersistence().addServizio(pk, servizio);
	}

	/**
	 * Adds an association between the tipologia and the servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPKs the primary keys of the servizios
	 */
	public static void addServizios(long pk, long[] servizioPKs) {
		getPersistence().addServizios(pk, servizioPKs);
	}

	/**
	 * Adds an association between the tipologia and the servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizios the servizios
	 */
	public static void addServizios(
		long pk,
		List<it.servizidigitali.gestioneservizi.model.Servizio> servizios) {

		getPersistence().addServizios(pk, servizios);
	}

	/**
	 * Clears all associations between the tipologia and its servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia to clear the associated servizios from
	 */
	public static void clearServizios(long pk) {
		getPersistence().clearServizios(pk);
	}

	/**
	 * Removes the association between the tipologia and the servizio. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPK the primary key of the servizio
	 */
	public static void removeServizio(long pk, long servizioPK) {
		getPersistence().removeServizio(pk, servizioPK);
	}

	/**
	 * Removes the association between the tipologia and the servizio. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizio the servizio
	 */
	public static void removeServizio(
		long pk, it.servizidigitali.gestioneservizi.model.Servizio servizio) {

		getPersistence().removeServizio(pk, servizio);
	}

	/**
	 * Removes the association between the tipologia and the servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPKs the primary keys of the servizios
	 */
	public static void removeServizios(long pk, long[] servizioPKs) {
		getPersistence().removeServizios(pk, servizioPKs);
	}

	/**
	 * Removes the association between the tipologia and the servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizios the servizios
	 */
	public static void removeServizios(
		long pk,
		List<it.servizidigitali.gestioneservizi.model.Servizio> servizios) {

		getPersistence().removeServizios(pk, servizios);
	}

	/**
	 * Sets the servizios associated with the tipologia, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPKs the primary keys of the servizios to be associated with the tipologia
	 */
	public static void setServizios(long pk, long[] servizioPKs) {
		getPersistence().setServizios(pk, servizioPKs);
	}

	/**
	 * Sets the servizios associated with the tipologia, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizios the servizios to be associated with the tipologia
	 */
	public static void setServizios(
		long pk,
		List<it.servizidigitali.gestioneservizi.model.Servizio> servizios) {

		getPersistence().setServizios(pk, servizios);
	}

	public static TipologiaPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TipologiaPersistence _persistence;

}