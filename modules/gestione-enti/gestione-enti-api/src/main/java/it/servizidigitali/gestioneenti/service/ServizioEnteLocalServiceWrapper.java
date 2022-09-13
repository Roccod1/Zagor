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

package it.servizidigitali.gestioneenti.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ServizioEnteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioEnteLocalService
 * @generated
 */
public class ServizioEnteLocalServiceWrapper
	implements ServiceWrapper<ServizioEnteLocalService>,
			   ServizioEnteLocalService {

	public ServizioEnteLocalServiceWrapper() {
		this(null);
	}

	public ServizioEnteLocalServiceWrapper(
		ServizioEnteLocalService servizioEnteLocalService) {

		_servizioEnteLocalService = servizioEnteLocalService;
	}

	/**
	 * Adds the servizio ente to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizioEnte the servizio ente
	 * @return the servizio ente that was added
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.ServizioEnte addServizioEnte(
		it.servizidigitali.gestioneenti.model.ServizioEnte servizioEnte) {

		return _servizioEnteLocalService.addServizioEnte(servizioEnte);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servizioEnteLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new servizio ente with the primary key. Does not add the servizio ente to the database.
	 *
	 * @param servizioEntePK the primary key for the new servizio ente
	 * @return the new servizio ente
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.ServizioEnte
		createServizioEnte(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK) {

		return _servizioEnteLocalService.createServizioEnte(servizioEntePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servizioEnteLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the servizio ente from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizioEnte the servizio ente
	 * @return the servizio ente that was removed
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.ServizioEnte
		deleteServizioEnte(
			it.servizidigitali.gestioneenti.model.ServizioEnte servizioEnte) {

		return _servizioEnteLocalService.deleteServizioEnte(servizioEnte);
	}

	/**
	 * Deletes the servizio ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente that was removed
	 * @throws PortalException if a servizio ente with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.ServizioEnte
			deleteServizioEnte(
				it.servizidigitali.gestioneenti.service.persistence.
					ServizioEntePK servizioEntePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servizioEnteLocalService.deleteServizioEnte(servizioEntePK);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _servizioEnteLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _servizioEnteLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _servizioEnteLocalService.dynamicQuery();
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

		return _servizioEnteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneenti.model.impl.ServizioEnteModelImpl</code>.
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

		return _servizioEnteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneenti.model.impl.ServizioEnteModelImpl</code>.
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

		return _servizioEnteLocalService.dynamicQuery(
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

		return _servizioEnteLocalService.dynamicQueryCount(dynamicQuery);
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

		return _servizioEnteLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestioneenti.model.ServizioEnte fetchServizioEnte(
		it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
			servizioEntePK) {

		return _servizioEnteLocalService.fetchServizioEnte(servizioEntePK);
	}

	/**
	 * Returns the servizio ente matching the UUID and group.
	 *
	 * @param uuid the servizio ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.ServizioEnte
		fetchServizioEnteByUuidAndGroupId(String uuid, long groupId) {

		return _servizioEnteLocalService.fetchServizioEnteByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
			findOrganizationsByParams(
				String nome, String codiceIpa, int cur, int delta,
				String orderByCol, String orderByType)
		throws Exception {

		return _servizioEnteLocalService.findOrganizationsByParams(
			nome, codiceIpa, cur, delta, orderByCol, orderByType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _servizioEnteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _servizioEnteLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _servizioEnteLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<Object> getListaServiziByCompanyOrganizationAttivo(
			long companyId, long organizationId, boolean attivo)
		throws Exception {

		return _servizioEnteLocalService.
			getListaServiziByCompanyOrganizationAttivo(
				companyId, organizationId, attivo);
	}

	@Override
	public java.util.List<Long> getListaServiziByOrganizationAttivo(
			long organizationId, boolean attivo)
		throws Exception {

		return _servizioEnteLocalService.getListaServiziByOrganizationAttivo(
			organizationId, attivo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _servizioEnteLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servizioEnteLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneenti.model.ServizioEnte>
		getServiziEnte(long organizationId) {

		return _servizioEnteLocalService.getServiziEnte(organizationId);
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneenti.model.ServizioEnte>
		getServiziEnteByOrganizationIdSubOrganizationIdsAttivo(
			long organizationId, java.util.List<Long> subOrganizationIds,
			Boolean attivo, long groupId, long companyId) {

		return _servizioEnteLocalService.
			getServiziEnteByOrganizationIdSubOrganizationIdsAttivo(
				organizationId, subOrganizationIds, attivo, groupId, companyId);
	}

	/**
	 * Returns the servizio ente with the primary key.
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente
	 * @throws PortalException if a servizio ente with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.ServizioEnte getServizioEnte(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servizioEnteLocalService.getServizioEnte(servizioEntePK);
	}

	@Override
	public it.servizidigitali.gestioneenti.model.ServizioEnte
		getServizioEnteByOrganizationIdLayoutId(
			long organizationId, long layoutId) {

		return _servizioEnteLocalService.
			getServizioEnteByOrganizationIdLayoutId(organizationId, layoutId);
	}

	/**
	 * Returns the servizio ente matching the UUID and group.
	 *
	 * @param uuid the servizio ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching servizio ente
	 * @throws PortalException if a matching servizio ente could not be found
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.ServizioEnte
			getServizioEnteByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servizioEnteLocalService.getServizioEnteByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneenti.model.impl.ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of servizio entes
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneenti.model.ServizioEnte>
		getServizioEntes(int start, int end) {

		return _servizioEnteLocalService.getServizioEntes(start, end);
	}

	/**
	 * Returns all the servizio entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the servizio entes
	 * @param companyId the primary key of the company
	 * @return the matching servizio entes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneenti.model.ServizioEnte>
		getServizioEntesByUuidAndCompanyId(String uuid, long companyId) {

		return _servizioEnteLocalService.getServizioEntesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of servizio entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the servizio entes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching servizio entes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneenti.model.ServizioEnte>
		getServizioEntesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestioneenti.model.ServizioEnte>
					orderByComparator) {

		return _servizioEnteLocalService.getServizioEntesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of servizio entes.
	 *
	 * @return the number of servizio entes
	 */
	@Override
	public int getServizioEntesCount() {
		return _servizioEnteLocalService.getServizioEntesCount();
	}

	/**
	 * Updates the servizio ente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizioEnte the servizio ente
	 * @return the servizio ente that was updated
	 */
	@Override
	public it.servizidigitali.gestioneenti.model.ServizioEnte
		updateServizioEnte(
			it.servizidigitali.gestioneenti.model.ServizioEnte servizioEnte) {

		return _servizioEnteLocalService.updateServizioEnte(servizioEnte);
	}

	@Override
	public ServizioEnteLocalService getWrappedService() {
		return _servizioEnteLocalService;
	}

	@Override
	public void setWrappedService(
		ServizioEnteLocalService servizioEnteLocalService) {

		_servizioEnteLocalService = servizioEnteLocalService;
	}

	private ServizioEnteLocalService _servizioEnteLocalService;

}