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

package it.servizidigitali.gestioneservizi.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AreaTematicaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AreaTematicaLocalService
 * @generated
 */
public class AreaTematicaLocalServiceWrapper
	implements AreaTematicaLocalService,
			   ServiceWrapper<AreaTematicaLocalService> {

	public AreaTematicaLocalServiceWrapper() {
		this(null);
	}

	public AreaTematicaLocalServiceWrapper(
		AreaTematicaLocalService areaTematicaLocalService) {

		_areaTematicaLocalService = areaTematicaLocalService;
	}

	/**
	 * Adds the area tematica to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AreaTematicaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param areaTematica the area tematica
	 * @return the area tematica that was added
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.AreaTematica
		addAreaTematica(
			it.servizidigitali.gestioneservizi.model.AreaTematica
				areaTematica) {

		return _areaTematicaLocalService.addAreaTematica(areaTematica);
	}

	@Override
	public long count() throws Exception {
		return _areaTematicaLocalService.count();
	}

	/**
	 * Creates a new area tematica with the primary key. Does not add the area tematica to the database.
	 *
	 * @param areaTematicaId the primary key for the new area tematica
	 * @return the new area tematica
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.AreaTematica
		createAreaTematica(long areaTematicaId) {

		return _areaTematicaLocalService.createAreaTematica(areaTematicaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _areaTematicaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the area tematica from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AreaTematicaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param areaTematica the area tematica
	 * @return the area tematica that was removed
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.AreaTematica
		deleteAreaTematica(
			it.servizidigitali.gestioneservizi.model.AreaTematica
				areaTematica) {

		return _areaTematicaLocalService.deleteAreaTematica(areaTematica);
	}

	/**
	 * Deletes the area tematica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AreaTematicaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica that was removed
	 * @throws PortalException if a area tematica with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.AreaTematica
			deleteAreaTematica(long areaTematicaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _areaTematicaLocalService.deleteAreaTematica(areaTematicaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _areaTematicaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _areaTematicaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _areaTematicaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _areaTematicaLocalService.dynamicQuery();
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

		return _areaTematicaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.AreaTematicaModelImpl</code>.
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

		return _areaTematicaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.AreaTematicaModelImpl</code>.
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

		return _areaTematicaLocalService.dynamicQuery(
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

		return _areaTematicaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _areaTematicaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestioneservizi.model.AreaTematica
		fetchAreaTematica(long areaTematicaId) {

		return _areaTematicaLocalService.fetchAreaTematica(areaTematicaId);
	}

	/**
	 * Returns the area tematica matching the UUID and group.
	 *
	 * @param uuid the area tematica's UUID
	 * @param groupId the primary key of the group
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.AreaTematica
		fetchAreaTematicaByUuidAndGroupId(String uuid, long groupId) {

		return _areaTematicaLocalService.fetchAreaTematicaByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _areaTematicaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the area tematica with the primary key.
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica
	 * @throws PortalException if a area tematica with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.AreaTematica
			getAreaTematica(long areaTematicaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _areaTematicaLocalService.getAreaTematica(areaTematicaId);
	}

	/**
	 * Returns the area tematica matching the UUID and group.
	 *
	 * @param uuid the area tematica's UUID
	 * @param groupId the primary key of the group
	 * @return the matching area tematica
	 * @throws PortalException if a matching area tematica could not be found
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.AreaTematica
			getAreaTematicaByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _areaTematicaLocalService.getAreaTematicaByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the area tematicas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of area tematicas
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.AreaTematica>
		getAreaTematicas(int start, int end) {

		return _areaTematicaLocalService.getAreaTematicas(start, end);
	}

	/**
	 * Returns all the area tematicas matching the UUID and company.
	 *
	 * @param uuid the UUID of the area tematicas
	 * @param companyId the primary key of the company
	 * @return the matching area tematicas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.AreaTematica>
		getAreaTematicasByUuidAndCompanyId(String uuid, long companyId) {

		return _areaTematicaLocalService.getAreaTematicasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of area tematicas matching the UUID and company.
	 *
	 * @param uuid the UUID of the area tematicas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching area tematicas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.AreaTematica>
		getAreaTematicasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestioneservizi.model.AreaTematica>
					orderByComparator) {

		return _areaTematicaLocalService.getAreaTematicasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of area tematicas.
	 *
	 * @return the number of area tematicas
	 */
	@Override
	public int getAreaTematicasCount() {
		return _areaTematicaLocalService.getAreaTematicasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _areaTematicaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _areaTematicaLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.AreaTematica>
		getListaAreeTematiche(
			int inizio, int fine, String orderByCol, String orderByType) {

		return _areaTematicaLocalService.getListaAreeTematiche(
			inizio, fine, orderByCol, orderByType);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _areaTematicaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _areaTematicaLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public it.servizidigitali.gestioneservizi.model.AreaTematica
			salvaAreaTematica(
				it.servizidigitali.gestioneservizi.model.AreaTematica
					areaTematica)
		throws Exception {

		return _areaTematicaLocalService.salvaAreaTematica(areaTematica);
	}

	/**
	 * Updates the area tematica in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AreaTematicaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param areaTematica the area tematica
	 * @return the area tematica that was updated
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.AreaTematica
		updateAreaTematica(
			it.servizidigitali.gestioneservizi.model.AreaTematica
				areaTematica) {

		return _areaTematicaLocalService.updateAreaTematica(areaTematica);
	}

	@Override
	public AreaTematicaLocalService getWrappedService() {
		return _areaTematicaLocalService;
	}

	@Override
	public void setWrappedService(
		AreaTematicaLocalService areaTematicaLocalService) {

		_areaTematicaLocalService = areaTematicaLocalService;
	}

	private AreaTematicaLocalService _areaTematicaLocalService;

}