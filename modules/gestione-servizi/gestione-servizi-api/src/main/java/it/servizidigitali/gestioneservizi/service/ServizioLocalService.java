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

import it.servizidigitali.gestioneservizi.model.Servizio;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Servizio. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ServizioLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.servizidigitali.gestioneservizi.service.impl.ServizioLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the servizio local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ServizioLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the servizio to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizio the servizio
	 * @return the servizio that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Servizio addServizio(Servizio servizio);

	public void addTipologiaServizio(long tipologiaId, long servizioId);

	public void addTipologiaServizio(long tipologiaId, Servizio servizio);

	public void addTipologiaServizios(
		long tipologiaId, List<Servizio> servizios);

	public void addTipologiaServizios(long tipologiaId, long[] servizioIds);

	public Servizio aggiornaServizio(Servizio servizioDaAggiornare)
		throws Exception;

	public void clearTipologiaServizios(long tipologiaId);

	public int count(String nome, String codice, Boolean soloServiziAttivi);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new servizio with the primary key. Does not add the servizio to the database.
	 *
	 * @param servizioId the primary key for the new servizio
	 * @return the new servizio
	 */
	@Transactional(enabled = false)
	public Servizio createServizio(long servizioId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the servizio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio that was removed
	 * @throws PortalException if a servizio with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Servizio deleteServizio(long servizioId) throws PortalException;

	/**
	 * Deletes the servizio from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizio the servizio
	 * @return the servizio that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Servizio deleteServizio(Servizio servizio);

	public void deleteTipologiaServizio(long tipologiaId, long servizioId);

	public void deleteTipologiaServizio(long tipologiaId, Servizio servizio);

	public void deleteTipologiaServizios(
		long tipologiaId, List<Servizio> servizios);

	public void deleteTipologiaServizios(long tipologiaId, long[] servizioIds);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.ServizioModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.ServizioModelImpl</code>.
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
	public Servizio fetchServizio(long servizioId);

	/**
	 * Returns the servizio matching the UUID and group.
	 *
	 * @param uuid the servizio's UUID
	 * @param groupId the primary key of the group
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Servizio fetchServizioByUuidAndGroupId(String uuid, long groupId);

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
	 * Returns the servizio with the primary key.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio
	 * @throws PortalException if a servizio with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Servizio getServizio(long servizioId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Servizio getServizioByCodice(String codice);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Servizio getServizioById(Long servizioId) throws Exception;

	/**
	 * Returns the servizio matching the UUID and group.
	 *
	 * @param uuid the servizio's UUID
	 * @param groupId the primary key of the group
	 * @return the matching servizio
	 * @throws PortalException if a matching servizio could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Servizio getServizioByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneservizi.model.impl.ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of servizios
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Servizio> getServizios(int start, int end);

	/**
	 * Returns all the servizios matching the UUID and company.
	 *
	 * @param uuid the UUID of the servizios
	 * @param companyId the primary key of the company
	 * @return the matching servizios, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Servizio> getServiziosByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of servizios matching the UUID and company.
	 *
	 * @param uuid the UUID of the servizios
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching servizios, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Servizio> getServiziosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Servizio> orderByComparator);

	/**
	 * Returns the number of servizios.
	 *
	 * @return the number of servizios
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getServiziosCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Servizio> getServiziUtilizzabili(
		List<Object> listaServiziEnte, String nome, long areaTematicaId,
		long tipologiaId, int cur, int delta, String orderByCol,
		String orderByType);

	/**
	 * Returns the tipologiaIds of the tipologias associated with the servizio.
	 *
	 * @param servizioId the servizioId of the servizio
	 * @return long[] the tipologiaIds of tipologias associated with the servizio
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getTipologiaPrimaryKeys(long servizioId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Servizio> getTipologiaServizios(long tipologiaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Servizio> getTipologiaServizios(
		long tipologiaId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Servizio> getTipologiaServizios(
		long tipologiaId, int start, int end,
		OrderByComparator<Servizio> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTipologiaServiziosCount(long tipologiaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasTipologiaServizio(long tipologiaId, long servizioId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasTipologiaServizios(long tipologiaId);

	public List<Servizio> listaServiziAttivi(
			Boolean attivo, Integer start, Integer end)
		throws Exception;

	/**
	 * @param nome
	 * @param codice
	 * @param soloServiziAttivi
	 * @param cur: pagina attuale
	 * @param delta: numero elementi per pagina
	 * @param nomeOrdinamento
	 * @param direzioneOrdinamento
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Servizio> searchServizio(
			String nome, String codice, Boolean soloServiziAttivi, int inizio,
			int fine, OrderByComparator<Servizio> ordine)
		throws Exception;

	public void setTipologiaServizios(long tipologiaId, long[] servizioIds);

	/**
	 * Updates the servizio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServizioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param servizio the servizio
	 * @return the servizio that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Servizio updateServizio(Servizio servizio);

}