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

package it.servizidigitali.gestionecomunicazioni.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione;
import it.servizidigitali.gestionecomunicazioni.service.TipologiaComunicazioneLocalService;
import it.servizidigitali.gestionecomunicazioni.service.TipologiaComunicazioneLocalServiceUtil;
import it.servizidigitali.gestionecomunicazioni.service.persistence.ComunicazionePersistence;
import it.servizidigitali.gestionecomunicazioni.service.persistence.TipologiaComunicazionePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the tipologia comunicazione local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.servizidigitali.gestionecomunicazioni.service.impl.TipologiaComunicazioneLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.servizidigitali.gestionecomunicazioni.service.impl.TipologiaComunicazioneLocalServiceImpl
 * @generated
 */
public abstract class TipologiaComunicazioneLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   TipologiaComunicazioneLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TipologiaComunicazioneLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>TipologiaComunicazioneLocalServiceUtil</code>.
	 */

	/**
	 * Adds the tipologia comunicazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologiaComunicazione the tipologia comunicazione
	 * @return the tipologia comunicazione that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TipologiaComunicazione addTipologiaComunicazione(
		TipologiaComunicazione tipologiaComunicazione) {

		tipologiaComunicazione.setNew(true);

		return tipologiaComunicazionePersistence.update(tipologiaComunicazione);
	}

	/**
	 * Creates a new tipologia comunicazione with the primary key. Does not add the tipologia comunicazione to the database.
	 *
	 * @param tipologiaComunicazioneId the primary key for the new tipologia comunicazione
	 * @return the new tipologia comunicazione
	 */
	@Override
	@Transactional(enabled = false)
	public TipologiaComunicazione createTipologiaComunicazione(
		long tipologiaComunicazioneId) {

		return tipologiaComunicazionePersistence.create(
			tipologiaComunicazioneId);
	}

	/**
	 * Deletes the tipologia comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologiaComunicazioneId the primary key of the tipologia comunicazione
	 * @return the tipologia comunicazione that was removed
	 * @throws PortalException if a tipologia comunicazione with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TipologiaComunicazione deleteTipologiaComunicazione(
			long tipologiaComunicazioneId)
		throws PortalException {

		return tipologiaComunicazionePersistence.remove(
			tipologiaComunicazioneId);
	}

	/**
	 * Deletes the tipologia comunicazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologiaComunicazione the tipologia comunicazione
	 * @return the tipologia comunicazione that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TipologiaComunicazione deleteTipologiaComunicazione(
		TipologiaComunicazione tipologiaComunicazione) {

		return tipologiaComunicazionePersistence.remove(tipologiaComunicazione);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return tipologiaComunicazionePersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			TipologiaComunicazione.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return tipologiaComunicazionePersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.TipologiaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return tipologiaComunicazionePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.TipologiaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return tipologiaComunicazionePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return tipologiaComunicazionePersistence.countWithDynamicQuery(
			dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return tipologiaComunicazionePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public TipologiaComunicazione fetchTipologiaComunicazione(
		long tipologiaComunicazioneId) {

		return tipologiaComunicazionePersistence.fetchByPrimaryKey(
			tipologiaComunicazioneId);
	}

	/**
	 * Returns the tipologia comunicazione with the primary key.
	 *
	 * @param tipologiaComunicazioneId the primary key of the tipologia comunicazione
	 * @return the tipologia comunicazione
	 * @throws PortalException if a tipologia comunicazione with the primary key could not be found
	 */
	@Override
	public TipologiaComunicazione getTipologiaComunicazione(
			long tipologiaComunicazioneId)
		throws PortalException {

		return tipologiaComunicazionePersistence.findByPrimaryKey(
			tipologiaComunicazioneId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			tipologiaComunicazioneLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TipologiaComunicazione.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"tipologiaComunicazioneId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			tipologiaComunicazioneLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			TipologiaComunicazione.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"tipologiaComunicazioneId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			tipologiaComunicazioneLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TipologiaComunicazione.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"tipologiaComunicazioneId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return tipologiaComunicazionePersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return tipologiaComunicazioneLocalService.deleteTipologiaComunicazione(
			(TipologiaComunicazione)persistedModel);
	}

	@Override
	public BasePersistence<TipologiaComunicazione> getBasePersistence() {
		return tipologiaComunicazionePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return tipologiaComunicazionePersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the tipologia comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestionecomunicazioni.model.impl.TipologiaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia comunicaziones
	 * @param end the upper bound of the range of tipologia comunicaziones (not inclusive)
	 * @return the range of tipologia comunicaziones
	 */
	@Override
	public List<TipologiaComunicazione> getTipologiaComunicaziones(
		int start, int end) {

		return tipologiaComunicazionePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of tipologia comunicaziones.
	 *
	 * @return the number of tipologia comunicaziones
	 */
	@Override
	public int getTipologiaComunicazionesCount() {
		return tipologiaComunicazionePersistence.countAll();
	}

	/**
	 * Updates the tipologia comunicazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipologiaComunicazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipologiaComunicazione the tipologia comunicazione
	 * @return the tipologia comunicazione that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TipologiaComunicazione updateTipologiaComunicazione(
		TipologiaComunicazione tipologiaComunicazione) {

		return tipologiaComunicazionePersistence.update(tipologiaComunicazione);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			TipologiaComunicazioneLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		tipologiaComunicazioneLocalService =
			(TipologiaComunicazioneLocalService)aopProxy;

		_setLocalServiceUtilService(tipologiaComunicazioneLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TipologiaComunicazioneLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TipologiaComunicazione.class;
	}

	protected String getModelClassName() {
		return TipologiaComunicazione.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				tipologiaComunicazionePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		TipologiaComunicazioneLocalService tipologiaComunicazioneLocalService) {

		try {
			Field field =
				TipologiaComunicazioneLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, tipologiaComunicazioneLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ComunicazionePersistence comunicazionePersistence;

	protected TipologiaComunicazioneLocalService
		tipologiaComunicazioneLocalService;

	@Reference
	protected TipologiaComunicazionePersistence
		tipologiaComunicazionePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}