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

import it.servizidigitali.gestioneforms.exception.NoSuchFormException;
import it.servizidigitali.gestioneforms.model.Form;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormUtil
 * @generated
 */
@ProviderType
public interface FormPersistence extends BasePersistence<Form> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FormUtil} to access the form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching forms
	 */
	public java.util.List<Form> findByUuid(String uuid);

	/**
	 * Returns a range of all the forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @return the range of matching forms
	 */
	public java.util.List<Form> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching forms
	 */
	public java.util.List<Form> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator);

	/**
	 * Returns an ordered range of all the forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching forms
	 */
	public java.util.List<Form> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public Form findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Form>
				orderByComparator)
		throws NoSuchFormException;

	/**
	 * Returns the first form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form, or <code>null</code> if a matching form could not be found
	 */
	public Form fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator);

	/**
	 * Returns the last form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public Form findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Form>
				orderByComparator)
		throws NoSuchFormException;

	/**
	 * Returns the last form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form, or <code>null</code> if a matching form could not be found
	 */
	public Form fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator);

	/**
	 * Returns the forms before and after the current form in the ordered set where uuid = &#63;.
	 *
	 * @param formId the primary key of the current form
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public Form[] findByUuid_PrevAndNext(
			long formId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Form>
				orderByComparator)
		throws NoSuchFormException;

	/**
	 * Removes all the forms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching forms
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the form where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFormException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public Form findByUUID_G(String uuid, long groupId)
		throws NoSuchFormException;

	/**
	 * Returns the form where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form, or <code>null</code> if a matching form could not be found
	 */
	public Form fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the form where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form, or <code>null</code> if a matching form could not be found
	 */
	public Form fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the form where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the form that was removed
	 */
	public Form removeByUUID_G(String uuid, long groupId)
		throws NoSuchFormException;

	/**
	 * Returns the number of forms where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching forms
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching forms
	 */
	public java.util.List<Form> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @return the range of matching forms
	 */
	public java.util.List<Form> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching forms
	 */
	public java.util.List<Form> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator);

	/**
	 * Returns an ordered range of all the forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching forms
	 */
	public java.util.List<Form> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public Form findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Form>
				orderByComparator)
		throws NoSuchFormException;

	/**
	 * Returns the first form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form, or <code>null</code> if a matching form could not be found
	 */
	public Form fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator);

	/**
	 * Returns the last form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public Form findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Form>
				orderByComparator)
		throws NoSuchFormException;

	/**
	 * Returns the last form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form, or <code>null</code> if a matching form could not be found
	 */
	public Form fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator);

	/**
	 * Returns the forms before and after the current form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param formId the primary key of the current form
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public Form[] findByUuid_C_PrevAndNext(
			long formId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Form>
				orderByComparator)
		throws NoSuchFormException;

	/**
	 * Removes all the forms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching forms
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the form where codice = &#63; or throws a <code>NoSuchFormException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public Form findByCodice(String codice) throws NoSuchFormException;

	/**
	 * Returns the form where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching form, or <code>null</code> if a matching form could not be found
	 */
	public Form fetchByCodice(String codice);

	/**
	 * Returns the form where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form, or <code>null</code> if a matching form could not be found
	 */
	public Form fetchByCodice(String codice, boolean useFinderCache);

	/**
	 * Removes the form where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the form that was removed
	 */
	public Form removeByCodice(String codice) throws NoSuchFormException;

	/**
	 * Returns the number of forms where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching forms
	 */
	public int countByCodice(String codice);

	/**
	 * Returns all the forms where principale = &#63;.
	 *
	 * @param principale the principale
	 * @return the matching forms
	 */
	public java.util.List<Form> findByPrincipale(boolean principale);

	/**
	 * Returns a range of all the forms where principale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param principale the principale
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @return the range of matching forms
	 */
	public java.util.List<Form> findByPrincipale(
		boolean principale, int start, int end);

	/**
	 * Returns an ordered range of all the forms where principale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param principale the principale
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching forms
	 */
	public java.util.List<Form> findByPrincipale(
		boolean principale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator);

	/**
	 * Returns an ordered range of all the forms where principale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param principale the principale
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching forms
	 */
	public java.util.List<Form> findByPrincipale(
		boolean principale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first form in the ordered set where principale = &#63;.
	 *
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public Form findByPrincipale_First(
			boolean principale,
			com.liferay.portal.kernel.util.OrderByComparator<Form>
				orderByComparator)
		throws NoSuchFormException;

	/**
	 * Returns the first form in the ordered set where principale = &#63;.
	 *
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form, or <code>null</code> if a matching form could not be found
	 */
	public Form fetchByPrincipale_First(
		boolean principale,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator);

	/**
	 * Returns the last form in the ordered set where principale = &#63;.
	 *
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form
	 * @throws NoSuchFormException if a matching form could not be found
	 */
	public Form findByPrincipale_Last(
			boolean principale,
			com.liferay.portal.kernel.util.OrderByComparator<Form>
				orderByComparator)
		throws NoSuchFormException;

	/**
	 * Returns the last form in the ordered set where principale = &#63;.
	 *
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form, or <code>null</code> if a matching form could not be found
	 */
	public Form fetchByPrincipale_Last(
		boolean principale,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator);

	/**
	 * Returns the forms before and after the current form in the ordered set where principale = &#63;.
	 *
	 * @param formId the primary key of the current form
	 * @param principale the principale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public Form[] findByPrincipale_PrevAndNext(
			long formId, boolean principale,
			com.liferay.portal.kernel.util.OrderByComparator<Form>
				orderByComparator)
		throws NoSuchFormException;

	/**
	 * Removes all the forms where principale = &#63; from the database.
	 *
	 * @param principale the principale
	 */
	public void removeByPrincipale(boolean principale);

	/**
	 * Returns the number of forms where principale = &#63;.
	 *
	 * @param principale the principale
	 * @return the number of matching forms
	 */
	public int countByPrincipale(boolean principale);

	/**
	 * Caches the form in the entity cache if it is enabled.
	 *
	 * @param form the form
	 */
	public void cacheResult(Form form);

	/**
	 * Caches the forms in the entity cache if it is enabled.
	 *
	 * @param forms the forms
	 */
	public void cacheResult(java.util.List<Form> forms);

	/**
	 * Creates a new form with the primary key. Does not add the form to the database.
	 *
	 * @param formId the primary key for the new form
	 * @return the new form
	 */
	public Form create(long formId);

	/**
	 * Removes the form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formId the primary key of the form
	 * @return the form that was removed
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public Form remove(long formId) throws NoSuchFormException;

	public Form updateImpl(Form form);

	/**
	 * Returns the form with the primary key or throws a <code>NoSuchFormException</code> if it could not be found.
	 *
	 * @param formId the primary key of the form
	 * @return the form
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public Form findByPrimaryKey(long formId) throws NoSuchFormException;

	/**
	 * Returns the form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formId the primary key of the form
	 * @return the form, or <code>null</code> if a form with the primary key could not be found
	 */
	public Form fetchByPrimaryKey(long formId);

	/**
	 * Returns all the forms.
	 *
	 * @return the forms
	 */
	public java.util.List<Form> findAll();

	/**
	 * Returns a range of all the forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @return the range of forms
	 */
	public java.util.List<Form> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of forms
	 */
	public java.util.List<Form> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator);

	/**
	 * Returns an ordered range of all the forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of forms
	 */
	public java.util.List<Form> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the forms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of forms.
	 *
	 * @return the number of forms
	 */
	public int countAll();

}