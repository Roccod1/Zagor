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
 * Provides a wrapper for {@link ResponsabileEnteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ResponsabileEnteLocalService
 * @generated
 */
public class ResponsabileEnteLocalServiceWrapper
	implements ResponsabileEnteLocalService,
			   ServiceWrapper<ResponsabileEnteLocalService> {

	public ResponsabileEnteLocalServiceWrapper() {
		this(null);
	}

	public ResponsabileEnteLocalServiceWrapper(
		ResponsabileEnteLocalService responsabileEnteLocalService) {

		_responsabileEnteLocalService = responsabileEnteLocalService;
	}

	/**
	 * Adds the responsabile ente to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResponsabileEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param responsabileEnte the responsabile ente
	 * @return the responsabile ente that was added
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
		addResponsabileEnte(
			it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
				responsabileEnte) {

		return _responsabileEnteLocalService.addResponsabileEnte(
			responsabileEnte);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _responsabileEnteLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new responsabile ente with the primary key. Does not add the responsabile ente to the database.
	 *
	 * @param responsabileEnteId the primary key for the new responsabile ente
	 * @return the new responsabile ente
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
		createResponsabileEnte(long responsabileEnteId) {

		return _responsabileEnteLocalService.createResponsabileEnte(
			responsabileEnteId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _responsabileEnteLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the responsabile ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResponsabileEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param responsabileEnteId the primary key of the responsabile ente
	 * @return the responsabile ente that was removed
	 * @throws PortalException if a responsabile ente with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
			deleteResponsabileEnte(long responsabileEnteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _responsabileEnteLocalService.deleteResponsabileEnte(
			responsabileEnteId);
	}

	/**
	 * Deletes the responsabile ente from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResponsabileEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param responsabileEnte the responsabile ente
	 * @return the responsabile ente that was removed
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
		deleteResponsabileEnte(
			it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
				responsabileEnte) {

		return _responsabileEnteLocalService.deleteResponsabileEnte(
			responsabileEnte);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _responsabileEnteLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _responsabileEnteLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _responsabileEnteLocalService.dynamicQuery();
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

		return _responsabileEnteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.accreditamentoenti.model.impl.ResponsabileEnteModelImpl</code>.
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

		return _responsabileEnteLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.accreditamentoenti.model.impl.ResponsabileEnteModelImpl</code>.
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

		return _responsabileEnteLocalService.dynamicQuery(
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

		return _responsabileEnteLocalService.dynamicQueryCount(dynamicQuery);
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

		return _responsabileEnteLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
		fetchResponsabileEnte(long responsabileEnteId) {

		return _responsabileEnteLocalService.fetchResponsabileEnte(
			responsabileEnteId);
	}

	/**
	 * Returns the responsabile ente matching the UUID and group.
	 *
	 * @param uuid the responsabile ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching responsabile ente, or <code>null</code> if a matching responsabile ente could not be found
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
		fetchResponsabileEnteByUuidAndGroupId(String uuid, long groupId) {

		return _responsabileEnteLocalService.
			fetchResponsabileEnteByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _responsabileEnteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _responsabileEnteLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _responsabileEnteLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _responsabileEnteLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _responsabileEnteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the responsabile ente with the primary key.
	 *
	 * @param responsabileEnteId the primary key of the responsabile ente
	 * @return the responsabile ente
	 * @throws PortalException if a responsabile ente with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
			getResponsabileEnte(long responsabileEnteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _responsabileEnteLocalService.getResponsabileEnte(
			responsabileEnteId);
	}

	@Override
	public java.util.List
		<it.servizidigitali.accreditamentoenti.model.ResponsabileEnte>
			getResponsabileEnteByEnteId(long enteId) {

		return _responsabileEnteLocalService.getResponsabileEnteByEnteId(
			enteId);
	}

	@Override
	public it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
			getResponsabileEnteByResponsabileUserIdAndEnteId(
				long responsabileUserId, long enteId)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchResponsabileEnteException {

		return _responsabileEnteLocalService.
			getResponsabileEnteByResponsabileUserIdAndEnteId(
				responsabileUserId, enteId);
	}

	/**
	 * Returns the responsabile ente matching the UUID and group.
	 *
	 * @param uuid the responsabile ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching responsabile ente
	 * @throws PortalException if a matching responsabile ente could not be found
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
			getResponsabileEnteByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _responsabileEnteLocalService.
			getResponsabileEnteByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the responsabile entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.accreditamentoenti.model.impl.ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @return the range of responsabile entes
	 */
	@Override
	public java.util.List
		<it.servizidigitali.accreditamentoenti.model.ResponsabileEnte>
			getResponsabileEntes(int start, int end) {

		return _responsabileEnteLocalService.getResponsabileEntes(start, end);
	}

	/**
	 * Returns all the responsabile entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the responsabile entes
	 * @param companyId the primary key of the company
	 * @return the matching responsabile entes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.accreditamentoenti.model.ResponsabileEnte>
			getResponsabileEntesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _responsabileEnteLocalService.
			getResponsabileEntesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of responsabile entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the responsabile entes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching responsabile entes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.accreditamentoenti.model.ResponsabileEnte>
			getResponsabileEntesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<it.servizidigitali.accreditamentoenti.model.
						ResponsabileEnte> orderByComparator) {

		return _responsabileEnteLocalService.
			getResponsabileEntesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of responsabile entes.
	 *
	 * @return the number of responsabile entes
	 */
	@Override
	public int getResponsabileEntesCount() {
		return _responsabileEnteLocalService.getResponsabileEntesCount();
	}

	/**
	 * Updates the responsabile ente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResponsabileEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param responsabileEnte the responsabile ente
	 * @return the responsabile ente that was updated
	 */
	@Override
	public it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
		updateResponsabileEnte(
			it.servizidigitali.accreditamentoenti.model.ResponsabileEnte
				responsabileEnte) {

		return _responsabileEnteLocalService.updateResponsabileEnte(
			responsabileEnte);
	}

	@Override
	public ResponsabileEnteLocalService getWrappedService() {
		return _responsabileEnteLocalService;
	}

	@Override
	public void setWrappedService(
		ResponsabileEnteLocalService responsabileEnteLocalService) {

		_responsabileEnteLocalService = responsabileEnteLocalService;
	}

	private ResponsabileEnteLocalService _responsabileEnteLocalService;

}