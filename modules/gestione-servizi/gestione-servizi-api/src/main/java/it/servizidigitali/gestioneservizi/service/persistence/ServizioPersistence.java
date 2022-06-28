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

package it.servizidigitali.gestioneservizi.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.gestioneservizi.exception.NoSuchServizioException;
import it.servizidigitali.gestioneservizi.model.Servizio;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the servizio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioUtil
 * @generated
 */
@ProviderType
public interface ServizioPersistence extends BasePersistence<Servizio> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServizioUtil} to access the servizio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the servizios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching servizios
	 */
	public java.util.List<Servizio> findByUuid(String uuid);

	/**
	 * Returns a range of all the servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of matching servizios
	 */
	public java.util.List<Servizio> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizios
	 */
	public java.util.List<Servizio> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizios
	 */
	public java.util.List<Servizio> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public Servizio findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Servizio>
				orderByComparator)
		throws NoSuchServizioException;

	/**
	 * Returns the first servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public Servizio fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator);

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public Servizio findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Servizio>
				orderByComparator)
		throws NoSuchServizioException;

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public Servizio fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator);

	/**
	 * Returns the servizios before and after the current servizio in the ordered set where uuid = &#63;.
	 *
	 * @param servizioId the primary key of the current servizio
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	public Servizio[] findByUuid_PrevAndNext(
			long servizioId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Servizio>
				orderByComparator)
		throws NoSuchServizioException;

	/**
	 * Removes all the servizios where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of servizios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching servizios
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the servizio where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchServizioException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public Servizio findByUUID_G(String uuid, long groupId)
		throws NoSuchServizioException;

	/**
	 * Returns the servizio where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public Servizio fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the servizio where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public Servizio fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the servizio where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the servizio that was removed
	 */
	public Servizio removeByUUID_G(String uuid, long groupId)
		throws NoSuchServizioException;

	/**
	 * Returns the number of servizios where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching servizios
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching servizios
	 */
	public java.util.List<Servizio> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of matching servizios
	 */
	public java.util.List<Servizio> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizios
	 */
	public java.util.List<Servizio> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizios
	 */
	public java.util.List<Servizio> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public Servizio findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Servizio>
				orderByComparator)
		throws NoSuchServizioException;

	/**
	 * Returns the first servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public Servizio fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator);

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public Servizio findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Servizio>
				orderByComparator)
		throws NoSuchServizioException;

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public Servizio fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator);

	/**
	 * Returns the servizios before and after the current servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param servizioId the primary key of the current servizio
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	public Servizio[] findByUuid_C_PrevAndNext(
			long servizioId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Servizio>
				orderByComparator)
		throws NoSuchServizioException;

	/**
	 * Removes all the servizios where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching servizios
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the servizio where codice = &#63; or throws a <code>NoSuchServizioException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public Servizio findByCodice(String codice) throws NoSuchServizioException;

	/**
	 * Returns the servizio where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public Servizio fetchByCodice(String codice);

	/**
	 * Returns the servizio where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public Servizio fetchByCodice(String codice, boolean useFinderCache);

	/**
	 * Removes the servizio where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the servizio that was removed
	 */
	public Servizio removeByCodice(String codice)
		throws NoSuchServizioException;

	/**
	 * Returns the number of servizios where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching servizios
	 */
	public int countByCodice(String codice);

	/**
	 * Returns all the servizios where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching servizios
	 */
	public java.util.List<Servizio> findByAttivo(boolean attivo);

	/**
	 * Returns a range of all the servizios where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of matching servizios
	 */
	public java.util.List<Servizio> findByAttivo(
		boolean attivo, int start, int end);

	/**
	 * Returns an ordered range of all the servizios where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizios
	 */
	public java.util.List<Servizio> findByAttivo(
		boolean attivo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the servizios where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizios
	 */
	public java.util.List<Servizio> findByAttivo(
		boolean attivo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first servizio in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public Servizio findByAttivo_First(
			boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator<Servizio>
				orderByComparator)
		throws NoSuchServizioException;

	/**
	 * Returns the first servizio in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public Servizio fetchByAttivo_First(
		boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator);

	/**
	 * Returns the last servizio in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	public Servizio findByAttivo_Last(
			boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator<Servizio>
				orderByComparator)
		throws NoSuchServizioException;

	/**
	 * Returns the last servizio in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	public Servizio fetchByAttivo_Last(
		boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator);

	/**
	 * Returns the servizios before and after the current servizio in the ordered set where attivo = &#63;.
	 *
	 * @param servizioId the primary key of the current servizio
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	public Servizio[] findByAttivo_PrevAndNext(
			long servizioId, boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator<Servizio>
				orderByComparator)
		throws NoSuchServizioException;

	/**
	 * Removes all the servizios where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	public void removeByAttivo(boolean attivo);

	/**
	 * Returns the number of servizios where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching servizios
	 */
	public int countByAttivo(boolean attivo);

	/**
	 * Caches the servizio in the entity cache if it is enabled.
	 *
	 * @param servizio the servizio
	 */
	public void cacheResult(Servizio servizio);

	/**
	 * Caches the servizios in the entity cache if it is enabled.
	 *
	 * @param servizios the servizios
	 */
	public void cacheResult(java.util.List<Servizio> servizios);

	/**
	 * Creates a new servizio with the primary key. Does not add the servizio to the database.
	 *
	 * @param servizioId the primary key for the new servizio
	 * @return the new servizio
	 */
	public Servizio create(long servizioId);

	/**
	 * Removes the servizio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio that was removed
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	public Servizio remove(long servizioId) throws NoSuchServizioException;

	public Servizio updateImpl(Servizio servizio);

	/**
	 * Returns the servizio with the primary key or throws a <code>NoSuchServizioException</code> if it could not be found.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	public Servizio findByPrimaryKey(long servizioId)
		throws NoSuchServizioException;

	/**
	 * Returns the servizio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio, or <code>null</code> if a servizio with the primary key could not be found
	 */
	public Servizio fetchByPrimaryKey(long servizioId);

	/**
	 * Returns all the servizios.
	 *
	 * @return the servizios
	 */
	public java.util.List<Servizio> findAll();

	/**
	 * Returns a range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of servizios
	 */
	public java.util.List<Servizio> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of servizios
	 */
	public java.util.List<Servizio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of servizios
	 */
	public java.util.List<Servizio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Servizio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the servizios from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of servizios.
	 *
	 * @return the number of servizios
	 */
	public int countAll();

}