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

package it.servizidigitali.accreditamentoenti.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.accreditamentoenti.exception.NoSuchResponsabileEnteException;
import it.servizidigitali.accreditamentoenti.model.ResponsabileEnte;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the responsabile ente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResponsabileEnteUtil
 * @generated
 */
@ProviderType
public interface ResponsabileEntePersistence
	extends BasePersistence<ResponsabileEnte> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResponsabileEnteUtil} to access the responsabile ente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the responsabile entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findByUuid(String uuid);

	/**
	 * Returns a range of all the responsabile entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @return the range of matching responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the responsabile entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator);

	/**
	 * Returns an ordered range of all the responsabile entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first responsabile ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching responsabile ente
	 * @throws NoSuchResponsabileEnteException if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
				orderByComparator)
		throws NoSuchResponsabileEnteException;

	/**
	 * Returns the first responsabile ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching responsabile ente, or <code>null</code> if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator);

	/**
	 * Returns the last responsabile ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching responsabile ente
	 * @throws NoSuchResponsabileEnteException if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
				orderByComparator)
		throws NoSuchResponsabileEnteException;

	/**
	 * Returns the last responsabile ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching responsabile ente, or <code>null</code> if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator);

	/**
	 * Returns the responsabile entes before and after the current responsabile ente in the ordered set where uuid = &#63;.
	 *
	 * @param responsabileEnteId the primary key of the current responsabile ente
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next responsabile ente
	 * @throws NoSuchResponsabileEnteException if a responsabile ente with the primary key could not be found
	 */
	public ResponsabileEnte[] findByUuid_PrevAndNext(
			long responsabileEnteId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
				orderByComparator)
		throws NoSuchResponsabileEnteException;

	/**
	 * Removes all the responsabile entes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of responsabile entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching responsabile entes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the responsabile ente where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchResponsabileEnteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching responsabile ente
	 * @throws NoSuchResponsabileEnteException if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte findByUUID_G(String uuid, long groupId)
		throws NoSuchResponsabileEnteException;

	/**
	 * Returns the responsabile ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching responsabile ente, or <code>null</code> if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the responsabile ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching responsabile ente, or <code>null</code> if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the responsabile ente where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the responsabile ente that was removed
	 */
	public ResponsabileEnte removeByUUID_G(String uuid, long groupId)
		throws NoSuchResponsabileEnteException;

	/**
	 * Returns the number of responsabile entes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching responsabile entes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the responsabile entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the responsabile entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @return the range of matching responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the responsabile entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator);

	/**
	 * Returns an ordered range of all the responsabile entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first responsabile ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching responsabile ente
	 * @throws NoSuchResponsabileEnteException if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
				orderByComparator)
		throws NoSuchResponsabileEnteException;

	/**
	 * Returns the first responsabile ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching responsabile ente, or <code>null</code> if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator);

	/**
	 * Returns the last responsabile ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching responsabile ente
	 * @throws NoSuchResponsabileEnteException if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
				orderByComparator)
		throws NoSuchResponsabileEnteException;

	/**
	 * Returns the last responsabile ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching responsabile ente, or <code>null</code> if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator);

	/**
	 * Returns the responsabile entes before and after the current responsabile ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param responsabileEnteId the primary key of the current responsabile ente
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next responsabile ente
	 * @throws NoSuchResponsabileEnteException if a responsabile ente with the primary key could not be found
	 */
	public ResponsabileEnte[] findByUuid_C_PrevAndNext(
			long responsabileEnteId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
				orderByComparator)
		throws NoSuchResponsabileEnteException;

	/**
	 * Removes all the responsabile entes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of responsabile entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching responsabile entes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the responsabile entes where enteId = &#63;.
	 *
	 * @param enteId the ente ID
	 * @return the matching responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findByEnteId(long enteId);

	/**
	 * Returns a range of all the responsabile entes where enteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param enteId the ente ID
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @return the range of matching responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findByEnteId(
		long enteId, int start, int end);

	/**
	 * Returns an ordered range of all the responsabile entes where enteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param enteId the ente ID
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findByEnteId(
		long enteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator);

	/**
	 * Returns an ordered range of all the responsabile entes where enteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param enteId the ente ID
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findByEnteId(
		long enteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first responsabile ente in the ordered set where enteId = &#63;.
	 *
	 * @param enteId the ente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching responsabile ente
	 * @throws NoSuchResponsabileEnteException if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte findByEnteId_First(
			long enteId,
			com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
				orderByComparator)
		throws NoSuchResponsabileEnteException;

	/**
	 * Returns the first responsabile ente in the ordered set where enteId = &#63;.
	 *
	 * @param enteId the ente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching responsabile ente, or <code>null</code> if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte fetchByEnteId_First(
		long enteId,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator);

	/**
	 * Returns the last responsabile ente in the ordered set where enteId = &#63;.
	 *
	 * @param enteId the ente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching responsabile ente
	 * @throws NoSuchResponsabileEnteException if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte findByEnteId_Last(
			long enteId,
			com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
				orderByComparator)
		throws NoSuchResponsabileEnteException;

	/**
	 * Returns the last responsabile ente in the ordered set where enteId = &#63;.
	 *
	 * @param enteId the ente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching responsabile ente, or <code>null</code> if a matching responsabile ente could not be found
	 */
	public ResponsabileEnte fetchByEnteId_Last(
		long enteId,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator);

	/**
	 * Returns the responsabile entes before and after the current responsabile ente in the ordered set where enteId = &#63;.
	 *
	 * @param responsabileEnteId the primary key of the current responsabile ente
	 * @param enteId the ente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next responsabile ente
	 * @throws NoSuchResponsabileEnteException if a responsabile ente with the primary key could not be found
	 */
	public ResponsabileEnte[] findByEnteId_PrevAndNext(
			long responsabileEnteId, long enteId,
			com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
				orderByComparator)
		throws NoSuchResponsabileEnteException;

	/**
	 * Removes all the responsabile entes where enteId = &#63; from the database.
	 *
	 * @param enteId the ente ID
	 */
	public void removeByEnteId(long enteId);

	/**
	 * Returns the number of responsabile entes where enteId = &#63;.
	 *
	 * @param enteId the ente ID
	 * @return the number of matching responsabile entes
	 */
	public int countByEnteId(long enteId);

	/**
	 * Caches the responsabile ente in the entity cache if it is enabled.
	 *
	 * @param responsabileEnte the responsabile ente
	 */
	public void cacheResult(ResponsabileEnte responsabileEnte);

	/**
	 * Caches the responsabile entes in the entity cache if it is enabled.
	 *
	 * @param responsabileEntes the responsabile entes
	 */
	public void cacheResult(java.util.List<ResponsabileEnte> responsabileEntes);

	/**
	 * Creates a new responsabile ente with the primary key. Does not add the responsabile ente to the database.
	 *
	 * @param responsabileEnteId the primary key for the new responsabile ente
	 * @return the new responsabile ente
	 */
	public ResponsabileEnte create(long responsabileEnteId);

	/**
	 * Removes the responsabile ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param responsabileEnteId the primary key of the responsabile ente
	 * @return the responsabile ente that was removed
	 * @throws NoSuchResponsabileEnteException if a responsabile ente with the primary key could not be found
	 */
	public ResponsabileEnte remove(long responsabileEnteId)
		throws NoSuchResponsabileEnteException;

	public ResponsabileEnte updateImpl(ResponsabileEnte responsabileEnte);

	/**
	 * Returns the responsabile ente with the primary key or throws a <code>NoSuchResponsabileEnteException</code> if it could not be found.
	 *
	 * @param responsabileEnteId the primary key of the responsabile ente
	 * @return the responsabile ente
	 * @throws NoSuchResponsabileEnteException if a responsabile ente with the primary key could not be found
	 */
	public ResponsabileEnte findByPrimaryKey(long responsabileEnteId)
		throws NoSuchResponsabileEnteException;

	/**
	 * Returns the responsabile ente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param responsabileEnteId the primary key of the responsabile ente
	 * @return the responsabile ente, or <code>null</code> if a responsabile ente with the primary key could not be found
	 */
	public ResponsabileEnte fetchByPrimaryKey(long responsabileEnteId);

	/**
	 * Returns all the responsabile entes.
	 *
	 * @return the responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findAll();

	/**
	 * Returns a range of all the responsabile entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @return the range of responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the responsabile entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator);

	/**
	 * Returns an ordered range of all the responsabile entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResponsabileEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of responsabile entes
	 * @param end the upper bound of the range of responsabile entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of responsabile entes
	 */
	public java.util.List<ResponsabileEnte> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResponsabileEnte>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the responsabile entes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of responsabile entes.
	 *
	 * @return the number of responsabile entes
	 */
	public int countAll();

}