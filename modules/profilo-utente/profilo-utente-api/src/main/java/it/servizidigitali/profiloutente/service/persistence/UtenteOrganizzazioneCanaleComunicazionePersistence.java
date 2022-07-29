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

import it.servizidigitali.profiloutente.exception.NoSuchUtenteOrganizzazioneCanaleComunicazioneException;
import it.servizidigitali.profiloutente.model.UtenteOrganizzazioneCanaleComunicazione;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the utente organizzazione canale comunicazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazioneCanaleComunicazioneUtil
 * @generated
 */
@ProviderType
public interface UtenteOrganizzazioneCanaleComunicazionePersistence
	extends BasePersistence<UtenteOrganizzazioneCanaleComunicazione> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UtenteOrganizzazioneCanaleComunicazioneUtil} to access the utente organizzazione canale comunicazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione[] findByUuid_PrevAndNext(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazioneCanaleComunicazionePK
					utenteOrganizzazioneCanaleComunicazionePK,
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Removes all the utente organizzazione canale comunicaziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the utente organizzazione canale comunicazione where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUtenteOrganizzazioneCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione findByUUID_G(
			String uuid, long groupId)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the utente organizzazione canale comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the utente organizzazione canale comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the utente organizzazione canale comunicazione where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the utente organizzazione canale comunicazione that was removed
	 */
	public UtenteOrganizzazioneCanaleComunicazione removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione[] findByUuid_C_PrevAndNext(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazioneCanaleComunicazionePK
					utenteOrganizzazioneCanaleComunicazionePK,
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Removes all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione>
		findByOrganizationId(long organizationId);

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione>
		findByOrganizationId(long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione>
		findByOrganizationId(
			long organizationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione>
		findByOrganizationId(
			long organizationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione[]
			findByOrganizationId_PrevAndNext(
				it.servizidigitali.profiloutente.service.persistence.
					UtenteOrganizzazioneCanaleComunicazionePK
						utenteOrganizzazioneCanaleComunicazionePK,
				long organizationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Removes all the utente organizzazione canale comunicaziones where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Returns all the utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione>
		findByUtenteId(long utenteId);

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione>
		findByUtenteId(long utenteId, int start, int end);

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione>
		findByUtenteId(
			long utenteId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione>
		findByUtenteId(
			long utenteId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione findByUtenteId_First(
			long utenteId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione fetchByUtenteId_First(
		long utenteId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione findByUtenteId_Last(
			long utenteId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione fetchByUtenteId_Last(
		long utenteId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione[] findByUtenteId_PrevAndNext(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazioneCanaleComunicazionePK
					utenteOrganizzazioneCanaleComunicazionePK,
			long utenteId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Removes all the utente organizzazione canale comunicaziones where utenteId = &#63; from the database.
	 *
	 * @param utenteId the utente ID
	 */
	public void removeByUtenteId(long utenteId);

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	public int countByUtenteId(long utenteId);

	/**
	 * Returns all the utente organizzazione canale comunicaziones where utenteId = &#63; and organizationId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param organizationId the organization ID
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione>
		findByUtenteOrganization(long utenteId, long organizationId);

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where utenteId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione>
		findByUtenteOrganization(
			long utenteId, long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where utenteId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione>
		findByUtenteOrganization(
			long utenteId, long organizationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where utenteId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione>
		findByUtenteOrganization(
			long utenteId, long organizationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where utenteId = &#63; and organizationId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione
			findByUtenteOrganization_First(
				long utenteId, long organizationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where utenteId = &#63; and organizationId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione
		fetchByUtenteOrganization_First(
			long utenteId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where utenteId = &#63; and organizationId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione
			findByUtenteOrganization_Last(
				long utenteId, long organizationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where utenteId = &#63; and organizationId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione
		fetchByUtenteOrganization_Last(
			long utenteId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where utenteId = &#63; and organizationId = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param utenteId the utente ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione[]
			findByUtenteOrganization_PrevAndNext(
				it.servizidigitali.profiloutente.service.persistence.
					UtenteOrganizzazioneCanaleComunicazionePK
						utenteOrganizzazioneCanaleComunicazionePK,
				long utenteId, long organizationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<UtenteOrganizzazioneCanaleComunicazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Removes all the utente organizzazione canale comunicaziones where utenteId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param utenteId the utente ID
	 * @param organizationId the organization ID
	 */
	public void removeByUtenteOrganization(long utenteId, long organizationId);

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where utenteId = &#63; and organizationId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param organizationId the organization ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	public int countByUtenteOrganization(long utenteId, long organizationId);

	/**
	 * Caches the utente organizzazione canale comunicazione in the entity cache if it is enabled.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazione the utente organizzazione canale comunicazione
	 */
	public void cacheResult(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione);

	/**
	 * Caches the utente organizzazione canale comunicaziones in the entity cache if it is enabled.
	 *
	 * @param utenteOrganizzazioneCanaleComunicaziones the utente organizzazione canale comunicaziones
	 */
	public void cacheResult(
		java.util.List<UtenteOrganizzazioneCanaleComunicazione>
			utenteOrganizzazioneCanaleComunicaziones);

	/**
	 * Creates a new utente organizzazione canale comunicazione with the primary key. Does not add the utente organizzazione canale comunicazione to the database.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key for the new utente organizzazione canale comunicazione
	 * @return the new utente organizzazione canale comunicazione
	 */
	public UtenteOrganizzazioneCanaleComunicazione create(
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazioneCanaleComunicazionePK
				utenteOrganizzazioneCanaleComunicazionePK);

	/**
	 * Removes the utente organizzazione canale comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione that was removed
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione remove(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazioneCanaleComunicazionePK
					utenteOrganizzazioneCanaleComunicazionePK)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	public UtenteOrganizzazioneCanaleComunicazione updateImpl(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione);

	/**
	 * Returns the utente organizzazione canale comunicazione with the primary key or throws a <code>NoSuchUtenteOrganizzazioneCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione findByPrimaryKey(
			it.servizidigitali.profiloutente.service.persistence.
				UtenteOrganizzazioneCanaleComunicazionePK
					utenteOrganizzazioneCanaleComunicazionePK)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException;

	/**
	 * Returns the utente organizzazione canale comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione, or <code>null</code> if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	public UtenteOrganizzazioneCanaleComunicazione fetchByPrimaryKey(
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazioneCanaleComunicazionePK
				utenteOrganizzazioneCanaleComunicazionePK);

	/**
	 * Returns all the utente organizzazione canale comunicaziones.
	 *
	 * @return the utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione> findAll();

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator);

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of utente organizzazione canale comunicaziones
	 */
	public java.util.List<UtenteOrganizzazioneCanaleComunicazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UtenteOrganizzazioneCanaleComunicazione> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the utente organizzazione canale comunicaziones from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of utente organizzazione canale comunicaziones.
	 *
	 * @return the number of utente organizzazione canale comunicaziones
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}