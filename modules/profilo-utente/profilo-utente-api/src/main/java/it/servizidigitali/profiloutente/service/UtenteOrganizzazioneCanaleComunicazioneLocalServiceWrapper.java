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
 * Provides a wrapper for {@link UtenteOrganizzazioneCanaleComunicazioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazioneCanaleComunicazioneLocalService
 * @generated
 */
public class UtenteOrganizzazioneCanaleComunicazioneLocalServiceWrapper
	implements ServiceWrapper
		<UtenteOrganizzazioneCanaleComunicazioneLocalService>,
			   UtenteOrganizzazioneCanaleComunicazioneLocalService {

	public UtenteOrganizzazioneCanaleComunicazioneLocalServiceWrapper() {
		this(null);
	}

	public UtenteOrganizzazioneCanaleComunicazioneLocalServiceWrapper(
		UtenteOrganizzazioneCanaleComunicazioneLocalService
			utenteOrganizzazioneCanaleComunicazioneLocalService) {

		_utenteOrganizzazioneCanaleComunicazioneLocalService =
			utenteOrganizzazioneCanaleComunicazioneLocalService;
	}

	/**
	 * Adds the utente organizzazione canale comunicazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneCanaleComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazioneCanaleComunicazione the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione that was added
	 */
	@Override
	public it.servizidigitali.profiloutente.model.
		UtenteOrganizzazioneCanaleComunicazione
			addUtenteOrganizzazioneCanaleComunicazione(
				it.servizidigitali.profiloutente.model.
					UtenteOrganizzazioneCanaleComunicazione
						utenteOrganizzazioneCanaleComunicazione) {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			addUtenteOrganizzazioneCanaleComunicazione(
				utenteOrganizzazioneCanaleComunicazione);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new utente organizzazione canale comunicazione with the primary key. Does not add the utente organizzazione canale comunicazione to the database.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key for the new utente organizzazione canale comunicazione
	 * @return the new utente organizzazione canale comunicazione
	 */
	@Override
	public it.servizidigitali.profiloutente.model.
		UtenteOrganizzazioneCanaleComunicazione
			createUtenteOrganizzazioneCanaleComunicazione(
				it.servizidigitali.profiloutente.service.persistence.
					UtenteOrganizzazioneCanaleComunicazionePK
						utenteOrganizzazioneCanaleComunicazionePK) {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			createUtenteOrganizzazioneCanaleComunicazione(
				utenteOrganizzazioneCanaleComunicazionePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the utente organizzazione canale comunicazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneCanaleComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazioneCanaleComunicazione the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione that was removed
	 */
	@Override
	public it.servizidigitali.profiloutente.model.
		UtenteOrganizzazioneCanaleComunicazione
			deleteUtenteOrganizzazioneCanaleComunicazione(
				it.servizidigitali.profiloutente.model.
					UtenteOrganizzazioneCanaleComunicazione
						utenteOrganizzazioneCanaleComunicazione) {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			deleteUtenteOrganizzazioneCanaleComunicazione(
				utenteOrganizzazioneCanaleComunicazione);
	}

	/**
	 * Deletes the utente organizzazione canale comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneCanaleComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione that was removed
	 * @throws PortalException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.profiloutente.model.
		UtenteOrganizzazioneCanaleComunicazione
				deleteUtenteOrganizzazioneCanaleComunicazione(
					it.servizidigitali.profiloutente.service.persistence.
						UtenteOrganizzazioneCanaleComunicazionePK
							utenteOrganizzazioneCanaleComunicazionePK)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			deleteUtenteOrganizzazioneCanaleComunicazione(
				utenteOrganizzazioneCanaleComunicazionePK);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _utenteOrganizzazioneCanaleComunicazioneLocalService.dslQuery(
			dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			dynamicQuery();
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

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
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

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
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

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			dynamicQuery(dynamicQuery, start, end, orderByComparator);
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

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			dynamicQueryCount(dynamicQuery);
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

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.profiloutente.model.
		UtenteOrganizzazioneCanaleComunicazione
			fetchUtenteOrganizzazioneCanaleComunicazione(
				it.servizidigitali.profiloutente.service.persistence.
					UtenteOrganizzazioneCanaleComunicazionePK
						utenteOrganizzazioneCanaleComunicazionePK) {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			fetchUtenteOrganizzazioneCanaleComunicazione(
				utenteOrganizzazioneCanaleComunicazionePK);
	}

	/**
	 * Returns the utente organizzazione canale comunicazione matching the UUID and group.
	 *
	 * @param uuid the utente organizzazione canale comunicazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public it.servizidigitali.profiloutente.model.
		UtenteOrganizzazioneCanaleComunicazione
			fetchUtenteOrganizzazioneCanaleComunicazioneByUuidAndGroupId(
				String uuid, long groupId) {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			fetchUtenteOrganizzazioneCanaleComunicazioneByUuidAndGroupId(
				uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.
			UtenteOrganizzazioneCanaleComunicazione>
				getListaCanaleComunicazioneByUtenteOrganization(
					long utenteId, long organizationId) {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			getListaCanaleComunicazioneByUtenteOrganization(
				utenteId, organizationId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the utente organizzazione canale comunicazione with the primary key.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione
	 * @throws PortalException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.profiloutente.model.
		UtenteOrganizzazioneCanaleComunicazione
				getUtenteOrganizzazioneCanaleComunicazione(
					it.servizidigitali.profiloutente.service.persistence.
						UtenteOrganizzazioneCanaleComunicazionePK
							utenteOrganizzazioneCanaleComunicazionePK)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			getUtenteOrganizzazioneCanaleComunicazione(
				utenteOrganizzazioneCanaleComunicazionePK);
	}

	/**
	 * Returns the utente organizzazione canale comunicazione matching the UUID and group.
	 *
	 * @param uuid the utente organizzazione canale comunicazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching utente organizzazione canale comunicazione
	 * @throws PortalException if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public it.servizidigitali.profiloutente.model.
		UtenteOrganizzazioneCanaleComunicazione
				getUtenteOrganizzazioneCanaleComunicazioneByUuidAndGroupId(
					String uuid, long groupId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			getUtenteOrganizzazioneCanaleComunicazioneByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of utente organizzazione canale comunicaziones
	 */
	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.
			UtenteOrganizzazioneCanaleComunicazione>
				getUtenteOrganizzazioneCanaleComunicaziones(
					int start, int end) {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			getUtenteOrganizzazioneCanaleComunicaziones(start, end);
	}

	/**
	 * Returns all the utente organizzazione canale comunicaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the utente organizzazione canale comunicaziones
	 * @param companyId the primary key of the company
	 * @return the matching utente organizzazione canale comunicaziones, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.
			UtenteOrganizzazioneCanaleComunicazione>
				getUtenteOrganizzazioneCanaleComunicazionesByUuidAndCompanyId(
					String uuid, long companyId) {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			getUtenteOrganizzazioneCanaleComunicazionesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of utente organizzazione canale comunicaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the utente organizzazione canale comunicaziones
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching utente organizzazione canale comunicaziones, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.
			UtenteOrganizzazioneCanaleComunicazione>
				getUtenteOrganizzazioneCanaleComunicazionesByUuidAndCompanyId(
					String uuid, long companyId, int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<it.servizidigitali.profiloutente.model.
							UtenteOrganizzazioneCanaleComunicazione>
								orderByComparator) {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			getUtenteOrganizzazioneCanaleComunicazionesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones.
	 *
	 * @return the number of utente organizzazione canale comunicaziones
	 */
	@Override
	public int getUtenteOrganizzazioneCanaleComunicazionesCount() {
		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			getUtenteOrganizzazioneCanaleComunicazionesCount();
	}

	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.
			UtenteOrganizzazioneCanaleComunicazione>
					updateMassivoUtenteOrganizzazioneCanaleComunicazione(
						long userId, long groupId, long companyId,
						long organizationId, long[] listaIdCanaliComunicazione)
				throws Exception {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			updateMassivoUtenteOrganizzazioneCanaleComunicazione(
				userId, groupId, companyId, organizationId,
				listaIdCanaliComunicazione);
	}

	/**
	 * Updates the utente organizzazione canale comunicazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneCanaleComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazioneCanaleComunicazione the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione that was updated
	 */
	@Override
	public it.servizidigitali.profiloutente.model.
		UtenteOrganizzazioneCanaleComunicazione
			updateUtenteOrganizzazioneCanaleComunicazione(
				it.servizidigitali.profiloutente.model.
					UtenteOrganizzazioneCanaleComunicazione
						utenteOrganizzazioneCanaleComunicazione) {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService.
			updateUtenteOrganizzazioneCanaleComunicazione(
				utenteOrganizzazioneCanaleComunicazione);
	}

	@Override
	public UtenteOrganizzazioneCanaleComunicazioneLocalService
		getWrappedService() {

		return _utenteOrganizzazioneCanaleComunicazioneLocalService;
	}

	@Override
	public void setWrappedService(
		UtenteOrganizzazioneCanaleComunicazioneLocalService
			utenteOrganizzazioneCanaleComunicazioneLocalService) {

		_utenteOrganizzazioneCanaleComunicazioneLocalService =
			utenteOrganizzazioneCanaleComunicazioneLocalService;
	}

	private UtenteOrganizzazioneCanaleComunicazioneLocalService
		_utenteOrganizzazioneCanaleComunicazioneLocalService;

}