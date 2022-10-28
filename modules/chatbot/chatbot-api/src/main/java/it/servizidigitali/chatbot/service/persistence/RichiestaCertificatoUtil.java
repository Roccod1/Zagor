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

package it.servizidigitali.chatbot.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.chatbot.model.RichiestaCertificato;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the richiesta certificato service. This utility wraps <code>it.servizidigitali.chatbot.service.persistence.impl.RichiestaCertificatoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaCertificatoPersistence
 * @generated
 */
public class RichiestaCertificatoUtil {

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
	public static void clearCache(RichiestaCertificato richiestaCertificato) {
		getPersistence().clearCache(richiestaCertificato);
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
	public static Map<Serializable, RichiestaCertificato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RichiestaCertificato> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RichiestaCertificato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RichiestaCertificato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RichiestaCertificato update(
		RichiestaCertificato richiestaCertificato) {

		return getPersistence().update(richiestaCertificato);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RichiestaCertificato update(
		RichiestaCertificato richiestaCertificato,
		ServiceContext serviceContext) {

		return getPersistence().update(richiestaCertificato, serviceContext);
	}

	/**
	 * Returns all the richiesta certificatos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the richiesta certificatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByUuid_First(
			String uuid,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByUuid_First(
		String uuid,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByUuid_Last(
			String uuid,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByUuid_Last(
		String uuid,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public static RichiestaCertificato[] findByUuid_PrevAndNext(
			long richiestaCertificatoId, String uuid,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByUuid_PrevAndNext(
			richiestaCertificatoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the richiesta certificatos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of richiesta certificatos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching richiesta certificatos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the richiesta certificato where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRichiestaCertificatoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the richiesta certificato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the richiesta certificato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the richiesta certificato where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the richiesta certificato that was removed
	 */
	public static RichiestaCertificato removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of richiesta certificatos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching richiesta certificatos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public static RichiestaCertificato[] findByUuid_C_PrevAndNext(
			long richiestaCertificatoId, String uuid, long companyId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			richiestaCertificatoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the richiesta certificatos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching richiesta certificatos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByCodiceFiscale(
		String codiceFiscale) {

		return getPersistence().findByCodiceFiscale(codiceFiscale);
	}

	/**
	 * Returns a range of all the richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByCodiceFiscale(
		String codiceFiscale, int start, int end) {

		return getPersistence().findByCodiceFiscale(codiceFiscale, start, end);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByCodiceFiscale(
		String codiceFiscale, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().findByCodiceFiscale(
			codiceFiscale, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByCodiceFiscale(
		String codiceFiscale, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCodiceFiscale(
			codiceFiscale, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByCodiceFiscale_First(
			String codiceFiscale,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByCodiceFiscale_First(
			codiceFiscale, orderByComparator);
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByCodiceFiscale_First(
		String codiceFiscale,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().fetchByCodiceFiscale_First(
			codiceFiscale, orderByComparator);
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByCodiceFiscale_Last(
			String codiceFiscale,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByCodiceFiscale_Last(
			codiceFiscale, orderByComparator);
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByCodiceFiscale_Last(
		String codiceFiscale,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().fetchByCodiceFiscale_Last(
			codiceFiscale, orderByComparator);
	}

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public static RichiestaCertificato[] findByCodiceFiscale_PrevAndNext(
			long richiestaCertificatoId, String codiceFiscale,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByCodiceFiscale_PrevAndNext(
			richiestaCertificatoId, codiceFiscale, orderByComparator);
	}

	/**
	 * Removes all the richiesta certificatos where codiceFiscale = &#63; from the database.
	 *
	 * @param codiceFiscale the codice fiscale
	 */
	public static void removeByCodiceFiscale(String codiceFiscale) {
		getPersistence().removeByCodiceFiscale(codiceFiscale);
	}

	/**
	 * Returns the number of richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the number of matching richiesta certificatos
	 */
	public static int countByCodiceFiscale(String codiceFiscale) {
		return getPersistence().countByCodiceFiscale(codiceFiscale);
	}

	/**
	 * Returns all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @return the matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId) {

		return getPersistence().findByCodiceFiscaleGroupId(
			codiceFiscale, groupId);
	}

	/**
	 * Returns a range of all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId, int start, int end) {

		return getPersistence().findByCodiceFiscaleGroupId(
			codiceFiscale, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().findByCodiceFiscaleGroupId(
			codiceFiscale, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCodiceFiscaleGroupId(
			codiceFiscale, groupId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByCodiceFiscaleGroupId_First(
			String codiceFiscale, long groupId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByCodiceFiscaleGroupId_First(
			codiceFiscale, groupId, orderByComparator);
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByCodiceFiscaleGroupId_First(
		String codiceFiscale, long groupId,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().fetchByCodiceFiscaleGroupId_First(
			codiceFiscale, groupId, orderByComparator);
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByCodiceFiscaleGroupId_Last(
			String codiceFiscale, long groupId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByCodiceFiscaleGroupId_Last(
			codiceFiscale, groupId, orderByComparator);
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByCodiceFiscaleGroupId_Last(
		String codiceFiscale, long groupId,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().fetchByCodiceFiscaleGroupId_Last(
			codiceFiscale, groupId, orderByComparator);
	}

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public static RichiestaCertificato[] findByCodiceFiscaleGroupId_PrevAndNext(
			long richiestaCertificatoId, String codiceFiscale, long groupId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByCodiceFiscaleGroupId_PrevAndNext(
			richiestaCertificatoId, codiceFiscale, groupId, orderByComparator);
	}

	/**
	 * Removes all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63; from the database.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 */
	public static void removeByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId) {

		getPersistence().removeByCodiceFiscaleGroupId(codiceFiscale, groupId);
	}

	/**
	 * Returns the number of richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @return the number of matching richiesta certificatos
	 */
	public static int countByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId) {

		return getPersistence().countByCodiceFiscaleGroupId(
			codiceFiscale, groupId);
	}

	/**
	 * Returns all the richiesta certificatos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByStato(String stato) {
		return getPersistence().findByStato(stato);
	}

	/**
	 * Returns a range of all the richiesta certificatos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByStato(
		String stato, int start, int end) {

		return getPersistence().findByStato(stato, start, end);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByStato(
		String stato, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().findByStato(
			stato, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByStato(
		String stato, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStato(
			stato, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByStato_First(
			String stato,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByStato_First(stato, orderByComparator);
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByStato_First(
		String stato,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().fetchByStato_First(stato, orderByComparator);
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByStato_Last(
			String stato,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByStato_Last(stato, orderByComparator);
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByStato_Last(
		String stato,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().fetchByStato_Last(stato, orderByComparator);
	}

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public static RichiestaCertificato[] findByStato_PrevAndNext(
			long richiestaCertificatoId, String stato,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByStato_PrevAndNext(
			richiestaCertificatoId, stato, orderByComparator);
	}

	/**
	 * Removes all the richiesta certificatos where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	public static void removeByStato(String stato) {
		getPersistence().removeByStato(stato);
	}

	/**
	 * Returns the number of richiesta certificatos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching richiesta certificatos
	 */
	public static int countByStato(String stato) {
		return getPersistence().countByStato(stato);
	}

	/**
	 * Returns the richiesta certificato where richiestaId = &#63; or throws a <code>NoSuchRichiestaCertificatoException</code> if it could not be found.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByRichiestaId(long richiestaId)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByRichiestaId(richiestaId);
	}

	/**
	 * Returns the richiesta certificato where richiestaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByRichiestaId(long richiestaId) {
		return getPersistence().fetchByRichiestaId(richiestaId);
	}

	/**
	 * Returns the richiesta certificato where richiestaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByRichiestaId(
		long richiestaId, boolean useFinderCache) {

		return getPersistence().fetchByRichiestaId(richiestaId, useFinderCache);
	}

	/**
	 * Removes the richiesta certificato where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the richiesta certificato that was removed
	 */
	public static RichiestaCertificato removeByRichiestaId(long richiestaId)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().removeByRichiestaId(richiestaId);
	}

