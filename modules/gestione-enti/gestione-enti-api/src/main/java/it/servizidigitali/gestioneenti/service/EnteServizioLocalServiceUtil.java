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

package it.servizidigitali.gestioneenti.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneenti.model.EnteServizio;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EnteServizio. This utility wraps
 * <code>it.servizidigitali.gestioneenti.service.impl.EnteServizioLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EnteServizioLocalService
 * @generated
 */
public class EnteServizioLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestioneenti.service.impl.EnteServizioLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ente servizio to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnteServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enteServizio the ente servizio
	 * @return the ente servizio that was added
	 */
	public static EnteServizio addEnteServizio(EnteServizio enteServizio) {
		return getService().addEnteServizio(enteServizio);
	}

	/**
	 * Creates a new ente servizio with the primary key. Does not add the ente servizio to the database.
	 *
	 * @param enteServizioPK the primary key for the new ente servizio
	 * @return the new ente servizio
	 */
	public static EnteServizio createEnteServizio(
		it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
			enteServizioPK) {

		return getService().createEnteServizio(enteServizioPK);
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
	 * Deletes the ente servizio from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnteServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enteServizio the ente servizio
	 * @return the ente servizio that was removed
	 */
	public static EnteServizio deleteEnteServizio(EnteServizio enteServizio) {
		return getService().deleteEnteServizio(enteServizio);
	}

	/**
	 * Deletes the ente servizio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnteServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enteServizioPK the primary key of the ente servizio
	 * @return the ente servizio that was removed
	 * @throws PortalException if a ente servizio with the primary key could not be found
	 */
	public static EnteServizio deleteEnteServizio(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK)
		throws PortalException {

		return getService().deleteEnteServizio(enteServizioPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneenti.model.impl.EnteServizioModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneenti.model.impl.EnteServizioModelImpl</code>.
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

	public static EnteServizio fetchEnteServizio(
		it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
			enteServizioPK) {

		return getService().fetchEnteServizio(enteServizioPK);
	}

	/**
	 * Returns the ente servizio matching the UUID and group.
	 *
	 * @param uuid the ente servizio's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public static EnteServizio fetchEnteServizioByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEnteServizioByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ente servizio with the primary key.
	 *
	 * @param enteServizioPK the primary key of the ente servizio
	 * @return the ente servizio
	 * @throws PortalException if a ente servizio with the primary key could not be found
	 */
	public static EnteServizio getEnteServizio(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK)
		throws PortalException {

		return getService().getEnteServizio(enteServizioPK);
	}

	/**
	 * Returns the ente servizio matching the UUID and group.
	 *
	 * @param uuid the ente servizio's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ente servizio
	 * @throws PortalException if a matching ente servizio could not be found
	 */
	public static EnteServizio getEnteServizioByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEnteServizioByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the ente servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneenti.model.impl.EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @return the range of ente servizios
	 */
	public static List<EnteServizio> getEnteServizios(int start, int end) {
		return getService().getEnteServizios(start, end);
	}

	/**
	 * Returns all the ente servizios matching the UUID and company.
	 *
	 * @param uuid the UUID of the ente servizios
	 * @param companyId the primary key of the company
	 * @return the matching ente servizios, or an empty list if no matches were found
	 */
	public static List<EnteServizio> getEnteServiziosByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEnteServiziosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of ente servizios matching the UUID and company.
	 *
	 * @param uuid the UUID of the ente servizios
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ente servizios, or an empty list if no matches were found
	 */
	public static List<EnteServizio> getEnteServiziosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EnteServizio> orderByComparator) {

		return getService().getEnteServiziosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ente servizios.
	 *
	 * @return the number of ente servizios
	 */
	public static int getEnteServiziosCount() {
		return getService().getEnteServiziosCount();
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
	 * Updates the ente servizio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnteServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enteServizio the ente servizio
	 * @return the ente servizio that was updated
	 */
	public static EnteServizio updateEnteServizio(EnteServizio enteServizio) {
		return getService().updateEnteServizio(enteServizio);
	}

	public static EnteServizioLocalService getService() {
		return _service;
	}

	private static volatile EnteServizioLocalService _service;

}