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

package it.servizidigitali.gestioneenti.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EnteServizioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EnteServizioLocalService
 * @generated
 */
public class EnteServizioLocalServiceWrapper
	implements EnteServizioLocalService,
			   ServiceWrapper<EnteServizioLocalService> {

	public EnteServizioLocalServiceWrapper() {
		this(null);
	}

	public EnteServizioLocalServiceWrapper(
		EnteServizioLocalService enteServizioLocalService) {

		_enteServizioLocalService = enteServizioLocalService;
	}

	/**
	 * Adds the ente servizio to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnteServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enteServizio the ente servizio
	 * @return the ente servizio that was added
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.EnteServizio addEnteServizio(
		it.servizidigitali.gestioneenti.model.EnteServizio enteServizio) {

		return _enteServizioLocalService.addEnteServizio(enteServizio);
	}

	/**
	 * Creates a new ente servizio with the primary key. Does not add the ente servizio to the database.
	 *
	 * @param enteServizioPK the primary key for the new ente servizio
	 * @return the new ente servizio
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.EnteServizio
		createEnteServizio(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK) {

		return _enteServizioLocalService.createEnteServizio(enteServizioPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enteServizioLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the ente servizio from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnteServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enteServizio the ente servizio
	 * @return the ente servizio that was removed
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.EnteServizio
		deleteEnteServizio(
			it.servizidigitali.gestioneenti.model.EnteServizio enteServizio) {

		return _enteServizioLocalService.deleteEnteServizio(enteServizio);
	}

	/**
	 * Deletes the ente servizio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnteServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enteServizioPK the primary key of the ente servizio
	 * @return the ente servizio that was removed
	 * @throws PortalException if a ente servizio with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.EnteServizio
			deleteEnteServizio(
				it.servizidigitali.gestioneenti.service.persistence.
					EnteServizioPK enteServizioPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enteServizioLocalService.deleteEnteServizio(enteServizioPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enteServizioLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _enteServizioLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _enteServizioLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _enteServizioLocalService.dynamicQuery();
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

		return _enteServizioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneenti.model.impl.EnteServizioModelImpl</code>.
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

		return _enteServizioLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneenti.model.impl.EnteServizioModelImpl</code>.
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

		return _enteServizioLocalService.dynamicQuery(
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

		return _enteServizioLocalService.dynamicQueryCount(dynamicQuery);
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

		return _enteServizioLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestioneenti.model.EnteServizio fetchEnteServizio(
		it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
			enteServizioPK) {

		return _enteServizioLocalService.fetchEnteServizio(enteServizioPK);
	}

	/**
	 * Returns the ente servizio matching the UUID and group.
	 *
	 * @param uuid the ente servizio's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.EnteServizio
		fetchEnteServizioByUuidAndGroupId(String uuid, long groupId) {

		return _enteServizioLocalService.fetchEnteServizioByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _enteServizioLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ente servizio with the primary key.
	 *
	 * @param enteServizioPK the primary key of the ente servizio
	 * @return the ente servizio
	 * @throws PortalException if a ente servizio with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.EnteServizio getEnteServizio(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enteServizioLocalService.getEnteServizio(enteServizioPK);
	}

	/**
	 * Returns the ente servizio matching the UUID and group.
	 *
	 * @param uuid the ente servizio's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ente servizio
	 * @throws PortalException if a matching ente servizio could not be found
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.EnteServizio
			getEnteServizioByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enteServizioLocalService.getEnteServizioByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the ente servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneenti.model.impl.EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @return the range of ente servizios
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneenti.model.EnteServizio>
		getEnteServizios(int start, int end) {

		return _enteServizioLocalService.getEnteServizios(start, end);
	}

	/**
	 * Returns all the ente servizios matching the UUID and company.
	 *
	 * @param uuid the UUID of the ente servizios
	 * @param companyId the primary key of the company
	 * @return the matching ente servizios, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneenti.model.EnteServizio>
		getEnteServiziosByUuidAndCompanyId(String uuid, long companyId) {

		return _enteServizioLocalService.getEnteServiziosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of ente servizios matching the UUID and company.
	 *
	 * @param uuid the UUID of the ente servizios
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ente servizios, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneenti.model.EnteServizio>
		getEnteServiziosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestioneenti.model.EnteServizio>
					orderByComparator) {

		return _enteServizioLocalService.getEnteServiziosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ente servizios.
	 *
	 * @return the number of ente servizios
	 */
	@Override
	public int getEnteServiziosCount() {
		return _enteServizioLocalService.getEnteServiziosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _enteServizioLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _enteServizioLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _enteServizioLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enteServizioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the ente servizio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnteServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enteServizio the ente servizio
	 * @return the ente servizio that was updated
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.EnteServizio
		updateEnteServizio(
			it.servizidigitali.gestioneenti.model.EnteServizio enteServizio) {

		return _enteServizioLocalService.updateEnteServizio(enteServizio);
	}

	@Override
	public EnteServizioLocalService getWrappedService() {
		return _enteServizioLocalService;
	}

	@Override
	public void setWrappedService(
		EnteServizioLocalService enteServizioLocalService) {

		_enteServizioLocalService = enteServizioLocalService;
	}

	private EnteServizioLocalService _enteServizioLocalService;

}