	/**
	 * Returns the number of richiesta certificatos where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching richiesta certificatos
	 */
	public static int countByRichiestaId(long richiestaId) {
		return getPersistence().countByRichiestaId(richiestaId);
	}

	/**
	 * Returns all the richiesta certificatos where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByServizioId(long servizioId) {
		return getPersistence().findByServizioId(servizioId);
	}

	/**
	 * Returns a range of all the richiesta certificatos where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByServizioId(
		long servizioId, int start, int end) {

		return getPersistence().findByServizioId(servizioId, start, end);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().findByServizioId(
			servizioId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	public static List<RichiestaCertificato> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByServizioId(
			servizioId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByServizioId_First(
			long servizioId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByServizioId_First(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByServizioId_First(
		long servizioId,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().fetchByServizioId_First(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByServizioId_Last(
			long servizioId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByServizioId_Last(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByServizioId_Last(
		long servizioId,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().fetchByServizioId_Last(
			servizioId, orderByComparator);
	}

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public static RichiestaCertificato[] findByServizioId_PrevAndNext(
			long richiestaCertificatoId, long servizioId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByServizioId_PrevAndNext(
			richiestaCertificatoId, servizioId, orderByComparator);
	}

	/**
	 * Removes all the richiesta certificatos where servizioId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 */
	public static void removeByServizioId(long servizioId) {
		getPersistence().removeByServizioId(servizioId);
	}

