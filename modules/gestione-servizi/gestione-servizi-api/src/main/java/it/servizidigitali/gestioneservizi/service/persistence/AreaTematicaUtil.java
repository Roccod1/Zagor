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

import it.servizidigitali.gestioneservizi.model.AreaTematica;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the area tematica service. This utility wraps <code>it.servizidigitali.gestioneservizi.service.persistence.impl.AreaTematicaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AreaTematicaPersistence
 * @generated
 */
public class AreaTematicaUtil {

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
	public static void clearCache(AreaTematica areaTematica) {
		getPersistence().clearCache(areaTematica);
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
	public static Map<Serializable, AreaTematica> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AreaTematica> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AreaTematica> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AreaTematica> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AreaTematica update(AreaTematica areaTematica) {
		return getPersistence().update(areaTematica);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AreaTematica update(
		AreaTematica areaTematica, ServiceContext serviceContext) {

		return getPersistence().update(areaTematica, serviceContext);
	}

	/**
	 * Returns all the area tematicas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching area tematicas
	 */
	public static List<AreaTematica> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the area tematicas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of matching area tematicas
	 */
	public static List<AreaTematica> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the area tematicas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching area tematicas
	 */
	public static List<AreaTematica> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the area tematicas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching area tematicas
	 */
	public static List<AreaTematica> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public static AreaTematica findByUuid_First(
			String uuid, OrderByComparator<AreaTematica> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public static AreaTematica fetchByUuid_First(
		String uuid, OrderByComparator<AreaTematica> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public static AreaTematica findByUuid_Last(
			String uuid, OrderByComparator<AreaTematica> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public static AreaTematica fetchByUuid_Last(
		String uuid, OrderByComparator<AreaTematica> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the area tematicas before and after the current area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param areaTematicaId the primary key of the current area tematica
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	public static AreaTematica[] findByUuid_PrevAndNext(
			long areaTematicaId, String uuid,
			OrderByComparator<AreaTematica> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().findByUuid_PrevAndNext(
			areaTematicaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the area tematicas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of area tematicas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching area tematicas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the area tematica where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAreaTematicaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public static AreaTematica findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the area tematica where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public static AreaTematica fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the area tematica where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public static AreaTematica fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the area tematica where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the area tematica that was removed
	 */
	public static AreaTematica removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of area tematicas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching area tematicas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching area tematicas
	 */
	public static List<AreaTematica> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of matching area tematicas
	 */
	public static List<AreaTematica> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching area tematicas
	 */
	public static List<AreaTematica> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching area tematicas
	 */
	public static List<AreaTematica> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public static AreaTematica findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AreaTematica> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public static AreaTematica fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AreaTematica> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public static AreaTematica findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AreaTematica> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public static AreaTematica fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AreaTematica> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the area tematicas before and after the current area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param areaTematicaId the primary key of the current area tematica
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	public static AreaTematica[] findByUuid_C_PrevAndNext(
			long areaTematicaId, String uuid, long companyId,
			OrderByComparator<AreaTematica> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			areaTematicaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the area tematicas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching area tematicas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the area tematica where codice = &#63; or throws a <code>NoSuchAreaTematicaException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public static AreaTematica findByCodice(String codice)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().findByCodice(codice);
	}

	/**
	 * Returns the area tematica where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public static AreaTematica fetchByCodice(String codice) {
		return getPersistence().fetchByCodice(codice);
	}

	/**
	 * Returns the area tematica where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public static AreaTematica fetchByCodice(
		String codice, boolean useFinderCache) {

		return getPersistence().fetchByCodice(codice, useFinderCache);
	}

	/**
	 * Removes the area tematica where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the area tematica that was removed
	 */
	public static AreaTematica removeByCodice(String codice)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().removeByCodice(codice);
	}

	/**
	 * Returns the number of area tematicas where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching area tematicas
	 */
	public static int countByCodice(String codice) {
		return getPersistence().countByCodice(codice);
	}

	/**
	 * Returns all the area tematicas where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @return the matching area tematicas
	 */
	public static List<AreaTematica> findByAttiva(boolean attiva) {
		return getPersistence().findByAttiva(attiva);
	}

	/**
	 * Returns a range of all the area tematicas where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of matching area tematicas
	 */
	public static List<AreaTematica> findByAttiva(
		boolean attiva, int start, int end) {

		return getPersistence().findByAttiva(attiva, start, end);
	}

	/**
	 * Returns an ordered range of all the area tematicas where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching area tematicas
	 */
	public static List<AreaTematica> findByAttiva(
		boolean attiva, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator) {

		return getPersistence().findByAttiva(
			attiva, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the area tematicas where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching area tematicas
	 */
	public static List<AreaTematica> findByAttiva(
		boolean attiva, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAttiva(
			attiva, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public static AreaTematica findByAttiva_First(
			boolean attiva, OrderByComparator<AreaTematica> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().findByAttiva_First(attiva, orderByComparator);
	}

	/**
	 * Returns the first area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public static AreaTematica fetchByAttiva_First(
		boolean attiva, OrderByComparator<AreaTematica> orderByComparator) {

		return getPersistence().fetchByAttiva_First(attiva, orderByComparator);
	}

	/**
	 * Returns the last area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public static AreaTematica findByAttiva_Last(
			boolean attiva, OrderByComparator<AreaTematica> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().findByAttiva_Last(attiva, orderByComparator);
	}

	/**
	 * Returns the last area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public static AreaTematica fetchByAttiva_Last(
		boolean attiva, OrderByComparator<AreaTematica> orderByComparator) {

		return getPersistence().fetchByAttiva_Last(attiva, orderByComparator);
	}

	/**
	 * Returns the area tematicas before and after the current area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param areaTematicaId the primary key of the current area tematica
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	public static AreaTematica[] findByAttiva_PrevAndNext(
			long areaTematicaId, boolean attiva,
			OrderByComparator<AreaTematica> orderByComparator)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().findByAttiva_PrevAndNext(
			areaTematicaId, attiva, orderByComparator);
	}

	/**
	 * Removes all the area tematicas where attiva = &#63; from the database.
	 *
	 * @param attiva the attiva
	 */
	public static void removeByAttiva(boolean attiva) {
		getPersistence().removeByAttiva(attiva);
	}

	/**
	 * Returns the number of area tematicas where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @return the number of matching area tematicas
	 */
	public static int countByAttiva(boolean attiva) {
		return getPersistence().countByAttiva(attiva);
	}

	/**
	 * Caches the area tematica in the entity cache if it is enabled.
	 *
	 * @param areaTematica the area tematica
	 */
	public static void cacheResult(AreaTematica areaTematica) {
		getPersistence().cacheResult(areaTematica);
	}

	/**
	 * Caches the area tematicas in the entity cache if it is enabled.
	 *
	 * @param areaTematicas the area tematicas
	 */
	public static void cacheResult(List<AreaTematica> areaTematicas) {
		getPersistence().cacheResult(areaTematicas);
	}

	/**
	 * Creates a new area tematica with the primary key. Does not add the area tematica to the database.
	 *
	 * @param areaTematicaId the primary key for the new area tematica
	 * @return the new area tematica
	 */
	public static AreaTematica create(long areaTematicaId) {
		return getPersistence().create(areaTematicaId);
	}

	/**
	 * Removes the area tematica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica that was removed
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	public static AreaTematica remove(long areaTematicaId)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().remove(areaTematicaId);
	}

	public static AreaTematica updateImpl(AreaTematica areaTematica) {
		return getPersistence().updateImpl(areaTematica);
	}

	/**
	 * Returns the area tematica with the primary key or throws a <code>NoSuchAreaTematicaException</code> if it could not be found.
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	public static AreaTematica findByPrimaryKey(long areaTematicaId)
		throws it.servizidigitali.gestioneservizi.exception.
			NoSuchAreaTematicaException {

		return getPersistence().findByPrimaryKey(areaTematicaId);
	}

	/**
	 * Returns the area tematica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica, or <code>null</code> if a area tematica with the primary key could not be found
	 */
	public static AreaTematica fetchByPrimaryKey(long areaTematicaId) {
		return getPersistence().fetchByPrimaryKey(areaTematicaId);
	}

	/**
	 * Returns all the area tematicas.
	 *
	 * @return the area tematicas
	 */
	public static List<AreaTematica> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the area tematicas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of area tematicas
	 */
	public static List<AreaTematica> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the area tematicas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of area tematicas
	 */
	public static List<AreaTematica> findAll(
		int start, int end, OrderByComparator<AreaTematica> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the area tematicas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of area tematicas
	 */
	public static List<AreaTematica> findAll(
		int start, int end, OrderByComparator<AreaTematica> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the area tematicas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of area tematicas.
	 *
	 * @return the number of area tematicas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AreaTematicaPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AreaTematicaPersistence _persistence;

}