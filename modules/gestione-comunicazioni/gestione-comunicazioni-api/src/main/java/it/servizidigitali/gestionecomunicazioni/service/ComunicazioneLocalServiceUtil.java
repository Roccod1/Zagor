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

package it.servizidigitali.gestionecomunicazioni.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestionecomunicazioni.model.Comunicazione;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Comunicazione. This utility wraps
 * <code>it.servizidigitali.gestionecomunicazioni.service.impl.ComunicazioneLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ComunicazioneLocalService
 * @generated
 */
public class ComunicazioneLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestionecomunicazioni.service.impl.ComunicazioneLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the comunicazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comunicazione the comunicazione
	 * @return the comunicazione that was added
	 */
	public static Comunicazione addComunicazione(Comunicazione comunicazione) {
		return getService().addComunicazione(comunicazione);
	}

	public static Comunicazione addComunicazione(
			long groupId, long companyId, long userId, long organizationId,
			String userName, String titolo, String descrizione,
			java.util.Date dataInizio, java.util.Date dataFine,
			long tipologiaId, Long destinatarioUserId,
			long destinatarioOrganizationId)
		throws PortalException {

		return getService().addComunicazione(
			groupId, companyId, userId, organizationId, userName, titolo,
			descrizione, dataInizio, dataFine, tipologiaId, destinatarioUserId,
			destinatarioOrganizationId);
	}

	public static int countByFilters(
		Long organizzazione, String username, Long tipologia) {

		return getService().countByFilters(organizzazione, username, tipologia);
	}

	/**
	 * Creates a new comunicazione with the primary key. Does not add the comunicazione to the database.
	 *
	 * @param comunicazioneId the primary key for the new comunicazione
	 * @return the new comunicazione
	 */
	public static Comunicazione createComunicazione(long comunicazioneId) {
		return getService().createComunicazione(comunicazioneId);
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
	 * Deletes the comunicazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comunicazione the comunicazione
	 * @return the comunicazione that was removed
	 */
	public static Comunicazione deleteComunicazione(
		Comunicazione comunicazione) {

		return getService().deleteComunicazione(comunicazione);
	}

	/**
	 * Deletes the comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione that was removed
	 * @throws PortalException if a comunicazione with the primary key could not be found
	 */
	public static Comunicazione deleteComunicazione(long comunicazioneId)
		throws PortalException {

		return getService().deleteComunicazione(comunicazioneId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.ComunicazioneModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.ComunicazioneModelImpl</code>.
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

	public static Comunicazione fetchComunicazione(long comunicazioneId) {
		return getService().fetchComunicazione(comunicazioneId);
	}

	/**
	 * Returns the comunicazione matching the UUID and group.
	 *
	 * @param uuid the comunicazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public static Comunicazione fetchComunicazioneByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchComunicazioneByUuidAndGroupId(uuid, groupId);
	}

	public static List<Comunicazione> findByFilters(
		Long organizzazione, String username, Long tipologia, int cur,
		int delta) {

		return getService().findByFilters(
			organizzazione, username, tipologia, cur, delta);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the comunicazione with the primary key.
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione
	 * @throws PortalException if a comunicazione with the primary key could not be found
	 */
	public static Comunicazione getComunicazione(long comunicazioneId)
		throws PortalException {

		return getService().getComunicazione(comunicazioneId);
	}

	/**
	 * Returns the comunicazione matching the UUID and group.
	 *
	 * @param uuid the comunicazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching comunicazione
	 * @throws PortalException if a matching comunicazione could not be found
	 */
	public static Comunicazione getComunicazioneByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getComunicazioneByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of comunicaziones
	 */
	public static List<Comunicazione> getComunicaziones(int start, int end) {
		return getService().getComunicaziones(start, end);
	}

	/**
	 * Returns all the comunicaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the comunicaziones
	 * @param companyId the primary key of the company
	 * @return the matching comunicaziones, or an empty list if no matches were found
	 */
	public static List<Comunicazione> getComunicazionesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getComunicazionesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of comunicaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the comunicaziones
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching comunicaziones, or an empty list if no matches were found
	 */
	public static List<Comunicazione> getComunicazionesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return getService().getComunicazionesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of comunicaziones.
	 *
	 * @return the number of comunicaziones
	 */
	public static int getComunicazionesCount() {
		return getService().getComunicazionesCount();
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
	 * Updates the comunicazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comunicazione the comunicazione
	 * @return the comunicazione that was updated
	 */
	public static Comunicazione updateComunicazione(
		Comunicazione comunicazione) {

		return getService().updateComunicazione(comunicazione);
	}

	public static ComunicazioneLocalService getService() {
		return _service;
	}

	private static volatile ComunicazioneLocalService _service;

}