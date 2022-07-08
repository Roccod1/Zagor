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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchRichiestaException;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the richiesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaUtil
 * @generated
 */
@ProviderType
public interface RichiestaPersistence extends BasePersistence<Richiesta> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiestaUtil} to access the richiesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching richiestas
	 */
	public java.util.List<Richiesta> findByUuid(String uuid);

	/**
	 * Returns a range of all the richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public java.util.List<Richiesta> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the first richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the last richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the last richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public Richiesta[] findByUuid_PrevAndNext(
			long richiestaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Removes all the richiestas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching richiestas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the richiesta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRichiestaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByUUID_G(String uuid, long groupId)
		throws NoSuchRichiestaException;

	/**
	 * Returns the richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the richiesta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the richiesta that was removed
	 */
	public Richiesta removeByUUID_G(String uuid, long groupId)
		throws NoSuchRichiestaException;

	/**
	 * Returns the number of richiestas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching richiestas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching richiestas
	 */
	public java.util.List<Richiesta> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public java.util.List<Richiesta> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the first richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the last richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the last richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public Richiesta[] findByUuid_C_PrevAndNext(
			long richiestaId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Removes all the richiestas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching richiestas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the richiestas where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the matching richiestas
	 */
	public java.util.List<Richiesta> findByCodiceFiscale(String codiceFiscale);

	/**
	 * Returns a range of all the richiestas where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public java.util.List<Richiesta> findByCodiceFiscale(
		String codiceFiscale, int start, int end);

	/**
	 * Returns an ordered range of all the richiestas where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByCodiceFiscale(
		String codiceFiscale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiestas where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByCodiceFiscale(
		String codiceFiscale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByCodiceFiscale_First(
			String codiceFiscale,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the first richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByCodiceFiscale_First(
		String codiceFiscale,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the last richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByCodiceFiscale_Last(
			String codiceFiscale,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the last richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByCodiceFiscale_Last(
		String codiceFiscale,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public Richiesta[] findByCodiceFiscale_PrevAndNext(
			long richiestaId, String codiceFiscale,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Removes all the richiestas where codiceFiscale = &#63; from the database.
	 *
	 * @param codiceFiscale the codice fiscale
	 */
	public void removeByCodiceFiscale(String codiceFiscale);

	/**
	 * Returns the number of richiestas where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the number of matching richiestas
	 */
	public int countByCodiceFiscale(String codiceFiscale);

	/**
	 * Returns all the richiestas where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @return the matching richiestas
	 */
	public java.util.List<Richiesta> findByPartitaIva(String partitaIva);

	/**
	 * Returns a range of all the richiestas where partitaIva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param partitaIva the partita iva
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public java.util.List<Richiesta> findByPartitaIva(
		String partitaIva, int start, int end);

	/**
	 * Returns an ordered range of all the richiestas where partitaIva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param partitaIva the partita iva
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByPartitaIva(
		String partitaIva, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiestas where partitaIva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param partitaIva the partita iva
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByPartitaIva(
		String partitaIva, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByPartitaIva_First(
			String partitaIva,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the first richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByPartitaIva_First(
		String partitaIva,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the last richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByPartitaIva_Last(
			String partitaIva,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the last richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByPartitaIva_Last(
		String partitaIva,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public Richiesta[] findByPartitaIva_PrevAndNext(
			long richiestaId, String partitaIva,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Removes all the richiestas where partitaIva = &#63; from the database.
	 *
	 * @param partitaIva the partita iva
	 */
	public void removeByPartitaIva(String partitaIva);

	/**
	 * Returns the number of richiestas where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @return the number of matching richiestas
	 */
	public int countByPartitaIva(String partitaIva);

	/**
	 * Returns all the richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @return the matching richiestas
	 */
	public java.util.List<Richiesta> findByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato);

	/**
	 * Returns a range of all the richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public java.util.List<Richiesta> findByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato, int start, int end);

	/**
	 * Returns an ordered range of all the richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByCodiceFiscaleDelegato_First(
			String codiceFiscaleDelegato,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the first richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByCodiceFiscaleDelegato_First(
		String codiceFiscaleDelegato,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the last richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByCodiceFiscaleDelegato_Last(
			String codiceFiscaleDelegato,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the last richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByCodiceFiscaleDelegato_Last(
		String codiceFiscaleDelegato,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public Richiesta[] findByCodiceFiscaleDelegato_PrevAndNext(
			long richiestaId, String codiceFiscaleDelegato,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Removes all the richiestas where codiceFiscaleDelegato = &#63; from the database.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 */
	public void removeByCodiceFiscaleDelegato(String codiceFiscaleDelegato);

	/**
	 * Returns the number of richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @return the number of matching richiestas
	 */
	public int countByCodiceFiscaleDelegato(String codiceFiscaleDelegato);

	/**
	 * Returns all the richiestas where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching richiestas
	 */
	public java.util.List<Richiesta> findByStato(String stato);

	/**
	 * Returns a range of all the richiestas where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public java.util.List<Richiesta> findByStato(
		String stato, int start, int end);

	/**
	 * Returns an ordered range of all the richiestas where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByStato(
		String stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiestas where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByStato(
		String stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByStato_First(
			String stato,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the first richiesta in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByStato_First(
		String stato,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the last richiesta in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByStato_Last(
			String stato,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the last richiesta in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByStato_Last(
		String stato,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where stato = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public Richiesta[] findByStato_PrevAndNext(
			long richiestaId, String stato,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Removes all the richiestas where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	public void removeByStato(String stato);

	/**
	 * Returns the number of richiestas where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching richiestas
	 */
	public int countByStato(String stato);

	/**
	 * Returns all the richiestas where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @return the matching richiestas
	 */
	public java.util.List<Richiesta> findByInvioGuest(boolean invioGuest);

	/**
	 * Returns a range of all the richiestas where invioGuest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param invioGuest the invio guest
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public java.util.List<Richiesta> findByInvioGuest(
		boolean invioGuest, int start, int end);

	/**
	 * Returns an ordered range of all the richiestas where invioGuest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param invioGuest the invio guest
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByInvioGuest(
		boolean invioGuest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiestas where invioGuest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param invioGuest the invio guest
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByInvioGuest(
		boolean invioGuest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByInvioGuest_First(
			boolean invioGuest,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the first richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByInvioGuest_First(
		boolean invioGuest,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the last richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByInvioGuest_Last(
			boolean invioGuest,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the last richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByInvioGuest_Last(
		boolean invioGuest,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public Richiesta[] findByInvioGuest_PrevAndNext(
			long richiestaId, boolean invioGuest,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Removes all the richiestas where invioGuest = &#63; from the database.
	 *
	 * @param invioGuest the invio guest
	 */
	public void removeByInvioGuest(boolean invioGuest);

	/**
	 * Returns the number of richiestas where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @return the number of matching richiestas
	 */
	public int countByInvioGuest(boolean invioGuest);

	/**
	 * Returns the richiesta where tokenVisualizzazione = &#63; or throws a <code>NoSuchRichiestaException</code> if it could not be found.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @return the matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByTokenVisualizzazione(String tokenVisualizzazione)
		throws NoSuchRichiestaException;

	/**
	 * Returns the richiesta where tokenVisualizzazione = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByTokenVisualizzazione(String tokenVisualizzazione);

	/**
	 * Returns the richiesta where tokenVisualizzazione = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByTokenVisualizzazione(
		String tokenVisualizzazione, boolean useFinderCache);

	/**
	 * Removes the richiesta where tokenVisualizzazione = &#63; from the database.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @return the richiesta that was removed
	 */
	public Richiesta removeByTokenVisualizzazione(String tokenVisualizzazione)
		throws NoSuchRichiestaException;

	/**
	 * Returns the number of richiestas where tokenVisualizzazione = &#63;.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @return the number of matching richiestas
	 */
	public int countByTokenVisualizzazione(String tokenVisualizzazione);

	/**
	 * Returns all the richiestas where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the matching richiestas
	 */
	public java.util.List<Richiesta> findByProceduraId(long proceduraId);

	/**
	 * Returns a range of all the richiestas where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	public java.util.List<Richiesta> findByProceduraId(
		long proceduraId, int start, int end);

	/**
	 * Returns an ordered range of all the richiestas where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByProceduraId(
		long proceduraId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiestas where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	public java.util.List<Richiesta> findByProceduraId(
		long proceduraId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByProceduraId_First(
			long proceduraId,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the first richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByProceduraId_First(
		long proceduraId,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the last richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	public Richiesta findByProceduraId_Last(
			long proceduraId,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Returns the last richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	public Richiesta fetchByProceduraId_Last(
		long proceduraId,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public Richiesta[] findByProceduraId_PrevAndNext(
			long richiestaId, long proceduraId,
			com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
				orderByComparator)
		throws NoSuchRichiestaException;

	/**
	 * Removes all the richiestas where proceduraId = &#63; from the database.
	 *
	 * @param proceduraId the procedura ID
	 */
	public void removeByProceduraId(long proceduraId);

	/**
	 * Returns the number of richiestas where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the number of matching richiestas
	 */
	public int countByProceduraId(long proceduraId);

	/**
	 * Caches the richiesta in the entity cache if it is enabled.
	 *
	 * @param richiesta the richiesta
	 */
	public void cacheResult(Richiesta richiesta);

	/**
	 * Caches the richiestas in the entity cache if it is enabled.
	 *
	 * @param richiestas the richiestas
	 */
	public void cacheResult(java.util.List<Richiesta> richiestas);

	/**
	 * Creates a new richiesta with the primary key. Does not add the richiesta to the database.
	 *
	 * @param richiestaId the primary key for the new richiesta
	 * @return the new richiesta
	 */
	public Richiesta create(long richiestaId);

	/**
	 * Removes the richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta that was removed
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public Richiesta remove(long richiestaId) throws NoSuchRichiestaException;

	public Richiesta updateImpl(Richiesta richiesta);

	/**
	 * Returns the richiesta with the primary key or throws a <code>NoSuchRichiestaException</code> if it could not be found.
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	public Richiesta findByPrimaryKey(long richiestaId)
		throws NoSuchRichiestaException;

	/**
	 * Returns the richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta, or <code>null</code> if a richiesta with the primary key could not be found
	 */
	public Richiesta fetchByPrimaryKey(long richiestaId);

	/**
	 * Returns all the richiestas.
	 *
	 * @return the richiestas
	 */
	public java.util.List<Richiesta> findAll();

	/**
	 * Returns a range of all the richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of richiestas
	 */
	public java.util.List<Richiesta> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiestas
	 */
	public java.util.List<Richiesta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of richiestas
	 */
	public java.util.List<Richiesta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richiesta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the richiestas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of richiestas.
	 *
	 * @return the number of richiestas
	 */
	public int countAll();

}