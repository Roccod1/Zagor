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

import it.servizidigitali.gestioneprocedure.exception.NoSuchTemplatePdfException;
import it.servizidigitali.gestioneprocedure.model.TemplatePdf;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the template pdf service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TemplatePdfUtil
 * @generated
 */
@ProviderType
public interface TemplatePdfPersistence extends BasePersistence<TemplatePdf> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TemplatePdfUtil} to access the template pdf persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the template pdfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByUuid(String uuid);

	/**
	 * Returns a range of all the template pdfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the template pdfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns an ordered range of all the template pdfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public TemplatePdf findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
				orderByComparator)
		throws NoSuchTemplatePdfException;

	/**
	 * Returns the first template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public TemplatePdf fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns the last template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public TemplatePdf findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
				orderByComparator)
		throws NoSuchTemplatePdfException;

	/**
	 * Returns the last template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public TemplatePdf fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns the template pdfs before and after the current template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param templatePdfId the primary key of the current template pdf
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	public TemplatePdf[] findByUuid_PrevAndNext(
			long templatePdfId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
				orderByComparator)
		throws NoSuchTemplatePdfException;

	/**
	 * Removes all the template pdfs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of template pdfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching template pdfs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the template pdf where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTemplatePdfException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public TemplatePdf findByUUID_G(String uuid, long groupId)
		throws NoSuchTemplatePdfException;

	/**
	 * Returns the template pdf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public TemplatePdf fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the template pdf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public TemplatePdf fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the template pdf where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the template pdf that was removed
	 */
	public TemplatePdf removeByUUID_G(String uuid, long groupId)
		throws NoSuchTemplatePdfException;

	/**
	 * Returns the number of template pdfs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching template pdfs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns an ordered range of all the template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public TemplatePdf findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
				orderByComparator)
		throws NoSuchTemplatePdfException;

	/**
	 * Returns the first template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public TemplatePdf fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns the last template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public TemplatePdf findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
				orderByComparator)
		throws NoSuchTemplatePdfException;

	/**
	 * Returns the last template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public TemplatePdf fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns the template pdfs before and after the current template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param templatePdfId the primary key of the current template pdf
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	public TemplatePdf[] findByUuid_C_PrevAndNext(
			long templatePdfId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
				orderByComparator)
		throws NoSuchTemplatePdfException;

	/**
	 * Removes all the template pdfs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching template pdfs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the template pdfs where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @return the matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByTemplatePdfParentId(
		long templatePdfParentId);

	/**
	 * Returns a range of all the template pdfs where templatePdfParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByTemplatePdfParentId(
		long templatePdfParentId, int start, int end);

	/**
	 * Returns an ordered range of all the template pdfs where templatePdfParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByTemplatePdfParentId(
		long templatePdfParentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns an ordered range of all the template pdfs where templatePdfParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByTemplatePdfParentId(
		long templatePdfParentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public TemplatePdf findByTemplatePdfParentId_First(
			long templatePdfParentId,
			com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
				orderByComparator)
		throws NoSuchTemplatePdfException;

	/**
	 * Returns the first template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public TemplatePdf fetchByTemplatePdfParentId_First(
		long templatePdfParentId,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns the last template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public TemplatePdf findByTemplatePdfParentId_Last(
			long templatePdfParentId,
			com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
				orderByComparator)
		throws NoSuchTemplatePdfException;

	/**
	 * Returns the last template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public TemplatePdf fetchByTemplatePdfParentId_Last(
		long templatePdfParentId,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns the template pdfs before and after the current template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfId the primary key of the current template pdf
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	public TemplatePdf[] findByTemplatePdfParentId_PrevAndNext(
			long templatePdfId, long templatePdfParentId,
			com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
				orderByComparator)
		throws NoSuchTemplatePdfException;

	/**
	 * Removes all the template pdfs where templatePdfParentId = &#63; from the database.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 */
	public void removeByTemplatePdfParentId(long templatePdfParentId);

	/**
	 * Returns the number of template pdfs where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @return the number of matching template pdfs
	 */
	public int countByTemplatePdfParentId(long templatePdfParentId);

	/**
	 * Returns all the template pdfs where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByProceduraId(long proceduraId);

	/**
	 * Returns a range of all the template pdfs where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByProceduraId(
		long proceduraId, int start, int end);

	/**
	 * Returns an ordered range of all the template pdfs where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByProceduraId(
		long proceduraId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns an ordered range of all the template pdfs where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching template pdfs
	 */
	public java.util.List<TemplatePdf> findByProceduraId(
		long proceduraId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first template pdf in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public TemplatePdf findByProceduraId_First(
			long proceduraId,
			com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
				orderByComparator)
		throws NoSuchTemplatePdfException;

	/**
	 * Returns the first template pdf in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public TemplatePdf fetchByProceduraId_First(
		long proceduraId,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns the last template pdf in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	public TemplatePdf findByProceduraId_Last(
			long proceduraId,
			com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
				orderByComparator)
		throws NoSuchTemplatePdfException;

	/**
	 * Returns the last template pdf in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	public TemplatePdf fetchByProceduraId_Last(
		long proceduraId,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns the template pdfs before and after the current template pdf in the ordered set where proceduraId = &#63;.
	 *
	 * @param templatePdfId the primary key of the current template pdf
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	public TemplatePdf[] findByProceduraId_PrevAndNext(
			long templatePdfId, long proceduraId,
			com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
				orderByComparator)
		throws NoSuchTemplatePdfException;

	/**
	 * Removes all the template pdfs where proceduraId = &#63; from the database.
	 *
	 * @param proceduraId the procedura ID
	 */
	public void removeByProceduraId(long proceduraId);

	/**
	 * Returns the number of template pdfs where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the number of matching template pdfs
	 */
	public int countByProceduraId(long proceduraId);

	/**
	 * Caches the template pdf in the entity cache if it is enabled.
	 *
	 * @param templatePdf the template pdf
	 */
	public void cacheResult(TemplatePdf templatePdf);

	/**
	 * Caches the template pdfs in the entity cache if it is enabled.
	 *
	 * @param templatePdfs the template pdfs
	 */
	public void cacheResult(java.util.List<TemplatePdf> templatePdfs);

	/**
	 * Creates a new template pdf with the primary key. Does not add the template pdf to the database.
	 *
	 * @param templatePdfId the primary key for the new template pdf
	 * @return the new template pdf
	 */
	public TemplatePdf create(long templatePdfId);

	/**
	 * Removes the template pdf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf that was removed
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	public TemplatePdf remove(long templatePdfId)
		throws NoSuchTemplatePdfException;

	public TemplatePdf updateImpl(TemplatePdf templatePdf);

	/**
	 * Returns the template pdf with the primary key or throws a <code>NoSuchTemplatePdfException</code> if it could not be found.
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	public TemplatePdf findByPrimaryKey(long templatePdfId)
		throws NoSuchTemplatePdfException;

	/**
	 * Returns the template pdf with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf, or <code>null</code> if a template pdf with the primary key could not be found
	 */
	public TemplatePdf fetchByPrimaryKey(long templatePdfId);

	/**
	 * Returns all the template pdfs.
	 *
	 * @return the template pdfs
	 */
	public java.util.List<TemplatePdf> findAll();

	/**
	 * Returns a range of all the template pdfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of template pdfs
	 */
	public java.util.List<TemplatePdf> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the template pdfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of template pdfs
	 */
	public java.util.List<TemplatePdf> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator);

	/**
	 * Returns an ordered range of all the template pdfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of template pdfs
	 */
	public java.util.List<TemplatePdf> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TemplatePdf>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the template pdfs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of template pdfs.
	 *
	 * @return the number of template pdfs
	 */
	public int countAll();

}