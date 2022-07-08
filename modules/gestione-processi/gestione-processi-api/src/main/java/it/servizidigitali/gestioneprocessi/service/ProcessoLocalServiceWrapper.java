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

package it.servizidigitali.gestioneprocessi.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProcessoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProcessoLocalService
 * @generated
 */
public class ProcessoLocalServiceWrapper
	implements ProcessoLocalService, ServiceWrapper<ProcessoLocalService> {

	public ProcessoLocalServiceWrapper() {
		this(null);
	}

	public ProcessoLocalServiceWrapper(
		ProcessoLocalService processoLocalService) {

		_processoLocalService = processoLocalService;
	}

	/**
	 * Adds the processo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcessoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param processo the processo
	 * @return the processo that was added
	 */
	@Override
	public it.servizidigitali.gestioneprocessi.model.Processo addProcesso(
		it.servizidigitali.gestioneprocessi.model.Processo processo) {

		return _processoLocalService.addProcesso(processo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _processoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new processo with the primary key. Does not add the processo to the database.
	 *
	 * @param processoId the primary key for the new processo
	 * @return the new processo
	 */
	@Override
	public it.servizidigitali.gestioneprocessi.model.Processo createProcesso(
		long processoId) {

		return _processoLocalService.createProcesso(processoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _processoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the processo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcessoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo that was removed
	 * @throws PortalException if a processo with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocessi.model.Processo deleteProcesso(
			long processoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _processoLocalService.deleteProcesso(processoId);
	}

	/**
	 * Deletes the processo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcessoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param processo the processo
	 * @return the processo that was removed
	 */
	@Override
	public it.servizidigitali.gestioneprocessi.model.Processo deleteProcesso(
		it.servizidigitali.gestioneprocessi.model.Processo processo) {

		return _processoLocalService.deleteProcesso(processo);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _processoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _processoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _processoLocalService.dynamicQuery();
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

		return _processoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocessi.model.impl.ProcessoModelImpl</code>.
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

		return _processoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocessi.model.impl.ProcessoModelImpl</code>.
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

		return _processoLocalService.dynamicQuery(
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

		return _processoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _processoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestioneprocessi.model.Processo fetchProcesso(
		long processoId) {

		return _processoLocalService.fetchProcesso(processoId);
	}

	/**
	 * Returns the processo matching the UUID and group.
	 *
	 * @param uuid the processo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocessi.model.Processo
		fetchProcessoByUuidAndGroupId(String uuid, long groupId) {

		return _processoLocalService.fetchProcessoByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _processoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _processoLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _processoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _processoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _processoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the processo with the primary key.
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo
	 * @throws PortalException if a processo with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocessi.model.Processo getProcesso(
			long processoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _processoLocalService.getProcesso(processoId);
	}

	/**
	 * Returns the processo matching the UUID and group.
	 *
	 * @param uuid the processo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching processo
	 * @throws PortalException if a matching processo could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocessi.model.Processo
			getProcessoByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _processoLocalService.getProcessoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the processos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocessi.model.impl.ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of processos
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneprocessi.model.Processo>
		getProcessos(int start, int end) {

		return _processoLocalService.getProcessos(start, end);
	}

	/**
	 * Returns all the processos matching the UUID and company.
	 *
	 * @param uuid the UUID of the processos
	 * @param companyId the primary key of the company
	 * @return the matching processos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneprocessi.model.Processo>
		getProcessosByUuidAndCompanyId(String uuid, long companyId) {

		return _processoLocalService.getProcessosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of processos matching the UUID and company.
	 *
	 * @param uuid the UUID of the processos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching processos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneprocessi.model.Processo>
		getProcessosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestioneprocessi.model.Processo>
					orderByComparator) {

		return _processoLocalService.getProcessosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of processos.
	 *
	 * @return the number of processos
	 */
	@Override
	public int getProcessosCount() {
		return _processoLocalService.getProcessosCount();
	}

	/**
	 * Updates the processo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcessoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param processo the processo
	 * @return the processo that was updated
	 */
	@Override
	public it.servizidigitali.gestioneprocessi.model.Processo updateProcesso(
		it.servizidigitali.gestioneprocessi.model.Processo processo) {

		return _processoLocalService.updateProcesso(processo);
	}

	@Override
	public ProcessoLocalService getWrappedService() {
		return _processoLocalService;
	}

	@Override
	public void setWrappedService(ProcessoLocalService processoLocalService) {
		_processoLocalService = processoLocalService;
	}

	private ProcessoLocalService _processoLocalService;

}