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

package it.servizidigitali.accreditamentoenti.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.accreditamentoenti.model.ResponsabileEnte;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ResponsabileEnte. This utility wraps
 * <code>it.servizidigitali.accreditamentoenti.service.impl.ResponsabileEnteLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ResponsabileEnteLocalService
 * @generated
 */
public class ResponsabileEnteLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.accreditamentoenti.service.impl.ResponsabileEnteLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the responsabile ente to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResponsabileEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param responsabileEnte the responsabile ente
	 * @return the responsabile ente that was added
	 */
	public static ResponsabileEnte addResponsabileEnte(
		ResponsabileEnte responsabileEnte) {

		return getService().addResponsabileEnte(responsabileEnte);
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
	 * Creates a new responsabile ente with the primary key. Does not add the responsabile ente to the database.
	 *
	 * @param responsabileEnteId the primary key for the new responsabile ente
	 * @return the new responsabile ente
	 */
	public static ResponsabileEnte createResponsabileEnte(
		long responsabileEnteId) {

		return getService().createResponsabileEnte(responsabileEnteId);
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
	 * Deletes the responsabile ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResponsabileEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param responsabileEnteId the primary key of the responsabile ente
	 * @return the responsabile ente that was removed
	 * @throws PortalException if a responsabile ente with the primary key could not be found
	 */
	public static ResponsabileEnte deleteResponsabileEnte(
			long responsabileEnteId)
		throws PortalException {

		return getService().deleteResponsabileEnte(responsabileEnteId);
	}

	/**
	 * Deletes the responsabile ente from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResponsabileEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param responsabileEnte the responsabile ente
	 * @return the responsabile ente that was removed
	 */
	public static ResponsabileEnte deleteResponsabileEnte(
		ResponsabileEnte responsabileEnte) {

		return getService().deleteResponsabileEnte(responsabileEnte);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.accreditamentoenti.model.impl.ResponsabileEnteModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.accreditamentoenti.model.impl.ResponsabileEnteModelImpl</code>.
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

	public static ResponsabileEnte fetchResponsabileEnte(
		long responsabileEnteId) {

		return getService().fetchResponsabileEnte(responsabileEnteId);
	}

	/**
	 * Returns the responsabile ente matching the UUID and group.
	 *
	 * @param uuid the responsabile ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching responsabile ente, or <code>null</code> if a matching responsabile ente could not be found
	 */
	public static ResponsabileEnte fetchResponsabileEnteByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchResponsabileEnteByUuidAndGroupId(
			uuid, groupId);
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
	 * Returns the responsabile ente with the primary key.
	 *
	 * @param responsabileEnteId the primary key of the responsabile ente
	 * @return the responsabile ente
	 * @throws PortalException if a responsabile ente with the primary key could not be found
	 */
	public static ResponsabileEnte getResponsabileEnte(long responsabileEnteId)
		throws PortalException {

		return getService().getResponsabileEnte(responsabileEnteId);
	}

	public static List<ResponsabileEnte> getResponsabileEnteByEnteId(
		long enteId) {

		return getService().getResponsabileEnteByEnteId(enteId);
	}

	public static ResponsabileEnte
			getResponsabileEnteByResponsabileUserIdAndEnteId(
				long responsabileUserId, long enteId)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchResponsabileEnteException {

		return getService().getResponsabileEnteByResponsabileUserIdAndEnteId(
			responsabileUserId, enteId);
	}

	/**
	 * Returns the responsabile ente matching the UUID and group.
	 *
	 * @param uuid the responsabile ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching responsabile ente
	 * @throws PortalException if a matching responsabile ente could not be found
	 */
	public static ResponsabileEnte getResponsabileEnteByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getResponsabileEnteByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the responsabile entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.accreditamentoenti.model.impl.ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @return the range of responsabile entes
	 */
	public static List<ResponsabileEnte> getResponsabileEntes(
		int start, int end) {

		return getService().getResponsabileEntes(start, end);
	}

	/**
	 * Returns all the responsabile entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the responsabile entes
	 * @param companyId the primary key of the company
	 * @return the matching responsabile entes, or an empty list if no matches were found
	 */
	public static List<ResponsabileEnte> getResponsabileEntesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getResponsabileEntesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of responsabile entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the responsabile entes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching responsabile entes, or an empty list if no matches were found
	 */
	public static List<ResponsabileEnte> getResponsabileEntesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResponsabileEnte> orderByComparator) {

		return getService().getResponsabileEntesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of responsabile entes.
	 *
	 * @return the number of responsabile entes
	 */
	public static int getResponsabileEntesCount() {
		return getService().getResponsabileEntesCount();
	}

	/**
	 * Updates the responsabile ente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResponsabileEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param responsabileEnte the responsabile ente
	 * @return the responsabile ente that was updated
	 */
	public static ResponsabileEnte updateResponsabileEnte(
		ResponsabileEnte responsabileEnte) {

		return getService().updateResponsabileEnte(responsabileEnte);
	}

	public static ResponsabileEnteLocalService getService() {
		return _service;
	}

	private static volatile ResponsabileEnteLocalService _service;

}