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
 * Provides a wrapper for {@link AllegatoRichiestaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AllegatoRichiestaLocalService
 * @generated
 */
public class AllegatoRichiestaLocalServiceWrapper
	implements AllegatoRichiestaLocalService,
			   ServiceWrapper<AllegatoRichiestaLocalService> {

	public AllegatoRichiestaLocalServiceWrapper() {
		this(null);
	}

	public AllegatoRichiestaLocalServiceWrapper(
		AllegatoRichiestaLocalService allegatoRichiestaLocalService) {

		_allegatoRichiestaLocalService = allegatoRichiestaLocalService;
	}

	/**
	 * Adds the allegato richiesta to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllegatoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allegatoRichiesta the allegato richiesta
	 * @return the allegato richiesta that was added
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta
		addAllegatoRichiesta(
			it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta
				allegatoRichiesta) {

		return _allegatoRichiestaLocalService.addAllegatoRichiesta(
			allegatoRichiesta);
	}

	/**
	 * Creates a new allegato richiesta with the primary key. Does not add the allegato richiesta to the database.
	 *
	 * @param allegatoRichiestaPK the primary key for the new allegato richiesta
	 * @return the new allegato richiesta
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta
		createAllegatoRichiesta(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				AllegatoRichiestaPK allegatoRichiestaPK) {

		return _allegatoRichiestaLocalService.createAllegatoRichiesta(
			allegatoRichiestaPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allegatoRichiestaLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the allegato richiesta from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllegatoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allegatoRichiesta the allegato richiesta
	 * @return the allegato richiesta that was removed
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta
		deleteAllegatoRichiesta(
			it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta
				allegatoRichiesta) {

		return _allegatoRichiestaLocalService.deleteAllegatoRichiesta(
			allegatoRichiesta);
	}

	/**
	 * Deletes the allegato richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllegatoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allegatoRichiestaPK the primary key of the allegato richiesta
	 * @return the allegato richiesta that was removed
	 * @throws PortalException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta
			deleteAllegatoRichiesta(
				it.servizidigitali.scrivaniaoperatore.service.persistence.
					AllegatoRichiestaPK allegatoRichiestaPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allegatoRichiestaLocalService.deleteAllegatoRichiesta(
			allegatoRichiestaPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allegatoRichiestaLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _allegatoRichiestaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _allegatoRichiestaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _allegatoRichiestaLocalService.dynamicQuery();
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

		return _allegatoRichiestaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.AllegatoRichiestaModelImpl</code>.
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

		return _allegatoRichiestaLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.AllegatoRichiestaModelImpl</code>.
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

		return _allegatoRichiestaLocalService.dynamicQuery(
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

		return _allegatoRichiestaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _allegatoRichiestaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta
		fetchAllegatoRichiesta(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				AllegatoRichiestaPK allegatoRichiestaPK) {

		return _allegatoRichiestaLocalService.fetchAllegatoRichiesta(
			allegatoRichiestaPK);
	}

	/**
	 * Returns the allegato richiesta matching the UUID and group.
	 *
	 * @param uuid the allegato richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta
		fetchAllegatoRichiestaByUuidAndGroupId(String uuid, long groupId) {

		return _allegatoRichiestaLocalService.
			fetchAllegatoRichiestaByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _allegatoRichiestaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the allegato richiesta with the primary key.
	 *
	 * @param allegatoRichiestaPK the primary key of the allegato richiesta
	 * @return the allegato richiesta
	 * @throws PortalException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta
			getAllegatoRichiesta(
				it.servizidigitali.scrivaniaoperatore.service.persistence.
					AllegatoRichiestaPK allegatoRichiestaPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allegatoRichiestaLocalService.getAllegatoRichiesta(
			allegatoRichiestaPK);
	}

	/**
	 * Returns the allegato richiesta matching the UUID and group.
	 *
	 * @param uuid the allegato richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allegato richiesta
	 * @throws PortalException if a matching allegato richiesta could not be found
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta
			getAllegatoRichiestaByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allegatoRichiestaLocalService.
			getAllegatoRichiestaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the allegato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of allegato richiestas
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta>
			getAllegatoRichiestas(int start, int end) {

		return _allegatoRichiestaLocalService.getAllegatoRichiestas(start, end);
	}

	/**
	 * Returns all the allegato richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the allegato richiestas
	 * @param companyId the primary key of the company
	 * @return the matching allegato richiestas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta>
			getAllegatoRichiestasByUuidAndCompanyId(
				String uuid, long companyId) {

		return _allegatoRichiestaLocalService.
			getAllegatoRichiestasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of allegato richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the allegato richiestas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching allegato richiestas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta>
			getAllegatoRichiestasByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<it.servizidigitali.scrivaniaoperatore.model.
						AllegatoRichiesta> orderByComparator) {

		return _allegatoRichiestaLocalService.
			getAllegatoRichiestasByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of allegato richiestas.
	 *
	 * @return the number of allegato richiestas
	 */
	@Override
	public int getAllegatoRichiestasCount() {
		return _allegatoRichiestaLocalService.getAllegatoRichiestasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _allegatoRichiestaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _allegatoRichiestaLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allegatoRichiestaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allegatoRichiestaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the allegato richiesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllegatoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allegatoRichiesta the allegato richiesta
	 * @return the allegato richiesta that was updated
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta
		updateAllegatoRichiesta(
			it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta
				allegatoRichiesta) {

		return _allegatoRichiestaLocalService.updateAllegatoRichiesta(
			allegatoRichiesta);
	}

	@Override
	public AllegatoRichiestaLocalService getWrappedService() {
		return _allegatoRichiestaLocalService;
	}

	@Override
	public void setWrappedService(
		AllegatoRichiestaLocalService allegatoRichiestaLocalService) {

		_allegatoRichiestaLocalService = allegatoRichiestaLocalService;
	}

	private AllegatoRichiestaLocalService _allegatoRichiestaLocalService;

}