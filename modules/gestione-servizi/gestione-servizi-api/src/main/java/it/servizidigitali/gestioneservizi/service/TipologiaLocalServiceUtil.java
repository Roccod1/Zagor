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

import it.servizidigitali.gestioneservizi.model.Tipologia;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Tipologia. This utility wraps
 * <code>it.servizidigitali.gestioneservizi.service.impl.TipologiaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaLocalService
 * @generated
 */
public class TipologiaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestioneservizi.service.impl.TipologiaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addServizioTipologia(long servizioId, long tipologiaId) {
		getService().addServizioTipologia(servizioId, tipologiaId);
	}

	public static void addServizioTipologia(
		long servizioId, Tipologia tipologia) {

		getService().addServizioTipologia(servizioId, tipologia);
	}

	public static void addServizioTipologias(
		long servizioId, List<Tipologia> tipologias) {

		getService().addServizioTipologias(servizioId, tipologias);
	}

	public static void addServizioTipologias(
		long servizioId, long[] tipologiaIds) {

		getService().addServizioTipologias(servizioId, tipologiaIds);
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
	public static Tipologia addTipologia(Tipologia tipologia) {
		return getService().addTipologia(tipologia);
	}

	public static void clearServizioTipologias(long servizioId) {
		getService().clearServizioTipologias(servizioId);
	}

	public static long count() throws Exception {
		return getService().count();
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
	 * Creates a new tipologia with the primary key. Does not add the tipologia to the database.
	 *
	 * @param tipologiaId the primary key for the new tipologia
	 * @return the new tipologia
	 */
	public static Tipologia createTipologia(long tipologiaId) {
		return getService().createTipologia(tipologiaId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteServizioTipologia(
		long servizioId, long tipologiaId) {

		getService().deleteServizioTipologia(servizioId, tipologiaId);
	}

	public static void deleteServizioTipologia(
		long servizioId, Tipologia tipologia) {

		getService().deleteServizioTipologia(servizioId, tipologia);
	}

	public static void deleteServizioTipologias(
		long servizioId, List<Tipologia> tipologias) {

		getService().deleteServizioTipologias(servizioId, tipologias);
	}

	public static void deleteServizioTipologias(
		long servizioId, long[] tipologiaIds) {

		getService().deleteServizioTipologias(servizioId, tipologiaIds);
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
	public static Tipologia deleteTipologia(long tipologiaId)
		throws PortalException {

		return getService().deleteTipologia(tipologiaId);
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
	public static Tipologia deleteTipologia(Tipologia tipologia) {
		return getService().deleteTipologia(tipologia);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.TipologiaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.TipologiaModelImpl</code>.
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

	public static Tipologia fetchTipologia(long tipologiaId) {
		return getService().fetchTipologia(tipologiaId);
	}

	/**
	 * Returns the tipologia matching the UUID and group.
	 *
	 * @param uuid the tipologia's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public static Tipologia fetchTipologiaByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTipologiaByUuidAndGroupId(uuid, groupId);
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
	 * Returns the servizioIds of the servizios associated with the tipologia.
	 *
	 * @param tipologiaId the tipologiaId of the tipologia
	 * @return long[] the servizioIds of servizios associated with the tipologia
	 */
	public static long[] getServizioPrimaryKeys(long tipologiaId) {
		return getService().getServizioPrimaryKeys(tipologiaId);
	}

	public static List<Tipologia> getServizioTipologias(long servizioId) {
		return getService().getServizioTipologias(servizioId);
	}

	public static List<Tipologia> getServizioTipologias(
		long servizioId, int start, int end) {

		return getService().getServizioTipologias(servizioId, start, end);
	}

	public static List<Tipologia> getServizioTipologias(
		long servizioId, int start, int end,
		OrderByComparator<Tipologia> orderByComparator) {

		return getService().getServizioTipologias(
			servizioId, start, end, orderByComparator);
	}

	public static int getServizioTipologiasCount(long servizioId) {
		return getService().getServizioTipologiasCount(servizioId);
	}

	/**
	 * Returns the tipologia with the primary key.
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia
	 * @throws PortalException if a tipologia with the primary key could not be found
	 */
	public static Tipologia getTipologia(long tipologiaId)
		throws PortalException {

		return getService().getTipologia(tipologiaId);
	}

	public static Tipologia getTipologiaByCodice(String codice) {
		return getService().getTipologiaByCodice(codice);
	}

	/**
	 * Returns the tipologia matching the UUID and group.
	 *
	 * @param uuid the tipologia's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipologia
	 * @throws PortalException if a matching tipologia could not be found
	 */
	public static Tipologia getTipologiaByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getTipologiaByUuidAndGroupId(uuid, groupId);
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
	public static List<Tipologia> getTipologias(int start, int end) {
		return getService().getTipologias(start, end);
	}

	/**
	 * Returns all the tipologias matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipologias
	 * @param companyId the primary key of the company
	 * @return the matching tipologias, or an empty list if no matches were found
	 */
	public static List<Tipologia> getTipologiasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTipologiasByUuidAndCompanyId(uuid, companyId);
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
	public static List<Tipologia> getTipologiasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Tipologia> orderByComparator) {

		return getService().getTipologiasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of tipologias.
	 *
	 * @return the number of tipologias
	 */
	public static int getTipologiasCount() {
		return getService().getTipologiasCount();
	}

	public static List<Tipologia> getTipologie(
		int inizio, int fine, String orderByCol, String orderByType) {

		return getService().getTipologie(inizio, fine, orderByCol, orderByType);
	}

	public static boolean hasServizioTipologia(
		long servizioId, long tipologiaId) {

		return getService().hasServizioTipologia(servizioId, tipologiaId);
	}

	public static boolean hasServizioTipologias(long servizioId) {
		return getService().hasServizioTipologias(servizioId);
	}

	public static Tipologia salvaTipologia(Tipologia tipologia)
		throws Exception {

		return getService().salvaTipologia(tipologia);
	}

	public static void setServizioTipologias(
		long servizioId, long[] tipologiaIds) {

		getService().setServizioTipologias(servizioId, tipologiaIds);
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
	public static Tipologia updateTipologia(Tipologia tipologia) {
		return getService().updateTipologia(tipologia);
	}

	public static TipologiaLocalService getService() {
		return _service;
	}

	private static volatile TipologiaLocalService _service;

}