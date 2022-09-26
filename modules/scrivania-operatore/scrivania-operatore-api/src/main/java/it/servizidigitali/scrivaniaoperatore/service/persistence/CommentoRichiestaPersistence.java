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

package it.servizidigitali.scrivaniaoperatore.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchCommentoRichiestaException;
import it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the commento richiesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentoRichiestaUtil
 * @generated
 */
@ProviderType
public interface CommentoRichiestaPersistence
	extends BasePersistence<CommentoRichiesta> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommentoRichiestaUtil} to access the commento richiesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the commento richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByUuid(String uuid);

	/**
	 * Returns a range of all the commento richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the commento richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commento richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the first commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns the last commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the last commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public CommentoRichiesta[] findByUuid_PrevAndNext(
			long commentoRichiestaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Removes all the commento richiestas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of commento richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching commento richiestas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the commento richiesta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCommentoRichiestaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta findByUUID_G(String uuid, long groupId)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the commento richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the commento richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the commento richiesta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the commento richiesta that was removed
	 */
	public CommentoRichiesta removeByUUID_G(String uuid, long groupId)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the number of commento richiestas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching commento richiestas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the first commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns the last commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the last commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public CommentoRichiesta[] findByUuid_C_PrevAndNext(
			long commentoRichiestaId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Removes all the commento richiestas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching commento richiestas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the commento richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByRichiestaId(
		long richiestaId);

	/**
	 * Returns a range of all the commento richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end);

	/**
	 * Returns an ordered range of all the commento richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commento richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta findByRichiestaId_First(
			long richiestaId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the first commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta fetchByRichiestaId_First(
		long richiestaId,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns the last commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta findByRichiestaId_Last(
			long richiestaId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the last commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta fetchByRichiestaId_Last(
		long richiestaId,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public CommentoRichiesta[] findByRichiestaId_PrevAndNext(
			long commentoRichiestaId, long richiestaId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Removes all the commento richiestas where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 */
	public void removeByRichiestaId(long richiestaId);

	/**
	 * Returns the number of commento richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching commento richiestas
	 */
	public int countByRichiestaId(long richiestaId);

	/**
	 * Returns all the commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @return the matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile);

	/**
	 * Returns a range of all the commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end);

	/**
	 * Returns an ordered range of all the commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta findByRichiestaIdVisibile_First(
			long richiestaId, boolean visibile,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the first commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta fetchByRichiestaIdVisibile_First(
		long richiestaId, boolean visibile,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns the last commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta findByRichiestaIdVisibile_Last(
			long richiestaId, boolean visibile,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the last commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta fetchByRichiestaIdVisibile_Last(
		long richiestaId, boolean visibile,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public CommentoRichiesta[] findByRichiestaIdVisibile_PrevAndNext(
			long commentoRichiestaId, long richiestaId, boolean visibile,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Removes all the commento richiestas where richiestaId = &#63; and visibile = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 */
	public void removeByRichiestaIdVisibile(long richiestaId, boolean visibile);

	/**
	 * Returns the number of commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @return the number of matching commento richiestas
	 */
	public int countByRichiestaIdVisibile(long richiestaId, boolean visibile);

	/**
	 * Returns all the commento richiestas where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByTaskId(String taskId);

	/**
	 * Returns a range of all the commento richiestas where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByTaskId(
		String taskId, int start, int end);

	/**
	 * Returns an ordered range of all the commento richiestas where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByTaskId(
		String taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commento richiestas where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findByTaskId(
		String taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta findByTaskId_First(
			String taskId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the first commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta fetchByTaskId_First(
		String taskId,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns the last commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta findByTaskId_Last(
			String taskId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the last commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	public CommentoRichiesta fetchByTaskId_Last(
		String taskId,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public CommentoRichiesta[] findByTaskId_PrevAndNext(
			long commentoRichiestaId, String taskId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
				orderByComparator)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Removes all the commento richiestas where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public void removeByTaskId(String taskId);

	/**
	 * Returns the number of commento richiestas where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching commento richiestas
	 */
	public int countByTaskId(String taskId);

	/**
	 * Caches the commento richiesta in the entity cache if it is enabled.
	 *
	 * @param commentoRichiesta the commento richiesta
	 */
	public void cacheResult(CommentoRichiesta commentoRichiesta);

	/**
	 * Caches the commento richiestas in the entity cache if it is enabled.
	 *
	 * @param commentoRichiestas the commento richiestas
	 */
	public void cacheResult(
		java.util.List<CommentoRichiesta> commentoRichiestas);

	/**
	 * Creates a new commento richiesta with the primary key. Does not add the commento richiesta to the database.
	 *
	 * @param commentoRichiestaId the primary key for the new commento richiesta
	 * @return the new commento richiesta
	 */
	public CommentoRichiesta create(long commentoRichiestaId);

	/**
	 * Removes the commento richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta that was removed
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public CommentoRichiesta remove(long commentoRichiestaId)
		throws NoSuchCommentoRichiestaException;

	public CommentoRichiesta updateImpl(CommentoRichiesta commentoRichiesta);

	/**
	 * Returns the commento richiesta with the primary key or throws a <code>NoSuchCommentoRichiestaException</code> if it could not be found.
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	public CommentoRichiesta findByPrimaryKey(long commentoRichiestaId)
		throws NoSuchCommentoRichiestaException;

	/**
	 * Returns the commento richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta, or <code>null</code> if a commento richiesta with the primary key could not be found
	 */
	public CommentoRichiesta fetchByPrimaryKey(long commentoRichiestaId);

	/**
	 * Returns all the commento richiestas.
	 *
	 * @return the commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findAll();

	/**
	 * Returns a range of all the commento richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the commento richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commento richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commento richiestas
	 */
	public java.util.List<CommentoRichiesta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the commento richiestas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of commento richiestas.
	 *
	 * @return the number of commento richiestas
	 */
	public int countAll();

}