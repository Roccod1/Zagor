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

package it.servizidigitali.scrivaniaoperatore.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DestinazioneUsoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DestinazioneUsoLocalService
 * @generated
 */
public class DestinazioneUsoLocalServiceWrapper
	implements DestinazioneUsoLocalService,
			   ServiceWrapper<DestinazioneUsoLocalService> {

	public DestinazioneUsoLocalServiceWrapper() {
		this(null);
	}

	public DestinazioneUsoLocalServiceWrapper(
		DestinazioneUsoLocalService destinazioneUsoLocalService) {

		_destinazioneUsoLocalService = destinazioneUsoLocalService;
	}

	/**
	 * Adds the destinazione uso to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUso the destinazione uso
	 * @return the destinazione uso that was added
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso
		addDestinazioneUso(
			it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso
				destinazioneUso) {

		return _destinazioneUsoLocalService.addDestinazioneUso(destinazioneUso);
	}

	/**
	 * Creates a new destinazione uso with the primary key. Does not add the destinazione uso to the database.
	 *
	 * @param destinazioneUsoId the primary key for the new destinazione uso
	 * @return the new destinazione uso
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso
		createDestinazioneUso(long destinazioneUsoId) {

		return _destinazioneUsoLocalService.createDestinazioneUso(
			destinazioneUsoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _destinazioneUsoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the destinazione uso from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUso the destinazione uso
	 * @return the destinazione uso that was removed
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso
		deleteDestinazioneUso(
			it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso
				destinazioneUso) {

		return _destinazioneUsoLocalService.deleteDestinazioneUso(
			destinazioneUso);
	}

	/**
	 * Deletes the destinazione uso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso that was removed
	 * @throws PortalException if a destinazione uso with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso
			deleteDestinazioneUso(long destinazioneUsoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _destinazioneUsoLocalService.deleteDestinazioneUso(
			destinazioneUsoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _destinazioneUsoLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _destinazioneUsoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _destinazioneUsoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _destinazioneUsoLocalService.dynamicQuery();
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

		return _destinazioneUsoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoModelImpl</code>.
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

		return _destinazioneUsoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoModelImpl</code>.
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

		return _destinazioneUsoLocalService.dynamicQuery(
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

		return _destinazioneUsoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _destinazioneUsoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso
		fetchDestinazioneUso(long destinazioneUsoId) {

		return _destinazioneUsoLocalService.fetchDestinazioneUso(
			destinazioneUsoId);
	}

	/**
	 * Returns the destinazione uso matching the UUID and group.
	 *
	 * @param uuid the destinazione uso's UUID
	 * @param groupId the primary key of the group
	 * @return the matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso
		fetchDestinazioneUsoByUuidAndGroupId(String uuid, long groupId) {

		return _destinazioneUsoLocalService.
			fetchDestinazioneUsoByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _destinazioneUsoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the destinazione uso with the primary key.
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso
	 * @throws PortalException if a destinazione uso with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso
			getDestinazioneUso(long destinazioneUsoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _destinazioneUsoLocalService.getDestinazioneUso(
			destinazioneUsoId);
	}

	/**
	 * Returns the destinazione uso matching the UUID and group.
	 *
	 * @param uuid the destinazione uso's UUID
	 * @param groupId the primary key of the group
	 * @return the matching destinazione uso
	 * @throws PortalException if a matching destinazione uso could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso
			getDestinazioneUsoByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _destinazioneUsoLocalService.getDestinazioneUsoByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the destinazione usos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of destinazione usos
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso>
			getDestinazioneUsos(int start, int end) {

		return _destinazioneUsoLocalService.getDestinazioneUsos(start, end);
	}

	/**
	 * Returns all the destinazione usos matching the UUID and company.
	 *
	 * @param uuid the UUID of the destinazione usos
	 * @param companyId the primary key of the company
	 * @return the matching destinazione usos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso>
			getDestinazioneUsosByUuidAndCompanyId(String uuid, long companyId) {

		return _destinazioneUsoLocalService.
			getDestinazioneUsosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of destinazione usos matching the UUID and company.
	 *
	 * @param uuid the UUID of the destinazione usos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching destinazione usos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso>
			getDestinazioneUsosByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<it.servizidigitali.scrivaniaoperatore.model.
						DestinazioneUso> orderByComparator) {

		return _destinazioneUsoLocalService.
			getDestinazioneUsosByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of destinazione usos.
	 *
	 * @return the number of destinazione usos
	 */
	@Override
	public int getDestinazioneUsosCount() {
		return _destinazioneUsoLocalService.getDestinazioneUsosCount();
	}

	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso>
			getDestinazioniUsoByOrganizationId(
				long organizationId, long groupId, long companyId) {

		return _destinazioneUsoLocalService.getDestinazioniUsoByOrganizationId(
			organizationId, groupId, companyId);
	}

	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso>
			getDestinazioniUsoByServizioIdOrganizationId(
				long servizioId, long organizationId, long groupId,
				long companyId) {

		return _destinazioneUsoLocalService.
			getDestinazioniUsoByServizioIdOrganizationId(
				servizioId, organizationId, groupId, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _destinazioneUsoLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _destinazioneUsoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _destinazioneUsoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _destinazioneUsoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the destinazione uso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUso the destinazione uso
	 * @return the destinazione uso that was updated
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso
		updateDestinazioneUso(
			it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso
				destinazioneUso) {

		return _destinazioneUsoLocalService.updateDestinazioneUso(
			destinazioneUso);
	}

	@Override
	public DestinazioneUsoLocalService getWrappedService() {
		return _destinazioneUsoLocalService;
	}

	@Override
	public void setWrappedService(
		DestinazioneUsoLocalService destinazioneUsoLocalService) {

		_destinazioneUsoLocalService = destinazioneUsoLocalService;
	}

	private DestinazioneUsoLocalService _destinazioneUsoLocalService;

}