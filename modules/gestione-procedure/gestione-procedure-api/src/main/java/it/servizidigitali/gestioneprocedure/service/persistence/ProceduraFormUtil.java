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

package it.servizidigitali.gestioneprocedure.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneprocedure.model.ProceduraForm;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the procedura form service. This utility wraps <code>it.servizidigitali.gestioneprocedure.service.persistence.impl.ProceduraFormPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProceduraFormPersistence
 * @generated
 */
public class ProceduraFormUtil {

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
	public static void clearCache(ProceduraForm proceduraForm) {
		getPersistence().clearCache(proceduraForm);
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
	public static Map<Serializable, ProceduraForm> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProceduraForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProceduraForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProceduraForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProceduraForm update(ProceduraForm proceduraForm) {
		return getPersistence().update(proceduraForm);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProceduraForm update(
		ProceduraForm proceduraForm, ServiceContext serviceContext) {

		return getPersistence().update(proceduraForm, serviceContext);
	}

	/**
	 * Returns all the procedura forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedura forms
	 */
	public static List<ProceduraForm> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the procedura forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @return the range of matching procedura forms
	 */
	public static List<ProceduraForm> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the procedura forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedura forms
	 */
	public static List<ProceduraForm> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedura forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedura forms
	 */
	public static List<ProceduraForm> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	public static ProceduraForm findByUuid_First(
			String uuid, OrderByComparator<ProceduraForm> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraFormException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	public static ProceduraForm fetchByUuid_First(
		String uuid, OrderByComparator<ProceduraForm> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	public static ProceduraForm findByUuid_Last(
			String uuid, OrderByComparator<ProceduraForm> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraFormException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	public static ProceduraForm fetchByUuid_Last(
		String uuid, OrderByComparator<ProceduraForm> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the procedura forms before and after the current procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param proceduraFormPK the primary key of the current procedura form
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura form
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	public static ProceduraForm[] findByUuid_PrevAndNext(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK,
			String uuid, OrderByComparator<ProceduraForm> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraFormException {

		return getPersistence().findByUuid_PrevAndNext(
			proceduraFormPK, uuid, orderByComparator);
	}

	/**
	 * Removes all the procedura forms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of procedura forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedura forms
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedura forms
	 */
	public static List<ProceduraForm> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @return the range of matching procedura forms
	 */
	public static List<ProceduraForm> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedura forms
	 */
	public static List<ProceduraForm> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedura forms
	 */
	public static List<ProceduraForm> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	public static ProceduraForm findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraFormException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	public static ProceduraForm fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProceduraForm> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	public static ProceduraForm findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraFormException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	public static ProceduraForm fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProceduraForm> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the procedura forms before and after the current procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param proceduraFormPK the primary key of the current procedura form
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura form
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	public static ProceduraForm[] findByUuid_C_PrevAndNext(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK,
			String uuid, long companyId,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraFormException {

		return getPersistence().findByUuid_C_PrevAndNext(
			proceduraFormPK, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the procedura forms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedura forms
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the procedura forms where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the matching procedura forms
	 */
	public static List<ProceduraForm> findByproceduraId(long proceduraId) {
		return getPersistence().findByproceduraId(proceduraId);
	}

	/**
	 * Returns a range of all the procedura forms where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @return the range of matching procedura forms
	 */
	public static List<ProceduraForm> findByproceduraId(
		long proceduraId, int start, int end) {

		return getPersistence().findByproceduraId(proceduraId, start, end);
	}

	/**
	 * Returns an ordered range of all the procedura forms where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedura forms
	 */
	public static List<ProceduraForm> findByproceduraId(
		long proceduraId, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator) {

		return getPersistence().findByproceduraId(
			proceduraId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedura forms where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedura forms
	 */
	public static List<ProceduraForm> findByproceduraId(
		long proceduraId, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByproceduraId(
			proceduraId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedura form in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	public static ProceduraForm findByproceduraId_First(
			long proceduraId,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraFormException {

		return getPersistence().findByproceduraId_First(
			proceduraId, orderByComparator);
	}

	/**
	 * Returns the first procedura form in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	public static ProceduraForm fetchByproceduraId_First(
		long proceduraId, OrderByComparator<ProceduraForm> orderByComparator) {

		return getPersistence().fetchByproceduraId_First(
			proceduraId, orderByComparator);
	}

	/**
	 * Returns the last procedura form in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	public static ProceduraForm findByproceduraId_Last(
			long proceduraId,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraFormException {

		return getPersistence().findByproceduraId_Last(
			proceduraId, orderByComparator);
	}

	/**
	 * Returns the last procedura form in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	public static ProceduraForm fetchByproceduraId_Last(
		long proceduraId, OrderByComparator<ProceduraForm> orderByComparator) {

		return getPersistence().fetchByproceduraId_Last(
			proceduraId, orderByComparator);
	}

	/**
	 * Returns the procedura forms before and after the current procedura form in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraFormPK the primary key of the current procedura form
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura form
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	public static ProceduraForm[] findByproceduraId_PrevAndNext(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK,
			long proceduraId,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraFormException {

		return getPersistence().findByproceduraId_PrevAndNext(
			proceduraFormPK, proceduraId, orderByComparator);
	}

	/**
	 * Removes all the procedura forms where proceduraId = &#63; from the database.
	 *
	 * @param proceduraId the procedura ID
	 */
	public static void removeByproceduraId(long proceduraId) {
		getPersistence().removeByproceduraId(proceduraId);
	}

	/**
	 * Returns the number of procedura forms where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the number of matching procedura forms
	 */
	public static int countByproceduraId(long proceduraId) {
		return getPersistence().countByproceduraId(proceduraId);
	}

	/**
	 * Caches the procedura form in the entity cache if it is enabled.
	 *
	 * @param proceduraForm the procedura form
	 */
	public static void cacheResult(ProceduraForm proceduraForm) {
		getPersistence().cacheResult(proceduraForm);
	}

	/**
	 * Caches the procedura forms in the entity cache if it is enabled.
	 *
	 * @param proceduraForms the procedura forms
	 */
	public static void cacheResult(List<ProceduraForm> proceduraForms) {
		getPersistence().cacheResult(proceduraForms);
	}

	/**
	 * Creates a new procedura form with the primary key. Does not add the procedura form to the database.
	 *
	 * @param proceduraFormPK the primary key for the new procedura form
	 * @return the new procedura form
	 */
	public static ProceduraForm create(
		it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK
			proceduraFormPK) {

		return getPersistence().create(proceduraFormPK);
	}

	/**
	 * Removes the procedura form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proceduraFormPK the primary key of the procedura form
	 * @return the procedura form that was removed
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	public static ProceduraForm remove(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraFormException {

		return getPersistence().remove(proceduraFormPK);
	}

	public static ProceduraForm updateImpl(ProceduraForm proceduraForm) {
		return getPersistence().updateImpl(proceduraForm);
	}

	/**
	 * Returns the procedura form with the primary key or throws a <code>NoSuchProceduraFormException</code> if it could not be found.
	 *
	 * @param proceduraFormPK the primary key of the procedura form
	 * @return the procedura form
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	public static ProceduraForm findByPrimaryKey(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchProceduraFormException {

		return getPersistence().findByPrimaryKey(proceduraFormPK);
	}

	/**
	 * Returns the procedura form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proceduraFormPK the primary key of the procedura form
	 * @return the procedura form, or <code>null</code> if a procedura form with the primary key could not be found
	 */
	public static ProceduraForm fetchByPrimaryKey(
		it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK
			proceduraFormPK) {

		return getPersistence().fetchByPrimaryKey(proceduraFormPK);
	}

	/**
	 * Returns all the procedura forms.
	 *
	 * @return the procedura forms
	 */
	public static List<ProceduraForm> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the procedura forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @return the range of procedura forms
	 */
	public static List<ProceduraForm> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the procedura forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedura forms
	 */
	public static List<ProceduraForm> findAll(
		int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedura forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedura forms
	 */
	public static List<ProceduraForm> findAll(
		int start, int end, OrderByComparator<ProceduraForm> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the procedura forms from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of procedura forms.
	 *
	 * @return the number of procedura forms
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static ProceduraFormPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProceduraFormPersistence _persistence;

}