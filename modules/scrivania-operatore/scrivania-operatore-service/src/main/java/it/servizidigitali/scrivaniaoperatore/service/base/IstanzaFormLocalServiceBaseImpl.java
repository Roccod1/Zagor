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

import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.service.IstanzaFormLocalService;
import it.servizidigitali.scrivaniaoperatore.service.IstanzaFormLocalServiceUtil;
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
 * Provides the base implementation for the istanza form local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.servizidigitali.scrivaniaoperatore.service.impl.IstanzaFormLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.servizidigitali.scrivaniaoperatore.service.impl.IstanzaFormLocalServiceImpl
 * @generated
 */
public abstract class IstanzaFormLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, IstanzaFormLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>IstanzaFormLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>IstanzaFormLocalServiceUtil</code>.
	 */

	/**
	 * Adds the istanza form to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IstanzaFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param istanzaForm the istanza form
	 * @return the istanza form that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public IstanzaForm addIstanzaForm(IstanzaForm istanzaForm) {
		istanzaForm.setNew(true);

		return istanzaFormPersistence.update(istanzaForm);
	}

	/**
	 * Creates a new istanza form with the primary key. Does not add the istanza form to the database.
	 *
	 * @param istanzaFormId the primary key for the new istanza form
	 * @return the new istanza form
	 */
	@Override
	@Transactional(enabled = false)
	public IstanzaForm createIstanzaForm(long istanzaFormId) {
		return istanzaFormPersistence.create(istanzaFormId);
	}

	/**
	 * Deletes the istanza form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IstanzaFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form that was removed
	 * @throws PortalException if a istanza form with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public IstanzaForm deleteIstanzaForm(long istanzaFormId)
		throws PortalException {

		return istanzaFormPersistence.remove(istanzaFormId);
	}

	/**
	 * Deletes the istanza form from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IstanzaFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param istanzaForm the istanza form
	 * @return the istanza form that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public IstanzaForm deleteIstanzaForm(IstanzaForm istanzaForm) {
		return istanzaFormPersistence.remove(istanzaForm);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return istanzaFormPersistence.dslQuery(dslQuery);
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
			IstanzaForm.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return istanzaFormPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.IstanzaFormModelImpl</code>.
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

		return istanzaFormPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.IstanzaFormModelImpl</code>.
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

		return istanzaFormPersistence.findWithDynamicQuery(
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
		return istanzaFormPersistence.countWithDynamicQuery(dynamicQuery);
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

		return istanzaFormPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public IstanzaForm fetchIstanzaForm(long istanzaFormId) {
		return istanzaFormPersistence.fetchByPrimaryKey(istanzaFormId);
	}

	/**
	 * Returns the istanza form matching the UUID and group.
	 *
	 * @param uuid the istanza form's UUID
	 * @param groupId the primary key of the group
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm fetchIstanzaFormByUuidAndGroupId(
		String uuid, long groupId) {

		return istanzaFormPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the istanza form with the primary key.
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form
	 * @throws PortalException if a istanza form with the primary key could not be found
	 */
	@Override
	public IstanzaForm getIstanzaForm(long istanzaFormId)
		throws PortalException {

		return istanzaFormPersistence.findByPrimaryKey(istanzaFormId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(istanzaFormLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(IstanzaForm.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("istanzaFormId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			istanzaFormLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(IstanzaForm.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"istanzaFormId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(istanzaFormLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(IstanzaForm.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("istanzaFormId");
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
			new ActionableDynamicQuery.PerformActionMethod<IstanzaForm>() {

				@Override
				public void performAction(IstanzaForm istanzaForm)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, istanzaForm);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(IstanzaForm.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return istanzaFormPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return istanzaFormLocalService.deleteIstanzaForm(
			(IstanzaForm)persistedModel);
	}

	@Override
	public BasePersistence<IstanzaForm> getBasePersistence() {
		return istanzaFormPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return istanzaFormPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the istanza forms matching the UUID and company.
	 *
	 * @param uuid the UUID of the istanza forms
	 * @param companyId the primary key of the company
	 * @return the matching istanza forms, or an empty list if no matches were found
	 */
	@Override
	public List<IstanzaForm> getIstanzaFormsByUuidAndCompanyId(
		String uuid, long companyId) {

		return istanzaFormPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of istanza forms matching the UUID and company.
	 *
	 * @param uuid the UUID of the istanza forms
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching istanza forms, or an empty list if no matches were found
	 */
	@Override
	public List<IstanzaForm> getIstanzaFormsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator) {

		return istanzaFormPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the istanza form matching the UUID and group.
	 *
	 * @param uuid the istanza form's UUID
	 * @param groupId the primary key of the group
	 * @return the matching istanza form
	 * @throws PortalException if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm getIstanzaFormByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return istanzaFormPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the istanza forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.servizidigitali.scrivaniaoperatore.model.impl.IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of istanza forms
	 */
	@Override
	public List<IstanzaForm> getIstanzaForms(int start, int end) {
		return istanzaFormPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of istanza forms.
	 *
	 * @return the number of istanza forms
	 */
	@Override
	public int getIstanzaFormsCount() {
		return istanzaFormPersistence.countAll();
	}

	/**
	 * Updates the istanza form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IstanzaFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param istanzaForm the istanza form
	 * @return the istanza form that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public IstanzaForm updateIstanzaForm(IstanzaForm istanzaForm) {
		return istanzaFormPersistence.update(istanzaForm);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			IstanzaFormLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		istanzaFormLocalService = (IstanzaFormLocalService)aopProxy;

		_setLocalServiceUtilService(istanzaFormLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return IstanzaFormLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return IstanzaForm.class;
	}

	protected String getModelClassName() {
		return IstanzaForm.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = istanzaFormPersistence.getDataSource();

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
		IstanzaFormLocalService istanzaFormLocalService) {

		try {
			Field field = IstanzaFormLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, istanzaFormLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected AllegatoRichiestaPersistence allegatoRichiestaPersistence;

	@Reference
	protected CommentoRichiestaPersistence commentoRichiestaPersistence;

	protected IstanzaFormLocalService istanzaFormLocalService;

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