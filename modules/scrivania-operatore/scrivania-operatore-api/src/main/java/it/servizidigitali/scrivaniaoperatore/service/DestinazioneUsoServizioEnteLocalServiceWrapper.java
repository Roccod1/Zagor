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
 * Provides a wrapper for {@link DestinazioneUsoServizioEnteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DestinazioneUsoServizioEnteLocalService
 * @generated
 */
public class DestinazioneUsoServizioEnteLocalServiceWrapper
	implements DestinazioneUsoServizioEnteLocalService,
			   ServiceWrapper<DestinazioneUsoServizioEnteLocalService> {

	public DestinazioneUsoServizioEnteLocalServiceWrapper() {
		this(null);
	}

	public DestinazioneUsoServizioEnteLocalServiceWrapper(
		DestinazioneUsoServizioEnteLocalService
			destinazioneUsoServizioEnteLocalService) {

		_destinazioneUsoServizioEnteLocalService =
			destinazioneUsoServizioEnteLocalService;
	}

	/**
	 * Adds the destinazione uso servizio ente to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUsoServizioEnte the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente that was added
	 */
	@Override
	public
		it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte
			addDestinazioneUsoServizioEnte(
				it.servizidigitali.scrivaniaoperatore.model.
					DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		return _destinazioneUsoServizioEnteLocalService.
			addDestinazioneUsoServizioEnte(destinazioneUsoServizioEnte);
	}

	/**
	 * Creates a new destinazione uso servizio ente with the primary key. Does not add the destinazione uso servizio ente to the database.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key for the new destinazione uso servizio ente
	 * @return the new destinazione uso servizio ente
	 */
	@Override
	public
		it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte
			createDestinazioneUsoServizioEnte(
				it.servizidigitali.scrivaniaoperatore.service.persistence.
					DestinazioneUsoServizioEntePK
						destinazioneUsoServizioEntePK) {

		return _destinazioneUsoServizioEnteLocalService.
			createDestinazioneUsoServizioEnte(destinazioneUsoServizioEntePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _destinazioneUsoServizioEnteLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the destinazione uso servizio ente from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUsoServizioEnte the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente that was removed
	 */
	@Override
	public
		it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte
			deleteDestinazioneUsoServizioEnte(
				it.servizidigitali.scrivaniaoperatore.model.
					DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		return _destinazioneUsoServizioEnteLocalService.
			deleteDestinazioneUsoServizioEnte(destinazioneUsoServizioEnte);
	}

	/**
	 * Deletes the destinazione uso servizio ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente that was removed
	 * @throws PortalException if a destinazione uso servizio ente with the primary key could not be found
	 */
	@Override
	public
		it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte
				deleteDestinazioneUsoServizioEnte(
					it.servizidigitali.scrivaniaoperatore.service.persistence.
						DestinazioneUsoServizioEntePK
							destinazioneUsoServizioEntePK)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _destinazioneUsoServizioEnteLocalService.
			deleteDestinazioneUsoServizioEnte(destinazioneUsoServizioEntePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _destinazioneUsoServizioEnteLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _destinazioneUsoServizioEnteLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _destinazioneUsoServizioEnteLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _destinazioneUsoServizioEnteLocalService.dynamicQuery();
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

		return _destinazioneUsoServizioEnteLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoServizioEnteModelImpl</code>.
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

		return _destinazioneUsoServizioEnteLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoServizioEnteModelImpl</code>.
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

		return _destinazioneUsoServizioEnteLocalService.dynamicQuery(
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

		return _destinazioneUsoServizioEnteLocalService.dynamicQueryCount(
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

		return _destinazioneUsoServizioEnteLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public
		it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte
			fetchDestinazioneUsoServizioEnte(
				it.servizidigitali.scrivaniaoperatore.service.persistence.
					DestinazioneUsoServizioEntePK
						destinazioneUsoServizioEntePK) {

		return _destinazioneUsoServizioEnteLocalService.
			fetchDestinazioneUsoServizioEnte(destinazioneUsoServizioEntePK);
	}

	/**
	 * Returns the destinazione uso servizio ente matching the UUID and group.
	 *
	 * @param uuid the destinazione uso servizio ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public
		it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte
			fetchDestinazioneUsoServizioEnteByUuidAndGroupId(
				String uuid, long groupId) {

		return _destinazioneUsoServizioEnteLocalService.
			fetchDestinazioneUsoServizioEnteByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _destinazioneUsoServizioEnteLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the destinazione uso servizio ente with the primary key.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente
	 * @throws PortalException if a destinazione uso servizio ente with the primary key could not be found
	 */
	@Override
	public
		it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte
				getDestinazioneUsoServizioEnte(
					it.servizidigitali.scrivaniaoperatore.service.persistence.
						DestinazioneUsoServizioEntePK
							destinazioneUsoServizioEntePK)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _destinazioneUsoServizioEnteLocalService.
			getDestinazioneUsoServizioEnte(destinazioneUsoServizioEntePK);
	}

	/**
	 * Returns the destinazione uso servizio ente matching the UUID and group.
	 *
	 * @param uuid the destinazione uso servizio ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching destinazione uso servizio ente
	 * @throws PortalException if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public
		it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte
				getDestinazioneUsoServizioEnteByUuidAndGroupId(
					String uuid, long groupId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _destinazioneUsoServizioEnteLocalService.
			getDestinazioneUsoServizioEnteByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the destinazione uso servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of destinazione uso servizio entes
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.
			DestinazioneUsoServizioEnte> getDestinazioneUsoServizioEntes(
				int start, int end) {

		return _destinazioneUsoServizioEnteLocalService.
			getDestinazioneUsoServizioEntes(start, end);
	}

	/**
	 * Returns all the destinazione uso servizio entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the destinazione uso servizio entes
	 * @param companyId the primary key of the company
	 * @return the matching destinazione uso servizio entes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.
			DestinazioneUsoServizioEnte>
				getDestinazioneUsoServizioEntesByUuidAndCompanyId(
					String uuid, long companyId) {

		return _destinazioneUsoServizioEnteLocalService.
			getDestinazioneUsoServizioEntesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of destinazione uso servizio entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the destinazione uso servizio entes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching destinazione uso servizio entes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.
			DestinazioneUsoServizioEnte>
				getDestinazioneUsoServizioEntesByUuidAndCompanyId(
					String uuid, long companyId, int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<it.servizidigitali.scrivaniaoperatore.model.
							DestinazioneUsoServizioEnte> orderByComparator) {

		return _destinazioneUsoServizioEnteLocalService.
			getDestinazioneUsoServizioEntesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of destinazione uso servizio entes.
	 *
	 * @return the number of destinazione uso servizio entes
	 */
	@Override
	public int getDestinazioneUsoServizioEntesCount() {
		return _destinazioneUsoServizioEnteLocalService.
			getDestinazioneUsoServizioEntesCount();
	}

	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.
			DestinazioneUsoServizioEnte>
				getDestinazioniUsoServizioEnteByServizioIdOrganizationId(
					long servizioId, long organizationId, long groupId,
					long companyId) {

		return _destinazioneUsoServizioEnteLocalService.
			getDestinazioniUsoServizioEnteByServizioIdOrganizationId(
				servizioId, organizationId, groupId, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _destinazioneUsoServizioEnteLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _destinazioneUsoServizioEnteLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _destinazioneUsoServizioEnteLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _destinazioneUsoServizioEnteLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the destinazione uso servizio ente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUsoServizioEnte the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente that was updated
	 */
	@Override
	public
		it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte
			updateDestinazioneUsoServizioEnte(
				it.servizidigitali.scrivaniaoperatore.model.
					DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		return _destinazioneUsoServizioEnteLocalService.
			updateDestinazioneUsoServizioEnte(destinazioneUsoServizioEnte);
	}

	@Override
	public DestinazioneUsoServizioEnteLocalService getWrappedService() {
		return _destinazioneUsoServizioEnteLocalService;
	}

	@Override
	public void setWrappedService(
		DestinazioneUsoServizioEnteLocalService
			destinazioneUsoServizioEnteLocalService) {

		_destinazioneUsoServizioEnteLocalService =
			destinazioneUsoServizioEnteLocalService;
	}

	private DestinazioneUsoServizioEnteLocalService
		_destinazioneUsoServizioEnteLocalService;

}