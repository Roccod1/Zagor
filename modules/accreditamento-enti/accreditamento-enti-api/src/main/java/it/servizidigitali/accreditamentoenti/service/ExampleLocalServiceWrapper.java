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

package it.servizidigitali.accreditamentoenti.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExampleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExampleLocalService
 * @generated
 */
public class ExampleLocalServiceWrapper
	implements ExampleLocalService, ServiceWrapper<ExampleLocalService> {

	public ExampleLocalServiceWrapper() {
		this(null);
	}

	public ExampleLocalServiceWrapper(ExampleLocalService exampleLocalService) {
		_exampleLocalService = exampleLocalService;
	}

	/**
	 * Adds the example to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExampleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param example the example
	 * @return the example that was added
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Example addExample(
		it.servizidigitali.accreditamentoenti.model.Example example) {

		return _exampleLocalService.addExample(example);
	}

	/**
	 * Creates a new example with the primary key. Does not add the example to the database.
	 *
	 * @param exampleId the primary key for the new example
	 * @return the new example
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Example createExample(
		long exampleId) {

		return _exampleLocalService.createExample(exampleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exampleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the example from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExampleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param example the example
	 * @return the example that was removed
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Example deleteExample(
		it.servizidigitali.accreditamentoenti.model.Example example) {

		return _exampleLocalService.deleteExample(example);
	}

	/**
	 * Deletes the example with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExampleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param exampleId the primary key of the example
	 * @return the example that was removed
	 * @throws PortalException if a example with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Example deleteExample(
			long exampleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exampleLocalService.deleteExample(exampleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exampleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _exampleLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _exampleLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _exampleLocalService.dynamicQuery();
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

		return _exampleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.accreditamentoenti.model.impl.ExampleModelImpl</code>.
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

		return _exampleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.accreditamentoenti.model.impl.ExampleModelImpl</code>.
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

		return _exampleLocalService.dynamicQuery(
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

		return _exampleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _exampleLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.accreditamentoenti.model.Example fetchExample(
		long exampleId) {

		return _exampleLocalService.fetchExample(exampleId);
	}

	/**
	 * Returns the example matching the UUID and group.
	 *
	 * @param uuid the example's UUID
	 * @param groupId the primary key of the group
	 * @return the matching example, or <code>null</code> if a matching example could not be found
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Example
		fetchExampleByUuidAndGroupId(String uuid, long groupId) {

		return _exampleLocalService.fetchExampleByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _exampleLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the example with the primary key.
	 *
	 * @param exampleId the primary key of the example
	 * @return the example
	 * @throws PortalException if a example with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Example getExample(
			long exampleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exampleLocalService.getExample(exampleId);
	}

	/**
	 * Returns the example matching the UUID and group.
	 *
	 * @param uuid the example's UUID
	 * @param groupId the primary key of the group
	 * @return the matching example
	 * @throws PortalException if a matching example could not be found
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Example
			getExampleByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exampleLocalService.getExampleByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the examples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.accreditamentoenti.model.impl.ExampleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of examples
	 * @param end the upper bound of the range of examples (not inclusive)
	 * @return the range of examples
	 */
	@Override
	public java.util.List<it.servizidigitali.accreditamentoenti.model.Example>
		getExamples(int start, int end) {

		return _exampleLocalService.getExamples(start, end);
	}

	/**
	 * Returns all the examples matching the UUID and company.
	 *
	 * @param uuid the UUID of the examples
	 * @param companyId the primary key of the company
	 * @return the matching examples, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.accreditamentoenti.model.Example>
		getExamplesByUuidAndCompanyId(String uuid, long companyId) {

		return _exampleLocalService.getExamplesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of examples matching the UUID and company.
	 *
	 * @param uuid the UUID of the examples
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of examples
	 * @param end the upper bound of the range of examples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching examples, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.accreditamentoenti.model.Example>
		getExamplesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.accreditamentoenti.model.Example>
					orderByComparator) {

		return _exampleLocalService.getExamplesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of examples.
	 *
	 * @return the number of examples
	 */
	@Override
	public int getExamplesCount() {
		return _exampleLocalService.getExamplesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _exampleLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _exampleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _exampleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exampleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the example in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExampleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param example the example
	 * @return the example that was updated
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Example updateExample(
		it.servizidigitali.accreditamentoenti.model.Example example) {

		return _exampleLocalService.updateExample(example);
	}

	@Override
	public ExampleLocalService getWrappedService() {
		return _exampleLocalService;
	}

	@Override
	public void setWrappedService(ExampleLocalService exampleLocalService) {
		_exampleLocalService = exampleLocalService;
	}

	private ExampleLocalService _exampleLocalService;

}