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

package it.servizidigitali.gestioneprocedure.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneprocedure.model.TemplatePdf;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TemplatePdf. This utility wraps
 * <code>it.servizidigitali.gestioneprocedure.service.impl.TemplatePdfLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TemplatePdfLocalService
 * @generated
 */
public class TemplatePdfLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestioneprocedure.service.impl.TemplatePdfLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the template pdf to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TemplatePdfLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templatePdf the template pdf
	 * @return the template pdf that was added
	 */
	public static TemplatePdf addTemplatePdf(TemplatePdf templatePdf) {
		return getService().addTemplatePdf(templatePdf);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new template pdf with the primary key. Does not add the template pdf to the database.
	 *
	 * @param templatePdfId the primary key for the new template pdf
	 * @return the new template pdf
	 */
	public static TemplatePdf createTemplatePdf(long templatePdfId) {
		return getService().createTemplatePdf(templatePdfId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the template pdf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TemplatePdfLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf that was removed
	 * @throws PortalException if a template pdf with the primary key could not be found
	 */
	public static TemplatePdf deleteTemplatePdf(long templatePdfId)
		throws PortalException {

		return getService().deleteTemplatePdf(templatePdfId);
	}

	/**
	 * Deletes the template pdf from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TemplatePdfLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templatePdf the template pdf
	 * @return the template pdf that was removed
	 */
	public static TemplatePdf deleteTemplatePdf(TemplatePdf templatePdf) {
		return getService().deleteTemplatePdf(templatePdf);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static TemplatePdf fetchTemplatePdf(long templatePdfId) {
		return getService().fetchTemplatePdf(templatePdfId);
	}

	/**
	 * Returns the template pdf matching the UUID and group.
	 *
	 * @param uuid the template pdf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public static TemplatePdf fetchTemplatePdfByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTemplatePdfByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the template pdf with the primary key.
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf
	 * @throws PortalException if a template pdf with the primary key could not be found
	 */
	public static TemplatePdf getTemplatePdf(long templatePdfId)
		throws PortalException {

		return getService().getTemplatePdf(templatePdfId);
	}

	public static List<TemplatePdf> getTemplatePdfByProceduraId(
		long proceduraId) {

		return getService().getTemplatePdfByProceduraId(proceduraId);
	}

	public static List<TemplatePdf> getTemplatePdfByProceduraIdAndTipoTemplate(
		long proceduraId, String tipoTemplate) {

		return getService().getTemplatePdfByProceduraIdAndTipoTemplate(
			proceduraId, tipoTemplate);
	}

	/**
	 * Returns the template pdf matching the UUID and group.
	 *
	 * @param uuid the template pdf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching template pdf
	 * @throws PortalException if a matching template pdf could not be found
	 */
	public static TemplatePdf getTemplatePdfByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getTemplatePdfByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the template pdfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of template pdfs
	 */
	public static List<TemplatePdf> getTemplatePdfs(int start, int end) {
		return getService().getTemplatePdfs(start, end);
	}

	/**
	 * Returns all the template pdfs matching the UUID and company.
	 *
	 * @param uuid the UUID of the template pdfs
	 * @param companyId the primary key of the company
	 * @return the matching template pdfs, or an empty list if no matches were found
	 */
	public static List<TemplatePdf> getTemplatePdfsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTemplatePdfsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of template pdfs matching the UUID and company.
	 *
	 * @param uuid the UUID of the template pdfs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching template pdfs, or an empty list if no matches were found
	 */
	public static List<TemplatePdf> getTemplatePdfsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return getService().getTemplatePdfsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of template pdfs.
	 *
	 * @return the number of template pdfs
	 */
	public static int getTemplatePdfsCount() {
		return getService().getTemplatePdfsCount();
	}

	/**
	 * Updates the template pdf in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TemplatePdfLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templatePdf the template pdf
	 * @return the template pdf that was updated
	 */
	public static TemplatePdf updateTemplatePdf(TemplatePdf templatePdf) {
		return getService().updateTemplatePdf(templatePdf);
	}

	public static TemplatePdfLocalService getService() {
		return _service;
	}

	private static volatile TemplatePdfLocalService _service;

}