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

import it.servizidigitali.gestioneservizi.exception.NoSuchAreaTematicaException;
import it.servizidigitali.gestioneservizi.model.AreaTematica;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the area tematica service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AreaTematicaUtil
 * @generated
 */
@ProviderType
public interface AreaTematicaPersistence extends BasePersistence<AreaTematica> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AreaTematicaUtil} to access the area tematica persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the area tematicas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching area tematicas
	 */
	public java.util.List<AreaTematica> findByUuid(String uuid);

	/**
	 * Returns a range of all the area tematicas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of matching area tematicas
	 */
	public java.util.List<AreaTematica> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the area tematicas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching area tematicas
	 */
	public java.util.List<AreaTematica> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator);

	/**
	 * Returns an ordered range of all the area tematicas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching area tematicas
	 */
	public java.util.List<AreaTematica> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public AreaTematica findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
				orderByComparator)
		throws NoSuchAreaTematicaException;

	/**
	 * Returns the first area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public AreaTematica fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator);

	/**
	 * Returns the last area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public AreaTematica findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
				orderByComparator)
		throws NoSuchAreaTematicaException;

	/**
	 * Returns the last area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public AreaTematica fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator);

	/**
	 * Returns the area tematicas before and after the current area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param areaTematicaId the primary key of the current area tematica
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	public AreaTematica[] findByUuid_PrevAndNext(
			long areaTematicaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
				orderByComparator)
		throws NoSuchAreaTematicaException;

	/**
	 * Removes all the area tematicas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of area tematicas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching area tematicas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the area tematica where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAreaTematicaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public AreaTematica findByUUID_G(String uuid, long groupId)
		throws NoSuchAreaTematicaException;

	/**
	 * Returns the area tematica where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public AreaTematica fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the area tematica where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public AreaTematica fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the area tematica where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the area tematica that was removed
	 */
	public AreaTematica removeByUUID_G(String uuid, long groupId)
		throws NoSuchAreaTematicaException;

	/**
	 * Returns the number of area tematicas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching area tematicas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching area tematicas
	 */
	public java.util.List<AreaTematica> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of matching area tematicas
	 */
	public java.util.List<AreaTematica> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching area tematicas
	 */
	public java.util.List<AreaTematica> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator);

	/**
	 * Returns an ordered range of all the area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching area tematicas
	 */
	public java.util.List<AreaTematica> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public AreaTematica findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
				orderByComparator)
		throws NoSuchAreaTematicaException;

	/**
	 * Returns the first area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public AreaTematica fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator);

	/**
	 * Returns the last area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public AreaTematica findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
				orderByComparator)
		throws NoSuchAreaTematicaException;

	/**
	 * Returns the last area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public AreaTematica fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator);

	/**
	 * Returns the area tematicas before and after the current area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param areaTematicaId the primary key of the current area tematica
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	public AreaTematica[] findByUuid_C_PrevAndNext(
			long areaTematicaId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
				orderByComparator)
		throws NoSuchAreaTematicaException;

	/**
	 * Removes all the area tematicas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching area tematicas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the area tematica where codice = &#63; or throws a <code>NoSuchAreaTematicaException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public AreaTematica findByCodice(String codice)
		throws NoSuchAreaTematicaException;

	/**
	 * Returns the area tematica where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public AreaTematica fetchByCodice(String codice);

	/**
	 * Returns the area tematica where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public AreaTematica fetchByCodice(String codice, boolean useFinderCache);

	/**
	 * Removes the area tematica where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the area tematica that was removed
	 */
	public AreaTematica removeByCodice(String codice)
		throws NoSuchAreaTematicaException;

	/**
	 * Returns the number of area tematicas where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching area tematicas
	 */
	public int countByCodice(String codice);

	/**
	 * Returns all the area tematicas where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @return the matching area tematicas
	 */
	public java.util.List<AreaTematica> findByAttiva(boolean attiva);

	/**
	 * Returns a range of all the area tematicas where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of matching area tematicas
	 */
	public java.util.List<AreaTematica> findByAttiva(
		boolean attiva, int start, int end);

	/**
	 * Returns an ordered range of all the area tematicas where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching area tematicas
	 */
	public java.util.List<AreaTematica> findByAttiva(
		boolean attiva, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator);

	/**
	 * Returns an ordered range of all the area tematicas where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching area tematicas
	 */
	public java.util.List<AreaTematica> findByAttiva(
		boolean attiva, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public AreaTematica findByAttiva_First(
			boolean attiva,
			com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
				orderByComparator)
		throws NoSuchAreaTematicaException;

	/**
	 * Returns the first area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public AreaTematica fetchByAttiva_First(
		boolean attiva,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator);

	/**
	 * Returns the last area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	public AreaTematica findByAttiva_Last(
			boolean attiva,
			com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
				orderByComparator)
		throws NoSuchAreaTematicaException;

	/**
	 * Returns the last area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	public AreaTematica fetchByAttiva_Last(
		boolean attiva,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator);

	/**
	 * Returns the area tematicas before and after the current area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param areaTematicaId the primary key of the current area tematica
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	public AreaTematica[] findByAttiva_PrevAndNext(
			long areaTematicaId, boolean attiva,
			com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
				orderByComparator)
		throws NoSuchAreaTematicaException;

	/**
	 * Removes all the area tematicas where attiva = &#63; from the database.
	 *
	 * @param attiva the attiva
	 */
	public void removeByAttiva(boolean attiva);

	/**
	 * Returns the number of area tematicas where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @return the number of matching area tematicas
	 */
	public int countByAttiva(boolean attiva);

	/**
	 * Caches the area tematica in the entity cache if it is enabled.
	 *
	 * @param areaTematica the area tematica
	 */
	public void cacheResult(AreaTematica areaTematica);

	/**
	 * Caches the area tematicas in the entity cache if it is enabled.
	 *
	 * @param areaTematicas the area tematicas
	 */
	public void cacheResult(java.util.List<AreaTematica> areaTematicas);

	/**
	 * Creates a new area tematica with the primary key. Does not add the area tematica to the database.
	 *
	 * @param areaTematicaId the primary key for the new area tematica
	 * @return the new area tematica
	 */
	public AreaTematica create(long areaTematicaId);

	/**
	 * Removes the area tematica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica that was removed
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	public AreaTematica remove(long areaTematicaId)
		throws NoSuchAreaTematicaException;

	public AreaTematica updateImpl(AreaTematica areaTematica);

	/**
	 * Returns the area tematica with the primary key or throws a <code>NoSuchAreaTematicaException</code> if it could not be found.
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	public AreaTematica findByPrimaryKey(long areaTematicaId)
		throws NoSuchAreaTematicaException;

	/**
	 * Returns the area tematica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica, or <code>null</code> if a area tematica with the primary key could not be found
	 */
	public AreaTematica fetchByPrimaryKey(long areaTematicaId);

	/**
	 * Returns all the area tematicas.
	 *
	 * @return the area tematicas
	 */
	public java.util.List<AreaTematica> findAll();

	/**
	 * Returns a range of all the area tematicas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of area tematicas
	 */
	public java.util.List<AreaTematica> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the area tematicas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of area tematicas
	 */
	public java.util.List<AreaTematica> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator);

	/**
	 * Returns an ordered range of all the area tematicas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of area tematicas
	 */
	public java.util.List<AreaTematica> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AreaTematica>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the area tematicas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of area tematicas.
	 *
	 * @return the number of area tematicas
	 */
	public int countAll();

}