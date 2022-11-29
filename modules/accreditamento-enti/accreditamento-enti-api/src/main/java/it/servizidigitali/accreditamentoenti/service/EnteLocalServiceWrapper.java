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
 * Provides a wrapper for {@link EnteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EnteLocalService
 * @generated
 */
public class EnteLocalServiceWrapper
	implements EnteLocalService, ServiceWrapper<EnteLocalService> {

	public EnteLocalServiceWrapper() {
		this(null);
	}

	public EnteLocalServiceWrapper(EnteLocalService enteLocalService) {
		_enteLocalService = enteLocalService;
	}

	/**
	 * Adds the ente to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ente the ente
	 * @return the ente that was added
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Ente addEnte(
		it.servizidigitali.accreditamentoenti.model.Ente ente) {

		return _enteLocalService.addEnte(ente);
	}

	/**
	 * Creates a new ente with the primary key. Does not add the ente to the database.
	 *
	 * @param enteId the primary key for the new ente
	 * @return the new ente
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Ente createEnte(
		long enteId) {

		return _enteLocalService.createEnte(enteId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enteLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the ente from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ente the ente
	 * @return the ente that was removed
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Ente deleteEnte(
		it.servizidigitali.accreditamentoenti.model.Ente ente) {

		return _enteLocalService.deleteEnte(ente);
	}

	/**
	 * Deletes the ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enteId the primary key of the ente
	 * @return the ente that was removed
	 * @throws PortalException if a ente with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Ente deleteEnte(
			long enteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enteLocalService.deleteEnte(enteId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enteLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _enteLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _enteLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _enteLocalService.dynamicQuery();
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

		return _enteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.accreditamentoenti.model.impl.EnteModelImpl</code>.
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

		return _enteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.accreditamentoenti.model.impl.EnteModelImpl</code>.
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

		return _enteLocalService.dynamicQuery(
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

		return _enteLocalService.dynamicQueryCount(dynamicQuery);
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

		return _enteLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.accreditamentoenti.model.Ente fetchEnte(
		long enteId) {

		return _enteLocalService.fetchEnte(enteId);
	}

	/**
	 * Returns the ente matching the UUID and group.
	 *
	 * @param uuid the ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ente, or <code>null</code> if a matching ente could not be found
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Ente
		fetchEnteByUuidAndGroupId(String uuid, long groupId) {

		return _enteLocalService.fetchEnteByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _enteLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ente with the primary key.
	 *
	 * @param enteId the primary key of the ente
	 * @return the ente
	 * @throws PortalException if a ente with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Ente getEnte(long enteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enteLocalService.getEnte(enteId);
	}

	/**
	 * Returns the ente matching the UUID and group.
	 *
	 * @param uuid the ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ente
	 * @throws PortalException if a matching ente could not be found
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Ente
			getEnteByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enteLocalService.getEnteByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.accreditamentoenti.model.impl.EnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @return the range of entes
	 */
	@Override
	public java.util.List<it.servizidigitali.accreditamentoenti.model.Ente>
		getEntes(int start, int end) {

		return _enteLocalService.getEntes(start, end);
	}

	/**
	 * Returns all the entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the entes
	 * @param companyId the primary key of the company
	 * @return the matching entes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.accreditamentoenti.model.Ente>
		getEntesByUuidAndCompanyId(String uuid, long companyId) {

		return _enteLocalService.getEntesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the entes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching entes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.accreditamentoenti.model.Ente>
		getEntesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.accreditamentoenti.model.Ente>
					orderByComparator) {

		return _enteLocalService.getEntesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of entes.
	 *
	 * @return the number of entes
	 */
	@Override
	public int getEntesCount() {
		return _enteLocalService.getEntesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _enteLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _enteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _enteLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the ente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ente the ente
	 * @return the ente that was updated
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.Ente updateEnte(
		it.servizidigitali.accreditamentoenti.model.Ente ente) {

		return _enteLocalService.updateEnte(ente);
	}

	@Override
	public EnteLocalService getWrappedService() {
		return _enteLocalService;
	}

	@Override
	public void setWrappedService(EnteLocalService enteLocalService) {
		_enteLocalService = enteLocalService;
	}

	private EnteLocalService _enteLocalService;

}