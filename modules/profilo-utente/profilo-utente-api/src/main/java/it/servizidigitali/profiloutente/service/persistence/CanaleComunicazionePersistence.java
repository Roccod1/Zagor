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

import it.servizidigitali.profiloutente.exception.NoSuchCanaleComunicazioneException;
import it.servizidigitali.profiloutente.model.CanaleComunicazione;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the canale comunicazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanaleComunicazioneUtil
 * @generated
 */
@ProviderType
public interface CanaleComunicazionePersistence
	extends BasePersistence<CanaleComunicazione> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CanaleComunicazioneUtil} to access the canale comunicazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the canale comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findByUuid(String uuid);

	/**
	 * Returns a range of all the canale comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @return the range of matching canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the canale comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the canale comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CanaleComunicazione> orderByComparator)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Returns the first canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator);

	/**
	 * Returns the last canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CanaleComunicazione> orderByComparator)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Returns the last canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator);

	/**
	 * Returns the canale comunicaziones before and after the current canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param canaleComunicazioneId the primary key of the current canale comunicazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	public CanaleComunicazione[] findByUuid_PrevAndNext(
			long canaleComunicazioneId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CanaleComunicazione> orderByComparator)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Removes all the canale comunicaziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of canale comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching canale comunicaziones
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the canale comunicazione where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione findByUUID_G(String uuid, long groupId)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Returns the canale comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the canale comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the canale comunicazione where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the canale comunicazione that was removed
	 */
	public CanaleComunicazione removeByUUID_G(String uuid, long groupId)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Returns the number of canale comunicaziones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching canale comunicaziones
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @return the range of matching canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CanaleComunicazione> orderByComparator)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Returns the first canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator);

	/**
	 * Returns the last canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CanaleComunicazione> orderByComparator)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Returns the last canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator);

	/**
	 * Returns the canale comunicaziones before and after the current canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param canaleComunicazioneId the primary key of the current canale comunicazione
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	public CanaleComunicazione[] findByUuid_C_PrevAndNext(
			long canaleComunicazioneId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CanaleComunicazione> orderByComparator)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Removes all the canale comunicaziones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching canale comunicaziones
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the canale comunicazione where codice = &#63; or throws a <code>NoSuchCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione findByCodice(String codice)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Returns the canale comunicazione where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione fetchByCodice(String codice);

	/**
	 * Returns the canale comunicazione where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione fetchByCodice(
		String codice, boolean useFinderCache);

	/**
	 * Removes the canale comunicazione where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the canale comunicazione that was removed
	 */
	public CanaleComunicazione removeByCodice(String codice)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Returns the number of canale comunicaziones where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching canale comunicaziones
	 */
	public int countByCodice(String codice);

	/**
	 * Returns all the canale comunicaziones where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findByAttivo(boolean attivo);

	/**
	 * Returns a range of all the canale comunicaziones where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @return the range of matching canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findByAttivo(
		boolean attivo, int start, int end);

	/**
	 * Returns an ordered range of all the canale comunicaziones where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findByAttivo(
		boolean attivo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the canale comunicaziones where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findByAttivo(
		boolean attivo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione findByAttivo_First(
			boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator
				<CanaleComunicazione> orderByComparator)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Returns the first canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione fetchByAttivo_First(
		boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator);

	/**
	 * Returns the last canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione findByAttivo_Last(
			boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator
				<CanaleComunicazione> orderByComparator)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Returns the last canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	public CanaleComunicazione fetchByAttivo_Last(
		boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator);

	/**
	 * Returns the canale comunicaziones before and after the current canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param canaleComunicazioneId the primary key of the current canale comunicazione
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	public CanaleComunicazione[] findByAttivo_PrevAndNext(
			long canaleComunicazioneId, boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator
				<CanaleComunicazione> orderByComparator)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Removes all the canale comunicaziones where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	public void removeByAttivo(boolean attivo);

	/**
	 * Returns the number of canale comunicaziones where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching canale comunicaziones
	 */
	public int countByAttivo(boolean attivo);

	/**
	 * Caches the canale comunicazione in the entity cache if it is enabled.
	 *
	 * @param canaleComunicazione the canale comunicazione
	 */
	public void cacheResult(CanaleComunicazione canaleComunicazione);

	/**
	 * Caches the canale comunicaziones in the entity cache if it is enabled.
	 *
	 * @param canaleComunicaziones the canale comunicaziones
	 */
	public void cacheResult(
		java.util.List<CanaleComunicazione> canaleComunicaziones);

	/**
	 * Creates a new canale comunicazione with the primary key. Does not add the canale comunicazione to the database.
	 *
	 * @param canaleComunicazioneId the primary key for the new canale comunicazione
	 * @return the new canale comunicazione
	 */
	public CanaleComunicazione create(long canaleComunicazioneId);

	/**
	 * Removes the canale comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param canaleComunicazioneId the primary key of the canale comunicazione
	 * @return the canale comunicazione that was removed
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	public CanaleComunicazione remove(long canaleComunicazioneId)
		throws NoSuchCanaleComunicazioneException;

	public CanaleComunicazione updateImpl(
		CanaleComunicazione canaleComunicazione);

	/**
	 * Returns the canale comunicazione with the primary key or throws a <code>NoSuchCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param canaleComunicazioneId the primary key of the canale comunicazione
	 * @return the canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	public CanaleComunicazione findByPrimaryKey(long canaleComunicazioneId)
		throws NoSuchCanaleComunicazioneException;

	/**
	 * Returns the canale comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param canaleComunicazioneId the primary key of the canale comunicazione
	 * @return the canale comunicazione, or <code>null</code> if a canale comunicazione with the primary key could not be found
	 */
	public CanaleComunicazione fetchByPrimaryKey(long canaleComunicazioneId);

	/**
	 * Returns all the canale comunicaziones.
	 *
	 * @return the canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findAll();

	/**
	 * Returns a range of all the canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @return the range of canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of canale comunicaziones
	 */
	public java.util.List<CanaleComunicazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CanaleComunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the canale comunicaziones from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of canale comunicaziones.
	 *
	 * @return the number of canale comunicaziones
	 */
	public int countAll();

}