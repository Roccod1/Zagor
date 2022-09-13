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

package it.servizidigitali.gestioneprocedure.service.base;

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

import it.servizidigitali.gestioneprocedure.model.TemplatePdf;
import it.servizidigitali.gestioneprocedure.service.TemplatePdfLocalService;
import it.servizidigitali.gestioneprocedure.service.TemplatePdfLocalServiceUtil;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFinder;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPersistence;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraPersistence;
import it.servizidigitali.gestioneprocedure.service.persistence.TemplatePdfPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the template pdf local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.servizidigitali.gestioneprocedure.service.impl.TemplatePdfLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.servizidigitali.gestioneprocedure.service.impl.TemplatePdfLocalServiceImpl
 * @generated
 */
public abstract class TemplatePdfLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, TemplatePdfLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TemplatePdfLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>TemplatePdfLocalServiceUtil</code>.
	 */

	/**
	 * Adds the template pdf to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TemplatePdfLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templatePdf the template pdf
	 * @return the template pdf that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TemplatePdf addTemplatePdf(TemplatePdf templatePdf) {
		templatePdf.setNew(true);

		return templatePdfPersistence.update(templatePdf);
	}

	/**
	 * Creates a new template pdf with the primary key. Does not add the template pdf to the database.
	 *
	 * @param templatePdfId the primary key for the new template pdf
	 * @return the new template pdf
	 */
	@Override
	@Transactional(enabled = false)
	public TemplatePdf createTemplatePdf(long templatePdfId) {
		return templatePdfPersistence.create(templatePdfId);
	}

	/**
	 * Deletes the template pdf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TemplatePdfLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf that was removed
	 * @throws PortalException if a template pdf with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TemplatePdf deleteTemplatePdf(long templatePdfId)
		throws PortalException {

		return templatePdfPersistence.remove(templatePdfId);
	}

	/**
	 * Deletes the template pdf from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TemplatePdfLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templatePdf the template pdf
	 * @return the template pdf that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TemplatePdf deleteTemplatePdf(TemplatePdf templatePdf) {
		return templatePdfPersistence.remove(templatePdf);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return templatePdfPersistence.dslQuery(dslQuery);
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
			TemplatePdf.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return templatePdfPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.TemplatePdfModelImpl</code>.
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

		return templatePdfPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.TemplatePdfModelImpl</code>.
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

		return templatePdfPersistence.findWithDynamicQuery(
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
		return templatePdfPersistence.countWithDynamicQuery(dynamicQuery);
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

		return templatePdfPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public TemplatePdf fetchTemplatePdf(long templatePdfId) {
		return templatePdfPersistence.fetchByPrimaryKey(templatePdfId);
	}

	/**
	 * Returns the template pdf with the matching UUID and company.
	 *
	 * @param uuid the template pdf's UUID
	 * @param companyId the primary key of the company
	 * @return the matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchTemplatePdfByUuidAndCompanyId(
		String uuid, long companyId) {

		return templatePdfPersistence.fetchByUuid_C_First(
			uuid, companyId, null);
	}

	/**
	 * Returns the template pdf with the primary key.
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf
	 * @throws PortalException if a template pdf with the primary key could not be found
	 */
	@Override
	public TemplatePdf getTemplatePdf(long templatePdfId)
		throws PortalException {

		return templatePdfPersistence.findByPrimaryKey(templatePdfId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(templatePdfLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TemplatePdf.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("templatePdfId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			templatePdfLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(TemplatePdf.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"templatePdfId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(templatePdfLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TemplatePdf.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("templatePdfId");
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
			new ActionableDynamicQuery.PerformActionMethod<TemplatePdf>() {

				@Override
				public void performAction(TemplatePdf templatePdf)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, templatePdf);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(TemplatePdf.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return templatePdfPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return templatePdfLocalService.deleteTemplatePdf(
			(TemplatePdf)persistedModel);
	}

	@Override
	public BasePersistence<TemplatePdf> getBasePersistence() {
		return templatePdfPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return templatePdfPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the template pdf with the matching UUID and company.
	 *
	 * @param uuid the template pdf's UUID
	 * @param companyId the primary key of the company
	 * @return the matching template pdf
	 * @throws PortalException if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf getTemplatePdfByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return templatePdfPersistence.findByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns a range of all the template pdfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.gestioneprocedure.model.impl.TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of template pdfs
	 */
	@Override
	public List<TemplatePdf> getTemplatePdfs(int start, int end) {
		return templatePdfPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of template pdfs.
	 *
	 * @return the number of template pdfs
	 */
	@Override
	public int getTemplatePdfsCount() {
		return templatePdfPersistence.countAll();
	}

	/**
	 * Updates the template pdf in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TemplatePdfLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templatePdf the template pdf
	 * @return the template pdf that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TemplatePdf updateTemplatePdf(TemplatePdf templatePdf) {
		return templatePdfPersistence.update(templatePdf);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			TemplatePdfLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		templatePdfLocalService = (TemplatePdfLocalService)aopProxy;

		_setLocalServiceUtilService(templatePdfLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TemplatePdfLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TemplatePdf.class;
	}

	protected String getModelClassName() {
		return TemplatePdf.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = templatePdfPersistence.getDataSource();

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
		TemplatePdfLocalService templatePdfLocalService) {

		try {
			Field field = TemplatePdfLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, templatePdfLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ProceduraPersistence proceduraPersistence;

	@Reference
	protected ProceduraFinder proceduraFinder;

	@Reference
	protected ProceduraFormPersistence proceduraFormPersistence;

	protected TemplatePdfLocalService templatePdfLocalService;

	@Reference
	protected TemplatePdfPersistence templatePdfPersistence;

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