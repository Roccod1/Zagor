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

package it.servizidigitali.gestioneforms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TipoDocumentoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipoDocumentoLocalService
 * @generated
 */
public class TipoDocumentoLocalServiceWrapper
	implements ServiceWrapper<TipoDocumentoLocalService>,
			   TipoDocumentoLocalService {

	public TipoDocumentoLocalServiceWrapper() {
		this(null);
	}

	public TipoDocumentoLocalServiceWrapper(
		TipoDocumentoLocalService tipoDocumentoLocalService) {

		_tipoDocumentoLocalService = tipoDocumentoLocalService;
	}

	/**
	 * Adds the tipo documento to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipoDocumentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipoDocumento the tipo documento
	 * @return the tipo documento that was added
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.TipoDocumento
		addTipoDocumento(
			it.servizidigitali.gestioneforms.model.TipoDocumento
				tipoDocumento) {

		return _tipoDocumentoLocalService.addTipoDocumento(tipoDocumento);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipoDocumentoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new tipo documento with the primary key. Does not add the tipo documento to the database.
	 *
	 * @param tipoDocumentoId the primary key for the new tipo documento
	 * @return the new tipo documento
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.TipoDocumento
		createTipoDocumento(long tipoDocumentoId) {

		return _tipoDocumentoLocalService.createTipoDocumento(tipoDocumentoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipoDocumentoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the tipo documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipoDocumentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento that was removed
	 * @throws PortalException if a tipo documento with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.TipoDocumento
			deleteTipoDocumento(long tipoDocumentoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipoDocumentoLocalService.deleteTipoDocumento(tipoDocumentoId);
	}

	/**
	 * Deletes the tipo documento from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipoDocumentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipoDocumento the tipo documento
	 * @return the tipo documento that was removed
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.TipoDocumento
		deleteTipoDocumento(
			it.servizidigitali.gestioneforms.model.TipoDocumento
				tipoDocumento) {

		return _tipoDocumentoLocalService.deleteTipoDocumento(tipoDocumento);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _tipoDocumentoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _tipoDocumentoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipoDocumentoLocalService.dynamicQuery();
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

		return _tipoDocumentoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.TipoDocumentoModelImpl</code>.
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

		return _tipoDocumentoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.TipoDocumentoModelImpl</code>.
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

		return _tipoDocumentoLocalService.dynamicQuery(
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

		return _tipoDocumentoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _tipoDocumentoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestioneforms.model.TipoDocumento
		fetchTipoDocumento(long tipoDocumentoId) {

		return _tipoDocumentoLocalService.fetchTipoDocumento(tipoDocumentoId);
	}

	/**
	 * Returns the tipo documento matching the UUID and group.
	 *
	 * @param uuid the tipo documento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.TipoDocumento
		fetchTipoDocumentoByUuidAndGroupId(String uuid, long groupId) {

		return _tipoDocumentoLocalService.fetchTipoDocumentoByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tipoDocumentoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _tipoDocumentoLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tipoDocumentoLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneforms.model.TipoDocumento>
		getListaTipoDocumentiByStato(String stato) {

		return _tipoDocumentoLocalService.getListaTipoDocumentiByStato(stato);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tipoDocumentoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipoDocumentoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the tipo documento with the primary key.
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento
	 * @throws PortalException if a tipo documento with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.TipoDocumento
			getTipoDocumento(long tipoDocumentoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipoDocumentoLocalService.getTipoDocumento(tipoDocumentoId);
	}

	/**
	 * Returns the tipo documento matching the UUID and group.
	 *
	 * @param uuid the tipo documento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipo documento
	 * @throws PortalException if a matching tipo documento could not be found
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.TipoDocumento
			getTipoDocumentoByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipoDocumentoLocalService.getTipoDocumentoByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the tipo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of tipo documentos
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneforms.model.TipoDocumento>
		getTipoDocumentos(int start, int end) {

		return _tipoDocumentoLocalService.getTipoDocumentos(start, end);
	}

	/**
	 * Returns all the tipo documentos matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipo documentos
	 * @param companyId the primary key of the company
	 * @return the matching tipo documentos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneforms.model.TipoDocumento>
		getTipoDocumentosByUuidAndCompanyId(String uuid, long companyId) {

		return _tipoDocumentoLocalService.getTipoDocumentosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of tipo documentos matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipo documentos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching tipo documentos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneforms.model.TipoDocumento>
		getTipoDocumentosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestioneforms.model.TipoDocumento>
					orderByComparator) {

		return _tipoDocumentoLocalService.getTipoDocumentosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of tipo documentos.
	 *
	 * @return the number of tipo documentos
	 */
	@Override
	public int getTipoDocumentosCount() {
		return _tipoDocumentoLocalService.getTipoDocumentosCount();
	}

	/**
	 * Updates the tipo documento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipoDocumentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipoDocumento the tipo documento
	 * @return the tipo documento that was updated
	 */
	@Override
	public it.servizidigitali.gestioneforms.model.TipoDocumento
		updateTipoDocumento(
			it.servizidigitali.gestioneforms.model.TipoDocumento
				tipoDocumento) {

		return _tipoDocumentoLocalService.updateTipoDocumento(tipoDocumento);
	}

	@Override
	public TipoDocumentoLocalService getWrappedService() {
		return _tipoDocumentoLocalService;
	}

	@Override
	public void setWrappedService(
		TipoDocumentoLocalService tipoDocumentoLocalService) {

		_tipoDocumentoLocalService = tipoDocumentoLocalService;
	}

	private TipoDocumentoLocalService _tipoDocumentoLocalService;

}