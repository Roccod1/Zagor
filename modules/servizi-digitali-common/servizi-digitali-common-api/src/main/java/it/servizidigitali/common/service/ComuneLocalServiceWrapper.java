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

package it.servizidigitali.common.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ComuneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ComuneLocalService
 * @generated
 */
public class ComuneLocalServiceWrapper
	implements ComuneLocalService, ServiceWrapper<ComuneLocalService> {

	public ComuneLocalServiceWrapper() {
		this(null);
	}

	public ComuneLocalServiceWrapper(ComuneLocalService comuneLocalService) {
		_comuneLocalService = comuneLocalService;
	}

	/**
	 * Adds the comune to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComuneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comune the comune
	 * @return the comune that was added
	 */
	@Override
	public it.servizidigitali.common.model.Comune addComune(
		it.servizidigitali.common.model.Comune comune) {

		return _comuneLocalService.addComune(comune);
	}

	/**
	 * Creates a new comune with the primary key. Does not add the comune to the database.
	 *
	 * @param comuneId the primary key for the new comune
	 * @return the new comune
	 */
	@Override
	public it.servizidigitali.common.model.Comune createComune(long comuneId) {
		return _comuneLocalService.createComune(comuneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuneLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the comune from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComuneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comune the comune
	 * @return the comune that was removed
	 */
	@Override
	public it.servizidigitali.common.model.Comune deleteComune(
		it.servizidigitali.common.model.Comune comune) {

		return _comuneLocalService.deleteComune(comune);
	}

	/**
	 * Deletes the comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComuneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comuneId the primary key of the comune
	 * @return the comune that was removed
	 * @throws PortalException if a comune with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.common.model.Comune deleteComune(long comuneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuneLocalService.deleteComune(comuneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuneLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _comuneLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _comuneLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _comuneLocalService.dynamicQuery();
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

		return _comuneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.common.model.impl.ComuneModelImpl</code>.
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

		return _comuneLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.common.model.impl.ComuneModelImpl</code>.
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

		return _comuneLocalService.dynamicQuery(
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

		return _comuneLocalService.dynamicQueryCount(dynamicQuery);
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

		return _comuneLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.servizidigitali.common.model.Comune fetchComune(long comuneId) {
		return _comuneLocalService.fetchComune(comuneId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _comuneLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the comune with the primary key.
	 *
	 * @param comuneId the primary key of the comune
	 * @return the comune
	 * @throws PortalException if a comune with the primary key could not be found
	 */
	@Override
	public it.servizidigitali.common.model.Comune getComune(long comuneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuneLocalService.getComune(comuneId);
	}

	@Override
	public it.servizidigitali.common.model.Comune getComuneByCodiceCatastale(
		String codiceCatastale) {

		return _comuneLocalService.getComuneByCodiceCatastale(codiceCatastale);
	}

	@Override
	public it.servizidigitali.common.model.Comune getComuneByCodiceISTAT(
		String codiceIstat) {

		return _comuneLocalService.getComuneByCodiceISTAT(codiceIstat);
	}

	@Override
	public it.servizidigitali.common.model.Comune getComuneByDenominazione(
		String denominazione) {

		return _comuneLocalService.getComuneByDenominazione(denominazione);
	}

	/**
	 * Returns a range of all the comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.common.model.impl.ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @return the range of comunes
	 */
	@Override
	public java.util.List<it.servizidigitali.common.model.Comune> getComunes(
		int start, int end) {

		return _comuneLocalService.getComunes(start, end);
	}

	/**
	 * Returns the number of comunes.
	 *
	 * @return the number of comunes
	 */
	@Override
	public int getComunesCount() {
		return _comuneLocalService.getComunesCount();
	}

	@Override
	public java.util.List<it.servizidigitali.common.model.Comune>
		getComuniByIdProvinciaSiglaProvinciaDenominazioneRegione(
			Long idProvincia, String siglaProvincia,
			String denominazioneRegione) {

		return _comuneLocalService.
			getComuniByIdProvinciaSiglaProvinciaDenominazioneRegione(
				idProvincia, siglaProvincia, denominazioneRegione);
	}

	@Override
	public java.util.List<it.servizidigitali.common.model.Comune>
		getComuniByIdRegione(long idRegione) {

		return _comuneLocalService.getComuniByIdRegione(idRegione);
	}

	@Override
	public java.util.List<it.servizidigitali.common.model.Comune>
		getComuniByProvinciaId(long provinciaId) {

		return _comuneLocalService.getComuniByProvinciaId(provinciaId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _comuneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _comuneLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the comune in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComuneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comune the comune
	 * @return the comune that was updated
	 */
	@Override
	public it.servizidigitali.common.model.Comune updateComune(
		it.servizidigitali.common.model.Comune comune) {

		return _comuneLocalService.updateComune(comune);
	}

	@Override
	public ComuneLocalService getWrappedService() {
		return _comuneLocalService;
	}

	@Override
	public void setWrappedService(ComuneLocalService comuneLocalService) {
		_comuneLocalService = comuneLocalService;
	}

	private ComuneLocalService _comuneLocalService;

}