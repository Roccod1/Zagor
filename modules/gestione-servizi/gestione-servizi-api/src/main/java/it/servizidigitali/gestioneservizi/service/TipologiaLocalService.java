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

package it.servizidigitali.gestioneservizi.service;

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

import it.servizidigitali.gestioneservizi.model.Tipologia;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Tipologia. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TipologiaLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.servizidigitali.gestioneservizi.service.impl.TipologiaLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the tipologia local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TipologiaLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addServizioTipologia(long servizioId, long tipologiaId);

	public void addServizioTipologia(long servizioId, Tipologia tipologia);

	public void addServizioTipologias(
		long servizioId, List<Tipologia> tipologias);

	public void addServizioTipologias(long servizioId, long[] tipologiaIds);

	/**
	 * Adds the tipologia to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologia the tipologia
	 * @return the tipologia that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Tipologia addTipologia(Tipologia tipologia);

	public void clearServizioTipologias(long servizioId);

	public long count() throws Exception;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new tipologia with the primary key. Does not add the tipologia to the database.
	 *
	 * @param tipologiaId the primary key for the new tipologia
	 * @return the new tipologia
	 */
	@Transactional(enabled = false)
	public Tipologia createTipologia(long tipologiaId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deleteServizioTipologia(long servizioId, long tipologiaId);

	public void deleteServizioTipologia(long servizioId, Tipologia tipologia);

	public void deleteServizioTipologias(
		long servizioId, List<Tipologia> tipologias);

	public void deleteServizioTipologias(long servizioId, long[] tipologiaIds);

	/**
	 * Deletes the tipologia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia that was removed
	 * @throws PortalException if a tipologia with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Tipologia deleteTipologia(long tipologiaId) throws PortalException;

	/**
	 * Deletes the tipologia from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologia the tipologia
	 * @return the tipologia that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Tipologia deleteTipologia(Tipologia tipologia);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.TipologiaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.TipologiaModelImpl</code>.
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
	public Tipologia fetchTipologia(long tipologiaId);

	/**
	 * Returns the tipologia matching the UUID and group.
	 *
	 * @param uuid the tipologia's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Tipologia fetchTipologiaByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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
	 * Returns the servizioIds of the servizios associated with the tipologia.
	 *
	 * @param tipologiaId the tipologiaId of the tipologia
	 * @return long[] the servizioIds of servizios associated with the tipologia
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getServizioPrimaryKeys(long tipologiaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tipologia> getServizioTipologias(long servizioId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tipologia> getServizioTipologias(
		long servizioId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tipologia> getServizioTipologias(
		long servizioId, int start, int end,
		OrderByComparator<Tipologia> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getServizioTipologiasCount(long servizioId);

	/**
	 * Returns the tipologia with the primary key.
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia
	 * @throws PortalException if a tipologia with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Tipologia getTipologia(long tipologiaId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Tipologia getTipologiaByCodice(String codice);

	/**
	 * Returns the tipologia matching the UUID and group.
	 *
	 * @param uuid the tipologia's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipologia
	 * @throws PortalException if a matching tipologia could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Tipologia getTipologiaByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the tipologias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of tipologias
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tipologia> getTipologias(int start, int end);

	/**
	 * Returns all the tipologias matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipologias
	 * @param companyId the primary key of the company
	 * @return the matching tipologias, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tipologia> getTipologiasByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of tipologias matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipologias
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching tipologias, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tipologia> getTipologiasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Tipologia> orderByComparator);

	/**
	 * Returns the number of tipologias.
	 *
	 * @return the number of tipologias
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTipologiasCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tipologia> getTipologie(
		int inizio, int fine, String orderByCol, String orderByType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasServizioTipologia(long servizioId, long tipologiaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasServizioTipologias(long servizioId);

	public Tipologia salvaTipologia(Tipologia tipologia) throws Exception;

	public void setServizioTipologias(long servizioId, long[] tipologiaIds);

	/**
	 * Updates the tipologia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologia the tipologia
	 * @return the tipologia that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Tipologia updateTipologia(Tipologia tipologia);

}