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

package it.servizidigitali.profiloutente.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CanaleComunicazioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CanaleComunicazioneLocalService
 * @generated
 */
public class CanaleComunicazioneLocalServiceWrapper
	implements CanaleComunicazioneLocalService,
			   ServiceWrapper<CanaleComunicazioneLocalService> {

	public CanaleComunicazioneLocalServiceWrapper() {
		this(null);
	}

	public CanaleComunicazioneLocalServiceWrapper(
		CanaleComunicazioneLocalService canaleComunicazioneLocalService) {

		_canaleComunicazioneLocalService = canaleComunicazioneLocalService;
	}

	/**
	 * Adds the canale comunicazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CanaleComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param canaleComunicazione the canale comunicazione
	 * @return the canale comunicazione that was added
	 */
	@Override
	public it.servizidigitali.profiloutente.model.CanaleComunicazione
		addCanaleComunicazione(
			it.servizidigitali.profiloutente.model.CanaleComunicazione
				canaleComunicazione) {

		return _canaleComunicazioneLocalService.addCanaleComunicazione(
			canaleComunicazione);
	}

	/**
	 * Creates a new canale comunicazione with the primary key. Does not add the canale comunicazione to the database.
	 *
	 * @param canaleComunicazioneId the primary key for the new canale comunicazione
	 * @return the new canale comunicazione
	 */
	@Override
	public it.servizidigitali.profiloutente.model.CanaleComunicazione
		createCanaleComunicazione(long canaleComunicazioneId) {

		return _canaleComunicazioneLocalService.createCanaleComunicazione(
			canaleComunicazioneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _canaleComunicazioneLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the canale comunicazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CanaleComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param canaleComunicazione the canale comunicazione
	 * @return the canale comunicazione that was removed
	 */
	@Override
	public it.servizidigitali.profiloutente.model.CanaleComunicazione
		deleteCanaleComunicazione(
			it.servizidigitali.profiloutente.model.CanaleComunicazione
				canaleComunicazione) {

		return _canaleComunicazioneLocalService.deleteCanaleComunicazione(
			canaleComunicazione);
	}

	/**
	 * Deletes the canale comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CanaleComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param canaleComunicazioneId the primary key of the canale comunicazione
	 * @return the canale comunicazione that was removed
	 * @throws PortalException if a canale comunicazione with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.profiloutente.model.CanaleComunicazione
			deleteCanaleComunicazione(long canaleComunicazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _canaleComunicazioneLocalService.deleteCanaleComunicazione(
			canaleComunicazioneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _canaleComunicazioneLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _canaleComunicazioneLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _canaleComunicazioneLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _canaleComunicazioneLocalService.dynamicQuery();
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

		return _canaleComunicazioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.CanaleComunicazioneModelImpl</code>.
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

		return _canaleComunicazioneLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.CanaleComunicazioneModelImpl</code>.
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

		return _canaleComunicazioneLocalService.dynamicQuery(
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

		return _canaleComunicazioneLocalService.dynamicQueryCount(dynamicQuery);
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

		return _canaleComunicazioneLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.profiloutente.model.CanaleComunicazione
		fetchCanaleComunicazione(long canaleComunicazioneId) {

		return _canaleComunicazioneLocalService.fetchCanaleComunicazione(
			canaleComunicazioneId);
	}

	/**
	 * Returns the canale comunicazione matching the UUID and group.
	 *
	 * @param uuid the canale comunicazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	@Override
	public it.servizidigitali.profiloutente.model.CanaleComunicazione
		fetchCanaleComunicazioneByUuidAndGroupId(String uuid, long groupId) {

		return _canaleComunicazioneLocalService.
			fetchCanaleComunicazioneByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _canaleComunicazioneLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the canale comunicazione with the primary key.
	 *
	 * @param canaleComunicazioneId the primary key of the canale comunicazione
	 * @return the canale comunicazione
	 * @throws PortalException if a canale comunicazione with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.profiloutente.model.CanaleComunicazione
			getCanaleComunicazione(long canaleComunicazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _canaleComunicazioneLocalService.getCanaleComunicazione(
			canaleComunicazioneId);
	}

	/**
	 * Returns the canale comunicazione matching the UUID and group.
	 *
	 * @param uuid the canale comunicazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching canale comunicazione
	 * @throws PortalException if a matching canale comunicazione could not be found
	 */
	@Override
	public it.servizidigitali.profiloutente.model.CanaleComunicazione
			getCanaleComunicazioneByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _canaleComunicazioneLocalService.
			getCanaleComunicazioneByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @return the range of canale comunicaziones
	 */
	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.CanaleComunicazione>
			getCanaleComunicaziones(int start, int end) {

		return _canaleComunicazioneLocalService.getCanaleComunicaziones(
			start, end);
	}

	/**
	 * Returns all the canale comunicaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the canale comunicaziones
	 * @param companyId the primary key of the company
	 * @return the matching canale comunicaziones, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.CanaleComunicazione>
			getCanaleComunicazionesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _canaleComunicazioneLocalService.
			getCanaleComunicazionesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of canale comunicaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the canale comunicaziones
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching canale comunicaziones, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.CanaleComunicazione>
			getCanaleComunicazionesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<it.servizidigitali.profiloutente.model.CanaleComunicazione>
						orderByComparator) {

		return _canaleComunicazioneLocalService.
			getCanaleComunicazionesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of canale comunicaziones.
	 *
	 * @return the number of canale comunicaziones
	 */
	@Override
	public int getCanaleComunicazionesCount() {
		return _canaleComunicazioneLocalService.getCanaleComunicazionesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _canaleComunicazioneLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _canaleComunicazioneLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _canaleComunicazioneLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _canaleComunicazioneLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the canale comunicazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CanaleComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param canaleComunicazione the canale comunicazione
	 * @return the canale comunicazione that was updated
	 */
	@Override
	public it.servizidigitali.profiloutente.model.CanaleComunicazione
		updateCanaleComunicazione(
			it.servizidigitali.profiloutente.model.CanaleComunicazione
				canaleComunicazione) {

		return _canaleComunicazioneLocalService.updateCanaleComunicazione(
			canaleComunicazione);
	}

	@Override
	public CanaleComunicazioneLocalService getWrappedService() {
		return _canaleComunicazioneLocalService;
	}

	@Override
	public void setWrappedService(
		CanaleComunicazioneLocalService canaleComunicazioneLocalService) {

		_canaleComunicazioneLocalService = canaleComunicazioneLocalService;
	}

	private CanaleComunicazioneLocalService _canaleComunicazioneLocalService;

}