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

package it.servizidigitali.gestioneprocedure.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.gestioneprocedure.exception.NoSuchProceduraException;
import it.servizidigitali.gestioneprocedure.model.Procedura;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the procedura service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProceduraUtil
 * @generated
 */
@ProviderType
public interface ProceduraPersistence extends BasePersistence<Procedura> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProceduraUtil} to access the procedura persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the proceduras where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching proceduras
	 */
	public java.util.List<Procedura> findByUuid(String uuid);

	/**
	 * Returns a range of all the proceduras where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	public java.util.List<Procedura> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the proceduras where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	public java.util.List<Procedura> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns an ordered range of all the proceduras where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	public java.util.List<Procedura> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public Procedura findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Returns the first procedura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public Procedura fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns the last procedura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public Procedura findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Returns the last procedura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public Procedura fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where uuid = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public Procedura[] findByUuid_PrevAndNext(
			long proceduraId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Removes all the proceduras where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of proceduras where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching proceduras
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the procedura where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProceduraException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public Procedura findByUUID_G(String uuid, long groupId)
		throws NoSuchProceduraException;

	/**
	 * Returns the procedura where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public Procedura fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the procedura where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public Procedura fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the procedura where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedura that was removed
	 */
	public Procedura removeByUUID_G(String uuid, long groupId)
		throws NoSuchProceduraException;

	/**
	 * Returns the number of proceduras where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching proceduras
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching proceduras
	 */
	public java.util.List<Procedura> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	public java.util.List<Procedura> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	public java.util.List<Procedura> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns an ordered range of all the proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	public java.util.List<Procedura> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public Procedura findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Returns the first procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public Procedura fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns the last procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public Procedura findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Returns the last procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public Procedura fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public Procedura[] findByUuid_C_PrevAndNext(
			long proceduraId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Removes all the proceduras where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching proceduras
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the proceduras where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @return the matching proceduras
	 */
	public java.util.List<Procedura> findByAttiva(boolean attiva);

	/**
	 * Returns a range of all the proceduras where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	public java.util.List<Procedura> findByAttiva(
		boolean attiva, int start, int end);

	/**
	 * Returns an ordered range of all the proceduras where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	public java.util.List<Procedura> findByAttiva(
		boolean attiva, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns an ordered range of all the proceduras where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	public java.util.List<Procedura> findByAttiva(
		boolean attiva, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedura in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public Procedura findByAttiva_First(
			boolean attiva,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Returns the first procedura in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public Procedura fetchByAttiva_First(
		boolean attiva,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns the last procedura in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public Procedura findByAttiva_Last(
			boolean attiva,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Returns the last procedura in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public Procedura fetchByAttiva_Last(
		boolean attiva,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where attiva = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public Procedura[] findByAttiva_PrevAndNext(
			long proceduraId, boolean attiva,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Removes all the proceduras where attiva = &#63; from the database.
	 *
	 * @param attiva the attiva
	 */
	public void removeByAttiva(boolean attiva);

	/**
	 * Returns the number of proceduras where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @return the number of matching proceduras
	 */
	public int countByAttiva(boolean attiva);

	/**
	 * Returns all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @return the matching proceduras
	 */
	public java.util.List<Procedura> findByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId);

	/**
	 * Returns a range of all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	public java.util.List<Procedura> findByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId, int start, int end);

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	public java.util.List<Procedura> findByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	public java.util.List<Procedura> findByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public Procedura findByGroupIdServizioIdProcessoId_First(
			long groupId, long servizioId, long processoId,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public Procedura fetchByGroupIdServizioIdProcessoId_First(
		long groupId, long servizioId, long processoId,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public Procedura findByGroupIdServizioIdProcessoId_Last(
			long groupId, long servizioId, long processoId,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public Procedura fetchByGroupIdServizioIdProcessoId_Last(
		long groupId, long servizioId, long processoId,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public Procedura[] findByGroupIdServizioIdProcessoId_PrevAndNext(
			long proceduraId, long groupId, long servizioId, long processoId,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Removes all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 */
	public void removeByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId);

	/**
	 * Returns the number of proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @return the number of matching proceduras
	 */
	public int countByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId);

	/**
	 * Returns all the proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @return the matching proceduras
	 */
	public java.util.List<Procedura> findByGroupIdServizioId(
		long groupId, long servizioId);

	/**
	 * Returns a range of all the proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	public java.util.List<Procedura> findByGroupIdServizioId(
		long groupId, long servizioId, int start, int end);

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	public java.util.List<Procedura> findByGroupIdServizioId(
		long groupId, long servizioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	public java.util.List<Procedura> findByGroupIdServizioId(
		long groupId, long servizioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public Procedura findByGroupIdServizioId_First(
			long groupId, long servizioId,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public Procedura fetchByGroupIdServizioId_First(
		long groupId, long servizioId,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	public Procedura findByGroupIdServizioId_Last(
			long groupId, long servizioId,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	public Procedura fetchByGroupIdServizioId_Last(
		long groupId, long servizioId,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public Procedura[] findByGroupIdServizioId_PrevAndNext(
			long proceduraId, long groupId, long servizioId,
			com.liferay.portal.kernel.util.OrderByComparator<Procedura>
				orderByComparator)
		throws NoSuchProceduraException;

	/**
	 * Removes all the proceduras where groupId = &#63; and servizioId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 */
	public void removeByGroupIdServizioId(long groupId, long servizioId);

	/**
	 * Returns the number of proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @return the number of matching proceduras
	 */
	public int countByGroupIdServizioId(long groupId, long servizioId);

	/**
	 * Caches the procedura in the entity cache if it is enabled.
	 *
	 * @param procedura the procedura
	 */
	public void cacheResult(Procedura procedura);

	/**
	 * Caches the proceduras in the entity cache if it is enabled.
	 *
	 * @param proceduras the proceduras
	 */
	public void cacheResult(java.util.List<Procedura> proceduras);

	/**
	 * Creates a new procedura with the primary key. Does not add the procedura to the database.
	 *
	 * @param proceduraId the primary key for the new procedura
	 * @return the new procedura
	 */
	public Procedura create(long proceduraId);

	/**
	 * Removes the procedura with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proceduraId the primary key of the procedura
	 * @return the procedura that was removed
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public Procedura remove(long proceduraId) throws NoSuchProceduraException;

	public Procedura updateImpl(Procedura procedura);

	/**
	 * Returns the procedura with the primary key or throws a <code>NoSuchProceduraException</code> if it could not be found.
	 *
	 * @param proceduraId the primary key of the procedura
	 * @return the procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	public Procedura findByPrimaryKey(long proceduraId)
		throws NoSuchProceduraException;

	/**
	 * Returns the procedura with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proceduraId the primary key of the procedura
	 * @return the procedura, or <code>null</code> if a procedura with the primary key could not be found
	 */
	public Procedura fetchByPrimaryKey(long proceduraId);

	/**
	 * Returns all the proceduras.
	 *
	 * @return the proceduras
	 */
	public java.util.List<Procedura> findAll();

	/**
	 * Returns a range of all the proceduras.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of proceduras
	 */
	public java.util.List<Procedura> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the proceduras.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proceduras
	 */
	public java.util.List<Procedura> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator);

	/**
	 * Returns an ordered range of all the proceduras.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of proceduras
	 */
	public java.util.List<Procedura> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Procedura>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the proceduras from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of proceduras.
	 *
	 * @return the number of proceduras
	 */
	public int countAll();

}