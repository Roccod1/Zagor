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

package it.servizidigitali.gestioneservizi.service.base;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
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
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
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

import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.gestioneservizi.service.ServizioLocalServiceUtil;
import it.servizidigitali.gestioneservizi.service.persistence.AreaTematicaPersistence;
import it.servizidigitali.gestioneservizi.service.persistence.ServizioPersistence;
import it.servizidigitali.gestioneservizi.service.persistence.TipologiaPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the servizio local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.servizidigitali.gestioneservizi.service.impl.ServizioLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.servizidigitali.gestioneservizi.service.impl.ServizioLocalServiceImpl
 * @generated
 */
public abstract class ServizioLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, ServizioLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ServizioLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ServizioLocalServiceUtil</code>.
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
	@Override
	public Servizio addServizio(Servizio servizio) {
		servizio.setNew(true);

		return servizioPersistence.update(servizio);
	}

	/**
	 * Creates a new servizio with the primary key. Does not add the servizio to the database.
	 *
	 * @param servizioId the primary key for the new servizio
	 * @return the new servizio
	 */
	@Override
	@Transactional(enabled = false)
	public Servizio createServizio(long servizioId) {
		return servizioPersistence.create(servizioId);
	}

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
	@Override
	public Servizio deleteServizio(long servizioId) throws PortalException {
		return servizioPersistence.remove(servizioId);
	}

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
	@Override
	public Servizio deleteServizio(Servizio servizio) {
		return servizioPersistence.remove(servizio);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return servizioPersistence.dslQuery(dslQuery);
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
			Servizio.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return servizioPersistence.findWithDynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return servizioPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return servizioPersistence.findWithDynamicQuery(
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
		return servizioPersistence.countWithDynamicQuery(dynamicQuery);
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

		return servizioPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Servizio fetchServizio(long servizioId) {
		return servizioPersistence.fetchByPrimaryKey(servizioId);
	}

	/**
	 * Returns the servizio matching the UUID and group.
	 *
	 * @param uuid the servizio's UUID
	 * @param groupId the primary key of the group
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchServizioByUuidAndGroupId(String uuid, long groupId) {
		return servizioPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the servizio with the primary key.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio
	 * @throws PortalException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio getServizio(long servizioId) throws PortalException {
		return servizioPersistence.findByPrimaryKey(servizioId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(servizioLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Servizio.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("servizioId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			servizioLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Servizio.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("servizioId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(servizioLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Servizio.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("servizioId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Servizio>() {

				@Override
				public void performAction(Servizio servizio)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, servizio);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Servizio.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return servizioPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return servizioLocalService.deleteServizio((Servizio)persistedModel);
	}

	@Override
	public BasePersistence<Servizio> getBasePersistence() {
		return servizioPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return servizioPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the servizios matching the UUID and company.
	 *
	 * @param uuid the UUID of the servizios
	 * @param companyId the primary key of the company
	 * @return the matching servizios, or an empty list if no matches were found
	 */
	@Override
	public List<Servizio> getServiziosByUuidAndCompanyId(
		String uuid, long companyId) {

		return servizioPersistence.findByUuid_C(uuid, companyId);
	}

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
	@Override
	public List<Servizio> getServiziosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return servizioPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the servizio matching the UUID and group.
	 *
	 * @param uuid the servizio's UUID
	 * @param groupId the primary key of the group
	 * @return the matching servizio
	 * @throws PortalException if a matching servizio could not be found
	 */
	@Override
	public Servizio getServizioByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return servizioPersistence.findByUUID_G(uuid, groupId);
	}

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
	@Override
	public List<Servizio> getServizios(int start, int end) {
		return servizioPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of servizios.
	 *
	 * @return the number of servizios
	 */
	@Override
	public int getServiziosCount() {
		return servizioPersistence.countAll();
	}

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
	@Override
	public Servizio updateServizio(Servizio servizio) {
		return servizioPersistence.update(servizio);
	}

	/**
	 */
	@Override
	public void addTipologiaServizio(long tipologiaId, long servizioId) {
		tipologiaPersistence.addServizio(tipologiaId, servizioId);
	}

	/**
	 */
	@Override
	public void addTipologiaServizio(long tipologiaId, Servizio servizio) {
		tipologiaPersistence.addServizio(tipologiaId, servizio);
	}

	/**
	 */
	@Override
	public void addTipologiaServizios(long tipologiaId, long[] servizioIds) {
		tipologiaPersistence.addServizios(tipologiaId, servizioIds);
	}

	/**
	 */
	@Override
	public void addTipologiaServizios(
		long tipologiaId, List<Servizio> servizios) {

		tipologiaPersistence.addServizios(tipologiaId, servizios);
	}

	/**
	 */
	@Override
	public void clearTipologiaServizios(long tipologiaId) {
		tipologiaPersistence.clearServizios(tipologiaId);
	}

	/**
	 */
	@Override
	public void deleteTipologiaServizio(long tipologiaId, long servizioId) {
		tipologiaPersistence.removeServizio(tipologiaId, servizioId);
	}

	/**
	 */
	@Override
	public void deleteTipologiaServizio(long tipologiaId, Servizio servizio) {
		tipologiaPersistence.removeServizio(tipologiaId, servizio);
	}

	/**
	 */
	@Override
	public void deleteTipologiaServizios(long tipologiaId, long[] servizioIds) {
		tipologiaPersistence.removeServizios(tipologiaId, servizioIds);
	}

	/**
	 */
	@Override
	public void deleteTipologiaServizios(
		long tipologiaId, List<Servizio> servizios) {

		tipologiaPersistence.removeServizios(tipologiaId, servizios);
	}

	/**
	 * Returns the tipologiaIds of the tipologias associated with the servizio.
	 *
	 * @param servizioId the servizioId of the servizio
	 * @return long[] the tipologiaIds of tipologias associated with the servizio
	 */
	@Override
	public long[] getTipologiaPrimaryKeys(long servizioId) {
		return servizioPersistence.getTipologiaPrimaryKeys(servizioId);
	}

	/**
	 */
	@Override
	public List<Servizio> getTipologiaServizios(long tipologiaId) {
		return servizioPersistence.getTipologiaServizios(tipologiaId);
	}

	/**
	 */
	@Override
	public List<Servizio> getTipologiaServizios(
		long tipologiaId, int start, int end) {

		return servizioPersistence.getTipologiaServizios(
			tipologiaId, start, end);
	}

	/**
	 */
	@Override
	public List<Servizio> getTipologiaServizios(
		long tipologiaId, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return servizioPersistence.getTipologiaServizios(
			tipologiaId, start, end, orderByComparator);
	}

	/**
	 */
	@Override
	public int getTipologiaServiziosCount(long tipologiaId) {
		return tipologiaPersistence.getServiziosSize(tipologiaId);
	}

	/**
	 */
	@Override
	public boolean hasTipologiaServizio(long tipologiaId, long servizioId) {
		return tipologiaPersistence.containsServizio(tipologiaId, servizioId);
	}

	/**
	 */
	@Override
	public boolean hasTipologiaServizios(long tipologiaId) {
		return tipologiaPersistence.containsServizios(tipologiaId);
	}

	/**
	 */
	@Override
	public void setTipologiaServizios(long tipologiaId, long[] servizioIds) {
		tipologiaPersistence.setServizios(tipologiaId, servizioIds);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ServizioLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		servizioLocalService = (ServizioLocalService)aopProxy;

		_setLocalServiceUtilService(servizioLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ServizioLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Servizio.class;
	}

	protected String getModelClassName() {
		return Servizio.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = servizioPersistence.getDataSource();

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
		ServizioLocalService servizioLocalService) {

		try {
			Field field = ServizioLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, servizioLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected AreaTematicaPersistence areaTematicaPersistence;

	protected ServizioLocalService servizioLocalService;

	@Reference
	protected ServizioPersistence servizioPersistence;

	@Reference
	protected TipologiaPersistence tipologiaPersistence;

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