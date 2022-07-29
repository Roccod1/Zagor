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

package it.servizidigitali.gestioneforms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DefinizioneAllegatoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DefinizioneAllegatoLocalService
 * @generated
 */
public class DefinizioneAllegatoLocalServiceWrapper
	implements DefinizioneAllegatoLocalService,
			   ServiceWrapper<DefinizioneAllegatoLocalService> {

	public DefinizioneAllegatoLocalServiceWrapper() {
		this(null);
	}

	public DefinizioneAllegatoLocalServiceWrapper(
		DefinizioneAllegatoLocalService definizioneAllegatoLocalService) {

		_definizioneAllegatoLocalService = definizioneAllegatoLocalService;
	}

	/**
	 * Adds the definizione allegato to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DefinizioneAllegatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param definizioneAllegato the definizione allegato
	 * @return the definizione allegato that was added
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.DefinizioneAllegato
		addDefinizioneAllegato(
			it.servizidigitali.gestioneforms.model.DefinizioneAllegato
				definizioneAllegato) {

		return _definizioneAllegatoLocalService.addDefinizioneAllegato(
			definizioneAllegato);
	}

	@Override
	public it.servizidigitali.gestioneforms.model.DefinizioneAllegato
		cancellaAllegati(String[] allegatiDaEliminare) {

		return _definizioneAllegatoLocalService.cancellaAllegati(
			allegatiDaEliminare);
	}

	/**
	 * Creates a new definizione allegato with the primary key. Does not add the definizione allegato to the database.
	 *
	 * @param definizioneAllegatoId the primary key for the new definizione allegato
	 * @return the new definizione allegato
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.DefinizioneAllegato
		createDefinizioneAllegato(long definizioneAllegatoId) {

		return _definizioneAllegatoLocalService.createDefinizioneAllegato(
			definizioneAllegatoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _definizioneAllegatoLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the definizione allegato from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DefinizioneAllegatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param definizioneAllegato the definizione allegato
	 * @return the definizione allegato that was removed
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.DefinizioneAllegato
		deleteDefinizioneAllegato(
			it.servizidigitali.gestioneforms.model.DefinizioneAllegato
				definizioneAllegato) {

		return _definizioneAllegatoLocalService.deleteDefinizioneAllegato(
			definizioneAllegato);
	}

	/**
	 * Deletes the definizione allegato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DefinizioneAllegatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato that was removed
	 * @throws PortalException if a definizione allegato with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.DefinizioneAllegato
			deleteDefinizioneAllegato(long definizioneAllegatoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _definizioneAllegatoLocalService.deleteDefinizioneAllegato(
			definizioneAllegatoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _definizioneAllegatoLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _definizioneAllegatoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _definizioneAllegatoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _definizioneAllegatoLocalService.dynamicQuery();
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

		return _definizioneAllegatoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.DefinizioneAllegatoModelImpl</code>.
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

		return _definizioneAllegatoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.DefinizioneAllegatoModelImpl</code>.
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

		return _definizioneAllegatoLocalService.dynamicQuery(
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

		return _definizioneAllegatoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _definizioneAllegatoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestioneforms.model.DefinizioneAllegato
		fetchDefinizioneAllegato(long definizioneAllegatoId) {

		return _definizioneAllegatoLocalService.fetchDefinizioneAllegato(
			definizioneAllegatoId);
	}

	/**
	 * Returns the definizione allegato matching the UUID and group.
	 *
	 * @param uuid the definizione allegato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.DefinizioneAllegato
		fetchDefinizioneAllegatoByUuidAndGroupId(String uuid, long groupId) {

		return _definizioneAllegatoLocalService.
			fetchDefinizioneAllegatoByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _definizioneAllegatoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the definizione allegato with the primary key.
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato
	 * @throws PortalException if a definizione allegato with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.DefinizioneAllegato
			getDefinizioneAllegato(long definizioneAllegatoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _definizioneAllegatoLocalService.getDefinizioneAllegato(
			definizioneAllegatoId);
	}

	/**
	 * Returns the definizione allegato matching the UUID and group.
	 *
	 * @param uuid the definizione allegato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching definizione allegato
	 * @throws PortalException if a matching definizione allegato could not be found
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.DefinizioneAllegato
			getDefinizioneAllegatoByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _definizioneAllegatoLocalService.
			getDefinizioneAllegatoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the definizione allegatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of definizione allegatos
	 */
	@Override
	public java.util.List
		<it.servizidigitali.gestioneforms.model.DefinizioneAllegato>
			getDefinizioneAllegatos(int start, int end) {

		return _definizioneAllegatoLocalService.getDefinizioneAllegatos(
			start, end);
	}

	/**
	 * Returns all the definizione allegatos matching the UUID and company.
	 *
	 * @param uuid the UUID of the definizione allegatos
	 * @param companyId the primary key of the company
	 * @return the matching definizione allegatos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.gestioneforms.model.DefinizioneAllegato>
			getDefinizioneAllegatosByUuidAndCompanyId(
				String uuid, long companyId) {

		return _definizioneAllegatoLocalService.
			getDefinizioneAllegatosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of definizione allegatos matching the UUID and company.
	 *
	 * @param uuid the UUID of the definizione allegatos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching definizione allegatos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.gestioneforms.model.DefinizioneAllegato>
			getDefinizioneAllegatosByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<it.servizidigitali.gestioneforms.model.DefinizioneAllegato>
						orderByComparator) {

		return _definizioneAllegatoLocalService.
			getDefinizioneAllegatosByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of definizione allegatos.
	 *
	 * @return the number of definizione allegatos
	 */
	@Override
	public int getDefinizioneAllegatosCount() {
		return _definizioneAllegatoLocalService.getDefinizioneAllegatosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _definizioneAllegatoLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _definizioneAllegatoLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<it.servizidigitali.gestioneforms.model.DefinizioneAllegato>
			getListaDefinizioneAllegatoByFormId(long formId) {

		return _definizioneAllegatoLocalService.
			getListaDefinizioneAllegatoByFormId(formId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _definizioneAllegatoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _definizioneAllegatoLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the definizione allegato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DefinizioneAllegatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param definizioneAllegato the definizione allegato
	 * @return the definizione allegato that was updated
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.DefinizioneAllegato
		updateDefinizioneAllegato(
			it.servizidigitali.gestioneforms.model.DefinizioneAllegato
				definizioneAllegato) {

		return _definizioneAllegatoLocalService.updateDefinizioneAllegato(
			definizioneAllegato);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry
			uploadAllegatoDocumentMediaRepository(
				String idAllegatoTemporaneo, String fileNameModello,
				long groupId, long formId, long userId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return _definizioneAllegatoLocalService.
			uploadAllegatoDocumentMediaRepository(
				idAllegatoTemporaneo, fileNameModello, groupId, formId, userId,
				serviceContext);
	}

	@Override
	public long uploadAllegatoTemporaneo(java.io.File allegato)
		throws Exception {

		return _definizioneAllegatoLocalService.uploadAllegatoTemporaneo(
			allegato);
	}

	@Override
	public DefinizioneAllegatoLocalService getWrappedService() {
		return _definizioneAllegatoLocalService;
	}

	@Override
	public void setWrappedService(
		DefinizioneAllegatoLocalService definizioneAllegatoLocalService) {

		_definizioneAllegatoLocalService = definizioneAllegatoLocalService;
	}

	private DefinizioneAllegatoLocalService _definizioneAllegatoLocalService;

}