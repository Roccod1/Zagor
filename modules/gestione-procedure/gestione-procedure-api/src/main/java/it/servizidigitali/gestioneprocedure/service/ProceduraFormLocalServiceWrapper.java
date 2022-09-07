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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProceduraFormLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProceduraFormLocalService
 * @generated
 */
public class ProceduraFormLocalServiceWrapper
	implements ProceduraFormLocalService,
			   ServiceWrapper<ProceduraFormLocalService> {

	public ProceduraFormLocalServiceWrapper() {
		this(null);
	}

	public ProceduraFormLocalServiceWrapper(
		ProceduraFormLocalService proceduraFormLocalService) {

		_proceduraFormLocalService = proceduraFormLocalService;
	}

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
	@Override
	public it.servizidigitali.gestioneprocedure.model.ProceduraForm
		addProceduraForm(
			it.servizidigitali.gestioneprocedure.model.ProceduraForm
				proceduraForm) {

		return _proceduraFormLocalService.addProceduraForm(proceduraForm);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraFormLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new procedura form with the primary key. Does not add the procedura form to the database.
	 *
	 * @param proceduraFormPK the primary key for the new procedura form
	 * @return the new procedura form
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.ProceduraForm
		createProceduraForm(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK) {

		return _proceduraFormLocalService.createProceduraForm(proceduraFormPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraFormLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public it.servizidigitali.gestioneprocedure.model.ProceduraForm
		deleteProceduraForm(
			it.servizidigitali.gestioneprocedure.model.ProceduraForm
				proceduraForm) {

		return _proceduraFormLocalService.deleteProceduraForm(proceduraForm);
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
	@Override
	public it.servizidigitali.gestioneprocedure.model.ProceduraForm
			deleteProceduraForm(
				it.servizidigitali.gestioneprocedure.service.persistence.
					ProceduraFormPK proceduraFormPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraFormLocalService.deleteProceduraForm(proceduraFormPK);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _proceduraFormLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _proceduraFormLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _proceduraFormLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _proceduraFormLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _proceduraFormLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _proceduraFormLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _proceduraFormLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _proceduraFormLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.gestioneprocedure.model.ProceduraForm
		fetchProceduraForm(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK) {

		return _proceduraFormLocalService.fetchProceduraForm(proceduraFormPK);
	}

	/**
	 * Returns the procedura form with the matching UUID and company.
	 *
	 * @param uuid the procedura form's UUID
	 * @param companyId the primary key of the company
	 * @return the matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.ProceduraForm
		fetchProceduraFormByUuidAndCompanyId(String uuid, long companyId) {

		return _proceduraFormLocalService.fetchProceduraFormByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _proceduraFormLocalService.getActionableDynamicQuery();
	}

	@Override
	public String getFormIntegrativiProcedura(long idProcedura)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraFormLocalService.getFormIntegrativiProcedura(
			idProcedura);
	}

	@Override
	public long getFormPrincipaleProcedura(long idProcedura) {
		return _proceduraFormLocalService.getFormPrincipaleProcedura(
			idProcedura);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _proceduraFormLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _proceduraFormLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraFormLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the procedura form with the primary key.
	 *
	 * @param proceduraFormPK the primary key of the procedura form
	 * @return the procedura form
	 * @throws PortalException if a procedura form with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.ProceduraForm
			getProceduraForm(
				it.servizidigitali.gestioneprocedure.service.persistence.
					ProceduraFormPK proceduraFormPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraFormLocalService.getProceduraForm(proceduraFormPK);
	}

	/**
	 * Returns the procedura form with the matching UUID and company.
	 *
	 * @param uuid the procedura form's UUID
	 * @param companyId the primary key of the company
	 * @return the matching procedura form
	 * @throws PortalException if a matching procedura form could not be found
	 */
	@Override
	public it.servizidigitali.gestioneprocedure.model.ProceduraForm
			getProceduraFormByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduraFormLocalService.getProceduraFormByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List
		<it.servizidigitali.gestioneprocedure.model.ProceduraForm>
			getProceduraForms(int start, int end) {

		return _proceduraFormLocalService.getProceduraForms(start, end);
	}

	/**
	 * Returns the number of procedura forms.
	 *
	 * @return the number of procedura forms
	 */
	@Override
	public int getProceduraFormsCount() {
		return _proceduraFormLocalService.getProceduraFormsCount();
	}

	@Override
	public void salvaListaFormIntegrativi(
		String[] listaFormIntegrativi, long idProcedura) {

		_proceduraFormLocalService.salvaListaFormIntegrativi(
			listaFormIntegrativi, idProcedura);
	}

	@Override
	public it.servizidigitali.gestioneprocedure.model.ProceduraForm
		salvaProceduraFormPrincipale(long idFormPrincipale, long idProcedura) {

		return _proceduraFormLocalService.salvaProceduraFormPrincipale(
			idFormPrincipale, idProcedura);
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
	@Override
	public it.servizidigitali.gestioneprocedure.model.ProceduraForm
		updateProceduraForm(
			it.servizidigitali.gestioneprocedure.model.ProceduraForm
				proceduraForm) {

		return _proceduraFormLocalService.updateProceduraForm(proceduraForm);
	}

	@Override
	public ProceduraFormLocalService getWrappedService() {
		return _proceduraFormLocalService;
	}

	@Override
	public void setWrappedService(
		ProceduraFormLocalService proceduraFormLocalService) {

		_proceduraFormLocalService = proceduraFormLocalService;
	}

	private ProceduraFormLocalService _proceduraFormLocalService;

}