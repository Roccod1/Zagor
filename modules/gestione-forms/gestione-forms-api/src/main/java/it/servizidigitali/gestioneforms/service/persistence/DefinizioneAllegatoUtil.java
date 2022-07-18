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

package it.servizidigitali.gestioneforms.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the definizione allegato service. This utility wraps <code>it.servizidigitali.gestioneforms.service.persistence.impl.DefinizioneAllegatoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DefinizioneAllegatoPersistence
 * @generated
 */
public class DefinizioneAllegatoUtil {

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
	public static void clearCache(DefinizioneAllegato definizioneAllegato) {
		getPersistence().clearCache(definizioneAllegato);
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
	public static Map<Serializable, DefinizioneAllegato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DefinizioneAllegato> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DefinizioneAllegato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DefinizioneAllegato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DefinizioneAllegato update(
		DefinizioneAllegato definizioneAllegato) {

		return getPersistence().update(definizioneAllegato);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DefinizioneAllegato update(
		DefinizioneAllegato definizioneAllegato,
		ServiceContext serviceContext) {

		return getPersistence().update(definizioneAllegato, serviceContext);
	}

	/**
	 * Returns all the definizione allegatos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching definizione allegatos
	 */
	public static List<DefinizioneAllegato> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the definizione allegatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of matching definizione allegatos
	 */
	public static List<DefinizioneAllegato> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching definizione allegatos
	 */
	public static List<DefinizioneAllegato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching definizione allegatos
	 */
	public static List<DefinizioneAllegato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato findByUuid_First(
			String uuid,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato fetchByUuid_First(
		String uuid, OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato findByUuid_Last(
			String uuid,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato fetchByUuid_Last(
		String uuid, OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the definizione allegatos before and after the current definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param definizioneAllegatoId the primary key of the current definizione allegato
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	public static DefinizioneAllegato[] findByUuid_PrevAndNext(
			long definizioneAllegatoId, String uuid,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().findByUuid_PrevAndNext(
			definizioneAllegatoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the definizione allegatos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of definizione allegatos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching definizione allegatos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the definizione allegato where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDefinizioneAllegatoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the definizione allegato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the definizione allegato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the definizione allegato where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the definizione allegato that was removed
	 */
	public static DefinizioneAllegato removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of definizione allegatos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching definizione allegatos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching definizione allegatos
	 */
	public static List<DefinizioneAllegato> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of matching definizione allegatos
	 */
	public static List<DefinizioneAllegato> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching definizione allegatos
	 */
	public static List<DefinizioneAllegato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching definizione allegatos
	 */
	public static List<DefinizioneAllegato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the definizione allegatos before and after the current definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param definizioneAllegatoId the primary key of the current definizione allegato
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	public static DefinizioneAllegato[] findByUuid_C_PrevAndNext(
			long definizioneAllegatoId, String uuid, long companyId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			definizioneAllegatoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the definizione allegatos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching definizione allegatos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the definizione allegatos where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @return the matching definizione allegatos
	 */
	public static List<DefinizioneAllegato> findByformId(long formId) {
		return getPersistence().findByformId(formId);
	}

	/**
	 * Returns a range of all the definizione allegatos where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of matching definizione allegatos
	 */
	public static List<DefinizioneAllegato> findByformId(
		long formId, int start, int end) {

		return getPersistence().findByformId(formId, start, end);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching definizione allegatos
	 */
	public static List<DefinizioneAllegato> findByformId(
		long formId, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return getPersistence().findByformId(
			formId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching definizione allegatos
	 */
	public static List<DefinizioneAllegato> findByformId(
		long formId, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByformId(
			formId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first definizione allegato in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato findByformId_First(
			long formId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().findByformId_First(formId, orderByComparator);
	}

	/**
	 * Returns the first definizione allegato in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato fetchByformId_First(
		long formId, OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return getPersistence().fetchByformId_First(formId, orderByComparator);
	}

	/**
	 * Returns the last definizione allegato in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato findByformId_Last(
			long formId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().findByformId_Last(formId, orderByComparator);
	}

	/**
	 * Returns the last definizione allegato in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato fetchByformId_Last(
		long formId, OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return getPersistence().fetchByformId_Last(formId, orderByComparator);
	}

	/**
	 * Returns the definizione allegatos before and after the current definizione allegato in the ordered set where formId = &#63;.
	 *
	 * @param definizioneAllegatoId the primary key of the current definizione allegato
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	public static DefinizioneAllegato[] findByformId_PrevAndNext(
			long definizioneAllegatoId, long formId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().findByformId_PrevAndNext(
			definizioneAllegatoId, formId, orderByComparator);
	}

	/**
	 * Removes all the definizione allegatos where formId = &#63; from the database.
	 *
	 * @param formId the form ID
	 */
	public static void removeByformId(long formId) {
		getPersistence().removeByformId(formId);
	}

	/**
	 * Returns the number of definizione allegatos where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @return the number of matching definizione allegatos
	 */
	public static int countByformId(long formId) {
		return getPersistence().countByformId(formId);
	}

	/**
	 * Caches the definizione allegato in the entity cache if it is enabled.
	 *
	 * @param definizioneAllegato the definizione allegato
	 */
	public static void cacheResult(DefinizioneAllegato definizioneAllegato) {
		getPersistence().cacheResult(definizioneAllegato);
	}

	/**
	 * Caches the definizione allegatos in the entity cache if it is enabled.
	 *
	 * @param definizioneAllegatos the definizione allegatos
	 */
	public static void cacheResult(
		List<DefinizioneAllegato> definizioneAllegatos) {

		getPersistence().cacheResult(definizioneAllegatos);
	}

	/**
	 * Creates a new definizione allegato with the primary key. Does not add the definizione allegato to the database.
	 *
	 * @param definizioneAllegatoId the primary key for the new definizione allegato
	 * @return the new definizione allegato
	 */
	public static DefinizioneAllegato create(long definizioneAllegatoId) {
		return getPersistence().create(definizioneAllegatoId);
	}

	/**
	 * Removes the definizione allegato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato that was removed
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	public static DefinizioneAllegato remove(long definizioneAllegatoId)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().remove(definizioneAllegatoId);
	}

	public static DefinizioneAllegato updateImpl(
		DefinizioneAllegato definizioneAllegato) {

		return getPersistence().updateImpl(definizioneAllegato);
	}

	/**
	 * Returns the definizione allegato with the primary key or throws a <code>NoSuchDefinizioneAllegatoException</code> if it could not be found.
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	public static DefinizioneAllegato findByPrimaryKey(
			long definizioneAllegatoId)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchDefinizioneAllegatoException {

		return getPersistence().findByPrimaryKey(definizioneAllegatoId);
	}

	/**
	 * Returns the definizione allegato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato, or <code>null</code> if a definizione allegato with the primary key could not be found
	 */
	public static DefinizioneAllegato fetchByPrimaryKey(
		long definizioneAllegatoId) {

		return getPersistence().fetchByPrimaryKey(definizioneAllegatoId);
	}

	/**
	 * Returns all the definizione allegatos.
	 *
	 * @return the definizione allegatos
	 */
	public static List<DefinizioneAllegato> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the definizione allegatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of definizione allegatos
	 */
	public static List<DefinizioneAllegato> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of definizione allegatos
	 */
	public static List<DefinizioneAllegato> findAll(
		int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of definizione allegatos
	 */
	public static List<DefinizioneAllegato> findAll(
		int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the definizione allegatos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of definizione allegatos.
	 *
	 * @return the number of definizione allegatos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DefinizioneAllegatoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DefinizioneAllegatoPersistence _persistence;

}