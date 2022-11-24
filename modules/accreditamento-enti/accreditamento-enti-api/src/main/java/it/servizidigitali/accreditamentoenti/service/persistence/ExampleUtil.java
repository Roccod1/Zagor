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

package it.servizidigitali.accreditamentoenti.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.accreditamentoenti.model.Example;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the example service. This utility wraps <code>it.servizidigitali.accreditamentoenti.service.persistence.impl.ExamplePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamplePersistence
 * @generated
 */
public class ExampleUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Example example) {
		getPersistence().clearCache(example);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Example> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Example> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Example> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Example> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Example> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Example update(Example example) {
		return getPersistence().update(example);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Example update(
		Example example, ServiceContext serviceContext) {

		return getPersistence().update(example, serviceContext);
	}

	/**
	 * Returns all the examples where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching examples
	 */
	public static List<Example> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the examples where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExampleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of examples
	 * @param end the upper bound of the range of examples (not inclusive)
	 * @return the range of matching examples
	 */
	public static List<Example> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the examples where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExampleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of examples
	 * @param end the upper bound of the range of examples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching examples
	 */
	public static List<Example> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Example> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the examples where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExampleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of examples
	 * @param end the upper bound of the range of examples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching examples
	 */
	public static List<Example> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Example> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first example in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching example
	 * @throws NoSuchExampleException if a matching example could not be found
	 */
	public static Example findByUuid_First(
			String uuid, OrderByComparator<Example> orderByComparator)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchExampleException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first example in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching example, or <code>null</code> if a matching example could not be found
	 */
	public static Example fetchByUuid_First(
		String uuid, OrderByComparator<Example> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last example in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching example
	 * @throws NoSuchExampleException if a matching example could not be found
	 */
	public static Example findByUuid_Last(
			String uuid, OrderByComparator<Example> orderByComparator)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchExampleException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last example in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching example, or <code>null</code> if a matching example could not be found
	 */
	public static Example fetchByUuid_Last(
		String uuid, OrderByComparator<Example> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the examples before and after the current example in the ordered set where uuid = &#63;.
	 *
	 * @param exampleId the primary key of the current example
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next example
	 * @throws NoSuchExampleException if a example with the primary key could not be found
	 */
	public static Example[] findByUuid_PrevAndNext(
			long exampleId, String uuid,
			OrderByComparator<Example> orderByComparator)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchExampleException {

		return getPersistence().findByUuid_PrevAndNext(
			exampleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the examples where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of examples where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching examples
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the example where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchExampleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching example
	 * @throws NoSuchExampleException if a matching example could not be found
	 */
	public static Example findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchExampleException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the example where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching example, or <code>null</code> if a matching example could not be found
	 */
	public static Example fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the example where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching example, or <code>null</code> if a matching example could not be found
	 */
	public static Example fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the example where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the example that was removed
	 */
	public static Example removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchExampleException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of examples where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching examples
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the examples where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching examples
	 */
	public static List<Example> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the examples where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExampleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of examples
	 * @param end the upper bound of the range of examples (not inclusive)
	 * @return the range of matching examples
	 */
	public static List<Example> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the examples where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExampleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of examples
	 * @param end the upper bound of the range of examples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching examples
	 */
	public static List<Example> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Example> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the examples where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExampleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of examples
	 * @param end the upper bound of the range of examples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching examples
	 */
	public static List<Example> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Example> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first example in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching example
	 * @throws NoSuchExampleException if a matching example could not be found
	 */
	public static Example findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Example> orderByComparator)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchExampleException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first example in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching example, or <code>null</code> if a matching example could not be found
	 */
	public static Example fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Example> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last example in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching example
	 * @throws NoSuchExampleException if a matching example could not be found
	 */
	public static Example findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Example> orderByComparator)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchExampleException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last example in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching example, or <code>null</code> if a matching example could not be found
	 */
	public static Example fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Example> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the examples before and after the current example in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param exampleId the primary key of the current example
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next example
	 * @throws NoSuchExampleException if a example with the primary key could not be found
	 */
	public static Example[] findByUuid_C_PrevAndNext(
			long exampleId, String uuid, long companyId,
			OrderByComparator<Example> orderByComparator)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchExampleException {

		return getPersistence().findByUuid_C_PrevAndNext(
			exampleId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the examples where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of examples where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching examples
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the example in the entity cache if it is enabled.
	 *
	 * @param example the example
	 */
	public static void cacheResult(Example example) {
		getPersistence().cacheResult(example);
	}

	/**
	 * Caches the examples in the entity cache if it is enabled.
	 *
	 * @param examples the examples
	 */
	public static void cacheResult(List<Example> examples) {
		getPersistence().cacheResult(examples);
	}

	/**
	 * Creates a new example with the primary key. Does not add the example to the database.
	 *
	 * @param exampleId the primary key for the new example
	 * @return the new example
	 */
	public static Example create(long exampleId) {
		return getPersistence().create(exampleId);
	}

	/**
	 * Removes the example with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param exampleId the primary key of the example
	 * @return the example that was removed
	 * @throws NoSuchExampleException if a example with the primary key could not be found
	 */
	public static Example remove(long exampleId)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchExampleException {

		return getPersistence().remove(exampleId);
	}

	public static Example updateImpl(Example example) {
		return getPersistence().updateImpl(example);
	}

	/**
	 * Returns the example with the primary key or throws a <code>NoSuchExampleException</code> if it could not be found.
	 *
	 * @param exampleId the primary key of the example
	 * @return the example
	 * @throws NoSuchExampleException if a example with the primary key could not be found
	 */
	public static Example findByPrimaryKey(long exampleId)
		throws it.servizidigitali.accreditamentoenti.exception.
			NoSuchExampleException {

		return getPersistence().findByPrimaryKey(exampleId);
	}

	/**
	 * Returns the example with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param exampleId the primary key of the example
	 * @return the example, or <code>null</code> if a example with the primary key could not be found
	 */
	public static Example fetchByPrimaryKey(long exampleId) {
		return getPersistence().fetchByPrimaryKey(exampleId);
	}

	/**
	 * Returns all the examples.
	 *
	 * @return the examples
	 */
	public static List<Example> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the examples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExampleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of examples
	 * @param end the upper bound of the range of examples (not inclusive)
	 * @return the range of examples
	 */
	public static List<Example> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the examples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExampleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of examples
	 * @param end the upper bound of the range of examples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of examples
	 */
	public static List<Example> findAll(
		int start, int end, OrderByComparator<Example> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the examples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExampleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of examples
	 * @param end the upper bound of the range of examples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of examples
	 */
	public static List<Example> findAll(
		int start, int end, OrderByComparator<Example> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the examples from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of examples.
	 *
	 * @return the number of examples
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExamplePersistence getPersistence() {
		return _persistence;
	}

	private static volatile ExamplePersistence _persistence;

}