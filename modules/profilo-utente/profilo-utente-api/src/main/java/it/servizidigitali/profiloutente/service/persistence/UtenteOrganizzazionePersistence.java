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

package it.servizidigitali.profiloutente.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.profiloutente.exception.NoSuchUtenteOrganizzazioneException;
import it.servizidigitali.profiloutente.model.UtenteOrganizzazione;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the utente organizzazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazioneUtil
 * @generated
 */
@ProviderType
public interface UtenteOrganizzazionePersistence
	extends BasePersistence<UtenteOrganizzazione> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UtenteOrganizzazioneUtil} to access the utente organizzazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the utente organizzaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByUuid(String uuid);

	/**
	 * Returns a range of all the utente organizzaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the utente organizzaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the utente organizzaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Returns the first utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns the last utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Returns the last utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns the utente organizzaziones before and after the current utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param utenteOrganizzazionePK the primary key of the current utente organizzazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	public UtenteOrganizzazione[] findByUuid_PrevAndNext(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK,
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Removes all the utente organizzaziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of utente organizzaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching utente organizzaziones
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the utente organizzazione where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUtenteOrganizzazioneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione findByUUID_G(String uuid, long groupId)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Returns the utente organizzazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the utente organizzazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the utente organizzazione where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the utente organizzazione that was removed
	 */
	public UtenteOrganizzazione removeByUUID_G(String uuid, long groupId)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Returns the number of utente organizzaziones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching utente organizzaziones
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Returns the first utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns the last utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Returns the last utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns the utente organizzaziones before and after the current utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param utenteOrganizzazionePK the primary key of the current utente organizzazione
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	public UtenteOrganizzazione[] findByUuid_C_PrevAndNext(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK,
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Removes all the utente organizzaziones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching utente organizzaziones
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the utente organizzaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByOrganizationId(
		long organizationId);

	/**
	 * Returns a range of all the utente organizzaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByOrganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the utente organizzaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the utente organizzaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Returns the first utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns the last utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Returns the last utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns the utente organizzaziones before and after the current utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param utenteOrganizzazionePK the primary key of the current utente organizzazione
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	public UtenteOrganizzazione[] findByOrganizationId_PrevAndNext(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK,
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Removes all the utente organizzaziones where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of utente organizzaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching utente organizzaziones
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Returns all the utente organizzaziones where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @return the matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByUtenteId(long utenteId);

	/**
	 * Returns a range of all the utente organizzaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByUtenteId(
		long utenteId, int start, int end);

	/**
	 * Returns an ordered range of all the utente organizzaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByUtenteId(
		long utenteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the utente organizzaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findByUtenteId(
		long utenteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione findByUtenteId_First(
			long utenteId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Returns the first utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione fetchByUtenteId_First(
		long utenteId,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns the last utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione findByUtenteId_Last(
			long utenteId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Returns the last utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	public UtenteOrganizzazione fetchByUtenteId_Last(
		long utenteId,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns the utente organizzaziones before and after the current utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteOrganizzazionePK the primary key of the current utente organizzazione
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	public UtenteOrganizzazione[] findByUtenteId_PrevAndNext(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK,
			long utenteId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Removes all the utente organizzaziones where utenteId = &#63; from the database.
	 *
	 * @param utenteId the utente ID
	 */
	public void removeByUtenteId(long utenteId);

	/**
	 * Returns the number of utente organizzaziones where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @return the number of matching utente organizzaziones
	 */
	public int countByUtenteId(long utenteId);

	/**
	 * Caches the utente organizzazione in the entity cache if it is enabled.
	 *
	 * @param utenteOrganizzazione the utente organizzazione
	 */
	public void cacheResult(UtenteOrganizzazione utenteOrganizzazione);

	/**
	 * Caches the utente organizzaziones in the entity cache if it is enabled.
	 *
	 * @param utenteOrganizzaziones the utente organizzaziones
	 */
	public void cacheResult(
		java.util.List<UtenteOrganizzazione> utenteOrganizzaziones);

	/**
	 * Creates a new utente organizzazione with the primary key. Does not add the utente organizzazione to the database.
	 *
	 * @param utenteOrganizzazionePK the primary key for the new utente organizzazione
	 * @return the new utente organizzazione
	 */
	public UtenteOrganizzazione create(
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazionePK utenteOrganizzazionePK);

	/**
	 * Removes the utente organizzazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione that was removed
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	public UtenteOrganizzazione remove(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK)
		throws NoSuchUtenteOrganizzazioneException;

	public UtenteOrganizzazione updateImpl(
		UtenteOrganizzazione utenteOrganizzazione);

	/**
	 * Returns the utente organizzazione with the primary key or throws a <code>NoSuchUtenteOrganizzazioneException</code> if it could not be found.
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	public UtenteOrganizzazione findByPrimaryKey(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazionePK utenteOrganizzazionePK)
		throws NoSuchUtenteOrganizzazioneException;

	/**
	 * Returns the utente organizzazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione, or <code>null</code> if a utente organizzazione with the primary key could not be found
	 */
	public UtenteOrganizzazione fetchByPrimaryKey(
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazionePK utenteOrganizzazionePK);

	/**
	 * Returns all the utente organizzaziones.
	 *
	 * @return the utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findAll();

	/**
	 * Returns a range of all the utente organizzaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the utente organizzaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the utente organizzaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of utente organizzaziones
	 */
	public java.util.List<UtenteOrganizzazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteOrganizzazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the utente organizzaziones from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of utente organizzaziones.
	 *
	 * @return the number of utente organizzaziones
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}