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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchAttivitaRichiestaException;
import it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the attivita richiesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttivitaRichiestaUtil
 * @generated
 */
@ProviderType
public interface AttivitaRichiestaPersistence
	extends BasePersistence<AttivitaRichiesta> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttivitaRichiestaUtil} to access the attivita richiesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the attivita richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findByUuid(String uuid);

	/**
	 * Returns a range of all the attivita richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of matching attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the attivita richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the attivita richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
				orderByComparator)
		throws NoSuchAttivitaRichiestaException;

	/**
	 * Returns the first attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator);

	/**
	 * Returns the last attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
				orderByComparator)
		throws NoSuchAttivitaRichiestaException;

	/**
	 * Returns the last attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator);

	/**
	 * Returns the attivita richiestas before and after the current attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param attivitaRichiestaId the primary key of the current attivita richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	public AttivitaRichiesta[] findByUuid_PrevAndNext(
			long attivitaRichiestaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
				orderByComparator)
		throws NoSuchAttivitaRichiestaException;

	/**
	 * Removes all the attivita richiestas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of attivita richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching attivita richiestas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the attivita richiesta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAttivitaRichiestaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta findByUUID_G(String uuid, long groupId)
		throws NoSuchAttivitaRichiestaException;

	/**
	 * Returns the attivita richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the attivita richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the attivita richiesta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the attivita richiesta that was removed
	 */
	public AttivitaRichiesta removeByUUID_G(String uuid, long groupId)
		throws NoSuchAttivitaRichiestaException;

	/**
	 * Returns the number of attivita richiestas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching attivita richiestas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of matching attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
				orderByComparator)
		throws NoSuchAttivitaRichiestaException;

	/**
	 * Returns the first attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator);

	/**
	 * Returns the last attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
				orderByComparator)
		throws NoSuchAttivitaRichiestaException;

	/**
	 * Returns the last attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator);

	/**
	 * Returns the attivita richiestas before and after the current attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param attivitaRichiestaId the primary key of the current attivita richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	public AttivitaRichiesta[] findByUuid_C_PrevAndNext(
			long attivitaRichiestaId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
				orderByComparator)
		throws NoSuchAttivitaRichiestaException;

	/**
	 * Removes all the attivita richiestas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching attivita richiestas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the attivita richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findByRichiestaId(
		long richiestaId);

	/**
	 * Returns a range of all the attivita richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of matching attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findByRichiestaId(
		long richiestaId, int start, int end);

	/**
	 * Returns an ordered range of all the attivita richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the attivita richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta findByRichiestaId_First(
			long richiestaId,
			com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
				orderByComparator)
		throws NoSuchAttivitaRichiestaException;

	/**
	 * Returns the first attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta fetchByRichiestaId_First(
		long richiestaId,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator);

	/**
	 * Returns the last attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta findByRichiestaId_Last(
			long richiestaId,
			com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
				orderByComparator)
		throws NoSuchAttivitaRichiestaException;

	/**
	 * Returns the last attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	public AttivitaRichiesta fetchByRichiestaId_Last(
		long richiestaId,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator);

	/**
	 * Returns the attivita richiestas before and after the current attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param attivitaRichiestaId the primary key of the current attivita richiesta
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	public AttivitaRichiesta[] findByRichiestaId_PrevAndNext(
			long attivitaRichiestaId, long richiestaId,
			com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
				orderByComparator)
		throws NoSuchAttivitaRichiestaException;

	/**
	 * Removes all the attivita richiestas where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 */
	public void removeByRichiestaId(long richiestaId);

	/**
	 * Returns the number of attivita richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching attivita richiestas
	 */
	public int countByRichiestaId(long richiestaId);

	/**
	 * Caches the attivita richiesta in the entity cache if it is enabled.
	 *
	 * @param attivitaRichiesta the attivita richiesta
	 */
	public void cacheResult(AttivitaRichiesta attivitaRichiesta);

	/**
	 * Caches the attivita richiestas in the entity cache if it is enabled.
	 *
	 * @param attivitaRichiestas the attivita richiestas
	 */
	public void cacheResult(
		java.util.List<AttivitaRichiesta> attivitaRichiestas);

	/**
	 * Creates a new attivita richiesta with the primary key. Does not add the attivita richiesta to the database.
	 *
	 * @param attivitaRichiestaId the primary key for the new attivita richiesta
	 * @return the new attivita richiesta
	 */
	public AttivitaRichiesta create(long attivitaRichiestaId);

	/**
	 * Removes the attivita richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attivitaRichiestaId the primary key of the attivita richiesta
	 * @return the attivita richiesta that was removed
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	public AttivitaRichiesta remove(long attivitaRichiestaId)
		throws NoSuchAttivitaRichiestaException;

	public AttivitaRichiesta updateImpl(AttivitaRichiesta attivitaRichiesta);

	/**
	 * Returns the attivita richiesta with the primary key or throws a <code>NoSuchAttivitaRichiestaException</code> if it could not be found.
	 *
	 * @param attivitaRichiestaId the primary key of the attivita richiesta
	 * @return the attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	public AttivitaRichiesta findByPrimaryKey(long attivitaRichiestaId)
		throws NoSuchAttivitaRichiestaException;

	/**
	 * Returns the attivita richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attivitaRichiestaId the primary key of the attivita richiesta
	 * @return the attivita richiesta, or <code>null</code> if a attivita richiesta with the primary key could not be found
	 */
	public AttivitaRichiesta fetchByPrimaryKey(long attivitaRichiestaId);

	/**
	 * Returns all the attivita richiestas.
	 *
	 * @return the attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findAll();

	/**
	 * Returns a range of all the attivita richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the attivita richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the attivita richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of attivita richiestas
	 */
	public java.util.List<AttivitaRichiesta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttivitaRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the attivita richiestas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of attivita richiestas.
	 *
	 * @return the number of attivita richiestas
	 */
	public int countAll();

}