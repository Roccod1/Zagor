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

package it.servizidigitali.chatbot.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RichiestaCertificatoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaCertificatoLocalService
 * @generated
 */
public class RichiestaCertificatoLocalServiceWrapper
	implements RichiestaCertificatoLocalService,
			   ServiceWrapper<RichiestaCertificatoLocalService> {

	public RichiestaCertificatoLocalServiceWrapper() {
		this(null);
	}

	public RichiestaCertificatoLocalServiceWrapper(
		RichiestaCertificatoLocalService richiestaCertificatoLocalService) {

		_richiestaCertificatoLocalService = richiestaCertificatoLocalService;
	}

	/**
	 * Adds the richiesta certificato to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaCertificatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaCertificato the richiesta certificato
	 * @return the richiesta certificato that was added
	 */
	@Override
	public it.servizidigitali.chatbot.model.RichiestaCertificato
		addRichiestaCertificato(
			it.servizidigitali.chatbot.model.RichiestaCertificato
				richiestaCertificato) {

		return _richiestaCertificatoLocalService.addRichiestaCertificato(
			richiestaCertificato);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _richiestaCertificatoLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new richiesta certificato with the primary key. Does not add the richiesta certificato to the database.
	 *
	 * @param richiestaCertificatoId the primary key for the new richiesta certificato
	 * @return the new richiesta certificato
	 */
	@Override
	public it.servizidigitali.chatbot.model.RichiestaCertificato
		createRichiestaCertificato(long richiestaCertificatoId) {

		return _richiestaCertificatoLocalService.createRichiestaCertificato(
			richiestaCertificatoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _richiestaCertificatoLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the richiesta certificato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaCertificatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato that was removed
	 * @throws PortalException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.chatbot.model.RichiestaCertificato
			deleteRichiestaCertificato(long richiestaCertificatoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _richiestaCertificatoLocalService.deleteRichiestaCertificato(
			richiestaCertificatoId);
	}

	/**
	 * Deletes the richiesta certificato from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaCertificatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaCertificato the richiesta certificato
	 * @return the richiesta certificato that was removed
	 */
	@Override
	public it.servizidigitali.chatbot.model.RichiestaCertificato
		deleteRichiestaCertificato(
			it.servizidigitali.chatbot.model.RichiestaCertificato
				richiestaCertificato) {

		return _richiestaCertificatoLocalService.deleteRichiestaCertificato(
			richiestaCertificato);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _richiestaCertificatoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _richiestaCertificatoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _richiestaCertificatoLocalService.dynamicQuery();
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

		return _richiestaCertificatoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.chatbot.model.impl.RichiestaCertificatoModelImpl</code>.
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

		return _richiestaCertificatoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.chatbot.model.impl.RichiestaCertificatoModelImpl</code>.
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

		return _richiestaCertificatoLocalService.dynamicQuery(
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

		return _richiestaCertificatoLocalService.dynamicQueryCount(
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

		return _richiestaCertificatoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.chatbot.model.RichiestaCertificato
		fetchRichiestaCertificato(long richiestaCertificatoId) {

		return _richiestaCertificatoLocalService.fetchRichiestaCertificato(
			richiestaCertificatoId);
	}

	/**
	 * Returns the richiesta certificato matching the UUID and group.
	 *
	 * @param uuid the richiesta certificato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public it.servizidigitali.chatbot.model.RichiestaCertificato
		fetchRichiestaCertificatoByUuidAndGroupId(String uuid, long groupId) {

		return _richiestaCertificatoLocalService.
			fetchRichiestaCertificatoByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _richiestaCertificatoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _richiestaCertificatoLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _richiestaCertificatoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _richiestaCertificatoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _richiestaCertificatoLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the richiesta certificato with the primary key.
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato
	 * @throws PortalException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.chatbot.model.RichiestaCertificato
			getRichiestaCertificato(long richiestaCertificatoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _richiestaCertificatoLocalService.getRichiestaCertificato(
			richiestaCertificatoId);
	}

	/**
	 * Returns the richiesta certificato matching the UUID and group.
	 *
	 * @param uuid the richiesta certificato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching richiesta certificato
	 * @throws PortalException if a matching richiesta certificato could not be found
	 */
	@Override
	public it.servizidigitali.chatbot.model.RichiestaCertificato
			getRichiestaCertificatoByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _richiestaCertificatoLocalService.
			getRichiestaCertificatoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the richiesta certificatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.chatbot.model.impl.RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of richiesta certificatos
	 */
	@Override
	public java.util.List<it.servizidigitali.chatbot.model.RichiestaCertificato>
		getRichiestaCertificatos(int start, int end) {

		return _richiestaCertificatoLocalService.getRichiestaCertificatos(
			start, end);
	}

	/**
	 * Returns all the richiesta certificatos matching the UUID and company.
	 *
	 * @param uuid the UUID of the richiesta certificatos
	 * @param companyId the primary key of the company
	 * @return the matching richiesta certificatos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.chatbot.model.RichiestaCertificato>
		getRichiestaCertificatosByUuidAndCompanyId(
			String uuid, long companyId) {

		return _richiestaCertificatoLocalService.
			getRichiestaCertificatosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of richiesta certificatos matching the UUID and company.
	 *
	 * @param uuid the UUID of the richiesta certificatos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching richiesta certificatos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.chatbot.model.RichiestaCertificato>
		getRichiestaCertificatosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.chatbot.model.RichiestaCertificato>
					orderByComparator) {

		return _richiestaCertificatoLocalService.
			getRichiestaCertificatosByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of richiesta certificatos.
	 *
	 * @return the number of richiesta certificatos
	 */
	@Override
	public int getRichiestaCertificatosCount() {
		return _richiestaCertificatoLocalService.
			getRichiestaCertificatosCount();
	}

	/**
	 * Updates the richiesta certificato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaCertificatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaCertificato the richiesta certificato
	 * @return the richiesta certificato that was updated
	 */
	@Override
	public it.servizidigitali.chatbot.model.RichiestaCertificato
		updateRichiestaCertificato(
			it.servizidigitali.chatbot.model.RichiestaCertificato
				richiestaCertificato) {

		return _richiestaCertificatoLocalService.updateRichiestaCertificato(
			richiestaCertificato);
	}

	@Override
	public RichiestaCertificatoLocalService getWrappedService() {
		return _richiestaCertificatoLocalService;
	}

	@Override
	public void setWrappedService(
		RichiestaCertificatoLocalService richiestaCertificatoLocalService) {

		_richiestaCertificatoLocalService = richiestaCertificatoLocalService;
	}

	private RichiestaCertificatoLocalService _richiestaCertificatoLocalService;

}