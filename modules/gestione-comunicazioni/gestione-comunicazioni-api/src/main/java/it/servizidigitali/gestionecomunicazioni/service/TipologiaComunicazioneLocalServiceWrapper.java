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

package it.servizidigitali.gestionecomunicazioni.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TipologiaComunicazioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaComunicazioneLocalService
 * @generated
 */
public class TipologiaComunicazioneLocalServiceWrapper
	implements ServiceWrapper<TipologiaComunicazioneLocalService>,
			   TipologiaComunicazioneLocalService {

	public TipologiaComunicazioneLocalServiceWrapper() {
		this(null);
	}

	public TipologiaComunicazioneLocalServiceWrapper(
		TipologiaComunicazioneLocalService tipologiaComunicazioneLocalService) {

		_tipologiaComunicazioneLocalService =
			tipologiaComunicazioneLocalService;
	}

	/**
	 * Adds the tipologia comunicazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologiaComunicazione the tipologia comunicazione
	 * @return the tipologia comunicazione that was added
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione
		addTipologiaComunicazione(
			it.servizidigitali.gestionecomunicazioni.model.
				TipologiaComunicazione tipologiaComunicazione) {

		return _tipologiaComunicazioneLocalService.addTipologiaComunicazione(
			tipologiaComunicazione);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipologiaComunicazioneLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new tipologia comunicazione with the primary key. Does not add the tipologia comunicazione to the database.
	 *
	 * @param tipologiaComunicazioneId the primary key for the new tipologia comunicazione
	 * @return the new tipologia comunicazione
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione
		createTipologiaComunicazione(long tipologiaComunicazioneId) {

		return _tipologiaComunicazioneLocalService.createTipologiaComunicazione(
			tipologiaComunicazioneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipologiaComunicazioneLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the tipologia comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologiaComunicazioneId the primary key of the tipologia comunicazione
	 * @return the tipologia comunicazione that was removed
	 * @throws PortalException if a tipologia comunicazione with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione
			deleteTipologiaComunicazione(long tipologiaComunicazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipologiaComunicazioneLocalService.deleteTipologiaComunicazione(
			tipologiaComunicazioneId);
	}

	/**
	 * Deletes the tipologia comunicazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologiaComunicazione the tipologia comunicazione
	 * @return the tipologia comunicazione that was removed
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione
		deleteTipologiaComunicazione(
			it.servizidigitali.gestionecomunicazioni.model.
				TipologiaComunicazione tipologiaComunicazione) {

		return _tipologiaComunicazioneLocalService.deleteTipologiaComunicazione(
			tipologiaComunicazione);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _tipologiaComunicazioneLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _tipologiaComunicazioneLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipologiaComunicazioneLocalService.dynamicQuery();
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

		return _tipologiaComunicazioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.TipologiaComunicazioneModelImpl</code>.
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

		return _tipologiaComunicazioneLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.TipologiaComunicazioneModelImpl</code>.
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

		return _tipologiaComunicazioneLocalService.dynamicQuery(
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

		return _tipologiaComunicazioneLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _tipologiaComunicazioneLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione
		fetchTipologiaComunicazione(long tipologiaComunicazioneId) {

		return _tipologiaComunicazioneLocalService.fetchTipologiaComunicazione(
			tipologiaComunicazioneId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tipologiaComunicazioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tipologiaComunicazioneLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tipologiaComunicazioneLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipologiaComunicazioneLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the tipologia comunicazione with the primary key.
	 *
	 * @param tipologiaComunicazioneId the primary key of the tipologia comunicazione
	 * @return the tipologia comunicazione
	 * @throws PortalException if a tipologia comunicazione with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione
			getTipologiaComunicazione(long tipologiaComunicazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipologiaComunicazioneLocalService.getTipologiaComunicazione(
			tipologiaComunicazioneId);
	}

	/**
	 * Returns a range of all the tipologia comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.TipologiaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia comunicaziones
	 * @param end the upper bound of the range of tipologia comunicaziones (not inclusive)
	 * @return the range of tipologia comunicaziones
	 */
	@Override
	public java.util.List
		<it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione>
			getTipologiaComunicaziones(int start, int end) {

		return _tipologiaComunicazioneLocalService.getTipologiaComunicaziones(
			start, end);
	}

	/**
	 * Returns the number of tipologia comunicaziones.
	 *
	 * @return the number of tipologia comunicaziones
	 */
	@Override
	public int getTipologiaComunicazionesCount() {
		return _tipologiaComunicazioneLocalService.
			getTipologiaComunicazionesCount();
	}

	/**
	 * Updates the tipologia comunicazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologiaComunicazione the tipologia comunicazione
	 * @return the tipologia comunicazione that was updated
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione
		updateTipologiaComunicazione(
			it.servizidigitali.gestionecomunicazioni.model.
				TipologiaComunicazione tipologiaComunicazione) {

		return _tipologiaComunicazioneLocalService.updateTipologiaComunicazione(
			tipologiaComunicazione);
	}

	@Override
	public TipologiaComunicazioneLocalService getWrappedService() {
		return _tipologiaComunicazioneLocalService;
	}

	@Override
	public void setWrappedService(
		TipologiaComunicazioneLocalService tipologiaComunicazioneLocalService) {

		_tipologiaComunicazioneLocalService =
			tipologiaComunicazioneLocalService;
	}

	private TipologiaComunicazioneLocalService
		_tipologiaComunicazioneLocalService;

}