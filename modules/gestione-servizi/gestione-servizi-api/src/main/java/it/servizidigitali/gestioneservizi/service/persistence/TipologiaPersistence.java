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

import it.servizidigitali.gestioneservizi.exception.NoSuchTipologiaException;
import it.servizidigitali.gestioneservizi.model.Tipologia;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the tipologia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaUtil
 * @generated
 */
@ProviderType
public interface TipologiaPersistence extends BasePersistence<Tipologia> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipologiaUtil} to access the tipologia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the tipologias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tipologias
	 */
	public java.util.List<Tipologia> findByUuid(String uuid);

	/**
	 * Returns a range of all the tipologias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of matching tipologias
	 */
	public java.util.List<Tipologia> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the tipologias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipologias
	 */
	public java.util.List<Tipologia> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipologias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipologias
	 */
	public java.util.List<Tipologia> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public Tipologia findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
				orderByComparator)
		throws NoSuchTipologiaException;

	/**
	 * Returns the first tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public Tipologia fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator);

	/**
	 * Returns the last tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public Tipologia findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
				orderByComparator)
		throws NoSuchTipologiaException;

	/**
	 * Returns the last tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public Tipologia fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator);

	/**
	 * Returns the tipologias before and after the current tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param tipologiaId the primary key of the current tipologia
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	public Tipologia[] findByUuid_PrevAndNext(
			long tipologiaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
				orderByComparator)
		throws NoSuchTipologiaException;

	/**
	 * Removes all the tipologias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of tipologias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tipologias
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the tipologia where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTipologiaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public Tipologia findByUUID_G(String uuid, long groupId)
		throws NoSuchTipologiaException;

	/**
	 * Returns the tipologia where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public Tipologia fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the tipologia where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public Tipologia fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the tipologia where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tipologia that was removed
	 */
	public Tipologia removeByUUID_G(String uuid, long groupId)
		throws NoSuchTipologiaException;

	/**
	 * Returns the number of tipologias where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tipologias
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tipologias
	 */
	public java.util.List<Tipologia> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of matching tipologias
	 */
	public java.util.List<Tipologia> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipologias
	 */
	public java.util.List<Tipologia> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipologias
	 */
	public java.util.List<Tipologia> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public Tipologia findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
				orderByComparator)
		throws NoSuchTipologiaException;

	/**
	 * Returns the first tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public Tipologia fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator);

	/**
	 * Returns the last tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public Tipologia findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
				orderByComparator)
		throws NoSuchTipologiaException;

	/**
	 * Returns the last tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public Tipologia fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator);

	/**
	 * Returns the tipologias before and after the current tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param tipologiaId the primary key of the current tipologia
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	public Tipologia[] findByUuid_C_PrevAndNext(
			long tipologiaId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
				orderByComparator)
		throws NoSuchTipologiaException;

	/**
	 * Removes all the tipologias where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tipologias
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the tipologias where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @return the matching tipologias
	 */
	public java.util.List<Tipologia> findByVisibile(boolean visibile);

	/**
	 * Returns a range of all the tipologias where visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param visibile the visibile
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of matching tipologias
	 */
	public java.util.List<Tipologia> findByVisibile(
		boolean visibile, int start, int end);

	/**
	 * Returns an ordered range of all the tipologias where visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param visibile the visibile
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipologias
	 */
	public java.util.List<Tipologia> findByVisibile(
		boolean visibile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipologias where visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param visibile the visibile
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipologias
	 */
	public java.util.List<Tipologia> findByVisibile(
		boolean visibile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public Tipologia findByVisibile_First(
			boolean visibile,
			com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
				orderByComparator)
		throws NoSuchTipologiaException;

	/**
	 * Returns the first tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public Tipologia fetchByVisibile_First(
		boolean visibile,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator);

	/**
	 * Returns the last tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	public Tipologia findByVisibile_Last(
			boolean visibile,
			com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
				orderByComparator)
		throws NoSuchTipologiaException;

	/**
	 * Returns the last tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	public Tipologia fetchByVisibile_Last(
		boolean visibile,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator);

	/**
	 * Returns the tipologias before and after the current tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param tipologiaId the primary key of the current tipologia
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	public Tipologia[] findByVisibile_PrevAndNext(
			long tipologiaId, boolean visibile,
			com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
				orderByComparator)
		throws NoSuchTipologiaException;

	/**
	 * Removes all the tipologias where visibile = &#63; from the database.
	 *
	 * @param visibile the visibile
	 */
	public void removeByVisibile(boolean visibile);

	/**
	 * Returns the number of tipologias where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @return the number of matching tipologias
	 */
	public int countByVisibile(boolean visibile);

	/**
	 * Caches the tipologia in the entity cache if it is enabled.
	 *
	 * @param tipologia the tipologia
	 */
	public void cacheResult(Tipologia tipologia);

	/**
	 * Caches the tipologias in the entity cache if it is enabled.
	 *
	 * @param tipologias the tipologias
	 */
	public void cacheResult(java.util.List<Tipologia> tipologias);

	/**
	 * Creates a new tipologia with the primary key. Does not add the tipologia to the database.
	 *
	 * @param tipologiaId the primary key for the new tipologia
	 * @return the new tipologia
	 */
	public Tipologia create(long tipologiaId);

	/**
	 * Removes the tipologia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia that was removed
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	public Tipologia remove(long tipologiaId) throws NoSuchTipologiaException;

	public Tipologia updateImpl(Tipologia tipologia);

	/**
	 * Returns the tipologia with the primary key or throws a <code>NoSuchTipologiaException</code> if it could not be found.
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	public Tipologia findByPrimaryKey(long tipologiaId)
		throws NoSuchTipologiaException;

	/**
	 * Returns the tipologia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia, or <code>null</code> if a tipologia with the primary key could not be found
	 */
	public Tipologia fetchByPrimaryKey(long tipologiaId);

	/**
	 * Returns all the tipologias.
	 *
	 * @return the tipologias
	 */
	public java.util.List<Tipologia> findAll();

	/**
	 * Returns a range of all the tipologias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of tipologias
	 */
	public java.util.List<Tipologia> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tipologias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipologias
	 */
	public java.util.List<Tipologia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipologias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tipologias
	 */
	public java.util.List<Tipologia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the tipologias from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tipologias.
	 *
	 * @return the number of tipologias
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of servizios associated with the tipologia.
	 *
	 * @param pk the primary key of the tipologia
	 * @return long[] of the primaryKeys of servizios associated with the tipologia
	 */
	public long[] getServizioPrimaryKeys(long pk);

	/**
	 * Returns all the tipologia associated with the servizio.
	 *
	 * @param pk the primary key of the servizio
	 * @return the tipologias associated with the servizio
	 */
	public java.util.List<Tipologia> getServizioTipologias(long pk);

	/**
	 * Returns all the tipologia associated with the servizio.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the servizio
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of tipologias associated with the servizio
	 */
	public java.util.List<Tipologia> getServizioTipologias(
		long pk, int start, int end);

	/**
	 * Returns all the tipologia associated with the servizio.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the servizio
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipologias associated with the servizio
	 */
	public java.util.List<Tipologia> getServizioTipologias(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tipologia>
			orderByComparator);

	/**
	 * Returns the number of servizios associated with the tipologia.
	 *
	 * @param pk the primary key of the tipologia
	 * @return the number of servizios associated with the tipologia
	 */
	public int getServiziosSize(long pk);

	/**
	 * Returns <code>true</code> if the servizio is associated with the tipologia.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPK the primary key of the servizio
	 * @return <code>true</code> if the servizio is associated with the tipologia; <code>false</code> otherwise
	 */
	public boolean containsServizio(long pk, long servizioPK);

	/**
	 * Returns <code>true</code> if the tipologia has any servizios associated with it.
	 *
	 * @param pk the primary key of the tipologia to check for associations with servizios
	 * @return <code>true</code> if the tipologia has any servizios associated with it; <code>false</code> otherwise
	 */
	public boolean containsServizios(long pk);

	/**
	 * Adds an association between the tipologia and the servizio. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPK the primary key of the servizio
	 */
	public void addServizio(long pk, long servizioPK);

	/**
	 * Adds an association between the tipologia and the servizio. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizio the servizio
	 */
	public void addServizio(
		long pk, it.servizidigitali.gestioneservizi.model.Servizio servizio);

	/**
	 * Adds an association between the tipologia and the servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPKs the primary keys of the servizios
	 */
	public void addServizios(long pk, long[] servizioPKs);

	/**
	 * Adds an association between the tipologia and the servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizios the servizios
	 */
	public void addServizios(
		long pk,
		java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
			servizios);

	/**
	 * Clears all associations between the tipologia and its servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia to clear the associated servizios from
	 */
	public void clearServizios(long pk);

	/**
	 * Removes the association between the tipologia and the servizio. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPK the primary key of the servizio
	 */
	public void removeServizio(long pk, long servizioPK);

	/**
	 * Removes the association between the tipologia and the servizio. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizio the servizio
	 */
	public void removeServizio(
		long pk, it.servizidigitali.gestioneservizi.model.Servizio servizio);

	/**
	 * Removes the association between the tipologia and the servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPKs the primary keys of the servizios
	 */
	public void removeServizios(long pk, long[] servizioPKs);

	/**
	 * Removes the association between the tipologia and the servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizios the servizios
	 */
	public void removeServizios(
		long pk,
		java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
			servizios);

	/**
	 * Sets the servizios associated with the tipologia, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPKs the primary keys of the servizios to be associated with the tipologia
	 */
	public void setServizios(long pk, long[] servizioPKs);

	/**
	 * Sets the servizios associated with the tipologia, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizios the servizios to be associated with the tipologia
	 */
	public void setServizios(
		long pk,
		java.util.List<it.servizidigitali.gestioneservizi.model.Servizio>
			servizios);

}