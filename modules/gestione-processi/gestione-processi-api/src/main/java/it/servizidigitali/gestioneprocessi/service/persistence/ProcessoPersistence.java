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

package it.servizidigitali.gestioneprocessi.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.gestioneprocessi.exception.NoSuchProcessoException;
import it.servizidigitali.gestioneprocessi.model.Processo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the processo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessoUtil
 * @generated
 */
@ProviderType
public interface ProcessoPersistence extends BasePersistence<Processo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProcessoUtil} to access the processo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the processos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching processos
	 */
	public java.util.List<Processo> findByUuid(String uuid);

	/**
	 * Returns a range of all the processos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of matching processos
	 */
	public java.util.List<Processo> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the processos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processos
	 */
	public java.util.List<Processo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the processos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching processos
	 */
	public java.util.List<Processo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first processo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public Processo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Processo>
				orderByComparator)
		throws NoSuchProcessoException;

	/**
	 * Returns the first processo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns the last processo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public Processo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Processo>
				orderByComparator)
		throws NoSuchProcessoException;

	/**
	 * Returns the last processo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns the processos before and after the current processo in the ordered set where uuid = &#63;.
	 *
	 * @param processoId the primary key of the current processo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	public Processo[] findByUuid_PrevAndNext(
			long processoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Processo>
				orderByComparator)
		throws NoSuchProcessoException;

	/**
	 * Removes all the processos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of processos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching processos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the processo where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcessoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public Processo findByUUID_G(String uuid, long groupId)
		throws NoSuchProcessoException;

	/**
	 * Returns the processo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the processo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the processo where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the processo that was removed
	 */
	public Processo removeByUUID_G(String uuid, long groupId)
		throws NoSuchProcessoException;

	/**
	 * Returns the number of processos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching processos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the processos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching processos
	 */
	public java.util.List<Processo> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the processos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of matching processos
	 */
	public java.util.List<Processo> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the processos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processos
	 */
	public java.util.List<Processo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the processos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching processos
	 */
	public java.util.List<Processo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public Processo findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Processo>
				orderByComparator)
		throws NoSuchProcessoException;

	/**
	 * Returns the first processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns the last processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public Processo findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Processo>
				orderByComparator)
		throws NoSuchProcessoException;

	/**
	 * Returns the last processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns the processos before and after the current processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param processoId the primary key of the current processo
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	public Processo[] findByUuid_C_PrevAndNext(
			long processoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Processo>
				orderByComparator)
		throws NoSuchProcessoException;

	/**
	 * Removes all the processos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of processos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching processos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the processo where codice = &#63; or throws a <code>NoSuchProcessoException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public Processo findByCodice(String codice) throws NoSuchProcessoException;

	/**
	 * Returns the processo where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByCodice(String codice);

	/**
	 * Returns the processo where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByCodice(String codice, boolean useFinderCache);

	/**
	 * Removes the processo where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the processo that was removed
	 */
	public Processo removeByCodice(String codice)
		throws NoSuchProcessoException;

	/**
	 * Returns the number of processos where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching processos
	 */
	public int countByCodice(String codice);

	/**
	 * Returns all the processos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching processos
	 */
	public java.util.List<Processo> findByStato(String stato);

	/**
	 * Returns a range of all the processos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of matching processos
	 */
	public java.util.List<Processo> findByStato(
		String stato, int start, int end);

	/**
	 * Returns an ordered range of all the processos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processos
	 */
	public java.util.List<Processo> findByStato(
		String stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the processos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching processos
	 */
	public java.util.List<Processo> findByStato(
		String stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first processo in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public Processo findByStato_First(
			String stato,
			com.liferay.portal.kernel.util.OrderByComparator<Processo>
				orderByComparator)
		throws NoSuchProcessoException;

	/**
	 * Returns the first processo in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByStato_First(
		String stato,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns the last processo in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public Processo findByStato_Last(
			String stato,
			com.liferay.portal.kernel.util.OrderByComparator<Processo>
				orderByComparator)
		throws NoSuchProcessoException;

	/**
	 * Returns the last processo in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByStato_Last(
		String stato,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns the processos before and after the current processo in the ordered set where stato = &#63;.
	 *
	 * @param processoId the primary key of the current processo
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	public Processo[] findByStato_PrevAndNext(
			long processoId, String stato,
			com.liferay.portal.kernel.util.OrderByComparator<Processo>
				orderByComparator)
		throws NoSuchProcessoException;

	/**
	 * Removes all the processos where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	public void removeByStato(String stato);

	/**
	 * Returns the number of processos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching processos
	 */
	public int countByStato(String stato);

	/**
	 * Returns all the processos where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching processos
	 */
	public java.util.List<Processo> findByAttivo(boolean attivo);

	/**
	 * Returns a range of all the processos where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of matching processos
	 */
	public java.util.List<Processo> findByAttivo(
		boolean attivo, int start, int end);

	/**
	 * Returns an ordered range of all the processos where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processos
	 */
	public java.util.List<Processo> findByAttivo(
		boolean attivo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the processos where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching processos
	 */
	public java.util.List<Processo> findByAttivo(
		boolean attivo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first processo in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public Processo findByAttivo_First(
			boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator<Processo>
				orderByComparator)
		throws NoSuchProcessoException;

	/**
	 * Returns the first processo in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByAttivo_First(
		boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns the last processo in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public Processo findByAttivo_Last(
			boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator<Processo>
				orderByComparator)
		throws NoSuchProcessoException;

	/**
	 * Returns the last processo in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByAttivo_Last(
		boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns the processos before and after the current processo in the ordered set where attivo = &#63;.
	 *
	 * @param processoId the primary key of the current processo
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	public Processo[] findByAttivo_PrevAndNext(
			long processoId, boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator<Processo>
				orderByComparator)
		throws NoSuchProcessoException;

	/**
	 * Removes all the processos where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	public void removeByAttivo(boolean attivo);

	/**
	 * Returns the number of processos where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching processos
	 */
	public int countByAttivo(boolean attivo);

	/**
	 * Returns the processo where deploymentId = &#63; and resourceId = &#63; or throws a <code>NoSuchProcessoException</code> if it could not be found.
	 *
	 * @param deploymentId the deployment ID
	 * @param resourceId the resource ID
	 * @return the matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	public Processo findByDeploymentIdResourceId(
			String deploymentId, String resourceId)
		throws NoSuchProcessoException;

	/**
	 * Returns the processo where deploymentId = &#63; and resourceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deploymentId the deployment ID
	 * @param resourceId the resource ID
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByDeploymentIdResourceId(
		String deploymentId, String resourceId);

	/**
	 * Returns the processo where deploymentId = &#63; and resourceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deploymentId the deployment ID
	 * @param resourceId the resource ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	public Processo fetchByDeploymentIdResourceId(
		String deploymentId, String resourceId, boolean useFinderCache);

	/**
	 * Removes the processo where deploymentId = &#63; and resourceId = &#63; from the database.
	 *
	 * @param deploymentId the deployment ID
	 * @param resourceId the resource ID
	 * @return the processo that was removed
	 */
	public Processo removeByDeploymentIdResourceId(
			String deploymentId, String resourceId)
		throws NoSuchProcessoException;

	/**
	 * Returns the number of processos where deploymentId = &#63; and resourceId = &#63;.
	 *
	 * @param deploymentId the deployment ID
	 * @param resourceId the resource ID
	 * @return the number of matching processos
	 */
	public int countByDeploymentIdResourceId(
		String deploymentId, String resourceId);

	/**
	 * Caches the processo in the entity cache if it is enabled.
	 *
	 * @param processo the processo
	 */
	public void cacheResult(Processo processo);

	/**
	 * Caches the processos in the entity cache if it is enabled.
	 *
	 * @param processos the processos
	 */
	public void cacheResult(java.util.List<Processo> processos);

	/**
	 * Creates a new processo with the primary key. Does not add the processo to the database.
	 *
	 * @param processoId the primary key for the new processo
	 * @return the new processo
	 */
	public Processo create(long processoId);

	/**
	 * Removes the processo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo that was removed
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	public Processo remove(long processoId) throws NoSuchProcessoException;

	public Processo updateImpl(Processo processo);

	/**
	 * Returns the processo with the primary key or throws a <code>NoSuchProcessoException</code> if it could not be found.
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	public Processo findByPrimaryKey(long processoId)
		throws NoSuchProcessoException;

	/**
	 * Returns the processo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo, or <code>null</code> if a processo with the primary key could not be found
	 */
	public Processo fetchByPrimaryKey(long processoId);

	/**
	 * Returns all the processos.
	 *
	 * @return the processos
	 */
	public java.util.List<Processo> findAll();

	/**
	 * Returns a range of all the processos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of processos
	 */
	public java.util.List<Processo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the processos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of processos
	 */
	public java.util.List<Processo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the processos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of processos
	 */
	public java.util.List<Processo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Processo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the processos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of processos.
	 *
	 * @return the number of processos
	 */
	public int countAll();

}