	/**
	 * Returns the number of richiesta certificatos where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the number of matching richiesta certificatos
	 */
	public static int countByServizioId(long servizioId) {
		return getPersistence().countByServizioId(servizioId);
	}

	/**
	 * Returns the richiesta certificato where servizioId = &#63; and groupId = &#63; or throws a <code>NoSuchRichiestaCertificatoException</code> if it could not be found.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @return the matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato findByServizioIdGroupId(
			long servizioId, long groupId)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByServizioIdGroupId(servizioId, groupId);
	}

	/**
	 * Returns the richiesta certificato where servizioId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByServizioIdGroupId(
		long servizioId, long groupId) {

		return getPersistence().fetchByServizioIdGroupId(servizioId, groupId);
	}

	/**
	 * Returns the richiesta certificato where servizioId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato fetchByServizioIdGroupId(
		long servizioId, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByServizioIdGroupId(
			servizioId, groupId, useFinderCache);
	}

	/**
	 * Removes the richiesta certificato where servizioId = &#63; and groupId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @return the richiesta certificato that was removed
	 */
	public static RichiestaCertificato removeByServizioIdGroupId(
			long servizioId, long groupId)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().removeByServizioIdGroupId(servizioId, groupId);
	}

	/**
	 * Returns the number of richiesta certificatos where servizioId = &#63; and groupId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @return the number of matching richiesta certificatos
	 */
	public static int countByServizioIdGroupId(long servizioId, long groupId) {
		return getPersistence().countByServizioIdGroupId(servizioId, groupId);
	}

	/**
	 * Caches the richiesta certificato in the entity cache if it is enabled.
	 *
	 * @param richiestaCertificato the richiesta certificato
	 */
	public static void cacheResult(RichiestaCertificato richiestaCertificato) {
		getPersistence().cacheResult(richiestaCertificato);
	}

	/**
	 * Caches the richiesta certificatos in the entity cache if it is enabled.
	 *
	 * @param richiestaCertificatos the richiesta certificatos
	 */
	public static void cacheResult(
		List<RichiestaCertificato> richiestaCertificatos) {

		getPersistence().cacheResult(richiestaCertificatos);
	}

	/**
	 * Creates a new richiesta certificato with the primary key. Does not add the richiesta certificato to the database.
	 *
	 * @param richiestaCertificatoId the primary key for the new richiesta certificato
	 * @return the new richiesta certificato
	 */
	public static RichiestaCertificato create(long richiestaCertificatoId) {
		return getPersistence().create(richiestaCertificatoId);
	}

	/**
	 * Removes the richiesta certificato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato that was removed
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public static RichiestaCertificato remove(long richiestaCertificatoId)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().remove(richiestaCertificatoId);
	}

	public static RichiestaCertificato updateImpl(
		RichiestaCertificato richiestaCertificato) {

		return getPersistence().updateImpl(richiestaCertificato);
	}

	/**
	 * Returns the richiesta certificato with the primary key or throws a <code>NoSuchRichiestaCertificatoException</code> if it could not be found.
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public static RichiestaCertificato findByPrimaryKey(
			long richiestaCertificatoId)
		throws it.servizidigitali.chatbot.exception.
			NoSuchRichiestaCertificatoException {

		return getPersistence().findByPrimaryKey(richiestaCertificatoId);
	}

	/**
	 * Returns the richiesta certificato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato, or <code>null</code> if a richiesta certificato with the primary key could not be found
	 */
	public static RichiestaCertificato fetchByPrimaryKey(
		long richiestaCertificatoId) {

		return getPersistence().fetchByPrimaryKey(richiestaCertificatoId);
	}

	/**
	 * Returns all the richiesta certificatos.
	 *
	 * @return the richiesta certificatos
	 */
	public static List<RichiestaCertificato> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the richiesta certificatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of richiesta certificatos
	 */
	public static List<RichiestaCertificato> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiesta certificatos
	 */
	public static List<RichiestaCertificato> findAll(
		int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of richiesta certificatos
	 */
	public static List<RichiestaCertificato> findAll(
		int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the richiesta certificatos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of richiesta certificatos.
	 *
	 * @return the number of richiesta certificatos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RichiestaCertificatoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RichiestaCertificatoPersistence _persistence;

}