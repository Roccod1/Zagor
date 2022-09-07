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
 * Provides a wrapper for {@link RichiestaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaLocalService
 * @generated
 */
public class RichiestaLocalServiceWrapper
	implements RichiestaLocalService, ServiceWrapper<RichiestaLocalService> {

	public RichiestaLocalServiceWrapper() {
		this(null);
	}

	public RichiestaLocalServiceWrapper(
		RichiestaLocalService richiestaLocalService) {

		_richiestaLocalService = richiestaLocalService;
	}

	/**
	 * Adds the richiesta to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiesta the richiesta
	 * @return the richiesta that was added
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.Richiesta addRichiesta(
		it.servizidigitali.scrivaniaoperatore.model.Richiesta richiesta) {

		return _richiestaLocalService.addRichiesta(richiesta);
	}

	@Override
	public int count(
		it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters filters) {

		return _richiestaLocalService.count(filters);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _richiestaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new richiesta with the primary key. Does not add the richiesta to the database.
	 *
	 * @param richiestaId the primary key for the new richiesta
	 * @return the new richiesta
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.Richiesta
		createRichiesta(long richiestaId) {

		return _richiestaLocalService.createRichiesta(richiestaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _richiestaLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta that was removed
	 * @throws PortalException if a richiesta with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.Richiesta
			deleteRichiesta(long richiestaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _richiestaLocalService.deleteRichiesta(richiestaId);
	}

	/**
	 * Deletes the richiesta from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiesta the richiesta
	 * @return the richiesta that was removed
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.Richiesta
		deleteRichiesta(
			it.servizidigitali.scrivaniaoperatore.model.Richiesta richiesta) {

		return _richiestaLocalService.deleteRichiesta(richiesta);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _richiestaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _richiestaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _richiestaLocalService.dynamicQuery();
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

		return _richiestaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaModelImpl</code>.
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

		return _richiestaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaModelImpl</code>.
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

		return _richiestaLocalService.dynamicQuery(
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

		return _richiestaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _richiestaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.scrivaniaoperatore.model.Richiesta fetchRichiesta(
		long richiestaId) {

		return _richiestaLocalService.fetchRichiesta(richiestaId);
	}

	/**
	 * Returns the richiesta matching the UUID and group.
	 *
	 * @param uuid the richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.Richiesta
		fetchRichiestaByUuidAndGroupId(String uuid, long groupId) {

		return _richiestaLocalService.fetchRichiestaByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _richiestaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _richiestaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _richiestaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _richiestaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _richiestaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the richiesta with the primary key.
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta
	 * @throws PortalException if a richiesta with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.Richiesta getRichiesta(
			long richiestaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _richiestaLocalService.getRichiesta(richiestaId);
	}

	/**
	 * Returns the richiesta matching the UUID and group.
	 *
	 * @param uuid the richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching richiesta
	 * @throws PortalException if a matching richiesta could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.Richiesta
			getRichiestaByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _richiestaLocalService.getRichiestaByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of richiestas
	 */
	@Override
	public java.util.List<it.servizidigitali.scrivaniaoperatore.model.Richiesta>
		getRichiestas(int start, int end) {

		return _richiestaLocalService.getRichiestas(start, end);
	}

	/**
	 * Returns all the richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the richiestas
	 * @param companyId the primary key of the company
	 * @return the matching richiestas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.scrivaniaoperatore.model.Richiesta>
		getRichiestasByUuidAndCompanyId(String uuid, long companyId) {

		return _richiestaLocalService.getRichiestasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the richiestas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching richiestas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.scrivaniaoperatore.model.Richiesta>
		getRichiestasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.scrivaniaoperatore.model.Richiesta>
					orderByComparator) {

		return _richiestaLocalService.getRichiestasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of richiestas.
	 *
	 * @return the number of richiestas
	 */
	@Override
	public int getRichiestasCount() {
		return _richiestaLocalService.getRichiestasCount();
	}

	@Override
	public java.util.List<it.servizidigitali.scrivaniaoperatore.model.Richiesta>
			getRichiesteByCodiceFiscaleUtenteAndOrganizationGroupid(
				String codiceFiscale, long organizationGroupId, int cur,
				int delta, String orderByCol, String orderByType)
		throws Exception {

		return _richiestaLocalService.
			getRichiesteByCodiceFiscaleUtenteAndOrganizationGroupid(
				codiceFiscale, organizationGroupId, cur, delta, orderByCol,
				orderByType);
	}

	@Override
	public java.util.List<it.servizidigitali.scrivaniaoperatore.model.Richiesta>
		getRichiesteByStato(String stato) {

		return _richiestaLocalService.getRichiesteByStato(stato);
	}

	@Override
	public java.util.List<it.servizidigitali.scrivaniaoperatore.model.Richiesta>
		search(
			it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters
				filters,
			int start, int end) {

		return _richiestaLocalService.search(filters, start, end);
	}

	@Override
	public void updateProcessiInstanceIdRichiesta(
			long richiestaId, String processInstanceId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		_richiestaLocalService.updateProcessiInstanceIdRichiesta(
			richiestaId, processInstanceId);
	}

	/**
	 * Updates the richiesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiesta the richiesta
	 * @return the richiesta that was updated
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.Richiesta
		updateRichiesta(
			it.servizidigitali.scrivaniaoperatore.model.Richiesta richiesta) {

		return _richiestaLocalService.updateRichiesta(richiesta);
	}

	@Override
	public void updateStatoRichiesta(long richiestaId, String stato)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		_richiestaLocalService.updateStatoRichiesta(richiestaId, stato);
	}

	@Override
	public RichiestaLocalService getWrappedService() {
		return _richiestaLocalService;
	}

	@Override
	public void setWrappedService(RichiestaLocalService richiestaLocalService) {
		_richiestaLocalService = richiestaLocalService;
	}

	private RichiestaLocalService _richiestaLocalService;

}