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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchAllegatoRichiestaException;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the allegato richiesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AllegatoRichiestaUtil
 * @generated
 */
@ProviderType
public interface AllegatoRichiestaPersistence
	extends BasePersistence<AllegatoRichiesta> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AllegatoRichiestaUtil} to access the allegato richiesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the allegato richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByUuid(String uuid);

	/**
	 * Returns a range of all the allegato richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the allegato richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allegato richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the first allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns the last allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the last allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param allegatoRichiestaPK the primary key of the current allegato richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public AllegatoRichiesta[] findByUuid_PrevAndNext(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				AllegatoRichiestaPK allegatoRichiestaPK,
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Removes all the allegato richiestas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of allegato richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allegato richiestas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the allegato richiesta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByUUID_G(String uuid, long groupId)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the allegato richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the allegato richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the allegato richiesta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allegato richiesta that was removed
	 */
	public AllegatoRichiesta removeByUUID_G(String uuid, long groupId)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the number of allegato richiestas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allegato richiestas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the first allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns the last allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the last allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allegatoRichiestaPK the primary key of the current allegato richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public AllegatoRichiesta[] findByUuid_C_PrevAndNext(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				AllegatoRichiestaPK allegatoRichiestaPK,
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Removes all the allegato richiestas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allegato richiestas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the allegato richiesta where idDocumentale = &#63; or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param idDocumentale the id documentale
	 * @return the matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByIdDocumentale(String idDocumentale)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the allegato richiesta where idDocumentale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idDocumentale the id documentale
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByIdDocumentale(String idDocumentale);

	/**
	 * Returns the allegato richiesta where idDocumentale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idDocumentale the id documentale
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByIdDocumentale(
		String idDocumentale, boolean useFinderCache);

	/**
	 * Removes the allegato richiesta where idDocumentale = &#63; from the database.
	 *
	 * @param idDocumentale the id documentale
	 * @return the allegato richiesta that was removed
	 */
	public AllegatoRichiesta removeByIdDocumentale(String idDocumentale)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the number of allegato richiestas where idDocumentale = &#63;.
	 *
	 * @param idDocumentale the id documentale
	 * @return the number of matching allegato richiestas
	 */
	public int countByIdDocumentale(String idDocumentale);

	/**
	 * Returns the allegato richiesta where url = &#63; or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param url the url
	 * @return the matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByUrl(String url)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the allegato richiesta where url = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param url the url
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByUrl(String url);

	/**
	 * Returns the allegato richiesta where url = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param url the url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByUrl(String url, boolean useFinderCache);

	/**
	 * Removes the allegato richiesta where url = &#63; from the database.
	 *
	 * @param url the url
	 * @return the allegato richiesta that was removed
	 */
	public AllegatoRichiesta removeByUrl(String url)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the number of allegato richiestas where url = &#63;.
	 *
	 * @param url the url
	 * @return the number of matching allegato richiestas
	 */
	public int countByUrl(String url);

	/**
	 * Returns the allegato richiesta where richiestaId = &#63; and principale = &#63; and groupId = &#63; or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param groupId the group ID
	 * @return the matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByR_P_G(
			long richiestaId, boolean principale, long groupId)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the allegato richiesta where richiestaId = &#63; and principale = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param groupId the group ID
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByR_P_G(
		long richiestaId, boolean principale, long groupId);

	/**
	 * Returns the allegato richiesta where richiestaId = &#63; and principale = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByR_P_G(
		long richiestaId, boolean principale, long groupId,
		boolean useFinderCache);

	/**
	 * Removes the allegato richiesta where richiestaId = &#63; and principale = &#63; and groupId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param groupId the group ID
	 * @return the allegato richiesta that was removed
	 */
	public AllegatoRichiesta removeByR_P_G(
			long richiestaId, boolean principale, long groupId)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and principale = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param groupId the group ID
	 * @return the number of matching allegato richiestas
	 */
	public int countByR_P_G(long richiestaId, boolean principale, long groupId);

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @return the matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G(
		long richiestaId, long groupId);

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G(
		long richiestaId, long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G(
		long richiestaId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G(
		long richiestaId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByR_G_First(
			long richiestaId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByR_G_First(
		long richiestaId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByR_G_Last(
			long richiestaId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByR_G_Last(
		long richiestaId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param allegatoRichiestaPK the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public AllegatoRichiesta[] findByR_G_PrevAndNext(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				AllegatoRichiestaPK allegatoRichiestaPK,
			long richiestaId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; and groupId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 */
	public void removeByR_G(long richiestaId, long groupId);

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @return the number of matching allegato richiestas
	 */
	public int countByR_G(long richiestaId, long groupId);

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @return the matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G_I(
		long richiestaId, long groupId, boolean interno);

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G_I(
		long richiestaId, long groupId, boolean interno, int start, int end);

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G_I(
		long richiestaId, long groupId, boolean interno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G_I(
		long richiestaId, long groupId, boolean interno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByR_G_I_First(
			long richiestaId, long groupId, boolean interno,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByR_G_I_First(
		long richiestaId, long groupId, boolean interno,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByR_G_I_Last(
			long richiestaId, long groupId, boolean interno,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByR_G_I_Last(
		long richiestaId, long groupId, boolean interno,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param allegatoRichiestaPK the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public AllegatoRichiesta[] findByR_G_I_PrevAndNext(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				AllegatoRichiestaPK allegatoRichiestaPK,
			long richiestaId, long groupId, boolean interno,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 */
	public void removeByR_G_I(long richiestaId, long groupId, boolean interno);

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @return the number of matching allegato richiestas
	 */
	public int countByR_G_I(long richiestaId, long groupId, boolean interno);

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @return the matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G_V(
		long richiestaId, long groupId, boolean visibile);

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G_V(
		long richiestaId, long groupId, boolean visibile, int start, int end);

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G_V(
		long richiestaId, long groupId, boolean visibile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G_V(
		long richiestaId, long groupId, boolean visibile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByR_G_V_First(
			long richiestaId, long groupId, boolean visibile,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByR_G_V_First(
		long richiestaId, long groupId, boolean visibile,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByR_G_V_Last(
			long richiestaId, long groupId, boolean visibile,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByR_G_V_Last(
		long richiestaId, long groupId, boolean visibile,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param allegatoRichiestaPK the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public AllegatoRichiesta[] findByR_G_V_PrevAndNext(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				AllegatoRichiestaPK allegatoRichiestaPK,
			long richiestaId, long groupId, boolean visibile,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and visibile = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 */
	public void removeByR_G_V(long richiestaId, long groupId, boolean visibile);

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @return the number of matching allegato richiestas
	 */
	public int countByR_G_V(long richiestaId, long groupId, boolean visibile);

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @return the matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G_I_V(
		long richiestaId, long groupId, boolean interno, boolean visibile);

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G_I_V(
		long richiestaId, long groupId, boolean interno, boolean visibile,
		int start, int end);

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G_I_V(
		long richiestaId, long groupId, boolean interno, boolean visibile,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findByR_G_I_V(
		long richiestaId, long groupId, boolean interno, boolean visibile,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByR_G_I_V_First(
			long richiestaId, long groupId, boolean interno, boolean visibile,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByR_G_I_V_First(
		long richiestaId, long groupId, boolean interno, boolean visibile,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta findByR_G_I_V_Last(
			long richiestaId, long groupId, boolean interno, boolean visibile,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	public AllegatoRichiesta fetchByR_G_I_V_Last(
		long richiestaId, long groupId, boolean interno, boolean visibile,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param allegatoRichiestaPK the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public AllegatoRichiesta[] findByR_G_I_V_PrevAndNext(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				AllegatoRichiestaPK allegatoRichiestaPK,
			long richiestaId, long groupId, boolean interno, boolean visibile,
			com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
				orderByComparator)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 */
	public void removeByR_G_I_V(
		long richiestaId, long groupId, boolean interno, boolean visibile);

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @return the number of matching allegato richiestas
	 */
	public int countByR_G_I_V(
		long richiestaId, long groupId, boolean interno, boolean visibile);

	/**
	 * Caches the allegato richiesta in the entity cache if it is enabled.
	 *
	 * @param allegatoRichiesta the allegato richiesta
	 */
	public void cacheResult(AllegatoRichiesta allegatoRichiesta);

	/**
	 * Caches the allegato richiestas in the entity cache if it is enabled.
	 *
	 * @param allegatoRichiestas the allegato richiestas
	 */
	public void cacheResult(
		java.util.List<AllegatoRichiesta> allegatoRichiestas);

	/**
	 * Creates a new allegato richiesta with the primary key. Does not add the allegato richiesta to the database.
	 *
	 * @param allegatoRichiestaPK the primary key for the new allegato richiesta
	 * @return the new allegato richiesta
	 */
	public AllegatoRichiesta create(
		it.servizidigitali.scrivaniaoperatore.service.persistence.
			AllegatoRichiestaPK allegatoRichiestaPK);

	/**
	 * Removes the allegato richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allegatoRichiestaPK the primary key of the allegato richiesta
	 * @return the allegato richiesta that was removed
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public AllegatoRichiesta remove(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				AllegatoRichiestaPK allegatoRichiestaPK)
		throws NoSuchAllegatoRichiestaException;

	public AllegatoRichiesta updateImpl(AllegatoRichiesta allegatoRichiesta);

	/**
	 * Returns the allegato richiesta with the primary key or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param allegatoRichiestaPK the primary key of the allegato richiesta
	 * @return the allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	public AllegatoRichiesta findByPrimaryKey(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				AllegatoRichiestaPK allegatoRichiestaPK)
		throws NoSuchAllegatoRichiestaException;

	/**
	 * Returns the allegato richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allegatoRichiestaPK the primary key of the allegato richiesta
	 * @return the allegato richiesta, or <code>null</code> if a allegato richiesta with the primary key could not be found
	 */
	public AllegatoRichiesta fetchByPrimaryKey(
		it.servizidigitali.scrivaniaoperatore.service.persistence.
			AllegatoRichiestaPK allegatoRichiestaPK);

	/**
	 * Returns all the allegato richiestas.
	 *
	 * @return the allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findAll();

	/**
	 * Returns a range of all the allegato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the allegato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allegato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of allegato richiestas
	 */
	public java.util.List<AllegatoRichiesta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllegatoRichiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the allegato richiestas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of allegato richiestas.
	 *
	 * @return the number of allegato richiestas
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}