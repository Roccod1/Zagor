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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestionepagamenti.model.Pagamento;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Pagamento. This utility wraps
 * <code>it.servizidigitali.gestionepagamenti.service.impl.PagamentoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PagamentoLocalService
 * @generated
 */
public class PagamentoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestionepagamenti.service.impl.PagamentoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Pagamento addPagamento(Pagamento pagamento) {
		return getService().addPagamento(pagamento);
	}

	public static long countByFilters(
		java.util.Date dataInserimentoDa, java.util.Date dataInserimentoA,
		java.util.Date dataOperazioneDa, java.util.Date dataOperazioneA,
		String organizzazione, String categoria, String stato, String gateway,
		String canale, String codiceFiscale, String identificativoPagamento,
		String codiceIuv, long idPagamento) {

		return getService().countByFilters(
			dataInserimentoDa, dataInserimentoA, dataOperazioneDa,
			dataOperazioneA, organizzazione, categoria, stato, gateway, canale,
			codiceFiscale, identificativoPagamento, codiceIuv, idPagamento);
	}

	/**
	 * Creates a new pagamento with the primary key. Does not add the pagamento to the database.
	 *
	 * @param pagamentoId the primary key for the new pagamento
	 * @return the new pagamento
	 */
	public static Pagamento createPagamento(long pagamentoId) {
		return getService().createPagamento(pagamentoId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static Pagamento deletePagamento(long pagamentoId)
		throws PortalException {

		return getService().deletePagamento(pagamentoId);
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
	public static Pagamento deletePagamento(Pagamento pagamento) {
		return getService().deletePagamento(pagamento);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Pagamento fetchPagamento(long pagamentoId) {
		return getService().fetchPagamento(pagamentoId);
	}

	/**
	 * Returns the pagamento matching the UUID and group.
	 *
	 * @param uuid the pagamento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchPagamentoByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPagamentoByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Returns the pagamento with the primary key.
	 *
	 * @param pagamentoId the primary key of the pagamento
	 * @return the pagamento
	 * @throws PortalException if a pagamento with the primary key could not be found
	 */
	public static Pagamento getPagamento(long pagamentoId)
		throws PortalException {

		return getService().getPagamento(pagamentoId);
	}

	/**
	 * Returns the pagamento matching the UUID and group.
	 *
	 * @param uuid the pagamento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pagamento
	 * @throws PortalException if a matching pagamento could not be found
	 */
	public static Pagamento getPagamentoByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPagamentoByUuidAndGroupId(uuid, groupId);
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
	public static List<Pagamento> getPagamentos(int start, int end) {
		return getService().getPagamentos(start, end);
	}

	/**
	 * Returns all the pagamentos matching the UUID and company.
	 *
	 * @param uuid the UUID of the pagamentos
	 * @param companyId the primary key of the company
	 * @return the matching pagamentos, or an empty list if no matches were found
	 */
	public static List<Pagamento> getPagamentosByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPagamentosByUuidAndCompanyId(uuid, companyId);
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
	public static List<Pagamento> getPagamentosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return getService().getPagamentosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of pagamentos.
	 *
	 * @return the number of pagamentos
	 */
	public static int getPagamentosCount() {
		return getService().getPagamentosCount();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static List<Pagamento> search(
		java.util.Date dataInserimentoDa, java.util.Date dataInserimentoA,
		java.util.Date dataOperazioneDa, java.util.Date dataOperazioneA,
		String organizzazione, String categoria, String stato, String gateway,
		String canale, String codiceFiscale, String identificativoPagamento,
		String codiceIuv, long idPagamento, int inizio, int fine,
		OrderByComparator<Pagamento> comparator) {

		return getService().search(
			dataInserimentoDa, dataInserimentoA, dataOperazioneDa,
			dataOperazioneA, organizzazione, categoria, stato, gateway, canale,
			codiceFiscale, identificativoPagamento, codiceIuv, idPagamento,
			inizio, fine, comparator);
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
	public static Pagamento updatePagamento(Pagamento pagamento) {
		return getService().updatePagamento(pagamento);
	}

	public static PagamentoLocalService getService() {
		return _service;
	}

	private static volatile PagamentoLocalService _service;

}