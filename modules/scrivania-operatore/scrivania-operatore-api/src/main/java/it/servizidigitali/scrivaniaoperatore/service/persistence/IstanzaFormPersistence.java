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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchIstanzaFormException;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the istanza form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IstanzaFormUtil
 * @generated
 */
@ProviderType
public interface IstanzaFormPersistence extends BasePersistence<IstanzaForm> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IstanzaFormUtil} to access the istanza form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the istanza forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByUuid(String uuid);

	/**
	 * Returns a range of all the istanza forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the istanza forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns an ordered range of all the istanza forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public IstanzaForm findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
				orderByComparator)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the first istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public IstanzaForm fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns the last istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public IstanzaForm findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
				orderByComparator)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the last istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public IstanzaForm fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns the istanza forms before and after the current istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param istanzaFormId the primary key of the current istanza form
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	public IstanzaForm[] findByUuid_PrevAndNext(
			long istanzaFormId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
				orderByComparator)
		throws NoSuchIstanzaFormException;

	/**
	 * Removes all the istanza forms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of istanza forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching istanza forms
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the istanza form where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIstanzaFormException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public IstanzaForm findByUUID_G(String uuid, long groupId)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the istanza form where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public IstanzaForm fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the istanza form where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public IstanzaForm fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the istanza form where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the istanza form that was removed
	 */
	public IstanzaForm removeByUUID_G(String uuid, long groupId)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the number of istanza forms where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching istanza forms
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns an ordered range of all the istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public IstanzaForm findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
				orderByComparator)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the first istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public IstanzaForm fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns the last istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public IstanzaForm findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
				orderByComparator)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the last istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public IstanzaForm fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns the istanza forms before and after the current istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param istanzaFormId the primary key of the current istanza form
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	public IstanzaForm[] findByUuid_C_PrevAndNext(
			long istanzaFormId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
				orderByComparator)
		throws NoSuchIstanzaFormException;

	/**
	 * Removes all the istanza forms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching istanza forms
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the istanza forms where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByRichiestaId(long richiestaId);

	/**
	 * Returns a range of all the istanza forms where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByRichiestaId(
		long richiestaId, int start, int end);

	/**
	 * Returns an ordered range of all the istanza forms where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByRichiestaId(
		long richiestaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns an ordered range of all the istanza forms where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByRichiestaId(
		long richiestaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first istanza form in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public IstanzaForm findByRichiestaId_First(
			long richiestaId,
			com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
				orderByComparator)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the first istanza form in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public IstanzaForm fetchByRichiestaId_First(
		long richiestaId,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns the last istanza form in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public IstanzaForm findByRichiestaId_Last(
			long richiestaId,
			com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
				orderByComparator)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the last istanza form in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public IstanzaForm fetchByRichiestaId_Last(
		long richiestaId,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns the istanza forms before and after the current istanza form in the ordered set where richiestaId = &#63;.
	 *
	 * @param istanzaFormId the primary key of the current istanza form
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	public IstanzaForm[] findByRichiestaId_PrevAndNext(
			long istanzaFormId, long richiestaId,
			com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
				orderByComparator)
		throws NoSuchIstanzaFormException;

	/**
	 * Removes all the istanza forms where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 */
	public void removeByRichiestaId(long richiestaId);

	/**
	 * Returns the number of istanza forms where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching istanza forms
	 */
	public int countByRichiestaId(long richiestaId);

	/**
	 * Returns the istanza form where richiestaId = &#63; and formId = &#63; or throws a <code>NoSuchIstanzaFormException</code> if it could not be found.
	 *
	 * @param richiestaId the richiesta ID
	 * @param formId the form ID
	 * @return the matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public IstanzaForm findByRichiestaIdFormId(long richiestaId, long formId)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the istanza form where richiestaId = &#63; and formId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param formId the form ID
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public IstanzaForm fetchByRichiestaIdFormId(long richiestaId, long formId);

	/**
	 * Returns the istanza form where richiestaId = &#63; and formId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param formId the form ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public IstanzaForm fetchByRichiestaIdFormId(
		long richiestaId, long formId, boolean useFinderCache);

	/**
	 * Removes the istanza form where richiestaId = &#63; and formId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param formId the form ID
	 * @return the istanza form that was removed
	 */
	public IstanzaForm removeByRichiestaIdFormId(long richiestaId, long formId)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the number of istanza forms where richiestaId = &#63; and formId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param formId the form ID
	 * @return the number of matching istanza forms
	 */
	public int countByRichiestaIdFormId(long richiestaId, long formId);

	/**
	 * Returns all the istanza forms where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @return the matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByFormId(long formId);

	/**
	 * Returns a range of all the istanza forms where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByFormId(
		long formId, int start, int end);

	/**
	 * Returns an ordered range of all the istanza forms where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByFormId(
		long formId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns an ordered range of all the istanza forms where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching istanza forms
	 */
	public java.util.List<IstanzaForm> findByFormId(
		long formId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first istanza form in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public IstanzaForm findByFormId_First(
			long formId,
			com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
				orderByComparator)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the first istanza form in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public IstanzaForm fetchByFormId_First(
		long formId,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns the last istanza form in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	public IstanzaForm findByFormId_Last(
			long formId,
			com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
				orderByComparator)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the last istanza form in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	public IstanzaForm fetchByFormId_Last(
		long formId,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns the istanza forms before and after the current istanza form in the ordered set where formId = &#63;.
	 *
	 * @param istanzaFormId the primary key of the current istanza form
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	public IstanzaForm[] findByFormId_PrevAndNext(
			long istanzaFormId, long formId,
			com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
				orderByComparator)
		throws NoSuchIstanzaFormException;

	/**
	 * Removes all the istanza forms where formId = &#63; from the database.
	 *
	 * @param formId the form ID
	 */
	public void removeByFormId(long formId);

	/**
	 * Returns the number of istanza forms where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @return the number of matching istanza forms
	 */
	public int countByFormId(long formId);

	/**
	 * Caches the istanza form in the entity cache if it is enabled.
	 *
	 * @param istanzaForm the istanza form
	 */
	public void cacheResult(IstanzaForm istanzaForm);

	/**
	 * Caches the istanza forms in the entity cache if it is enabled.
	 *
	 * @param istanzaForms the istanza forms
	 */
	public void cacheResult(java.util.List<IstanzaForm> istanzaForms);

	/**
	 * Creates a new istanza form with the primary key. Does not add the istanza form to the database.
	 *
	 * @param istanzaFormId the primary key for the new istanza form
	 * @return the new istanza form
	 */
	public IstanzaForm create(long istanzaFormId);

	/**
	 * Removes the istanza form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form that was removed
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	public IstanzaForm remove(long istanzaFormId)
		throws NoSuchIstanzaFormException;

	public IstanzaForm updateImpl(IstanzaForm istanzaForm);

	/**
	 * Returns the istanza form with the primary key or throws a <code>NoSuchIstanzaFormException</code> if it could not be found.
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	public IstanzaForm findByPrimaryKey(long istanzaFormId)
		throws NoSuchIstanzaFormException;

	/**
	 * Returns the istanza form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form, or <code>null</code> if a istanza form with the primary key could not be found
	 */
	public IstanzaForm fetchByPrimaryKey(long istanzaFormId);

	/**
	 * Returns all the istanza forms.
	 *
	 * @return the istanza forms
	 */
	public java.util.List<IstanzaForm> findAll();

	/**
	 * Returns a range of all the istanza forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of istanza forms
	 */
	public java.util.List<IstanzaForm> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the istanza forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of istanza forms
	 */
	public java.util.List<IstanzaForm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator);

	/**
	 * Returns an ordered range of all the istanza forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of istanza forms
	 */
	public java.util.List<IstanzaForm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IstanzaForm>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the istanza forms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of istanza forms.
	 *
	 * @return the number of istanza forms
	 */
	public int countAll();

}