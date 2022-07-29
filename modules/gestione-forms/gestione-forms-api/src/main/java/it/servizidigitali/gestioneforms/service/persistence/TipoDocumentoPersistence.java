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

import it.servizidigitali.gestioneforms.exception.NoSuchTipoDocumentoException;
import it.servizidigitali.gestioneforms.model.TipoDocumento;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the tipo documento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoDocumentoUtil
 * @generated
 */
@ProviderType
public interface TipoDocumentoPersistence
	extends BasePersistence<TipoDocumento> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipoDocumentoUtil} to access the tipo documento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the tipo documentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tipo documentos
	 */
	public java.util.List<TipoDocumento> findByUuid(String uuid);

	/**
	 * Returns a range of all the tipo documentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of matching tipo documentos
	 */
	public java.util.List<TipoDocumento> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the tipo documentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo documentos
	 */
	public java.util.List<TipoDocumento> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipo documentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo documentos
	 */
	public java.util.List<TipoDocumento> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public TipoDocumento findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
				orderByComparator)
		throws NoSuchTipoDocumentoException;

	/**
	 * Returns the first tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public TipoDocumento fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator);

	/**
	 * Returns the last tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public TipoDocumento findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
				orderByComparator)
		throws NoSuchTipoDocumentoException;

	/**
	 * Returns the last tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public TipoDocumento fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator);

	/**
	 * Returns the tipo documentos before and after the current tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param tipoDocumentoId the primary key of the current tipo documento
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	public TipoDocumento[] findByUuid_PrevAndNext(
			long tipoDocumentoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
				orderByComparator)
		throws NoSuchTipoDocumentoException;

	/**
	 * Removes all the tipo documentos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of tipo documentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tipo documentos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the tipo documento where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTipoDocumentoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public TipoDocumento findByUUID_G(String uuid, long groupId)
		throws NoSuchTipoDocumentoException;

	/**
	 * Returns the tipo documento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public TipoDocumento fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the tipo documento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public TipoDocumento fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the tipo documento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tipo documento that was removed
	 */
	public TipoDocumento removeByUUID_G(String uuid, long groupId)
		throws NoSuchTipoDocumentoException;

	/**
	 * Returns the number of tipo documentos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tipo documentos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tipo documentos
	 */
	public java.util.List<TipoDocumento> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of matching tipo documentos
	 */
	public java.util.List<TipoDocumento> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo documentos
	 */
	public java.util.List<TipoDocumento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo documentos
	 */
	public java.util.List<TipoDocumento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public TipoDocumento findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
				orderByComparator)
		throws NoSuchTipoDocumentoException;

	/**
	 * Returns the first tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public TipoDocumento fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator);

	/**
	 * Returns the last tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public TipoDocumento findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
				orderByComparator)
		throws NoSuchTipoDocumentoException;

	/**
	 * Returns the last tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public TipoDocumento fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator);

	/**
	 * Returns the tipo documentos before and after the current tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param tipoDocumentoId the primary key of the current tipo documento
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	public TipoDocumento[] findByUuid_C_PrevAndNext(
			long tipoDocumentoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
				orderByComparator)
		throws NoSuchTipoDocumentoException;

	/**
	 * Removes all the tipo documentos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tipo documentos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the tipo documentos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching tipo documentos
	 */
	public java.util.List<TipoDocumento> findBystato(String stato);

	/**
	 * Returns a range of all the tipo documentos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of matching tipo documentos
	 */
	public java.util.List<TipoDocumento> findBystato(
		String stato, int start, int end);

	/**
	 * Returns an ordered range of all the tipo documentos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo documentos
	 */
	public java.util.List<TipoDocumento> findBystato(
		String stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipo documentos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo documentos
	 */
	public java.util.List<TipoDocumento> findBystato(
		String stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public TipoDocumento findBystato_First(
			String stato,
			com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
				orderByComparator)
		throws NoSuchTipoDocumentoException;

	/**
	 * Returns the first tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public TipoDocumento fetchBystato_First(
		String stato,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator);

	/**
	 * Returns the last tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	public TipoDocumento findBystato_Last(
			String stato,
			com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
				orderByComparator)
		throws NoSuchTipoDocumentoException;

	/**
	 * Returns the last tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	public TipoDocumento fetchBystato_Last(
		String stato,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator);

	/**
	 * Returns the tipo documentos before and after the current tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param tipoDocumentoId the primary key of the current tipo documento
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	public TipoDocumento[] findBystato_PrevAndNext(
			long tipoDocumentoId, String stato,
			com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
				orderByComparator)
		throws NoSuchTipoDocumentoException;

	/**
	 * Removes all the tipo documentos where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	public void removeBystato(String stato);

	/**
	 * Returns the number of tipo documentos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching tipo documentos
	 */
	public int countBystato(String stato);

	/**
	 * Caches the tipo documento in the entity cache if it is enabled.
	 *
	 * @param tipoDocumento the tipo documento
	 */
	public void cacheResult(TipoDocumento tipoDocumento);

	/**
	 * Caches the tipo documentos in the entity cache if it is enabled.
	 *
	 * @param tipoDocumentos the tipo documentos
	 */
	public void cacheResult(java.util.List<TipoDocumento> tipoDocumentos);

	/**
	 * Creates a new tipo documento with the primary key. Does not add the tipo documento to the database.
	 *
	 * @param tipoDocumentoId the primary key for the new tipo documento
	 * @return the new tipo documento
	 */
	public TipoDocumento create(long tipoDocumentoId);

	/**
	 * Removes the tipo documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento that was removed
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	public TipoDocumento remove(long tipoDocumentoId)
		throws NoSuchTipoDocumentoException;

	public TipoDocumento updateImpl(TipoDocumento tipoDocumento);

	/**
	 * Returns the tipo documento with the primary key or throws a <code>NoSuchTipoDocumentoException</code> if it could not be found.
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	public TipoDocumento findByPrimaryKey(long tipoDocumentoId)
		throws NoSuchTipoDocumentoException;

	/**
	 * Returns the tipo documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento, or <code>null</code> if a tipo documento with the primary key could not be found
	 */
	public TipoDocumento fetchByPrimaryKey(long tipoDocumentoId);

	/**
	 * Returns all the tipo documentos.
	 *
	 * @return the tipo documentos
	 */
	public java.util.List<TipoDocumento> findAll();

	/**
	 * Returns a range of all the tipo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of tipo documentos
	 */
	public java.util.List<TipoDocumento> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tipo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipo documentos
	 */
	public java.util.List<TipoDocumento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tipo documentos
	 */
	public java.util.List<TipoDocumento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoDocumento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the tipo documentos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tipo documentos.
	 *
	 * @return the number of tipo documentos
	 */
	public int countAll();

}