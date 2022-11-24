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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.accreditamentoenti.exception.NoSuchExampleException;
import it.servizidigitali.accreditamentoenti.model.Example;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the example service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExampleUtil
 * @generated
 */
@ProviderType
public interface ExamplePersistence extends BasePersistence<Example> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExampleUtil} to access the example persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the examples where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching examples
	 */
	public java.util.List<Example> findByUuid(String uuid);

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
	public java.util.List<Example> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Example> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Example>
			orderByComparator);

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
	public java.util.List<Example> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Example>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first example in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching example
	 * @throws NoSuchExampleException if a matching example could not be found
	 */
	public Example findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Example>
				orderByComparator)
		throws NoSuchExampleException;

	/**
	 * Returns the first example in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching example, or <code>null</code> if a matching example could not be found
	 */
	public Example fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Example>
			orderByComparator);

	/**
	 * Returns the last example in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching example
	 * @throws NoSuchExampleException if a matching example could not be found
	 */
	public Example findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Example>
				orderByComparator)
		throws NoSuchExampleException;

	/**
	 * Returns the last example in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching example, or <code>null</code> if a matching example could not be found
	 */
	public Example fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Example>
			orderByComparator);

	/**
	 * Returns the examples before and after the current example in the ordered set where uuid = &#63;.
	 *
	 * @param exampleId the primary key of the current example
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next example
	 * @throws NoSuchExampleException if a example with the primary key could not be found
	 */
	public Example[] findByUuid_PrevAndNext(
			long exampleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Example>
				orderByComparator)
		throws NoSuchExampleException;

	/**
	 * Removes all the examples where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of examples where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching examples
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the example where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchExampleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching example
	 * @throws NoSuchExampleException if a matching example could not be found
	 */
	public Example findByUUID_G(String uuid, long groupId)
		throws NoSuchExampleException;

	/**
	 * Returns the example where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching example, or <code>null</code> if a matching example could not be found
	 */
	public Example fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the example where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching example, or <code>null</code> if a matching example could not be found
	 */
	public Example fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the example where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the example that was removed
	 */
	public Example removeByUUID_G(String uuid, long groupId)
		throws NoSuchExampleException;

	/**
	 * Returns the number of examples where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching examples
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the examples where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching examples
	 */
	public java.util.List<Example> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Example> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Example> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Example>
			orderByComparator);

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
	public java.util.List<Example> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Example>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first example in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching example
	 * @throws NoSuchExampleException if a matching example could not be found
	 */
	public Example findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Example>
				orderByComparator)
		throws NoSuchExampleException;

	/**
	 * Returns the first example in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching example, or <code>null</code> if a matching example could not be found
	 */
	public Example fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Example>
			orderByComparator);

	/**
	 * Returns the last example in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching example
	 * @throws NoSuchExampleException if a matching example could not be found
	 */
	public Example findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Example>
				orderByComparator)
		throws NoSuchExampleException;

	/**
	 * Returns the last example in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching example, or <code>null</code> if a matching example could not be found
	 */
	public Example fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Example>
			orderByComparator);

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
	public Example[] findByUuid_C_PrevAndNext(
			long exampleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Example>
				orderByComparator)
		throws NoSuchExampleException;

	/**
	 * Removes all the examples where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of examples where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching examples
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the example in the entity cache if it is enabled.
	 *
	 * @param example the example
	 */
	public void cacheResult(Example example);

	/**
	 * Caches the examples in the entity cache if it is enabled.
	 *
	 * @param examples the examples
	 */
	public void cacheResult(java.util.List<Example> examples);

	/**
	 * Creates a new example with the primary key. Does not add the example to the database.
	 *
	 * @param exampleId the primary key for the new example
	 * @return the new example
	 */
	public Example create(long exampleId);

	/**
	 * Removes the example with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param exampleId the primary key of the example
	 * @return the example that was removed
	 * @throws NoSuchExampleException if a example with the primary key could not be found
	 */
	public Example remove(long exampleId) throws NoSuchExampleException;

	public Example updateImpl(Example example);

	/**
	 * Returns the example with the primary key or throws a <code>NoSuchExampleException</code> if it could not be found.
	 *
	 * @param exampleId the primary key of the example
	 * @return the example
	 * @throws NoSuchExampleException if a example with the primary key could not be found
	 */
	public Example findByPrimaryKey(long exampleId)
		throws NoSuchExampleException;

	/**
	 * Returns the example with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param exampleId the primary key of the example
	 * @return the example, or <code>null</code> if a example with the primary key could not be found
	 */
	public Example fetchByPrimaryKey(long exampleId);

	/**
	 * Returns all the examples.
	 *
	 * @return the examples
	 */
	public java.util.List<Example> findAll();

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
	public java.util.List<Example> findAll(int start, int end);

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
	public java.util.List<Example> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Example>
			orderByComparator);

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
	public java.util.List<Example> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Example>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the examples from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of examples.
	 *
	 * @return the number of examples
	 */
	public int countAll();

}