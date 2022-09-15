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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TemplatePdfLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TemplatePdfLocalService
 * @generated
 */
public class TemplatePdfLocalServiceWrapper
	implements ServiceWrapper<TemplatePdfLocalService>,
			   TemplatePdfLocalService {

	public TemplatePdfLocalServiceWrapper() {
		this(null);
	}

	public TemplatePdfLocalServiceWrapper(
		TemplatePdfLocalService templatePdfLocalService) {

		_templatePdfLocalService = templatePdfLocalService;
	}

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
	@Override
	public it.servizidigitali.gestioneprocedure.model.TemplatePdf
		addTemplatePdf(
			it.servizidigitali.gestioneprocedure.model.TemplatePdf
				templatePdf) {

		return _templatePdfLocalService.addTemplatePdf(templatePdf);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _templatePdfLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new template pdf with the primary key. Does not add the template pdf to the database.
	 *
	 * @param templatePdfId the primary key for the new template pdf
	 * @return the new template pdf
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.TemplatePdf
		createTemplatePdf(long templatePdfId) {

		return _templatePdfLocalService.createTemplatePdf(templatePdfId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _templatePdfLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public it.servizidigitali.gestioneprocedure.model.TemplatePdf
			deleteTemplatePdf(long templatePdfId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _templatePdfLocalService.deleteTemplatePdf(templatePdfId);
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
	@Override
	public it.servizidigitali.gestioneprocedure.model.TemplatePdf
		deleteTemplatePdf(
			it.servizidigitali.gestioneprocedure.model.TemplatePdf
				templatePdf) {

		return _templatePdfLocalService.deleteTemplatePdf(templatePdf);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _templatePdfLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _templatePdfLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _templatePdfLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _templatePdfLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _templatePdfLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _templatePdfLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _templatePdfLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _templatePdfLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestioneprocedure.model.TemplatePdf
		fetchTemplatePdf(long templatePdfId) {

		return _templatePdfLocalService.fetchTemplatePdf(templatePdfId);
	}

	/**
	 * Returns the template pdf with the matching UUID and company.
	 *
	 * @param uuid the template pdf's UUID
	 * @param companyId the primary key of the company
	 * @return the matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.TemplatePdf
		fetchTemplatePdfByUuidAndCompanyId(String uuid, long companyId) {

		return _templatePdfLocalService.fetchTemplatePdfByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _templatePdfLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _templatePdfLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _templatePdfLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _templatePdfLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _templatePdfLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the template pdf with the primary key.
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf
	 * @throws PortalException if a template pdf with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.TemplatePdf
			getTemplatePdf(long templatePdfId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _templatePdfLocalService.getTemplatePdf(templatePdfId);
	}

	@Override
	public java.util.List
		<it.servizidigitali.gestioneprocedure.model.TemplatePdf>
			getTemplatePdfByProceduraId(long proceduraId) {

		return _templatePdfLocalService.getTemplatePdfByProceduraId(
			proceduraId);
	}

	@Override
	public java.util.List
		<it.servizidigitali.gestioneprocedure.model.TemplatePdf>
			getTemplatePdfByProceduraIdAndAttivo(
				long proceduraId, boolean attivo) {

		return _templatePdfLocalService.getTemplatePdfByProceduraIdAndAttivo(
			proceduraId, attivo);
	}

	/**
	 * Returns the template pdf with the matching UUID and company.
	 *
	 * @param uuid the template pdf's UUID
	 * @param companyId the primary key of the company
	 * @return the matching template pdf
	 * @throws PortalException if a matching template pdf could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.TemplatePdf
			getTemplatePdfByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _templatePdfLocalService.getTemplatePdfByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List
		<it.servizidigitali.gestioneprocedure.model.TemplatePdf>
			getTemplatePdfs(int start, int end) {

		return _templatePdfLocalService.getTemplatePdfs(start, end);
	}

	/**
	 * Returns the number of template pdfs.
	 *
	 * @return the number of template pdfs
	 */
	@Override
	public int getTemplatePdfsCount() {
		return _templatePdfLocalService.getTemplatePdfsCount();
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
	@Override
	public it.servizidigitali.gestioneprocedure.model.TemplatePdf
		updateTemplatePdf(
			it.servizidigitali.gestioneprocedure.model.TemplatePdf
				templatePdf) {

		return _templatePdfLocalService.updateTemplatePdf(templatePdf);
	}

	@Override
	public TemplatePdfLocalService getWrappedService() {
		return _templatePdfLocalService;
	}

	@Override
	public void setWrappedService(
		TemplatePdfLocalService templatePdfLocalService) {

		_templatePdfLocalService = templatePdfLocalService;
	}

	private TemplatePdfLocalService _templatePdfLocalService;

}