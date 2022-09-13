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

package it.servizidigitali.gestionecomunicazioni.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.gestionecomunicazioni.exception.NoSuchComunicazioneException;
import it.servizidigitali.gestionecomunicazioni.model.Comunicazione;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the comunicazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComunicazioneUtil
 * @generated
 */
@ProviderType
public interface ComunicazionePersistence
	extends BasePersistence<Comunicazione> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ComunicazioneUtil} to access the comunicazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByUuid(String uuid);

	/**
	 * Returns a range of all the comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the first comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the last comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the last comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public Comunicazione[] findByUuid_PrevAndNext(
			long comunicazioneId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Removes all the comunicaziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching comunicaziones
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the comunicazione where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchComunicazioneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByUUID_G(String uuid, long groupId)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the comunicazione where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the comunicazione that was removed
	 */
	public Comunicazione removeByUUID_G(String uuid, long groupId)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the number of comunicaziones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching comunicaziones
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the first comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the last comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the last comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public Comunicazione[] findByUuid_C_PrevAndNext(
			long comunicazioneId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Removes all the comunicaziones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching comunicaziones
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the comunicaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByOrganizationId(
		long organizationId);

	/**
	 * Returns a range of all the comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByOrganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the first comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the last comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the last comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public Comunicazione[] findByOrganizationId_PrevAndNext(
			long comunicazioneId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Removes all the comunicaziones where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of comunicaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching comunicaziones
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Returns all the comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @return the matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByTipologiaComunicazioneId(
		long tipologiaComunicazioneId);

	/**
	 * Returns a range of all the comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByTipologiaComunicazioneId(
		long tipologiaComunicazioneId, int start, int end);

	/**
	 * Returns an ordered range of all the comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByTipologiaComunicazioneId(
		long tipologiaComunicazioneId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByTipologiaComunicazioneId(
		long tipologiaComunicazioneId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByTipologiaComunicazioneId_First(
			long tipologiaComunicazioneId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the first comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByTipologiaComunicazioneId_First(
		long tipologiaComunicazioneId,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the last comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByTipologiaComunicazioneId_Last(
			long tipologiaComunicazioneId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the last comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByTipologiaComunicazioneId_Last(
		long tipologiaComunicazioneId,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public Comunicazione[] findByTipologiaComunicazioneId_PrevAndNext(
			long comunicazioneId, long tipologiaComunicazioneId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Removes all the comunicaziones where tipologiaComunicazioneId = &#63; from the database.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 */
	public void removeByTipologiaComunicazioneId(long tipologiaComunicazioneId);

	/**
	 * Returns the number of comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @return the number of matching comunicaziones
	 */
	public int countByTipologiaComunicazioneId(long tipologiaComunicazioneId);

	/**
	 * Returns all the comunicaziones where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @return the matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByDestinatarioOrganizationId(
		long destinatarioUserId);

	/**
	 * Returns a range of all the comunicaziones where destinatarioUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByDestinatarioOrganizationId(
		long destinatarioUserId, int start, int end);

	/**
	 * Returns an ordered range of all the comunicaziones where destinatarioUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByDestinatarioOrganizationId(
		long destinatarioUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comunicaziones where destinatarioUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByDestinatarioOrganizationId(
		long destinatarioUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByDestinatarioOrganizationId_First(
			long destinatarioUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the first comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByDestinatarioOrganizationId_First(
		long destinatarioUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the last comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByDestinatarioOrganizationId_Last(
			long destinatarioUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the last comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByDestinatarioOrganizationId_Last(
		long destinatarioUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public Comunicazione[] findByDestinatarioOrganizationId_PrevAndNext(
			long comunicazioneId, long destinatarioUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Removes all the comunicaziones where destinatarioUserId = &#63; from the database.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 */
	public void removeByDestinatarioOrganizationId(long destinatarioUserId);

	/**
	 * Returns the number of comunicaziones where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @return the number of matching comunicaziones
	 */
	public int countByDestinatarioOrganizationId(long destinatarioUserId);

	/**
	 * Returns all the comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @return the matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByDestinatarioUserId(
		long destinatarioOrganizationId);

	/**
	 * Returns a range of all the comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByDestinatarioUserId(
		long destinatarioOrganizationId, int start, int end);

	/**
	 * Returns an ordered range of all the comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByDestinatarioUserId(
		long destinatarioOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByDestinatarioUserId(
		long destinatarioOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByDestinatarioUserId_First(
			long destinatarioOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the first comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByDestinatarioUserId_First(
		long destinatarioOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the last comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByDestinatarioUserId_Last(
			long destinatarioOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the last comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByDestinatarioUserId_Last(
		long destinatarioOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public Comunicazione[] findByDestinatarioUserId_PrevAndNext(
			long comunicazioneId, long destinatarioOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Removes all the comunicaziones where destinatarioOrganizationId = &#63; from the database.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 */
	public void removeByDestinatarioUserId(long destinatarioOrganizationId);

	/**
	 * Returns the number of comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @return the number of matching comunicaziones
	 */
	public int countByDestinatarioUserId(long destinatarioOrganizationId);

	/**
	 * Returns all the comunicaziones where dataInvio = &#63;.
	 *
	 * @param dataInvio the data invio
	 * @return the matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByDataInvio(Date dataInvio);

	/**
	 * Returns a range of all the comunicaziones where dataInvio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param dataInvio the data invio
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByDataInvio(
		Date dataInvio, int start, int end);

	/**
	 * Returns an ordered range of all the comunicaziones where dataInvio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param dataInvio the data invio
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByDataInvio(
		Date dataInvio, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comunicaziones where dataInvio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param dataInvio the data invio
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	public java.util.List<Comunicazione> findByDataInvio(
		Date dataInvio, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comunicazione in the ordered set where dataInvio = &#63;.
	 *
	 * @param dataInvio the data invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByDataInvio_First(
			Date dataInvio,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the first comunicazione in the ordered set where dataInvio = &#63;.
	 *
	 * @param dataInvio the data invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByDataInvio_First(
		Date dataInvio,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the last comunicazione in the ordered set where dataInvio = &#63;.
	 *
	 * @param dataInvio the data invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	public Comunicazione findByDataInvio_Last(
			Date dataInvio,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the last comunicazione in the ordered set where dataInvio = &#63;.
	 *
	 * @param dataInvio the data invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	public Comunicazione fetchByDataInvio_Last(
		Date dataInvio,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where dataInvio = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param dataInvio the data invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public Comunicazione[] findByDataInvio_PrevAndNext(
			long comunicazioneId, Date dataInvio,
			com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
				orderByComparator)
		throws NoSuchComunicazioneException;

	/**
	 * Removes all the comunicaziones where dataInvio = &#63; from the database.
	 *
	 * @param dataInvio the data invio
	 */
	public void removeByDataInvio(Date dataInvio);

	/**
	 * Returns the number of comunicaziones where dataInvio = &#63;.
	 *
	 * @param dataInvio the data invio
	 * @return the number of matching comunicaziones
	 */
	public int countByDataInvio(Date dataInvio);

	/**
	 * Caches the comunicazione in the entity cache if it is enabled.
	 *
	 * @param comunicazione the comunicazione
	 */
	public void cacheResult(Comunicazione comunicazione);

	/**
	 * Caches the comunicaziones in the entity cache if it is enabled.
	 *
	 * @param comunicaziones the comunicaziones
	 */
	public void cacheResult(java.util.List<Comunicazione> comunicaziones);

	/**
	 * Creates a new comunicazione with the primary key. Does not add the comunicazione to the database.
	 *
	 * @param comunicazioneId the primary key for the new comunicazione
	 * @return the new comunicazione
	 */
	public Comunicazione create(long comunicazioneId);

	/**
	 * Removes the comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione that was removed
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public Comunicazione remove(long comunicazioneId)
		throws NoSuchComunicazioneException;

	public Comunicazione updateImpl(Comunicazione comunicazione);

	/**
	 * Returns the comunicazione with the primary key or throws a <code>NoSuchComunicazioneException</code> if it could not be found.
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	public Comunicazione findByPrimaryKey(long comunicazioneId)
		throws NoSuchComunicazioneException;

	/**
	 * Returns the comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione, or <code>null</code> if a comunicazione with the primary key could not be found
	 */
	public Comunicazione fetchByPrimaryKey(long comunicazioneId);

	/**
	 * Returns all the comunicaziones.
	 *
	 * @return the comunicaziones
	 */
	public java.util.List<Comunicazione> findAll();

	/**
	 * Returns a range of all the comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of comunicaziones
	 */
	public java.util.List<Comunicazione> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comunicaziones
	 */
	public java.util.List<Comunicazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comunicaziones
	 */
	public java.util.List<Comunicazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the comunicaziones from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of comunicaziones.
	 *
	 * @return the number of comunicaziones
	 */
	public int countAll();

}