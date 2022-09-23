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

import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalServiceUtil;
import it.servizidigitali.scrivaniaoperatore.service.persistence.AllegatoRichiestaPK;
import it.servizidigitali.scrivaniaoperatore.service.persistence.AllegatoRichiestaPersistence;
import it.servizidigitali.scrivaniaoperatore.service.persistence.AttivitaRichiestaPersistence;
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
 * Provides the base implementation for the allegato richiesta local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.servizidigitali.scrivaniaoperatore.service.impl.AllegatoRichiestaLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.servizidigitali.scrivaniaoperatore.service.impl.AllegatoRichiestaLocalServiceImpl
 * @generated
 */
public abstract class AllegatoRichiestaLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AllegatoRichiestaLocalService, AopService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AllegatoRichiestaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AllegatoRichiestaLocalServiceUtil</code>.
	 */

	/**
	 * Adds the allegato richiesta to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllegatoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allegatoRichiesta the allegato richiesta
	 * @return the allegato richiesta that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AllegatoRichiesta addAllegatoRichiesta(
		AllegatoRichiesta allegatoRichiesta) {

		allegatoRichiesta.setNew(true);

		return allegatoRichiestaPersistence.update(allegatoRichiesta);
	}

	/**
	 * Creates a new allegato richiesta with the primary key. Does not add the allegato richiesta to the database.
	 *
	 * @param allegatoRichiestaPK the primary key for the new allegato richiesta
	 * @return the new allegato richiesta
	 */
	@Override
	@Transactional(enabled = false)
	public AllegatoRichiesta createAllegatoRichiesta(
		AllegatoRichiestaPK allegatoRichiestaPK) {

		return allegatoRichiestaPersistence.create(allegatoRichiestaPK);
	}

	/**
	 * Deletes the allegato richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllegatoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allegatoRichiestaPK the primary key of the allegato richiesta
	 * @return the allegato richiesta that was removed
	 * @throws PortalException if a allegato richiesta with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AllegatoRichiesta deleteAllegatoRichiesta(
			AllegatoRichiestaPK allegatoRichiestaPK)
		throws PortalException {

		return allegatoRichiestaPersistence.remove(allegatoRichiestaPK);
	}

	/**
	 * Deletes the allegato richiesta from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllegatoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allegatoRichiesta the allegato richiesta
	 * @return the allegato richiesta that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AllegatoRichiesta deleteAllegatoRichiesta(
		AllegatoRichiesta allegatoRichiesta) {

		return allegatoRichiestaPersistence.remove(allegatoRichiesta);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return allegatoRichiestaPersistence.dslQuery(dslQuery);
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
			AllegatoRichiesta.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return allegatoRichiestaPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.AllegatoRichiestaModelImpl</code>.
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

		return allegatoRichiestaPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.AllegatoRichiestaModelImpl</code>.
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

		return allegatoRichiestaPersistence.findWithDynamicQuery(
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
		return allegatoRichiestaPersistence.countWithDynamicQuery(dynamicQuery);
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

		return allegatoRichiestaPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public AllegatoRichiesta fetchAllegatoRichiesta(
		AllegatoRichiestaPK allegatoRichiestaPK) {

		return allegatoRichiestaPersistence.fetchByPrimaryKey(
			allegatoRichiestaPK);
	}

	/**
	 * Returns the allegato richiesta matching the UUID and group.
	 *
	 * @param uuid the allegato richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchAllegatoRichiestaByUuidAndGroupId(
		String uuid, long groupId) {

		return allegatoRichiestaPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the allegato richiesta with the primary key.
	 *
	 * @param allegatoRichiestaPK the primary key of the allegato richiesta
	 * @return the allegato richiesta
	 * @throws PortalException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta getAllegatoRichiesta(
			AllegatoRichiestaPK allegatoRichiestaPK)
		throws PortalException {

		return allegatoRichiestaPersistence.findByPrimaryKey(
			allegatoRichiestaPK);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			allegatoRichiestaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AllegatoRichiesta.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.richiestaId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			allegatoRichiestaLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(AllegatoRichiesta.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.richiestaId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			allegatoRichiestaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AllegatoRichiesta.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.richiestaId");
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
			new ActionableDynamicQuery.PerformActionMethod
				<AllegatoRichiesta>() {

				@Override
				public void performAction(AllegatoRichiesta allegatoRichiesta)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, allegatoRichiesta);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(AllegatoRichiesta.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return allegatoRichiestaPersistence.create(
			(AllegatoRichiestaPK)primaryKeyObj);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return allegatoRichiestaLocalService.deleteAllegatoRichiesta(
			(AllegatoRichiesta)persistedModel);
	}

	@Override
	public BasePersistence<AllegatoRichiesta> getBasePersistence() {
		return allegatoRichiestaPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return allegatoRichiestaPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the allegato richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the allegato richiestas
	 * @param companyId the primary key of the company
	 * @return the matching allegato richiestas, or an empty list if no matches were found
	 */
	@Override
	public List<AllegatoRichiesta> getAllegatoRichiestasByUuidAndCompanyId(
		String uuid, long companyId) {

		return allegatoRichiestaPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of allegato richiestas matching the UUID and company.
	 *
	 * @param uuid the UUID of the allegato richiestas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching allegato richiestas, or an empty list if no matches were found
	 */
	@Override
	public List<AllegatoRichiesta> getAllegatoRichiestasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return allegatoRichiestaPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the allegato richiesta matching the UUID and group.
	 *
	 * @param uuid the allegato richiesta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allegato richiesta
	 * @throws PortalException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta getAllegatoRichiestaByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return allegatoRichiestaPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the allegato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> getAllegatoRichiestas(int start, int end) {
		return allegatoRichiestaPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of allegato richiestas.
	 *
	 * @return the number of allegato richiestas
	 */
	@Override
	public int getAllegatoRichiestasCount() {
		return allegatoRichiestaPersistence.countAll();
	}

	/**
	 * Updates the allegato richiesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllegatoRichiestaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allegatoRichiesta the allegato richiesta
	 * @return the allegato richiesta that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AllegatoRichiesta updateAllegatoRichiesta(
		AllegatoRichiesta allegatoRichiesta) {

		return allegatoRichiestaPersistence.update(allegatoRichiesta);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			AllegatoRichiestaLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		allegatoRichiestaLocalService = (AllegatoRichiestaLocalService)aopProxy;

		_setLocalServiceUtilService(allegatoRichiestaLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AllegatoRichiestaLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AllegatoRichiesta.class;
	}

	protected String getModelClassName() {
		return AllegatoRichiesta.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				allegatoRichiestaPersistence.getDataSource();

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
		AllegatoRichiestaLocalService allegatoRichiestaLocalService) {

		try {
			Field field =
				AllegatoRichiestaLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, allegatoRichiestaLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected AllegatoRichiestaLocalService allegatoRichiestaLocalService;

	@Reference
	protected AllegatoRichiestaPersistence allegatoRichiestaPersistence;

	@Reference
	protected AttivitaRichiestaPersistence attivitaRichiestaPersistence;

	@Reference
	protected CommentoRichiestaPersistence commentoRichiestaPersistence;

	@Reference
	protected IstanzaFormPersistence istanzaFormPersistence;

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