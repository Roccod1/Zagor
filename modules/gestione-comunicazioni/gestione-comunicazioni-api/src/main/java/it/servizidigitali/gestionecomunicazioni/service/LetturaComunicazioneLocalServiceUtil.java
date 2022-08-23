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

import it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LetturaComunicazione. This utility wraps
 * <code>it.servizidigitali.gestionecomunicazioni.service.impl.LetturaComunicazioneLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LetturaComunicazioneLocalService
 * @generated
 */
public class LetturaComunicazioneLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.servizidigitali.gestionecomunicazioni.service.impl.LetturaComunicazioneLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the lettura comunicazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LetturaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param letturaComunicazione the lettura comunicazione
	 * @return the lettura comunicazione that was added
	 */
	public static LetturaComunicazione addLetturaComunicazione(
		LetturaComunicazione letturaComunicazione) {

		return getService().addLetturaComunicazione(letturaComunicazione);
	}

	/**
	 * Creates a new lettura comunicazione with the primary key. Does not add the lettura comunicazione to the database.
	 *
	 * @param letturaComunicazionePK the primary key for the new lettura comunicazione
	 * @return the new lettura comunicazione
	 */
	public static LetturaComunicazione createLetturaComunicazione(
		it.servizidigitali.gestionecomunicazioni.service.persistence.
			LetturaComunicazionePK letturaComunicazionePK) {

		return getService().createLetturaComunicazione(letturaComunicazionePK);
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
	 * Deletes the lettura comunicazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LetturaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param letturaComunicazione the lettura comunicazione
	 * @return the lettura comunicazione that was removed
	 */
	public static LetturaComunicazione deleteLetturaComunicazione(
		LetturaComunicazione letturaComunicazione) {

		return getService().deleteLetturaComunicazione(letturaComunicazione);
	}

	/**
	 * Deletes the lettura comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LetturaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione that was removed
	 * @throws PortalException if a lettura comunicazione with the primary key could not be found
	 */
	public static LetturaComunicazione deleteLetturaComunicazione(
			it.servizidigitali.gestionecomunicazioni.service.persistence.
				LetturaComunicazionePK letturaComunicazionePK)
		throws PortalException {

		return getService().deleteLetturaComunicazione(letturaComunicazionePK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.LetturaComunicazioneModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.LetturaComunicazioneModelImpl</code>.
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

	public static LetturaComunicazione fetchLetturaComunicazione(
		it.servizidigitali.gestionecomunicazioni.service.persistence.
			LetturaComunicazionePK letturaComunicazionePK) {

		return getService().fetchLetturaComunicazione(letturaComunicazionePK);
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
	 * Returns the lettura comunicazione with the primary key.
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione
	 * @throws PortalException if a lettura comunicazione with the primary key could not be found
	 */
	public static LetturaComunicazione getLetturaComunicazione(
			it.servizidigitali.gestionecomunicazioni.service.persistence.
				LetturaComunicazionePK letturaComunicazionePK)
		throws PortalException {

		return getService().getLetturaComunicazione(letturaComunicazionePK);
	}

	/**
	 * Returns a range of all the lettura comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.LetturaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lettura comunicaziones
	 * @param end the upper bound of the range of lettura comunicaziones (not inclusive)
	 * @return the range of lettura comunicaziones
	 */
	public static List<LetturaComunicazione> getLetturaComunicaziones(
		int start, int end) {

		return getService().getLetturaComunicaziones(start, end);
	}

	/**
	 * Returns the number of lettura comunicaziones.
	 *
	 * @return the number of lettura comunicaziones
	 */
	public static int getLetturaComunicazionesCount() {
		return getService().getLetturaComunicazionesCount();
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
	 * Updates the lettura comunicazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LetturaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param letturaComunicazione the lettura comunicazione
	 * @return the lettura comunicazione that was updated
	 */
	public static LetturaComunicazione updateLetturaComunicazione(
		LetturaComunicazione letturaComunicazione) {

		return getService().updateLetturaComunicazione(letturaComunicazione);
	}

	public static LetturaComunicazioneLocalService getService() {
		return _service;
	}

	private static volatile LetturaComunicazioneLocalService _service;

}