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
 * Provides a wrapper for {@link StatoEsteroLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StatoEsteroLocalService
 * @generated
 */
public class StatoEsteroLocalServiceWrapper
	implements ServiceWrapper<StatoEsteroLocalService>,
			   StatoEsteroLocalService {

	public StatoEsteroLocalServiceWrapper() {
		this(null);
	}

	public StatoEsteroLocalServiceWrapper(
		StatoEsteroLocalService statoEsteroLocalService) {

		_statoEsteroLocalService = statoEsteroLocalService;
	}

	/**
	 * Adds the stato estero to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatoEsteroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param statoEstero the stato estero
	 * @return the stato estero that was added
	 */
	@Override
	public it.servizidigitali.common.model.StatoEstero addStatoEstero(
		it.servizidigitali.common.model.StatoEstero statoEstero) {

		return _statoEsteroLocalService.addStatoEstero(statoEstero);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statoEsteroLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new stato estero with the primary key. Does not add the stato estero to the database.
	 *
	 * @param statoEsteroId the primary key for the new stato estero
	 * @return the new stato estero
	 */
	@Override
	public it.servizidigitali.common.model.StatoEstero createStatoEstero(
		long statoEsteroId) {

		return _statoEsteroLocalService.createStatoEstero(statoEsteroId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statoEsteroLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the stato estero with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatoEsteroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param statoEsteroId the primary key of the stato estero
	 * @return the stato estero that was removed
	 * @throws PortalException if a stato estero with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.common.model.StatoEstero deleteStatoEstero(
			long statoEsteroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statoEsteroLocalService.deleteStatoEstero(statoEsteroId);
	}

	/**
	 * Deletes the stato estero from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatoEsteroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param statoEstero the stato estero
	 * @return the stato estero that was removed
	 */
	@Override
	public it.servizidigitali.common.model.StatoEstero deleteStatoEstero(
		it.servizidigitali.common.model.StatoEstero statoEstero) {

		return _statoEsteroLocalService.deleteStatoEstero(statoEstero);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _statoEsteroLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _statoEsteroLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _statoEsteroLocalService.dynamicQuery();
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

		return _statoEsteroLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.common.model.impl.StatoEsteroModelImpl</code>.
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

		return _statoEsteroLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.common.model.impl.StatoEsteroModelImpl</code>.
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

		return _statoEsteroLocalService.dynamicQuery(
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

		return _statoEsteroLocalService.dynamicQueryCount(dynamicQuery);
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

		return _statoEsteroLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.common.model.StatoEstero fetchStatoEstero(
		long statoEsteroId) {

		return _statoEsteroLocalService.fetchStatoEstero(statoEsteroId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _statoEsteroLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _statoEsteroLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _statoEsteroLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statoEsteroLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the stato estero with the primary key.
	 *
	 * @param statoEsteroId the primary key of the stato estero
	 * @return the stato estero
	 * @throws PortalException if a stato estero with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.common.model.StatoEstero getStatoEstero(
			long statoEsteroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statoEsteroLocalService.getStatoEstero(statoEsteroId);
	}

	@Override
	public it.servizidigitali.common.model.StatoEstero
		getStatoEsteroByCodiceStato(int codiceStato) {

		return _statoEsteroLocalService.getStatoEsteroByCodiceStato(
			codiceStato);
	}

	@Override
	public it.servizidigitali.common.model.StatoEstero
		getStatoEsteroByDenominazione(String denominazione) {

		return _statoEsteroLocalService.getStatoEsteroByDenominazione(
			denominazione);
	}

	/**
	 * Returns a range of all the stato esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.common.model.impl.StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @return the range of stato esteros
	 */
	@Override
	public java.util.List<it.servizidigitali.common.model.StatoEstero>
		getStatoEsteros(int start, int end) {

		return _statoEsteroLocalService.getStatoEsteros(start, end);
	}

	/**
	 * Returns the number of stato esteros.
	 *
	 * @return the number of stato esteros
	 */
	@Override
	public int getStatoEsterosCount() {
		return _statoEsteroLocalService.getStatoEsterosCount();
	}

	/**
	 * Updates the stato estero in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatoEsteroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param statoEstero the stato estero
	 * @return the stato estero that was updated
	 */
	@Override
	public it.servizidigitali.common.model.StatoEstero updateStatoEstero(
		it.servizidigitali.common.model.StatoEstero statoEstero) {

		return _statoEsteroLocalService.updateStatoEstero(statoEstero);
	}

	@Override
	public StatoEsteroLocalService getWrappedService() {
		return _statoEsteroLocalService;
	}

	@Override
	public void setWrappedService(
		StatoEsteroLocalService statoEsteroLocalService) {

		_statoEsteroLocalService = statoEsteroLocalService;
	}

	private StatoEsteroLocalService _statoEsteroLocalService;

}