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

import it.servizidigitali.gestioneforms.model.TipoDocumento;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the tipo documento service. This utility wraps <code>it.servizidigitali.gestioneforms.service.persistence.impl.TipoDocumentoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoDocumentoPersistence
 * @generated
 */
public class TipoDocumentoUtil {

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
	public static void clearCache(TipoDocumento tipoDocumento) {
		getPersistence().clearCache(tipoDocumento);
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
	public static Map<Serializable, TipoDocumento> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TipoDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipoDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipoDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TipoDocumento update(TipoDocumento tipoDocumento) {
		return getPersistence().update(tipoDocumento);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TipoDocumento update(
		TipoDocumento tipoDocumento, ServiceContext serviceContext) {

		return getPersistence().update(tipoDocumento, serviceContext);
	}

	/**
	 * Returns all the tipo documentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tipo documentos
	 */
	public static List<TipoDocumento> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the tipo documentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of matching tipo documentos
	 */
	public static List<TipoDocumento> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the tipo documentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo documentos
	 */
	public static List<TipoDocumento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipo documentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo documentos
	 */
	public static List<TipoDocumento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public static TipoDocumento findByUuid_First(
			String uuid, OrderByComparator<TipoDocumento> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public static TipoDocumento fetchByUuid_First(
		String uuid, OrderByComparator<TipoDocumento> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public static TipoDocumento findByUuid_Last(
			String uuid, OrderByComparator<TipoDocumento> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public static TipoDocumento fetchByUuid_Last(
		String uuid, OrderByComparator<TipoDocumento> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the tipo documentos before and after the current tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param tipoDocumentoId the primary key of the current tipo documento
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	public static TipoDocumento[] findByUuid_PrevAndNext(
			long tipoDocumentoId, String uuid,
			OrderByComparator<TipoDocumento> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().findByUuid_PrevAndNext(
			tipoDocumentoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the tipo documentos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of tipo documentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tipo documentos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the tipo documento where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTipoDocumentoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public static TipoDocumento findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the tipo documento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public static TipoDocumento fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the tipo documento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public static TipoDocumento fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the tipo documento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tipo documento that was removed
	 */
	public static TipoDocumento removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of tipo documentos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tipo documentos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tipo documentos
	 */
	public static List<TipoDocumento> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of matching tipo documentos
	 */
	public static List<TipoDocumento> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo documentos
	 */
	public static List<TipoDocumento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo documentos
	 */
	public static List<TipoDocumento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public static TipoDocumento findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TipoDocumento> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public static TipoDocumento fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TipoDocumento> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public static TipoDocumento findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TipoDocumento> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public static TipoDocumento fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TipoDocumento> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the tipo documentos before and after the current tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param tipoDocumentoId the primary key of the current tipo documento
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	public static TipoDocumento[] findByUuid_C_PrevAndNext(
			long tipoDocumentoId, String uuid, long companyId,
			OrderByComparator<TipoDocumento> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			tipoDocumentoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the tipo documentos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tipo documentos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the tipo documentos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching tipo documentos
	 */
	public static List<TipoDocumento> findBystato(String stato) {
		return getPersistence().findBystato(stato);
	}

	/**
	 * Returns a range of all the tipo documentos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of matching tipo documentos
	 */
	public static List<TipoDocumento> findBystato(
		String stato, int start, int end) {

		return getPersistence().findBystato(stato, start, end);
	}

	/**
	 * Returns an ordered range of all the tipo documentos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo documentos
	 */
	public static List<TipoDocumento> findBystato(
		String stato, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator) {

		return getPersistence().findBystato(
			stato, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipo documentos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo documentos
	 */
	public static List<TipoDocumento> findBystato(
		String stato, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBystato(
			stato, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public static TipoDocumento findBystato_First(
			String stato, OrderByComparator<TipoDocumento> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().findBystato_First(stato, orderByComparator);
	}

	/**
	 * Returns the first tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public static TipoDocumento fetchBystato_First(
		String stato, OrderByComparator<TipoDocumento> orderByComparator) {

		return getPersistence().fetchBystato_First(stato, orderByComparator);
	}

	/**
	 * Returns the last tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public static TipoDocumento findBystato_Last(
			String stato, OrderByComparator<TipoDocumento> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().findBystato_Last(stato, orderByComparator);
	}

	/**
	 * Returns the last tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public static TipoDocumento fetchBystato_Last(
		String stato, OrderByComparator<TipoDocumento> orderByComparator) {

		return getPersistence().fetchBystato_Last(stato, orderByComparator);
	}

	/**
	 * Returns the tipo documentos before and after the current tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param tipoDocumentoId the primary key of the current tipo documento
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	public static TipoDocumento[] findBystato_PrevAndNext(
			long tipoDocumentoId, String stato,
			OrderByComparator<TipoDocumento> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().findBystato_PrevAndNext(
			tipoDocumentoId, stato, orderByComparator);
	}

	/**
	 * Removes all the tipo documentos where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	public static void removeBystato(String stato) {
		getPersistence().removeBystato(stato);
	}

	/**
	 * Returns the number of tipo documentos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching tipo documentos
	 */
	public static int countBystato(String stato) {
		return getPersistence().countBystato(stato);
	}

	/**
	 * Caches the tipo documento in the entity cache if it is enabled.
	 *
	 * @param tipoDocumento the tipo documento
	 */
	public static void cacheResult(TipoDocumento tipoDocumento) {
		getPersistence().cacheResult(tipoDocumento);
	}

	/**
	 * Caches the tipo documentos in the entity cache if it is enabled.
	 *
	 * @param tipoDocumentos the tipo documentos
	 */
	public static void cacheResult(List<TipoDocumento> tipoDocumentos) {
		getPersistence().cacheResult(tipoDocumentos);
	}

	/**
	 * Creates a new tipo documento with the primary key. Does not add the tipo documento to the database.
	 *
	 * @param tipoDocumentoId the primary key for the new tipo documento
	 * @return the new tipo documento
	 */
	public static TipoDocumento create(long tipoDocumentoId) {
		return getPersistence().create(tipoDocumentoId);
	}

	/**
	 * Removes the tipo documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento that was removed
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	public static TipoDocumento remove(long tipoDocumentoId)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().remove(tipoDocumentoId);
	}

	public static TipoDocumento updateImpl(TipoDocumento tipoDocumento) {
		return getPersistence().updateImpl(tipoDocumento);
	}

	/**
	 * Returns the tipo documento with the primary key or throws a <code>NoSuchTipoDocumentoException</code> if it could not be found.
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	public static TipoDocumento findByPrimaryKey(long tipoDocumentoId)
		throws it.servizidigitali.gestioneforms.exception.
			NoSuchTipoDocumentoException {

		return getPersistence().findByPrimaryKey(tipoDocumentoId);
	}

	/**
	 * Returns the tipo documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento, or <code>null</code> if a tipo documento with the primary key could not be found
	 */
	public static TipoDocumento fetchByPrimaryKey(long tipoDocumentoId) {
		return getPersistence().fetchByPrimaryKey(tipoDocumentoId);
	}

	/**
	 * Returns all the tipo documentos.
	 *
	 * @return the tipo documentos
	 */
	public static List<TipoDocumento> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the tipo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of tipo documentos
	 */
	public static List<TipoDocumento> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the tipo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipo documentos
	 */
	public static List<TipoDocumento> findAll(
		int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tipo documentos
	 */
	public static List<TipoDocumento> findAll(
		int start, int end, OrderByComparator<TipoDocumento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the tipo documentos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of tipo documentos.
	 *
	 * @return the number of tipo documentos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TipoDocumentoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TipoDocumentoPersistence _persistence;

}