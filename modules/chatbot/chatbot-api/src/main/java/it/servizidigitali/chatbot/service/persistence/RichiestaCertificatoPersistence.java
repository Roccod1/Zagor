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

package it.servizidigitali.chatbot.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.chatbot.exception.NoSuchRichiestaCertificatoException;
import it.servizidigitali.chatbot.model.RichiestaCertificato;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the richiesta certificato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaCertificatoUtil
 * @generated
 */
@ProviderType
public interface RichiestaCertificatoPersistence
	extends BasePersistence<RichiestaCertificato> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiestaCertificatoUtil} to access the richiesta certificato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the richiesta certificatos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByUuid(String uuid);

	/**
	 * Returns a range of all the richiesta certificatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the richiesta certificatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiesta certificatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the first richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns the last richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the last richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public RichiestaCertificato[] findByUuid_PrevAndNext(
			long richiestaCertificatoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Removes all the richiesta certificatos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of richiesta certificatos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching richiesta certificatos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the richiesta certificato where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRichiestaCertificatoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByUUID_G(String uuid, long groupId)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the richiesta certificato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the richiesta certificato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the richiesta certificato where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the richiesta certificato that was removed
	 */
	public RichiestaCertificato removeByUUID_G(String uuid, long groupId)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the number of richiesta certificatos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching richiesta certificatos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the first richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns the last richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the last richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public RichiestaCertificato[] findByUuid_C_PrevAndNext(
			long richiestaCertificatoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Removes all the richiesta certificatos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching richiesta certificatos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByCodiceFiscale(
		String codiceFiscale);

	/**
	 * Returns a range of all the richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByCodiceFiscale(
		String codiceFiscale, int start, int end);

	/**
	 * Returns an ordered range of all the richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByCodiceFiscale(
		String codiceFiscale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByCodiceFiscale(
		String codiceFiscale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByCodiceFiscale_First(
			String codiceFiscale,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the first richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByCodiceFiscale_First(
		String codiceFiscale,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns the last richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByCodiceFiscale_Last(
			String codiceFiscale,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the last richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByCodiceFiscale_Last(
		String codiceFiscale,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public RichiestaCertificato[] findByCodiceFiscale_PrevAndNext(
			long richiestaCertificatoId, String codiceFiscale,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Removes all the richiesta certificatos where codiceFiscale = &#63; from the database.
	 *
	 * @param codiceFiscale the codice fiscale
	 */
	public void removeByCodiceFiscale(String codiceFiscale);

	/**
	 * Returns the number of richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the number of matching richiesta certificatos
	 */
	public int countByCodiceFiscale(String codiceFiscale);

	/**
	 * Returns all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @return the matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId);

	/**
	 * Returns a range of all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByCodiceFiscaleGroupId_First(
			String codiceFiscale, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the first richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByCodiceFiscaleGroupId_First(
		String codiceFiscale, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns the last richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByCodiceFiscaleGroupId_Last(
			String codiceFiscale, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the last richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByCodiceFiscaleGroupId_Last(
		String codiceFiscale, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public RichiestaCertificato[] findByCodiceFiscaleGroupId_PrevAndNext(
			long richiestaCertificatoId, String codiceFiscale, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Removes all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63; from the database.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 */
	public void removeByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId);

	/**
	 * Returns the number of richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @return the number of matching richiesta certificatos
	 */
	public int countByCodiceFiscaleGroupId(String codiceFiscale, long groupId);

	/**
	 * Returns all the richiesta certificatos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByStato(String stato);

	/**
	 * Returns a range of all the richiesta certificatos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByStato(
		String stato, int start, int end);

	/**
	 * Returns an ordered range of all the richiesta certificatos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByStato(
		String stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiesta certificatos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByStato(
		String stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByStato_First(
			String stato,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the first richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByStato_First(
		String stato,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns the last richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByStato_Last(
			String stato,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the last richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByStato_Last(
		String stato,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public RichiestaCertificato[] findByStato_PrevAndNext(
			long richiestaCertificatoId, String stato,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Removes all the richiesta certificatos where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	public void removeByStato(String stato);

	/**
	 * Returns the number of richiesta certificatos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching richiesta certificatos
	 */
	public int countByStato(String stato);

	/**
	 * Returns the richiesta certificato where richiestaId = &#63; or throws a <code>NoSuchRichiestaCertificatoException</code> if it could not be found.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByRichiestaId(long richiestaId)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the richiesta certificato where richiestaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByRichiestaId(long richiestaId);

	/**
	 * Returns the richiesta certificato where richiestaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByRichiestaId(
		long richiestaId, boolean useFinderCache);

	/**
	 * Removes the richiesta certificato where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the richiesta certificato that was removed
	 */
	public RichiestaCertificato removeByRichiestaId(long richiestaId)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the number of richiesta certificatos where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching richiesta certificatos
	 */
	public int countByRichiestaId(long richiestaId);

	/**
	 * Returns all the richiesta certificatos where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByServizioId(
		long servizioId);

	/**
	 * Returns a range of all the richiesta certificatos where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByServizioId(
		long servizioId, int start, int end);

	/**
	 * Returns an ordered range of all the richiesta certificatos where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByServizioId(
		long servizioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiesta certificatos where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findByServizioId(
		long servizioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByServizioId_First(
			long servizioId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the first richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByServizioId_First(
		long servizioId,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns the last richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByServizioId_Last(
			long servizioId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the last richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByServizioId_Last(
		long servizioId,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public RichiestaCertificato[] findByServizioId_PrevAndNext(
			long richiestaCertificatoId, long servizioId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Removes all the richiesta certificatos where servizioId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 */
	public void removeByServizioId(long servizioId);

	/**
	 * Returns the number of richiesta certificatos where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the number of matching richiesta certificatos
	 */
	public int countByServizioId(long servizioId);

	/**
	 * Returns the richiesta certificato where servizioId = &#63; and groupId = &#63; or throws a <code>NoSuchRichiestaCertificatoException</code> if it could not be found.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @return the matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato findByServizioIdGroupId(
			long servizioId, long groupId)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the richiesta certificato where servizioId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByServizioIdGroupId(
		long servizioId, long groupId);

	/**
	 * Returns the richiesta certificato where servizioId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	public RichiestaCertificato fetchByServizioIdGroupId(
		long servizioId, long groupId, boolean useFinderCache);

	/**
	 * Removes the richiesta certificato where servizioId = &#63; and groupId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @return the richiesta certificato that was removed
	 */
	public RichiestaCertificato removeByServizioIdGroupId(
			long servizioId, long groupId)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the number of richiesta certificatos where servizioId = &#63; and groupId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @return the number of matching richiesta certificatos
	 */
	public int countByServizioIdGroupId(long servizioId, long groupId);

	/**
	 * Caches the richiesta certificato in the entity cache if it is enabled.
	 *
	 * @param richiestaCertificato the richiesta certificato
	 */
	public void cacheResult(RichiestaCertificato richiestaCertificato);

	/**
	 * Caches the richiesta certificatos in the entity cache if it is enabled.
	 *
	 * @param richiestaCertificatos the richiesta certificatos
	 */
	public void cacheResult(
		java.util.List<RichiestaCertificato> richiestaCertificatos);

	/**
	 * Creates a new richiesta certificato with the primary key. Does not add the richiesta certificato to the database.
	 *
	 * @param richiestaCertificatoId the primary key for the new richiesta certificato
	 * @return the new richiesta certificato
	 */
	public RichiestaCertificato create(long richiestaCertificatoId);

	/**
	 * Removes the richiesta certificato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato that was removed
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public RichiestaCertificato remove(long richiestaCertificatoId)
		throws NoSuchRichiestaCertificatoException;

	public RichiestaCertificato updateImpl(
		RichiestaCertificato richiestaCertificato);

	/**
	 * Returns the richiesta certificato with the primary key or throws a <code>NoSuchRichiestaCertificatoException</code> if it could not be found.
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	public RichiestaCertificato findByPrimaryKey(long richiestaCertificatoId)
		throws NoSuchRichiestaCertificatoException;

	/**
	 * Returns the richiesta certificato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato, or <code>null</code> if a richiesta certificato with the primary key could not be found
	 */
	public RichiestaCertificato fetchByPrimaryKey(long richiestaCertificatoId);

	/**
	 * Returns all the richiesta certificatos.
	 *
	 * @return the richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findAll();

	/**
	 * Returns a range of all the richiesta certificatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the richiesta certificatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiesta certificatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of richiesta certificatos
	 */
	public java.util.List<RichiestaCertificato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaCertificato>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the richiesta certificatos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of richiesta certificatos.
	 *
	 * @return the number of richiesta certificatos
	 */
	public int countAll();

}