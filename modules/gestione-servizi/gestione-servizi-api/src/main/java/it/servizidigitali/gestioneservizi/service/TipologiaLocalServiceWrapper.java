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

package it.servizidigitali.gestioneservizi.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TipologiaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaLocalService
 * @generated
 */
public class TipologiaLocalServiceWrapper
	implements ServiceWrapper<TipologiaLocalService>, TipologiaLocalService {

	public TipologiaLocalServiceWrapper() {
		this(null);
	}

	public TipologiaLocalServiceWrapper(
		TipologiaLocalService tipologiaLocalService) {

		_tipologiaLocalService = tipologiaLocalService;
	}

	@Override
	public void addServizioTipologia(long servizioId, long tipologiaId) {
		_tipologiaLocalService.addServizioTipologia(servizioId, tipologiaId);
	}

	@Override
	public void addServizioTipologia(
		long servizioId,
		it.servizidigitali.gestioneservizi.model.Tipologia tipologia) {

		_tipologiaLocalService.addServizioTipologia(servizioId, tipologia);
	}

	@Override
	public void addServizioTipologias(
		long servizioId,
		java.util.List<it.servizidigitali.gestioneservizi.model.Tipologia>
			tipologias) {

		_tipologiaLocalService.addServizioTipologias(servizioId, tipologias);
	}

	@Override
	public void addServizioTipologias(long servizioId, long[] tipologiaIds) {
		_tipologiaLocalService.addServizioTipologias(servizioId, tipologiaIds);
	}

	/**
	 * Adds the tipologia to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologia the tipologia
	 * @return the tipologia that was added
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Tipologia addTipologia(
		it.servizidigitali.gestioneservizi.model.Tipologia tipologia) {

		return _tipologiaLocalService.addTipologia(tipologia);
	}

	@Override
	public void clearServizioTipologias(long servizioId) {
		_tipologiaLocalService.clearServizioTipologias(servizioId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipologiaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new tipologia with the primary key. Does not add the tipologia to the database.
	 *
	 * @param tipologiaId the primary key for the new tipologia
	 * @return the new tipologia
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Tipologia createTipologia(
		long tipologiaId) {

		return _tipologiaLocalService.createTipologia(tipologiaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipologiaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteServizioTipologia(long servizioId, long tipologiaId) {
		_tipologiaLocalService.deleteServizioTipologia(servizioId, tipologiaId);
	}

	@Override
	public void deleteServizioTipologia(
		long servizioId,
		it.servizidigitali.gestioneservizi.model.Tipologia tipologia) {

		_tipologiaLocalService.deleteServizioTipologia(servizioId, tipologia);
	}

	@Override
	public void deleteServizioTipologias(
		long servizioId,
		java.util.List<it.servizidigitali.gestioneservizi.model.Tipologia>
			tipologias) {

		_tipologiaLocalService.deleteServizioTipologias(servizioId, tipologias);
	}

	@Override
	public void deleteServizioTipologias(long servizioId, long[] tipologiaIds) {
		_tipologiaLocalService.deleteServizioTipologias(
			servizioId, tipologiaIds);
	}

	/**
	 * Deletes the tipologia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia that was removed
	 * @throws PortalException if a tipologia with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Tipologia deleteTipologia(
			long tipologiaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipologiaLocalService.deleteTipologia(tipologiaId);
	}

	/**
	 * Deletes the tipologia from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologia the tipologia
	 * @return the tipologia that was removed
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Tipologia deleteTipologia(
		it.servizidigitali.gestioneservizi.model.Tipologia tipologia) {

		return _tipologiaLocalService.deleteTipologia(tipologia);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _tipologiaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _tipologiaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipologiaLocalService.dynamicQuery();
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

		return _tipologiaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.TipologiaModelImpl</code>.
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

		return _tipologiaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.TipologiaModelImpl</code>.
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

		return _tipologiaLocalService.dynamicQuery(
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

		return _tipologiaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _tipologiaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestioneservizi.model.Tipologia fetchTipologia(
		long tipologiaId) {

		return _tipologiaLocalService.fetchTipologia(tipologiaId);
	}

	/**
	 * Returns the tipologia matching the UUID and group.
	 *
	 * @param uuid the tipologia's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Tipologia
		fetchTipologiaByUuidAndGroupId(String uuid, long groupId) {

		return _tipologiaLocalService.fetchTipologiaByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tipologiaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _tipologiaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tipologiaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tipologiaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipologiaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the servizioIds of the servizios associated with the tipologia.
	 *
	 * @param tipologiaId the tipologiaId of the tipologia
	 * @return long[] the servizioIds of servizios associated with the tipologia
	 */
	@Override
	public long[] getServizioPrimaryKeys(long tipologiaId) {
		return _tipologiaLocalService.getServizioPrimaryKeys(tipologiaId);
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Tipologia>
		getServizioTipologias(long servizioId) {

		return _tipologiaLocalService.getServizioTipologias(servizioId);
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Tipologia>
		getServizioTipologias(long servizioId, int start, int end) {

		return _tipologiaLocalService.getServizioTipologias(
			servizioId, start, end);
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Tipologia>
		getServizioTipologias(
			long servizioId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestioneservizi.model.Tipologia>
					orderByComparator) {

		return _tipologiaLocalService.getServizioTipologias(
			servizioId, start, end, orderByComparator);
	}

	@Override
	public int getServizioTipologiasCount(long servizioId) {
		return _tipologiaLocalService.getServizioTipologiasCount(servizioId);
	}

	/**
	 * Returns the tipologia with the primary key.
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia
	 * @throws PortalException if a tipologia with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Tipologia getTipologia(
			long tipologiaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipologiaLocalService.getTipologia(tipologiaId);
	}

	@Override
	public it.servizidigitali.gestioneservizi.model.Tipologia getTipologiaById(
		Long idTipologia) {

		return _tipologiaLocalService.getTipologiaById(idTipologia);
	}

	/**
	 * Returns the tipologia matching the UUID and group.
	 *
	 * @param uuid the tipologia's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipologia
	 * @throws PortalException if a matching tipologia could not be found
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Tipologia
			getTipologiaByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipologiaLocalService.getTipologiaByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the tipologias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of tipologias
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Tipologia>
		getTipologias(int start, int end) {

		return _tipologiaLocalService.getTipologias(start, end);
	}

	/**
	 * Returns all the tipologias matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipologias
	 * @param companyId the primary key of the company
	 * @return the matching tipologias, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Tipologia>
		getTipologiasByUuidAndCompanyId(String uuid, long companyId) {

		return _tipologiaLocalService.getTipologiasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of tipologias matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipologias
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching tipologias, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Tipologia>
		getTipologiasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestioneservizi.model.Tipologia>
					orderByComparator) {

		return _tipologiaLocalService.getTipologiasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of tipologias.
	 *
	 * @return the number of tipologias
	 */
	@Override
	public int getTipologiasCount() {
		return _tipologiaLocalService.getTipologiasCount();
	}

	@Override
	public boolean hasServizioTipologia(long servizioId, long tipologiaId) {
		return _tipologiaLocalService.hasServizioTipologia(
			servizioId, tipologiaId);
	}

	@Override
	public boolean hasServizioTipologias(long servizioId) {
		return _tipologiaLocalService.hasServizioTipologias(servizioId);
	}

	@Override
	public void setServizioTipologias(long servizioId, long[] tipologiaIds) {
		_tipologiaLocalService.setServizioTipologias(servizioId, tipologiaIds);
	}

	/**
	 * Updates the tipologia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologia the tipologia
	 * @return the tipologia that was updated
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Tipologia updateTipologia(
		it.servizidigitali.gestioneservizi.model.Tipologia tipologia) {

		return _tipologiaLocalService.updateTipologia(tipologia);
	}

	@Override
	public TipologiaLocalService getWrappedService() {
		return _tipologiaLocalService;
	}

	@Override
	public void setWrappedService(TipologiaLocalService tipologiaLocalService) {
		_tipologiaLocalService = tipologiaLocalService;
	}

	private TipologiaLocalService _tipologiaLocalService;

}