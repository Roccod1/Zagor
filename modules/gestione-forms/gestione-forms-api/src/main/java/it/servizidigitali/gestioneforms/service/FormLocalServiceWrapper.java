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

package it.servizidigitali.gestioneforms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FormLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FormLocalService
 * @generated
 */
public class FormLocalServiceWrapper
	implements FormLocalService, ServiceWrapper<FormLocalService> {

	public FormLocalServiceWrapper() {
		this(null);
	}

	public FormLocalServiceWrapper(FormLocalService formLocalService) {
		_formLocalService = formLocalService;
	}

	/**
	 * Adds the form to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param form the form
	 * @return the form that was added
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.Form addForm(
		it.servizidigitali.gestioneforms.model.Form form) {

		return _formLocalService.addForm(form);
	}

	/**
	 * Creates a new form with the primary key. Does not add the form to the database.
	 *
	 * @param formId the primary key for the new form
	 * @return the new form
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.Form createForm(long formId) {
		return _formLocalService.createForm(formId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the form from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param form the form
	 * @return the form that was removed
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.Form deleteForm(
		it.servizidigitali.gestioneforms.model.Form form) {

		return _formLocalService.deleteForm(form);
	}

	/**
	 * Deletes the form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formId the primary key of the form
	 * @return the form that was removed
	 * @throws PortalException if a form with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.Form deleteForm(long formId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formLocalService.deleteForm(formId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _formLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _formLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _formLocalService.dynamicQuery();
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

		return _formLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.FormModelImpl</code>.
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

		return _formLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.FormModelImpl</code>.
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

		return _formLocalService.dynamicQuery(
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

		return _formLocalService.dynamicQueryCount(dynamicQuery);
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

		return _formLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestioneforms.model.Form fetchForm(long formId) {
		return _formLocalService.fetchForm(formId);
	}

	/**
	 * Returns the form matching the UUID and group.
	 *
	 * @param uuid the form's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form, or <code>null</code> if a matching form could not be found
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.Form
		fetchFormByUuidAndGroupId(String uuid, long groupId) {

		return _formLocalService.fetchFormByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _formLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _formLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the form with the primary key.
	 *
	 * @param formId the primary key of the form
	 * @return the form
	 * @throws PortalException if a form with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.Form getForm(long formId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formLocalService.getForm(formId);
	}

	/**
	 * Returns the form matching the UUID and group.
	 *
	 * @param uuid the form's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form
	 * @throws PortalException if a matching form could not be found
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.Form getFormByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formLocalService.getFormByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.FormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @return the range of forms
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneforms.model.Form> getForms(
		int start, int end) {

		return _formLocalService.getForms(start, end);
	}

	/**
	 * Returns all the forms matching the UUID and company.
	 *
	 * @param uuid the UUID of the forms
	 * @param companyId the primary key of the company
	 * @return the matching forms, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneforms.model.Form>
		getFormsByUuidAndCompanyId(String uuid, long companyId) {

		return _formLocalService.getFormsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of forms matching the UUID and company.
	 *
	 * @param uuid the UUID of the forms
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching forms, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneforms.model.Form>
		getFormsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestioneforms.model.Form>
					orderByComparator) {

		return _formLocalService.getFormsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of forms.
	 *
	 * @return the number of forms
	 */
	@Override
	public int getFormsCount() {
		return _formLocalService.getFormsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _formLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _formLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param form the form
	 * @return the form that was updated
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.Form updateForm(
		it.servizidigitali.gestioneforms.model.Form form) {

		return _formLocalService.updateForm(form);
	}

	@Override
	public FormLocalService getWrappedService() {
		return _formLocalService;
	}

	@Override
	public void setWrappedService(FormLocalService formLocalService) {
		_formLocalService = formLocalService;
	}

	private FormLocalService _formLocalService;

}