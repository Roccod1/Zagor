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

import it.servizidigitali.profiloutente.model.UtenteOrganizzazioneCanaleComunicazione;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for UtenteOrganizzazioneCanaleComunicazione. This utility wraps
 * <code>it.servizidigitali.profiloutente.service.impl.UtenteOrganizzazioneCanaleComunicazioneLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazioneCanaleComunicazioneLocalService
 * @generated
 */
public class UtenteOrganizzazioneCanaleComunicazioneLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.profiloutente.service.impl.UtenteOrganizzazioneCanaleComunicazioneLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the utente organizzazione canale comunicazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneCanaleComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazioneCanaleComunicazione the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione that was added
	 */
	public static UtenteOrganizzazioneCanaleComunicazione
		addUtenteOrganizzazioneCanaleComunicazione(
			UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione) {

		return getService().addUtenteOrganizzazioneCanaleComunicazione(
			utenteOrganizzazioneCanaleComunicazione);
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
	 * Creates a new utente organizzazione canale comunicazione with the primary key. Does not add the utente organizzazione canale comunicazione to the database.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key for the new utente organizzazione canale comunicazione
	 * @return the new utente organizzazione canale comunicazione
	 */
	public static UtenteOrganizzazioneCanaleComunicazione
		createUtenteOrganizzazioneCanaleComunicazione(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazioneCanaleComunicazionePK
					utenteOrganizzazioneCanaleComunicazionePK) {

		return getService().createUtenteOrganizzazioneCanaleComunicazione(
			utenteOrganizzazioneCanaleComunicazionePK);
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
	 * Deletes the utente organizzazione canale comunicazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneCanaleComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazioneCanaleComunicazione the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione that was removed
	 */
	public static UtenteOrganizzazioneCanaleComunicazione
		deleteUtenteOrganizzazioneCanaleComunicazione(
			UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione) {

		return getService().deleteUtenteOrganizzazioneCanaleComunicazione(
			utenteOrganizzazioneCanaleComunicazione);
	}

	/**
	 * Deletes the utente organizzazione canale comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneCanaleComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione that was removed
	 * @throws PortalException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione
			deleteUtenteOrganizzazioneCanaleComunicazione(
				it.servizidigitali.profiloutente.service.persistence.
					UtenteOrganizzazioneCanaleComunicazionePK
						utenteOrganizzazioneCanaleComunicazionePK)
		throws PortalException {

		return getService().deleteUtenteOrganizzazioneCanaleComunicazione(
			utenteOrganizzazioneCanaleComunicazionePK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
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

	public static UtenteOrganizzazioneCanaleComunicazione
		fetchUtenteOrganizzazioneCanaleComunicazione(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazioneCanaleComunicazionePK
					utenteOrganizzazioneCanaleComunicazionePK) {

		return getService().fetchUtenteOrganizzazioneCanaleComunicazione(
			utenteOrganizzazioneCanaleComunicazionePK);
	}

	/**
	 * Returns the utente organizzazione canale comunicazione matching the UUID and group.
	 *
	 * @param uuid the utente organizzazione canale comunicazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione
		fetchUtenteOrganizzazioneCanaleComunicazioneByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().
			fetchUtenteOrganizzazioneCanaleComunicazioneByUuidAndGroupId(
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

	public static List<UtenteOrganizzazioneCanaleComunicazione>
		getListaCanaleComunicazioneByUtenteOrganization(
			long utenteId, long organizationId) {

		return getService().getListaCanaleComunicazioneByUtenteOrganization(
			utenteId, organizationId);
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
	 * Returns the utente organizzazione canale comunicazione with the primary key.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione
	 * @throws PortalException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione
			getUtenteOrganizzazioneCanaleComunicazione(
				it.servizidigitali.profiloutente.service.persistence.
					UtenteOrganizzazioneCanaleComunicazionePK
						utenteOrganizzazioneCanaleComunicazionePK)
		throws PortalException {

		return getService().getUtenteOrganizzazioneCanaleComunicazione(
			utenteOrganizzazioneCanaleComunicazionePK);
	}

	/**
	 * Returns the utente organizzazione canale comunicazione matching the UUID and group.
	 *
	 * @param uuid the utente organizzazione canale comunicazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching utente organizzazione canale comunicazione
	 * @throws PortalException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public static UtenteOrganizzazioneCanaleComunicazione
			getUtenteOrganizzazioneCanaleComunicazioneByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().
			getUtenteOrganizzazioneCanaleComunicazioneByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of utente organizzazione canale comunicaziones
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione>
		getUtenteOrganizzazioneCanaleComunicaziones(int start, int end) {

		return getService().getUtenteOrganizzazioneCanaleComunicaziones(
			start, end);
	}

	/**
	 * Returns all the utente organizzazione canale comunicaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the utente organizzazione canale comunicaziones
	 * @param companyId the primary key of the company
	 * @return the matching utente organizzazione canale comunicaziones, or an empty list if no matches were found
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione>
		getUtenteOrganizzazioneCanaleComunicazionesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
			getUtenteOrganizzazioneCanaleComunicazionesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of utente organizzazione canale comunicaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the utente organizzazione canale comunicaziones
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching utente organizzazione canale comunicaziones, or an empty list if no matches were found
	 */
	public static List<UtenteOrganizzazioneCanaleComunicazione>
		getUtenteOrganizzazioneCanaleComunicazionesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator) {

		return getService().
			getUtenteOrganizzazioneCanaleComunicazionesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones.
	 *
	 * @return the number of utente organizzazione canale comunicaziones
	 */
	public static int getUtenteOrganizzazioneCanaleComunicazionesCount() {
		return getService().getUtenteOrganizzazioneCanaleComunicazionesCount();
	}

	public static List<UtenteOrganizzazioneCanaleComunicazione>
			updateMassivoUtenteOrganizzazioneCanaleComunicazione(
				long userId, long groupId, long companyId, long organizationId,
				long[] listaIdCanaliComunicazione)
		throws Exception {

		return getService().
			updateMassivoUtenteOrganizzazioneCanaleComunicazione(
				userId, groupId, companyId, organizationId,
				listaIdCanaliComunicazione);
	}

	/**
	 * Updates the utente organizzazione canale comunicazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteOrganizzazioneCanaleComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utenteOrganizzazioneCanaleComunicazione the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione that was updated
	 */
	public static UtenteOrganizzazioneCanaleComunicazione
		updateUtenteOrganizzazioneCanaleComunicazione(
			UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione) {

		return getService().updateUtenteOrganizzazioneCanaleComunicazione(
			utenteOrganizzazioneCanaleComunicazione);
	}

	public static UtenteOrganizzazioneCanaleComunicazioneLocalService
		getService() {

		return _service;
	}

	private static volatile UtenteOrganizzazioneCanaleComunicazioneLocalService
		_service;

}