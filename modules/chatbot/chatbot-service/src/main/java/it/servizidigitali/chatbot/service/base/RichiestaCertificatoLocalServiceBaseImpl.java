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

package it.servizidigitali.chatbot.service.base;

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

import it.servizidigitali.chatbot.model.RichiestaCertificato;
import it.servizidigitali.chatbot.service.RichiestaCertificatoLocalService;
import it.servizidigitali.chatbot.service.RichiestaCertificatoLocalServiceUtil;
import it.servizidigitali.chatbot.service.persistence.RichiestaCertificatoPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the richiesta certificato local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.servizidigitali.chatbot.service.impl.RichiestaCertificatoLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.servizidigitali.chatbot.service.impl.RichiestaCertificatoLocalServiceImpl
 * @generated
 */
public abstract class RichiestaCertificatoLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   RichiestaCertificatoLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>RichiestaCertificatoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>RichiestaCertificatoLocalServiceUtil</code>.
	 */

	/**
	 * Adds the richiesta certificato to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaCertificatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaCertificato the richiesta certificato
	 * @return the richiesta certificato that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RichiestaCertificato addRichiestaCertificato(
		RichiestaCertificato richiestaCertificato) {

		richiestaCertificato.setNew(true);

		return richiestaCertificatoPersistence.update(richiestaCertificato);
	}

	/**
	 * Creates a new richiesta certificato with the primary key. Does not add the richiesta certificato to the database.
	 *
	 * @param richiestaCertificatoId the primary key for the new richiesta certificato
	 * @return the new richiesta certificato
	 */
	@Override
	@Transactional(enabled = false)
	public RichiestaCertificato createRichiestaCertificato(
		long richiestaCertificatoId) {

		return richiestaCertificatoPersistence.create(richiestaCertificatoId);
	}

	/**
	 * Deletes the richiesta certificato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaCertificatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato that was removed
	 * @throws PortalException if a richiesta certificato with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public RichiestaCertificato deleteRichiestaCertificato(
			long richiestaCertificatoId)
		throws PortalException {

		return richiestaCertificatoPersistence.remove(richiestaCertificatoId);
	}

	/**
	 * Deletes the richiesta certificato from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaCertificatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaCertificato the richiesta certificato
	 * @return the richiesta certificato that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public RichiestaCertificato deleteRichiestaCertificato(
		RichiestaCertificato richiestaCertificato) {

		return richiestaCertificatoPersistence.remove(richiestaCertificato);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return richiestaCertificatoPersistence.dslQuery(dslQuery);
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
			RichiestaCertificato.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return richiestaCertificatoPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.chatbot.model.impl.RichiestaCertificatoModelImpl</code>.
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

		return richiestaCertificatoPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.chatbot.model.impl.RichiestaCertificatoModelImpl</code>.
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

		return richiestaCertificatoPersistence.findWithDynamicQuery(
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
		return richiestaCertificatoPersistence.countWithDynamicQuery(
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

		return richiestaCertificatoPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public RichiestaCertificato fetchRichiestaCertificato(
		long richiestaCertificatoId) {

		return richiestaCertificatoPersistence.fetchByPrimaryKey(
			richiestaCertificatoId);
	}

	/**
	 * Returns the richiesta certificato matching the UUID and group.
	 *
	 * @param uuid the richiesta certificato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchRichiestaCertificatoByUuidAndGroupId(
		String uuid, long groupId) {

		return richiestaCertificatoPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the richiesta certificato with the primary key.
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato
	 * @throws PortalException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public RichiestaCertificato getRichiestaCertificato(
			long richiestaCertificatoId)
		throws PortalException {

		return richiestaCertificatoPersistence.findByPrimaryKey(
			richiestaCertificatoId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			richiestaCertificatoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(RichiestaCertificato.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"richiestaCertificatoId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			richiestaCertificatoLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			RichiestaCertificato.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"richiestaCertificatoId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			richiestaCertificatoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(RichiestaCertificato.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"richiestaCertificatoId");
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
				<RichiestaCertificato>() {

				@Override
				public void performAction(
						RichiestaCertificato richiestaCertificato)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, richiestaCertificato);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					RichiestaCertificato.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return richiestaCertificatoPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return richiestaCertificatoLocalService.deleteRichiestaCertificato(
			(RichiestaCertificato)persistedModel);
	}

	@Override
	public BasePersistence<RichiestaCertificato> getBasePersistence() {
		return richiestaCertificatoPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return richiestaCertificatoPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the richiesta certificatos matching the UUID and company.
	 *
	 * @param uuid the UUID of the richiesta certificatos
	 * @param companyId the primary key of the company
	 * @return the matching richiesta certificatos, or an empty list if no matches were found
	 */
	@Override
	public List<RichiestaCertificato>
		getRichiestaCertificatosByUuidAndCompanyId(
			String uuid, long companyId) {

		return richiestaCertificatoPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of richiesta certificatos matching the UUID and company.
	 *
	 * @param uuid the UUID of the richiesta certificatos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching richiesta certificatos, or an empty list if no matches were found
	 */
	@Override
	public List<RichiestaCertificato>
		getRichiestaCertificatosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<RichiestaCertificato> orderByComparator) {

		return richiestaCertificatoPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the richiesta certificato matching the UUID and group.
	 *
	 * @param uuid the richiesta certificato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching richiesta certificato
	 * @throws PortalException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato getRichiestaCertificatoByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return richiestaCertificatoPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the richiesta certificatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.chatbot.model.impl.RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> getRichiestaCertificatos(
		int start, int end) {

		return richiestaCertificatoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of richiesta certificatos.
	 *
	 * @return the number of richiesta certificatos
	 */
	@Override
	public int getRichiestaCertificatosCount() {
		return richiestaCertificatoPersistence.countAll();
	}

	/**
	 * Updates the richiesta certificato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RichiestaCertificatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param richiestaCertificato the richiesta certificato
	 * @return the richiesta certificato that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RichiestaCertificato updateRichiestaCertificato(
		RichiestaCertificato richiestaCertificato) {

		return richiestaCertificatoPersistence.update(richiestaCertificato);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			RichiestaCertificatoLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		richiestaCertificatoLocalService =
			(RichiestaCertificatoLocalService)aopProxy;

		_setLocalServiceUtilService(richiestaCertificatoLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return RichiestaCertificatoLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return RichiestaCertificato.class;
	}

	protected String getModelClassName() {
		return RichiestaCertificato.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				richiestaCertificatoPersistence.getDataSource();

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
		RichiestaCertificatoLocalService richiestaCertificatoLocalService) {

		try {
			Field field =
				RichiestaCertificatoLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, richiestaCertificatoLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected RichiestaCertificatoLocalService richiestaCertificatoLocalService;

	@Reference
	protected RichiestaCertificatoPersistence richiestaCertificatoPersistence;

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