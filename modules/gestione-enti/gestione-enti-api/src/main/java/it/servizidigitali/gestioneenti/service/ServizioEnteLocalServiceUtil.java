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

import it.servizidigitali.gestioneenti.model.ServizioEnte;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ServizioEnte. This utility wraps
 * <code>it.servizidigitali.gestioneenti.service.impl.ServizioEnteLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioEnteLocalService
 * @generated
 */
public class ServizioEnteLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestioneenti.service.impl.ServizioEnteLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the servizio ente to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizioEnte the servizio ente
	 * @return the servizio ente that was added
	 */
	public static ServizioEnte addServizioEnte(ServizioEnte servizioEnte) {
		return getService().addServizioEnte(servizioEnte);
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
	 * Creates a new servizio ente with the primary key. Does not add the servizio ente to the database.
	 *
	 * @param servizioEntePK the primary key for the new servizio ente
	 * @return the new servizio ente
	 */
	public static ServizioEnte createServizioEnte(
		it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
			servizioEntePK) {

		return getService().createServizioEnte(servizioEntePK);
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
	 * Deletes the servizio ente from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizioEnte the servizio ente
	 * @return the servizio ente that was removed
	 */
	public static ServizioEnte deleteServizioEnte(ServizioEnte servizioEnte) {
		return getService().deleteServizioEnte(servizioEnte);
	}

	/**
	 * Deletes the servizio ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente that was removed
	 * @throws PortalException if a servizio ente with the primary key could not be found
	 */
	public static ServizioEnte deleteServizioEnte(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK)
		throws PortalException {

		return getService().deleteServizioEnte(servizioEntePK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneenti.model.impl.ServizioEnteModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneenti.model.impl.ServizioEnteModelImpl</code>.
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

	public static ServizioEnte fetchServizioEnte(
		it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
			servizioEntePK) {

		return getService().fetchServizioEnte(servizioEntePK);
	}

	/**
	 * Returns the servizio ente matching the UUID and group.
	 *
	 * @param uuid the servizio ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public static ServizioEnte fetchServizioEnteByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchServizioEnteByUuidAndGroupId(uuid, groupId);
	}

	public static List<com.liferay.portal.kernel.model.Organization>
			findOrganizationsByParams(
				String nome, String codiceIpa, int cur, int delta,
				String orderByCol, String orderByType)
		throws Exception {

		return getService().findOrganizationsByParams(
			nome, codiceIpa, cur, delta, orderByCol, orderByType);
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

	public static List<Object> getListaServiziByCompanyOrganizationAttivo(
			long companyId, long organizationId, boolean attivo)
		throws Exception {

		return getService().getListaServiziByCompanyOrganizationAttivo(
			companyId, organizationId, attivo);
	}

	public static List<Long> getListaServiziByOrganizationAttivo(
			long organizationId, boolean attivo)
		throws Exception {

		return getService().getListaServiziByOrganizationAttivo(
			organizationId, attivo);
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

	public static List<ServizioEnte> getServiziEnte(long organizationId) {
		return getService().getServiziEnte(organizationId);
	}

	public static List<ServizioEnte>
		getServiziEnteByOrganizationIdSubOrganizationIdsAttivo(
			long organizationId, List<Long> subOrganizationIds, Boolean attivo,
			long groupId, long companyId) {

		return getService().
			getServiziEnteByOrganizationIdSubOrganizationIdsAttivo(
				organizationId, subOrganizationIds, attivo, groupId, companyId);
	}

	/**
	 * Returns the servizio ente with the primary key.
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente
	 * @throws PortalException if a servizio ente with the primary key could not be found
	 */
	public static ServizioEnte getServizioEnte(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK)
		throws PortalException {

		return getService().getServizioEnte(servizioEntePK);
	}

	/**
	 * Returns the servizio ente matching the UUID and group.
	 *
	 * @param uuid the servizio ente's UUID
	 * @param groupId the primary key of the group
	 * @return the matching servizio ente
	 * @throws PortalException if a matching servizio ente could not be found
	 */
	public static ServizioEnte getServizioEnteByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getServizioEnteByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneenti.model.impl.ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of servizio entes
	 */
	public static List<ServizioEnte> getServizioEntes(int start, int end) {
		return getService().getServizioEntes(start, end);
	}

	/**
	 * Returns all the servizio entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the servizio entes
	 * @param companyId the primary key of the company
	 * @return the matching servizio entes, or an empty list if no matches were found
	 */
	public static List<ServizioEnte> getServizioEntesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getServizioEntesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of servizio entes matching the UUID and company.
	 *
	 * @param uuid the UUID of the servizio entes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching servizio entes, or an empty list if no matches were found
	 */
	public static List<ServizioEnte> getServizioEntesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return getService().getServizioEntesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of servizio entes.
	 *
	 * @return the number of servizio entes
	 */
	public static int getServizioEntesCount() {
		return getService().getServizioEntesCount();
	}

	/**
	 * Updates the servizio ente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioEnteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizioEnte the servizio ente
	 * @return the servizio ente that was updated
	 */
	public static ServizioEnte updateServizioEnte(ServizioEnte servizioEnte) {
		return getService().updateServizioEnte(servizioEnte);
	}

	public static ServizioEnteLocalService getService() {
		return _service;
	}

	private static volatile ServizioEnteLocalService _service;

}