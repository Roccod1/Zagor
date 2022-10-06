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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchDestinazioneUsoException;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the destinazione uso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DestinazioneUsoUtil
 * @generated
 */
@ProviderType
public interface DestinazioneUsoPersistence
	extends BasePersistence<DestinazioneUso> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DestinazioneUsoUtil} to access the destinazione uso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the destinazione usos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByUuid(String uuid);

	/**
	 * Returns a range of all the destinazione usos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the destinazione usos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns an ordered range of all the destinazione usos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public DestinazioneUso findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
				orderByComparator)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Returns the first destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public DestinazioneUso fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns the last destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public DestinazioneUso findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
				orderByComparator)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Returns the last destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public DestinazioneUso fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns the destinazione usos before and after the current destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param destinazioneUsoId the primary key of the current destinazione uso
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	public DestinazioneUso[] findByUuid_PrevAndNext(
			long destinazioneUsoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
				orderByComparator)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Removes all the destinazione usos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of destinazione usos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching destinazione usos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the destinazione uso where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDestinazioneUsoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public DestinazioneUso findByUUID_G(String uuid, long groupId)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Returns the destinazione uso where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public DestinazioneUso fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the destinazione uso where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public DestinazioneUso fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the destinazione uso where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the destinazione uso that was removed
	 */
	public DestinazioneUso removeByUUID_G(String uuid, long groupId)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Returns the number of destinazione usos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching destinazione usos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns an ordered range of all the destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public DestinazioneUso findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
				orderByComparator)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Returns the first destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public DestinazioneUso fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns the last destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public DestinazioneUso findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
				orderByComparator)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Returns the last destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public DestinazioneUso fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns the destinazione usos before and after the current destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param destinazioneUsoId the primary key of the current destinazione uso
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	public DestinazioneUso[] findByUuid_C_PrevAndNext(
			long destinazioneUsoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
				orderByComparator)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Removes all the destinazione usos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching destinazione usos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the destinazione usos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByGroupId(long groupId);

	/**
	 * Returns a range of all the destinazione usos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the destinazione usos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns an ordered range of all the destinazione usos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public DestinazioneUso findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
				orderByComparator)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Returns the first destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public DestinazioneUso fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns the last destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public DestinazioneUso findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
				orderByComparator)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Returns the last destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public DestinazioneUso fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns the destinazione usos before and after the current destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param destinazioneUsoId the primary key of the current destinazione uso
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	public DestinazioneUso[] findByGroupId_PrevAndNext(
			long destinazioneUsoId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
				orderByComparator)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Removes all the destinazione usos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of destinazione usos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching destinazione usos
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the destinazione usos where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @return the matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByPagamentoBollo(
		boolean pagamentoBollo);

	/**
	 * Returns a range of all the destinazione usos where pagamentoBollo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByPagamentoBollo(
		boolean pagamentoBollo, int start, int end);

	/**
	 * Returns an ordered range of all the destinazione usos where pagamentoBollo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByPagamentoBollo(
		boolean pagamentoBollo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns an ordered range of all the destinazione usos where pagamentoBollo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione usos
	 */
	public java.util.List<DestinazioneUso> findByPagamentoBollo(
		boolean pagamentoBollo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public DestinazioneUso findByPagamentoBollo_First(
			boolean pagamentoBollo,
			com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
				orderByComparator)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Returns the first destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public DestinazioneUso fetchByPagamentoBollo_First(
		boolean pagamentoBollo,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns the last destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	public DestinazioneUso findByPagamentoBollo_Last(
			boolean pagamentoBollo,
			com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
				orderByComparator)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Returns the last destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	public DestinazioneUso fetchByPagamentoBollo_Last(
		boolean pagamentoBollo,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns the destinazione usos before and after the current destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param destinazioneUsoId the primary key of the current destinazione uso
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	public DestinazioneUso[] findByPagamentoBollo_PrevAndNext(
			long destinazioneUsoId, boolean pagamentoBollo,
			com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
				orderByComparator)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Removes all the destinazione usos where pagamentoBollo = &#63; from the database.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 */
	public void removeByPagamentoBollo(boolean pagamentoBollo);

	/**
	 * Returns the number of destinazione usos where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @return the number of matching destinazione usos
	 */
	public int countByPagamentoBollo(boolean pagamentoBollo);

	/**
	 * Caches the destinazione uso in the entity cache if it is enabled.
	 *
	 * @param destinazioneUso the destinazione uso
	 */
	public void cacheResult(DestinazioneUso destinazioneUso);

	/**
	 * Caches the destinazione usos in the entity cache if it is enabled.
	 *
	 * @param destinazioneUsos the destinazione usos
	 */
	public void cacheResult(java.util.List<DestinazioneUso> destinazioneUsos);

	/**
	 * Creates a new destinazione uso with the primary key. Does not add the destinazione uso to the database.
	 *
	 * @param destinazioneUsoId the primary key for the new destinazione uso
	 * @return the new destinazione uso
	 */
	public DestinazioneUso create(long destinazioneUsoId);

	/**
	 * Removes the destinazione uso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso that was removed
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	public DestinazioneUso remove(long destinazioneUsoId)
		throws NoSuchDestinazioneUsoException;

	public DestinazioneUso updateImpl(DestinazioneUso destinazioneUso);

	/**
	 * Returns the destinazione uso with the primary key or throws a <code>NoSuchDestinazioneUsoException</code> if it could not be found.
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	public DestinazioneUso findByPrimaryKey(long destinazioneUsoId)
		throws NoSuchDestinazioneUsoException;

	/**
	 * Returns the destinazione uso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso, or <code>null</code> if a destinazione uso with the primary key could not be found
	 */
	public DestinazioneUso fetchByPrimaryKey(long destinazioneUsoId);

	/**
	 * Returns all the destinazione usos.
	 *
	 * @return the destinazione usos
	 */
	public java.util.List<DestinazioneUso> findAll();

	/**
	 * Returns a range of all the destinazione usos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of destinazione usos
	 */
	public java.util.List<DestinazioneUso> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the destinazione usos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of destinazione usos
	 */
	public java.util.List<DestinazioneUso> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator);

	/**
	 * Returns an ordered range of all the destinazione usos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of destinazione usos
	 */
	public java.util.List<DestinazioneUso> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DestinazioneUso>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the destinazione usos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of destinazione usos.
	 *
	 * @return the number of destinazione usos
	 */
	public int countAll();

}