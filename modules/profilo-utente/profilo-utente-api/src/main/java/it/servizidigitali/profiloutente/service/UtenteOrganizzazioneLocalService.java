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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.profiloutente.model.UtenteOrganizzazione;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazionePK;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for UtenteOrganizzazione. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazioneLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface UtenteOrganizzazioneLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.servizidigitali.profiloutente.service.impl.UtenteOrganizzazioneLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the utente organizzazione local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link UtenteOrganizzazioneLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public UtenteOrganizzazione addUtenteOrganizzazione(
		UtenteOrganizzazione utenteOrganizzazione);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new utente organizzazione with the primary key. Does not add the utente organizzazione to the database.
	 *
	 * @param utenteOrganizzazionePK the primary key for the new utente organizzazione
	 * @return the new utente organizzazione
	 */
	@Transactional(enabled = false)
	public UtenteOrganizzazione createUtenteOrganizzazione(
		UtenteOrganizzazionePK utenteOrganizzazionePK);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public UtenteOrganizzazione deleteUtenteOrganizzazione(
		UtenteOrganizzazione utenteOrganizzazione);

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
	@Indexable(type = IndexableType.DELETE)
	public UtenteOrganizzazione deleteUtenteOrganizzazione(
			UtenteOrganizzazionePK utenteOrganizzazionePK)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UtenteOrganizzazione fetchUtenteOrganizzazione(
		UtenteOrganizzazionePK utenteOrganizzazionePK);

	/**
	 * Returns the utente organizzazione matching the UUID and group.
	 *
	 * @param uuid the utente organizzazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UtenteOrganizzazione fetchUtenteOrganizzazioneByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UtenteOrganizzazione> getByUtenteOrganizzazionePreferito(
			long userId, long organizationId, boolean preferito)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UtenteOrganizzazione> getByUtentePreferito(
			long userId, boolean preferito)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UtenteOrganizzazione> getOrganizzazioniUtenteConfigurate(
			Long utenteId)
		throws Exception;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the utente organizzazione with the primary key.
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione
	 * @throws PortalException if a utente organizzazione with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UtenteOrganizzazione getUtenteOrganizzazione(
			UtenteOrganizzazionePK utenteOrganizzazionePK)
		throws PortalException;

	/**
	 * Returns the utente organizzazione matching the UUID and group.
	 *
	 * @param uuid the utente organizzazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching utente organizzazione
	 * @throws PortalException if a matching utente organizzazione could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UtenteOrganizzazione getUtenteOrganizzazioneByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UtenteOrganizzazione> getUtenteOrganizzaziones(
		int start, int end);

	/**
	 * Returns all the utente organizzaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the utente organizzaziones
	 * @param companyId the primary key of the company
	 * @return the matching utente organizzaziones, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UtenteOrganizzazione>
		getUtenteOrganizzazionesByUuidAndCompanyId(String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UtenteOrganizzazione>
		getUtenteOrganizzazionesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<UtenteOrganizzazione> orderByComparator);

	/**
	 * Returns the number of utente organizzaziones.
	 *
	 * @return the number of utente organizzaziones
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUtenteOrganizzazionesCount();

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
	@Indexable(type = IndexableType.REINDEX)
	public UtenteOrganizzazione updateUtenteOrganizzazione(
		UtenteOrganizzazione utenteOrganizzazione);

}