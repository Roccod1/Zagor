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

import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AllegatoRichiesta. This utility wraps
 * <code>it.servizidigitali.scrivaniaoperatore.service.impl.AllegatoRichiestaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AllegatoRichiestaLocalService
 * @generated
 */
public class AllegatoRichiestaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.scrivaniaoperatore.service.impl.AllegatoRichiestaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the allegato richiesta to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllegatoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allegatoRichiesta the allegato richiesta
	 * @return the allegato richiesta that was added
	 */
	public static AllegatoRichiesta addAllegatoRichiesta(
		AllegatoRichiesta allegatoRichiesta) {

		return getService().addAllegatoRichiesta(allegatoRichiesta);
	}

	/**
	 * Creates a new allegato richiesta with the primary key. Does not add the allegato richiesta to the database.
	 *
	 * @param allegatoRichiestaId the primary key for the new allegato richiesta
	 * @return the new allegato richiesta
	 */
	public static AllegatoRichiesta createAllegatoRichiesta(
		long allegatoRichiestaId) {

		return getService().createAllegatoRichiesta(allegatoRichiestaId);
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
	 * Deletes the allegato richiesta from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllegatoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allegatoRichiesta the allegato richiesta
	 * @return the allegato richiesta that was removed
	 */
	public static AllegatoRichiesta deleteAllegatoRichiesta(
		AllegatoRichiesta allegatoRichiesta) {

		return getService().deleteAllegatoRichiesta(allegatoRichiesta);
	}

	/**
	 * Deletes the allegato richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllegatoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allegatoRichiestaId the primary key of the allegato richiesta
	 * @return the allegato richiesta that was removed
	 * @throws PortalException if a allegato richiesta with the primary key could not be found
	 */
	public static AllegatoRichiesta deleteAllegatoRichiesta(
			long allegatoRichiestaId)
		throws PortalException {

		return getService().deleteAllegatoRichiesta(allegatoRichiestaId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.AllegatoRichiestaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.AllegatoRichiestaModelImpl</code>.
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

	public static AllegatoRichiesta fetchAllegatoRichiesta(
		long allegatoRichiestaId) {

		return getService().fetchAllegatoRichiesta(allegatoRichiestaId);
	}

	/**
	 * Returns the allegato richiesta matching the UUID and group.
	 *
	 * @param uuid the allegato richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta fetchAllegatoRichiestaByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAllegatoRichiestaByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<AllegatoRichiesta> getAllegatiRichiestaByRichiestaId(
		long richiestaId) {

		return getService().getAllegatiRichiestaByRichiestaId(richiestaId);
	}

	public static List<AllegatoRichiesta>
		getAllegatiRichiestaByRichiestaIdGroupIdInterno(
			long richiestaId, boolean interno) {

		return getService().getAllegatiRichiestaByRichiestaIdGroupIdInterno(
			richiestaId, interno);
	}

	public static List<AllegatoRichiesta>
		getAllegatiRichiestaByRichiestaIdGroupIdVisibile(
			long richiestaId, boolean visibile) {

		return getService().getAllegatiRichiestaByRichiestaIdGroupIdVisibile(
			richiestaId, visibile);
	}

	/**
	 * Returns the allegato richiesta with the primary key.
	 *
	 * @param allegatoRichiestaId the primary key of the allegato richiesta
	 * @return the allegato richiesta
	 * @throws PortalException if a allegato richiesta with the primary key could not be found
	 */
	public static AllegatoRichiesta getAllegatoRichiesta(
			long allegatoRichiestaId)
		throws PortalException {

		return getService().getAllegatoRichiesta(allegatoRichiestaId);
	}

	public static AllegatoRichiesta getAllegatoRichiestaByRichiestaIdPrincipale(
		long richiestaId, boolean principale) {

		return getService().getAllegatoRichiestaByRichiestaIdPrincipale(
			richiestaId, principale);
	}

	/**
	 * Returns the allegato richiesta matching the UUID and group.
	 *
	 * @param uuid the allegato richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allegato richiesta
	 * @throws PortalException if a matching allegato richiesta could not be found
	 */
	public static AllegatoRichiesta getAllegatoRichiestaByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAllegatoRichiestaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the allegato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of allegato richiestas
	 */
	public static List<AllegatoRichiesta> getAllegatoRichiestas(
		int start, int end) {

		return getService().getAllegatoRichiestas(start, end);
	}

	/**
	 * Returns all the allegato richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the allegato richiestas
	 * @param companyId the primary key of the company
	 * @return the matching allegato richiestas, or an empty list if no matches were found
	 */
	public static List<AllegatoRichiesta>
		getAllegatoRichiestasByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getAllegatoRichiestasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of allegato richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the allegato richiestas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching allegato richiestas, or an empty list if no matches were found
	 */
	public static List<AllegatoRichiesta>
		getAllegatoRichiestasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return getService().getAllegatoRichiestasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of allegato richiestas.
	 *
	 * @return the number of allegato richiestas
	 */
	public static int getAllegatoRichiestasCount() {
		return getService().getAllegatoRichiestasCount();
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
	 * Updates the allegato richiesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllegatoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allegatoRichiesta the allegato richiesta
	 * @return the allegato richiesta that was updated
	 */
	public static AllegatoRichiesta updateAllegatoRichiesta(
		AllegatoRichiesta allegatoRichiesta) {

		return getService().updateAllegatoRichiesta(allegatoRichiesta);
	}

	public static void updateVisibilitaAllegatiRichiesta(
		List<String> ids, boolean visibile) {

		getService().updateVisibilitaAllegatiRichiesta(ids, visibile);
	}

	public static AllegatoRichiestaLocalService getService() {
		return _service;
	}

	private static volatile AllegatoRichiestaLocalService _service;

}