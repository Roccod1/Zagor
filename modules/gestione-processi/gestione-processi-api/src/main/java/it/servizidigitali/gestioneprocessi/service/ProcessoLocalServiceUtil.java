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

package it.servizidigitali.gestioneprocessi.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneprocessi.model.Processo;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Processo. This utility wraps
 * <code>it.servizidigitali.gestioneprocessi.service.impl.ProcessoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProcessoLocalService
 * @generated
 */
public class ProcessoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestioneprocessi.service.impl.ProcessoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the processo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcessoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param processo the processo
	 * @return the processo that was added
	 */
	public static Processo addProcesso(Processo processo) {
		return getService().addProcesso(processo);
	}

	public static List<Processo> cerca(
			String nome, java.util.Date dataInserimentoDa,
			java.util.Date dataInserimentoA, int delta, int cur,
			String orderByCol, String orderByType)
		throws PortalException {

		return getService().cerca(
			nome, dataInserimentoDa, dataInserimentoA, delta, cur, orderByCol,
			orderByType);
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
	 * Creates a new processo with the primary key. Does not add the processo to the database.
	 *
	 * @param processoId the primary key for the new processo
	 * @return the new processo
	 */
	public static Processo createProcesso(long processoId) {
		return getService().createProcesso(processoId);
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
	 * Deletes the processo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcessoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo that was removed
	 * @throws PortalException if a processo with the primary key could not be found
	 */
	public static Processo deleteProcesso(long processoId)
		throws PortalException {

		return getService().deleteProcesso(processoId);
	}

	/**
	 * Deletes the processo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcessoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param processo the processo
	 * @return the processo that was removed
	 */
	public static Processo deleteProcesso(Processo processo) {
		return getService().deleteProcesso(processo);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocessi.model.impl.ProcessoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocessi.model.impl.ProcessoModelImpl</code>.
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

	public static Processo fetchProcesso(long processoId) {
		return getService().fetchProcesso(processoId);
	}

	/**
	 * Returns the processo matching the UUID and group.
	 *
	 * @param uuid the processo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public static Processo fetchProcessoByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProcessoByUuidAndGroupId(uuid, groupId);
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
	 * Returns the processo with the primary key.
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo
	 * @throws PortalException if a processo with the primary key could not be found
	 */
	public static Processo getProcesso(long processoId) throws PortalException {
		return getService().getProcesso(processoId);
	}

	public static Processo getProcessoByCodice(String codice)
		throws it.servizidigitali.gestioneprocessi.exception.
			NoSuchProcessoException {

		return getService().getProcessoByCodice(codice);
	}

	/**
	 * Returns the processo matching the UUID and group.
	 *
	 * @param uuid the processo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching processo
	 * @throws PortalException if a matching processo could not be found
	 */
	public static Processo getProcessoByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProcessoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the processos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocessi.model.impl.ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of processos
	 */
	public static List<Processo> getProcessos(int start, int end) {
		return getService().getProcessos(start, end);
	}

	/**
	 * Returns all the processos matching the UUID and company.
	 *
	 * @param uuid the UUID of the processos
	 * @param companyId the primary key of the company
	 * @return the matching processos, or an empty list if no matches were found
	 */
	public static List<Processo> getProcessosByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProcessosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of processos matching the UUID and company.
	 *
	 * @param uuid the UUID of the processos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching processos, or an empty list if no matches were found
	 */
	public static List<Processo> getProcessosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Processo> orderByComparator) {

		return getService().getProcessosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of processos.
	 *
	 * @return the number of processos
	 */
	public static int getProcessosCount() {
		return getService().getProcessosCount();
	}

	/**
	 * Updates the processo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcessoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param processo the processo
	 * @return the processo that was updated
	 */
	public static Processo updateProcesso(Processo processo) {
		return getService().updateProcesso(processo);
	}

	public static ProcessoLocalService getService() {
		return _service;
	}

	private static volatile ProcessoLocalService _service;

}