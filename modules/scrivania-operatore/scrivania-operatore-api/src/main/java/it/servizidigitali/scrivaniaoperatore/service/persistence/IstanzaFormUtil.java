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

import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the istanza form service. This utility wraps <code>it.servizidigitali.scrivaniaoperatore.service.persistence.impl.IstanzaFormPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IstanzaFormPersistence
 * @generated
 */
public class IstanzaFormUtil {

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
	public static void clearCache(IstanzaForm istanzaForm) {
		getPersistence().clearCache(istanzaForm);
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
	public static Map<Serializable, IstanzaForm> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<IstanzaForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IstanzaForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IstanzaForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static IstanzaForm update(IstanzaForm istanzaForm) {
		return getPersistence().update(istanzaForm);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static IstanzaForm update(
		IstanzaForm istanzaForm, ServiceContext serviceContext) {

		return getPersistence().update(istanzaForm, serviceContext);
	}

	/**
	 * Returns all the istanza forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching istanza forms
	 */
	public static List<IstanzaForm> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the istanza forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of matching istanza forms
	 */
	public static List<IstanzaForm> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the istanza forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching istanza forms
	 */
	public static List<IstanzaForm> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the istanza forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching istanza forms
	 */
	public static List<IstanzaForm> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public static IstanzaForm findByUuid_First(
			String uuid, OrderByComparator<IstanzaForm> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public static IstanzaForm fetchByUuid_First(
		String uuid, OrderByComparator<IstanzaForm> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public static IstanzaForm findByUuid_Last(
			String uuid, OrderByComparator<IstanzaForm> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public static IstanzaForm fetchByUuid_Last(
		String uuid, OrderByComparator<IstanzaForm> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the istanza forms before and after the current istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param istanzaFormId the primary key of the current istanza form
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	public static IstanzaForm[] findByUuid_PrevAndNext(
			long istanzaFormId, String uuid,
			OrderByComparator<IstanzaForm> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().findByUuid_PrevAndNext(
			istanzaFormId, uuid, orderByComparator);
	}

	/**
	 * Removes all the istanza forms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of istanza forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching istanza forms
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the istanza form where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIstanzaFormException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public static IstanzaForm findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the istanza form where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public static IstanzaForm fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the istanza form where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public static IstanzaForm fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the istanza form where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the istanza form that was removed
	 */
	public static IstanzaForm removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of istanza forms where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching istanza forms
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching istanza forms
	 */
	public static List<IstanzaForm> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of matching istanza forms
	 */
	public static List<IstanzaForm> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching istanza forms
	 */
	public static List<IstanzaForm> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching istanza forms
	 */
	public static List<IstanzaForm> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public static IstanzaForm findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<IstanzaForm> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public static IstanzaForm fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<IstanzaForm> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public static IstanzaForm findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<IstanzaForm> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public static IstanzaForm fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<IstanzaForm> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the istanza forms before and after the current istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param istanzaFormId the primary key of the current istanza form
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	public static IstanzaForm[] findByUuid_C_PrevAndNext(
			long istanzaFormId, String uuid, long companyId,
			OrderByComparator<IstanzaForm> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().findByUuid_C_PrevAndNext(
			istanzaFormId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the istanza forms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching istanza forms
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the istanza form where richiestaId = &#63; or throws a <code>NoSuchIstanzaFormException</code> if it could not be found.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public static IstanzaForm findByRichiestaId(long richiestaId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().findByRichiestaId(richiestaId);
	}

	/**
	 * Returns the istanza form where richiestaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public static IstanzaForm fetchByRichiestaId(long richiestaId) {
		return getPersistence().fetchByRichiestaId(richiestaId);
	}

	/**
	 * Returns the istanza form where richiestaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public static IstanzaForm fetchByRichiestaId(
		long richiestaId, boolean useFinderCache) {

		return getPersistence().fetchByRichiestaId(richiestaId, useFinderCache);
	}

	/**
	 * Removes the istanza form where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the istanza form that was removed
	 */
	public static IstanzaForm removeByRichiestaId(long richiestaId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().removeByRichiestaId(richiestaId);
	}

	/**
	 * Returns the number of istanza forms where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching istanza forms
	 */
	public static int countByRichiestaId(long richiestaId) {
		return getPersistence().countByRichiestaId(richiestaId);
	}

	/**
	 * Returns all the istanza forms where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @return the matching istanza forms
	 */
	public static List<IstanzaForm> findByFormId(long formId) {
		return getPersistence().findByFormId(formId);
	}

	/**
	 * Returns a range of all the istanza forms where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of matching istanza forms
	 */
	public static List<IstanzaForm> findByFormId(
		long formId, int start, int end) {

		return getPersistence().findByFormId(formId, start, end);
	}

	/**
	 * Returns an ordered range of all the istanza forms where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching istanza forms
	 */
	public static List<IstanzaForm> findByFormId(
		long formId, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator) {

		return getPersistence().findByFormId(
			formId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the istanza forms where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching istanza forms
	 */
	public static List<IstanzaForm> findByFormId(
		long formId, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFormId(
			formId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first istanza form in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public static IstanzaForm findByFormId_First(
			long formId, OrderByComparator<IstanzaForm> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().findByFormId_First(formId, orderByComparator);
	}

	/**
	 * Returns the first istanza form in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public static IstanzaForm fetchByFormId_First(
		long formId, OrderByComparator<IstanzaForm> orderByComparator) {

		return getPersistence().fetchByFormId_First(formId, orderByComparator);
	}

	/**
	 * Returns the last istanza form in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public static IstanzaForm findByFormId_Last(
			long formId, OrderByComparator<IstanzaForm> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().findByFormId_Last(formId, orderByComparator);
	}

	/**
	 * Returns the last istanza form in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public static IstanzaForm fetchByFormId_Last(
		long formId, OrderByComparator<IstanzaForm> orderByComparator) {

		return getPersistence().fetchByFormId_Last(formId, orderByComparator);
	}

	/**
	 * Returns the istanza forms before and after the current istanza form in the ordered set where formId = &#63;.
	 *
	 * @param istanzaFormId the primary key of the current istanza form
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	public static IstanzaForm[] findByFormId_PrevAndNext(
			long istanzaFormId, long formId,
			OrderByComparator<IstanzaForm> orderByComparator)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().findByFormId_PrevAndNext(
			istanzaFormId, formId, orderByComparator);
	}

	/**
	 * Removes all the istanza forms where formId = &#63; from the database.
	 *
	 * @param formId the form ID
	 */
	public static void removeByFormId(long formId) {
		getPersistence().removeByFormId(formId);
	}

	/**
	 * Returns the number of istanza forms where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @return the number of matching istanza forms
	 */
	public static int countByFormId(long formId) {
		return getPersistence().countByFormId(formId);
	}

	/**
	 * Caches the istanza form in the entity cache if it is enabled.
	 *
	 * @param istanzaForm the istanza form
	 */
	public static void cacheResult(IstanzaForm istanzaForm) {
		getPersistence().cacheResult(istanzaForm);
	}

	/**
	 * Caches the istanza forms in the entity cache if it is enabled.
	 *
	 * @param istanzaForms the istanza forms
	 */
	public static void cacheResult(List<IstanzaForm> istanzaForms) {
		getPersistence().cacheResult(istanzaForms);
	}

	/**
	 * Creates a new istanza form with the primary key. Does not add the istanza form to the database.
	 *
	 * @param istanzaFormId the primary key for the new istanza form
	 * @return the new istanza form
	 */
	public static IstanzaForm create(long istanzaFormId) {
		return getPersistence().create(istanzaFormId);
	}

	/**
	 * Removes the istanza form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form that was removed
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	public static IstanzaForm remove(long istanzaFormId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().remove(istanzaFormId);
	}

	public static IstanzaForm updateImpl(IstanzaForm istanzaForm) {
		return getPersistence().updateImpl(istanzaForm);
	}

	/**
	 * Returns the istanza form with the primary key or throws a <code>NoSuchIstanzaFormException</code> if it could not be found.
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	public static IstanzaForm findByPrimaryKey(long istanzaFormId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchIstanzaFormException {

		return getPersistence().findByPrimaryKey(istanzaFormId);
	}

	/**
	 * Returns the istanza form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form, or <code>null</code> if a istanza form with the primary key could not be found
	 */
	public static IstanzaForm fetchByPrimaryKey(long istanzaFormId) {
		return getPersistence().fetchByPrimaryKey(istanzaFormId);
	}

	/**
	 * Returns all the istanza forms.
	 *
	 * @return the istanza forms
	 */
	public static List<IstanzaForm> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the istanza forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of istanza forms
	 */
	public static List<IstanzaForm> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the istanza forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of istanza forms
	 */
	public static List<IstanzaForm> findAll(
		int start, int end, OrderByComparator<IstanzaForm> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the istanza forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of istanza forms
	 */
	public static List<IstanzaForm> findAll(
		int start, int end, OrderByComparator<IstanzaForm> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the istanza forms from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of istanza forms.
	 *
	 * @return the number of istanza forms
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IstanzaFormPersistence getPersistence() {
		return _persistence;
	}

	private static volatile IstanzaFormPersistence _persistence;

}