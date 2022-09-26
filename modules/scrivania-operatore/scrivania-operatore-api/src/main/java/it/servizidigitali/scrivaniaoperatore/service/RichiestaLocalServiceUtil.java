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

package it.servizidigitali.scrivaniaoperatore.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Richiesta. This utility wraps
 * <code>it.servizidigitali.scrivaniaoperatore.service.impl.RichiestaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaLocalService
 * @generated
 */
public class RichiestaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.scrivaniaoperatore.service.impl.RichiestaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the richiesta to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiesta the richiesta
	 * @return the richiesta that was added
	 */
	public static Richiesta addRichiesta(Richiesta richiesta) {
		return getService().addRichiesta(richiesta);
	}

	public static int count(
		it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters filters) {

		return getService().count(filters);
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
	 * Creates a new richiesta with the primary key. Does not add the richiesta to the database.
	 *
	 * @param richiestaId the primary key for the new richiesta
	 * @return the new richiesta
	 */
	public static Richiesta createRichiesta(long richiestaId) {
		return getService().createRichiesta(richiestaId);
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
	 * Deletes the richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta that was removed
	 * @throws PortalException if a richiesta with the primary key could not be found
	 */
	public static Richiesta deleteRichiesta(long richiestaId)
		throws PortalException {

		return getService().deleteRichiesta(richiestaId);
	}

	/**
	 * Deletes the richiesta from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiesta the richiesta
	 * @return the richiesta that was removed
	 */
	public static Richiesta deleteRichiesta(Richiesta richiesta) {
		return getService().deleteRichiesta(richiesta);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaModelImpl</code>.
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

	public static Richiesta fetchRichiesta(long richiestaId) {
		return getService().fetchRichiesta(richiestaId);
	}

	/**
	 * Returns the richiesta matching the UUID and group.
	 *
	 * @param uuid the richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public static Richiesta fetchRichiestaByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchRichiestaByUuidAndGroupId(uuid, groupId);
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
	 * Returns the richiesta with the primary key.
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta
	 * @throws PortalException if a richiesta with the primary key could not be found
	 */
	public static Richiesta getRichiesta(long richiestaId)
		throws PortalException {

		return getService().getRichiesta(richiestaId);
	}

	/**
	 * Returns the richiesta matching the UUID and group.
	 *
	 * @param uuid the richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching richiesta
	 * @throws PortalException if a matching richiesta could not be found
	 */
	public static Richiesta getRichiestaByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getRichiestaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of richiestas
	 */
	public static List<Richiesta> getRichiestas(int start, int end) {
		return getService().getRichiestas(start, end);
	}

	/**
	 * Returns all the richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the richiestas
	 * @param companyId the primary key of the company
	 * @return the matching richiestas, or an empty list if no matches were found
	 */
	public static List<Richiesta> getRichiestasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getRichiestasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the richiestas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching richiestas, or an empty list if no matches were found
	 */
	public static List<Richiesta> getRichiestasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return getService().getRichiestasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of richiestas.
	 *
	 * @return the number of richiestas
	 */
	public static int getRichiestasCount() {
		return getService().getRichiestasCount();
	}

	public static List<Richiesta>
			getRichiesteByCodiceFiscaleUtenteAndOrganizationGroupid(
				String codiceFiscale, long organizationGroupId, int cur,
				int delta, String orderByCol, String orderByType)
		throws Exception {

		return getService().
			getRichiesteByCodiceFiscaleUtenteAndOrganizationGroupid(
				codiceFiscale, organizationGroupId, cur, delta, orderByCol,
				orderByType);
	}

	public static List<Richiesta> getRichiesteByStato(String stato) {
		return getService().getRichiesteByStato(stato);
	}

	public static List<Richiesta> search(
		it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters filters,
		int start, int end) {

		return getService().search(filters, start, end);
	}

	public static void updateProcessiInstanceIdRichiesta(
			long richiestaId, String processInstanceId)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		getService().updateProcessiInstanceIdRichiesta(
			richiestaId, processInstanceId);
	}

	/**
	 * Updates the richiesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiesta the richiesta
	 * @return the richiesta that was updated
	 */
	public static Richiesta updateRichiesta(Richiesta richiesta) {
		return getService().updateRichiesta(richiesta);
	}

	public static void updateStatoRichiesta(long richiestaId, String stato)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		getService().updateStatoRichiesta(richiestaId, stato);
	}

	public static void updateStatoRichiesta(
			long richiestaId, String stato, String noteToAppend)
		throws it.servizidigitali.scrivaniaoperatore.exception.
			NoSuchRichiestaException {

		getService().updateStatoRichiesta(richiestaId, stato, noteToAppend);
	}

	public static RichiestaLocalService getService() {
		return _service;
	}

	private static volatile RichiestaLocalService _service;

}