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
 * Provides a wrapper for {@link ServizioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioLocalService
 * @generated
 */
public class ServizioLocalServiceWrapper
	implements ServiceWrapper<ServizioLocalService>, ServizioLocalService {

	public ServizioLocalServiceWrapper() {
		this(null);
	}

	public ServizioLocalServiceWrapper(
		ServizioLocalService servizioLocalService) {

		_servizioLocalService = servizioLocalService;
	}

	/**
	 * Adds the servizio to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizio the servizio
	 * @return the servizio that was added
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Servizio addServizio(
		it.servizidigitali.gestioneservizi.model.Servizio servizio) {

		return _servizioLocalService.addServizio(servizio);
	}

	@Override
	public void addTipologiaServizio(long tipologiaId, long servizioId) {
		_servizioLocalService.addTipologiaServizio(tipologiaId, servizioId);
	}

	@Override
	public void addTipologiaServizio(
		long tipologiaId,
		it.servizidigitali.gestioneservizi.model.Servizio servizio) {

		_servizioLocalService.addTipologiaServizio(tipologiaId, servizio);
	}

	@Override
	public void addTipologiaServizios(
		long tipologiaId,
		java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
			servizios) {

		_servizioLocalService.addTipologiaServizios(tipologiaId, servizios);
	}

	@Override
	public void addTipologiaServizios(long tipologiaId, long[] servizioIds) {
		_servizioLocalService.addTipologiaServizios(tipologiaId, servizioIds);
	}

	@Override
	public it.servizidigitali.gestioneservizi.model.Servizio aggiornaServizio(
			it.servizidigitali.gestioneservizi.model.Servizio
				servizioDaAggiornare)
		throws Exception {

		return _servizioLocalService.aggiornaServizio(servizioDaAggiornare);
	}

	@Override
	public void clearTipologiaServizios(long tipologiaId) {
		_servizioLocalService.clearTipologiaServizios(tipologiaId);
	}

	@Override
	public int count(String nome, String codice, Boolean soloServiziAttivi) {
		return _servizioLocalService.count(nome, codice, soloServiziAttivi);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servizioLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new servizio with the primary key. Does not add the servizio to the database.
	 *
	 * @param servizioId the primary key for the new servizio
	 * @return the new servizio
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Servizio createServizio(
		long servizioId) {

		return _servizioLocalService.createServizio(servizioId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servizioLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the servizio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio that was removed
	 * @throws PortalException if a servizio with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Servizio deleteServizio(
			long servizioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servizioLocalService.deleteServizio(servizioId);
	}

	/**
	 * Deletes the servizio from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizio the servizio
	 * @return the servizio that was removed
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Servizio deleteServizio(
		it.servizidigitali.gestioneservizi.model.Servizio servizio) {

		return _servizioLocalService.deleteServizio(servizio);
	}

	@Override
	public void deleteTipologiaServizio(long tipologiaId, long servizioId) {
		_servizioLocalService.deleteTipologiaServizio(tipologiaId, servizioId);
	}

	@Override
	public void deleteTipologiaServizio(
		long tipologiaId,
		it.servizidigitali.gestioneservizi.model.Servizio servizio) {

		_servizioLocalService.deleteTipologiaServizio(tipologiaId, servizio);
	}

	@Override
	public void deleteTipologiaServizios(
		long tipologiaId,
		java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
			servizios) {

		_servizioLocalService.deleteTipologiaServizios(tipologiaId, servizios);
	}

	@Override
	public void deleteTipologiaServizios(long tipologiaId, long[] servizioIds) {
		_servizioLocalService.deleteTipologiaServizios(
			tipologiaId, servizioIds);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _servizioLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _servizioLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _servizioLocalService.dynamicQuery();
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

		return _servizioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.ServizioModelImpl</code>.
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

		return _servizioLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.ServizioModelImpl</code>.
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

		return _servizioLocalService.dynamicQuery(
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

		return _servizioLocalService.dynamicQueryCount(dynamicQuery);
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

		return _servizioLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestioneservizi.model.Servizio fetchServizio(
		long servizioId) {

		return _servizioLocalService.fetchServizio(servizioId);
	}

	/**
	 * Returns the servizio matching the UUID and group.
	 *
	 * @param uuid the servizio's UUID
	 * @param groupId the primary key of the group
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Servizio
		fetchServizioByUuidAndGroupId(String uuid, long groupId) {

		return _servizioLocalService.fetchServizioByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _servizioLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _servizioLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _servizioLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _servizioLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servizioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the servizio with the primary key.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio
	 * @throws PortalException if a servizio with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Servizio getServizio(
			long servizioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servizioLocalService.getServizio(servizioId);
	}

	@Override
	public it.servizidigitali.gestioneservizi.model.Servizio
		getServizioByCodice(String codice) {

		return _servizioLocalService.getServizioByCodice(codice);
	}

	@Override
	public it.servizidigitali.gestioneservizi.model.Servizio getServizioById(
			Long servizioId)
		throws Exception {

		return _servizioLocalService.getServizioById(servizioId);
	}

	/**
	 * Returns the servizio matching the UUID and group.
	 *
	 * @param uuid the servizio's UUID
	 * @param groupId the primary key of the group
	 * @return the matching servizio
	 * @throws PortalException if a matching servizio could not be found
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Servizio
			getServizioByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servizioLocalService.getServizioByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of servizios
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
		getServizios(int start, int end) {

		return _servizioLocalService.getServizios(start, end);
	}

	/**
	 * Returns all the servizios matching the UUID and company.
	 *
	 * @param uuid the UUID of the servizios
	 * @param companyId the primary key of the company
	 * @return the matching servizios, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
		getServiziosByUuidAndCompanyId(String uuid, long companyId) {

		return _servizioLocalService.getServiziosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of servizios matching the UUID and company.
	 *
	 * @param uuid the UUID of the servizios
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching servizios, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
		getServiziosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestioneservizi.model.Servizio>
					orderByComparator) {

		return _servizioLocalService.getServiziosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of servizios.
	 *
	 * @return the number of servizios
	 */
	@Override
	public int getServiziosCount() {
		return _servizioLocalService.getServiziosCount();
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
		getServiziUtilizzabili(
			java.util.List<Object> listaServiziEnte, String nome,
			long areaTematicaId, long tipologiaId, int cur, int delta,
			String orderByCol, String orderByType) {

		return _servizioLocalService.getServiziUtilizzabili(
			listaServiziEnte, nome, areaTematicaId, tipologiaId, cur, delta,
			orderByCol, orderByType);
	}

	/**
	 * Returns the tipologiaIds of the tipologias associated with the servizio.
	 *
	 * @param servizioId the servizioId of the servizio
	 * @return long[] the tipologiaIds of tipologias associated with the servizio
	 */
	@Override
	public long[] getTipologiaPrimaryKeys(long servizioId) {
		return _servizioLocalService.getTipologiaPrimaryKeys(servizioId);
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
		getTipologiaServizios(long tipologiaId) {

		return _servizioLocalService.getTipologiaServizios(tipologiaId);
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
		getTipologiaServizios(long tipologiaId, int start, int end) {

		return _servizioLocalService.getTipologiaServizios(
			tipologiaId, start, end);
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
		getTipologiaServizios(
			long tipologiaId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestioneservizi.model.Servizio>
					orderByComparator) {

		return _servizioLocalService.getTipologiaServizios(
			tipologiaId, start, end, orderByComparator);
	}

	@Override
	public int getTipologiaServiziosCount(long tipologiaId) {
		return _servizioLocalService.getTipologiaServiziosCount(tipologiaId);
	}

	@Override
	public boolean hasTipologiaServizio(long tipologiaId, long servizioId) {
		return _servizioLocalService.hasTipologiaServizio(
			tipologiaId, servizioId);
	}

	@Override
	public boolean hasTipologiaServizios(long tipologiaId) {
		return _servizioLocalService.hasTipologiaServizios(tipologiaId);
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
			listaServiziAttivi(Boolean attivo, Integer start, Integer end)
		throws Exception {

		return _servizioLocalService.listaServiziAttivi(attivo, start, end);
	}

	/**
	 * @param nome
	 * @param codice
	 * @param soloServiziAttivi
	 * @param cur: pagina attuale
	 * @param delta: numero elementi per pagina
	 * @param nomeOrdinamento
	 * @param direzioneOrdinamento
	 * @return
	 */
	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
			searchServizio(
				String nome, String codice, Boolean soloServiziAttivi,
				int inizio, int fine,
				com.liferay.portal.kernel.util.OrderByComparator
					<it.servizidigitali.gestioneservizi.model.Servizio> ordine)
		throws Exception {

		return _servizioLocalService.searchServizio(
			nome, codice, soloServiziAttivi, inizio, fine, ordine);
	}

	@Override
	public void setTipologiaServizios(long tipologiaId, long[] servizioIds) {
		_servizioLocalService.setTipologiaServizios(tipologiaId, servizioIds);
	}

	/**
	 * Updates the servizio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizio the servizio
	 * @return the servizio that was updated
	 */
	@Override
	public it.servizidigitali.gestioneservizi.model.Servizio updateServizio(
		it.servizidigitali.gestioneservizi.model.Servizio servizio) {

		return _servizioLocalService.updateServizio(servizio);
	}

	@Override
	public ServizioLocalService getWrappedService() {
		return _servizioLocalService;
	}

	@Override
	public void setWrappedService(ServizioLocalService servizioLocalService) {
		_servizioLocalService = servizioLocalService;
	}

	private ServizioLocalService _servizioLocalService;

}