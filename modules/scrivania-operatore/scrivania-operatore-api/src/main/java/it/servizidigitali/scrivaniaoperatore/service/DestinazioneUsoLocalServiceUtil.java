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

import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DestinazioneUso. This utility wraps
 * <code>it.servizidigitali.scrivaniaoperatore.service.impl.DestinazioneUsoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DestinazioneUsoLocalService
 * @generated
 */
public class DestinazioneUsoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.scrivaniaoperatore.service.impl.DestinazioneUsoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the destinazione uso to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUso the destinazione uso
	 * @return the destinazione uso that was added
	 */
	public static DestinazioneUso addDestinazioneUso(
		DestinazioneUso destinazioneUso) {

		return getService().addDestinazioneUso(destinazioneUso);
	}

	/**
	 * Creates a new destinazione uso with the primary key. Does not add the destinazione uso to the database.
	 *
	 * @param destinazioneUsoId the primary key for the new destinazione uso
	 * @return the new destinazione uso
	 */
	public static DestinazioneUso createDestinazioneUso(
		long destinazioneUsoId) {

		return getService().createDestinazioneUso(destinazioneUsoId);
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
	 * Deletes the destinazione uso from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUso the destinazione uso
	 * @return the destinazione uso that was removed
	 */
	public static DestinazioneUso deleteDestinazioneUso(
		DestinazioneUso destinazioneUso) {

		return getService().deleteDestinazioneUso(destinazioneUso);
	}

	/**
	 * Deletes the destinazione uso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso that was removed
	 * @throws PortalException if a destinazione uso with the primary key could not be found
	 */
	public static DestinazioneUso deleteDestinazioneUso(long destinazioneUsoId)
		throws PortalException {

		return getService().deleteDestinazioneUso(destinazioneUsoId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoModelImpl</code>.
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

	public static DestinazioneUso fetchDestinazioneUso(long destinazioneUsoId) {
		return getService().fetchDestinazioneUso(destinazioneUsoId);
	}

	/**
	 * Returns the destinazione uso matching the UUID and group.
	 *
	 * @param uuid the destinazione uso's UUID
	 * @param groupId the primary key of the group
	 * @return the matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso fetchDestinazioneUsoByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDestinazioneUsoByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the destinazione uso with the primary key.
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso
	 * @throws PortalException if a destinazione uso with the primary key could not be found
	 */
	public static DestinazioneUso getDestinazioneUso(long destinazioneUsoId)
		throws PortalException {

		return getService().getDestinazioneUso(destinazioneUsoId);
	}

	/**
	 * Returns the destinazione uso matching the UUID and group.
	 *
	 * @param uuid the destinazione uso's UUID
	 * @param groupId the primary key of the group
	 * @return the matching destinazione uso
	 * @throws PortalException if a matching destinazione uso could not be found
	 */
	public static DestinazioneUso getDestinazioneUsoByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDestinazioneUsoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the destinazione usos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of destinazione usos
	 */
	public static List<DestinazioneUso> getDestinazioneUsos(
		int start, int end) {

		return getService().getDestinazioneUsos(start, end);
	}

	/**
	 * Returns all the destinazione usos matching the UUID and company.
	 *
	 * @param uuid the UUID of the destinazione usos
	 * @param companyId the primary key of the company
	 * @return the matching destinazione usos, or an empty list if no matches were found
	 */
	public static List<DestinazioneUso> getDestinazioneUsosByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDestinazioneUsosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of destinazione usos matching the UUID and company.
	 *
	 * @param uuid the UUID of the destinazione usos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching destinazione usos, or an empty list if no matches were found
	 */
	public static List<DestinazioneUso> getDestinazioneUsosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return getService().getDestinazioneUsosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of destinazione usos.
	 *
	 * @return the number of destinazione usos
	 */
	public static int getDestinazioneUsosCount() {
		return getService().getDestinazioneUsosCount();
	}

	public static List<DestinazioneUso> getDestinazioniUsoByOrganizationId(
		long organizationId, long groupId, long companyId) {

		return getService().getDestinazioniUsoByOrganizationId(
			organizationId, groupId, companyId);
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
	 * Updates the destinazione uso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUso the destinazione uso
	 * @return the destinazione uso that was updated
	 */
	public static DestinazioneUso updateDestinazioneUso(
		DestinazioneUso destinazioneUso) {

		return getService().updateDestinazioneUso(destinazioneUso);
	}

	public static DestinazioneUsoLocalService getService() {
		return _service;
	}

	private static volatile DestinazioneUsoLocalService _service;

}