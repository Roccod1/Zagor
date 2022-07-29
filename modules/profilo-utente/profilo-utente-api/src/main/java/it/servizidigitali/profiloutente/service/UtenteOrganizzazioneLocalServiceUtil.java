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

package it.servizidigitali.profiloutente.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.profiloutente.model.UtenteOrganizzazione;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for UtenteOrganizzazione. This utility wraps
 * <code>it.servizidigitali.profiloutente.service.impl.UtenteOrganizzazioneLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazioneLocalService
 * @generated
 */
public class UtenteOrganizzazioneLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.profiloutente.service.impl.UtenteOrganizzazioneLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the utente organizzazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazione the utente organizzazione
	 * @return the utente organizzazione that was added
	 */
	public static UtenteOrganizzazione addUtenteOrganizzazione(
		UtenteOrganizzazione utenteOrganizzazione) {

		return getService().addUtenteOrganizzazione(utenteOrganizzazione);
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
	 * Creates a new utente organizzazione with the primary key. Does not add the utente organizzazione to the database.
	 *
	 * @param utenteOrganizzazionePK the primary key for the new utente organizzazione
	 * @return the new utente organizzazione
	 */
	public static UtenteOrganizzazione createUtenteOrganizzazione(
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazionePK utenteOrganizzazionePK) {

		return getService().createUtenteOrganizzazione(utenteOrganizzazionePK);
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
	 * Deletes the utente organizzazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazione the utente organizzazione
	 * @return the utente organizzazione that was removed
	 */
	public static UtenteOrganizzazione deleteUtenteOrganizzazione(
		UtenteOrganizzazione utenteOrganizzazione) {

		return getService().deleteUtenteOrganizzazione(utenteOrganizzazione);
	}

	/**
	 * Deletes the utente organizzazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione that was removed
	 * @throws PortalException if a utente organizzazione with the primary key could not be found
	 */
	public static UtenteOrganizzazione deleteUtenteOrganizzazione(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK)
		throws PortalException {

		return getService().deleteUtenteOrganizzazione(utenteOrganizzazionePK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneModelImpl</code>.
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

	public static UtenteOrganizzazione fetchUtenteOrganizzazione(
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazionePK utenteOrganizzazionePK) {

		return getService().fetchUtenteOrganizzazione(utenteOrganizzazionePK);
	}

	/**
	 * Returns the utente organizzazione matching the UUID and group.
	 *
	 * @param uuid the utente organizzazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione
		fetchUtenteOrganizzazioneByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchUtenteOrganizzazioneByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<UtenteOrganizzazione> getByUtenteOrganizzazionePreferito(
			long userId, long organizationId, boolean preferito)
		throws Exception {

		return getService().getByUtenteOrganizzazionePreferito(
			userId, organizationId, preferito);
	}

	public static List<UtenteOrganizzazione> getByUtentePreferito(
			long userId, boolean preferito)
		throws Exception {

		return getService().getByUtentePreferito(userId, preferito);
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

	public static List<UtenteOrganizzazione> getOrganizzazioniUtenteConfigurate(
			Long utenteId)
		throws Exception {

		return getService().getOrganizzazioniUtenteConfigurate(utenteId);
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
	 * Returns the utente organizzazione with the primary key.
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione
	 * @throws PortalException if a utente organizzazione with the primary key could not be found
	 */
	public static UtenteOrganizzazione getUtenteOrganizzazione(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK)
		throws PortalException {

		return getService().getUtenteOrganizzazione(utenteOrganizzazionePK);
	}

	/**
	 * Returns the utente organizzazione matching the UUID and group.
	 *
	 * @param uuid the utente organizzazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching utente organizzazione
	 * @throws PortalException if a matching utente organizzazione could not be found
	 */
	public static UtenteOrganizzazione getUtenteOrganizzazioneByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getUtenteOrganizzazioneByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the utente organizzaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of utente organizzaziones
	 */
	public static List<UtenteOrganizzazione> getUtenteOrganizzaziones(
		int start, int end) {

		return getService().getUtenteOrganizzaziones(start, end);
	}

	/**
	 * Returns all the utente organizzaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the utente organizzaziones
	 * @param companyId the primary key of the company
	 * @return the matching utente organizzaziones, or an empty list if no matches were found
	 */
	public static List<UtenteOrganizzazione>
		getUtenteOrganizzazionesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getUtenteOrganizzazionesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of utente organizzaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the utente organizzaziones
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching utente organizzaziones, or an empty list if no matches were found
	 */
	public static List<UtenteOrganizzazione>
		getUtenteOrganizzazionesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return getService().getUtenteOrganizzazionesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of utente organizzaziones.
	 *
	 * @return the number of utente organizzaziones
	 */
	public static int getUtenteOrganizzazionesCount() {
		return getService().getUtenteOrganizzazionesCount();
	}

	/**
	 * Updates the utente organizzazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazione the utente organizzazione
	 * @return the utente organizzazione that was updated
	 */
	public static UtenteOrganizzazione updateUtenteOrganizzazione(
		UtenteOrganizzazione utenteOrganizzazione) {

		return getService().updateUtenteOrganizzazione(utenteOrganizzazione);
	}

	public static UtenteOrganizzazioneLocalService getService() {
		return _service;
	}

	private static volatile UtenteOrganizzazioneLocalService _service;

}