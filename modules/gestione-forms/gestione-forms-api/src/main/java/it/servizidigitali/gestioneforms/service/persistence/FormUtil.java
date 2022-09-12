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

import it.servizidigitali.gestioneforms.model.Form;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the form service. This utility wraps <code>it.servizidigitali.gestioneforms.service.persistence.impl.FormPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormPersistence
 * @generated
 */
public class FormUtil {

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
	public static void clearCache(Form form) {
		getPersistence().clearCache(form);
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
	public static Map<Serializable, Form> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Form> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Form> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Form> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Form> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Form update(Form form) {
		return getPersistence().update(form);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Form update(Form form, ServiceContext serviceContext) {
		return getPersistence().update(form, serviceContext);
	}

	/**
	 * Returns all the forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching forms
	 */
	public static List<Form> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @return the range of matching forms
	 */
	public static List<Form> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching forms
	 */
	public static List<Form> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Form> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching forms
	 */
	public static List<Form> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Form> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public static Form findByUuid_First(
			String uuid, OrderByComparator<Form> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form, or <code>null</code> if a matching form could not be found
	 */
	public static Form fetchByUuid_First(
		String uuid, OrderByComparator<Form> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public static Form findByUuid_Last(
			String uuid, OrderByComparator<Form> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form, or <code>null</code> if a matching form could not be found
	 */
	public static Form fetchByUuid_Last(
		String uuid, OrderByComparator<Form> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the forms before and after the current form in the ordered set where uuid = &#63;.
	 *
	 * @param formId the primary key of the current form
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public static Form[] findByUuid_PrevAndNext(
			long formId, String uuid, OrderByComparator<Form> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByUuid_PrevAndNext(
			formId, uuid, orderByComparator);
	}

	/**
	 * Removes all the forms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching forms
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the form where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFormException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public static Form findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the form where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form, or <code>null</code> if a matching form could not be found
	 */
	public static Form fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the form where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form, or <code>null</code> if a matching form could not be found
	 */
	public static Form fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the form where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the form that was removed
	 */
	public static Form removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of forms where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching forms
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching forms
	 */
	public static List<Form> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @return the range of matching forms
	 */
	public static List<Form> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching forms
	 */
	public static List<Form> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Form> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching forms
	 */
	public static List<Form> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Form> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public static Form findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Form> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form, or <code>null</code> if a matching form could not be found
	 */
	public static Form fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Form> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public static Form findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Form> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form, or <code>null</code> if a matching form could not be found
	 */
	public static Form fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Form> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the forms before and after the current form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param formId the primary key of the current form
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public static Form[] findByUuid_C_PrevAndNext(
			long formId, String uuid, long companyId,
			OrderByComparator<Form> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByUuid_C_PrevAndNext(
			formId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the forms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching forms
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the form where codice = &#63; or throws a <code>NoSuchFormException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public static Form findByCodice(String codice)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByCodice(codice);
	}

	/**
	 * Returns the form where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching form, or <code>null</code> if a matching form could not be found
	 */
	public static Form fetchByCodice(String codice) {
		return getPersistence().fetchByCodice(codice);
	}

	/**
	 * Returns the form where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form, or <code>null</code> if a matching form could not be found
	 */
	public static Form fetchByCodice(String codice, boolean useFinderCache) {
		return getPersistence().fetchByCodice(codice, useFinderCache);
	}

	/**
	 * Removes the form where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the form that was removed
	 */
	public static Form removeByCodice(String codice)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().removeByCodice(codice);
	}

	/**
	 * Returns the number of forms where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching forms
	 */
	public static int countByCodice(String codice) {
		return getPersistence().countByCodice(codice);
	}

	/**
	 * Returns all the forms where principale = &#63;.
	 *
	 * @param principale the principale
	 * @return the matching forms
	 */
	public static List<Form> findByPrincipale(boolean principale) {
		return getPersistence().findByPrincipale(principale);
	}

	/**
	 * Returns a range of all the forms where principale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param principale the principale
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @return the range of matching forms
	 */
	public static List<Form> findByPrincipale(
		boolean principale, int start, int end) {

		return getPersistence().findByPrincipale(principale, start, end);
	}

	/**
	 * Returns an ordered range of all the forms where principale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param principale the principale
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching forms
	 */
	public static List<Form> findByPrincipale(
		boolean principale, int start, int end,
		OrderByComparator<Form> orderByComparator) {

		return getPersistence().findByPrincipale(
			principale, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the forms where principale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param principale the principale
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching forms
	 */
	public static List<Form> findByPrincipale(
		boolean principale, int start, int end,
		OrderByComparator<Form> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByPrincipale(
			principale, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first form in the ordered set where principale = &#63;.
	 *
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public static Form findByPrincipale_First(
			boolean principale, OrderByComparator<Form> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByPrincipale_First(
			principale, orderByComparator);
	}

	/**
	 * Returns the first form in the ordered set where principale = &#63;.
	 *
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form, or <code>null</code> if a matching form could not be found
	 */
	public static Form fetchByPrincipale_First(
		boolean principale, OrderByComparator<Form> orderByComparator) {

		return getPersistence().fetchByPrincipale_First(
			principale, orderByComparator);
	}

	/**
	 * Returns the last form in the ordered set where principale = &#63;.
	 *
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public static Form findByPrincipale_Last(
			boolean principale, OrderByComparator<Form> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByPrincipale_Last(
			principale, orderByComparator);
	}

	/**
	 * Returns the last form in the ordered set where principale = &#63;.
	 *
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form, or <code>null</code> if a matching form could not be found
	 */
	public static Form fetchByPrincipale_Last(
		boolean principale, OrderByComparator<Form> orderByComparator) {

		return getPersistence().fetchByPrincipale_Last(
			principale, orderByComparator);
	}

	/**
	 * Returns the forms before and after the current form in the ordered set where principale = &#63;.
	 *
	 * @param formId the primary key of the current form
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public static Form[] findByPrincipale_PrevAndNext(
			long formId, boolean principale,
			OrderByComparator<Form> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByPrincipale_PrevAndNext(
			formId, principale, orderByComparator);
	}

	/**
	 * Removes all the forms where principale = &#63; from the database.
	 *
	 * @param principale the principale
	 */
	public static void removeByPrincipale(boolean principale) {
		getPersistence().removeByPrincipale(principale);
	}

	/**
	 * Returns the number of forms where principale = &#63;.
	 *
	 * @param principale the principale
	 * @return the number of matching forms
	 */
	public static int countByPrincipale(boolean principale) {
		return getPersistence().countByPrincipale(principale);
	}

	/**
	 * Returns all the forms where principale = &#63; and groupId = &#63;.
	 *
	 * @param principale the principale
	 * @param groupId the group ID
	 * @return the matching forms
	 */
	public static List<Form> findByprincipaleAndGroupId(
		boolean principale, long groupId) {

		return getPersistence().findByprincipaleAndGroupId(principale, groupId);
	}

	/**
	 * Returns a range of all the forms where principale = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param principale the principale
	 * @param groupId the group ID
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @return the range of matching forms
	 */
	public static List<Form> findByprincipaleAndGroupId(
		boolean principale, long groupId, int start, int end) {

		return getPersistence().findByprincipaleAndGroupId(
			principale, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the forms where principale = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param principale the principale
	 * @param groupId the group ID
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching forms
	 */
	public static List<Form> findByprincipaleAndGroupId(
		boolean principale, long groupId, int start, int end,
		OrderByComparator<Form> orderByComparator) {

		return getPersistence().findByprincipaleAndGroupId(
			principale, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the forms where principale = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param principale the principale
	 * @param groupId the group ID
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching forms
	 */
	public static List<Form> findByprincipaleAndGroupId(
		boolean principale, long groupId, int start, int end,
		OrderByComparator<Form> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByprincipaleAndGroupId(
			principale, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first form in the ordered set where principale = &#63; and groupId = &#63;.
	 *
	 * @param principale the principale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public static Form findByprincipaleAndGroupId_First(
			boolean principale, long groupId,
			OrderByComparator<Form> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByprincipaleAndGroupId_First(
			principale, groupId, orderByComparator);
	}

	/**
	 * Returns the first form in the ordered set where principale = &#63; and groupId = &#63;.
	 *
	 * @param principale the principale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form, or <code>null</code> if a matching form could not be found
	 */
	public static Form fetchByprincipaleAndGroupId_First(
		boolean principale, long groupId,
		OrderByComparator<Form> orderByComparator) {

		return getPersistence().fetchByprincipaleAndGroupId_First(
			principale, groupId, orderByComparator);
	}

	/**
	 * Returns the last form in the ordered set where principale = &#63; and groupId = &#63;.
	 *
	 * @param principale the principale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public static Form findByprincipaleAndGroupId_Last(
			boolean principale, long groupId,
			OrderByComparator<Form> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByprincipaleAndGroupId_Last(
			principale, groupId, orderByComparator);
	}

	/**
	 * Returns the last form in the ordered set where principale = &#63; and groupId = &#63;.
	 *
	 * @param principale the principale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form, or <code>null</code> if a matching form could not be found
	 */
	public static Form fetchByprincipaleAndGroupId_Last(
		boolean principale, long groupId,
		OrderByComparator<Form> orderByComparator) {

		return getPersistence().fetchByprincipaleAndGroupId_Last(
			principale, groupId, orderByComparator);
	}

	/**
	 * Returns the forms before and after the current form in the ordered set where principale = &#63; and groupId = &#63;.
	 *
	 * @param formId the primary key of the current form
	 * @param principale the principale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public static Form[] findByprincipaleAndGroupId_PrevAndNext(
			long formId, boolean principale, long groupId,
			OrderByComparator<Form> orderByComparator)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByprincipaleAndGroupId_PrevAndNext(
			formId, principale, groupId, orderByComparator);
	}

	/**
	 * Removes all the forms where principale = &#63; and groupId = &#63; from the database.
	 *
	 * @param principale the principale
	 * @param groupId the group ID
	 */
	public static void removeByprincipaleAndGroupId(
		boolean principale, long groupId) {

		getPersistence().removeByprincipaleAndGroupId(principale, groupId);
	}

	/**
	 * Returns the number of forms where principale = &#63; and groupId = &#63;.
	 *
	 * @param principale the principale
	 * @param groupId the group ID
	 * @return the number of matching forms
	 */
	public static int countByprincipaleAndGroupId(
		boolean principale, long groupId) {

		return getPersistence().countByprincipaleAndGroupId(
			principale, groupId);
	}

	/**
	 * Caches the form in the entity cache if it is enabled.
	 *
	 * @param form the form
	 */
	public static void cacheResult(Form form) {
		getPersistence().cacheResult(form);
	}

	/**
	 * Caches the forms in the entity cache if it is enabled.
	 *
	 * @param forms the forms
	 */
	public static void cacheResult(List<Form> forms) {
		getPersistence().cacheResult(forms);
	}

	/**
	 * Creates a new form with the primary key. Does not add the form to the database.
	 *
	 * @param formId the primary key for the new form
	 * @return the new form
	 */
	public static Form create(long formId) {
		return getPersistence().create(formId);
	}

	/**
	 * Removes the form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formId the primary key of the form
	 * @return the form that was removed
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public static Form remove(long formId)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().remove(formId);
	}

	public static Form updateImpl(Form form) {
		return getPersistence().updateImpl(form);
	}

	/**
	 * Returns the form with the primary key or throws a <code>NoSuchFormException</code> if it could not be found.
	 *
	 * @param formId the primary key of the form
	 * @return the form
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public static Form findByPrimaryKey(long formId)
		throws it.servizidigitali.gestioneforms.exception.NoSuchFormException {

		return getPersistence().findByPrimaryKey(formId);
	}

	/**
	 * Returns the form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formId the primary key of the form
	 * @return the form, or <code>null</code> if a form with the primary key could not be found
	 */
	public static Form fetchByPrimaryKey(long formId) {
		return getPersistence().fetchByPrimaryKey(formId);
	}

	/**
	 * Returns all the forms.
	 *
	 * @return the forms
	 */
	public static List<Form> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @return the range of forms
	 */
	public static List<Form> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of forms
	 */
	public static List<Form> findAll(
		int start, int end, OrderByComparator<Form> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of forms
	 */
	public static List<Form> findAll(
		int start, int end, OrderByComparator<Form> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the forms from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of forms.
	 *
	 * @return the number of forms
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FormPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FormPersistence _persistence;

}