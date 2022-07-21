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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneservizi.model.Servizio;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Servizio. This utility wraps
 * <code>it.servizidigitali.gestioneservizi.service.impl.ServizioLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioLocalService
 * @generated
 */
public class ServizioLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestioneservizi.service.impl.ServizioLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Servizio addServizio(Servizio servizio) {
		return getService().addServizio(servizio);
	}

	public static void addTipologiaServizio(long tipologiaId, long servizioId) {
		getService().addTipologiaServizio(tipologiaId, servizioId);
	}

	public static void addTipologiaServizio(
		long tipologiaId, Servizio servizio) {

		getService().addTipologiaServizio(tipologiaId, servizio);
	}

	public static void addTipologiaServizios(
		long tipologiaId, List<Servizio> servizios) {

		getService().addTipologiaServizios(tipologiaId, servizios);
	}

	public static void addTipologiaServizios(
		long tipologiaId, long[] servizioIds) {

		getService().addTipologiaServizios(tipologiaId, servizioIds);
	}

	public static Servizio aggiornaServizio(Servizio servizioDaAggiornare)
		throws Exception {

		return getService().aggiornaServizio(servizioDaAggiornare);
	}

	public static void clearTipologiaServizios(long tipologiaId) {
		getService().clearTipologiaServizios(tipologiaId);
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
	 * Creates a new servizio with the primary key. Does not add the servizio to the database.
	 *
	 * @param servizioId the primary key for the new servizio
	 * @return the new servizio
	 */
	public static Servizio createServizio(long servizioId) {
		return getService().createServizio(servizioId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static Servizio deleteServizio(long servizioId)
		throws PortalException {

		return getService().deleteServizio(servizioId);
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
	public static Servizio deleteServizio(Servizio servizio) {
		return getService().deleteServizio(servizio);
	}

	public static void deleteTipologiaServizio(
		long tipologiaId, long servizioId) {

		getService().deleteTipologiaServizio(tipologiaId, servizioId);
	}

	public static void deleteTipologiaServizio(
		long tipologiaId, Servizio servizio) {

		getService().deleteTipologiaServizio(tipologiaId, servizio);
	}

	public static void deleteTipologiaServizios(
		long tipologiaId, List<Servizio> servizios) {

		getService().deleteTipologiaServizios(tipologiaId, servizios);
	}

	public static void deleteTipologiaServizios(
		long tipologiaId, long[] servizioIds) {

		getService().deleteTipologiaServizios(tipologiaId, servizioIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.ServizioModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.ServizioModelImpl</code>.
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

	public static Servizio fetchServizio(long servizioId) {
		return getService().fetchServizio(servizioId);
	}

	/**
	 * Returns the servizio matching the UUID and group.
	 *
	 * @param uuid the servizio's UUID
	 * @param groupId the primary key of the group
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public static Servizio fetchServizioByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchServizioByUuidAndGroupId(uuid, groupId);
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
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the servizio with the primary key.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio
	 * @throws PortalException if a servizio with the primary key could not be found
	 */
	public static Servizio getServizio(long servizioId) throws PortalException {
		return getService().getServizio(servizioId);
	}

	public static Servizio getServizioById(Long servizioId) throws Exception {
		return getService().getServizioById(servizioId);
	}

	/**
	 * Returns the servizio matching the UUID and group.
	 *
	 * @param uuid the servizio's UUID
	 * @param groupId the primary key of the group
	 * @return the matching servizio
	 * @throws PortalException if a matching servizio could not be found
	 */
	public static Servizio getServizioByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getServizioByUuidAndGroupId(uuid, groupId);
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
	public static List<Servizio> getServizios(int start, int end) {
		return getService().getServizios(start, end);
	}

	/**
	 * Returns all the servizios matching the UUID and company.
	 *
	 * @param uuid the UUID of the servizios
	 * @param companyId the primary key of the company
	 * @return the matching servizios, or an empty list if no matches were found
	 */
	public static List<Servizio> getServiziosByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getServiziosByUuidAndCompanyId(uuid, companyId);
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
	public static List<Servizio> getServiziosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return getService().getServiziosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of servizios.
	 *
	 * @return the number of servizios
	 */
	public static int getServiziosCount() {
		return getService().getServiziosCount();
	}

	/**
	 * Returns the tipologiaIds of the tipologias associated with the servizio.
	 *
	 * @param servizioId the servizioId of the servizio
	 * @return long[] the tipologiaIds of tipologias associated with the servizio
	 */
	public static long[] getTipologiaPrimaryKeys(long servizioId) {
		return getService().getTipologiaPrimaryKeys(servizioId);
	}

	public static List<Servizio> getTipologiaServizios(long tipologiaId) {
		return getService().getTipologiaServizios(tipologiaId);
	}

	public static List<Servizio> getTipologiaServizios(
		long tipologiaId, int start, int end) {

		return getService().getTipologiaServizios(tipologiaId, start, end);
	}

	public static List<Servizio> getTipologiaServizios(
		long tipologiaId, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return getService().getTipologiaServizios(
			tipologiaId, start, end, orderByComparator);
	}

	public static int getTipologiaServiziosCount(long tipologiaId) {
		return getService().getTipologiaServiziosCount(tipologiaId);
	}

	public static boolean hasTipologiaServizio(
		long tipologiaId, long servizioId) {

		return getService().hasTipologiaServizio(tipologiaId, servizioId);
	}

	public static boolean hasTipologiaServizios(long tipologiaId) {
		return getService().hasTipologiaServizios(tipologiaId);
	}

	public static List<Servizio> listaServiziAttivi(
			Boolean attivo, Integer start, Integer end)
		throws Exception {

		return getService().listaServiziAttivi(attivo, start, end);
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
	public static List<Servizio> searchServizio(
			String nome, String codice, Boolean soloServiziAttivi, int cur,
			int delta, String nomeOrdinamento, String direzioneOrdinamento)
		throws Exception {

		return getService().searchServizio(
			nome, codice, soloServiziAttivi, cur, delta, nomeOrdinamento,
			direzioneOrdinamento);
	}

	public static void setTipologiaServizios(
		long tipologiaId, long[] servizioIds) {

		getService().setTipologiaServizios(tipologiaId, servizioIds);
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
	public static Servizio updateServizio(Servizio servizio) {
		return getService().updateServizio(servizio);
	}

	public static ServizioLocalService getService() {
		return _service;
	}

	private static volatile ServizioLocalService _service;

}