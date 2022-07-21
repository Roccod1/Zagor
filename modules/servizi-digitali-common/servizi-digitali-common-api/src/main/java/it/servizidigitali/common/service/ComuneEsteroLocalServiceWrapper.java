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

package it.servizidigitali.common.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ComuneEsteroLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ComuneEsteroLocalService
 * @generated
 */
public class ComuneEsteroLocalServiceWrapper
	implements ComuneEsteroLocalService,
			   ServiceWrapper<ComuneEsteroLocalService> {

	public ComuneEsteroLocalServiceWrapper() {
		this(null);
	}

	public ComuneEsteroLocalServiceWrapper(
		ComuneEsteroLocalService comuneEsteroLocalService) {

		_comuneEsteroLocalService = comuneEsteroLocalService;
	}

	/**
	 * Adds the comune estero to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComuneEsteroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comuneEstero the comune estero
	 * @return the comune estero that was added
	 */
	@Override
	public it.servizidigitali.common.model.ComuneEstero addComuneEstero(
		it.servizidigitali.common.model.ComuneEstero comuneEstero) {

		return _comuneEsteroLocalService.addComuneEstero(comuneEstero);
	}

	/**
	 * Creates a new comune estero with the primary key. Does not add the comune estero to the database.
	 *
	 * @param comuneEsteroId the primary key for the new comune estero
	 * @return the new comune estero
	 */
	@Override
	public it.servizidigitali.common.model.ComuneEstero createComuneEstero(
		long comuneEsteroId) {

		return _comuneEsteroLocalService.createComuneEstero(comuneEsteroId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuneEsteroLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the comune estero from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComuneEsteroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comuneEstero the comune estero
	 * @return the comune estero that was removed
	 */
	@Override
	public it.servizidigitali.common.model.ComuneEstero deleteComuneEstero(
		it.servizidigitali.common.model.ComuneEstero comuneEstero) {

		return _comuneEsteroLocalService.deleteComuneEstero(comuneEstero);
	}

	/**
	 * Deletes the comune estero with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComuneEsteroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero that was removed
	 * @throws PortalException if a comune estero with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.common.model.ComuneEstero deleteComuneEstero(
			long comuneEsteroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuneEsteroLocalService.deleteComuneEstero(comuneEsteroId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuneEsteroLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _comuneEsteroLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _comuneEsteroLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _comuneEsteroLocalService.dynamicQuery();
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

		return _comuneEsteroLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.common.model.impl.ComuneEsteroModelImpl</code>.
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

		return _comuneEsteroLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.common.model.impl.ComuneEsteroModelImpl</code>.
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

		return _comuneEsteroLocalService.dynamicQuery(
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

		return _comuneEsteroLocalService.dynamicQueryCount(dynamicQuery);
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

		return _comuneEsteroLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.common.model.ComuneEstero fetchComuneEstero(
		long comuneEsteroId) {

		return _comuneEsteroLocalService.fetchComuneEstero(comuneEsteroId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _comuneEsteroLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the comune estero with the primary key.
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero
	 * @throws PortalException if a comune estero with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.common.model.ComuneEstero getComuneEstero(
			long comuneEsteroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuneEsteroLocalService.getComuneEstero(comuneEsteroId);
	}

	@Override
	public it.servizidigitali.common.model.ComuneEstero getComuneEsteroByCodice(
		int codice) {

		return _comuneEsteroLocalService.getComuneEsteroByCodice(codice);
	}

	/**
	 * Returns a range of all the comune esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.common.model.impl.ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @return the range of comune esteros
	 */
	@Override
	public java.util.List<it.servizidigitali.common.model.ComuneEstero>
		getComuneEsteros(int start, int end) {

		return _comuneEsteroLocalService.getComuneEsteros(start, end);
	}

	/**
	 * Returns the number of comune esteros.
	 *
	 * @return the number of comune esteros
	 */
	@Override
	public int getComuneEsterosCount() {
		return _comuneEsteroLocalService.getComuneEsterosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _comuneEsteroLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _comuneEsteroLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuneEsteroLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the comune estero in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComuneEsteroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comuneEstero the comune estero
	 * @return the comune estero that was updated
	 */
	@Override
	public it.servizidigitali.common.model.ComuneEstero updateComuneEstero(
		it.servizidigitali.common.model.ComuneEstero comuneEstero) {

		return _comuneEsteroLocalService.updateComuneEstero(comuneEstero);
	}

	@Override
	public ComuneEsteroLocalService getWrappedService() {
		return _comuneEsteroLocalService;
	}

	@Override
	public void setWrappedService(
		ComuneEsteroLocalService comuneEsteroLocalService) {

		_comuneEsteroLocalService = comuneEsteroLocalService;
	}

	private ComuneEsteroLocalService _comuneEsteroLocalService;

}