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

package it.servizidigitali.gestioneenti.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.gestioneenti.exception.NoSuchEnteServizioException;
import it.servizidigitali.gestioneenti.model.EnteServizio;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ente servizio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnteServizioUtil
 * @generated
 */
@ProviderType
public interface EnteServizioPersistence extends BasePersistence<EnteServizio> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnteServizioUtil} to access the ente servizio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ente servizios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ente servizios
	 */
	public java.util.List<EnteServizio> findByUuid(String uuid);

	/**
	 * Returns a range of all the ente servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @return the range of matching ente servizios
	 */
	public java.util.List<EnteServizio> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ente servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ente servizios
	 */
	public java.util.List<EnteServizio> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ente servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ente servizios
	 */
	public java.util.List<EnteServizio> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ente servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public EnteServizio findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
				orderByComparator)
		throws NoSuchEnteServizioException;

	/**
	 * Returns the first ente servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public EnteServizio fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator);

	/**
	 * Returns the last ente servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public EnteServizio findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
				orderByComparator)
		throws NoSuchEnteServizioException;

	/**
	 * Returns the last ente servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public EnteServizio fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator);

	/**
	 * Returns the ente servizios before and after the current ente servizio in the ordered set where uuid = &#63;.
	 *
	 * @param enteServizioPK the primary key of the current ente servizio
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ente servizio
	 * @throws NoSuchEnteServizioException if a ente servizio with the primary key could not be found
	 */
	public EnteServizio[] findByUuid_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK,
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
				orderByComparator)
		throws NoSuchEnteServizioException;

	/**
	 * Removes all the ente servizios where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ente servizios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ente servizios
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ente servizio where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEnteServizioException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public EnteServizio findByUUID_G(String uuid, long groupId)
		throws NoSuchEnteServizioException;

	/**
	 * Returns the ente servizio where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public EnteServizio fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ente servizio where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public EnteServizio fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ente servizio where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ente servizio that was removed
	 */
	public EnteServizio removeByUUID_G(String uuid, long groupId)
		throws NoSuchEnteServizioException;

	/**
	 * Returns the number of ente servizios where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ente servizios
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the ente servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ente servizios
	 */
	public java.util.List<EnteServizio> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the ente servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @return the range of matching ente servizios
	 */
	public java.util.List<EnteServizio> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the ente servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ente servizios
	 */
	public java.util.List<EnteServizio> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ente servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ente servizios
	 */
	public java.util.List<EnteServizio> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ente servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public EnteServizio findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
				orderByComparator)
		throws NoSuchEnteServizioException;

	/**
	 * Returns the first ente servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public EnteServizio fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator);

	/**
	 * Returns the last ente servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public EnteServizio findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
				orderByComparator)
		throws NoSuchEnteServizioException;

	/**
	 * Returns the last ente servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public EnteServizio fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator);

	/**
	 * Returns the ente servizios before and after the current ente servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param enteServizioPK the primary key of the current ente servizio
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ente servizio
	 * @throws NoSuchEnteServizioException if a ente servizio with the primary key could not be found
	 */
	public EnteServizio[] findByUuid_C_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK,
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
				orderByComparator)
		throws NoSuchEnteServizioException;

	/**
	 * Removes all the ente servizios where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of ente servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ente servizios
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the ente servizio where organizationId = &#63; or throws a <code>NoSuchEnteServizioException</code> if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @return the matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public EnteServizio findByOrganizationId(long organizationId)
		throws NoSuchEnteServizioException;

	/**
	 * Returns the ente servizio where organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @return the matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public EnteServizio fetchByOrganizationId(long organizationId);

	/**
	 * Returns the ente servizio where organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public EnteServizio fetchByOrganizationId(
		long organizationId, boolean useFinderCache);

	/**
	 * Removes the ente servizio where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @return the ente servizio that was removed
	 */
	public EnteServizio removeByOrganizationId(long organizationId)
		throws NoSuchEnteServizioException;

	/**
	 * Returns the number of ente servizios where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching ente servizios
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Returns all the ente servizios where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the matching ente servizios
	 */
	public java.util.List<EnteServizio> findByServizioId(long servizioId);

	/**
	 * Returns a range of all the ente servizios where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @return the range of matching ente servizios
	 */
	public java.util.List<EnteServizio> findByServizioId(
		long servizioId, int start, int end);

	/**
	 * Returns an ordered range of all the ente servizios where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ente servizios
	 */
	public java.util.List<EnteServizio> findByServizioId(
		long servizioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ente servizios where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ente servizios
	 */
	public java.util.List<EnteServizio> findByServizioId(
		long servizioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ente servizio in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public EnteServizio findByServizioId_First(
			long servizioId,
			com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
				orderByComparator)
		throws NoSuchEnteServizioException;

	/**
	 * Returns the first ente servizio in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public EnteServizio fetchByServizioId_First(
		long servizioId,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator);

	/**
	 * Returns the last ente servizio in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente servizio
	 * @throws NoSuchEnteServizioException if a matching ente servizio could not be found
	 */
	public EnteServizio findByServizioId_Last(
			long servizioId,
			com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
				orderByComparator)
		throws NoSuchEnteServizioException;

	/**
	 * Returns the last ente servizio in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ente servizio, or <code>null</code> if a matching ente servizio could not be found
	 */
	public EnteServizio fetchByServizioId_Last(
		long servizioId,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator);

	/**
	 * Returns the ente servizios before and after the current ente servizio in the ordered set where servizioId = &#63;.
	 *
	 * @param enteServizioPK the primary key of the current ente servizio
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ente servizio
	 * @throws NoSuchEnteServizioException if a ente servizio with the primary key could not be found
	 */
	public EnteServizio[] findByServizioId_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK,
			long servizioId,
			com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
				orderByComparator)
		throws NoSuchEnteServizioException;

	/**
	 * Removes all the ente servizios where servizioId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 */
	public void removeByServizioId(long servizioId);

	/**
	 * Returns the number of ente servizios where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the number of matching ente servizios
	 */
	public int countByServizioId(long servizioId);

	/**
	 * Caches the ente servizio in the entity cache if it is enabled.
	 *
	 * @param enteServizio the ente servizio
	 */
	public void cacheResult(EnteServizio enteServizio);

	/**
	 * Caches the ente servizios in the entity cache if it is enabled.
	 *
	 * @param enteServizios the ente servizios
	 */
	public void cacheResult(java.util.List<EnteServizio> enteServizios);

	/**
	 * Creates a new ente servizio with the primary key. Does not add the ente servizio to the database.
	 *
	 * @param enteServizioPK the primary key for the new ente servizio
	 * @return the new ente servizio
	 */
	public EnteServizio create(
		it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
			enteServizioPK);

	/**
	 * Removes the ente servizio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enteServizioPK the primary key of the ente servizio
	 * @return the ente servizio that was removed
	 * @throws NoSuchEnteServizioException if a ente servizio with the primary key could not be found
	 */
	public EnteServizio remove(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK)
		throws NoSuchEnteServizioException;

	public EnteServizio updateImpl(EnteServizio enteServizio);

	/**
	 * Returns the ente servizio with the primary key or throws a <code>NoSuchEnteServizioException</code> if it could not be found.
	 *
	 * @param enteServizioPK the primary key of the ente servizio
	 * @return the ente servizio
	 * @throws NoSuchEnteServizioException if a ente servizio with the primary key could not be found
	 */
	public EnteServizio findByPrimaryKey(
			it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
				enteServizioPK)
		throws NoSuchEnteServizioException;

	/**
	 * Returns the ente servizio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enteServizioPK the primary key of the ente servizio
	 * @return the ente servizio, or <code>null</code> if a ente servizio with the primary key could not be found
	 */
	public EnteServizio fetchByPrimaryKey(
		it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
			enteServizioPK);

	/**
	 * Returns all the ente servizios.
	 *
	 * @return the ente servizios
	 */
	public java.util.List<EnteServizio> findAll();

	/**
	 * Returns a range of all the ente servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @return the range of ente servizios
	 */
	public java.util.List<EnteServizio> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ente servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ente servizios
	 */
	public java.util.List<EnteServizio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ente servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnteServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ente servizios
	 * @param end the upper bound of the range of ente servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ente servizios
	 */
	public java.util.List<EnteServizio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EnteServizio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ente servizios from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ente servizios.
	 *
	 * @return the number of ente servizios
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}