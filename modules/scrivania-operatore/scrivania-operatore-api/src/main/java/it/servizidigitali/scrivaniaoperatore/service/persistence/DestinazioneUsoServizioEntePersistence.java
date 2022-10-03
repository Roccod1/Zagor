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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchDestinazioneUsoServizioEnteException;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the destinazione uso servizio ente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DestinazioneUsoServizioEnteUtil
 * @generated
 */
@ProviderType
public interface DestinazioneUsoServizioEntePersistence
	extends BasePersistence<DestinazioneUsoServizioEnte> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DestinazioneUsoServizioEnteUtil} to access the destinazione uso servizio ente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the destinazione uso servizio entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findByUuid(String uuid);

	/**
	 * Returns a range of all the destinazione uso servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns the destinazione uso servizio entes before and after the current destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the current destinazione uso servizio ente
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public DestinazioneUsoServizioEnte[] findByUuid_PrevAndNext(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK,
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Removes all the destinazione uso servizio entes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of destinazione uso servizio entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching destinazione uso servizio entes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the destinazione uso servizio ente where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDestinazioneUsoServizioEnteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte findByUUID_G(String uuid, long groupId)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the destinazione uso servizio ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the destinazione uso servizio ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the destinazione uso servizio ente where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the destinazione uso servizio ente that was removed
	 */
	public DestinazioneUsoServizioEnte removeByUUID_G(String uuid, long groupId)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the number of destinazione uso servizio entes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns the destinazione uso servizio entes before and after the current destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the current destinazione uso servizio ente
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public DestinazioneUsoServizioEnte[] findByUuid_C_PrevAndNext(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK,
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Removes all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the destinazione uso servizio ente where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63; or throws a <code>NoSuchDestinazioneUsoServizioEnteException</code> if it could not be found.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @return the matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte
			findByDestinazioneUsoIdServizioIdOrganizationId(
				long destinazioneUsoId, long servizioId, long organizationId)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the destinazione uso servizio ente where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte
		fetchByDestinazioneUsoIdServizioIdOrganizationId(
			long destinazioneUsoId, long servizioId, long organizationId);

	/**
	 * Returns the destinazione uso servizio ente where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte
		fetchByDestinazioneUsoIdServizioIdOrganizationId(
			long destinazioneUsoId, long servizioId, long organizationId,
			boolean useFinderCache);

	/**
	 * Removes the destinazione uso servizio ente where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @return the destinazione uso servizio ente that was removed
	 */
	public DestinazioneUsoServizioEnte
			removeByDestinazioneUsoIdServizioIdOrganizationId(
				long destinazioneUsoId, long servizioId, long organizationId)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the number of destinazione uso servizio entes where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63;.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	public int countByDestinazioneUsoIdServizioIdOrganizationId(
		long destinazioneUsoId, long servizioId, long organizationId);

	/**
	 * Returns all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte>
		findByOrganizationIdGroupIdCompanyId(
			long organizationId, long groupId, long companyId);

	/**
	 * Returns a range of all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte>
		findByOrganizationIdGroupIdCompanyId(
			long organizationId, long groupId, long companyId, int start,
			int end);

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte>
		findByOrganizationIdGroupIdCompanyId(
			long organizationId, long groupId, long companyId, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte>
		findByOrganizationIdGroupIdCompanyId(
			long organizationId, long groupId, long companyId, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte
			findByOrganizationIdGroupIdCompanyId_First(
				long organizationId, long groupId, long companyId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte
		fetchByOrganizationIdGroupIdCompanyId_First(
			long organizationId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte
			findByOrganizationIdGroupIdCompanyId_Last(
				long organizationId, long groupId, long companyId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte
		fetchByOrganizationIdGroupIdCompanyId_Last(
			long organizationId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns the destinazione uso servizio entes before and after the current destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the current destinazione uso servizio ente
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public DestinazioneUsoServizioEnte[]
			findByOrganizationIdGroupIdCompanyId_PrevAndNext(
				it.servizidigitali.scrivaniaoperatore.service.persistence.
					DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK,
				long organizationId, long groupId, long companyId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Removes all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByOrganizationIdGroupIdCompanyId(
		long organizationId, long groupId, long companyId);

	/**
	 * Returns the number of destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	public int countByOrganizationIdGroupIdCompanyId(
		long organizationId, long groupId, long companyId);

	/**
	 * Returns all the destinazione uso servizio entes where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findByO_S_G_C(
		long organizationId, long servizioId, long groupId, long companyId);

	/**
	 * Returns a range of all the destinazione uso servizio entes where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findByO_S_G_C(
		long organizationId, long servizioId, long groupId, long companyId,
		int start, int end);

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findByO_S_G_C(
		long organizationId, long servizioId, long groupId, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findByO_S_G_C(
		long organizationId, long servizioId, long groupId, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte findByO_S_G_C_First(
			long organizationId, long servizioId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte fetchByO_S_G_C_First(
		long organizationId, long servizioId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte findByO_S_G_C_Last(
			long organizationId, long servizioId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	public DestinazioneUsoServizioEnte fetchByO_S_G_C_Last(
		long organizationId, long servizioId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns the destinazione uso servizio entes before and after the current destinazione uso servizio ente in the ordered set where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the current destinazione uso servizio ente
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public DestinazioneUsoServizioEnte[] findByO_S_G_C_PrevAndNext(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK,
			long organizationId, long servizioId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Removes all the destinazione uso servizio entes where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByO_S_G_C(
		long organizationId, long servizioId, long groupId, long companyId);

	/**
	 * Returns the number of destinazione uso servizio entes where organizationId = &#63; and servizioId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	public int countByO_S_G_C(
		long organizationId, long servizioId, long groupId, long companyId);

	/**
	 * Caches the destinazione uso servizio ente in the entity cache if it is enabled.
	 *
	 * @param destinazioneUsoServizioEnte the destinazione uso servizio ente
	 */
	public void cacheResult(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte);

	/**
	 * Caches the destinazione uso servizio entes in the entity cache if it is enabled.
	 *
	 * @param destinazioneUsoServizioEntes the destinazione uso servizio entes
	 */
	public void cacheResult(
		java.util.List<DestinazioneUsoServizioEnte>
			destinazioneUsoServizioEntes);

	/**
	 * Creates a new destinazione uso servizio ente with the primary key. Does not add the destinazione uso servizio ente to the database.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key for the new destinazione uso servizio ente
	 * @return the new destinazione uso servizio ente
	 */
	public DestinazioneUsoServizioEnte create(
		it.servizidigitali.scrivaniaoperatore.service.persistence.
			DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK);

	/**
	 * Removes the destinazione uso servizio ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente that was removed
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public DestinazioneUsoServizioEnte remove(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK)
		throws NoSuchDestinazioneUsoServizioEnteException;

	public DestinazioneUsoServizioEnte updateImpl(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte);

	/**
	 * Returns the destinazione uso servizio ente with the primary key or throws a <code>NoSuchDestinazioneUsoServizioEnteException</code> if it could not be found.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	public DestinazioneUsoServizioEnte findByPrimaryKey(
			it.servizidigitali.scrivaniaoperatore.service.persistence.
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK)
		throws NoSuchDestinazioneUsoServizioEnteException;

	/**
	 * Returns the destinazione uso servizio ente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente, or <code>null</code> if a destinazione uso servizio ente with the primary key could not be found
	 */
	public DestinazioneUsoServizioEnte fetchByPrimaryKey(
		it.servizidigitali.scrivaniaoperatore.service.persistence.
			DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK);

	/**
	 * Returns all the destinazione uso servizio entes.
	 *
	 * @return the destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findAll();

	/**
	 * Returns a range of all the destinazione uso servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator);

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of destinazione uso servizio entes
	 */
	public java.util.List<DestinazioneUsoServizioEnte> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DestinazioneUsoServizioEnte> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the destinazione uso servizio entes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of destinazione uso servizio entes.
	 *
	 * @return the number of destinazione uso servizio entes
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}