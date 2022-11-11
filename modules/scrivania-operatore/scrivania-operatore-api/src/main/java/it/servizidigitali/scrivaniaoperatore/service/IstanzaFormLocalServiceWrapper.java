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

package it.servizidigitali.scrivaniaoperatore.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IstanzaFormLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see IstanzaFormLocalService
 * @generated
 */
public class IstanzaFormLocalServiceWrapper
	implements IstanzaFormLocalService,
			   ServiceWrapper<IstanzaFormLocalService> {

	public IstanzaFormLocalServiceWrapper() {
		this(null);
	}

	public IstanzaFormLocalServiceWrapper(
		IstanzaFormLocalService istanzaFormLocalService) {

		_istanzaFormLocalService = istanzaFormLocalService;
	}

	/**
	 * Adds the istanza form to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IstanzaFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param istanzaForm the istanza form
	 * @return the istanza form that was added
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
		addIstanzaForm(
			it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
				istanzaForm) {

		return _istanzaFormLocalService.addIstanzaForm(istanzaForm);
	}

	/**
	 * Creates a new istanza form with the primary key. Does not add the istanza form to the database.
	 *
	 * @param istanzaFormId the primary key for the new istanza form
	 * @return the new istanza form
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
		createIstanzaForm(long istanzaFormId) {

		return _istanzaFormLocalService.createIstanzaForm(istanzaFormId);
	}

	@Override
	public it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
		createIstanzaForm(
			String json, long formId, long richiestaId, long userId,
			String userName, long groupId, long companyId) {

		return _istanzaFormLocalService.createIstanzaForm(
			json, formId, richiestaId, userId, userName, groupId, companyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _istanzaFormLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the istanza form from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IstanzaFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param istanzaForm the istanza form
	 * @return the istanza form that was removed
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
		deleteIstanzaForm(
			it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
				istanzaForm) {

		return _istanzaFormLocalService.deleteIstanzaForm(istanzaForm);
	}

	/**
	 * Deletes the istanza form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IstanzaFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form that was removed
	 * @throws PortalException if a istanza form with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
			deleteIstanzaForm(long istanzaFormId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _istanzaFormLocalService.deleteIstanzaForm(istanzaFormId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _istanzaFormLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _istanzaFormLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _istanzaFormLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _istanzaFormLocalService.dynamicQuery();
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

		return _istanzaFormLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.IstanzaFormModelImpl</code>.
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

		return _istanzaFormLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.IstanzaFormModelImpl</code>.
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

		return _istanzaFormLocalService.dynamicQuery(
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

		return _istanzaFormLocalService.dynamicQueryCount(dynamicQuery);
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

		return _istanzaFormLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
		fetchIstanzaForm(long istanzaFormId) {

		return _istanzaFormLocalService.fetchIstanzaForm(istanzaFormId);
	}

	/**
	 * Returns the istanza form matching the UUID and group.
	 *
	 * @param uuid the istanza form's UUID
	 * @param groupId the primary key of the group
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
		fetchIstanzaFormByUuidAndGroupId(String uuid, long groupId) {

		return _istanzaFormLocalService.fetchIstanzaFormByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _istanzaFormLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _istanzaFormLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _istanzaFormLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the istanza form with the primary key.
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form
	 * @throws PortalException if a istanza form with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
			getIstanzaForm(long istanzaFormId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _istanzaFormLocalService.getIstanzaForm(istanzaFormId);
	}

	@Override
	public it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
		getIstanzaFormByRichiestaIdFormId(long richiestaId, long formId) {

		return _istanzaFormLocalService.getIstanzaFormByRichiestaIdFormId(
			richiestaId, formId);
	}

	/**
	 * Returns the istanza form matching the UUID and group.
	 *
	 * @param uuid the istanza form's UUID
	 * @param groupId the primary key of the group
	 * @return the matching istanza form
	 * @throws PortalException if a matching istanza form could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
			getIstanzaFormByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _istanzaFormLocalService.getIstanzaFormByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the istanza forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of istanza forms
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.IstanzaForm>
			getIstanzaForms(int start, int end) {

		return _istanzaFormLocalService.getIstanzaForms(start, end);
	}

	/**
	 * Returns all the istanza forms matching the UUID and company.
	 *
	 * @param uuid the UUID of the istanza forms
	 * @param companyId the primary key of the company
	 * @return the matching istanza forms, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.IstanzaForm>
			getIstanzaFormsByUuidAndCompanyId(String uuid, long companyId) {

		return _istanzaFormLocalService.getIstanzaFormsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of istanza forms matching the UUID and company.
	 *
	 * @param uuid the UUID of the istanza forms
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching istanza forms, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.IstanzaForm>
			getIstanzaFormsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<it.servizidigitali.scrivaniaoperatore.model.IstanzaForm>
						orderByComparator) {

		return _istanzaFormLocalService.getIstanzaFormsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of istanza forms.
	 *
	 * @return the number of istanza forms
	 */
	@Override
	public int getIstanzaFormsCount() {
		return _istanzaFormLocalService.getIstanzaFormsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _istanzaFormLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _istanzaFormLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the istanza form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IstanzaFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param istanzaForm the istanza form
	 * @return the istanza form that was updated
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
		updateIstanzaForm(
			it.servizidigitali.scrivaniaoperatore.model.IstanzaForm
				istanzaForm) {

		return _istanzaFormLocalService.updateIstanzaForm(istanzaForm);
	}

	@Override
	public IstanzaFormLocalService getWrappedService() {
		return _istanzaFormLocalService;
	}

	@Override
	public void setWrappedService(
		IstanzaFormLocalService istanzaFormLocalService) {

		_istanzaFormLocalService = istanzaFormLocalService;
	}

	private IstanzaFormLocalService _istanzaFormLocalService;

}