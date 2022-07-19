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

package it.servizidigitali.profiloutente.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.profiloutente.model.UtenteOrganizzazione;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the utente organizzazione service. This utility wraps <code>it.servizidigitali.profiloutente.service.persistence.impl.UtenteOrganizzazionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazionePersistence
 * @generated
 */
public class UtenteOrganizzazioneUtil {

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
	public static void clearCache(UtenteOrganizzazione utenteOrganizzazione) {
		getPersistence().clearCache(utenteOrganizzazione);
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
	public static Map<Serializable, UtenteOrganizzazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UtenteOrganizzazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UtenteOrganizzazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UtenteOrganizzazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UtenteOrganizzazione update(
		UtenteOrganizzazione utenteOrganizzazione) {

		return getPersistence().update(utenteOrganizzazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UtenteOrganizzazione update(
		UtenteOrganizzazione utenteOrganizzazione,
		ServiceContext serviceContext) {

		return getPersistence().update(utenteOrganizzazione, serviceContext);
	}

	/**
	 * Returns all the utente organizzaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the utente organizzaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione findByUuid_First(
			String uuid,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione fetchByUuid_First(
		String uuid,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione findByUuid_Last(
			String uuid,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione fetchByUuid_Last(
		String uuid,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the utente organizzaziones before and after the current utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param utenteOrganizzazionePK the primary key of the current utente organizzazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	public static UtenteOrganizzazione[] findByUuid_PrevAndNext(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK,
			String uuid,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByUuid_PrevAndNext(
			utenteOrganizzazionePK, uuid, orderByComparator);
	}

	/**
	 * Removes all the utente organizzaziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of utente organizzaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching utente organizzaziones
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the utente organizzazione where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUtenteOrganizzazioneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the utente organizzazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the utente organizzazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the utente organizzazione where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the utente organizzazione that was removed
	 */
	public static UtenteOrganizzazione removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of utente organizzaziones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching utente organizzaziones
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the utente organizzaziones before and after the current utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param utenteOrganizzazionePK the primary key of the current utente organizzazione
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	public static UtenteOrganizzazione[] findByUuid_C_PrevAndNext(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK,
			String uuid, long companyId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByUuid_C_PrevAndNext(
			utenteOrganizzazionePK, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the utente organizzaziones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching utente organizzaziones
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the utente organizzaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByOrganizationId(
		long organizationId) {

		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	 * Returns a range of all the utente organizzaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione findByOrganizationId_First(
			long organizationId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the utente organizzaziones before and after the current utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param utenteOrganizzazionePK the primary key of the current utente organizzazione
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	public static UtenteOrganizzazione[] findByOrganizationId_PrevAndNext(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK,
			long organizationId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			utenteOrganizzazionePK, organizationId, orderByComparator);
	}

	/**
	 * Removes all the utente organizzaziones where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of utente organizzaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching utente organizzaziones
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Returns all the utente organizzaziones where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @return the matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByUtenteId(long utenteId) {
		return getPersistence().findByUtenteId(utenteId);
	}

	/**
	 * Returns a range of all the utente organizzaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByUtenteId(
		long utenteId, int start, int end) {

		return getPersistence().findByUtenteId(utenteId, start, end);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByUtenteId(
		long utenteId, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().findByUtenteId(
			utenteId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findByUtenteId(
		long utenteId, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUtenteId(
			utenteId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione findByUtenteId_First(
			long utenteId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByUtenteId_First(
			utenteId, orderByComparator);
	}

	/**
	 * Returns the first utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione fetchByUtenteId_First(
		long utenteId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().fetchByUtenteId_First(
			utenteId, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione findByUtenteId_Last(
			long utenteId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByUtenteId_Last(
			utenteId, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione fetchByUtenteId_Last(
		long utenteId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().fetchByUtenteId_Last(
			utenteId, orderByComparator);
	}

	/**
	 * Returns the utente organizzaziones before and after the current utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteOrganizzazionePK the primary key of the current utente organizzazione
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	public static UtenteOrganizzazione[] findByUtenteId_PrevAndNext(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK,
			long utenteId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByUtenteId_PrevAndNext(
			utenteOrganizzazionePK, utenteId, orderByComparator);
	}

	/**
	 * Removes all the utente organizzaziones where utenteId = &#63; from the database.
	 *
	 * @param utenteId the utente ID
	 */
	public static void removeByUtenteId(long utenteId) {
		getPersistence().removeByUtenteId(utenteId);
	}

	/**
	 * Returns the number of utente organizzaziones where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @return the number of matching utente organizzaziones
	 */
	public static int countByUtenteId(long utenteId) {
		return getPersistence().countByUtenteId(utenteId);
	}

	/**
	 * Caches the utente organizzazione in the entity cache if it is enabled.
	 *
	 * @param utenteOrganizzazione the utente organizzazione
	 */
	public static void cacheResult(UtenteOrganizzazione utenteOrganizzazione) {
		getPersistence().cacheResult(utenteOrganizzazione);
	}

	/**
	 * Caches the utente organizzaziones in the entity cache if it is enabled.
	 *
	 * @param utenteOrganizzaziones the utente organizzaziones
	 */
	public static void cacheResult(
		List<UtenteOrganizzazione> utenteOrganizzaziones) {

		getPersistence().cacheResult(utenteOrganizzaziones);
	}

	/**
	 * Creates a new utente organizzazione with the primary key. Does not add the utente organizzazione to the database.
	 *
	 * @param utenteOrganizzazionePK the primary key for the new utente organizzazione
	 * @return the new utente organizzazione
	 */
	public static UtenteOrganizzazione create(
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazionePK utenteOrganizzazionePK) {

		return getPersistence().create(utenteOrganizzazionePK);
	}

	/**
	 * Removes the utente organizzazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione that was removed
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	public static UtenteOrganizzazione remove(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().remove(utenteOrganizzazionePK);
	}

	public static UtenteOrganizzazione updateImpl(
		UtenteOrganizzazione utenteOrganizzazione) {

		return getPersistence().updateImpl(utenteOrganizzazione);
	}

	/**
	 * Returns the utente organizzazione with the primary key or throws a <code>NoSuchUtenteOrganizzazioneException</code> if it could not be found.
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	public static UtenteOrganizzazione findByPrimaryKey(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneException {

		return getPersistence().findByPrimaryKey(utenteOrganizzazionePK);
	}

	/**
	 * Returns the utente organizzazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione, or <code>null</code> if a utente organizzazione with the primary key could not be found
	 */
	public static UtenteOrganizzazione fetchByPrimaryKey(
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazionePK utenteOrganizzazionePK) {

		return getPersistence().fetchByPrimaryKey(utenteOrganizzazionePK);
	}

	/**
	 * Returns all the utente organizzaziones.
	 *
	 * @return the utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the utente organizzaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findAll(
		int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> findAll(
		int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the utente organizzaziones from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of utente organizzaziones.
	 *
	 * @return the number of utente organizzaziones
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static UtenteOrganizzazionePersistence getPersistence() {
		return _persistence;
	}

	private static volatile UtenteOrganizzazionePersistence _persistence;

}