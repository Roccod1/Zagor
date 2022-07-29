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

import it.servizidigitali.gestioneforms.model.TipoDocumento;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TipoDocumento. This utility wraps
 * <code>it.servizidigitali.gestioneforms.service.impl.TipoDocumentoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TipoDocumentoLocalService
 * @generated
 */
public class TipoDocumentoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestioneforms.service.impl.TipoDocumentoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the tipo documento to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipoDocumentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipoDocumento the tipo documento
	 * @return the tipo documento that was added
	 */
	public static TipoDocumento addTipoDocumento(TipoDocumento tipoDocumento) {
		return getService().addTipoDocumento(tipoDocumento);
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
	 * Creates a new tipo documento with the primary key. Does not add the tipo documento to the database.
	 *
	 * @param tipoDocumentoId the primary key for the new tipo documento
	 * @return the new tipo documento
	 */
	public static TipoDocumento createTipoDocumento(long tipoDocumentoId) {
		return getService().createTipoDocumento(tipoDocumentoId);
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
	 * Deletes the tipo documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipoDocumentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento that was removed
	 * @throws PortalException if a tipo documento with the primary key could not be found
	 */
	public static TipoDocumento deleteTipoDocumento(long tipoDocumentoId)
		throws PortalException {

		return getService().deleteTipoDocumento(tipoDocumentoId);
	}

	/**
	 * Deletes the tipo documento from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipoDocumentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipoDocumento the tipo documento
	 * @return the tipo documento that was removed
	 */
	public static TipoDocumento deleteTipoDocumento(
		TipoDocumento tipoDocumento) {

		return getService().deleteTipoDocumento(tipoDocumento);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.TipoDocumentoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.TipoDocumentoModelImpl</code>.
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

	public static TipoDocumento fetchTipoDocumento(long tipoDocumentoId) {
		return getService().fetchTipoDocumento(tipoDocumentoId);
	}

	/**
	 * Returns the tipo documento matching the UUID and group.
	 *
	 * @param uuid the tipo documento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public static TipoDocumento fetchTipoDocumentoByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTipoDocumentoByUuidAndGroupId(uuid, groupId);
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

	public static List<TipoDocumento> getListaTipoDocumentiByStato(
		String stato) {

		return getService().getListaTipoDocumentiByStato(stato);
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
	 * Returns the tipo documento with the primary key.
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento
	 * @throws PortalException if a tipo documento with the primary key could not be found
	 */
	public static TipoDocumento getTipoDocumento(long tipoDocumentoId)
		throws PortalException {

		return getService().getTipoDocumento(tipoDocumentoId);
	}

	/**
	 * Returns the tipo documento matching the UUID and group.
	 *
	 * @param uuid the tipo documento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipo documento
	 * @throws PortalException if a matching tipo documento could not be found
	 */
	public static TipoDocumento getTipoDocumentoByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getTipoDocumentoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the tipo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneforms.model.impl.TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of tipo documentos
	 */
	public static List<TipoDocumento> getTipoDocumentos(int start, int end) {
		return getService().getTipoDocumentos(start, end);
	}

	/**
	 * Returns all the tipo documentos matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipo documentos
	 * @param companyId the primary key of the company
	 * @return the matching tipo documentos, or an empty list if no matches were found
	 */
	public static List<TipoDocumento> getTipoDocumentosByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTipoDocumentosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of tipo documentos matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipo documentos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching tipo documentos, or an empty list if no matches were found
	 */
	public static List<TipoDocumento> getTipoDocumentosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator) {

		return getService().getTipoDocumentosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of tipo documentos.
	 *
	 * @return the number of tipo documentos
	 */
	public static int getTipoDocumentosCount() {
		return getService().getTipoDocumentosCount();
	}

	/**
	 * Updates the tipo documento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipoDocumentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipoDocumento the tipo documento
	 * @return the tipo documento that was updated
	 */
	public static TipoDocumento updateTipoDocumento(
		TipoDocumento tipoDocumento) {

		return getService().updateTipoDocumento(tipoDocumento);
	}

	public static TipoDocumentoLocalService getService() {
		return _service;
	}

	private static volatile TipoDocumentoLocalService _service;

}