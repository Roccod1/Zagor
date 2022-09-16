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

package it.servizidigitali.scrivaniaoperatore.service.base;

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

import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalServiceUtil;
import it.servizidigitali.scrivaniaoperatore.service.persistence.AllegatoRichiestaPersistence;
import it.servizidigitali.scrivaniaoperatore.service.persistence.CommentoRichiestaPersistence;
import it.servizidigitali.scrivaniaoperatore.service.persistence.IstanzaFormPersistence;
import it.servizidigitali.scrivaniaoperatore.service.persistence.RichiestaFinder;
import it.servizidigitali.scrivaniaoperatore.service.persistence.RichiestaPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the richiesta local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.servizidigitali.scrivaniaoperatore.service.impl.RichiestaLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.servizidigitali.scrivaniaoperatore.service.impl.RichiestaLocalServiceImpl
 * @generated
 */
public abstract class RichiestaLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, RichiestaLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>RichiestaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>RichiestaLocalServiceUtil</code>.
	 */

	/**
	 * Adds the richiesta to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiesta the richiesta
	 * @return the richiesta that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Richiesta addRichiesta(Richiesta richiesta) {
		richiesta.setNew(true);

		return richiestaPersistence.update(richiesta);
	}

	/**
	 * Creates a new richiesta with the primary key. Does not add the richiesta to the database.
	 *
	 * @param richiestaId the primary key for the new richiesta
	 * @return the new richiesta
	 */
	@Override
	@Transactional(enabled = false)
	public Richiesta createRichiesta(long richiestaId) {
		return richiestaPersistence.create(richiestaId);
	}

	/**
	 * Deletes the richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta that was removed
	 * @throws PortalException if a richiesta with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Richiesta deleteRichiesta(long richiestaId) throws PortalException {
		return richiestaPersistence.remove(richiestaId);
	}

	/**
	 * Deletes the richiesta from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiesta the richiesta
	 * @return the richiesta that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Richiesta deleteRichiesta(Richiesta richiesta) {
		return richiestaPersistence.remove(richiesta);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return richiestaPersistence.dslQuery(dslQuery);
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
			Richiesta.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return richiestaPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaModelImpl</code>.
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

		return richiestaPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaModelImpl</code>.
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

		return richiestaPersistence.findWithDynamicQuery(
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
		return richiestaPersistence.countWithDynamicQuery(dynamicQuery);
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

		return richiestaPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Richiesta fetchRichiesta(long richiestaId) {
		return richiestaPersistence.fetchByPrimaryKey(richiestaId);
	}

	/**
	 * Returns the richiesta matching the UUID and group.
	 *
	 * @param uuid the richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchRichiestaByUuidAndGroupId(String uuid, long groupId) {
		return richiestaPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the richiesta with the primary key.
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta
	 * @throws PortalException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta getRichiesta(long richiestaId) throws PortalException {
		return richiestaPersistence.findByPrimaryKey(richiestaId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(richiestaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Richiesta.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("richiestaId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			richiestaLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Richiesta.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"richiestaId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(richiestaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Richiesta.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("richiestaId");
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
			new ActionableDynamicQuery.PerformActionMethod<Richiesta>() {

				@Override
				public void performAction(Richiesta richiesta)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, richiesta);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Richiesta.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return richiestaPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return richiestaLocalService.deleteRichiesta((Richiesta)persistedModel);
	}

	@Override
	public BasePersistence<Richiesta> getBasePersistence() {
		return richiestaPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return richiestaPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the richiestas
	 * @param companyId the primary key of the company
	 * @return the matching richiestas, or an empty list if no matches were found
	 */
	@Override
	public List<Richiesta> getRichiestasByUuidAndCompanyId(
		String uuid, long companyId) {

		return richiestaPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the richiestas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching richiestas, or an empty list if no matches were found
	 */
	@Override
	public List<Richiesta> getRichiestasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return richiestaPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the richiesta matching the UUID and group.
	 *
	 * @param uuid the richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching richiesta
	 * @throws PortalException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta getRichiestaByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return richiestaPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of richiestas
	 */
	@Override
	public List<Richiesta> getRichiestas(int start, int end) {
		return richiestaPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of richiestas.
	 *
	 * @return the number of richiestas
	 */
	@Override
	public int getRichiestasCount() {
		return richiestaPersistence.countAll();
	}

	/**
	 * Updates the richiesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiesta the richiesta
	 * @return the richiesta that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Richiesta updateRichiesta(Richiesta richiesta) {
		return richiestaPersistence.update(richiesta);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			RichiestaLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		richiestaLocalService = (RichiestaLocalService)aopProxy;

		_setLocalServiceUtilService(richiestaLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return RichiestaLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Richiesta.class;
	}

	protected String getModelClassName() {
		return Richiesta.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = richiestaPersistence.getDataSource();

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
		RichiestaLocalService richiestaLocalService) {

		try {
			Field field = RichiestaLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, richiestaLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected AllegatoRichiestaPersistence allegatoRichiestaPersistence;

	@Reference
	protected CommentoRichiestaPersistence commentoRichiestaPersistence;

	@Reference
	protected IstanzaFormPersistence istanzaFormPersistence;

	protected RichiestaLocalService richiestaLocalService;

	@Reference
	protected RichiestaPersistence richiestaPersistence;

	@Reference
	protected RichiestaFinder richiestaFinder;

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