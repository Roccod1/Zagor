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
 * Provides a wrapper for {@link CommentoRichiestaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CommentoRichiestaLocalService
 * @generated
 */
public class CommentoRichiestaLocalServiceWrapper
	implements CommentoRichiestaLocalService,
			   ServiceWrapper<CommentoRichiestaLocalService> {

	public CommentoRichiestaLocalServiceWrapper() {
		this(null);
	}

	public CommentoRichiestaLocalServiceWrapper(
		CommentoRichiestaLocalService commentoRichiestaLocalService) {

		_commentoRichiestaLocalService = commentoRichiestaLocalService;
	}

	/**
	 * Adds the commento richiesta to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentoRichiesta the commento richiesta
	 * @return the commento richiesta that was added
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta
		addCommentoRichiesta(
			it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta
				commentoRichiesta) {

		return _commentoRichiestaLocalService.addCommentoRichiesta(
			commentoRichiesta);
	}

	@Override
	public int countCommentiRichiestaByRichiestaIdVisibile(
		long richiestaId, boolean visibile) {

		return _commentoRichiestaLocalService.
			countCommentiRichiestaByRichiestaIdVisibile(richiestaId, visibile);
	}

	/**
	 * Creates a new commento richiesta with the primary key. Does not add the commento richiesta to the database.
	 *
	 * @param commentoRichiestaId the primary key for the new commento richiesta
	 * @return the new commento richiesta
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta
		createCommentoRichiesta(long commentoRichiestaId) {

		return _commentoRichiestaLocalService.createCommentoRichiesta(
			commentoRichiestaId);
	}

	@Override
	public long createCommentoRichiesta(
		String testo, String taskId, boolean visibile, long richiestaId,
		long userId, String userName, long groupId, long companyId) {

		return _commentoRichiestaLocalService.createCommentoRichiesta(
			testo, taskId, visibile, richiestaId, userId, userName, groupId,
			companyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentoRichiestaLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the commento richiesta from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentoRichiesta the commento richiesta
	 * @return the commento richiesta that was removed
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta
		deleteCommentoRichiesta(
			it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta
				commentoRichiesta) {

		return _commentoRichiestaLocalService.deleteCommentoRichiesta(
			commentoRichiesta);
	}

	/**
	 * Deletes the commento richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta that was removed
	 * @throws PortalException if a commento richiesta with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta
			deleteCommentoRichiesta(long commentoRichiestaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentoRichiestaLocalService.deleteCommentoRichiesta(
			commentoRichiestaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentoRichiestaLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _commentoRichiestaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _commentoRichiestaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commentoRichiestaLocalService.dynamicQuery();
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

		return _commentoRichiestaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.CommentoRichiestaModelImpl</code>.
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

		return _commentoRichiestaLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.CommentoRichiestaModelImpl</code>.
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

		return _commentoRichiestaLocalService.dynamicQuery(
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

		return _commentoRichiestaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _commentoRichiestaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta
		fetchCommentoRichiesta(long commentoRichiestaId) {

		return _commentoRichiestaLocalService.fetchCommentoRichiesta(
			commentoRichiestaId);
	}

	/**
	 * Returns the commento richiesta matching the UUID and group.
	 *
	 * @param uuid the commento richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta
		fetchCommentoRichiestaByUuidAndGroupId(String uuid, long groupId) {

		return _commentoRichiestaLocalService.
			fetchCommentoRichiestaByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _commentoRichiestaLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta>
			getCommentiRichiestaByRichiestaId(long richiestaId) {

		return _commentoRichiestaLocalService.getCommentiRichiestaByRichiestaId(
			richiestaId);
	}

	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta>
			getCommentiRichiestaByRichiestaIdVisibile(
				long richiestaId, boolean visibile) {

		return _commentoRichiestaLocalService.
			getCommentiRichiestaByRichiestaIdVisibile(richiestaId, visibile);
	}

	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta>
			getCommentiRichiestaByRichiestaIdVisibile(
				long richiestaId, boolean visibile, int start, int end) {

		return _commentoRichiestaLocalService.
			getCommentiRichiestaByRichiestaIdVisibile(
				richiestaId, visibile, start, end);
	}

	/**
	 * Returns the commento richiesta with the primary key.
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta
	 * @throws PortalException if a commento richiesta with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta
			getCommentoRichiesta(long commentoRichiestaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentoRichiestaLocalService.getCommentoRichiesta(
			commentoRichiestaId);
	}

	/**
	 * Returns the commento richiesta matching the UUID and group.
	 *
	 * @param uuid the commento richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching commento richiesta
	 * @throws PortalException if a matching commento richiesta could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta
			getCommentoRichiestaByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentoRichiestaLocalService.
			getCommentoRichiestaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the commento richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of commento richiestas
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta>
			getCommentoRichiestas(int start, int end) {

		return _commentoRichiestaLocalService.getCommentoRichiestas(start, end);
	}

	/**
	 * Returns all the commento richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the commento richiestas
	 * @param companyId the primary key of the company
	 * @return the matching commento richiestas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta>
			getCommentoRichiestasByUuidAndCompanyId(
				String uuid, long companyId) {

		return _commentoRichiestaLocalService.
			getCommentoRichiestasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of commento richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the commento richiestas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching commento richiestas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta>
			getCommentoRichiestasByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<it.servizidigitali.scrivaniaoperatore.model.
						CommentoRichiesta> orderByComparator) {

		return _commentoRichiestaLocalService.
			getCommentoRichiestasByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of commento richiestas.
	 *
	 * @return the number of commento richiestas
	 */
	@Override
	public int getCommentoRichiestasCount() {
		return _commentoRichiestaLocalService.getCommentoRichiestasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _commentoRichiestaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _commentoRichiestaLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commentoRichiestaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentoRichiestaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the commento richiesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentoRichiesta the commento richiesta
	 * @return the commento richiesta that was updated
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta
		updateCommentoRichiesta(
			it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta
				commentoRichiesta) {

		return _commentoRichiestaLocalService.updateCommentoRichiesta(
			commentoRichiesta);
	}

	@Override
	public CommentoRichiestaLocalService getWrappedService() {
		return _commentoRichiestaLocalService;
	}

	@Override
	public void setWrappedService(
		CommentoRichiestaLocalService commentoRichiestaLocalService) {

		_commentoRichiestaLocalService = commentoRichiestaLocalService;
	}

	private CommentoRichiestaLocalService _commentoRichiestaLocalService;

}