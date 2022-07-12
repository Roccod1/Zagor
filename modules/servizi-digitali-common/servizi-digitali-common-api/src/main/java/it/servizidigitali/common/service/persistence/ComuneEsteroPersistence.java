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

package it.servizidigitali.common.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.common.exception.NoSuchComuneEsteroException;
import it.servizidigitali.common.model.ComuneEstero;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the comune estero service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComuneEsteroUtil
 * @generated
 */
@ProviderType
public interface ComuneEsteroPersistence extends BasePersistence<ComuneEstero> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ComuneEsteroUtil} to access the comune estero persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the comune estero where codice = &#63; or throws a <code>NoSuchComuneEsteroException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching comune estero
	 * @throws NoSuchComuneEsteroException if a matching comune estero could not be found
	 */
	public ComuneEstero findByCodice(int codice)
		throws NoSuchComuneEsteroException;

	/**
	 * Returns the comune estero where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching comune estero, or <code>null</code> if a matching comune estero could not be found
	 */
	public ComuneEstero fetchByCodice(int codice);

	/**
	 * Returns the comune estero where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune estero, or <code>null</code> if a matching comune estero could not be found
	 */
	public ComuneEstero fetchByCodice(int codice, boolean useFinderCache);

	/**
	 * Removes the comune estero where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the comune estero that was removed
	 */
	public ComuneEstero removeByCodice(int codice)
		throws NoSuchComuneEsteroException;

	/**
	 * Returns the number of comune esteros where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching comune esteros
	 */
	public int countByCodice(int codice);

	/**
	 * Returns all the comune esteros where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @return the matching comune esteros
	 */
	public java.util.List<ComuneEstero> findByDenominazioneLike(
		String denominazione);

	/**
	 * Returns a range of all the comune esteros where denominazione LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param denominazione the denominazione
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @return the range of matching comune esteros
	 */
	public java.util.List<ComuneEstero> findByDenominazioneLike(
		String denominazione, int start, int end);

	/**
	 * Returns an ordered range of all the comune esteros where denominazione LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param denominazione the denominazione
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comune esteros
	 */
	public java.util.List<ComuneEstero> findByDenominazioneLike(
		String denominazione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComuneEstero>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comune esteros where denominazione LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param denominazione the denominazione
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comune esteros
	 */
	public java.util.List<ComuneEstero> findByDenominazioneLike(
		String denominazione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComuneEstero>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune estero
	 * @throws NoSuchComuneEsteroException if a matching comune estero could not be found
	 */
	public ComuneEstero findByDenominazioneLike_First(
			String denominazione,
			com.liferay.portal.kernel.util.OrderByComparator<ComuneEstero>
				orderByComparator)
		throws NoSuchComuneEsteroException;

	/**
	 * Returns the first comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune estero, or <code>null</code> if a matching comune estero could not be found
	 */
	public ComuneEstero fetchByDenominazioneLike_First(
		String denominazione,
		com.liferay.portal.kernel.util.OrderByComparator<ComuneEstero>
			orderByComparator);

	/**
	 * Returns the last comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune estero
	 * @throws NoSuchComuneEsteroException if a matching comune estero could not be found
	 */
	public ComuneEstero findByDenominazioneLike_Last(
			String denominazione,
			com.liferay.portal.kernel.util.OrderByComparator<ComuneEstero>
				orderByComparator)
		throws NoSuchComuneEsteroException;

	/**
	 * Returns the last comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune estero, or <code>null</code> if a matching comune estero could not be found
	 */
	public ComuneEstero fetchByDenominazioneLike_Last(
		String denominazione,
		com.liferay.portal.kernel.util.OrderByComparator<ComuneEstero>
			orderByComparator);

	/**
	 * Returns the comune esteros before and after the current comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param comuneEsteroId the primary key of the current comune estero
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comune estero
	 * @throws NoSuchComuneEsteroException if a comune estero with the primary key could not be found
	 */
	public ComuneEstero[] findByDenominazioneLike_PrevAndNext(
			long comuneEsteroId, String denominazione,
			com.liferay.portal.kernel.util.OrderByComparator<ComuneEstero>
				orderByComparator)
		throws NoSuchComuneEsteroException;

	/**
	 * Removes all the comune esteros where denominazione LIKE &#63; from the database.
	 *
	 * @param denominazione the denominazione
	 */
	public void removeByDenominazioneLike(String denominazione);

	/**
	 * Returns the number of comune esteros where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @return the number of matching comune esteros
	 */
	public int countByDenominazioneLike(String denominazione);

	/**
	 * Caches the comune estero in the entity cache if it is enabled.
	 *
	 * @param comuneEstero the comune estero
	 */
	public void cacheResult(ComuneEstero comuneEstero);

	/**
	 * Caches the comune esteros in the entity cache if it is enabled.
	 *
	 * @param comuneEsteros the comune esteros
	 */
	public void cacheResult(java.util.List<ComuneEstero> comuneEsteros);

	/**
	 * Creates a new comune estero with the primary key. Does not add the comune estero to the database.
	 *
	 * @param comuneEsteroId the primary key for the new comune estero
	 * @return the new comune estero
	 */
	public ComuneEstero create(long comuneEsteroId);

	/**
	 * Removes the comune estero with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero that was removed
	 * @throws NoSuchComuneEsteroException if a comune estero with the primary key could not be found
	 */
	public ComuneEstero remove(long comuneEsteroId)
		throws NoSuchComuneEsteroException;

	public ComuneEstero updateImpl(ComuneEstero comuneEstero);

	/**
	 * Returns the comune estero with the primary key or throws a <code>NoSuchComuneEsteroException</code> if it could not be found.
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero
	 * @throws NoSuchComuneEsteroException if a comune estero with the primary key could not be found
	 */
	public ComuneEstero findByPrimaryKey(long comuneEsteroId)
		throws NoSuchComuneEsteroException;

	/**
	 * Returns the comune estero with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero, or <code>null</code> if a comune estero with the primary key could not be found
	 */
	public ComuneEstero fetchByPrimaryKey(long comuneEsteroId);

	/**
	 * Returns all the comune esteros.
	 *
	 * @return the comune esteros
	 */
	public java.util.List<ComuneEstero> findAll();

	/**
	 * Returns a range of all the comune esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @return the range of comune esteros
	 */
	public java.util.List<ComuneEstero> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the comune esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comune esteros
	 */
	public java.util.List<ComuneEstero> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComuneEstero>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comune esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comune esteros
	 */
	public java.util.List<ComuneEstero> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComuneEstero>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the comune esteros from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of comune esteros.
	 *
	 * @return the number of comune esteros
	 */
	public int countAll();

}