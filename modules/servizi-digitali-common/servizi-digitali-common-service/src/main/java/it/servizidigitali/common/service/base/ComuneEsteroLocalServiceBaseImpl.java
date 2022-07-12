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

package it.servizidigitali.common.service.base;

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

import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneEsteroLocalServiceUtil;
import it.servizidigitali.common.service.persistence.ComuneEsteroPersistence;
import it.servizidigitali.common.service.persistence.ComunePersistence;
import it.servizidigitali.common.service.persistence.ProvinciaPersistence;
import it.servizidigitali.common.service.persistence.StatoEsteroPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the comune estero local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.servizidigitali.common.service.impl.ComuneEsteroLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.servizidigitali.common.service.impl.ComuneEsteroLocalServiceImpl
 * @generated
 */
public abstract class ComuneEsteroLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, ComuneEsteroLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ComuneEsteroLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ComuneEsteroLocalServiceUtil</code>.
	 */

	/**
	 * Adds the comune estero to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComuneEsteroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comuneEstero the comune estero
	 * @return the comune estero that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ComuneEstero addComuneEstero(ComuneEstero comuneEstero) {
		comuneEstero.setNew(true);

		return comuneEsteroPersistence.update(comuneEstero);
	}

	/**
	 * Creates a new comune estero with the primary key. Does not add the comune estero to the database.
	 *
	 * @param comuneEsteroId the primary key for the new comune estero
	 * @return the new comune estero
	 */
	@Override
	@Transactional(enabled = false)
	public ComuneEstero createComuneEstero(long comuneEsteroId) {
		return comuneEsteroPersistence.create(comuneEsteroId);
	}

	/**
	 * Deletes the comune estero with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComuneEsteroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero that was removed
	 * @throws PortalException if a comune estero with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ComuneEstero deleteComuneEstero(long comuneEsteroId)
		throws PortalException {

		return comuneEsteroPersistence.remove(comuneEsteroId);
	}

	/**
	 * Deletes the comune estero from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComuneEsteroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comuneEstero the comune estero
	 * @return the comune estero that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ComuneEstero deleteComuneEstero(ComuneEstero comuneEstero) {
		return comuneEsteroPersistence.remove(comuneEstero);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return comuneEsteroPersistence.dslQuery(dslQuery);
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
			ComuneEstero.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return comuneEsteroPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.common.model.impl.ComuneEsteroModelImpl</code>.
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

		return comuneEsteroPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.common.model.impl.ComuneEsteroModelImpl</code>.
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

		return comuneEsteroPersistence.findWithDynamicQuery(
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
		return comuneEsteroPersistence.countWithDynamicQuery(dynamicQuery);
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

		return comuneEsteroPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ComuneEstero fetchComuneEstero(long comuneEsteroId) {
		return comuneEsteroPersistence.fetchByPrimaryKey(comuneEsteroId);
	}

	/**
	 * Returns the comune estero with the primary key.
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero
	 * @throws PortalException if a comune estero with the primary key could not be found
	 */
	@Override
	public ComuneEstero getComuneEstero(long comuneEsteroId)
		throws PortalException {

		return comuneEsteroPersistence.findByPrimaryKey(comuneEsteroId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(comuneEsteroLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ComuneEstero.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("comuneEsteroId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			comuneEsteroLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ComuneEstero.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"comuneEsteroId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(comuneEsteroLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ComuneEstero.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("comuneEsteroId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return comuneEsteroPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return comuneEsteroLocalService.deleteComuneEstero(
			(ComuneEstero)persistedModel);
	}

	@Override
	public BasePersistence<ComuneEstero> getBasePersistence() {
		return comuneEsteroPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return comuneEsteroPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the comune esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.common.model.impl.ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @return the range of comune esteros
	 */
	@Override
	public List<ComuneEstero> getComuneEsteros(int start, int end) {
		return comuneEsteroPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of comune esteros.
	 *
	 * @return the number of comune esteros
	 */
	@Override
	public int getComuneEsterosCount() {
		return comuneEsteroPersistence.countAll();
	}

	/**
	 * Updates the comune estero in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComuneEsteroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comuneEstero the comune estero
	 * @return the comune estero that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ComuneEstero updateComuneEstero(ComuneEstero comuneEstero) {
		return comuneEsteroPersistence.update(comuneEstero);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ComuneEsteroLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		comuneEsteroLocalService = (ComuneEsteroLocalService)aopProxy;

		_setLocalServiceUtilService(comuneEsteroLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ComuneEsteroLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ComuneEstero.class;
	}

	protected String getModelClassName() {
		return ComuneEstero.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = comuneEsteroPersistence.getDataSource();

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
		ComuneEsteroLocalService comuneEsteroLocalService) {

		try {
			Field field = ComuneEsteroLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, comuneEsteroLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ComunePersistence comunePersistence;

	protected ComuneEsteroLocalService comuneEsteroLocalService;

	@Reference
	protected ComuneEsteroPersistence comuneEsteroPersistence;

	@Reference
	protected ProvinciaPersistence provinciaPersistence;

	@Reference
	protected StatoEsteroPersistence statoEsteroPersistence;

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