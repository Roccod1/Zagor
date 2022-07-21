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
 * Provides a wrapper for {@link UtenteOrganizzazioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazioneLocalService
 * @generated
 */
public class UtenteOrganizzazioneLocalServiceWrapper
	implements ServiceWrapper<UtenteOrganizzazioneLocalService>,
			   UtenteOrganizzazioneLocalService {

	public UtenteOrganizzazioneLocalServiceWrapper() {
		this(null);
	}

	public UtenteOrganizzazioneLocalServiceWrapper(
		UtenteOrganizzazioneLocalService utenteOrganizzazioneLocalService) {

		_utenteOrganizzazioneLocalService = utenteOrganizzazioneLocalService;
	}

	/**
	 * Adds the utente organizzazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazione the utente organizzazione
	 * @return the utente organizzazione that was added
	 */
	@Override
	public it.servizidigitali.profiloutente.model.UtenteOrganizzazione
		addUtenteOrganizzazione(
			it.servizidigitali.profiloutente.model.UtenteOrganizzazione
				utenteOrganizzazione) {

		return _utenteOrganizzazioneLocalService.addUtenteOrganizzazione(
			utenteOrganizzazione);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteOrganizzazioneLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new utente organizzazione with the primary key. Does not add the utente organizzazione to the database.
	 *
	 * @param utenteOrganizzazionePK the primary key for the new utente organizzazione
	 * @return the new utente organizzazione
	 */
	@Override
	public it.servizidigitali.profiloutente.model.UtenteOrganizzazione
		createUtenteOrganizzazione(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK) {

		return _utenteOrganizzazioneLocalService.createUtenteOrganizzazione(
			utenteOrganizzazionePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteOrganizzazioneLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the utente organizzazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazione the utente organizzazione
	 * @return the utente organizzazione that was removed
	 */
	@Override
	public it.servizidigitali.profiloutente.model.UtenteOrganizzazione
		deleteUtenteOrganizzazione(
			it.servizidigitali.profiloutente.model.UtenteOrganizzazione
				utenteOrganizzazione) {

		return _utenteOrganizzazioneLocalService.deleteUtenteOrganizzazione(
			utenteOrganizzazione);
	}

	/**
	 * Deletes the utente organizzazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione that was removed
	 * @throws PortalException if a utente organizzazione with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.profiloutente.model.UtenteOrganizzazione
			deleteUtenteOrganizzazione(
				it.servizidigitali.profiloutente.service.persistence.
					UtenteOrganizzazionePK utenteOrganizzazionePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteOrganizzazioneLocalService.deleteUtenteOrganizzazione(
			utenteOrganizzazionePK);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _utenteOrganizzazioneLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _utenteOrganizzazioneLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _utenteOrganizzazioneLocalService.dynamicQuery();
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

		return _utenteOrganizzazioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneModelImpl</code>.
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

		return _utenteOrganizzazioneLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneModelImpl</code>.
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

		return _utenteOrganizzazioneLocalService.dynamicQuery(
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

		return _utenteOrganizzazioneLocalService.dynamicQueryCount(
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

		return _utenteOrganizzazioneLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.profiloutente.model.UtenteOrganizzazione
		fetchUtenteOrganizzazione(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK) {

		return _utenteOrganizzazioneLocalService.fetchUtenteOrganizzazione(
			utenteOrganizzazionePK);
	}

	/**
	 * Returns the utente organizzazione matching the UUID and group.
	 *
	 * @param uuid the utente organizzazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public it.servizidigitali.profiloutente.model.UtenteOrganizzazione
		fetchUtenteOrganizzazioneByUuidAndGroupId(String uuid, long groupId) {

		return _utenteOrganizzazioneLocalService.
			fetchUtenteOrganizzazioneByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.UtenteOrganizzazione>
				findByUtenteOrganizzazionePreferito(
					long userId, long organizationId, boolean preferito)
			throws Exception {

		return _utenteOrganizzazioneLocalService.
			findByUtenteOrganizzazionePreferito(
				userId, organizationId, preferito);
	}

	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.UtenteOrganizzazione>
				findByUtentePreferito(long userId, boolean preferito)
			throws Exception {

		return _utenteOrganizzazioneLocalService.findByUtentePreferito(
			userId, preferito);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _utenteOrganizzazioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _utenteOrganizzazioneLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _utenteOrganizzazioneLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.UtenteOrganizzazione>
				getOrganizzazioniUtenteConfigurate(Long utenteId)
			throws Exception {

		return _utenteOrganizzazioneLocalService.
			getOrganizzazioniUtenteConfigurate(utenteId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _utenteOrganizzazioneLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteOrganizzazioneLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the utente organizzazione with the primary key.
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione
	 * @throws PortalException if a utente organizzazione with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.profiloutente.model.UtenteOrganizzazione
			getUtenteOrganizzazione(
				it.servizidigitali.profiloutente.service.persistence.
					UtenteOrganizzazionePK utenteOrganizzazionePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteOrganizzazioneLocalService.getUtenteOrganizzazione(
			utenteOrganizzazionePK);
	}

	/**
	 * Returns the utente organizzazione matching the UUID and group.
	 *
	 * @param uuid the utente organizzazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching utente organizzazione
	 * @throws PortalException if a matching utente organizzazione could not be found
	 */
	@Override
	public it.servizidigitali.profiloutente.model.UtenteOrganizzazione
			getUtenteOrganizzazioneByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteOrganizzazioneLocalService.
			getUtenteOrganizzazioneByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the utente organizzaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of utente organizzaziones
	 */
	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.UtenteOrganizzazione>
			getUtenteOrganizzaziones(int start, int end) {

		return _utenteOrganizzazioneLocalService.getUtenteOrganizzaziones(
			start, end);
	}

	/**
	 * Returns all the utente organizzaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the utente organizzaziones
	 * @param companyId the primary key of the company
	 * @return the matching utente organizzaziones, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.UtenteOrganizzazione>
			getUtenteOrganizzazionesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _utenteOrganizzazioneLocalService.
			getUtenteOrganizzazionesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of utente organizzaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the utente organizzaziones
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching utente organizzaziones, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.profiloutente.model.UtenteOrganizzazione>
			getUtenteOrganizzazionesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<it.servizidigitali.profiloutente.model.
						UtenteOrganizzazione> orderByComparator) {

		return _utenteOrganizzazioneLocalService.
			getUtenteOrganizzazionesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of utente organizzaziones.
	 *
	 * @return the number of utente organizzaziones
	 */
	@Override
	public int getUtenteOrganizzazionesCount() {
		return _utenteOrganizzazioneLocalService.
			getUtenteOrganizzazionesCount();
	}

	/**
	 * Updates the utente organizzazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazione the utente organizzazione
	 * @return the utente organizzazione that was updated
	 */
	@Override
	public it.servizidigitali.profiloutente.model.UtenteOrganizzazione
		updateUtenteOrganizzazione(
			it.servizidigitali.profiloutente.model.UtenteOrganizzazione
				utenteOrganizzazione) {

		return _utenteOrganizzazioneLocalService.updateUtenteOrganizzazione(
			utenteOrganizzazione);
	}

	@Override
	public UtenteOrganizzazioneLocalService getWrappedService() {
		return _utenteOrganizzazioneLocalService;
	}

	@Override
	public void setWrappedService(
		UtenteOrganizzazioneLocalService utenteOrganizzazioneLocalService) {

		_utenteOrganizzazioneLocalService = utenteOrganizzazioneLocalService;
	}

	private UtenteOrganizzazioneLocalService _utenteOrganizzazioneLocalService;

}