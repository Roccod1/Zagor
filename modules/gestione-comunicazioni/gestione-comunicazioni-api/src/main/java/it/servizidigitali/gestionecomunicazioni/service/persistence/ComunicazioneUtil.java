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

package it.servizidigitali.gestionecomunicazioni.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestionecomunicazioni.model.Comunicazione;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the comunicazione service. This utility wraps <code>it.servizidigitali.gestionecomunicazioni.service.persistence.impl.ComunicazionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComunicazionePersistence
 * @generated
 */
public class ComunicazioneUtil {

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
	public static void clearCache(Comunicazione comunicazione) {
		getPersistence().clearCache(comunicazione);
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
	public static Map<Serializable, Comunicazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Comunicazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Comunicazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Comunicazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Comunicazione update(Comunicazione comunicazione) {
		return getPersistence().update(comunicazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Comunicazione update(
		Comunicazione comunicazione, ServiceContext serviceContext) {

		return getPersistence().update(comunicazione, serviceContext);
	}

	/**
	 * Returns all the comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching comunicaziones
	 */
	public static List<Comunicazione> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public static List<Comunicazione> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByUuid_First(
			String uuid, OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByUuid_First(
		String uuid, OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByUuid_Last(
			String uuid, OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByUuid_Last(
		String uuid, OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public static Comunicazione[] findByUuid_PrevAndNext(
			long comunicazioneId, String uuid,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByUuid_PrevAndNext(
			comunicazioneId, uuid, orderByComparator);
	}

	/**
	 * Removes all the comunicaziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching comunicaziones
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the comunicazione where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchComunicazioneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the comunicazione where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the comunicazione that was removed
	 */
	public static Comunicazione removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of comunicaziones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching comunicaziones
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching comunicaziones
	 */
	public static List<Comunicazione> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public static List<Comunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public static Comunicazione[] findByUuid_C_PrevAndNext(
			long comunicazioneId, String uuid, long companyId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByUuid_C_PrevAndNext(
			comunicazioneId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the comunicaziones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching comunicaziones
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the comunicaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching comunicaziones
	 */
	public static List<Comunicazione> findByOrganizationId(
		long organizationId) {

		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	 * Returns a range of all the comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public static List<Comunicazione> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByOrganizationId_First(
			long organizationId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public static Comunicazione[] findByOrganizationId_PrevAndNext(
			long comunicazioneId, long organizationId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			comunicazioneId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the comunicaziones where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of comunicaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching comunicaziones
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Returns all the comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @return the matching comunicaziones
	 */
	public static List<Comunicazione> findByTipologiaComunicazioneId(
		long tipologiaComunicazioneId) {

		return getPersistence().findByTipologiaComunicazioneId(
			tipologiaComunicazioneId);
	}

	/**
	 * Returns a range of all the comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public static List<Comunicazione> findByTipologiaComunicazioneId(
		long tipologiaComunicazioneId, int start, int end) {

		return getPersistence().findByTipologiaComunicazioneId(
			tipologiaComunicazioneId, start, end);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByTipologiaComunicazioneId(
		long tipologiaComunicazioneId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().findByTipologiaComunicazioneId(
			tipologiaComunicazioneId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByTipologiaComunicazioneId(
		long tipologiaComunicazioneId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTipologiaComunicazioneId(
			tipologiaComunicazioneId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByTipologiaComunicazioneId_First(
			long tipologiaComunicazioneId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByTipologiaComunicazioneId_First(
			tipologiaComunicazioneId, orderByComparator);
	}

	/**
	 * Returns the first comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByTipologiaComunicazioneId_First(
		long tipologiaComunicazioneId,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByTipologiaComunicazioneId_First(
			tipologiaComunicazioneId, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByTipologiaComunicazioneId_Last(
			long tipologiaComunicazioneId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByTipologiaComunicazioneId_Last(
			tipologiaComunicazioneId, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByTipologiaComunicazioneId_Last(
		long tipologiaComunicazioneId,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByTipologiaComunicazioneId_Last(
			tipologiaComunicazioneId, orderByComparator);
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public static Comunicazione[] findByTipologiaComunicazioneId_PrevAndNext(
			long comunicazioneId, long tipologiaComunicazioneId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByTipologiaComunicazioneId_PrevAndNext(
			comunicazioneId, tipologiaComunicazioneId, orderByComparator);
	}

	/**
	 * Removes all the comunicaziones where tipologiaComunicazioneId = &#63; from the database.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 */
	public static void removeByTipologiaComunicazioneId(
		long tipologiaComunicazioneId) {

		getPersistence().removeByTipologiaComunicazioneId(
			tipologiaComunicazioneId);
	}

	/**
	 * Returns the number of comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @return the number of matching comunicaziones
	 */
	public static int countByTipologiaComunicazioneId(
		long tipologiaComunicazioneId) {

		return getPersistence().countByTipologiaComunicazioneId(
			tipologiaComunicazioneId);
	}

	/**
	 * Returns all the comunicaziones where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @return the matching comunicaziones
	 */
	public static List<Comunicazione> findByDestinatarioOrganizationId(
		long destinatarioUserId) {

		return getPersistence().findByDestinatarioOrganizationId(
			destinatarioUserId);
	}

	/**
	 * Returns a range of all the comunicaziones where destinatarioUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public static List<Comunicazione> findByDestinatarioOrganizationId(
		long destinatarioUserId, int start, int end) {

		return getPersistence().findByDestinatarioOrganizationId(
			destinatarioUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where destinatarioUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByDestinatarioOrganizationId(
		long destinatarioUserId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().findByDestinatarioOrganizationId(
			destinatarioUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where destinatarioUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByDestinatarioOrganizationId(
		long destinatarioUserId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDestinatarioOrganizationId(
			destinatarioUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByDestinatarioOrganizationId_First(
			long destinatarioUserId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByDestinatarioOrganizationId_First(
			destinatarioUserId, orderByComparator);
	}

	/**
	 * Returns the first comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByDestinatarioOrganizationId_First(
		long destinatarioUserId,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByDestinatarioOrganizationId_First(
			destinatarioUserId, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByDestinatarioOrganizationId_Last(
			long destinatarioUserId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByDestinatarioOrganizationId_Last(
			destinatarioUserId, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByDestinatarioOrganizationId_Last(
		long destinatarioUserId,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByDestinatarioOrganizationId_Last(
			destinatarioUserId, orderByComparator);
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public static Comunicazione[] findByDestinatarioOrganizationId_PrevAndNext(
			long comunicazioneId, long destinatarioUserId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByDestinatarioOrganizationId_PrevAndNext(
			comunicazioneId, destinatarioUserId, orderByComparator);
	}

	/**
	 * Removes all the comunicaziones where destinatarioUserId = &#63; from the database.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 */
	public static void removeByDestinatarioOrganizationId(
		long destinatarioUserId) {

		getPersistence().removeByDestinatarioOrganizationId(destinatarioUserId);
	}

	/**
	 * Returns the number of comunicaziones where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @return the number of matching comunicaziones
	 */
	public static int countByDestinatarioOrganizationId(
		long destinatarioUserId) {

		return getPersistence().countByDestinatarioOrganizationId(
			destinatarioUserId);
	}

	/**
	 * Returns all the comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @return the matching comunicaziones
	 */
	public static List<Comunicazione> findByDestinatarioUserId(
		long destinatarioOrganizationId) {

		return getPersistence().findByDestinatarioUserId(
			destinatarioOrganizationId);
	}

	/**
	 * Returns a range of all the comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public static List<Comunicazione> findByDestinatarioUserId(
		long destinatarioOrganizationId, int start, int end) {

		return getPersistence().findByDestinatarioUserId(
			destinatarioOrganizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByDestinatarioUserId(
		long destinatarioOrganizationId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().findByDestinatarioUserId(
			destinatarioOrganizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByDestinatarioUserId(
		long destinatarioOrganizationId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDestinatarioUserId(
			destinatarioOrganizationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByDestinatarioUserId_First(
			long destinatarioOrganizationId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByDestinatarioUserId_First(
			destinatarioOrganizationId, orderByComparator);
	}

	/**
	 * Returns the first comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByDestinatarioUserId_First(
		long destinatarioOrganizationId,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByDestinatarioUserId_First(
			destinatarioOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByDestinatarioUserId_Last(
			long destinatarioOrganizationId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByDestinatarioUserId_Last(
			destinatarioOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByDestinatarioUserId_Last(
		long destinatarioOrganizationId,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByDestinatarioUserId_Last(
			destinatarioOrganizationId, orderByComparator);
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public static Comunicazione[] findByDestinatarioUserId_PrevAndNext(
			long comunicazioneId, long destinatarioOrganizationId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByDestinatarioUserId_PrevAndNext(
			comunicazioneId, destinatarioOrganizationId, orderByComparator);
	}

	/**
	 * Removes all the comunicaziones where destinatarioOrganizationId = &#63; from the database.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 */
	public static void removeByDestinatarioUserId(
		long destinatarioOrganizationId) {

		getPersistence().removeByDestinatarioUserId(destinatarioOrganizationId);
	}

	/**
	 * Returns the number of comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @return the number of matching comunicaziones
	 */
	public static int countByDestinatarioUserId(
		long destinatarioOrganizationId) {

		return getPersistence().countByDestinatarioUserId(
			destinatarioOrganizationId);
	}

	/**
	 * Returns all the comunicaziones where dataInvio = &#63;.
	 *
	 * @param dataInvio the data invio
	 * @return the matching comunicaziones
	 */
	public static List<Comunicazione> findByDataInvio(Date dataInvio) {
		return getPersistence().findByDataInvio(dataInvio);
	}

	/**
	 * Returns a range of all the comunicaziones where dataInvio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param dataInvio the data invio
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public static List<Comunicazione> findByDataInvio(
		Date dataInvio, int start, int end) {

		return getPersistence().findByDataInvio(dataInvio, start, end);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where dataInvio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param dataInvio the data invio
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByDataInvio(
		Date dataInvio, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().findByDataInvio(
			dataInvio, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where dataInvio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param dataInvio the data invio
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public static List<Comunicazione> findByDataInvio(
		Date dataInvio, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataInvio(
			dataInvio, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comunicazione in the ordered set where dataInvio = &#63;.
	 *
	 * @param dataInvio the data invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByDataInvio_First(
			Date dataInvio, OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByDataInvio_First(
			dataInvio, orderByComparator);
	}

	/**
	 * Returns the first comunicazione in the ordered set where dataInvio = &#63;.
	 *
	 * @param dataInvio the data invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByDataInvio_First(
		Date dataInvio, OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByDataInvio_First(
			dataInvio, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where dataInvio = &#63;.
	 *
	 * @param dataInvio the data invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public static Comunicazione findByDataInvio_Last(
			Date dataInvio, OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByDataInvio_Last(
			dataInvio, orderByComparator);
	}

	/**
	 * Returns the last comunicazione in the ordered set where dataInvio = &#63;.
	 *
	 * @param dataInvio the data invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchByDataInvio_Last(
		Date dataInvio, OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().fetchByDataInvio_Last(
			dataInvio, orderByComparator);
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where dataInvio = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param dataInvio the data invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public static Comunicazione[] findByDataInvio_PrevAndNext(
			long comunicazioneId, Date dataInvio,
			OrderByComparator<Comunicazione> orderByComparator)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByDataInvio_PrevAndNext(
			comunicazioneId, dataInvio, orderByComparator);
	}

	/**
	 * Removes all the comunicaziones where dataInvio = &#63; from the database.
	 *
	 * @param dataInvio the data invio
	 */
	public static void removeByDataInvio(Date dataInvio) {
		getPersistence().removeByDataInvio(dataInvio);
	}

	/**
	 * Returns the number of comunicaziones where dataInvio = &#63;.
	 *
	 * @param dataInvio the data invio
	 * @return the number of matching comunicaziones
	 */
	public static int countByDataInvio(Date dataInvio) {
		return getPersistence().countByDataInvio(dataInvio);
	}

	/**
	 * Caches the comunicazione in the entity cache if it is enabled.
	 *
	 * @param comunicazione the comunicazione
	 */
	public static void cacheResult(Comunicazione comunicazione) {
		getPersistence().cacheResult(comunicazione);
	}

	/**
	 * Caches the comunicaziones in the entity cache if it is enabled.
	 *
	 * @param comunicaziones the comunicaziones
	 */
	public static void cacheResult(List<Comunicazione> comunicaziones) {
		getPersistence().cacheResult(comunicaziones);
	}

	/**
	 * Creates a new comunicazione with the primary key. Does not add the comunicazione to the database.
	 *
	 * @param comunicazioneId the primary key for the new comunicazione
	 * @return the new comunicazione
	 */
	public static Comunicazione create(long comunicazioneId) {
		return getPersistence().create(comunicazioneId);
	}

	/**
	 * Removes the comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione that was removed
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public static Comunicazione remove(long comunicazioneId)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().remove(comunicazioneId);
	}

	public static Comunicazione updateImpl(Comunicazione comunicazione) {
		return getPersistence().updateImpl(comunicazione);
	}

	/**
	 * Returns the comunicazione with the primary key or throws a <code>NoSuchComunicazioneException</code> if it could not be found.
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public static Comunicazione findByPrimaryKey(long comunicazioneId)
		throws it.servizidigitali.gestionecomunicazioni.exception.
			NoSuchComunicazioneException {

		return getPersistence().findByPrimaryKey(comunicazioneId);
	}

	/**
	 * Returns the comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione, or <code>null</code> if a comunicazione with the primary key could not be found
	 */
	public static Comunicazione fetchByPrimaryKey(long comunicazioneId) {
		return getPersistence().fetchByPrimaryKey(comunicazioneId);
	}

	/**
	 * Returns all the comunicaziones.
	 *
	 * @return the comunicaziones
	 */
	public static List<Comunicazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of comunicaziones
	 */
	public static List<Comunicazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comunicaziones
	 */
	public static List<Comunicazione> findAll(
		int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comunicaziones
	 */
	public static List<Comunicazione> findAll(
		int start, int end, OrderByComparator<Comunicazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the comunicaziones from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of comunicaziones.
	 *
	 * @return the number of comunicaziones
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ComunicazionePersistence getPersistence() {
		return _persistence;
	}

	private static volatile ComunicazionePersistence _persistence;

}