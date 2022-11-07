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

package it.servizidigitali.gestionepagamenti.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PagamentoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PagamentoLocalService
 * @generated
 */
public class PagamentoLocalServiceWrapper
	implements PagamentoLocalService, ServiceWrapper<PagamentoLocalService> {

	public PagamentoLocalServiceWrapper() {
		this(null);
	}

	public PagamentoLocalServiceWrapper(
		PagamentoLocalService pagamentoLocalService) {

		_pagamentoLocalService = pagamentoLocalService;
	}

	/**
	 * Adds the pagamento to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PagamentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pagamento the pagamento
	 * @return the pagamento that was added
	 */
	@Override
	public it.servizidigitali.gestionepagamenti.model.Pagamento addPagamento(
		it.servizidigitali.gestionepagamenti.model.Pagamento pagamento) {

		return _pagamentoLocalService.addPagamento(pagamento);
	}

	@Override
	public long countByFilters(
		java.util.Date dataInserimentoDa, java.util.Date dataInserimentoA,
		java.util.Date dataOperazioneDa, java.util.Date dataOperazioneA,
		long groupId, long servizioId, String stato, String gateway,
		String canale, String codiceFiscale, String codiceIuv,
		long idPagamento) {

		return _pagamentoLocalService.countByFilters(
			dataInserimentoDa, dataInserimentoA, dataOperazioneDa,
			dataOperazioneA, groupId, servizioId, stato, gateway, canale,
			codiceFiscale, codiceIuv, idPagamento);
	}

	@Override
	public it.servizidigitali.gestionepagamenti.model.Pagamento create(
		long groupId, long userId, String userName, String idCredito,
		String idFiscaleCliente, String denominazioneCliente,
		String emailQuietanza, String causale, long servizioId,
		String nomeServizio, java.math.BigDecimal importo,
		java.math.BigDecimal commissioni, String canale, String gateway,
		String iud, String iuv, String idSessione, String pathAvviso,
		boolean emailInviata, String stato, long richiestaId) {

		return _pagamentoLocalService.create(
			groupId, userId, userName, idCredito, idFiscaleCliente,
			denominazioneCliente, emailQuietanza, causale, servizioId,
			nomeServizio, importo, commissioni, canale, gateway, iud, iuv,
			idSessione, pathAvviso, emailInviata, stato, richiestaId);
	}

	/**
	 * Creates a new pagamento with the primary key. Does not add the pagamento to the database.
	 *
	 * @param pagamentoId the primary key for the new pagamento
	 * @return the new pagamento
	 */
	@Override
	public it.servizidigitali.gestionepagamenti.model.Pagamento createPagamento(
		long pagamentoId) {

		return _pagamentoLocalService.createPagamento(pagamentoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pagamentoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the pagamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PagamentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pagamentoId the primary key of the pagamento
	 * @return the pagamento that was removed
	 * @throws PortalException if a pagamento with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestionepagamenti.model.Pagamento deletePagamento(
			long pagamentoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pagamentoLocalService.deletePagamento(pagamentoId);
	}

	/**
	 * Deletes the pagamento from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PagamentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pagamento the pagamento
	 * @return the pagamento that was removed
	 */
	@Override
	public it.servizidigitali.gestionepagamenti.model.Pagamento deletePagamento(
		it.servizidigitali.gestionepagamenti.model.Pagamento pagamento) {

		return _pagamentoLocalService.deletePagamento(pagamento);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pagamentoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _pagamentoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _pagamentoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pagamentoLocalService.dynamicQuery();
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

		return _pagamentoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionepagamenti.model.impl.PagamentoModelImpl</code>.
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

		return _pagamentoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionepagamenti.model.impl.PagamentoModelImpl</code>.
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

		return _pagamentoLocalService.dynamicQuery(
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

		return _pagamentoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _pagamentoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestionepagamenti.model.Pagamento fetchPagamento(
		long pagamentoId) {

		return _pagamentoLocalService.fetchPagamento(pagamentoId);
	}

	/**
	 * Returns the pagamento matching the UUID and group.
	 *
	 * @param uuid the pagamento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public it.servizidigitali.gestionepagamenti.model.Pagamento
		fetchPagamentoByUuidAndGroupId(String uuid, long groupId) {

		return _pagamentoLocalService.fetchPagamentoByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _pagamentoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _pagamentoLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _pagamentoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pagamentoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<it.servizidigitali.gestionepagamenti.model.Pagamento>
		getPagamentiByStato(String stato) {

		return _pagamentoLocalService.getPagamentiByStato(stato);
	}

	/**
	 * Returns the pagamento with the primary key.
	 *
	 * @param pagamentoId the primary key of the pagamento
	 * @return the pagamento
	 * @throws PortalException if a pagamento with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestionepagamenti.model.Pagamento getPagamento(
			long pagamentoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pagamentoLocalService.getPagamento(pagamentoId);
	}

	@Override
	public it.servizidigitali.gestionepagamenti.model.Pagamento
		getPagamentoByRichistaId(long richiestaId) {

		return _pagamentoLocalService.getPagamentoByRichistaId(richiestaId);
	}

	/**
	 * Returns the pagamento matching the UUID and group.
	 *
	 * @param uuid the pagamento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pagamento
	 * @throws PortalException if a matching pagamento could not be found
	 */
	@Override
	public it.servizidigitali.gestionepagamenti.model.Pagamento
			getPagamentoByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pagamentoLocalService.getPagamentoByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the pagamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionepagamenti.model.impl.PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @return the range of pagamentos
	 */
	@Override
	public java.util.List<it.servizidigitali.gestionepagamenti.model.Pagamento>
		getPagamentos(int start, int end) {

		return _pagamentoLocalService.getPagamentos(start, end);
	}

	/**
	 * Returns all the pagamentos matching the UUID and company.
	 *
	 * @param uuid the UUID of the pagamentos
	 * @param companyId the primary key of the company
	 * @return the matching pagamentos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestionepagamenti.model.Pagamento>
		getPagamentosByUuidAndCompanyId(String uuid, long companyId) {

		return _pagamentoLocalService.getPagamentosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of pagamentos matching the UUID and company.
	 *
	 * @param uuid the UUID of the pagamentos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching pagamentos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.servizidigitali.gestionepagamenti.model.Pagamento>
		getPagamentosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestionepagamenti.model.Pagamento>
					orderByComparator) {

		return _pagamentoLocalService.getPagamentosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of pagamentos.
	 *
	 * @return the number of pagamentos
	 */
	@Override
	public int getPagamentosCount() {
		return _pagamentoLocalService.getPagamentosCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pagamentoLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<it.servizidigitali.gestionepagamenti.model.Pagamento>
		search(
			java.util.Date dataInserimentoDa, java.util.Date dataInserimentoA,
			java.util.Date dataOperazioneDa, java.util.Date dataOperazioneA,
			long groupId, long servizioId, String stato, String gateway,
			String canale, String codiceFiscale, String codiceIuv,
			long idPagamento, int inizio, int fine, String orderByCol,
			String orderByType) {

		return _pagamentoLocalService.search(
			dataInserimentoDa, dataInserimentoA, dataOperazioneDa,
			dataOperazioneA, groupId, servizioId, stato, gateway, canale,
			codiceFiscale, codiceIuv, idPagamento, inizio, fine, orderByCol,
			orderByType);
	}

	/**
	 * Updates the pagamento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PagamentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pagamento the pagamento
	 * @return the pagamento that was updated
	 */
	@Override
	public it.servizidigitali.gestionepagamenti.model.Pagamento updatePagamento(
		it.servizidigitali.gestionepagamenti.model.Pagamento pagamento) {

		return _pagamentoLocalService.updatePagamento(pagamento);
	}

	@Override
	public PagamentoLocalService getWrappedService() {
		return _pagamentoLocalService;
	}

	@Override
	public void setWrappedService(PagamentoLocalService pagamentoLocalService) {
		_pagamentoLocalService = pagamentoLocalService;
	}

	private PagamentoLocalService _pagamentoLocalService;

}