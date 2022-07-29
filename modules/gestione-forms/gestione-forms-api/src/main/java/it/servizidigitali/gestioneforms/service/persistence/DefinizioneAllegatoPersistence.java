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

package it.servizidigitali.gestioneforms.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.gestioneforms.exception.NoSuchDefinizioneAllegatoException;
import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the definizione allegato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DefinizioneAllegatoUtil
 * @generated
 */
@ProviderType
public interface DefinizioneAllegatoPersistence
	extends BasePersistence<DefinizioneAllegato> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DefinizioneAllegatoUtil} to access the definizione allegato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the definizione allegatos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findByUuid(String uuid);

	/**
	 * Returns a range of all the definizione allegatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of matching definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the definizione allegatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the definizione allegatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException;

	/**
	 * Returns the first definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator);

	/**
	 * Returns the last definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException;

	/**
	 * Returns the last definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator);

	/**
	 * Returns the definizione allegatos before and after the current definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param definizioneAllegatoId the primary key of the current definizione allegato
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	public DefinizioneAllegato[] findByUuid_PrevAndNext(
			long definizioneAllegatoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException;

	/**
	 * Removes all the definizione allegatos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of definizione allegatos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching definizione allegatos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the definizione allegato where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDefinizioneAllegatoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato findByUUID_G(String uuid, long groupId)
		throws NoSuchDefinizioneAllegatoException;

	/**
	 * Returns the definizione allegato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the definizione allegato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the definizione allegato where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the definizione allegato that was removed
	 */
	public DefinizioneAllegato removeByUUID_G(String uuid, long groupId)
		throws NoSuchDefinizioneAllegatoException;

	/**
	 * Returns the number of definizione allegatos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching definizione allegatos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of matching definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException;

	/**
	 * Returns the first definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator);

	/**
	 * Returns the last definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException;

	/**
	 * Returns the last definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator);

	/**
	 * Returns the definizione allegatos before and after the current definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param definizioneAllegatoId the primary key of the current definizione allegato
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	public DefinizioneAllegato[] findByUuid_C_PrevAndNext(
			long definizioneAllegatoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException;

	/**
	 * Removes all the definizione allegatos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching definizione allegatos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the definizione allegatos where formId = &#63; and eliminato = &#63;.
	 *
	 * @param formId the form ID
	 * @param eliminato the eliminato
	 * @return the matching definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findByformIdAndEliminato(
		long formId, boolean eliminato);

	/**
	 * Returns a range of all the definizione allegatos where formId = &#63; and eliminato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param eliminato the eliminato
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of matching definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findByformIdAndEliminato(
		long formId, boolean eliminato, int start, int end);

	/**
	 * Returns an ordered range of all the definizione allegatos where formId = &#63; and eliminato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param eliminato the eliminato
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findByformIdAndEliminato(
		long formId, boolean eliminato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the definizione allegatos where formId = &#63; and eliminato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param eliminato the eliminato
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findByformIdAndEliminato(
		long formId, boolean eliminato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first definizione allegato in the ordered set where formId = &#63; and eliminato = &#63;.
	 *
	 * @param formId the form ID
	 * @param eliminato the eliminato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato findByformIdAndEliminato_First(
			long formId, boolean eliminato,
			com.liferay.portal.kernel.util.OrderByComparator
				<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException;

	/**
	 * Returns the first definizione allegato in the ordered set where formId = &#63; and eliminato = &#63;.
	 *
	 * @param formId the form ID
	 * @param eliminato the eliminato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato fetchByformIdAndEliminato_First(
		long formId, boolean eliminato,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator);

	/**
	 * Returns the last definizione allegato in the ordered set where formId = &#63; and eliminato = &#63;.
	 *
	 * @param formId the form ID
	 * @param eliminato the eliminato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato findByformIdAndEliminato_Last(
			long formId, boolean eliminato,
			com.liferay.portal.kernel.util.OrderByComparator
				<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException;

	/**
	 * Returns the last definizione allegato in the ordered set where formId = &#63; and eliminato = &#63;.
	 *
	 * @param formId the form ID
	 * @param eliminato the eliminato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	public DefinizioneAllegato fetchByformIdAndEliminato_Last(
		long formId, boolean eliminato,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator);

	/**
	 * Returns the definizione allegatos before and after the current definizione allegato in the ordered set where formId = &#63; and eliminato = &#63;.
	 *
	 * @param definizioneAllegatoId the primary key of the current definizione allegato
	 * @param formId the form ID
	 * @param eliminato the eliminato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	public DefinizioneAllegato[] findByformIdAndEliminato_PrevAndNext(
			long definizioneAllegatoId, long formId, boolean eliminato,
			com.liferay.portal.kernel.util.OrderByComparator
				<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException;

	/**
	 * Removes all the definizione allegatos where formId = &#63; and eliminato = &#63; from the database.
	 *
	 * @param formId the form ID
	 * @param eliminato the eliminato
	 */
	public void removeByformIdAndEliminato(long formId, boolean eliminato);

	/**
	 * Returns the number of definizione allegatos where formId = &#63; and eliminato = &#63;.
	 *
	 * @param formId the form ID
	 * @param eliminato the eliminato
	 * @return the number of matching definizione allegatos
	 */
	public int countByformIdAndEliminato(long formId, boolean eliminato);

	/**
	 * Caches the definizione allegato in the entity cache if it is enabled.
	 *
	 * @param definizioneAllegato the definizione allegato
	 */
	public void cacheResult(DefinizioneAllegato definizioneAllegato);

	/**
	 * Caches the definizione allegatos in the entity cache if it is enabled.
	 *
	 * @param definizioneAllegatos the definizione allegatos
	 */
	public void cacheResult(
		java.util.List<DefinizioneAllegato> definizioneAllegatos);

	/**
	 * Creates a new definizione allegato with the primary key. Does not add the definizione allegato to the database.
	 *
	 * @param definizioneAllegatoId the primary key for the new definizione allegato
	 * @return the new definizione allegato
	 */
	public DefinizioneAllegato create(long definizioneAllegatoId);

	/**
	 * Removes the definizione allegato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato that was removed
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	public DefinizioneAllegato remove(long definizioneAllegatoId)
		throws NoSuchDefinizioneAllegatoException;

	public DefinizioneAllegato updateImpl(
		DefinizioneAllegato definizioneAllegato);

	/**
	 * Returns the definizione allegato with the primary key or throws a <code>NoSuchDefinizioneAllegatoException</code> if it could not be found.
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	public DefinizioneAllegato findByPrimaryKey(long definizioneAllegatoId)
		throws NoSuchDefinizioneAllegatoException;

	/**
	 * Returns the definizione allegato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato, or <code>null</code> if a definizione allegato with the primary key could not be found
	 */
	public DefinizioneAllegato fetchByPrimaryKey(long definizioneAllegatoId);

	/**
	 * Returns all the definizione allegatos.
	 *
	 * @return the definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findAll();

	/**
	 * Returns a range of all the definizione allegatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the definizione allegatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the definizione allegatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of definizione allegatos
	 */
	public java.util.List<DefinizioneAllegato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DefinizioneAllegato>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the definizione allegatos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of definizione allegatos.
	 *
	 * @return the number of definizione allegatos
	 */
	public int countAll();

}