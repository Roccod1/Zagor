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

import it.servizidigitali.gestioneprocedure.model.TemplatePdf;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the template pdf service. This utility wraps <code>it.servizidigitali.gestioneprocedure.service.persistence.impl.TemplatePdfPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TemplatePdfPersistence
 * @generated
 */
public class TemplatePdfUtil {

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
	public static void clearCache(TemplatePdf templatePdf) {
		getPersistence().clearCache(templatePdf);
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
	public static Map<Serializable, TemplatePdf> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TemplatePdf> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TemplatePdf> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TemplatePdf> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TemplatePdf update(TemplatePdf templatePdf) {
		return getPersistence().update(templatePdf);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TemplatePdf update(
		TemplatePdf templatePdf, ServiceContext serviceContext) {

		return getPersistence().update(templatePdf, serviceContext);
	}

	/**
	 * Returns all the template pdfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching template pdfs
	 */
	public static List<TemplatePdf> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the template pdfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of matching template pdfs
	 */
	public static List<TemplatePdf> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the template pdfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template pdfs
	 */
	public static List<TemplatePdf> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the template pdfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching template pdfs
	 */
	public static List<TemplatePdf> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public static TemplatePdf findByUuid_First(
			String uuid, OrderByComparator<TemplatePdf> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchTemplatePdfException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public static TemplatePdf fetchByUuid_First(
		String uuid, OrderByComparator<TemplatePdf> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public static TemplatePdf findByUuid_Last(
			String uuid, OrderByComparator<TemplatePdf> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchTemplatePdfException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public static TemplatePdf fetchByUuid_Last(
		String uuid, OrderByComparator<TemplatePdf> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the template pdfs before and after the current template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param templatePdfId the primary key of the current template pdf
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	public static TemplatePdf[] findByUuid_PrevAndNext(
			long templatePdfId, String uuid,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchTemplatePdfException {

		return getPersistence().findByUuid_PrevAndNext(
			templatePdfId, uuid, orderByComparator);
	}

	/**
	 * Removes all the template pdfs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of template pdfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching template pdfs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching template pdfs
	 */
	public static List<TemplatePdf> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of matching template pdfs
	 */
	public static List<TemplatePdf> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template pdfs
	 */
	public static List<TemplatePdf> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching template pdfs
	 */
	public static List<TemplatePdf> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public static TemplatePdf findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchTemplatePdfException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public static TemplatePdf fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public static TemplatePdf findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchTemplatePdfException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public static TemplatePdf fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the template pdfs before and after the current template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param templatePdfId the primary key of the current template pdf
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	public static TemplatePdf[] findByUuid_C_PrevAndNext(
			long templatePdfId, String uuid, long companyId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchTemplatePdfException {

		return getPersistence().findByUuid_C_PrevAndNext(
			templatePdfId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the template pdfs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching template pdfs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the template pdfs where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @return the matching template pdfs
	 */
	public static List<TemplatePdf> findByTemplatePdfParentId(
		long templatePdfParentId) {

		return getPersistence().findByTemplatePdfParentId(templatePdfParentId);
	}

	/**
	 * Returns a range of all the template pdfs where templatePdfParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of matching template pdfs
	 */
	public static List<TemplatePdf> findByTemplatePdfParentId(
		long templatePdfParentId, int start, int end) {

		return getPersistence().findByTemplatePdfParentId(
			templatePdfParentId, start, end);
	}

	/**
	 * Returns an ordered range of all the template pdfs where templatePdfParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template pdfs
	 */
	public static List<TemplatePdf> findByTemplatePdfParentId(
		long templatePdfParentId, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return getPersistence().findByTemplatePdfParentId(
			templatePdfParentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the template pdfs where templatePdfParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching template pdfs
	 */
	public static List<TemplatePdf> findByTemplatePdfParentId(
		long templatePdfParentId, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTemplatePdfParentId(
			templatePdfParentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public static TemplatePdf findByTemplatePdfParentId_First(
			long templatePdfParentId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchTemplatePdfException {

		return getPersistence().findByTemplatePdfParentId_First(
			templatePdfParentId, orderByComparator);
	}

	/**
	 * Returns the first template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public static TemplatePdf fetchByTemplatePdfParentId_First(
		long templatePdfParentId,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return getPersistence().fetchByTemplatePdfParentId_First(
			templatePdfParentId, orderByComparator);
	}

	/**
	 * Returns the last template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public static TemplatePdf findByTemplatePdfParentId_Last(
			long templatePdfParentId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchTemplatePdfException {

		return getPersistence().findByTemplatePdfParentId_Last(
			templatePdfParentId, orderByComparator);
	}

	/**
	 * Returns the last template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public static TemplatePdf fetchByTemplatePdfParentId_Last(
		long templatePdfParentId,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return getPersistence().fetchByTemplatePdfParentId_Last(
			templatePdfParentId, orderByComparator);
	}

	/**
	 * Returns the template pdfs before and after the current template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfId the primary key of the current template pdf
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	public static TemplatePdf[] findByTemplatePdfParentId_PrevAndNext(
			long templatePdfId, long templatePdfParentId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchTemplatePdfException {

		return getPersistence().findByTemplatePdfParentId_PrevAndNext(
			templatePdfId, templatePdfParentId, orderByComparator);
	}

	/**
	 * Removes all the template pdfs where templatePdfParentId = &#63; from the database.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 */
	public static void removeByTemplatePdfParentId(long templatePdfParentId) {
		getPersistence().removeByTemplatePdfParentId(templatePdfParentId);
	}

	/**
	 * Returns the number of template pdfs where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @return the number of matching template pdfs
	 */
	public static int countByTemplatePdfParentId(long templatePdfParentId) {
		return getPersistence().countByTemplatePdfParentId(templatePdfParentId);
	}

	/**
	 * Caches the template pdf in the entity cache if it is enabled.
	 *
	 * @param templatePdf the template pdf
	 */
	public static void cacheResult(TemplatePdf templatePdf) {
		getPersistence().cacheResult(templatePdf);
	}

	/**
	 * Caches the template pdfs in the entity cache if it is enabled.
	 *
	 * @param templatePdfs the template pdfs
	 */
	public static void cacheResult(List<TemplatePdf> templatePdfs) {
		getPersistence().cacheResult(templatePdfs);
	}

	/**
	 * Creates a new template pdf with the primary key. Does not add the template pdf to the database.
	 *
	 * @param templatePdfId the primary key for the new template pdf
	 * @return the new template pdf
	 */
	public static TemplatePdf create(long templatePdfId) {
		return getPersistence().create(templatePdfId);
	}

	/**
	 * Removes the template pdf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf that was removed
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	public static TemplatePdf remove(long templatePdfId)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchTemplatePdfException {

		return getPersistence().remove(templatePdfId);
	}

	public static TemplatePdf updateImpl(TemplatePdf templatePdf) {
		return getPersistence().updateImpl(templatePdf);
	}

	/**
	 * Returns the template pdf with the primary key or throws a <code>NoSuchTemplatePdfException</code> if it could not be found.
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	public static TemplatePdf findByPrimaryKey(long templatePdfId)
		throws it.servizidigitali.gestioneprocedure.exception.
			NoSuchTemplatePdfException {

		return getPersistence().findByPrimaryKey(templatePdfId);
	}

	/**
	 * Returns the template pdf with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf, or <code>null</code> if a template pdf with the primary key could not be found
	 */
	public static TemplatePdf fetchByPrimaryKey(long templatePdfId) {
		return getPersistence().fetchByPrimaryKey(templatePdfId);
	}

	/**
	 * Returns all the template pdfs.
	 *
	 * @return the template pdfs
	 */
	public static List<TemplatePdf> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the template pdfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of template pdfs
	 */
	public static List<TemplatePdf> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the template pdfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of template pdfs
	 */
	public static List<TemplatePdf> findAll(
		int start, int end, OrderByComparator<TemplatePdf> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the template pdfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of template pdfs
	 */
	public static List<TemplatePdf> findAll(
		int start, int end, OrderByComparator<TemplatePdf> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the template pdfs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of template pdfs.
	 *
	 * @return the number of template pdfs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TemplatePdfPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TemplatePdfPersistence _persistence;

}