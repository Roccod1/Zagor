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

package it.servizidigitali.gestioneforms.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DefinizioneAllegato. This utility wraps
 * <code>it.servizidigitali.gestioneforms.service.impl.DefinizioneAllegatoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DefinizioneAllegatoLocalService
 * @generated
 */
public class DefinizioneAllegatoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestioneforms.service.impl.DefinizioneAllegatoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the definizione allegato to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DefinizioneAllegatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param definizioneAllegato the definizione allegato
	 * @return the definizione allegato that was added
	 */
	public static DefinizioneAllegato addDefinizioneAllegato(
		DefinizioneAllegato definizioneAllegato) {

		return getService().addDefinizioneAllegato(definizioneAllegato);
	}

	public static DefinizioneAllegato cancellaAllegati(
		String[] allegatiDaEliminare) {

		return getService().cancellaAllegati(allegatiDaEliminare);
	}

	/**
	 * Creates a new definizione allegato with the primary key. Does not add the definizione allegato to the database.
	 *
	 * @param definizioneAllegatoId the primary key for the new definizione allegato
	 * @return the new definizione allegato
	 */
	public static DefinizioneAllegato createDefinizioneAllegato(
		long definizioneAllegatoId) {

		return getService().createDefinizioneAllegato(definizioneAllegatoId);
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
	 * Deletes the definizione allegato from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DefinizioneAllegatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param definizioneAllegato the definizione allegato
	 * @return the definizione allegato that was removed
	 */
	public static DefinizioneAllegato deleteDefinizioneAllegato(
		DefinizioneAllegato definizioneAllegato) {

		return getService().deleteDefinizioneAllegato(definizioneAllegato);
	}

	/**
	 * Deletes the definizione allegato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DefinizioneAllegatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato that was removed
	 * @throws PortalException if a definizione allegato with the primary key could not be found
	 */
	public static DefinizioneAllegato deleteDefinizioneAllegato(
			long definizioneAllegatoId)
		throws PortalException {

		return getService().deleteDefinizioneAllegato(definizioneAllegatoId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.DefinizioneAllegatoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.DefinizioneAllegatoModelImpl</code>.
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

	public static DefinizioneAllegato fetchDefinizioneAllegato(
		long definizioneAllegatoId) {

		return getService().fetchDefinizioneAllegato(definizioneAllegatoId);
	}

	/**
	 * Returns the definizione allegato matching the UUID and group.
	 *
	 * @param uuid the definizione allegato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato fetchDefinizioneAllegatoByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDefinizioneAllegatoByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the definizione allegato with the primary key.
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato
	 * @throws PortalException if a definizione allegato with the primary key could not be found
	 */
	public static DefinizioneAllegato getDefinizioneAllegato(
			long definizioneAllegatoId)
		throws PortalException {

		return getService().getDefinizioneAllegato(definizioneAllegatoId);
	}

	/**
	 * Returns the definizione allegato matching the UUID and group.
	 *
	 * @param uuid the definizione allegato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching definizione allegato
	 * @throws PortalException if a matching definizione allegato could not be found
	 */
	public static DefinizioneAllegato getDefinizioneAllegatoByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDefinizioneAllegatoByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the definizione allegatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of definizione allegatos
	 */
	public static List<DefinizioneAllegato> getDefinizioneAllegatos(
		int start, int end) {

		return getService().getDefinizioneAllegatos(start, end);
	}

	/**
	 * Returns all the definizione allegatos matching the UUID and company.
	 *
	 * @param uuid the UUID of the definizione allegatos
	 * @param companyId the primary key of the company
	 * @return the matching definizione allegatos, or an empty list if no matches were found
	 */
	public static List<DefinizioneAllegato>
		getDefinizioneAllegatosByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getDefinizioneAllegatosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of definizione allegatos matching the UUID and company.
	 *
	 * @param uuid the UUID of the definizione allegatos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching definizione allegatos, or an empty list if no matches were found
	 */
	public static List<DefinizioneAllegato>
		getDefinizioneAllegatosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return getService().getDefinizioneAllegatosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of definizione allegatos.
	 *
	 * @return the number of definizione allegatos
	 */
	public static int getDefinizioneAllegatosCount() {
		return getService().getDefinizioneAllegatosCount();
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

	public static List<DefinizioneAllegato> getListaDefinizioneAllegatoByFormId(
		long formId) {

		return getService().getListaDefinizioneAllegatoByFormId(formId);
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
	 * Updates the definizione allegato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DefinizioneAllegatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param definizioneAllegato the definizione allegato
	 * @return the definizione allegato that was updated
	 */
	public static DefinizioneAllegato updateDefinizioneAllegato(
		DefinizioneAllegato definizioneAllegato) {

		return getService().updateDefinizioneAllegato(definizioneAllegato);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry
			uploadAllegato(
				java.io.File allegato,
				com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
				String fileName, long formId, String mimeType,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return getService().uploadAllegato(
			allegato, themeDisplay, fileName, formId, mimeType, serviceContext);
	}

	public static DefinizioneAllegatoLocalService getService() {
		return _service;
	}

	private static volatile DefinizioneAllegatoLocalService _service;

}