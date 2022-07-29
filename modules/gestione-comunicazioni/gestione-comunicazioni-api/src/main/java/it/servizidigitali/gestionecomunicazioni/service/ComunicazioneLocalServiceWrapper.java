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
 * Provides a wrapper for {@link ComunicazioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ComunicazioneLocalService
 * @generated
 */
public class ComunicazioneLocalServiceWrapper
	implements ComunicazioneLocalService,
			   ServiceWrapper<ComunicazioneLocalService> {

	public ComunicazioneLocalServiceWrapper() {
		this(null);
	}

	public ComunicazioneLocalServiceWrapper(
		ComunicazioneLocalService comunicazioneLocalService) {

		_comunicazioneLocalService = comunicazioneLocalService;
	}

	/**
	 * Adds the comunicazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comunicazione the comunicazione
	 * @return the comunicazione that was added
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.Comunicazione
		addComunicazione(
			it.servizidigitali.gestionecomunicazioni.model.Comunicazione
				comunicazione) {

		return _comunicazioneLocalService.addComunicazione(comunicazione);
	}

	@Override
	public it.servizidigitali.gestionecomunicazioni.model.Comunicazione
			addComunicazione(
				long groupId, long companyId, long userId, long organizationId,
				String userName, String titolo, String descrizione,
				java.util.Date dataInizio, java.util.Date dataFine,
				long tipologiaId, Long destinatarioUserId,
				long destinatarioOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comunicazioneLocalService.addComunicazione(
			groupId, companyId, userId, organizationId, userName, titolo,
			descrizione, dataInizio, dataFine, tipologiaId, destinatarioUserId,
			destinatarioOrganizationId);
	}

	@Override
	public int countByFilters(
		Long organizzazione, String username, Long tipologia) {

		return _comunicazioneLocalService.countByFilters(
			organizzazione, username, tipologia);
	}

	/**
	 * Creates a new comunicazione with the primary key. Does not add the comunicazione to the database.
	 *
	 * @param comunicazioneId the primary key for the new comunicazione
	 * @return the new comunicazione
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.Comunicazione
		createComunicazione(long comunicazioneId) {

		return _comunicazioneLocalService.createComunicazione(comunicazioneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comunicazioneLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the comunicazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comunicazione the comunicazione
	 * @return the comunicazione that was removed
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.Comunicazione
		deleteComunicazione(
			it.servizidigitali.gestionecomunicazioni.model.Comunicazione
				comunicazione) {

		return _comunicazioneLocalService.deleteComunicazione(comunicazione);
	}

	/**
	 * Deletes the comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione that was removed
	 * @throws PortalException if a comunicazione with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.Comunicazione
			deleteComunicazione(long comunicazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comunicazioneLocalService.deleteComunicazione(comunicazioneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comunicazioneLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _comunicazioneLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _comunicazioneLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _comunicazioneLocalService.dynamicQuery();
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

		return _comunicazioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.ComunicazioneModelImpl</code>.
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

		return _comunicazioneLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.ComunicazioneModelImpl</code>.
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

		return _comunicazioneLocalService.dynamicQuery(
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

		return _comunicazioneLocalService.dynamicQueryCount(dynamicQuery);
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

		return _comunicazioneLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestionecomunicazioni.model.Comunicazione
		fetchComunicazione(long comunicazioneId) {

		return _comunicazioneLocalService.fetchComunicazione(comunicazioneId);
	}

	/**
	 * Returns the comunicazione matching the UUID and group.
	 *
	 * @param uuid the comunicazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.Comunicazione
		fetchComunicazioneByUuidAndGroupId(String uuid, long groupId) {

		return _comunicazioneLocalService.fetchComunicazioneByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List
		<it.servizidigitali.gestionecomunicazioni.model.Comunicazione>
			findByFilters(
				Long organizzazione, String username, Long tipologia, int cur,
				int delta) {

		return _comunicazioneLocalService.findByFilters(
			organizzazione, username, tipologia, cur, delta);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _comunicazioneLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the comunicazione with the primary key.
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione
	 * @throws PortalException if a comunicazione with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.Comunicazione
			getComunicazione(long comunicazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comunicazioneLocalService.getComunicazione(comunicazioneId);
	}

	/**
	 * Returns the comunicazione matching the UUID and group.
	 *
	 * @param uuid the comunicazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching comunicazione
	 * @throws PortalException if a matching comunicazione could not be found
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.Comunicazione
			getComunicazioneByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comunicazioneLocalService.getComunicazioneByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of comunicaziones
	 */
	@Override
	public java.util.List
		<it.servizidigitali.gestionecomunicazioni.model.Comunicazione>
			getComunicaziones(int start, int end) {

		return _comunicazioneLocalService.getComunicaziones(start, end);
	}

	/**
	 * Returns all the comunicaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the comunicaziones
	 * @param companyId the primary key of the company
	 * @return the matching comunicaziones, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.gestionecomunicazioni.model.Comunicazione>
			getComunicazionesByUuidAndCompanyId(String uuid, long companyId) {

		return _comunicazioneLocalService.getComunicazionesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of comunicaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the comunicaziones
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching comunicaziones, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.gestionecomunicazioni.model.Comunicazione>
			getComunicazionesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<it.servizidigitali.gestionecomunicazioni.model.
						Comunicazione> orderByComparator) {

		return _comunicazioneLocalService.getComunicazionesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of comunicaziones.
	 *
	 * @return the number of comunicaziones
	 */
	@Override
	public int getComunicazionesCount() {
		return _comunicazioneLocalService.getComunicazionesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _comunicazioneLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _comunicazioneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _comunicazioneLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comunicazioneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the comunicazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comunicazione the comunicazione
	 * @return the comunicazione that was updated
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.model.Comunicazione
		updateComunicazione(
			it.servizidigitali.gestionecomunicazioni.model.Comunicazione
				comunicazione) {

		return _comunicazioneLocalService.updateComunicazione(comunicazione);
	}

	@Override
	public ComunicazioneLocalService getWrappedService() {
		return _comunicazioneLocalService;
	}

	@Override
	public void setWrappedService(
		ComunicazioneLocalService comunicazioneLocalService) {

		_comunicazioneLocalService = comunicazioneLocalService;
	}

	private ComunicazioneLocalService _comunicazioneLocalService;

}