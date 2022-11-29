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

import it.servizidigitali.accreditamentoenti.exception.NoSuchEnteException;
import it.servizidigitali.accreditamentoenti.model.Ente;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnteUtil
 * @generated
 */
@ProviderType
public interface EntePersistence extends BasePersistence<Ente> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnteUtil} to access the ente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching entes
	 */
	public java.util.List<Ente> findByUuid(String uuid);

	/**
	 * Returns a range of all the entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @return the range of matching entes
	 */
	public java.util.List<Ente> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching entes
	 */
	public java.util.List<Ente> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ente>
			orderByComparator);

	/**
	 * Returns an ordered range of all the entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching entes
	 */
	public java.util.List<Ente> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ente>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente
	 * @throws NoSuchEnteException if a matching ente could not be found
	 */
	public Ente findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Ente>
				orderByComparator)
		throws NoSuchEnteException;

	/**
	 * Returns the first ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente, or <code>null</code> if a matching ente could not be found
	 */
	public Ente fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ente>
			orderByComparator);

	/**
	 * Returns the last ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente
	 * @throws NoSuchEnteException if a matching ente could not be found
	 */
	public Ente findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Ente>
				orderByComparator)
		throws NoSuchEnteException;

	/**
	 * Returns the last ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente, or <code>null</code> if a matching ente could not be found
	 */
	public Ente fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ente>
			orderByComparator);

	/**
	 * Returns the entes before and after the current ente in the ordered set where uuid = &#63;.
	 *
	 * @param enteId the primary key of the current ente
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ente
	 * @throws NoSuchEnteException if a ente with the primary key could not be found
	 */
	public Ente[] findByUuid_PrevAndNext(
			long enteId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Ente>
				orderByComparator)
		throws NoSuchEnteException;

	/**
	 * Removes all the entes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching entes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ente where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEnteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ente
	 * @throws NoSuchEnteException if a matching ente could not be found
	 */
	public Ente findByUUID_G(String uuid, long groupId)
		throws NoSuchEnteException;

	/**
	 * Returns the ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ente, or <code>null</code> if a matching ente could not be found
	 */
	public Ente fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ente, or <code>null</code> if a matching ente could not be found
	 */
	public Ente fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ente where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ente that was removed
	 */
	public Ente removeByUUID_G(String uuid, long groupId)
		throws NoSuchEnteException;

	/**
	 * Returns the number of entes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching entes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching entes
	 */
	public java.util.List<Ente> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @return the range of matching entes
	 */
	public java.util.List<Ente> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching entes
	 */
	public java.util.List<Ente> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ente>
			orderByComparator);

	/**
	 * Returns an ordered range of all the entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching entes
	 */
	public java.util.List<Ente> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ente>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente
	 * @throws NoSuchEnteException if a matching ente could not be found
	 */
	public Ente findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Ente>
				orderByComparator)
		throws NoSuchEnteException;

	/**
	 * Returns the first ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente, or <code>null</code> if a matching ente could not be found
	 */
	public Ente fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Ente>
			orderByComparator);

	/**
	 * Returns the last ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente
	 * @throws NoSuchEnteException if a matching ente could not be found
	 */
	public Ente findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Ente>
				orderByComparator)
		throws NoSuchEnteException;

	/**
	 * Returns the last ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente, or <code>null</code> if a matching ente could not be found
	 */
	public Ente fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Ente>
			orderByComparator);

	/**
	 * Returns the entes before and after the current ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param enteId the primary key of the current ente
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ente
	 * @throws NoSuchEnteException if a ente with the primary key could not be found
	 */
	public Ente[] findByUuid_C_PrevAndNext(
			long enteId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Ente>
				orderByComparator)
		throws NoSuchEnteException;

	/**
	 * Removes all the entes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching entes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the ente in the entity cache if it is enabled.
	 *
	 * @param ente the ente
	 */
	public void cacheResult(Ente ente);

	/**
	 * Caches the entes in the entity cache if it is enabled.
	 *
	 * @param entes the entes
	 */
	public void cacheResult(java.util.List<Ente> entes);

	/**
	 * Creates a new ente with the primary key. Does not add the ente to the database.
	 *
	 * @param enteId the primary key for the new ente
	 * @return the new ente
	 */
	public Ente create(long enteId);

	/**
	 * Removes the ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enteId the primary key of the ente
	 * @return the ente that was removed
	 * @throws NoSuchEnteException if a ente with the primary key could not be found
	 */
	public Ente remove(long enteId) throws NoSuchEnteException;

	public Ente updateImpl(Ente ente);

	/**
	 * Returns the ente with the primary key or throws a <code>NoSuchEnteException</code> if it could not be found.
	 *
	 * @param enteId the primary key of the ente
	 * @return the ente
	 * @throws NoSuchEnteException if a ente with the primary key could not be found
	 */
	public Ente findByPrimaryKey(long enteId) throws NoSuchEnteException;

	/**
	 * Returns the ente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enteId the primary key of the ente
	 * @return the ente, or <code>null</code> if a ente with the primary key could not be found
	 */
	public Ente fetchByPrimaryKey(long enteId);

	/**
	 * Returns all the entes.
	 *
	 * @return the entes
	 */
	public java.util.List<Ente> findAll();

	/**
	 * Returns a range of all the entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @return the range of entes
	 */
	public java.util.List<Ente> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of entes
	 */
	public java.util.List<Ente> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ente>
			orderByComparator);

	/**
	 * Returns an ordered range of all the entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entes
	 * @param end the upper bound of the range of entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of entes
	 */
	public java.util.List<Ente> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ente>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the entes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of entes.
	 *
	 * @return the number of entes
	 */
	public int countAll();

}