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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneprocedure.model.Procedura;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Procedura. This utility wraps
 * <code>it.servizidigitali.gestioneprocedure.service.impl.ProceduraLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProceduraLocalService
 * @generated
 */
public class ProceduraLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestioneprocedure.service.impl.ProceduraLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Procedura addProcedura(Procedura procedura) {
		return getService().addProcedura(procedura);
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
	 * Creates a new procedura with the primary key. Does not add the procedura to the database.
	 *
	 * @param proceduraId the primary key for the new procedura
	 * @return the new procedura
	 */
	public static Procedura createProcedura(long proceduraId) {
		return getService().createProcedura(proceduraId);
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
	public static Procedura deleteProcedura(long proceduraId)
		throws PortalException {

		return getService().deleteProcedura(proceduraId);
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
	public static Procedura deleteProcedura(Procedura procedura) {
		return getService().deleteProcedura(procedura);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.ProceduraModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.ProceduraModelImpl</code>.
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

	public static Procedura fetchProcedura(long proceduraId) {
		return getService().fetchProcedura(proceduraId);
	}

	/**
	 * Returns the procedura matching the UUID and group.
	 *
	 * @param uuid the procedura's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public static Procedura fetchProceduraByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProceduraByUuidAndGroupId(uuid, groupId);
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
	 * Returns the procedura with the primary key.
	 *
	 * @param proceduraId the primary key of the procedura
	 * @return the procedura
	 * @throws PortalException if a procedura with the primary key could not be found
	 */
	public static Procedura getProcedura(long proceduraId)
		throws PortalException {

		return getService().getProcedura(proceduraId);
	}

	/**
	 * Returns the procedura matching the UUID and group.
	 *
	 * @param uuid the procedura's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedura
	 * @throws PortalException if a matching procedura could not be found
	 */
	public static Procedura getProceduraByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProceduraByUuidAndGroupId(uuid, groupId);
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
	public static List<Procedura> getProceduras(int start, int end) {
		return getService().getProceduras(start, end);
	}

	/**
	 * Returns all the proceduras matching the UUID and company.
	 *
	 * @param uuid the UUID of the proceduras
	 * @param companyId the primary key of the company
	 * @return the matching proceduras, or an empty list if no matches were found
	 */
	public static List<Procedura> getProcedurasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProcedurasByUuidAndCompanyId(uuid, companyId);
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
	public static List<Procedura> getProcedurasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return getService().getProcedurasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of proceduras.
	 *
	 * @return the number of proceduras
	 */
	public static int getProcedurasCount() {
		return getService().getProcedurasCount();
	}

	public static List<Procedura> search(
		String nome, Boolean attiva, java.util.Date dataInserimentoDa,
		java.util.Date dataInserimentoA, int delta, int cur, String orderByCol,
		String orderByType) {

		return getService().search(
			nome, attiva, dataInserimentoDa, dataInserimentoA, delta, cur,
			orderByCol, orderByType);
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
	public static Procedura updateProcedura(Procedura procedura) {
		return getService().updateProcedura(procedura);
	}

	public static ProceduraLocalService getService() {
		return _service;
	}

	private static volatile ProceduraLocalService _service;

}