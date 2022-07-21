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

package it.servizidigitali.gestioneprocedure.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestioneprocedure.model.ProceduraForm;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProceduraForm. This utility wraps
 * <code>it.servizidigitali.gestioneprocedure.service.impl.ProceduraFormLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProceduraFormLocalService
 * @generated
 */
public class ProceduraFormLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestioneprocedure.service.impl.ProceduraFormLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the procedura form to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduraFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proceduraForm the procedura form
	 * @return the procedura form that was added
	 */
	public static ProceduraForm addProceduraForm(ProceduraForm proceduraForm) {
		return getService().addProceduraForm(proceduraForm);
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
	 * Creates a new procedura form with the primary key. Does not add the procedura form to the database.
	 *
	 * @param proceduraFormPK the primary key for the new procedura form
	 * @return the new procedura form
	 */
	public static ProceduraForm createProceduraForm(
		it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK
			proceduraFormPK) {

		return getService().createProceduraForm(proceduraFormPK);
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
	 * Deletes the procedura form from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduraFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proceduraForm the procedura form
	 * @return the procedura form that was removed
	 */
	public static ProceduraForm deleteProceduraForm(
		ProceduraForm proceduraForm) {

		return getService().deleteProceduraForm(proceduraForm);
	}

	/**
	 * Deletes the procedura form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduraFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proceduraFormPK the primary key of the procedura form
	 * @return the procedura form that was removed
	 * @throws PortalException if a procedura form with the primary key could not be found
	 */
	public static ProceduraForm deleteProceduraForm(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK)
		throws PortalException {

		return getService().deleteProceduraForm(proceduraFormPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.ProceduraFormModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.ProceduraFormModelImpl</code>.
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

	public static ProceduraForm fetchProceduraForm(
		it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK
			proceduraFormPK) {

		return getService().fetchProceduraForm(proceduraFormPK);
	}

	/**
	 * Returns the procedura form with the matching UUID and company.
	 *
	 * @param uuid the procedura form's UUID
	 * @param companyId the primary key of the company
	 * @return the matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	public static ProceduraForm fetchProceduraFormByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchProceduraFormByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the procedura form with the primary key.
	 *
	 * @param proceduraFormPK the primary key of the procedura form
	 * @return the procedura form
	 * @throws PortalException if a procedura form with the primary key could not be found
	 */
	public static ProceduraForm getProceduraForm(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK)
		throws PortalException {

		return getService().getProceduraForm(proceduraFormPK);
	}

	/**
	 * Returns the procedura form with the matching UUID and company.
	 *
	 * @param uuid the procedura form's UUID
	 * @param companyId the primary key of the company
	 * @return the matching procedura form
	 * @throws PortalException if a matching procedura form could not be found
	 */
	public static ProceduraForm getProceduraFormByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getProceduraFormByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the procedura forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @return the range of procedura forms
	 */
	public static List<ProceduraForm> getProceduraForms(int start, int end) {
		return getService().getProceduraForms(start, end);
	}

	/**
	 * Returns the number of procedura forms.
	 *
	 * @return the number of procedura forms
	 */
	public static int getProceduraFormsCount() {
		return getService().getProceduraFormsCount();
	}

	/**
	 * Updates the procedura form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduraFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proceduraForm the procedura form
	 * @return the procedura form that was updated
	 */
	public static ProceduraForm updateProceduraForm(
		ProceduraForm proceduraForm) {

		return getService().updateProceduraForm(proceduraForm);
	}

	public static ProceduraFormLocalService getService() {
		return _service;
	}

	private static volatile ProceduraFormLocalService _service;

}