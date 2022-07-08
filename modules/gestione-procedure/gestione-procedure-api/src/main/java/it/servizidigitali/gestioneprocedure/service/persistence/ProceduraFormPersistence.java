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

import it.servizidigitali.gestioneprocedure.exception.NoSuchProceduraFormException;
import it.servizidigitali.gestioneprocedure.model.ProceduraForm;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the procedura form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProceduraFormUtil
 * @generated
 */
@ProviderType
public interface ProceduraFormPersistence
	extends BasePersistence<ProceduraForm> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProceduraFormUtil} to access the procedura form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the procedura forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedura forms
	 */
	public java.util.List<ProceduraForm> findByUuid(String uuid);

	/**
	 * Returns a range of all the procedura forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @return the range of matching procedura forms
	 */
	public java.util.List<ProceduraForm> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the procedura forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedura forms
	 */
	public java.util.List<ProceduraForm> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
			orderByComparator);

	/**
	 * Returns an ordered range of all the procedura forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedura forms
	 */
	public java.util.List<ProceduraForm> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	public ProceduraForm findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
				orderByComparator)
		throws NoSuchProceduraFormException;

	/**
	 * Returns the first procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	public ProceduraForm fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
			orderByComparator);

	/**
	 * Returns the last procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	public ProceduraForm findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
				orderByComparator)
		throws NoSuchProceduraFormException;

	/**
	 * Returns the last procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	public ProceduraForm fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
			orderByComparator);

	/**
	 * Returns the procedura forms before and after the current procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param proceduraFormPK the primary key of the current procedura form
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura form
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	public ProceduraForm[] findByUuid_PrevAndNext(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK,
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
				orderByComparator)
		throws NoSuchProceduraFormException;

	/**
	 * Removes all the procedura forms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of procedura forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedura forms
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedura forms
	 */
	public java.util.List<ProceduraForm> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @return the range of matching procedura forms
	 */
	public java.util.List<ProceduraForm> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedura forms
	 */
	public java.util.List<ProceduraForm> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
			orderByComparator);

	/**
	 * Returns an ordered range of all the procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedura forms
	 */
	public java.util.List<ProceduraForm> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	public ProceduraForm findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
				orderByComparator)
		throws NoSuchProceduraFormException;

	/**
	 * Returns the first procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	public ProceduraForm fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
			orderByComparator);

	/**
	 * Returns the last procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	public ProceduraForm findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
				orderByComparator)
		throws NoSuchProceduraFormException;

	/**
	 * Returns the last procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	public ProceduraForm fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
			orderByComparator);

	/**
	 * Returns the procedura forms before and after the current procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param proceduraFormPK the primary key of the current procedura form
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura form
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	public ProceduraForm[] findByUuid_C_PrevAndNext(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK,
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
				orderByComparator)
		throws NoSuchProceduraFormException;

	/**
	 * Removes all the procedura forms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedura forms
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the procedura form in the entity cache if it is enabled.
	 *
	 * @param proceduraForm the procedura form
	 */
	public void cacheResult(ProceduraForm proceduraForm);

	/**
	 * Caches the procedura forms in the entity cache if it is enabled.
	 *
	 * @param proceduraForms the procedura forms
	 */
	public void cacheResult(java.util.List<ProceduraForm> proceduraForms);

	/**
	 * Creates a new procedura form with the primary key. Does not add the procedura form to the database.
	 *
	 * @param proceduraFormPK the primary key for the new procedura form
	 * @return the new procedura form
	 */
	public ProceduraForm create(
		it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK
			proceduraFormPK);

	/**
	 * Removes the procedura form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proceduraFormPK the primary key of the procedura form
	 * @return the procedura form that was removed
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	public ProceduraForm remove(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK)
		throws NoSuchProceduraFormException;

	public ProceduraForm updateImpl(ProceduraForm proceduraForm);

	/**
	 * Returns the procedura form with the primary key or throws a <code>NoSuchProceduraFormException</code> if it could not be found.
	 *
	 * @param proceduraFormPK the primary key of the procedura form
	 * @return the procedura form
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	public ProceduraForm findByPrimaryKey(
			it.servizidigitali.gestioneprocedure.service.persistence.
				ProceduraFormPK proceduraFormPK)
		throws NoSuchProceduraFormException;

	/**
	 * Returns the procedura form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proceduraFormPK the primary key of the procedura form
	 * @return the procedura form, or <code>null</code> if a procedura form with the primary key could not be found
	 */
	public ProceduraForm fetchByPrimaryKey(
		it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK
			proceduraFormPK);

	/**
	 * Returns all the procedura forms.
	 *
	 * @return the procedura forms
	 */
	public java.util.List<ProceduraForm> findAll();

	/**
	 * Returns a range of all the procedura forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @return the range of procedura forms
	 */
	public java.util.List<ProceduraForm> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the procedura forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedura forms
	 */
	public java.util.List<ProceduraForm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
			orderByComparator);

	/**
	 * Returns an ordered range of all the procedura forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedura forms
	 */
	public java.util.List<ProceduraForm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProceduraForm>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the procedura forms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of procedura forms.
	 *
	 * @return the number of procedura forms
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}