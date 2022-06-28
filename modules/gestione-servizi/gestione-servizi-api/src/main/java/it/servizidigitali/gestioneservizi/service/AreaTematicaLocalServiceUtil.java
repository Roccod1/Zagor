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

import it.servizidigitali.gestioneservizi.model.AreaTematica;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AreaTematica. This utility wraps
 * <code>it.servizidigitali.gestioneservizi.service.impl.AreaTematicaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AreaTematicaLocalService
 * @generated
 */
public class AreaTematicaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestioneservizi.service.impl.AreaTematicaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the area tematica to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AreaTematicaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param areaTematica the area tematica
	 * @return the area tematica that was added
	 */
	public static AreaTematica addAreaTematica(AreaTematica areaTematica) {
		return getService().addAreaTematica(areaTematica);
	}

	/**
	 * Creates a new area tematica with the primary key. Does not add the area tematica to the database.
	 *
	 * @param areaTematicaId the primary key for the new area tematica
	 * @return the new area tematica
	 */
	public static AreaTematica createAreaTematica(long areaTematicaId) {
		return getService().createAreaTematica(areaTematicaId);
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
	 * Deletes the area tematica from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AreaTematicaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param areaTematica the area tematica
	 * @return the area tematica that was removed
	 */
	public static AreaTematica deleteAreaTematica(AreaTematica areaTematica) {
		return getService().deleteAreaTematica(areaTematica);
	}

	/**
	 * Deletes the area tematica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AreaTematicaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica that was removed
	 * @throws PortalException if a area tematica with the primary key could not be found
	 */
	public static AreaTematica deleteAreaTematica(long areaTematicaId)
		throws PortalException {

		return getService().deleteAreaTematica(areaTematicaId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.AreaTematicaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.AreaTematicaModelImpl</code>.
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

	public static AreaTematica fetchAreaTematica(long areaTematicaId) {
		return getService().fetchAreaTematica(areaTematicaId);
	}

	/**
	 * Returns the area tematica matching the UUID and group.
	 *
	 * @param uuid the area tematica's UUID
	 * @param groupId the primary key of the group
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public static AreaTematica fetchAreaTematicaByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAreaTematicaByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the area tematica with the primary key.
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica
	 * @throws PortalException if a area tematica with the primary key could not be found
	 */
	public static AreaTematica getAreaTematica(long areaTematicaId)
		throws PortalException {

		return getService().getAreaTematica(areaTematicaId);
	}

	/**
	 * Returns the area tematica matching the UUID and group.
	 *
	 * @param uuid the area tematica's UUID
	 * @param groupId the primary key of the group
	 * @return the matching area tematica
	 * @throws PortalException if a matching area tematica could not be found
	 */
	public static AreaTematica getAreaTematicaByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAreaTematicaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the area tematicas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of area tematicas
	 */
	public static List<AreaTematica> getAreaTematicas(int start, int end) {
		return getService().getAreaTematicas(start, end);
	}

	/**
	 * Returns all the area tematicas matching the UUID and company.
	 *
	 * @param uuid the UUID of the area tematicas
	 * @param companyId the primary key of the company
	 * @return the matching area tematicas, or an empty list if no matches were found
	 */
	public static List<AreaTematica> getAreaTematicasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAreaTematicasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of area tematicas matching the UUID and company.
	 *
	 * @param uuid the UUID of the area tematicas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching area tematicas, or an empty list if no matches were found
	 */
	public static List<AreaTematica> getAreaTematicasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator) {

		return getService().getAreaTematicasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of area tematicas.
	 *
	 * @return the number of area tematicas
	 */
	public static int getAreaTematicasCount() {
		return getService().getAreaTematicasCount();
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
	 * Updates the area tematica in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AreaTematicaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param areaTematica the area tematica
	 * @return the area tematica that was updated
	 */
	public static AreaTematica updateAreaTematica(AreaTematica areaTematica) {
		return getService().updateAreaTematica(areaTematica);
	}

	public static AreaTematicaLocalService getService() {
		return _service;
	}

	private static volatile AreaTematicaLocalService _service;

}