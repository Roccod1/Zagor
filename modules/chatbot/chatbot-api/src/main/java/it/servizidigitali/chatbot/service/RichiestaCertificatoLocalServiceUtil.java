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

package it.servizidigitali.chatbot.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.chatbot.model.RichiestaCertificato;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for RichiestaCertificato. This utility wraps
 * <code>it.servizidigitali.chatbot.service.impl.RichiestaCertificatoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaCertificatoLocalService
 * @generated
 */
public class RichiestaCertificatoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.chatbot.service.impl.RichiestaCertificatoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the richiesta certificato to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaCertificatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaCertificato the richiesta certificato
	 * @return the richiesta certificato that was added
	 */
	public static RichiestaCertificato addRichiestaCertificato(
		RichiestaCertificato richiestaCertificato) {

		return getService().addRichiestaCertificato(richiestaCertificato);
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
	 * Creates a new richiesta certificato with the primary key. Does not add the richiesta certificato to the database.
	 *
	 * @param richiestaCertificatoId the primary key for the new richiesta certificato
	 * @return the new richiesta certificato
	 */
	public static RichiestaCertificato createRichiestaCertificato(
		long richiestaCertificatoId) {

		return getService().createRichiestaCertificato(richiestaCertificatoId);
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
	 * Deletes the richiesta certificato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaCertificatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato that was removed
	 * @throws PortalException if a richiesta certificato with the primary key could not be found
	 */
	public static RichiestaCertificato deleteRichiestaCertificato(
			long richiestaCertificatoId)
		throws PortalException {

		return getService().deleteRichiestaCertificato(richiestaCertificatoId);
	}

	/**
	 * Deletes the richiesta certificato from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaCertificatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaCertificato the richiesta certificato
	 * @return the richiesta certificato that was removed
	 */
	public static RichiestaCertificato deleteRichiestaCertificato(
		RichiestaCertificato richiestaCertificato) {

		return getService().deleteRichiestaCertificato(richiestaCertificato);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.chatbot.model.impl.RichiestaCertificatoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.chatbot.model.impl.RichiestaCertificatoModelImpl</code>.
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

	public static RichiestaCertificato fetchRichiestaCertificato(
		long richiestaCertificatoId) {

		return getService().fetchRichiestaCertificato(richiestaCertificatoId);
	}

	/**
	 * Returns the richiesta certificato matching the UUID and group.
	 *
	 * @param uuid the richiesta certificato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato
		fetchRichiestaCertificatoByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchRichiestaCertificatoByUuidAndGroupId(
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
	 * Returns the richiesta certificato with the primary key.
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato
	 * @throws PortalException if a richiesta certificato with the primary key could not be found
	 */
	public static RichiestaCertificato getRichiestaCertificato(
			long richiestaCertificatoId)
		throws PortalException {

		return getService().getRichiestaCertificato(richiestaCertificatoId);
	}

	/**
	 * Returns the richiesta certificato matching the UUID and group.
	 *
	 * @param uuid the richiesta certificato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching richiesta certificato
	 * @throws PortalException if a matching richiesta certificato could not be found
	 */
	public static RichiestaCertificato getRichiestaCertificatoByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getRichiestaCertificatoByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the richiesta certificatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.chatbot.model.impl.RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of richiesta certificatos
	 */
	public static List<RichiestaCertificato> getRichiestaCertificatos(
		int start, int end) {

		return getService().getRichiestaCertificatos(start, end);
	}

	/**
	 * Returns all the richiesta certificatos matching the UUID and company.
	 *
	 * @param uuid the UUID of the richiesta certificatos
	 * @param companyId the primary key of the company
	 * @return the matching richiesta certificatos, or an empty list if no matches were found
	 */
	public static List<RichiestaCertificato>
		getRichiestaCertificatosByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getRichiestaCertificatosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of richiesta certificatos matching the UUID and company.
	 *
	 * @param uuid the UUID of the richiesta certificatos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching richiesta certificatos, or an empty list if no matches were found
	 */
	public static List<RichiestaCertificato>
		getRichiestaCertificatosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<RichiestaCertificato> orderByComparator) {

		return getService().getRichiestaCertificatosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of richiesta certificatos.
	 *
	 * @return the number of richiesta certificatos
	 */
	public static int getRichiestaCertificatosCount() {
		return getService().getRichiestaCertificatosCount();
	}

	/**
	 * Updates the richiesta certificato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaCertificatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaCertificato the richiesta certificato
	 * @return the richiesta certificato that was updated
	 */
	public static RichiestaCertificato updateRichiestaCertificato(
		RichiestaCertificato richiestaCertificato) {

		return getService().updateRichiestaCertificato(richiestaCertificato);
	}

	public static RichiestaCertificatoLocalService getService() {
		return _service;
	}

	private static volatile RichiestaCertificatoLocalService _service;

}