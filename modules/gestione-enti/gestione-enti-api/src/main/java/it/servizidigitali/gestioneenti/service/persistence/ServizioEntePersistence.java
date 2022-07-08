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

import it.servizidigitali.gestioneenti.exception.NoSuchServizioEnteException;
import it.servizidigitali.gestioneenti.model.ServizioEnte;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the servizio ente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioEnteUtil
 * @generated
 */
@ProviderType
public interface ServizioEntePersistence extends BasePersistence<ServizioEnte> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServizioEnteUtil} to access the servizio ente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the servizio entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByUuid(String uuid);

	/**
	 * Returns a range of all the servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns an ordered range of all the servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public ServizioEnte findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
				orderByComparator)
		throws NoSuchServizioEnteException;

	/**
	 * Returns the first servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public ServizioEnte fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns the last servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public ServizioEnte findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
				orderByComparator)
		throws NoSuchServizioEnteException;

	/**
	 * Returns the last servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public ServizioEnte fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns the servizio entes before and after the current servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param servizioEntePK the primary key of the current servizio ente
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	public ServizioEnte[] findByUuid_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK,
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
				orderByComparator)
		throws NoSuchServizioEnteException;

	/**
	 * Removes all the servizio entes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of servizio entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching servizio entes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the servizio ente where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchServizioEnteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public ServizioEnte findByUUID_G(String uuid, long groupId)
		throws NoSuchServizioEnteException;

	/**
	 * Returns the servizio ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public ServizioEnte fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the servizio ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public ServizioEnte fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the servizio ente where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the servizio ente that was removed
	 */
	public ServizioEnte removeByUUID_G(String uuid, long groupId)
		throws NoSuchServizioEnteException;

	/**
	 * Returns the number of servizio entes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching servizio entes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns an ordered range of all the servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public ServizioEnte findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
				orderByComparator)
		throws NoSuchServizioEnteException;

	/**
	 * Returns the first servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public ServizioEnte fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns the last servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public ServizioEnte findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
				orderByComparator)
		throws NoSuchServizioEnteException;

	/**
	 * Returns the last servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public ServizioEnte fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns the servizio entes before and after the current servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param servizioEntePK the primary key of the current servizio ente
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	public ServizioEnte[] findByUuid_C_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK,
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
				orderByComparator)
		throws NoSuchServizioEnteException;

	/**
	 * Removes all the servizio entes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching servizio entes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the servizio entes where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByOrganizationId(
		long organizationId);

	/**
	 * Returns a range of all the servizio entes where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByOrganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the servizio entes where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns an ordered range of all the servizio entes where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public ServizioEnte findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
				orderByComparator)
		throws NoSuchServizioEnteException;

	/**
	 * Returns the first servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public ServizioEnte fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns the last servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public ServizioEnte findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
				orderByComparator)
		throws NoSuchServizioEnteException;

	/**
	 * Returns the last servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public ServizioEnte fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns the servizio entes before and after the current servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param servizioEntePK the primary key of the current servizio ente
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	public ServizioEnte[] findByOrganizationId_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK,
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
				orderByComparator)
		throws NoSuchServizioEnteException;

	/**
	 * Removes all the servizio entes where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of servizio entes where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching servizio entes
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Returns all the servizio entes where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByServizioId(long servizioId);

	/**
	 * Returns a range of all the servizio entes where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByServizioId(
		long servizioId, int start, int end);

	/**
	 * Returns an ordered range of all the servizio entes where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByServizioId(
		long servizioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns an ordered range of all the servizio entes where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizio entes
	 */
	public java.util.List<ServizioEnte> findByServizioId(
		long servizioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public ServizioEnte findByServizioId_First(
			long servizioId,
			com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
				orderByComparator)
		throws NoSuchServizioEnteException;

	/**
	 * Returns the first servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public ServizioEnte fetchByServizioId_First(
		long servizioId,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns the last servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	public ServizioEnte findByServizioId_Last(
			long servizioId,
			com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
				orderByComparator)
		throws NoSuchServizioEnteException;

	/**
	 * Returns the last servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	public ServizioEnte fetchByServizioId_Last(
		long servizioId,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns the servizio entes before and after the current servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioEntePK the primary key of the current servizio ente
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	public ServizioEnte[] findByServizioId_PrevAndNext(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK,
			long servizioId,
			com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
				orderByComparator)
		throws NoSuchServizioEnteException;

	/**
	 * Removes all the servizio entes where servizioId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 */
	public void removeByServizioId(long servizioId);

	/**
	 * Returns the number of servizio entes where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the number of matching servizio entes
	 */
	public int countByServizioId(long servizioId);

	/**
	 * Caches the servizio ente in the entity cache if it is enabled.
	 *
	 * @param servizioEnte the servizio ente
	 */
	public void cacheResult(ServizioEnte servizioEnte);

	/**
	 * Caches the servizio entes in the entity cache if it is enabled.
	 *
	 * @param servizioEntes the servizio entes
	 */
	public void cacheResult(java.util.List<ServizioEnte> servizioEntes);

	/**
	 * Creates a new servizio ente with the primary key. Does not add the servizio ente to the database.
	 *
	 * @param servizioEntePK the primary key for the new servizio ente
	 * @return the new servizio ente
	 */
	public ServizioEnte create(
		it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
			servizioEntePK);

	/**
	 * Removes the servizio ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente that was removed
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	public ServizioEnte remove(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK)
		throws NoSuchServizioEnteException;

	public ServizioEnte updateImpl(ServizioEnte servizioEnte);

	/**
	 * Returns the servizio ente with the primary key or throws a <code>NoSuchServizioEnteException</code> if it could not be found.
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	public ServizioEnte findByPrimaryKey(
			it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
				servizioEntePK)
		throws NoSuchServizioEnteException;

	/**
	 * Returns the servizio ente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente, or <code>null</code> if a servizio ente with the primary key could not be found
	 */
	public ServizioEnte fetchByPrimaryKey(
		it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
			servizioEntePK);

	/**
	 * Returns all the servizio entes.
	 *
	 * @return the servizio entes
	 */
	public java.util.List<ServizioEnte> findAll();

	/**
	 * Returns a range of all the servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of servizio entes
	 */
	public java.util.List<ServizioEnte> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of servizio entes
	 */
	public java.util.List<ServizioEnte> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator);

	/**
	 * Returns an ordered range of all the servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of servizio entes
	 */
	public java.util.List<ServizioEnte> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioEnte>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the servizio entes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of servizio entes.
	 *
	 * @return the number of servizio entes
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}