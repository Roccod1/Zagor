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

import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DestinazioneUsoServizioEnte. This utility wraps
 * <code>it.servizidigitali.scrivaniaoperatore.service.impl.DestinazioneUsoServizioEnteLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DestinazioneUsoServizioEnteLocalService
 * @generated
 */
public class DestinazioneUsoServizioEnteLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.scrivaniaoperatore.service.impl.DestinazioneUsoServizioEnteLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the destinazione uso servizio ente to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUsoServizioEnte the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente that was added
	 */
	public static DestinazioneUsoServizioEnte addDestinazioneUsoServizioEnte(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		return getService().addDestinazioneUsoServizioEnte(
			destinazioneUsoServizioEnte);
	}

	/**
	 * Creates a new destinazione uso servizio ente with the primary key. Does not add the destinazione uso servizio ente to the database.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key for the new destinazione uso servizio ente
	 * @return the new destinazione uso servizio ente
	 */
	public static DestinazioneUsoServizioEnte createDestinazioneUsoServizioEnte(
		it.servizidigitali.scrivaniaoperatore.service.persistence.
			DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK) {

		return getService().createDestinazioneUsoServizioEnte(
			destinazioneUsoServizioEntePK);
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
	 * Deletes the destinazione uso servizio ente from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUsoServizioEnte the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente that was removed
	 */
	public static DestinazioneUsoServizioEnte deleteDestinazioneUsoServizioEnte(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		return getService().deleteDestinazioneUsoServizioEnte(
			destinazioneUsoServizioEnte);
	}

	/**
	 * Deletes the destinazione uso servizio ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente that was removed
	 * @throws PortalException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public static DestinazioneUsoServizioEnte deleteDestinazioneUsoServizioEnte(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK)
		throws PortalException {

		return getService().deleteDestinazioneUsoServizioEnte(
			destinazioneUsoServizioEntePK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoServizioEnteModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoServizioEnteModelImpl</code>.
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

	public static DestinazioneUsoServizioEnte fetchDestinazioneUsoServizioEnte(
		it.servizidigitali.scrivaniaoperatore.service.persistence.
			DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK) {

		return getService().fetchDestinazioneUsoServizioEnte(
			destinazioneUsoServizioEntePK);
	}

	/**
	 * Returns the destinazione uso servizio ente matching the UUID and group.
	 *
	 * @param uuid the destinazione uso servizio ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte
		fetchDestinazioneUsoServizioEnteByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchDestinazioneUsoServizioEnteByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the destinazione uso servizio ente with the primary key.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente
	 * @throws PortalException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public static DestinazioneUsoServizioEnte getDestinazioneUsoServizioEnte(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK)
		throws PortalException {

		return getService().getDestinazioneUsoServizioEnte(
			destinazioneUsoServizioEntePK);
	}

	/**
	 * Returns the destinazione uso servizio ente matching the UUID and group.
	 *
	 * @param uuid the destinazione uso servizio ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching destinazione uso servizio ente
	 * @throws PortalException if a matching destinazione uso servizio ente could not be found
	 */
	public static DestinazioneUsoServizioEnte
			getDestinazioneUsoServizioEnteByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getDestinazioneUsoServizioEnteByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the destinazione uso servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of destinazione uso servizio entes
	 */
	public static List<DestinazioneUsoServizioEnte>
		getDestinazioneUsoServizioEntes(int start, int end) {

		return getService().getDestinazioneUsoServizioEntes(start, end);
	}

	/**
	 * Returns all the destinazione uso servizio entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the destinazione uso servizio entes
	 * @param companyId the primary key of the company
	 * @return the matching destinazione uso servizio entes, or an empty list if no matches were found
	 */
	public static List<DestinazioneUsoServizioEnte>
		getDestinazioneUsoServizioEntesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getDestinazioneUsoServizioEntesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of destinazione uso servizio entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the destinazione uso servizio entes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching destinazione uso servizio entes, or an empty list if no matches were found
	 */
	public static List<DestinazioneUsoServizioEnte>
		getDestinazioneUsoServizioEntesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return getService().getDestinazioneUsoServizioEntesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of destinazione uso servizio entes.
	 *
	 * @return the number of destinazione uso servizio entes
	 */
	public static int getDestinazioneUsoServizioEntesCount() {
		return getService().getDestinazioneUsoServizioEntesCount();
	}

	public static List<DestinazioneUsoServizioEnte>
		getDestinazioniUsoServizioEnteByServizioIdOrganizationId(
			long servizioId, long organizationId, long groupId,
			long companyId) {

		return getService().
			getDestinazioniUsoServizioEnteByServizioIdOrganizationId(
				servizioId, organizationId, groupId, companyId);
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
	 * Updates the destinazione uso servizio ente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DestinazioneUsoServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param destinazioneUsoServizioEnte the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente that was updated
	 */
	public static DestinazioneUsoServizioEnte updateDestinazioneUsoServizioEnte(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		return getService().updateDestinazioneUsoServizioEnte(
			destinazioneUsoServizioEnte);
	}

	public static DestinazioneUsoServizioEnteLocalService getService() {
		return _service;
	}

	private static volatile DestinazioneUsoServizioEnteLocalService _service;

}