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

package it.servizidigitali.gestioneprocedure.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProceduraLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProceduraLocalService
 * @generated
 */
public class ProceduraLocalServiceWrapper
	implements ProceduraLocalService, ServiceWrapper<ProceduraLocalService> {

	public ProceduraLocalServiceWrapper() {
		this(null);
	}

	public ProceduraLocalServiceWrapper(
		ProceduraLocalService proceduraLocalService) {

		_proceduraLocalService = proceduraLocalService;
	}

	/**
	 * Adds the procedura to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduraLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedura the procedura
	 * @return the procedura that was added
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.Procedura addProcedura(
		it.servizidigitali.gestioneprocedure.model.Procedura procedura) {

		return _proceduraLocalService.addProcedura(procedura);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new procedura with the primary key. Does not add the procedura to the database.
	 *
	 * @param proceduraId the primary key for the new procedura
	 * @return the new procedura
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.Procedura createProcedura(
		long proceduraId) {

		return _proceduraLocalService.createProcedura(proceduraId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the procedura with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduraLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proceduraId the primary key of the procedura
	 * @return the procedura that was removed
	 * @throws PortalException if a procedura with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.Procedura deleteProcedura(
			long proceduraId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraLocalService.deleteProcedura(proceduraId);
	}

	/**
	 * Deletes the procedura from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduraLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedura the procedura
	 * @return the procedura that was removed
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.Procedura deleteProcedura(
		it.servizidigitali.gestioneprocedure.model.Procedura procedura) {

		return _proceduraLocalService.deleteProcedura(procedura);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _proceduraLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _proceduraLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _proceduraLocalService.dynamicQuery();
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

		return _proceduraLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.ProceduraModelImpl</code>.
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

		return _proceduraLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.ProceduraModelImpl</code>.
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

		return _proceduraLocalService.dynamicQuery(
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

		return _proceduraLocalService.dynamicQueryCount(dynamicQuery);
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

		return _proceduraLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestioneprocedure.model.Procedura fetchProcedura(
		long proceduraId) {

		return _proceduraLocalService.fetchProcedura(proceduraId);
	}

	/**
	 * Returns the procedura matching the UUID and group.
	 *
	 * @param uuid the procedura's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.Procedura
		fetchProceduraByUuidAndGroupId(String uuid, long groupId) {

		return _proceduraLocalService.fetchProceduraByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _proceduraLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _proceduraLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _proceduraLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _proceduraLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the procedura with the primary key.
	 *
	 * @param proceduraId the primary key of the procedura
	 * @return the procedura
	 * @throws PortalException if a procedura with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.Procedura getProcedura(
			long proceduraId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraLocalService.getProcedura(proceduraId);
	}

	/**
	 * Returns the procedura matching the UUID and group.
	 *
	 * @param uuid the procedura's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedura
	 * @throws PortalException if a matching procedura could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.Procedura
			getProceduraByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraLocalService.getProceduraByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the proceduras.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of proceduras
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneprocedure.model.Procedura>
		getProceduras(int start, int end) {

		return _proceduraLocalService.getProceduras(start, end);
	}

	/**
	 * Returns all the proceduras matching the UUID and company.
	 *
	 * @param uuid the UUID of the proceduras
	 * @param companyId the primary key of the company
	 * @return the matching proceduras, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneprocedure.model.Procedura>
		getProcedurasByUuidAndCompanyId(String uuid, long companyId) {

		return _proceduraLocalService.getProcedurasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of proceduras matching the UUID and company.
	 *
	 * @param uuid the UUID of the proceduras
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching proceduras, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneprocedure.model.Procedura>
		getProcedurasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestioneprocedure.model.Procedura>
					orderByComparator) {

		return _proceduraLocalService.getProcedurasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of proceduras.
	 *
	 * @return the number of proceduras
	 */
	@Override
	public int getProcedurasCount() {
		return _proceduraLocalService.getProcedurasCount();
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneprocedure.model.Procedura>
		getProcedureByGroupIdAttiva(long groupId, boolean attiva) {

		return _proceduraLocalService.getProcedureByGroupIdAttiva(
			groupId, attiva);
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneprocedure.model.Procedura>
		getProcedureByGroupIdServizioIdAttiva(
			long groupId, long servizioId, boolean attiva) {

		return _proceduraLocalService.getProcedureByGroupIdServizioIdAttiva(
			groupId, servizioId, attiva);
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneprocedure.model.Procedura>
		getProcedureByServiziIdsGroupIdAttiva(
			java.util.List<Long> serviziIds, long groupId, Boolean attiva) {

		return _proceduraLocalService.getProcedureByServiziIdsGroupIdAttiva(
			serviziIds, groupId, attiva);
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneprocedure.model.Procedura>
		search(
			String nome, String attiva, java.util.Date dataInserimentoDa,
			java.util.Date dataInserimentoA, long groupId, int delta, int cur,
			String orderByCol, String orderByType) {

		return _proceduraLocalService.search(
			nome, attiva, dataInserimentoDa, dataInserimentoA, groupId, delta,
			cur, orderByCol, orderByType);
	}

	/**
	 * Updates the procedura in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduraLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedura the procedura
	 * @return the procedura that was updated
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.Procedura updateProcedura(
		it.servizidigitali.gestioneprocedure.model.Procedura procedura) {

		return _proceduraLocalService.updateProcedura(procedura);
	}

	@Override
	public ProceduraLocalService getWrappedService() {
		return _proceduraLocalService;
	}

	@Override
	public void setWrappedService(ProceduraLocalService proceduraLocalService) {
		_proceduraLocalService = proceduraLocalService;
	}

	private ProceduraLocalService _proceduraLocalService;

}