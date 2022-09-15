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

package it.servizidigitali.gestioneprocessi.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneprocessi.model.Processo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the processo service. This utility wraps <code>it.servizidigitali.gestioneprocessi.service.persistence.impl.ProcessoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessoPersistence
 * @generated
 */
public class ProcessoUtil {

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
	public static void clearCache(Processo processo) {
		getPersistence().clearCache(processo);
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
	public static Map<Serializable, Processo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Processo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Processo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Processo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Processo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Processo update(Processo processo) {
		return getPersistence().update(processo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Processo update(
		Processo processo, ServiceContext serviceContext) {

		return getPersistence().update(processo, serviceContext);
	}

	/**
	 * Returns all the processos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching processos
	 */
	public static List<Processo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the processos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of matching processos
	 */
	public static List<Processo> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the processos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processos
	 */
	public static List<Processo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Processo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the processos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching processos
	 */
	public static List<Processo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Processo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first processo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public static Processo findByUuid_First(
			String uuid, OrderByComparator<Processo> orderByComparator)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first processo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByUuid_First(
		String uuid, OrderByComparator<Processo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last processo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public static Processo findByUuid_Last(
			String uuid, OrderByComparator<Processo> orderByComparator)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last processo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByUuid_Last(
		String uuid, OrderByComparator<Processo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the processos before and after the current processo in the ordered set where uuid = &#63;.
	 *
	 * @param processoId the primary key of the current processo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	public static Processo[] findByUuid_PrevAndNext(
			long processoId, String uuid,
			OrderByComparator<Processo> orderByComparator)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByUuid_PrevAndNext(
			processoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the processos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of processos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching processos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the processo where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcessoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public static Processo findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the processo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the processo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the processo where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the processo that was removed
	 */
	public static Processo removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of processos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching processos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the processos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching processos
	 */
	public static List<Processo> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the processos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of matching processos
	 */
	public static List<Processo> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the processos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processos
	 */
	public static List<Processo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Processo> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the processos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching processos
	 */
	public static List<Processo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Processo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public static Processo findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Processo> orderByComparator)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Processo> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public static Processo findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Processo> orderByComparator)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Processo> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the processos before and after the current processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param processoId the primary key of the current processo
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	public static Processo[] findByUuid_C_PrevAndNext(
			long processoId, String uuid, long companyId,
			OrderByComparator<Processo> orderByComparator)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			processoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the processos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of processos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching processos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the processo where codice = &#63; or throws a <code>NoSuchProcessoException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public static Processo findByCodice(String codice)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByCodice(codice);
	}

	/**
	 * Returns the processo where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByCodice(String codice) {
		return getPersistence().fetchByCodice(codice);
	}

	/**
	 * Returns the processo where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByCodice(
		String codice, boolean useFinderCache) {

		return getPersistence().fetchByCodice(codice, useFinderCache);
	}

	/**
	 * Removes the processo where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the processo that was removed
	 */
	public static Processo removeByCodice(String codice)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().removeByCodice(codice);
	}

	/**
	 * Returns the number of processos where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching processos
	 */
	public static int countByCodice(String codice) {
		return getPersistence().countByCodice(codice);
	}

	/**
	 * Returns all the processos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching processos
	 */
	public static List<Processo> findByStato(String stato) {
		return getPersistence().findByStato(stato);
	}

	/**
	 * Returns a range of all the processos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of matching processos
	 */
	public static List<Processo> findByStato(String stato, int start, int end) {
		return getPersistence().findByStato(stato, start, end);
	}

	/**
	 * Returns an ordered range of all the processos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processos
	 */
	public static List<Processo> findByStato(
		String stato, int start, int end,
		OrderByComparator<Processo> orderByComparator) {

		return getPersistence().findByStato(
			stato, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the processos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching processos
	 */
	public static List<Processo> findByStato(
		String stato, int start, int end,
		OrderByComparator<Processo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStato(
			stato, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first processo in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public static Processo findByStato_First(
			String stato, OrderByComparator<Processo> orderByComparator)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByStato_First(stato, orderByComparator);
	}

	/**
	 * Returns the first processo in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByStato_First(
		String stato, OrderByComparator<Processo> orderByComparator) {

		return getPersistence().fetchByStato_First(stato, orderByComparator);
	}

	/**
	 * Returns the last processo in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public static Processo findByStato_Last(
			String stato, OrderByComparator<Processo> orderByComparator)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByStato_Last(stato, orderByComparator);
	}

	/**
	 * Returns the last processo in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByStato_Last(
		String stato, OrderByComparator<Processo> orderByComparator) {

		return getPersistence().fetchByStato_Last(stato, orderByComparator);
	}

	/**
	 * Returns the processos before and after the current processo in the ordered set where stato = &#63;.
	 *
	 * @param processoId the primary key of the current processo
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	public static Processo[] findByStato_PrevAndNext(
			long processoId, String stato,
			OrderByComparator<Processo> orderByComparator)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByStato_PrevAndNext(
			processoId, stato, orderByComparator);
	}

	/**
	 * Removes all the processos where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	public static void removeByStato(String stato) {
		getPersistence().removeByStato(stato);
	}

	/**
	 * Returns the number of processos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching processos
	 */
	public static int countByStato(String stato) {
		return getPersistence().countByStato(stato);
	}

	/**
	 * Returns all the processos where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching processos
	 */
	public static List<Processo> findByAttivo(boolean attivo) {
		return getPersistence().findByAttivo(attivo);
	}

	/**
	 * Returns a range of all the processos where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of matching processos
	 */
	public static List<Processo> findByAttivo(
		boolean attivo, int start, int end) {

		return getPersistence().findByAttivo(attivo, start, end);
	}

	/**
	 * Returns an ordered range of all the processos where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processos
	 */
	public static List<Processo> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<Processo> orderByComparator) {

		return getPersistence().findByAttivo(
			attivo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the processos where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching processos
	 */
	public static List<Processo> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<Processo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAttivo(
			attivo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first processo in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public static Processo findByAttivo_First(
			boolean attivo, OrderByComparator<Processo> orderByComparator)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByAttivo_First(attivo, orderByComparator);
	}

	/**
	 * Returns the first processo in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByAttivo_First(
		boolean attivo, OrderByComparator<Processo> orderByComparator) {

		return getPersistence().fetchByAttivo_First(attivo, orderByComparator);
	}

	/**
	 * Returns the last processo in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public static Processo findByAttivo_Last(
			boolean attivo, OrderByComparator<Processo> orderByComparator)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByAttivo_Last(attivo, orderByComparator);
	}

	/**
	 * Returns the last processo in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByAttivo_Last(
		boolean attivo, OrderByComparator<Processo> orderByComparator) {

		return getPersistence().fetchByAttivo_Last(attivo, orderByComparator);
	}

	/**
	 * Returns the processos before and after the current processo in the ordered set where attivo = &#63;.
	 *
	 * @param processoId the primary key of the current processo
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	public static Processo[] findByAttivo_PrevAndNext(
			long processoId, boolean attivo,
			OrderByComparator<Processo> orderByComparator)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByAttivo_PrevAndNext(
			processoId, attivo, orderByComparator);
	}

	/**
	 * Removes all the processos where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	public static void removeByAttivo(boolean attivo) {
		getPersistence().removeByAttivo(attivo);
	}

	/**
	 * Returns the number of processos where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching processos
	 */
	public static int countByAttivo(boolean attivo) {
		return getPersistence().countByAttivo(attivo);
	}

	/**
	 * Returns the processo where deploymentId = &#63; and resourceId = &#63; or throws a <code>NoSuchProcessoException</code> if it could not be found.
	 *
	 * @param deploymentId the deployment ID
	 * @param resourceId the resource ID
	 * @return the matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public static Processo findByDeploymentIdResourceId(
			String deploymentId, String resourceId)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByDeploymentIdResourceId(
			deploymentId, resourceId);
	}

	/**
	 * Returns the processo where deploymentId = &#63; and resourceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deploymentId the deployment ID
	 * @param resourceId the resource ID
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByDeploymentIdResourceId(
		String deploymentId, String resourceId) {

		return getPersistence().fetchByDeploymentIdResourceId(
			deploymentId, resourceId);
	}

	/**
	 * Returns the processo where deploymentId = &#63; and resourceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deploymentId the deployment ID
	 * @param resourceId the resource ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchByDeploymentIdResourceId(
		String deploymentId, String resourceId, boolean useFinderCache) {

		return getPersistence().fetchByDeploymentIdResourceId(
			deploymentId, resourceId, useFinderCache);
	}

	/**
	 * Removes the processo where deploymentId = &#63; and resourceId = &#63; from the database.
	 *
	 * @param deploymentId the deployment ID
	 * @param resourceId the resource ID
	 * @return the processo that was removed
	 */
	public static Processo removeByDeploymentIdResourceId(
			String deploymentId, String resourceId)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().removeByDeploymentIdResourceId(
			deploymentId, resourceId);
	}

	/**
	 * Returns the number of processos where deploymentId = &#63; and resourceId = &#63;.
	 *
	 * @param deploymentId the deployment ID
	 * @param resourceId the resource ID
	 * @return the number of matching processos
	 */
	public static int countByDeploymentIdResourceId(
		String deploymentId, String resourceId) {

		return getPersistence().countByDeploymentIdResourceId(
			deploymentId, resourceId);
	}

	/**
	 * Caches the processo in the entity cache if it is enabled.
	 *
	 * @param processo the processo
	 */
	public static void cacheResult(Processo processo) {
		getPersistence().cacheResult(processo);
	}

	/**
	 * Caches the processos in the entity cache if it is enabled.
	 *
	 * @param processos the processos
	 */
	public static void cacheResult(List<Processo> processos) {
		getPersistence().cacheResult(processos);
	}

	/**
	 * Creates a new processo with the primary key. Does not add the processo to the database.
	 *
	 * @param processoId the primary key for the new processo
	 * @return the new processo
	 */
	public static Processo create(long processoId) {
		return getPersistence().create(processoId);
	}

	/**
	 * Removes the processo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo that was removed
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	public static Processo remove(long processoId)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().remove(processoId);
	}

	public static Processo updateImpl(Processo processo) {
		return getPersistence().updateImpl(processo);
	}

	/**
	 * Returns the processo with the primary key or throws a <code>NoSuchProcessoException</code> if it could not be found.
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	public static Processo findByPrimaryKey(long processoId)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getPersistence().findByPrimaryKey(processoId);
	}

	/**
	 * Returns the processo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo, or <code>null</code> if a processo with the primary key could not be found
	 */
	public static Processo fetchByPrimaryKey(long processoId) {
		return getPersistence().fetchByPrimaryKey(processoId);
	}

	/**
	 * Returns all the processos.
	 *
	 * @return the processos
	 */
	public static List<Processo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the processos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of processos
	 */
	public static List<Processo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the processos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of processos
	 */
	public static List<Processo> findAll(
		int start, int end, OrderByComparator<Processo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the processos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of processos
	 */
	public static List<Processo> findAll(
		int start, int end, OrderByComparator<Processo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the processos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of processos.
	 *
	 * @return the number of processos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProcessoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProcessoPersistence _persistence;

}