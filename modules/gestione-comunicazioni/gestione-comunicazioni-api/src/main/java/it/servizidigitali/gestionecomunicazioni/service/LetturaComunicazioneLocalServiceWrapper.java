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
 * Provides a wrapper for {@link LetturaComunicazioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LetturaComunicazioneLocalService
 * @generated
 */
public class LetturaComunicazioneLocalServiceWrapper
	implements LetturaComunicazioneLocalService,
			   ServiceWrapper<LetturaComunicazioneLocalService> {

	public LetturaComunicazioneLocalServiceWrapper() {
		this(null);
	}

	public LetturaComunicazioneLocalServiceWrapper(
		LetturaComunicazioneLocalService letturaComunicazioneLocalService) {

		_letturaComunicazioneLocalService = letturaComunicazioneLocalService;
	}

	/**
	 * Adds the lettura comunicazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LetturaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param letturaComunicazione the lettura comunicazione
	 * @return the lettura comunicazione that was added
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione
		addLetturaComunicazione(
			it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione
				letturaComunicazione) {

		return _letturaComunicazioneLocalService.addLetturaComunicazione(
			letturaComunicazione);
	}

	/**
	 * Creates a new lettura comunicazione with the primary key. Does not add the lettura comunicazione to the database.
	 *
	 * @param letturaComunicazionePK the primary key for the new lettura comunicazione
	 * @return the new lettura comunicazione
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione
		createLetturaComunicazione(
			it.servizidigitali.gestionecomunicazioni.service.persistence.
				LetturaComunicazionePK letturaComunicazionePK) {

		return _letturaComunicazioneLocalService.createLetturaComunicazione(
			letturaComunicazionePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _letturaComunicazioneLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the lettura comunicazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LetturaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param letturaComunicazione the lettura comunicazione
	 * @return the lettura comunicazione that was removed
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione
		deleteLetturaComunicazione(
			it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione
				letturaComunicazione) {

		return _letturaComunicazioneLocalService.deleteLetturaComunicazione(
			letturaComunicazione);
	}

	/**
	 * Deletes the lettura comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LetturaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione that was removed
	 * @throws PortalException if a lettura comunicazione with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione
			deleteLetturaComunicazione(
				it.servizidigitali.gestionecomunicazioni.service.persistence.
					LetturaComunicazionePK letturaComunicazionePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _letturaComunicazioneLocalService.deleteLetturaComunicazione(
			letturaComunicazionePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _letturaComunicazioneLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _letturaComunicazioneLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _letturaComunicazioneLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _letturaComunicazioneLocalService.dynamicQuery();
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

		return _letturaComunicazioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.LetturaComunicazioneModelImpl</code>.
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

		return _letturaComunicazioneLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.LetturaComunicazioneModelImpl</code>.
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

		return _letturaComunicazioneLocalService.dynamicQuery(
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

		return _letturaComunicazioneLocalService.dynamicQueryCount(
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

		return _letturaComunicazioneLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione
		fetchLetturaComunicazione(
			it.servizidigitali.gestionecomunicazioni.service.persistence.
				LetturaComunicazionePK letturaComunicazionePK) {

		return _letturaComunicazioneLocalService.fetchLetturaComunicazione(
			letturaComunicazionePK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _letturaComunicazioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _letturaComunicazioneLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lettura comunicazione with the primary key.
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione
	 * @throws PortalException if a lettura comunicazione with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione
			getLetturaComunicazione(
				it.servizidigitali.gestionecomunicazioni.service.persistence.
					LetturaComunicazionePK letturaComunicazionePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _letturaComunicazioneLocalService.getLetturaComunicazione(
			letturaComunicazionePK);
	}

	/**
	 * Returns a range of all the lettura comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.LetturaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lettura comunicaziones
	 * @param end the upper bound of the range of lettura comunicaziones (not inclusive)
	 * @return the range of lettura comunicaziones
	 */
	@Override
	public java.util.List
		<it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione>
			getLetturaComunicaziones(int start, int end) {

		return _letturaComunicazioneLocalService.getLetturaComunicaziones(
			start, end);
	}

	/**
	 * Returns the number of lettura comunicaziones.
	 *
	 * @return the number of lettura comunicaziones
	 */
	@Override
	public int getLetturaComunicazionesCount() {
		return _letturaComunicazioneLocalService.
			getLetturaComunicazionesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _letturaComunicazioneLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _letturaComunicazioneLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the lettura comunicazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LetturaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param letturaComunicazione the lettura comunicazione
	 * @return the lettura comunicazione that was updated
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione
		updateLetturaComunicazione(
			it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione
				letturaComunicazione) {

		return _letturaComunicazioneLocalService.updateLetturaComunicazione(
			letturaComunicazione);
	}

	@Override
	public LetturaComunicazioneLocalService getWrappedService() {
		return _letturaComunicazioneLocalService;
	}

	@Override
	public void setWrappedService(
		LetturaComunicazioneLocalService letturaComunicazioneLocalService) {

		_letturaComunicazioneLocalService = letturaComunicazioneLocalService;
	}

	private LetturaComunicazioneLocalService _letturaComunicazioneLocalService;

}