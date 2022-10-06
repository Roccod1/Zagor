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

import it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CommentoRichiesta. This utility wraps
 * <code>it.servizidigitali.scrivaniaoperatore.service.impl.CommentoRichiestaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CommentoRichiestaLocalService
 * @generated
 */
public class CommentoRichiestaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.scrivaniaoperatore.service.impl.CommentoRichiestaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the commento richiesta to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentoRichiesta the commento richiesta
	 * @return the commento richiesta that was added
	 */
	public static CommentoRichiesta addCommentoRichiesta(
		CommentoRichiesta commentoRichiesta) {

		return getService().addCommentoRichiesta(commentoRichiesta);
	}

	public static int countCommentiRichiestaByRichiestaIdVisibile(
		long richiestaId, boolean visibile) {

		return getService().countCommentiRichiestaByRichiestaIdVisibile(
			richiestaId, visibile);
	}

	/**
	 * Creates a new commento richiesta with the primary key. Does not add the commento richiesta to the database.
	 *
	 * @param commentoRichiestaId the primary key for the new commento richiesta
	 * @return the new commento richiesta
	 */
	public static CommentoRichiesta createCommentoRichiesta(
		long commentoRichiestaId) {

		return getService().createCommentoRichiesta(commentoRichiestaId);
	}

	public static long createCommentoRichiesta(
		String testo, String taskId, boolean visibile, long richiestaId,
		long userId, String userName, long groupId, long companyId) {

		return getService().createCommentoRichiesta(
			testo, taskId, visibile, richiestaId, userId, userName, groupId,
			companyId);
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
	 * Deletes the commento richiesta from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentoRichiesta the commento richiesta
	 * @return the commento richiesta that was removed
	 */
	public static CommentoRichiesta deleteCommentoRichiesta(
		CommentoRichiesta commentoRichiesta) {

		return getService().deleteCommentoRichiesta(commentoRichiesta);
	}

	/**
	 * Deletes the commento richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta that was removed
	 * @throws PortalException if a commento richiesta with the primary key could not be found
	 */
	public static CommentoRichiesta deleteCommentoRichiesta(
			long commentoRichiestaId)
		throws PortalException {

		return getService().deleteCommentoRichiesta(commentoRichiestaId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.CommentoRichiestaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.CommentoRichiestaModelImpl</code>.
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

	public static CommentoRichiesta fetchCommentoRichiesta(
		long commentoRichiestaId) {

		return getService().fetchCommentoRichiesta(commentoRichiestaId);
	}

	/**
	 * Returns the commento richiesta matching the UUID and group.
	 *
	 * @param uuid the commento richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta fetchCommentoRichiestaByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCommentoRichiestaByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<CommentoRichiesta> getCommentiRichiestaByRichiestaId(
		long richiestaId) {

		return getService().getCommentiRichiestaByRichiestaId(richiestaId);
	}

	public static List<CommentoRichiesta>
		getCommentiRichiestaByRichiestaIdVisibile(
			long richiestaId, boolean visibile) {

		return getService().getCommentiRichiestaByRichiestaIdVisibile(
			richiestaId, visibile);
	}

	public static List<CommentoRichiesta>
		getCommentiRichiestaByRichiestaIdVisibile(
			long richiestaId, boolean visibile, int start, int end) {

		return getService().getCommentiRichiestaByRichiestaIdVisibile(
			richiestaId, visibile, start, end);
	}

	/**
	 * Returns the commento richiesta with the primary key.
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta
	 * @throws PortalException if a commento richiesta with the primary key could not be found
	 */
	public static CommentoRichiesta getCommentoRichiesta(
			long commentoRichiestaId)
		throws PortalException {

		return getService().getCommentoRichiesta(commentoRichiestaId);
	}

	/**
	 * Returns the commento richiesta matching the UUID and group.
	 *
	 * @param uuid the commento richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching commento richiesta
	 * @throws PortalException if a matching commento richiesta could not be found
	 */
	public static CommentoRichiesta getCommentoRichiestaByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCommentoRichiestaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the commento richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of commento richiestas
	 */
	public static List<CommentoRichiesta> getCommentoRichiestas(
		int start, int end) {

		return getService().getCommentoRichiestas(start, end);
	}

	/**
	 * Returns all the commento richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the commento richiestas
	 * @param companyId the primary key of the company
	 * @return the matching commento richiestas, or an empty list if no matches were found
	 */
	public static List<CommentoRichiesta>
		getCommentoRichiestasByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getCommentoRichiestasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of commento richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the commento richiestas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching commento richiestas, or an empty list if no matches were found
	 */
	public static List<CommentoRichiesta>
		getCommentoRichiestasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<CommentoRichiesta> orderByComparator) {

		return getService().getCommentoRichiestasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of commento richiestas.
	 *
	 * @return the number of commento richiestas
	 */
	public static int getCommentoRichiestasCount() {
		return getService().getCommentoRichiestasCount();
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
	 * Updates the commento richiesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentoRichiesta the commento richiesta
	 * @return the commento richiesta that was updated
	 */
	public static CommentoRichiesta updateCommentoRichiesta(
		CommentoRichiesta commentoRichiesta) {

		return getService().updateCommentoRichiesta(commentoRichiesta);
	}

	public static CommentoRichiestaLocalService getService() {
		return _service;
	}

	private static volatile CommentoRichiestaLocalService _service;

}