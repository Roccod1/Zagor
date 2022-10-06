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
 * Provides a wrapper for {@link AttivitaRichiestaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AttivitaRichiestaLocalService
 * @generated
 */
public class AttivitaRichiestaLocalServiceWrapper
	implements AttivitaRichiestaLocalService,
			   ServiceWrapper<AttivitaRichiestaLocalService> {

	public AttivitaRichiestaLocalServiceWrapper() {
		this(null);
	}

	public AttivitaRichiestaLocalServiceWrapper(
		AttivitaRichiestaLocalService attivitaRichiestaLocalService) {

		_attivitaRichiestaLocalService = attivitaRichiestaLocalService;
	}

	/**
	 * Adds the attivita richiesta to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttivitaRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attivitaRichiesta the attivita richiesta
	 * @return the attivita richiesta that was added
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta
		addAttivitaRichiesta(
			it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta
				attivitaRichiesta) {

		return _attivitaRichiestaLocalService.addAttivitaRichiesta(
			attivitaRichiesta);
	}

	@Override
	public int countAttivitaRichiestaByRichiestaId(long richiestaId) {
		return _attivitaRichiestaLocalService.
			countAttivitaRichiestaByRichiestaId(richiestaId);
	}

	/**
	 * Creates a new attivita richiesta with the primary key. Does not add the attivita richiesta to the database.
	 *
	 * @param attivitaRichiestaId the primary key for the new attivita richiesta
	 * @return the new attivita richiesta
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta
		createAttivitaRichiesta(long attivitaRichiestaId) {

		return _attivitaRichiestaLocalService.createAttivitaRichiesta(
			attivitaRichiestaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attivitaRichiestaLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the attivita richiesta from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttivitaRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attivitaRichiesta the attivita richiesta
	 * @return the attivita richiesta that was removed
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta
		deleteAttivitaRichiesta(
			it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta
				attivitaRichiesta) {

		return _attivitaRichiestaLocalService.deleteAttivitaRichiesta(
			attivitaRichiesta);
	}

	/**
	 * Deletes the attivita richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttivitaRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attivitaRichiestaId the primary key of the attivita richiesta
	 * @return the attivita richiesta that was removed
	 * @throws PortalException if a attivita richiesta with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta
			deleteAttivitaRichiesta(long attivitaRichiestaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attivitaRichiestaLocalService.deleteAttivitaRichiesta(
			attivitaRichiestaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attivitaRichiestaLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _attivitaRichiestaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _attivitaRichiestaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _attivitaRichiestaLocalService.dynamicQuery();
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

		return _attivitaRichiestaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.AttivitaRichiestaModelImpl</code>.
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

		return _attivitaRichiestaLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.AttivitaRichiestaModelImpl</code>.
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

		return _attivitaRichiestaLocalService.dynamicQuery(
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

		return _attivitaRichiestaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _attivitaRichiestaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta
		fetchAttivitaRichiesta(long attivitaRichiestaId) {

		return _attivitaRichiestaLocalService.fetchAttivitaRichiesta(
			attivitaRichiestaId);
	}

	/**
	 * Returns the attivita richiesta matching the UUID and group.
	 *
	 * @param uuid the attivita richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta
		fetchAttivitaRichiestaByUuidAndGroupId(String uuid, long groupId) {

		return _attivitaRichiestaLocalService.
			fetchAttivitaRichiestaByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _attivitaRichiestaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the attivita richiesta with the primary key.
	 *
	 * @param attivitaRichiestaId the primary key of the attivita richiesta
	 * @return the attivita richiesta
	 * @throws PortalException if a attivita richiesta with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta
			getAttivitaRichiesta(long attivitaRichiestaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attivitaRichiestaLocalService.getAttivitaRichiesta(
			attivitaRichiestaId);
	}

	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta>
			getAttivitaRichiestaByRichiestaId(long richiestaId) {

		return _attivitaRichiestaLocalService.getAttivitaRichiestaByRichiestaId(
			richiestaId);
	}

	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta>
			getAttivitaRichiestaByRichiestaId(
				long richiestaId, int start, int end) {

		return _attivitaRichiestaLocalService.getAttivitaRichiestaByRichiestaId(
			richiestaId, start, end);
	}

	/**
	 * Returns the attivita richiesta matching the UUID and group.
	 *
	 * @param uuid the attivita richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching attivita richiesta
	 * @throws PortalException if a matching attivita richiesta could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta
			getAttivitaRichiestaByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attivitaRichiestaLocalService.
			getAttivitaRichiestaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the attivita richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of attivita richiestas
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta>
			getAttivitaRichiestas(int start, int end) {

		return _attivitaRichiestaLocalService.getAttivitaRichiestas(start, end);
	}

	/**
	 * Returns all the attivita richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the attivita richiestas
	 * @param companyId the primary key of the company
	 * @return the matching attivita richiestas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta>
			getAttivitaRichiestasByUuidAndCompanyId(
				String uuid, long companyId) {

		return _attivitaRichiestaLocalService.
			getAttivitaRichiestasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of attivita richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the attivita richiestas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching attivita richiestas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta>
			getAttivitaRichiestasByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<it.servizidigitali.scrivaniaoperatore.model.
						AttivitaRichiesta> orderByComparator) {

		return _attivitaRichiestaLocalService.
			getAttivitaRichiestasByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of attivita richiestas.
	 *
	 * @return the number of attivita richiestas
	 */
	@Override
	public int getAttivitaRichiestasCount() {
		return _attivitaRichiestaLocalService.getAttivitaRichiestasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _attivitaRichiestaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _attivitaRichiestaLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _attivitaRichiestaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attivitaRichiestaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the attivita richiesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttivitaRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attivitaRichiesta the attivita richiesta
	 * @return the attivita richiesta that was updated
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta
		updateAttivitaRichiesta(
			it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta
				attivitaRichiesta) {

		return _attivitaRichiestaLocalService.updateAttivitaRichiesta(
			attivitaRichiesta);
	}

	@Override
	public AttivitaRichiestaLocalService getWrappedService() {
		return _attivitaRichiestaLocalService;
	}

	@Override
	public void setWrappedService(
		AttivitaRichiestaLocalService attivitaRichiestaLocalService) {

		_attivitaRichiestaLocalService = attivitaRichiestaLocalService;
	}

	private AttivitaRichiestaLocalService _attivitaRichiestaLocalService;

}