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

import it.servizidigitali.profiloutente.model.UtenteOrganizzazioneCanaleComunicazione;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the utente organizzazione canale comunicazione service. This utility wraps <code>it.servizidigitali.profiloutente.service.persistence.impl.UtenteOrganizzazioneCanaleComunicazionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazioneCanaleComunicazionePersistence
 * @generated
 */
public class UtenteOrganizzazioneCanaleComunicazioneUtil {

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
	public static void clearCache(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione) {

		getPersistence().clearCache(utenteOrganizzazioneCanaleComunicazione);
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
	public static Map<Serializable, UtenteOrganizzazioneCanaleComunicazione>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione>
		findWithDynamicQuery(DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione>
		findWithDynamicQuery(DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione>
		findWithDynamicQuery(
			DynamicQuery dynamicQuery, int start, int end,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UtenteOrganizzazioneCanaleComunicazione update(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione) {

		return getPersistence().update(utenteOrganizzazioneCanaleComunicazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UtenteOrganizzazioneCanaleComunicazione update(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione,
		ServiceContext serviceContext) {

		return getPersistence().update(
			utenteOrganizzazioneCanaleComunicazione, serviceContext);
	}

	/**
	 * Returns all the utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione findByUuid_First(
			String uuid,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione fetchByUuid_First(
		String uuid,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione findByUuid_Last(
			String uuid,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione fetchByUuid_Last(
		String uuid,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione[]
			findByUuid_PrevAndNext(
				it.servizidigitali.profiloutente.service.persistence.
					UtenteOrganizzazioneCanaleComunicazionePK
						utenteOrganizzazioneCanaleComunicazionePK,
				String uuid,
				OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
					orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByUuid_PrevAndNext(
			utenteOrganizzazioneCanaleComunicazionePK, uuid, orderByComparator);
	}

	/**
	 * Removes all the utente organizzazione canale comunicaziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the utente organizzazione canale comunicazione where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUtenteOrganizzazioneCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione findByUUID_G(
			String uuid, long groupId)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the utente organizzazione canale comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the utente organizzazione canale comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the utente organizzazione canale comunicazione where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the utente organizzazione canale comunicazione that was removed
	 */
	public static UtenteOrganizzazioneCanaleComunicazione removeByUUID_G(
			String uuid, long groupId)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione[]
			findByUuid_C_PrevAndNext(
				it.servizidigitali.profiloutente.service.persistence.
					UtenteOrganizzazioneCanaleComunicazionePK
						utenteOrganizzazioneCanaleComunicazionePK,
				String uuid, long companyId,
				OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
					orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByUuid_C_PrevAndNext(
			utenteOrganizzazioneCanaleComunicazionePK, uuid, companyId,
			orderByComparator);
	}

	/**
	 * Removes all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione>
		findByOrganizationId(long organizationId) {

		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione>
		findByOrganizationId(long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione>
		findByOrganizationId(
			long organizationId, int start, int end,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione>
		findByOrganizationId(
			long organizationId, int start, int end,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione
			findByOrganizationId_First(
				long organizationId,
				OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
					orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione
		fetchByOrganizationId_First(
			long organizationId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione
			findByOrganizationId_Last(
				long organizationId,
				OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
					orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione
		fetchByOrganizationId_Last(
			long organizationId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione[]
			findByOrganizationId_PrevAndNext(
				it.servizidigitali.profiloutente.service.persistence.
					UtenteOrganizzazioneCanaleComunicazionePK
						utenteOrganizzazioneCanaleComunicazionePK,
				long organizationId,
				OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
					orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			utenteOrganizzazioneCanaleComunicazionePK, organizationId,
			orderByComparator);
	}

	/**
	 * Removes all the utente organizzazione canale comunicaziones where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Returns all the utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findByUtenteId(
		long utenteId) {

		return getPersistence().findByUtenteId(utenteId);
	}

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findByUtenteId(
		long utenteId, int start, int end) {

		return getPersistence().findByUtenteId(utenteId, start, end);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findByUtenteId(
		long utenteId, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return getPersistence().findByUtenteId(
			utenteId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findByUtenteId(
		long utenteId, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUtenteId(
			utenteId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione findByUtenteId_First(
			long utenteId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByUtenteId_First(
			utenteId, orderByComparator);
	}

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione fetchByUtenteId_First(
		long utenteId,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return getPersistence().fetchByUtenteId_First(
			utenteId, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione findByUtenteId_Last(
			long utenteId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByUtenteId_Last(
			utenteId, orderByComparator);
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione fetchByUtenteId_Last(
		long utenteId,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return getPersistence().fetchByUtenteId_Last(
			utenteId, orderByComparator);
	}

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione[]
			findByUtenteId_PrevAndNext(
				it.servizidigitali.profiloutente.service.persistence.
					UtenteOrganizzazioneCanaleComunicazionePK
						utenteOrganizzazioneCanaleComunicazionePK,
				long utenteId,
				OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
					orderByComparator)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByUtenteId_PrevAndNext(
			utenteOrganizzazioneCanaleComunicazionePK, utenteId,
			orderByComparator);
	}

	/**
	 * Removes all the utente organizzazione canale comunicaziones where utenteId = &#63; from the database.
	 *
	 * @param utenteId the utente ID
	 */
	public static void removeByUtenteId(long utenteId) {
		getPersistence().removeByUtenteId(utenteId);
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	public static int countByUtenteId(long utenteId) {
		return getPersistence().countByUtenteId(utenteId);
	}

	/**
	 * Caches the utente organizzazione canale comunicazione in the entity cache if it is enabled.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazione the utente organizzazione canale comunicazione
	 */
	public static void cacheResult(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione) {

		getPersistence().cacheResult(utenteOrganizzazioneCanaleComunicazione);
	}

	/**
	 * Caches the utente organizzazione canale comunicaziones in the entity cache if it is enabled.
	 *
	 * @param utenteOrganizzazioneCanaleComunicaziones the utente organizzazione canale comunicaziones
	 */
	public static void cacheResult(
		List<UtenteOrganizzazioneCanaleComunicazione>
			utenteOrganizzazioneCanaleComunicaziones) {

		getPersistence().cacheResult(utenteOrganizzazioneCanaleComunicaziones);
	}

	/**
	 * Creates a new utente organizzazione canale comunicazione with the primary key. Does not add the utente organizzazione canale comunicazione to the database.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key for the new utente organizzazione canale comunicazione
	 * @return the new utente organizzazione canale comunicazione
	 */
	public static UtenteOrganizzazioneCanaleComunicazione create(
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazioneCanaleComunicazionePK
				utenteOrganizzazioneCanaleComunicazionePK) {

		return getPersistence().create(
			utenteOrganizzazioneCanaleComunicazionePK);
	}

	/**
	 * Removes the utente organizzazione canale comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione that was removed
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione remove(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazioneCanaleComunicazionePK
					utenteOrganizzazioneCanaleComunicazionePK)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().remove(
			utenteOrganizzazioneCanaleComunicazionePK);
	}

	public static UtenteOrganizzazioneCanaleComunicazione updateImpl(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione) {

		return getPersistence().updateImpl(
			utenteOrganizzazioneCanaleComunicazione);
	}

	/**
	 * Returns the utente organizzazione canale comunicazione with the primary key or throws a <code>NoSuchUtenteOrganizzazioneCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione findByPrimaryKey(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazioneCanaleComunicazionePK
					utenteOrganizzazioneCanaleComunicazionePK)
		throws it.servizidigitali.profiloutente.exception.
			NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return getPersistence().findByPrimaryKey(
			utenteOrganizzazioneCanaleComunicazionePK);
	}

	/**
	 * Returns the utente organizzazione canale comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione, or <code>null</code> if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione fetchByPrimaryKey(
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazioneCanaleComunicazionePK
				utenteOrganizzazioneCanaleComunicazionePK) {

		return getPersistence().fetchByPrimaryKey(
			utenteOrganizzazioneCanaleComunicazionePK);
	}

	/**
	 * Returns all the utente organizzazione canale comunicaziones.
	 *
	 * @return the utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findAll(
		int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione> findAll(
		int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the utente organizzazione canale comunicaziones from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones.
	 *
	 * @return the number of utente organizzazione canale comunicaziones
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static UtenteOrganizzazioneCanaleComunicazionePersistence
		getPersistence() {

		return _persistence;
	}

	private static volatile UtenteOrganizzazioneCanaleComunicazionePersistence
		_persistence;

}