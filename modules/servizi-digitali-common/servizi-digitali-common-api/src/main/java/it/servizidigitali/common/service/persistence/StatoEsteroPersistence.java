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

import it.servizidigitali.common.exception.NoSuchStatoEsteroException;
import it.servizidigitali.common.model.StatoEstero;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the stato estero service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoEsteroUtil
 * @generated
 */
@ProviderType
public interface StatoEsteroPersistence extends BasePersistence<StatoEstero> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatoEsteroUtil} to access the stato estero persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the stato estero where codiceStato = &#63; or throws a <code>NoSuchStatoEsteroException</code> if it could not be found.
	 *
	 * @param codiceStato the codice stato
	 * @return the matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	public StatoEstero findByCodiceStato(int codiceStato)
		throws NoSuchStatoEsteroException;

	/**
	 * Returns the stato estero where codiceStato = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceStato the codice stato
	 * @return the matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public StatoEstero fetchByCodiceStato(int codiceStato);

	/**
	 * Returns the stato estero where codiceStato = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceStato the codice stato
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public StatoEstero fetchByCodiceStato(
		int codiceStato, boolean useFinderCache);

	/**
	 * Removes the stato estero where codiceStato = &#63; from the database.
	 *
	 * @param codiceStato the codice stato
	 * @return the stato estero that was removed
	 */
	public StatoEstero removeByCodiceStato(int codiceStato)
		throws NoSuchStatoEsteroException;

	/**
	 * Returns the number of stato esteros where codiceStato = &#63;.
	 *
	 * @param codiceStato the codice stato
	 * @return the number of matching stato esteros
	 */
	public int countByCodiceStato(int codiceStato);

	/**
	 * Returns the stato estero where denominazione = &#63; or throws a <code>NoSuchStatoEsteroException</code> if it could not be found.
	 *
	 * @param denominazione the denominazione
	 * @return the matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	public StatoEstero findByDenominazione(String denominazione)
		throws NoSuchStatoEsteroException;

	/**
	 * Returns the stato estero where denominazione = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param denominazione the denominazione
	 * @return the matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public StatoEstero fetchByDenominazione(String denominazione);

	/**
	 * Returns the stato estero where denominazione = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param denominazione the denominazione
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public StatoEstero fetchByDenominazione(
		String denominazione, boolean useFinderCache);

	/**
	 * Removes the stato estero where denominazione = &#63; from the database.
	 *
	 * @param denominazione the denominazione
	 * @return the stato estero that was removed
	 */
	public StatoEstero removeByDenominazione(String denominazione)
		throws NoSuchStatoEsteroException;

	/**
	 * Returns the number of stato esteros where denominazione = &#63;.
	 *
	 * @param denominazione the denominazione
	 * @return the number of matching stato esteros
	 */
	public int countByDenominazione(String denominazione);

	/**
	 * Returns all the stato esteros where continente = &#63;.
	 *
	 * @param continente the continente
	 * @return the matching stato esteros
	 */
	public java.util.List<StatoEstero> findByContinente(int continente);

	/**
	 * Returns a range of all the stato esteros where continente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param continente the continente
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @return the range of matching stato esteros
	 */
	public java.util.List<StatoEstero> findByContinente(
		int continente, int start, int end);

	/**
	 * Returns an ordered range of all the stato esteros where continente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param continente the continente
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato esteros
	 */
	public java.util.List<StatoEstero> findByContinente(
		int continente, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
			orderByComparator);

	/**
	 * Returns an ordered range of all the stato esteros where continente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param continente the continente
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stato esteros
	 */
	public java.util.List<StatoEstero> findByContinente(
		int continente, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stato estero in the ordered set where continente = &#63;.
	 *
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	public StatoEstero findByContinente_First(
			int continente,
			com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
				orderByComparator)
		throws NoSuchStatoEsteroException;

	/**
	 * Returns the first stato estero in the ordered set where continente = &#63;.
	 *
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public StatoEstero fetchByContinente_First(
		int continente,
		com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
			orderByComparator);

	/**
	 * Returns the last stato estero in the ordered set where continente = &#63;.
	 *
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	public StatoEstero findByContinente_Last(
			int continente,
			com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
				orderByComparator)
		throws NoSuchStatoEsteroException;

	/**
	 * Returns the last stato estero in the ordered set where continente = &#63;.
	 *
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public StatoEstero fetchByContinente_Last(
		int continente,
		com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
			orderByComparator);

	/**
	 * Returns the stato esteros before and after the current stato estero in the ordered set where continente = &#63;.
	 *
	 * @param statoEsteroId the primary key of the current stato estero
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato estero
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	public StatoEstero[] findByContinente_PrevAndNext(
			long statoEsteroId, int continente,
			com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
				orderByComparator)
		throws NoSuchStatoEsteroException;

	/**
	 * Removes all the stato esteros where continente = &#63; from the database.
	 *
	 * @param continente the continente
	 */
	public void removeByContinente(int continente);

	/**
	 * Returns the number of stato esteros where continente = &#63;.
	 *
	 * @param continente the continente
	 * @return the number of matching stato esteros
	 */
	public int countByContinente(int continente);

	/**
	 * Returns all the stato esteros where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @return the matching stato esteros
	 */
	public java.util.List<StatoEstero> findByCodiceArea(int codiceArea);

	/**
	 * Returns a range of all the stato esteros where codiceArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param codiceArea the codice area
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @return the range of matching stato esteros
	 */
	public java.util.List<StatoEstero> findByCodiceArea(
		int codiceArea, int start, int end);

	/**
	 * Returns an ordered range of all the stato esteros where codiceArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param codiceArea the codice area
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato esteros
	 */
	public java.util.List<StatoEstero> findByCodiceArea(
		int codiceArea, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
			orderByComparator);

	/**
	 * Returns an ordered range of all the stato esteros where codiceArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param codiceArea the codice area
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stato esteros
	 */
	public java.util.List<StatoEstero> findByCodiceArea(
		int codiceArea, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	public StatoEstero findByCodiceArea_First(
			int codiceArea,
			com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
				orderByComparator)
		throws NoSuchStatoEsteroException;

	/**
	 * Returns the first stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public StatoEstero fetchByCodiceArea_First(
		int codiceArea,
		com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
			orderByComparator);

	/**
	 * Returns the last stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	public StatoEstero findByCodiceArea_Last(
			int codiceArea,
			com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
				orderByComparator)
		throws NoSuchStatoEsteroException;

	/**
	 * Returns the last stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	public StatoEstero fetchByCodiceArea_Last(
		int codiceArea,
		com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
			orderByComparator);

	/**
	 * Returns the stato esteros before and after the current stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param statoEsteroId the primary key of the current stato estero
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato estero
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	public StatoEstero[] findByCodiceArea_PrevAndNext(
			long statoEsteroId, int codiceArea,
			com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
				orderByComparator)
		throws NoSuchStatoEsteroException;

	/**
	 * Removes all the stato esteros where codiceArea = &#63; from the database.
	 *
	 * @param codiceArea the codice area
	 */
	public void removeByCodiceArea(int codiceArea);

	/**
	 * Returns the number of stato esteros where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @return the number of matching stato esteros
	 */
	public int countByCodiceArea(int codiceArea);

	/**
	 * Caches the stato estero in the entity cache if it is enabled.
	 *
	 * @param statoEstero the stato estero
	 */
	public void cacheResult(StatoEstero statoEstero);

	/**
	 * Caches the stato esteros in the entity cache if it is enabled.
	 *
	 * @param statoEsteros the stato esteros
	 */
	public void cacheResult(java.util.List<StatoEstero> statoEsteros);

	/**
	 * Creates a new stato estero with the primary key. Does not add the stato estero to the database.
	 *
	 * @param statoEsteroId the primary key for the new stato estero
	 * @return the new stato estero
	 */
	public StatoEstero create(long statoEsteroId);

	/**
	 * Removes the stato estero with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statoEsteroId the primary key of the stato estero
	 * @return the stato estero that was removed
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	public StatoEstero remove(long statoEsteroId)
		throws NoSuchStatoEsteroException;

	public StatoEstero updateImpl(StatoEstero statoEstero);

	/**
	 * Returns the stato estero with the primary key or throws a <code>NoSuchStatoEsteroException</code> if it could not be found.
	 *
	 * @param statoEsteroId the primary key of the stato estero
	 * @return the stato estero
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	public StatoEstero findByPrimaryKey(long statoEsteroId)
		throws NoSuchStatoEsteroException;

	/**
	 * Returns the stato estero with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statoEsteroId the primary key of the stato estero
	 * @return the stato estero, or <code>null</code> if a stato estero with the primary key could not be found
	 */
	public StatoEstero fetchByPrimaryKey(long statoEsteroId);

	/**
	 * Returns all the stato esteros.
	 *
	 * @return the stato esteros
	 */
	public java.util.List<StatoEstero> findAll();

	/**
	 * Returns a range of all the stato esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @return the range of stato esteros
	 */
	public java.util.List<StatoEstero> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the stato esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stato esteros
	 */
	public java.util.List<StatoEstero> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
			orderByComparator);

	/**
	 * Returns an ordered range of all the stato esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of stato esteros
	 */
	public java.util.List<StatoEstero> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoEstero>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the stato esteros from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of stato esteros.
	 *
	 * @return the number of stato esteros
	 */
	public int countAll();

}