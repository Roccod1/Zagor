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

import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for IstanzaForm. This utility wraps
 * <code>it.servizidigitali.scrivaniaoperatore.service.impl.IstanzaFormLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see IstanzaFormLocalService
 * @generated
 */
public class IstanzaFormLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.scrivaniaoperatore.service.impl.IstanzaFormLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the istanza form to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IstanzaFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param istanzaForm the istanza form
	 * @return the istanza form that was added
	 */
	public static IstanzaForm addIstanzaForm(IstanzaForm istanzaForm) {
		return getService().addIstanzaForm(istanzaForm);
	}

	/**
	 * Creates a new istanza form with the primary key. Does not add the istanza form to the database.
	 *
	 * @param istanzaFormId the primary key for the new istanza form
	 * @return the new istanza form
	 */
	public static IstanzaForm createIstanzaForm(long istanzaFormId) {
		return getService().createIstanzaForm(istanzaFormId);
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
	 * Deletes the istanza form from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IstanzaFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param istanzaForm the istanza form
	 * @return the istanza form that was removed
	 */
	public static IstanzaForm deleteIstanzaForm(IstanzaForm istanzaForm) {
		return getService().deleteIstanzaForm(istanzaForm);
	}

	/**
	 * Deletes the istanza form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IstanzaFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form that was removed
	 * @throws PortalException if a istanza form with the primary key could not be found
	 */
	public static IstanzaForm deleteIstanzaForm(long istanzaFormId)
		throws PortalException {

		return getService().deleteIstanzaForm(istanzaFormId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.IstanzaFormModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.IstanzaFormModelImpl</code>.
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

	public static IstanzaForm fetchIstanzaForm(long istanzaFormId) {
		return getService().fetchIstanzaForm(istanzaFormId);
	}

	/**
	 * Returns the istanza form matching the UUID and group.
	 *
	 * @param uuid the istanza form's UUID
	 * @param groupId the primary key of the group
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public static IstanzaForm fetchIstanzaFormByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchIstanzaFormByUuidAndGroupId(uuid, groupId);
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
	 * Returns the istanza form with the primary key.
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form
	 * @throws PortalException if a istanza form with the primary key could not be found
	 */
	public static IstanzaForm getIstanzaForm(long istanzaFormId)
		throws PortalException {

		return getService().getIstanzaForm(istanzaFormId);
	}

	public static IstanzaForm getIstanzaFormByRichiestaIdFormId(
		long richiestaId, long formId) {

		return getService().getIstanzaFormByRichiestaIdFormId(
			richiestaId, formId);
	}

	/**
	 * Returns the istanza form matching the UUID and group.
	 *
	 * @param uuid the istanza form's UUID
	 * @param groupId the primary key of the group
	 * @return the matching istanza form
	 * @throws PortalException if a matching istanza form could not be found
	 */
	public static IstanzaForm getIstanzaFormByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getIstanzaFormByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the istanza forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of istanza forms
	 */
	public static List<IstanzaForm> getIstanzaForms(int start, int end) {
		return getService().getIstanzaForms(start, end);
	}

	/**
	 * Returns all the istanza forms matching the UUID and company.
	 *
	 * @param uuid the UUID of the istanza forms
	 * @param companyId the primary key of the company
	 * @return the matching istanza forms, or an empty list if no matches were found
	 */
	public static List<IstanzaForm> getIstanzaFormsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getIstanzaFormsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of istanza forms matching the UUID and company.
	 *
	 * @param uuid the UUID of the istanza forms
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching istanza forms, or an empty list if no matches were found
	 */
	public static List<IstanzaForm> getIstanzaFormsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator) {

		return getService().getIstanzaFormsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of istanza forms.
	 *
	 * @return the number of istanza forms
	 */
	public static int getIstanzaFormsCount() {
		return getService().getIstanzaFormsCount();
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
	 * Updates the istanza form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IstanzaFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param istanzaForm the istanza form
	 * @return the istanza form that was updated
	 */
	public static IstanzaForm updateIstanzaForm(IstanzaForm istanzaForm) {
		return getService().updateIstanzaForm(istanzaForm);
	}

	public static IstanzaFormLocalService getService() {
		return _service;
	}

	private static volatile IstanzaFormLocalService _service;

}